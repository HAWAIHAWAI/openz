//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Settlement;

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
class SettlementData implements FieldProvider {
static Logger log4j = Logger.getLogger(SettlementData.class);
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
  public String documentno;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String settlementtype;
  public String settlementtyper;
  public String datetrx;
  public String dateacct;
  public String description;
  public String cActivityId;
  public String cActivityIdr;
  public String cancelednotchargeamt;
  public String generatedamt;
  public String chargedamt;
  public String createfrom;
  public String processed;
  public String processedBtn;
  public String posted;
  public String postedBtn;
  public String settlementopen;
  public String isactive;
  public String processing;
  public String cProjectId;
  public String cCampaignId;
  public String user2Id;
  public String user1Id;
  public String cSettlementId;
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
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("settlementtype"))
      return settlementtype;
    else if (fieldName.equalsIgnoreCase("settlementtyper"))
      return settlementtyper;
    else if (fieldName.equalsIgnoreCase("datetrx"))
      return datetrx;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("c_activity_idr") || fieldName.equals("cActivityIdr"))
      return cActivityIdr;
    else if (fieldName.equalsIgnoreCase("cancelednotchargeamt"))
      return cancelednotchargeamt;
    else if (fieldName.equalsIgnoreCase("generatedamt"))
      return generatedamt;
    else if (fieldName.equalsIgnoreCase("chargedamt"))
      return chargedamt;
    else if (fieldName.equalsIgnoreCase("createfrom"))
      return createfrom;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("processed_btn") || fieldName.equals("processedBtn"))
      return processedBtn;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("posted_btn") || fieldName.equals("postedBtn"))
      return postedBtn;
    else if (fieldName.equalsIgnoreCase("settlementopen"))
      return settlementopen;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("c_settlement_id") || fieldName.equals("cSettlementId"))
      return cSettlementId;
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
  public static SettlementData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static SettlementData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Settlement.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Settlement.CreatedBy) as CreatedByR, " +
      "        to_char(C_Settlement.Updated, ?) as updated, " +
      "        to_char(C_Settlement.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Settlement.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Settlement.UpdatedBy) as UpdatedByR," +
      "        C_Settlement.AD_Client_ID, " +
      "(CASE WHEN C_Settlement.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_Settlement.AD_Org_ID, " +
      "(CASE WHEN C_Settlement.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Settlement.DocumentNo, " +
      "C_Settlement.C_Currency_ID, " +
      "(CASE WHEN C_Settlement.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "C_Settlement.C_DocType_ID, " +
      "(CASE WHEN C_Settlement.C_DocType_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_DocType_IDR, " +
      "C_Settlement.Settlementtype, " +
      "(CASE WHEN C_Settlement.Settlementtype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS SettlementtypeR, " +
      "C_Settlement.DateTrx, " +
      "C_Settlement.DateAcct, " +
      "C_Settlement.Description, " +
      "C_Settlement.C_Activity_ID, " +
      "(CASE WHEN C_Settlement.C_Activity_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Activity_IDR, " +
      "C_Settlement.Cancelednotchargeamt, " +
      "C_Settlement.Generatedamt, " +
      "C_Settlement.Chargedamt, " +
      "C_Settlement.CreateFrom, " +
      "C_Settlement.Processed, " +
      "list2.name as Processed_BTN, " +
      "C_Settlement.Posted, " +
      "list3.name as Posted_BTN, " +
      "C_Settlement.SettlementOpen, " +
      "COALESCE(C_Settlement.IsActive, 'N') AS IsActive, " +
      "COALESCE(C_Settlement.Processing, 'N') AS Processing, " +
      "C_Settlement.C_Project_ID, " +
      "C_Settlement.C_Campaign_ID, " +
      "C_Settlement.User2_ID, " +
      "C_Settlement.User1_ID, " +
      "C_Settlement.C_Settlement_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Settlement left join (select AD_Client_ID, Name from AD_Client) table1 on (C_Settlement.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_Settlement.AD_Org_ID = table2.AD_Org_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table3 on (C_Settlement.C_Currency_ID = table3.C_Currency_ID) left join (select C_DocType_ID, Name from C_DocType) table4 on (C_Settlement.C_DocType_ID = table4.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL4 on (table4.C_DocType_ID = tableTRL4.C_DocType_ID and tableTRL4.AD_Language = ?)  left join ad_ref_list_v list1 on (C_Settlement.Settlementtype = list1.value and list1.ad_reference_id = '800010' and list1.ad_language = ?)  left join (select C_Activity_ID, Name from C_Activity) table5 on (C_Settlement.C_Activity_ID = table5.C_Activity_ID) left join ad_ref_list_v list2 on (list2.ad_reference_id = '800024' and list2.ad_language = ?  AND C_Settlement.Processed = TO_CHAR(list2.value)) left join ad_ref_list_v list3 on (list3.ad_reference_id = '234' and list3.ad_language = ?  AND C_Settlement.Posted = TO_CHAR(list3.value))" +
      "        WHERE 2=2 " +
      " AND C_Settlement.settlementtype<>'I'" +
      "        AND 1=1 " +
      "        AND C_Settlement.C_Settlement_ID = ? " +
      "        AND C_Settlement.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Settlement.AD_Org_ID IN (";
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
        SettlementData objectSettlementData = new SettlementData();
        objectSettlementData.created = UtilSql.getValue(result, "created");
        objectSettlementData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSettlementData.updated = UtilSql.getValue(result, "updated");
        objectSettlementData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSettlementData.updatedby = UtilSql.getValue(result, "updatedby");
        objectSettlementData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSettlementData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSettlementData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectSettlementData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSettlementData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectSettlementData.documentno = UtilSql.getValue(result, "documentno");
        objectSettlementData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectSettlementData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectSettlementData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectSettlementData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectSettlementData.settlementtype = UtilSql.getValue(result, "settlementtype");
        objectSettlementData.settlementtyper = UtilSql.getValue(result, "settlementtyper");
        objectSettlementData.datetrx = UtilSql.getDateValue(result, "datetrx", "dd-MM-yyyy");
        objectSettlementData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectSettlementData.description = UtilSql.getValue(result, "description");
        objectSettlementData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectSettlementData.cActivityIdr = UtilSql.getValue(result, "c_activity_idr");
        objectSettlementData.cancelednotchargeamt = UtilSql.getValue(result, "cancelednotchargeamt");
        objectSettlementData.generatedamt = UtilSql.getValue(result, "generatedamt");
        objectSettlementData.chargedamt = UtilSql.getValue(result, "chargedamt");
        objectSettlementData.createfrom = UtilSql.getValue(result, "createfrom");
        objectSettlementData.processed = UtilSql.getValue(result, "processed");
        objectSettlementData.processedBtn = UtilSql.getValue(result, "processed_btn");
        objectSettlementData.posted = UtilSql.getValue(result, "posted");
        objectSettlementData.postedBtn = UtilSql.getValue(result, "posted_btn");
        objectSettlementData.settlementopen = UtilSql.getValue(result, "settlementopen");
        objectSettlementData.isactive = UtilSql.getValue(result, "isactive");
        objectSettlementData.processing = UtilSql.getValue(result, "processing");
        objectSettlementData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectSettlementData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectSettlementData.user2Id = UtilSql.getValue(result, "user2_id");
        objectSettlementData.user1Id = UtilSql.getValue(result, "user1_id");
        objectSettlementData.cSettlementId = UtilSql.getValue(result, "c_settlement_id");
        objectSettlementData.language = UtilSql.getValue(result, "language");
        objectSettlementData.adUserClient = "";
        objectSettlementData.adOrgClient = "";
        objectSettlementData.createdby = "";
        objectSettlementData.trBgcolor = "";
        objectSettlementData.totalCount = "";
        objectSettlementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSettlementData);
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
    SettlementData objectSettlementData[] = new SettlementData[vector.size()];
    vector.copyInto(objectSettlementData);
    return(objectSettlementData);
  }

/**
Create a registry
 */
  public static SettlementData[] set(String cSettlementId, String settlementopen, String createdby, String createdbyr, String cDoctypeId, String documentno, String user1Id, String cCampaignId, String cProjectId, String cActivityId, String createfrom, String chargedamt, String description, String adClientId, String processing, String cancelednotchargeamt, String generatedamt, String user2Id, String settlementtype, String updatedby, String updatedbyr, String processed, String processedBtn, String adOrgId, String cCurrencyId, String isactive, String datetrx, String posted, String postedBtn, String dateacct)    throws ServletException {
    SettlementData objectSettlementData[] = new SettlementData[1];
    objectSettlementData[0] = new SettlementData();
    objectSettlementData[0].created = "";
    objectSettlementData[0].createdbyr = createdbyr;
    objectSettlementData[0].updated = "";
    objectSettlementData[0].updatedTimeStamp = "";
    objectSettlementData[0].updatedby = updatedby;
    objectSettlementData[0].updatedbyr = updatedbyr;
    objectSettlementData[0].adClientId = adClientId;
    objectSettlementData[0].adClientIdr = "";
    objectSettlementData[0].adOrgId = adOrgId;
    objectSettlementData[0].adOrgIdr = "";
    objectSettlementData[0].documentno = documentno;
    objectSettlementData[0].cCurrencyId = cCurrencyId;
    objectSettlementData[0].cCurrencyIdr = "";
    objectSettlementData[0].cDoctypeId = cDoctypeId;
    objectSettlementData[0].cDoctypeIdr = "";
    objectSettlementData[0].settlementtype = settlementtype;
    objectSettlementData[0].settlementtyper = "";
    objectSettlementData[0].datetrx = datetrx;
    objectSettlementData[0].dateacct = dateacct;
    objectSettlementData[0].description = description;
    objectSettlementData[0].cActivityId = cActivityId;
    objectSettlementData[0].cActivityIdr = "";
    objectSettlementData[0].cancelednotchargeamt = cancelednotchargeamt;
    objectSettlementData[0].generatedamt = generatedamt;
    objectSettlementData[0].chargedamt = chargedamt;
    objectSettlementData[0].createfrom = createfrom;
    objectSettlementData[0].processed = processed;
    objectSettlementData[0].processedBtn = processedBtn;
    objectSettlementData[0].posted = posted;
    objectSettlementData[0].postedBtn = postedBtn;
    objectSettlementData[0].settlementopen = settlementopen;
    objectSettlementData[0].isactive = isactive;
    objectSettlementData[0].processing = processing;
    objectSettlementData[0].cProjectId = cProjectId;
    objectSettlementData[0].cCampaignId = cCampaignId;
    objectSettlementData[0].user2Id = user2Id;
    objectSettlementData[0].user1Id = user1Id;
    objectSettlementData[0].cSettlementId = cSettlementId;
    objectSettlementData[0].language = "";
    return objectSettlementData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef800330_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef800332_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
      "        UPDATE C_Settlement" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , DocumentNo = (?) , C_Currency_ID = (?) , C_DocType_ID = (?) , Settlementtype = (?) , DateTrx = TO_DATE(?) , DateAcct = TO_DATE(?) , Description = (?) , C_Activity_ID = (?) , Cancelednotchargeamt = TO_NUMBER(?) , Generatedamt = TO_NUMBER(?) , Chargedamt = TO_NUMBER(?) , CreateFrom = (?) , Processed = (?) , Posted = (?) , SettlementOpen = (?) , IsActive = (?) , Processing = (?) , C_Project_ID = (?) , C_Campaign_ID = (?) , User2_ID = (?) , User1_ID = (?) , C_Settlement_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Settlement.C_Settlement_ID = ? " +
      "        AND C_Settlement.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Settlement.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, settlementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datetrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancelednotchargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, settlementopen);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);
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
      "        INSERT INTO C_Settlement " +
      "        (AD_Client_ID, AD_Org_ID, DocumentNo, C_Currency_ID, C_DocType_ID, Settlementtype, DateTrx, DateAcct, Description, C_Activity_ID, Cancelednotchargeamt, Generatedamt, Chargedamt, CreateFrom, Processed, Posted, SettlementOpen, IsActive, Processing, C_Project_ID, C_Campaign_ID, User2_ID, User1_ID, C_Settlement_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, settlementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datetrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancelednotchargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, settlementopen);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);
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
      "        DELETE FROM C_Settlement" +
      "        WHERE C_Settlement.C_Settlement_ID = ? " +
      "        AND C_Settlement.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Settlement.AD_Org_ID IN (";
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
      "        DELETE FROM C_Settlement" +
      "        WHERE C_Settlement.C_Settlement_ID = ? ";

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
      "          FROM C_Settlement" +
      "         WHERE C_Settlement.C_Settlement_ID = ? ";

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
      "          FROM C_Settlement" +
      "         WHERE C_Settlement.C_Settlement_ID = ? ";

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
