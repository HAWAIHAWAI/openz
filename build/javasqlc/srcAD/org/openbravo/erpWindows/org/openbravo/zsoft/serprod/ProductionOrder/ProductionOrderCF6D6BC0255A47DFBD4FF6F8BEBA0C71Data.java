//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.ProductionOrder;

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
class ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String value;
  public String name;
  public String description;
  public String note;
  public String isactive;
  public String projectstatus;
  public String projectstatusr;
  public String startdate;
  public String datefinish;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String responsibleId;
  public String responsibleIdr;
  public String actualcostamount;
  public String machinecost;
  public String materialcost;
  public String servcost;
  public String changeprojectstatus;
  public String closeproject;
  public String adUserId;
  public String mPricelistId;
  public String cLocationId;
  public String adClientId;
  public String expmargin;
  public String schedulestatus;
  public String expenses;
  public String copyfrom;
  public String cCurrencyId;
  public String cProjecttypeId;
  public String lastplannedproposaldate;
  public String paymentrule;
  public String projectbalanceamt;
  public String projectkind;
  public String generateorder;
  public String processing;
  public String servrevenue;
  public String documentCopies;
  public String processed;
  public String poreference;
  public String projectphase;
  public String mPricelistVersionId;
  public String percentdoneyet;
  public String invoicedqty;
  public String cProjectId;
  public String setprojecttype;
  public String mProductId;
  public String projectcategory;
  public String qtyofproduct;
  public String estimatedamt;
  public String accountno;
  public String cBpartnerLocationId;
  public String aAssetId;
  public String cPaymenttermId;
  public String issummary;
  public String committedamt;
  public String plannedqty;
  public String createtemppricelist;
  public String indirectcost;
  public String committedqty;
  public String cBpartnerId;
  public String servmargin;
  public String zssmProductionorderVId;
  public String datecontract;
  public String billtoId;
  public String generateto;
  public String plannedmarginamt;
  public String salesrepId;
  public String plannedpoamt;
  public String publicprivate;
  public String invoicedamt;
  public String iscommitceiling;
  public String expexpenses;
  public String cCampaignId;
  public String plannedamt;
  public String expreinvoicing;
  public String iscommitment;
  public String reopenproject;
  public String invoiceToproject;
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
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("note"))
      return note;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("projectstatus"))
      return projectstatus;
    else if (fieldName.equalsIgnoreCase("projectstatusr"))
      return projectstatusr;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("datefinish"))
      return datefinish;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("responsible_id") || fieldName.equals("responsibleId"))
      return responsibleId;
    else if (fieldName.equalsIgnoreCase("responsible_idr") || fieldName.equals("responsibleIdr"))
      return responsibleIdr;
    else if (fieldName.equalsIgnoreCase("actualcostamount"))
      return actualcostamount;
    else if (fieldName.equalsIgnoreCase("machinecost"))
      return machinecost;
    else if (fieldName.equalsIgnoreCase("materialcost"))
      return materialcost;
    else if (fieldName.equalsIgnoreCase("servcost"))
      return servcost;
    else if (fieldName.equalsIgnoreCase("changeprojectstatus"))
      return changeprojectstatus;
    else if (fieldName.equalsIgnoreCase("closeproject"))
      return closeproject;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("c_location_id") || fieldName.equals("cLocationId"))
      return cLocationId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("expmargin"))
      return expmargin;
    else if (fieldName.equalsIgnoreCase("schedulestatus"))
      return schedulestatus;
    else if (fieldName.equalsIgnoreCase("expenses"))
      return expenses;
    else if (fieldName.equalsIgnoreCase("copyfrom"))
      return copyfrom;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_projecttype_id") || fieldName.equals("cProjecttypeId"))
      return cProjecttypeId;
    else if (fieldName.equalsIgnoreCase("lastplannedproposaldate"))
      return lastplannedproposaldate;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("projectbalanceamt"))
      return projectbalanceamt;
    else if (fieldName.equalsIgnoreCase("projectkind"))
      return projectkind;
    else if (fieldName.equalsIgnoreCase("generateorder"))
      return generateorder;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("servrevenue"))
      return servrevenue;
    else if (fieldName.equalsIgnoreCase("document_copies") || fieldName.equals("documentCopies"))
      return documentCopies;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("projectphase"))
      return projectphase;
    else if (fieldName.equalsIgnoreCase("m_pricelist_version_id") || fieldName.equals("mPricelistVersionId"))
      return mPricelistVersionId;
    else if (fieldName.equalsIgnoreCase("percentdoneyet"))
      return percentdoneyet;
    else if (fieldName.equalsIgnoreCase("invoicedqty"))
      return invoicedqty;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("setprojecttype"))
      return setprojecttype;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("projectcategory"))
      return projectcategory;
    else if (fieldName.equalsIgnoreCase("qtyofproduct"))
      return qtyofproduct;
    else if (fieldName.equalsIgnoreCase("estimatedamt"))
      return estimatedamt;
    else if (fieldName.equalsIgnoreCase("accountno"))
      return accountno;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("committedamt"))
      return committedamt;
    else if (fieldName.equalsIgnoreCase("plannedqty"))
      return plannedqty;
    else if (fieldName.equalsIgnoreCase("createtemppricelist"))
      return createtemppricelist;
    else if (fieldName.equalsIgnoreCase("indirectcost"))
      return indirectcost;
    else if (fieldName.equalsIgnoreCase("committedqty"))
      return committedqty;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("servmargin"))
      return servmargin;
    else if (fieldName.equalsIgnoreCase("zssm_productionorder_v_id") || fieldName.equals("zssmProductionorderVId"))
      return zssmProductionorderVId;
    else if (fieldName.equalsIgnoreCase("datecontract"))
      return datecontract;
    else if (fieldName.equalsIgnoreCase("billto_id") || fieldName.equals("billtoId"))
      return billtoId;
    else if (fieldName.equalsIgnoreCase("generateto"))
      return generateto;
    else if (fieldName.equalsIgnoreCase("plannedmarginamt"))
      return plannedmarginamt;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("plannedpoamt"))
      return plannedpoamt;
    else if (fieldName.equalsIgnoreCase("publicprivate"))
      return publicprivate;
    else if (fieldName.equalsIgnoreCase("invoicedamt"))
      return invoicedamt;
    else if (fieldName.equalsIgnoreCase("iscommitceiling"))
      return iscommitceiling;
    else if (fieldName.equalsIgnoreCase("expexpenses"))
      return expexpenses;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("plannedamt"))
      return plannedamt;
    else if (fieldName.equalsIgnoreCase("expreinvoicing"))
      return expreinvoicing;
    else if (fieldName.equalsIgnoreCase("iscommitment"))
      return iscommitment;
    else if (fieldName.equalsIgnoreCase("reopenproject"))
      return reopenproject;
    else if (fieldName.equalsIgnoreCase("invoice_toproject") || fieldName.equals("invoiceToproject"))
      return invoiceToproject;
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
  public static ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssm_productionorder_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_productionorder_v.CreatedBy) as CreatedByR, " +
      "        to_char(zssm_productionorder_v.Updated, ?) as updated, " +
      "        to_char(zssm_productionorder_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssm_productionorder_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_productionorder_v.UpdatedBy) as UpdatedByR," +
      "        zssm_productionorder_v.AD_Org_ID, " +
      "(CASE WHEN zssm_productionorder_v.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zssm_productionorder_v.Value, " +
      "zssm_productionorder_v.Name, " +
      "zssm_productionorder_v.Description, " +
      "zssm_productionorder_v.Note, " +
      "COALESCE(zssm_productionorder_v.IsActive, 'N') AS IsActive, " +
      "zssm_productionorder_v.ProjectStatus, " +
      "(CASE WHEN zssm_productionorder_v.ProjectStatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ProjectStatusR, " +
      "zssm_productionorder_v.Startdate, " +
      "zssm_productionorder_v.DateFinish, " +
      "zssm_productionorder_v.M_Warehouse_ID, " +
      "(CASE WHEN zssm_productionorder_v.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "zssm_productionorder_v.Responsible_ID, " +
      "(CASE WHEN zssm_productionorder_v.Responsible_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS Responsible_IDR, " +
      "zssm_productionorder_v.Actualcostamount, " +
      "zssm_productionorder_v.Machinecost, " +
      "zssm_productionorder_v.Materialcost, " +
      "zssm_productionorder_v.Servcost, " +
      "zssm_productionorder_v.ChangeProjectStatus, " +
      "zssm_productionorder_v.CloseProject, " +
      "zssm_productionorder_v.AD_User_ID, " +
      "zssm_productionorder_v.M_PriceList_ID, " +
      "zssm_productionorder_v.C_Location_ID, " +
      "zssm_productionorder_v.AD_Client_ID, " +
      "zssm_productionorder_v.Expmargin, " +
      "zssm_productionorder_v.Schedulestatus, " +
      "zssm_productionorder_v.Expenses, " +
      "zssm_productionorder_v.CopyFrom, " +
      "zssm_productionorder_v.C_Currency_ID, " +
      "zssm_productionorder_v.C_ProjectType_ID, " +
      "zssm_productionorder_v.LastPlannedProposalDate, " +
      "zssm_productionorder_v.PaymentRule, " +
      "zssm_productionorder_v.ProjectBalanceAmt, " +
      "zssm_productionorder_v.Projectkind, " +
      "zssm_productionorder_v.GenerateOrder, " +
      "zssm_productionorder_v.Processing, " +
      "zssm_productionorder_v.Servrevenue, " +
      "zssm_productionorder_v.Document_Copies, " +
      "COALESCE(zssm_productionorder_v.Processed, 'N') AS Processed, " +
      "zssm_productionorder_v.POReference, " +
      "zssm_productionorder_v.Projectphase, " +
      "zssm_productionorder_v.M_PriceList_Version_ID, " +
      "zssm_productionorder_v.Percentdoneyet, " +
      "zssm_productionorder_v.InvoicedQty, " +
      "zssm_productionorder_v.C_Project_ID, " +
      "zssm_productionorder_v.Setprojecttype, " +
      "zssm_productionorder_v.M_Product_ID, " +
      "zssm_productionorder_v.ProjectCategory, " +
      "zssm_productionorder_v.Qtyofproduct, " +
      "zssm_productionorder_v.Estimatedamt, " +
      "zssm_productionorder_v.AccountNo, " +
      "zssm_productionorder_v.C_BPartner_Location_ID, " +
      "zssm_productionorder_v.A_Asset_ID, " +
      "zssm_productionorder_v.C_PaymentTerm_ID, " +
      "COALESCE(zssm_productionorder_v.IsSummary, 'N') AS IsSummary, " +
      "zssm_productionorder_v.CommittedAmt, " +
      "zssm_productionorder_v.PlannedQty, " +
      "COALESCE(zssm_productionorder_v.Createtemppricelist, 'N') AS Createtemppricelist, " +
      "zssm_productionorder_v.Indirectcost, " +
      "zssm_productionorder_v.CommittedQty, " +
      "zssm_productionorder_v.C_BPartner_ID, " +
      "zssm_productionorder_v.Servmargin, " +
      "zssm_productionorder_v.Zssm_Productionorder_V_ID, " +
      "zssm_productionorder_v.DateContract, " +
      "zssm_productionorder_v.BillTo_ID, " +
      "zssm_productionorder_v.GenerateTo, " +
      "zssm_productionorder_v.PlannedMarginAmt, " +
      "zssm_productionorder_v.SalesRep_ID, " +
      "zssm_productionorder_v.PlannedPOAmt, " +
      "zssm_productionorder_v.Publicprivate, " +
      "zssm_productionorder_v.InvoicedAmt, " +
      "COALESCE(zssm_productionorder_v.IsCommitCeiling, 'N') AS IsCommitCeiling, " +
      "zssm_productionorder_v.Expexpenses, " +
      "zssm_productionorder_v.C_Campaign_ID, " +
      "zssm_productionorder_v.PlannedAmt, " +
      "zssm_productionorder_v.Expreinvoicing, " +
      "COALESCE(zssm_productionorder_v.IsCommitment, 'N') AS IsCommitment, " +
      "zssm_productionorder_v.Reopenproject, " +
      "COALESCE(zssm_productionorder_v.Invoice_ToProject, 'N') AS Invoice_ToProject, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_productionorder_v left join (select AD_Org_ID, Name from AD_Org) table1 on (zssm_productionorder_v.AD_Org_ID = table1.AD_Org_ID) left join ad_ref_list_v list1 on (zssm_productionorder_v.ProjectStatus = list1.value and list1.ad_reference_id = '285D1A65E0F847E5844969E712B0FDC8' and list1.ad_language = ?)  left join (select M_Warehouse_ID, Name from M_Warehouse) table2 on (zssm_productionorder_v.M_Warehouse_ID = table2.M_Warehouse_ID) left join (select AD_User_ID, Name from AD_User) table3 on (zssm_productionorder_v.Responsible_ID =  table3.AD_User_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND zssm_productionorder_v.Zssm_Productionorder_V_ID = ? " +
      "        AND zssm_productionorder_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssm_productionorder_v.AD_Org_ID IN (";
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
        ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data = new ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data();
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.created = UtilSql.getValue(result, "created");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.updated = UtilSql.getValue(result, "updated");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.value = UtilSql.getValue(result, "value");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.name = UtilSql.getValue(result, "name");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.description = UtilSql.getValue(result, "description");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.note = UtilSql.getValue(result, "note");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.isactive = UtilSql.getValue(result, "isactive");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.projectstatus = UtilSql.getValue(result, "projectstatus");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.projectstatusr = UtilSql.getValue(result, "projectstatusr");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.datefinish = UtilSql.getDateValue(result, "datefinish", "dd-MM-yyyy");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.responsibleId = UtilSql.getValue(result, "responsible_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.responsibleIdr = UtilSql.getValue(result, "responsible_idr");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.actualcostamount = UtilSql.getValue(result, "actualcostamount");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.machinecost = UtilSql.getValue(result, "machinecost");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.materialcost = UtilSql.getValue(result, "materialcost");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.servcost = UtilSql.getValue(result, "servcost");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.changeprojectstatus = UtilSql.getValue(result, "changeprojectstatus");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.closeproject = UtilSql.getValue(result, "closeproject");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.expmargin = UtilSql.getValue(result, "expmargin");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.schedulestatus = UtilSql.getValue(result, "schedulestatus");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.expenses = UtilSql.getValue(result, "expenses");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.cProjecttypeId = UtilSql.getValue(result, "c_projecttype_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.lastplannedproposaldate = UtilSql.getDateValue(result, "lastplannedproposaldate", "dd-MM-yyyy");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.projectbalanceamt = UtilSql.getValue(result, "projectbalanceamt");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.projectkind = UtilSql.getValue(result, "projectkind");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.generateorder = UtilSql.getValue(result, "generateorder");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.processing = UtilSql.getValue(result, "processing");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.servrevenue = UtilSql.getValue(result, "servrevenue");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.documentCopies = UtilSql.getValue(result, "document_copies");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.processed = UtilSql.getValue(result, "processed");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.poreference = UtilSql.getValue(result, "poreference");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.projectphase = UtilSql.getValue(result, "projectphase");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.mPricelistVersionId = UtilSql.getValue(result, "m_pricelist_version_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.percentdoneyet = UtilSql.getValue(result, "percentdoneyet");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.invoicedqty = UtilSql.getValue(result, "invoicedqty");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.setprojecttype = UtilSql.getValue(result, "setprojecttype");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.projectcategory = UtilSql.getValue(result, "projectcategory");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.qtyofproduct = UtilSql.getValue(result, "qtyofproduct");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.estimatedamt = UtilSql.getValue(result, "estimatedamt");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.accountno = UtilSql.getValue(result, "accountno");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.issummary = UtilSql.getValue(result, "issummary");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.committedamt = UtilSql.getValue(result, "committedamt");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.plannedqty = UtilSql.getValue(result, "plannedqty");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.createtemppricelist = UtilSql.getValue(result, "createtemppricelist");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.indirectcost = UtilSql.getValue(result, "indirectcost");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.committedqty = UtilSql.getValue(result, "committedqty");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.servmargin = UtilSql.getValue(result, "servmargin");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.zssmProductionorderVId = UtilSql.getValue(result, "zssm_productionorder_v_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.datecontract = UtilSql.getDateValue(result, "datecontract", "dd-MM-yyyy");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.billtoId = UtilSql.getValue(result, "billto_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.generateto = UtilSql.getValue(result, "generateto");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.plannedmarginamt = UtilSql.getValue(result, "plannedmarginamt");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.plannedpoamt = UtilSql.getValue(result, "plannedpoamt");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.publicprivate = UtilSql.getValue(result, "publicprivate");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.iscommitceiling = UtilSql.getValue(result, "iscommitceiling");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.expexpenses = UtilSql.getValue(result, "expexpenses");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.expreinvoicing = UtilSql.getValue(result, "expreinvoicing");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.iscommitment = UtilSql.getValue(result, "iscommitment");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.reopenproject = UtilSql.getValue(result, "reopenproject");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.invoiceToproject = UtilSql.getValue(result, "invoice_toproject");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.language = UtilSql.getValue(result, "language");
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.adUserClient = "";
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.adOrgClient = "";
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.createdby = "";
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.trBgcolor = "";
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.totalCount = "";
        objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data);
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
    ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[] = new ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[vector.size()];
    vector.copyInto(objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data);
    return(objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data);
  }

/**
Create a registry
 */
  public static ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[] set(String cLocationId, String expenses, String generateorder, String mWarehouseId, String expmargin, String cCampaignId, String cProjecttypeId, String cBpartnerId, String name, String servmargin, String schedulestatus, String projectphase, String mPricelistId, String isactive, String invoicedqty, String responsibleId, String iscommitceiling, String adOrgId, String indirectcost, String reopenproject, String cCurrencyId, String servrevenue, String billtoId, String lastplannedproposaldate, String changeprojectstatus, String changeprojectstatusBtn, String projectstatus, String mProductId, String generateto, String expexpenses, String cProjectId, String machinecost, String processed, String actualcostamount, String description, String createdby, String createdbyr, String plannedpoamt, String salesrepId, String plannedamt, String accountno, String invoicedamt, String publicprivate, String adUserId, String documentCopies, String closeproject, String projectbalanceamt, String datecontract, String aAssetId, String datefinish, String poreference, String invoiceToproject, String expreinvoicing, String adClientId, String iscommitment, String plannedqty, String cPaymenttermId, String startdate, String committedqty, String projectkind, String updatedby, String updatedbyr, String setprojecttype, String materialcost, String servcost, String createtemppricelist, String paymentrule, String percentdoneyet, String plannedmarginamt, String projectcategory, String qtyofproduct, String value, String processing, String cBpartnerLocationId, String copyfrom, String mPricelistVersionId, String committedamt, String zssmProductionorderVId, String estimatedamt, String issummary, String note)    throws ServletException {
    ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[] = new ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[1];
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0] = new ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data();
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].created = "";
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].createdbyr = createdbyr;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].updated = "";
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].updatedTimeStamp = "";
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].updatedby = updatedby;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].updatedbyr = updatedbyr;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].adOrgId = adOrgId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].adOrgIdr = "";
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].value = value;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].name = name;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].description = description;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].note = note;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].isactive = isactive;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].projectstatus = projectstatus;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].projectstatusr = "";
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].startdate = startdate;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].datefinish = datefinish;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].mWarehouseId = mWarehouseId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].mWarehouseIdr = "";
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].responsibleId = responsibleId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].responsibleIdr = "";
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].actualcostamount = actualcostamount;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].machinecost = machinecost;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].materialcost = materialcost;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].servcost = servcost;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].changeprojectstatus = changeprojectstatus;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].closeproject = closeproject;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].adUserId = adUserId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].mPricelistId = mPricelistId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].cLocationId = cLocationId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].adClientId = adClientId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].expmargin = expmargin;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].schedulestatus = schedulestatus;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].expenses = expenses;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].copyfrom = copyfrom;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].cCurrencyId = cCurrencyId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].cProjecttypeId = cProjecttypeId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].lastplannedproposaldate = lastplannedproposaldate;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].paymentrule = paymentrule;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].projectbalanceamt = projectbalanceamt;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].projectkind = projectkind;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].generateorder = generateorder;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].processing = processing;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].servrevenue = servrevenue;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].documentCopies = documentCopies;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].processed = processed;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].poreference = poreference;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].projectphase = projectphase;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].mPricelistVersionId = mPricelistVersionId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].percentdoneyet = percentdoneyet;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].invoicedqty = invoicedqty;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].cProjectId = cProjectId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].setprojecttype = setprojecttype;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].mProductId = mProductId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].projectcategory = projectcategory;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].qtyofproduct = qtyofproduct;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].estimatedamt = estimatedamt;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].accountno = accountno;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].cBpartnerLocationId = cBpartnerLocationId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].aAssetId = aAssetId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].cPaymenttermId = cPaymenttermId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].issummary = issummary;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].committedamt = committedamt;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].plannedqty = plannedqty;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].createtemppricelist = createtemppricelist;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].indirectcost = indirectcost;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].committedqty = committedqty;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].cBpartnerId = cBpartnerId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].servmargin = servmargin;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].zssmProductionorderVId = zssmProductionorderVId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].datecontract = datecontract;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].billtoId = billtoId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].generateto = generateto;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].plannedmarginamt = plannedmarginamt;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].salesrepId = salesrepId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].plannedpoamt = plannedpoamt;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].publicprivate = publicprivate;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].invoicedamt = invoicedamt;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].iscommitceiling = iscommitceiling;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].expexpenses = expexpenses;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].cCampaignId = cCampaignId;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].plannedamt = plannedamt;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].expreinvoicing = expreinvoicing;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].iscommitment = iscommitment;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].reopenproject = reopenproject;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].invoiceToproject = invoiceToproject;
    objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0].language = "";
    return objectProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefC04C197FCAB0495284A6BFFCDE5C0480(ConnectionProvider connectionProvider, String ad_client_ID)    throws ServletException {
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
  public static String selectDef8B5C2BB077454B65AAC32F77F9A73D76_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef7EBCB8A1D65343F597BFAB1415EA0C74_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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

  public static int updateChangeProjectStatus(ConnectionProvider connectionProvider, String changeprojectstatus, String zssmProductionorderVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE zssm_productionorder_v" +
      "        SET changeprojectstatus = ? " +
      "        WHERE zssm_productionorder_v.Zssm_Productionorder_V_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changeprojectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);

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
      "        UPDATE zssm_productionorder_v" +
      "        SET AD_Org_ID = (?) , Value = (?) , Name = (?) , Description = (?) , Note = (?) , IsActive = (?) , ProjectStatus = (?) , Startdate = TO_DATE(?) , DateFinish = TO_DATE(?) , M_Warehouse_ID = (?) , Responsible_ID = (?) , Actualcostamount = TO_NUMBER(?) , Machinecost = TO_NUMBER(?) , Materialcost = TO_NUMBER(?) , Servcost = TO_NUMBER(?) , ChangeProjectStatus = (?) , CloseProject = (?) , AD_User_ID = (?) , M_PriceList_ID = (?) , C_Location_ID = (?) , AD_Client_ID = (?) , Expmargin = TO_NUMBER(?) , Schedulestatus = (?) , Expenses = TO_NUMBER(?) , CopyFrom = (?) , C_Currency_ID = (?) , C_ProjectType_ID = (?) , LastPlannedProposalDate = TO_DATE(?) , PaymentRule = (?) , ProjectBalanceAmt = TO_NUMBER(?) , Projectkind = (?) , GenerateOrder = (?) , Processing = (?) , Servrevenue = TO_NUMBER(?) , Document_Copies = TO_NUMBER(?) , Processed = (?) , POReference = (?) , Projectphase = (?) , M_PriceList_Version_ID = (?) , Percentdoneyet = TO_NUMBER(?) , InvoicedQty = TO_NUMBER(?) , C_Project_ID = (?) , Setprojecttype = (?) , M_Product_ID = (?) , ProjectCategory = (?) , Qtyofproduct = TO_NUMBER(?) , Estimatedamt = TO_NUMBER(?) , AccountNo = (?) , C_BPartner_Location_ID = (?) , A_Asset_ID = (?) , C_PaymentTerm_ID = (?) , IsSummary = (?) , CommittedAmt = TO_NUMBER(?) , PlannedQty = TO_NUMBER(?) , Createtemppricelist = (?) , Indirectcost = TO_NUMBER(?) , CommittedQty = TO_NUMBER(?) , C_BPartner_ID = (?) , Servmargin = TO_NUMBER(?) , Zssm_Productionorder_V_ID = (?) , DateContract = TO_DATE(?) , BillTo_ID = (?) , GenerateTo = (?) , PlannedMarginAmt = TO_NUMBER(?) , SalesRep_ID = (?) , PlannedPOAmt = TO_NUMBER(?) , Publicprivate = (?) , InvoicedAmt = TO_NUMBER(?) , IsCommitCeiling = (?) , Expexpenses = TO_NUMBER(?) , C_Campaign_ID = (?) , PlannedAmt = TO_NUMBER(?) , Expreinvoicing = TO_NUMBER(?) , IsCommitment = (?) , Reopenproject = (?) , Invoice_ToProject = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssm_productionorder_v.Zssm_Productionorder_V_ID = ? " +
      "        AND zssm_productionorder_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_productionorder_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefinish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, responsibleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changeprojectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastplannedproposaldate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectbalanceamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectkind);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servrevenue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentCopies);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectphase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdoneyet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setprojecttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyofproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createtemppricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedpoamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, publicprivate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expexpenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expreinvoicing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reopenproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceToproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
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
      "        INSERT INTO zssm_productionorder_v " +
      "        (AD_Org_ID, Value, Name, Description, Note, IsActive, ProjectStatus, Startdate, DateFinish, M_Warehouse_ID, Responsible_ID, Actualcostamount, Machinecost, Materialcost, Servcost, ChangeProjectStatus, CloseProject, AD_User_ID, M_PriceList_ID, C_Location_ID, AD_Client_ID, Expmargin, Schedulestatus, Expenses, CopyFrom, C_Currency_ID, C_ProjectType_ID, LastPlannedProposalDate, PaymentRule, ProjectBalanceAmt, Projectkind, GenerateOrder, Processing, Servrevenue, Document_Copies, Processed, POReference, Projectphase, M_PriceList_Version_ID, Percentdoneyet, InvoicedQty, C_Project_ID, Setprojecttype, M_Product_ID, ProjectCategory, Qtyofproduct, Estimatedamt, AccountNo, C_BPartner_Location_ID, A_Asset_ID, C_PaymentTerm_ID, IsSummary, CommittedAmt, PlannedQty, Createtemppricelist, Indirectcost, CommittedQty, C_BPartner_ID, Servmargin, Zssm_Productionorder_V_ID, DateContract, BillTo_ID, GenerateTo, PlannedMarginAmt, SalesRep_ID, PlannedPOAmt, Publicprivate, InvoicedAmt, IsCommitCeiling, Expexpenses, C_Campaign_ID, PlannedAmt, Expreinvoicing, IsCommitment, Reopenproject, Invoice_ToProject, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_DATE(?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefinish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, responsibleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changeprojectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastplannedproposaldate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectbalanceamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectkind);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servrevenue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentCopies);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectphase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdoneyet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setprojecttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyofproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createtemppricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedpoamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, publicprivate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expexpenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expreinvoicing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reopenproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceToproject);
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
      "        DELETE FROM zssm_productionorder_v" +
      "        WHERE zssm_productionorder_v.Zssm_Productionorder_V_ID = ? " +
      "        AND zssm_productionorder_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_productionorder_v.AD_Org_ID IN (";
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
      "        DELETE FROM zssm_productionorder_v" +
      "        WHERE zssm_productionorder_v.Zssm_Productionorder_V_ID = ? ";

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
      "          FROM zssm_productionorder_v" +
      "         WHERE zssm_productionorder_v.Zssm_Productionorder_V_ID = ? ";

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
      "          FROM zssm_productionorder_v" +
      "         WHERE zssm_productionorder_v.Zssm_Productionorder_V_ID = ? ";

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
