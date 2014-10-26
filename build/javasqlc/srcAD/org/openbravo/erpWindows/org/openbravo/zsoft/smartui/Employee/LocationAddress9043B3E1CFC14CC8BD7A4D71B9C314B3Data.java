//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.Employee;

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
class LocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data implements FieldProvider {
static Logger log4j = Logger.getLogger(LocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String upc;
  public String name;
  public String isactive;
  public String cLocationId;
  public String cLocationIdr;
  public String phone;
  public String phone2;
  public String fax;
  public String istaxlocation;
  public String isheadquarter;
  public String adClientId;
  public String cSalesregionId;
  public String isremitto;
  public String adOrgId;
  public String ispayfrom;
  public String isbillto;
  public String isshipto;
  public String cBpartnerLocationId;
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
    else if (fieldName.equalsIgnoreCase("upc"))
      return upc;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
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
    else if (fieldName.equalsIgnoreCase("istaxlocation"))
      return istaxlocation;
    else if (fieldName.equalsIgnoreCase("isheadquarter"))
      return isheadquarter;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_salesregion_id") || fieldName.equals("cSalesregionId"))
      return cSalesregionId;
    else if (fieldName.equalsIgnoreCase("isremitto"))
      return isremitto;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ispayfrom"))
      return ispayfrom;
    else if (fieldName.equalsIgnoreCase("isbillto"))
      return isbillto;
    else if (fieldName.equalsIgnoreCase("isshipto"))
      return isshipto;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
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
  public static LocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cBpartnerId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static LocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
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
      "C_BPartner_Location.UPC, " +
      "C_BPartner_Location.Name, " +
      "COALESCE(C_BPartner_Location.IsActive, 'N') AS IsActive, " +
      "C_BPartner_Location.C_Location_ID, " +
      "(CASE WHEN C_BPartner_Location.C_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Address1), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Address2), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Postal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.City), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_Location_IDR, " +
      "C_BPartner_Location.Phone, " +
      "C_BPartner_Location.Phone2, " +
      "C_BPartner_Location.Fax, " +
      "COALESCE(C_BPartner_Location.IsTaxLocation, 'N') AS IsTaxLocation, " +
      "COALESCE(C_BPartner_Location.Isheadquarter, 'N') AS Isheadquarter, " +
      "C_BPartner_Location.AD_Client_ID, " +
      "C_BPartner_Location.C_SalesRegion_ID, " +
      "COALESCE(C_BPartner_Location.IsRemitTo, 'N') AS IsRemitTo, " +
      "C_BPartner_Location.AD_Org_ID, " +
      "COALESCE(C_BPartner_Location.IsPayFrom, 'N') AS IsPayFrom, " +
      "COALESCE(C_BPartner_Location.IsBillTo, 'N') AS IsBillTo, " +
      "COALESCE(C_BPartner_Location.IsShipTo, 'N') AS IsShipTo, " +
      "C_BPartner_Location.C_BPartner_Location_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_BPartner_Location left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BPartner_Location.C_BPartner_ID = table1.C_BPartner_ID) left join (select C_Location_ID, Address1, Address2, Postal, City, C_Region_ID, C_Country_ID from C_Location) table2 on (C_BPartner_Location.C_Location_ID = table2.C_Location_ID) left join (select C_Region_ID, Name from C_Region) table3 on (table2.C_Region_ID = table3.C_Region_ID) left join (select C_Country_ID, Name from C_Country) table4 on (table2.C_Country_ID = table4.C_Country_ID) left join (select C_Country_ID,AD_Language, Name from C_Country_TRL) tableTRL4 on (table4.C_Country_ID = tableTRL4.C_Country_ID and tableTRL4.AD_Language = ?) " +
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
        LocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data = new LocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data();
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.created = UtilSql.getValue(result, "created");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.updated = UtilSql.getValue(result, "updated");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.upc = UtilSql.getValue(result, "upc");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.name = UtilSql.getValue(result, "name");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.isactive = UtilSql.getValue(result, "isactive");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.cLocationIdr = UtilSql.getValue(result, "c_location_idr");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.phone = UtilSql.getValue(result, "phone");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.phone2 = UtilSql.getValue(result, "phone2");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.fax = UtilSql.getValue(result, "fax");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.istaxlocation = UtilSql.getValue(result, "istaxlocation");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.isheadquarter = UtilSql.getValue(result, "isheadquarter");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.cSalesregionId = UtilSql.getValue(result, "c_salesregion_id");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.isremitto = UtilSql.getValue(result, "isremitto");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.ispayfrom = UtilSql.getValue(result, "ispayfrom");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.isbillto = UtilSql.getValue(result, "isbillto");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.isshipto = UtilSql.getValue(result, "isshipto");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.language = UtilSql.getValue(result, "language");
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.adUserClient = "";
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.adOrgClient = "";
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.createdby = "";
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.trBgcolor = "";
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.totalCount = "";
        objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data);
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
    LocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[] = new LocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[vector.size()];
    vector.copyInto(objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data);
    return(objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data);
  }

/**
Create a registry
 */
  public static LocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[] set(String cBpartnerId, String cBpartnerIdr, String isactive, String istaxlocation, String adOrgId, String isshipto, String cSalesregionId, String phone2, String cBpartnerLocationId, String adClientId, String fax, String name, String isbillto, String cLocationId, String cLocationIdr, String phone, String ispayfrom, String isremitto, String isheadquarter, String createdby, String createdbyr, String upc, String updatedby, String updatedbyr)    throws ServletException {
    LocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[] = new LocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[1];
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0] = new LocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data();
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].created = "";
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].createdbyr = createdbyr;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].updated = "";
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].updatedTimeStamp = "";
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].updatedby = updatedby;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].updatedbyr = updatedbyr;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].cBpartnerId = cBpartnerId;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].cBpartnerIdr = cBpartnerIdr;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].upc = upc;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].name = name;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].isactive = isactive;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].cLocationId = cLocationId;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].cLocationIdr = cLocationIdr;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].phone = phone;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].phone2 = phone2;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].fax = fax;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].istaxlocation = istaxlocation;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].isheadquarter = isheadquarter;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].adClientId = adClientId;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].cSalesregionId = cSalesregionId;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].isremitto = isremitto;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].adOrgId = adOrgId;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].ispayfrom = ispayfrom;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].isbillto = isbillto;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].isshipto = isshipto;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].cBpartnerLocationId = cBpartnerLocationId;
    objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data[0].language = "";
    return objectLocationAddress9043B3E1CFC14CC8BD7A4D71B9C314B3Data;
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
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM c_bpartneremployee_view left join (select C_BPartner_ID, Name from C_BPartner) table1 on (c_bpartneremployee_view.C_BPartner_ID = table1.C_BPartner_ID) WHERE c_bpartneremployee_view.C_BPartner_ID = ?  ";

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
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM c_bpartneremployee_view left join (select C_BPartner_ID, Name from C_BPartner) table1 on (c_bpartneremployee_view.C_BPartner_ID = table1.C_BPartner_ID) WHERE c_bpartneremployee_view.C_BPartner_ID = ?  ";

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
      "        SET C_BPartner_ID = (?) , UPC = (?) , Name = (?) , IsActive = (?) , C_Location_ID = (?) , Phone = (?) , Phone2 = (?) , Fax = (?) , IsTaxLocation = (?) , Isheadquarter = (?) , AD_Client_ID = (?) , C_SalesRegion_ID = (?) , IsRemitTo = (?) , AD_Org_ID = (?) , IsPayFrom = (?) , IsBillTo = (?) , IsShipTo = (?) , C_BPartner_Location_ID = (?) , updated = now(), updatedby = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxlocation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isheadquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isremitto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispayfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbillto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isshipto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
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
      "        (C_BPartner_ID, UPC, Name, IsActive, C_Location_ID, Phone, Phone2, Fax, IsTaxLocation, Isheadquarter, AD_Client_ID, C_SalesRegion_ID, IsRemitTo, AD_Org_ID, IsPayFrom, IsBillTo, IsShipTo, C_BPartner_Location_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxlocation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isheadquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isremitto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispayfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbillto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isshipto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
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
