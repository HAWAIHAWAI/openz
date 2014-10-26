//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.AccountingSchema;

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
class AccountSchemaElementData implements FieldProvider {
static Logger log4j = Logger.getLogger(AccountSchemaElementData.class);
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
  public String cAcctschemaId;
  public String cAcctschemaIdr;
  public String name;
  public String isactive;
  public String elementtype;
  public String elementtyper;
  public String cElementId;
  public String cElementIdr;
  public String seqno;
  public String orgId;
  public String orgIdr;
  public String mProductId;
  public String mProductIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cLocationId;
  public String cLocationIdr;
  public String cSalesregionId;
  public String cSalesregionIdr;
  public String cProjectId;
  public String cProjectIdr;
  public String cCampaignId;
  public String cCampaignIdr;
  public String cActivityId;
  public String cActivityIdr;
  public String cElementvalueId;
  public String cAcctschemaElementId;
  public String isbalanced;
  public String ismandatory;
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
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_idr") || fieldName.equals("cAcctschemaIdr"))
      return cAcctschemaIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("elementtype"))
      return elementtype;
    else if (fieldName.equalsIgnoreCase("elementtyper"))
      return elementtyper;
    else if (fieldName.equalsIgnoreCase("c_element_id") || fieldName.equals("cElementId"))
      return cElementId;
    else if (fieldName.equalsIgnoreCase("c_element_idr") || fieldName.equals("cElementIdr"))
      return cElementIdr;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("org_id") || fieldName.equals("orgId"))
      return orgId;
    else if (fieldName.equalsIgnoreCase("org_idr") || fieldName.equals("orgIdr"))
      return orgIdr;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_location_id") || fieldName.equals("cLocationId"))
      return cLocationId;
    else if (fieldName.equalsIgnoreCase("c_location_idr") || fieldName.equals("cLocationIdr"))
      return cLocationIdr;
    else if (fieldName.equalsIgnoreCase("c_salesregion_id") || fieldName.equals("cSalesregionId"))
      return cSalesregionId;
    else if (fieldName.equalsIgnoreCase("c_salesregion_idr") || fieldName.equals("cSalesregionIdr"))
      return cSalesregionIdr;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_campaign_idr") || fieldName.equals("cCampaignIdr"))
      return cCampaignIdr;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("c_activity_idr") || fieldName.equals("cActivityIdr"))
      return cActivityIdr;
    else if (fieldName.equalsIgnoreCase("c_elementvalue_id") || fieldName.equals("cElementvalueId"))
      return cElementvalueId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_element_id") || fieldName.equals("cAcctschemaElementId"))
      return cAcctschemaElementId;
    else if (fieldName.equalsIgnoreCase("isbalanced"))
      return isbalanced;
    else if (fieldName.equalsIgnoreCase("ismandatory"))
      return ismandatory;
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
  public static AccountSchemaElementData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cAcctschemaId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cAcctschemaId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static AccountSchemaElementData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cAcctschemaId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_AcctSchema_Element.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_AcctSchema_Element.CreatedBy) as CreatedByR, " +
      "        to_char(C_AcctSchema_Element.Updated, ?) as updated, " +
      "        to_char(C_AcctSchema_Element.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_AcctSchema_Element.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_AcctSchema_Element.UpdatedBy) as UpdatedByR," +
      "        C_AcctSchema_Element.AD_Client_ID, " +
      "(CASE WHEN C_AcctSchema_Element.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_AcctSchema_Element.AD_Org_ID, " +
      "(CASE WHEN C_AcctSchema_Element.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_AcctSchema_Element.C_AcctSchema_ID, " +
      "(CASE WHEN C_AcctSchema_Element.C_AcctSchema_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_AcctSchema_IDR, " +
      "C_AcctSchema_Element.Name, " +
      "COALESCE(C_AcctSchema_Element.IsActive, 'N') AS IsActive, " +
      "C_AcctSchema_Element.ElementType, " +
      "(CASE WHEN C_AcctSchema_Element.ElementType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ElementTypeR, " +
      "C_AcctSchema_Element.C_Element_ID, " +
      "(CASE WHEN C_AcctSchema_Element.C_Element_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Element_IDR, " +
      "C_AcctSchema_Element.SeqNo, " +
      "C_AcctSchema_Element.Org_ID, " +
      "(CASE WHEN C_AcctSchema_Element.Org_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS Org_IDR, " +
      "C_AcctSchema_Element.M_Product_ID, " +
      "(CASE WHEN C_AcctSchema_Element.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "C_AcctSchema_Element.C_BPartner_ID, " +
      "(CASE WHEN C_AcctSchema_Element.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "C_AcctSchema_Element.C_Location_ID, " +
      "(CASE WHEN C_AcctSchema_Element.C_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Address1), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Address2), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Postal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.City), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL10.Name IS NULL THEN TO_CHAR(table10.Name) ELSE TO_CHAR(tableTRL10.Name) END)), ''))),'') ) END) AS C_Location_IDR, " +
      "C_AcctSchema_Element.C_SalesRegion_ID, " +
      "(CASE WHEN C_AcctSchema_Element.C_SalesRegion_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS C_SalesRegion_IDR, " +
      "C_AcctSchema_Element.C_Project_ID, " +
      "(CASE WHEN C_AcctSchema_Element.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "C_AcctSchema_Element.C_Campaign_ID, " +
      "(CASE WHEN C_AcctSchema_Element.C_Campaign_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Name), ''))),'') ) END) AS C_Campaign_IDR, " +
      "C_AcctSchema_Element.C_Activity_ID, " +
      "(CASE WHEN C_AcctSchema_Element.C_Activity_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Name), ''))),'') ) END) AS C_Activity_IDR, " +
      "C_AcctSchema_Element.C_ElementValue_ID, " +
      "C_AcctSchema_Element.C_AcctSchema_Element_ID, " +
      "COALESCE(C_AcctSchema_Element.IsBalanced, 'N') AS IsBalanced, " +
      "COALESCE(C_AcctSchema_Element.IsMandatory, 'N') AS IsMandatory, " +
      "        ? AS LANGUAGE " +
      "        FROM C_AcctSchema_Element left join (select AD_Client_ID, Name from AD_Client) table1 on (C_AcctSchema_Element.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_AcctSchema_Element.AD_Org_ID = table2.AD_Org_ID) left join (select C_AcctSchema_ID, Name from C_AcctSchema) table3 on (C_AcctSchema_Element.C_AcctSchema_ID = table3.C_AcctSchema_ID) left join ad_ref_list_v list1 on (C_AcctSchema_Element.ElementType = list1.value and list1.ad_reference_id = '181' and list1.ad_language = ?)  left join (select C_Element_ID, Name from C_Element) table4 on (C_AcctSchema_Element.C_Element_ID = table4.C_Element_ID) left join (select AD_Org_ID, value, Name from AD_Org) table5 on (C_AcctSchema_Element.Org_ID =  table5.AD_Org_ID) left join (select M_Product_ID, Value, Name from M_Product) table6 on (C_AcctSchema_Element.M_Product_ID = table6.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL6 on (table6.M_Product_ID = tableTRL6.M_Product_ID and tableTRL6.AD_Language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table7 on (C_AcctSchema_Element.C_BPartner_ID = table7.C_BPartner_ID) left join (select C_Location_ID, Address1, Address2, Postal, City, C_Region_ID, C_Country_ID from C_Location) table8 on (C_AcctSchema_Element.C_Location_ID = table8.C_Location_ID) left join (select C_Region_ID, Name from C_Region) table9 on (table8.C_Region_ID = table9.C_Region_ID) left join (select C_Country_ID, Name from C_Country) table10 on (table8.C_Country_ID = table10.C_Country_ID) left join (select C_Country_ID,AD_Language, Name from C_Country_TRL) tableTRL10 on (table10.C_Country_ID = tableTRL10.C_Country_ID and tableTRL10.AD_Language = ?)  left join (select C_SalesRegion_ID, Name from C_SalesRegion) table11 on (C_AcctSchema_Element.C_SalesRegion_ID = table11.C_SalesRegion_ID) left join (select C_Project_ID, Value, Name from C_Project) table12 on (C_AcctSchema_Element.C_Project_ID = table12.C_Project_ID) left join (select C_Campaign_ID, Name from C_Campaign) table13 on (C_AcctSchema_Element.C_Campaign_ID = table13.C_Campaign_ID) left join (select C_Activity_ID, Name from C_Activity) table14 on (C_AcctSchema_Element.C_Activity_ID = table14.C_Activity_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cAcctschemaId==null || cAcctschemaId.equals(""))?"":"  AND C_AcctSchema_Element.C_AcctSchema_ID = ?  ");
    strSql = strSql + 
      "        AND C_AcctSchema_Element.C_AcctSchema_Element_ID = ? " +
      "        AND C_AcctSchema_Element.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_AcctSchema_Element.AD_Org_ID IN (";
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
      if (cAcctschemaId != null && !(cAcctschemaId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      }
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
        AccountSchemaElementData objectAccountSchemaElementData = new AccountSchemaElementData();
        objectAccountSchemaElementData.created = UtilSql.getValue(result, "created");
        objectAccountSchemaElementData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectAccountSchemaElementData.updated = UtilSql.getValue(result, "updated");
        objectAccountSchemaElementData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectAccountSchemaElementData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAccountSchemaElementData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectAccountSchemaElementData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAccountSchemaElementData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectAccountSchemaElementData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAccountSchemaElementData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectAccountSchemaElementData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectAccountSchemaElementData.cAcctschemaIdr = UtilSql.getValue(result, "c_acctschema_idr");
        objectAccountSchemaElementData.name = UtilSql.getValue(result, "name");
        objectAccountSchemaElementData.isactive = UtilSql.getValue(result, "isactive");
        objectAccountSchemaElementData.elementtype = UtilSql.getValue(result, "elementtype");
        objectAccountSchemaElementData.elementtyper = UtilSql.getValue(result, "elementtyper");
        objectAccountSchemaElementData.cElementId = UtilSql.getValue(result, "c_element_id");
        objectAccountSchemaElementData.cElementIdr = UtilSql.getValue(result, "c_element_idr");
        objectAccountSchemaElementData.seqno = UtilSql.getValue(result, "seqno");
        objectAccountSchemaElementData.orgId = UtilSql.getValue(result, "org_id");
        objectAccountSchemaElementData.orgIdr = UtilSql.getValue(result, "org_idr");
        objectAccountSchemaElementData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectAccountSchemaElementData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectAccountSchemaElementData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectAccountSchemaElementData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectAccountSchemaElementData.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectAccountSchemaElementData.cLocationIdr = UtilSql.getValue(result, "c_location_idr");
        objectAccountSchemaElementData.cSalesregionId = UtilSql.getValue(result, "c_salesregion_id");
        objectAccountSchemaElementData.cSalesregionIdr = UtilSql.getValue(result, "c_salesregion_idr");
        objectAccountSchemaElementData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectAccountSchemaElementData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectAccountSchemaElementData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectAccountSchemaElementData.cCampaignIdr = UtilSql.getValue(result, "c_campaign_idr");
        objectAccountSchemaElementData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectAccountSchemaElementData.cActivityIdr = UtilSql.getValue(result, "c_activity_idr");
        objectAccountSchemaElementData.cElementvalueId = UtilSql.getValue(result, "c_elementvalue_id");
        objectAccountSchemaElementData.cAcctschemaElementId = UtilSql.getValue(result, "c_acctschema_element_id");
        objectAccountSchemaElementData.isbalanced = UtilSql.getValue(result, "isbalanced");
        objectAccountSchemaElementData.ismandatory = UtilSql.getValue(result, "ismandatory");
        objectAccountSchemaElementData.language = UtilSql.getValue(result, "language");
        objectAccountSchemaElementData.adUserClient = "";
        objectAccountSchemaElementData.adOrgClient = "";
        objectAccountSchemaElementData.createdby = "";
        objectAccountSchemaElementData.trBgcolor = "";
        objectAccountSchemaElementData.totalCount = "";
        objectAccountSchemaElementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountSchemaElementData);
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
    AccountSchemaElementData objectAccountSchemaElementData[] = new AccountSchemaElementData[vector.size()];
    vector.copyInto(objectAccountSchemaElementData);
    return(objectAccountSchemaElementData);
  }

/**
Create a registry
 */
  public static AccountSchemaElementData[] set(String cAcctschemaId, String name, String seqno, String cCampaignId, String cBpartnerId, String cBpartnerIdr, String isbalanced, String cElementvalueId, String adOrgId, String orgId, String cLocationId, String cLocationIdr, String isactive, String mProductId, String mProductIdr, String cActivityId, String updatedby, String updatedbyr, String ismandatory, String cAcctschemaElementId, String createdby, String createdbyr, String adClientId, String elementtype, String cElementId, String cProjectId, String cSalesregionId)    throws ServletException {
    AccountSchemaElementData objectAccountSchemaElementData[] = new AccountSchemaElementData[1];
    objectAccountSchemaElementData[0] = new AccountSchemaElementData();
    objectAccountSchemaElementData[0].created = "";
    objectAccountSchemaElementData[0].createdbyr = createdbyr;
    objectAccountSchemaElementData[0].updated = "";
    objectAccountSchemaElementData[0].updatedTimeStamp = "";
    objectAccountSchemaElementData[0].updatedby = updatedby;
    objectAccountSchemaElementData[0].updatedbyr = updatedbyr;
    objectAccountSchemaElementData[0].adClientId = adClientId;
    objectAccountSchemaElementData[0].adClientIdr = "";
    objectAccountSchemaElementData[0].adOrgId = adOrgId;
    objectAccountSchemaElementData[0].adOrgIdr = "";
    objectAccountSchemaElementData[0].cAcctschemaId = cAcctschemaId;
    objectAccountSchemaElementData[0].cAcctschemaIdr = "";
    objectAccountSchemaElementData[0].name = name;
    objectAccountSchemaElementData[0].isactive = isactive;
    objectAccountSchemaElementData[0].elementtype = elementtype;
    objectAccountSchemaElementData[0].elementtyper = "";
    objectAccountSchemaElementData[0].cElementId = cElementId;
    objectAccountSchemaElementData[0].cElementIdr = "";
    objectAccountSchemaElementData[0].seqno = seqno;
    objectAccountSchemaElementData[0].orgId = orgId;
    objectAccountSchemaElementData[0].orgIdr = "";
    objectAccountSchemaElementData[0].mProductId = mProductId;
    objectAccountSchemaElementData[0].mProductIdr = mProductIdr;
    objectAccountSchemaElementData[0].cBpartnerId = cBpartnerId;
    objectAccountSchemaElementData[0].cBpartnerIdr = cBpartnerIdr;
    objectAccountSchemaElementData[0].cLocationId = cLocationId;
    objectAccountSchemaElementData[0].cLocationIdr = cLocationIdr;
    objectAccountSchemaElementData[0].cSalesregionId = cSalesregionId;
    objectAccountSchemaElementData[0].cSalesregionIdr = "";
    objectAccountSchemaElementData[0].cProjectId = cProjectId;
    objectAccountSchemaElementData[0].cProjectIdr = "";
    objectAccountSchemaElementData[0].cCampaignId = cCampaignId;
    objectAccountSchemaElementData[0].cCampaignIdr = "";
    objectAccountSchemaElementData[0].cActivityId = cActivityId;
    objectAccountSchemaElementData[0].cActivityIdr = "";
    objectAccountSchemaElementData[0].cElementvalueId = cElementvalueId;
    objectAccountSchemaElementData[0].cAcctschemaElementId = cAcctschemaElementId;
    objectAccountSchemaElementData[0].isbalanced = isbalanced;
    objectAccountSchemaElementData[0].ismandatory = ismandatory;
    objectAccountSchemaElementData[0].language = "";
    return objectAccountSchemaElementData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2665(ConnectionProvider connectionProvider, String C_AcctSchema_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(SeqNo),0)+10 AS DefaultValue FROM C_AcctSchema_Element WHERE C_AcctSchema_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
  public static String selectDef2738_0(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
  public static String selectDef2697_1(ConnectionProvider connectionProvider, String C_Location_IDR)    throws ServletException {
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
  public static String selectDef2695_2(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef2662_3(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef2660_4(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_AcctSchema_Element.C_AcctSchema_ID AS NAME" +
      "        FROM C_AcctSchema_Element" +
      "        WHERE C_AcctSchema_Element.C_AcctSchema_Element_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
Select for parent field
 */
  public static String selectParent(ConnectionProvider connectionProvider, String cAcctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_AcctSchema left join (select C_AcctSchema_ID, Name from C_AcctSchema) table1 on (C_AcctSchema.C_AcctSchema_ID = table1.C_AcctSchema_ID) WHERE C_AcctSchema.C_AcctSchema_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
Select for parent field
 */
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cAcctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_AcctSchema left join (select C_AcctSchema_ID, Name from C_AcctSchema) table1 on (C_AcctSchema.C_AcctSchema_ID = table1.C_AcctSchema_ID) WHERE C_AcctSchema.C_AcctSchema_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
      "        UPDATE C_AcctSchema_Element" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , C_AcctSchema_ID = (?) , Name = (?) , IsActive = (?) , ElementType = (?) , C_Element_ID = (?) , SeqNo = TO_NUMBER(?) , Org_ID = (?) , M_Product_ID = (?) , C_BPartner_ID = (?) , C_Location_ID = (?) , C_SalesRegion_ID = (?) , C_Project_ID = (?) , C_Campaign_ID = (?) , C_Activity_ID = (?) , C_ElementValue_ID = (?) , C_AcctSchema_Element_ID = (?) , IsBalanced = (?) , IsMandatory = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_AcctSchema_Element.C_AcctSchema_Element_ID = ? " +
      "                 AND C_AcctSchema_Element.C_AcctSchema_ID = ? " +
      "        AND C_AcctSchema_Element.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_AcctSchema_Element.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, elementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbalanced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismandatory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
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
      "        INSERT INTO C_AcctSchema_Element " +
      "        (AD_Client_ID, AD_Org_ID, C_AcctSchema_ID, Name, IsActive, ElementType, C_Element_ID, SeqNo, Org_ID, M_Product_ID, C_BPartner_ID, C_Location_ID, C_SalesRegion_ID, C_Project_ID, C_Campaign_ID, C_Activity_ID, C_ElementValue_ID, C_AcctSchema_Element_ID, IsBalanced, IsMandatory, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, elementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbalanced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismandatory);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cAcctschemaId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_AcctSchema_Element" +
      "        WHERE C_AcctSchema_Element.C_AcctSchema_Element_ID = ? " +
      "                 AND C_AcctSchema_Element.C_AcctSchema_ID = ? " +
      "        AND C_AcctSchema_Element.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_AcctSchema_Element.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cAcctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_AcctSchema_Element" +
      "        WHERE C_AcctSchema_Element.C_AcctSchema_Element_ID = ? " +
      "                 AND C_AcctSchema_Element.C_AcctSchema_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

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
      "          FROM C_AcctSchema_Element" +
      "         WHERE C_AcctSchema_Element.C_AcctSchema_Element_ID = ? ";

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
      "          FROM C_AcctSchema_Element" +
      "         WHERE C_AcctSchema_Element.C_AcctSchema_Element_ID = ? ";

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
