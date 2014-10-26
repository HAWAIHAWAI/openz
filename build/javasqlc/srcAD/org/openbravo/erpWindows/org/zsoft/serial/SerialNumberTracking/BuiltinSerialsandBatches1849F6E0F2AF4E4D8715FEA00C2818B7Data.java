//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.zsoft.serial.SerialNumberTracking;

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
class BuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data implements FieldProvider {
static Logger log4j = Logger.getLogger(BuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String snrCurrentbomSerialsId;
  public String snrCurrentbomVId;
  public String snrCurrentbomVIdr;
  public String snrMasterdataId;
  public String snrMasterdataIdr;
  public String snrBatchmasterdataId;
  public String snrBatchmasterdataIdr;
  public String qty;
  public String adClientId;
  public String adOrgId;
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
    else if (fieldName.equalsIgnoreCase("snr_currentbom_serials_id") || fieldName.equals("snrCurrentbomSerialsId"))
      return snrCurrentbomSerialsId;
    else if (fieldName.equalsIgnoreCase("snr_currentbom_v_id") || fieldName.equals("snrCurrentbomVId"))
      return snrCurrentbomVId;
    else if (fieldName.equalsIgnoreCase("snr_currentbom_v_idr") || fieldName.equals("snrCurrentbomVIdr"))
      return snrCurrentbomVIdr;
    else if (fieldName.equalsIgnoreCase("snr_masterdata_id") || fieldName.equals("snrMasterdataId"))
      return snrMasterdataId;
    else if (fieldName.equalsIgnoreCase("snr_masterdata_idr") || fieldName.equals("snrMasterdataIdr"))
      return snrMasterdataIdr;
    else if (fieldName.equalsIgnoreCase("snr_batchmasterdata_id") || fieldName.equals("snrBatchmasterdataId"))
      return snrBatchmasterdataId;
    else if (fieldName.equalsIgnoreCase("snr_batchmasterdata_idr") || fieldName.equals("snrBatchmasterdataIdr"))
      return snrBatchmasterdataIdr;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
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
  public static BuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String snrCurrentbomVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, snrCurrentbomVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static BuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String snrCurrentbomVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(snr_currentbom_serials.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_currentbom_serials.CreatedBy) as CreatedByR, " +
      "        to_char(snr_currentbom_serials.Updated, ?) as updated, " +
      "        to_char(snr_currentbom_serials.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        snr_currentbom_serials.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_currentbom_serials.UpdatedBy) as UpdatedByR," +
      "        snr_currentbom_serials.SNR_Currentbom_Serials_ID, " +
      "snr_currentbom_serials.SNR_Currentbom_V_ID, " +
      "(CASE WHEN snr_currentbom_serials.SNR_Currentbom_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Serialnumber), ''))),'') ) END) AS SNR_Currentbom_V_IDR, " +
      "snr_currentbom_serials.SNR_Masterdata_ID, " +
      "(CASE WHEN snr_currentbom_serials.SNR_Masterdata_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Serialnumber), ''))),'') ) END) AS SNR_Masterdata_IDR, " +
      "snr_currentbom_serials.SNR_Batchmasterdata_ID, " +
      "(CASE WHEN snr_currentbom_serials.SNR_Batchmasterdata_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Batchnumber), ''))),'') ) END) AS SNR_Batchmasterdata_IDR, " +
      "snr_currentbom_serials.Qty, " +
      "snr_currentbom_serials.AD_Client_ID, " +
      "snr_currentbom_serials.AD_Org_ID, " +
      "COALESCE(snr_currentbom_serials.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM snr_currentbom_serials left join (select SNR_Currentbom_V_ID, SNR_Masterdata_ID from SNR_Currentbom_V) table1 on (snr_currentbom_serials.SNR_Currentbom_V_ID = table1.SNR_Currentbom_V_ID) left join (select SNR_Masterdata_ID, M_Product_ID, Serialnumber from SNR_Masterdata) table2 on (table1.SNR_Masterdata_ID = table2.SNR_Masterdata_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (table2.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  left join (select SNR_Masterdata_ID, M_Product_ID, Serialnumber from SNR_Masterdata) table4 on (snr_currentbom_serials.SNR_Masterdata_ID = table4.SNR_Masterdata_ID) left join (select M_Product_ID, Value, Name from M_Product) table5 on (table4.M_Product_ID = table5.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL5 on (table5.M_Product_ID = tableTRL5.M_Product_ID and tableTRL5.AD_Language = ?)  left join (select SNR_Batchmasterdata_ID, Batchnumber from SNR_Batchmasterdata) table6 on (snr_currentbom_serials.SNR_Batchmasterdata_ID = table6.SNR_Batchmasterdata_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((snrCurrentbomVId==null || snrCurrentbomVId.equals(""))?"":"  AND snr_currentbom_serials.SNR_Currentbom_V_ID = ?  ");
    strSql = strSql + 
      "        AND snr_currentbom_serials.SNR_Currentbom_Serials_ID = ? " +
      "        AND snr_currentbom_serials.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND snr_currentbom_serials.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (snrCurrentbomVId != null && !(snrCurrentbomVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrCurrentbomVId);
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
        BuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data = new BuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data();
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.created = UtilSql.getValue(result, "created");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.updated = UtilSql.getValue(result, "updated");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.snrCurrentbomSerialsId = UtilSql.getValue(result, "snr_currentbom_serials_id");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.snrCurrentbomVId = UtilSql.getValue(result, "snr_currentbom_v_id");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.snrCurrentbomVIdr = UtilSql.getValue(result, "snr_currentbom_v_idr");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.snrMasterdataId = UtilSql.getValue(result, "snr_masterdata_id");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.snrMasterdataIdr = UtilSql.getValue(result, "snr_masterdata_idr");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.snrBatchmasterdataId = UtilSql.getValue(result, "snr_batchmasterdata_id");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.snrBatchmasterdataIdr = UtilSql.getValue(result, "snr_batchmasterdata_idr");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.qty = UtilSql.getValue(result, "qty");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.isactive = UtilSql.getValue(result, "isactive");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.language = UtilSql.getValue(result, "language");
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.adUserClient = "";
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.adOrgClient = "";
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.createdby = "";
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.trBgcolor = "";
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.totalCount = "";
        objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data);
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
    BuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[] = new BuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[vector.size()];
    vector.copyInto(objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data);
    return(objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data);
  }

/**
Create a registry
 */
  public static BuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[] set(String snrCurrentbomVId, String snrMasterdataId, String snrBatchmasterdataId, String adClientId, String qty, String updatedby, String updatedbyr, String adOrgId, String snrCurrentbomSerialsId, String isactive, String createdby, String createdbyr)    throws ServletException {
    BuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[] = new BuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[1];
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0] = new BuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data();
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].created = "";
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].createdbyr = createdbyr;
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].updated = "";
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].updatedTimeStamp = "";
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].updatedby = updatedby;
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].updatedbyr = updatedbyr;
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].snrCurrentbomSerialsId = snrCurrentbomSerialsId;
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].snrCurrentbomVId = snrCurrentbomVId;
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].snrCurrentbomVIdr = "";
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].snrMasterdataId = snrMasterdataId;
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].snrMasterdataIdr = "";
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].snrBatchmasterdataId = snrBatchmasterdataId;
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].snrBatchmasterdataIdr = "";
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].qty = qty;
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].adClientId = adClientId;
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].adOrgId = adOrgId;
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].isactive = isactive;
    objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data[0].language = "";
    return objectBuiltinSerialsandBatches1849F6E0F2AF4E4D8715FEA00C2818B7Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1D3913B97905472197D90F1D4E5F2EF3_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef9C3B9312A531473B9B52CA1B65E69C2C_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT snr_currentbom_serials.SNR_Currentbom_V_ID AS NAME" +
      "        FROM snr_currentbom_serials" +
      "        WHERE snr_currentbom_serials.SNR_Currentbom_Serials_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String snrCurrentbomVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table3.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Serialnumber), ''))) AS NAME FROM snr_currentbom_v left join (select SNR_Currentbom_V_ID, SNR_Masterdata_ID from SNR_Currentbom_V) table1 on (snr_currentbom_v.SNR_Currentbom_V_ID = table1.SNR_Currentbom_V_ID) left join (select SNR_Masterdata_ID, M_Product_ID, Serialnumber from SNR_Masterdata) table2 on (table1.SNR_Masterdata_ID = table2.SNR_Masterdata_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (table2.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  WHERE snr_currentbom_v.SNR_Currentbom_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrCurrentbomVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String snrCurrentbomVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table3.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Serialnumber), ''))) AS NAME FROM snr_currentbom_v left join (select SNR_Currentbom_V_ID, SNR_Masterdata_ID from SNR_Currentbom_V) table1 on (snr_currentbom_v.SNR_Currentbom_V_ID = table1.SNR_Currentbom_V_ID) left join (select SNR_Masterdata_ID, M_Product_ID, Serialnumber from SNR_Masterdata) table2 on (table1.SNR_Masterdata_ID = table2.SNR_Masterdata_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (table2.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  WHERE snr_currentbom_v.SNR_Currentbom_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrCurrentbomVId);

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
      "        UPDATE snr_currentbom_serials" +
      "        SET SNR_Currentbom_Serials_ID = (?) , SNR_Currentbom_V_ID = (?) , SNR_Masterdata_ID = (?) , SNR_Batchmasterdata_ID = (?) , Qty = TO_NUMBER(?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE snr_currentbom_serials.SNR_Currentbom_Serials_ID = ? " +
      "                 AND snr_currentbom_serials.SNR_Currentbom_V_ID = ? " +
      "        AND snr_currentbom_serials.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_currentbom_serials.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrCurrentbomSerialsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrCurrentbomVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchmasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrCurrentbomSerialsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrCurrentbomVId);
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
      "        INSERT INTO snr_currentbom_serials " +
      "        (SNR_Currentbom_Serials_ID, SNR_Currentbom_V_ID, SNR_Masterdata_ID, SNR_Batchmasterdata_ID, Qty, AD_Client_ID, AD_Org_ID, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrCurrentbomSerialsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrCurrentbomVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchmasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String snrCurrentbomVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM snr_currentbom_serials" +
      "        WHERE snr_currentbom_serials.SNR_Currentbom_Serials_ID = ? " +
      "                 AND snr_currentbom_serials.SNR_Currentbom_V_ID = ? " +
      "        AND snr_currentbom_serials.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_currentbom_serials.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrCurrentbomVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String snrCurrentbomVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM snr_currentbom_serials" +
      "        WHERE snr_currentbom_serials.SNR_Currentbom_Serials_ID = ? " +
      "                 AND snr_currentbom_serials.SNR_Currentbom_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrCurrentbomVId);

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
      "          FROM snr_currentbom_serials" +
      "         WHERE snr_currentbom_serials.SNR_Currentbom_Serials_ID = ? ";

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
      "          FROM snr_currentbom_serials" +
      "         WHERE snr_currentbom_serials.SNR_Currentbom_Serials_ID = ? ";

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
