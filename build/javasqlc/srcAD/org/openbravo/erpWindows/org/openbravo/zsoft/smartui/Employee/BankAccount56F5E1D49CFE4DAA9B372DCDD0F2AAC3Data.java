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
class BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data implements FieldProvider {
static Logger log4j = Logger.getLogger(BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String aCountry;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String adUserId;
  public String adUserIdr;
  public String isactive;
  public String bankaccounttype;
  public String bankaccounttyper;
  public String routingno;
  public String accountno;
  public String showaccountno;
  public String aZip;
  public String iban;
  public String showiban;
  public String swiftcode;
  public String cCountryId;
  public String cCountryIdr;
  public String displayedaccount;
  public String bankName;
  public String creditcardtype;
  public String creditcardtyper;
  public String creditcardnumber;
  public String creditcardexpmm;
  public String creditcardexpyy;
  public String aName;
  public String text1;
  public String aStreet;
  public String aIdentSsn;
  public String aIdentDl;
  public String aCity;
  public String adClientId;
  public String aState;
  public String rAvszip;
  public String adOrgId;
  public String cBpBankaccountId;
  public String aEmail;
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
    else if (fieldName.equalsIgnoreCase("a_country") || fieldName.equals("aCountry"))
      return aCountry;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("bankaccounttype"))
      return bankaccounttype;
    else if (fieldName.equalsIgnoreCase("bankaccounttyper"))
      return bankaccounttyper;
    else if (fieldName.equalsIgnoreCase("routingno"))
      return routingno;
    else if (fieldName.equalsIgnoreCase("accountno"))
      return accountno;
    else if (fieldName.equalsIgnoreCase("showaccountno"))
      return showaccountno;
    else if (fieldName.equalsIgnoreCase("a_zip") || fieldName.equals("aZip"))
      return aZip;
    else if (fieldName.equalsIgnoreCase("iban"))
      return iban;
    else if (fieldName.equalsIgnoreCase("showiban"))
      return showiban;
    else if (fieldName.equalsIgnoreCase("swiftcode"))
      return swiftcode;
    else if (fieldName.equalsIgnoreCase("c_country_id") || fieldName.equals("cCountryId"))
      return cCountryId;
    else if (fieldName.equalsIgnoreCase("c_country_idr") || fieldName.equals("cCountryIdr"))
      return cCountryIdr;
    else if (fieldName.equalsIgnoreCase("displayedaccount"))
      return displayedaccount;
    else if (fieldName.equalsIgnoreCase("bank_name") || fieldName.equals("bankName"))
      return bankName;
    else if (fieldName.equalsIgnoreCase("creditcardtype"))
      return creditcardtype;
    else if (fieldName.equalsIgnoreCase("creditcardtyper"))
      return creditcardtyper;
    else if (fieldName.equalsIgnoreCase("creditcardnumber"))
      return creditcardnumber;
    else if (fieldName.equalsIgnoreCase("creditcardexpmm"))
      return creditcardexpmm;
    else if (fieldName.equalsIgnoreCase("creditcardexpyy"))
      return creditcardexpyy;
    else if (fieldName.equalsIgnoreCase("a_name") || fieldName.equals("aName"))
      return aName;
    else if (fieldName.equalsIgnoreCase("text1"))
      return text1;
    else if (fieldName.equalsIgnoreCase("a_street") || fieldName.equals("aStreet"))
      return aStreet;
    else if (fieldName.equalsIgnoreCase("a_ident_ssn") || fieldName.equals("aIdentSsn"))
      return aIdentSsn;
    else if (fieldName.equalsIgnoreCase("a_ident_dl") || fieldName.equals("aIdentDl"))
      return aIdentDl;
    else if (fieldName.equalsIgnoreCase("a_city") || fieldName.equals("aCity"))
      return aCity;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("a_state") || fieldName.equals("aState"))
      return aState;
    else if (fieldName.equalsIgnoreCase("r_avszip") || fieldName.equals("rAvszip"))
      return rAvszip;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_bp_bankaccount_id") || fieldName.equals("cBpBankaccountId"))
      return cBpBankaccountId;
    else if (fieldName.equalsIgnoreCase("a_email") || fieldName.equals("aEmail"))
      return aEmail;
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
  public static BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cBpartnerId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_BP_BankAccount.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_BP_BankAccount.CreatedBy) as CreatedByR, " +
      "        to_char(C_BP_BankAccount.Updated, ?) as updated, " +
      "        to_char(C_BP_BankAccount.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_BP_BankAccount.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_BP_BankAccount.UpdatedBy) as UpdatedByR," +
      "        C_BP_BankAccount.A_Country, " +
      "C_BP_BankAccount.C_BPartner_ID, " +
      "(CASE WHEN C_BP_BankAccount.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "C_BP_BankAccount.AD_User_ID, " +
      "(CASE WHEN C_BP_BankAccount.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "COALESCE(C_BP_BankAccount.IsActive, 'N') AS IsActive, " +
      "C_BP_BankAccount.BankAccountType, " +
      "(CASE WHEN C_BP_BankAccount.BankAccountType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS BankAccountTypeR, " +
      "C_BP_BankAccount.RoutingNo, " +
      "C_BP_BankAccount.AccountNo, " +
      "COALESCE(C_BP_BankAccount.ShowAccountNo, 'N') AS ShowAccountNo, " +
      "C_BP_BankAccount.A_Zip, " +
      "C_BP_BankAccount.Iban, " +
      "COALESCE(C_BP_BankAccount.Showiban, 'N') AS Showiban, " +
      "C_BP_BankAccount.SwiftCode, " +
      "C_BP_BankAccount.C_Country_ID, " +
      "(CASE WHEN C_BP_BankAccount.C_Country_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_Country_IDR, " +
      "C_BP_BankAccount.Displayedaccount, " +
      "C_BP_BankAccount.Bank_Name, " +
      "C_BP_BankAccount.CreditCardType, " +
      "(CASE WHEN C_BP_BankAccount.CreditCardType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS CreditCardTypeR, " +
      "C_BP_BankAccount.CreditCardNumber, " +
      "C_BP_BankAccount.CreditCardExpMM, " +
      "C_BP_BankAccount.CreditCardExpYY, " +
      "C_BP_BankAccount.A_Name, " +
      "C_BP_BankAccount.Text1, " +
      "C_BP_BankAccount.A_Street, " +
      "C_BP_BankAccount.A_Ident_SSN, " +
      "C_BP_BankAccount.A_Ident_DL, " +
      "C_BP_BankAccount.A_City, " +
      "C_BP_BankAccount.AD_Client_ID, " +
      "C_BP_BankAccount.A_State, " +
      "C_BP_BankAccount.R_AvsZip, " +
      "C_BP_BankAccount.AD_Org_ID, " +
      "C_BP_BankAccount.C_BP_BankAccount_ID, " +
      "C_BP_BankAccount.A_EMail, " +
      "        ? AS LANGUAGE " +
      "        FROM C_BP_BankAccount left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BP_BankAccount.C_BPartner_ID = table1.C_BPartner_ID) left join (select AD_User_ID, Name from AD_User) table2 on (C_BP_BankAccount.AD_User_ID = table2.AD_User_ID) left join ad_ref_list_v list1 on (C_BP_BankAccount.BankAccountType = list1.value and list1.ad_reference_id = '216' and list1.ad_language = ?)  left join (select C_Country_ID, Name from C_Country) table3 on (C_BP_BankAccount.C_Country_ID = table3.C_Country_ID) left join (select C_Country_ID,AD_Language, Name from C_Country_TRL) tableTRL3 on (table3.C_Country_ID = tableTRL3.C_Country_ID and tableTRL3.AD_Language = ?)  left join ad_ref_list_v list2 on (C_BP_BankAccount.CreditCardType = list2.value and list2.ad_reference_id = '149' and list2.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BP_BankAccount.C_BPartner_ID = ?  ");
    strSql = strSql + 
      "        AND C_BP_BankAccount.C_BP_BankAccount_ID = ? " +
      "        AND C_BP_BankAccount.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_BP_BankAccount.AD_Org_ID IN (";
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
        BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data = new BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data();
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.created = UtilSql.getValue(result, "created");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.updated = UtilSql.getValue(result, "updated");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.aCountry = UtilSql.getValue(result, "a_country");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.isactive = UtilSql.getValue(result, "isactive");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.bankaccounttype = UtilSql.getValue(result, "bankaccounttype");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.bankaccounttyper = UtilSql.getValue(result, "bankaccounttyper");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.routingno = UtilSql.getValue(result, "routingno");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.accountno = UtilSql.getValue(result, "accountno");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.showaccountno = UtilSql.getValue(result, "showaccountno");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.aZip = UtilSql.getValue(result, "a_zip");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.iban = UtilSql.getValue(result, "iban");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.showiban = UtilSql.getValue(result, "showiban");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.swiftcode = UtilSql.getValue(result, "swiftcode");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.cCountryId = UtilSql.getValue(result, "c_country_id");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.cCountryIdr = UtilSql.getValue(result, "c_country_idr");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.displayedaccount = UtilSql.getValue(result, "displayedaccount");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.bankName = UtilSql.getValue(result, "bank_name");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.creditcardtype = UtilSql.getValue(result, "creditcardtype");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.creditcardtyper = UtilSql.getValue(result, "creditcardtyper");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.creditcardnumber = UtilSql.getValue(result, "creditcardnumber");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.creditcardexpmm = UtilSql.getValue(result, "creditcardexpmm");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.creditcardexpyy = UtilSql.getValue(result, "creditcardexpyy");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.aName = UtilSql.getValue(result, "a_name");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.text1 = UtilSql.getValue(result, "text1");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.aStreet = UtilSql.getValue(result, "a_street");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.aIdentSsn = UtilSql.getValue(result, "a_ident_ssn");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.aIdentDl = UtilSql.getValue(result, "a_ident_dl");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.aCity = UtilSql.getValue(result, "a_city");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.aState = UtilSql.getValue(result, "a_state");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.rAvszip = UtilSql.getValue(result, "r_avszip");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.cBpBankaccountId = UtilSql.getValue(result, "c_bp_bankaccount_id");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.aEmail = UtilSql.getValue(result, "a_email");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.language = UtilSql.getValue(result, "language");
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.adUserClient = "";
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.adOrgClient = "";
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.createdby = "";
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.trBgcolor = "";
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.totalCount = "";
        objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data);
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
    BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[] = new BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[vector.size()];
    vector.copyInto(objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data);
    return(objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data);
  }

/**
Create a registry
 */
  public static BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[] set(String cBpartnerId, String aStreet, String displayedaccount, String aEmail, String aZip, String bankaccounttype, String adOrgId, String aName, String bankName, String swiftcode, String showiban, String accountno, String rAvszip, String adClientId, String aState, String isactive, String updatedby, String updatedbyr, String cBpBankaccountId, String text1, String cCountryId, String aCountry, String showaccountno, String creditcardexpmm, String creditcardnumber, String iban, String createdby, String createdbyr, String routingno, String aCity, String creditcardtype, String cBpartnerIdr, String created, String adUserId, String creditcardexpyy, String aIdentDl, String aIdentSsn)    throws ServletException {
    BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[] = new BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[1];
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0] = new BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data();
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].created = created;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].createdbyr = createdbyr;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].updated = "";
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].updatedTimeStamp = "";
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].updatedby = updatedby;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].updatedbyr = updatedbyr;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].aCountry = aCountry;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].cBpartnerId = cBpartnerId;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].cBpartnerIdr = cBpartnerIdr;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].adUserId = adUserId;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].adUserIdr = "";
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].isactive = isactive;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].bankaccounttype = bankaccounttype;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].bankaccounttyper = "";
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].routingno = routingno;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].accountno = accountno;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].showaccountno = showaccountno;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].aZip = aZip;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].iban = iban;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].showiban = showiban;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].swiftcode = swiftcode;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].cCountryId = cCountryId;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].cCountryIdr = "";
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].displayedaccount = displayedaccount;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].bankName = bankName;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].creditcardtype = creditcardtype;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].creditcardtyper = "";
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].creditcardnumber = creditcardnumber;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].creditcardexpmm = creditcardexpmm;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].creditcardexpyy = creditcardexpyy;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].aName = aName;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].text1 = text1;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].aStreet = aStreet;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].aIdentSsn = aIdentSsn;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].aIdentDl = aIdentDl;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].aCity = aCity;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].adClientId = adClientId;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].aState = aState;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].rAvszip = rAvszip;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].adOrgId = adOrgId;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].cBpBankaccountId = cBpBankaccountId;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].aEmail = aEmail;
    objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0].language = "";
    return objectBankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef3101_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef3100_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef3102_2(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_BP_BankAccount.C_BPartner_ID AS NAME" +
      "        FROM C_BP_BankAccount" +
      "        WHERE C_BP_BankAccount.C_BP_BankAccount_ID = ?";

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
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM c_bpartneremployee_view left join (select C_BPartner_ID, Name from C_BPartner) table1 on (c_bpartneremployee_view.C_BPartner_ID = table1.C_BPartner_ID) WHERE c_bpartneremployee_view.C_BPartner_ID = ?  ";

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
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM c_bpartneremployee_view left join (select C_BPartner_ID, Name from C_BPartner) table1 on (c_bpartneremployee_view.C_BPartner_ID = table1.C_BPartner_ID) WHERE c_bpartneremployee_view.C_BPartner_ID = ?  ";

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
      "        UPDATE C_BP_BankAccount" +
      "        SET A_Country = (?) , C_BPartner_ID = (?) , AD_User_ID = (?) , IsActive = (?) , BankAccountType = (?) , RoutingNo = (?) , AccountNo = (?) , ShowAccountNo = (?) , A_Zip = (?) , Iban = (?) , Showiban = (?) , SwiftCode = (?) , C_Country_ID = (?) , Displayedaccount = (?) , Bank_Name = (?) , CreditCardType = (?) , CreditCardNumber = (?) , CreditCardExpMM = TO_NUMBER(?) , CreditCardExpYY = TO_NUMBER(?) , A_Name = (?) , Text1 = (?) , A_Ident_SSN = (?) , C_BP_BankAccount_ID = (?) , AD_Client_ID = (?) , A_State = (?) , R_AvsZip = (?) , AD_Org_ID = (?) , A_City = (?) , A_Ident_DL = (?) , A_EMail = (?) , A_Street = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_BP_BankAccount.C_BP_BankAccount_ID = ? " +
      "                 AND C_BP_BankAccount.C_BPartner_ID = ? " +
      "        AND C_BP_BankAccount.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_BP_BankAccount.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aCountry);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bankaccounttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, routingno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showaccountno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aZip);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iban);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showiban);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, swiftcode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displayedaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bankName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, creditcardtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, creditcardnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, creditcardexpmm);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, creditcardexpyy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aIdentSsn);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpBankaccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aState);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rAvszip);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aCity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aIdentDl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aEmail);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aStreet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpBankaccountId);
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
      "        INSERT INTO C_BP_BankAccount " +
      "        (A_Country, C_BPartner_ID, AD_User_ID, IsActive, BankAccountType, RoutingNo, AccountNo, ShowAccountNo, A_Zip, Iban, Showiban, SwiftCode, C_Country_ID, Displayedaccount, Bank_Name, CreditCardType, CreditCardNumber, CreditCardExpMM, CreditCardExpYY, A_Name, Text1, A_Street, A_Ident_SSN, A_Ident_DL, A_City, AD_Client_ID, A_State, R_AvsZip, AD_Org_ID, C_BP_BankAccount_ID, A_EMail, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aCountry);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bankaccounttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, routingno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showaccountno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aZip);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iban);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showiban);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, swiftcode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displayedaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bankName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, creditcardtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, creditcardnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, creditcardexpmm);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, creditcardexpyy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aStreet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aIdentSsn);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aIdentDl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aCity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aState);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rAvszip);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpBankaccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aEmail);
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
      "        DELETE FROM C_BP_BankAccount" +
      "        WHERE C_BP_BankAccount.C_BP_BankAccount_ID = ? " +
      "                 AND C_BP_BankAccount.C_BPartner_ID = ? " +
      "        AND C_BP_BankAccount.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_BP_BankAccount.AD_Org_ID IN (";
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
      "        DELETE FROM C_BP_BankAccount" +
      "        WHERE C_BP_BankAccount.C_BP_BankAccount_ID = ? " +
      "                 AND C_BP_BankAccount.C_BPartner_ID = ? ";

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
      "          FROM C_BP_BankAccount" +
      "         WHERE C_BP_BankAccount.C_BP_BankAccount_ID = ? ";

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
      "          FROM C_BP_BankAccount" +
      "         WHERE C_BP_BankAccount.C_BP_BankAccount_ID = ? ";

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
