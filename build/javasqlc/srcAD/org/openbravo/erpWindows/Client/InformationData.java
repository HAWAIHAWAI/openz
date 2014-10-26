//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Client;

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
class InformationData implements FieldProvider {
static Logger log4j = Logger.getLogger(InformationData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adTreeOrgId;
  public String adTreeOrgIdr;
  public String adTreeMenuId;
  public String adTreeMenuIdr;
  public String adTreeBpartnerId;
  public String adTreeBpartnerIdr;
  public String adTreeProductId;
  public String adTreeProductIdr;
  public String adTreeProjectId;
  public String adTreeProjectIdr;
  public String adTreeSalesregionId;
  public String adTreeSalesregionIdr;
  public String allownegativestock;
  public String checkinoutorg;
  public String checkorderorg;
  public String yourCompanyBigImage;
  public String yourCompanyDocumentImage;
  public String yourCompanyMenuImage;
  public String mProductfreightId;
  public String isdiscountlineamt;
  public String cBpartnercashtrxId;
  public String mPricelistId;
  public String cUomTimeId;
  public String cUomLengthId;
  public String cUomWeightId;
  public String groupacctinvlines;
  public String cCalendarId;
  public String cAcctschema1Id;
  public String acct2Active;
  public String cAcctschema2Id;
  public String acct3Active;
  public String cAcctschema3Id;
  public String isactive;
  public String adOrgId;
  public String cUomVolumeId;
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
    else if (fieldName.equalsIgnoreCase("ad_tree_org_id") || fieldName.equals("adTreeOrgId"))
      return adTreeOrgId;
    else if (fieldName.equalsIgnoreCase("ad_tree_org_idr") || fieldName.equals("adTreeOrgIdr"))
      return adTreeOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_tree_menu_id") || fieldName.equals("adTreeMenuId"))
      return adTreeMenuId;
    else if (fieldName.equalsIgnoreCase("ad_tree_menu_idr") || fieldName.equals("adTreeMenuIdr"))
      return adTreeMenuIdr;
    else if (fieldName.equalsIgnoreCase("ad_tree_bpartner_id") || fieldName.equals("adTreeBpartnerId"))
      return adTreeBpartnerId;
    else if (fieldName.equalsIgnoreCase("ad_tree_bpartner_idr") || fieldName.equals("adTreeBpartnerIdr"))
      return adTreeBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("ad_tree_product_id") || fieldName.equals("adTreeProductId"))
      return adTreeProductId;
    else if (fieldName.equalsIgnoreCase("ad_tree_product_idr") || fieldName.equals("adTreeProductIdr"))
      return adTreeProductIdr;
    else if (fieldName.equalsIgnoreCase("ad_tree_project_id") || fieldName.equals("adTreeProjectId"))
      return adTreeProjectId;
    else if (fieldName.equalsIgnoreCase("ad_tree_project_idr") || fieldName.equals("adTreeProjectIdr"))
      return adTreeProjectIdr;
    else if (fieldName.equalsIgnoreCase("ad_tree_salesregion_id") || fieldName.equals("adTreeSalesregionId"))
      return adTreeSalesregionId;
    else if (fieldName.equalsIgnoreCase("ad_tree_salesregion_idr") || fieldName.equals("adTreeSalesregionIdr"))
      return adTreeSalesregionIdr;
    else if (fieldName.equalsIgnoreCase("allownegativestock"))
      return allownegativestock;
    else if (fieldName.equalsIgnoreCase("checkinoutorg"))
      return checkinoutorg;
    else if (fieldName.equalsIgnoreCase("checkorderorg"))
      return checkorderorg;
    else if (fieldName.equalsIgnoreCase("your_company_big_image") || fieldName.equals("yourCompanyBigImage"))
      return yourCompanyBigImage;
    else if (fieldName.equalsIgnoreCase("your_company_document_image") || fieldName.equals("yourCompanyDocumentImage"))
      return yourCompanyDocumentImage;
    else if (fieldName.equalsIgnoreCase("your_company_menu_image") || fieldName.equals("yourCompanyMenuImage"))
      return yourCompanyMenuImage;
    else if (fieldName.equalsIgnoreCase("m_productfreight_id") || fieldName.equals("mProductfreightId"))
      return mProductfreightId;
    else if (fieldName.equalsIgnoreCase("isdiscountlineamt"))
      return isdiscountlineamt;
    else if (fieldName.equalsIgnoreCase("c_bpartnercashtrx_id") || fieldName.equals("cBpartnercashtrxId"))
      return cBpartnercashtrxId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("c_uom_time_id") || fieldName.equals("cUomTimeId"))
      return cUomTimeId;
    else if (fieldName.equalsIgnoreCase("c_uom_length_id") || fieldName.equals("cUomLengthId"))
      return cUomLengthId;
    else if (fieldName.equalsIgnoreCase("c_uom_weight_id") || fieldName.equals("cUomWeightId"))
      return cUomWeightId;
    else if (fieldName.equalsIgnoreCase("groupacctinvlines"))
      return groupacctinvlines;
    else if (fieldName.equalsIgnoreCase("c_calendar_id") || fieldName.equals("cCalendarId"))
      return cCalendarId;
    else if (fieldName.equalsIgnoreCase("c_acctschema1_id") || fieldName.equals("cAcctschema1Id"))
      return cAcctschema1Id;
    else if (fieldName.equalsIgnoreCase("acct2_active") || fieldName.equals("acct2Active"))
      return acct2Active;
    else if (fieldName.equalsIgnoreCase("c_acctschema2_id") || fieldName.equals("cAcctschema2Id"))
      return cAcctschema2Id;
    else if (fieldName.equalsIgnoreCase("acct3_active") || fieldName.equals("acct3Active"))
      return acct3Active;
    else if (fieldName.equalsIgnoreCase("c_acctschema3_id") || fieldName.equals("cAcctschema3Id"))
      return cAcctschema3Id;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_uom_volume_id") || fieldName.equals("cUomVolumeId"))
      return cUomVolumeId;
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
  public static InformationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static InformationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_ClientInfo.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_ClientInfo.CreatedBy) as CreatedByR, " +
      "        to_char(AD_ClientInfo.Updated, ?) as updated, " +
      "        to_char(AD_ClientInfo.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_ClientInfo.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_ClientInfo.UpdatedBy) as UpdatedByR," +
      "        AD_ClientInfo.AD_Client_ID, " +
      "(CASE WHEN AD_ClientInfo.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_ClientInfo.AD_Tree_Org_ID, " +
      "(CASE WHEN AD_ClientInfo.AD_Tree_Org_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Tree_Org_IDR, " +
      "AD_ClientInfo.AD_Tree_Menu_ID, " +
      "(CASE WHEN AD_ClientInfo.AD_Tree_Menu_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_Tree_Menu_IDR, " +
      "AD_ClientInfo.AD_Tree_BPartner_ID, " +
      "(CASE WHEN AD_ClientInfo.AD_Tree_BPartner_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_Tree_BPartner_IDR, " +
      "AD_ClientInfo.AD_Tree_Product_ID, " +
      "(CASE WHEN AD_ClientInfo.AD_Tree_Product_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_Tree_Product_IDR, " +
      "AD_ClientInfo.AD_Tree_Project_ID, " +
      "(CASE WHEN AD_ClientInfo.AD_Tree_Project_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS AD_Tree_Project_IDR, " +
      "AD_ClientInfo.AD_Tree_SalesRegion_ID, " +
      "(CASE WHEN AD_ClientInfo.AD_Tree_SalesRegion_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS AD_Tree_SalesRegion_IDR, " +
      "COALESCE(AD_ClientInfo.AllowNegativeStock, 'N') AS AllowNegativeStock, " +
      "COALESCE(AD_ClientInfo.Checkinoutorg, 'N') AS Checkinoutorg, " +
      "COALESCE(AD_ClientInfo.Checkorderorg, 'N') AS Checkorderorg, " +
      "AD_ClientInfo.Your_Company_Big_Image, " +
      "AD_ClientInfo.Your_Company_Document_Image, " +
      "AD_ClientInfo.Your_Company_Menu_Image, " +
      "AD_ClientInfo.M_ProductFreight_ID, " +
      "COALESCE(AD_ClientInfo.IsDiscountLineAmt, 'N') AS IsDiscountLineAmt, " +
      "AD_ClientInfo.C_BPartnerCashTrx_ID, " +
      "AD_ClientInfo.M_PriceList_ID, " +
      "AD_ClientInfo.C_UOM_Time_ID, " +
      "AD_ClientInfo.C_UOM_Length_ID, " +
      "AD_ClientInfo.C_UOM_Weight_ID, " +
      "COALESCE(AD_ClientInfo.Groupacctinvlines, 'N') AS Groupacctinvlines, " +
      "AD_ClientInfo.C_Calendar_ID, " +
      "AD_ClientInfo.C_AcctSchema1_ID, " +
      "COALESCE(AD_ClientInfo.Acct2_Active, 'N') AS Acct2_Active, " +
      "AD_ClientInfo.C_AcctSchema2_ID, " +
      "COALESCE(AD_ClientInfo.Acct3_Active, 'N') AS Acct3_Active, " +
      "AD_ClientInfo.C_AcctSchema3_ID, " +
      "COALESCE(AD_ClientInfo.IsActive, 'N') AS IsActive, " +
      "AD_ClientInfo.AD_Org_ID, " +
      "AD_ClientInfo.C_UOM_Volume_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_ClientInfo left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_ClientInfo.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Tree_ID, Name from AD_Tree) table2 on (AD_ClientInfo.AD_Tree_Org_ID =  table2.AD_Tree_ID) left join (select AD_Tree_ID, Name from AD_Tree) table3 on (AD_ClientInfo.AD_Tree_Menu_ID =  table3.AD_Tree_ID) left join (select AD_Tree_ID, Name from AD_Tree) table4 on (AD_ClientInfo.AD_Tree_BPartner_ID =  table4.AD_Tree_ID) left join (select AD_Tree_ID, Name from AD_Tree) table5 on (AD_ClientInfo.AD_Tree_Product_ID =  table5.AD_Tree_ID) left join (select AD_Tree_ID, Name from AD_Tree) table6 on (AD_ClientInfo.AD_Tree_Project_ID =  table6.AD_Tree_ID) left join (select AD_Tree_ID, Name from AD_Tree) table7 on (AD_ClientInfo.AD_Tree_SalesRegion_ID =  table7.AD_Tree_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND AD_ClientInfo.AD_Client_ID = ? " +
      "        AND AD_ClientInfo.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_ClientInfo.AD_Org_ID IN (";
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
        InformationData objectInformationData = new InformationData();
        objectInformationData.created = UtilSql.getValue(result, "created");
        objectInformationData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectInformationData.updated = UtilSql.getValue(result, "updated");
        objectInformationData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectInformationData.updatedby = UtilSql.getValue(result, "updatedby");
        objectInformationData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectInformationData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectInformationData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectInformationData.adTreeOrgId = UtilSql.getValue(result, "ad_tree_org_id");
        objectInformationData.adTreeOrgIdr = UtilSql.getValue(result, "ad_tree_org_idr");
        objectInformationData.adTreeMenuId = UtilSql.getValue(result, "ad_tree_menu_id");
        objectInformationData.adTreeMenuIdr = UtilSql.getValue(result, "ad_tree_menu_idr");
        objectInformationData.adTreeBpartnerId = UtilSql.getValue(result, "ad_tree_bpartner_id");
        objectInformationData.adTreeBpartnerIdr = UtilSql.getValue(result, "ad_tree_bpartner_idr");
        objectInformationData.adTreeProductId = UtilSql.getValue(result, "ad_tree_product_id");
        objectInformationData.adTreeProductIdr = UtilSql.getValue(result, "ad_tree_product_idr");
        objectInformationData.adTreeProjectId = UtilSql.getValue(result, "ad_tree_project_id");
        objectInformationData.adTreeProjectIdr = UtilSql.getValue(result, "ad_tree_project_idr");
        objectInformationData.adTreeSalesregionId = UtilSql.getValue(result, "ad_tree_salesregion_id");
        objectInformationData.adTreeSalesregionIdr = UtilSql.getValue(result, "ad_tree_salesregion_idr");
        objectInformationData.allownegativestock = UtilSql.getValue(result, "allownegativestock");
        objectInformationData.checkinoutorg = UtilSql.getValue(result, "checkinoutorg");
        objectInformationData.checkorderorg = UtilSql.getValue(result, "checkorderorg");
        objectInformationData.yourCompanyBigImage = UtilSql.getValue(result, "your_company_big_image");
        objectInformationData.yourCompanyDocumentImage = UtilSql.getValue(result, "your_company_document_image");
        objectInformationData.yourCompanyMenuImage = UtilSql.getValue(result, "your_company_menu_image");
        objectInformationData.mProductfreightId = UtilSql.getValue(result, "m_productfreight_id");
        objectInformationData.isdiscountlineamt = UtilSql.getValue(result, "isdiscountlineamt");
        objectInformationData.cBpartnercashtrxId = UtilSql.getValue(result, "c_bpartnercashtrx_id");
        objectInformationData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectInformationData.cUomTimeId = UtilSql.getValue(result, "c_uom_time_id");
        objectInformationData.cUomLengthId = UtilSql.getValue(result, "c_uom_length_id");
        objectInformationData.cUomWeightId = UtilSql.getValue(result, "c_uom_weight_id");
        objectInformationData.groupacctinvlines = UtilSql.getValue(result, "groupacctinvlines");
        objectInformationData.cCalendarId = UtilSql.getValue(result, "c_calendar_id");
        objectInformationData.cAcctschema1Id = UtilSql.getValue(result, "c_acctschema1_id");
        objectInformationData.acct2Active = UtilSql.getValue(result, "acct2_active");
        objectInformationData.cAcctschema2Id = UtilSql.getValue(result, "c_acctschema2_id");
        objectInformationData.acct3Active = UtilSql.getValue(result, "acct3_active");
        objectInformationData.cAcctschema3Id = UtilSql.getValue(result, "c_acctschema3_id");
        objectInformationData.isactive = UtilSql.getValue(result, "isactive");
        objectInformationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectInformationData.cUomVolumeId = UtilSql.getValue(result, "c_uom_volume_id");
        objectInformationData.language = UtilSql.getValue(result, "language");
        objectInformationData.adUserClient = "";
        objectInformationData.adOrgClient = "";
        objectInformationData.createdby = "";
        objectInformationData.trBgcolor = "";
        objectInformationData.totalCount = "";
        objectInformationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInformationData);
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
    InformationData objectInformationData[] = new InformationData[vector.size()];
    vector.copyInto(objectInformationData);
    return(objectInformationData);
  }

/**
Create a registry
 */
  public static InformationData[] set(String yourCompanyDocumentImage, String adClientId, String mProductfreightId, String yourCompanyMenuImage, String cUomWeightId, String allownegativestock, String isactive, String updatedby, String updatedbyr, String mPricelistId, String cCalendarId, String cAcctschema3Id, String adTreeMenuId, String checkorderorg, String adTreeOrgId, String isdiscountlineamt, String groupacctinvlines, String cAcctschema2Id, String acct2Active, String adTreeSalesregionId, String checkinoutorg, String acct3Active, String cUomTimeId, String cAcctschema1Id, String adTreeProductId, String createdby, String createdbyr, String adTreeBpartnerId, String cBpartnercashtrxId, String adOrgId, String cUomLengthId, String yourCompanyBigImage, String cUomVolumeId, String adTreeProjectId)    throws ServletException {
    InformationData objectInformationData[] = new InformationData[1];
    objectInformationData[0] = new InformationData();
    objectInformationData[0].created = "";
    objectInformationData[0].createdbyr = createdbyr;
    objectInformationData[0].updated = "";
    objectInformationData[0].updatedTimeStamp = "";
    objectInformationData[0].updatedby = updatedby;
    objectInformationData[0].updatedbyr = updatedbyr;
    objectInformationData[0].adClientId = adClientId;
    objectInformationData[0].adClientIdr = "";
    objectInformationData[0].adTreeOrgId = adTreeOrgId;
    objectInformationData[0].adTreeOrgIdr = "";
    objectInformationData[0].adTreeMenuId = adTreeMenuId;
    objectInformationData[0].adTreeMenuIdr = "";
    objectInformationData[0].adTreeBpartnerId = adTreeBpartnerId;
    objectInformationData[0].adTreeBpartnerIdr = "";
    objectInformationData[0].adTreeProductId = adTreeProductId;
    objectInformationData[0].adTreeProductIdr = "";
    objectInformationData[0].adTreeProjectId = adTreeProjectId;
    objectInformationData[0].adTreeProjectIdr = "";
    objectInformationData[0].adTreeSalesregionId = adTreeSalesregionId;
    objectInformationData[0].adTreeSalesregionIdr = "";
    objectInformationData[0].allownegativestock = allownegativestock;
    objectInformationData[0].checkinoutorg = checkinoutorg;
    objectInformationData[0].checkorderorg = checkorderorg;
    objectInformationData[0].yourCompanyBigImage = yourCompanyBigImage;
    objectInformationData[0].yourCompanyDocumentImage = yourCompanyDocumentImage;
    objectInformationData[0].yourCompanyMenuImage = yourCompanyMenuImage;
    objectInformationData[0].mProductfreightId = mProductfreightId;
    objectInformationData[0].isdiscountlineamt = isdiscountlineamt;
    objectInformationData[0].cBpartnercashtrxId = cBpartnercashtrxId;
    objectInformationData[0].mPricelistId = mPricelistId;
    objectInformationData[0].cUomTimeId = cUomTimeId;
    objectInformationData[0].cUomLengthId = cUomLengthId;
    objectInformationData[0].cUomWeightId = cUomWeightId;
    objectInformationData[0].groupacctinvlines = groupacctinvlines;
    objectInformationData[0].cCalendarId = cCalendarId;
    objectInformationData[0].cAcctschema1Id = cAcctschema1Id;
    objectInformationData[0].acct2Active = acct2Active;
    objectInformationData[0].cAcctschema2Id = cAcctschema2Id;
    objectInformationData[0].acct3Active = acct3Active;
    objectInformationData[0].cAcctschema3Id = cAcctschema3Id;
    objectInformationData[0].isactive = isactive;
    objectInformationData[0].adOrgId = adOrgId;
    objectInformationData[0].cUomVolumeId = cUomVolumeId;
    objectInformationData[0].language = "";
    return objectInformationData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1989_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef1987_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
      "        UPDATE AD_ClientInfo" +
      "        SET AD_Client_ID = (?) , AD_Tree_Org_ID = (?) , AD_Tree_Menu_ID = (?) , AD_Tree_BPartner_ID = (?) , AD_Tree_Product_ID = (?) , AD_Tree_Project_ID = (?) , AD_Tree_SalesRegion_ID = (?) , AllowNegativeStock = (?) , Checkinoutorg = (?) , Checkorderorg = (?) , Your_Company_Big_Image = (?) , Your_Company_Document_Image = (?) , Your_Company_Menu_Image = (?) , M_ProductFreight_ID = (?) , IsDiscountLineAmt = (?) , C_BPartnerCashTrx_ID = (?) , M_PriceList_ID = (?) , C_UOM_Time_ID = (?) , C_UOM_Length_ID = (?) , C_UOM_Weight_ID = (?) , Groupacctinvlines = (?) , C_Calendar_ID = (?) , C_AcctSchema1_ID = (?) , Acct2_Active = (?) , C_AcctSchema2_ID = (?) , Acct3_Active = (?) , C_AcctSchema3_ID = (?) , IsActive = (?) , AD_Org_ID = (?) , C_UOM_Volume_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_ClientInfo.AD_Client_ID = ? " +
      "        AND AD_ClientInfo.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_ClientInfo.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeMenuId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allownegativestock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, checkinoutorg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, checkorderorg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yourCompanyBigImage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yourCompanyDocumentImage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yourCompanyMenuImage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductfreightId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountlineamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnercashtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomTimeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomLengthId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomWeightId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupacctinvlines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendarId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschema1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acct2Active);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschema2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acct3Active);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschema3Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomVolumeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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
      "        INSERT INTO AD_ClientInfo " +
      "        (AD_Client_ID, AD_Tree_Org_ID, AD_Tree_Menu_ID, AD_Tree_BPartner_ID, AD_Tree_Product_ID, AD_Tree_Project_ID, AD_Tree_SalesRegion_ID, AllowNegativeStock, Checkinoutorg, Checkorderorg, Your_Company_Big_Image, Your_Company_Document_Image, Your_Company_Menu_Image, M_ProductFreight_ID, IsDiscountLineAmt, C_BPartnerCashTrx_ID, M_PriceList_ID, C_UOM_Time_ID, C_UOM_Length_ID, C_UOM_Weight_ID, Groupacctinvlines, C_Calendar_ID, C_AcctSchema1_ID, Acct2_Active, C_AcctSchema2_ID, Acct3_Active, C_AcctSchema3_ID, IsActive, AD_Org_ID, C_UOM_Volume_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeMenuId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allownegativestock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, checkinoutorg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, checkorderorg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yourCompanyBigImage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yourCompanyDocumentImage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yourCompanyMenuImage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductfreightId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountlineamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnercashtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomTimeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomLengthId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomWeightId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupacctinvlines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendarId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschema1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acct2Active);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschema2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acct3Active);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschema3Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomVolumeId);
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
      "        DELETE FROM AD_ClientInfo" +
      "        WHERE AD_ClientInfo.AD_Client_ID = ? " +
      "        AND AD_ClientInfo.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_ClientInfo.AD_Org_ID IN (";
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
      "        DELETE FROM AD_ClientInfo" +
      "        WHERE AD_ClientInfo.AD_Client_ID = ? ";

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
      "          FROM AD_ClientInfo" +
      "         WHERE AD_ClientInfo.AD_Client_ID = ? ";

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
      "          FROM AD_ClientInfo" +
      "         WHERE AD_ClientInfo.AD_Client_ID = ? ";

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
