//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.AccountingSchema;

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
class AccountingSchemaData implements FieldProvider {
static Logger log4j = Logger.getLogger(AccountingSchemaData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cAcctschemaId;
  public String hascombination;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String name;
  public String description;
  public String isactive;
  public String gaap;
  public String gaapr;
  public String isaccrual;
  public String costingmethod;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String autoperiodcontrol;
  public String cPeriodId;
  public String cPeriodIdr;
  public String periodOpenhistory;
  public String periodOpenfuture;
  public String separator;
  public String hasalias;
  public String istradediscountposted;
  public String isdiscountcorrectstax;
  public String allownegative;
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
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("hascombination"))
      return hascombination;
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
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("gaap"))
      return gaap;
    else if (fieldName.equalsIgnoreCase("gaapr"))
      return gaapr;
    else if (fieldName.equalsIgnoreCase("isaccrual"))
      return isaccrual;
    else if (fieldName.equalsIgnoreCase("costingmethod"))
      return costingmethod;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("autoperiodcontrol"))
      return autoperiodcontrol;
    else if (fieldName.equalsIgnoreCase("c_period_id") || fieldName.equals("cPeriodId"))
      return cPeriodId;
    else if (fieldName.equalsIgnoreCase("c_period_idr") || fieldName.equals("cPeriodIdr"))
      return cPeriodIdr;
    else if (fieldName.equalsIgnoreCase("period_openhistory") || fieldName.equals("periodOpenhistory"))
      return periodOpenhistory;
    else if (fieldName.equalsIgnoreCase("period_openfuture") || fieldName.equals("periodOpenfuture"))
      return periodOpenfuture;
    else if (fieldName.equalsIgnoreCase("separator"))
      return separator;
    else if (fieldName.equalsIgnoreCase("hasalias"))
      return hasalias;
    else if (fieldName.equalsIgnoreCase("istradediscountposted"))
      return istradediscountposted;
    else if (fieldName.equalsIgnoreCase("isdiscountcorrectstax"))
      return isdiscountcorrectstax;
    else if (fieldName.equalsIgnoreCase("allownegative"))
      return allownegative;
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
  public static AccountingSchemaData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static AccountingSchemaData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_AcctSchema.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_AcctSchema.CreatedBy) as CreatedByR, " +
      "        to_char(C_AcctSchema.Updated, ?) as updated, " +
      "        to_char(C_AcctSchema.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_AcctSchema.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_AcctSchema.UpdatedBy) as UpdatedByR," +
      "        C_AcctSchema.C_AcctSchema_ID, " +
      "COALESCE(C_AcctSchema.HasCombination, 'N') AS HasCombination, " +
      "C_AcctSchema.AD_Client_ID, " +
      "(CASE WHEN C_AcctSchema.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_AcctSchema.AD_Org_ID, " +
      "(CASE WHEN C_AcctSchema.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_AcctSchema.Name, " +
      "C_AcctSchema.Description, " +
      "COALESCE(C_AcctSchema.IsActive, 'N') AS IsActive, " +
      "C_AcctSchema.GAAP, " +
      "(CASE WHEN C_AcctSchema.GAAP IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS GAAPR, " +
      "COALESCE(C_AcctSchema.IsAccrual, 'N') AS IsAccrual, " +
      "C_AcctSchema.CostingMethod, " +
      "C_AcctSchema.C_Currency_ID, " +
      "(CASE WHEN C_AcctSchema.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "COALESCE(C_AcctSchema.AutoPeriodControl, 'N') AS AutoPeriodControl, " +
      "C_AcctSchema.C_Period_ID, " +
      "(CASE WHEN C_AcctSchema.C_Period_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Period_IDR, " +
      "C_AcctSchema.Period_OpenHistory, " +
      "C_AcctSchema.Period_OpenFuture, " +
      "C_AcctSchema.Separator, " +
      "COALESCE(C_AcctSchema.HasAlias, 'N') AS HasAlias, " +
      "COALESCE(C_AcctSchema.IsTradeDiscountPosted, 'N') AS IsTradeDiscountPosted, " +
      "COALESCE(C_AcctSchema.IsDiscountCorrectsTax, 'N') AS IsDiscountCorrectsTax, " +
      "COALESCE(C_AcctSchema.Allownegative, 'N') AS Allownegative, " +
      "        ? AS LANGUAGE " +
      "        FROM C_AcctSchema left join (select AD_Client_ID, Name from AD_Client) table1 on (C_AcctSchema.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_AcctSchema.AD_Org_ID = table2.AD_Org_ID) left join ad_ref_list_v list1 on (C_AcctSchema.GAAP = list1.value and list1.ad_reference_id = '123' and list1.ad_language = ?)  left join (select C_Currency_ID, ISO_Code from C_Currency) table3 on (C_AcctSchema.C_Currency_ID = table3.C_Currency_ID) left join (select C_Period_ID, Name from C_Period) table4 on (C_AcctSchema.C_Period_ID = table4.C_Period_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_AcctSchema.C_AcctSchema_ID = ? " +
      "        AND C_AcctSchema.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_AcctSchema.AD_Org_ID IN (";
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
        AccountingSchemaData objectAccountingSchemaData = new AccountingSchemaData();
        objectAccountingSchemaData.created = UtilSql.getValue(result, "created");
        objectAccountingSchemaData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectAccountingSchemaData.updated = UtilSql.getValue(result, "updated");
        objectAccountingSchemaData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectAccountingSchemaData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAccountingSchemaData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectAccountingSchemaData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectAccountingSchemaData.hascombination = UtilSql.getValue(result, "hascombination");
        objectAccountingSchemaData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAccountingSchemaData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectAccountingSchemaData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAccountingSchemaData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectAccountingSchemaData.name = UtilSql.getValue(result, "name");
        objectAccountingSchemaData.description = UtilSql.getValue(result, "description");
        objectAccountingSchemaData.isactive = UtilSql.getValue(result, "isactive");
        objectAccountingSchemaData.gaap = UtilSql.getValue(result, "gaap");
        objectAccountingSchemaData.gaapr = UtilSql.getValue(result, "gaapr");
        objectAccountingSchemaData.isaccrual = UtilSql.getValue(result, "isaccrual");
        objectAccountingSchemaData.costingmethod = UtilSql.getValue(result, "costingmethod");
        objectAccountingSchemaData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectAccountingSchemaData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectAccountingSchemaData.autoperiodcontrol = UtilSql.getValue(result, "autoperiodcontrol");
        objectAccountingSchemaData.cPeriodId = UtilSql.getValue(result, "c_period_id");
        objectAccountingSchemaData.cPeriodIdr = UtilSql.getValue(result, "c_period_idr");
        objectAccountingSchemaData.periodOpenhistory = UtilSql.getValue(result, "period_openhistory");
        objectAccountingSchemaData.periodOpenfuture = UtilSql.getValue(result, "period_openfuture");
        objectAccountingSchemaData.separator = UtilSql.getValue(result, "separator");
        objectAccountingSchemaData.hasalias = UtilSql.getValue(result, "hasalias");
        objectAccountingSchemaData.istradediscountposted = UtilSql.getValue(result, "istradediscountposted");
        objectAccountingSchemaData.isdiscountcorrectstax = UtilSql.getValue(result, "isdiscountcorrectstax");
        objectAccountingSchemaData.allownegative = UtilSql.getValue(result, "allownegative");
        objectAccountingSchemaData.language = UtilSql.getValue(result, "language");
        objectAccountingSchemaData.adUserClient = "";
        objectAccountingSchemaData.adOrgClient = "";
        objectAccountingSchemaData.createdby = "";
        objectAccountingSchemaData.trBgcolor = "";
        objectAccountingSchemaData.totalCount = "";
        objectAccountingSchemaData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountingSchemaData);
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
    AccountingSchemaData objectAccountingSchemaData[] = new AccountingSchemaData[vector.size()];
    vector.copyInto(objectAccountingSchemaData);
    return(objectAccountingSchemaData);
  }

/**
Create a registry
 */
  public static AccountingSchemaData[] set(String hasalias, String hascombination, String adClientId, String isaccrual, String costingmethod, String name, String autoperiodcontrol, String periodOpenfuture, String adOrgId, String createdby, String createdbyr, String allownegative, String isactive, String description, String istradediscountposted, String separator, String updatedby, String updatedbyr, String isdiscountcorrectstax, String cCurrencyId, String cAcctschemaId, String gaap, String cPeriodId, String periodOpenhistory)    throws ServletException {
    AccountingSchemaData objectAccountingSchemaData[] = new AccountingSchemaData[1];
    objectAccountingSchemaData[0] = new AccountingSchemaData();
    objectAccountingSchemaData[0].created = "";
    objectAccountingSchemaData[0].createdbyr = createdbyr;
    objectAccountingSchemaData[0].updated = "";
    objectAccountingSchemaData[0].updatedTimeStamp = "";
    objectAccountingSchemaData[0].updatedby = updatedby;
    objectAccountingSchemaData[0].updatedbyr = updatedbyr;
    objectAccountingSchemaData[0].cAcctschemaId = cAcctschemaId;
    objectAccountingSchemaData[0].hascombination = hascombination;
    objectAccountingSchemaData[0].adClientId = adClientId;
    objectAccountingSchemaData[0].adClientIdr = "";
    objectAccountingSchemaData[0].adOrgId = adOrgId;
    objectAccountingSchemaData[0].adOrgIdr = "";
    objectAccountingSchemaData[0].name = name;
    objectAccountingSchemaData[0].description = description;
    objectAccountingSchemaData[0].isactive = isactive;
    objectAccountingSchemaData[0].gaap = gaap;
    objectAccountingSchemaData[0].gaapr = "";
    objectAccountingSchemaData[0].isaccrual = isaccrual;
    objectAccountingSchemaData[0].costingmethod = costingmethod;
    objectAccountingSchemaData[0].cCurrencyId = cCurrencyId;
    objectAccountingSchemaData[0].cCurrencyIdr = "";
    objectAccountingSchemaData[0].autoperiodcontrol = autoperiodcontrol;
    objectAccountingSchemaData[0].cPeriodId = cPeriodId;
    objectAccountingSchemaData[0].cPeriodIdr = "";
    objectAccountingSchemaData[0].periodOpenhistory = periodOpenhistory;
    objectAccountingSchemaData[0].periodOpenfuture = periodOpenfuture;
    objectAccountingSchemaData[0].separator = separator;
    objectAccountingSchemaData[0].hasalias = hasalias;
    objectAccountingSchemaData[0].istradediscountposted = istradediscountposted;
    objectAccountingSchemaData[0].isdiscountcorrectstax = isdiscountcorrectstax;
    objectAccountingSchemaData[0].allownegative = allownegative;
    objectAccountingSchemaData[0].language = "";
    return objectAccountingSchemaData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2468_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef2470_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
      "        UPDATE C_AcctSchema" +
      "        SET C_AcctSchema_ID = (?) , HasCombination = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Name = (?) , Description = (?) , IsActive = (?) , GAAP = (?) , IsAccrual = (?) , CostingMethod = (?) , C_Currency_ID = (?) , AutoPeriodControl = (?) , C_Period_ID = (?) , Period_OpenHistory = TO_NUMBER(?) , Period_OpenFuture = TO_NUMBER(?) , Separator = (?) , HasAlias = (?) , IsTradeDiscountPosted = (?) , IsDiscountCorrectsTax = (?) , Allownegative = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_AcctSchema.C_AcctSchema_ID = ? " +
      "        AND C_AcctSchema.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_AcctSchema.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hascombination);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gaap);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isaccrual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costingmethod);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, autoperiodcontrol);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodOpenhistory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodOpenfuture);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, separator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hasalias);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istradediscountposted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountcorrectstax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allownegative);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
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
      "        INSERT INTO C_AcctSchema " +
      "        (C_AcctSchema_ID, HasCombination, AD_Client_ID, AD_Org_ID, Name, Description, IsActive, GAAP, IsAccrual, CostingMethod, C_Currency_ID, AutoPeriodControl, C_Period_ID, Period_OpenHistory, Period_OpenFuture, Separator, HasAlias, IsTradeDiscountPosted, IsDiscountCorrectsTax, Allownegative, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hascombination);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gaap);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isaccrual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costingmethod);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, autoperiodcontrol);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodOpenhistory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodOpenfuture);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, separator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hasalias);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istradediscountposted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountcorrectstax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allownegative);
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
      "        DELETE FROM C_AcctSchema" +
      "        WHERE C_AcctSchema.C_AcctSchema_ID = ? " +
      "        AND C_AcctSchema.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_AcctSchema.AD_Org_ID IN (";
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
      "        DELETE FROM C_AcctSchema" +
      "        WHERE C_AcctSchema.C_AcctSchema_ID = ? ";

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
      "          FROM C_AcctSchema" +
      "         WHERE C_AcctSchema.C_AcctSchema_ID = ? ";

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
      "          FROM C_AcctSchema" +
      "         WHERE C_AcctSchema.C_AcctSchema_ID = ? ";

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
