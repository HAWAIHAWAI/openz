//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Bank;

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
class BankAccountData implements FieldProvider {
static Logger log4j = Logger.getLogger(BankAccountData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String digitcontrol;
  public String accountno;
  public String codeaccount;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cBankId;
  public String cBankIdr;
  public String isactive;
  public String showspanish;
  public String bankaccounttype;
  public String bankaccounttyper;
  public String isdefault;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String genericaccount;
  public String showgeneric;
  public String iban;
  public String showiban;
  public String displayedaccount;
  public String creditlimit;
  public String currentbalance;
  public String cBankaccountId;
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
    else if (fieldName.equalsIgnoreCase("digitcontrol"))
      return digitcontrol;
    else if (fieldName.equalsIgnoreCase("accountno"))
      return accountno;
    else if (fieldName.equalsIgnoreCase("codeaccount"))
      return codeaccount;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_bank_id") || fieldName.equals("cBankId"))
      return cBankId;
    else if (fieldName.equalsIgnoreCase("c_bank_idr") || fieldName.equals("cBankIdr"))
      return cBankIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("showspanish"))
      return showspanish;
    else if (fieldName.equalsIgnoreCase("bankaccounttype"))
      return bankaccounttype;
    else if (fieldName.equalsIgnoreCase("bankaccounttyper"))
      return bankaccounttyper;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("genericaccount"))
      return genericaccount;
    else if (fieldName.equalsIgnoreCase("showgeneric"))
      return showgeneric;
    else if (fieldName.equalsIgnoreCase("iban"))
      return iban;
    else if (fieldName.equalsIgnoreCase("showiban"))
      return showiban;
    else if (fieldName.equalsIgnoreCase("displayedaccount"))
      return displayedaccount;
    else if (fieldName.equalsIgnoreCase("creditlimit"))
      return creditlimit;
    else if (fieldName.equalsIgnoreCase("currentbalance"))
      return currentbalance;
    else if (fieldName.equalsIgnoreCase("c_bankaccount_id") || fieldName.equals("cBankaccountId"))
      return cBankaccountId;
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
  public static BankAccountData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBankId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cBankId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static BankAccountData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBankId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_BankAccount.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_BankAccount.CreatedBy) as CreatedByR, " +
      "        to_char(C_BankAccount.Updated, ?) as updated, " +
      "        to_char(C_BankAccount.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_BankAccount.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_BankAccount.UpdatedBy) as UpdatedByR," +
      "        C_BankAccount.Digitcontrol, " +
      "C_BankAccount.AccountNo, " +
      "C_BankAccount.Codeaccount, " +
      "C_BankAccount.AD_Client_ID, " +
      "(CASE WHEN C_BankAccount.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_BankAccount.AD_Org_ID, " +
      "(CASE WHEN C_BankAccount.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_BankAccount.C_Bank_ID, " +
      "(CASE WHEN C_BankAccount.C_Bank_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Bank_IDR, " +
      "COALESCE(C_BankAccount.IsActive, 'N') AS IsActive, " +
      "COALESCE(C_BankAccount.ShowSpanish, 'N') AS ShowSpanish, " +
      "C_BankAccount.BankAccountType, " +
      "(CASE WHEN C_BankAccount.BankAccountType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS BankAccountTypeR, " +
      "COALESCE(C_BankAccount.IsDefault, 'N') AS IsDefault, " +
      "C_BankAccount.C_Currency_ID, " +
      "(CASE WHEN C_BankAccount.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "C_BankAccount.GenericAccount, " +
      "COALESCE(C_BankAccount.ShowGeneric, 'N') AS ShowGeneric, " +
      "C_BankAccount.Iban, " +
      "COALESCE(C_BankAccount.ShowIBAN, 'N') AS ShowIBAN, " +
      "C_BankAccount.DisplayedAccount, " +
      "C_BankAccount.CreditLimit, " +
      "C_BankAccount.CurrentBalance, " +
      "C_BankAccount.C_BankAccount_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_BankAccount left join (select AD_Client_ID, Name from AD_Client) table1 on (C_BankAccount.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_BankAccount.AD_Org_ID = table2.AD_Org_ID) left join (select C_Bank_ID, Name from C_Bank) table3 on (C_BankAccount.C_Bank_ID = table3.C_Bank_ID) left join ad_ref_list_v list1 on (C_BankAccount.BankAccountType = list1.value and list1.ad_reference_id = '216' and list1.ad_language = ?)  left join (select C_Currency_ID, ISO_Code from C_Currency) table4 on (C_BankAccount.C_Currency_ID = table4.C_Currency_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cBankId==null || cBankId.equals(""))?"":"  AND C_BankAccount.C_Bank_ID = ?  ");
    strSql = strSql + 
      "        AND C_BankAccount.C_BankAccount_ID = ? " +
      "        AND C_BankAccount.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_BankAccount.AD_Org_ID IN (";
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
      if (cBankId != null && !(cBankId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankId);
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
        BankAccountData objectBankAccountData = new BankAccountData();
        objectBankAccountData.created = UtilSql.getValue(result, "created");
        objectBankAccountData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectBankAccountData.updated = UtilSql.getValue(result, "updated");
        objectBankAccountData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectBankAccountData.updatedby = UtilSql.getValue(result, "updatedby");
        objectBankAccountData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectBankAccountData.digitcontrol = UtilSql.getValue(result, "digitcontrol");
        objectBankAccountData.accountno = UtilSql.getValue(result, "accountno");
        objectBankAccountData.codeaccount = UtilSql.getValue(result, "codeaccount");
        objectBankAccountData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectBankAccountData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectBankAccountData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectBankAccountData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectBankAccountData.cBankId = UtilSql.getValue(result, "c_bank_id");
        objectBankAccountData.cBankIdr = UtilSql.getValue(result, "c_bank_idr");
        objectBankAccountData.isactive = UtilSql.getValue(result, "isactive");
        objectBankAccountData.showspanish = UtilSql.getValue(result, "showspanish");
        objectBankAccountData.bankaccounttype = UtilSql.getValue(result, "bankaccounttype");
        objectBankAccountData.bankaccounttyper = UtilSql.getValue(result, "bankaccounttyper");
        objectBankAccountData.isdefault = UtilSql.getValue(result, "isdefault");
        objectBankAccountData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectBankAccountData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectBankAccountData.genericaccount = UtilSql.getValue(result, "genericaccount");
        objectBankAccountData.showgeneric = UtilSql.getValue(result, "showgeneric");
        objectBankAccountData.iban = UtilSql.getValue(result, "iban");
        objectBankAccountData.showiban = UtilSql.getValue(result, "showiban");
        objectBankAccountData.displayedaccount = UtilSql.getValue(result, "displayedaccount");
        objectBankAccountData.creditlimit = UtilSql.getValue(result, "creditlimit");
        objectBankAccountData.currentbalance = UtilSql.getValue(result, "currentbalance");
        objectBankAccountData.cBankaccountId = UtilSql.getValue(result, "c_bankaccount_id");
        objectBankAccountData.language = UtilSql.getValue(result, "language");
        objectBankAccountData.adUserClient = "";
        objectBankAccountData.adOrgClient = "";
        objectBankAccountData.createdby = "";
        objectBankAccountData.trBgcolor = "";
        objectBankAccountData.totalCount = "";
        objectBankAccountData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBankAccountData);
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
    BankAccountData objectBankAccountData[] = new BankAccountData[vector.size()];
    vector.copyInto(objectBankAccountData);
    return(objectBankAccountData);
  }

/**
Create a registry
 */
  public static BankAccountData[] set(String cBankId, String currentbalance, String cCurrencyId, String accountno, String adClientId, String codeaccount, String digitcontrol, String genericaccount, String iban, String showiban, String adOrgId, String isdefault, String updatedby, String updatedbyr, String created, String showgeneric, String showspanish, String creditlimit, String isactive, String bankaccounttype, String displayedaccount, String cBankaccountId, String createdby, String createdbyr)    throws ServletException {
    BankAccountData objectBankAccountData[] = new BankAccountData[1];
    objectBankAccountData[0] = new BankAccountData();
    objectBankAccountData[0].created = created;
    objectBankAccountData[0].createdbyr = createdbyr;
    objectBankAccountData[0].updated = "";
    objectBankAccountData[0].updatedTimeStamp = "";
    objectBankAccountData[0].updatedby = updatedby;
    objectBankAccountData[0].updatedbyr = updatedbyr;
    objectBankAccountData[0].digitcontrol = digitcontrol;
    objectBankAccountData[0].accountno = accountno;
    objectBankAccountData[0].codeaccount = codeaccount;
    objectBankAccountData[0].adClientId = adClientId;
    objectBankAccountData[0].adClientIdr = "";
    objectBankAccountData[0].adOrgId = adOrgId;
    objectBankAccountData[0].adOrgIdr = "";
    objectBankAccountData[0].cBankId = cBankId;
    objectBankAccountData[0].cBankIdr = "";
    objectBankAccountData[0].isactive = isactive;
    objectBankAccountData[0].showspanish = showspanish;
    objectBankAccountData[0].bankaccounttype = bankaccounttype;
    objectBankAccountData[0].bankaccounttyper = "";
    objectBankAccountData[0].isdefault = isdefault;
    objectBankAccountData[0].cCurrencyId = cCurrencyId;
    objectBankAccountData[0].cCurrencyIdr = "";
    objectBankAccountData[0].genericaccount = genericaccount;
    objectBankAccountData[0].showgeneric = showgeneric;
    objectBankAccountData[0].iban = iban;
    objectBankAccountData[0].showiban = showiban;
    objectBankAccountData[0].displayedaccount = displayedaccount;
    objectBankAccountData[0].creditlimit = creditlimit;
    objectBankAccountData[0].currentbalance = currentbalance;
    objectBankAccountData[0].cBankaccountId = cBankaccountId;
    objectBankAccountData[0].language = "";
    return objectBankAccountData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef3071_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef3069_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_BankAccount.C_Bank_ID AS NAME" +
      "        FROM C_BankAccount" +
      "        WHERE C_BankAccount.C_BankAccount_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cBankId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_Bank left join (select C_Bank_ID, Name from C_Bank) table1 on (C_Bank.C_Bank_ID = table1.C_Bank_ID) WHERE C_Bank.C_Bank_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cBankId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_Bank left join (select C_Bank_ID, Name from C_Bank) table1 on (C_Bank.C_Bank_ID = table1.C_Bank_ID) WHERE C_Bank.C_Bank_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankId);

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
      "        UPDATE C_BankAccount" +
      "        SET Digitcontrol = (?) , AccountNo = (?) , Codeaccount = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_Bank_ID = (?) , IsActive = (?) , ShowSpanish = (?) , BankAccountType = (?) , IsDefault = (?) , C_Currency_ID = (?) , GenericAccount = (?) , ShowGeneric = (?) , Iban = (?) , ShowIBAN = (?) , DisplayedAccount = (?) , CreditLimit = TO_NUMBER(?) , CurrentBalance = TO_NUMBER(?) , C_BankAccount_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_BankAccount.C_BankAccount_ID = ? " +
      "                 AND C_BankAccount.C_Bank_ID = ? " +
      "        AND C_BankAccount.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_BankAccount.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, digitcontrol);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, codeaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showspanish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bankaccounttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, genericaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showgeneric);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iban);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showiban);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displayedaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, creditlimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currentbalance);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankId);
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
      "        INSERT INTO C_BankAccount " +
      "        (Digitcontrol, AccountNo, Codeaccount, AD_Client_ID, AD_Org_ID, C_Bank_ID, IsActive, ShowSpanish, BankAccountType, IsDefault, C_Currency_ID, GenericAccount, ShowGeneric, Iban, ShowIBAN, DisplayedAccount, CreditLimit, CurrentBalance, C_BankAccount_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, digitcontrol);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, codeaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showspanish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bankaccounttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, genericaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showgeneric);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iban);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showiban);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displayedaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, creditlimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currentbalance);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cBankId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_BankAccount" +
      "        WHERE C_BankAccount.C_BankAccount_ID = ? " +
      "                 AND C_BankAccount.C_Bank_ID = ? " +
      "        AND C_BankAccount.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_BankAccount.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cBankId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_BankAccount" +
      "        WHERE C_BankAccount.C_BankAccount_ID = ? " +
      "                 AND C_BankAccount.C_Bank_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankId);

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
      "          FROM C_BankAccount" +
      "         WHERE C_BankAccount.C_BankAccount_ID = ? ";

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
      "          FROM C_BankAccount" +
      "         WHERE C_BankAccount.C_BankAccount_ID = ? ";

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
