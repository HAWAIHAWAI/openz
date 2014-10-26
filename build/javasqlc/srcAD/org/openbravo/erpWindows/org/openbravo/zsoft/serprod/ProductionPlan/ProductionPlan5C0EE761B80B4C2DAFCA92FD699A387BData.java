//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.ProductionPlan;

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
class ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String projectcategory;
  public String projectcategoryr;
  public String isactive;
  public String projectstatus;
  public String projectstatusr;
  public String isdefault;
  public String isautotriggered;
  public String timeperpiece;
  public String setuptime;
  public String value;
  public String name;
  public String description;
  public String note;
  public String responsibleId;
  public String responsibleIdr;
  public String changeprojectstatus;
  public String cPhaseId;
  public String committedamt;
  public String expreinvoicing;
  public String processed;
  public String lastplannedproposaldate;
  public String cProjecttypeId;
  public String projectphase;
  public String expenses;
  public String paymentrule;
  public String machinecost;
  public String iscommitceiling;
  public String generateto;
  public String cBpartnerId;
  public String issummary;
  public String committedqty;
  public String plannedmarginamt;
  public String invoicedamt;
  public String cLocationId;
  public String invoiceToproject;
  public String adClientId;
  public String documentCopies;
  public String percentdoneyet;
  public String projectkind;
  public String plannedpoamt;
  public String mPricelistVersionId;
  public String indirectcost;
  public String datefinish;
  public String aAssetId;
  public String projectbalanceamt;
  public String servcost;
  public String cCampaignId;
  public String schedulestatus;
  public String qtyofproduct;
  public String iscommitment;
  public String servrevenue;
  public String zssmProductionplanVId;
  public String expexpenses;
  public String reopenproject;
  public String datecontract;
  public String cCurrencyId;
  public String processing;
  public String estimatedamt;
  public String adUserId;
  public String mProductId;
  public String plannedamt;
  public String actualcostamount;
  public String expmargin;
  public String accountno;
  public String publicprivate;
  public String mPricelistId;
  public String poreference;
  public String mWarehouseId;
  public String cPaymenttermId;
  public String cBpartnerLocationId;
  public String createtemppricelist;
  public String cProjectId;
  public String plannedqty;
  public String setprojecttype;
  public String invoicedqty;
  public String billtoId;
  public String materialcost;
  public String salesrepId;
  public String closeproject;
  public String servmargin;
  public String startdate;
  public String copyfrom;
  public String generateorder;
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
    else if (fieldName.equalsIgnoreCase("projectcategory"))
      return projectcategory;
    else if (fieldName.equalsIgnoreCase("projectcategoryr"))
      return projectcategoryr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("projectstatus"))
      return projectstatus;
    else if (fieldName.equalsIgnoreCase("projectstatusr"))
      return projectstatusr;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("isautotriggered"))
      return isautotriggered;
    else if (fieldName.equalsIgnoreCase("timeperpiece"))
      return timeperpiece;
    else if (fieldName.equalsIgnoreCase("setuptime"))
      return setuptime;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("note"))
      return note;
    else if (fieldName.equalsIgnoreCase("responsible_id") || fieldName.equals("responsibleId"))
      return responsibleId;
    else if (fieldName.equalsIgnoreCase("responsible_idr") || fieldName.equals("responsibleIdr"))
      return responsibleIdr;
    else if (fieldName.equalsIgnoreCase("changeprojectstatus"))
      return changeprojectstatus;
    else if (fieldName.equalsIgnoreCase("c_phase_id") || fieldName.equals("cPhaseId"))
      return cPhaseId;
    else if (fieldName.equalsIgnoreCase("committedamt"))
      return committedamt;
    else if (fieldName.equalsIgnoreCase("expreinvoicing"))
      return expreinvoicing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("lastplannedproposaldate"))
      return lastplannedproposaldate;
    else if (fieldName.equalsIgnoreCase("c_projecttype_id") || fieldName.equals("cProjecttypeId"))
      return cProjecttypeId;
    else if (fieldName.equalsIgnoreCase("projectphase"))
      return projectphase;
    else if (fieldName.equalsIgnoreCase("expenses"))
      return expenses;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("machinecost"))
      return machinecost;
    else if (fieldName.equalsIgnoreCase("iscommitceiling"))
      return iscommitceiling;
    else if (fieldName.equalsIgnoreCase("generateto"))
      return generateto;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("committedqty"))
      return committedqty;
    else if (fieldName.equalsIgnoreCase("plannedmarginamt"))
      return plannedmarginamt;
    else if (fieldName.equalsIgnoreCase("invoicedamt"))
      return invoicedamt;
    else if (fieldName.equalsIgnoreCase("c_location_id") || fieldName.equals("cLocationId"))
      return cLocationId;
    else if (fieldName.equalsIgnoreCase("invoice_toproject") || fieldName.equals("invoiceToproject"))
      return invoiceToproject;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("document_copies") || fieldName.equals("documentCopies"))
      return documentCopies;
    else if (fieldName.equalsIgnoreCase("percentdoneyet"))
      return percentdoneyet;
    else if (fieldName.equalsIgnoreCase("projectkind"))
      return projectkind;
    else if (fieldName.equalsIgnoreCase("plannedpoamt"))
      return plannedpoamt;
    else if (fieldName.equalsIgnoreCase("m_pricelist_version_id") || fieldName.equals("mPricelistVersionId"))
      return mPricelistVersionId;
    else if (fieldName.equalsIgnoreCase("indirectcost"))
      return indirectcost;
    else if (fieldName.equalsIgnoreCase("datefinish"))
      return datefinish;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("projectbalanceamt"))
      return projectbalanceamt;
    else if (fieldName.equalsIgnoreCase("servcost"))
      return servcost;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("schedulestatus"))
      return schedulestatus;
    else if (fieldName.equalsIgnoreCase("qtyofproduct"))
      return qtyofproduct;
    else if (fieldName.equalsIgnoreCase("iscommitment"))
      return iscommitment;
    else if (fieldName.equalsIgnoreCase("servrevenue"))
      return servrevenue;
    else if (fieldName.equalsIgnoreCase("zssm_productionplan_v_id") || fieldName.equals("zssmProductionplanVId"))
      return zssmProductionplanVId;
    else if (fieldName.equalsIgnoreCase("expexpenses"))
      return expexpenses;
    else if (fieldName.equalsIgnoreCase("reopenproject"))
      return reopenproject;
    else if (fieldName.equalsIgnoreCase("datecontract"))
      return datecontract;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("estimatedamt"))
      return estimatedamt;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("plannedamt"))
      return plannedamt;
    else if (fieldName.equalsIgnoreCase("actualcostamount"))
      return actualcostamount;
    else if (fieldName.equalsIgnoreCase("expmargin"))
      return expmargin;
    else if (fieldName.equalsIgnoreCase("accountno"))
      return accountno;
    else if (fieldName.equalsIgnoreCase("publicprivate"))
      return publicprivate;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("createtemppricelist"))
      return createtemppricelist;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("plannedqty"))
      return plannedqty;
    else if (fieldName.equalsIgnoreCase("setprojecttype"))
      return setprojecttype;
    else if (fieldName.equalsIgnoreCase("invoicedqty"))
      return invoicedqty;
    else if (fieldName.equalsIgnoreCase("billto_id") || fieldName.equals("billtoId"))
      return billtoId;
    else if (fieldName.equalsIgnoreCase("materialcost"))
      return materialcost;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("closeproject"))
      return closeproject;
    else if (fieldName.equalsIgnoreCase("servmargin"))
      return servmargin;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("copyfrom"))
      return copyfrom;
    else if (fieldName.equalsIgnoreCase("generateorder"))
      return generateorder;
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
  public static ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssm_productionplan_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_productionplan_v.CreatedBy) as CreatedByR, " +
      "        to_char(zssm_productionplan_v.Updated, ?) as updated, " +
      "        to_char(zssm_productionplan_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssm_productionplan_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_productionplan_v.UpdatedBy) as UpdatedByR," +
      "        zssm_productionplan_v.AD_Org_ID, " +
      "(CASE WHEN zssm_productionplan_v.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zssm_productionplan_v.ProjectCategory, " +
      "(CASE WHEN zssm_productionplan_v.ProjectCategory IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ProjectCategoryR, " +
      "COALESCE(zssm_productionplan_v.IsActive, 'N') AS IsActive, " +
      "zssm_productionplan_v.ProjectStatus, " +
      "(CASE WHEN zssm_productionplan_v.ProjectStatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS ProjectStatusR, " +
      "COALESCE(zssm_productionplan_v.Isdefault, 'N') AS Isdefault, " +
      "COALESCE(zssm_productionplan_v.Isautotriggered, 'N') AS Isautotriggered, " +
      "zssm_productionplan_v.Timeperpiece, " +
      "zssm_productionplan_v.Setuptime, " +
      "zssm_productionplan_v.Value, " +
      "zssm_productionplan_v.Name, " +
      "zssm_productionplan_v.Description, " +
      "zssm_productionplan_v.Note, " +
      "zssm_productionplan_v.Responsible_ID, " +
      "(CASE WHEN zssm_productionplan_v.Responsible_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS Responsible_IDR, " +
      "zssm_productionplan_v.ChangeProjectStatus, " +
      "zssm_productionplan_v.C_Phase_ID, " +
      "zssm_productionplan_v.CommittedAmt, " +
      "zssm_productionplan_v.Expreinvoicing, " +
      "COALESCE(zssm_productionplan_v.Processed, 'N') AS Processed, " +
      "zssm_productionplan_v.LastPlannedProposalDate, " +
      "zssm_productionplan_v.C_ProjectType_ID, " +
      "zssm_productionplan_v.Projectphase, " +
      "zssm_productionplan_v.Expenses, " +
      "zssm_productionplan_v.PaymentRule, " +
      "zssm_productionplan_v.Machinecost, " +
      "COALESCE(zssm_productionplan_v.IsCommitCeiling, 'N') AS IsCommitCeiling, " +
      "zssm_productionplan_v.GenerateTo, " +
      "zssm_productionplan_v.C_BPartner_ID, " +
      "COALESCE(zssm_productionplan_v.IsSummary, 'N') AS IsSummary, " +
      "zssm_productionplan_v.CommittedQty, " +
      "zssm_productionplan_v.PlannedMarginAmt, " +
      "zssm_productionplan_v.InvoicedAmt, " +
      "zssm_productionplan_v.C_Location_ID, " +
      "COALESCE(zssm_productionplan_v.Invoice_ToProject, 'N') AS Invoice_ToProject, " +
      "zssm_productionplan_v.AD_Client_ID, " +
      "zssm_productionplan_v.Document_Copies, " +
      "zssm_productionplan_v.Percentdoneyet, " +
      "zssm_productionplan_v.Projectkind, " +
      "zssm_productionplan_v.PlannedPOAmt, " +
      "zssm_productionplan_v.M_PriceList_Version_ID, " +
      "zssm_productionplan_v.Indirectcost, " +
      "zssm_productionplan_v.DateFinish, " +
      "zssm_productionplan_v.A_Asset_ID, " +
      "zssm_productionplan_v.ProjectBalanceAmt, " +
      "zssm_productionplan_v.Servcost, " +
      "zssm_productionplan_v.C_Campaign_ID, " +
      "zssm_productionplan_v.Schedulestatus, " +
      "zssm_productionplan_v.Qtyofproduct, " +
      "COALESCE(zssm_productionplan_v.IsCommitment, 'N') AS IsCommitment, " +
      "zssm_productionplan_v.Servrevenue, " +
      "zssm_productionplan_v.Zssm_Productionplan_V_ID, " +
      "zssm_productionplan_v.Expexpenses, " +
      "zssm_productionplan_v.Reopenproject, " +
      "zssm_productionplan_v.DateContract, " +
      "zssm_productionplan_v.C_Currency_ID, " +
      "zssm_productionplan_v.Processing, " +
      "zssm_productionplan_v.Estimatedamt, " +
      "zssm_productionplan_v.AD_User_ID, " +
      "zssm_productionplan_v.M_Product_ID, " +
      "zssm_productionplan_v.PlannedAmt, " +
      "zssm_productionplan_v.Actualcostamount, " +
      "zssm_productionplan_v.Expmargin, " +
      "zssm_productionplan_v.AccountNo, " +
      "zssm_productionplan_v.Publicprivate, " +
      "zssm_productionplan_v.M_PriceList_ID, " +
      "zssm_productionplan_v.POReference, " +
      "zssm_productionplan_v.M_Warehouse_ID, " +
      "zssm_productionplan_v.C_PaymentTerm_ID, " +
      "zssm_productionplan_v.C_BPartner_Location_ID, " +
      "COALESCE(zssm_productionplan_v.Createtemppricelist, 'N') AS Createtemppricelist, " +
      "zssm_productionplan_v.C_Project_ID, " +
      "zssm_productionplan_v.PlannedQty, " +
      "zssm_productionplan_v.Setprojecttype, " +
      "zssm_productionplan_v.InvoicedQty, " +
      "zssm_productionplan_v.BillTo_ID, " +
      "zssm_productionplan_v.Materialcost, " +
      "zssm_productionplan_v.SalesRep_ID, " +
      "zssm_productionplan_v.Closeproject, " +
      "zssm_productionplan_v.Servmargin, " +
      "zssm_productionplan_v.Startdate, " +
      "zssm_productionplan_v.CopyFrom, " +
      "zssm_productionplan_v.GenerateOrder, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_productionplan_v left join (select AD_Org_ID, Name from AD_Org) table1 on (zssm_productionplan_v.AD_Org_ID = table1.AD_Org_ID) left join ad_ref_list_v list1 on (zssm_productionplan_v.ProjectCategory = list1.value and list1.ad_reference_id = '377B9AA223674A8B825295B11AEAFE25' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (zssm_productionplan_v.ProjectStatus = list2.value and list2.ad_reference_id = 'CF2E265D07B74B8492A031AAD6BCE74D' and list2.ad_language = ?)  left join (select AD_User_ID, Name from AD_User) table2 on (zssm_productionplan_v.Responsible_ID =  table2.AD_User_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND zssm_productionplan_v.Zssm_Productionplan_V_ID = ? " +
      "        AND zssm_productionplan_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssm_productionplan_v.AD_Org_ID IN (";
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
        ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData = new ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData();
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.created = UtilSql.getValue(result, "created");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.updated = UtilSql.getValue(result, "updated");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.updatedby = UtilSql.getValue(result, "updatedby");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.projectcategory = UtilSql.getValue(result, "projectcategory");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.projectcategoryr = UtilSql.getValue(result, "projectcategoryr");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.isactive = UtilSql.getValue(result, "isactive");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.projectstatus = UtilSql.getValue(result, "projectstatus");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.projectstatusr = UtilSql.getValue(result, "projectstatusr");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.isdefault = UtilSql.getValue(result, "isdefault");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.isautotriggered = UtilSql.getValue(result, "isautotriggered");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.timeperpiece = UtilSql.getValue(result, "timeperpiece");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.setuptime = UtilSql.getValue(result, "setuptime");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.value = UtilSql.getValue(result, "value");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.name = UtilSql.getValue(result, "name");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.description = UtilSql.getValue(result, "description");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.note = UtilSql.getValue(result, "note");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.responsibleId = UtilSql.getValue(result, "responsible_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.responsibleIdr = UtilSql.getValue(result, "responsible_idr");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.changeprojectstatus = UtilSql.getValue(result, "changeprojectstatus");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.cPhaseId = UtilSql.getValue(result, "c_phase_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.committedamt = UtilSql.getValue(result, "committedamt");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.expreinvoicing = UtilSql.getValue(result, "expreinvoicing");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.processed = UtilSql.getValue(result, "processed");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.lastplannedproposaldate = UtilSql.getDateValue(result, "lastplannedproposaldate", "dd-MM-yyyy");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.cProjecttypeId = UtilSql.getValue(result, "c_projecttype_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.projectphase = UtilSql.getValue(result, "projectphase");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.expenses = UtilSql.getValue(result, "expenses");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.machinecost = UtilSql.getValue(result, "machinecost");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.iscommitceiling = UtilSql.getValue(result, "iscommitceiling");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.generateto = UtilSql.getValue(result, "generateto");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.issummary = UtilSql.getValue(result, "issummary");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.committedqty = UtilSql.getValue(result, "committedqty");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.plannedmarginamt = UtilSql.getValue(result, "plannedmarginamt");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.invoiceToproject = UtilSql.getValue(result, "invoice_toproject");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.documentCopies = UtilSql.getValue(result, "document_copies");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.percentdoneyet = UtilSql.getValue(result, "percentdoneyet");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.projectkind = UtilSql.getValue(result, "projectkind");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.plannedpoamt = UtilSql.getValue(result, "plannedpoamt");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.mPricelistVersionId = UtilSql.getValue(result, "m_pricelist_version_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.indirectcost = UtilSql.getValue(result, "indirectcost");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.datefinish = UtilSql.getDateValue(result, "datefinish", "dd-MM-yyyy");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.projectbalanceamt = UtilSql.getValue(result, "projectbalanceamt");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.servcost = UtilSql.getValue(result, "servcost");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.schedulestatus = UtilSql.getValue(result, "schedulestatus");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.qtyofproduct = UtilSql.getValue(result, "qtyofproduct");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.iscommitment = UtilSql.getValue(result, "iscommitment");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.servrevenue = UtilSql.getValue(result, "servrevenue");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.zssmProductionplanVId = UtilSql.getValue(result, "zssm_productionplan_v_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.expexpenses = UtilSql.getValue(result, "expexpenses");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.reopenproject = UtilSql.getValue(result, "reopenproject");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.datecontract = UtilSql.getDateValue(result, "datecontract", "dd-MM-yyyy");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.processing = UtilSql.getValue(result, "processing");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.estimatedamt = UtilSql.getValue(result, "estimatedamt");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.actualcostamount = UtilSql.getValue(result, "actualcostamount");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.expmargin = UtilSql.getValue(result, "expmargin");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.accountno = UtilSql.getValue(result, "accountno");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.publicprivate = UtilSql.getValue(result, "publicprivate");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.poreference = UtilSql.getValue(result, "poreference");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.createtemppricelist = UtilSql.getValue(result, "createtemppricelist");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.plannedqty = UtilSql.getValue(result, "plannedqty");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.setprojecttype = UtilSql.getValue(result, "setprojecttype");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.invoicedqty = UtilSql.getValue(result, "invoicedqty");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.billtoId = UtilSql.getValue(result, "billto_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.materialcost = UtilSql.getValue(result, "materialcost");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.closeproject = UtilSql.getValue(result, "closeproject");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.servmargin = UtilSql.getValue(result, "servmargin");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.generateorder = UtilSql.getValue(result, "generateorder");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.language = UtilSql.getValue(result, "language");
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.adUserClient = "";
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.adOrgClient = "";
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.createdby = "";
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.trBgcolor = "";
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.totalCount = "";
        objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData);
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
    ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[] = new ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[vector.size()];
    vector.copyInto(objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData);
    return(objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData);
  }

/**
Create a registry
 */
  public static ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[] set(String expexpenses, String invoicedqty, String projectbalanceamt, String cPhaseId, String accountno, String materialcost, String iscommitment, String actualcostamount, String salesrepId, String committedqty, String responsibleId, String closeproject, String adClientId, String projectphase, String schedulestatus, String servrevenue, String iscommitceiling, String projectkind, String invoicedamt, String plannedpoamt, String note, String setuptime, String committedamt, String name, String projectstatus, String mPricelistId, String invoiceToproject, String poreference, String plannedqty, String mProductId, String mPricelistVersionId, String expenses, String cCurrencyId, String createdby, String createdbyr, String setprojecttype, String cPaymenttermId, String startdate, String expreinvoicing, String plannedamt, String updatedby, String updatedbyr, String lastplannedproposaldate, String processed, String issummary, String datefinish, String paymentrule, String isdefault, String cLocationId, String aAssetId, String servcost, String description, String generateorder, String billtoId, String cCampaignId, String publicprivate, String cBpartnerLocationId, String isautotriggered, String qtyofproduct, String zssmProductionplanVId, String expmargin, String percentdoneyet, String copyfrom, String cProjecttypeId, String machinecost, String timeperpiece, String servmargin, String plannedmarginamt, String datecontract, String estimatedamt, String changeprojectstatus, String changeprojectstatusBtn, String value, String cProjectId, String generateto, String cBpartnerId, String reopenproject, String projectcategory, String isactive, String adUserId, String adOrgId, String processing, String createtemppricelist, String documentCopies, String indirectcost, String mWarehouseId)    throws ServletException {
    ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[] = new ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[1];
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0] = new ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData();
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].created = "";
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].createdbyr = createdbyr;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].updated = "";
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].updatedTimeStamp = "";
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].updatedby = updatedby;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].updatedbyr = updatedbyr;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].adOrgId = adOrgId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].adOrgIdr = "";
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].projectcategory = projectcategory;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].projectcategoryr = "";
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].isactive = isactive;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].projectstatus = projectstatus;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].projectstatusr = "";
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].isdefault = isdefault;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].isautotriggered = isautotriggered;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].timeperpiece = timeperpiece;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].setuptime = setuptime;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].value = value;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].name = name;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].description = description;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].note = note;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].responsibleId = responsibleId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].responsibleIdr = "";
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].changeprojectstatus = changeprojectstatus;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].cPhaseId = cPhaseId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].committedamt = committedamt;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].expreinvoicing = expreinvoicing;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].processed = processed;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].lastplannedproposaldate = lastplannedproposaldate;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].cProjecttypeId = cProjecttypeId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].projectphase = projectphase;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].expenses = expenses;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].paymentrule = paymentrule;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].machinecost = machinecost;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].iscommitceiling = iscommitceiling;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].generateto = generateto;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].cBpartnerId = cBpartnerId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].issummary = issummary;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].committedqty = committedqty;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].plannedmarginamt = plannedmarginamt;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].invoicedamt = invoicedamt;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].cLocationId = cLocationId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].invoiceToproject = invoiceToproject;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].adClientId = adClientId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].documentCopies = documentCopies;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].percentdoneyet = percentdoneyet;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].projectkind = projectkind;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].plannedpoamt = plannedpoamt;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].mPricelistVersionId = mPricelistVersionId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].indirectcost = indirectcost;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].datefinish = datefinish;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].aAssetId = aAssetId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].projectbalanceamt = projectbalanceamt;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].servcost = servcost;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].cCampaignId = cCampaignId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].schedulestatus = schedulestatus;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].qtyofproduct = qtyofproduct;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].iscommitment = iscommitment;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].servrevenue = servrevenue;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].zssmProductionplanVId = zssmProductionplanVId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].expexpenses = expexpenses;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].reopenproject = reopenproject;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].datecontract = datecontract;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].cCurrencyId = cCurrencyId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].processing = processing;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].estimatedamt = estimatedamt;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].adUserId = adUserId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].mProductId = mProductId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].plannedamt = plannedamt;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].actualcostamount = actualcostamount;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].expmargin = expmargin;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].accountno = accountno;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].publicprivate = publicprivate;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].mPricelistId = mPricelistId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].poreference = poreference;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].mWarehouseId = mWarehouseId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].cPaymenttermId = cPaymenttermId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].createtemppricelist = createtemppricelist;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].cProjectId = cProjectId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].plannedqty = plannedqty;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].setprojecttype = setprojecttype;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].invoicedqty = invoicedqty;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].billtoId = billtoId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].materialcost = materialcost;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].salesrepId = salesrepId;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].closeproject = closeproject;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].servmargin = servmargin;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].startdate = startdate;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].copyfrom = copyfrom;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].generateorder = generateorder;
    objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0].language = "";
    return objectProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef464EC7312A434A6B8CFB56A6244A0DD5(ConnectionProvider connectionProvider, String ad_client_ID)    throws ServletException {
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
  public static String selectDefDDCB17F4783B42F3AB9159DBC8BA5284_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDefC3CDDA746364456B84023E8993F65CEF_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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

  public static int updateChangeProjectStatus(ConnectionProvider connectionProvider, String changeprojectstatus, String zssmProductionplanVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE zssm_productionplan_v" +
      "        SET changeprojectstatus = ? " +
      "        WHERE zssm_productionplan_v.Zssm_Productionplan_V_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changeprojectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);

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
      "        UPDATE zssm_productionplan_v" +
      "        SET AD_Org_ID = (?) , ProjectCategory = (?) , IsActive = (?) , ProjectStatus = (?) , Isdefault = (?) , Isautotriggered = (?) , Timeperpiece = TO_NUMBER(?) , Setuptime = TO_NUMBER(?) , Value = (?) , Name = (?) , Description = (?) , Note = (?) , Responsible_ID = (?) , ChangeProjectStatus = (?) , C_Phase_ID = (?) , CommittedAmt = TO_NUMBER(?) , Expreinvoicing = TO_NUMBER(?) , Processed = (?) , LastPlannedProposalDate = TO_DATE(?) , C_ProjectType_ID = (?) , Projectphase = (?) , Expenses = TO_NUMBER(?) , PaymentRule = (?) , Machinecost = TO_NUMBER(?) , IsCommitCeiling = (?) , GenerateTo = (?) , C_BPartner_ID = (?) , IsSummary = (?) , CommittedQty = TO_NUMBER(?) , PlannedMarginAmt = TO_NUMBER(?) , InvoicedAmt = TO_NUMBER(?) , C_Location_ID = (?) , Invoice_ToProject = (?) , AD_Client_ID = (?) , Document_Copies = TO_NUMBER(?) , Percentdoneyet = TO_NUMBER(?) , Projectkind = (?) , PlannedPOAmt = TO_NUMBER(?) , M_PriceList_Version_ID = (?) , Indirectcost = TO_NUMBER(?) , DateFinish = TO_DATE(?) , A_Asset_ID = (?) , ProjectBalanceAmt = TO_NUMBER(?) , Servcost = TO_NUMBER(?) , C_Campaign_ID = (?) , Schedulestatus = (?) , Qtyofproduct = TO_NUMBER(?) , IsCommitment = (?) , Servrevenue = TO_NUMBER(?) , Zssm_Productionplan_V_ID = (?) , Expexpenses = TO_NUMBER(?) , Reopenproject = (?) , DateContract = TO_DATE(?) , C_Currency_ID = (?) , Processing = (?) , Estimatedamt = TO_NUMBER(?) , AD_User_ID = (?) , M_Product_ID = (?) , PlannedAmt = TO_NUMBER(?) , Actualcostamount = TO_NUMBER(?) , Expmargin = TO_NUMBER(?) , AccountNo = (?) , Publicprivate = (?) , M_PriceList_ID = (?) , POReference = (?) , M_Warehouse_ID = (?) , C_PaymentTerm_ID = (?) , C_BPartner_Location_ID = (?) , Createtemppricelist = (?) , C_Project_ID = (?) , PlannedQty = TO_NUMBER(?) , Setprojecttype = (?) , InvoicedQty = TO_NUMBER(?) , BillTo_ID = (?) , Materialcost = TO_NUMBER(?) , SalesRep_ID = (?) , Closeproject = (?) , Servmargin = TO_NUMBER(?) , Startdate = TO_DATE(?) , CopyFrom = (?) , GenerateOrder = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssm_productionplan_v.Zssm_Productionplan_V_ID = ? " +
      "        AND zssm_productionplan_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_productionplan_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isautotriggered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timeperpiece);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setuptime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, responsibleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changeprojectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPhaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expreinvoicing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastplannedproposaldate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectphase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceToproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentCopies);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdoneyet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectkind);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedpoamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefinish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectbalanceamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyofproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servrevenue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expexpenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reopenproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, publicprivate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createtemppricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setprojecttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);
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
      "        INSERT INTO zssm_productionplan_v " +
      "        (AD_Org_ID, ProjectCategory, IsActive, ProjectStatus, Isdefault, Isautotriggered, Timeperpiece, Setuptime, Value, Name, Description, Note, Responsible_ID, ChangeProjectStatus, C_Phase_ID, CommittedAmt, Expreinvoicing, Processed, LastPlannedProposalDate, C_ProjectType_ID, Projectphase, Expenses, PaymentRule, Machinecost, IsCommitCeiling, GenerateTo, C_BPartner_ID, IsSummary, CommittedQty, PlannedMarginAmt, InvoicedAmt, C_Location_ID, Invoice_ToProject, AD_Client_ID, Document_Copies, Percentdoneyet, Projectkind, PlannedPOAmt, M_PriceList_Version_ID, Indirectcost, DateFinish, A_Asset_ID, ProjectBalanceAmt, Servcost, C_Campaign_ID, Schedulestatus, Qtyofproduct, IsCommitment, Servrevenue, Zssm_Productionplan_V_ID, Expexpenses, Reopenproject, DateContract, C_Currency_ID, Processing, Estimatedamt, AD_User_ID, M_Product_ID, PlannedAmt, Actualcostamount, Expmargin, AccountNo, Publicprivate, M_PriceList_ID, POReference, M_Warehouse_ID, C_PaymentTerm_ID, C_BPartner_Location_ID, Createtemppricelist, C_Project_ID, PlannedQty, Setprojecttype, InvoicedQty, BillTo_ID, Materialcost, SalesRep_ID, Closeproject, Servmargin, Startdate, CopyFrom, GenerateOrder, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_DATE(?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_DATE(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_DATE(?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_DATE(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isautotriggered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timeperpiece);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setuptime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, responsibleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changeprojectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPhaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expreinvoicing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastplannedproposaldate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectphase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceToproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentCopies);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdoneyet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectkind);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedpoamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefinish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectbalanceamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyofproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servrevenue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expexpenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reopenproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, publicprivate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createtemppricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setprojecttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateorder);
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
      "        DELETE FROM zssm_productionplan_v" +
      "        WHERE zssm_productionplan_v.Zssm_Productionplan_V_ID = ? " +
      "        AND zssm_productionplan_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_productionplan_v.AD_Org_ID IN (";
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
      "        DELETE FROM zssm_productionplan_v" +
      "        WHERE zssm_productionplan_v.Zssm_Productionplan_V_ID = ? ";

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
      "          FROM zssm_productionplan_v" +
      "         WHERE zssm_productionplan_v.Zssm_Productionplan_V_ID = ? ";

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
      "          FROM zssm_productionplan_v" +
      "         WHERE zssm_productionplan_v.Zssm_Productionplan_V_ID = ? ";

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
