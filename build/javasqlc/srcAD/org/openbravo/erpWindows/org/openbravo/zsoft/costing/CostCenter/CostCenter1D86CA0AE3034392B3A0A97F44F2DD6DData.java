//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.costing.CostCenter;

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
class CostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData implements FieldProvider {
static Logger log4j = Logger.getLogger(CostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String isdisposed;
  public String isowned;
  public String assetdepreciationdate;
  public String isdepreciated;
  public String aAssetId;
  public String useunits;
  public String isfullydepreciated;
  public String lifeuseunits;
  public String cBpartnerLocationId;
  public String isinposession;
  public String cBpartnerId;
  public String adClientId;
  public String adClientIdr;
  public String datepurchased;
  public String adOrgId;
  public String adOrgIdr;
  public String datecancelled;
  public String assettype;
  public String assettyper;
  public String amortizationstartdate;
  public String isactive;
  public String amortizationenddate;
  public String issummary;
  public String annualamortizationpercentage;
  public String adUserId;
  public String adUserIdr;
  public String cCurrencyId;
  public String value;
  public String assetvalueamt;
  public String name;
  public String residualassetvalueamt;
  public String help;
  public String description;
  public String acctvalueamt;
  public String cLocationId;
  public String cLocationIdr;
  public String amortizationtype;
  public String locationcomment;
  public String amortizationvalueamt;
  public String lot;
  public String assetschedule;
  public String versionno;
  public String documentno;
  public String serno;
  public String assetdisposaldate;
  public String processed;
  public String guaranteedate;
  public String profit;
  public String uselifeyears;
  public String uselifemonths;
  public String depreciatedvalue;
  public String assetservicedate;
  public String depreciatedplan;
  public String depreciatedpreviousamt;
  public String aAssetGroupId;
  public String amortizationcalctype;
  public String cProjectId;
  public String iscostcenter;
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
    else if (fieldName.equalsIgnoreCase("isdisposed"))
      return isdisposed;
    else if (fieldName.equalsIgnoreCase("isowned"))
      return isowned;
    else if (fieldName.equalsIgnoreCase("assetdepreciationdate"))
      return assetdepreciationdate;
    else if (fieldName.equalsIgnoreCase("isdepreciated"))
      return isdepreciated;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("useunits"))
      return useunits;
    else if (fieldName.equalsIgnoreCase("isfullydepreciated"))
      return isfullydepreciated;
    else if (fieldName.equalsIgnoreCase("lifeuseunits"))
      return lifeuseunits;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("isinposession"))
      return isinposession;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("datepurchased"))
      return datepurchased;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("datecancelled"))
      return datecancelled;
    else if (fieldName.equalsIgnoreCase("assettype"))
      return assettype;
    else if (fieldName.equalsIgnoreCase("assettyper"))
      return assettyper;
    else if (fieldName.equalsIgnoreCase("amortizationstartdate"))
      return amortizationstartdate;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("amortizationenddate"))
      return amortizationenddate;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("annualamortizationpercentage"))
      return annualamortizationpercentage;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("assetvalueamt"))
      return assetvalueamt;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("residualassetvalueamt"))
      return residualassetvalueamt;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("acctvalueamt"))
      return acctvalueamt;
    else if (fieldName.equalsIgnoreCase("c_location_id") || fieldName.equals("cLocationId"))
      return cLocationId;
    else if (fieldName.equalsIgnoreCase("c_location_idr") || fieldName.equals("cLocationIdr"))
      return cLocationIdr;
    else if (fieldName.equalsIgnoreCase("amortizationtype"))
      return amortizationtype;
    else if (fieldName.equalsIgnoreCase("locationcomment"))
      return locationcomment;
    else if (fieldName.equalsIgnoreCase("amortizationvalueamt"))
      return amortizationvalueamt;
    else if (fieldName.equalsIgnoreCase("lot"))
      return lot;
    else if (fieldName.equalsIgnoreCase("assetschedule"))
      return assetschedule;
    else if (fieldName.equalsIgnoreCase("versionno"))
      return versionno;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("serno"))
      return serno;
    else if (fieldName.equalsIgnoreCase("assetdisposaldate"))
      return assetdisposaldate;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("guaranteedate"))
      return guaranteedate;
    else if (fieldName.equalsIgnoreCase("profit"))
      return profit;
    else if (fieldName.equalsIgnoreCase("uselifeyears"))
      return uselifeyears;
    else if (fieldName.equalsIgnoreCase("uselifemonths"))
      return uselifemonths;
    else if (fieldName.equalsIgnoreCase("depreciatedvalue"))
      return depreciatedvalue;
    else if (fieldName.equalsIgnoreCase("assetservicedate"))
      return assetservicedate;
    else if (fieldName.equalsIgnoreCase("depreciatedplan"))
      return depreciatedplan;
    else if (fieldName.equalsIgnoreCase("depreciatedpreviousamt"))
      return depreciatedpreviousamt;
    else if (fieldName.equalsIgnoreCase("a_asset_group_id") || fieldName.equals("aAssetGroupId"))
      return aAssetGroupId;
    else if (fieldName.equalsIgnoreCase("amortizationcalctype"))
      return amortizationcalctype;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("iscostcenter"))
      return iscostcenter;
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
  public static CostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(A_Asset.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = A_Asset.CreatedBy) as CreatedByR, " +
      "        to_char(A_Asset.Updated, ?) as updated, " +
      "        to_char(A_Asset.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        A_Asset.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = A_Asset.UpdatedBy) as UpdatedByR," +
      "        COALESCE(A_Asset.IsDisposed, 'N') AS IsDisposed, " +
      "COALESCE(A_Asset.IsOwned, 'N') AS IsOwned, " +
      "A_Asset.AssetDepreciationDate, " +
      "COALESCE(A_Asset.IsDepreciated, 'N') AS IsDepreciated, " +
      "A_Asset.A_Asset_ID, " +
      "A_Asset.UseUnits, " +
      "COALESCE(A_Asset.IsFullyDepreciated, 'N') AS IsFullyDepreciated, " +
      "A_Asset.LifeUseUnits, " +
      "A_Asset.C_BPartner_Location_ID, " +
      "COALESCE(A_Asset.IsInPosession, 'N') AS IsInPosession, " +
      "A_Asset.C_BPartner_ID, " +
      "A_Asset.AD_Client_ID, " +
      "(CASE WHEN A_Asset.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "A_Asset.Datepurchased, " +
      "A_Asset.AD_Org_ID, " +
      "(CASE WHEN A_Asset.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "A_Asset.Datecancelled, " +
      "A_Asset.Assettype, " +
      "(CASE WHEN A_Asset.Assettype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS AssettypeR, " +
      "A_Asset.Amortizationstartdate, " +
      "COALESCE(A_Asset.IsActive, 'N') AS IsActive, " +
      "A_Asset.Amortizationenddate, " +
      "COALESCE(A_Asset.Issummary, 'N') AS Issummary, " +
      "A_Asset.Annualamortizationpercentage, " +
      "A_Asset.AD_User_ID, " +
      "(CASE WHEN A_Asset.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "A_Asset.C_Currency_ID, " +
      "A_Asset.Value, " +
      "A_Asset.AssetValueAmt, " +
      "A_Asset.Name, " +
      "A_Asset.Residualassetvalueamt, " +
      "A_Asset.Help, " +
      "A_Asset.Description, " +
      "A_Asset.Acctvalueamt, " +
      "A_Asset.C_Location_ID, " +
      "(CASE WHEN A_Asset.C_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Address1), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Address2), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Postal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.City), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS C_Location_IDR, " +
      "A_Asset.Amortizationtype, " +
      "A_Asset.LocationComment, " +
      "A_Asset.Amortizationvalueamt, " +
      "A_Asset.Lot, " +
      "A_Asset.Assetschedule, " +
      "A_Asset.VersionNo, " +
      "A_Asset.DocumentNo, " +
      "A_Asset.SerNo, " +
      "A_Asset.AssetDisposalDate, " +
      "A_Asset.Processed, " +
      "A_Asset.GuaranteeDate, " +
      "A_Asset.Profit, " +
      "A_Asset.UseLifeYears, " +
      "A_Asset.UseLifeMonths, " +
      "A_Asset.Depreciatedvalue, " +
      "A_Asset.AssetServiceDate, " +
      "A_Asset.Depreciatedplan, " +
      "A_Asset.Depreciatedpreviousamt, " +
      "A_Asset.A_Asset_Group_ID, " +
      "A_Asset.Amortizationcalctype, " +
      "A_Asset.C_Project_ID, " +
      "COALESCE(A_Asset.Iscostcenter, 'N') AS Iscostcenter, " +
      "        ? AS LANGUAGE " +
      "        FROM A_Asset left join (select AD_Client_ID, Name from AD_Client) table1 on (A_Asset.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (A_Asset.AD_Org_ID = table2.AD_Org_ID) left join ad_ref_list_v list1 on (A_Asset.Assettype = list1.value and list1.ad_reference_id = '65DF5707867B448CB985D4ED8FE6CB17' and list1.ad_language = ?)  left join (select AD_User_ID, Name from AD_User) table3 on (A_Asset.AD_User_ID = table3.AD_User_ID) left join (select C_Location_ID, Address1, Address2, Postal, City, C_Region_ID, C_Country_ID from C_Location) table4 on (A_Asset.C_Location_ID = table4.C_Location_ID) left join (select C_Region_ID, Name from C_Region) table5 on (table4.C_Region_ID = table5.C_Region_ID) left join (select C_Country_ID, Name from C_Country) table6 on (table4.C_Country_ID = table6.C_Country_ID) left join (select C_Country_ID,AD_Language, Name from C_Country_TRL) tableTRL6 on (table6.C_Country_ID = tableTRL6.C_Country_ID and tableTRL6.AD_Language = ?) " +
      "        WHERE 2=2 " +
      " AND a_asset.assettype in ('OA','CC','RE') and a_asset.iscostcenter='Y'" +
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
        CostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData = new CostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData();
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.created = UtilSql.getValue(result, "created");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.updated = UtilSql.getValue(result, "updated");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.updatedby = UtilSql.getValue(result, "updatedby");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.isdisposed = UtilSql.getValue(result, "isdisposed");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.isowned = UtilSql.getValue(result, "isowned");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.assetdepreciationdate = UtilSql.getDateValue(result, "assetdepreciationdate", "dd-MM-yyyy");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.isdepreciated = UtilSql.getValue(result, "isdepreciated");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.useunits = UtilSql.getValue(result, "useunits");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.isfullydepreciated = UtilSql.getValue(result, "isfullydepreciated");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.lifeuseunits = UtilSql.getValue(result, "lifeuseunits");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.isinposession = UtilSql.getValue(result, "isinposession");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.datepurchased = UtilSql.getDateValue(result, "datepurchased", "dd-MM-yyyy");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.datecancelled = UtilSql.getDateValue(result, "datecancelled", "dd-MM-yyyy");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.assettype = UtilSql.getValue(result, "assettype");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.assettyper = UtilSql.getValue(result, "assettyper");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.amortizationstartdate = UtilSql.getDateValue(result, "amortizationstartdate", "dd-MM-yyyy");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.isactive = UtilSql.getValue(result, "isactive");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.amortizationenddate = UtilSql.getDateValue(result, "amortizationenddate", "dd-MM-yyyy");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.issummary = UtilSql.getValue(result, "issummary");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.annualamortizationpercentage = UtilSql.getValue(result, "annualamortizationpercentage");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.value = UtilSql.getValue(result, "value");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.assetvalueamt = UtilSql.getValue(result, "assetvalueamt");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.name = UtilSql.getValue(result, "name");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.residualassetvalueamt = UtilSql.getValue(result, "residualassetvalueamt");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.help = UtilSql.getValue(result, "help");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.description = UtilSql.getValue(result, "description");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.acctvalueamt = UtilSql.getValue(result, "acctvalueamt");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.cLocationIdr = UtilSql.getValue(result, "c_location_idr");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.amortizationtype = UtilSql.getValue(result, "amortizationtype");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.locationcomment = UtilSql.getValue(result, "locationcomment");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.amortizationvalueamt = UtilSql.getValue(result, "amortizationvalueamt");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.lot = UtilSql.getValue(result, "lot");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.assetschedule = UtilSql.getValue(result, "assetschedule");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.versionno = UtilSql.getValue(result, "versionno");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.documentno = UtilSql.getValue(result, "documentno");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.serno = UtilSql.getValue(result, "serno");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.assetdisposaldate = UtilSql.getDateValue(result, "assetdisposaldate", "dd-MM-yyyy");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.processed = UtilSql.getValue(result, "processed");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.guaranteedate = UtilSql.getDateValue(result, "guaranteedate", "dd-MM-yyyy");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.profit = UtilSql.getValue(result, "profit");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.uselifeyears = UtilSql.getValue(result, "uselifeyears");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.uselifemonths = UtilSql.getValue(result, "uselifemonths");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.depreciatedvalue = UtilSql.getValue(result, "depreciatedvalue");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.assetservicedate = UtilSql.getDateValue(result, "assetservicedate", "dd-MM-yyyy");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.depreciatedplan = UtilSql.getValue(result, "depreciatedplan");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.depreciatedpreviousamt = UtilSql.getValue(result, "depreciatedpreviousamt");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.aAssetGroupId = UtilSql.getValue(result, "a_asset_group_id");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.amortizationcalctype = UtilSql.getValue(result, "amortizationcalctype");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.iscostcenter = UtilSql.getValue(result, "iscostcenter");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.language = UtilSql.getValue(result, "language");
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.adUserClient = "";
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.adOrgClient = "";
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.createdby = "";
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.trBgcolor = "";
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.totalCount = "";
        objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData);
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
    CostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[] = new CostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[vector.size()];
    vector.copyInto(objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData);
    return(objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData);
  }

/**
Create a registry
 */
  public static CostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[] set(String adClientId, String name, String guaranteedate, String isfullydepreciated, String adOrgId, String isowned, String assetdisposaldate, String cCurrencyId, String assetservicedate, String depreciatedvalue, String cLocationId, String cLocationIdr, String assetschedule, String cBpartnerId, String amortizationenddate, String aAssetId, String isdisposed, String lot, String uselifemonths, String createdby, String createdbyr, String amortizationtype, String value, String serno, String amortizationvalueamt, String isinposession, String adUserId, String useunits, String acctvalueamt, String documentno, String issummary, String residualassetvalueamt, String uselifeyears, String depreciatedpreviousamt, String amortizationstartdate, String cProjectId, String depreciatedplan, String datecancelled, String amortizationcalctype, String isdepreciated, String description, String versionno, String datepurchased, String updatedby, String updatedbyr, String cBpartnerLocationId, String assetdepreciationdate, String locationcomment, String annualamortizationpercentage, String isactive, String processed, String aAssetGroupId, String assetvalueamt, String assettype, String iscostcenter, String help, String lifeuseunits, String profit)    throws ServletException {
    CostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[] = new CostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[1];
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0] = new CostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData();
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].created = "";
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].createdbyr = createdbyr;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].updated = "";
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].updatedTimeStamp = "";
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].updatedby = updatedby;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].updatedbyr = updatedbyr;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].isdisposed = isdisposed;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].isowned = isowned;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].assetdepreciationdate = assetdepreciationdate;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].isdepreciated = isdepreciated;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].aAssetId = aAssetId;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].useunits = useunits;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].isfullydepreciated = isfullydepreciated;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].lifeuseunits = lifeuseunits;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].isinposession = isinposession;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].cBpartnerId = cBpartnerId;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].adClientId = adClientId;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].adClientIdr = "";
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].datepurchased = datepurchased;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].adOrgId = adOrgId;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].adOrgIdr = "";
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].datecancelled = datecancelled;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].assettype = assettype;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].assettyper = "";
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].amortizationstartdate = amortizationstartdate;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].isactive = isactive;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].amortizationenddate = amortizationenddate;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].issummary = issummary;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].annualamortizationpercentage = annualamortizationpercentage;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].adUserId = adUserId;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].adUserIdr = "";
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].cCurrencyId = cCurrencyId;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].value = value;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].assetvalueamt = assetvalueamt;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].name = name;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].residualassetvalueamt = residualassetvalueamt;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].help = help;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].description = description;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].acctvalueamt = acctvalueamt;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].cLocationId = cLocationId;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].cLocationIdr = cLocationIdr;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].amortizationtype = amortizationtype;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].locationcomment = locationcomment;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].amortizationvalueamt = amortizationvalueamt;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].lot = lot;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].assetschedule = assetschedule;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].versionno = versionno;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].documentno = documentno;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].serno = serno;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].assetdisposaldate = assetdisposaldate;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].processed = processed;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].guaranteedate = guaranteedate;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].profit = profit;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].uselifeyears = uselifeyears;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].uselifemonths = uselifemonths;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].depreciatedvalue = depreciatedvalue;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].assetservicedate = assetservicedate;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].depreciatedplan = depreciatedplan;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].depreciatedpreviousamt = depreciatedpreviousamt;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].aAssetGroupId = aAssetGroupId;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].amortizationcalctype = amortizationcalctype;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].cProjectId = cProjectId;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].iscostcenter = iscostcenter;
    objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData[0].language = "";
    return objectCostCenter1D86CA0AE3034392B3A0A97F44F2DD6DData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef8049_0(ConnectionProvider connectionProvider, String C_Location_IDR)    throws ServletException {
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
  public static String selectDef8045_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
      "        SET IsDisposed = (?) , IsOwned = (?) , AssetDepreciationDate = TO_DATE(?) , IsDepreciated = (?) , A_Asset_ID = (?) , UseUnits = TO_NUMBER(?) , IsFullyDepreciated = (?) , LifeUseUnits = TO_NUMBER(?) , C_BPartner_Location_ID = (?) , IsInPosession = (?) , C_BPartner_ID = (?) , AD_Client_ID = (?) , Datepurchased = TO_DATE(?) , AD_Org_ID = (?) , Datecancelled = TO_DATE(?) , Assettype = (?) , Amortizationstartdate = TO_DATE(?) , IsActive = (?) , Amortizationenddate = TO_DATE(?) , Issummary = (?) , Annualamortizationpercentage = TO_NUMBER(?) , AD_User_ID = (?) , C_Currency_ID = (?) , Value = (?) , AssetValueAmt = TO_NUMBER(?) , Name = (?) , Residualassetvalueamt = TO_NUMBER(?) , Help = (?) , Description = (?) , Acctvalueamt = TO_NUMBER(?) , C_Location_ID = (?) , Amortizationtype = (?) , LocationComment = (?) , Amortizationvalueamt = TO_NUMBER(?) , Lot = (?) , Assetschedule = (?) , VersionNo = (?) , DocumentNo = (?) , SerNo = (?) , AssetDisposalDate = TO_DATE(?) , Processed = (?) , GuaranteeDate = TO_DATE(?) , Profit = TO_NUMBER(?) , UseLifeYears = TO_NUMBER(?) , UseLifeMonths = TO_NUMBER(?) , Depreciatedvalue = TO_NUMBER(?) , AssetServiceDate = TO_DATE(?) , Depreciatedplan = TO_NUMBER(?) , Depreciatedpreviousamt = TO_NUMBER(?) , A_Asset_Group_ID = (?) , Amortizationcalctype = (?) , C_Project_ID = (?) , Iscostcenter = (?) , updated = now(), updatedby = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisposed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isowned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetdepreciationdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdepreciated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, useunits);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfullydepreciated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lifeuseunits);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinposession);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepurchased);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecancelled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assettype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationstartdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationenddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, annualamortizationpercentage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, residualassetvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, locationcomment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lot);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetschedule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, versionno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetdisposaldate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, profit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uselifeyears);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uselifemonths);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetservicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedpreviousamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationcalctype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscostcenter);
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
      "        (IsDisposed, IsOwned, AssetDepreciationDate, IsDepreciated, A_Asset_ID, UseUnits, IsFullyDepreciated, LifeUseUnits, C_BPartner_Location_ID, IsInPosession, C_BPartner_ID, AD_Client_ID, Datepurchased, AD_Org_ID, Datecancelled, Assettype, Amortizationstartdate, IsActive, Amortizationenddate, Issummary, Annualamortizationpercentage, AD_User_ID, C_Currency_ID, Value, AssetValueAmt, Name, Residualassetvalueamt, Help, Description, Acctvalueamt, C_Location_ID, Amortizationtype, LocationComment, Amortizationvalueamt, Lot, Assetschedule, VersionNo, DocumentNo, SerNo, AssetDisposalDate, Processed, GuaranteeDate, Profit, UseLifeYears, UseLifeMonths, Depreciatedvalue, AssetServiceDate, Depreciatedplan, Depreciatedpreviousamt, A_Asset_Group_ID, Amortizationcalctype, C_Project_ID, Iscostcenter, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_DATE(?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_DATE(?), (?), TO_DATE(?), (?), TO_DATE(?), (?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_DATE(?), (?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisposed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isowned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetdepreciationdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdepreciated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, useunits);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfullydepreciated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lifeuseunits);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinposession);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepurchased);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecancelled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assettype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationstartdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationenddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, annualamortizationpercentage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, residualassetvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, locationcomment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lot);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetschedule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, versionno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetdisposaldate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, profit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uselifeyears);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uselifemonths);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetservicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, depreciatedpreviousamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortizationcalctype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscostcenter);
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
