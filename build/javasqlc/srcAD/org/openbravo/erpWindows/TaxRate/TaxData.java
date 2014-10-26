//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.TaxRate;

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
class TaxData implements FieldProvider {
static Logger log4j = Logger.getLogger(TaxData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String istaxexempt;
  public String sopotype;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String name;
  public String description;
  public String line;
  public String taxhint;
  public String cascade;
  public String isactive;
  public String iswithholdingtax;
  public String validfrom;
  public String rate;
  public String deducpercent;
  public String reversecharge;
  public String originalrate;
  public String adduid2fact;
  public String istaxundeductable;
  public String cCountryId;
  public String cCountryIdr;
  public String isnovat;
  public String datevkeyvst;
  public String datevkeyust;
  public String isnotaxable;
  public String isdefault;
  public String issummary;
  public String cRegionId;
  public String toRegionId;
  public String toCountryId;
  public String cTaxId;
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
    else if (fieldName.equalsIgnoreCase("istaxexempt"))
      return istaxexempt;
    else if (fieldName.equalsIgnoreCase("sopotype"))
      return sopotype;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("taxhint"))
      return taxhint;
    else if (fieldName.equalsIgnoreCase("cascade"))
      return cascade;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("iswithholdingtax"))
      return iswithholdingtax;
    else if (fieldName.equalsIgnoreCase("validfrom"))
      return validfrom;
    else if (fieldName.equalsIgnoreCase("rate"))
      return rate;
    else if (fieldName.equalsIgnoreCase("deducpercent"))
      return deducpercent;
    else if (fieldName.equalsIgnoreCase("reversecharge"))
      return reversecharge;
    else if (fieldName.equalsIgnoreCase("originalrate"))
      return originalrate;
    else if (fieldName.equalsIgnoreCase("adduid2fact"))
      return adduid2fact;
    else if (fieldName.equalsIgnoreCase("istaxundeductable"))
      return istaxundeductable;
    else if (fieldName.equalsIgnoreCase("c_country_id") || fieldName.equals("cCountryId"))
      return cCountryId;
    else if (fieldName.equalsIgnoreCase("c_country_idr") || fieldName.equals("cCountryIdr"))
      return cCountryIdr;
    else if (fieldName.equalsIgnoreCase("isnovat"))
      return isnovat;
    else if (fieldName.equalsIgnoreCase("datevkeyvst"))
      return datevkeyvst;
    else if (fieldName.equalsIgnoreCase("datevkeyust"))
      return datevkeyust;
    else if (fieldName.equalsIgnoreCase("isnotaxable"))
      return isnotaxable;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("c_region_id") || fieldName.equals("cRegionId"))
      return cRegionId;
    else if (fieldName.equalsIgnoreCase("to_region_id") || fieldName.equals("toRegionId"))
      return toRegionId;
    else if (fieldName.equalsIgnoreCase("to_country_id") || fieldName.equals("toCountryId"))
      return toCountryId;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
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
  public static TaxData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TaxData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Tax.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Tax.CreatedBy) as CreatedByR, " +
      "        to_char(C_Tax.Updated, ?) as updated, " +
      "        to_char(C_Tax.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Tax.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Tax.UpdatedBy) as UpdatedByR," +
      "        COALESCE(C_Tax.IsTaxExempt, 'N') AS IsTaxExempt, " +
      "C_Tax.SOPOType, " +
      "C_Tax.AD_Client_ID, " +
      "(CASE WHEN C_Tax.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_Tax.AD_Org_ID, " +
      "(CASE WHEN C_Tax.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Tax.Name, " +
      "C_Tax.Description, " +
      "C_Tax.Line, " +
      "C_Tax.Taxhint, " +
      "COALESCE(C_Tax.Cascade, 'N') AS Cascade, " +
      "COALESCE(C_Tax.IsActive, 'N') AS IsActive, " +
      "COALESCE(C_Tax.IsWithholdingTax, 'N') AS IsWithholdingTax, " +
      "C_Tax.ValidFrom, " +
      "C_Tax.Rate, " +
      "C_Tax.Deducpercent, " +
      "COALESCE(C_Tax.Reversecharge, 'N') AS Reversecharge, " +
      "C_Tax.Originalrate, " +
      "COALESCE(C_Tax.Adduid2fact, 'N') AS Adduid2fact, " +
      "COALESCE(C_Tax.IsTaxUndeductable, 'N') AS IsTaxUndeductable, " +
      "C_Tax.C_Country_ID, " +
      "(CASE WHEN C_Tax.C_Country_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_Country_IDR, " +
      "COALESCE(C_Tax.IsNoVAT, 'N') AS IsNoVAT, " +
      "C_Tax.Datevkeyvst, " +
      "C_Tax.Datevkeyust, " +
      "COALESCE(C_Tax.IsNoTaxable, 'N') AS IsNoTaxable, " +
      "COALESCE(C_Tax.IsDefault, 'N') AS IsDefault, " +
      "COALESCE(C_Tax.IsSummary, 'N') AS IsSummary, " +
      "C_Tax.C_Region_ID, " +
      "C_Tax.To_Region_ID, " +
      "C_Tax.To_Country_ID, " +
      "C_Tax.C_Tax_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Tax left join (select AD_Client_ID, Name from AD_Client) table1 on (C_Tax.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_Tax.AD_Org_ID = table2.AD_Org_ID) left join (select C_Country_ID, Name from C_Country) table3 on (C_Tax.C_Country_ID =  table3.C_Country_ID) left join (select C_Country_ID,AD_Language, Name from C_Country_TRL) tableTRL3 on (table3.C_Country_ID = tableTRL3.C_Country_ID and tableTRL3.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_Tax.C_Tax_ID = ? " +
      "        AND C_Tax.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Tax.AD_Org_ID IN (";
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
        TaxData objectTaxData = new TaxData();
        objectTaxData.created = UtilSql.getValue(result, "created");
        objectTaxData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTaxData.updated = UtilSql.getValue(result, "updated");
        objectTaxData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTaxData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTaxData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTaxData.istaxexempt = UtilSql.getValue(result, "istaxexempt");
        objectTaxData.sopotype = UtilSql.getValue(result, "sopotype");
        objectTaxData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTaxData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectTaxData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTaxData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectTaxData.name = UtilSql.getValue(result, "name");
        objectTaxData.description = UtilSql.getValue(result, "description");
        objectTaxData.line = UtilSql.getValue(result, "line");
        objectTaxData.taxhint = UtilSql.getValue(result, "taxhint");
        objectTaxData.cascade = UtilSql.getValue(result, "cascade");
        objectTaxData.isactive = UtilSql.getValue(result, "isactive");
        objectTaxData.iswithholdingtax = UtilSql.getValue(result, "iswithholdingtax");
        objectTaxData.validfrom = UtilSql.getDateValue(result, "validfrom", "dd-MM-yyyy");
        objectTaxData.rate = UtilSql.getValue(result, "rate");
        objectTaxData.deducpercent = UtilSql.getValue(result, "deducpercent");
        objectTaxData.reversecharge = UtilSql.getValue(result, "reversecharge");
        objectTaxData.originalrate = UtilSql.getValue(result, "originalrate");
        objectTaxData.adduid2fact = UtilSql.getValue(result, "adduid2fact");
        objectTaxData.istaxundeductable = UtilSql.getValue(result, "istaxundeductable");
        objectTaxData.cCountryId = UtilSql.getValue(result, "c_country_id");
        objectTaxData.cCountryIdr = UtilSql.getValue(result, "c_country_idr");
        objectTaxData.isnovat = UtilSql.getValue(result, "isnovat");
        objectTaxData.datevkeyvst = UtilSql.getValue(result, "datevkeyvst");
        objectTaxData.datevkeyust = UtilSql.getValue(result, "datevkeyust");
        objectTaxData.isnotaxable = UtilSql.getValue(result, "isnotaxable");
        objectTaxData.isdefault = UtilSql.getValue(result, "isdefault");
        objectTaxData.issummary = UtilSql.getValue(result, "issummary");
        objectTaxData.cRegionId = UtilSql.getValue(result, "c_region_id");
        objectTaxData.toRegionId = UtilSql.getValue(result, "to_region_id");
        objectTaxData.toCountryId = UtilSql.getValue(result, "to_country_id");
        objectTaxData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectTaxData.language = UtilSql.getValue(result, "language");
        objectTaxData.adUserClient = "";
        objectTaxData.adOrgClient = "";
        objectTaxData.createdby = "";
        objectTaxData.trBgcolor = "";
        objectTaxData.totalCount = "";
        objectTaxData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTaxData);
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
    TaxData objectTaxData[] = new TaxData[vector.size()];
    vector.copyInto(objectTaxData);
    return(objectTaxData);
  }

/**
Create a registry
 */
  public static TaxData[] set(String cCountryId, String isdefault, String adduid2fact, String cRegionId, String deducpercent, String originalrate, String taxhint, String createdby, String createdbyr, String datevkeyvst, String toCountryId, String adClientId, String isactive, String toRegionId, String isnotaxable, String reversecharge, String datevkeyust, String rate, String line, String cascade, String validfrom, String istaxexempt, String sopotype, String cTaxId, String istaxundeductable, String isnovat, String issummary, String created, String iswithholdingtax, String name, String adOrgId, String updatedby, String updatedbyr, String description)    throws ServletException {
    TaxData objectTaxData[] = new TaxData[1];
    objectTaxData[0] = new TaxData();
    objectTaxData[0].created = created;
    objectTaxData[0].createdbyr = createdbyr;
    objectTaxData[0].updated = "";
    objectTaxData[0].updatedTimeStamp = "";
    objectTaxData[0].updatedby = updatedby;
    objectTaxData[0].updatedbyr = updatedbyr;
    objectTaxData[0].istaxexempt = istaxexempt;
    objectTaxData[0].sopotype = sopotype;
    objectTaxData[0].adClientId = adClientId;
    objectTaxData[0].adClientIdr = "";
    objectTaxData[0].adOrgId = adOrgId;
    objectTaxData[0].adOrgIdr = "";
    objectTaxData[0].name = name;
    objectTaxData[0].description = description;
    objectTaxData[0].line = line;
    objectTaxData[0].taxhint = taxhint;
    objectTaxData[0].cascade = cascade;
    objectTaxData[0].isactive = isactive;
    objectTaxData[0].iswithholdingtax = iswithholdingtax;
    objectTaxData[0].validfrom = validfrom;
    objectTaxData[0].rate = rate;
    objectTaxData[0].deducpercent = deducpercent;
    objectTaxData[0].reversecharge = reversecharge;
    objectTaxData[0].originalrate = originalrate;
    objectTaxData[0].adduid2fact = adduid2fact;
    objectTaxData[0].istaxundeductable = istaxundeductable;
    objectTaxData[0].cCountryId = cCountryId;
    objectTaxData[0].cCountryIdr = "";
    objectTaxData[0].isnovat = isnovat;
    objectTaxData[0].datevkeyvst = datevkeyvst;
    objectTaxData[0].datevkeyust = datevkeyust;
    objectTaxData[0].isnotaxable = isnotaxable;
    objectTaxData[0].isdefault = isdefault;
    objectTaxData[0].issummary = issummary;
    objectTaxData[0].cRegionId = cRegionId;
    objectTaxData[0].toRegionId = toRegionId;
    objectTaxData[0].toCountryId = toCountryId;
    objectTaxData[0].cTaxId = cTaxId;
    objectTaxData[0].language = "";
    return objectTaxData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2245_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef2277_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
      "        UPDATE C_Tax" +
      "        SET IsTaxExempt = (?) , SOPOType = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Name = (?) , Description = (?) , Line = TO_NUMBER(?) , Taxhint = (?) , Cascade = (?) , IsActive = (?) , IsWithholdingTax = (?) , ValidFrom = TO_DATE(?) , Rate = TO_NUMBER(?) , Deducpercent = TO_NUMBER(?) , Reversecharge = (?) , Originalrate = TO_NUMBER(?) , Adduid2fact = (?) , IsTaxUndeductable = (?) , C_Country_ID = (?) , IsNoVAT = (?) , Datevkeyvst = (?) , Datevkeyust = (?) , IsNoTaxable = (?) , IsDefault = (?) , IsSummary = (?) , C_Region_ID = (?) , C_Tax_ID = (?) , To_Country_ID = (?) , To_Region_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Tax.C_Tax_ID = ? " +
      "        AND C_Tax.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Tax.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxexempt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sopotype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxhint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cascade);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iswithholdingtax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deducpercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reversecharge);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, originalrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adduid2fact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxundeductable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isnovat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datevkeyvst);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datevkeyust);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isnotaxable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRegionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, toCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, toRegionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
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
      "        INSERT INTO C_Tax " +
      "        (IsTaxExempt, SOPOType, AD_Client_ID, AD_Org_ID, Name, Description, Line, Taxhint, Cascade, IsActive, IsWithholdingTax, ValidFrom, Rate, Deducpercent, Reversecharge, Originalrate, Adduid2fact, IsTaxUndeductable, C_Country_ID, IsNoVAT, Datevkeyvst, Datevkeyust, IsNoTaxable, IsDefault, IsSummary, C_Region_ID, To_Region_ID, To_Country_ID, C_Tax_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxexempt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sopotype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxhint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cascade);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iswithholdingtax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deducpercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reversecharge);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, originalrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adduid2fact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxundeductable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isnovat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datevkeyvst);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datevkeyust);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isnotaxable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRegionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, toRegionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, toCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
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
      "        DELETE FROM C_Tax" +
      "        WHERE C_Tax.C_Tax_ID = ? " +
      "        AND C_Tax.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Tax.AD_Org_ID IN (";
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
      "        DELETE FROM C_Tax" +
      "        WHERE C_Tax.C_Tax_ID = ? ";

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
      "          FROM C_Tax" +
      "         WHERE C_Tax.C_Tax_ID = ? ";

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
      "          FROM C_Tax" +
      "         WHERE C_Tax.C_Tax_ID = ? ";

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
