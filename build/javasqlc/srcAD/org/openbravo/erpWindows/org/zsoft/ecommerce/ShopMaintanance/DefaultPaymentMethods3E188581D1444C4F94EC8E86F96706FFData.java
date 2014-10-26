//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.zsoft.ecommerce.ShopMaintanance;

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
class DefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData implements FieldProvider {
static Logger log4j = Logger.getLogger(DefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zseShopId;
  public String zseShopIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String paymentmethod;
  public String paymentmethodr;
  public String zseShopDefaultpaymethodId;
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
    else if (fieldName.equalsIgnoreCase("zse_shop_id") || fieldName.equals("zseShopId"))
      return zseShopId;
    else if (fieldName.equalsIgnoreCase("zse_shop_idr") || fieldName.equals("zseShopIdr"))
      return zseShopIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("paymentmethod"))
      return paymentmethod;
    else if (fieldName.equalsIgnoreCase("paymentmethodr"))
      return paymentmethodr;
    else if (fieldName.equalsIgnoreCase("zse_shop_defaultpaymethod_id") || fieldName.equals("zseShopDefaultpaymethodId"))
      return zseShopDefaultpaymethodId;
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
  public static DefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zseShopId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zseShopId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static DefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zseShopId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zse_shop_defaultpaymethod.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zse_shop_defaultpaymethod.CreatedBy) as CreatedByR, " +
      "        to_char(zse_shop_defaultpaymethod.Updated, ?) as updated, " +
      "        to_char(zse_shop_defaultpaymethod.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zse_shop_defaultpaymethod.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zse_shop_defaultpaymethod.UpdatedBy) as UpdatedByR," +
      "        zse_shop_defaultpaymethod.ZSE_Shop_ID, " +
      "(CASE WHEN zse_shop_defaultpaymethod.ZSE_Shop_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'') ) END) AS ZSE_Shop_IDR, " +
      "zse_shop_defaultpaymethod.AD_Org_ID, " +
      "(CASE WHEN zse_shop_defaultpaymethod.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(zse_shop_defaultpaymethod.Isactive, 'N') AS Isactive, " +
      "zse_shop_defaultpaymethod.Paymentmethod, " +
      "(CASE WHEN zse_shop_defaultpaymethod.Paymentmethod IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS PaymentmethodR, " +
      "zse_shop_defaultpaymethod.ZSE_Shop_Defaultpaymethod_ID, " +
      "zse_shop_defaultpaymethod.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zse_shop_defaultpaymethod left join (select ZSE_Shop_ID, Value from ZSE_Shop) table1 on (zse_shop_defaultpaymethod.ZSE_Shop_ID = table1.ZSE_Shop_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (zse_shop_defaultpaymethod.AD_Org_ID = table2.AD_Org_ID) left join ad_ref_list_v list1 on (zse_shop_defaultpaymethod.Paymentmethod = list1.value and list1.ad_reference_id = '8EE47A7F188B4F86936C8AF91A55490A' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zseShopId==null || zseShopId.equals(""))?"":"  AND zse_shop_defaultpaymethod.ZSE_Shop_ID = ?  ");
    strSql = strSql + 
      "        AND zse_shop_defaultpaymethod.ZSE_Shop_Defaultpaymethod_ID = ? " +
      "        AND zse_shop_defaultpaymethod.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zse_shop_defaultpaymethod.AD_Org_ID IN (";
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
      if (zseShopId != null && !(zseShopId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseShopId);
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
        DefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData = new DefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData();
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.created = UtilSql.getValue(result, "created");
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.updated = UtilSql.getValue(result, "updated");
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.zseShopId = UtilSql.getValue(result, "zse_shop_id");
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.zseShopIdr = UtilSql.getValue(result, "zse_shop_idr");
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.isactive = UtilSql.getValue(result, "isactive");
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.paymentmethod = UtilSql.getValue(result, "paymentmethod");
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.paymentmethodr = UtilSql.getValue(result, "paymentmethodr");
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.zseShopDefaultpaymethodId = UtilSql.getValue(result, "zse_shop_defaultpaymethod_id");
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.language = UtilSql.getValue(result, "language");
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.adUserClient = "";
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.adOrgClient = "";
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.createdby = "";
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.trBgcolor = "";
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.totalCount = "";
        objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData);
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
    DefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[] = new DefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[vector.size()];
    vector.copyInto(objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData);
    return(objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData);
  }

/**
Create a registry
 */
  public static DefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[] set(String zseShopId, String isactive, String zseShopDefaultpaymethodId, String adClientId, String updatedby, String updatedbyr, String createdby, String createdbyr, String adOrgId, String paymentmethod)    throws ServletException {
    DefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[] = new DefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[1];
    objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[0] = new DefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData();
    objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[0].created = "";
    objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[0].createdbyr = createdbyr;
    objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[0].updated = "";
    objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[0].updatedTimeStamp = "";
    objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[0].updatedby = updatedby;
    objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[0].updatedbyr = updatedbyr;
    objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[0].zseShopId = zseShopId;
    objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[0].zseShopIdr = "";
    objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[0].adOrgId = adOrgId;
    objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[0].adOrgIdr = "";
    objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[0].isactive = isactive;
    objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[0].paymentmethod = paymentmethod;
    objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[0].paymentmethodr = "";
    objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[0].zseShopDefaultpaymethodId = zseShopDefaultpaymethodId;
    objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[0].adClientId = adClientId;
    objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData[0].language = "";
    return objectDefaultPaymentMethods3E188581D1444C4F94EC8E86F96706FFData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefD6FE242705BC4E078A73D2122935D9EE_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef1C57B750CD4341599F486BD11CF6C889_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT zse_shop_defaultpaymethod.ZSE_Shop_ID AS NAME" +
      "        FROM zse_shop_defaultpaymethod" +
      "        WHERE zse_shop_defaultpaymethod.ZSE_Shop_Defaultpaymethod_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String zseShopId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))) AS NAME FROM zse_shop left join (select ZSE_Shop_ID, Value from ZSE_Shop) table1 on (zse_shop.ZSE_Shop_ID = table1.ZSE_Shop_ID) WHERE zse_shop.ZSE_Shop_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseShopId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zseShopId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))) AS NAME FROM zse_shop left join (select ZSE_Shop_ID, Value from ZSE_Shop) table1 on (zse_shop.ZSE_Shop_ID = table1.ZSE_Shop_ID) WHERE zse_shop.ZSE_Shop_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseShopId);

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
      "        UPDATE zse_shop_defaultpaymethod" +
      "        SET ZSE_Shop_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , Paymentmethod = (?) , ZSE_Shop_Defaultpaymethod_ID = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zse_shop_defaultpaymethod.ZSE_Shop_Defaultpaymethod_ID = ? " +
      "                 AND zse_shop_defaultpaymethod.ZSE_Shop_ID = ? " +
      "        AND zse_shop_defaultpaymethod.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zse_shop_defaultpaymethod.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseShopId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentmethod);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseShopDefaultpaymethodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseShopDefaultpaymethodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseShopId);
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
      "        INSERT INTO zse_shop_defaultpaymethod " +
      "        (ZSE_Shop_ID, AD_Org_ID, Isactive, Paymentmethod, ZSE_Shop_Defaultpaymethod_ID, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseShopId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentmethod);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseShopDefaultpaymethodId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zseShopId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zse_shop_defaultpaymethod" +
      "        WHERE zse_shop_defaultpaymethod.ZSE_Shop_Defaultpaymethod_ID = ? " +
      "                 AND zse_shop_defaultpaymethod.ZSE_Shop_ID = ? " +
      "        AND zse_shop_defaultpaymethod.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zse_shop_defaultpaymethod.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseShopId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zseShopId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zse_shop_defaultpaymethod" +
      "        WHERE zse_shop_defaultpaymethod.ZSE_Shop_Defaultpaymethod_ID = ? " +
      "                 AND zse_shop_defaultpaymethod.ZSE_Shop_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseShopId);

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
      "          FROM zse_shop_defaultpaymethod" +
      "         WHERE zse_shop_defaultpaymethod.ZSE_Shop_Defaultpaymethod_ID = ? ";

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
      "          FROM zse_shop_defaultpaymethod" +
      "         WHERE zse_shop_defaultpaymethod.ZSE_Shop_Defaultpaymethod_ID = ? ";

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
