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
class BusinessPartnerData implements FieldProvider {
static Logger log4j = Logger.getLogger(BusinessPartnerData.class);
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
  public String name2;
  public String description;
  public String isactive;
  public String issaleslead;
  public String taxid;
  public String referenceno;
  public String rating;
  public String owncodeatpartnersite;
  public String cBpGroupId;
  public String cBpGroupIdr;
  public String adLanguage;
  public String adLanguager;
  public String zssiGroupofcompaniesId;
  public String zssiGroupofcompaniesIdr;
  public String cLineofbusinessId;
  public String cLineofbusinessIdr;
  public String country;
  public String zipcode;
  public String city;
  public String url;
  public String isprospect;
  public String potentiallifetimevalue;
  public String actuallifetimevalue;
  public String numberemployees;
  public String shareofcustomer;
  public String lastDays;
  public String salesvolume;
  public String firstsale;
  public String acqusitioncost;
  public String istaxexempt;
  public String isonetime;
  public String soCreditused;
  public String naics;
  public String issummary;
  public String duns;
  public String cBpartnerId;
  public String adForcedOrgId;
  public String showpriceinorder;
  public String iscustomer;
  public String isvendor;
  public String upc;
  public String isofiscalcode;
  public String invoicegrouping;
  public String socreditstatus;
  public String isworker;
  public String invoicerule;
  public String fiscalcode;
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
    else if (fieldName.equalsIgnoreCase("name2"))
      return name2;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("issaleslead"))
      return issaleslead;
    else if (fieldName.equalsIgnoreCase("taxid"))
      return taxid;
    else if (fieldName.equalsIgnoreCase("referenceno"))
      return referenceno;
    else if (fieldName.equalsIgnoreCase("rating"))
      return rating;
    else if (fieldName.equalsIgnoreCase("owncodeatpartnersite"))
      return owncodeatpartnersite;
    else if (fieldName.equalsIgnoreCase("c_bp_group_id") || fieldName.equals("cBpGroupId"))
      return cBpGroupId;
    else if (fieldName.equalsIgnoreCase("c_bp_group_idr") || fieldName.equals("cBpGroupIdr"))
      return cBpGroupIdr;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("zssi_groupofcompanies_id") || fieldName.equals("zssiGroupofcompaniesId"))
      return zssiGroupofcompaniesId;
    else if (fieldName.equalsIgnoreCase("zssi_groupofcompanies_idr") || fieldName.equals("zssiGroupofcompaniesIdr"))
      return zssiGroupofcompaniesIdr;
    else if (fieldName.equalsIgnoreCase("c_lineofbusiness_id") || fieldName.equals("cLineofbusinessId"))
      return cLineofbusinessId;
    else if (fieldName.equalsIgnoreCase("c_lineofbusiness_idr") || fieldName.equals("cLineofbusinessIdr"))
      return cLineofbusinessIdr;
    else if (fieldName.equalsIgnoreCase("country"))
      return country;
    else if (fieldName.equalsIgnoreCase("zipcode"))
      return zipcode;
    else if (fieldName.equalsIgnoreCase("city"))
      return city;
    else if (fieldName.equalsIgnoreCase("url"))
      return url;
    else if (fieldName.equalsIgnoreCase("isprospect"))
      return isprospect;
    else if (fieldName.equalsIgnoreCase("potentiallifetimevalue"))
      return potentiallifetimevalue;
    else if (fieldName.equalsIgnoreCase("actuallifetimevalue"))
      return actuallifetimevalue;
    else if (fieldName.equalsIgnoreCase("numberemployees"))
      return numberemployees;
    else if (fieldName.equalsIgnoreCase("shareofcustomer"))
      return shareofcustomer;
    else if (fieldName.equalsIgnoreCase("last_days") || fieldName.equals("lastDays"))
      return lastDays;
    else if (fieldName.equalsIgnoreCase("salesvolume"))
      return salesvolume;
    else if (fieldName.equalsIgnoreCase("firstsale"))
      return firstsale;
    else if (fieldName.equalsIgnoreCase("acqusitioncost"))
      return acqusitioncost;
    else if (fieldName.equalsIgnoreCase("istaxexempt"))
      return istaxexempt;
    else if (fieldName.equalsIgnoreCase("isonetime"))
      return isonetime;
    else if (fieldName.equalsIgnoreCase("so_creditused") || fieldName.equals("soCreditused"))
      return soCreditused;
    else if (fieldName.equalsIgnoreCase("naics"))
      return naics;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("duns"))
      return duns;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("ad_forced_org_id") || fieldName.equals("adForcedOrgId"))
      return adForcedOrgId;
    else if (fieldName.equalsIgnoreCase("showpriceinorder"))
      return showpriceinorder;
    else if (fieldName.equalsIgnoreCase("iscustomer"))
      return iscustomer;
    else if (fieldName.equalsIgnoreCase("isvendor"))
      return isvendor;
    else if (fieldName.equalsIgnoreCase("upc"))
      return upc;
    else if (fieldName.equalsIgnoreCase("isofiscalcode"))
      return isofiscalcode;
    else if (fieldName.equalsIgnoreCase("invoicegrouping"))
      return invoicegrouping;
    else if (fieldName.equalsIgnoreCase("socreditstatus"))
      return socreditstatus;
    else if (fieldName.equalsIgnoreCase("isworker"))
      return isworker;
    else if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
    else if (fieldName.equalsIgnoreCase("fiscalcode"))
      return fiscalcode;
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
  public static BusinessPartnerData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static BusinessPartnerData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
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
      "C_BPartner.Value, " +
      "C_BPartner.Name, " +
      "C_BPartner.Name2, " +
      "C_BPartner.Description, " +
      "COALESCE(C_BPartner.IsActive, 'N') AS IsActive, " +
      "COALESCE(C_BPartner.isSalesLead, 'N') AS isSalesLead, " +
      "C_BPartner.TaxID, " +
      "C_BPartner.ReferenceNo, " +
      "C_BPartner.Rating, " +
      "C_BPartner.Owncodeatpartnersite, " +
      "C_BPartner.C_BP_Group_ID, " +
      "(CASE WHEN C_BPartner.C_BP_Group_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_BP_Group_IDR, " +
      "C_BPartner.AD_Language, " +
      "(CASE WHEN C_BPartner.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "C_BPartner.Zssi_Groupofcompanies_ID, " +
      "(CASE WHEN C_BPartner.Zssi_Groupofcompanies_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS Zssi_Groupofcompanies_IDR, " +
      "C_BPartner.C_Lineofbusiness_ID, " +
      "(CASE WHEN C_BPartner.C_Lineofbusiness_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS C_Lineofbusiness_IDR, " +
      "C_BPartner.Country, " +
      "C_BPartner.Zipcode, " +
      "C_BPartner.City, " +
      "C_BPartner.URL, " +
      "COALESCE(C_BPartner.IsProspect, 'N') AS IsProspect, " +
      "C_BPartner.PotentialLifeTimeValue, " +
      "C_BPartner.ActualLifeTimeValue, " +
      "C_BPartner.NumberEmployees, " +
      "C_BPartner.ShareOfCustomer, " +
      "C_BPartner.Last_Days, " +
      "C_BPartner.SalesVolume, " +
      "C_BPartner.FirstSale, " +
      "C_BPartner.AcqusitionCost, " +
      "COALESCE(C_BPartner.IsTaxExempt, 'N') AS IsTaxExempt, " +
      "COALESCE(C_BPartner.IsOneTime, 'N') AS IsOneTime, " +
      "C_BPartner.SO_CreditUsed, " +
      "C_BPartner.NAICS, " +
      "COALESCE(C_BPartner.IsSummary, 'N') AS IsSummary, " +
      "C_BPartner.DUNS, " +
      "C_BPartner.C_BPartner_ID, " +
      "C_BPartner.AD_Forced_Org_ID, " +
      "COALESCE(C_BPartner.ShowPriceInOrder, 'N') AS ShowPriceInOrder, " +
      "COALESCE(C_BPartner.IsCustomer, 'N') AS IsCustomer, " +
      "COALESCE(C_BPartner.IsVendor, 'N') AS IsVendor, " +
      "C_BPartner.UPC, " +
      "C_BPartner.ISOFiscalCode, " +
      "C_BPartner.Invoicegrouping, " +
      "C_BPartner.SOCreditStatus, " +
      "COALESCE(C_BPartner.Isworker, 'N') AS Isworker, " +
      "C_BPartner.InvoiceRule, " +
      "C_BPartner.Fiscalcode, " +
      "        ? AS LANGUAGE " +
      "        FROM C_BPartner left join (select AD_Client_ID, Name from AD_Client) table1 on (C_BPartner.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_BPartner.AD_Org_ID = table2.AD_Org_ID) left join (select C_BP_Group_ID, Name from C_BP_Group) table3 on (C_BPartner.C_BP_Group_ID = table3.C_BP_Group_ID) left join (select AD_Language, Name from AD_Language) table4 on (C_BPartner.AD_Language =  table4.AD_Language) left join (select Zssi_Groupofcompanies_ID, Name from Zssi_Groupofcompanies) table5 on (C_BPartner.Zssi_Groupofcompanies_ID = table5.Zssi_Groupofcompanies_ID) left join (select C_Lineofbusiness_ID, Name from C_Lineofbusiness) table6 on (C_BPartner.C_Lineofbusiness_ID = table6.C_Lineofbusiness_ID) left join (select C_Lineofbusiness_ID,AD_Language, Name from c_lineofbusiness_TRL) tableTRL6 on (table6.C_Lineofbusiness_ID = tableTRL6.C_Lineofbusiness_ID and tableTRL6.AD_Language = ?) " +
      "        WHERE 2=2 " +
      " AND c_bpartner.isemployee='N'" +
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
        BusinessPartnerData objectBusinessPartnerData = new BusinessPartnerData();
        objectBusinessPartnerData.created = UtilSql.getValue(result, "created");
        objectBusinessPartnerData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectBusinessPartnerData.updated = UtilSql.getValue(result, "updated");
        objectBusinessPartnerData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectBusinessPartnerData.updatedby = UtilSql.getValue(result, "updatedby");
        objectBusinessPartnerData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectBusinessPartnerData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectBusinessPartnerData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectBusinessPartnerData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectBusinessPartnerData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectBusinessPartnerData.value = UtilSql.getValue(result, "value");
        objectBusinessPartnerData.name = UtilSql.getValue(result, "name");
        objectBusinessPartnerData.name2 = UtilSql.getValue(result, "name2");
        objectBusinessPartnerData.description = UtilSql.getValue(result, "description");
        objectBusinessPartnerData.isactive = UtilSql.getValue(result, "isactive");
        objectBusinessPartnerData.issaleslead = UtilSql.getValue(result, "issaleslead");
        objectBusinessPartnerData.taxid = UtilSql.getValue(result, "taxid");
        objectBusinessPartnerData.referenceno = UtilSql.getValue(result, "referenceno");
        objectBusinessPartnerData.rating = UtilSql.getValue(result, "rating");
        objectBusinessPartnerData.owncodeatpartnersite = UtilSql.getValue(result, "owncodeatpartnersite");
        objectBusinessPartnerData.cBpGroupId = UtilSql.getValue(result, "c_bp_group_id");
        objectBusinessPartnerData.cBpGroupIdr = UtilSql.getValue(result, "c_bp_group_idr");
        objectBusinessPartnerData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectBusinessPartnerData.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectBusinessPartnerData.zssiGroupofcompaniesId = UtilSql.getValue(result, "zssi_groupofcompanies_id");
        objectBusinessPartnerData.zssiGroupofcompaniesIdr = UtilSql.getValue(result, "zssi_groupofcompanies_idr");
        objectBusinessPartnerData.cLineofbusinessId = UtilSql.getValue(result, "c_lineofbusiness_id");
        objectBusinessPartnerData.cLineofbusinessIdr = UtilSql.getValue(result, "c_lineofbusiness_idr");
        objectBusinessPartnerData.country = UtilSql.getValue(result, "country");
        objectBusinessPartnerData.zipcode = UtilSql.getValue(result, "zipcode");
        objectBusinessPartnerData.city = UtilSql.getValue(result, "city");
        objectBusinessPartnerData.url = UtilSql.getValue(result, "url");
        objectBusinessPartnerData.isprospect = UtilSql.getValue(result, "isprospect");
        objectBusinessPartnerData.potentiallifetimevalue = UtilSql.getValue(result, "potentiallifetimevalue");
        objectBusinessPartnerData.actuallifetimevalue = UtilSql.getValue(result, "actuallifetimevalue");
        objectBusinessPartnerData.numberemployees = UtilSql.getValue(result, "numberemployees");
        objectBusinessPartnerData.shareofcustomer = UtilSql.getValue(result, "shareofcustomer");
        objectBusinessPartnerData.lastDays = UtilSql.getValue(result, "last_days");
        objectBusinessPartnerData.salesvolume = UtilSql.getValue(result, "salesvolume");
        objectBusinessPartnerData.firstsale = UtilSql.getDateValue(result, "firstsale", "dd-MM-yyyy");
        objectBusinessPartnerData.acqusitioncost = UtilSql.getValue(result, "acqusitioncost");
        objectBusinessPartnerData.istaxexempt = UtilSql.getValue(result, "istaxexempt");
        objectBusinessPartnerData.isonetime = UtilSql.getValue(result, "isonetime");
        objectBusinessPartnerData.soCreditused = UtilSql.getValue(result, "so_creditused");
        objectBusinessPartnerData.naics = UtilSql.getValue(result, "naics");
        objectBusinessPartnerData.issummary = UtilSql.getValue(result, "issummary");
        objectBusinessPartnerData.duns = UtilSql.getValue(result, "duns");
        objectBusinessPartnerData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectBusinessPartnerData.adForcedOrgId = UtilSql.getValue(result, "ad_forced_org_id");
        objectBusinessPartnerData.showpriceinorder = UtilSql.getValue(result, "showpriceinorder");
        objectBusinessPartnerData.iscustomer = UtilSql.getValue(result, "iscustomer");
        objectBusinessPartnerData.isvendor = UtilSql.getValue(result, "isvendor");
        objectBusinessPartnerData.upc = UtilSql.getValue(result, "upc");
        objectBusinessPartnerData.isofiscalcode = UtilSql.getValue(result, "isofiscalcode");
        objectBusinessPartnerData.invoicegrouping = UtilSql.getValue(result, "invoicegrouping");
        objectBusinessPartnerData.socreditstatus = UtilSql.getValue(result, "socreditstatus");
        objectBusinessPartnerData.isworker = UtilSql.getValue(result, "isworker");
        objectBusinessPartnerData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectBusinessPartnerData.fiscalcode = UtilSql.getValue(result, "fiscalcode");
        objectBusinessPartnerData.language = UtilSql.getValue(result, "language");
        objectBusinessPartnerData.adUserClient = "";
        objectBusinessPartnerData.adOrgClient = "";
        objectBusinessPartnerData.createdby = "";
        objectBusinessPartnerData.trBgcolor = "";
        objectBusinessPartnerData.totalCount = "";
        objectBusinessPartnerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBusinessPartnerData);
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
    BusinessPartnerData objectBusinessPartnerData[] = new BusinessPartnerData[vector.size()];
    vector.copyInto(objectBusinessPartnerData);
    return(objectBusinessPartnerData);
  }

/**
Create a registry
 */
  public static BusinessPartnerData[] set(String referenceno, String name, String soCreditused, String isactive, String owncodeatpartnersite, String lastDays, String updatedby, String updatedbyr, String upc, String actuallifetimevalue, String description, String isonetime, String cBpartnerId, String numberemployees, String country, String invoicerule, String zssiGroupofcompaniesId, String shareofcustomer, String firstsale, String city, String fiscalcode, String adLanguage, String taxid, String zipcode, String value, String issaleslead, String adOrgId, String issummary, String duns, String showpriceinorder, String invoicegrouping, String createdby, String createdbyr, String rating, String salesvolume, String name2, String socreditstatus, String adClientId, String cLineofbusinessId, String url, String adForcedOrgId, String naics, String acqusitioncost, String iscustomer, String isofiscalcode, String istaxexempt, String cBpGroupId, String isworker, String isvendor, String potentiallifetimevalue, String isprospect)    throws ServletException {
    BusinessPartnerData objectBusinessPartnerData[] = new BusinessPartnerData[1];
    objectBusinessPartnerData[0] = new BusinessPartnerData();
    objectBusinessPartnerData[0].created = "";
    objectBusinessPartnerData[0].createdbyr = createdbyr;
    objectBusinessPartnerData[0].updated = "";
    objectBusinessPartnerData[0].updatedTimeStamp = "";
    objectBusinessPartnerData[0].updatedby = updatedby;
    objectBusinessPartnerData[0].updatedbyr = updatedbyr;
    objectBusinessPartnerData[0].adClientId = adClientId;
    objectBusinessPartnerData[0].adClientIdr = "";
    objectBusinessPartnerData[0].adOrgId = adOrgId;
    objectBusinessPartnerData[0].adOrgIdr = "";
    objectBusinessPartnerData[0].value = value;
    objectBusinessPartnerData[0].name = name;
    objectBusinessPartnerData[0].name2 = name2;
    objectBusinessPartnerData[0].description = description;
    objectBusinessPartnerData[0].isactive = isactive;
    objectBusinessPartnerData[0].issaleslead = issaleslead;
    objectBusinessPartnerData[0].taxid = taxid;
    objectBusinessPartnerData[0].referenceno = referenceno;
    objectBusinessPartnerData[0].rating = rating;
    objectBusinessPartnerData[0].owncodeatpartnersite = owncodeatpartnersite;
    objectBusinessPartnerData[0].cBpGroupId = cBpGroupId;
    objectBusinessPartnerData[0].cBpGroupIdr = "";
    objectBusinessPartnerData[0].adLanguage = adLanguage;
    objectBusinessPartnerData[0].adLanguager = "";
    objectBusinessPartnerData[0].zssiGroupofcompaniesId = zssiGroupofcompaniesId;
    objectBusinessPartnerData[0].zssiGroupofcompaniesIdr = "";
    objectBusinessPartnerData[0].cLineofbusinessId = cLineofbusinessId;
    objectBusinessPartnerData[0].cLineofbusinessIdr = "";
    objectBusinessPartnerData[0].country = country;
    objectBusinessPartnerData[0].zipcode = zipcode;
    objectBusinessPartnerData[0].city = city;
    objectBusinessPartnerData[0].url = url;
    objectBusinessPartnerData[0].isprospect = isprospect;
    objectBusinessPartnerData[0].potentiallifetimevalue = potentiallifetimevalue;
    objectBusinessPartnerData[0].actuallifetimevalue = actuallifetimevalue;
    objectBusinessPartnerData[0].numberemployees = numberemployees;
    objectBusinessPartnerData[0].shareofcustomer = shareofcustomer;
    objectBusinessPartnerData[0].lastDays = lastDays;
    objectBusinessPartnerData[0].salesvolume = salesvolume;
    objectBusinessPartnerData[0].firstsale = firstsale;
    objectBusinessPartnerData[0].acqusitioncost = acqusitioncost;
    objectBusinessPartnerData[0].istaxexempt = istaxexempt;
    objectBusinessPartnerData[0].isonetime = isonetime;
    objectBusinessPartnerData[0].soCreditused = soCreditused;
    objectBusinessPartnerData[0].naics = naics;
    objectBusinessPartnerData[0].issummary = issummary;
    objectBusinessPartnerData[0].duns = duns;
    objectBusinessPartnerData[0].cBpartnerId = cBpartnerId;
    objectBusinessPartnerData[0].adForcedOrgId = adForcedOrgId;
    objectBusinessPartnerData[0].showpriceinorder = showpriceinorder;
    objectBusinessPartnerData[0].iscustomer = iscustomer;
    objectBusinessPartnerData[0].isvendor = isvendor;
    objectBusinessPartnerData[0].upc = upc;
    objectBusinessPartnerData[0].isofiscalcode = isofiscalcode;
    objectBusinessPartnerData[0].invoicegrouping = invoicegrouping;
    objectBusinessPartnerData[0].socreditstatus = socreditstatus;
    objectBusinessPartnerData[0].isworker = isworker;
    objectBusinessPartnerData[0].invoicerule = invoicerule;
    objectBusinessPartnerData[0].fiscalcode = fiscalcode;
    objectBusinessPartnerData[0].language = "";
    return objectBusinessPartnerData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2900_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef2898_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
      "        UPDATE C_BPartner" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , Value = (?) , Name = (?) , Name2 = (?) , Description = (?) , IsActive = (?) , isSalesLead = (?) , TaxID = (?) , ReferenceNo = (?) , Rating = (?) , Owncodeatpartnersite = (?) , C_BP_Group_ID = (?) , AD_Language = (?) , Zssi_Groupofcompanies_ID = (?) , C_Lineofbusiness_ID = (?) , Country = (?) , Zipcode = (?) , City = (?) , URL = (?) , IsProspect = (?) , PotentialLifeTimeValue = TO_NUMBER(?) , ActualLifeTimeValue = TO_NUMBER(?) , NumberEmployees = TO_NUMBER(?) , ShareOfCustomer = TO_NUMBER(?) , Last_Days = TO_NUMBER(?) , SalesVolume = TO_NUMBER(?) , FirstSale = TO_DATE(?) , AcqusitionCost = TO_NUMBER(?) , IsTaxExempt = (?) , IsOneTime = (?) , SO_CreditUsed = TO_NUMBER(?) , NAICS = (?) , IsSummary = (?) , DUNS = (?) , C_BPartner_ID = (?) , AD_Forced_Org_ID = (?) , ShowPriceInOrder = (?) , IsCustomer = (?) , IsVendor = (?) , UPC = (?) , ISOFiscalCode = (?) , Invoicegrouping = (?) , SOCreditStatus = (?) , Isworker = (?) , InvoiceRule = (?) , Fiscalcode = (?) , updated = now(), updatedby = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issaleslead);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rating);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, owncodeatpartnersite);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiGroupofcompaniesId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLineofbusinessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, country);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zipcode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, city);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, url);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprospect);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, potentiallifetimevalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actuallifetimevalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, numberemployees);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shareofcustomer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastDays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesvolume);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstsale);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acqusitioncost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxexempt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, soCreditused);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, naics);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, duns);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adForcedOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showpriceinorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscustomer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvendor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isofiscalcode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicegrouping);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, socreditstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isworker);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fiscalcode);
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
      "        (AD_Client_ID, AD_Org_ID, Value, Name, Name2, Description, IsActive, isSalesLead, TaxID, ReferenceNo, Rating, Owncodeatpartnersite, C_BP_Group_ID, AD_Language, Zssi_Groupofcompanies_ID, C_Lineofbusiness_ID, Country, Zipcode, City, URL, IsProspect, PotentialLifeTimeValue, ActualLifeTimeValue, NumberEmployees, ShareOfCustomer, Last_Days, SalesVolume, FirstSale, AcqusitionCost, IsTaxExempt, IsOneTime, SO_CreditUsed, NAICS, IsSummary, DUNS, C_BPartner_ID, AD_Forced_Org_ID, ShowPriceInOrder, IsCustomer, IsVendor, UPC, ISOFiscalCode, Invoicegrouping, SOCreditStatus, Isworker, InvoiceRule, Fiscalcode, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issaleslead);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rating);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, owncodeatpartnersite);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiGroupofcompaniesId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLineofbusinessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, country);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zipcode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, city);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, url);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprospect);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, potentiallifetimevalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actuallifetimevalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, numberemployees);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shareofcustomer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastDays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesvolume);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstsale);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acqusitioncost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxexempt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, soCreditused);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, naics);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, duns);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adForcedOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showpriceinorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscustomer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvendor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isofiscalcode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicegrouping);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, socreditstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isworker);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fiscalcode);
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
