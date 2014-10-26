//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.GoodsTransactionList;

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
class Serialnumbers4F0942684B3540EFA837A05BC93F3E37Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Serialnumbers4F0942684B3540EFA837A05BC93F3E37Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String snrMovementlineId;
  public String mMovementlineId;
  public String mMovementlineIdr;
  public String adClientId;
  public String serialnumber;
  public String adOrgId;
  public String guaranteedate;
  public String isactive;
  public String isunavailable;
  public String lotnumber;
  public String quantity;
  public String description;
  public String guaranteedays;
  public String rfidnumber;
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
    else if (fieldName.equalsIgnoreCase("snr_movementline_id") || fieldName.equals("snrMovementlineId"))
      return snrMovementlineId;
    else if (fieldName.equalsIgnoreCase("m_movementline_id") || fieldName.equals("mMovementlineId"))
      return mMovementlineId;
    else if (fieldName.equalsIgnoreCase("m_movementline_idr") || fieldName.equals("mMovementlineIdr"))
      return mMovementlineIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("serialnumber"))
      return serialnumber;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("guaranteedate"))
      return guaranteedate;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isunavailable"))
      return isunavailable;
    else if (fieldName.equalsIgnoreCase("lotnumber"))
      return lotnumber;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("guaranteedays"))
      return guaranteedays;
    else if (fieldName.equalsIgnoreCase("rfidnumber"))
      return rfidnumber;
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
  public static Serialnumbers4F0942684B3540EFA837A05BC93F3E37Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Serialnumbers4F0942684B3540EFA837A05BC93F3E37Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(snr_movementline.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_movementline.CreatedBy) as CreatedByR, " +
      "        to_char(snr_movementline.Updated, ?) as updated, " +
      "        to_char(snr_movementline.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        snr_movementline.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_movementline.UpdatedBy) as UpdatedByR," +
      "        snr_movementline.SNR_Movementline_ID, " +
      "snr_movementline.M_Movementline_ID, " +
      "(CASE WHEN snr_movementline.M_Movementline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.MovementQty), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS M_Movementline_IDR, " +
      "snr_movementline.AD_Client_ID, " +
      "snr_movementline.Serialnumber, " +
      "snr_movementline.AD_Org_ID, " +
      "snr_movementline.Guaranteedate, " +
      "COALESCE(snr_movementline.Isactive, 'N') AS Isactive, " +
      "COALESCE(snr_movementline.Isunavailable, 'N') AS Isunavailable, " +
      "snr_movementline.Lotnumber, " +
      "snr_movementline.Quantity, " +
      "snr_movementline.Description, " +
      "snr_movementline.Guaranteedays, " +
      "snr_movementline.Rfidnumber, " +
      "        ? AS LANGUAGE " +
      "        FROM snr_movementline left join (select M_Movementline_ID, Line, MovementQty, M_Movement_ID from M_Movementline) table1 on (snr_movementline.M_Movementline_ID = table1.M_Movementline_ID) left join (select M_Movement_ID, DocumentNo, Name from M_Movement) table2 on (table1.M_Movement_ID = table2.M_Movement_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND snr_movementline.SNR_Movementline_ID = ? " +
      "        AND snr_movementline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND snr_movementline.AD_Org_ID IN (";
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
        Serialnumbers4F0942684B3540EFA837A05BC93F3E37Data objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data = new Serialnumbers4F0942684B3540EFA837A05BC93F3E37Data();
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.created = UtilSql.getValue(result, "created");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.updated = UtilSql.getValue(result, "updated");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.snrMovementlineId = UtilSql.getValue(result, "snr_movementline_id");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.mMovementlineId = UtilSql.getValue(result, "m_movementline_id");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.mMovementlineIdr = UtilSql.getValue(result, "m_movementline_idr");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.serialnumber = UtilSql.getValue(result, "serialnumber");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.guaranteedate = UtilSql.getDateValue(result, "guaranteedate", "dd-MM-yyyy");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.isactive = UtilSql.getValue(result, "isactive");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.isunavailable = UtilSql.getValue(result, "isunavailable");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.lotnumber = UtilSql.getValue(result, "lotnumber");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.quantity = UtilSql.getValue(result, "quantity");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.description = UtilSql.getValue(result, "description");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.guaranteedays = UtilSql.getValue(result, "guaranteedays");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.rfidnumber = UtilSql.getValue(result, "rfidnumber");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.language = UtilSql.getValue(result, "language");
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.adUserClient = "";
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.adOrgClient = "";
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.createdby = "";
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.trBgcolor = "";
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.totalCount = "";
        objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data);
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
    Serialnumbers4F0942684B3540EFA837A05BC93F3E37Data objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[] = new Serialnumbers4F0942684B3540EFA837A05BC93F3E37Data[vector.size()];
    vector.copyInto(objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data);
    return(objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data);
  }

/**
Create a registry
 */
  public static Serialnumbers4F0942684B3540EFA837A05BC93F3E37Data[] set(String snrMovementlineId, String description, String lotnumber, String adOrgId, String isunavailable, String guaranteedate, String mMovementlineId, String adClientId, String guaranteedays, String quantity, String serialnumber, String updatedby, String updatedbyr, String isactive, String rfidnumber, String createdby, String createdbyr)    throws ServletException {
    Serialnumbers4F0942684B3540EFA837A05BC93F3E37Data objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[] = new Serialnumbers4F0942684B3540EFA837A05BC93F3E37Data[1];
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0] = new Serialnumbers4F0942684B3540EFA837A05BC93F3E37Data();
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].created = "";
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].createdbyr = createdbyr;
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].updated = "";
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].updatedTimeStamp = "";
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].updatedby = updatedby;
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].updatedbyr = updatedbyr;
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].snrMovementlineId = snrMovementlineId;
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].mMovementlineId = mMovementlineId;
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].mMovementlineIdr = "";
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].adClientId = adClientId;
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].serialnumber = serialnumber;
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].adOrgId = adOrgId;
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].guaranteedate = guaranteedate;
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].isactive = isactive;
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].isunavailable = isunavailable;
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].lotnumber = lotnumber;
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].quantity = quantity;
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].description = description;
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].guaranteedays = guaranteedays;
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].rfidnumber = rfidnumber;
    objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data[0].language = "";
    return objectSerialnumbers4F0942684B3540EFA837A05BC93F3E37Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef97EAC1321ED1499B9F1C687CCD52DCED_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef2B9B8D359DBE47FC940D735EE3E3A19B_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        UPDATE snr_movementline" +
      "        SET SNR_Movementline_ID = (?) , M_Movementline_ID = (?) , AD_Client_ID = (?) , Serialnumber = (?) , AD_Org_ID = (?) , Guaranteedate = TO_DATE(?) , Isactive = (?) , Isunavailable = (?) , Lotnumber = (?) , Quantity = TO_NUMBER(?) , Description = (?) , Guaranteedays = TO_NUMBER(?) , Rfidnumber = (?) , updated = now(), updatedby = ? " +
      "        WHERE snr_movementline.SNR_Movementline_ID = ? " +
      "        AND snr_movementline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_movementline.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMovementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mMovementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isunavailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lotnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rfidnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMovementlineId);
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
      "        INSERT INTO snr_movementline " +
      "        (SNR_Movementline_ID, M_Movementline_ID, AD_Client_ID, Serialnumber, AD_Org_ID, Guaranteedate, Isactive, Isunavailable, Lotnumber, Quantity, Description, Guaranteedays, Rfidnumber, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMovementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mMovementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isunavailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lotnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rfidnumber);
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
      "        DELETE FROM snr_movementline" +
      "        WHERE snr_movementline.SNR_Movementline_ID = ? " +
      "        AND snr_movementline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_movementline.AD_Org_ID IN (";
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
      "        DELETE FROM snr_movementline" +
      "        WHERE snr_movementline.SNR_Movementline_ID = ? ";

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
      "          FROM snr_movementline" +
      "         WHERE snr_movementline.SNR_Movementline_ID = ? ";

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
      "          FROM snr_movementline" +
      "         WHERE snr_movementline.SNR_Movementline_ID = ? ";

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
