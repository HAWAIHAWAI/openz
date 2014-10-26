//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.BusinessPartner;

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
class LocationAddressData implements FieldProvider {
static Logger log4j = Logger.getLogger(LocationAddressData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String name;
  public String deviantBpName;
  public String isactive;
  public String cLocationId;
  public String cLocationIdr;
  public String phone;
  public String phone2;
  public String fax;
  public String isshipto;
  public String isbillto;
  public String ispayfrom;
  public String isremitto;
  public String istaxlocation;
  public String isheadquarter;
  public String uidnumber;
  public String eoriidentification;
  public String cTaxId;
  public String cTaxIdr;
  public String cSalesregionId;
  public String cSalesregionIdr;
  public String upc;
  public String adOrgId;
  public String cBpartnerLocationId;
  public String adClientId;
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
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("deviant_bp_name") || fieldName.equals("deviantBpName"))
      return deviantBpName;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_location_id") || fieldName.equals("cLocationId"))
      return cLocationId;
    else if (fieldName.equalsIgnoreCase("c_location_idr") || fieldName.equals("cLocationIdr"))
      return cLocationIdr;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("phone2"))
      return phone2;
    else if (fieldName.equalsIgnoreCase("fax"))
      return fax;
    else if (fieldName.equalsIgnoreCase("isshipto"))
      return isshipto;
    else if (fieldName.equalsIgnoreCase("isbillto"))
      return isbillto;
    else if (fieldName.equalsIgnoreCase("ispayfrom"))
      return ispayfrom;
    else if (fieldName.equalsIgnoreCase("isremitto"))
      return isremitto;
    else if (fieldName.equalsIgnoreCase("istaxlocation"))
      return istaxlocation;
    else if (fieldName.equalsIgnoreCase("isheadquarter"))
      return isheadquarter;
    else if (fieldName.equalsIgnoreCase("uidnumber"))
      return uidnumber;
    else if (fieldName.equalsIgnoreCase("eoriidentification"))
      return eoriidentification;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("c_tax_idr") || fieldName.equals("cTaxIdr"))
      return cTaxIdr;
    else if (fieldName.equalsIgnoreCase("c_salesregion_id") || fieldName.equals("cSalesregionId"))
      return cSalesregionId;
    else if (fieldName.equalsIgnoreCase("c_salesregion_idr") || fieldName.equals("cSalesregionIdr"))
      return cSalesregionIdr;
    else if (fieldName.equalsIgnoreCase("upc"))
      return upc;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
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
  public static LocationAddressData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cBpartnerId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static LocationAddressData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_BPartner_Location.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_BPartner_Location.CreatedBy) as CreatedByR, " +
      "        to_char(C_BPartner_Location.Updated, ?) as updated, " +
      "        to_char(C_BPartner_Location.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_BPartner_Location.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_BPartner_Location.UpdatedBy) as UpdatedByR," +
      "        C_BPartner_Location.C_BPartner_ID, " +
      "(CASE WHEN C_BPartner_Location.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "C_BPartner_Location.Name, " +
      "C_BPartner_Location.Deviant_Bp_Name, " +
      "COALESCE(C_BPartner_Location.IsActive, 'N') AS IsActive, " +
      "C_BPartner_Location.C_Location_ID, " +
      "(CASE WHEN C_BPartner_Location.C_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Address1), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Address2), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Postal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.City), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_Location_IDR, " +
      "C_BPartner_Location.Phone, " +
      "C_BPartner_Location.Phone2, " +
      "C_BPartner_Location.Fax, " +
      "COALESCE(C_BPartner_Location.IsShipTo, 'N') AS IsShipTo, " +
      "COALESCE(C_BPartner_Location.IsBillTo, 'N') AS IsBillTo, " +
      "COALESCE(C_BPartner_Location.IsPayFrom, 'N') AS IsPayFrom, " +
      "COALESCE(C_BPartner_Location.IsRemitTo, 'N') AS IsRemitTo, " +
      "COALESCE(C_BPartner_Location.IsTaxLocation, 'N') AS IsTaxLocation, " +
      "COALESCE(C_BPartner_Location.Isheadquarter, 'N') AS Isheadquarter, " +
      "C_BPartner_Location.Uidnumber, " +
      "C_BPartner_Location.Eoriidentification, " +
      "C_BPartner_Location.C_Tax_ID, " +
      "(CASE WHEN C_BPartner_Location.C_Tax_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS C_Tax_IDR, " +
      "C_BPartner_Location.C_SalesRegion_ID, " +
      "(CASE WHEN C_BPartner_Location.C_SalesRegion_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_SalesRegion_IDR, " +
      "C_BPartner_Location.UPC, " +
      "C_BPartner_Location.AD_Org_ID, " +
      "C_BPartner_Location.C_BPartner_Location_ID, " +
      "C_BPartner_Location.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_BPartner_Location left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BPartner_Location.C_BPartner_ID = table1.C_BPartner_ID) left join (select C_Location_ID, Address1, Address2, Postal, City, C_Region_ID, C_Country_ID from C_Location) table2 on (C_BPartner_Location.C_Location_ID = table2.C_Location_ID) left join (select C_Region_ID, Name from C_Region) table3 on (table2.C_Region_ID = table3.C_Region_ID) left join (select C_Country_ID, Name from C_Country) table4 on (table2.C_Country_ID = table4.C_Country_ID) left join (select C_Country_ID,AD_Language, Name from C_Country_TRL) tableTRL4 on (table4.C_Country_ID = tableTRL4.C_Country_ID and tableTRL4.AD_Language = ?)  left join (select C_Tax_ID, Name from C_Tax) table5 on (C_BPartner_Location.C_Tax_ID = table5.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL5 on (table5.C_Tax_ID = tableTRL5.C_Tax_ID and tableTRL5.AD_Language = ?)  left join (select C_SalesRegion_ID, Name from C_SalesRegion) table6 on (C_BPartner_Location.C_SalesRegion_ID = table6.C_SalesRegion_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BPartner_Location.C_BPartner_ID = ?  ");
    strSql = strSql + 
      "        AND C_BPartner_Location.C_BPartner_Location_ID = ? " +
      "        AND C_BPartner_Location.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_BPartner_Location.AD_Org_ID IN (";
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
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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
        LocationAddressData objectLocationAddressData = new LocationAddressData();
        objectLocationAddressData.created = UtilSql.getValue(result, "created");
        objectLocationAddressData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectLocationAddressData.updated = UtilSql.getValue(result, "updated");
        objectLocationAddressData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectLocationAddressData.updatedby = UtilSql.getValue(result, "updatedby");
        objectLocationAddressData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectLocationAddressData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectLocationAddressData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectLocationAddressData.name = UtilSql.getValue(result, "name");
        objectLocationAddressData.deviantBpName = UtilSql.getValue(result, "deviant_bp_name");
        objectLocationAddressData.isactive = UtilSql.getValue(result, "isactive");
        objectLocationAddressData.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectLocationAddressData.cLocationIdr = UtilSql.getValue(result, "c_location_idr");
        objectLocationAddressData.phone = UtilSql.getValue(result, "phone");
        objectLocationAddressData.phone2 = UtilSql.getValue(result, "phone2");
        objectLocationAddressData.fax = UtilSql.getValue(result, "fax");
        objectLocationAddressData.isshipto = UtilSql.getValue(result, "isshipto");
        objectLocationAddressData.isbillto = UtilSql.getValue(result, "isbillto");
        objectLocationAddressData.ispayfrom = UtilSql.getValue(result, "ispayfrom");
        objectLocationAddressData.isremitto = UtilSql.getValue(result, "isremitto");
        objectLocationAddressData.istaxlocation = UtilSql.getValue(result, "istaxlocation");
        objectLocationAddressData.isheadquarter = UtilSql.getValue(result, "isheadquarter");
        objectLocationAddressData.uidnumber = UtilSql.getValue(result, "uidnumber");
        objectLocationAddressData.eoriidentification = UtilSql.getValue(result, "eoriidentification");
        objectLocationAddressData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectLocationAddressData.cTaxIdr = UtilSql.getValue(result, "c_tax_idr");
        objectLocationAddressData.cSalesregionId = UtilSql.getValue(result, "c_salesregion_id");
        objectLocationAddressData.cSalesregionIdr = UtilSql.getValue(result, "c_salesregion_idr");
        objectLocationAddressData.upc = UtilSql.getValue(result, "upc");
        objectLocationAddressData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectLocationAddressData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectLocationAddressData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectLocationAddressData.language = UtilSql.getValue(result, "language");
        objectLocationAddressData.adUserClient = "";
        objectLocationAddressData.adOrgClient = "";
        objectLocationAddressData.createdby = "";
        objectLocationAddressData.trBgcolor = "";
        objectLocationAddressData.totalCount = "";
        objectLocationAddressData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLocationAddressData);
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
    LocationAddressData objectLocationAddressData[] = new LocationAddressData[vector.size()];
    vector.copyInto(objectLocationAddressData);
    return(objectLocationAddressData);
  }

/**
Create a registry
 */
  public static LocationAddressData[] set(String cBpartnerId, String cBpartnerIdr, String isactive, String istaxlocation, String adOrgId, String phone2, String upc, String isbillto, String ispayfrom, String deviantBpName, String adClientId, String fax, String isremitto, String name, String uidnumber, String cLocationId, String cLocationIdr, String phone, String eoriidentification, String cTaxId, String isheadquarter, String createdby, String createdbyr, String cSalesregionId, String isshipto, String updatedby, String updatedbyr, String cBpartnerLocationId)    throws ServletException {
    LocationAddressData objectLocationAddressData[] = new LocationAddressData[1];
    objectLocationAddressData[0] = new LocationAddressData();
    objectLocationAddressData[0].created = "";
    objectLocationAddressData[0].createdbyr = createdbyr;
    objectLocationAddressData[0].updated = "";
    objectLocationAddressData[0].updatedTimeStamp = "";
    objectLocationAddressData[0].updatedby = updatedby;
    objectLocationAddressData[0].updatedbyr = updatedbyr;
    objectLocationAddressData[0].cBpartnerId = cBpartnerId;
    objectLocationAddressData[0].cBpartnerIdr = cBpartnerIdr;
    objectLocationAddressData[0].name = name;
    objectLocationAddressData[0].deviantBpName = deviantBpName;
    objectLocationAddressData[0].isactive = isactive;
    objectLocationAddressData[0].cLocationId = cLocationId;
    objectLocationAddressData[0].cLocationIdr = cLocationIdr;
    objectLocationAddressData[0].phone = phone;
    objectLocationAddressData[0].phone2 = phone2;
    objectLocationAddressData[0].fax = fax;
    objectLocationAddressData[0].isshipto = isshipto;
    objectLocationAddressData[0].isbillto = isbillto;
    objectLocationAddressData[0].ispayfrom = ispayfrom;
    objectLocationAddressData[0].isremitto = isremitto;
    objectLocationAddressData[0].istaxlocation = istaxlocation;
    objectLocationAddressData[0].isheadquarter = isheadquarter;
    objectLocationAddressData[0].uidnumber = uidnumber;
    objectLocationAddressData[0].eoriidentification = eoriidentification;
    objectLocationAddressData[0].cTaxId = cTaxId;
    objectLocationAddressData[0].cTaxIdr = "";
    objectLocationAddressData[0].cSalesregionId = cSalesregionId;
    objectLocationAddressData[0].cSalesregionIdr = "";
    objectLocationAddressData[0].upc = upc;
    objectLocationAddressData[0].adOrgId = adOrgId;
    objectLocationAddressData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectLocationAddressData[0].adClientId = adClientId;
    objectLocationAddressData[0].language = "";
    return objectLocationAddressData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2958_0(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_BPartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_bpartner_id");
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
  public static String selectDef2959_1(ConnectionProvider connectionProvider, String C_Location_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Address1), '')  || ' - ' || COALESCE(TO_CHAR(table1.Address2), '')  || ' - ' || COALESCE(TO_CHAR(table1.Postal), '')  || ' - ' || COALESCE(TO_CHAR(table1.City), '')  || ' - ' || COALESCE(TO_CHAR(table1.C_Region_ID), '')  || ' - ' || COALESCE(TO_CHAR(table1.C_Country_ID), '') ) as C_Location_ID FROM C_Location table1 WHERE table1.isActive='Y' AND table1.C_Location_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Location_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_location_id");
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
  public static String selectDef2955_2(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDef2957_3(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_BPartner_Location.C_BPartner_ID AS NAME" +
      "        FROM C_BPartner_Location" +
      "        WHERE C_BPartner_Location.C_BPartner_Location_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BPartner left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BPartner.C_BPartner_ID = table1.C_BPartner_ID) WHERE C_BPartner.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BPartner left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BPartner.C_BPartner_ID = table1.C_BPartner_ID) WHERE C_BPartner.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
      "        UPDATE C_BPartner_Location" +
      "        SET C_BPartner_ID = (?) , Name = (?) , Deviant_Bp_Name = (?) , IsActive = (?) , C_Location_ID = (?) , Phone = (?) , Phone2 = (?) , Fax = (?) , IsShipTo = (?) , IsBillTo = (?) , IsPayFrom = (?) , IsRemitTo = (?) , IsTaxLocation = (?) , Isheadquarter = (?) , Uidnumber = (?) , Eoriidentification = (?) , C_Tax_ID = (?) , C_SalesRegion_ID = (?) , UPC = (?) , AD_Org_ID = (?) , C_BPartner_Location_ID = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_BPartner_Location.C_BPartner_Location_ID = ? " +
      "                 AND C_BPartner_Location.C_BPartner_ID = ? " +
      "        AND C_BPartner_Location.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_BPartner_Location.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deviantBpName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isshipto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbillto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispayfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isremitto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxlocation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isheadquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uidnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, eoriidentification);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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
      "        INSERT INTO C_BPartner_Location " +
      "        (C_BPartner_ID, Name, Deviant_Bp_Name, IsActive, C_Location_ID, Phone, Phone2, Fax, IsShipTo, IsBillTo, IsPayFrom, IsRemitTo, IsTaxLocation, Isheadquarter, Uidnumber, Eoriidentification, C_Tax_ID, C_SalesRegion_ID, UPC, AD_Org_ID, C_BPartner_Location_ID, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deviantBpName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isshipto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbillto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispayfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isremitto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxlocation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isheadquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uidnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, eoriidentification);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cBpartnerId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_BPartner_Location" +
      "        WHERE C_BPartner_Location.C_BPartner_Location_ID = ? " +
      "                 AND C_BPartner_Location.C_BPartner_ID = ? " +
      "        AND C_BPartner_Location.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_BPartner_Location.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_BPartner_Location" +
      "        WHERE C_BPartner_Location.C_BPartner_Location_ID = ? " +
      "                 AND C_BPartner_Location.C_BPartner_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
      "          FROM C_BPartner_Location" +
      "         WHERE C_BPartner_Location.C_BPartner_Location_ID = ? ";

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
      "          FROM C_BPartner_Location" +
      "         WHERE C_BPartner_Location.C_BPartner_Location_ID = ? ";

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
