//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.asset.CustomerAsset;

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
class CustomerAsset450Data implements FieldProvider {
static Logger log4j = Logger.getLogger(CustomerAsset450Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String assettype;
  public String assettyper;
  public String isactive;
  public String adUserId;
  public String adUserIdr;
  public String value;
  public String name;
  public String help;
  public String description;
  public String lot;
  public String versionno;
  public String snrMasterdataId;
  public String snrMasterdataIdr;
  public String cProjectId;
  public String cProjectIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String locationcomment;
  public String assetdisposaldate;
  public String guaranteedate;
  public String uselifeyears;
  public String uselifemonths;
  public String assetservicedate;
  public String serno;
  public String documentno;
  public String datepurchased;
  public String datecancelled;
  public String amortizationstartdate;
  public String amortizationenddate;
  public String annualamortizationpercentage;
  public String cCurrencyId;
  public String assetvalueamt;
  public String residualassetvalueamt;
  public String lifeuseunits;
  public String cLocationId;
  public String useunits;
  public String depreciatedvalue;
  public String amortizationvalueamt;
  public String aAssetId;
  public String depreciatedpreviousamt;
  public String isfullydepreciated;
  public String isowned;
  public String profit;
  public String acctvalueamt;
  public String isinposession;
  public String amortizationcalctype;
  public String isdepreciated;
  public String aAssetGroupId;
  public String processed;
  public String iscostcenter;
  public String depreciatedplan;
  public String isdisposed;
  public String assetdepreciationdate;
  public String amortizationtype;
  public String assetschedule;
  public String issummary;
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
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("assettype"))
      return assettype;
    else if (fieldName.equalsIgnoreCase("assettyper"))
      return assettyper;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("lot"))
      return lot;
    else if (fieldName.equalsIgnoreCase("versionno"))
      return versionno;
    else if (fieldName.equalsIgnoreCase("snr_masterdata_id") || fieldName.equals("snrMasterdataId"))
      return snrMasterdataId;
    else if (fieldName.equalsIgnoreCase("snr_masterdata_idr") || fieldName.equals("snrMasterdataIdr"))
      return snrMasterdataIdr;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("locationcomment"))
      return locationcomment;
    else if (fieldName.equalsIgnoreCase("assetdisposaldate"))
      return assetdisposaldate;
    else if (fieldName.equalsIgnoreCase("guaranteedate"))
      return guaranteedate;
    else if (fieldName.equalsIgnoreCase("uselifeyears"))
      return uselifeyears;
    else if (fieldName.equalsIgnoreCase("uselifemonths"))
      return uselifemonths;
    else if (fieldName.equalsIgnoreCase("assetservicedate"))
      return assetservicedate;
    else if (fieldName.equalsIgnoreCase("serno"))
      return serno;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("datepurchased"))
      return datepurchased;
    else if (fieldName.equalsIgnoreCase("datecancelled"))
      return datecancelled;
    else if (fieldName.equalsIgnoreCase("amortizationstartdate"))
      return amortizationstartdate;
    else if (fieldName.equalsIgnoreCase("amortizationenddate"))
      return amortizationenddate;
    else if (fieldName.equalsIgnoreCase("annualamortizationpercentage"))
      return annualamortizationpercentage;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("assetvalueamt"))
      return assetvalueamt;
    else if (fieldName.equalsIgnoreCase("residualassetvalueamt"))
      return residualassetvalueamt;
    else if (fieldName.equalsIgnoreCase("lifeuseunits"))
      return lifeuseunits;
    else if (fieldName.equalsIgnoreCase("c_location_id") || fieldName.equals("cLocationId"))
      return cLocationId;
    else if (fieldName.equalsIgnoreCase("useunits"))
      return useunits;
    else if (fieldName.equalsIgnoreCase("depreciatedvalue"))
      return depreciatedvalue;
    else if (fieldName.equalsIgnoreCase("amortizationvalueamt"))
      return amortizationvalueamt;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("depreciatedpreviousamt"))
      return depreciatedpreviousamt;
    else if (fieldName.equalsIgnoreCase("isfullydepreciated"))
      return isfullydepreciated;
    else if (fieldName.equalsIgnoreCase("isowned"))
      return isowned;
    else if (fieldName.equalsIgnoreCase("profit"))
      return profit;
    else if (fieldName.equalsIgnoreCase("acctvalueamt"))
      return acctvalueamt;
    else if (fieldName.equalsIgnoreCase("isinposession"))
      return isinposession;
    else if (fieldName.equalsIgnoreCase("amortizationcalctype"))
      return amortizationcalctype;
    else if (fieldName.equalsIgnoreCase("isdepreciated"))
      return isdepreciated;
    else if (fieldName.equalsIgnoreCase("a_asset_group_id") || fieldName.equals("aAssetGroupId"))
      return aAssetGroupId;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("iscostcenter"))
      return iscostcenter;
    else if (fieldName.equalsIgnoreCase("depreciatedplan"))
      return depreciatedplan;
    else if (fieldName.equalsIgnoreCase("isdisposed"))
      return isdisposed;
    else if (fieldName.equalsIgnoreCase("assetdepreciationdate"))
      return assetdepreciationdate;
    else if (fieldName.equalsIgnoreCase("amortizationtype"))
      return amortizationtype;
    else if (fieldName.equalsIgnoreCase("assetschedule"))
      return assetschedule;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
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
  public static CustomerAsset450Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CustomerAsset450Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(A_Asset.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = A_Asset.CreatedBy) as CreatedByR, " +
      "        to_char(A_Asset.Updated, ?) as updated, " +
      "        to_char(A_Asset.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        A_Asset.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = A_Asset.UpdatedBy) as UpdatedByR," +
      "        A_Asset.AD_Client_ID, " +
      "(CASE WHEN A_Asset.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "A_Asset.AD_Org_ID, " +
      "(CASE WHEN A_Asset.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "A_Asset.Assettype, " +
      "(CASE WHEN A_Asset.Assettype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS AssettypeR, " +
      "COALESCE(A_Asset.IsActive, 'N') AS IsActive, " +
      "A_Asset.AD_User_ID, " +
      "(CASE WHEN A_Asset.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "A_Asset.Value, " +
      "A_Asset.Name, " +
      "A_Asset.Help, " +
      "A_Asset.Description, " +
      "A_Asset.Lot, " +
      "A_Asset.VersionNo, " +
      "A_Asset.SNR_Masterdata_ID, " +
      "(CASE WHEN A_Asset.SNR_Masterdata_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Serialnumber), ''))),'') ) END) AS SNR_Masterdata_IDR, " +
      "A_Asset.C_Project_ID, " +
      "(CASE WHEN A_Asset.C_Project_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "A_Asset.C_BPartner_ID, " +
      "(CASE WHEN A_Asset.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "A_Asset.C_BPartner_Location_ID, " +
      "(CASE WHEN A_Asset.C_BPartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS C_BPartner_Location_IDR, " +
      "A_Asset.LocationComment, " +
      "A_Asset.AssetDisposalDate, " +
      "A_Asset.GuaranteeDate, " +
      "A_Asset.UseLifeYears, " +
      "A_Asset.UseLifeMonths, " +
      "A_Asset.AssetServiceDate, " +
      "A_Asset.SerNo, " +
      "A_Asset.DocumentNo, " +
      "A_Asset.Datepurchased, " +
      "A_Asset.Datecancelled, " +
      "A_Asset.Amortizationstartdate, " +
      "A_Asset.Amortizationenddate, " +
      "A_Asset.Annualamortizationpercentage, " +
      "A_Asset.C_Currency_ID, " +
      "A_Asset.AssetValueAmt, " +
      "A_Asset.Residualassetvalueamt, " +
      "A_Asset.LifeUseUnits, " +
      "A_Asset.C_Location_ID, " +
      "A_Asset.UseUnits, " +
      "A_Asset.Depreciatedvalue, " +
      "A_Asset.Amortizationvalueamt, " +
      "A_Asset.A_Asset_ID, " +
      "A_Asset.Depreciatedpreviousamt, " +
      "COALESCE(A_Asset.IsFullyDepreciated, 'N') AS IsFullyDepreciated, " +
      "COALESCE(A_Asset.IsOwned, 'N') AS IsOwned, " +
      "A_Asset.Profit, " +
      "A_Asset.Acctvalueamt, " +
      "COALESCE(A_Asset.IsInPosession, 'N') AS IsInPosession, " +
      "A_Asset.Amortizationcalctype, " +
      "COALESCE(A_Asset.IsDepreciated, 'N') AS IsDepreciated, " +
      "A_Asset.A_Asset_Group_ID, " +
      "A_Asset.Processed, " +
      "COALESCE(A_Asset.Iscostcenter, 'N') AS Iscostcenter, " +
      "A_Asset.Depreciatedplan, " +
      "COALESCE(A_Asset.IsDisposed, 'N') AS IsDisposed, " +
      "A_Asset.AssetDepreciationDate, " +
      "A_Asset.Amortizationtype, " +
      "A_Asset.Assetschedule, " +
      "COALESCE(A_Asset.Issummary, 'N') AS Issummary, " +
      "        ? AS LANGUAGE " +
      "        FROM A_Asset left join (select AD_Client_ID, Name from AD_Client) table1 on (A_Asset.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (A_Asset.AD_Org_ID = table2.AD_Org_ID) left join ad_ref_list_v list1 on (A_Asset.Assettype = list1.value and list1.ad_reference_id = '65DF5707867B448CB985D4ED8FE6CB17' and list1.ad_language = ?)  left join (select AD_User_ID, Name from AD_User) table3 on (A_Asset.AD_User_ID = table3.AD_User_ID) left join (select SNR_Masterdata_ID, M_Product_ID, Serialnumber from SNR_Masterdata) table4 on (A_Asset.SNR_Masterdata_ID = table4.SNR_Masterdata_ID) left join (select M_Product_ID, Value, Name from M_Product) table5 on (table4.M_Product_ID = table5.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL5 on (table5.M_Product_ID = tableTRL5.M_Product_ID and tableTRL5.AD_Language = ?)  left join (select C_Project_ID, Name from C_Project) table6 on (A_Asset.C_Project_ID =  table6.C_Project_ID) left join (select C_BPartner_ID, Name from C_BPartner) table7 on (A_Asset.C_BPartner_ID = table7.C_BPartner_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table8 on (A_Asset.C_BPartner_Location_ID = table8.C_BPartner_Location_ID)" +
      "        WHERE 2=2 " +
      " AND a_asset.assettype = 'CA' and a_asset.isactive='Y'" +
      "        AND 1=1 " +
      "        AND A_Asset.A_Asset_ID = ? " +
      "        AND A_Asset.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND A_Asset.AD_Org_ID IN (";
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
        CustomerAsset450Data objectCustomerAsset450Data = new CustomerAsset450Data();
        objectCustomerAsset450Data.created = UtilSql.getValue(result, "created");
        objectCustomerAsset450Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCustomerAsset450Data.updated = UtilSql.getValue(result, "updated");
        objectCustomerAsset450Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCustomerAsset450Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectCustomerAsset450Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCustomerAsset450Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCustomerAsset450Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectCustomerAsset450Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCustomerAsset450Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectCustomerAsset450Data.assettype = UtilSql.getValue(result, "assettype");
        objectCustomerAsset450Data.assettyper = UtilSql.getValue(result, "assettyper");
        objectCustomerAsset450Data.isactive = UtilSql.getValue(result, "isactive");
        objectCustomerAsset450Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectCustomerAsset450Data.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectCustomerAsset450Data.value = UtilSql.getValue(result, "value");
        objectCustomerAsset450Data.name = UtilSql.getValue(result, "name");
        objectCustomerAsset450Data.help = UtilSql.getValue(result, "help");
        objectCustomerAsset450Data.description = UtilSql.getValue(result, "description");
        objectCustomerAsset450Data.lot = UtilSql.getValue(result, "lot");
        objectCustomerAsset450Data.versionno = UtilSql.getValue(result, "versionno");
        objectCustomerAsset450Data.snrMasterdataId = UtilSql.getValue(result, "snr_masterdata_id");
        objectCustomerAsset450Data.snrMasterdataIdr = UtilSql.getValue(result, "snr_masterdata_idr");
        objectCustomerAsset450Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCustomerAsset450Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectCustomerAsset450Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCustomerAsset450Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectCustomerAsset450Data.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectCustomerAsset450Data.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectCustomerAsset450Data.locationcomment = UtilSql.getValue(result, "locationcomment");
        objectCustomerAsset450Data.assetdisposaldate = UtilSql.getDateValue(result, "assetdisposaldate", "dd-MM-yyyy");
        objectCustomerAsset450Data.guaranteedate = UtilSql.getDateValue(result, "guaranteedate", "dd-MM-yyyy");
        objectCustomerAsset450Data.uselifeyears = UtilSql.getValue(result, "uselifeyears");
        objectCustomerAsset450Data.uselifemonths = UtilSql.getValue(result, "uselifemonths");
        objectCustomerAsset450Data.assetservicedate = UtilSql.getDateValue(result, "assetservicedate", "dd-MM-yyyy");
        objectCustomerAsset450Data.serno = UtilSql.getValue(result, "serno");
        objectCustomerAsset450Data.documentno = UtilSql.getValue(result, "documentno");
        objectCustomerAsset450Data.datepurchased = UtilSql.getDateValue(result, "datepurchased", "dd-MM-yyyy");
        objectCustomerAsset450Data.datecancelled = UtilSql.getDateValue(result, "datecancelled", "dd-MM-yyyy");
        objectCustomerAsset450Data.amortizationstartdate = UtilSql.getDateValue(result, "amortizationstartdate", "dd-MM-yyyy");
        objectCustomerAsset450Data.amortizationenddate = UtilSql.getDateValue(result, "amortizationenddate", "dd-MM-yyyy");
        objectCustomerAsset450Data.annualamortizationpercentage = UtilSql.getValue(result, "annualamortizationpercentage");
        objectCustomerAsset450Data.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCustomerAsset450Data.assetvalueamt = UtilSql.getValue(result, "assetvalueamt");
        objectCustomerAsset450Data.residualassetvalueamt = UtilSql.getValue(result, "residualassetvalueamt");
        objectCustomerAsset450Data.lifeuseunits = UtilSql.getValue(result, "lifeuseunits");
        objectCustomerAsset450Data.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectCustomerAsset450Data.useunits = UtilSql.getValue(result, "useunits");
        objectCustomerAsset450Data.depreciatedvalue = UtilSql.getValue(result, "depreciatedvalue");
        objectCustomerAsset450Data.amortizationvalueamt = UtilSql.getValue(result, "amortizationvalueamt");
        objectCustomerAsset450Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectCustomerAsset450Data.depreciatedpreviousamt = UtilSql.getValue(result, "depreciatedpreviousamt");
        objectCustomerAsset450Data.isfullydepreciated = UtilSql.getValue(result, "isfullydepreciated");
        objectCustomerAsset450Data.isowned = UtilSql.getValue(result, "isowned");
        objectCustomerAsset450Data.profit = UtilSql.getValue(result, "profit");
        objectCustomerAsset450Data.acctvalueamt = UtilSql.getValue(result, "acctvalueamt");
        objectCustomerAsset450Data.isinposession = UtilSql.getValue(result, "isinposession");
        objectCustomerAsset450Data.amortizationcalctype = UtilSql.getValue(result, "amortizationcalctype");
        objectCustomerAsset450Data.isdepreciated = UtilSql.getValue(result, "isdepreciated");
        objectCustomerAsset450Data.aAssetGroupId = UtilSql.getValue(result, "a_asset_group_id");
        objectCustomerAsset450Data.processed = UtilSql.getValue(result, "processed");
        objectCustomerAsset450Data.iscostcenter = UtilSql.getValue(result, "iscostcenter");
        objectCustomerAsset450Data.depreciatedplan = UtilSql.getValue(result, "depreciatedplan");
        objectCustomerAsset450Data.isdisposed = UtilSql.getValue(result, "isdisposed");
        objectCustomerAsset450Data.assetdepreciationdate = UtilSql.getDateValue(result, "assetdepreciationdate", "dd-MM-yyyy");
        objectCustomerAsset450Data.amortizationtype = UtilSql.getValue(result, "amortizationtype");
        objectCustomerAsset450Data.assetschedule = UtilSql.getValue(result, "assetschedule");
        objectCustomerAsset450Data.issummary = UtilSql.getValue(result, "issummary");
        objectCustomerAsset450Data.language = UtilSql.getValue(result, "language");
        objectCustomerAsset450Data.adUserClient = "";
        objectCustomerAsset450Data.adOrgClient = "";
        objectCustomerAsset450Data.createdby = "";
        objectCustomerAsset450Data.trBgcolor = "";
        objectCustomerAsset450Data.totalCount = "";
        objectCustomerAsset450Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCustomerAsset450Data);
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
    CustomerAsset450Data objectCustomerAsset450Data[] = new CustomerAsset450Data[vector.size()];
    vector.copyInto(objectCustomerAsset450Data);
    return(objectCustomerAsset450Data);
  }

/**
Create a registry
 */
  public static CustomerAsset450Data[] set(String name, String adClientId, String cBpartnerLocationId, String guaranteedate, String isfullydepreciated, String adOrgId, String isowned, String snrMasterdataId, String assetdisposaldate, String assetservicedate, String cCurrencyId, String depreciatedvalue, String assetschedule, String aAssetId, String amortizationenddate, String isdisposed, String lot, String issummary, String uselifemonths, String createdby, String createdbyr, String value, String amortizationtype, String amortizationvalueamt, String isinposession, String adUserId, String acctvalueamt, String useunits, String cProjectId, String documentno, String cBpartnerId, String cBpartnerIdr, String residualassetvalueamt, String uselifeyears, String depreciatedpreviousamt, String amortizationstartdate, String depreciatedplan, String datecancelled, String amortizationcalctype, String serno, String isdepreciated, String description, String datepurchased, String versionno, String updatedby, String updatedbyr, String assetdepreciationdate, String isactive, String locationcomment, String annualamortizationpercentage, String cLocationId, String processed, String iscostcenter, String assettype, String assetvalueamt, String aAssetGroupId, String help, String lifeuseunits, String profit)    throws ServletException {
    CustomerAsset450Data objectCustomerAsset450Data[] = new CustomerAsset450Data[1];
    objectCustomerAsset450Data[0] = new CustomerAsset450Data();
    objectCustomerAsset450Data[0].created = "";
    objectCustomerAsset450Data[0].createdbyr = createdbyr;
    objectCustomerAsset450Data[0].updated = "";
    objectCustomerAsset450Data[0].updatedTimeStamp = "";
    objectCustomerAsset450Data[0].updatedby = updatedby;
    objectCustomerAsset450Data[0].updatedbyr = updatedbyr;
    objectCustomerAsset450Data[0].adClientId = adClientId;
    objectCustomerAsset450Data[0].adClientIdr = "";
    objectCustomerAsset450Data[0].adOrgId = adOrgId;
    objectCustomerAsset450Data[0].adOrgIdr = "";
    objectCustomerAsset450Data[0].assettype = assettype;
    objectCustomerAsset450Data[0].assettyper = "";
    objectCustomerAsset450Data[0].isactive = isactive;
    objectCustomerAsset450Data[0].adUserId = adUserId;
    objectCustomerAsset450Data[0].adUserIdr = "";
    objectCustomerAsset450Data[0].value = value;
    objectCustomerAsset450Data[0].name = name;
    objectCustomerAsset450Data[0].help = help;
    objectCustomerAsset450Data[0].description = description;
    objectCustomerAsset450Data[0].lot = lot;
    objectCustomerAsset450Data[0].versionno = versionno;
    objectCustomerAsset450Data[0].snrMasterdataId = snrMasterdataId;
    objectCustomerAsset450Data[0].snrMasterdataIdr = "";
    objectCustomerAsset450Data[0].cProjectId = cProjectId;
    objectCustomerAsset450Data[0].cProjectIdr = "";
    objectCustomerAsset450Data[0].cBpartnerId = cBpartnerId;
    objectCustomerAsset450Data[0].cBpartnerIdr = cBpartnerIdr;
    objectCustomerAsset450Data[0].cBpartnerLocationId = cBpartnerLocationId;
    objectCustomerAsset450Data[0].cBpartnerLocationIdr = "";
    objectCustomerAsset450Data[0].locationcomment = locationcomment;
    objectCustomerAsset450Data[0].assetdisposaldate = assetdisposaldate;
    objectCustomerAsset450Data[0].guaranteedate = guaranteedate;
    objectCustomerAsset450Data[0].uselifeyears = uselifeyears;
    objectCustomerAsset450Data[0].uselifemonths = uselifemonths;
    objectCustomerAsset450Data[0].assetservicedate = assetservicedate;
    objectCustomerAsset450Data[0].serno = serno;
    objectCustomerAsset450Data[0].documentno = documentno;
    objectCustomerAsset450Data[0].datepurchased = datepurchased;
    objectCustomerAsset450Data[0].datecancelled = datecancelled;
    objectCustomerAsset450Data[0].amortizationstartdate = amortizationstartdate;
    objectCustomerAsset450Data[0].amortizationenddate = amortizationenddate;
    objectCustomerAsset450Data[0].annualamortizationpercentage = annualamortizationpercentage;
    objectCustomerAsset450Data[0].cCurrencyId = cCurrencyId;
    objectCustomerAsset450Data[0].assetvalueamt = assetvalueamt;
    objectCustomerAsset450Data[0].residualassetvalueamt = residualassetvalueamt;
    objectCustomerAsset450Data[0].lifeuseunits = lifeuseunits;
    objectCustomerAsset450Data[0].cLocationId = cLocationId;
    objectCustomerAsset450Data[0].useunits = useunits;
    objectCustomerAsset450Data[0].depreciatedvalue = depreciatedvalue;
    objectCustomerAsset450Data[0].amortizationvalueamt = amortizationvalueamt;
    objectCustomerAsset450Data[0].aAssetId = aAssetId;
    objectCustomerAsset450Data[0].depreciatedpreviousamt = depreciatedpreviousamt;
    objectCustomerAsset450Data[0].isfullydepreciated = isfullydepreciated;
    objectCustomerAsset450Data[0].isowned = isowned;
    objectCustomerAsset450Data[0].profit = profit;
    objectCustomerAsset450Data[0].acctvalueamt = acctvalueamt;
    objectCustomerAsset450Data[0].isinposession = isinposession;
    objectCustomerAsset450Data[0].amortizationcalctype = amortizationcalctype;
    objectCustomerAsset450Data[0].isdepreciated = isdepreciated;
    objectCustomerAsset450Data[0].aAssetGroupId = aAssetGroupId;
    objectCustomerAsset450Data[0].processed = processed;
    objectCustomerAsset450Data[0].iscostcenter = iscostcenter;
    objectCustomerAsset450Data[0].depreciatedplan = depreciatedplan;
    objectCustomerAsset450Data[0].isdisposed = isdisposed;
    objectCustomerAsset450Data[0].assetdepreciationdate = assetdepreciationdate;
    objectCustomerAsset450Data[0].amortizationtype = amortizationtype;
    objectCustomerAsset450Data[0].assetschedule = assetschedule;
    objectCustomerAsset450Data[0].issummary = issummary;
    objectCustomerAsset450Data[0].language = "";
    return objectCustomerAsset450Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef8045_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef8065_1(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
  public static String selectDef8063_2(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE A_Asset" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , Assettype = (?) , IsActive = (?) , AD_User_ID = (?) , Value = (?) , Name = (?) , Help = (?) , Description = (?) , Lot = (?) , VersionNo = (?) , SNR_Masterdata_ID = (?) , C_Project_ID = (?) , C_BPartner_ID = (?) , C_BPartner_Location_ID = (?) , LocationComment = (?) , AssetDisposalDate = TO_DATE(?) , GuaranteeDate = TO_DATE(?) , UseLifeYears = TO_NUMBER(?) , UseLifeMonths = TO_NUMBER(?) , AssetServiceDate = TO_DATE(?) , SerNo = (?) , DocumentNo = (?) , Datepurchased = TO_DATE(?) , Datecancelled = TO_DATE(?) , Amortizationstartdate = TO_DATE(?) , Amortizationenddate = TO_DATE(?) , Annualamortizationpercentage = TO_NUMBER(?) , C_Currency_ID = (?) , AssetValueAmt = TO_NUMBER(?) , Residualassetvalueamt = TO_NUMBER(?) , LifeUseUnits = TO_NUMBER(?) , C_Location_ID = (?) , UseUnits = TO_NUMBER(?) , Depreciatedvalue = TO_NUMBER(?) , Amortizationvalueamt = TO_NUMBER(?) , A_Asset_ID = (?) , Depreciatedpreviousamt = TO_NUMBER(?) , IsFullyDepreciated = (?) , IsOwned = (?) , Profit = TO_NUMBER(?) , Acctvalueamt = TO_NUMBER(?) , IsInPosession = (?) , Amortizationcalctype = (?) , IsDepreciated = (?) , A_Asset_Group_ID = (?) , Processed = (?) , Iscostcenter = (?) , Depreciatedplan = TO_NUMBER(?) , IsDisposed = (?) , AssetDepreciationDate = TO_DATE(?) , Amortizationtype = (?) , Assetschedule = (?) , Issummary = (?) , updated = now(), updatedby = ? " +
      "        WHERE A_Asset.A_Asset_ID = ? " +
      "        AND A_Asset.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND A_Asset.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assettype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lot);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, versionno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, locationcomment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetdisposaldate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uselifeyears);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uselifemonths);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetservicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepurchased);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecancelled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationstartdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationenddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, annualamortizationpercentage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, residualassetvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lifeuseunits);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, useunits);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedpreviousamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfullydepreciated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isowned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, profit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinposession);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationcalctype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdepreciated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscostcenter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisposed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetdepreciationdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetschedule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
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
      "        INSERT INTO A_Asset " +
      "        (AD_Client_ID, AD_Org_ID, Assettype, IsActive, AD_User_ID, Value, Name, Help, Description, Lot, VersionNo, SNR_Masterdata_ID, C_Project_ID, C_BPartner_ID, C_BPartner_Location_ID, LocationComment, AssetDisposalDate, GuaranteeDate, UseLifeYears, UseLifeMonths, AssetServiceDate, SerNo, DocumentNo, Datepurchased, Datecancelled, Amortizationstartdate, Amortizationenddate, Annualamortizationpercentage, C_Currency_ID, AssetValueAmt, Residualassetvalueamt, LifeUseUnits, C_Location_ID, UseUnits, Depreciatedvalue, Amortizationvalueamt, A_Asset_ID, Depreciatedpreviousamt, IsFullyDepreciated, IsOwned, Profit, Acctvalueamt, IsInPosession, Amortizationcalctype, IsDepreciated, A_Asset_Group_ID, Processed, Iscostcenter, Depreciatedplan, IsDisposed, AssetDepreciationDate, Amortizationtype, Assetschedule, Issummary, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_DATE(?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assettype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lot);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, versionno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, locationcomment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetdisposaldate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uselifeyears);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uselifemonths);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetservicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepurchased);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecancelled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationstartdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationenddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, annualamortizationpercentage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, residualassetvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lifeuseunits);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, useunits);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedpreviousamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfullydepreciated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isowned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, profit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinposession);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationcalctype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdepreciated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscostcenter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisposed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetdepreciationdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetschedule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
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
      "        DELETE FROM A_Asset" +
      "        WHERE A_Asset.A_Asset_ID = ? " +
      "        AND A_Asset.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND A_Asset.AD_Org_ID IN (";
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
      "        DELETE FROM A_Asset" +
      "        WHERE A_Asset.A_Asset_ID = ? ";

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
      "          FROM A_Asset" +
      "         WHERE A_Asset.A_Asset_ID = ? ";

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
      "          FROM A_Asset" +
      "         WHERE A_Asset.A_Asset_ID = ? ";

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
