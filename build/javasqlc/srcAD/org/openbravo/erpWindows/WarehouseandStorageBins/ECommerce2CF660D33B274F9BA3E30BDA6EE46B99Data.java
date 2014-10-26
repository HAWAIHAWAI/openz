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
class ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data implements FieldProvider {
static Logger log4j = Logger.getLogger(ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String zseWarehouseShopId;
  public String adOrgId;
  public String adOrgIdr;
  public String adClientId;
  public String zseShopId;
  public String zseShopIdr;
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
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("zse_warehouse_shop_id") || fieldName.equals("zseWarehouseShopId"))
      return zseWarehouseShopId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("zse_shop_id") || fieldName.equals("zseShopId"))
      return zseShopId;
    else if (fieldName.equalsIgnoreCase("zse_shop_idr") || fieldName.equals("zseShopIdr"))
      return zseShopIdr;
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
  public static ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mWarehouseId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, mWarehouseId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mWarehouseId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zse_warehouse_shop.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zse_warehouse_shop.CreatedBy) as CreatedByR, " +
      "        to_char(zse_warehouse_shop.Updated, ?) as updated, " +
      "        to_char(zse_warehouse_shop.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zse_warehouse_shop.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zse_warehouse_shop.UpdatedBy) as UpdatedByR," +
      "        zse_warehouse_shop.M_Warehouse_ID, " +
      "(CASE WHEN zse_warehouse_shop.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "zse_warehouse_shop.ZSE_Warehouse_Shop_ID, " +
      "zse_warehouse_shop.AD_Org_ID, " +
      "(CASE WHEN zse_warehouse_shop.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zse_warehouse_shop.AD_Client_ID, " +
      "zse_warehouse_shop.ZSE_Shop_ID, " +
      "(CASE WHEN zse_warehouse_shop.ZSE_Shop_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'') ) END) AS ZSE_Shop_IDR, " +
      "COALESCE(zse_warehouse_shop.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM zse_warehouse_shop left join (select M_Warehouse_ID, Name from M_Warehouse) table1 on (zse_warehouse_shop.M_Warehouse_ID = table1.M_Warehouse_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (zse_warehouse_shop.AD_Org_ID = table2.AD_Org_ID) left join (select ZSE_Shop_ID, Value from ZSE_Shop) table3 on (zse_warehouse_shop.ZSE_Shop_ID = table3.ZSE_Shop_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":"  AND zse_warehouse_shop.M_Warehouse_ID = ?  ");
    strSql = strSql + 
      "        AND zse_warehouse_shop.ZSE_Warehouse_Shop_ID = ? " +
      "        AND zse_warehouse_shop.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zse_warehouse_shop.AD_Org_ID IN (";
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
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
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
        ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data = new ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data();
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.created = UtilSql.getValue(result, "created");
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.updated = UtilSql.getValue(result, "updated");
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.zseWarehouseShopId = UtilSql.getValue(result, "zse_warehouse_shop_id");
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.zseShopId = UtilSql.getValue(result, "zse_shop_id");
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.zseShopIdr = UtilSql.getValue(result, "zse_shop_idr");
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.isactive = UtilSql.getValue(result, "isactive");
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.language = UtilSql.getValue(result, "language");
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.adUserClient = "";
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.adOrgClient = "";
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.createdby = "";
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.trBgcolor = "";
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.totalCount = "";
        objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data);
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
    ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[] = new ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[vector.size()];
    vector.copyInto(objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data);
    return(objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data);
  }

/**
Create a registry
 */
  public static ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[] set(String mWarehouseId, String adClientId, String createdby, String createdbyr, String adOrgId, String isactive, String zseShopId, String updatedby, String updatedbyr, String zseWarehouseShopId)    throws ServletException {
    ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[] = new ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[1];
    objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0] = new ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data();
    objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0].created = "";
    objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0].createdbyr = createdbyr;
    objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0].updated = "";
    objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0].updatedTimeStamp = "";
    objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0].updatedby = updatedby;
    objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0].updatedbyr = updatedbyr;
    objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0].mWarehouseId = mWarehouseId;
    objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0].mWarehouseIdr = "";
    objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0].zseWarehouseShopId = zseWarehouseShopId;
    objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0].adOrgId = adOrgId;
    objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0].adOrgIdr = "";
    objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0].adClientId = adClientId;
    objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0].zseShopId = zseShopId;
    objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0].zseShopIdr = "";
    objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0].isactive = isactive;
    objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0].language = "";
    return objectECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefE975E8CAD9E244F695BF4C40CB69B1A7_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef76C6967D3E534B7598466B5804A7A2C5_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zse_warehouse_shop.M_Warehouse_ID AS NAME" +
      "        FROM zse_warehouse_shop" +
      "        WHERE zse_warehouse_shop.ZSE_Warehouse_Shop_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String mWarehouseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM M_Warehouse left join (select M_Warehouse_ID, Name from M_Warehouse) table1 on (M_Warehouse.M_Warehouse_ID = table1.M_Warehouse_ID) WHERE M_Warehouse.M_Warehouse_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String mWarehouseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM M_Warehouse left join (select M_Warehouse_ID, Name from M_Warehouse) table1 on (M_Warehouse.M_Warehouse_ID = table1.M_Warehouse_ID) WHERE M_Warehouse.M_Warehouse_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);

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
      "        UPDATE zse_warehouse_shop" +
      "        SET M_Warehouse_ID = (?) , ZSE_Warehouse_Shop_ID = (?) , AD_Org_ID = (?) , AD_Client_ID = (?) , ZSE_Shop_ID = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE zse_warehouse_shop.ZSE_Warehouse_Shop_ID = ? " +
      "                 AND zse_warehouse_shop.M_Warehouse_ID = ? " +
      "        AND zse_warehouse_shop.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zse_warehouse_shop.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseWarehouseShopId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseShopId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseWarehouseShopId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
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
      "        INSERT INTO zse_warehouse_shop " +
      "        (M_Warehouse_ID, ZSE_Warehouse_Shop_ID, AD_Org_ID, AD_Client_ID, ZSE_Shop_ID, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseWarehouseShopId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseShopId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String mWarehouseId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zse_warehouse_shop" +
      "        WHERE zse_warehouse_shop.ZSE_Warehouse_Shop_ID = ? " +
      "                 AND zse_warehouse_shop.M_Warehouse_ID = ? " +
      "        AND zse_warehouse_shop.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zse_warehouse_shop.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String mWarehouseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zse_warehouse_shop" +
      "        WHERE zse_warehouse_shop.ZSE_Warehouse_Shop_ID = ? " +
      "                 AND zse_warehouse_shop.M_Warehouse_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);

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
      "          FROM zse_warehouse_shop" +
      "         WHERE zse_warehouse_shop.ZSE_Warehouse_Shop_ID = ? ";

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
      "          FROM zse_warehouse_shop" +
      "         WHERE zse_warehouse_shop.ZSE_Warehouse_Shop_ID = ? ";

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
