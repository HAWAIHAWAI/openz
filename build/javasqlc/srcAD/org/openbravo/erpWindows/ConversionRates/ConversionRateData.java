//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ConversionRates;

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
class ConversionRateData implements FieldProvider {
static Logger log4j = Logger.getLogger(ConversionRateData.class);
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
  public static ConversionRateData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ConversionRateData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
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
      "        AND 1=1 " +
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
        ConversionRateData objectConversionRateData = new ConversionRateData();
        objectConversionRateData.created = UtilSql.getValue(result, "created");
        objectConversionRateData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectConversionRateData.updated = UtilSql.getValue(result, "updated");
        objectConversionRateData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectConversionRateData.updatedby = UtilSql.getValue(result, "updatedby");
        objectConversionRateData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectConversionRateData.cConversionRateId = UtilSql.getValue(result, "c_conversion_rate_id");
        objectConversionRateData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectConversionRateData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectConversionRateData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectConversionRateData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectConversionRateData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectConversionRateData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectConversionRateData.cCurrencyIdTo = UtilSql.getValue(result, "c_currency_id_to");
        objectConversionRateData.cCurrencyIdTor = UtilSql.getValue(result, "c_currency_id_tor");
        objectConversionRateData.isactive = UtilSql.getValue(result, "isactive");
        objectConversionRateData.validfrom = UtilSql.getDateValue(result, "validfrom", "dd-MM-yyyy");
        objectConversionRateData.validto = UtilSql.getDateValue(result, "validto", "dd-MM-yyyy");
        objectConversionRateData.multiplyrate = UtilSql.getValue(result, "multiplyrate");
        objectConversionRateData.dividerate = UtilSql.getValue(result, "dividerate");
        objectConversionRateData.conversionratetype = UtilSql.getValue(result, "conversionratetype");
        objectConversionRateData.language = UtilSql.getValue(result, "language");
        objectConversionRateData.adUserClient = "";
        objectConversionRateData.adOrgClient = "";
        objectConversionRateData.createdby = "";
        objectConversionRateData.trBgcolor = "";
        objectConversionRateData.totalCount = "";
        objectConversionRateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectConversionRateData);
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
    ConversionRateData objectConversionRateData[] = new ConversionRateData[vector.size()];
    vector.copyInto(objectConversionRateData);
    return(objectConversionRateData);
  }

/**
Create a registry
 */
  public static ConversionRateData[] set(String cConversionRateId, String adOrgId, String validto, String conversionratetype, String updatedby, String updatedbyr, String cCurrencyId, String cCurrencyIdTo, String validfrom, String adClientId, String isactive, String dividerate, String createdby, String createdbyr, String multiplyrate)    throws ServletException {
    ConversionRateData objectConversionRateData[] = new ConversionRateData[1];
    objectConversionRateData[0] = new ConversionRateData();
    objectConversionRateData[0].created = "";
    objectConversionRateData[0].createdbyr = createdbyr;
    objectConversionRateData[0].updated = "";
    objectConversionRateData[0].updatedTimeStamp = "";
    objectConversionRateData[0].updatedby = updatedby;
    objectConversionRateData[0].updatedbyr = updatedbyr;
    objectConversionRateData[0].cConversionRateId = cConversionRateId;
    objectConversionRateData[0].adClientId = adClientId;
    objectConversionRateData[0].adClientIdr = "";
    objectConversionRateData[0].adOrgId = adOrgId;
    objectConversionRateData[0].adOrgIdr = "";
    objectConversionRateData[0].cCurrencyId = cCurrencyId;
    objectConversionRateData[0].cCurrencyIdr = "";
    objectConversionRateData[0].cCurrencyIdTo = cCurrencyIdTo;
    objectConversionRateData[0].cCurrencyIdTor = "";
    objectConversionRateData[0].isactive = isactive;
    objectConversionRateData[0].validfrom = validfrom;
    objectConversionRateData[0].validto = validto;
    objectConversionRateData[0].multiplyrate = multiplyrate;
    objectConversionRateData[0].dividerate = dividerate;
    objectConversionRateData[0].conversionratetype = conversionratetype;
    objectConversionRateData[0].language = "";
    return objectConversionRateData;
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_Conversion_Rate" +
      "        SET C_Conversion_Rate_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_Currency_ID = (?) , C_Currency_ID_To = (?) , IsActive = (?) , ValidFrom = TO_DATE(?) , ValidTo = TO_DATE(?) , MultiplyRate = TO_NUMBER(?) , DivideRate = TO_NUMBER(?) , ConversionRateType = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Conversion_Rate.C_Conversion_Rate_ID = ? " +
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Conversion_Rate" +
      "        WHERE C_Conversion_Rate.C_Conversion_Rate_ID = ? " +
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
      "        DELETE FROM C_Conversion_Rate" +
      "        WHERE C_Conversion_Rate.C_Conversion_Rate_ID = ? ";

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
