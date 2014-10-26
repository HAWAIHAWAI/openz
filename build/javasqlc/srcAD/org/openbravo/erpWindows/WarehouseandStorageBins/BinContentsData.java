//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.WarehouseandStorageBins;

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
class BinContentsData implements FieldProvider {
static Logger log4j = Logger.getLogger(BinContentsData.class);
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
  public String mLocatorId;
  public String mLocatorIdr;
  public String mProductId;
  public String mProductIdr;
  public String mAttributesetinstanceId;
  public String mAttributesetinstanceIdr;
  public String isactive;
  public String datelastinventory;
  public String cUomId;
  public String cUomIdr;
  public String mProductUomId;
  public String mProductUomIdr;
  public String qtyonhand;
  public String qtyorderonhand;
  public String preqtyonhand;
  public String preqtyorderonhand;
  public String mStorageDetailId;
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
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_locator_idr") || fieldName.equals("mLocatorIdr"))
      return mLocatorIdr;
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
    else if (fieldName.equalsIgnoreCase("datelastinventory"))
      return datelastinventory;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("m_product_uom_id") || fieldName.equals("mProductUomId"))
      return mProductUomId;
    else if (fieldName.equalsIgnoreCase("m_product_uom_idr") || fieldName.equals("mProductUomIdr"))
      return mProductUomIdr;
    else if (fieldName.equalsIgnoreCase("qtyonhand"))
      return qtyonhand;
    else if (fieldName.equalsIgnoreCase("qtyorderonhand"))
      return qtyorderonhand;
    else if (fieldName.equalsIgnoreCase("preqtyonhand"))
      return preqtyonhand;
    else if (fieldName.equalsIgnoreCase("preqtyorderonhand"))
      return preqtyorderonhand;
    else if (fieldName.equalsIgnoreCase("m_storage_detail_id") || fieldName.equals("mStorageDetailId"))
      return mStorageDetailId;
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
  public static BinContentsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String M_Locator_ID, String mLocatorId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, M_Locator_ID, mLocatorId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static BinContentsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String M_Locator_ID, String mLocatorId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_Storage_Detail.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Storage_Detail.CreatedBy) as CreatedByR, " +
      "        to_char(M_Storage_Detail.Updated, ?) as updated, " +
      "        to_char(M_Storage_Detail.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_Storage_Detail.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Storage_Detail.UpdatedBy) as UpdatedByR," +
      "        M_Storage_Detail.AD_Client_ID, " +
      "(CASE WHEN M_Storage_Detail.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "M_Storage_Detail.AD_Org_ID, " +
      "(CASE WHEN M_Storage_Detail.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "M_Storage_Detail.M_Locator_ID, " +
      "(CASE WHEN M_Storage_Detail.M_Locator_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'') ) END) AS M_Locator_IDR, " +
      "M_Storage_Detail.M_Product_ID, " +
      "(CASE WHEN M_Storage_Detail.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "M_Storage_Detail.M_AttributeSetInstance_ID, " +
      "(CASE WHEN M_Storage_Detail.M_AttributeSetInstance_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Description), ''))),'') ) END) AS M_AttributeSetInstance_IDR, " +
      "COALESCE(M_Storage_Detail.IsActive, 'N') AS IsActive, " +
      "M_Storage_Detail.DateLastInventory, " +
      "M_Storage_Detail.C_UOM_ID, " +
      "(CASE WHEN M_Storage_Detail.C_UOM_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS C_UOM_IDR, " +
      "M_Storage_Detail.M_Product_Uom_Id, " +
      "(CASE WHEN M_Storage_Detail.M_Product_Uom_Id IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL8.Name IS NULL THEN TO_CHAR(table8.Name) ELSE TO_CHAR(tableTRL8.Name) END)), ''))),'') ) END) AS M_Product_Uom_IdR, " +
      "M_Storage_Detail.QtyOnHand, " +
      "M_Storage_Detail.QtyOrderOnHand, " +
      "M_Storage_Detail.PreQtyOnHand, " +
      "M_Storage_Detail.PreQtyOrderOnHand, " +
      "M_Storage_Detail.M_Storage_Detail_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM M_Storage_Detail left join (select AD_Client_ID, Name from AD_Client) table1 on (M_Storage_Detail.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (M_Storage_Detail.AD_Org_ID = table2.AD_Org_ID) left join (select M_Locator_ID, Value from M_Locator) table3 on (M_Storage_Detail.M_Locator_ID = table3.M_Locator_ID) left join (select M_Product_ID, Value, Name from M_Product) table4 on (M_Storage_Detail.M_Product_ID = table4.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL4 on (table4.M_Product_ID = tableTRL4.M_Product_ID and tableTRL4.AD_Language = ?)  left join (select M_AttributeSetInstance_ID, Description from M_AttributeSetInstance) table5 on (M_Storage_Detail.M_AttributeSetInstance_ID = table5.M_AttributeSetInstance_ID) left join (select C_UOM_ID, Name from C_UOM) table6 on (M_Storage_Detail.C_UOM_ID = table6.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL6 on (table6.C_UOM_ID = tableTRL6.C_UOM_ID and tableTRL6.AD_Language = ?)  left join (select M_Product_Uom_Id, C_UOM_ID from M_Product_Uom) table7 on (M_Storage_Detail.M_Product_Uom_Id = table7.M_Product_Uom_Id) left join (select C_UOM_ID, Name from C_UOM) table8 on (table7.C_UOM_ID = table8.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL8 on (table8.C_UOM_ID = tableTRL8.C_UOM_ID and tableTRL8.AD_Language = ?) " +
      "        WHERE 2=2 " +
      " AND M_Storage_Detail.qtyonhand <>0 AND M_Storage_Detail.M_Locator_ID = ?" +
      "        AND 1=1 ";
    strSql = strSql + ((mLocatorId==null || mLocatorId.equals(""))?"":"  AND M_Storage_Detail.M_Locator_ID = ?  ");
    strSql = strSql + 
      "        AND M_Storage_Detail.M_Storage_Detail_ID = ? " +
      "        AND M_Storage_Detail.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND M_Storage_Detail.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Locator_ID);
      if (mLocatorId != null && !(mLocatorId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
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
        BinContentsData objectBinContentsData = new BinContentsData();
        objectBinContentsData.created = UtilSql.getValue(result, "created");
        objectBinContentsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectBinContentsData.updated = UtilSql.getValue(result, "updated");
        objectBinContentsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectBinContentsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectBinContentsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectBinContentsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectBinContentsData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectBinContentsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectBinContentsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectBinContentsData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectBinContentsData.mLocatorIdr = UtilSql.getValue(result, "m_locator_idr");
        objectBinContentsData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectBinContentsData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectBinContentsData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectBinContentsData.mAttributesetinstanceIdr = UtilSql.getValue(result, "m_attributesetinstance_idr");
        objectBinContentsData.isactive = UtilSql.getValue(result, "isactive");
        objectBinContentsData.datelastinventory = UtilSql.getDateValue(result, "datelastinventory", "dd-MM-yyyy");
        objectBinContentsData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectBinContentsData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectBinContentsData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectBinContentsData.mProductUomIdr = UtilSql.getValue(result, "m_product_uom_idr");
        objectBinContentsData.qtyonhand = UtilSql.getValue(result, "qtyonhand");
        objectBinContentsData.qtyorderonhand = UtilSql.getValue(result, "qtyorderonhand");
        objectBinContentsData.preqtyonhand = UtilSql.getValue(result, "preqtyonhand");
        objectBinContentsData.preqtyorderonhand = UtilSql.getValue(result, "preqtyorderonhand");
        objectBinContentsData.mStorageDetailId = UtilSql.getValue(result, "m_storage_detail_id");
        objectBinContentsData.language = UtilSql.getValue(result, "language");
        objectBinContentsData.adUserClient = "";
        objectBinContentsData.adOrgClient = "";
        objectBinContentsData.createdby = "";
        objectBinContentsData.trBgcolor = "";
        objectBinContentsData.totalCount = "";
        objectBinContentsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBinContentsData);
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
    BinContentsData objectBinContentsData[] = new BinContentsData[vector.size()];
    vector.copyInto(objectBinContentsData);
    return(objectBinContentsData);
  }

/**
Create a registry
 */
  public static BinContentsData[] set(String mLocatorId, String cUomId, String adOrgId, String isactive, String datelastinventory, String updatedby, String updatedbyr, String mLocatorIdr, String qtyorderonhand, String mProductUomId, String adClientId, String preqtyonhand, String createdby, String createdbyr, String preqtyorderonhand, String mProductId, String mProductIdr, String qtyonhand, String mAttributesetinstanceId, String mAttributesetinstanceIdr, String mStorageDetailId)    throws ServletException {
    BinContentsData objectBinContentsData[] = new BinContentsData[1];
    objectBinContentsData[0] = new BinContentsData();
    objectBinContentsData[0].created = "";
    objectBinContentsData[0].createdbyr = createdbyr;
    objectBinContentsData[0].updated = "";
    objectBinContentsData[0].updatedTimeStamp = "";
    objectBinContentsData[0].updatedby = updatedby;
    objectBinContentsData[0].updatedbyr = updatedbyr;
    objectBinContentsData[0].adClientId = adClientId;
    objectBinContentsData[0].adClientIdr = "";
    objectBinContentsData[0].adOrgId = adOrgId;
    objectBinContentsData[0].adOrgIdr = "";
    objectBinContentsData[0].mLocatorId = mLocatorId;
    objectBinContentsData[0].mLocatorIdr = mLocatorIdr;
    objectBinContentsData[0].mProductId = mProductId;
    objectBinContentsData[0].mProductIdr = mProductIdr;
    objectBinContentsData[0].mAttributesetinstanceId = mAttributesetinstanceId;
    objectBinContentsData[0].mAttributesetinstanceIdr = mAttributesetinstanceIdr;
    objectBinContentsData[0].isactive = isactive;
    objectBinContentsData[0].datelastinventory = datelastinventory;
    objectBinContentsData[0].cUomId = cUomId;
    objectBinContentsData[0].cUomIdr = "";
    objectBinContentsData[0].mProductUomId = mProductUomId;
    objectBinContentsData[0].mProductUomIdr = "";
    objectBinContentsData[0].qtyonhand = qtyonhand;
    objectBinContentsData[0].qtyorderonhand = qtyorderonhand;
    objectBinContentsData[0].preqtyonhand = preqtyonhand;
    objectBinContentsData[0].preqtyorderonhand = preqtyorderonhand;
    objectBinContentsData[0].mStorageDetailId = mStorageDetailId;
    objectBinContentsData[0].language = "";
    return objectBinContentsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef800649_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef800634_1(ConnectionProvider connectionProvider, String M_Locator_IDR)    throws ServletException {
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
  public static String selectDef800647_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef800633_3(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef800635_4(ConnectionProvider connectionProvider, String M_AttributeSetInstance_IDR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_Storage_Detail.M_Locator_ID AS NAME" +
      "        FROM M_Storage_Detail" +
      "        WHERE M_Storage_Detail.M_Storage_Detail_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String mLocatorId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))) AS NAME FROM M_Locator left join (select M_Locator_ID, Value from M_Locator) table1 on (M_Locator.M_Locator_ID = table1.M_Locator_ID) WHERE M_Locator.M_Locator_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String mLocatorId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))) AS NAME FROM M_Locator left join (select M_Locator_ID, Value from M_Locator) table1 on (M_Locator.M_Locator_ID = table1.M_Locator_ID) WHERE M_Locator.M_Locator_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);

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
      "        UPDATE M_Storage_Detail" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , M_Locator_ID = (?) , M_Product_ID = (?) , M_AttributeSetInstance_ID = (?) , IsActive = (?) , DateLastInventory = TO_DATE(?) , C_UOM_ID = (?) , M_Product_Uom_Id = (?) , QtyOnHand = TO_NUMBER(?) , QtyOrderOnHand = TO_NUMBER(?) , PreQtyOnHand = TO_NUMBER(?) , PreQtyOrderOnHand = TO_NUMBER(?) , M_Storage_Detail_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_Storage_Detail.M_Storage_Detail_ID = ? " +
      "                 AND M_Storage_Detail.M_Locator_ID = ? " +
      "        AND M_Storage_Detail.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Storage_Detail.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datelastinventory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyorderonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, preqtyonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, preqtyorderonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mStorageDetailId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mStorageDetailId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
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
      "        INSERT INTO M_Storage_Detail " +
      "        (AD_Client_ID, AD_Org_ID, M_Locator_ID, M_Product_ID, M_AttributeSetInstance_ID, IsActive, DateLastInventory, C_UOM_ID, M_Product_Uom_Id, QtyOnHand, QtyOrderOnHand, PreQtyOnHand, PreQtyOrderOnHand, M_Storage_Detail_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datelastinventory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyorderonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, preqtyonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, preqtyorderonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mStorageDetailId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String mLocatorId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_Storage_Detail" +
      "        WHERE M_Storage_Detail.M_Storage_Detail_ID = ? " +
      "                 AND M_Storage_Detail.M_Locator_ID = ? " +
      "        AND M_Storage_Detail.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Storage_Detail.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String mLocatorId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_Storage_Detail" +
      "        WHERE M_Storage_Detail.M_Storage_Detail_ID = ? " +
      "                 AND M_Storage_Detail.M_Locator_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);

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
      "          FROM M_Storage_Detail" +
      "         WHERE M_Storage_Detail.M_Storage_Detail_ID = ? ";

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
      "          FROM M_Storage_Detail" +
      "         WHERE M_Storage_Detail.M_Storage_Detail_ID = ? ";

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
