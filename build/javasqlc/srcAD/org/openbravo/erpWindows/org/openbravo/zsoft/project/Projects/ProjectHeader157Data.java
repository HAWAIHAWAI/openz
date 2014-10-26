//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.project.Projects;

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
class ProjectHeader157Data implements FieldProvider {
static Logger log4j = Logger.getLogger(ProjectHeader157Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String value;
  public String projectcategory;
  public String projectcategoryr;
  public String name;
  public String description;
  public String note;
  public String projectstatus;
  public String projectstatusr;
  public String ishidden;
  public String startdate;
  public String datecontract;
  public String datefinish;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String poreference;
  public String maMachineId;
  public String maMachineIdr;
  public String aAssetId;
  public String aAssetIdr;
  public String adUserId;
  public String adUserIdr;
  public String salesrepId;
  public String salesrepIdr;
  public String responsibleId;
  public String responsibleIdr;
  public String expensesplan;
  public String expenses;
  public String externalserviceplan;
  public String externalservice;
  public String materialcostplan;
  public String materialcost;
  public String servcostplan;
  public String servcost;
  public String machinecostplan;
  public String machinecost;
  public String indirectcostplan;
  public String indirectcost;
  public String committedamt;
  public String invoicedamt;
  public String plannedmarginamt;
  public String marginamt;
  public String plannedmarginpercent;
  public String marginpercent;
  public String plannedamt;
  public String actualcostamount;
  public String estimatedamt;
  public String percentdoneyet;
  public String schedulestatus;
  public String schedulestatusr;
  public String changeprojectstatus;
  public String closeproject;
  public String reopenproject;
  public String setprojecttype;
  public String publicprivate;
  public String createtemppricelist;
  public String cPhaseId;
  public String processing;
  public String cCurrencyId;
  public String iscommitment;
  public String generateto;
  public String mPricelistVersionId;
  public String plannedqty;
  public String processed;
  public String cCampaignId;
  public String cPaymenttermId;
  public String iscommitceiling;
  public String copyfrom;
  public String cProjectphaseId;
  public String invoicedqty;
  public String cProjecttypeId;
  public String committedqty;
  public String cProjectId;
  public String adClientId;
  public String issummary;
  public String projectkind;
  public String servrevenue;
  public String expreinvoicing;
  public String expexpenses;
  public String servmargin;
  public String expmargin;
  public String generateorder;
  public String projectphase;
  public String billtoId;
  public String mPricelistId;
  public String accountno;
  public String documentCopies;
  public String paymentrule;
  public String invoiceToproject;
  public String cLocationId;
  public String plannedpoamt;
  public String lastplannedproposaldate;
  public String mProductId;
  public String qtyofproduct;
  public String projectbalanceamt;
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
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("projectcategory"))
      return projectcategory;
    else if (fieldName.equalsIgnoreCase("projectcategoryr"))
      return projectcategoryr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("note"))
      return note;
    else if (fieldName.equalsIgnoreCase("projectstatus"))
      return projectstatus;
    else if (fieldName.equalsIgnoreCase("projectstatusr"))
      return projectstatusr;
    else if (fieldName.equalsIgnoreCase("ishidden"))
      return ishidden;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("datecontract"))
      return datecontract;
    else if (fieldName.equalsIgnoreCase("datefinish"))
      return datefinish;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("ma_machine_idr") || fieldName.equals("maMachineIdr"))
      return maMachineIdr;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("responsible_id") || fieldName.equals("responsibleId"))
      return responsibleId;
    else if (fieldName.equalsIgnoreCase("responsible_idr") || fieldName.equals("responsibleIdr"))
      return responsibleIdr;
    else if (fieldName.equalsIgnoreCase("expensesplan"))
      return expensesplan;
    else if (fieldName.equalsIgnoreCase("expenses"))
      return expenses;
    else if (fieldName.equalsIgnoreCase("externalserviceplan"))
      return externalserviceplan;
    else if (fieldName.equalsIgnoreCase("externalservice"))
      return externalservice;
    else if (fieldName.equalsIgnoreCase("materialcostplan"))
      return materialcostplan;
    else if (fieldName.equalsIgnoreCase("materialcost"))
      return materialcost;
    else if (fieldName.equalsIgnoreCase("servcostplan"))
      return servcostplan;
    else if (fieldName.equalsIgnoreCase("servcost"))
      return servcost;
    else if (fieldName.equalsIgnoreCase("machinecostplan"))
      return machinecostplan;
    else if (fieldName.equalsIgnoreCase("machinecost"))
      return machinecost;
    else if (fieldName.equalsIgnoreCase("indirectcostplan"))
      return indirectcostplan;
    else if (fieldName.equalsIgnoreCase("indirectcost"))
      return indirectcost;
    else if (fieldName.equalsIgnoreCase("committedamt"))
      return committedamt;
    else if (fieldName.equalsIgnoreCase("invoicedamt"))
      return invoicedamt;
    else if (fieldName.equalsIgnoreCase("plannedmarginamt"))
      return plannedmarginamt;
    else if (fieldName.equalsIgnoreCase("marginamt"))
      return marginamt;
    else if (fieldName.equalsIgnoreCase("plannedmarginpercent"))
      return plannedmarginpercent;
    else if (fieldName.equalsIgnoreCase("marginpercent"))
      return marginpercent;
    else if (fieldName.equalsIgnoreCase("plannedamt"))
      return plannedamt;
    else if (fieldName.equalsIgnoreCase("actualcostamount"))
      return actualcostamount;
    else if (fieldName.equalsIgnoreCase("estimatedamt"))
      return estimatedamt;
    else if (fieldName.equalsIgnoreCase("percentdoneyet"))
      return percentdoneyet;
    else if (fieldName.equalsIgnoreCase("schedulestatus"))
      return schedulestatus;
    else if (fieldName.equalsIgnoreCase("schedulestatusr"))
      return schedulestatusr;
    else if (fieldName.equalsIgnoreCase("changeprojectstatus"))
      return changeprojectstatus;
    else if (fieldName.equalsIgnoreCase("closeproject"))
      return closeproject;
    else if (fieldName.equalsIgnoreCase("reopenproject"))
      return reopenproject;
    else if (fieldName.equalsIgnoreCase("setprojecttype"))
      return setprojecttype;
    else if (fieldName.equalsIgnoreCase("publicprivate"))
      return publicprivate;
    else if (fieldName.equalsIgnoreCase("createtemppricelist"))
      return createtemppricelist;
    else if (fieldName.equalsIgnoreCase("c_phase_id") || fieldName.equals("cPhaseId"))
      return cPhaseId;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("iscommitment"))
      return iscommitment;
    else if (fieldName.equalsIgnoreCase("generateto"))
      return generateto;
    else if (fieldName.equalsIgnoreCase("m_pricelist_version_id") || fieldName.equals("mPricelistVersionId"))
      return mPricelistVersionId;
    else if (fieldName.equalsIgnoreCase("plannedqty"))
      return plannedqty;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("iscommitceiling"))
      return iscommitceiling;
    else if (fieldName.equalsIgnoreCase("copyfrom"))
      return copyfrom;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
    else if (fieldName.equalsIgnoreCase("invoicedqty"))
      return invoicedqty;
    else if (fieldName.equalsIgnoreCase("c_projecttype_id") || fieldName.equals("cProjecttypeId"))
      return cProjecttypeId;
    else if (fieldName.equalsIgnoreCase("committedqty"))
      return committedqty;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("projectkind"))
      return projectkind;
    else if (fieldName.equalsIgnoreCase("servrevenue"))
      return servrevenue;
    else if (fieldName.equalsIgnoreCase("expreinvoicing"))
      return expreinvoicing;
    else if (fieldName.equalsIgnoreCase("expexpenses"))
      return expexpenses;
    else if (fieldName.equalsIgnoreCase("servmargin"))
      return servmargin;
    else if (fieldName.equalsIgnoreCase("expmargin"))
      return expmargin;
    else if (fieldName.equalsIgnoreCase("generateorder"))
      return generateorder;
    else if (fieldName.equalsIgnoreCase("projectphase"))
      return projectphase;
    else if (fieldName.equalsIgnoreCase("billto_id") || fieldName.equals("billtoId"))
      return billtoId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("accountno"))
      return accountno;
    else if (fieldName.equalsIgnoreCase("document_copies") || fieldName.equals("documentCopies"))
      return documentCopies;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("invoice_toproject") || fieldName.equals("invoiceToproject"))
      return invoiceToproject;
    else if (fieldName.equalsIgnoreCase("c_location_id") || fieldName.equals("cLocationId"))
      return cLocationId;
    else if (fieldName.equalsIgnoreCase("plannedpoamt"))
      return plannedpoamt;
    else if (fieldName.equalsIgnoreCase("lastplannedproposaldate"))
      return lastplannedproposaldate;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("qtyofproduct"))
      return qtyofproduct;
    else if (fieldName.equalsIgnoreCase("projectbalanceamt"))
      return projectbalanceamt;
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
  public static ProjectHeader157Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProjectHeader157Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Project.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Project.CreatedBy) as CreatedByR, " +
      "        to_char(C_Project.Updated, ?) as updated, " +
      "        to_char(C_Project.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Project.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Project.UpdatedBy) as UpdatedByR," +
      "        C_Project.AD_Org_ID, " +
      "(CASE WHEN C_Project.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(C_Project.IsActive, 'N') AS IsActive, " +
      "C_Project.Value, " +
      "C_Project.ProjectCategory, " +
      "(CASE WHEN C_Project.ProjectCategory IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ProjectCategoryR, " +
      "C_Project.Name, " +
      "C_Project.Description, " +
      "C_Project.Note, " +
      "C_Project.Projectstatus, " +
      "(CASE WHEN C_Project.Projectstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS ProjectstatusR, " +
      "COALESCE(C_Project.Ishidden, 'N') AS Ishidden, " +
      "C_Project.Startdate, " +
      "C_Project.DateContract, " +
      "C_Project.DateFinish, " +
      "C_Project.M_Warehouse_ID, " +
      "(CASE WHEN C_Project.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "C_Project.C_BPartner_ID, " +
      "(CASE WHEN C_Project.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "C_Project.C_BPartner_Location_ID, " +
      "(CASE WHEN C_Project.C_BPartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_BPartner_Location_IDR, " +
      "C_Project.POReference, " +
      "C_Project.MA_Machine_ID, " +
      "(CASE WHEN C_Project.MA_Machine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS MA_Machine_IDR, " +
      "C_Project.A_Asset_ID, " +
      "(CASE WHEN C_Project.A_Asset_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "C_Project.AD_User_ID, " +
      "(CASE WHEN C_Project.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "C_Project.SalesRep_ID, " +
      "(CASE WHEN C_Project.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "C_Project.Responsible_ID, " +
      "(CASE WHEN C_Project.Responsible_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS Responsible_IDR, " +
      "C_Project.Expensesplan, " +
      "C_Project.Expenses, " +
      "C_Project.Externalserviceplan, " +
      "C_Project.Externalservice, " +
      "C_Project.Materialcostplan, " +
      "C_Project.Materialcost, " +
      "C_Project.Servcostplan, " +
      "C_Project.Servcost, " +
      "C_Project.Machinecostplan, " +
      "C_Project.Machinecost, " +
      "C_Project.Indirectcostplan, " +
      "C_Project.Indirectcost, " +
      "C_Project.CommittedAmt, " +
      "C_Project.InvoicedAmt, " +
      "C_Project.PlannedMarginAmt, " +
      "C_Project.Marginamt, " +
      "C_Project.Plannedmarginpercent, " +
      "C_Project.Marginpercent, " +
      "C_Project.PlannedAmt, " +
      "C_Project.Actualcostamount, " +
      "C_Project.Estimatedamt, " +
      "C_Project.Percentdoneyet, " +
      "C_Project.Schedulestatus, " +
      "(CASE WHEN C_Project.Schedulestatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS SchedulestatusR, " +
      "C_Project.ChangeProjectStatus, " +
      "C_Project.Closeproject, " +
      "C_Project.Reopenproject, " +
      "C_Project.Setprojecttype, " +
      "C_Project.Publicprivate, " +
      "COALESCE(C_Project.Createtemppricelist, 'N') AS Createtemppricelist, " +
      "C_Project.C_Phase_ID, " +
      "C_Project.Processing, " +
      "C_Project.C_Currency_ID, " +
      "COALESCE(C_Project.IsCommitment, 'N') AS IsCommitment, " +
      "C_Project.GenerateTo, " +
      "C_Project.M_PriceList_Version_ID, " +
      "C_Project.PlannedQty, " +
      "COALESCE(C_Project.Processed, 'N') AS Processed, " +
      "C_Project.C_Campaign_ID, " +
      "C_Project.C_PaymentTerm_ID, " +
      "COALESCE(C_Project.IsCommitCeiling, 'N') AS IsCommitCeiling, " +
      "C_Project.CopyFrom, " +
      "C_Project.C_ProjectPhase_ID, " +
      "C_Project.InvoicedQty, " +
      "C_Project.C_ProjectType_ID, " +
      "C_Project.CommittedQty, " +
      "C_Project.C_Project_ID, " +
      "C_Project.AD_Client_ID, " +
      "COALESCE(C_Project.IsSummary, 'N') AS IsSummary, " +
      "C_Project.Projectkind, " +
      "C_Project.Servrevenue, " +
      "C_Project.Expreinvoicing, " +
      "C_Project.Expexpenses, " +
      "C_Project.Servmargin, " +
      "C_Project.Expmargin, " +
      "C_Project.GenerateOrder, " +
      "C_Project.Projectphase, " +
      "C_Project.BillTo_ID, " +
      "C_Project.M_PriceList_ID, " +
      "C_Project.AccountNo, " +
      "C_Project.Document_Copies, " +
      "C_Project.PaymentRule, " +
      "COALESCE(C_Project.Invoice_ToProject, 'N') AS Invoice_ToProject, " +
      "C_Project.C_Location_ID, " +
      "C_Project.PlannedPOAmt, " +
      "C_Project.LastPlannedProposalDate, " +
      "C_Project.M_Product_ID, " +
      "C_Project.Qtyofproduct, " +
      "C_Project.ProjectBalanceAmt, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Project left join (select AD_Org_ID, Name from AD_Org) table1 on (C_Project.AD_Org_ID = table1.AD_Org_ID) left join ad_ref_list_v list1 on (C_Project.ProjectCategory = list1.value and list1.ad_reference_id = '288' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (C_Project.Projectstatus = list2.value and list2.ad_reference_id = '800002' and list2.ad_language = ?)  left join (select M_Warehouse_ID, Name from M_Warehouse) table2 on (C_Project.M_Warehouse_ID = table2.M_Warehouse_ID) left join (select C_BPartner_ID, Name from C_BPartner) table3 on (C_Project.C_BPartner_ID = table3.C_BPartner_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table4 on (C_Project.C_BPartner_Location_ID = table4.C_BPartner_Location_ID) left join (select MA_Machine_ID, Value, Name from MA_Machine) table5 on (C_Project.MA_Machine_ID = table5.MA_Machine_ID) left join (select A_Asset_ID, Name from A_Asset) table6 on (C_Project.A_Asset_ID = table6.A_Asset_ID) left join (select AD_User_ID, Name from AD_User) table7 on (C_Project.AD_User_ID = table7.AD_User_ID) left join (select AD_User_ID, Name from AD_User) table8 on (C_Project.SalesRep_ID =  table8.AD_User_ID) left join (select AD_User_ID, Name from AD_User) table9 on (C_Project.Responsible_ID =  table9.AD_User_ID) left join ad_ref_list_v list3 on (C_Project.Schedulestatus = list3.value and list3.ad_reference_id = '5A15398CEFA041818A3970A9FF8D7A78' and list3.ad_language = ?) " +
      "        WHERE 2=2 " +
      " AND C_Project.ProjectCategory not in ( 'B','C','PRO','PRP')" +
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
        ProjectHeader157Data objectProjectHeader157Data = new ProjectHeader157Data();
        objectProjectHeader157Data.created = UtilSql.getValue(result, "created");
        objectProjectHeader157Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectProjectHeader157Data.updated = UtilSql.getValue(result, "updated");
        objectProjectHeader157Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectProjectHeader157Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectProjectHeader157Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectProjectHeader157Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProjectHeader157Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectProjectHeader157Data.isactive = UtilSql.getValue(result, "isactive");
        objectProjectHeader157Data.value = UtilSql.getValue(result, "value");
        objectProjectHeader157Data.projectcategory = UtilSql.getValue(result, "projectcategory");
        objectProjectHeader157Data.projectcategoryr = UtilSql.getValue(result, "projectcategoryr");
        objectProjectHeader157Data.name = UtilSql.getValue(result, "name");
        objectProjectHeader157Data.description = UtilSql.getValue(result, "description");
        objectProjectHeader157Data.note = UtilSql.getValue(result, "note");
        objectProjectHeader157Data.projectstatus = UtilSql.getValue(result, "projectstatus");
        objectProjectHeader157Data.projectstatusr = UtilSql.getValue(result, "projectstatusr");
        objectProjectHeader157Data.ishidden = UtilSql.getValue(result, "ishidden");
        objectProjectHeader157Data.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectProjectHeader157Data.datecontract = UtilSql.getDateValue(result, "datecontract", "dd-MM-yyyy");
        objectProjectHeader157Data.datefinish = UtilSql.getDateValue(result, "datefinish", "dd-MM-yyyy");
        objectProjectHeader157Data.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectProjectHeader157Data.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectProjectHeader157Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectProjectHeader157Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectProjectHeader157Data.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectProjectHeader157Data.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectProjectHeader157Data.poreference = UtilSql.getValue(result, "poreference");
        objectProjectHeader157Data.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectProjectHeader157Data.maMachineIdr = UtilSql.getValue(result, "ma_machine_idr");
        objectProjectHeader157Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectProjectHeader157Data.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectProjectHeader157Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectProjectHeader157Data.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectProjectHeader157Data.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectProjectHeader157Data.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectProjectHeader157Data.responsibleId = UtilSql.getValue(result, "responsible_id");
        objectProjectHeader157Data.responsibleIdr = UtilSql.getValue(result, "responsible_idr");
        objectProjectHeader157Data.expensesplan = UtilSql.getValue(result, "expensesplan");
        objectProjectHeader157Data.expenses = UtilSql.getValue(result, "expenses");
        objectProjectHeader157Data.externalserviceplan = UtilSql.getValue(result, "externalserviceplan");
        objectProjectHeader157Data.externalservice = UtilSql.getValue(result, "externalservice");
        objectProjectHeader157Data.materialcostplan = UtilSql.getValue(result, "materialcostplan");
        objectProjectHeader157Data.materialcost = UtilSql.getValue(result, "materialcost");
        objectProjectHeader157Data.servcostplan = UtilSql.getValue(result, "servcostplan");
        objectProjectHeader157Data.servcost = UtilSql.getValue(result, "servcost");
        objectProjectHeader157Data.machinecostplan = UtilSql.getValue(result, "machinecostplan");
        objectProjectHeader157Data.machinecost = UtilSql.getValue(result, "machinecost");
        objectProjectHeader157Data.indirectcostplan = UtilSql.getValue(result, "indirectcostplan");
        objectProjectHeader157Data.indirectcost = UtilSql.getValue(result, "indirectcost");
        objectProjectHeader157Data.committedamt = UtilSql.getValue(result, "committedamt");
        objectProjectHeader157Data.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectProjectHeader157Data.plannedmarginamt = UtilSql.getValue(result, "plannedmarginamt");
        objectProjectHeader157Data.marginamt = UtilSql.getValue(result, "marginamt");
        objectProjectHeader157Data.plannedmarginpercent = UtilSql.getValue(result, "plannedmarginpercent");
        objectProjectHeader157Data.marginpercent = UtilSql.getValue(result, "marginpercent");
        objectProjectHeader157Data.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectProjectHeader157Data.actualcostamount = UtilSql.getValue(result, "actualcostamount");
        objectProjectHeader157Data.estimatedamt = UtilSql.getValue(result, "estimatedamt");
        objectProjectHeader157Data.percentdoneyet = UtilSql.getValue(result, "percentdoneyet");
        objectProjectHeader157Data.schedulestatus = UtilSql.getValue(result, "schedulestatus");
        objectProjectHeader157Data.schedulestatusr = UtilSql.getValue(result, "schedulestatusr");
        objectProjectHeader157Data.changeprojectstatus = UtilSql.getValue(result, "changeprojectstatus");
        objectProjectHeader157Data.closeproject = UtilSql.getValue(result, "closeproject");
        objectProjectHeader157Data.reopenproject = UtilSql.getValue(result, "reopenproject");
        objectProjectHeader157Data.setprojecttype = UtilSql.getValue(result, "setprojecttype");
        objectProjectHeader157Data.publicprivate = UtilSql.getValue(result, "publicprivate");
        objectProjectHeader157Data.createtemppricelist = UtilSql.getValue(result, "createtemppricelist");
        objectProjectHeader157Data.cPhaseId = UtilSql.getValue(result, "c_phase_id");
        objectProjectHeader157Data.processing = UtilSql.getValue(result, "processing");
        objectProjectHeader157Data.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectProjectHeader157Data.iscommitment = UtilSql.getValue(result, "iscommitment");
        objectProjectHeader157Data.generateto = UtilSql.getValue(result, "generateto");
        objectProjectHeader157Data.mPricelistVersionId = UtilSql.getValue(result, "m_pricelist_version_id");
        objectProjectHeader157Data.plannedqty = UtilSql.getValue(result, "plannedqty");
        objectProjectHeader157Data.processed = UtilSql.getValue(result, "processed");
        objectProjectHeader157Data.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectProjectHeader157Data.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectProjectHeader157Data.iscommitceiling = UtilSql.getValue(result, "iscommitceiling");
        objectProjectHeader157Data.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectProjectHeader157Data.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectProjectHeader157Data.invoicedqty = UtilSql.getValue(result, "invoicedqty");
        objectProjectHeader157Data.cProjecttypeId = UtilSql.getValue(result, "c_projecttype_id");
        objectProjectHeader157Data.committedqty = UtilSql.getValue(result, "committedqty");
        objectProjectHeader157Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectProjectHeader157Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProjectHeader157Data.issummary = UtilSql.getValue(result, "issummary");
        objectProjectHeader157Data.projectkind = UtilSql.getValue(result, "projectkind");
        objectProjectHeader157Data.servrevenue = UtilSql.getValue(result, "servrevenue");
        objectProjectHeader157Data.expreinvoicing = UtilSql.getValue(result, "expreinvoicing");
        objectProjectHeader157Data.expexpenses = UtilSql.getValue(result, "expexpenses");
        objectProjectHeader157Data.servmargin = UtilSql.getValue(result, "servmargin");
        objectProjectHeader157Data.expmargin = UtilSql.getValue(result, "expmargin");
        objectProjectHeader157Data.generateorder = UtilSql.getValue(result, "generateorder");
        objectProjectHeader157Data.projectphase = UtilSql.getValue(result, "projectphase");
        objectProjectHeader157Data.billtoId = UtilSql.getValue(result, "billto_id");
        objectProjectHeader157Data.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectProjectHeader157Data.accountno = UtilSql.getValue(result, "accountno");
        objectProjectHeader157Data.documentCopies = UtilSql.getValue(result, "document_copies");
        objectProjectHeader157Data.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectProjectHeader157Data.invoiceToproject = UtilSql.getValue(result, "invoice_toproject");
        objectProjectHeader157Data.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectProjectHeader157Data.plannedpoamt = UtilSql.getValue(result, "plannedpoamt");
        objectProjectHeader157Data.lastplannedproposaldate = UtilSql.getDateValue(result, "lastplannedproposaldate", "dd-MM-yyyy");
        objectProjectHeader157Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProjectHeader157Data.qtyofproduct = UtilSql.getValue(result, "qtyofproduct");
        objectProjectHeader157Data.projectbalanceamt = UtilSql.getValue(result, "projectbalanceamt");
        objectProjectHeader157Data.language = UtilSql.getValue(result, "language");
        objectProjectHeader157Data.adUserClient = "";
        objectProjectHeader157Data.adOrgClient = "";
        objectProjectHeader157Data.createdby = "";
        objectProjectHeader157Data.trBgcolor = "";
        objectProjectHeader157Data.totalCount = "";
        objectProjectHeader157Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjectHeader157Data);
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
    ProjectHeader157Data objectProjectHeader157Data[] = new ProjectHeader157Data[vector.size()];
    vector.copyInto(objectProjectHeader157Data);
    return(objectProjectHeader157Data);
  }

/**
Create a registry
 */
  public static ProjectHeader157Data[] set(String createdby, String createdbyr, String billtoId, String invoicedamt, String processed, String responsibleId, String adClientId, String name, String copyfrom, String reopenproject, String maMachineId, String publicprivate, String externalservice, String committedqty, String iscommitceiling, String closeproject, String cBpartnerId, String cBpartnerIdr, String estimatedamt, String materialcostplan, String salesrepId, String servcost, String expreinvoicing, String generateto, String setprojecttype, String materialcost, String poreference, String lastplannedproposaldate, String adOrgId, String plannedmarginpercent, String datefinish, String projectstatus, String indirectcostplan, String projectcategory, String processing, String cProjecttypeId, String projectbalanceamt, String expmargin, String invoiceToproject, String updatedby, String updatedbyr, String qtyofproduct, String datecontract, String cCampaignId, String machinecostplan, String machinecost, String servcostplan, String cPaymenttermId, String isactive, String paymentrule, String createtemppricelist, String committedamt, String invoicedqty, String value, String plannedamt, String mPricelistVersionId, String cProjectphaseId, String note, String plannedpoamt, String projectkind, String mProductId, String servmargin, String expexpenses, String cLocationId, String projectphase, String cCurrencyId, String plannedqty, String actualcostamount, String ishidden, String expenses, String accountno, String cBpartnerLocationId, String servrevenue, String iscommitment, String percentdoneyet, String schedulestatus, String adUserId, String cPhaseId, String marginamt, String startdate, String mPricelistId, String aAssetId, String externalserviceplan, String documentCopies, String cProjectId, String mWarehouseId, String issummary, String generateorder, String expensesplan, String indirectcost, String description, String changeprojectstatus, String changeprojectstatusBtn, String plannedmarginamt, String marginpercent)    throws ServletException {
    ProjectHeader157Data objectProjectHeader157Data[] = new ProjectHeader157Data[1];
    objectProjectHeader157Data[0] = new ProjectHeader157Data();
    objectProjectHeader157Data[0].created = "";
    objectProjectHeader157Data[0].createdbyr = createdbyr;
    objectProjectHeader157Data[0].updated = "";
    objectProjectHeader157Data[0].updatedTimeStamp = "";
    objectProjectHeader157Data[0].updatedby = updatedby;
    objectProjectHeader157Data[0].updatedbyr = updatedbyr;
    objectProjectHeader157Data[0].adOrgId = adOrgId;
    objectProjectHeader157Data[0].adOrgIdr = "";
    objectProjectHeader157Data[0].isactive = isactive;
    objectProjectHeader157Data[0].value = value;
    objectProjectHeader157Data[0].projectcategory = projectcategory;
    objectProjectHeader157Data[0].projectcategoryr = "";
    objectProjectHeader157Data[0].name = name;
    objectProjectHeader157Data[0].description = description;
    objectProjectHeader157Data[0].note = note;
    objectProjectHeader157Data[0].projectstatus = projectstatus;
    objectProjectHeader157Data[0].projectstatusr = "";
    objectProjectHeader157Data[0].ishidden = ishidden;
    objectProjectHeader157Data[0].startdate = startdate;
    objectProjectHeader157Data[0].datecontract = datecontract;
    objectProjectHeader157Data[0].datefinish = datefinish;
    objectProjectHeader157Data[0].mWarehouseId = mWarehouseId;
    objectProjectHeader157Data[0].mWarehouseIdr = "";
    objectProjectHeader157Data[0].cBpartnerId = cBpartnerId;
    objectProjectHeader157Data[0].cBpartnerIdr = cBpartnerIdr;
    objectProjectHeader157Data[0].cBpartnerLocationId = cBpartnerLocationId;
    objectProjectHeader157Data[0].cBpartnerLocationIdr = "";
    objectProjectHeader157Data[0].poreference = poreference;
    objectProjectHeader157Data[0].maMachineId = maMachineId;
    objectProjectHeader157Data[0].maMachineIdr = "";
    objectProjectHeader157Data[0].aAssetId = aAssetId;
    objectProjectHeader157Data[0].aAssetIdr = "";
    objectProjectHeader157Data[0].adUserId = adUserId;
    objectProjectHeader157Data[0].adUserIdr = "";
    objectProjectHeader157Data[0].salesrepId = salesrepId;
    objectProjectHeader157Data[0].salesrepIdr = "";
    objectProjectHeader157Data[0].responsibleId = responsibleId;
    objectProjectHeader157Data[0].responsibleIdr = "";
    objectProjectHeader157Data[0].expensesplan = expensesplan;
    objectProjectHeader157Data[0].expenses = expenses;
    objectProjectHeader157Data[0].externalserviceplan = externalserviceplan;
    objectProjectHeader157Data[0].externalservice = externalservice;
    objectProjectHeader157Data[0].materialcostplan = materialcostplan;
    objectProjectHeader157Data[0].materialcost = materialcost;
    objectProjectHeader157Data[0].servcostplan = servcostplan;
    objectProjectHeader157Data[0].servcost = servcost;
    objectProjectHeader157Data[0].machinecostplan = machinecostplan;
    objectProjectHeader157Data[0].machinecost = machinecost;
    objectProjectHeader157Data[0].indirectcostplan = indirectcostplan;
    objectProjectHeader157Data[0].indirectcost = indirectcost;
    objectProjectHeader157Data[0].committedamt = committedamt;
    objectProjectHeader157Data[0].invoicedamt = invoicedamt;
    objectProjectHeader157Data[0].plannedmarginamt = plannedmarginamt;
    objectProjectHeader157Data[0].marginamt = marginamt;
    objectProjectHeader157Data[0].plannedmarginpercent = plannedmarginpercent;
    objectProjectHeader157Data[0].marginpercent = marginpercent;
    objectProjectHeader157Data[0].plannedamt = plannedamt;
    objectProjectHeader157Data[0].actualcostamount = actualcostamount;
    objectProjectHeader157Data[0].estimatedamt = estimatedamt;
    objectProjectHeader157Data[0].percentdoneyet = percentdoneyet;
    objectProjectHeader157Data[0].schedulestatus = schedulestatus;
    objectProjectHeader157Data[0].schedulestatusr = "";
    objectProjectHeader157Data[0].changeprojectstatus = changeprojectstatus;
    objectProjectHeader157Data[0].closeproject = closeproject;
    objectProjectHeader157Data[0].reopenproject = reopenproject;
    objectProjectHeader157Data[0].setprojecttype = setprojecttype;
    objectProjectHeader157Data[0].publicprivate = publicprivate;
    objectProjectHeader157Data[0].createtemppricelist = createtemppricelist;
    objectProjectHeader157Data[0].cPhaseId = cPhaseId;
    objectProjectHeader157Data[0].processing = processing;
    objectProjectHeader157Data[0].cCurrencyId = cCurrencyId;
    objectProjectHeader157Data[0].iscommitment = iscommitment;
    objectProjectHeader157Data[0].generateto = generateto;
    objectProjectHeader157Data[0].mPricelistVersionId = mPricelistVersionId;
    objectProjectHeader157Data[0].plannedqty = plannedqty;
    objectProjectHeader157Data[0].processed = processed;
    objectProjectHeader157Data[0].cCampaignId = cCampaignId;
    objectProjectHeader157Data[0].cPaymenttermId = cPaymenttermId;
    objectProjectHeader157Data[0].iscommitceiling = iscommitceiling;
    objectProjectHeader157Data[0].copyfrom = copyfrom;
    objectProjectHeader157Data[0].cProjectphaseId = cProjectphaseId;
    objectProjectHeader157Data[0].invoicedqty = invoicedqty;
    objectProjectHeader157Data[0].cProjecttypeId = cProjecttypeId;
    objectProjectHeader157Data[0].committedqty = committedqty;
    objectProjectHeader157Data[0].cProjectId = cProjectId;
    objectProjectHeader157Data[0].adClientId = adClientId;
    objectProjectHeader157Data[0].issummary = issummary;
    objectProjectHeader157Data[0].projectkind = projectkind;
    objectProjectHeader157Data[0].servrevenue = servrevenue;
    objectProjectHeader157Data[0].expreinvoicing = expreinvoicing;
    objectProjectHeader157Data[0].expexpenses = expexpenses;
    objectProjectHeader157Data[0].servmargin = servmargin;
    objectProjectHeader157Data[0].expmargin = expmargin;
    objectProjectHeader157Data[0].generateorder = generateorder;
    objectProjectHeader157Data[0].projectphase = projectphase;
    objectProjectHeader157Data[0].billtoId = billtoId;
    objectProjectHeader157Data[0].mPricelistId = mPricelistId;
    objectProjectHeader157Data[0].accountno = accountno;
    objectProjectHeader157Data[0].documentCopies = documentCopies;
    objectProjectHeader157Data[0].paymentrule = paymentrule;
    objectProjectHeader157Data[0].invoiceToproject = invoiceToproject;
    objectProjectHeader157Data[0].cLocationId = cLocationId;
    objectProjectHeader157Data[0].plannedpoamt = plannedpoamt;
    objectProjectHeader157Data[0].lastplannedproposaldate = lastplannedproposaldate;
    objectProjectHeader157Data[0].mProductId = mProductId;
    objectProjectHeader157Data[0].qtyofproduct = qtyofproduct;
    objectProjectHeader157Data[0].projectbalanceamt = projectbalanceamt;
    objectProjectHeader157Data[0].language = "";
    return objectProjectHeader157Data;
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
  public static String selectDef1357_2(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
      "        SET AD_Org_ID = (?) , IsActive = (?) , Value = (?) , ProjectCategory = (?) , Name = (?) , Description = (?) , Note = (?) , Projectstatus = (?) , Ishidden = (?) , Startdate = TO_DATE(?) , DateContract = TO_DATE(?) , DateFinish = TO_DATE(?) , M_Warehouse_ID = (?) , C_BPartner_ID = (?) , C_BPartner_Location_ID = (?) , POReference = (?) , MA_Machine_ID = (?) , A_Asset_ID = (?) , AD_User_ID = (?) , SalesRep_ID = (?) , Responsible_ID = (?) , Expensesplan = TO_NUMBER(?) , Expenses = TO_NUMBER(?) , Externalserviceplan = TO_NUMBER(?) , Externalservice = TO_NUMBER(?) , Materialcostplan = TO_NUMBER(?) , Materialcost = TO_NUMBER(?) , Servcostplan = TO_NUMBER(?) , Servcost = TO_NUMBER(?) , Machinecostplan = TO_NUMBER(?) , Machinecost = TO_NUMBER(?) , Indirectcostplan = TO_NUMBER(?) , Indirectcost = TO_NUMBER(?) , CommittedAmt = TO_NUMBER(?) , InvoicedAmt = TO_NUMBER(?) , PlannedMarginAmt = TO_NUMBER(?) , Marginamt = TO_NUMBER(?) , Plannedmarginpercent = TO_NUMBER(?) , Marginpercent = TO_NUMBER(?) , PlannedAmt = TO_NUMBER(?) , Actualcostamount = TO_NUMBER(?) , Estimatedamt = TO_NUMBER(?) , Percentdoneyet = TO_NUMBER(?) , Schedulestatus = (?) , ChangeProjectStatus = (?) , Closeproject = (?) , Reopenproject = (?) , Setprojecttype = (?) , Publicprivate = (?) , Createtemppricelist = (?) , C_Phase_ID = (?) , Processing = (?) , C_Currency_ID = (?) , IsCommitment = (?) , GenerateTo = (?) , M_PriceList_Version_ID = (?) , PlannedQty = TO_NUMBER(?) , Processed = (?) , C_Campaign_ID = (?) , C_PaymentTerm_ID = (?) , IsCommitCeiling = (?) , CopyFrom = (?) , C_ProjectPhase_ID = (?) , InvoicedQty = TO_NUMBER(?) , C_ProjectType_ID = (?) , CommittedQty = TO_NUMBER(?) , C_Project_ID = (?) , AD_Client_ID = (?) , IsSummary = (?) , Projectkind = (?) , Servrevenue = TO_NUMBER(?) , Expreinvoicing = TO_NUMBER(?) , Expexpenses = TO_NUMBER(?) , Servmargin = TO_NUMBER(?) , Expmargin = TO_NUMBER(?) , GenerateOrder = (?) , Projectphase = (?) , BillTo_ID = (?) , M_PriceList_ID = (?) , AccountNo = (?) , Document_Copies = TO_NUMBER(?) , PaymentRule = (?) , Invoice_ToProject = (?) , C_Location_ID = (?) , PlannedPOAmt = TO_NUMBER(?) , LastPlannedProposalDate = TO_DATE(?) , M_Product_ID = (?) , Qtyofproduct = TO_NUMBER(?) , ProjectBalanceAmt = TO_NUMBER(?) , updated = now(), updatedby = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ishidden);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefinish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, responsibleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expensesplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, externalserviceplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, externalservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marginamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginpercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marginpercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdoneyet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changeprojectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reopenproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setprojecttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, publicprivate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createtemppricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPhaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectkind);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servrevenue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expreinvoicing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expexpenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectphase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentCopies);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceToproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedpoamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastplannedproposaldate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyofproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectbalanceamt);
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
      "        (AD_Org_ID, IsActive, Value, ProjectCategory, Name, Description, Note, Projectstatus, Ishidden, Startdate, DateContract, DateFinish, M_Warehouse_ID, C_BPartner_ID, C_BPartner_Location_ID, POReference, MA_Machine_ID, A_Asset_ID, AD_User_ID, SalesRep_ID, Responsible_ID, Expensesplan, Expenses, Externalserviceplan, Externalservice, Materialcostplan, Materialcost, Servcostplan, Servcost, Machinecostplan, Machinecost, Indirectcostplan, Indirectcost, CommittedAmt, InvoicedAmt, PlannedMarginAmt, Marginamt, Plannedmarginpercent, Marginpercent, PlannedAmt, Actualcostamount, Estimatedamt, Percentdoneyet, Schedulestatus, ChangeProjectStatus, Closeproject, Reopenproject, Setprojecttype, Publicprivate, Createtemppricelist, C_Phase_ID, Processing, C_Currency_ID, IsCommitment, GenerateTo, M_PriceList_Version_ID, PlannedQty, Processed, C_Campaign_ID, C_PaymentTerm_ID, IsCommitCeiling, CopyFrom, C_ProjectPhase_ID, InvoicedQty, C_ProjectType_ID, CommittedQty, C_Project_ID, AD_Client_ID, IsSummary, Projectkind, Servrevenue, Expreinvoicing, Expexpenses, Servmargin, Expmargin, GenerateOrder, Projectphase, BillTo_ID, M_PriceList_ID, AccountNo, Document_Copies, PaymentRule, Invoice_ToProject, C_Location_ID, PlannedPOAmt, LastPlannedProposalDate, M_Product_ID, Qtyofproduct, ProjectBalanceAmt, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_DATE(?), (?), TO_NUMBER(?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ishidden);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefinish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, responsibleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expensesplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, externalserviceplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, externalservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marginamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginpercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marginpercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdoneyet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changeprojectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reopenproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setprojecttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, publicprivate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createtemppricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPhaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectkind);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servrevenue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expreinvoicing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expexpenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectphase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentCopies);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceToproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedpoamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastplannedproposaldate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyofproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectbalanceamt);
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
