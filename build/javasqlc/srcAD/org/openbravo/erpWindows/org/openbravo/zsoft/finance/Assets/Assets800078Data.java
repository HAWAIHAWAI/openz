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
class Assets800078Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Assets800078Data.class);
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
  public String documentno;
  public String value;
  public String name;
  public String description;
  public String isactive;
  public String iscostcenter;
  public String assettype;
  public String assettyper;
  public String aAssetGroupId;
  public String aAssetGroupIdr;
  public String isdepreciated;
  public String isfullydepreciated;
  public String amortizationtype;
  public String amortizationtyper;
  public String amortizationcalctype;
  public String amortizationcalctyper;
  public String assetschedule;
  public String assetscheduler;
  public String uselifeyears;
  public String uselifemonths;
  public String annualamortizationpercentage;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String datepurchased;
  public String datecancelled;
  public String amortizationstartdate;
  public String amortizationenddate;
  public String assetvalueamt;
  public String residualassetvalueamt;
  public String amortizationvalueamt;
  public String depreciatedpreviousamt;
  public String depreciatedvalue;
  public String depreciatedplan;
  public String processed;
  public String processedBtn;
  public String locationcomment;
  public String cProjectId;
  public String cBpartnerLocationId;
  public String profit;
  public String isinposession;
  public String aAssetId;
  public String cLocationId;
  public String isdisposed;
  public String assetservicedate;
  public String adUserId;
  public String assetdepreciationdate;
  public String cBpartnerId;
  public String lifeuseunits;
  public String useunits;
  public String assetdisposaldate;
  public String guaranteedate;
  public String isowned;
  public String help;
  public String versionno;
  public String serno;
  public String acctvalueamt;
  public String lot;
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
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("iscostcenter"))
      return iscostcenter;
    else if (fieldName.equalsIgnoreCase("assettype"))
      return assettype;
    else if (fieldName.equalsIgnoreCase("assettyper"))
      return assettyper;
    else if (fieldName.equalsIgnoreCase("a_asset_group_id") || fieldName.equals("aAssetGroupId"))
      return aAssetGroupId;
    else if (fieldName.equalsIgnoreCase("a_asset_group_idr") || fieldName.equals("aAssetGroupIdr"))
      return aAssetGroupIdr;
    else if (fieldName.equalsIgnoreCase("isdepreciated"))
      return isdepreciated;
    else if (fieldName.equalsIgnoreCase("isfullydepreciated"))
      return isfullydepreciated;
    else if (fieldName.equalsIgnoreCase("amortizationtype"))
      return amortizationtype;
    else if (fieldName.equalsIgnoreCase("amortizationtyper"))
      return amortizationtyper;
    else if (fieldName.equalsIgnoreCase("amortizationcalctype"))
      return amortizationcalctype;
    else if (fieldName.equalsIgnoreCase("amortizationcalctyper"))
      return amortizationcalctyper;
    else if (fieldName.equalsIgnoreCase("assetschedule"))
      return assetschedule;
    else if (fieldName.equalsIgnoreCase("assetscheduler"))
      return assetscheduler;
    else if (fieldName.equalsIgnoreCase("uselifeyears"))
      return uselifeyears;
    else if (fieldName.equalsIgnoreCase("uselifemonths"))
      return uselifemonths;
    else if (fieldName.equalsIgnoreCase("annualamortizationpercentage"))
      return annualamortizationpercentage;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("datepurchased"))
      return datepurchased;
    else if (fieldName.equalsIgnoreCase("datecancelled"))
      return datecancelled;
    else if (fieldName.equalsIgnoreCase("amortizationstartdate"))
      return amortizationstartdate;
    else if (fieldName.equalsIgnoreCase("amortizationenddate"))
      return amortizationenddate;
    else if (fieldName.equalsIgnoreCase("assetvalueamt"))
      return assetvalueamt;
    else if (fieldName.equalsIgnoreCase("residualassetvalueamt"))
      return residualassetvalueamt;
    else if (fieldName.equalsIgnoreCase("amortizationvalueamt"))
      return amortizationvalueamt;
    else if (fieldName.equalsIgnoreCase("depreciatedpreviousamt"))
      return depreciatedpreviousamt;
    else if (fieldName.equalsIgnoreCase("depreciatedvalue"))
      return depreciatedvalue;
    else if (fieldName.equalsIgnoreCase("depreciatedplan"))
      return depreciatedplan;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("processed_btn") || fieldName.equals("processedBtn"))
      return processedBtn;
    else if (fieldName.equalsIgnoreCase("locationcomment"))
      return locationcomment;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("profit"))
      return profit;
    else if (fieldName.equalsIgnoreCase("isinposession"))
      return isinposession;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("c_location_id") || fieldName.equals("cLocationId"))
      return cLocationId;
    else if (fieldName.equalsIgnoreCase("isdisposed"))
      return isdisposed;
    else if (fieldName.equalsIgnoreCase("assetservicedate"))
      return assetservicedate;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("assetdepreciationdate"))
      return assetdepreciationdate;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("lifeuseunits"))
      return lifeuseunits;
    else if (fieldName.equalsIgnoreCase("useunits"))
      return useunits;
    else if (fieldName.equalsIgnoreCase("assetdisposaldate"))
      return assetdisposaldate;
    else if (fieldName.equalsIgnoreCase("guaranteedate"))
      return guaranteedate;
    else if (fieldName.equalsIgnoreCase("isowned"))
      return isowned;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("versionno"))
      return versionno;
    else if (fieldName.equalsIgnoreCase("serno"))
      return serno;
    else if (fieldName.equalsIgnoreCase("acctvalueamt"))
      return acctvalueamt;
    else if (fieldName.equalsIgnoreCase("lot"))
      return lot;
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
  public static Assets800078Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Assets800078Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
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
      "A_Asset.DocumentNo, " +
      "A_Asset.Value, " +
      "A_Asset.Name, " +
      "A_Asset.Description, " +
      "COALESCE(A_Asset.IsActive, 'N') AS IsActive, " +
      "COALESCE(A_Asset.Iscostcenter, 'N') AS Iscostcenter, " +
      "A_Asset.Assettype, " +
      "(CASE WHEN A_Asset.Assettype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS AssettypeR, " +
      "A_Asset.A_Asset_Group_ID, " +
      "(CASE WHEN A_Asset.A_Asset_Group_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS A_Asset_Group_IDR, " +
      "COALESCE(A_Asset.IsDepreciated, 'N') AS IsDepreciated, " +
      "COALESCE(A_Asset.IsFullyDepreciated, 'N') AS IsFullyDepreciated, " +
      "A_Asset.Amortizationtype, " +
      "(CASE WHEN A_Asset.Amortizationtype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS AmortizationtypeR, " +
      "A_Asset.Amortizationcalctype, " +
      "(CASE WHEN A_Asset.Amortizationcalctype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS AmortizationcalctypeR, " +
      "A_Asset.Assetschedule, " +
      "(CASE WHEN A_Asset.Assetschedule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS AssetscheduleR, " +
      "A_Asset.UseLifeYears, " +
      "A_Asset.UseLifeMonths, " +
      "A_Asset.Annualamortizationpercentage, " +
      "A_Asset.C_Currency_ID, " +
      "(CASE WHEN A_Asset.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "A_Asset.Datepurchased, " +
      "A_Asset.Datecancelled, " +
      "A_Asset.Amortizationstartdate, " +
      "A_Asset.Amortizationenddate, " +
      "A_Asset.AssetValueAmt, " +
      "A_Asset.Residualassetvalueamt, " +
      "A_Asset.Amortizationvalueamt, " +
      "A_Asset.Depreciatedpreviousamt, " +
      "A_Asset.Depreciatedvalue, " +
      "A_Asset.Depreciatedplan, " +
      "A_Asset.Processed, " +
      "list5.name as Processed_BTN, " +
      "A_Asset.LocationComment, " +
      "A_Asset.C_Project_ID, " +
      "A_Asset.C_BPartner_Location_ID, " +
      "A_Asset.Profit, " +
      "COALESCE(A_Asset.IsInPosession, 'N') AS IsInPosession, " +
      "A_Asset.A_Asset_ID, " +
      "A_Asset.C_Location_ID, " +
      "COALESCE(A_Asset.IsDisposed, 'N') AS IsDisposed, " +
      "A_Asset.AssetServiceDate, " +
      "A_Asset.AD_User_ID, " +
      "A_Asset.AssetDepreciationDate, " +
      "A_Asset.C_BPartner_ID, " +
      "A_Asset.LifeUseUnits, " +
      "A_Asset.UseUnits, " +
      "A_Asset.AssetDisposalDate, " +
      "A_Asset.GuaranteeDate, " +
      "COALESCE(A_Asset.IsOwned, 'N') AS IsOwned, " +
      "A_Asset.Help, " +
      "A_Asset.VersionNo, " +
      "A_Asset.SerNo, " +
      "A_Asset.Acctvalueamt, " +
      "A_Asset.Lot, " +
      "        ? AS LANGUAGE " +
      "        FROM A_Asset left join (select AD_Client_ID, Name from AD_Client) table1 on (A_Asset.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (A_Asset.AD_Org_ID = table2.AD_Org_ID) left join ad_ref_list_v list1 on (A_Asset.Assettype = list1.value and list1.ad_reference_id = '65DF5707867B448CB985D4ED8FE6CB17' and list1.ad_language = ?)  left join (select A_Asset_Group_ID, Name from A_Asset_Group) table3 on (A_Asset.A_Asset_Group_ID = table3.A_Asset_Group_ID) left join ad_ref_list_v list2 on (A_Asset.Amortizationtype = list2.value and list2.ad_reference_id = '800040' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (A_Asset.Amortizationcalctype = list3.value and list3.ad_reference_id = '800068' and list3.ad_language = ?)  left join ad_ref_list_v list4 on (A_Asset.Assetschedule = list4.value and list4.ad_reference_id = '800041' and list4.ad_language = ?)  left join (select C_Currency_ID, ISO_Code from C_Currency) table4 on (A_Asset.C_Currency_ID = table4.C_Currency_ID) left join ad_ref_list_v list5 on (list5.ad_reference_id = '800042' and list5.ad_language = ?  AND A_Asset.Processed = TO_CHAR(list5.value))" +
      "        WHERE 2=2 " +
      " AND A_ASSET.assettype not in ('CA','CC')" +
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
        Assets800078Data objectAssets800078Data = new Assets800078Data();
        objectAssets800078Data.created = UtilSql.getValue(result, "created");
        objectAssets800078Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectAssets800078Data.updated = UtilSql.getValue(result, "updated");
        objectAssets800078Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectAssets800078Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectAssets800078Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectAssets800078Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAssets800078Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectAssets800078Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAssets800078Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectAssets800078Data.documentno = UtilSql.getValue(result, "documentno");
        objectAssets800078Data.value = UtilSql.getValue(result, "value");
        objectAssets800078Data.name = UtilSql.getValue(result, "name");
        objectAssets800078Data.description = UtilSql.getValue(result, "description");
        objectAssets800078Data.isactive = UtilSql.getValue(result, "isactive");
        objectAssets800078Data.iscostcenter = UtilSql.getValue(result, "iscostcenter");
        objectAssets800078Data.assettype = UtilSql.getValue(result, "assettype");
        objectAssets800078Data.assettyper = UtilSql.getValue(result, "assettyper");
        objectAssets800078Data.aAssetGroupId = UtilSql.getValue(result, "a_asset_group_id");
        objectAssets800078Data.aAssetGroupIdr = UtilSql.getValue(result, "a_asset_group_idr");
        objectAssets800078Data.isdepreciated = UtilSql.getValue(result, "isdepreciated");
        objectAssets800078Data.isfullydepreciated = UtilSql.getValue(result, "isfullydepreciated");
        objectAssets800078Data.amortizationtype = UtilSql.getValue(result, "amortizationtype");
        objectAssets800078Data.amortizationtyper = UtilSql.getValue(result, "amortizationtyper");
        objectAssets800078Data.amortizationcalctype = UtilSql.getValue(result, "amortizationcalctype");
        objectAssets800078Data.amortizationcalctyper = UtilSql.getValue(result, "amortizationcalctyper");
        objectAssets800078Data.assetschedule = UtilSql.getValue(result, "assetschedule");
        objectAssets800078Data.assetscheduler = UtilSql.getValue(result, "assetscheduler");
        objectAssets800078Data.uselifeyears = UtilSql.getValue(result, "uselifeyears");
        objectAssets800078Data.uselifemonths = UtilSql.getValue(result, "uselifemonths");
        objectAssets800078Data.annualamortizationpercentage = UtilSql.getValue(result, "annualamortizationpercentage");
        objectAssets800078Data.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectAssets800078Data.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectAssets800078Data.datepurchased = UtilSql.getDateValue(result, "datepurchased", "dd-MM-yyyy");
        objectAssets800078Data.datecancelled = UtilSql.getDateValue(result, "datecancelled", "dd-MM-yyyy");
        objectAssets800078Data.amortizationstartdate = UtilSql.getDateValue(result, "amortizationstartdate", "dd-MM-yyyy");
        objectAssets800078Data.amortizationenddate = UtilSql.getDateValue(result, "amortizationenddate", "dd-MM-yyyy");
        objectAssets800078Data.assetvalueamt = UtilSql.getValue(result, "assetvalueamt");
        objectAssets800078Data.residualassetvalueamt = UtilSql.getValue(result, "residualassetvalueamt");
        objectAssets800078Data.amortizationvalueamt = UtilSql.getValue(result, "amortizationvalueamt");
        objectAssets800078Data.depreciatedpreviousamt = UtilSql.getValue(result, "depreciatedpreviousamt");
        objectAssets800078Data.depreciatedvalue = UtilSql.getValue(result, "depreciatedvalue");
        objectAssets800078Data.depreciatedplan = UtilSql.getValue(result, "depreciatedplan");
        objectAssets800078Data.processed = UtilSql.getValue(result, "processed");
        objectAssets800078Data.processedBtn = UtilSql.getValue(result, "processed_btn");
        objectAssets800078Data.locationcomment = UtilSql.getValue(result, "locationcomment");
        objectAssets800078Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectAssets800078Data.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectAssets800078Data.profit = UtilSql.getValue(result, "profit");
        objectAssets800078Data.isinposession = UtilSql.getValue(result, "isinposession");
        objectAssets800078Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectAssets800078Data.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectAssets800078Data.isdisposed = UtilSql.getValue(result, "isdisposed");
        objectAssets800078Data.assetservicedate = UtilSql.getDateValue(result, "assetservicedate", "dd-MM-yyyy");
        objectAssets800078Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectAssets800078Data.assetdepreciationdate = UtilSql.getDateValue(result, "assetdepreciationdate", "dd-MM-yyyy");
        objectAssets800078Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectAssets800078Data.lifeuseunits = UtilSql.getValue(result, "lifeuseunits");
        objectAssets800078Data.useunits = UtilSql.getValue(result, "useunits");
        objectAssets800078Data.assetdisposaldate = UtilSql.getDateValue(result, "assetdisposaldate", "dd-MM-yyyy");
        objectAssets800078Data.guaranteedate = UtilSql.getDateValue(result, "guaranteedate", "dd-MM-yyyy");
        objectAssets800078Data.isowned = UtilSql.getValue(result, "isowned");
        objectAssets800078Data.help = UtilSql.getValue(result, "help");
        objectAssets800078Data.versionno = UtilSql.getValue(result, "versionno");
        objectAssets800078Data.serno = UtilSql.getValue(result, "serno");
        objectAssets800078Data.acctvalueamt = UtilSql.getValue(result, "acctvalueamt");
        objectAssets800078Data.lot = UtilSql.getValue(result, "lot");
        objectAssets800078Data.language = UtilSql.getValue(result, "language");
        objectAssets800078Data.adUserClient = "";
        objectAssets800078Data.adOrgClient = "";
        objectAssets800078Data.createdby = "";
        objectAssets800078Data.trBgcolor = "";
        objectAssets800078Data.totalCount = "";
        objectAssets800078Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAssets800078Data);
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
    Assets800078Data objectAssets800078Data[] = new Assets800078Data[vector.size()];
    vector.copyInto(objectAssets800078Data);
    return(objectAssets800078Data);
  }

/**
Create a registry
 */
  public static Assets800078Data[] set(String name, String adClientId, String versionno, String datepurchased, String iscostcenter, String aAssetGroupId, String adOrgId, String assetvalueamt, String isowned, String help, String locationcomment, String annualamortizationpercentage, String processed, String processedBtn, String cBpartnerId, String aAssetId, String isdisposed, String residualassetvalueamt, String documentno, String uselifemonths, String createdby, String createdbyr, String depreciatedplan, String datecancelled, String amortizationcalctype, String value, String isdepreciated, String isinposession, String amortizationstartdate, String depreciatedpreviousamt, String useunits, String acctvalueamt, String amortizationenddate, String lot, String amortizationvalueamt, String uselifeyears, String adUserId, String cProjectId, String amortizationtype, String serno, String description, String isfullydepreciated, String updatedby, String updatedbyr, String cBpartnerLocationId, String assetdepreciationdate, String guaranteedate, String assetservicedate, String cCurrencyId, String isactive, String depreciatedvalue, String cLocationId, String assetschedule, String assettype, String profit, String lifeuseunits, String assetdisposaldate)    throws ServletException {
    Assets800078Data objectAssets800078Data[] = new Assets800078Data[1];
    objectAssets800078Data[0] = new Assets800078Data();
    objectAssets800078Data[0].created = "";
    objectAssets800078Data[0].createdbyr = createdbyr;
    objectAssets800078Data[0].updated = "";
    objectAssets800078Data[0].updatedTimeStamp = "";
    objectAssets800078Data[0].updatedby = updatedby;
    objectAssets800078Data[0].updatedbyr = updatedbyr;
    objectAssets800078Data[0].adClientId = adClientId;
    objectAssets800078Data[0].adClientIdr = "";
    objectAssets800078Data[0].adOrgId = adOrgId;
    objectAssets800078Data[0].adOrgIdr = "";
    objectAssets800078Data[0].documentno = documentno;
    objectAssets800078Data[0].value = value;
    objectAssets800078Data[0].name = name;
    objectAssets800078Data[0].description = description;
    objectAssets800078Data[0].isactive = isactive;
    objectAssets800078Data[0].iscostcenter = iscostcenter;
    objectAssets800078Data[0].assettype = assettype;
    objectAssets800078Data[0].assettyper = "";
    objectAssets800078Data[0].aAssetGroupId = aAssetGroupId;
    objectAssets800078Data[0].aAssetGroupIdr = "";
    objectAssets800078Data[0].isdepreciated = isdepreciated;
    objectAssets800078Data[0].isfullydepreciated = isfullydepreciated;
    objectAssets800078Data[0].amortizationtype = amortizationtype;
    objectAssets800078Data[0].amortizationtyper = "";
    objectAssets800078Data[0].amortizationcalctype = amortizationcalctype;
    objectAssets800078Data[0].amortizationcalctyper = "";
    objectAssets800078Data[0].assetschedule = assetschedule;
    objectAssets800078Data[0].assetscheduler = "";
    objectAssets800078Data[0].uselifeyears = uselifeyears;
    objectAssets800078Data[0].uselifemonths = uselifemonths;
    objectAssets800078Data[0].annualamortizationpercentage = annualamortizationpercentage;
    objectAssets800078Data[0].cCurrencyId = cCurrencyId;
    objectAssets800078Data[0].cCurrencyIdr = "";
    objectAssets800078Data[0].datepurchased = datepurchased;
    objectAssets800078Data[0].datecancelled = datecancelled;
    objectAssets800078Data[0].amortizationstartdate = amortizationstartdate;
    objectAssets800078Data[0].amortizationenddate = amortizationenddate;
    objectAssets800078Data[0].assetvalueamt = assetvalueamt;
    objectAssets800078Data[0].residualassetvalueamt = residualassetvalueamt;
    objectAssets800078Data[0].amortizationvalueamt = amortizationvalueamt;
    objectAssets800078Data[0].depreciatedpreviousamt = depreciatedpreviousamt;
    objectAssets800078Data[0].depreciatedvalue = depreciatedvalue;
    objectAssets800078Data[0].depreciatedplan = depreciatedplan;
    objectAssets800078Data[0].processed = processed;
    objectAssets800078Data[0].processedBtn = processedBtn;
    objectAssets800078Data[0].locationcomment = locationcomment;
    objectAssets800078Data[0].cProjectId = cProjectId;
    objectAssets800078Data[0].cBpartnerLocationId = cBpartnerLocationId;
    objectAssets800078Data[0].profit = profit;
    objectAssets800078Data[0].isinposession = isinposession;
    objectAssets800078Data[0].aAssetId = aAssetId;
    objectAssets800078Data[0].cLocationId = cLocationId;
    objectAssets800078Data[0].isdisposed = isdisposed;
    objectAssets800078Data[0].assetservicedate = assetservicedate;
    objectAssets800078Data[0].adUserId = adUserId;
    objectAssets800078Data[0].assetdepreciationdate = assetdepreciationdate;
    objectAssets800078Data[0].cBpartnerId = cBpartnerId;
    objectAssets800078Data[0].lifeuseunits = lifeuseunits;
    objectAssets800078Data[0].useunits = useunits;
    objectAssets800078Data[0].assetdisposaldate = assetdisposaldate;
    objectAssets800078Data[0].guaranteedate = guaranteedate;
    objectAssets800078Data[0].isowned = isowned;
    objectAssets800078Data[0].help = help;
    objectAssets800078Data[0].versionno = versionno;
    objectAssets800078Data[0].serno = serno;
    objectAssets800078Data[0].acctvalueamt = acctvalueamt;
    objectAssets800078Data[0].lot = lot;
    objectAssets800078Data[0].language = "";
    return objectAssets800078Data;
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
  public static String selectDef8063_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , DocumentNo = (?) , Value = (?) , Name = (?) , Description = (?) , IsActive = (?) , Iscostcenter = (?) , Assettype = (?) , A_Asset_Group_ID = (?) , IsDepreciated = (?) , IsFullyDepreciated = (?) , Amortizationtype = (?) , Amortizationcalctype = (?) , Assetschedule = (?) , UseLifeYears = TO_NUMBER(?) , UseLifeMonths = TO_NUMBER(?) , Annualamortizationpercentage = TO_NUMBER(?) , C_Currency_ID = (?) , Datepurchased = TO_DATE(?) , Datecancelled = TO_DATE(?) , Amortizationstartdate = TO_DATE(?) , Amortizationenddate = TO_DATE(?) , AssetValueAmt = TO_NUMBER(?) , Residualassetvalueamt = TO_NUMBER(?) , Amortizationvalueamt = TO_NUMBER(?) , Depreciatedpreviousamt = TO_NUMBER(?) , Depreciatedvalue = TO_NUMBER(?) , Depreciatedplan = TO_NUMBER(?) , Processed = (?) , LocationComment = (?) , C_Project_ID = (?) , C_BPartner_Location_ID = (?) , Profit = TO_NUMBER(?) , IsInPosession = (?) , A_Asset_ID = (?) , C_Location_ID = (?) , IsDisposed = (?) , AssetServiceDate = TO_DATE(?) , AD_User_ID = (?) , AssetDepreciationDate = TO_DATE(?) , C_BPartner_ID = (?) , LifeUseUnits = TO_NUMBER(?) , UseUnits = TO_NUMBER(?) , AssetDisposalDate = TO_DATE(?) , GuaranteeDate = TO_DATE(?) , IsOwned = (?) , Help = (?) , VersionNo = (?) , SerNo = (?) , Acctvalueamt = TO_NUMBER(?) , Lot = (?) , updated = now(), updatedby = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscostcenter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assettype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdepreciated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfullydepreciated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationcalctype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetschedule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uselifeyears);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uselifemonths);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, annualamortizationpercentage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepurchased);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecancelled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationstartdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationenddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, residualassetvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedpreviousamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, locationcomment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, profit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinposession);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisposed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetservicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetdepreciationdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lifeuseunits);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, useunits);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetdisposaldate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isowned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, versionno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lot);
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
      "        (AD_Client_ID, AD_Org_ID, DocumentNo, Value, Name, Description, IsActive, Iscostcenter, Assettype, A_Asset_Group_ID, IsDepreciated, IsFullyDepreciated, Amortizationtype, Amortizationcalctype, Assetschedule, UseLifeYears, UseLifeMonths, Annualamortizationpercentage, C_Currency_ID, Datepurchased, Datecancelled, Amortizationstartdate, Amortizationenddate, AssetValueAmt, Residualassetvalueamt, Amortizationvalueamt, Depreciatedpreviousamt, Depreciatedvalue, Depreciatedplan, Processed, LocationComment, C_Project_ID, C_BPartner_Location_ID, Profit, IsInPosession, A_Asset_ID, C_Location_ID, IsDisposed, AssetServiceDate, AD_User_ID, AssetDepreciationDate, C_BPartner_ID, LifeUseUnits, UseUnits, AssetDisposalDate, GuaranteeDate, IsOwned, Help, VersionNo, SerNo, Acctvalueamt, Lot, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_DATE(?), (?), TO_DATE(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscostcenter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assettype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdepreciated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfullydepreciated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationcalctype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetschedule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uselifeyears);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uselifemonths);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, annualamortizationpercentage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepurchased);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecancelled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationstartdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationenddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, residualassetvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedpreviousamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, locationcomment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, profit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinposession);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisposed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetservicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetdepreciationdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lifeuseunits);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, useunits);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetdisposaldate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isowned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, versionno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lot);
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
