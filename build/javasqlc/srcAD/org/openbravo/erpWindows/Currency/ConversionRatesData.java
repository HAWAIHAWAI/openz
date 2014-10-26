//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Currency;

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
class ConversionRatesData implements FieldProvider {
static Logger log4j = Logger.getLogger(ConversionRatesData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cConversionRateId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String cCurrencyIdTo;
  public String cCurrencyIdTor;
  public String isactive;
  public String validfrom;
  public String validto;
  public String multiplyrate;
  public String dividerate;
  public String conversionratetype;
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
    else if (fieldName.equalsIgnoreCase("c_conversion_rate_id") || fieldName.equals("cConversionRateId"))
      return cConversionRateId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("c_currency_id_to") || fieldName.equals("cCurrencyIdTo"))
      return cCurrencyIdTo;
    else if (fieldName.equalsIgnoreCase("c_currency_id_tor") || fieldName.equals("cCurrencyIdTor"))
      return cCurrencyIdTor;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("validfrom"))
      return validfrom;
    else if (fieldName.equalsIgnoreCase("validto"))
      return validto;
    else if (fieldName.equalsIgnoreCase("multiplyrate"))
      return multiplyrate;
    else if (fieldName.equalsIgnoreCase("dividerate"))
      return dividerate;
    else if (fieldName.equalsIgnoreCase("conversionratetype"))
      return conversionratetype;
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
  public static ConversionRatesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String C_Currency_ID, String cCurrencyId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, C_Currency_ID, cCurrencyId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ConversionRatesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String C_Currency_ID, String cCurrencyId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Conversion_Rate.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Conversion_Rate.CreatedBy) as CreatedByR, " +
      "        to_char(C_Conversion_Rate.Updated, ?) as updated, " +
      "        to_char(C_Conversion_Rate.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Conversion_Rate.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Conversion_Rate.UpdatedBy) as UpdatedByR," +
      "        C_Conversion_Rate.C_Conversion_Rate_ID, " +
      "C_Conversion_Rate.AD_Client_ID, " +
      "(CASE WHEN C_Conversion_Rate.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_Conversion_Rate.AD_Org_ID, " +
      "(CASE WHEN C_Conversion_Rate.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Conversion_Rate.C_Currency_ID, " +
      "(CASE WHEN C_Conversion_Rate.C_Currency_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "C_Conversion_Rate.C_Currency_ID_To, " +
      "(CASE WHEN C_Conversion_Rate.C_Currency_ID_To IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.ISO_Code), ''))),'') ) END) AS C_Currency_ID_ToR, " +
      "COALESCE(C_Conversion_Rate.IsActive, 'N') AS IsActive, " +
      "C_Conversion_Rate.ValidFrom, " +
      "C_Conversion_Rate.ValidTo, " +
      "C_Conversion_Rate.MultiplyRate, " +
      "C_Conversion_Rate.DivideRate, " +
      "C_Conversion_Rate.ConversionRateType, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Conversion_Rate left join (select AD_Client_ID, Name from AD_Client) table1 on (C_Conversion_Rate.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_Conversion_Rate.AD_Org_ID = table2.AD_Org_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table3 on (C_Conversion_Rate.C_Currency_ID =  table3.C_Currency_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table4 on (C_Conversion_Rate.C_Currency_ID_To =  table4.C_Currency_ID)" +
      "        WHERE 2=2 " +
      " AND C_Conversion_Rate.C_Currency_ID = ?" +
      "        AND 1=1 ";
    strSql = strSql + ((cCurrencyId==null || cCurrencyId.equals(""))?"":"  AND C_Conversion_Rate.C_Currency_ID = ?  ");
    strSql = strSql + 
      "        AND C_Conversion_Rate.C_Conversion_Rate_ID = ? " +
      "        AND C_Conversion_Rate.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Conversion_Rate.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Currency_ID);
      if (cCurrencyId != null && !(cCurrencyId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
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
        ConversionRatesData objectConversionRatesData = new ConversionRatesData();
        objectConversionRatesData.created = UtilSql.getValue(result, "created");
        objectConversionRatesData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectConversionRatesData.updated = UtilSql.getValue(result, "updated");
        objectConversionRatesData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectConversionRatesData.updatedby = UtilSql.getValue(result, "updatedby");
        objectConversionRatesData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectConversionRatesData.cConversionRateId = UtilSql.getValue(result, "c_conversion_rate_id");
        objectConversionRatesData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectConversionRatesData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectConversionRatesData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectConversionRatesData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectConversionRatesData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectConversionRatesData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectConversionRatesData.cCurrencyIdTo = UtilSql.getValue(result, "c_currency_id_to");
        objectConversionRatesData.cCurrencyIdTor = UtilSql.getValue(result, "c_currency_id_tor");
        objectConversionRatesData.isactive = UtilSql.getValue(result, "isactive");
        objectConversionRatesData.validfrom = UtilSql.getDateValue(result, "validfrom", "dd-MM-yyyy");
        objectConversionRatesData.validto = UtilSql.getDateValue(result, "validto", "dd-MM-yyyy");
        objectConversionRatesData.multiplyrate = UtilSql.getValue(result, "multiplyrate");
        objectConversionRatesData.dividerate = UtilSql.getValue(result, "dividerate");
        objectConversionRatesData.conversionratetype = UtilSql.getValue(result, "conversionratetype");
        objectConversionRatesData.language = UtilSql.getValue(result, "language");
        objectConversionRatesData.adUserClient = "";
        objectConversionRatesData.adOrgClient = "";
        objectConversionRatesData.createdby = "";
        objectConversionRatesData.trBgcolor = "";
        objectConversionRatesData.totalCount = "";
        objectConversionRatesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectConversionRatesData);
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
    ConversionRatesData objectConversionRatesData[] = new ConversionRatesData[vector.size()];
    vector.copyInto(objectConversionRatesData);
    return(objectConversionRatesData);
  }

/**
Create a registry
 */
  public static ConversionRatesData[] set(String cCurrencyId, String adOrgId, String cConversionRateId, String conversionratetype, String validto, String updatedby, String updatedbyr, String cCurrencyIdTo, String validfrom, String adClientId, String isactive, String dividerate, String createdby, String createdbyr, String multiplyrate)    throws ServletException {
    ConversionRatesData objectConversionRatesData[] = new ConversionRatesData[1];
    objectConversionRatesData[0] = new ConversionRatesData();
    objectConversionRatesData[0].created = "";
    objectConversionRatesData[0].createdbyr = createdbyr;
    objectConversionRatesData[0].updated = "";
    objectConversionRatesData[0].updatedTimeStamp = "";
    objectConversionRatesData[0].updatedby = updatedby;
    objectConversionRatesData[0].updatedbyr = updatedbyr;
    objectConversionRatesData[0].cConversionRateId = cConversionRateId;
    objectConversionRatesData[0].adClientId = adClientId;
    objectConversionRatesData[0].adClientIdr = "";
    objectConversionRatesData[0].adOrgId = adOrgId;
    objectConversionRatesData[0].adOrgIdr = "";
    objectConversionRatesData[0].cCurrencyId = cCurrencyId;
    objectConversionRatesData[0].cCurrencyIdr = "";
    objectConversionRatesData[0].cCurrencyIdTo = cCurrencyIdTo;
    objectConversionRatesData[0].cCurrencyIdTor = "";
    objectConversionRatesData[0].isactive = isactive;
    objectConversionRatesData[0].validfrom = validfrom;
    objectConversionRatesData[0].validto = validto;
    objectConversionRatesData[0].multiplyrate = multiplyrate;
    objectConversionRatesData[0].dividerate = dividerate;
    objectConversionRatesData[0].conversionratetype = conversionratetype;
    objectConversionRatesData[0].language = "";
    return objectConversionRatesData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef785_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as UpdatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

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
  public static String selectDef783_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as CreatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

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
      "        SELECT C_Conversion_Rate.C_Currency_ID AS NAME" +
      "        FROM C_Conversion_Rate" +
      "        WHERE C_Conversion_Rate.C_Conversion_Rate_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cCurrencyId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.ISO_Code), ''))) AS NAME FROM C_Currency left join (select C_Currency_ID, ISO_Code from C_Currency) table1 on (C_Currency.C_Currency_ID =  table1.C_Currency_ID) WHERE C_Currency.C_Currency_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cCurrencyId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.ISO_Code), ''))) AS NAME FROM C_Currency left join (select C_Currency_ID, ISO_Code from C_Currency) table1 on (C_Currency.C_Currency_ID =  table1.C_Currency_ID) WHERE C_Currency.C_Currency_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);

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
      "        UPDATE C_Conversion_Rate" +
      "        SET C_Conversion_Rate_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_Currency_ID = (?) , C_Currency_ID_To = (?) , IsActive = (?) , ValidFrom = TO_DATE(?) , ValidTo = TO_DATE(?) , MultiplyRate = TO_NUMBER(?) , DivideRate = TO_NUMBER(?) , ConversionRateType = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Conversion_Rate.C_Conversion_Rate_ID = ? " +
      "                 AND C_Conversion_Rate.C_Currency_ID = ? " +
      "        AND C_Conversion_Rate.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Conversion_Rate.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cConversionRateId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyIdTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, multiplyrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dividerate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, conversionratetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cConversionRateId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
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
      "        INSERT INTO C_Conversion_Rate " +
      "        (C_Conversion_Rate_ID, AD_Client_ID, AD_Org_ID, C_Currency_ID, C_Currency_ID_To, IsActive, ValidFrom, ValidTo, MultiplyRate, DivideRate, ConversionRateType, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cConversionRateId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyIdTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, multiplyrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dividerate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, conversionratetype);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cCurrencyId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Conversion_Rate" +
      "        WHERE C_Conversion_Rate.C_Conversion_Rate_ID = ? " +
      "                 AND C_Conversion_Rate.C_Currency_ID = ? " +
      "        AND C_Conversion_Rate.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Conversion_Rate.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cCurrencyId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Conversion_Rate" +
      "        WHERE C_Conversion_Rate.C_Conversion_Rate_ID = ? " +
      "                 AND C_Conversion_Rate.C_Currency_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);

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
      "          FROM C_Conversion_Rate" +
      "         WHERE C_Conversion_Rate.C_Conversion_Rate_ID = ? ";

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
      "          FROM C_Conversion_Rate" +
      "         WHERE C_Conversion_Rate.C_Conversion_Rate_ID = ? ";

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
