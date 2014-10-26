//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.InternalMaterialMovements;

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
class Serialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Serialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mInternalConsumptionlineId;
  public String mInternalConsumptionlineIdr;
  public String snrInternalConsumptionlineId;
  public String adClientId;
  public String serialnumber;
  public String adOrgId;
  public String isunavailable;
  public String lotnumber;
  public String isactive;
  public String quantity;
  public String guaranteedays;
  public String guaranteedate;
  public String rfidnumber;
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
    else if (fieldName.equalsIgnoreCase("m_internal_consumptionline_id") || fieldName.equals("mInternalConsumptionlineId"))
      return mInternalConsumptionlineId;
    else if (fieldName.equalsIgnoreCase("m_internal_consumptionline_idr") || fieldName.equals("mInternalConsumptionlineIdr"))
      return mInternalConsumptionlineIdr;
    else if (fieldName.equalsIgnoreCase("snr_internal_consumptionline_id") || fieldName.equals("snrInternalConsumptionlineId"))
      return snrInternalConsumptionlineId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("serialnumber"))
      return serialnumber;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isunavailable"))
      return isunavailable;
    else if (fieldName.equalsIgnoreCase("lotnumber"))
      return lotnumber;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("guaranteedays"))
      return guaranteedays;
    else if (fieldName.equalsIgnoreCase("guaranteedate"))
      return guaranteedate;
    else if (fieldName.equalsIgnoreCase("rfidnumber"))
      return rfidnumber;
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
  public static Serialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mInternalConsumptionlineId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, mInternalConsumptionlineId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Serialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mInternalConsumptionlineId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(snr_internal_consumptionline.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_internal_consumptionline.CreatedBy) as CreatedByR, " +
      "        to_char(snr_internal_consumptionline.Updated, ?) as updated, " +
      "        to_char(snr_internal_consumptionline.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        snr_internal_consumptionline.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_internal_consumptionline.UpdatedBy) as UpdatedByR," +
      "        snr_internal_consumptionline.M_Internal_Consumptionline_ID, " +
      "(CASE WHEN snr_internal_consumptionline.M_Internal_Consumptionline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.MovementQty), ''))),'') ) END) AS M_Internal_Consumptionline_IDR, " +
      "snr_internal_consumptionline.SNR_Internal_Consumptionline_ID, " +
      "snr_internal_consumptionline.AD_Client_ID, " +
      "snr_internal_consumptionline.Serialnumber, " +
      "snr_internal_consumptionline.AD_Org_ID, " +
      "COALESCE(snr_internal_consumptionline.Isunavailable, 'N') AS Isunavailable, " +
      "snr_internal_consumptionline.Lotnumber, " +
      "COALESCE(snr_internal_consumptionline.Isactive, 'N') AS Isactive, " +
      "snr_internal_consumptionline.Quantity, " +
      "snr_internal_consumptionline.Guaranteedays, " +
      "snr_internal_consumptionline.Guaranteedate, " +
      "snr_internal_consumptionline.Rfidnumber, " +
      "snr_internal_consumptionline.Description, " +
      "        ? AS LANGUAGE " +
      "        FROM snr_internal_consumptionline left join (select M_Internal_Consumptionline_ID, M_Internal_Consumption_ID, M_Product_ID, MovementQty from M_Internal_Consumptionline) table1 on (snr_internal_consumptionline.M_Internal_Consumptionline_ID = table1.M_Internal_Consumptionline_ID) left join (select M_Internal_Consumption_ID, Name from M_Internal_Consumption) table2 on (table1.M_Internal_Consumption_ID = table2.M_Internal_Consumption_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (table1.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((mInternalConsumptionlineId==null || mInternalConsumptionlineId.equals(""))?"":"  AND snr_internal_consumptionline.M_Internal_Consumptionline_ID = ?  ");
    strSql = strSql + 
      "        AND snr_internal_consumptionline.SNR_Internal_Consumptionline_ID = ? " +
      "        AND snr_internal_consumptionline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND snr_internal_consumptionline.AD_Org_ID IN (";
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
      if (mInternalConsumptionlineId != null && !(mInternalConsumptionlineId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionlineId);
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
        Serialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data = new Serialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data();
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.created = UtilSql.getValue(result, "created");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.updated = UtilSql.getValue(result, "updated");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.mInternalConsumptionlineId = UtilSql.getValue(result, "m_internal_consumptionline_id");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.mInternalConsumptionlineIdr = UtilSql.getValue(result, "m_internal_consumptionline_idr");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.snrInternalConsumptionlineId = UtilSql.getValue(result, "snr_internal_consumptionline_id");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.serialnumber = UtilSql.getValue(result, "serialnumber");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.isunavailable = UtilSql.getValue(result, "isunavailable");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.lotnumber = UtilSql.getValue(result, "lotnumber");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.isactive = UtilSql.getValue(result, "isactive");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.quantity = UtilSql.getValue(result, "quantity");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.guaranteedays = UtilSql.getValue(result, "guaranteedays");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.guaranteedate = UtilSql.getDateValue(result, "guaranteedate", "dd-MM-yyyy");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.rfidnumber = UtilSql.getValue(result, "rfidnumber");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.description = UtilSql.getValue(result, "description");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.language = UtilSql.getValue(result, "language");
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.adUserClient = "";
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.adOrgClient = "";
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.createdby = "";
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.trBgcolor = "";
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.totalCount = "";
        objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data);
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
    Serialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[] = new Serialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[vector.size()];
    vector.copyInto(objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data);
    return(objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data);
  }

/**
Create a registry
 */
  public static Serialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[] set(String mInternalConsumptionlineId, String adClientId, String isactive, String guaranteedays, String description, String rfidnumber, String guaranteedate, String updatedby, String updatedbyr, String createdby, String createdbyr, String serialnumber, String quantity, String lotnumber, String isunavailable, String adOrgId, String snrInternalConsumptionlineId)    throws ServletException {
    Serialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[] = new Serialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[1];
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0] = new Serialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data();
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].created = "";
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].createdbyr = createdbyr;
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].updated = "";
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].updatedTimeStamp = "";
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].updatedby = updatedby;
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].updatedbyr = updatedbyr;
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].mInternalConsumptionlineId = mInternalConsumptionlineId;
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].mInternalConsumptionlineIdr = "";
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].snrInternalConsumptionlineId = snrInternalConsumptionlineId;
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].adClientId = adClientId;
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].serialnumber = serialnumber;
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].adOrgId = adOrgId;
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].isunavailable = isunavailable;
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].lotnumber = lotnumber;
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].isactive = isactive;
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].quantity = quantity;
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].guaranteedays = guaranteedays;
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].guaranteedate = guaranteedate;
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].rfidnumber = rfidnumber;
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].description = description;
    objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data[0].language = "";
    return objectSerialnumbers1BD46C67B6A54A8AB55EFF9A36B4D3B1Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef394CD14BE0DC425AAF61F8F612EDA7E4_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefB4C9569891BF47D0A25F791501B91DE9_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT snr_internal_consumptionline.M_Internal_Consumptionline_ID AS NAME" +
      "        FROM snr_internal_consumptionline" +
      "        WHERE snr_internal_consumptionline.SNR_Internal_Consumptionline_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String mInternalConsumptionlineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.MovementQty), ''))) AS NAME FROM M_Internal_ConsumptionLine left join (select M_Internal_Consumptionline_ID, M_Internal_Consumption_ID, M_Product_ID, MovementQty from M_Internal_Consumptionline) table1 on (M_Internal_ConsumptionLine.M_Internal_Consumptionline_ID = table1.M_Internal_Consumptionline_ID) left join (select M_Internal_Consumption_ID, Name from M_Internal_Consumption) table2 on (table1.M_Internal_Consumption_ID = table2.M_Internal_Consumption_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (table1.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  WHERE M_Internal_ConsumptionLine.M_Internal_Consumptionline_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionlineId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String mInternalConsumptionlineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.MovementQty), ''))) AS NAME FROM M_Internal_ConsumptionLine left join (select M_Internal_Consumptionline_ID, M_Internal_Consumption_ID, M_Product_ID, MovementQty from M_Internal_Consumptionline) table1 on (M_Internal_ConsumptionLine.M_Internal_Consumptionline_ID = table1.M_Internal_Consumptionline_ID) left join (select M_Internal_Consumption_ID, Name from M_Internal_Consumption) table2 on (table1.M_Internal_Consumption_ID = table2.M_Internal_Consumption_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (table1.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  WHERE M_Internal_ConsumptionLine.M_Internal_Consumptionline_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionlineId);

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
      "        UPDATE snr_internal_consumptionline" +
      "        SET M_Internal_Consumptionline_ID = (?) , SNR_Internal_Consumptionline_ID = (?) , AD_Client_ID = (?) , Serialnumber = (?) , AD_Org_ID = (?) , Isunavailable = (?) , Lotnumber = (?) , Isactive = (?) , Quantity = TO_NUMBER(?) , Guaranteedays = TO_NUMBER(?) , Guaranteedate = TO_DATE(?) , Rfidnumber = (?) , Description = (?) , updated = now(), updatedby = ? " +
      "        WHERE snr_internal_consumptionline.SNR_Internal_Consumptionline_ID = ? " +
      "                 AND snr_internal_consumptionline.M_Internal_Consumptionline_ID = ? " +
      "        AND snr_internal_consumptionline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_internal_consumptionline.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrInternalConsumptionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isunavailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lotnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rfidnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrInternalConsumptionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionlineId);
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
      "        INSERT INTO snr_internal_consumptionline " +
      "        (M_Internal_Consumptionline_ID, SNR_Internal_Consumptionline_ID, AD_Client_ID, Serialnumber, AD_Org_ID, Isunavailable, Lotnumber, Isactive, Quantity, Guaranteedays, Guaranteedate, Rfidnumber, Description, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrInternalConsumptionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isunavailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lotnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rfidnumber);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String mInternalConsumptionlineId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM snr_internal_consumptionline" +
      "        WHERE snr_internal_consumptionline.SNR_Internal_Consumptionline_ID = ? " +
      "                 AND snr_internal_consumptionline.M_Internal_Consumptionline_ID = ? " +
      "        AND snr_internal_consumptionline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_internal_consumptionline.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionlineId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String mInternalConsumptionlineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM snr_internal_consumptionline" +
      "        WHERE snr_internal_consumptionline.SNR_Internal_Consumptionline_ID = ? " +
      "                 AND snr_internal_consumptionline.M_Internal_Consumptionline_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionlineId);

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
      "          FROM snr_internal_consumptionline" +
      "         WHERE snr_internal_consumptionline.SNR_Internal_Consumptionline_ID = ? ";

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
      "          FROM snr_internal_consumptionline" +
      "         WHERE snr_internal_consumptionline.SNR_Internal_Consumptionline_ID = ? ";

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
