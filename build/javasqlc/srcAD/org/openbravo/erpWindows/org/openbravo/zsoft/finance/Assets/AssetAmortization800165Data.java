//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.finance.Assets;

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
class AssetAmortization800165Data implements FieldProvider {
static Logger log4j = Logger.getLogger(AssetAmortization800165Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String aAmortizationlineId;
  public String adOrgId;
  public String adOrgIdr;
  public String adClientId;
  public String adClientIdr;
  public String isactive;
  public String aAmortizationId;
  public String aAmortizationIdr;
  public String line;
  public String amortizationamt;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String amortizationPercentage;
  public String aAssetId;
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
    else if (fieldName.equalsIgnoreCase("a_amortizationline_id") || fieldName.equals("aAmortizationlineId"))
      return aAmortizationlineId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("a_amortization_id") || fieldName.equals("aAmortizationId"))
      return aAmortizationId;
    else if (fieldName.equalsIgnoreCase("a_amortization_idr") || fieldName.equals("aAmortizationIdr"))
      return aAmortizationIdr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("amortizationamt"))
      return amortizationamt;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("amortization_percentage") || fieldName.equals("amortizationPercentage"))
      return amortizationPercentage;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
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
  public static AssetAmortization800165Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String aAssetId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, aAssetId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static AssetAmortization800165Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String aAssetId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(A_Amortizationline.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = A_Amortizationline.CreatedBy) as CreatedByR, " +
      "        to_char(A_Amortizationline.Updated, ?) as updated, " +
      "        to_char(A_Amortizationline.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        A_Amortizationline.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = A_Amortizationline.UpdatedBy) as UpdatedByR," +
      "        A_Amortizationline.A_Amortizationline_ID, " +
      "A_Amortizationline.AD_Org_ID, " +
      "(CASE WHEN A_Amortizationline.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "A_Amortizationline.AD_Client_ID, " +
      "(CASE WHEN A_Amortizationline.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "COALESCE(A_Amortizationline.IsActive, 'N') AS IsActive, " +
      "A_Amortizationline.A_Amortization_ID, " +
      "(CASE WHEN A_Amortizationline.A_Amortization_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.StartDate, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.EndDate, 'DD-MM-YYYY')),'') ) END) AS A_Amortization_IDR, " +
      "A_Amortizationline.Line, " +
      "A_Amortizationline.Amortizationamt, " +
      "A_Amortizationline.C_Currency_ID, " +
      "(CASE WHEN A_Amortizationline.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "A_Amortizationline.Amortization_Percentage, " +
      "A_Amortizationline.A_Asset_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM A_Amortizationline left join (select AD_Org_ID, Name from AD_Org) table1 on (A_Amortizationline.AD_Org_ID = table1.AD_Org_ID) left join (select AD_Client_ID, Name from AD_Client) table2 on (A_Amortizationline.AD_Client_ID = table2.AD_Client_ID) left join (select A_Amortization_ID, Name, StartDate, EndDate from A_Amortization) table3 on (A_Amortizationline.A_Amortization_ID = table3.A_Amortization_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table4 on (A_Amortizationline.C_Currency_ID = table4.C_Currency_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((aAssetId==null || aAssetId.equals(""))?"":"  AND A_Amortizationline.A_Asset_ID = ?  ");
    strSql = strSql + 
      "        AND A_Amortizationline.A_Amortizationline_ID = ? " +
      "        AND A_Amortizationline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND A_Amortizationline.AD_Org_ID IN (";
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
      if (aAssetId != null && !(aAssetId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
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
        AssetAmortization800165Data objectAssetAmortization800165Data = new AssetAmortization800165Data();
        objectAssetAmortization800165Data.created = UtilSql.getValue(result, "created");
        objectAssetAmortization800165Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectAssetAmortization800165Data.updated = UtilSql.getValue(result, "updated");
        objectAssetAmortization800165Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectAssetAmortization800165Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectAssetAmortization800165Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectAssetAmortization800165Data.aAmortizationlineId = UtilSql.getValue(result, "a_amortizationline_id");
        objectAssetAmortization800165Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAssetAmortization800165Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectAssetAmortization800165Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAssetAmortization800165Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectAssetAmortization800165Data.isactive = UtilSql.getValue(result, "isactive");
        objectAssetAmortization800165Data.aAmortizationId = UtilSql.getValue(result, "a_amortization_id");
        objectAssetAmortization800165Data.aAmortizationIdr = UtilSql.getValue(result, "a_amortization_idr");
        objectAssetAmortization800165Data.line = UtilSql.getValue(result, "line");
        objectAssetAmortization800165Data.amortizationamt = UtilSql.getValue(result, "amortizationamt");
        objectAssetAmortization800165Data.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectAssetAmortization800165Data.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectAssetAmortization800165Data.amortizationPercentage = UtilSql.getValue(result, "amortization_percentage");
        objectAssetAmortization800165Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectAssetAmortization800165Data.language = UtilSql.getValue(result, "language");
        objectAssetAmortization800165Data.adUserClient = "";
        objectAssetAmortization800165Data.adOrgClient = "";
        objectAssetAmortization800165Data.createdby = "";
        objectAssetAmortization800165Data.trBgcolor = "";
        objectAssetAmortization800165Data.totalCount = "";
        objectAssetAmortization800165Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAssetAmortization800165Data);
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
    AssetAmortization800165Data objectAssetAmortization800165Data[] = new AssetAmortization800165Data[vector.size()];
    vector.copyInto(objectAssetAmortization800165Data);
    return(objectAssetAmortization800165Data);
  }

/**
Create a registry
 */
  public static AssetAmortization800165Data[] set(String aAssetId, String amortizationPercentage, String aAmortizationId, String aAmortizationlineId, String adClientId, String isactive, String line, String updatedby, String updatedbyr, String adOrgId, String amortizationamt, String createdby, String createdbyr, String cCurrencyId)    throws ServletException {
    AssetAmortization800165Data objectAssetAmortization800165Data[] = new AssetAmortization800165Data[1];
    objectAssetAmortization800165Data[0] = new AssetAmortization800165Data();
    objectAssetAmortization800165Data[0].created = "";
    objectAssetAmortization800165Data[0].createdbyr = createdbyr;
    objectAssetAmortization800165Data[0].updated = "";
    objectAssetAmortization800165Data[0].updatedTimeStamp = "";
    objectAssetAmortization800165Data[0].updatedby = updatedby;
    objectAssetAmortization800165Data[0].updatedbyr = updatedbyr;
    objectAssetAmortization800165Data[0].aAmortizationlineId = aAmortizationlineId;
    objectAssetAmortization800165Data[0].adOrgId = adOrgId;
    objectAssetAmortization800165Data[0].adOrgIdr = "";
    objectAssetAmortization800165Data[0].adClientId = adClientId;
    objectAssetAmortization800165Data[0].adClientIdr = "";
    objectAssetAmortization800165Data[0].isactive = isactive;
    objectAssetAmortization800165Data[0].aAmortizationId = aAmortizationId;
    objectAssetAmortization800165Data[0].aAmortizationIdr = "";
    objectAssetAmortization800165Data[0].line = line;
    objectAssetAmortization800165Data[0].amortizationamt = amortizationamt;
    objectAssetAmortization800165Data[0].cCurrencyId = cCurrencyId;
    objectAssetAmortization800165Data[0].cCurrencyIdr = "";
    objectAssetAmortization800165Data[0].amortizationPercentage = amortizationPercentage;
    objectAssetAmortization800165Data[0].aAssetId = aAssetId;
    objectAssetAmortization800165Data[0].language = "";
    return objectAssetAmortization800165Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef801099(ConnectionProvider connectionProvider, String A_AMORTIZATION_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(LINE),0)+10 AS DefaultValue FROM A_AMORTIZATIONLINE WHERE A_AMORTIZATION_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, A_AMORTIZATION_ID);

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
  public static String selectDef801097_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef801095_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT A_Amortizationline.A_Asset_ID AS NAME" +
      "        FROM A_Amortizationline" +
      "        WHERE A_Amortizationline.A_Amortizationline_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String aAssetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM A_Asset left join (select A_Asset_ID, Name from A_Asset) table1 on (A_Asset.A_Asset_ID = table1.A_Asset_ID) WHERE A_Asset.A_Asset_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String aAssetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM A_Asset left join (select A_Asset_ID, Name from A_Asset) table1 on (A_Asset.A_Asset_ID = table1.A_Asset_ID) WHERE A_Asset.A_Asset_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);

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
      "        UPDATE A_Amortizationline" +
      "        SET A_Amortizationline_ID = (?) , AD_Org_ID = (?) , AD_Client_ID = (?) , IsActive = (?) , A_Amortization_ID = (?) , Line = TO_NUMBER(?) , Amortizationamt = TO_NUMBER(?) , C_Currency_ID = (?) , Amortization_Percentage = TO_NUMBER(?) , A_Asset_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE A_Amortizationline.A_Amortizationline_ID = ? " +
      "                 AND A_Amortizationline.A_Asset_ID = ? " +
      "        AND A_Amortizationline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND A_Amortizationline.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAmortizationlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAmortizationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationPercentage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAmortizationlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
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
      "        INSERT INTO A_Amortizationline " +
      "        (A_Amortizationline_ID, AD_Org_ID, AD_Client_ID, IsActive, A_Amortization_ID, Line, Amortizationamt, C_Currency_ID, Amortization_Percentage, A_Asset_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAmortizationlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAmortizationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationPercentage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String aAssetId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM A_Amortizationline" +
      "        WHERE A_Amortizationline.A_Amortizationline_ID = ? " +
      "                 AND A_Amortizationline.A_Asset_ID = ? " +
      "        AND A_Amortizationline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND A_Amortizationline.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String aAssetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM A_Amortizationline" +
      "        WHERE A_Amortizationline.A_Amortizationline_ID = ? " +
      "                 AND A_Amortizationline.A_Asset_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);

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
      "          FROM A_Amortizationline" +
      "         WHERE A_Amortizationline.A_Amortizationline_ID = ? ";

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
      "          FROM A_Amortizationline" +
      "         WHERE A_Amortizationline.A_Amortizationline_ID = ? ";

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
