//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.finance.Assets;

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
class Accounting800190Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Accounting800190Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String aAssetAcctId;
  public String adClientId;
  public String adClientIdr;
  public String aAssetId;
  public String adOrgId;
  public String adOrgIdr;
  public String cAcctschemaId;
  public String cAcctschemaIdr;
  public String isactive;
  public String aAccumdepreciationAcct;
  public String aAccumdepreciationAcctr;
  public String aDepreciationAcct;
  public String aDepreciationAcctr;
  public String aDisposalLoss;
  public String aDisposalGain;
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
    else if (fieldName.equalsIgnoreCase("a_asset_acct_id") || fieldName.equals("aAssetAcctId"))
      return aAssetAcctId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_idr") || fieldName.equals("cAcctschemaIdr"))
      return cAcctschemaIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("a_accumdepreciation_acct") || fieldName.equals("aAccumdepreciationAcct"))
      return aAccumdepreciationAcct;
    else if (fieldName.equalsIgnoreCase("a_accumdepreciation_acctr") || fieldName.equals("aAccumdepreciationAcctr"))
      return aAccumdepreciationAcctr;
    else if (fieldName.equalsIgnoreCase("a_depreciation_acct") || fieldName.equals("aDepreciationAcct"))
      return aDepreciationAcct;
    else if (fieldName.equalsIgnoreCase("a_depreciation_acctr") || fieldName.equals("aDepreciationAcctr"))
      return aDepreciationAcctr;
    else if (fieldName.equalsIgnoreCase("a_disposal_loss") || fieldName.equals("aDisposalLoss"))
      return aDisposalLoss;
    else if (fieldName.equalsIgnoreCase("a_disposal_gain") || fieldName.equals("aDisposalGain"))
      return aDisposalGain;
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
  public static Accounting800190Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String aAssetId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, aAssetId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Accounting800190Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String aAssetId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(A_Asset_Acct.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = A_Asset_Acct.CreatedBy) as CreatedByR, " +
      "        to_char(A_Asset_Acct.Updated, ?) as updated, " +
      "        to_char(A_Asset_Acct.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        A_Asset_Acct.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = A_Asset_Acct.UpdatedBy) as UpdatedByR," +
      "        A_Asset_Acct.A_Asset_Acct_ID, " +
      "A_Asset_Acct.AD_Client_ID, " +
      "(CASE WHEN A_Asset_Acct.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "A_Asset_Acct.A_Asset_ID, " +
      "A_Asset_Acct.AD_Org_ID, " +
      "(CASE WHEN A_Asset_Acct.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "A_Asset_Acct.C_AcctSchema_ID, " +
      "(CASE WHEN A_Asset_Acct.C_AcctSchema_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_AcctSchema_IDR, " +
      "COALESCE(A_Asset_Acct.IsActive, 'N') AS IsActive, " +
      "A_Asset_Acct.A_Accumdepreciation_Acct, " +
      "(CASE WHEN A_Asset_Acct.A_Accumdepreciation_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Combination), ''))),'') ) END) AS A_Accumdepreciation_AcctR, " +
      "A_Asset_Acct.A_Depreciation_Acct, " +
      "(CASE WHEN A_Asset_Acct.A_Depreciation_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Combination), ''))),'') ) END) AS A_Depreciation_AcctR, " +
      "A_Asset_Acct.A_Disposal_Loss, " +
      "A_Asset_Acct.A_Disposal_Gain, " +
      "        ? AS LANGUAGE " +
      "        FROM A_Asset_Acct left join (select AD_Client_ID, Name from AD_Client) table1 on (A_Asset_Acct.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (A_Asset_Acct.AD_Org_ID = table2.AD_Org_ID) left join (select C_AcctSchema_ID, Name from C_AcctSchema) table3 on (A_Asset_Acct.C_AcctSchema_ID = table3.C_AcctSchema_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table4 on (A_Asset_Acct.A_Accumdepreciation_Acct = table4.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table5 on (A_Asset_Acct.A_Depreciation_Acct = table5.C_ValidCombination_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((aAssetId==null || aAssetId.equals(""))?"":"  AND A_Asset_Acct.A_Asset_ID = ?  ");
    strSql = strSql + 
      "        AND A_Asset_Acct.A_Asset_Acct_ID = ? " +
      "        AND A_Asset_Acct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND A_Asset_Acct.AD_Org_ID IN (";
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
      if (aAssetId != null && !(aAssetId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
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
        Accounting800190Data objectAccounting800190Data = new Accounting800190Data();
        objectAccounting800190Data.created = UtilSql.getValue(result, "created");
        objectAccounting800190Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectAccounting800190Data.updated = UtilSql.getValue(result, "updated");
        objectAccounting800190Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectAccounting800190Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectAccounting800190Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectAccounting800190Data.aAssetAcctId = UtilSql.getValue(result, "a_asset_acct_id");
        objectAccounting800190Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAccounting800190Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectAccounting800190Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectAccounting800190Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAccounting800190Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectAccounting800190Data.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectAccounting800190Data.cAcctschemaIdr = UtilSql.getValue(result, "c_acctschema_idr");
        objectAccounting800190Data.isactive = UtilSql.getValue(result, "isactive");
        objectAccounting800190Data.aAccumdepreciationAcct = UtilSql.getValue(result, "a_accumdepreciation_acct");
        objectAccounting800190Data.aAccumdepreciationAcctr = UtilSql.getValue(result, "a_accumdepreciation_acctr");
        objectAccounting800190Data.aDepreciationAcct = UtilSql.getValue(result, "a_depreciation_acct");
        objectAccounting800190Data.aDepreciationAcctr = UtilSql.getValue(result, "a_depreciation_acctr");
        objectAccounting800190Data.aDisposalLoss = UtilSql.getValue(result, "a_disposal_loss");
        objectAccounting800190Data.aDisposalGain = UtilSql.getValue(result, "a_disposal_gain");
        objectAccounting800190Data.language = UtilSql.getValue(result, "language");
        objectAccounting800190Data.adUserClient = "";
        objectAccounting800190Data.adOrgClient = "";
        objectAccounting800190Data.createdby = "";
        objectAccounting800190Data.trBgcolor = "";
        objectAccounting800190Data.totalCount = "";
        objectAccounting800190Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccounting800190Data);
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
    Accounting800190Data objectAccounting800190Data[] = new Accounting800190Data[vector.size()];
    vector.copyInto(objectAccounting800190Data);
    return(objectAccounting800190Data);
  }

/**
Create a registry
 */
  public static Accounting800190Data[] set(String aAssetId, String aAssetAcctId, String aAccumdepreciationAcct, String aAccumdepreciationAcctr, String aDisposalGain, String updatedby, String updatedbyr, String aDisposalLoss, String createdby, String createdbyr, String adClientId, String aDepreciationAcct, String aDepreciationAcctr, String cAcctschemaId, String adOrgId, String isactive)    throws ServletException {
    Accounting800190Data objectAccounting800190Data[] = new Accounting800190Data[1];
    objectAccounting800190Data[0] = new Accounting800190Data();
    objectAccounting800190Data[0].created = "";
    objectAccounting800190Data[0].createdbyr = createdbyr;
    objectAccounting800190Data[0].updated = "";
    objectAccounting800190Data[0].updatedTimeStamp = "";
    objectAccounting800190Data[0].updatedby = updatedby;
    objectAccounting800190Data[0].updatedbyr = updatedbyr;
    objectAccounting800190Data[0].aAssetAcctId = aAssetAcctId;
    objectAccounting800190Data[0].adClientId = adClientId;
    objectAccounting800190Data[0].adClientIdr = "";
    objectAccounting800190Data[0].aAssetId = aAssetId;
    objectAccounting800190Data[0].adOrgId = adOrgId;
    objectAccounting800190Data[0].adOrgIdr = "";
    objectAccounting800190Data[0].cAcctschemaId = cAcctschemaId;
    objectAccounting800190Data[0].cAcctschemaIdr = "";
    objectAccounting800190Data[0].isactive = isactive;
    objectAccounting800190Data[0].aAccumdepreciationAcct = aAccumdepreciationAcct;
    objectAccounting800190Data[0].aAccumdepreciationAcctr = aAccumdepreciationAcctr;
    objectAccounting800190Data[0].aDepreciationAcct = aDepreciationAcct;
    objectAccounting800190Data[0].aDepreciationAcctr = aDepreciationAcctr;
    objectAccounting800190Data[0].aDisposalLoss = aDisposalLoss;
    objectAccounting800190Data[0].aDisposalGain = aDisposalGain;
    objectAccounting800190Data[0].language = "";
    return objectAccounting800190Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef802798_0(ConnectionProvider connectionProvider, String A_Accumdepreciation_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as A_Accumdepreciation_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, A_Accumdepreciation_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "a_accumdepreciation_acct");
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
  public static String selectDef802795_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef802793_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef802797_3(ConnectionProvider connectionProvider, String A_Depreciation_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as A_Depreciation_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, A_Depreciation_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "a_depreciation_acct");
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
      "        SELECT A_Asset_Acct.A_Asset_ID AS NAME" +
      "        FROM A_Asset_Acct" +
      "        WHERE A_Asset_Acct.A_Asset_Acct_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String aAssetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM A_Asset left join (select A_Asset_ID, Name from A_Asset) table1 on (A_Asset.A_Asset_ID = table1.A_Asset_ID) WHERE A_Asset.A_Asset_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String aAssetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM A_Asset left join (select A_Asset_ID, Name from A_Asset) table1 on (A_Asset.A_Asset_ID = table1.A_Asset_ID) WHERE A_Asset.A_Asset_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);

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
      "        UPDATE A_Asset_Acct" +
      "        SET A_Asset_Acct_ID = (?) , AD_Client_ID = (?) , A_Asset_ID = (?) , AD_Org_ID = (?) , C_AcctSchema_ID = (?) , IsActive = (?) , A_Accumdepreciation_Acct = (?) , A_Depreciation_Acct = (?) , A_Disposal_Loss = (?) , A_Disposal_Gain = (?) , updated = now(), updatedby = ? " +
      "        WHERE A_Asset_Acct.A_Asset_Acct_ID = ? " +
      "                 AND A_Asset_Acct.A_Asset_ID = ? " +
      "        AND A_Asset_Acct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND A_Asset_Acct.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetAcctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAccumdepreciationAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aDepreciationAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aDisposalLoss);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aDisposalGain);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetAcctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
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
      "        INSERT INTO A_Asset_Acct " +
      "        (A_Asset_Acct_ID, AD_Client_ID, A_Asset_ID, AD_Org_ID, C_AcctSchema_ID, IsActive, A_Accumdepreciation_Acct, A_Depreciation_Acct, A_Disposal_Loss, A_Disposal_Gain, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetAcctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAccumdepreciationAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aDepreciationAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aDisposalLoss);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aDisposalGain);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String aAssetId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM A_Asset_Acct" +
      "        WHERE A_Asset_Acct.A_Asset_Acct_ID = ? " +
      "                 AND A_Asset_Acct.A_Asset_ID = ? " +
      "        AND A_Asset_Acct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND A_Asset_Acct.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String aAssetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM A_Asset_Acct" +
      "        WHERE A_Asset_Acct.A_Asset_Acct_ID = ? " +
      "                 AND A_Asset_Acct.A_Asset_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);

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
      "          FROM A_Asset_Acct" +
      "         WHERE A_Asset_Acct.A_Asset_Acct_ID = ? ";

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
      "          FROM A_Asset_Acct" +
      "         WHERE A_Asset_Acct.A_Asset_Acct_ID = ? ";

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
