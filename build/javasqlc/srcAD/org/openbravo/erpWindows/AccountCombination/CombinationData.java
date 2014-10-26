//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.AccountCombination;

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
class CombinationData implements FieldProvider {
static Logger log4j = Logger.getLogger(CombinationData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cValidcombinationId;
  public String adClientId;
  public String adClientIdr;
  public String cAcctschemaId;
  public String cAcctschemaIdr;
  public String alias;
  public String combination;
  public String description;
  public String isactive;
  public String isfullyqualified;
  public String adOrgId;
  public String adOrgIdr;
  public String accountId;
  public String accountIdr;
  public String cActivityId;
  public String cActivityIdr;
  public String mProductId;
  public String mProductIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cProjectId;
  public String cProjectIdr;
  public String cCampaignId;
  public String cCampaignIdr;
  public String adOrgtrxId;
  public String cLocfromId;
  public String cLocfromIdr;
  public String cLoctoId;
  public String cLoctoIdr;
  public String cSalesregionId;
  public String cSalesregionIdr;
  public String user1Id;
  public String user2Id;
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
    else if (fieldName.equalsIgnoreCase("c_validcombination_id") || fieldName.equals("cValidcombinationId"))
      return cValidcombinationId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_idr") || fieldName.equals("cAcctschemaIdr"))
      return cAcctschemaIdr;
    else if (fieldName.equalsIgnoreCase("alias"))
      return alias;
    else if (fieldName.equalsIgnoreCase("combination"))
      return combination;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isfullyqualified"))
      return isfullyqualified;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("account_id") || fieldName.equals("accountId"))
      return accountId;
    else if (fieldName.equalsIgnoreCase("account_idr") || fieldName.equals("accountIdr"))
      return accountIdr;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("c_activity_idr") || fieldName.equals("cActivityIdr"))
      return cActivityIdr;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_campaign_idr") || fieldName.equals("cCampaignIdr"))
      return cCampaignIdr;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("c_locfrom_id") || fieldName.equals("cLocfromId"))
      return cLocfromId;
    else if (fieldName.equalsIgnoreCase("c_locfrom_idr") || fieldName.equals("cLocfromIdr"))
      return cLocfromIdr;
    else if (fieldName.equalsIgnoreCase("c_locto_id") || fieldName.equals("cLoctoId"))
      return cLoctoId;
    else if (fieldName.equalsIgnoreCase("c_locto_idr") || fieldName.equals("cLoctoIdr"))
      return cLoctoIdr;
    else if (fieldName.equalsIgnoreCase("c_salesregion_id") || fieldName.equals("cSalesregionId"))
      return cSalesregionId;
    else if (fieldName.equalsIgnoreCase("c_salesregion_idr") || fieldName.equals("cSalesregionIdr"))
      return cSalesregionIdr;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
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
  public static CombinationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CombinationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_ValidCombination.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_ValidCombination.CreatedBy) as CreatedByR, " +
      "        to_char(C_ValidCombination.Updated, ?) as updated, " +
      "        to_char(C_ValidCombination.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_ValidCombination.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_ValidCombination.UpdatedBy) as UpdatedByR," +
      "        C_ValidCombination.C_ValidCombination_ID, " +
      "C_ValidCombination.AD_Client_ID, " +
      "(CASE WHEN C_ValidCombination.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_ValidCombination.C_AcctSchema_ID, " +
      "(CASE WHEN C_ValidCombination.C_AcctSchema_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_AcctSchema_IDR, " +
      "C_ValidCombination.Alias, " +
      "C_ValidCombination.Combination, " +
      "C_ValidCombination.Description, " +
      "COALESCE(C_ValidCombination.IsActive, 'N') AS IsActive, " +
      "COALESCE(C_ValidCombination.IsFullyQualified, 'N') AS IsFullyQualified, " +
      "C_ValidCombination.AD_Org_ID, " +
      "(CASE WHEN C_ValidCombination.AD_Org_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_ValidCombination.Account_ID, " +
      "(CASE WHEN C_ValidCombination.Account_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS Account_IDR, " +
      "C_ValidCombination.C_Activity_ID, " +
      "(CASE WHEN C_ValidCombination.C_Activity_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Activity_IDR, " +
      "C_ValidCombination.M_Product_ID, " +
      "(CASE WHEN C_ValidCombination.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "C_ValidCombination.C_BPartner_ID, " +
      "(CASE WHEN C_ValidCombination.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "C_ValidCombination.C_Project_ID, " +
      "(CASE WHEN C_ValidCombination.C_Project_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "C_ValidCombination.C_Campaign_ID, " +
      "(CASE WHEN C_ValidCombination.C_Campaign_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS C_Campaign_IDR, " +
      "C_ValidCombination.AD_OrgTrx_ID, " +
      "C_ValidCombination.C_LocFrom_ID, " +
      "(CASE WHEN C_ValidCombination.C_LocFrom_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.City), ''))),'') ) END) AS C_LocFrom_IDR, " +
      "C_ValidCombination.C_LocTo_ID, " +
      "(CASE WHEN C_ValidCombination.C_LocTo_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.City), ''))),'') ) END) AS C_LocTo_IDR, " +
      "C_ValidCombination.C_SalesRegion_ID, " +
      "(CASE WHEN C_ValidCombination.C_SalesRegion_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Name), ''))),'') ) END) AS C_SalesRegion_IDR, " +
      "C_ValidCombination.User1_ID, " +
      "C_ValidCombination.User2_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_ValidCombination left join (select AD_Client_ID, Name from AD_Client) table1 on (C_ValidCombination.AD_Client_ID = table1.AD_Client_ID) left join (select C_AcctSchema_ID, Name from C_AcctSchema) table2 on (C_ValidCombination.C_AcctSchema_ID = table2.C_AcctSchema_ID) left join (select AD_Org_ID, Name from AD_Org) table3 on (C_ValidCombination.AD_Org_ID =  table3.AD_Org_ID) left join (select C_ElementValue_ID, value, Name from C_ElementValue) table4 on (C_ValidCombination.Account_ID =  table4.C_ElementValue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL4 on (table4.C_ElementValue_ID = tableTRL4.C_ElementValue_ID and tableTRL4.AD_Language = ?)  left join (select C_Activity_ID, Name from C_Activity) table5 on (C_ValidCombination.C_Activity_ID =  table5.C_Activity_ID) left join (select M_Product_ID, Value, Name from M_Product) table6 on (C_ValidCombination.M_Product_ID = table6.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL6 on (table6.M_Product_ID = tableTRL6.M_Product_ID and tableTRL6.AD_Language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table7 on (C_ValidCombination.C_BPartner_ID = table7.C_BPartner_ID) left join (select C_Project_ID, value, Name from C_Project) table8 on (C_ValidCombination.C_Project_ID =  table8.C_Project_ID) left join (select C_Campaign_ID, value, Name from C_Campaign) table9 on (C_ValidCombination.C_Campaign_ID =  table9.C_Campaign_ID) left join (select C_Location_ID, City from C_Location) table10 on (C_ValidCombination.C_LocFrom_ID =  table10.C_Location_ID) left join (select C_Location_ID, City from C_Location) table11 on (C_ValidCombination.C_LocTo_ID =  table11.C_Location_ID) left join (select C_SalesRegion_ID, value, Name from C_SalesRegion) table12 on (C_ValidCombination.C_SalesRegion_ID =  table12.C_SalesRegion_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_ValidCombination.C_ValidCombination_ID = ? " +
      "        AND C_ValidCombination.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_ValidCombination.AD_Org_ID IN (";
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
        CombinationData objectCombinationData = new CombinationData();
        objectCombinationData.created = UtilSql.getValue(result, "created");
        objectCombinationData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCombinationData.updated = UtilSql.getValue(result, "updated");
        objectCombinationData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCombinationData.updatedby = UtilSql.getValue(result, "updatedby");
        objectCombinationData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCombinationData.cValidcombinationId = UtilSql.getValue(result, "c_validcombination_id");
        objectCombinationData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCombinationData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectCombinationData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectCombinationData.cAcctschemaIdr = UtilSql.getValue(result, "c_acctschema_idr");
        objectCombinationData.alias = UtilSql.getValue(result, "alias");
        objectCombinationData.combination = UtilSql.getValue(result, "combination");
        objectCombinationData.description = UtilSql.getValue(result, "description");
        objectCombinationData.isactive = UtilSql.getValue(result, "isactive");
        objectCombinationData.isfullyqualified = UtilSql.getValue(result, "isfullyqualified");
        objectCombinationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCombinationData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectCombinationData.accountId = UtilSql.getValue(result, "account_id");
        objectCombinationData.accountIdr = UtilSql.getValue(result, "account_idr");
        objectCombinationData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectCombinationData.cActivityIdr = UtilSql.getValue(result, "c_activity_idr");
        objectCombinationData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCombinationData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectCombinationData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCombinationData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectCombinationData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCombinationData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectCombinationData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectCombinationData.cCampaignIdr = UtilSql.getValue(result, "c_campaign_idr");
        objectCombinationData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectCombinationData.cLocfromId = UtilSql.getValue(result, "c_locfrom_id");
        objectCombinationData.cLocfromIdr = UtilSql.getValue(result, "c_locfrom_idr");
        objectCombinationData.cLoctoId = UtilSql.getValue(result, "c_locto_id");
        objectCombinationData.cLoctoIdr = UtilSql.getValue(result, "c_locto_idr");
        objectCombinationData.cSalesregionId = UtilSql.getValue(result, "c_salesregion_id");
        objectCombinationData.cSalesregionIdr = UtilSql.getValue(result, "c_salesregion_idr");
        objectCombinationData.user1Id = UtilSql.getValue(result, "user1_id");
        objectCombinationData.user2Id = UtilSql.getValue(result, "user2_id");
        objectCombinationData.language = UtilSql.getValue(result, "language");
        objectCombinationData.adUserClient = "";
        objectCombinationData.adOrgClient = "";
        objectCombinationData.createdby = "";
        objectCombinationData.trBgcolor = "";
        objectCombinationData.totalCount = "";
        objectCombinationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCombinationData);
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
    CombinationData objectCombinationData[] = new CombinationData[vector.size()];
    vector.copyInto(objectCombinationData);
    return(objectCombinationData);
  }

/**
Create a registry
 */
  public static CombinationData[] set(String description, String cActivityId, String cLocfromId, String alias, String cBpartnerId, String cBpartnerIdr, String adClientId, String combination, String isfullyqualified, String user1Id, String user2Id, String cValidcombinationId, String mProductId, String mProductIdr, String adOrgtrxId, String cLoctoId, String cProjectId, String cAcctschemaId, String cSalesregionId, String updatedby, String updatedbyr, String createdby, String createdbyr, String accountId, String isactive, String cCampaignId, String adOrgId)    throws ServletException {
    CombinationData objectCombinationData[] = new CombinationData[1];
    objectCombinationData[0] = new CombinationData();
    objectCombinationData[0].created = "";
    objectCombinationData[0].createdbyr = createdbyr;
    objectCombinationData[0].updated = "";
    objectCombinationData[0].updatedTimeStamp = "";
    objectCombinationData[0].updatedby = updatedby;
    objectCombinationData[0].updatedbyr = updatedbyr;
    objectCombinationData[0].cValidcombinationId = cValidcombinationId;
    objectCombinationData[0].adClientId = adClientId;
    objectCombinationData[0].adClientIdr = "";
    objectCombinationData[0].cAcctschemaId = cAcctschemaId;
    objectCombinationData[0].cAcctschemaIdr = "";
    objectCombinationData[0].alias = alias;
    objectCombinationData[0].combination = combination;
    objectCombinationData[0].description = description;
    objectCombinationData[0].isactive = isactive;
    objectCombinationData[0].isfullyqualified = isfullyqualified;
    objectCombinationData[0].adOrgId = adOrgId;
    objectCombinationData[0].adOrgIdr = "";
    objectCombinationData[0].accountId = accountId;
    objectCombinationData[0].accountIdr = "";
    objectCombinationData[0].cActivityId = cActivityId;
    objectCombinationData[0].cActivityIdr = "";
    objectCombinationData[0].mProductId = mProductId;
    objectCombinationData[0].mProductIdr = mProductIdr;
    objectCombinationData[0].cBpartnerId = cBpartnerId;
    objectCombinationData[0].cBpartnerIdr = cBpartnerIdr;
    objectCombinationData[0].cProjectId = cProjectId;
    objectCombinationData[0].cProjectIdr = "";
    objectCombinationData[0].cCampaignId = cCampaignId;
    objectCombinationData[0].cCampaignIdr = "";
    objectCombinationData[0].adOrgtrxId = adOrgtrxId;
    objectCombinationData[0].cLocfromId = cLocfromId;
    objectCombinationData[0].cLocfromIdr = "";
    objectCombinationData[0].cLoctoId = cLoctoId;
    objectCombinationData[0].cLoctoIdr = "";
    objectCombinationData[0].cSalesregionId = cSalesregionId;
    objectCombinationData[0].cSalesregionIdr = "";
    objectCombinationData[0].user1Id = user1Id;
    objectCombinationData[0].user2Id = user2Id;
    objectCombinationData[0].language = "";
    return objectCombinationData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2754_0(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
  public static String selectDef2402_1(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef1021_2(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef1019_3(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
      "        UPDATE C_ValidCombination" +
      "        SET C_ValidCombination_ID = (?) , AD_Client_ID = (?) , C_AcctSchema_ID = (?) , Alias = (?) , Combination = (?) , Description = (?) , IsActive = (?) , IsFullyQualified = (?) , AD_Org_ID = (?) , Account_ID = (?) , C_Activity_ID = (?) , M_Product_ID = (?) , C_BPartner_ID = (?) , C_Project_ID = (?) , C_Campaign_ID = (?) , AD_OrgTrx_ID = (?) , C_LocFrom_ID = (?) , C_LocTo_ID = (?) , C_SalesRegion_ID = (?) , User1_ID = (?) , User2_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_ValidCombination.C_ValidCombination_ID = ? " +
      "        AND C_ValidCombination.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_ValidCombination.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cValidcombinationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alias);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, combination);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfullyqualified);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocfromId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLoctoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cValidcombinationId);
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
      "        INSERT INTO C_ValidCombination " +
      "        (C_ValidCombination_ID, AD_Client_ID, C_AcctSchema_ID, Alias, Combination, Description, IsActive, IsFullyQualified, AD_Org_ID, Account_ID, C_Activity_ID, M_Product_ID, C_BPartner_ID, C_Project_ID, C_Campaign_ID, AD_OrgTrx_ID, C_LocFrom_ID, C_LocTo_ID, C_SalesRegion_ID, User1_ID, User2_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cValidcombinationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alias);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, combination);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfullyqualified);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocfromId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLoctoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
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
      "        DELETE FROM C_ValidCombination" +
      "        WHERE C_ValidCombination.C_ValidCombination_ID = ? " +
      "        AND C_ValidCombination.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_ValidCombination.AD_Org_ID IN (";
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
      "        DELETE FROM C_ValidCombination" +
      "        WHERE C_ValidCombination.C_ValidCombination_ID = ? ";

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
      "          FROM C_ValidCombination" +
      "         WHERE C_ValidCombination.C_ValidCombination_ID = ? ";

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
      "          FROM C_ValidCombination" +
      "         WHERE C_ValidCombination.C_ValidCombination_ID = ? ";

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
