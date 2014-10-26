//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ImportBudget;

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
class ImportBudgetData implements FieldProvider {
static Logger log4j = Logger.getLogger(ImportBudgetData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String iBudgetlineId;
  public String iIsimported;
  public String cBudgetlineId;
  public String cBudgetlineIdr;
  public String iErrormsg;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String cBudgetId;
  public String cBudgetIdr;
  public String seqno;
  public String price;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String currencyident;
  public String qty;
  public String amount;
  public String cPeriodId;
  public String cPeriodIdr;
  public String periodident;
  public String cElementvalueId;
  public String cElementvalueIdr;
  public String elementvalueident;
  public String cAcctschemaId;
  public String cAcctschemaIdr;
  public String acctschemaident;
  public String mProductId;
  public String mProductIdr;
  public String productident;
  public String cUomId;
  public String cUomIdr;
  public String mProductCategoryId;
  public String mProductCategoryIdr;
  public String prodcategoryident;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String partnerident;
  public String cBpGroupId;
  public String cBpGroupIdr;
  public String bpgroupident;
  public String adOrgtrxId;
  public String adOrgtrxIdr;
  public String orgtrxident;
  public String cActivityId;
  public String cActivityIdr;
  public String activityident;
  public String cCampaignId;
  public String cCampaignIdr;
  public String campaignident;
  public String cProjectId;
  public String cProjectIdr;
  public String projectident;
  public String cSalesregionId;
  public String cSalesregionIdr;
  public String salesregionident;
  public String description;
  public String processing;
  public String processed;
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
    else if (fieldName.equalsIgnoreCase("i_budgetline_id") || fieldName.equals("iBudgetlineId"))
      return iBudgetlineId;
    else if (fieldName.equalsIgnoreCase("i_isimported") || fieldName.equals("iIsimported"))
      return iIsimported;
    else if (fieldName.equalsIgnoreCase("c_budgetline_id") || fieldName.equals("cBudgetlineId"))
      return cBudgetlineId;
    else if (fieldName.equalsIgnoreCase("c_budgetline_idr") || fieldName.equals("cBudgetlineIdr"))
      return cBudgetlineIdr;
    else if (fieldName.equalsIgnoreCase("i_errormsg") || fieldName.equals("iErrormsg"))
      return iErrormsg;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_budget_id") || fieldName.equals("cBudgetId"))
      return cBudgetId;
    else if (fieldName.equalsIgnoreCase("c_budget_idr") || fieldName.equals("cBudgetIdr"))
      return cBudgetIdr;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("price"))
      return price;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("currencyident"))
      return currencyident;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("c_period_id") || fieldName.equals("cPeriodId"))
      return cPeriodId;
    else if (fieldName.equalsIgnoreCase("c_period_idr") || fieldName.equals("cPeriodIdr"))
      return cPeriodIdr;
    else if (fieldName.equalsIgnoreCase("periodident"))
      return periodident;
    else if (fieldName.equalsIgnoreCase("c_elementvalue_id") || fieldName.equals("cElementvalueId"))
      return cElementvalueId;
    else if (fieldName.equalsIgnoreCase("c_elementvalue_idr") || fieldName.equals("cElementvalueIdr"))
      return cElementvalueIdr;
    else if (fieldName.equalsIgnoreCase("elementvalueident"))
      return elementvalueident;
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_idr") || fieldName.equals("cAcctschemaIdr"))
      return cAcctschemaIdr;
    else if (fieldName.equalsIgnoreCase("acctschemaident"))
      return acctschemaident;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("productident"))
      return productident;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("m_product_category_idr") || fieldName.equals("mProductCategoryIdr"))
      return mProductCategoryIdr;
    else if (fieldName.equalsIgnoreCase("prodcategoryident"))
      return prodcategoryident;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("partnerident"))
      return partnerident;
    else if (fieldName.equalsIgnoreCase("c_bp_group_id") || fieldName.equals("cBpGroupId"))
      return cBpGroupId;
    else if (fieldName.equalsIgnoreCase("c_bp_group_idr") || fieldName.equals("cBpGroupIdr"))
      return cBpGroupIdr;
    else if (fieldName.equalsIgnoreCase("bpgroupident"))
      return bpgroupident;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_idr") || fieldName.equals("adOrgtrxIdr"))
      return adOrgtrxIdr;
    else if (fieldName.equalsIgnoreCase("orgtrxident"))
      return orgtrxident;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("c_activity_idr") || fieldName.equals("cActivityIdr"))
      return cActivityIdr;
    else if (fieldName.equalsIgnoreCase("activityident"))
      return activityident;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_campaign_idr") || fieldName.equals("cCampaignIdr"))
      return cCampaignIdr;
    else if (fieldName.equalsIgnoreCase("campaignident"))
      return campaignident;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("projectident"))
      return projectident;
    else if (fieldName.equalsIgnoreCase("c_salesregion_id") || fieldName.equals("cSalesregionId"))
      return cSalesregionId;
    else if (fieldName.equalsIgnoreCase("c_salesregion_idr") || fieldName.equals("cSalesregionIdr"))
      return cSalesregionIdr;
    else if (fieldName.equalsIgnoreCase("salesregionident"))
      return salesregionident;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
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
  public static ImportBudgetData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ImportBudgetData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(I_Budgetline.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = I_Budgetline.CreatedBy) as CreatedByR, " +
      "        to_char(I_Budgetline.Updated, ?) as updated, " +
      "        to_char(I_Budgetline.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        I_Budgetline.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = I_Budgetline.UpdatedBy) as UpdatedByR," +
      "        I_Budgetline.I_Budgetline_ID, " +
      "COALESCE(I_Budgetline.I_IsImported, 'N') AS I_IsImported, " +
      "I_Budgetline.C_Budgetline_ID, " +
      "(CASE WHEN I_Budgetline.C_Budgetline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.SeqNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Budgetline_IDR, " +
      "I_Budgetline.I_ErrorMsg, " +
      "I_Budgetline.AD_Client_ID, " +
      "(CASE WHEN I_Budgetline.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "I_Budgetline.AD_Org_ID, " +
      "(CASE WHEN I_Budgetline.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(I_Budgetline.IsActive, 'N') AS IsActive, " +
      "I_Budgetline.C_Budget_ID, " +
      "(CASE WHEN I_Budgetline.C_Budget_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_Budget_IDR, " +
      "I_Budgetline.SeqNo, " +
      "I_Budgetline.Price, " +
      "I_Budgetline.C_Currency_ID, " +
      "(CASE WHEN I_Budgetline.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "I_Budgetline.Currencyident, " +
      "I_Budgetline.Qty, " +
      "I_Budgetline.Amount, " +
      "I_Budgetline.C_Period_ID, " +
      "(CASE WHEN I_Budgetline.C_Period_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS C_Period_IDR, " +
      "I_Budgetline.Periodident, " +
      "I_Budgetline.C_Elementvalue_ID, " +
      "(CASE WHEN I_Budgetline.C_Elementvalue_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL9.Name IS NULL THEN TO_CHAR(table9.Name) ELSE TO_CHAR(tableTRL9.Name) END)), ''))),'') ) END) AS C_Elementvalue_IDR, " +
      "I_Budgetline.Elementvalueident, " +
      "I_Budgetline.C_Acctschema_ID, " +
      "(CASE WHEN I_Budgetline.C_Acctschema_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS C_Acctschema_IDR, " +
      "I_Budgetline.Acctschemaident, " +
      "I_Budgetline.M_Product_ID, " +
      "(CASE WHEN I_Budgetline.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL11.Name IS NULL THEN TO_CHAR(table11.Name) ELSE TO_CHAR(tableTRL11.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "I_Budgetline.Productident, " +
      "I_Budgetline.C_UOM_ID, " +
      "(CASE WHEN I_Budgetline.C_UOM_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL12.Name IS NULL THEN TO_CHAR(table12.Name) ELSE TO_CHAR(tableTRL12.Name) END)), ''))),'') ) END) AS C_UOM_IDR, " +
      "I_Budgetline.M_Product_Category_ID, " +
      "(CASE WHEN I_Budgetline.M_Product_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Name), ''))),'') ) END) AS M_Product_Category_IDR, " +
      "I_Budgetline.Prodcategoryident, " +
      "I_Budgetline.C_BPartner_ID, " +
      "(CASE WHEN I_Budgetline.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "I_Budgetline.Partnerident, " +
      "I_Budgetline.C_BP_Group_ID, " +
      "(CASE WHEN I_Budgetline.C_BP_Group_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'') ) END) AS C_BP_Group_IDR, " +
      "I_Budgetline.Bpgroupident, " +
      "I_Budgetline.AD_OrgTrx_ID, " +
      "(CASE WHEN I_Budgetline.AD_OrgTrx_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Name), ''))),'') ) END) AS AD_OrgTrx_IDR, " +
      "I_Budgetline.Orgtrxident, " +
      "I_Budgetline.C_Activity_ID, " +
      "(CASE WHEN I_Budgetline.C_Activity_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.Name), ''))),'') ) END) AS C_Activity_IDR, " +
      "I_Budgetline.Activityident, " +
      "I_Budgetline.C_Campaign_ID, " +
      "(CASE WHEN I_Budgetline.C_Campaign_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table18.Name), ''))),'') ) END) AS C_Campaign_IDR, " +
      "I_Budgetline.Campaignident, " +
      "I_Budgetline.C_Project_ID, " +
      "(CASE WHEN I_Budgetline.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "I_Budgetline.Projectident, " +
      "I_Budgetline.C_SalesRegion_ID, " +
      "(CASE WHEN I_Budgetline.C_SalesRegion_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table20.Name), ''))),'') ) END) AS C_SalesRegion_IDR, " +
      "I_Budgetline.Salesregionident, " +
      "I_Budgetline.Description, " +
      "I_Budgetline.Processing, " +
      "COALESCE(I_Budgetline.Processed, 'N') AS Processed, " +
      "        ? AS LANGUAGE " +
      "        FROM I_Budgetline left join (select C_Budgetline_ID, C_Period_ID, SeqNo, C_Budget_ID from C_Budgetline) table1 on (I_Budgetline.C_Budgetline_ID = table1.C_Budgetline_ID) left join (select C_Period_ID, Name from C_Period) table2 on (table1.C_Period_ID =  table2.C_Period_ID) left join (select C_Budget_ID, Name from C_Budget) table3 on (table1.C_Budget_ID = table3.C_Budget_ID) left join (select AD_Client_ID, Name from AD_Client) table4 on (I_Budgetline.AD_Client_ID = table4.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table5 on (I_Budgetline.AD_Org_ID = table5.AD_Org_ID) left join (select C_Budget_ID, Name from C_Budget) table6 on (I_Budgetline.C_Budget_ID = table6.C_Budget_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table7 on (I_Budgetline.C_Currency_ID = table7.C_Currency_ID) left join (select C_Period_ID, Name from C_Period) table8 on (I_Budgetline.C_Period_ID = table8.C_Period_ID) left join (select C_Elementvalue_ID, Value, Name from C_Elementvalue) table9 on (I_Budgetline.C_Elementvalue_ID = table9.C_Elementvalue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL9 on (table9.C_ElementValue_ID = tableTRL9.C_ElementValue_ID and tableTRL9.AD_Language = ?)  left join (select C_Acctschema_ID, Name from C_Acctschema) table10 on (I_Budgetline.C_Acctschema_ID = table10.C_Acctschema_ID) left join (select M_Product_ID, Value, Name from M_Product) table11 on (I_Budgetline.M_Product_ID = table11.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL11 on (table11.M_Product_ID = tableTRL11.M_Product_ID and tableTRL11.AD_Language = ?)  left join (select C_UOM_ID, Name from C_UOM) table12 on (I_Budgetline.C_UOM_ID = table12.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL12 on (table12.C_UOM_ID = tableTRL12.C_UOM_ID and tableTRL12.AD_Language = ?)  left join (select M_Product_Category_ID, Name from M_Product_Category) table13 on (I_Budgetline.M_Product_Category_ID = table13.M_Product_Category_ID) left join (select C_BPartner_ID, Name from C_BPartner) table14 on (I_Budgetline.C_BPartner_ID = table14.C_BPartner_ID) left join (select C_BP_Group_ID, Name from C_BP_Group) table15 on (I_Budgetline.C_BP_Group_ID = table15.C_BP_Group_ID) left join (select AD_Org_ID, value, Name from AD_Org) table16 on (I_Budgetline.AD_OrgTrx_ID =  table16.AD_Org_ID) left join (select C_Activity_ID, Name from C_Activity) table17 on (I_Budgetline.C_Activity_ID = table17.C_Activity_ID) left join (select C_Campaign_ID, Name from C_Campaign) table18 on (I_Budgetline.C_Campaign_ID = table18.C_Campaign_ID) left join (select C_Project_ID, Value, Name from C_Project) table19 on (I_Budgetline.C_Project_ID = table19.C_Project_ID) left join (select C_SalesRegion_ID, Name from C_SalesRegion) table20 on (I_Budgetline.C_SalesRegion_ID = table20.C_SalesRegion_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND I_Budgetline.I_Budgetline_ID = ? " +
      "        AND I_Budgetline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND I_Budgetline.AD_Org_ID IN (";
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
        ImportBudgetData objectImportBudgetData = new ImportBudgetData();
        objectImportBudgetData.created = UtilSql.getValue(result, "created");
        objectImportBudgetData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectImportBudgetData.updated = UtilSql.getValue(result, "updated");
        objectImportBudgetData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectImportBudgetData.updatedby = UtilSql.getValue(result, "updatedby");
        objectImportBudgetData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectImportBudgetData.iBudgetlineId = UtilSql.getValue(result, "i_budgetline_id");
        objectImportBudgetData.iIsimported = UtilSql.getValue(result, "i_isimported");
        objectImportBudgetData.cBudgetlineId = UtilSql.getValue(result, "c_budgetline_id");
        objectImportBudgetData.cBudgetlineIdr = UtilSql.getValue(result, "c_budgetline_idr");
        objectImportBudgetData.iErrormsg = UtilSql.getValue(result, "i_errormsg");
        objectImportBudgetData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectImportBudgetData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectImportBudgetData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectImportBudgetData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectImportBudgetData.isactive = UtilSql.getValue(result, "isactive");
        objectImportBudgetData.cBudgetId = UtilSql.getValue(result, "c_budget_id");
        objectImportBudgetData.cBudgetIdr = UtilSql.getValue(result, "c_budget_idr");
        objectImportBudgetData.seqno = UtilSql.getValue(result, "seqno");
        objectImportBudgetData.price = UtilSql.getValue(result, "price");
        objectImportBudgetData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectImportBudgetData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectImportBudgetData.currencyident = UtilSql.getValue(result, "currencyident");
        objectImportBudgetData.qty = UtilSql.getValue(result, "qty");
        objectImportBudgetData.amount = UtilSql.getValue(result, "amount");
        objectImportBudgetData.cPeriodId = UtilSql.getValue(result, "c_period_id");
        objectImportBudgetData.cPeriodIdr = UtilSql.getValue(result, "c_period_idr");
        objectImportBudgetData.periodident = UtilSql.getValue(result, "periodident");
        objectImportBudgetData.cElementvalueId = UtilSql.getValue(result, "c_elementvalue_id");
        objectImportBudgetData.cElementvalueIdr = UtilSql.getValue(result, "c_elementvalue_idr");
        objectImportBudgetData.elementvalueident = UtilSql.getValue(result, "elementvalueident");
        objectImportBudgetData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectImportBudgetData.cAcctschemaIdr = UtilSql.getValue(result, "c_acctschema_idr");
        objectImportBudgetData.acctschemaident = UtilSql.getValue(result, "acctschemaident");
        objectImportBudgetData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectImportBudgetData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectImportBudgetData.productident = UtilSql.getValue(result, "productident");
        objectImportBudgetData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectImportBudgetData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectImportBudgetData.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectImportBudgetData.mProductCategoryIdr = UtilSql.getValue(result, "m_product_category_idr");
        objectImportBudgetData.prodcategoryident = UtilSql.getValue(result, "prodcategoryident");
        objectImportBudgetData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectImportBudgetData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectImportBudgetData.partnerident = UtilSql.getValue(result, "partnerident");
        objectImportBudgetData.cBpGroupId = UtilSql.getValue(result, "c_bp_group_id");
        objectImportBudgetData.cBpGroupIdr = UtilSql.getValue(result, "c_bp_group_idr");
        objectImportBudgetData.bpgroupident = UtilSql.getValue(result, "bpgroupident");
        objectImportBudgetData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectImportBudgetData.adOrgtrxIdr = UtilSql.getValue(result, "ad_orgtrx_idr");
        objectImportBudgetData.orgtrxident = UtilSql.getValue(result, "orgtrxident");
        objectImportBudgetData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectImportBudgetData.cActivityIdr = UtilSql.getValue(result, "c_activity_idr");
        objectImportBudgetData.activityident = UtilSql.getValue(result, "activityident");
        objectImportBudgetData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectImportBudgetData.cCampaignIdr = UtilSql.getValue(result, "c_campaign_idr");
        objectImportBudgetData.campaignident = UtilSql.getValue(result, "campaignident");
        objectImportBudgetData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectImportBudgetData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectImportBudgetData.projectident = UtilSql.getValue(result, "projectident");
        objectImportBudgetData.cSalesregionId = UtilSql.getValue(result, "c_salesregion_id");
        objectImportBudgetData.cSalesregionIdr = UtilSql.getValue(result, "c_salesregion_idr");
        objectImportBudgetData.salesregionident = UtilSql.getValue(result, "salesregionident");
        objectImportBudgetData.description = UtilSql.getValue(result, "description");
        objectImportBudgetData.processing = UtilSql.getValue(result, "processing");
        objectImportBudgetData.processed = UtilSql.getValue(result, "processed");
        objectImportBudgetData.language = UtilSql.getValue(result, "language");
        objectImportBudgetData.adUserClient = "";
        objectImportBudgetData.adOrgClient = "";
        objectImportBudgetData.createdby = "";
        objectImportBudgetData.trBgcolor = "";
        objectImportBudgetData.totalCount = "";
        objectImportBudgetData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImportBudgetData);
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
    ImportBudgetData objectImportBudgetData[] = new ImportBudgetData[vector.size()];
    vector.copyInto(objectImportBudgetData);
    return(objectImportBudgetData);
  }

/**
Create a registry
 */
  public static ImportBudgetData[] set(String seqno, String amount, String projectident, String processed, String cProjectId, String cBpartnerId, String cBpartnerIdr, String description, String qty, String activityident, String cBudgetlineId, String cAcctschemaId, String prodcategoryident, String cPeriodId, String orgtrxident, String cElementvalueId, String cCampaignId, String elementvalueident, String mProductId, String mProductIdr, String price, String adOrgtrxId, String iErrormsg, String campaignident, String cActivityId, String adOrgId, String salesregionident, String updatedby, String updatedbyr, String cCurrencyId, String processing, String productident, String partnerident, String iIsimported, String periodident, String adClientId, String cBudgetId, String cUomId, String cSalesregionId, String createdby, String createdbyr, String isactive, String bpgroupident, String acctschemaident, String currencyident, String iBudgetlineId, String cBpGroupId, String mProductCategoryId)    throws ServletException {
    ImportBudgetData objectImportBudgetData[] = new ImportBudgetData[1];
    objectImportBudgetData[0] = new ImportBudgetData();
    objectImportBudgetData[0].created = "";
    objectImportBudgetData[0].createdbyr = createdbyr;
    objectImportBudgetData[0].updated = "";
    objectImportBudgetData[0].updatedTimeStamp = "";
    objectImportBudgetData[0].updatedby = updatedby;
    objectImportBudgetData[0].updatedbyr = updatedbyr;
    objectImportBudgetData[0].iBudgetlineId = iBudgetlineId;
    objectImportBudgetData[0].iIsimported = iIsimported;
    objectImportBudgetData[0].cBudgetlineId = cBudgetlineId;
    objectImportBudgetData[0].cBudgetlineIdr = "";
    objectImportBudgetData[0].iErrormsg = iErrormsg;
    objectImportBudgetData[0].adClientId = adClientId;
    objectImportBudgetData[0].adClientIdr = "";
    objectImportBudgetData[0].adOrgId = adOrgId;
    objectImportBudgetData[0].adOrgIdr = "";
    objectImportBudgetData[0].isactive = isactive;
    objectImportBudgetData[0].cBudgetId = cBudgetId;
    objectImportBudgetData[0].cBudgetIdr = "";
    objectImportBudgetData[0].seqno = seqno;
    objectImportBudgetData[0].price = price;
    objectImportBudgetData[0].cCurrencyId = cCurrencyId;
    objectImportBudgetData[0].cCurrencyIdr = "";
    objectImportBudgetData[0].currencyident = currencyident;
    objectImportBudgetData[0].qty = qty;
    objectImportBudgetData[0].amount = amount;
    objectImportBudgetData[0].cPeriodId = cPeriodId;
    objectImportBudgetData[0].cPeriodIdr = "";
    objectImportBudgetData[0].periodident = periodident;
    objectImportBudgetData[0].cElementvalueId = cElementvalueId;
    objectImportBudgetData[0].cElementvalueIdr = "";
    objectImportBudgetData[0].elementvalueident = elementvalueident;
    objectImportBudgetData[0].cAcctschemaId = cAcctschemaId;
    objectImportBudgetData[0].cAcctschemaIdr = "";
    objectImportBudgetData[0].acctschemaident = acctschemaident;
    objectImportBudgetData[0].mProductId = mProductId;
    objectImportBudgetData[0].mProductIdr = mProductIdr;
    objectImportBudgetData[0].productident = productident;
    objectImportBudgetData[0].cUomId = cUomId;
    objectImportBudgetData[0].cUomIdr = "";
    objectImportBudgetData[0].mProductCategoryId = mProductCategoryId;
    objectImportBudgetData[0].mProductCategoryIdr = "";
    objectImportBudgetData[0].prodcategoryident = prodcategoryident;
    objectImportBudgetData[0].cBpartnerId = cBpartnerId;
    objectImportBudgetData[0].cBpartnerIdr = cBpartnerIdr;
    objectImportBudgetData[0].partnerident = partnerident;
    objectImportBudgetData[0].cBpGroupId = cBpGroupId;
    objectImportBudgetData[0].cBpGroupIdr = "";
    objectImportBudgetData[0].bpgroupident = bpgroupident;
    objectImportBudgetData[0].adOrgtrxId = adOrgtrxId;
    objectImportBudgetData[0].adOrgtrxIdr = "";
    objectImportBudgetData[0].orgtrxident = orgtrxident;
    objectImportBudgetData[0].cActivityId = cActivityId;
    objectImportBudgetData[0].cActivityIdr = "";
    objectImportBudgetData[0].activityident = activityident;
    objectImportBudgetData[0].cCampaignId = cCampaignId;
    objectImportBudgetData[0].cCampaignIdr = "";
    objectImportBudgetData[0].campaignident = campaignident;
    objectImportBudgetData[0].cProjectId = cProjectId;
    objectImportBudgetData[0].cProjectIdr = "";
    objectImportBudgetData[0].projectident = projectident;
    objectImportBudgetData[0].cSalesregionId = cSalesregionId;
    objectImportBudgetData[0].cSalesregionIdr = "";
    objectImportBudgetData[0].salesregionident = salesregionident;
    objectImportBudgetData[0].description = description;
    objectImportBudgetData[0].processing = processing;
    objectImportBudgetData[0].processed = processed;
    objectImportBudgetData[0].language = "";
    return objectImportBudgetData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef802910(ConnectionProvider connectionProvider, String C_BUDGETLINE_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(SEQNO),0)+10 AS DefaultValue FROM I_BUDGETLINE WHERE C_BUDGETLINE_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BUDGETLINE_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDef802897_0(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
  public static String selectDef802895_1(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as M_Product_ID FROM M_Product table1 WHERE table1.isActive='Y' AND table1.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_id");
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
  public static String selectDef802887_2(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDef802885_3(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_Budgetline" +
      "        SET I_Budgetline_ID = (?) , I_IsImported = (?) , C_Budgetline_ID = (?) , I_ErrorMsg = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , IsActive = (?) , C_Budget_ID = (?) , SeqNo = TO_NUMBER(?) , Price = TO_NUMBER(?) , C_Currency_ID = (?) , Currencyident = (?) , Qty = TO_NUMBER(?) , Amount = TO_NUMBER(?) , C_Period_ID = (?) , Periodident = (?) , C_Elementvalue_ID = (?) , Elementvalueident = (?) , C_Acctschema_ID = (?) , Acctschemaident = (?) , M_Product_ID = (?) , Productident = (?) , C_UOM_ID = (?) , M_Product_Category_ID = (?) , Prodcategoryident = (?) , C_BPartner_ID = (?) , Partnerident = (?) , C_BP_Group_ID = (?) , Bpgroupident = (?) , AD_OrgTrx_ID = (?) , Orgtrxident = (?) , C_Activity_ID = (?) , Activityident = (?) , C_Campaign_ID = (?) , Campaignident = (?) , C_Project_ID = (?) , Projectident = (?) , C_SalesRegion_ID = (?) , Salesregionident = (?) , Description = (?) , Processing = (?) , Processed = (?) , updated = now(), updatedby = ? " +
      "        WHERE I_Budgetline.I_Budgetline_ID = ? " +
      "        AND I_Budgetline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND I_Budgetline.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iBudgetlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iIsimported);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBudgetlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iErrormsg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBudgetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, price);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, elementvalueident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschemaident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, prodcategoryident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, partnerident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpgroupident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgtrxident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, activityident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, campaignident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesregionident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iBudgetlineId);
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
      "        INSERT INTO I_Budgetline " +
      "        (I_Budgetline_ID, I_IsImported, C_Budgetline_ID, I_ErrorMsg, AD_Client_ID, AD_Org_ID, IsActive, C_Budget_ID, SeqNo, Price, C_Currency_ID, Currencyident, Qty, Amount, C_Period_ID, Periodident, C_Elementvalue_ID, Elementvalueident, C_Acctschema_ID, Acctschemaident, M_Product_ID, Productident, C_UOM_ID, M_Product_Category_ID, Prodcategoryident, C_BPartner_ID, Partnerident, C_BP_Group_ID, Bpgroupident, AD_OrgTrx_ID, Orgtrxident, C_Activity_ID, Activityident, C_Campaign_ID, Campaignident, C_Project_ID, Projectident, C_SalesRegion_ID, Salesregionident, Description, Processing, Processed, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iBudgetlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iIsimported);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBudgetlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iErrormsg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBudgetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, price);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, elementvalueident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschemaident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, prodcategoryident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, partnerident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpgroupident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgtrxident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, activityident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, campaignident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesregionident);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
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
      "        DELETE FROM I_Budgetline" +
      "        WHERE I_Budgetline.I_Budgetline_ID = ? " +
      "        AND I_Budgetline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND I_Budgetline.AD_Org_ID IN (";
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
      "        DELETE FROM I_Budgetline" +
      "        WHERE I_Budgetline.I_Budgetline_ID = ? ";

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
      "          FROM I_Budgetline" +
      "         WHERE I_Budgetline.I_Budgetline_ID = ? ";

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
      "          FROM I_Budgetline" +
      "         WHERE I_Budgetline.I_Budgetline_ID = ? ";

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
