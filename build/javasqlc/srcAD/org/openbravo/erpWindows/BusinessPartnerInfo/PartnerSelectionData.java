//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.BusinessPartnerInfo;

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
class PartnerSelectionData implements FieldProvider {
static Logger log4j = Logger.getLogger(PartnerSelectionData.class);
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
  public String isactive;
  public String value;
  public String name;
  public String cBpGroupId;
  public String cBpGroupIdr;
  public String salesrepId;
  public String salesrepIdr;
  public String paymentrule;
  public String paymentruler;
  public String cPaymenttermId;
  public String cPaymenttermIdr;
  public String mPricelistId;
  public String mPricelistIdr;
  public String paymentrulepo;
  public String paymentrulepor;
  public String poPaymenttermId;
  public String poPaymenttermIdr;
  public String poPricelistId;
  public String poPricelistIdr;
  public String iscustomer;
  public String isvendor;
  public String isemployee;
  public String issalesrep;
  public String cBpartnerId;
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
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("c_bp_group_id") || fieldName.equals("cBpGroupId"))
      return cBpGroupId;
    else if (fieldName.equalsIgnoreCase("c_bp_group_idr") || fieldName.equals("cBpGroupIdr"))
      return cBpGroupIdr;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("paymentruler"))
      return paymentruler;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_idr") || fieldName.equals("cPaymenttermIdr"))
      return cPaymenttermIdr;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_idr") || fieldName.equals("mPricelistIdr"))
      return mPricelistIdr;
    else if (fieldName.equalsIgnoreCase("paymentrulepo"))
      return paymentrulepo;
    else if (fieldName.equalsIgnoreCase("paymentrulepor"))
      return paymentrulepor;
    else if (fieldName.equalsIgnoreCase("po_paymentterm_id") || fieldName.equals("poPaymenttermId"))
      return poPaymenttermId;
    else if (fieldName.equalsIgnoreCase("po_paymentterm_idr") || fieldName.equals("poPaymenttermIdr"))
      return poPaymenttermIdr;
    else if (fieldName.equalsIgnoreCase("po_pricelist_id") || fieldName.equals("poPricelistId"))
      return poPricelistId;
    else if (fieldName.equalsIgnoreCase("po_pricelist_idr") || fieldName.equals("poPricelistIdr"))
      return poPricelistIdr;
    else if (fieldName.equalsIgnoreCase("iscustomer"))
      return iscustomer;
    else if (fieldName.equalsIgnoreCase("isvendor"))
      return isvendor;
    else if (fieldName.equalsIgnoreCase("isemployee"))
      return isemployee;
    else if (fieldName.equalsIgnoreCase("issalesrep"))
      return issalesrep;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
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
  public static PartnerSelectionData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PartnerSelectionData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_BPartner.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_BPartner.CreatedBy) as CreatedByR, " +
      "        to_char(C_BPartner.Updated, ?) as updated, " +
      "        to_char(C_BPartner.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_BPartner.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_BPartner.UpdatedBy) as UpdatedByR," +
      "        C_BPartner.AD_Client_ID, " +
      "(CASE WHEN C_BPartner.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_BPartner.AD_Org_ID, " +
      "(CASE WHEN C_BPartner.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(C_BPartner.IsActive, 'N') AS IsActive, " +
      "C_BPartner.Value, " +
      "C_BPartner.Name, " +
      "C_BPartner.C_BP_Group_ID, " +
      "(CASE WHEN C_BPartner.C_BP_Group_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_BP_Group_IDR, " +
      "C_BPartner.SalesRep_ID, " +
      "(CASE WHEN C_BPartner.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "C_BPartner.PaymentRule, " +
      "(CASE WHEN C_BPartner.PaymentRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS PaymentRuleR, " +
      "C_BPartner.C_PaymentTerm_ID, " +
      "(CASE WHEN C_BPartner.C_PaymentTerm_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS C_PaymentTerm_IDR, " +
      "C_BPartner.M_PriceList_ID, " +
      "(CASE WHEN C_BPartner.M_PriceList_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS M_PriceList_IDR, " +
      "C_BPartner.PaymentRulePO, " +
      "(CASE WHEN C_BPartner.PaymentRulePO IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS PaymentRulePOR, " +
      "C_BPartner.PO_PaymentTerm_ID, " +
      "(CASE WHEN C_BPartner.PO_PaymentTerm_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL7.Name IS NULL THEN TO_CHAR(table7.Name) ELSE TO_CHAR(tableTRL7.Name) END)), ''))),'') ) END) AS PO_PaymentTerm_IDR, " +
      "C_BPartner.PO_PriceList_ID, " +
      "(CASE WHEN C_BPartner.PO_PriceList_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS PO_PriceList_IDR, " +
      "COALESCE(C_BPartner.IsCustomer, 'N') AS IsCustomer, " +
      "COALESCE(C_BPartner.IsVendor, 'N') AS IsVendor, " +
      "COALESCE(C_BPartner.IsEmployee, 'N') AS IsEmployee, " +
      "COALESCE(C_BPartner.IsSalesRep, 'N') AS IsSalesRep, " +
      "C_BPartner.C_BPartner_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_BPartner left join (select AD_Client_ID, Name from AD_Client) table1 on (C_BPartner.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_BPartner.AD_Org_ID = table2.AD_Org_ID) left join (select C_BP_Group_ID, Name from C_BP_Group) table3 on (C_BPartner.C_BP_Group_ID = table3.C_BP_Group_ID) left join (select C_BPartner_ID, Name from C_BPartner) table4 on (C_BPartner.SalesRep_ID =  table4.C_BPartner_ID) left join ad_ref_list_v list1 on (C_BPartner.PaymentRule = list1.value and list1.ad_reference_id = '195' and list1.ad_language = ?)  left join (select C_PaymentTerm_ID, Name from C_PaymentTerm) table5 on (C_BPartner.C_PaymentTerm_ID = table5.C_PaymentTerm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL5 on (table5.C_PaymentTerm_ID = tableTRL5.C_PaymentTerm_ID and tableTRL5.AD_Language = ?)  left join (select M_PriceList_ID, Name from M_PriceList) table6 on (C_BPartner.M_PriceList_ID =  table6.M_PriceList_ID) left join ad_ref_list_v list2 on (C_BPartner.PaymentRulePO = list2.value and list2.ad_reference_id = '195' and list2.ad_language = ?)  left join (select C_PaymentTerm_ID, Name from C_PaymentTerm) table7 on (C_BPartner.PO_PaymentTerm_ID =  table7.C_PaymentTerm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL7 on (table7.C_PaymentTerm_ID = tableTRL7.C_PaymentTerm_ID and tableTRL7.AD_Language = ?)  left join (select M_PriceList_ID, Name from M_PriceList) table8 on (C_BPartner.PO_PriceList_ID =  table8.M_PriceList_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_BPartner.C_BPartner_ID = ? " +
      "        AND C_BPartner.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_BPartner.AD_Org_ID IN (";
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
        PartnerSelectionData objectPartnerSelectionData = new PartnerSelectionData();
        objectPartnerSelectionData.created = UtilSql.getValue(result, "created");
        objectPartnerSelectionData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPartnerSelectionData.updated = UtilSql.getValue(result, "updated");
        objectPartnerSelectionData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPartnerSelectionData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPartnerSelectionData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPartnerSelectionData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPartnerSelectionData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectPartnerSelectionData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPartnerSelectionData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPartnerSelectionData.isactive = UtilSql.getValue(result, "isactive");
        objectPartnerSelectionData.value = UtilSql.getValue(result, "value");
        objectPartnerSelectionData.name = UtilSql.getValue(result, "name");
        objectPartnerSelectionData.cBpGroupId = UtilSql.getValue(result, "c_bp_group_id");
        objectPartnerSelectionData.cBpGroupIdr = UtilSql.getValue(result, "c_bp_group_idr");
        objectPartnerSelectionData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectPartnerSelectionData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectPartnerSelectionData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectPartnerSelectionData.paymentruler = UtilSql.getValue(result, "paymentruler");
        objectPartnerSelectionData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectPartnerSelectionData.cPaymenttermIdr = UtilSql.getValue(result, "c_paymentterm_idr");
        objectPartnerSelectionData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectPartnerSelectionData.mPricelistIdr = UtilSql.getValue(result, "m_pricelist_idr");
        objectPartnerSelectionData.paymentrulepo = UtilSql.getValue(result, "paymentrulepo");
        objectPartnerSelectionData.paymentrulepor = UtilSql.getValue(result, "paymentrulepor");
        objectPartnerSelectionData.poPaymenttermId = UtilSql.getValue(result, "po_paymentterm_id");
        objectPartnerSelectionData.poPaymenttermIdr = UtilSql.getValue(result, "po_paymentterm_idr");
        objectPartnerSelectionData.poPricelistId = UtilSql.getValue(result, "po_pricelist_id");
        objectPartnerSelectionData.poPricelistIdr = UtilSql.getValue(result, "po_pricelist_idr");
        objectPartnerSelectionData.iscustomer = UtilSql.getValue(result, "iscustomer");
        objectPartnerSelectionData.isvendor = UtilSql.getValue(result, "isvendor");
        objectPartnerSelectionData.isemployee = UtilSql.getValue(result, "isemployee");
        objectPartnerSelectionData.issalesrep = UtilSql.getValue(result, "issalesrep");
        objectPartnerSelectionData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectPartnerSelectionData.language = UtilSql.getValue(result, "language");
        objectPartnerSelectionData.adUserClient = "";
        objectPartnerSelectionData.adOrgClient = "";
        objectPartnerSelectionData.createdby = "";
        objectPartnerSelectionData.trBgcolor = "";
        objectPartnerSelectionData.totalCount = "";
        objectPartnerSelectionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPartnerSelectionData);
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
    PartnerSelectionData objectPartnerSelectionData[] = new PartnerSelectionData[vector.size()];
    vector.copyInto(objectPartnerSelectionData);
    return(objectPartnerSelectionData);
  }

/**
Create a registry
 */
  public static PartnerSelectionData[] set(String poPricelistId, String iscustomer, String value, String isemployee, String adOrgId, String cPaymenttermId, String paymentrulepo, String name, String isactive, String cBpartnerId, String isvendor, String createdby, String createdbyr, String salesrepId, String poPaymenttermId, String cBpGroupId, String paymentrule, String updatedby, String updatedbyr, String issalesrep, String adClientId, String mPricelistId)    throws ServletException {
    PartnerSelectionData objectPartnerSelectionData[] = new PartnerSelectionData[1];
    objectPartnerSelectionData[0] = new PartnerSelectionData();
    objectPartnerSelectionData[0].created = "";
    objectPartnerSelectionData[0].createdbyr = createdbyr;
    objectPartnerSelectionData[0].updated = "";
    objectPartnerSelectionData[0].updatedTimeStamp = "";
    objectPartnerSelectionData[0].updatedby = updatedby;
    objectPartnerSelectionData[0].updatedbyr = updatedbyr;
    objectPartnerSelectionData[0].adClientId = adClientId;
    objectPartnerSelectionData[0].adClientIdr = "";
    objectPartnerSelectionData[0].adOrgId = adOrgId;
    objectPartnerSelectionData[0].adOrgIdr = "";
    objectPartnerSelectionData[0].isactive = isactive;
    objectPartnerSelectionData[0].value = value;
    objectPartnerSelectionData[0].name = name;
    objectPartnerSelectionData[0].cBpGroupId = cBpGroupId;
    objectPartnerSelectionData[0].cBpGroupIdr = "";
    objectPartnerSelectionData[0].salesrepId = salesrepId;
    objectPartnerSelectionData[0].salesrepIdr = "";
    objectPartnerSelectionData[0].paymentrule = paymentrule;
    objectPartnerSelectionData[0].paymentruler = "";
    objectPartnerSelectionData[0].cPaymenttermId = cPaymenttermId;
    objectPartnerSelectionData[0].cPaymenttermIdr = "";
    objectPartnerSelectionData[0].mPricelistId = mPricelistId;
    objectPartnerSelectionData[0].mPricelistIdr = "";
    objectPartnerSelectionData[0].paymentrulepo = paymentrulepo;
    objectPartnerSelectionData[0].paymentrulepor = "";
    objectPartnerSelectionData[0].poPaymenttermId = poPaymenttermId;
    objectPartnerSelectionData[0].poPaymenttermIdr = "";
    objectPartnerSelectionData[0].poPricelistId = poPricelistId;
    objectPartnerSelectionData[0].poPricelistIdr = "";
    objectPartnerSelectionData[0].iscustomer = iscustomer;
    objectPartnerSelectionData[0].isvendor = isvendor;
    objectPartnerSelectionData[0].isemployee = isemployee;
    objectPartnerSelectionData[0].issalesrep = issalesrep;
    objectPartnerSelectionData[0].cBpartnerId = cBpartnerId;
    objectPartnerSelectionData[0].language = "";
    return objectPartnerSelectionData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2901(ConnectionProvider connectionProvider, String AD_ORG_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zssi_getNewBPartnerValue(?) ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_ORG_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zssi_getnewbpartnervalue");
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
  public static String selectDef2898_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef2900_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
      "        UPDATE C_BPartner" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , IsActive = (?) , Value = (?) , Name = (?) , C_BP_Group_ID = (?) , SalesRep_ID = (?) , PaymentRule = (?) , C_PaymentTerm_ID = (?) , M_PriceList_ID = (?) , PaymentRulePO = (?) , PO_PaymentTerm_ID = (?) , PO_PriceList_ID = (?) , IsCustomer = (?) , IsVendor = (?) , IsEmployee = (?) , IsSalesRep = (?) , C_BPartner_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_BPartner.C_BPartner_ID = ? " +
      "        AND C_BPartner.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_BPartner.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrulepo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscustomer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvendor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isemployee);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issalesrep);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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
      "        INSERT INTO C_BPartner " +
      "        (AD_Client_ID, AD_Org_ID, IsActive, Value, Name, C_BP_Group_ID, SalesRep_ID, PaymentRule, C_PaymentTerm_ID, M_PriceList_ID, PaymentRulePO, PO_PaymentTerm_ID, PO_PriceList_ID, IsCustomer, IsVendor, IsEmployee, IsSalesRep, C_BPartner_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrulepo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscustomer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvendor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isemployee);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issalesrep);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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
      "        DELETE FROM C_BPartner" +
      "        WHERE C_BPartner.C_BPartner_ID = ? " +
      "        AND C_BPartner.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_BPartner.AD_Org_ID IN (";
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
      "        DELETE FROM C_BPartner" +
      "        WHERE C_BPartner.C_BPartner_ID = ? ";

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
      "          FROM C_BPartner" +
      "         WHERE C_BPartner.C_BPartner_ID = ? ";

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
      "          FROM C_BPartner" +
      "         WHERE C_BPartner.C_BPartner_ID = ? ";

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
