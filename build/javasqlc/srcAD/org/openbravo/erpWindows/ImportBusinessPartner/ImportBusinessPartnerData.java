//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ImportBusinessPartner;

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
class ImportBusinessPartnerData implements FieldProvider {
static Logger log4j = Logger.getLogger(ImportBusinessPartnerData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String isactive;
  public String iBpartnerId;
  public String iIsimported;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String iErrormsg;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String value;
  public String name;
  public String name2;
  public String description;
  public String externalsynccode;
  public String issaleslead;
  public String iscustomer;
  public String customerpaymentterms;
  public String isvendor;
  public String duns;
  public String naics;
  public String taxid;
  public String groupvalue;
  public String cBpGroupId;
  public String cBpGroupIdr;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String address1;
  public String address2;
  public String postal;
  public String postalAdd;
  public String city;
  public String regionname;
  public String cRegionId;
  public String cRegionIdr;
  public String countrycode;
  public String cCountryId;
  public String cCountryIdr;
  public String isheadquarter;
  public String taxataddress;
  public String adUserId;
  public String adUserIdr;
  public String title;
  public String contactname;
  public String contactdescription;
  public String comments;
  public String phone;
  public String phone2;
  public String fax;
  public String email;
  public String password;
  public String birthday;
  public String bpcontactgreeting;
  public String cGreetingId;
  public String cGreetingIdr;
  public String processing;
  public String processed;
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
    else if (fieldName.equalsIgnoreCase("i_bpartner_id") || fieldName.equals("iBpartnerId"))
      return iBpartnerId;
    else if (fieldName.equalsIgnoreCase("i_isimported") || fieldName.equals("iIsimported"))
      return iIsimported;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("i_errormsg") || fieldName.equals("iErrormsg"))
      return iErrormsg;
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
    else if (fieldName.equalsIgnoreCase("name2"))
      return name2;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("externalsynccode"))
      return externalsynccode;
    else if (fieldName.equalsIgnoreCase("issaleslead"))
      return issaleslead;
    else if (fieldName.equalsIgnoreCase("iscustomer"))
      return iscustomer;
    else if (fieldName.equalsIgnoreCase("customerpaymentterms"))
      return customerpaymentterms;
    else if (fieldName.equalsIgnoreCase("isvendor"))
      return isvendor;
    else if (fieldName.equalsIgnoreCase("duns"))
      return duns;
    else if (fieldName.equalsIgnoreCase("naics"))
      return naics;
    else if (fieldName.equalsIgnoreCase("taxid"))
      return taxid;
    else if (fieldName.equalsIgnoreCase("groupvalue"))
      return groupvalue;
    else if (fieldName.equalsIgnoreCase("c_bp_group_id") || fieldName.equals("cBpGroupId"))
      return cBpGroupId;
    else if (fieldName.equalsIgnoreCase("c_bp_group_idr") || fieldName.equals("cBpGroupIdr"))
      return cBpGroupIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("address1"))
      return address1;
    else if (fieldName.equalsIgnoreCase("address2"))
      return address2;
    else if (fieldName.equalsIgnoreCase("postal"))
      return postal;
    else if (fieldName.equalsIgnoreCase("postal_add") || fieldName.equals("postalAdd"))
      return postalAdd;
    else if (fieldName.equalsIgnoreCase("city"))
      return city;
    else if (fieldName.equalsIgnoreCase("regionname"))
      return regionname;
    else if (fieldName.equalsIgnoreCase("c_region_id") || fieldName.equals("cRegionId"))
      return cRegionId;
    else if (fieldName.equalsIgnoreCase("c_region_idr") || fieldName.equals("cRegionIdr"))
      return cRegionIdr;
    else if (fieldName.equalsIgnoreCase("countrycode"))
      return countrycode;
    else if (fieldName.equalsIgnoreCase("c_country_id") || fieldName.equals("cCountryId"))
      return cCountryId;
    else if (fieldName.equalsIgnoreCase("c_country_idr") || fieldName.equals("cCountryIdr"))
      return cCountryIdr;
    else if (fieldName.equalsIgnoreCase("isheadquarter"))
      return isheadquarter;
    else if (fieldName.equalsIgnoreCase("taxataddress"))
      return taxataddress;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("title"))
      return title;
    else if (fieldName.equalsIgnoreCase("contactname"))
      return contactname;
    else if (fieldName.equalsIgnoreCase("contactdescription"))
      return contactdescription;
    else if (fieldName.equalsIgnoreCase("comments"))
      return comments;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("phone2"))
      return phone2;
    else if (fieldName.equalsIgnoreCase("fax"))
      return fax;
    else if (fieldName.equalsIgnoreCase("email"))
      return email;
    else if (fieldName.equalsIgnoreCase("password"))
      return password;
    else if (fieldName.equalsIgnoreCase("birthday"))
      return birthday;
    else if (fieldName.equalsIgnoreCase("bpcontactgreeting"))
      return bpcontactgreeting;
    else if (fieldName.equalsIgnoreCase("c_greeting_id") || fieldName.equals("cGreetingId"))
      return cGreetingId;
    else if (fieldName.equalsIgnoreCase("c_greeting_idr") || fieldName.equals("cGreetingIdr"))
      return cGreetingIdr;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
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
  public static ImportBusinessPartnerData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ImportBusinessPartnerData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(I_BPartner.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = I_BPartner.CreatedBy) as CreatedByR, " +
      "        to_char(I_BPartner.Updated, ?) as updated, " +
      "        to_char(I_BPartner.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        I_BPartner.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = I_BPartner.UpdatedBy) as UpdatedByR," +
      "        COALESCE(I_BPartner.IsActive, 'N') AS IsActive, " +
      "I_BPartner.I_BPartner_ID, " +
      "COALESCE(I_BPartner.I_IsImported, 'N') AS I_IsImported, " +
      "I_BPartner.C_BPartner_ID, " +
      "(CASE WHEN I_BPartner.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "I_BPartner.I_ErrorMsg, " +
      "I_BPartner.AD_Client_ID, " +
      "(CASE WHEN I_BPartner.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "I_BPartner.AD_Org_ID, " +
      "(CASE WHEN I_BPartner.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "I_BPartner.Value, " +
      "I_BPartner.Name, " +
      "I_BPartner.Name2, " +
      "I_BPartner.Description, " +
      "I_BPartner.Externalsynccode, " +
      "COALESCE(I_BPartner.Issaleslead, 'N') AS Issaleslead, " +
      "COALESCE(I_BPartner.Iscustomer, 'N') AS Iscustomer, " +
      "I_BPartner.Customerpaymentterms, " +
      "COALESCE(I_BPartner.Isvendor, 'N') AS Isvendor, " +
      "I_BPartner.DUNS, " +
      "I_BPartner.NAICS, " +
      "I_BPartner.TaxID, " +
      "I_BPartner.GroupValue, " +
      "I_BPartner.C_BP_Group_ID, " +
      "(CASE WHEN I_BPartner.C_BP_Group_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_BP_Group_IDR, " +
      "I_BPartner.C_BPartner_Location_ID, " +
      "(CASE WHEN I_BPartner.C_BPartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_BPartner_Location_IDR, " +
      "I_BPartner.Address1, " +
      "I_BPartner.Address2, " +
      "I_BPartner.Postal, " +
      "I_BPartner.Postal_Add, " +
      "I_BPartner.City, " +
      "I_BPartner.RegionName, " +
      "I_BPartner.C_Region_ID, " +
      "(CASE WHEN I_BPartner.C_Region_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_Region_IDR, " +
      "I_BPartner.CountryCode, " +
      "I_BPartner.C_Country_ID, " +
      "(CASE WHEN I_BPartner.C_Country_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL7.Name IS NULL THEN TO_CHAR(table7.Name) ELSE TO_CHAR(tableTRL7.Name) END)), ''))),'') ) END) AS C_Country_IDR, " +
      "COALESCE(I_BPartner.Isheadquarter, 'N') AS Isheadquarter, " +
      "I_BPartner.Taxataddress, " +
      "I_BPartner.AD_User_ID, " +
      "(CASE WHEN I_BPartner.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "I_BPartner.Title, " +
      "I_BPartner.ContactName, " +
      "I_BPartner.ContactDescription, " +
      "I_BPartner.Comments, " +
      "I_BPartner.Phone, " +
      "I_BPartner.Phone2, " +
      "I_BPartner.Fax, " +
      "I_BPartner.Email, " +
      "I_BPartner.Password, " +
      "I_BPartner.Birthday, " +
      "I_BPartner.BPContactGreeting, " +
      "I_BPartner.C_Greeting_ID, " +
      "(CASE WHEN I_BPartner.C_Greeting_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL9.Name IS NULL THEN TO_CHAR(table9.Name) ELSE TO_CHAR(tableTRL9.Name) END)), ''))),'') ) END) AS C_Greeting_IDR, " +
      "I_BPartner.Processing, " +
      "COALESCE(I_BPartner.Processed, 'N') AS Processed, " +
      "        ? AS LANGUAGE " +
      "        FROM I_BPartner left join (select C_BPartner_ID, Name from C_BPartner) table1 on (I_BPartner.C_BPartner_ID = table1.C_BPartner_ID) left join (select AD_Client_ID, Name from AD_Client) table2 on (I_BPartner.AD_Client_ID = table2.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table3 on (I_BPartner.AD_Org_ID = table3.AD_Org_ID) left join (select C_BP_Group_ID, Name from C_BP_Group) table4 on (I_BPartner.C_BP_Group_ID = table4.C_BP_Group_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table5 on (I_BPartner.C_BPartner_Location_ID = table5.C_BPartner_Location_ID) left join (select C_Region_ID, Name from C_Region) table6 on (I_BPartner.C_Region_ID = table6.C_Region_ID) left join (select C_Country_ID, Name from C_Country) table7 on (I_BPartner.C_Country_ID = table7.C_Country_ID) left join (select C_Country_ID,AD_Language, Name from C_Country_TRL) tableTRL7 on (table7.C_Country_ID = tableTRL7.C_Country_ID and tableTRL7.AD_Language = ?)  left join (select AD_User_ID, Name from AD_User) table8 on (I_BPartner.AD_User_ID = table8.AD_User_ID) left join (select C_Greeting_ID, Name from C_Greeting) table9 on (I_BPartner.C_Greeting_ID = table9.C_Greeting_ID) left join (select C_Greeting_ID,AD_Language, Name from C_Greeting_TRL) tableTRL9 on (table9.C_Greeting_ID = tableTRL9.C_Greeting_ID and tableTRL9.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND I_BPartner.I_BPartner_ID = ? " +
      "        AND I_BPartner.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND I_BPartner.AD_Org_ID IN (";
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
        ImportBusinessPartnerData objectImportBusinessPartnerData = new ImportBusinessPartnerData();
        objectImportBusinessPartnerData.created = UtilSql.getValue(result, "created");
        objectImportBusinessPartnerData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectImportBusinessPartnerData.updated = UtilSql.getValue(result, "updated");
        objectImportBusinessPartnerData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectImportBusinessPartnerData.updatedby = UtilSql.getValue(result, "updatedby");
        objectImportBusinessPartnerData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectImportBusinessPartnerData.isactive = UtilSql.getValue(result, "isactive");
        objectImportBusinessPartnerData.iBpartnerId = UtilSql.getValue(result, "i_bpartner_id");
        objectImportBusinessPartnerData.iIsimported = UtilSql.getValue(result, "i_isimported");
        objectImportBusinessPartnerData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectImportBusinessPartnerData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectImportBusinessPartnerData.iErrormsg = UtilSql.getValue(result, "i_errormsg");
        objectImportBusinessPartnerData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectImportBusinessPartnerData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectImportBusinessPartnerData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectImportBusinessPartnerData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectImportBusinessPartnerData.value = UtilSql.getValue(result, "value");
        objectImportBusinessPartnerData.name = UtilSql.getValue(result, "name");
        objectImportBusinessPartnerData.name2 = UtilSql.getValue(result, "name2");
        objectImportBusinessPartnerData.description = UtilSql.getValue(result, "description");
        objectImportBusinessPartnerData.externalsynccode = UtilSql.getValue(result, "externalsynccode");
        objectImportBusinessPartnerData.issaleslead = UtilSql.getValue(result, "issaleslead");
        objectImportBusinessPartnerData.iscustomer = UtilSql.getValue(result, "iscustomer");
        objectImportBusinessPartnerData.customerpaymentterms = UtilSql.getValue(result, "customerpaymentterms");
        objectImportBusinessPartnerData.isvendor = UtilSql.getValue(result, "isvendor");
        objectImportBusinessPartnerData.duns = UtilSql.getValue(result, "duns");
        objectImportBusinessPartnerData.naics = UtilSql.getValue(result, "naics");
        objectImportBusinessPartnerData.taxid = UtilSql.getValue(result, "taxid");
        objectImportBusinessPartnerData.groupvalue = UtilSql.getValue(result, "groupvalue");
        objectImportBusinessPartnerData.cBpGroupId = UtilSql.getValue(result, "c_bp_group_id");
        objectImportBusinessPartnerData.cBpGroupIdr = UtilSql.getValue(result, "c_bp_group_idr");
        objectImportBusinessPartnerData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectImportBusinessPartnerData.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectImportBusinessPartnerData.address1 = UtilSql.getValue(result, "address1");
        objectImportBusinessPartnerData.address2 = UtilSql.getValue(result, "address2");
        objectImportBusinessPartnerData.postal = UtilSql.getValue(result, "postal");
        objectImportBusinessPartnerData.postalAdd = UtilSql.getValue(result, "postal_add");
        objectImportBusinessPartnerData.city = UtilSql.getValue(result, "city");
        objectImportBusinessPartnerData.regionname = UtilSql.getValue(result, "regionname");
        objectImportBusinessPartnerData.cRegionId = UtilSql.getValue(result, "c_region_id");
        objectImportBusinessPartnerData.cRegionIdr = UtilSql.getValue(result, "c_region_idr");
        objectImportBusinessPartnerData.countrycode = UtilSql.getValue(result, "countrycode");
        objectImportBusinessPartnerData.cCountryId = UtilSql.getValue(result, "c_country_id");
        objectImportBusinessPartnerData.cCountryIdr = UtilSql.getValue(result, "c_country_idr");
        objectImportBusinessPartnerData.isheadquarter = UtilSql.getValue(result, "isheadquarter");
        objectImportBusinessPartnerData.taxataddress = UtilSql.getValue(result, "taxataddress");
        objectImportBusinessPartnerData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectImportBusinessPartnerData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectImportBusinessPartnerData.title = UtilSql.getValue(result, "title");
        objectImportBusinessPartnerData.contactname = UtilSql.getValue(result, "contactname");
        objectImportBusinessPartnerData.contactdescription = UtilSql.getValue(result, "contactdescription");
        objectImportBusinessPartnerData.comments = UtilSql.getValue(result, "comments");
        objectImportBusinessPartnerData.phone = UtilSql.getValue(result, "phone");
        objectImportBusinessPartnerData.phone2 = UtilSql.getValue(result, "phone2");
        objectImportBusinessPartnerData.fax = UtilSql.getValue(result, "fax");
        objectImportBusinessPartnerData.email = UtilSql.getValue(result, "email");
        objectImportBusinessPartnerData.password = UtilSql.getValue(result, "password");
        objectImportBusinessPartnerData.birthday = UtilSql.getDateValue(result, "birthday", "dd-MM-yyyy");
        objectImportBusinessPartnerData.bpcontactgreeting = UtilSql.getValue(result, "bpcontactgreeting");
        objectImportBusinessPartnerData.cGreetingId = UtilSql.getValue(result, "c_greeting_id");
        objectImportBusinessPartnerData.cGreetingIdr = UtilSql.getValue(result, "c_greeting_idr");
        objectImportBusinessPartnerData.processing = UtilSql.getValue(result, "processing");
        objectImportBusinessPartnerData.processed = UtilSql.getValue(result, "processed");
        objectImportBusinessPartnerData.language = UtilSql.getValue(result, "language");
        objectImportBusinessPartnerData.adUserClient = "";
        objectImportBusinessPartnerData.adOrgClient = "";
        objectImportBusinessPartnerData.createdby = "";
        objectImportBusinessPartnerData.trBgcolor = "";
        objectImportBusinessPartnerData.totalCount = "";
        objectImportBusinessPartnerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImportBusinessPartnerData);
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
    ImportBusinessPartnerData objectImportBusinessPartnerData[] = new ImportBusinessPartnerData[vector.size()];
    vector.copyInto(objectImportBusinessPartnerData);
    return(objectImportBusinessPartnerData);
  }

/**
Create a registry
 */
  public static ImportBusinessPartnerData[] set(String phone2, String issaleslead, String email, String contactdescription, String adOrgId, String isactive, String password, String iscustomer, String title, String birthday, String naics, String taxid, String externalsynccode, String value, String updatedby, String updatedbyr, String phone, String isheadquarter, String cGreetingId, String taxataddress, String comments, String regionname, String iBpartnerId, String postal, String iErrormsg, String processing, String bpcontactgreeting, String city, String cBpGroupId, String contactname, String adUserId, String name, String iIsimported, String cRegionId, String address2, String countrycode, String groupvalue, String cBpartnerId, String cBpartnerIdr, String description, String postalAdd, String fax, String isvendor, String processed, String duns, String createdby, String createdbyr, String adClientId, String cBpartnerLocationId, String customerpaymentterms, String cCountryId, String address1, String name2)    throws ServletException {
    ImportBusinessPartnerData objectImportBusinessPartnerData[] = new ImportBusinessPartnerData[1];
    objectImportBusinessPartnerData[0] = new ImportBusinessPartnerData();
    objectImportBusinessPartnerData[0].created = "";
    objectImportBusinessPartnerData[0].createdbyr = createdbyr;
    objectImportBusinessPartnerData[0].updated = "";
    objectImportBusinessPartnerData[0].updatedTimeStamp = "";
    objectImportBusinessPartnerData[0].updatedby = updatedby;
    objectImportBusinessPartnerData[0].updatedbyr = updatedbyr;
    objectImportBusinessPartnerData[0].isactive = isactive;
    objectImportBusinessPartnerData[0].iBpartnerId = iBpartnerId;
    objectImportBusinessPartnerData[0].iIsimported = iIsimported;
    objectImportBusinessPartnerData[0].cBpartnerId = cBpartnerId;
    objectImportBusinessPartnerData[0].cBpartnerIdr = cBpartnerIdr;
    objectImportBusinessPartnerData[0].iErrormsg = iErrormsg;
    objectImportBusinessPartnerData[0].adClientId = adClientId;
    objectImportBusinessPartnerData[0].adClientIdr = "";
    objectImportBusinessPartnerData[0].adOrgId = adOrgId;
    objectImportBusinessPartnerData[0].adOrgIdr = "";
    objectImportBusinessPartnerData[0].value = value;
    objectImportBusinessPartnerData[0].name = name;
    objectImportBusinessPartnerData[0].name2 = name2;
    objectImportBusinessPartnerData[0].description = description;
    objectImportBusinessPartnerData[0].externalsynccode = externalsynccode;
    objectImportBusinessPartnerData[0].issaleslead = issaleslead;
    objectImportBusinessPartnerData[0].iscustomer = iscustomer;
    objectImportBusinessPartnerData[0].customerpaymentterms = customerpaymentterms;
    objectImportBusinessPartnerData[0].isvendor = isvendor;
    objectImportBusinessPartnerData[0].duns = duns;
    objectImportBusinessPartnerData[0].naics = naics;
    objectImportBusinessPartnerData[0].taxid = taxid;
    objectImportBusinessPartnerData[0].groupvalue = groupvalue;
    objectImportBusinessPartnerData[0].cBpGroupId = cBpGroupId;
    objectImportBusinessPartnerData[0].cBpGroupIdr = "";
    objectImportBusinessPartnerData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectImportBusinessPartnerData[0].cBpartnerLocationIdr = "";
    objectImportBusinessPartnerData[0].address1 = address1;
    objectImportBusinessPartnerData[0].address2 = address2;
    objectImportBusinessPartnerData[0].postal = postal;
    objectImportBusinessPartnerData[0].postalAdd = postalAdd;
    objectImportBusinessPartnerData[0].city = city;
    objectImportBusinessPartnerData[0].regionname = regionname;
    objectImportBusinessPartnerData[0].cRegionId = cRegionId;
    objectImportBusinessPartnerData[0].cRegionIdr = "";
    objectImportBusinessPartnerData[0].countrycode = countrycode;
    objectImportBusinessPartnerData[0].cCountryId = cCountryId;
    objectImportBusinessPartnerData[0].cCountryIdr = "";
    objectImportBusinessPartnerData[0].isheadquarter = isheadquarter;
    objectImportBusinessPartnerData[0].taxataddress = taxataddress;
    objectImportBusinessPartnerData[0].adUserId = adUserId;
    objectImportBusinessPartnerData[0].adUserIdr = "";
    objectImportBusinessPartnerData[0].title = title;
    objectImportBusinessPartnerData[0].contactname = contactname;
    objectImportBusinessPartnerData[0].contactdescription = contactdescription;
    objectImportBusinessPartnerData[0].comments = comments;
    objectImportBusinessPartnerData[0].phone = phone;
    objectImportBusinessPartnerData[0].phone2 = phone2;
    objectImportBusinessPartnerData[0].fax = fax;
    objectImportBusinessPartnerData[0].email = email;
    objectImportBusinessPartnerData[0].password = password;
    objectImportBusinessPartnerData[0].birthday = birthday;
    objectImportBusinessPartnerData[0].bpcontactgreeting = bpcontactgreeting;
    objectImportBusinessPartnerData[0].cGreetingId = cGreetingId;
    objectImportBusinessPartnerData[0].cGreetingIdr = "";
    objectImportBusinessPartnerData[0].processing = processing;
    objectImportBusinessPartnerData[0].processed = processed;
    objectImportBusinessPartnerData[0].language = "";
    return objectImportBusinessPartnerData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef7879_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef7906_1(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
  public static String selectDef7880_2(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
      "        UPDATE I_BPartner" +
      "        SET IsActive = (?) , I_BPartner_ID = (?) , I_IsImported = (?) , C_BPartner_ID = (?) , I_ErrorMsg = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Value = (?) , Name = (?) , Name2 = (?) , Description = (?) , Externalsynccode = (?) , Issaleslead = (?) , Iscustomer = (?) , Customerpaymentterms = (?) , Isvendor = (?) , DUNS = (?) , NAICS = (?) , TaxID = (?) , GroupValue = (?) , C_BP_Group_ID = (?) , C_BPartner_Location_ID = (?) , Address1 = (?) , Address2 = (?) , Postal = (?) , Postal_Add = (?) , City = (?) , RegionName = (?) , C_Region_ID = (?) , CountryCode = (?) , C_Country_ID = (?) , Isheadquarter = (?) , Taxataddress = (?) , AD_User_ID = (?) , Title = (?) , ContactName = (?) , ContactDescription = (?) , Comments = (?) , Phone = (?) , Phone2 = (?) , Fax = (?) , Email = (?) , Password = (?) , Birthday = TO_DATE(?) , BPContactGreeting = (?) , C_Greeting_ID = (?) , Processing = (?) , Processed = (?) , updated = now(), updatedby = ? " +
      "        WHERE I_BPartner.I_BPartner_ID = ? " +
      "        AND I_BPartner.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND I_BPartner.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iIsimported);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iErrormsg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, externalsynccode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issaleslead);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscustomer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, customerpaymentterms);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvendor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, duns);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, naics);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postalAdd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, city);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, regionname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRegionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, countrycode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isheadquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxataddress);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, title);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contactname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contactdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, comments);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, password);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, birthday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpcontactgreeting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGreetingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iBpartnerId);
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
      "        INSERT INTO I_BPartner " +
      "        (IsActive, I_BPartner_ID, I_IsImported, C_BPartner_ID, I_ErrorMsg, AD_Client_ID, AD_Org_ID, Value, Name, Name2, Description, Externalsynccode, Issaleslead, Iscustomer, Customerpaymentterms, Isvendor, DUNS, NAICS, TaxID, GroupValue, C_BP_Group_ID, C_BPartner_Location_ID, Address1, Address2, Postal, Postal_Add, City, RegionName, C_Region_ID, CountryCode, C_Country_ID, Isheadquarter, Taxataddress, AD_User_ID, Title, ContactName, ContactDescription, Comments, Phone, Phone2, Fax, Email, Password, Birthday, BPContactGreeting, C_Greeting_ID, Processing, Processed, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iIsimported);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iErrormsg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, externalsynccode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issaleslead);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscustomer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, customerpaymentterms);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvendor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, duns);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, naics);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postalAdd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, city);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, regionname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRegionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, countrycode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isheadquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxataddress);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, title);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contactname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contactdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, comments);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, password);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, birthday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpcontactgreeting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGreetingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
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
      "        DELETE FROM I_BPartner" +
      "        WHERE I_BPartner.I_BPartner_ID = ? " +
      "        AND I_BPartner.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND I_BPartner.AD_Org_ID IN (";
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
      "        DELETE FROM I_BPartner" +
      "        WHERE I_BPartner.I_BPartner_ID = ? ";

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
      "          FROM I_BPartner" +
      "         WHERE I_BPartner.I_BPartner_ID = ? ";

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
      "          FROM I_BPartner" +
      "         WHERE I_BPartner.I_BPartner_ID = ? ";

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
