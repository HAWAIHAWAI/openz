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
class GeneralLedgerData implements FieldProvider {
static Logger log4j = Logger.getLogger(GeneralLedgerData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String ppvoffsetAcct;
  public String adClientId;
  public String adClientIdr;
  public String cfsOrderAcct;
  public String adOrgId;
  public String adOrgIdr;
  public String cAcctschemaGlId;
  public String cAcctschemaId;
  public String cAcctschemaIdr;
  public String isactive;
  public String usesuspensebalancing;
  public String suspensebalancingAcct;
  public String suspensebalancingAcctr;
  public String usesuspenseerror;
  public String suspenseerrorAcct;
  public String suspenseerrorAcctr;
  public String usecurrencybalancing;
  public String currencybalancingAcct;
  public String currencybalancingAcctr;
  public String retainedearningAcct;
  public String retainedearningAcctr;
  public String incomesummaryAcct;
  public String incomesummaryAcctr;
  public String intercompanyduefromAcct;
  public String intercompanyduetoAcct;
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
    else if (fieldName.equalsIgnoreCase("ppvoffset_acct") || fieldName.equals("ppvoffsetAcct"))
      return ppvoffsetAcct;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("cfs_order_acct") || fieldName.equals("cfsOrderAcct"))
      return cfsOrderAcct;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_acctschema_gl_id") || fieldName.equals("cAcctschemaGlId"))
      return cAcctschemaGlId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_idr") || fieldName.equals("cAcctschemaIdr"))
      return cAcctschemaIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("usesuspensebalancing"))
      return usesuspensebalancing;
    else if (fieldName.equalsIgnoreCase("suspensebalancing_acct") || fieldName.equals("suspensebalancingAcct"))
      return suspensebalancingAcct;
    else if (fieldName.equalsIgnoreCase("suspensebalancing_acctr") || fieldName.equals("suspensebalancingAcctr"))
      return suspensebalancingAcctr;
    else if (fieldName.equalsIgnoreCase("usesuspenseerror"))
      return usesuspenseerror;
    else if (fieldName.equalsIgnoreCase("suspenseerror_acct") || fieldName.equals("suspenseerrorAcct"))
      return suspenseerrorAcct;
    else if (fieldName.equalsIgnoreCase("suspenseerror_acctr") || fieldName.equals("suspenseerrorAcctr"))
      return suspenseerrorAcctr;
    else if (fieldName.equalsIgnoreCase("usecurrencybalancing"))
      return usecurrencybalancing;
    else if (fieldName.equalsIgnoreCase("currencybalancing_acct") || fieldName.equals("currencybalancingAcct"))
      return currencybalancingAcct;
    else if (fieldName.equalsIgnoreCase("currencybalancing_acctr") || fieldName.equals("currencybalancingAcctr"))
      return currencybalancingAcctr;
    else if (fieldName.equalsIgnoreCase("retainedearning_acct") || fieldName.equals("retainedearningAcct"))
      return retainedearningAcct;
    else if (fieldName.equalsIgnoreCase("retainedearning_acctr") || fieldName.equals("retainedearningAcctr"))
      return retainedearningAcctr;
    else if (fieldName.equalsIgnoreCase("incomesummary_acct") || fieldName.equals("incomesummaryAcct"))
      return incomesummaryAcct;
    else if (fieldName.equalsIgnoreCase("incomesummary_acctr") || fieldName.equals("incomesummaryAcctr"))
      return incomesummaryAcctr;
    else if (fieldName.equalsIgnoreCase("intercompanyduefrom_acct") || fieldName.equals("intercompanyduefromAcct"))
      return intercompanyduefromAcct;
    else if (fieldName.equalsIgnoreCase("intercompanydueto_acct") || fieldName.equals("intercompanyduetoAcct"))
      return intercompanyduetoAcct;
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
  public static GeneralLedgerData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cAcctschemaId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cAcctschemaId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static GeneralLedgerData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cAcctschemaId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_AcctSchema_GL.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_AcctSchema_GL.CreatedBy) as CreatedByR, " +
      "        to_char(C_AcctSchema_GL.Updated, ?) as updated, " +
      "        to_char(C_AcctSchema_GL.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_AcctSchema_GL.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_AcctSchema_GL.UpdatedBy) as UpdatedByR," +
      "        C_AcctSchema_GL.PPVOffset_Acct, " +
      "C_AcctSchema_GL.AD_Client_ID, " +
      "(CASE WHEN C_AcctSchema_GL.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_AcctSchema_GL.CFS_Order_Acct, " +
      "C_AcctSchema_GL.AD_Org_ID, " +
      "(CASE WHEN C_AcctSchema_GL.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_AcctSchema_GL.C_Acctschema_Gl_ID, " +
      "C_AcctSchema_GL.C_AcctSchema_ID, " +
      "(CASE WHEN C_AcctSchema_GL.C_AcctSchema_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_AcctSchema_IDR, " +
      "COALESCE(C_AcctSchema_GL.IsActive, 'N') AS IsActive, " +
      "COALESCE(C_AcctSchema_GL.UseSuspenseBalancing, 'N') AS UseSuspenseBalancing, " +
      "C_AcctSchema_GL.SuspenseBalancing_Acct, " +
      "(CASE WHEN C_AcctSchema_GL.SuspenseBalancing_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Combination), ''))),'') ) END) AS SuspenseBalancing_AcctR, " +
      "COALESCE(C_AcctSchema_GL.UseSuspenseError, 'N') AS UseSuspenseError, " +
      "C_AcctSchema_GL.SuspenseError_Acct, " +
      "(CASE WHEN C_AcctSchema_GL.SuspenseError_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Combination), ''))),'') ) END) AS SuspenseError_AcctR, " +
      "COALESCE(C_AcctSchema_GL.UseCurrencyBalancing, 'N') AS UseCurrencyBalancing, " +
      "C_AcctSchema_GL.CurrencyBalancing_Acct, " +
      "(CASE WHEN C_AcctSchema_GL.CurrencyBalancing_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Combination), ''))),'') ) END) AS CurrencyBalancing_AcctR, " +
      "C_AcctSchema_GL.RetainedEarning_Acct, " +
      "(CASE WHEN C_AcctSchema_GL.RetainedEarning_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Combination), ''))),'') ) END) AS RetainedEarning_AcctR, " +
      "C_AcctSchema_GL.IncomeSummary_Acct, " +
      "(CASE WHEN C_AcctSchema_GL.IncomeSummary_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Combination), ''))),'') ) END) AS IncomeSummary_AcctR, " +
      "C_AcctSchema_GL.IntercompanyDueFrom_Acct, " +
      "C_AcctSchema_GL.IntercompanyDueTo_Acct, " +
      "        ? AS LANGUAGE " +
      "        FROM C_AcctSchema_GL left join (select AD_Client_ID, Name from AD_Client) table1 on (C_AcctSchema_GL.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_AcctSchema_GL.AD_Org_ID = table2.AD_Org_ID) left join (select C_AcctSchema_ID, Name from C_AcctSchema) table3 on (C_AcctSchema_GL.C_AcctSchema_ID = table3.C_AcctSchema_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table4 on (C_AcctSchema_GL.SuspenseBalancing_Acct = table4.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table5 on (C_AcctSchema_GL.SuspenseError_Acct = table5.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table6 on (C_AcctSchema_GL.CurrencyBalancing_Acct = table6.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table7 on (C_AcctSchema_GL.RetainedEarning_Acct = table7.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table8 on (C_AcctSchema_GL.IncomeSummary_Acct = table8.C_ValidCombination_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cAcctschemaId==null || cAcctschemaId.equals(""))?"":"  AND C_AcctSchema_GL.C_AcctSchema_ID = ?  ");
    strSql = strSql + 
      "        AND C_AcctSchema_GL.C_Acctschema_Gl_ID = ? " +
      "        AND C_AcctSchema_GL.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_AcctSchema_GL.AD_Org_ID IN (";
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
      if (cAcctschemaId != null && !(cAcctschemaId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
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
        GeneralLedgerData objectGeneralLedgerData = new GeneralLedgerData();
        objectGeneralLedgerData.created = UtilSql.getValue(result, "created");
        objectGeneralLedgerData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectGeneralLedgerData.updated = UtilSql.getValue(result, "updated");
        objectGeneralLedgerData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectGeneralLedgerData.updatedby = UtilSql.getValue(result, "updatedby");
        objectGeneralLedgerData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectGeneralLedgerData.ppvoffsetAcct = UtilSql.getValue(result, "ppvoffset_acct");
        objectGeneralLedgerData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectGeneralLedgerData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectGeneralLedgerData.cfsOrderAcct = UtilSql.getValue(result, "cfs_order_acct");
        objectGeneralLedgerData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectGeneralLedgerData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectGeneralLedgerData.cAcctschemaGlId = UtilSql.getValue(result, "c_acctschema_gl_id");
        objectGeneralLedgerData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectGeneralLedgerData.cAcctschemaIdr = UtilSql.getValue(result, "c_acctschema_idr");
        objectGeneralLedgerData.isactive = UtilSql.getValue(result, "isactive");
        objectGeneralLedgerData.usesuspensebalancing = UtilSql.getValue(result, "usesuspensebalancing");
        objectGeneralLedgerData.suspensebalancingAcct = UtilSql.getValue(result, "suspensebalancing_acct");
        objectGeneralLedgerData.suspensebalancingAcctr = UtilSql.getValue(result, "suspensebalancing_acctr");
        objectGeneralLedgerData.usesuspenseerror = UtilSql.getValue(result, "usesuspenseerror");
        objectGeneralLedgerData.suspenseerrorAcct = UtilSql.getValue(result, "suspenseerror_acct");
        objectGeneralLedgerData.suspenseerrorAcctr = UtilSql.getValue(result, "suspenseerror_acctr");
        objectGeneralLedgerData.usecurrencybalancing = UtilSql.getValue(result, "usecurrencybalancing");
        objectGeneralLedgerData.currencybalancingAcct = UtilSql.getValue(result, "currencybalancing_acct");
        objectGeneralLedgerData.currencybalancingAcctr = UtilSql.getValue(result, "currencybalancing_acctr");
        objectGeneralLedgerData.retainedearningAcct = UtilSql.getValue(result, "retainedearning_acct");
        objectGeneralLedgerData.retainedearningAcctr = UtilSql.getValue(result, "retainedearning_acctr");
        objectGeneralLedgerData.incomesummaryAcct = UtilSql.getValue(result, "incomesummary_acct");
        objectGeneralLedgerData.incomesummaryAcctr = UtilSql.getValue(result, "incomesummary_acctr");
        objectGeneralLedgerData.intercompanyduefromAcct = UtilSql.getValue(result, "intercompanyduefrom_acct");
        objectGeneralLedgerData.intercompanyduetoAcct = UtilSql.getValue(result, "intercompanydueto_acct");
        objectGeneralLedgerData.language = UtilSql.getValue(result, "language");
        objectGeneralLedgerData.adUserClient = "";
        objectGeneralLedgerData.adOrgClient = "";
        objectGeneralLedgerData.createdby = "";
        objectGeneralLedgerData.trBgcolor = "";
        objectGeneralLedgerData.totalCount = "";
        objectGeneralLedgerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGeneralLedgerData);
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
    GeneralLedgerData objectGeneralLedgerData[] = new GeneralLedgerData[vector.size()];
    vector.copyInto(objectGeneralLedgerData);
    return(objectGeneralLedgerData);
  }

/**
Create a registry
 */
  public static GeneralLedgerData[] set(String cAcctschemaId, String suspenseerrorAcct, String suspenseerrorAcctr, String updatedby, String updatedbyr, String usesuspensebalancing, String suspensebalancingAcct, String suspensebalancingAcctr, String incomesummaryAcct, String incomesummaryAcctr, String usesuspenseerror, String adClientId, String ppvoffsetAcct, String cfsOrderAcct, String intercompanyduetoAcct, String adOrgId, String isactive, String retainedearningAcct, String retainedearningAcctr, String intercompanyduefromAcct, String currencybalancingAcct, String currencybalancingAcctr, String usecurrencybalancing, String createdby, String createdbyr, String cAcctschemaGlId)    throws ServletException {
    GeneralLedgerData objectGeneralLedgerData[] = new GeneralLedgerData[1];
    objectGeneralLedgerData[0] = new GeneralLedgerData();
    objectGeneralLedgerData[0].created = "";
    objectGeneralLedgerData[0].createdbyr = createdbyr;
    objectGeneralLedgerData[0].updated = "";
    objectGeneralLedgerData[0].updatedTimeStamp = "";
    objectGeneralLedgerData[0].updatedby = updatedby;
    objectGeneralLedgerData[0].updatedbyr = updatedbyr;
    objectGeneralLedgerData[0].ppvoffsetAcct = ppvoffsetAcct;
    objectGeneralLedgerData[0].adClientId = adClientId;
    objectGeneralLedgerData[0].adClientIdr = "";
    objectGeneralLedgerData[0].cfsOrderAcct = cfsOrderAcct;
    objectGeneralLedgerData[0].adOrgId = adOrgId;
    objectGeneralLedgerData[0].adOrgIdr = "";
    objectGeneralLedgerData[0].cAcctschemaGlId = cAcctschemaGlId;
    objectGeneralLedgerData[0].cAcctschemaId = cAcctschemaId;
    objectGeneralLedgerData[0].cAcctschemaIdr = "";
    objectGeneralLedgerData[0].isactive = isactive;
    objectGeneralLedgerData[0].usesuspensebalancing = usesuspensebalancing;
    objectGeneralLedgerData[0].suspensebalancingAcct = suspensebalancingAcct;
    objectGeneralLedgerData[0].suspensebalancingAcctr = suspensebalancingAcctr;
    objectGeneralLedgerData[0].usesuspenseerror = usesuspenseerror;
    objectGeneralLedgerData[0].suspenseerrorAcct = suspenseerrorAcct;
    objectGeneralLedgerData[0].suspenseerrorAcctr = suspenseerrorAcctr;
    objectGeneralLedgerData[0].usecurrencybalancing = usecurrencybalancing;
    objectGeneralLedgerData[0].currencybalancingAcct = currencybalancingAcct;
    objectGeneralLedgerData[0].currencybalancingAcctr = currencybalancingAcctr;
    objectGeneralLedgerData[0].retainedearningAcct = retainedearningAcct;
    objectGeneralLedgerData[0].retainedearningAcctr = retainedearningAcctr;
    objectGeneralLedgerData[0].incomesummaryAcct = incomesummaryAcct;
    objectGeneralLedgerData[0].incomesummaryAcctr = incomesummaryAcctr;
    objectGeneralLedgerData[0].intercompanyduefromAcct = intercompanyduefromAcct;
    objectGeneralLedgerData[0].intercompanyduetoAcct = intercompanyduetoAcct;
    objectGeneralLedgerData[0].language = "";
    return objectGeneralLedgerData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2493_0(ConnectionProvider connectionProvider, String SuspenseError_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as SuspenseError_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, SuspenseError_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "suspenseerror_acct");
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
  public static String selectDef2489_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef2491_2(ConnectionProvider connectionProvider, String SuspenseBalancing_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as SuspenseBalancing_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, SuspenseBalancing_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "suspensebalancing_acct");
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
  public static String selectDef2501_3(ConnectionProvider connectionProvider, String IncomeSummary_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as IncomeSummary_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IncomeSummary_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "incomesummary_acct");
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
  public static String selectDef2500_4(ConnectionProvider connectionProvider, String RetainedEarning_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as RetainedEarning_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, RetainedEarning_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "retainedearning_acct");
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
  public static String selectDef2495_5(ConnectionProvider connectionProvider, String CurrencyBalancing_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as CurrencyBalancing_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CurrencyBalancing_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "currencybalancing_acct");
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
  public static String selectDef2487_6(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
      "        SELECT C_AcctSchema_GL.C_AcctSchema_ID AS NAME" +
      "        FROM C_AcctSchema_GL" +
      "        WHERE C_AcctSchema_GL.C_Acctschema_Gl_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cAcctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_AcctSchema left join (select C_AcctSchema_ID, Name from C_AcctSchema) table1 on (C_AcctSchema.C_AcctSchema_ID = table1.C_AcctSchema_ID) WHERE C_AcctSchema.C_AcctSchema_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cAcctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_AcctSchema left join (select C_AcctSchema_ID, Name from C_AcctSchema) table1 on (C_AcctSchema.C_AcctSchema_ID = table1.C_AcctSchema_ID) WHERE C_AcctSchema.C_AcctSchema_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

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
      "        UPDATE C_AcctSchema_GL" +
      "        SET PPVOffset_Acct = (?) , AD_Client_ID = (?) , CFS_Order_Acct = (?) , AD_Org_ID = (?) , C_Acctschema_Gl_ID = (?) , C_AcctSchema_ID = (?) , IsActive = (?) , UseSuspenseBalancing = (?) , SuspenseBalancing_Acct = (?) , UseSuspenseError = (?) , SuspenseError_Acct = (?) , UseCurrencyBalancing = (?) , CurrencyBalancing_Acct = (?) , RetainedEarning_Acct = (?) , IncomeSummary_Acct = (?) , IntercompanyDueFrom_Acct = (?) , IntercompanyDueTo_Acct = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_AcctSchema_GL.C_Acctschema_Gl_ID = ? " +
      "                 AND C_AcctSchema_GL.C_AcctSchema_ID = ? " +
      "        AND C_AcctSchema_GL.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_AcctSchema_GL.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ppvoffsetAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cfsOrderAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaGlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usesuspensebalancing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, suspensebalancingAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usesuspenseerror);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, suspenseerrorAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usecurrencybalancing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencybalancingAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, retainedearningAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, incomesummaryAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, intercompanyduefromAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, intercompanyduetoAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaGlId);
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
      "        INSERT INTO C_AcctSchema_GL " +
      "        (PPVOffset_Acct, AD_Client_ID, CFS_Order_Acct, AD_Org_ID, C_Acctschema_Gl_ID, C_AcctSchema_ID, IsActive, UseSuspenseBalancing, SuspenseBalancing_Acct, UseSuspenseError, SuspenseError_Acct, UseCurrencyBalancing, CurrencyBalancing_Acct, RetainedEarning_Acct, IncomeSummary_Acct, IntercompanyDueFrom_Acct, IntercompanyDueTo_Acct, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ppvoffsetAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cfsOrderAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaGlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usesuspensebalancing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, suspensebalancingAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usesuspenseerror);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, suspenseerrorAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usecurrencybalancing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencybalancingAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, retainedearningAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, incomesummaryAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, intercompanyduefromAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, intercompanyduetoAcct);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cAcctschemaId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_AcctSchema_GL" +
      "        WHERE C_AcctSchema_GL.C_Acctschema_Gl_ID = ? " +
      "                 AND C_AcctSchema_GL.C_AcctSchema_ID = ? " +
      "        AND C_AcctSchema_GL.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_AcctSchema_GL.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cAcctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_AcctSchema_GL" +
      "        WHERE C_AcctSchema_GL.C_Acctschema_Gl_ID = ? " +
      "                 AND C_AcctSchema_GL.C_AcctSchema_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

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
      "          FROM C_AcctSchema_GL" +
      "         WHERE C_AcctSchema_GL.C_Acctschema_Gl_ID = ? ";

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
      "          FROM C_AcctSchema_GL" +
      "         WHERE C_AcctSchema_GL.C_Acctschema_Gl_ID = ? ";

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
