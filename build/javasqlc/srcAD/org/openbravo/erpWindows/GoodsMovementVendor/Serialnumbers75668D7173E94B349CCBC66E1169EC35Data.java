//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.GoodsMovementVendor;

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
class Serialnumbers75668D7173E94B349CCBC66E1169EC35Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Serialnumbers75668D7173E94B349CCBC66E1169EC35Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mInoutlineId;
  public String mInoutlineIdr;
  public String snrMinoutlineId;
  public String serialnumber;
  public String adClientId;
  public String isunavailable;
  public String adOrgId;
  public String lotnumber;
  public String quantity;
  public String isactive;
  public String guaranteedays;
  public String rfidnumber;
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
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
    else if (fieldName.equalsIgnoreCase("m_inoutline_idr") || fieldName.equals("mInoutlineIdr"))
      return mInoutlineIdr;
    else if (fieldName.equalsIgnoreCase("snr_minoutline_id") || fieldName.equals("snrMinoutlineId"))
      return snrMinoutlineId;
    else if (fieldName.equalsIgnoreCase("serialnumber"))
      return serialnumber;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("isunavailable"))
      return isunavailable;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("lotnumber"))
      return lotnumber;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("guaranteedays"))
      return guaranteedays;
    else if (fieldName.equalsIgnoreCase("rfidnumber"))
      return rfidnumber;
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
  public static Serialnumbers75668D7173E94B349CCBC66E1169EC35Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mInoutlineId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, mInoutlineId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Serialnumbers75668D7173E94B349CCBC66E1169EC35Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mInoutlineId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(snr_minoutline.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_minoutline.CreatedBy) as CreatedByR, " +
      "        to_char(snr_minoutline.Updated, ?) as updated, " +
      "        to_char(snr_minoutline.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        snr_minoutline.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_minoutline.UpdatedBy) as UpdatedByR," +
      "        snr_minoutline.M_Inoutline_ID, " +
      "(CASE WHEN snr_minoutline.M_Inoutline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table2.MovementDate, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS M_Inoutline_IDR, " +
      "snr_minoutline.SNR_Minoutline_ID, " +
      "snr_minoutline.Serialnumber, " +
      "snr_minoutline.AD_Client_ID, " +
      "COALESCE(snr_minoutline.Isunavailable, 'N') AS Isunavailable, " +
      "snr_minoutline.AD_Org_ID, " +
      "snr_minoutline.Lotnumber, " +
      "snr_minoutline.Quantity, " +
      "COALESCE(snr_minoutline.Isactive, 'N') AS Isactive, " +
      "snr_minoutline.Guaranteedays, " +
      "snr_minoutline.Rfidnumber, " +
      "snr_minoutline.Guaranteedate, " +
      "snr_minoutline.Description, " +
      "        ? AS LANGUAGE " +
      "        FROM snr_minoutline left join (select M_Inoutline_ID, M_InOut_ID, M_Product_ID from M_Inoutline) table1 on (snr_minoutline.M_Inoutline_ID = table1.M_Inoutline_ID) left join (select M_InOut_ID, DocumentNo, MovementDate from M_InOut) table2 on (table1.M_InOut_ID = table2.M_InOut_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (table1.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((mInoutlineId==null || mInoutlineId.equals(""))?"":"  AND snr_minoutline.M_Inoutline_ID = ?  ");
    strSql = strSql + 
      "        AND snr_minoutline.SNR_Minoutline_ID = ? " +
      "        AND snr_minoutline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND snr_minoutline.AD_Org_ID IN (";
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
      if (mInoutlineId != null && !(mInoutlineId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
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
        Serialnumbers75668D7173E94B349CCBC66E1169EC35Data objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data = new Serialnumbers75668D7173E94B349CCBC66E1169EC35Data();
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.created = UtilSql.getValue(result, "created");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.updated = UtilSql.getValue(result, "updated");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.mInoutlineIdr = UtilSql.getValue(result, "m_inoutline_idr");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.snrMinoutlineId = UtilSql.getValue(result, "snr_minoutline_id");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.serialnumber = UtilSql.getValue(result, "serialnumber");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.isunavailable = UtilSql.getValue(result, "isunavailable");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.lotnumber = UtilSql.getValue(result, "lotnumber");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.quantity = UtilSql.getValue(result, "quantity");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.isactive = UtilSql.getValue(result, "isactive");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.guaranteedays = UtilSql.getValue(result, "guaranteedays");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.rfidnumber = UtilSql.getValue(result, "rfidnumber");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.guaranteedate = UtilSql.getDateValue(result, "guaranteedate", "dd-MM-yyyy");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.description = UtilSql.getValue(result, "description");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.language = UtilSql.getValue(result, "language");
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.adUserClient = "";
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.adOrgClient = "";
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.createdby = "";
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.trBgcolor = "";
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.totalCount = "";
        objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data);
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
    Serialnumbers75668D7173E94B349CCBC66E1169EC35Data objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[] = new Serialnumbers75668D7173E94B349CCBC66E1169EC35Data[vector.size()];
    vector.copyInto(objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data);
    return(objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data);
  }

/**
Create a registry
 */
  public static Serialnumbers75668D7173E94B349CCBC66E1169EC35Data[] set(String mInoutlineId, String guaranteedate, String adClientId, String quantity, String isunavailable, String serialnumber, String rfidnumber, String updatedby, String updatedbyr, String lotnumber, String createdby, String createdbyr, String adOrgId, String description, String snrMinoutlineId, String isactive, String guaranteedays)    throws ServletException {
    Serialnumbers75668D7173E94B349CCBC66E1169EC35Data objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[] = new Serialnumbers75668D7173E94B349CCBC66E1169EC35Data[1];
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0] = new Serialnumbers75668D7173E94B349CCBC66E1169EC35Data();
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].created = "";
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].createdbyr = createdbyr;
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].updated = "";
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].updatedTimeStamp = "";
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].updatedby = updatedby;
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].updatedbyr = updatedbyr;
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].mInoutlineId = mInoutlineId;
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].mInoutlineIdr = "";
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].snrMinoutlineId = snrMinoutlineId;
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].serialnumber = serialnumber;
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].adClientId = adClientId;
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].isunavailable = isunavailable;
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].adOrgId = adOrgId;
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].lotnumber = lotnumber;
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].quantity = quantity;
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].isactive = isactive;
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].guaranteedays = guaranteedays;
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].rfidnumber = rfidnumber;
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].guaranteedate = guaranteedate;
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].description = description;
    objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data[0].language = "";
    return objectSerialnumbers75668D7173E94B349CCBC66E1169EC35Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefAF17F3E502804AB7AE13406ABF2B2890(ConnectionProvider connectionProvider, String m_inoutline_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT getLotQtyLeft(?)  AS DefaultValue  from dual ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_inoutline_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDefB15BCF19B3D74BA9AA72A278C34A9B08_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef9A006BE6F4604724BECAF2DA089118EC(ConnectionProvider connectionProvider, String ad_org_id, String issotrx, String m_inoutline_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT getAutoLotNo(?,?,?)  AS DefaultValue  from dual ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_inoutline_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDefD8F5A42696D449F0B636CA85AB6D830A_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT snr_minoutline.M_Inoutline_ID AS NAME" +
      "        FROM snr_minoutline" +
      "        WHERE snr_minoutline.SNR_Minoutline_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String mInoutlineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.DocumentNo), '')) || ' - ' || TO_CHAR(table2.MovementDate, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))) AS NAME FROM M_InOutLine left join (select M_Inoutline_ID, M_InOut_ID, M_Product_ID from M_Inoutline) table1 on (M_InOutLine.M_Inoutline_ID = table1.M_Inoutline_ID) left join (select M_InOut_ID, DocumentNo, MovementDate from M_InOut) table2 on (table1.M_InOut_ID = table2.M_InOut_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (table1.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  WHERE M_InOutLine.M_Inoutline_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String mInoutlineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.DocumentNo), '')) || ' - ' || TO_CHAR(table2.MovementDate, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))) AS NAME FROM M_InOutLine left join (select M_Inoutline_ID, M_InOut_ID, M_Product_ID from M_Inoutline) table1 on (M_InOutLine.M_Inoutline_ID = table1.M_Inoutline_ID) left join (select M_InOut_ID, DocumentNo, MovementDate from M_InOut) table2 on (table1.M_InOut_ID = table2.M_InOut_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (table1.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  WHERE M_InOutLine.M_Inoutline_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);

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
      "        UPDATE snr_minoutline" +
      "        SET M_Inoutline_ID = (?) , SNR_Minoutline_ID = (?) , Serialnumber = (?) , AD_Client_ID = (?) , Isunavailable = (?) , AD_Org_ID = (?) , Lotnumber = (?) , Quantity = TO_NUMBER(?) , Isactive = (?) , Guaranteedays = TO_NUMBER(?) , Rfidnumber = (?) , Guaranteedate = TO_DATE(?) , Description = (?) , updated = now(), updatedby = ? " +
      "        WHERE snr_minoutline.SNR_Minoutline_ID = ? " +
      "                 AND snr_minoutline.M_Inoutline_ID = ? " +
      "        AND snr_minoutline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_minoutline.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMinoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isunavailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lotnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rfidnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMinoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
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
      "        INSERT INTO snr_minoutline " +
      "        (M_Inoutline_ID, SNR_Minoutline_ID, Serialnumber, AD_Client_ID, Isunavailable, AD_Org_ID, Lotnumber, Quantity, Isactive, Guaranteedays, Rfidnumber, Guaranteedate, Description, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_DATE(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMinoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isunavailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lotnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rfidnumber);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String mInoutlineId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM snr_minoutline" +
      "        WHERE snr_minoutline.SNR_Minoutline_ID = ? " +
      "                 AND snr_minoutline.M_Inoutline_ID = ? " +
      "        AND snr_minoutline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_minoutline.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String mInoutlineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM snr_minoutline" +
      "        WHERE snr_minoutline.SNR_Minoutline_ID = ? " +
      "                 AND snr_minoutline.M_Inoutline_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);

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
      "          FROM snr_minoutline" +
      "         WHERE snr_minoutline.SNR_Minoutline_ID = ? ";

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
      "          FROM snr_minoutline" +
      "         WHERE snr_minoutline.SNR_Minoutline_ID = ? ";

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
