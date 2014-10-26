//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Product;

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
class ECommerceD2847A4EFB364B87A42AE4D0856F0491Data implements FieldProvider {
static Logger log4j = Logger.getLogger(ECommerceD2847A4EFB364B87A42AE4D0856F0491Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mProductId;
  public String mProductIdr;
  public String zseProductShopId;
  public String adOrgId;
  public String adOrgIdr;
  public String adClientId;
  public String zseShopId;
  public String zseShopIdr;
  public String eccategory;
  public String ecpriority;
  public String isorderable;
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
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("zse_product_shop_id") || fieldName.equals("zseProductShopId"))
      return zseProductShopId;
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
    else if (fieldName.equalsIgnoreCase("eccategory"))
      return eccategory;
    else if (fieldName.equalsIgnoreCase("ecpriority"))
      return ecpriority;
    else if (fieldName.equalsIgnoreCase("isorderable"))
      return isorderable;
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
  public static ECommerceD2847A4EFB364B87A42AE4D0856F0491Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mProductId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, mProductId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ECommerceD2847A4EFB364B87A42AE4D0856F0491Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mProductId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zse_product_shop.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zse_product_shop.CreatedBy) as CreatedByR, " +
      "        to_char(zse_product_shop.Updated, ?) as updated, " +
      "        to_char(zse_product_shop.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zse_product_shop.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zse_product_shop.UpdatedBy) as UpdatedByR," +
      "        zse_product_shop.M_Product_ID, " +
      "(CASE WHEN zse_product_shop.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "zse_product_shop.ZSE_Product_Shop_ID, " +
      "zse_product_shop.AD_Org_ID, " +
      "(CASE WHEN zse_product_shop.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zse_product_shop.AD_Client_ID, " +
      "zse_product_shop.ZSE_Shop_ID, " +
      "(CASE WHEN zse_product_shop.ZSE_Shop_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'') ) END) AS ZSE_Shop_IDR, " +
      "zse_product_shop.Eccategory, " +
      "zse_product_shop.Ecpriority, " +
      "COALESCE(zse_product_shop.Isorderable, 'N') AS Isorderable, " +
      "COALESCE(zse_product_shop.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM zse_product_shop left join (select M_Product_ID, Value, Name from M_Product) table1 on (zse_product_shop.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  left join (select AD_Org_ID, Name from AD_Org) table2 on (zse_product_shop.AD_Org_ID = table2.AD_Org_ID) left join (select ZSE_Shop_ID, Value from ZSE_Shop) table3 on (zse_product_shop.ZSE_Shop_ID = table3.ZSE_Shop_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND zse_product_shop.M_Product_ID = ?  ");
    strSql = strSql + 
      "        AND zse_product_shop.ZSE_Product_Shop_ID = ? " +
      "        AND zse_product_shop.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zse_product_shop.AD_Org_ID IN (";
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
      if (mProductId != null && !(mProductId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
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
        ECommerceD2847A4EFB364B87A42AE4D0856F0491Data objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data = new ECommerceD2847A4EFB364B87A42AE4D0856F0491Data();
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.created = UtilSql.getValue(result, "created");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.updated = UtilSql.getValue(result, "updated");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.zseProductShopId = UtilSql.getValue(result, "zse_product_shop_id");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.zseShopId = UtilSql.getValue(result, "zse_shop_id");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.zseShopIdr = UtilSql.getValue(result, "zse_shop_idr");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.eccategory = UtilSql.getValue(result, "eccategory");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.ecpriority = UtilSql.getValue(result, "ecpriority");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.isorderable = UtilSql.getValue(result, "isorderable");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.isactive = UtilSql.getValue(result, "isactive");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.language = UtilSql.getValue(result, "language");
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.adUserClient = "";
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.adOrgClient = "";
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.createdby = "";
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.trBgcolor = "";
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.totalCount = "";
        objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data);
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
    ECommerceD2847A4EFB364B87A42AE4D0856F0491Data objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[] = new ECommerceD2847A4EFB364B87A42AE4D0856F0491Data[vector.size()];
    vector.copyInto(objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data);
    return(objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data);
  }

/**
Create a registry
 */
  public static ECommerceD2847A4EFB364B87A42AE4D0856F0491Data[] set(String mProductId, String zseShopId, String createdby, String createdbyr, String eccategory, String isorderable, String adOrgId, String updatedby, String updatedbyr, String zseProductShopId, String isactive, String ecpriority, String adClientId)    throws ServletException {
    ECommerceD2847A4EFB364B87A42AE4D0856F0491Data objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[] = new ECommerceD2847A4EFB364B87A42AE4D0856F0491Data[1];
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0] = new ECommerceD2847A4EFB364B87A42AE4D0856F0491Data();
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].created = "";
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].createdbyr = createdbyr;
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].updated = "";
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].updatedTimeStamp = "";
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].updatedby = updatedby;
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].updatedbyr = updatedbyr;
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].mProductId = mProductId;
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].mProductIdr = "";
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].zseProductShopId = zseProductShopId;
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].adOrgId = adOrgId;
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].adOrgIdr = "";
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].adClientId = adClientId;
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].zseShopId = zseShopId;
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].zseShopIdr = "";
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].eccategory = eccategory;
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].ecpriority = ecpriority;
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].isorderable = isorderable;
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].isactive = isactive;
    objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data[0].language = "";
    return objectECommerceD2847A4EFB364B87A42AE4D0856F0491Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef746B8B38DC0F4B2392F1EE8995493A59_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefA36EF117A57545A48185C1536003E5AA_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT zse_product_shop.M_Product_ID AS NAME" +
      "        FROM zse_product_shop" +
      "        WHERE zse_product_shop.ZSE_Product_Shop_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM M_Product left join (select M_Product_ID, Value, Name from M_Product) table1 on (M_Product.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  WHERE M_Product.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM M_Product left join (select M_Product_ID, Value, Name from M_Product) table1 on (M_Product.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  WHERE M_Product.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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
      "        UPDATE zse_product_shop" +
      "        SET M_Product_ID = (?) , ZSE_Product_Shop_ID = (?) , AD_Org_ID = (?) , AD_Client_ID = (?) , ZSE_Shop_ID = (?) , Eccategory = (?) , Ecpriority = TO_NUMBER(?) , Isorderable = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE zse_product_shop.ZSE_Product_Shop_ID = ? " +
      "                 AND zse_product_shop.M_Product_ID = ? " +
      "        AND zse_product_shop.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zse_product_shop.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseProductShopId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseShopId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, eccategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ecpriority);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isorderable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseProductShopId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
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
      "        INSERT INTO zse_product_shop " +
      "        (M_Product_ID, ZSE_Product_Shop_ID, AD_Org_ID, AD_Client_ID, ZSE_Shop_ID, Eccategory, Ecpriority, Isorderable, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseProductShopId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseShopId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, eccategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ecpriority);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isorderable);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String mProductId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zse_product_shop" +
      "        WHERE zse_product_shop.ZSE_Product_Shop_ID = ? " +
      "                 AND zse_product_shop.M_Product_ID = ? " +
      "        AND zse_product_shop.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zse_product_shop.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zse_product_shop" +
      "        WHERE zse_product_shop.ZSE_Product_Shop_ID = ? " +
      "                 AND zse_product_shop.M_Product_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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
      "          FROM zse_product_shop" +
      "         WHERE zse_product_shop.ZSE_Product_Shop_ID = ? ";

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
      "          FROM zse_product_shop" +
      "         WHERE zse_product_shop.ZSE_Product_Shop_ID = ? ";

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
