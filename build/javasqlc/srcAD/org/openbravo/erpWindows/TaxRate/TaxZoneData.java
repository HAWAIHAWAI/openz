//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.TaxRate;

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
class TaxZoneData implements FieldProvider {
static Logger log4j = Logger.getLogger(TaxZoneData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cTaxZoneId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cTaxId;
  public String cTaxIdr;
  public String isactive;
  public String fromCountryId;
  public String fromCountryIdr;
  public String toCountryId;
  public String toCountryIdr;
  public String fromRegionId;
  public String fromRegionIdr;
  public String toRegionId;
  public String toRegionIdr;
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
    else if (fieldName.equalsIgnoreCase("c_tax_zone_id") || fieldName.equals("cTaxZoneId"))
      return cTaxZoneId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("c_tax_idr") || fieldName.equals("cTaxIdr"))
      return cTaxIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("from_country_id") || fieldName.equals("fromCountryId"))
      return fromCountryId;
    else if (fieldName.equalsIgnoreCase("from_country_idr") || fieldName.equals("fromCountryIdr"))
      return fromCountryIdr;
    else if (fieldName.equalsIgnoreCase("to_country_id") || fieldName.equals("toCountryId"))
      return toCountryId;
    else if (fieldName.equalsIgnoreCase("to_country_idr") || fieldName.equals("toCountryIdr"))
      return toCountryIdr;
    else if (fieldName.equalsIgnoreCase("from_region_id") || fieldName.equals("fromRegionId"))
      return fromRegionId;
    else if (fieldName.equalsIgnoreCase("from_region_idr") || fieldName.equals("fromRegionIdr"))
      return fromRegionIdr;
    else if (fieldName.equalsIgnoreCase("to_region_id") || fieldName.equals("toRegionId"))
      return toRegionId;
    else if (fieldName.equalsIgnoreCase("to_region_idr") || fieldName.equals("toRegionIdr"))
      return toRegionIdr;
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
  public static TaxZoneData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cTaxId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cTaxId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TaxZoneData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cTaxId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Tax_Zone.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Tax_Zone.CreatedBy) as CreatedByR, " +
      "        to_char(C_Tax_Zone.Updated, ?) as updated, " +
      "        to_char(C_Tax_Zone.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Tax_Zone.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Tax_Zone.UpdatedBy) as UpdatedByR," +
      "        C_Tax_Zone.C_Tax_Zone_ID, " +
      "C_Tax_Zone.AD_Client_ID, " +
      "(CASE WHEN C_Tax_Zone.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_Tax_Zone.AD_Org_ID, " +
      "(CASE WHEN C_Tax_Zone.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Tax_Zone.C_Tax_ID, " +
      "(CASE WHEN C_Tax_Zone.C_Tax_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_Tax_IDR, " +
      "COALESCE(C_Tax_Zone.IsActive, 'N') AS IsActive, " +
      "C_Tax_Zone.From_Country_ID, " +
      "(CASE WHEN C_Tax_Zone.From_Country_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS From_Country_IDR, " +
      "C_Tax_Zone.To_Country_ID, " +
      "(CASE WHEN C_Tax_Zone.To_Country_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS To_Country_IDR, " +
      "C_Tax_Zone.From_Region_ID, " +
      "(CASE WHEN C_Tax_Zone.From_Region_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS From_Region_IDR, " +
      "C_Tax_Zone.To_Region_ID, " +
      "(CASE WHEN C_Tax_Zone.To_Region_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS To_Region_IDR, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Tax_Zone left join (select AD_Client_ID, Name from AD_Client) table1 on (C_Tax_Zone.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_Tax_Zone.AD_Org_ID = table2.AD_Org_ID) left join (select C_Tax_ID, Name from C_Tax) table3 on (C_Tax_Zone.C_Tax_ID = table3.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL3 on (table3.C_Tax_ID = tableTRL3.C_Tax_ID and tableTRL3.AD_Language = ?)  left join (select C_Country_ID, Name from C_Country) table4 on (C_Tax_Zone.From_Country_ID =  table4.C_Country_ID) left join (select C_Country_ID,AD_Language, Name from C_Country_TRL) tableTRL4 on (table4.C_Country_ID = tableTRL4.C_Country_ID and tableTRL4.AD_Language = ?)  left join (select C_Country_ID, Name from C_Country) table5 on (C_Tax_Zone.To_Country_ID =  table5.C_Country_ID) left join (select C_Country_ID,AD_Language, Name from C_Country_TRL) tableTRL5 on (table5.C_Country_ID = tableTRL5.C_Country_ID and tableTRL5.AD_Language = ?)  left join (select C_Region_ID, Name from C_Region) table6 on (C_Tax_Zone.From_Region_ID =  table6.C_Region_ID) left join (select C_Region_ID, Name from C_Region) table7 on (C_Tax_Zone.To_Region_ID =  table7.C_Region_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cTaxId==null || cTaxId.equals(""))?"":"  AND C_Tax_Zone.C_Tax_ID = ?  ");
    strSql = strSql + 
      "        AND C_Tax_Zone.C_Tax_Zone_ID = ? " +
      "        AND C_Tax_Zone.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Tax_Zone.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (cTaxId != null && !(cTaxId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
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
        TaxZoneData objectTaxZoneData = new TaxZoneData();
        objectTaxZoneData.created = UtilSql.getValue(result, "created");
        objectTaxZoneData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTaxZoneData.updated = UtilSql.getValue(result, "updated");
        objectTaxZoneData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTaxZoneData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTaxZoneData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTaxZoneData.cTaxZoneId = UtilSql.getValue(result, "c_tax_zone_id");
        objectTaxZoneData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTaxZoneData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectTaxZoneData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTaxZoneData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectTaxZoneData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectTaxZoneData.cTaxIdr = UtilSql.getValue(result, "c_tax_idr");
        objectTaxZoneData.isactive = UtilSql.getValue(result, "isactive");
        objectTaxZoneData.fromCountryId = UtilSql.getValue(result, "from_country_id");
        objectTaxZoneData.fromCountryIdr = UtilSql.getValue(result, "from_country_idr");
        objectTaxZoneData.toCountryId = UtilSql.getValue(result, "to_country_id");
        objectTaxZoneData.toCountryIdr = UtilSql.getValue(result, "to_country_idr");
        objectTaxZoneData.fromRegionId = UtilSql.getValue(result, "from_region_id");
        objectTaxZoneData.fromRegionIdr = UtilSql.getValue(result, "from_region_idr");
        objectTaxZoneData.toRegionId = UtilSql.getValue(result, "to_region_id");
        objectTaxZoneData.toRegionIdr = UtilSql.getValue(result, "to_region_idr");
        objectTaxZoneData.language = UtilSql.getValue(result, "language");
        objectTaxZoneData.adUserClient = "";
        objectTaxZoneData.adOrgClient = "";
        objectTaxZoneData.createdby = "";
        objectTaxZoneData.trBgcolor = "";
        objectTaxZoneData.totalCount = "";
        objectTaxZoneData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTaxZoneData);
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
    TaxZoneData objectTaxZoneData[] = new TaxZoneData[vector.size()];
    vector.copyInto(objectTaxZoneData);
    return(objectTaxZoneData);
  }

/**
Create a registry
 */
  public static TaxZoneData[] set(String cTaxId, String toRegionId, String fromCountryId, String cTaxZoneId, String createdby, String createdbyr, String updatedby, String updatedbyr, String isactive, String toCountryId, String adOrgId, String adClientId, String fromRegionId)    throws ServletException {
    TaxZoneData objectTaxZoneData[] = new TaxZoneData[1];
    objectTaxZoneData[0] = new TaxZoneData();
    objectTaxZoneData[0].created = "";
    objectTaxZoneData[0].createdbyr = createdbyr;
    objectTaxZoneData[0].updated = "";
    objectTaxZoneData[0].updatedTimeStamp = "";
    objectTaxZoneData[0].updatedby = updatedby;
    objectTaxZoneData[0].updatedbyr = updatedbyr;
    objectTaxZoneData[0].cTaxZoneId = cTaxZoneId;
    objectTaxZoneData[0].adClientId = adClientId;
    objectTaxZoneData[0].adClientIdr = "";
    objectTaxZoneData[0].adOrgId = adOrgId;
    objectTaxZoneData[0].adOrgIdr = "";
    objectTaxZoneData[0].cTaxId = cTaxId;
    objectTaxZoneData[0].cTaxIdr = "";
    objectTaxZoneData[0].isactive = isactive;
    objectTaxZoneData[0].fromCountryId = fromCountryId;
    objectTaxZoneData[0].fromCountryIdr = "";
    objectTaxZoneData[0].toCountryId = toCountryId;
    objectTaxZoneData[0].toCountryIdr = "";
    objectTaxZoneData[0].fromRegionId = fromRegionId;
    objectTaxZoneData[0].fromRegionIdr = "";
    objectTaxZoneData[0].toRegionId = toRegionId;
    objectTaxZoneData[0].toRegionIdr = "";
    objectTaxZoneData[0].language = "";
    return objectTaxZoneData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef802474_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDef802476_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_Tax_Zone.C_Tax_ID AS NAME" +
      "        FROM C_Tax_Zone" +
      "        WHERE C_Tax_Zone.C_Tax_Zone_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String cTaxId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_Tax left join (select C_Tax_ID, Name from C_Tax) table1 on (C_Tax.C_Tax_ID = table1.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL1 on (table1.C_Tax_ID = tableTRL1.C_Tax_ID and tableTRL1.AD_Language = ?)  WHERE C_Tax.C_Tax_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String cTaxId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_Tax left join (select C_Tax_ID, Name from C_Tax) table1 on (C_Tax.C_Tax_ID = table1.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL1 on (table1.C_Tax_ID = tableTRL1.C_Tax_ID and tableTRL1.AD_Language = ?)  WHERE C_Tax.C_Tax_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);

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
      "        UPDATE C_Tax_Zone" +
      "        SET C_Tax_Zone_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_Tax_ID = (?) , IsActive = (?) , From_Country_ID = (?) , To_Country_ID = (?) , From_Region_ID = (?) , To_Region_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Tax_Zone.C_Tax_Zone_ID = ? " +
      "                 AND C_Tax_Zone.C_Tax_ID = ? " +
      "        AND C_Tax_Zone.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Tax_Zone.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxZoneId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fromCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, toCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fromRegionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, toRegionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxZoneId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
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
      "        INSERT INTO C_Tax_Zone " +
      "        (C_Tax_Zone_ID, AD_Client_ID, AD_Org_ID, C_Tax_ID, IsActive, From_Country_ID, To_Country_ID, From_Region_ID, To_Region_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxZoneId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fromCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, toCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fromRegionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, toRegionId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cTaxId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Tax_Zone" +
      "        WHERE C_Tax_Zone.C_Tax_Zone_ID = ? " +
      "                 AND C_Tax_Zone.C_Tax_ID = ? " +
      "        AND C_Tax_Zone.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Tax_Zone.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cTaxId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Tax_Zone" +
      "        WHERE C_Tax_Zone.C_Tax_Zone_ID = ? " +
      "                 AND C_Tax_Zone.C_Tax_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);

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
      "          FROM C_Tax_Zone" +
      "         WHERE C_Tax_Zone.C_Tax_Zone_ID = ? ";

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
      "          FROM C_Tax_Zone" +
      "         WHERE C_Tax_Zone.C_Tax_Zone_ID = ? ";

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
