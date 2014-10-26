//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Organization;

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
class ConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData implements FieldProvider {
static Logger log4j = Logger.getLogger(ConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cOrgconfigurationId;
  public String adOrgId;
  public String adOrgIdr;
  public String adClientId;
  public String adClientIdr;
  public String isstandard;
  public String deliveryofservices;
  public String isactive;
  public String activatepobpartnerpreselection;
  public String datevonlycreditdebit;
  public String automaterial2project;
  public String activateinternalconsumptionauto;
  public String createprojectfromso;
  public String generatestdtaskfromso;
  public String closeprojectfromso;
  public String bringbackmorematerialthanreceived;
  public String synchronizeworkstepboms;
  public String projectonlyapprovedproducts;
  public String projectgetmatontaskstart;
  public String datevexportprojasset;
  public String projectmatpanautowhengetmat;
  public String reinvoiceprojectexpenses;
  public String autoprojectvaluesequence;
  public String projectvaluereadonly;
  public String projectmangerworkflow;
  public String poprojectworkflow;
  public String defaultpoapprovalamt;
  public String prapprovalworkflow;
  public String defaultprapprovalamt;
  public String pipurchaserdisplay;
  public String orderrequisitionrestriction;
  public String offerpropabilitynotnull;
  public String orderprojectnotnull;
  public String datepromisednotnull;
  public String activatepoinvoiceautomatically;
  public String activatereceiptautomatically;
  public String activatesoinvoiceautomatically;
  public String activateshipmentautomatically;
  public String docnoreadonly;
  public String autoproductvaluesequence;
  public String productvaluereadonly;
  public String useproductvalue2scanproducts;
  public String autoproducteansequence;
  public String autoselectlotnumber;
  public String autobpartnervaluesequence;
  public String bpartnervaluereadonly;
  public String refreshintervall;
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
    else if (fieldName.equalsIgnoreCase("c_orgconfiguration_id") || fieldName.equals("cOrgconfigurationId"))
      return cOrgconfigurationId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("isstandard"))
      return isstandard;
    else if (fieldName.equalsIgnoreCase("deliveryofservices"))
      return deliveryofservices;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("activatepobpartnerpreselection"))
      return activatepobpartnerpreselection;
    else if (fieldName.equalsIgnoreCase("datevonlycreditdebit"))
      return datevonlycreditdebit;
    else if (fieldName.equalsIgnoreCase("automaterial2project"))
      return automaterial2project;
    else if (fieldName.equalsIgnoreCase("activateinternalconsumptionauto"))
      return activateinternalconsumptionauto;
    else if (fieldName.equalsIgnoreCase("createprojectfromso"))
      return createprojectfromso;
    else if (fieldName.equalsIgnoreCase("generatestdtaskfromso"))
      return generatestdtaskfromso;
    else if (fieldName.equalsIgnoreCase("closeprojectfromso"))
      return closeprojectfromso;
    else if (fieldName.equalsIgnoreCase("bringbackmorematerialthanreceived"))
      return bringbackmorematerialthanreceived;
    else if (fieldName.equalsIgnoreCase("synchronizeworkstepboms"))
      return synchronizeworkstepboms;
    else if (fieldName.equalsIgnoreCase("projectonlyapprovedproducts"))
      return projectonlyapprovedproducts;
    else if (fieldName.equalsIgnoreCase("projectgetmatontaskstart"))
      return projectgetmatontaskstart;
    else if (fieldName.equalsIgnoreCase("datevexportprojasset"))
      return datevexportprojasset;
    else if (fieldName.equalsIgnoreCase("projectmatpanautowhengetmat"))
      return projectmatpanautowhengetmat;
    else if (fieldName.equalsIgnoreCase("reinvoiceprojectexpenses"))
      return reinvoiceprojectexpenses;
    else if (fieldName.equalsIgnoreCase("autoprojectvaluesequence"))
      return autoprojectvaluesequence;
    else if (fieldName.equalsIgnoreCase("projectvaluereadonly"))
      return projectvaluereadonly;
    else if (fieldName.equalsIgnoreCase("projectmangerworkflow"))
      return projectmangerworkflow;
    else if (fieldName.equalsIgnoreCase("poprojectworkflow"))
      return poprojectworkflow;
    else if (fieldName.equalsIgnoreCase("defaultpoapprovalamt"))
      return defaultpoapprovalamt;
    else if (fieldName.equalsIgnoreCase("prapprovalworkflow"))
      return prapprovalworkflow;
    else if (fieldName.equalsIgnoreCase("defaultprapprovalamt"))
      return defaultprapprovalamt;
    else if (fieldName.equalsIgnoreCase("pipurchaserdisplay"))
      return pipurchaserdisplay;
    else if (fieldName.equalsIgnoreCase("orderrequisitionrestriction"))
      return orderrequisitionrestriction;
    else if (fieldName.equalsIgnoreCase("offerpropabilitynotnull"))
      return offerpropabilitynotnull;
    else if (fieldName.equalsIgnoreCase("orderprojectnotnull"))
      return orderprojectnotnull;
    else if (fieldName.equalsIgnoreCase("datepromisednotnull"))
      return datepromisednotnull;
    else if (fieldName.equalsIgnoreCase("activatepoinvoiceautomatically"))
      return activatepoinvoiceautomatically;
    else if (fieldName.equalsIgnoreCase("activatereceiptautomatically"))
      return activatereceiptautomatically;
    else if (fieldName.equalsIgnoreCase("activatesoinvoiceautomatically"))
      return activatesoinvoiceautomatically;
    else if (fieldName.equalsIgnoreCase("activateshipmentautomatically"))
      return activateshipmentautomatically;
    else if (fieldName.equalsIgnoreCase("docnoreadonly"))
      return docnoreadonly;
    else if (fieldName.equalsIgnoreCase("autoproductvaluesequence"))
      return autoproductvaluesequence;
    else if (fieldName.equalsIgnoreCase("productvaluereadonly"))
      return productvaluereadonly;
    else if (fieldName.equalsIgnoreCase("useproductvalue2scanproducts"))
      return useproductvalue2scanproducts;
    else if (fieldName.equalsIgnoreCase("autoproducteansequence"))
      return autoproducteansequence;
    else if (fieldName.equalsIgnoreCase("autoselectlotnumber"))
      return autoselectlotnumber;
    else if (fieldName.equalsIgnoreCase("autobpartnervaluesequence"))
      return autobpartnervaluesequence;
    else if (fieldName.equalsIgnoreCase("bpartnervaluereadonly"))
      return bpartnervaluereadonly;
    else if (fieldName.equalsIgnoreCase("refreshintervall"))
      return refreshintervall;
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
  public static ConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String ad_org_id, String adOrgId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, ad_org_id, adOrgId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String ad_org_id, String adOrgId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_orgconfiguration.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_orgconfiguration.CreatedBy) as CreatedByR, " +
      "        to_char(c_orgconfiguration.Updated, ?) as updated, " +
      "        to_char(c_orgconfiguration.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_orgconfiguration.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_orgconfiguration.UpdatedBy) as UpdatedByR," +
      "        c_orgconfiguration.c_orgconfiguration_id, " +
      "c_orgconfiguration.AD_Org_ID, " +
      "(CASE WHEN c_orgconfiguration.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "c_orgconfiguration.AD_Client_ID, " +
      "(CASE WHEN c_orgconfiguration.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "COALESCE(c_orgconfiguration.Isstandard, 'N') AS Isstandard, " +
      "COALESCE(c_orgconfiguration.Deliveryofservices, 'N') AS Deliveryofservices, " +
      "COALESCE(c_orgconfiguration.Isactive, 'N') AS Isactive, " +
      "COALESCE(c_orgconfiguration.ActivatePOBPartnerPreselection, 'N') AS ActivatePOBPartnerPreselection, " +
      "COALESCE(c_orgconfiguration.Datevonlycreditdebit, 'N') AS Datevonlycreditdebit, " +
      "COALESCE(c_orgconfiguration.Automaterial2project, 'N') AS Automaterial2project, " +
      "COALESCE(c_orgconfiguration.Activateinternalconsumptionauto, 'N') AS Activateinternalconsumptionauto, " +
      "COALESCE(c_orgconfiguration.Createprojectfromso, 'N') AS Createprojectfromso, " +
      "COALESCE(c_orgconfiguration.Generatestdtaskfromso, 'N') AS Generatestdtaskfromso, " +
      "COALESCE(c_orgconfiguration.Closeprojectfromso, 'N') AS Closeprojectfromso, " +
      "COALESCE(c_orgconfiguration.Bringbackmorematerialthanreceived, 'N') AS Bringbackmorematerialthanreceived, " +
      "COALESCE(c_orgconfiguration.Synchronizeworkstepboms, 'N') AS Synchronizeworkstepboms, " +
      "COALESCE(c_orgconfiguration.Projectonlyapprovedproducts, 'N') AS Projectonlyapprovedproducts, " +
      "COALESCE(c_orgconfiguration.Projectgetmatontaskstart, 'N') AS Projectgetmatontaskstart, " +
      "COALESCE(c_orgconfiguration.Datevexportprojasset, 'N') AS Datevexportprojasset, " +
      "COALESCE(c_orgconfiguration.Projectmatpanautowhengetmat, 'N') AS Projectmatpanautowhengetmat, " +
      "COALESCE(c_orgconfiguration.Reinvoiceprojectexpenses, 'N') AS Reinvoiceprojectexpenses, " +
      "COALESCE(c_orgconfiguration.Autoprojectvaluesequence, 'N') AS Autoprojectvaluesequence, " +
      "COALESCE(c_orgconfiguration.Projectvaluereadonly, 'N') AS Projectvaluereadonly, " +
      "COALESCE(c_orgconfiguration.Projectmangerworkflow, 'N') AS Projectmangerworkflow, " +
      "COALESCE(c_orgconfiguration.Poprojectworkflow, 'N') AS Poprojectworkflow, " +
      "c_orgconfiguration.Defaultpoapprovalamt, " +
      "COALESCE(c_orgconfiguration.Prapprovalworkflow, 'N') AS Prapprovalworkflow, " +
      "c_orgconfiguration.Defaultprapprovalamt, " +
      "COALESCE(c_orgconfiguration.Pipurchaserdisplay, 'N') AS Pipurchaserdisplay, " +
      "COALESCE(c_orgconfiguration.Orderrequisitionrestriction, 'N') AS Orderrequisitionrestriction, " +
      "COALESCE(c_orgconfiguration.Offerpropabilitynotnull, 'N') AS Offerpropabilitynotnull, " +
      "COALESCE(c_orgconfiguration.Orderprojectnotnull, 'N') AS Orderprojectnotnull, " +
      "COALESCE(c_orgconfiguration.Datepromisednotnull, 'N') AS Datepromisednotnull, " +
      "COALESCE(c_orgconfiguration.Activatepoinvoiceautomatically, 'N') AS Activatepoinvoiceautomatically, " +
      "COALESCE(c_orgconfiguration.Activatereceiptautomatically, 'N') AS Activatereceiptautomatically, " +
      "COALESCE(c_orgconfiguration.Activatesoinvoiceautomatically, 'N') AS Activatesoinvoiceautomatically, " +
      "COALESCE(c_orgconfiguration.Activateshipmentautomatically, 'N') AS Activateshipmentautomatically, " +
      "COALESCE(c_orgconfiguration.Docnoreadonly, 'N') AS Docnoreadonly, " +
      "COALESCE(c_orgconfiguration.Autoproductvaluesequence, 'N') AS Autoproductvaluesequence, " +
      "COALESCE(c_orgconfiguration.Productvaluereadonly, 'N') AS Productvaluereadonly, " +
      "COALESCE(c_orgconfiguration.Useproductvalue2scanproducts, 'N') AS Useproductvalue2scanproducts, " +
      "COALESCE(c_orgconfiguration.Autoproducteansequence, 'N') AS Autoproducteansequence, " +
      "COALESCE(c_orgconfiguration.Autoselectlotnumber, 'N') AS Autoselectlotnumber, " +
      "COALESCE(c_orgconfiguration.Autobpartnervaluesequence, 'N') AS Autobpartnervaluesequence, " +
      "COALESCE(c_orgconfiguration.Bpartnervaluereadonly, 'N') AS Bpartnervaluereadonly, " +
      "c_orgconfiguration.Refreshintervall, " +
      "        ? AS LANGUAGE " +
      "        FROM c_orgconfiguration left join (select AD_Org_ID, Name from AD_Org) table1 on (c_orgconfiguration.AD_Org_ID = table1.AD_Org_ID) left join (select AD_Client_ID, Name from AD_Client) table2 on (c_orgconfiguration.AD_Client_ID = table2.AD_Client_ID)" +
      "        WHERE 2=2 " +
      " AND c_orgconfiguration.ad_org_id=?" +
      "        AND 1=1 ";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":"  AND c_orgconfiguration.AD_Org_ID = ?  ");
    strSql = strSql + 
      "        AND c_orgconfiguration.c_orgconfiguration_id = ? " +
      "        AND c_orgconfiguration.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_orgconfiguration.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
        ConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData = new ConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData();
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.created = UtilSql.getValue(result, "created");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.updated = UtilSql.getValue(result, "updated");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.updatedby = UtilSql.getValue(result, "updatedby");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.cOrgconfigurationId = UtilSql.getValue(result, "c_orgconfiguration_id");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.isstandard = UtilSql.getValue(result, "isstandard");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.deliveryofservices = UtilSql.getValue(result, "deliveryofservices");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.isactive = UtilSql.getValue(result, "isactive");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.activatepobpartnerpreselection = UtilSql.getValue(result, "activatepobpartnerpreselection");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.datevonlycreditdebit = UtilSql.getValue(result, "datevonlycreditdebit");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.automaterial2project = UtilSql.getValue(result, "automaterial2project");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.activateinternalconsumptionauto = UtilSql.getValue(result, "activateinternalconsumptionauto");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.createprojectfromso = UtilSql.getValue(result, "createprojectfromso");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.generatestdtaskfromso = UtilSql.getValue(result, "generatestdtaskfromso");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.closeprojectfromso = UtilSql.getValue(result, "closeprojectfromso");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.bringbackmorematerialthanreceived = UtilSql.getValue(result, "bringbackmorematerialthanreceived");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.synchronizeworkstepboms = UtilSql.getValue(result, "synchronizeworkstepboms");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.projectonlyapprovedproducts = UtilSql.getValue(result, "projectonlyapprovedproducts");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.projectgetmatontaskstart = UtilSql.getValue(result, "projectgetmatontaskstart");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.datevexportprojasset = UtilSql.getValue(result, "datevexportprojasset");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.projectmatpanautowhengetmat = UtilSql.getValue(result, "projectmatpanautowhengetmat");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.reinvoiceprojectexpenses = UtilSql.getValue(result, "reinvoiceprojectexpenses");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.autoprojectvaluesequence = UtilSql.getValue(result, "autoprojectvaluesequence");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.projectvaluereadonly = UtilSql.getValue(result, "projectvaluereadonly");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.projectmangerworkflow = UtilSql.getValue(result, "projectmangerworkflow");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.poprojectworkflow = UtilSql.getValue(result, "poprojectworkflow");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.defaultpoapprovalamt = UtilSql.getValue(result, "defaultpoapprovalamt");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.prapprovalworkflow = UtilSql.getValue(result, "prapprovalworkflow");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.defaultprapprovalamt = UtilSql.getValue(result, "defaultprapprovalamt");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.pipurchaserdisplay = UtilSql.getValue(result, "pipurchaserdisplay");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.orderrequisitionrestriction = UtilSql.getValue(result, "orderrequisitionrestriction");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.offerpropabilitynotnull = UtilSql.getValue(result, "offerpropabilitynotnull");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.orderprojectnotnull = UtilSql.getValue(result, "orderprojectnotnull");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.datepromisednotnull = UtilSql.getValue(result, "datepromisednotnull");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.activatepoinvoiceautomatically = UtilSql.getValue(result, "activatepoinvoiceautomatically");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.activatereceiptautomatically = UtilSql.getValue(result, "activatereceiptautomatically");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.activatesoinvoiceautomatically = UtilSql.getValue(result, "activatesoinvoiceautomatically");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.activateshipmentautomatically = UtilSql.getValue(result, "activateshipmentautomatically");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.docnoreadonly = UtilSql.getValue(result, "docnoreadonly");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.autoproductvaluesequence = UtilSql.getValue(result, "autoproductvaluesequence");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.productvaluereadonly = UtilSql.getValue(result, "productvaluereadonly");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.useproductvalue2scanproducts = UtilSql.getValue(result, "useproductvalue2scanproducts");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.autoproducteansequence = UtilSql.getValue(result, "autoproducteansequence");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.autoselectlotnumber = UtilSql.getValue(result, "autoselectlotnumber");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.autobpartnervaluesequence = UtilSql.getValue(result, "autobpartnervaluesequence");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.bpartnervaluereadonly = UtilSql.getValue(result, "bpartnervaluereadonly");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.refreshintervall = UtilSql.getValue(result, "refreshintervall");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.language = UtilSql.getValue(result, "language");
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.adUserClient = "";
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.adOrgClient = "";
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.createdby = "";
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.trBgcolor = "";
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.totalCount = "";
        objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData);
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
    ConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[] = new ConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[vector.size()];
    vector.copyInto(objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData);
    return(objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData);
  }

/**
Create a registry
 */
  public static ConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[] set(String adOrgId, String synchronizeworkstepboms, String poprojectworkflow, String datepromisednotnull, String reinvoiceprojectexpenses, String activatepoinvoiceautomatically, String activatepobpartnerpreselection, String projectgetmatontaskstart, String autoproductvaluesequence, String orderrequisitionrestriction, String activateinternalconsumptionauto, String projectmangerworkflow, String datevonlycreditdebit, String autobpartnervaluesequence, String projectonlyapprovedproducts, String offerpropabilitynotnull, String isactive, String updatedby, String updatedbyr, String activatereceiptautomatically, String closeprojectfromso, String datevexportprojasset, String bpartnervaluereadonly, String autoprojectvaluesequence, String defaultpoapprovalamt, String projectmatpanautowhengetmat, String autoselectlotnumber, String docnoreadonly, String deliveryofservices, String productvaluereadonly, String projectvaluereadonly, String isstandard, String automaterial2project, String activatesoinvoiceautomatically, String cOrgconfigurationId, String bringbackmorematerialthanreceived, String refreshintervall, String orderprojectnotnull, String generatestdtaskfromso, String createprojectfromso, String defaultprapprovalamt, String prapprovalworkflow, String adClientId, String pipurchaserdisplay, String useproductvalue2scanproducts, String autoproducteansequence, String activateshipmentautomatically, String createdby, String createdbyr)    throws ServletException {
    ConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[] = new ConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[1];
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0] = new ConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData();
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].created = "";
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].createdbyr = createdbyr;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].updated = "";
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].updatedTimeStamp = "";
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].updatedby = updatedby;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].updatedbyr = updatedbyr;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].cOrgconfigurationId = cOrgconfigurationId;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].adOrgId = adOrgId;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].adOrgIdr = "";
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].adClientId = adClientId;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].adClientIdr = "";
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].isstandard = isstandard;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].deliveryofservices = deliveryofservices;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].isactive = isactive;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].activatepobpartnerpreselection = activatepobpartnerpreselection;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].datevonlycreditdebit = datevonlycreditdebit;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].automaterial2project = automaterial2project;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].activateinternalconsumptionauto = activateinternalconsumptionauto;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].createprojectfromso = createprojectfromso;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].generatestdtaskfromso = generatestdtaskfromso;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].closeprojectfromso = closeprojectfromso;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].bringbackmorematerialthanreceived = bringbackmorematerialthanreceived;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].synchronizeworkstepboms = synchronizeworkstepboms;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].projectonlyapprovedproducts = projectonlyapprovedproducts;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].projectgetmatontaskstart = projectgetmatontaskstart;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].datevexportprojasset = datevexportprojasset;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].projectmatpanautowhengetmat = projectmatpanautowhengetmat;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].reinvoiceprojectexpenses = reinvoiceprojectexpenses;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].autoprojectvaluesequence = autoprojectvaluesequence;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].projectvaluereadonly = projectvaluereadonly;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].projectmangerworkflow = projectmangerworkflow;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].poprojectworkflow = poprojectworkflow;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].defaultpoapprovalamt = defaultpoapprovalamt;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].prapprovalworkflow = prapprovalworkflow;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].defaultprapprovalamt = defaultprapprovalamt;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].pipurchaserdisplay = pipurchaserdisplay;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].orderrequisitionrestriction = orderrequisitionrestriction;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].offerpropabilitynotnull = offerpropabilitynotnull;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].orderprojectnotnull = orderprojectnotnull;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].datepromisednotnull = datepromisednotnull;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].activatepoinvoiceautomatically = activatepoinvoiceautomatically;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].activatereceiptautomatically = activatereceiptautomatically;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].activatesoinvoiceautomatically = activatesoinvoiceautomatically;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].activateshipmentautomatically = activateshipmentautomatically;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].docnoreadonly = docnoreadonly;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].autoproductvaluesequence = autoproductvaluesequence;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].productvaluereadonly = productvaluereadonly;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].useproductvalue2scanproducts = useproductvalue2scanproducts;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].autoproducteansequence = autoproducteansequence;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].autoselectlotnumber = autoselectlotnumber;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].autobpartnervaluesequence = autobpartnervaluesequence;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].bpartnervaluereadonly = bpartnervaluereadonly;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].refreshintervall = refreshintervall;
    objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData[0].language = "";
    return objectConfigurationOptions4876AD1C05004DF9934B4AFE73FCC24AData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef96ADB0FF81F24B95876A09A80B4C4087_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef8CF3A910C14A4BFAA8A1267155933BBB_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_orgconfiguration.AD_Org_ID AS NAME" +
      "        FROM c_orgconfiguration" +
      "        WHERE c_orgconfiguration.c_orgconfiguration_id = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Org left join (select AD_Org_ID, Name from AD_Org) table1 on (AD_Org.AD_Org_ID = table1.AD_Org_ID) WHERE AD_Org.AD_Org_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Org left join (select AD_Org_ID, Name from AD_Org) table1 on (AD_Org.AD_Org_ID = table1.AD_Org_ID) WHERE AD_Org.AD_Org_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
      "        UPDATE c_orgconfiguration" +
      "        SET c_orgconfiguration_id = (?) , AD_Org_ID = (?) , AD_Client_ID = (?) , Isstandard = (?) , Deliveryofservices = (?) , Isactive = (?) , ActivatePOBPartnerPreselection = (?) , Datevonlycreditdebit = (?) , Automaterial2project = (?) , Activateinternalconsumptionauto = (?) , Createprojectfromso = (?) , Generatestdtaskfromso = (?) , Closeprojectfromso = (?) , Bringbackmorematerialthanreceived = (?) , Synchronizeworkstepboms = (?) , Projectonlyapprovedproducts = (?) , Projectgetmatontaskstart = (?) , Datevexportprojasset = (?) , Projectmatpanautowhengetmat = (?) , Reinvoiceprojectexpenses = (?) , Autoprojectvaluesequence = (?) , Projectvaluereadonly = (?) , Projectmangerworkflow = (?) , Poprojectworkflow = (?) , Defaultpoapprovalamt = TO_NUMBER(?) , Prapprovalworkflow = (?) , Defaultprapprovalamt = TO_NUMBER(?) , Pipurchaserdisplay = (?) , Orderrequisitionrestriction = (?) , Offerpropabilitynotnull = (?) , Orderprojectnotnull = (?) , Datepromisednotnull = (?) , Activatepoinvoiceautomatically = (?) , Activatereceiptautomatically = (?) , Activatesoinvoiceautomatically = (?) , Activateshipmentautomatically = (?) , Docnoreadonly = (?) , Autoproductvaluesequence = (?) , Productvaluereadonly = (?) , Useproductvalue2scanproducts = (?) , Autoproducteansequence = (?) , Autoselectlotnumber = (?) , Autobpartnervaluesequence = (?) , Bpartnervaluereadonly = (?) , Refreshintervall = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE c_orgconfiguration.c_orgconfiguration_id = ? " +
      "                 AND c_orgconfiguration.AD_Org_ID = ? " +
      "        AND c_orgconfiguration.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_orgconfiguration.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrgconfigurationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isstandard);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryofservices);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, activatepobpartnerpreselection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datevonlycreditdebit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, automaterial2project);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, activateinternalconsumptionauto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createprojectfromso);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatestdtaskfromso);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeprojectfromso);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bringbackmorematerialthanreceived);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, synchronizeworkstepboms);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectonlyapprovedproducts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectgetmatontaskstart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datevexportprojasset);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectmatpanautowhengetmat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reinvoiceprojectexpenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, autoprojectvaluesequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectvaluereadonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectmangerworkflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poprojectworkflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultpoapprovalamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, prapprovalworkflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultprapprovalamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pipurchaserdisplay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderrequisitionrestriction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, offerpropabilitynotnull);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderprojectnotnull);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromisednotnull);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, activatepoinvoiceautomatically);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, activatereceiptautomatically);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, activatesoinvoiceautomatically);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, activateshipmentautomatically);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docnoreadonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, autoproductvaluesequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productvaluereadonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, useproductvalue2scanproducts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, autoproducteansequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, autoselectlotnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, autobpartnervaluesequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnervaluereadonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, refreshintervall);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrgconfigurationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
      "        INSERT INTO c_orgconfiguration " +
      "        (c_orgconfiguration_id, AD_Org_ID, AD_Client_ID, Isstandard, Deliveryofservices, Isactive, ActivatePOBPartnerPreselection, Datevonlycreditdebit, Automaterial2project, Activateinternalconsumptionauto, Createprojectfromso, Generatestdtaskfromso, Closeprojectfromso, Bringbackmorematerialthanreceived, Synchronizeworkstepboms, Projectonlyapprovedproducts, Projectgetmatontaskstart, Datevexportprojasset, Projectmatpanautowhengetmat, Reinvoiceprojectexpenses, Autoprojectvaluesequence, Projectvaluereadonly, Projectmangerworkflow, Poprojectworkflow, Defaultpoapprovalamt, Prapprovalworkflow, Defaultprapprovalamt, Pipurchaserdisplay, Orderrequisitionrestriction, Offerpropabilitynotnull, Orderprojectnotnull, Datepromisednotnull, Activatepoinvoiceautomatically, Activatereceiptautomatically, Activatesoinvoiceautomatically, Activateshipmentautomatically, Docnoreadonly, Autoproductvaluesequence, Productvaluereadonly, Useproductvalue2scanproducts, Autoproducteansequence, Autoselectlotnumber, Autobpartnervaluesequence, Bpartnervaluereadonly, Refreshintervall, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrgconfigurationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isstandard);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryofservices);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, activatepobpartnerpreselection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datevonlycreditdebit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, automaterial2project);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, activateinternalconsumptionauto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createprojectfromso);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatestdtaskfromso);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeprojectfromso);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bringbackmorematerialthanreceived);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, synchronizeworkstepboms);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectonlyapprovedproducts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectgetmatontaskstart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datevexportprojasset);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectmatpanautowhengetmat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reinvoiceprojectexpenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, autoprojectvaluesequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectvaluereadonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectmangerworkflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poprojectworkflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultpoapprovalamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, prapprovalworkflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultprapprovalamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pipurchaserdisplay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderrequisitionrestriction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, offerpropabilitynotnull);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderprojectnotnull);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromisednotnull);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, activatepoinvoiceautomatically);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, activatereceiptautomatically);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, activatesoinvoiceautomatically);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, activateshipmentautomatically);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docnoreadonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, autoproductvaluesequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productvaluereadonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, useproductvalue2scanproducts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, autoproducteansequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, autoselectlotnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, autobpartnervaluesequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnervaluereadonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, refreshintervall);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adOrgId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_orgconfiguration" +
      "        WHERE c_orgconfiguration.c_orgconfiguration_id = ? " +
      "                 AND c_orgconfiguration.AD_Org_ID = ? " +
      "        AND c_orgconfiguration.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_orgconfiguration.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_orgconfiguration" +
      "        WHERE c_orgconfiguration.c_orgconfiguration_id = ? " +
      "                 AND c_orgconfiguration.AD_Org_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
      "          FROM c_orgconfiguration" +
      "         WHERE c_orgconfiguration.c_orgconfiguration_id = ? ";

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
      "          FROM c_orgconfiguration" +
      "         WHERE c_orgconfiguration.c_orgconfiguration_id = ? ";

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
