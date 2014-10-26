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
class ECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data implements FieldProvider {
static Logger log4j = Logger.getLogger(ECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zseEcommercegrantId;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String adClientId;
  public String isactive;
  public String zseShopId;
  public String zseShopIdr;
  public String adOrgId;
  public String paymentmethod;
  public String paymentmethodr;
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
    else if (fieldName.equalsIgnoreCase("zse_ecommercegrant_id") || fieldName.equals("zseEcommercegrantId"))
      return zseEcommercegrantId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("zse_shop_id") || fieldName.equals("zseShopId"))
      return zseShopId;
    else if (fieldName.equalsIgnoreCase("zse_shop_idr") || fieldName.equals("zseShopIdr"))
      return zseShopIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("paymentmethod"))
      return paymentmethod;
    else if (fieldName.equalsIgnoreCase("paymentmethodr"))
      return paymentmethodr;
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
  public static ECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cBpartnerId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zse_ecommercegrant.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zse_ecommercegrant.CreatedBy) as CreatedByR, " +
      "        to_char(zse_ecommercegrant.Updated, ?) as updated, " +
      "        to_char(zse_ecommercegrant.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zse_ecommercegrant.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zse_ecommercegrant.UpdatedBy) as UpdatedByR," +
      "        zse_ecommercegrant.ZSE_Ecommercegrant_ID, " +
      "zse_ecommercegrant.C_Bpartner_ID, " +
      "(CASE WHEN zse_ecommercegrant.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "zse_ecommercegrant.AD_Client_ID, " +
      "COALESCE(zse_ecommercegrant.Isactive, 'N') AS Isactive, " +
      "zse_ecommercegrant.ZSE_Shop_ID, " +
      "(CASE WHEN zse_ecommercegrant.ZSE_Shop_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'') ) END) AS ZSE_Shop_IDR, " +
      "zse_ecommercegrant.AD_Org_ID, " +
      "zse_ecommercegrant.Paymentmethod, " +
      "(CASE WHEN zse_ecommercegrant.Paymentmethod IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS PaymentmethodR, " +
      "        ? AS LANGUAGE " +
      "        FROM zse_ecommercegrant left join (select C_BPartner_ID, Name from C_BPartner) table1 on (zse_ecommercegrant.C_Bpartner_ID = table1.C_BPartner_ID) left join (select ZSE_Shop_ID, Value from ZSE_Shop) table2 on (zse_ecommercegrant.ZSE_Shop_ID = table2.ZSE_Shop_ID) left join ad_ref_list_v list1 on (zse_ecommercegrant.Paymentmethod = list1.value and list1.ad_reference_id = '8EE47A7F188B4F86936C8AF91A55490A' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND zse_ecommercegrant.C_Bpartner_ID = ?  ");
    strSql = strSql + 
      "        AND zse_ecommercegrant.ZSE_Ecommercegrant_ID = ? " +
      "        AND zse_ecommercegrant.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zse_ecommercegrant.AD_Org_ID IN (";
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
        ECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data = new ECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data();
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.created = UtilSql.getValue(result, "created");
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.updated = UtilSql.getValue(result, "updated");
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.zseEcommercegrantId = UtilSql.getValue(result, "zse_ecommercegrant_id");
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.isactive = UtilSql.getValue(result, "isactive");
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.zseShopId = UtilSql.getValue(result, "zse_shop_id");
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.zseShopIdr = UtilSql.getValue(result, "zse_shop_idr");
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.paymentmethod = UtilSql.getValue(result, "paymentmethod");
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.paymentmethodr = UtilSql.getValue(result, "paymentmethodr");
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.language = UtilSql.getValue(result, "language");
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.adUserClient = "";
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.adOrgClient = "";
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.createdby = "";
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.trBgcolor = "";
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.totalCount = "";
        objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data);
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
    ECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[] = new ECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[vector.size()];
    vector.copyInto(objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data);
    return(objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data);
  }

/**
Create a registry
 */
  public static ECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[] set(String cBpartnerId, String adClientId, String paymentmethod, String zseEcommercegrantId, String updatedby, String updatedbyr, String zseShopId, String isactive, String createdby, String createdbyr, String cBpartnerIdr, String adOrgId)    throws ServletException {
    ECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[] = new ECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[1];
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0] = new ECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data();
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0].created = "";
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0].createdbyr = createdbyr;
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0].updated = "";
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0].updatedTimeStamp = "";
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0].updatedby = updatedby;
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0].updatedbyr = updatedbyr;
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0].zseEcommercegrantId = zseEcommercegrantId;
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0].cBpartnerId = cBpartnerId;
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0].cBpartnerIdr = cBpartnerIdr;
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0].adClientId = adClientId;
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0].isactive = isactive;
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0].zseShopId = zseShopId;
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0].zseShopIdr = "";
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0].adOrgId = adOrgId;
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0].paymentmethod = paymentmethod;
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0].paymentmethodr = "";
    objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data[0].language = "";
    return objectECommerceSettings2E763BC86232429AAF24E9650F5E8FC8Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefF80E51DF3CCB4316A7793D1DDB7C422A_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefDD67E48472694C7A8CB6373910541B2D_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef8D5029E621AC4B4F9D3FEA6215A57F07_2(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zse_ecommercegrant.C_Bpartner_ID AS NAME" +
      "        FROM zse_ecommercegrant" +
      "        WHERE zse_ecommercegrant.ZSE_Ecommercegrant_ID = ?";

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
      "        UPDATE zse_ecommercegrant" +
      "        SET ZSE_Ecommercegrant_ID = (?) , C_Bpartner_ID = (?) , AD_Client_ID = (?) , Isactive = (?) , ZSE_Shop_ID = (?) , AD_Org_ID = (?) , Paymentmethod = (?) , updated = now(), updatedby = ? " +
      "        WHERE zse_ecommercegrant.ZSE_Ecommercegrant_ID = ? " +
      "                 AND zse_ecommercegrant.C_Bpartner_ID = ? " +
      "        AND zse_ecommercegrant.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zse_ecommercegrant.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseEcommercegrantId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseShopId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentmethod);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseEcommercegrantId);
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
      "        INSERT INTO zse_ecommercegrant " +
      "        (ZSE_Ecommercegrant_ID, C_Bpartner_ID, AD_Client_ID, Isactive, ZSE_Shop_ID, AD_Org_ID, Paymentmethod, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseEcommercegrantId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseShopId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentmethod);
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
      "        DELETE FROM zse_ecommercegrant" +
      "        WHERE zse_ecommercegrant.ZSE_Ecommercegrant_ID = ? " +
      "                 AND zse_ecommercegrant.C_Bpartner_ID = ? " +
      "        AND zse_ecommercegrant.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zse_ecommercegrant.AD_Org_ID IN (";
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
      "        DELETE FROM zse_ecommercegrant" +
      "        WHERE zse_ecommercegrant.ZSE_Ecommercegrant_ID = ? " +
      "                 AND zse_ecommercegrant.C_Bpartner_ID = ? ";

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
      "          FROM zse_ecommercegrant" +
      "         WHERE zse_ecommercegrant.ZSE_Ecommercegrant_ID = ? ";

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
      "          FROM zse_ecommercegrant" +
      "         WHERE zse_ecommercegrant.ZSE_Ecommercegrant_ID = ? ";

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
