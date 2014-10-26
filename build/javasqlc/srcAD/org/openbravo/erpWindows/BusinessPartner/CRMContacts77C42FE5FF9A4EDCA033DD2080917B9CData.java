//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.BusinessPartner;

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
class CRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData implements FieldProvider {
static Logger log4j = Logger.getLogger(CRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssiNotes4customerId;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String adClientId;
  public String cCampaignId;
  public String cCampaignIdr;
  public String dateofcontact;
  public String adOrgId;
  public String adUserId;
  public String adUserIdr;
  public String zssiCrmactionsId;
  public String zssiCrmactionsIdr;
  public String contactBy;
  public String contactByr;
  public String description;
  public String followup;
  public String adUseridNext;
  public String adUseridNextr;
  public String nextAction;
  public String nextActionr;
  public String followupBy;
  public String followupByr;
  public String followupDone;
  public String cProjectId;
  public String cProjectIdr;
  public String isactive;
  public String lead2sale;
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
    else if (fieldName.equalsIgnoreCase("zssi_notes4customer_id") || fieldName.equals("zssiNotes4customerId"))
      return zssiNotes4customerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_campaign_idr") || fieldName.equals("cCampaignIdr"))
      return cCampaignIdr;
    else if (fieldName.equalsIgnoreCase("dateofcontact"))
      return dateofcontact;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("zssi_crmactions_id") || fieldName.equals("zssiCrmactionsId"))
      return zssiCrmactionsId;
    else if (fieldName.equalsIgnoreCase("zssi_crmactions_idr") || fieldName.equals("zssiCrmactionsIdr"))
      return zssiCrmactionsIdr;
    else if (fieldName.equalsIgnoreCase("contact_by") || fieldName.equals("contactBy"))
      return contactBy;
    else if (fieldName.equalsIgnoreCase("contact_byr") || fieldName.equals("contactByr"))
      return contactByr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("followup"))
      return followup;
    else if (fieldName.equalsIgnoreCase("ad_userid_next") || fieldName.equals("adUseridNext"))
      return adUseridNext;
    else if (fieldName.equalsIgnoreCase("ad_userid_nextr") || fieldName.equals("adUseridNextr"))
      return adUseridNextr;
    else if (fieldName.equalsIgnoreCase("next_action") || fieldName.equals("nextAction"))
      return nextAction;
    else if (fieldName.equalsIgnoreCase("next_actionr") || fieldName.equals("nextActionr"))
      return nextActionr;
    else if (fieldName.equalsIgnoreCase("followup_by") || fieldName.equals("followupBy"))
      return followupBy;
    else if (fieldName.equalsIgnoreCase("followup_byr") || fieldName.equals("followupByr"))
      return followupByr;
    else if (fieldName.equalsIgnoreCase("followup_done") || fieldName.equals("followupDone"))
      return followupDone;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("lead2sale"))
      return lead2sale;
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
  public static CRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cBpartnerId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_notes4customer.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_notes4customer.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_notes4customer.Updated, ?) as updated, " +
      "        to_char(zssi_notes4customer.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_notes4customer.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_notes4customer.UpdatedBy) as UpdatedByR," +
      "        zssi_notes4customer.Zssi_Notes4customer_ID, " +
      "zssi_notes4customer.C_Bpartner_ID, " +
      "(CASE WHEN zssi_notes4customer.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "zssi_notes4customer.AD_Client_ID, " +
      "zssi_notes4customer.C_Campaign_ID, " +
      "(CASE WHEN zssi_notes4customer.C_Campaign_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Campaign_IDR, " +
      "zssi_notes4customer.Dateofcontact, " +
      "zssi_notes4customer.AD_Org_ID, " +
      "zssi_notes4customer.AD_User_ID, " +
      "(CASE WHEN zssi_notes4customer.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "zssi_notes4customer.Zssi_Crmactions_ID, " +
      "(CASE WHEN zssi_notes4customer.Zssi_Crmactions_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS Zssi_Crmactions_IDR, " +
      "zssi_notes4customer.contact_by, " +
      "(CASE WHEN zssi_notes4customer.contact_by IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS contact_byR, " +
      "zssi_notes4customer.Description, " +
      "zssi_notes4customer.Followup, " +
      "zssi_notes4customer.ad_userid_next, " +
      "(CASE WHEN zssi_notes4customer.ad_userid_next IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS ad_userid_nextR, " +
      "zssi_notes4customer.next_action, " +
      "(CASE WHEN zssi_notes4customer.next_action IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS next_actionR, " +
      "zssi_notes4customer.Followup_By, " +
      "(CASE WHEN zssi_notes4customer.Followup_By IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS Followup_ByR, " +
      "COALESCE(zssi_notes4customer.Followup_Done, 'N') AS Followup_Done, " +
      "zssi_notes4customer.C_Project_ID, " +
      "(CASE WHEN zssi_notes4customer.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "COALESCE(zssi_notes4customer.Isactive, 'N') AS Isactive, " +
      "COALESCE(zssi_notes4customer.Lead2sale, 'N') AS Lead2sale, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_notes4customer left join (select C_BPartner_ID, Name from C_BPartner) table1 on (zssi_notes4customer.C_Bpartner_ID = table1.C_BPartner_ID) left join (select C_Campaign_ID, Name from C_Campaign) table2 on (zssi_notes4customer.C_Campaign_ID = table2.C_Campaign_ID) left join (select AD_User_ID, Name from AD_User) table3 on (zssi_notes4customer.AD_User_ID = table3.AD_User_ID) left join (select Zssi_Crmactions_ID, Name from Zssi_Crmactions) table4 on (zssi_notes4customer.Zssi_Crmactions_ID = table4.Zssi_Crmactions_ID) left join (select AD_User_ID, Name from AD_User) table5 on (zssi_notes4customer.contact_by =  table5.AD_User_ID) left join (select AD_User_ID, Name from AD_User) table6 on (zssi_notes4customer.ad_userid_next =  table6.AD_User_ID) left join (select Zssi_Crmactions_ID, Name from zssi_crmactions) table7 on (zssi_notes4customer.next_action =  table7.Zssi_Crmactions_ID) left join (select AD_User_ID, Name from AD_User) table8 on (zssi_notes4customer.Followup_By =  table8.AD_User_ID) left join (select C_Project_ID, Value, Name from C_Project) table9 on (zssi_notes4customer.C_Project_ID = table9.C_Project_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND zssi_notes4customer.C_Bpartner_ID = ?  ");
    strSql = strSql + 
      "        AND zssi_notes4customer.Zssi_Notes4customer_ID = ? " +
      "        AND zssi_notes4customer.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_notes4customer.AD_Org_ID IN (";
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
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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
        CRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData = new CRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData();
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.created = UtilSql.getValue(result, "created");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.updated = UtilSql.getValue(result, "updated");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.updatedby = UtilSql.getValue(result, "updatedby");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.zssiNotes4customerId = UtilSql.getValue(result, "zssi_notes4customer_id");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.cCampaignIdr = UtilSql.getValue(result, "c_campaign_idr");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.dateofcontact = UtilSql.getDateValue(result, "dateofcontact", "dd-MM-yyyy");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.zssiCrmactionsId = UtilSql.getValue(result, "zssi_crmactions_id");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.zssiCrmactionsIdr = UtilSql.getValue(result, "zssi_crmactions_idr");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.contactBy = UtilSql.getValue(result, "contact_by");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.contactByr = UtilSql.getValue(result, "contact_byr");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.description = UtilSql.getValue(result, "description");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.followup = UtilSql.getDateValue(result, "followup", "dd-MM-yyyy");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.adUseridNext = UtilSql.getValue(result, "ad_userid_next");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.adUseridNextr = UtilSql.getValue(result, "ad_userid_nextr");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.nextAction = UtilSql.getValue(result, "next_action");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.nextActionr = UtilSql.getValue(result, "next_actionr");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.followupBy = UtilSql.getValue(result, "followup_by");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.followupByr = UtilSql.getValue(result, "followup_byr");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.followupDone = UtilSql.getValue(result, "followup_done");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.isactive = UtilSql.getValue(result, "isactive");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.lead2sale = UtilSql.getValue(result, "lead2sale");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.language = UtilSql.getValue(result, "language");
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.adUserClient = "";
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.adOrgClient = "";
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.createdby = "";
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.trBgcolor = "";
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.totalCount = "";
        objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData);
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
    CRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[] = new CRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[vector.size()];
    vector.copyInto(objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData);
    return(objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData);
  }

/**
Create a registry
 */
  public static CRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[] set(String cBpartnerId, String followupDone, String dateofcontact, String followupBy, String followup, String zssiCrmactionsId, String nextAction, String cCampaignId, String adUserId, String adClientId, String contactBy, String createdby, String createdbyr, String adOrgId, String isactive, String description, String cBpartnerIdr, String updatedby, String updatedbyr, String adUseridNext, String cProjectId, String cProjectIdr, String zssiNotes4customerId, String lead2sale)    throws ServletException {
    CRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[] = new CRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[1];
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0] = new CRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData();
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].created = "";
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].createdbyr = createdbyr;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].updated = "";
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].updatedTimeStamp = "";
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].updatedby = updatedby;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].updatedbyr = updatedbyr;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].zssiNotes4customerId = zssiNotes4customerId;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].cBpartnerId = cBpartnerId;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].cBpartnerIdr = cBpartnerIdr;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].adClientId = adClientId;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].cCampaignId = cCampaignId;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].cCampaignIdr = "";
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].dateofcontact = dateofcontact;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].adOrgId = adOrgId;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].adUserId = adUserId;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].adUserIdr = "";
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].zssiCrmactionsId = zssiCrmactionsId;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].zssiCrmactionsIdr = "";
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].contactBy = contactBy;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].contactByr = "";
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].description = description;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].followup = followup;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].adUseridNext = adUseridNext;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].adUseridNextr = "";
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].nextAction = nextAction;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].nextActionr = "";
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].followupBy = followupBy;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].followupByr = "";
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].followupDone = followupDone;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].cProjectId = cProjectId;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].cProjectIdr = cProjectIdr;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].isactive = isactive;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].lead2sale = lead2sale;
    objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData[0].language = "";
    return objectCRMContacts77C42FE5FF9A4EDCA033DD2080917B9CData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef027988BE880041498D8D3441B0F4F3FA_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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

/**
Select for auxiliar field
 */
  public static String selectDefAB516DC86946451F975C54FDB5014BD7_1(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_Bpartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Bpartner_IDR);

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
  public static String selectDef96D7DD23E49D4DD0B8850D1D3D728EC1_2(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef8839480EA6724E17880A8E7EBCD83D3E_3(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as C_Project_ID FROM C_Project table1 WHERE table1.isActive='Y' AND table1.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_project_id");
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
      "        SELECT zssi_notes4customer.C_Bpartner_ID AS NAME" +
      "        FROM zssi_notes4customer" +
      "        WHERE zssi_notes4customer.Zssi_Notes4customer_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BPartner left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BPartner.C_Bpartner_ID = table1.C_BPartner_ID) WHERE C_BPartner.C_Bpartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BPartner left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BPartner.C_Bpartner_ID = table1.C_BPartner_ID) WHERE C_BPartner.C_Bpartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
      "        UPDATE zssi_notes4customer" +
      "        SET Zssi_Notes4customer_ID = (?) , C_Bpartner_ID = (?) , AD_Client_ID = (?) , C_Campaign_ID = (?) , Dateofcontact = TO_DATE(?) , AD_Org_ID = (?) , AD_User_ID = (?) , Zssi_Crmactions_ID = (?) , contact_by = (?) , Description = (?) , Followup = TO_DATE(?) , ad_userid_next = (?) , next_action = (?) , Followup_By = (?) , Followup_Done = (?) , C_Project_ID = (?) , Isactive = (?) , Lead2sale = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_notes4customer.Zssi_Notes4customer_ID = ? " +
      "                 AND zssi_notes4customer.C_Bpartner_ID = ? " +
      "        AND zssi_notes4customer.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_notes4customer.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiNotes4customerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateofcontact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiCrmactionsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contactBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, followup);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUseridNext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nextAction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, followupBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, followupDone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lead2sale);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiNotes4customerId);
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
      "        INSERT INTO zssi_notes4customer " +
      "        (Zssi_Notes4customer_ID, C_Bpartner_ID, AD_Client_ID, C_Campaign_ID, Dateofcontact, AD_Org_ID, AD_User_ID, Zssi_Crmactions_ID, contact_by, Description, Followup, ad_userid_next, next_action, Followup_By, Followup_Done, C_Project_ID, Isactive, Lead2sale, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiNotes4customerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateofcontact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiCrmactionsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contactBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, followup);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUseridNext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nextAction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, followupBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, followupDone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lead2sale);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cBpartnerId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_notes4customer" +
      "        WHERE zssi_notes4customer.Zssi_Notes4customer_ID = ? " +
      "                 AND zssi_notes4customer.C_Bpartner_ID = ? " +
      "        AND zssi_notes4customer.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_notes4customer.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_notes4customer" +
      "        WHERE zssi_notes4customer.Zssi_Notes4customer_ID = ? " +
      "                 AND zssi_notes4customer.C_Bpartner_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
      "          FROM zssi_notes4customer" +
      "         WHERE zssi_notes4customer.Zssi_Notes4customer_ID = ? ";

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
      "          FROM zssi_notes4customer" +
      "         WHERE zssi_notes4customer.Zssi_Notes4customer_ID = ? ";

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
