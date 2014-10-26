//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.Employee;

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
class EmployeeA3D0B320B69845B386024B5FF6B1E266Data implements FieldProvider {
static Logger log4j = Logger.getLogger(EmployeeA3D0B320B69845B386024B5FF6B1E266Data.class);
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
  public String value;
  public String name;
  public String description;
  public String isactive;
  public String isinresourceplan;
  public String issalesrep;
  public String isprojectmanager;
  public String isprocurementmanager;
  public String isworker;
  public String isapprover;
  public String approvalamt;
  public String isprapprover;
  public String ispaymentapprover;
  public String cSalaryCategoryId;
  public String cSalaryCategoryIdr;
  public String taxid;
  public String referenceno;
  public String cBpGroupId;
  public String cBpGroupIdr;
  public String adLanguage;
  public String adLanguager;
  public String country;
  public String zipcode;
  public String city;
  public String aAssetId;
  public String aAssetIdr;
  public String cBpartnerId;
  public String isemployee;
  public String istaxexempt;
  public String cGreetingId;
  public String rating;
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
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isinresourceplan"))
      return isinresourceplan;
    else if (fieldName.equalsIgnoreCase("issalesrep"))
      return issalesrep;
    else if (fieldName.equalsIgnoreCase("isprojectmanager"))
      return isprojectmanager;
    else if (fieldName.equalsIgnoreCase("isprocurementmanager"))
      return isprocurementmanager;
    else if (fieldName.equalsIgnoreCase("isworker"))
      return isworker;
    else if (fieldName.equalsIgnoreCase("isapprover"))
      return isapprover;
    else if (fieldName.equalsIgnoreCase("approvalamt"))
      return approvalamt;
    else if (fieldName.equalsIgnoreCase("isprapprover"))
      return isprapprover;
    else if (fieldName.equalsIgnoreCase("ispaymentapprover"))
      return ispaymentapprover;
    else if (fieldName.equalsIgnoreCase("c_salary_category_id") || fieldName.equals("cSalaryCategoryId"))
      return cSalaryCategoryId;
    else if (fieldName.equalsIgnoreCase("c_salary_category_idr") || fieldName.equals("cSalaryCategoryIdr"))
      return cSalaryCategoryIdr;
    else if (fieldName.equalsIgnoreCase("taxid"))
      return taxid;
    else if (fieldName.equalsIgnoreCase("referenceno"))
      return referenceno;
    else if (fieldName.equalsIgnoreCase("c_bp_group_id") || fieldName.equals("cBpGroupId"))
      return cBpGroupId;
    else if (fieldName.equalsIgnoreCase("c_bp_group_idr") || fieldName.equals("cBpGroupIdr"))
      return cBpGroupIdr;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("country"))
      return country;
    else if (fieldName.equalsIgnoreCase("zipcode"))
      return zipcode;
    else if (fieldName.equalsIgnoreCase("city"))
      return city;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("isemployee"))
      return isemployee;
    else if (fieldName.equalsIgnoreCase("istaxexempt"))
      return istaxexempt;
    else if (fieldName.equalsIgnoreCase("c_greeting_id") || fieldName.equals("cGreetingId"))
      return cGreetingId;
    else if (fieldName.equalsIgnoreCase("rating"))
      return rating;
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
  public static EmployeeA3D0B320B69845B386024B5FF6B1E266Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static EmployeeA3D0B320B69845B386024B5FF6B1E266Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_bpartneremployee_view.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_bpartneremployee_view.CreatedBy) as CreatedByR, " +
      "        to_char(c_bpartneremployee_view.Updated, ?) as updated, " +
      "        to_char(c_bpartneremployee_view.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_bpartneremployee_view.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_bpartneremployee_view.UpdatedBy) as UpdatedByR," +
      "        c_bpartneremployee_view.AD_Client_ID, " +
      "(CASE WHEN c_bpartneremployee_view.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "c_bpartneremployee_view.AD_Org_ID, " +
      "(CASE WHEN c_bpartneremployee_view.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "c_bpartneremployee_view.Value, " +
      "c_bpartneremployee_view.Name, " +
      "c_bpartneremployee_view.Description, " +
      "COALESCE(c_bpartneremployee_view.Isactive, 'N') AS Isactive, " +
      "COALESCE(c_bpartneremployee_view.isinresourceplan, 'N') AS isinresourceplan, " +
      "COALESCE(c_bpartneremployee_view.Issalesrep, 'N') AS Issalesrep, " +
      "COALESCE(c_bpartneremployee_view.Isprojectmanager, 'N') AS Isprojectmanager, " +
      "COALESCE(c_bpartneremployee_view.Isprocurementmanager, 'N') AS Isprocurementmanager, " +
      "COALESCE(c_bpartneremployee_view.Isworker, 'N') AS Isworker, " +
      "COALESCE(c_bpartneremployee_view.Isapprover, 'N') AS Isapprover, " +
      "c_bpartneremployee_view.Approvalamt, " +
      "COALESCE(c_bpartneremployee_view.Isprapprover, 'N') AS Isprapprover, " +
      "COALESCE(c_bpartneremployee_view.Ispaymentapprover, 'N') AS Ispaymentapprover, " +
      "c_bpartneremployee_view.C_Salary_Category_ID, " +
      "(CASE WHEN c_bpartneremployee_view.C_Salary_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Salary_Category_IDR, " +
      "c_bpartneremployee_view.Taxid, " +
      "c_bpartneremployee_view.Referenceno, " +
      "c_bpartneremployee_view.C_Bp_Group_ID, " +
      "(CASE WHEN c_bpartneremployee_view.C_Bp_Group_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Bp_Group_IDR, " +
      "c_bpartneremployee_view.AD_Language, " +
      "(CASE WHEN c_bpartneremployee_view.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "c_bpartneremployee_view.Country, " +
      "c_bpartneremployee_view.Zipcode, " +
      "c_bpartneremployee_view.City, " +
      "c_bpartneremployee_view.A_Asset_ID, " +
      "(CASE WHEN c_bpartneremployee_view.A_Asset_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "c_bpartneremployee_view.C_BPartner_ID, " +
      "COALESCE(c_bpartneremployee_view.Isemployee, 'N') AS Isemployee, " +
      "COALESCE(c_bpartneremployee_view.Istaxexempt, 'N') AS Istaxexempt, " +
      "c_bpartneremployee_view.C_Greeting_ID, " +
      "COALESCE(c_bpartneremployee_view.Rating, 'N') AS Rating, " +
      "        ? AS LANGUAGE " +
      "        FROM c_bpartneremployee_view left join (select AD_Client_ID, Name from AD_Client) table1 on (c_bpartneremployee_view.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (c_bpartneremployee_view.AD_Org_ID = table2.AD_Org_ID) left join (select C_Salary_Category_ID, Name from C_Salary_Category) table3 on (c_bpartneremployee_view.C_Salary_Category_ID = table3.C_Salary_Category_ID) left join (select C_Bp_Group_ID, Name from C_Bp_Group) table4 on (c_bpartneremployee_view.C_Bp_Group_ID = table4.C_Bp_Group_ID) left join (select AD_Language, Name from AD_Language) table5 on (c_bpartneremployee_view.AD_Language =  table5.AD_Language) left join (select A_Asset_ID, Name from A_Asset) table6 on (c_bpartneremployee_view.A_Asset_ID =  table6.A_Asset_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND c_bpartneremployee_view.C_BPartner_ID = ? " +
      "        AND c_bpartneremployee_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_bpartneremployee_view.AD_Org_ID IN (";
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
        EmployeeA3D0B320B69845B386024B5FF6B1E266Data objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data = new EmployeeA3D0B320B69845B386024B5FF6B1E266Data();
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.created = UtilSql.getValue(result, "created");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.updated = UtilSql.getValue(result, "updated");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.value = UtilSql.getValue(result, "value");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.name = UtilSql.getValue(result, "name");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.description = UtilSql.getValue(result, "description");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.isactive = UtilSql.getValue(result, "isactive");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.isinresourceplan = UtilSql.getValue(result, "isinresourceplan");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.issalesrep = UtilSql.getValue(result, "issalesrep");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.isprojectmanager = UtilSql.getValue(result, "isprojectmanager");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.isprocurementmanager = UtilSql.getValue(result, "isprocurementmanager");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.isworker = UtilSql.getValue(result, "isworker");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.isapprover = UtilSql.getValue(result, "isapprover");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.approvalamt = UtilSql.getValue(result, "approvalamt");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.isprapprover = UtilSql.getValue(result, "isprapprover");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.ispaymentapprover = UtilSql.getValue(result, "ispaymentapprover");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.cSalaryCategoryIdr = UtilSql.getValue(result, "c_salary_category_idr");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.taxid = UtilSql.getValue(result, "taxid");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.referenceno = UtilSql.getValue(result, "referenceno");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.cBpGroupId = UtilSql.getValue(result, "c_bp_group_id");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.cBpGroupIdr = UtilSql.getValue(result, "c_bp_group_idr");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.adLanguage = UtilSql.getValue(result, "ad_language");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.country = UtilSql.getValue(result, "country");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.zipcode = UtilSql.getValue(result, "zipcode");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.city = UtilSql.getValue(result, "city");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.isemployee = UtilSql.getValue(result, "isemployee");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.istaxexempt = UtilSql.getValue(result, "istaxexempt");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.cGreetingId = UtilSql.getValue(result, "c_greeting_id");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.rating = UtilSql.getValue(result, "rating");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.language = UtilSql.getValue(result, "language");
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.adUserClient = "";
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.adOrgClient = "";
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.createdby = "";
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.trBgcolor = "";
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.totalCount = "";
        objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data);
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
    EmployeeA3D0B320B69845B386024B5FF6B1E266Data objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[] = new EmployeeA3D0B320B69845B386024B5FF6B1E266Data[vector.size()];
    vector.copyInto(objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data);
    return(objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data);
  }

/**
Create a registry
 */
  public static EmployeeA3D0B320B69845B386024B5FF6B1E266Data[] set(String cBpGroupId, String istaxexempt, String adOrgId, String description, String referenceno, String issalesrep, String name, String aAssetId, String value, String country, String isemployee, String cBpartnerId, String rating, String adLanguage, String zipcode, String cSalaryCategoryId, String isprojectmanager, String isprapprover, String isprocurementmanager, String ispaymentapprover, String city, String isworker, String cGreetingId, String isactive, String isapprover, String approvalamt, String createdby, String createdbyr, String updatedby, String updatedbyr, String taxid, String isinresourceplan, String adClientId)    throws ServletException {
    EmployeeA3D0B320B69845B386024B5FF6B1E266Data objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[] = new EmployeeA3D0B320B69845B386024B5FF6B1E266Data[1];
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0] = new EmployeeA3D0B320B69845B386024B5FF6B1E266Data();
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].created = "";
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].createdbyr = createdbyr;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].updated = "";
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].updatedTimeStamp = "";
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].updatedby = updatedby;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].updatedbyr = updatedbyr;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].adClientId = adClientId;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].adClientIdr = "";
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].adOrgId = adOrgId;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].adOrgIdr = "";
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].value = value;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].name = name;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].description = description;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].isactive = isactive;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].isinresourceplan = isinresourceplan;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].issalesrep = issalesrep;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].isprojectmanager = isprojectmanager;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].isprocurementmanager = isprocurementmanager;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].isworker = isworker;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].isapprover = isapprover;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].approvalamt = approvalamt;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].isprapprover = isprapprover;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].ispaymentapprover = ispaymentapprover;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].cSalaryCategoryId = cSalaryCategoryId;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].cSalaryCategoryIdr = "";
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].taxid = taxid;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].referenceno = referenceno;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].cBpGroupId = cBpGroupId;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].cBpGroupIdr = "";
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].adLanguage = adLanguage;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].adLanguager = "";
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].country = country;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].zipcode = zipcode;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].city = city;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].aAssetId = aAssetId;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].aAssetIdr = "";
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].cBpartnerId = cBpartnerId;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].isemployee = isemployee;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].istaxexempt = istaxexempt;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].cGreetingId = cGreetingId;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].rating = rating;
    objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data[0].language = "";
    return objectEmployeeA3D0B320B69845B386024B5FF6B1E266Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef45A1EF4409BA4B759D2AEB557217145C_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef45BBDF9A74B04ED996519AD982A8CAF8_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE c_bpartneremployee_view" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , Value = (?) , Name = (?) , Description = (?) , Isactive = (?) , isinresourceplan = (?) , Issalesrep = (?) , Isprojectmanager = (?) , Isprocurementmanager = (?) , Isworker = (?) , Isapprover = (?) , Approvalamt = TO_NUMBER(?) , Isprapprover = (?) , Ispaymentapprover = (?) , C_Salary_Category_ID = (?) , Taxid = (?) , Referenceno = (?) , C_Bp_Group_ID = (?) , AD_Language = (?) , Country = (?) , Zipcode = (?) , City = (?) , A_Asset_ID = (?) , C_BPartner_ID = (?) , Isemployee = (?) , Istaxexempt = (?) , C_Greeting_ID = (?) , Rating = (?) , updated = now(), updatedby = ? " +
      "        WHERE c_bpartneremployee_view.C_BPartner_ID = ? " +
      "        AND c_bpartneremployee_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_bpartneremployee_view.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinresourceplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issalesrep);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprojectmanager);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprocurementmanager);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isworker);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isapprover);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, approvalamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprapprover);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaymentapprover);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, country);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zipcode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, city);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isemployee);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxexempt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGreetingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rating);
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
      "        INSERT INTO c_bpartneremployee_view " +
      "        (AD_Client_ID, AD_Org_ID, Value, Name, Description, Isactive, isinresourceplan, Issalesrep, Isprojectmanager, Isprocurementmanager, Isworker, Isapprover, Approvalamt, Isprapprover, Ispaymentapprover, C_Salary_Category_ID, Taxid, Referenceno, C_Bp_Group_ID, AD_Language, Country, Zipcode, City, A_Asset_ID, C_BPartner_ID, Isemployee, Istaxexempt, C_Greeting_ID, Rating, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinresourceplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issalesrep);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprojectmanager);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprocurementmanager);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isworker);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isapprover);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, approvalamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprapprover);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaymentapprover);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, country);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zipcode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, city);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isemployee);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxexempt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGreetingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rating);
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
      "        DELETE FROM c_bpartneremployee_view" +
      "        WHERE c_bpartneremployee_view.C_BPartner_ID = ? " +
      "        AND c_bpartneremployee_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_bpartneremployee_view.AD_Org_ID IN (";
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
      "        DELETE FROM c_bpartneremployee_view" +
      "        WHERE c_bpartneremployee_view.C_BPartner_ID = ? ";

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
      "          FROM c_bpartneremployee_view" +
      "         WHERE c_bpartneremployee_view.C_BPartner_ID = ? ";

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
      "          FROM c_bpartneremployee_view" +
      "         WHERE c_bpartneremployee_view.C_BPartner_ID = ? ";

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
