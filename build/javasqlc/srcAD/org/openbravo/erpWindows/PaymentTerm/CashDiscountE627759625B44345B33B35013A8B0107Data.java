//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.PaymentTerm;

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
class CashDiscountE627759625B44345B33B35013A8B0107Data implements FieldProvider {
static Logger log4j = Logger.getLogger(CashDiscountE627759625B44345B33B35013A8B0107Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zsfiDiscountId;
  public String cPaymenttermId;
  public String cPaymenttermIdr;
  public String isactive;
  public String description;
  public String netdays;
  public String percentage;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
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
    else if (fieldName.equalsIgnoreCase("zsfi_discount_id") || fieldName.equals("zsfiDiscountId"))
      return zsfiDiscountId;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_idr") || fieldName.equals("cPaymenttermIdr"))
      return cPaymenttermIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("netdays"))
      return netdays;
    else if (fieldName.equalsIgnoreCase("percentage"))
      return percentage;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
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
  public static CashDiscountE627759625B44345B33B35013A8B0107Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cPaymenttermId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cPaymenttermId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CashDiscountE627759625B44345B33B35013A8B0107Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cPaymenttermId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zsfi_discount.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zsfi_discount.CreatedBy) as CreatedByR, " +
      "        to_char(zsfi_discount.Updated, ?) as updated, " +
      "        to_char(zsfi_discount.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zsfi_discount.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zsfi_discount.UpdatedBy) as UpdatedByR," +
      "        zsfi_discount.Zsfi_Discount_ID, " +
      "zsfi_discount.C_Paymentterm_ID, " +
      "(CASE WHEN zsfi_discount.C_Paymentterm_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS C_Paymentterm_IDR, " +
      "COALESCE(zsfi_discount.Isactive, 'N') AS Isactive, " +
      "zsfi_discount.Description, " +
      "zsfi_discount.Netdays, " +
      "zsfi_discount.Percentage, " +
      "zsfi_discount.AD_Client_ID, " +
      "(CASE WHEN zsfi_discount.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "zsfi_discount.AD_Org_ID, " +
      "(CASE WHEN zsfi_discount.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "        ? AS LANGUAGE " +
      "        FROM zsfi_discount left join (select C_Paymentterm_ID, Name from C_Paymentterm) table1 on (zsfi_discount.C_Paymentterm_ID = table1.C_Paymentterm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL1 on (table1.C_PaymentTerm_ID = tableTRL1.C_PaymentTerm_ID and tableTRL1.AD_Language = ?)  left join (select AD_Client_ID, Name from AD_Client) table2 on (zsfi_discount.AD_Client_ID = table2.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table3 on (zsfi_discount.AD_Org_ID = table3.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cPaymenttermId==null || cPaymenttermId.equals(""))?"":"  AND zsfi_discount.C_Paymentterm_ID = ?  ");
    strSql = strSql + 
      "        AND zsfi_discount.Zsfi_Discount_ID = ? " +
      "        AND zsfi_discount.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zsfi_discount.AD_Org_ID IN (";
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
      if (cPaymenttermId != null && !(cPaymenttermId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
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
        CashDiscountE627759625B44345B33B35013A8B0107Data objectCashDiscountE627759625B44345B33B35013A8B0107Data = new CashDiscountE627759625B44345B33B35013A8B0107Data();
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.created = UtilSql.getValue(result, "created");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.updated = UtilSql.getValue(result, "updated");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.zsfiDiscountId = UtilSql.getValue(result, "zsfi_discount_id");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.cPaymenttermIdr = UtilSql.getValue(result, "c_paymentterm_idr");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.isactive = UtilSql.getValue(result, "isactive");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.description = UtilSql.getValue(result, "description");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.netdays = UtilSql.getValue(result, "netdays");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.percentage = UtilSql.getValue(result, "percentage");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.language = UtilSql.getValue(result, "language");
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.adUserClient = "";
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.adOrgClient = "";
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.createdby = "";
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.trBgcolor = "";
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.totalCount = "";
        objectCashDiscountE627759625B44345B33B35013A8B0107Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCashDiscountE627759625B44345B33B35013A8B0107Data);
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
    CashDiscountE627759625B44345B33B35013A8B0107Data objectCashDiscountE627759625B44345B33B35013A8B0107Data[] = new CashDiscountE627759625B44345B33B35013A8B0107Data[vector.size()];
    vector.copyInto(objectCashDiscountE627759625B44345B33B35013A8B0107Data);
    return(objectCashDiscountE627759625B44345B33B35013A8B0107Data);
  }

/**
Create a registry
 */
  public static CashDiscountE627759625B44345B33B35013A8B0107Data[] set(String cPaymenttermId, String isactive, String adOrgId, String updatedby, String updatedbyr, String percentage, String zsfiDiscountId, String createdby, String createdbyr, String adClientId, String netdays, String description)    throws ServletException {
    CashDiscountE627759625B44345B33B35013A8B0107Data objectCashDiscountE627759625B44345B33B35013A8B0107Data[] = new CashDiscountE627759625B44345B33B35013A8B0107Data[1];
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0] = new CashDiscountE627759625B44345B33B35013A8B0107Data();
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].created = "";
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].createdbyr = createdbyr;
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].updated = "";
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].updatedTimeStamp = "";
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].updatedby = updatedby;
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].updatedbyr = updatedbyr;
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].zsfiDiscountId = zsfiDiscountId;
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].cPaymenttermId = cPaymenttermId;
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].cPaymenttermIdr = "";
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].isactive = isactive;
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].description = description;
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].netdays = netdays;
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].percentage = percentage;
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].adClientId = adClientId;
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].adClientIdr = "";
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].adOrgId = adOrgId;
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].adOrgIdr = "";
    objectCashDiscountE627759625B44345B33B35013A8B0107Data[0].language = "";
    return objectCashDiscountE627759625B44345B33B35013A8B0107Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef54442F6053DD42F1984C740420D35138_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefF7CEE339A9F04B488EAFB70BEC74232D_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT zsfi_discount.C_Paymentterm_ID AS NAME" +
      "        FROM zsfi_discount" +
      "        WHERE zsfi_discount.Zsfi_Discount_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String cPaymenttermId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_PaymentTerm left join (select C_Paymentterm_ID, Name from C_Paymentterm) table1 on (C_PaymentTerm.C_Paymentterm_ID = table1.C_Paymentterm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL1 on (table1.C_PaymentTerm_ID = tableTRL1.C_PaymentTerm_ID and tableTRL1.AD_Language = ?)  WHERE C_PaymentTerm.C_Paymentterm_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String cPaymenttermId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_PaymentTerm left join (select C_Paymentterm_ID, Name from C_Paymentterm) table1 on (C_PaymentTerm.C_Paymentterm_ID = table1.C_Paymentterm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL1 on (table1.C_PaymentTerm_ID = tableTRL1.C_PaymentTerm_ID and tableTRL1.AD_Language = ?)  WHERE C_PaymentTerm.C_Paymentterm_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);

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
      "        UPDATE zsfi_discount" +
      "        SET Zsfi_Discount_ID = (?) , C_Paymentterm_ID = (?) , Isactive = (?) , Description = (?) , Netdays = TO_NUMBER(?) , Percentage = TO_NUMBER(?) , AD_Client_ID = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zsfi_discount.Zsfi_Discount_ID = ? " +
      "                 AND zsfi_discount.C_Paymentterm_ID = ? " +
      "        AND zsfi_discount.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zsfi_discount.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiDiscountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, netdays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiDiscountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
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
      "        INSERT INTO zsfi_discount " +
      "        (Zsfi_Discount_ID, C_Paymentterm_ID, Isactive, Description, Netdays, Percentage, AD_Client_ID, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiDiscountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, netdays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cPaymenttermId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zsfi_discount" +
      "        WHERE zsfi_discount.Zsfi_Discount_ID = ? " +
      "                 AND zsfi_discount.C_Paymentterm_ID = ? " +
      "        AND zsfi_discount.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zsfi_discount.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cPaymenttermId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zsfi_discount" +
      "        WHERE zsfi_discount.Zsfi_Discount_ID = ? " +
      "                 AND zsfi_discount.C_Paymentterm_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);

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
      "          FROM zsfi_discount" +
      "         WHERE zsfi_discount.Zsfi_Discount_ID = ? ";

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
      "          FROM zsfi_discount" +
      "         WHERE zsfi_discount.Zsfi_Discount_ID = ? ";

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
