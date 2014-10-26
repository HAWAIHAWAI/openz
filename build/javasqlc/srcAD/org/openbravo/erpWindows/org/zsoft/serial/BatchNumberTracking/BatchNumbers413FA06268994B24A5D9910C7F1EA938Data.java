//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.zsoft.serial.BatchNumberTracking;

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
class BatchNumbers413FA06268994B24A5D9910C7F1EA938Data implements FieldProvider {
static Logger log4j = Logger.getLogger(BatchNumbers413FA06268994B24A5D9910C7F1EA938Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String snrBatchmasterdataId;
  public String adOrgId;
  public String adOrgIdr;
  public String adClientId;
  public String batchnumber;
  public String mProductId;
  public String mProductIdr;
  public String firstseen;
  public String isactive;
  public String guaranteedate;
  public String description;
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
    else if (fieldName.equalsIgnoreCase("snr_batchmasterdata_id") || fieldName.equals("snrBatchmasterdataId"))
      return snrBatchmasterdataId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("batchnumber"))
      return batchnumber;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("firstseen"))
      return firstseen;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("guaranteedate"))
      return guaranteedate;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
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
  public static BatchNumbers413FA06268994B24A5D9910C7F1EA938Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static BatchNumbers413FA06268994B24A5D9910C7F1EA938Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(snr_batchmasterdata.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_batchmasterdata.CreatedBy) as CreatedByR, " +
      "        to_char(snr_batchmasterdata.Updated, ?) as updated, " +
      "        to_char(snr_batchmasterdata.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        snr_batchmasterdata.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_batchmasterdata.UpdatedBy) as UpdatedByR," +
      "        snr_batchmasterdata.SNR_Batchmasterdata_ID, " +
      "snr_batchmasterdata.AD_Org_ID, " +
      "(CASE WHEN snr_batchmasterdata.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "snr_batchmasterdata.AD_Client_ID, " +
      "snr_batchmasterdata.Batchnumber, " +
      "snr_batchmasterdata.M_Product_ID, " +
      "(CASE WHEN snr_batchmasterdata.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "snr_batchmasterdata.Firstseen, " +
      "COALESCE(snr_batchmasterdata.Isactive, 'N') AS Isactive, " +
      "snr_batchmasterdata.Guaranteedate, " +
      "snr_batchmasterdata.Description, " +
      "        ? AS LANGUAGE " +
      "        FROM snr_batchmasterdata left join (select AD_Org_ID, Name from AD_Org) table1 on (snr_batchmasterdata.AD_Org_ID = table1.AD_Org_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (snr_batchmasterdata.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND snr_batchmasterdata.SNR_Batchmasterdata_ID = ? " +
      "        AND snr_batchmasterdata.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND snr_batchmasterdata.AD_Org_ID IN (";
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
        BatchNumbers413FA06268994B24A5D9910C7F1EA938Data objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data = new BatchNumbers413FA06268994B24A5D9910C7F1EA938Data();
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.created = UtilSql.getValue(result, "created");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.updated = UtilSql.getValue(result, "updated");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.snrBatchmasterdataId = UtilSql.getValue(result, "snr_batchmasterdata_id");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.batchnumber = UtilSql.getValue(result, "batchnumber");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.firstseen = UtilSql.getDateValue(result, "firstseen", "dd-MM-yyyy");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.isactive = UtilSql.getValue(result, "isactive");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.guaranteedate = UtilSql.getDateValue(result, "guaranteedate", "dd-MM-yyyy");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.description = UtilSql.getValue(result, "description");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.language = UtilSql.getValue(result, "language");
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.adUserClient = "";
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.adOrgClient = "";
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.createdby = "";
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.trBgcolor = "";
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.totalCount = "";
        objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data);
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
    BatchNumbers413FA06268994B24A5D9910C7F1EA938Data objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[] = new BatchNumbers413FA06268994B24A5D9910C7F1EA938Data[vector.size()];
    vector.copyInto(objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data);
    return(objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data);
  }

/**
Create a registry
 */
  public static BatchNumbers413FA06268994B24A5D9910C7F1EA938Data[] set(String mProductId, String mProductIdr, String description, String batchnumber, String adOrgId, String adClientId, String guaranteedate, String snrBatchmasterdataId, String updatedby, String updatedbyr, String firstseen, String createdby, String createdbyr, String isactive)    throws ServletException {
    BatchNumbers413FA06268994B24A5D9910C7F1EA938Data objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[] = new BatchNumbers413FA06268994B24A5D9910C7F1EA938Data[1];
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0] = new BatchNumbers413FA06268994B24A5D9910C7F1EA938Data();
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].created = "";
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].createdbyr = createdbyr;
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].updated = "";
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].updatedTimeStamp = "";
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].updatedby = updatedby;
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].updatedbyr = updatedbyr;
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].snrBatchmasterdataId = snrBatchmasterdataId;
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].adOrgId = adOrgId;
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].adOrgIdr = "";
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].adClientId = adClientId;
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].batchnumber = batchnumber;
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].mProductId = mProductId;
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].mProductIdr = mProductIdr;
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].firstseen = firstseen;
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].isactive = isactive;
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].guaranteedate = guaranteedate;
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].description = description;
    objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data[0].language = "";
    return objectBatchNumbers413FA06268994B24A5D9910C7F1EA938Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefF69487C1655E407AA0767D1A81F515DB_0(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef59ADC3861D964AE2849A122F3258B58F_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef945E0EB6EB33474B94BFEBA0F9CDD38C_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        UPDATE snr_batchmasterdata" +
      "        SET SNR_Batchmasterdata_ID = (?) , AD_Org_ID = (?) , AD_Client_ID = (?) , Batchnumber = (?) , M_Product_ID = (?) , Firstseen = TO_DATE(?) , Isactive = (?) , Guaranteedate = TO_DATE(?) , Description = (?) , updated = now(), updatedby = ? " +
      "        WHERE snr_batchmasterdata.SNR_Batchmasterdata_ID = ? " +
      "        AND snr_batchmasterdata.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_batchmasterdata.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchmasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, batchnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstseen);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchmasterdataId);
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
      "        INSERT INTO snr_batchmasterdata " +
      "        (SNR_Batchmasterdata_ID, AD_Org_ID, AD_Client_ID, Batchnumber, M_Product_ID, Firstseen, Isactive, Guaranteedate, Description, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_DATE(?), (?), TO_DATE(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchmasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, batchnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstseen);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
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
      "        DELETE FROM snr_batchmasterdata" +
      "        WHERE snr_batchmasterdata.SNR_Batchmasterdata_ID = ? " +
      "        AND snr_batchmasterdata.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_batchmasterdata.AD_Org_ID IN (";
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
      "        DELETE FROM snr_batchmasterdata" +
      "        WHERE snr_batchmasterdata.SNR_Batchmasterdata_ID = ? ";

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
      "          FROM snr_batchmasterdata" +
      "         WHERE snr_batchmasterdata.SNR_Batchmasterdata_ID = ? ";

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
      "          FROM snr_batchmasterdata" +
      "         WHERE snr_batchmasterdata.SNR_Batchmasterdata_ID = ? ";

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
