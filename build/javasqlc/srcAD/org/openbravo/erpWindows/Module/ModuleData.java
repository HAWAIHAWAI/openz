//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Module;

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
class ModuleData implements FieldProvider {
static Logger log4j = Logger.getLogger(ModuleData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adModuleId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String name;
  public String javapackage;
  public String version;
  public String versionLabel;
  public String seqno;
  public String ordernumber;
  public String type;
  public String typer;
  public String isindevelopment;
  public String isdefault;
  public String description;
  public String help;
  public String istranslationrequired;
  public String istranslationmodule;
  public String adLanguage;
  public String adLanguager;
  public String licensetype;
  public String licensetyper;
  public String iscommercial;
  public String ispartofdistribution;
  public String license;
  public String author;
  public String url;
  public String status;
  public String statusr;
  public String updateinfo;
  public String updateAvailable;
  public String haschartofaccounts;
  public String hasreferencedata;
  public String updateVerId;
  public String referencedatainfo;
  public String versionId;
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
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
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
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("javapackage"))
      return javapackage;
    else if (fieldName.equalsIgnoreCase("version"))
      return version;
    else if (fieldName.equalsIgnoreCase("version_label") || fieldName.equals("versionLabel"))
      return versionLabel;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("ordernumber"))
      return ordernumber;
    else if (fieldName.equalsIgnoreCase("type"))
      return type;
    else if (fieldName.equalsIgnoreCase("typer"))
      return typer;
    else if (fieldName.equalsIgnoreCase("isindevelopment"))
      return isindevelopment;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("istranslationrequired"))
      return istranslationrequired;
    else if (fieldName.equalsIgnoreCase("istranslationmodule"))
      return istranslationmodule;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("licensetype"))
      return licensetype;
    else if (fieldName.equalsIgnoreCase("licensetyper"))
      return licensetyper;
    else if (fieldName.equalsIgnoreCase("iscommercial"))
      return iscommercial;
    else if (fieldName.equalsIgnoreCase("ispartofdistribution"))
      return ispartofdistribution;
    else if (fieldName.equalsIgnoreCase("license"))
      return license;
    else if (fieldName.equalsIgnoreCase("author"))
      return author;
    else if (fieldName.equalsIgnoreCase("url"))
      return url;
    else if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("statusr"))
      return statusr;
    else if (fieldName.equalsIgnoreCase("updateinfo"))
      return updateinfo;
    else if (fieldName.equalsIgnoreCase("update_available") || fieldName.equals("updateAvailable"))
      return updateAvailable;
    else if (fieldName.equalsIgnoreCase("haschartofaccounts"))
      return haschartofaccounts;
    else if (fieldName.equalsIgnoreCase("hasreferencedata"))
      return hasreferencedata;
    else if (fieldName.equalsIgnoreCase("update_ver_id") || fieldName.equals("updateVerId"))
      return updateVerId;
    else if (fieldName.equalsIgnoreCase("referencedatainfo"))
      return referencedatainfo;
    else if (fieldName.equalsIgnoreCase("version_id") || fieldName.equals("versionId"))
      return versionId;
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
  public static ModuleData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ModuleData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Module.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Module.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Module.Updated, ?) as updated, " +
      "        to_char(AD_Module.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Module.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Module.UpdatedBy) as UpdatedByR," +
      "        AD_Module.AD_Module_ID, " +
      "AD_Module.AD_Client_ID, " +
      "(CASE WHEN AD_Module.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Module.AD_Org_ID, " +
      "(CASE WHEN AD_Module.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(AD_Module.IsActive, 'N') AS IsActive, " +
      "AD_Module.Name, " +
      "AD_Module.JavaPackage, " +
      "AD_Module.Version, " +
      "AD_Module.Version_Label, " +
      "AD_Module.Seqno, " +
      "AD_Module.Ordernumber, " +
      "AD_Module.Type, " +
      "(CASE WHEN AD_Module.Type IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS TypeR, " +
      "COALESCE(AD_Module.IsInDevelopment, 'N') AS IsInDevelopment, " +
      "COALESCE(AD_Module.IsDefault, 'N') AS IsDefault, " +
      "AD_Module.Description, " +
      "AD_Module.Help, " +
      "COALESCE(AD_Module.IsTranslationRequired, 'N') AS IsTranslationRequired, " +
      "COALESCE(AD_Module.IsTranslationModule, 'N') AS IsTranslationModule, " +
      "AD_Module.AD_Language, " +
      "(CASE WHEN AD_Module.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "AD_Module.LicenseType, " +
      "(CASE WHEN AD_Module.LicenseType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS LicenseTypeR, " +
      "COALESCE(AD_Module.IsCommercial, 'N') AS IsCommercial, " +
      "COALESCE(AD_Module.Ispartofdistribution, 'N') AS Ispartofdistribution, " +
      "AD_Module.License, " +
      "AD_Module.Author, " +
      "AD_Module.URL, " +
      "AD_Module.Status, " +
      "(CASE WHEN AD_Module.Status IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS StatusR, " +
      "AD_Module.UpdateInfo, " +
      "AD_Module.Update_Available, " +
      "COALESCE(AD_Module.HasChartOfAccounts, 'N') AS HasChartOfAccounts, " +
      "COALESCE(AD_Module.HasReferenceData, 'N') AS HasReferenceData, " +
      "AD_Module.Update_Ver_ID, " +
      "AD_Module.ReferenceDataInfo, " +
      "AD_Module.Version_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Module left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Module.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_Module.AD_Org_ID = table2.AD_Org_ID) left join ad_ref_list_v list1 on (AD_Module.Type = list1.value and list1.ad_reference_id = '3F854F4DC7284CE4857A5EA941BE032C' and list1.ad_language = ?)  left join (select AD_Language, Name from AD_Language) table3 on (AD_Module.AD_Language =  table3.AD_Language) left join ad_ref_list_v list2 on (AD_Module.LicenseType = list2.value and list2.ad_reference_id = '5D4B2983E0254AA1B60A82A7B92DB67D' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (AD_Module.Status = list3.value and list3.ad_reference_id = '725CD8C6882C40AFB4D1C27B1AEF8BB4' and list3.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND AD_Module.AD_Module_ID = ? " +
      "        AND AD_Module.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Module.AD_Org_ID IN (";
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
        ModuleData objectModuleData = new ModuleData();
        objectModuleData.created = UtilSql.getValue(result, "created");
        objectModuleData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectModuleData.updated = UtilSql.getValue(result, "updated");
        objectModuleData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectModuleData.updatedby = UtilSql.getValue(result, "updatedby");
        objectModuleData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectModuleData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectModuleData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectModuleData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectModuleData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectModuleData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectModuleData.isactive = UtilSql.getValue(result, "isactive");
        objectModuleData.name = UtilSql.getValue(result, "name");
        objectModuleData.javapackage = UtilSql.getValue(result, "javapackage");
        objectModuleData.version = UtilSql.getValue(result, "version");
        objectModuleData.versionLabel = UtilSql.getValue(result, "version_label");
        objectModuleData.seqno = UtilSql.getValue(result, "seqno");
        objectModuleData.ordernumber = UtilSql.getValue(result, "ordernumber");
        objectModuleData.type = UtilSql.getValue(result, "type");
        objectModuleData.typer = UtilSql.getValue(result, "typer");
        objectModuleData.isindevelopment = UtilSql.getValue(result, "isindevelopment");
        objectModuleData.isdefault = UtilSql.getValue(result, "isdefault");
        objectModuleData.description = UtilSql.getValue(result, "description");
        objectModuleData.help = UtilSql.getValue(result, "help");
        objectModuleData.istranslationrequired = UtilSql.getValue(result, "istranslationrequired");
        objectModuleData.istranslationmodule = UtilSql.getValue(result, "istranslationmodule");
        objectModuleData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectModuleData.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectModuleData.licensetype = UtilSql.getValue(result, "licensetype");
        objectModuleData.licensetyper = UtilSql.getValue(result, "licensetyper");
        objectModuleData.iscommercial = UtilSql.getValue(result, "iscommercial");
        objectModuleData.ispartofdistribution = UtilSql.getValue(result, "ispartofdistribution");
        objectModuleData.license = UtilSql.getValue(result, "license");
        objectModuleData.author = UtilSql.getValue(result, "author");
        objectModuleData.url = UtilSql.getValue(result, "url");
        objectModuleData.status = UtilSql.getValue(result, "status");
        objectModuleData.statusr = UtilSql.getValue(result, "statusr");
        objectModuleData.updateinfo = UtilSql.getValue(result, "updateinfo");
        objectModuleData.updateAvailable = UtilSql.getValue(result, "update_available");
        objectModuleData.haschartofaccounts = UtilSql.getValue(result, "haschartofaccounts");
        objectModuleData.hasreferencedata = UtilSql.getValue(result, "hasreferencedata");
        objectModuleData.updateVerId = UtilSql.getValue(result, "update_ver_id");
        objectModuleData.referencedatainfo = UtilSql.getValue(result, "referencedatainfo");
        objectModuleData.versionId = UtilSql.getValue(result, "version_id");
        objectModuleData.language = UtilSql.getValue(result, "language");
        objectModuleData.adUserClient = "";
        objectModuleData.adOrgClient = "";
        objectModuleData.createdby = "";
        objectModuleData.trBgcolor = "";
        objectModuleData.totalCount = "";
        objectModuleData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectModuleData);
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
    ModuleData objectModuleData[] = new ModuleData[vector.size()];
    vector.copyInto(objectModuleData);
    return(objectModuleData);
  }

/**
Create a registry
 */
  public static ModuleData[] set(String adOrgId, String ordernumber, String help, String haschartofaccounts, String adClientId, String adModuleId, String versionId, String createdby, String createdbyr, String author, String updateVerId, String iscommercial, String license, String licensetype, String isactive, String adLanguage, String name, String description, String ispartofdistribution, String referencedatainfo, String updateinfo, String versionLabel, String type, String url, String status, String istranslationrequired, String isindevelopment, String seqno, String javapackage, String version, String isdefault, String updateAvailable, String hasreferencedata, String istranslationmodule, String updatedby, String updatedbyr)    throws ServletException {
    ModuleData objectModuleData[] = new ModuleData[1];
    objectModuleData[0] = new ModuleData();
    objectModuleData[0].created = "";
    objectModuleData[0].createdbyr = createdbyr;
    objectModuleData[0].updated = "";
    objectModuleData[0].updatedTimeStamp = "";
    objectModuleData[0].updatedby = updatedby;
    objectModuleData[0].updatedbyr = updatedbyr;
    objectModuleData[0].adModuleId = adModuleId;
    objectModuleData[0].adClientId = adClientId;
    objectModuleData[0].adClientIdr = "";
    objectModuleData[0].adOrgId = adOrgId;
    objectModuleData[0].adOrgIdr = "";
    objectModuleData[0].isactive = isactive;
    objectModuleData[0].name = name;
    objectModuleData[0].javapackage = javapackage;
    objectModuleData[0].version = version;
    objectModuleData[0].versionLabel = versionLabel;
    objectModuleData[0].seqno = seqno;
    objectModuleData[0].ordernumber = ordernumber;
    objectModuleData[0].type = type;
    objectModuleData[0].typer = "";
    objectModuleData[0].isindevelopment = isindevelopment;
    objectModuleData[0].isdefault = isdefault;
    objectModuleData[0].description = description;
    objectModuleData[0].help = help;
    objectModuleData[0].istranslationrequired = istranslationrequired;
    objectModuleData[0].istranslationmodule = istranslationmodule;
    objectModuleData[0].adLanguage = adLanguage;
    objectModuleData[0].adLanguager = "";
    objectModuleData[0].licensetype = licensetype;
    objectModuleData[0].licensetyper = "";
    objectModuleData[0].iscommercial = iscommercial;
    objectModuleData[0].ispartofdistribution = ispartofdistribution;
    objectModuleData[0].license = license;
    objectModuleData[0].author = author;
    objectModuleData[0].url = url;
    objectModuleData[0].status = status;
    objectModuleData[0].statusr = "";
    objectModuleData[0].updateinfo = updateinfo;
    objectModuleData[0].updateAvailable = updateAvailable;
    objectModuleData[0].haschartofaccounts = haschartofaccounts;
    objectModuleData[0].hasreferencedata = hasreferencedata;
    objectModuleData[0].updateVerId = updateVerId;
    objectModuleData[0].referencedatainfo = referencedatainfo;
    objectModuleData[0].versionId = versionId;
    objectModuleData[0].language = "";
    return objectModuleData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef565E56DF64DE9042E040007F01002829_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef565E56DF64E09042E040007F01002829_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
      "        UPDATE AD_Module" +
      "        SET AD_Module_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , IsActive = (?) , Name = (?) , JavaPackage = (?) , Version = (?) , Version_Label = (?) , Seqno = TO_NUMBER(?) , Ordernumber = TO_NUMBER(?) , Type = (?) , IsInDevelopment = (?) , IsDefault = (?) , Description = (?) , Help = (?) , IsTranslationRequired = (?) , IsTranslationModule = (?) , AD_Language = (?) , LicenseType = (?) , IsCommercial = (?) , Ispartofdistribution = (?) , License = (?) , Author = (?) , URL = (?) , Status = (?) , UpdateInfo = (?) , Update_Available = (?) , HasChartOfAccounts = (?) , HasReferenceData = (?) , Update_Ver_ID = (?) , ReferenceDataInfo = (?) , Version_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Module.AD_Module_ID = ? " +
      "        AND AD_Module.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Module.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, javapackage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, version);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, versionLabel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ordernumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isindevelopment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslationrequired);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslationmodule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, licensetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommercial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispartofdistribution);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, license);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, author);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, url);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updateinfo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updateAvailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, haschartofaccounts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hasreferencedata);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updateVerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referencedatainfo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, versionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
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
      "        INSERT INTO AD_Module " +
      "        (AD_Module_ID, AD_Client_ID, AD_Org_ID, IsActive, Name, JavaPackage, Version, Version_Label, Seqno, Ordernumber, Type, IsInDevelopment, IsDefault, Description, Help, IsTranslationRequired, IsTranslationModule, AD_Language, LicenseType, IsCommercial, Ispartofdistribution, License, Author, URL, Status, UpdateInfo, Update_Available, HasChartOfAccounts, HasReferenceData, Update_Ver_ID, ReferenceDataInfo, Version_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, javapackage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, version);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, versionLabel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ordernumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isindevelopment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslationrequired);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslationmodule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, licensetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommercial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispartofdistribution);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, license);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, author);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, url);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updateinfo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updateAvailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, haschartofaccounts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hasreferencedata);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updateVerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referencedatainfo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, versionId);
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
      "        DELETE FROM AD_Module" +
      "        WHERE AD_Module.AD_Module_ID = ? " +
      "        AND AD_Module.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Module.AD_Org_ID IN (";
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
      "        DELETE FROM AD_Module" +
      "        WHERE AD_Module.AD_Module_ID = ? ";

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
      "          FROM AD_Module" +
      "         WHERE AD_Module.AD_Module_ID = ? ";

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
      "          FROM AD_Module" +
      "         WHERE AD_Module.AD_Module_ID = ? ";

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
