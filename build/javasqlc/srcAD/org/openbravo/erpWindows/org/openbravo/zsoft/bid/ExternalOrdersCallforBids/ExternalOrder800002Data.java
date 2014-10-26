//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.bid.ExternalOrdersCallforBids;

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
class ExternalOrder800002Data implements FieldProvider {
static Logger log4j = Logger.getLogger(ExternalOrder800002Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cProjecttypeId;
  public String cPhaseId;
  public String invoicedqty;
  public String generateto;
  public String cCampaignId;
  public String processed;
  public String projectbalanceamt;
  public String mPricelistVersionId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String value;
  public String isactive;
  public String billtoId;
  public String projectcategory;
  public String projectcategoryr;
  public String name;
  public String description;
  public String projectphase;
  public String note;
  public String generateorder;
  public String projectstatus;
  public String projectstatusr;
  public String startdate;
  public String datecontract;
  public String datefinish;
  public String plannedpoamt;
  public String cLocationId;
  public String cLocationIdr;
  public String lastplannedproposaldate;
  public String salesrepId;
  public String salesrepIdr;
  public String documentCopies;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String accountno;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String responsibleId;
  public String adUserId;
  public String adUserIdr;
  public String poreference;
  public String paymentrule;
  public String paymentruler;
  public String servmargin;
  public String cPaymenttermId;
  public String cPaymenttermIdr;
  public String expreinvoicing;
  public String mPricelistId;
  public String mPricelistIdr;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String expmargin;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String setprojecttype;
  public String plannedamt;
  public String cProjectphaseId;
  public String plannedqty;
  public String createtemppricelist;
  public String plannedmarginamt;
  public String iscommitment;
  public String projectkind;
  public String iscommitceiling;
  public String publicprivate;
  public String committedamt;
  public String aAssetId;
  public String committedqty;
  public String schedulestatus;
  public String servrevenue;
  public String actualcostamount;
  public String expexpenses;
  public String percentdoneyet;
  public String servcost;
  public String estimatedamt;
  public String invoicedamt;
  public String changeprojectstatus;
  public String closeproject;
  public String copyfrom;
  public String issummary;
  public String invoiceToproject;
  public String cProjectId;
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
    else if (fieldName.equalsIgnoreCase("c_projecttype_id") || fieldName.equals("cProjecttypeId"))
      return cProjecttypeId;
    else if (fieldName.equalsIgnoreCase("c_phase_id") || fieldName.equals("cPhaseId"))
      return cPhaseId;
    else if (fieldName.equalsIgnoreCase("invoicedqty"))
      return invoicedqty;
    else if (fieldName.equalsIgnoreCase("generateto"))
      return generateto;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("projectbalanceamt"))
      return projectbalanceamt;
    else if (fieldName.equalsIgnoreCase("m_pricelist_version_id") || fieldName.equals("mPricelistVersionId"))
      return mPricelistVersionId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("billto_id") || fieldName.equals("billtoId"))
      return billtoId;
    else if (fieldName.equalsIgnoreCase("projectcategory"))
      return projectcategory;
    else if (fieldName.equalsIgnoreCase("projectcategoryr"))
      return projectcategoryr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("projectphase"))
      return projectphase;
    else if (fieldName.equalsIgnoreCase("note"))
      return note;
    else if (fieldName.equalsIgnoreCase("generateorder"))
      return generateorder;
    else if (fieldName.equalsIgnoreCase("projectstatus"))
      return projectstatus;
    else if (fieldName.equalsIgnoreCase("projectstatusr"))
      return projectstatusr;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("datecontract"))
      return datecontract;
    else if (fieldName.equalsIgnoreCase("datefinish"))
      return datefinish;
    else if (fieldName.equalsIgnoreCase("plannedpoamt"))
      return plannedpoamt;
    else if (fieldName.equalsIgnoreCase("c_location_id") || fieldName.equals("cLocationId"))
      return cLocationId;
    else if (fieldName.equalsIgnoreCase("c_location_idr") || fieldName.equals("cLocationIdr"))
      return cLocationIdr;
    else if (fieldName.equalsIgnoreCase("lastplannedproposaldate"))
      return lastplannedproposaldate;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("document_copies") || fieldName.equals("documentCopies"))
      return documentCopies;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("accountno"))
      return accountno;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("responsible_id") || fieldName.equals("responsibleId"))
      return responsibleId;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("paymentruler"))
      return paymentruler;
    else if (fieldName.equalsIgnoreCase("servmargin"))
      return servmargin;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_idr") || fieldName.equals("cPaymenttermIdr"))
      return cPaymenttermIdr;
    else if (fieldName.equalsIgnoreCase("expreinvoicing"))
      return expreinvoicing;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_idr") || fieldName.equals("mPricelistIdr"))
      return mPricelistIdr;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("expmargin"))
      return expmargin;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("setprojecttype"))
      return setprojecttype;
    else if (fieldName.equalsIgnoreCase("plannedamt"))
      return plannedamt;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
    else if (fieldName.equalsIgnoreCase("plannedqty"))
      return plannedqty;
    else if (fieldName.equalsIgnoreCase("createtemppricelist"))
      return createtemppricelist;
    else if (fieldName.equalsIgnoreCase("plannedmarginamt"))
      return plannedmarginamt;
    else if (fieldName.equalsIgnoreCase("iscommitment"))
      return iscommitment;
    else if (fieldName.equalsIgnoreCase("projectkind"))
      return projectkind;
    else if (fieldName.equalsIgnoreCase("iscommitceiling"))
      return iscommitceiling;
    else if (fieldName.equalsIgnoreCase("publicprivate"))
      return publicprivate;
    else if (fieldName.equalsIgnoreCase("committedamt"))
      return committedamt;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("committedqty"))
      return committedqty;
    else if (fieldName.equalsIgnoreCase("schedulestatus"))
      return schedulestatus;
    else if (fieldName.equalsIgnoreCase("servrevenue"))
      return servrevenue;
    else if (fieldName.equalsIgnoreCase("actualcostamount"))
      return actualcostamount;
    else if (fieldName.equalsIgnoreCase("expexpenses"))
      return expexpenses;
    else if (fieldName.equalsIgnoreCase("percentdoneyet"))
      return percentdoneyet;
    else if (fieldName.equalsIgnoreCase("servcost"))
      return servcost;
    else if (fieldName.equalsIgnoreCase("estimatedamt"))
      return estimatedamt;
    else if (fieldName.equalsIgnoreCase("invoicedamt"))
      return invoicedamt;
    else if (fieldName.equalsIgnoreCase("changeprojectstatus"))
      return changeprojectstatus;
    else if (fieldName.equalsIgnoreCase("closeproject"))
      return closeproject;
    else if (fieldName.equalsIgnoreCase("copyfrom"))
      return copyfrom;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("invoice_toproject") || fieldName.equals("invoiceToproject"))
      return invoiceToproject;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
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
  public static ExternalOrder800002Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ExternalOrder800002Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Project.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Project.CreatedBy) as CreatedByR, " +
      "        to_char(C_Project.Updated, ?) as updated, " +
      "        to_char(C_Project.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Project.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Project.UpdatedBy) as UpdatedByR," +
      "        C_Project.C_ProjectType_ID, " +
      "C_Project.C_Phase_ID, " +
      "C_Project.InvoicedQty, " +
      "C_Project.GenerateTo, " +
      "C_Project.C_Campaign_ID, " +
      "COALESCE(C_Project.Processed, 'N') AS Processed, " +
      "C_Project.ProjectBalanceAmt, " +
      "C_Project.M_PriceList_Version_ID, " +
      "C_Project.AD_Client_ID, " +
      "(CASE WHEN C_Project.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_Project.AD_Org_ID, " +
      "(CASE WHEN C_Project.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Project.Value, " +
      "COALESCE(C_Project.IsActive, 'N') AS IsActive, " +
      "C_Project.BillTo_ID, " +
      "C_Project.ProjectCategory, " +
      "(CASE WHEN C_Project.ProjectCategory IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ProjectCategoryR, " +
      "C_Project.Name, " +
      "C_Project.Description, " +
      "C_Project.Projectphase, " +
      "C_Project.Note, " +
      "C_Project.GenerateOrder, " +
      "C_Project.Projectstatus, " +
      "(CASE WHEN C_Project.Projectstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS ProjectstatusR, " +
      "C_Project.Startdate, " +
      "C_Project.DateContract, " +
      "C_Project.DateFinish, " +
      "C_Project.PlannedPOAmt, " +
      "C_Project.C_Location_ID, " +
      "(CASE WHEN C_Project.C_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Address1), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Address2), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Postal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.City), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS C_Location_IDR, " +
      "C_Project.LastPlannedProposalDate, " +
      "C_Project.SalesRep_ID, " +
      "(CASE WHEN C_Project.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "C_Project.Document_Copies, " +
      "C_Project.C_BPartner_ID, " +
      "(CASE WHEN C_Project.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "C_Project.AccountNo, " +
      "C_Project.C_BPartner_Location_ID, " +
      "(CASE WHEN C_Project.C_BPartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS C_BPartner_Location_IDR, " +
      "C_Project.Responsible_ID, " +
      "C_Project.AD_User_ID, " +
      "(CASE WHEN C_Project.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "C_Project.POReference, " +
      "C_Project.PaymentRule, " +
      "(CASE WHEN C_Project.PaymentRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS PaymentRuleR, " +
      "C_Project.Servmargin, " +
      "C_Project.C_PaymentTerm_ID, " +
      "(CASE WHEN C_Project.C_PaymentTerm_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL10.Name IS NULL THEN TO_CHAR(table10.Name) ELSE TO_CHAR(tableTRL10.Name) END)), ''))),'') ) END) AS C_PaymentTerm_IDR, " +
      "C_Project.Expreinvoicing, " +
      "C_Project.M_PriceList_ID, " +
      "(CASE WHEN C_Project.M_PriceList_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS M_PriceList_IDR, " +
      "C_Project.C_Currency_ID, " +
      "(CASE WHEN C_Project.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "C_Project.Expmargin, " +
      "C_Project.M_Warehouse_ID, " +
      "(CASE WHEN C_Project.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "C_Project.Setprojecttype, " +
      "C_Project.PlannedAmt, " +
      "C_Project.C_ProjectPhase_ID, " +
      "C_Project.PlannedQty, " +
      "COALESCE(C_Project.Createtemppricelist, 'N') AS Createtemppricelist, " +
      "C_Project.PlannedMarginAmt, " +
      "COALESCE(C_Project.IsCommitment, 'N') AS IsCommitment, " +
      "C_Project.Projectkind, " +
      "COALESCE(C_Project.IsCommitCeiling, 'N') AS IsCommitCeiling, " +
      "C_Project.Publicprivate, " +
      "C_Project.CommittedAmt, " +
      "C_Project.A_Asset_ID, " +
      "C_Project.CommittedQty, " +
      "C_Project.Schedulestatus, " +
      "C_Project.Servrevenue, " +
      "C_Project.Actualcostamount, " +
      "C_Project.Expexpenses, " +
      "C_Project.Percentdoneyet, " +
      "C_Project.Servcost, " +
      "C_Project.Estimatedamt, " +
      "C_Project.InvoicedAmt, " +
      "C_Project.ChangeProjectStatus, " +
      "C_Project.Closeproject, " +
      "C_Project.CopyFrom, " +
      "COALESCE(C_Project.IsSummary, 'N') AS IsSummary, " +
      "COALESCE(C_Project.Invoice_ToProject, 'N') AS Invoice_ToProject, " +
      "C_Project.C_Project_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Project left join (select AD_Client_ID, Name from AD_Client) table1 on (C_Project.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_Project.AD_Org_ID = table2.AD_Org_ID) left join ad_ref_list_v list1 on (C_Project.ProjectCategory = list1.value and list1.ad_reference_id = '288' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (C_Project.Projectstatus = list2.value and list2.ad_reference_id = '800002' and list2.ad_language = ?)  left join (select C_Location_ID, Address1, Address2, Postal, City, C_Region_ID, C_Country_ID from C_Location) table3 on (C_Project.C_Location_ID = table3.C_Location_ID) left join (select C_Region_ID, Name from C_Region) table4 on (table3.C_Region_ID = table4.C_Region_ID) left join (select C_Country_ID, Name from C_Country) table5 on (table3.C_Country_ID = table5.C_Country_ID) left join (select C_Country_ID,AD_Language, Name from C_Country_TRL) tableTRL5 on (table5.C_Country_ID = tableTRL5.C_Country_ID and tableTRL5.AD_Language = ?)  left join (select AD_User_ID, Name from AD_User) table6 on (C_Project.SalesRep_ID =  table6.AD_User_ID) left join (select C_BPartner_ID, Name from C_BPartner) table7 on (C_Project.C_BPartner_ID = table7.C_BPartner_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table8 on (C_Project.C_BPartner_Location_ID = table8.C_BPartner_Location_ID) left join (select AD_User_ID, Name from AD_User) table9 on (C_Project.AD_User_ID = table9.AD_User_ID) left join ad_ref_list_v list3 on (C_Project.PaymentRule = list3.value and list3.ad_reference_id = '195' and list3.ad_language = ?)  left join (select C_PaymentTerm_ID, Name from C_PaymentTerm) table10 on (C_Project.C_PaymentTerm_ID = table10.C_PaymentTerm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL10 on (table10.C_PaymentTerm_ID = tableTRL10.C_PaymentTerm_ID and tableTRL10.AD_Language = ?)  left join (select M_PriceList_ID, Name from M_PriceList) table11 on (C_Project.M_PriceList_ID = table11.M_PriceList_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table12 on (C_Project.C_Currency_ID = table12.C_Currency_ID) left join (select M_Warehouse_ID, Name from M_Warehouse) table13 on (C_Project.M_Warehouse_ID = table13.M_Warehouse_ID)" +
      "        WHERE 2=2 " +
      " AND C_Project.ProjectCategory='B'" +
      "        AND 1=1 " +
      "        AND C_Project.C_Project_ID = ? " +
      "        AND C_Project.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Project.AD_Org_ID IN (";
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
        ExternalOrder800002Data objectExternalOrder800002Data = new ExternalOrder800002Data();
        objectExternalOrder800002Data.created = UtilSql.getValue(result, "created");
        objectExternalOrder800002Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectExternalOrder800002Data.updated = UtilSql.getValue(result, "updated");
        objectExternalOrder800002Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectExternalOrder800002Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectExternalOrder800002Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectExternalOrder800002Data.cProjecttypeId = UtilSql.getValue(result, "c_projecttype_id");
        objectExternalOrder800002Data.cPhaseId = UtilSql.getValue(result, "c_phase_id");
        objectExternalOrder800002Data.invoicedqty = UtilSql.getValue(result, "invoicedqty");
        objectExternalOrder800002Data.generateto = UtilSql.getValue(result, "generateto");
        objectExternalOrder800002Data.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectExternalOrder800002Data.processed = UtilSql.getValue(result, "processed");
        objectExternalOrder800002Data.projectbalanceamt = UtilSql.getValue(result, "projectbalanceamt");
        objectExternalOrder800002Data.mPricelistVersionId = UtilSql.getValue(result, "m_pricelist_version_id");
        objectExternalOrder800002Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectExternalOrder800002Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectExternalOrder800002Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectExternalOrder800002Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectExternalOrder800002Data.value = UtilSql.getValue(result, "value");
        objectExternalOrder800002Data.isactive = UtilSql.getValue(result, "isactive");
        objectExternalOrder800002Data.billtoId = UtilSql.getValue(result, "billto_id");
        objectExternalOrder800002Data.projectcategory = UtilSql.getValue(result, "projectcategory");
        objectExternalOrder800002Data.projectcategoryr = UtilSql.getValue(result, "projectcategoryr");
        objectExternalOrder800002Data.name = UtilSql.getValue(result, "name");
        objectExternalOrder800002Data.description = UtilSql.getValue(result, "description");
        objectExternalOrder800002Data.projectphase = UtilSql.getValue(result, "projectphase");
        objectExternalOrder800002Data.note = UtilSql.getValue(result, "note");
        objectExternalOrder800002Data.generateorder = UtilSql.getValue(result, "generateorder");
        objectExternalOrder800002Data.projectstatus = UtilSql.getValue(result, "projectstatus");
        objectExternalOrder800002Data.projectstatusr = UtilSql.getValue(result, "projectstatusr");
        objectExternalOrder800002Data.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectExternalOrder800002Data.datecontract = UtilSql.getDateValue(result, "datecontract", "dd-MM-yyyy");
        objectExternalOrder800002Data.datefinish = UtilSql.getDateValue(result, "datefinish", "dd-MM-yyyy");
        objectExternalOrder800002Data.plannedpoamt = UtilSql.getValue(result, "plannedpoamt");
        objectExternalOrder800002Data.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectExternalOrder800002Data.cLocationIdr = UtilSql.getValue(result, "c_location_idr");
        objectExternalOrder800002Data.lastplannedproposaldate = UtilSql.getDateValue(result, "lastplannedproposaldate", "dd-MM-yyyy");
        objectExternalOrder800002Data.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectExternalOrder800002Data.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectExternalOrder800002Data.documentCopies = UtilSql.getValue(result, "document_copies");
        objectExternalOrder800002Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectExternalOrder800002Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectExternalOrder800002Data.accountno = UtilSql.getValue(result, "accountno");
        objectExternalOrder800002Data.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectExternalOrder800002Data.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectExternalOrder800002Data.responsibleId = UtilSql.getValue(result, "responsible_id");
        objectExternalOrder800002Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectExternalOrder800002Data.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectExternalOrder800002Data.poreference = UtilSql.getValue(result, "poreference");
        objectExternalOrder800002Data.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectExternalOrder800002Data.paymentruler = UtilSql.getValue(result, "paymentruler");
        objectExternalOrder800002Data.servmargin = UtilSql.getValue(result, "servmargin");
        objectExternalOrder800002Data.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectExternalOrder800002Data.cPaymenttermIdr = UtilSql.getValue(result, "c_paymentterm_idr");
        objectExternalOrder800002Data.expreinvoicing = UtilSql.getValue(result, "expreinvoicing");
        objectExternalOrder800002Data.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectExternalOrder800002Data.mPricelistIdr = UtilSql.getValue(result, "m_pricelist_idr");
        objectExternalOrder800002Data.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectExternalOrder800002Data.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectExternalOrder800002Data.expmargin = UtilSql.getValue(result, "expmargin");
        objectExternalOrder800002Data.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectExternalOrder800002Data.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectExternalOrder800002Data.setprojecttype = UtilSql.getValue(result, "setprojecttype");
        objectExternalOrder800002Data.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectExternalOrder800002Data.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectExternalOrder800002Data.plannedqty = UtilSql.getValue(result, "plannedqty");
        objectExternalOrder800002Data.createtemppricelist = UtilSql.getValue(result, "createtemppricelist");
        objectExternalOrder800002Data.plannedmarginamt = UtilSql.getValue(result, "plannedmarginamt");
        objectExternalOrder800002Data.iscommitment = UtilSql.getValue(result, "iscommitment");
        objectExternalOrder800002Data.projectkind = UtilSql.getValue(result, "projectkind");
        objectExternalOrder800002Data.iscommitceiling = UtilSql.getValue(result, "iscommitceiling");
        objectExternalOrder800002Data.publicprivate = UtilSql.getValue(result, "publicprivate");
        objectExternalOrder800002Data.committedamt = UtilSql.getValue(result, "committedamt");
        objectExternalOrder800002Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectExternalOrder800002Data.committedqty = UtilSql.getValue(result, "committedqty");
        objectExternalOrder800002Data.schedulestatus = UtilSql.getValue(result, "schedulestatus");
        objectExternalOrder800002Data.servrevenue = UtilSql.getValue(result, "servrevenue");
        objectExternalOrder800002Data.actualcostamount = UtilSql.getValue(result, "actualcostamount");
        objectExternalOrder800002Data.expexpenses = UtilSql.getValue(result, "expexpenses");
        objectExternalOrder800002Data.percentdoneyet = UtilSql.getValue(result, "percentdoneyet");
        objectExternalOrder800002Data.servcost = UtilSql.getValue(result, "servcost");
        objectExternalOrder800002Data.estimatedamt = UtilSql.getValue(result, "estimatedamt");
        objectExternalOrder800002Data.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectExternalOrder800002Data.changeprojectstatus = UtilSql.getValue(result, "changeprojectstatus");
        objectExternalOrder800002Data.closeproject = UtilSql.getValue(result, "closeproject");
        objectExternalOrder800002Data.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectExternalOrder800002Data.issummary = UtilSql.getValue(result, "issummary");
        objectExternalOrder800002Data.invoiceToproject = UtilSql.getValue(result, "invoice_toproject");
        objectExternalOrder800002Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectExternalOrder800002Data.language = UtilSql.getValue(result, "language");
        objectExternalOrder800002Data.adUserClient = "";
        objectExternalOrder800002Data.adOrgClient = "";
        objectExternalOrder800002Data.createdby = "";
        objectExternalOrder800002Data.trBgcolor = "";
        objectExternalOrder800002Data.totalCount = "";
        objectExternalOrder800002Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExternalOrder800002Data);
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
    ExternalOrder800002Data objectExternalOrder800002Data[] = new ExternalOrder800002Data[vector.size()];
    vector.copyInto(objectExternalOrder800002Data);
    return(objectExternalOrder800002Data);
  }

/**
Create a registry
 */
  public static ExternalOrder800002Data[] set(String createdby, String createdbyr, String billtoId, String invoicedamt, String processed, String name, String servrevenue, String publicprivate, String iscommitment, String percentdoneyet, String schedulestatus, String closeproject, String mPricelistId, String cBpartnerId, String cBpartnerIdr, String aAssetId, String servcost, String salesrepId, String cLocationId, String cLocationIdr, String expreinvoicing, String cCurrencyId, String generateto, String plannedqty, String poreference, String lastplannedproposaldate, String expexpenses, String adOrgId, String projectstatus, String datefinish, String actualcostamount, String projectcategory, String cProjecttypeId, String projectbalanceamt, String invoiceToproject, String expmargin, String updatedby, String updatedbyr, String datecontract, String cCampaignId, String isactive, String createtemppricelist, String committedamt, String value, String invoicedqty, String paymentrule, String plannedamt, String cProjectphaseId, String mPricelistVersionId, String plannedpoamt, String note, String cPaymenttermId, String projectkind, String servmargin, String projectphase, String setprojecttype, String accountno, String cBpartnerLocationId, String adUserId, String cPhaseId, String startdate, String committedqty, String iscommitceiling, String estimatedamt, String documentCopies, String cProjectId, String responsibleId, String mWarehouseId, String issummary, String generateorder, String description, String changeprojectstatus, String changeprojectstatusBtn, String copyfrom, String created, String plannedmarginamt, String adClientId)    throws ServletException {
    ExternalOrder800002Data objectExternalOrder800002Data[] = new ExternalOrder800002Data[1];
    objectExternalOrder800002Data[0] = new ExternalOrder800002Data();
    objectExternalOrder800002Data[0].created = created;
    objectExternalOrder800002Data[0].createdbyr = createdbyr;
    objectExternalOrder800002Data[0].updated = "";
    objectExternalOrder800002Data[0].updatedTimeStamp = "";
    objectExternalOrder800002Data[0].updatedby = updatedby;
    objectExternalOrder800002Data[0].updatedbyr = updatedbyr;
    objectExternalOrder800002Data[0].cProjecttypeId = cProjecttypeId;
    objectExternalOrder800002Data[0].cPhaseId = cPhaseId;
    objectExternalOrder800002Data[0].invoicedqty = invoicedqty;
    objectExternalOrder800002Data[0].generateto = generateto;
    objectExternalOrder800002Data[0].cCampaignId = cCampaignId;
    objectExternalOrder800002Data[0].processed = processed;
    objectExternalOrder800002Data[0].projectbalanceamt = projectbalanceamt;
    objectExternalOrder800002Data[0].mPricelistVersionId = mPricelistVersionId;
    objectExternalOrder800002Data[0].adClientId = adClientId;
    objectExternalOrder800002Data[0].adClientIdr = "";
    objectExternalOrder800002Data[0].adOrgId = adOrgId;
    objectExternalOrder800002Data[0].adOrgIdr = "";
    objectExternalOrder800002Data[0].value = value;
    objectExternalOrder800002Data[0].isactive = isactive;
    objectExternalOrder800002Data[0].billtoId = billtoId;
    objectExternalOrder800002Data[0].projectcategory = projectcategory;
    objectExternalOrder800002Data[0].projectcategoryr = "";
    objectExternalOrder800002Data[0].name = name;
    objectExternalOrder800002Data[0].description = description;
    objectExternalOrder800002Data[0].projectphase = projectphase;
    objectExternalOrder800002Data[0].note = note;
    objectExternalOrder800002Data[0].generateorder = generateorder;
    objectExternalOrder800002Data[0].projectstatus = projectstatus;
    objectExternalOrder800002Data[0].projectstatusr = "";
    objectExternalOrder800002Data[0].startdate = startdate;
    objectExternalOrder800002Data[0].datecontract = datecontract;
    objectExternalOrder800002Data[0].datefinish = datefinish;
    objectExternalOrder800002Data[0].plannedpoamt = plannedpoamt;
    objectExternalOrder800002Data[0].cLocationId = cLocationId;
    objectExternalOrder800002Data[0].cLocationIdr = cLocationIdr;
    objectExternalOrder800002Data[0].lastplannedproposaldate = lastplannedproposaldate;
    objectExternalOrder800002Data[0].salesrepId = salesrepId;
    objectExternalOrder800002Data[0].salesrepIdr = "";
    objectExternalOrder800002Data[0].documentCopies = documentCopies;
    objectExternalOrder800002Data[0].cBpartnerId = cBpartnerId;
    objectExternalOrder800002Data[0].cBpartnerIdr = cBpartnerIdr;
    objectExternalOrder800002Data[0].accountno = accountno;
    objectExternalOrder800002Data[0].cBpartnerLocationId = cBpartnerLocationId;
    objectExternalOrder800002Data[0].cBpartnerLocationIdr = "";
    objectExternalOrder800002Data[0].responsibleId = responsibleId;
    objectExternalOrder800002Data[0].adUserId = adUserId;
    objectExternalOrder800002Data[0].adUserIdr = "";
    objectExternalOrder800002Data[0].poreference = poreference;
    objectExternalOrder800002Data[0].paymentrule = paymentrule;
    objectExternalOrder800002Data[0].paymentruler = "";
    objectExternalOrder800002Data[0].servmargin = servmargin;
    objectExternalOrder800002Data[0].cPaymenttermId = cPaymenttermId;
    objectExternalOrder800002Data[0].cPaymenttermIdr = "";
    objectExternalOrder800002Data[0].expreinvoicing = expreinvoicing;
    objectExternalOrder800002Data[0].mPricelistId = mPricelistId;
    objectExternalOrder800002Data[0].mPricelistIdr = "";
    objectExternalOrder800002Data[0].cCurrencyId = cCurrencyId;
    objectExternalOrder800002Data[0].cCurrencyIdr = "";
    objectExternalOrder800002Data[0].expmargin = expmargin;
    objectExternalOrder800002Data[0].mWarehouseId = mWarehouseId;
    objectExternalOrder800002Data[0].mWarehouseIdr = "";
    objectExternalOrder800002Data[0].setprojecttype = setprojecttype;
    objectExternalOrder800002Data[0].plannedamt = plannedamt;
    objectExternalOrder800002Data[0].cProjectphaseId = cProjectphaseId;
    objectExternalOrder800002Data[0].plannedqty = plannedqty;
    objectExternalOrder800002Data[0].createtemppricelist = createtemppricelist;
    objectExternalOrder800002Data[0].plannedmarginamt = plannedmarginamt;
    objectExternalOrder800002Data[0].iscommitment = iscommitment;
    objectExternalOrder800002Data[0].projectkind = projectkind;
    objectExternalOrder800002Data[0].iscommitceiling = iscommitceiling;
    objectExternalOrder800002Data[0].publicprivate = publicprivate;
    objectExternalOrder800002Data[0].committedamt = committedamt;
    objectExternalOrder800002Data[0].aAssetId = aAssetId;
    objectExternalOrder800002Data[0].committedqty = committedqty;
    objectExternalOrder800002Data[0].schedulestatus = schedulestatus;
    objectExternalOrder800002Data[0].servrevenue = servrevenue;
    objectExternalOrder800002Data[0].actualcostamount = actualcostamount;
    objectExternalOrder800002Data[0].expexpenses = expexpenses;
    objectExternalOrder800002Data[0].percentdoneyet = percentdoneyet;
    objectExternalOrder800002Data[0].servcost = servcost;
    objectExternalOrder800002Data[0].estimatedamt = estimatedamt;
    objectExternalOrder800002Data[0].invoicedamt = invoicedamt;
    objectExternalOrder800002Data[0].changeprojectstatus = changeprojectstatus;
    objectExternalOrder800002Data[0].closeproject = closeproject;
    objectExternalOrder800002Data[0].copyfrom = copyfrom;
    objectExternalOrder800002Data[0].issummary = issummary;
    objectExternalOrder800002Data[0].invoiceToproject = invoiceToproject;
    objectExternalOrder800002Data[0].cProjectId = cProjectId;
    objectExternalOrder800002Data[0].language = "";
    return objectExternalOrder800002Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1354_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef3902_1(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
  public static String selectDef800142_2(ConnectionProvider connectionProvider, String C_Location_IDR)    throws ServletException {
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
  public static String selectDef3901(ConnectionProvider connectionProvider, String ad_client_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select c_currency_id from ad_client where ad_client_id=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_currency_id");
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
  public static String selectDef1357_3(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef2010(ConnectionProvider connectionProvider, String AD_ORG_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zssi_getNewProjectValue(?) ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_ORG_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zssi_getnewprojectvalue");
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

  public static int updateChangeProjectStatus(ConnectionProvider connectionProvider, String changeprojectstatus, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_Project" +
      "        SET changeprojectstatus = ? " +
      "        WHERE C_Project.C_Project_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changeprojectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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

/**
Select for action search
 */
  public static String selectActDefC_Project_ID(ConnectionProvider connectionProvider, String C_Project_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT Value FROM C_Project WHERE isActive='Y' AND C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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
      "        UPDATE C_Project" +
      "        SET C_ProjectType_ID = (?) , C_Phase_ID = (?) , InvoicedQty = TO_NUMBER(?) , GenerateTo = (?) , C_Campaign_ID = (?) , Processed = (?) , ProjectBalanceAmt = TO_NUMBER(?) , M_PriceList_Version_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Value = (?) , IsActive = (?) , BillTo_ID = (?) , ProjectCategory = (?) , Name = (?) , Description = (?) , Projectphase = (?) , Note = (?) , GenerateOrder = (?) , Projectstatus = (?) , Startdate = TO_DATE(?) , DateContract = TO_DATE(?) , DateFinish = TO_DATE(?) , PlannedPOAmt = TO_NUMBER(?) , C_Location_ID = (?) , LastPlannedProposalDate = TO_DATE(?) , SalesRep_ID = (?) , Document_Copies = TO_NUMBER(?) , C_BPartner_ID = (?) , AccountNo = (?) , C_BPartner_Location_ID = (?) , Responsible_ID = (?) , AD_User_ID = (?) , POReference = (?) , PaymentRule = (?) , Servmargin = TO_NUMBER(?) , C_PaymentTerm_ID = (?) , Expreinvoicing = TO_NUMBER(?) , M_PriceList_ID = (?) , C_Currency_ID = (?) , Expmargin = TO_NUMBER(?) , M_Warehouse_ID = (?) , Setprojecttype = (?) , PlannedAmt = TO_NUMBER(?) , C_ProjectPhase_ID = (?) , PlannedQty = TO_NUMBER(?) , Createtemppricelist = (?) , PlannedMarginAmt = TO_NUMBER(?) , IsCommitment = (?) , Projectkind = (?) , IsCommitCeiling = (?) , Publicprivate = (?) , CommittedAmt = TO_NUMBER(?) , A_Asset_ID = (?) , CommittedQty = TO_NUMBER(?) , Schedulestatus = (?) , Servrevenue = TO_NUMBER(?) , Actualcostamount = TO_NUMBER(?) , Expexpenses = TO_NUMBER(?) , Percentdoneyet = TO_NUMBER(?) , Servcost = TO_NUMBER(?) , Estimatedamt = TO_NUMBER(?) , InvoicedAmt = TO_NUMBER(?) , ChangeProjectStatus = (?) , Closeproject = (?) , CopyFrom = (?) , IsSummary = (?) , C_Project_ID = (?) , Invoice_ToProject = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Project.C_Project_ID = ? " +
      "        AND C_Project.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Project.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPhaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectbalanceamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectphase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefinish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedpoamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastplannedproposaldate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentCopies);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, responsibleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expreinvoicing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setprojecttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createtemppricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectkind);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, publicprivate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servrevenue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expexpenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdoneyet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changeprojectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceToproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
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
      "        INSERT INTO C_Project " +
      "        (C_ProjectType_ID, C_Phase_ID, InvoicedQty, GenerateTo, C_Campaign_ID, Processed, ProjectBalanceAmt, M_PriceList_Version_ID, AD_Client_ID, AD_Org_ID, Value, IsActive, BillTo_ID, ProjectCategory, Name, Description, Projectphase, Note, GenerateOrder, Projectstatus, Startdate, DateContract, DateFinish, PlannedPOAmt, C_Location_ID, LastPlannedProposalDate, SalesRep_ID, Document_Copies, C_BPartner_ID, AccountNo, C_BPartner_Location_ID, Responsible_ID, AD_User_ID, POReference, PaymentRule, Servmargin, C_PaymentTerm_ID, Expreinvoicing, M_PriceList_ID, C_Currency_ID, Expmargin, M_Warehouse_ID, Setprojecttype, PlannedAmt, C_ProjectPhase_ID, PlannedQty, Createtemppricelist, PlannedMarginAmt, IsCommitment, Projectkind, IsCommitCeiling, Publicprivate, CommittedAmt, A_Asset_ID, CommittedQty, Schedulestatus, Servrevenue, Actualcostamount, Expexpenses, Percentdoneyet, Servcost, Estimatedamt, InvoicedAmt, ChangeProjectStatus, Closeproject, CopyFrom, IsSummary, Invoice_ToProject, C_Project_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), (?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPhaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectbalanceamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectphase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefinish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedpoamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastplannedproposaldate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentCopies);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, responsibleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expreinvoicing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setprojecttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createtemppricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectkind);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, publicprivate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servrevenue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expexpenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdoneyet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changeprojectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceToproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
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
      "        DELETE FROM C_Project" +
      "        WHERE C_Project.C_Project_ID = ? " +
      "        AND C_Project.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Project.AD_Org_ID IN (";
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
      "        DELETE FROM C_Project" +
      "        WHERE C_Project.C_Project_ID = ? ";

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
      "          FROM C_Project" +
      "         WHERE C_Project.C_Project_ID = ? ";

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
      "          FROM C_Project" +
      "         WHERE C_Project.C_Project_ID = ? ";

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
