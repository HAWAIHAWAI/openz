//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.CountryRegionandCity;

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
class CountryData implements FieldProvider {
static Logger log4j = Logger.getLogger(CountryData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cCountryId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String countrycode;
  public String name;
  public String description;
  public String isactive;
  public String isdefault;
  public String hasregion;
  public String regionname;
  public String displaysequence;
  public String expressionphone;
  public String haspostalAdd;
  public String expressionpostal;
  public String expressionpostalAdd;
  public String adLanguage;
  public String adLanguager;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String ibancountry;
  public String ibannodigits;
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
    else if (fieldName.equalsIgnoreCase("c_country_id") || fieldName.equals("cCountryId"))
      return cCountryId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("countrycode"))
      return countrycode;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("hasregion"))
      return hasregion;
    else if (fieldName.equalsIgnoreCase("regionname"))
      return regionname;
    else if (fieldName.equalsIgnoreCase("displaysequence"))
      return displaysequence;
    else if (fieldName.equalsIgnoreCase("expressionphone"))
      return expressionphone;
    else if (fieldName.equalsIgnoreCase("haspostal_add") || fieldName.equals("haspostalAdd"))
      return haspostalAdd;
    else if (fieldName.equalsIgnoreCase("expressionpostal"))
      return expressionpostal;
    else if (fieldName.equalsIgnoreCase("expressionpostal_add") || fieldName.equals("expressionpostalAdd"))
      return expressionpostalAdd;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("ibancountry"))
      return ibancountry;
    else if (fieldName.equalsIgnoreCase("ibannodigits"))
      return ibannodigits;
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
  public static CountryData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CountryData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Country.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Country.CreatedBy) as CreatedByR, " +
      "        to_char(C_Country.Updated, ?) as updated, " +
      "        to_char(C_Country.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Country.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Country.UpdatedBy) as UpdatedByR," +
      "        C_Country.C_Country_ID, " +
      "C_Country.AD_Client_ID, " +
      "(CASE WHEN C_Country.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_Country.AD_Org_ID, " +
      "(CASE WHEN C_Country.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Country.CountryCode, " +
      "C_Country.Name, " +
      "C_Country.Description, " +
      "COALESCE(C_Country.IsActive, 'N') AS IsActive, " +
      "COALESCE(C_Country.IsDefault, 'N') AS IsDefault, " +
      "COALESCE(C_Country.HasRegion, 'N') AS HasRegion, " +
      "C_Country.RegionName, " +
      "C_Country.DisplaySequence, " +
      "C_Country.ExpressionPhone, " +
      "COALESCE(C_Country.HasPostal_Add, 'N') AS HasPostal_Add, " +
      "C_Country.ExpressionPostal, " +
      "C_Country.ExpressionPostal_Add, " +
      "C_Country.AD_Language, " +
      "(CASE WHEN C_Country.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "C_Country.C_Currency_ID, " +
      "(CASE WHEN C_Country.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "C_Country.IBANCountry, " +
      "C_Country.IBANNoDigits, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Country left join (select AD_Client_ID, Name from AD_Client) table1 on (C_Country.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_Country.AD_Org_ID = table2.AD_Org_ID) left join (select AD_Language, Name from AD_Language) table3 on (C_Country.AD_Language =  table3.AD_Language) left join (select C_Currency_ID, ISO_Code from C_Currency) table4 on (C_Country.C_Currency_ID = table4.C_Currency_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_Country.C_Country_ID = ? " +
      "        AND C_Country.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Country.AD_Org_ID IN (";
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
        CountryData objectCountryData = new CountryData();
        objectCountryData.created = UtilSql.getValue(result, "created");
        objectCountryData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCountryData.updated = UtilSql.getValue(result, "updated");
        objectCountryData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCountryData.updatedby = UtilSql.getValue(result, "updatedby");
        objectCountryData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCountryData.cCountryId = UtilSql.getValue(result, "c_country_id");
        objectCountryData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCountryData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectCountryData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCountryData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectCountryData.countrycode = UtilSql.getValue(result, "countrycode");
        objectCountryData.name = UtilSql.getValue(result, "name");
        objectCountryData.description = UtilSql.getValue(result, "description");
        objectCountryData.isactive = UtilSql.getValue(result, "isactive");
        objectCountryData.isdefault = UtilSql.getValue(result, "isdefault");
        objectCountryData.hasregion = UtilSql.getValue(result, "hasregion");
        objectCountryData.regionname = UtilSql.getValue(result, "regionname");
        objectCountryData.displaysequence = UtilSql.getValue(result, "displaysequence");
        objectCountryData.expressionphone = UtilSql.getValue(result, "expressionphone");
        objectCountryData.haspostalAdd = UtilSql.getValue(result, "haspostal_add");
        objectCountryData.expressionpostal = UtilSql.getValue(result, "expressionpostal");
        objectCountryData.expressionpostalAdd = UtilSql.getValue(result, "expressionpostal_add");
        objectCountryData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectCountryData.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectCountryData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCountryData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectCountryData.ibancountry = UtilSql.getValue(result, "ibancountry");
        objectCountryData.ibannodigits = UtilSql.getValue(result, "ibannodigits");
        objectCountryData.language = UtilSql.getValue(result, "language");
        objectCountryData.adUserClient = "";
        objectCountryData.adOrgClient = "";
        objectCountryData.createdby = "";
        objectCountryData.trBgcolor = "";
        objectCountryData.totalCount = "";
        objectCountryData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCountryData);
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
    CountryData objectCountryData[] = new CountryData[vector.size()];
    vector.copyInto(objectCountryData);
    return(objectCountryData);
  }

/**
Create a registry
 */
  public static CountryData[] set(String cCurrencyId, String name, String adLanguage, String hasregion, String expressionpostal, String expressionpostalAdd, String countrycode, String expressionphone, String ibannodigits, String description, String updatedby, String updatedbyr, String displaysequence, String ibancountry, String createdby, String createdbyr, String isactive, String adClientId, String isdefault, String cCountryId, String haspostalAdd, String regionname, String adOrgId)    throws ServletException {
    CountryData objectCountryData[] = new CountryData[1];
    objectCountryData[0] = new CountryData();
    objectCountryData[0].created = "";
    objectCountryData[0].createdbyr = createdbyr;
    objectCountryData[0].updated = "";
    objectCountryData[0].updatedTimeStamp = "";
    objectCountryData[0].updatedby = updatedby;
    objectCountryData[0].updatedbyr = updatedbyr;
    objectCountryData[0].cCountryId = cCountryId;
    objectCountryData[0].adClientId = adClientId;
    objectCountryData[0].adClientIdr = "";
    objectCountryData[0].adOrgId = adOrgId;
    objectCountryData[0].adOrgIdr = "";
    objectCountryData[0].countrycode = countrycode;
    objectCountryData[0].name = name;
    objectCountryData[0].description = description;
    objectCountryData[0].isactive = isactive;
    objectCountryData[0].isdefault = isdefault;
    objectCountryData[0].hasregion = hasregion;
    objectCountryData[0].regionname = regionname;
    objectCountryData[0].displaysequence = displaysequence;
    objectCountryData[0].expressionphone = expressionphone;
    objectCountryData[0].haspostalAdd = haspostalAdd;
    objectCountryData[0].expressionpostal = expressionpostal;
    objectCountryData[0].expressionpostalAdd = expressionpostalAdd;
    objectCountryData[0].adLanguage = adLanguage;
    objectCountryData[0].adLanguager = "";
    objectCountryData[0].cCurrencyId = cCurrencyId;
    objectCountryData[0].cCurrencyIdr = "";
    objectCountryData[0].ibancountry = ibancountry;
    objectCountryData[0].ibannodigits = ibannodigits;
    objectCountryData[0].language = "";
    return objectCountryData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef948_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef946_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
      "        UPDATE C_Country" +
      "        SET C_Country_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , CountryCode = (?) , Name = (?) , Description = (?) , IsActive = (?) , IsDefault = (?) , HasRegion = (?) , RegionName = (?) , DisplaySequence = (?) , ExpressionPhone = (?) , HasPostal_Add = (?) , ExpressionPostal = (?) , ExpressionPostal_Add = (?) , AD_Language = (?) , C_Currency_ID = (?) , IBANCountry = (?) , IBANNoDigits = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE C_Country.C_Country_ID = ? " +
      "        AND C_Country.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Country.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, countrycode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hasregion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, regionname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displaysequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expressionphone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, haspostalAdd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expressionpostal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expressionpostalAdd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ibancountry);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ibannodigits);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCountryId);
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
      "        INSERT INTO C_Country " +
      "        (C_Country_ID, AD_Client_ID, AD_Org_ID, CountryCode, Name, Description, IsActive, IsDefault, HasRegion, RegionName, DisplaySequence, ExpressionPhone, HasPostal_Add, ExpressionPostal, ExpressionPostal_Add, AD_Language, C_Currency_ID, IBANCountry, IBANNoDigits, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, countrycode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hasregion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, regionname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displaysequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expressionphone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, haspostalAdd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expressionpostal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expressionpostalAdd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ibancountry);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ibannodigits);
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
      "        DELETE FROM C_Country" +
      "        WHERE C_Country.C_Country_ID = ? " +
      "        AND C_Country.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Country.AD_Org_ID IN (";
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
      "        DELETE FROM C_Country" +
      "        WHERE C_Country.C_Country_ID = ? ";

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
      "          FROM C_Country" +
      "         WHERE C_Country.C_Country_ID = ? ";

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
      "          FROM C_Country" +
      "         WHERE C_Country.C_Country_ID = ? ";

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
