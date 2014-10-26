//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.PhysicalInventory;

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
class Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mInventorylineId;
  public String mInventorylineIdr;
  public String snrInventorylineId;
  public String serialnumber;
  public String adClientId;
  public String adOrgId;
  public String isunavailable;
  public String isactive;
  public String lotnumber;
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
    else if (fieldName.equalsIgnoreCase("m_inventoryline_id") || fieldName.equals("mInventorylineId"))
      return mInventorylineId;
    else if (fieldName.equalsIgnoreCase("m_inventoryline_idr") || fieldName.equals("mInventorylineIdr"))
      return mInventorylineIdr;
    else if (fieldName.equalsIgnoreCase("snr_inventoryline_id") || fieldName.equals("snrInventorylineId"))
      return snrInventorylineId;
    else if (fieldName.equalsIgnoreCase("serialnumber"))
      return serialnumber;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isunavailable"))
      return isunavailable;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("lotnumber"))
      return lotnumber;
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
  public static Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mInventorylineId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, mInventorylineId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mInventorylineId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(snr_inventoryline.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_inventoryline.CreatedBy) as CreatedByR, " +
      "        to_char(snr_inventoryline.Updated, ?) as updated, " +
      "        to_char(snr_inventoryline.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        snr_inventoryline.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_inventoryline.UpdatedBy) as UpdatedByR," +
      "        snr_inventoryline.M_Inventoryline_ID, " +
      "(CASE WHEN snr_inventoryline.M_Inventoryline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.QtyCount), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS M_Inventoryline_IDR, " +
      "snr_inventoryline.SNR_Inventoryline_ID, " +
      "snr_inventoryline.Serialnumber, " +
      "snr_inventoryline.AD_Client_ID, " +
      "snr_inventoryline.AD_Org_ID, " +
      "COALESCE(snr_inventoryline.Isunavailable, 'N') AS Isunavailable, " +
      "COALESCE(snr_inventoryline.Isactive, 'N') AS Isactive, " +
      "snr_inventoryline.Lotnumber, " +
      "snr_inventoryline.Quantity, " +
      "snr_inventoryline.Guaranteedays, " +
      "snr_inventoryline.Guaranteedate, " +
      "snr_inventoryline.Rfidnumber, " +
      "snr_inventoryline.Description, " +
      "        ? AS LANGUAGE " +
      "        FROM snr_inventoryline left join (select M_Inventoryline_ID, Line, QtyCount, M_Inventory_ID, Name from M_Inventoryline) table1 on (snr_inventoryline.M_Inventoryline_ID = table1.M_Inventoryline_ID) left join (select M_Inventory_ID, Name from M_Inventory) table2 on (table1.M_Inventory_ID = table2.M_Inventory_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((mInventorylineId==null || mInventorylineId.equals(""))?"":"  AND snr_inventoryline.M_Inventoryline_ID = ?  ");
    strSql = strSql + 
      "        AND snr_inventoryline.SNR_Inventoryline_ID = ? " +
      "        AND snr_inventoryline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND snr_inventoryline.AD_Org_ID IN (";
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
      if (mInventorylineId != null && !(mInventorylineId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventorylineId);
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
        Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data = new Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data();
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.created = UtilSql.getValue(result, "created");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.updated = UtilSql.getValue(result, "updated");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.mInventorylineId = UtilSql.getValue(result, "m_inventoryline_id");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.mInventorylineIdr = UtilSql.getValue(result, "m_inventoryline_idr");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.snrInventorylineId = UtilSql.getValue(result, "snr_inventoryline_id");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.serialnumber = UtilSql.getValue(result, "serialnumber");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.isunavailable = UtilSql.getValue(result, "isunavailable");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.isactive = UtilSql.getValue(result, "isactive");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.lotnumber = UtilSql.getValue(result, "lotnumber");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.quantity = UtilSql.getValue(result, "quantity");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.guaranteedays = UtilSql.getValue(result, "guaranteedays");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.guaranteedate = UtilSql.getDateValue(result, "guaranteedate", "dd-MM-yyyy");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.rfidnumber = UtilSql.getValue(result, "rfidnumber");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.description = UtilSql.getValue(result, "description");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.language = UtilSql.getValue(result, "language");
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.adUserClient = "";
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.adOrgClient = "";
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.createdby = "";
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.trBgcolor = "";
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.totalCount = "";
        objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data);
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
    Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[] = new Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[vector.size()];
    vector.copyInto(objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data);
    return(objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data);
  }

/**
Create a registry
 */
  public static Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[] set(String mInventorylineId, String serialnumber, String quantity, String guaranteedate, String updatedby, String updatedbyr, String isactive, String isunavailable, String rfidnumber, String adClientId, String guaranteedays, String createdby, String createdbyr, String description, String snrInventorylineId, String lotnumber, String adOrgId)    throws ServletException {
    Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[] = new Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[1];
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0] = new Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data();
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].created = "";
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].createdbyr = createdbyr;
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].updated = "";
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].updatedTimeStamp = "";
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].updatedby = updatedby;
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].updatedbyr = updatedbyr;
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].mInventorylineId = mInventorylineId;
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].mInventorylineIdr = "";
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].snrInventorylineId = snrInventorylineId;
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].serialnumber = serialnumber;
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].adClientId = adClientId;
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].adOrgId = adOrgId;
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].isunavailable = isunavailable;
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].isactive = isactive;
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].lotnumber = lotnumber;
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].quantity = quantity;
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].guaranteedays = guaranteedays;
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].guaranteedate = guaranteedate;
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].rfidnumber = rfidnumber;
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].description = description;
    objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0].language = "";
    return objectSerialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefCDAFF29584E24F46A900AD54035F227B_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefDF80E990D232466DA7688A90F297EFB5_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT snr_inventoryline.M_Inventoryline_ID AS NAME" +
      "        FROM snr_inventoryline" +
      "        WHERE snr_inventoryline.SNR_Inventoryline_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String mInventorylineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Line), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.QtyCount), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM M_InventoryLine left join (select M_Inventoryline_ID, Line, QtyCount, M_Inventory_ID, Name from M_Inventoryline) table1 on (M_InventoryLine.M_Inventoryline_ID = table1.M_Inventoryline_ID) left join (select M_Inventory_ID, Name from M_Inventory) table2 on (table1.M_Inventory_ID = table2.M_Inventory_ID) WHERE M_InventoryLine.M_Inventoryline_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventorylineId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String mInventorylineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Line), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.QtyCount), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM M_InventoryLine left join (select M_Inventoryline_ID, Line, QtyCount, M_Inventory_ID, Name from M_Inventoryline) table1 on (M_InventoryLine.M_Inventoryline_ID = table1.M_Inventoryline_ID) left join (select M_Inventory_ID, Name from M_Inventory) table2 on (table1.M_Inventory_ID = table2.M_Inventory_ID) WHERE M_InventoryLine.M_Inventoryline_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventorylineId);

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
      "        UPDATE snr_inventoryline" +
      "        SET M_Inventoryline_ID = (?) , SNR_Inventoryline_ID = (?) , Serialnumber = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Isunavailable = (?) , Isactive = (?) , Lotnumber = (?) , Quantity = TO_NUMBER(?) , Guaranteedays = TO_NUMBER(?) , Guaranteedate = TO_DATE(?) , Rfidnumber = (?) , Description = (?) , updated = now(), updatedby = ? " +
      "        WHERE snr_inventoryline.SNR_Inventoryline_ID = ? " +
      "                 AND snr_inventoryline.M_Inventoryline_ID = ? " +
      "        AND snr_inventoryline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_inventoryline.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventorylineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrInventorylineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isunavailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lotnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rfidnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrInventorylineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventorylineId);
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
      "        INSERT INTO snr_inventoryline " +
      "        (M_Inventoryline_ID, SNR_Inventoryline_ID, Serialnumber, AD_Client_ID, AD_Org_ID, Isunavailable, Isactive, Lotnumber, Quantity, Guaranteedays, Guaranteedate, Rfidnumber, Description, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventorylineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrInventorylineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isunavailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lotnumber);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String mInventorylineId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM snr_inventoryline" +
      "        WHERE snr_inventoryline.SNR_Inventoryline_ID = ? " +
      "                 AND snr_inventoryline.M_Inventoryline_ID = ? " +
      "        AND snr_inventoryline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_inventoryline.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventorylineId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String mInventorylineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM snr_inventoryline" +
      "        WHERE snr_inventoryline.SNR_Inventoryline_ID = ? " +
      "                 AND snr_inventoryline.M_Inventoryline_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventorylineId);

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
      "          FROM snr_inventoryline" +
      "         WHERE snr_inventoryline.SNR_Inventoryline_ID = ? ";

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
      "          FROM snr_inventoryline" +
      "         WHERE snr_inventoryline.SNR_Inventoryline_ID = ? ";

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
