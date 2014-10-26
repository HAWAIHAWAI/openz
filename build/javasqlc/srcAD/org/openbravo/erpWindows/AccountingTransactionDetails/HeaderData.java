//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.AccountingTransactionDetails;

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
class HeaderData implements FieldProvider {
static Logger log4j = Logger.getLogger(HeaderData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String isactive;
  public String aAssetId;
  public String lineId;
  public String factAcctId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cAcctschemaId;
  public String cAcctschemaIdr;
  public String adTableId;
  public String adTableIdr;
  public String recordId;
  public String description;
  public String cPeriodId;
  public String cPeriodIdr;
  public String dateacct;
  public String datetrx;
  public String accountId;
  public String accountIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String mProductId;
  public String mProductIdr;
  public String cProjectId;
  public String cProjectIdr;
  public String cSalesregionId;
  public String cSalesregionIdr;
  public String cCampaignId;
  public String cCampaignIdr;
  public String cLocfromId;
  public String cLocfromIdr;
  public String cLoctoId;
  public String cLoctoIdr;
  public String cActivityId;
  public String cActivityIdr;
  public String glCategoryId;
  public String glCategoryIdr;
  public String cTaxId;
  public String cTaxIdr;
  public String mLocatorId;
  public String mLocatorIdr;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String amtacctdr;
  public String amtacctcr;
  public String cUomId;
  public String cUomIdr;
  public String qty;
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
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("line_id") || fieldName.equals("lineId"))
      return lineId;
    else if (fieldName.equalsIgnoreCase("fact_acct_id") || fieldName.equals("factAcctId"))
      return factAcctId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_idr") || fieldName.equals("cAcctschemaIdr"))
      return cAcctschemaIdr;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("ad_table_idr") || fieldName.equals("adTableIdr"))
      return adTableIdr;
    else if (fieldName.equalsIgnoreCase("record_id") || fieldName.equals("recordId"))
      return recordId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_period_id") || fieldName.equals("cPeriodId"))
      return cPeriodId;
    else if (fieldName.equalsIgnoreCase("c_period_idr") || fieldName.equals("cPeriodIdr"))
      return cPeriodIdr;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("datetrx"))
      return datetrx;
    else if (fieldName.equalsIgnoreCase("account_id") || fieldName.equals("accountId"))
      return accountId;
    else if (fieldName.equalsIgnoreCase("account_idr") || fieldName.equals("accountIdr"))
      return accountIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_salesregion_id") || fieldName.equals("cSalesregionId"))
      return cSalesregionId;
    else if (fieldName.equalsIgnoreCase("c_salesregion_idr") || fieldName.equals("cSalesregionIdr"))
      return cSalesregionIdr;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_campaign_idr") || fieldName.equals("cCampaignIdr"))
      return cCampaignIdr;
    else if (fieldName.equalsIgnoreCase("c_locfrom_id") || fieldName.equals("cLocfromId"))
      return cLocfromId;
    else if (fieldName.equalsIgnoreCase("c_locfrom_idr") || fieldName.equals("cLocfromIdr"))
      return cLocfromIdr;
    else if (fieldName.equalsIgnoreCase("c_locto_id") || fieldName.equals("cLoctoId"))
      return cLoctoId;
    else if (fieldName.equalsIgnoreCase("c_locto_idr") || fieldName.equals("cLoctoIdr"))
      return cLoctoIdr;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("c_activity_idr") || fieldName.equals("cActivityIdr"))
      return cActivityIdr;
    else if (fieldName.equalsIgnoreCase("gl_category_id") || fieldName.equals("glCategoryId"))
      return glCategoryId;
    else if (fieldName.equalsIgnoreCase("gl_category_idr") || fieldName.equals("glCategoryIdr"))
      return glCategoryIdr;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("c_tax_idr") || fieldName.equals("cTaxIdr"))
      return cTaxIdr;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_locator_idr") || fieldName.equals("mLocatorIdr"))
      return mLocatorIdr;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("amtacctdr"))
      return amtacctdr;
    else if (fieldName.equalsIgnoreCase("amtacctcr"))
      return amtacctcr;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
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
  public static HeaderData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static HeaderData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(Fact_Acct.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = Fact_Acct.CreatedBy) as CreatedByR, " +
      "        to_char(Fact_Acct.Updated, ?) as updated, " +
      "        to_char(Fact_Acct.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        Fact_Acct.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = Fact_Acct.UpdatedBy) as UpdatedByR," +
      "        COALESCE(Fact_Acct.IsActive, 'N') AS IsActive, " +
      "Fact_Acct.A_Asset_ID, " +
      "Fact_Acct.Line_ID, " +
      "Fact_Acct.Fact_Acct_ID, " +
      "Fact_Acct.AD_Client_ID, " +
      "(CASE WHEN Fact_Acct.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "Fact_Acct.AD_Org_ID, " +
      "(CASE WHEN Fact_Acct.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "Fact_Acct.C_AcctSchema_ID, " +
      "(CASE WHEN Fact_Acct.C_AcctSchema_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_AcctSchema_IDR, " +
      "Fact_Acct.AD_Table_ID, " +
      "(CASE WHEN Fact_Acct.AD_Table_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.TableName), ''))),'') ) END) AS AD_Table_IDR, " +
      "Fact_Acct.Record_ID, " +
      "Fact_Acct.Description, " +
      "Fact_Acct.C_Period_ID, " +
      "(CASE WHEN Fact_Acct.C_Period_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Period_IDR, " +
      "Fact_Acct.DateAcct, " +
      "Fact_Acct.DateTrx, " +
      "Fact_Acct.Account_ID, " +
      "(CASE WHEN Fact_Acct.Account_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS Account_IDR, " +
      "Fact_Acct.C_BPartner_ID, " +
      "(CASE WHEN Fact_Acct.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "Fact_Acct.M_Product_ID, " +
      "(CASE WHEN Fact_Acct.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL8.Name IS NULL THEN TO_CHAR(table8.Name) ELSE TO_CHAR(tableTRL8.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "Fact_Acct.C_Project_ID, " +
      "(CASE WHEN Fact_Acct.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "Fact_Acct.C_SalesRegion_ID, " +
      "(CASE WHEN Fact_Acct.C_SalesRegion_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS C_SalesRegion_IDR, " +
      "Fact_Acct.C_Campaign_ID, " +
      "(CASE WHEN Fact_Acct.C_Campaign_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS C_Campaign_IDR, " +
      "Fact_Acct.C_LocFrom_ID, " +
      "(CASE WHEN Fact_Acct.C_LocFrom_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.City), ''))),'') ) END) AS C_LocFrom_IDR, " +
      "Fact_Acct.C_LocTo_ID, " +
      "(CASE WHEN Fact_Acct.C_LocTo_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.City), ''))),'') ) END) AS C_LocTo_IDR, " +
      "Fact_Acct.C_Activity_ID, " +
      "(CASE WHEN Fact_Acct.C_Activity_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Name), ''))),'') ) END) AS C_Activity_IDR, " +
      "Fact_Acct.GL_Category_ID, " +
      "(CASE WHEN Fact_Acct.GL_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'') ) END) AS GL_Category_IDR, " +
      "Fact_Acct.C_Tax_ID, " +
      "(CASE WHEN Fact_Acct.C_Tax_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL16.Name IS NULL THEN TO_CHAR(table16.Name) ELSE TO_CHAR(tableTRL16.Name) END)), ''))),'') ) END) AS C_Tax_IDR, " +
      "Fact_Acct.M_Locator_ID, " +
      "(CASE WHEN Fact_Acct.M_Locator_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.Value), ''))),'') ) END) AS M_Locator_IDR, " +
      "Fact_Acct.C_Currency_ID, " +
      "(CASE WHEN Fact_Acct.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table18.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "Fact_Acct.AmtAcctDr, " +
      "Fact_Acct.AmtAcctCr, " +
      "Fact_Acct.C_UOM_ID, " +
      "(CASE WHEN Fact_Acct.C_UOM_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL19.Name IS NULL THEN TO_CHAR(table19.Name) ELSE TO_CHAR(tableTRL19.Name) END)), ''))),'') ) END) AS C_UOM_IDR, " +
      "Fact_Acct.Qty, " +
      "        ? AS LANGUAGE " +
      "        FROM Fact_Acct left join (select AD_Client_ID, Name from AD_Client) table1 on (Fact_Acct.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (Fact_Acct.AD_Org_ID = table2.AD_Org_ID) left join (select C_AcctSchema_ID, Name from C_AcctSchema) table3 on (Fact_Acct.C_AcctSchema_ID = table3.C_AcctSchema_ID) left join (select AD_Table_ID, TableName from AD_Table) table4 on (Fact_Acct.AD_Table_ID = table4.AD_Table_ID) left join (select C_Period_ID, Name from C_Period) table5 on (Fact_Acct.C_Period_ID = table5.C_Period_ID) left join (select C_ElementValue_ID, value, Name from C_ElementValue) table6 on (Fact_Acct.Account_ID =  table6.C_ElementValue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL6 on (table6.C_ElementValue_ID = tableTRL6.C_ElementValue_ID and tableTRL6.AD_Language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table7 on (Fact_Acct.C_BPartner_ID = table7.C_BPartner_ID) left join (select M_Product_ID, Value, Name from M_Product) table8 on (Fact_Acct.M_Product_ID = table8.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL8 on (table8.M_Product_ID = tableTRL8.M_Product_ID and tableTRL8.AD_Language = ?)  left join (select C_Project_ID, Value, Name from C_Project) table9 on (Fact_Acct.C_Project_ID = table9.C_Project_ID) left join (select C_SalesRegion_ID, Name from C_SalesRegion) table10 on (Fact_Acct.C_SalesRegion_ID = table10.C_SalesRegion_ID) left join (select C_Campaign_ID, Name from C_Campaign) table11 on (Fact_Acct.C_Campaign_ID = table11.C_Campaign_ID) left join (select C_Location_ID, City from C_Location) table12 on (Fact_Acct.C_LocFrom_ID =  table12.C_Location_ID) left join (select C_Location_ID, City from C_Location) table13 on (Fact_Acct.C_LocTo_ID =  table13.C_Location_ID) left join (select C_Activity_ID, Name from C_Activity) table14 on (Fact_Acct.C_Activity_ID = table14.C_Activity_ID) left join (select GL_Category_ID, Name from GL_Category) table15 on (Fact_Acct.GL_Category_ID = table15.GL_Category_ID) left join (select C_Tax_ID, Name from C_Tax) table16 on (Fact_Acct.C_Tax_ID = table16.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL16 on (table16.C_Tax_ID = tableTRL16.C_Tax_ID and tableTRL16.AD_Language = ?)  left join (select M_Locator_ID, Value from M_Locator) table17 on (Fact_Acct.M_Locator_ID = table17.M_Locator_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table18 on (Fact_Acct.C_Currency_ID = table18.C_Currency_ID) left join (select C_UOM_ID, Name from C_UOM) table19 on (Fact_Acct.C_UOM_ID = table19.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL19 on (table19.C_UOM_ID = tableTRL19.C_UOM_ID and tableTRL19.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND Fact_Acct.Fact_Acct_ID = ? " +
      "        AND Fact_Acct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND Fact_Acct.AD_Org_ID IN (";
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
        HeaderData objectHeaderData = new HeaderData();
        objectHeaderData.created = UtilSql.getValue(result, "created");
        objectHeaderData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectHeaderData.updated = UtilSql.getValue(result, "updated");
        objectHeaderData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectHeaderData.updatedby = UtilSql.getValue(result, "updatedby");
        objectHeaderData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectHeaderData.isactive = UtilSql.getValue(result, "isactive");
        objectHeaderData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectHeaderData.lineId = UtilSql.getValue(result, "line_id");
        objectHeaderData.factAcctId = UtilSql.getValue(result, "fact_acct_id");
        objectHeaderData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectHeaderData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectHeaderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectHeaderData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectHeaderData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectHeaderData.cAcctschemaIdr = UtilSql.getValue(result, "c_acctschema_idr");
        objectHeaderData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectHeaderData.adTableIdr = UtilSql.getValue(result, "ad_table_idr");
        objectHeaderData.recordId = UtilSql.getValue(result, "record_id");
        objectHeaderData.description = UtilSql.getValue(result, "description");
        objectHeaderData.cPeriodId = UtilSql.getValue(result, "c_period_id");
        objectHeaderData.cPeriodIdr = UtilSql.getValue(result, "c_period_idr");
        objectHeaderData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectHeaderData.datetrx = UtilSql.getDateValue(result, "datetrx", "dd-MM-yyyy");
        objectHeaderData.accountId = UtilSql.getValue(result, "account_id");
        objectHeaderData.accountIdr = UtilSql.getValue(result, "account_idr");
        objectHeaderData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectHeaderData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectHeaderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectHeaderData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectHeaderData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectHeaderData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectHeaderData.cSalesregionId = UtilSql.getValue(result, "c_salesregion_id");
        objectHeaderData.cSalesregionIdr = UtilSql.getValue(result, "c_salesregion_idr");
        objectHeaderData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectHeaderData.cCampaignIdr = UtilSql.getValue(result, "c_campaign_idr");
        objectHeaderData.cLocfromId = UtilSql.getValue(result, "c_locfrom_id");
        objectHeaderData.cLocfromIdr = UtilSql.getValue(result, "c_locfrom_idr");
        objectHeaderData.cLoctoId = UtilSql.getValue(result, "c_locto_id");
        objectHeaderData.cLoctoIdr = UtilSql.getValue(result, "c_locto_idr");
        objectHeaderData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectHeaderData.cActivityIdr = UtilSql.getValue(result, "c_activity_idr");
        objectHeaderData.glCategoryId = UtilSql.getValue(result, "gl_category_id");
        objectHeaderData.glCategoryIdr = UtilSql.getValue(result, "gl_category_idr");
        objectHeaderData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectHeaderData.cTaxIdr = UtilSql.getValue(result, "c_tax_idr");
        objectHeaderData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectHeaderData.mLocatorIdr = UtilSql.getValue(result, "m_locator_idr");
        objectHeaderData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectHeaderData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectHeaderData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectHeaderData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectHeaderData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectHeaderData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectHeaderData.qty = UtilSql.getValue(result, "qty");
        objectHeaderData.language = UtilSql.getValue(result, "language");
        objectHeaderData.adUserClient = "";
        objectHeaderData.adOrgClient = "";
        objectHeaderData.createdby = "";
        objectHeaderData.trBgcolor = "";
        objectHeaderData.totalCount = "";
        objectHeaderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectHeaderData);
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
    HeaderData objectHeaderData[] = new HeaderData[vector.size()];
    vector.copyInto(objectHeaderData);
    return(objectHeaderData);
  }

/**
Select for relation
 */
  public static HeaderData[] select(ConnectionProvider connectionProvider, String paramLanguage, String parDescription, String parAD_Table_ID, String parDateAcct, String parAccount_ID, String parC_BPartner_ID, String parM_Product_ID, String parAmtAcctDr, String parAmtAcctCr, String parDateAcct_f, String parAmtAcctDr_f, String parAmtAcctCr_f, String parSessionDate, String parSessionUser, String adUserClient, String adOrgClient, String orderbyclause)    throws ServletException {
    return select(connectionProvider, paramLanguage, parDescription, parAD_Table_ID, parDateAcct, parAccount_ID, parC_BPartner_ID, parM_Product_ID, parAmtAcctDr, parAmtAcctCr, parDateAcct_f, parAmtAcctDr_f, parAmtAcctCr_f, parSessionDate, parSessionUser, adUserClient, adOrgClient, orderbyclause, 0, 0);
  }

/**
Select for relation
 */
  public static HeaderData[] select(ConnectionProvider connectionProvider, String paramLanguage, String parDescription, String parAD_Table_ID, String parDateAcct, String parAccount_ID, String parC_BPartner_ID, String parM_Product_ID, String parAmtAcctDr, String parAmtAcctCr, String parDateAcct_f, String parAmtAcctDr_f, String parAmtAcctCr_f, String parSessionDate, String parSessionUser, String adUserClient, String adOrgClient, String orderbyclause, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(Fact_Acct.IsActive, 'N') AS IsActive, " +
      "Fact_Acct.A_Asset_ID, " +
      "Fact_Acct.Line_ID, " +
      "Fact_Acct.Fact_Acct_ID, " +
      "Fact_Acct.AD_Client_ID, " +
      "(CASE WHEN Fact_Acct.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "Fact_Acct.AD_Org_ID, " +
      "(CASE WHEN Fact_Acct.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "Fact_Acct.C_AcctSchema_ID, " +
      "(CASE WHEN Fact_Acct.C_AcctSchema_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_AcctSchema_IDR, " +
      "Fact_Acct.AD_Table_ID, " +
      "(CASE WHEN Fact_Acct.AD_Table_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.TableName), ''))),'') ) END) AS AD_Table_IDR, " +
      "Fact_Acct.Record_ID, " +
      "Fact_Acct.Description, " +
      "Fact_Acct.C_Period_ID, " +
      "(CASE WHEN Fact_Acct.C_Period_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Period_IDR, " +
      "Fact_Acct.DateAcct, " +
      "Fact_Acct.DateTrx, " +
      "Fact_Acct.Account_ID, " +
      "(CASE WHEN Fact_Acct.Account_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS Account_IDR, " +
      "Fact_Acct.C_BPartner_ID, " +
      "(CASE WHEN Fact_Acct.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "Fact_Acct.M_Product_ID, " +
      "(CASE WHEN Fact_Acct.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL8.Name IS NULL THEN TO_CHAR(table8.Name) ELSE TO_CHAR(tableTRL8.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "Fact_Acct.C_Project_ID, " +
      "(CASE WHEN Fact_Acct.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "Fact_Acct.C_SalesRegion_ID, " +
      "(CASE WHEN Fact_Acct.C_SalesRegion_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS C_SalesRegion_IDR, " +
      "Fact_Acct.C_Campaign_ID, " +
      "(CASE WHEN Fact_Acct.C_Campaign_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS C_Campaign_IDR, " +
      "Fact_Acct.C_LocFrom_ID, " +
      "(CASE WHEN Fact_Acct.C_LocFrom_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.City), ''))),'') ) END) AS C_LocFrom_IDR, " +
      "Fact_Acct.C_LocTo_ID, " +
      "(CASE WHEN Fact_Acct.C_LocTo_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.City), ''))),'') ) END) AS C_LocTo_IDR, " +
      "Fact_Acct.C_Activity_ID, " +
      "(CASE WHEN Fact_Acct.C_Activity_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Name), ''))),'') ) END) AS C_Activity_IDR, " +
      "Fact_Acct.GL_Category_ID, " +
      "(CASE WHEN Fact_Acct.GL_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'') ) END) AS GL_Category_IDR, " +
      "Fact_Acct.C_Tax_ID, " +
      "(CASE WHEN Fact_Acct.C_Tax_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL16.Name IS NULL THEN TO_CHAR(table16.Name) ELSE TO_CHAR(tableTRL16.Name) END)), ''))),'') ) END) AS C_Tax_IDR, " +
      "Fact_Acct.M_Locator_ID, " +
      "(CASE WHEN Fact_Acct.M_Locator_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.Value), ''))),'') ) END) AS M_Locator_IDR, " +
      "Fact_Acct.C_Currency_ID, " +
      "(CASE WHEN Fact_Acct.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table18.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "Fact_Acct.AmtAcctDr, " +
      "Fact_Acct.AmtAcctCr, " +
      "Fact_Acct.C_UOM_ID, " +
      "(CASE WHEN Fact_Acct.C_UOM_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL19.Name IS NULL THEN TO_CHAR(table19.Name) ELSE TO_CHAR(tableTRL19.Name) END)), ''))),'') ) END) AS C_UOM_IDR, " +
      "Fact_Acct.Qty, " +
      "        '' AS TR_BGCOLOR, '' as total_count," +
      "        Fact_Acct.Created, " +
      "        Fact_Acct.CreatedBy, " +
      "        Fact_Acct.CreatedBy AS CreatedByR," +
      "        Fact_Acct.Updated, " +
      "        Fact_Acct.UpdatedBy," +
      "        Fact_Acct.UpdatedBy AS UpdatedByR," +
      "        ? AS LANGUAGE, '' AS AD_USER_CLIENT, '' AS AD_ORG_CLIENT" +
      "        FROM Fact_Acct left join (select AD_Client_ID, Name from AD_Client) table1 on (Fact_Acct.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (Fact_Acct.AD_Org_ID = table2.AD_Org_ID) left join (select C_AcctSchema_ID, Name from C_AcctSchema) table3 on (Fact_Acct.C_AcctSchema_ID = table3.C_AcctSchema_ID) left join (select AD_Table_ID, TableName from AD_Table) table4 on (Fact_Acct.AD_Table_ID = table4.AD_Table_ID) left join (select C_Period_ID, Name from C_Period) table5 on (Fact_Acct.C_Period_ID = table5.C_Period_ID) left join (select C_ElementValue_ID, value, Name from C_ElementValue) table6 on (Fact_Acct.Account_ID =  table6.C_ElementValue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL6 on (table6.C_ElementValue_ID = tableTRL6.C_ElementValue_ID and tableTRL6.AD_Language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table7 on (Fact_Acct.C_BPartner_ID = table7.C_BPartner_ID) left join (select M_Product_ID, Value, Name from M_Product) table8 on (Fact_Acct.M_Product_ID = table8.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL8 on (table8.M_Product_ID = tableTRL8.M_Product_ID and tableTRL8.AD_Language = ?)  left join (select C_Project_ID, Value, Name from C_Project) table9 on (Fact_Acct.C_Project_ID = table9.C_Project_ID) left join (select C_SalesRegion_ID, Name from C_SalesRegion) table10 on (Fact_Acct.C_SalesRegion_ID = table10.C_SalesRegion_ID) left join (select C_Campaign_ID, Name from C_Campaign) table11 on (Fact_Acct.C_Campaign_ID = table11.C_Campaign_ID) left join (select C_Location_ID, City from C_Location) table12 on (Fact_Acct.C_LocFrom_ID =  table12.C_Location_ID) left join (select C_Location_ID, City from C_Location) table13 on (Fact_Acct.C_LocTo_ID =  table13.C_Location_ID) left join (select C_Activity_ID, Name from C_Activity) table14 on (Fact_Acct.C_Activity_ID = table14.C_Activity_ID) left join (select GL_Category_ID, Name from GL_Category) table15 on (Fact_Acct.GL_Category_ID = table15.GL_Category_ID) left join (select C_Tax_ID, Name from C_Tax) table16 on (Fact_Acct.C_Tax_ID = table16.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL16 on (table16.C_Tax_ID = tableTRL16.C_Tax_ID and tableTRL16.AD_Language = ?)  left join (select M_Locator_ID, Value from M_Locator) table17 on (Fact_Acct.M_Locator_ID = table17.M_Locator_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table18 on (Fact_Acct.C_Currency_ID = table18.C_Currency_ID) left join (select C_UOM_ID, Name from C_UOM) table19 on (Fact_Acct.C_UOM_ID = table19.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL19 on (table19.C_UOM_ID = tableTRL19.C_UOM_ID and tableTRL19.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((parDescription==null || parDescription.equals(""))?"":"  AND C_IGNORE_ACCENT(Fact_Acct.Description) LIKE C_IGNORE_ACCENT(?) ");
    strSql = strSql + ((parAD_Table_ID==null || parAD_Table_ID.equals(""))?"":"  AND (Fact_Acct.AD_Table_ID) = (?) ");
    strSql = strSql + ((parDateAcct==null || parDateAcct.equals(""))?"":"  AND Fact_Acct.DateAcct >= TO_TIMESTAMP(?)  ");
    strSql = strSql + ((parAccount_ID==null || parAccount_ID.equals(""))?"":"  AND (Fact_Acct.Account_ID) = (?) ");
    strSql = strSql + ((parC_BPartner_ID==null || parC_BPartner_ID.equals(""))?"":"  AND (Fact_Acct.C_BPartner_ID) = (?) ");
    strSql = strSql + ((parM_Product_ID==null || parM_Product_ID.equals(""))?"":"  AND (Fact_Acct.M_Product_ID) = (?) ");
    strSql = strSql + ((parAmtAcctDr==null || parAmtAcctDr.equals(""))?"":"  AND Fact_Acct.AmtAcctDr >= (?)  ");
    strSql = strSql + ((parAmtAcctCr==null || parAmtAcctCr.equals(""))?"":"  AND Fact_Acct.AmtAcctCr >= (?)  ");
    strSql = strSql + ((parDateAcct_f==null || parDateAcct_f.equals(""))?"":"  AND Fact_Acct.DateAcct < TO_TIMESTAMP(?) + 1  ");
    strSql = strSql + ((parAmtAcctDr_f==null || parAmtAcctDr_f.equals(""))?"":"  AND Fact_Acct.AmtAcctDr < TO_NUMBER(?) + 1  ");
    strSql = strSql + ((parAmtAcctCr_f==null || parAmtAcctCr_f.equals(""))?"":"  AND Fact_Acct.AmtAcctCr < TO_NUMBER(?) + 1  ");
    strSql = strSql + ((parSessionDate.equals("parSessionDate"))?"  AND 1 = 1 ":"");
    strSql = strSql + ((parSessionUser.equals("parSessionUser"))?"  AND 1 = 1 ":"");
    strSql = strSql + 
      "        AND Fact_Acct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND Fact_Acct.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        ORDER BY ";
    strSql = strSql + ((orderbyclause==null || orderbyclause.equals(""))?"":orderbyclause);
    strSql = strSql + 
      ", 1";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (parDescription != null && !(parDescription.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDescription);
      }
      if (parAD_Table_ID != null && !(parAD_Table_ID.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parAD_Table_ID);
      }
      if (parDateAcct != null && !(parDateAcct.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateAcct);
      }
      if (parAccount_ID != null && !(parAccount_ID.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parAccount_ID);
      }
      if (parC_BPartner_ID != null && !(parC_BPartner_ID.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parC_BPartner_ID);
      }
      if (parM_Product_ID != null && !(parM_Product_ID.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parM_Product_ID);
      }
      if (parAmtAcctDr != null && !(parAmtAcctDr.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parAmtAcctDr);
      }
      if (parAmtAcctCr != null && !(parAmtAcctCr.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parAmtAcctCr);
      }
      if (parDateAcct_f != null && !(parDateAcct_f.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateAcct_f);
      }
      if (parAmtAcctDr_f != null && !(parAmtAcctDr_f.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parAmtAcctDr_f);
      }
      if (parAmtAcctCr_f != null && !(parAmtAcctCr_f.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parAmtAcctCr_f);
      }
      if (parSessionDate != null && !(parSessionDate.equals(""))) {
        }
      if (parSessionUser != null && !(parSessionUser.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (orderbyclause != null && !(orderbyclause.equals(""))) {
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
        HeaderData objectHeaderData = new HeaderData();
        objectHeaderData.isactive = UtilSql.getValue(result, "isactive");
        objectHeaderData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectHeaderData.lineId = UtilSql.getValue(result, "line_id");
        objectHeaderData.factAcctId = UtilSql.getValue(result, "fact_acct_id");
        objectHeaderData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectHeaderData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectHeaderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectHeaderData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectHeaderData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectHeaderData.cAcctschemaIdr = UtilSql.getValue(result, "c_acctschema_idr");
        objectHeaderData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectHeaderData.adTableIdr = UtilSql.getValue(result, "ad_table_idr");
        objectHeaderData.recordId = UtilSql.getValue(result, "record_id");
        objectHeaderData.description = UtilSql.getValue(result, "description");
        objectHeaderData.cPeriodId = UtilSql.getValue(result, "c_period_id");
        objectHeaderData.cPeriodIdr = UtilSql.getValue(result, "c_period_idr");
        objectHeaderData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectHeaderData.datetrx = UtilSql.getDateValue(result, "datetrx", "dd-MM-yyyy");
        objectHeaderData.accountId = UtilSql.getValue(result, "account_id");
        objectHeaderData.accountIdr = UtilSql.getValue(result, "account_idr");
        objectHeaderData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectHeaderData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectHeaderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectHeaderData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectHeaderData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectHeaderData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectHeaderData.cSalesregionId = UtilSql.getValue(result, "c_salesregion_id");
        objectHeaderData.cSalesregionIdr = UtilSql.getValue(result, "c_salesregion_idr");
        objectHeaderData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectHeaderData.cCampaignIdr = UtilSql.getValue(result, "c_campaign_idr");
        objectHeaderData.cLocfromId = UtilSql.getValue(result, "c_locfrom_id");
        objectHeaderData.cLocfromIdr = UtilSql.getValue(result, "c_locfrom_idr");
        objectHeaderData.cLoctoId = UtilSql.getValue(result, "c_locto_id");
        objectHeaderData.cLoctoIdr = UtilSql.getValue(result, "c_locto_idr");
        objectHeaderData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectHeaderData.cActivityIdr = UtilSql.getValue(result, "c_activity_idr");
        objectHeaderData.glCategoryId = UtilSql.getValue(result, "gl_category_id");
        objectHeaderData.glCategoryIdr = UtilSql.getValue(result, "gl_category_idr");
        objectHeaderData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectHeaderData.cTaxIdr = UtilSql.getValue(result, "c_tax_idr");
        objectHeaderData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectHeaderData.mLocatorIdr = UtilSql.getValue(result, "m_locator_idr");
        objectHeaderData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectHeaderData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectHeaderData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectHeaderData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectHeaderData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectHeaderData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectHeaderData.qty = UtilSql.getValue(result, "qty");
        objectHeaderData.trBgcolor = UtilSql.getValue(result, "tr_bgcolor");
        objectHeaderData.totalCount = UtilSql.getValue(result, "total_count");
        objectHeaderData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectHeaderData.createdby = UtilSql.getValue(result, "createdby");
        objectHeaderData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectHeaderData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectHeaderData.updatedby = UtilSql.getValue(result, "updatedby");
        objectHeaderData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectHeaderData.language = UtilSql.getValue(result, "language");
        objectHeaderData.adUserClient = UtilSql.getValue(result, "ad_user_client");
        objectHeaderData.adOrgClient = UtilSql.getValue(result, "ad_org_client");
        objectHeaderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectHeaderData);
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
    HeaderData objectHeaderData[] = new HeaderData[vector.size()];
    vector.copyInto(objectHeaderData);
    return(objectHeaderData);
  }

/**
Create a registry
 */
  public static HeaderData[] set(String lineId, String cSalesregionId, String datetrx, String cCampaignId, String accountId, String cTaxId, String cPeriodId, String dateacct, String cAcctschemaId, String glCategoryId, String isactive, String aAssetId, String amtacctcr, String adOrgId, String qty, String recordId, String mLocatorId, String cLoctoId, String adTableId, String updatedby, String updatedbyr, String cProjectId, String mProductId, String mProductIdr, String cBpartnerId, String cBpartnerIdr, String cLocfromId, String createdby, String createdbyr, String cActivityId, String adClientId, String description, String cUomId, String factAcctId, String amtacctdr, String cCurrencyId)    throws ServletException {
    HeaderData objectHeaderData[] = new HeaderData[1];
    objectHeaderData[0] = new HeaderData();
    objectHeaderData[0].isactive = isactive;
    objectHeaderData[0].aAssetId = aAssetId;
    objectHeaderData[0].lineId = lineId;
    objectHeaderData[0].factAcctId = factAcctId;
    objectHeaderData[0].adClientId = adClientId;
    objectHeaderData[0].adClientIdr = "";
    objectHeaderData[0].adOrgId = adOrgId;
    objectHeaderData[0].adOrgIdr = "";
    objectHeaderData[0].cAcctschemaId = cAcctschemaId;
    objectHeaderData[0].cAcctschemaIdr = "";
    objectHeaderData[0].adTableId = adTableId;
    objectHeaderData[0].adTableIdr = "";
    objectHeaderData[0].recordId = recordId;
    objectHeaderData[0].description = description;
    objectHeaderData[0].cPeriodId = cPeriodId;
    objectHeaderData[0].cPeriodIdr = "";
    objectHeaderData[0].dateacct = dateacct;
    objectHeaderData[0].datetrx = datetrx;
    objectHeaderData[0].accountId = accountId;
    objectHeaderData[0].accountIdr = "";
    objectHeaderData[0].cBpartnerId = cBpartnerId;
    objectHeaderData[0].cBpartnerIdr = cBpartnerIdr;
    objectHeaderData[0].mProductId = mProductId;
    objectHeaderData[0].mProductIdr = mProductIdr;
    objectHeaderData[0].cProjectId = cProjectId;
    objectHeaderData[0].cProjectIdr = "";
    objectHeaderData[0].cSalesregionId = cSalesregionId;
    objectHeaderData[0].cSalesregionIdr = "";
    objectHeaderData[0].cCampaignId = cCampaignId;
    objectHeaderData[0].cCampaignIdr = "";
    objectHeaderData[0].cLocfromId = cLocfromId;
    objectHeaderData[0].cLocfromIdr = "";
    objectHeaderData[0].cLoctoId = cLoctoId;
    objectHeaderData[0].cLoctoIdr = "";
    objectHeaderData[0].cActivityId = cActivityId;
    objectHeaderData[0].cActivityIdr = "";
    objectHeaderData[0].glCategoryId = glCategoryId;
    objectHeaderData[0].glCategoryIdr = "";
    objectHeaderData[0].cTaxId = cTaxId;
    objectHeaderData[0].cTaxIdr = "";
    objectHeaderData[0].mLocatorId = mLocatorId;
    objectHeaderData[0].mLocatorIdr = "";
    objectHeaderData[0].cCurrencyId = cCurrencyId;
    objectHeaderData[0].cCurrencyIdr = "";
    objectHeaderData[0].amtacctdr = amtacctdr;
    objectHeaderData[0].amtacctcr = amtacctcr;
    objectHeaderData[0].cUomId = cUomId;
    objectHeaderData[0].cUomIdr = "";
    objectHeaderData[0].qty = qty;
    objectHeaderData[0].trBgcolor = "";
    objectHeaderData[0].totalCount = "";
    objectHeaderData[0].created = "";
    objectHeaderData[0].createdby = createdby;
    objectHeaderData[0].createdbyr = createdbyr;
    objectHeaderData[0].updated = "";
    objectHeaderData[0].updatedby = updatedby;
    objectHeaderData[0].updatedbyr = updatedbyr;
    objectHeaderData[0].language = "";
    objectHeaderData[0].adUserClient = "";
    objectHeaderData[0].adOrgClient = "";
    return objectHeaderData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef5854_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef2527_1(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef2768_2(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
  public static String selectDef5852_3(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE Fact_Acct" +
      "        SET IsActive = (?) , A_Asset_ID = (?) , Line_ID = (?) , Fact_Acct_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_AcctSchema_ID = (?) , AD_Table_ID = (?) , Record_ID = TO_NUMBER(?) , Description = (?) , C_Period_ID = (?) , DateAcct = TO_DATE(?) , DateTrx = TO_DATE(?) , Account_ID = (?) , C_BPartner_ID = (?) , M_Product_ID = (?) , C_Project_ID = (?) , C_SalesRegion_ID = (?) , C_Campaign_ID = (?) , C_LocFrom_ID = (?) , C_LocTo_ID = (?) , C_Activity_ID = (?) , GL_Category_ID = (?) , C_Tax_ID = (?) , M_Locator_ID = (?) , C_Currency_ID = (?) , AmtAcctDr = TO_NUMBER(?) , AmtAcctCr = TO_NUMBER(?) , C_UOM_ID = (?) , Qty = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE Fact_Acct.Fact_Acct_ID = ? " +
      "        AND Fact_Acct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND Fact_Acct.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recordId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datetrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocfromId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLoctoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtacctdr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtacctcr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctId);
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
      "        INSERT INTO Fact_Acct " +
      "        (IsActive, A_Asset_ID, Line_ID, Fact_Acct_ID, AD_Client_ID, AD_Org_ID, C_AcctSchema_ID, AD_Table_ID, Record_ID, Description, C_Period_ID, DateAcct, DateTrx, Account_ID, C_BPartner_ID, M_Product_ID, C_Project_ID, C_SalesRegion_ID, C_Campaign_ID, C_LocFrom_ID, C_LocTo_ID, C_Activity_ID, GL_Category_ID, C_Tax_ID, M_Locator_ID, C_Currency_ID, AmtAcctDr, AmtAcctCr, C_UOM_ID, Qty, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recordId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datetrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocfromId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLoctoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtacctdr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtacctcr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
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
      "        DELETE FROM Fact_Acct" +
      "        WHERE Fact_Acct.Fact_Acct_ID = ? " +
      "        AND Fact_Acct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND Fact_Acct.AD_Org_ID IN (";
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
      "        DELETE FROM Fact_Acct" +
      "        WHERE Fact_Acct.Fact_Acct_ID = ? ";

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
      "          FROM Fact_Acct" +
      "         WHERE Fact_Acct.Fact_Acct_ID = ? ";

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
      "          FROM Fact_Acct" +
      "         WHERE Fact_Acct.Fact_Acct_ID = ? ";

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
