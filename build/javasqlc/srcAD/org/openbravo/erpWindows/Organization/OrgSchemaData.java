//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Organization;

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
class OrgSchemaData implements FieldProvider {
static Logger log4j = Logger.getLogger(OrgSchemaData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adOrgAcctschemaId;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String cAcctschemaId;
  public String cAcctschemaIdr;
  public String cTaxId;
  public String cTaxIdr;
  public String isbpnewaccount;
  public String adSequenceBpId;
  public String adSequencePrId;
  public String isprnewaccount;
  public String acctLength;
  public String subacctLength;
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
    else if (fieldName.equalsIgnoreCase("ad_org_acctschema_id") || fieldName.equals("adOrgAcctschemaId"))
      return adOrgAcctschemaId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_idr") || fieldName.equals("cAcctschemaIdr"))
      return cAcctschemaIdr;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("c_tax_idr") || fieldName.equals("cTaxIdr"))
      return cTaxIdr;
    else if (fieldName.equalsIgnoreCase("isbpnewaccount"))
      return isbpnewaccount;
    else if (fieldName.equalsIgnoreCase("ad_sequence_bp_id") || fieldName.equals("adSequenceBpId"))
      return adSequenceBpId;
    else if (fieldName.equalsIgnoreCase("ad_sequence_pr_id") || fieldName.equals("adSequencePrId"))
      return adSequencePrId;
    else if (fieldName.equalsIgnoreCase("isprnewaccount"))
      return isprnewaccount;
    else if (fieldName.equalsIgnoreCase("acct_length") || fieldName.equals("acctLength"))
      return acctLength;
    else if (fieldName.equalsIgnoreCase("subacct_length") || fieldName.equals("subacctLength"))
      return subacctLength;
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
  public static OrgSchemaData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String ad_org_id, String adOrgId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, ad_org_id, adOrgId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static OrgSchemaData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String ad_org_id, String adOrgId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Org_AcctSchema.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Org_AcctSchema.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Org_AcctSchema.Updated, ?) as updated, " +
      "        to_char(AD_Org_AcctSchema.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Org_AcctSchema.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Org_AcctSchema.UpdatedBy) as UpdatedByR," +
      "        AD_Org_AcctSchema.AD_Client_ID, " +
      "(CASE WHEN AD_Org_AcctSchema.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Org_AcctSchema.AD_Org_Acctschema_ID, " +
      "AD_Org_AcctSchema.AD_Org_ID, " +
      "(CASE WHEN AD_Org_AcctSchema.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(AD_Org_AcctSchema.Isactive, 'N') AS Isactive, " +
      "AD_Org_AcctSchema.C_Acctschema_ID, " +
      "(CASE WHEN AD_Org_AcctSchema.C_Acctschema_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Acctschema_IDR, " +
      "AD_Org_AcctSchema.C_Tax_ID, " +
      "(CASE WHEN AD_Org_AcctSchema.C_Tax_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_Tax_IDR, " +
      "COALESCE(AD_Org_AcctSchema.IsBpNewAccount, 'N') AS IsBpNewAccount, " +
      "AD_Org_AcctSchema.AD_Sequence_Bp_ID, " +
      "AD_Org_AcctSchema.AD_Sequence_Pr_ID, " +
      "COALESCE(AD_Org_AcctSchema.IsPrNewAccount, 'N') AS IsPrNewAccount, " +
      "AD_Org_AcctSchema.Acct_Length, " +
      "AD_Org_AcctSchema.SubAcct_Length, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Org_AcctSchema left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Org_AcctSchema.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_Org_AcctSchema.AD_Org_ID = table2.AD_Org_ID) left join (select C_Acctschema_ID, Name from C_Acctschema) table3 on (AD_Org_AcctSchema.C_Acctschema_ID = table3.C_Acctschema_ID) left join (select C_Tax_ID, Name from C_Tax) table4 on (AD_Org_AcctSchema.C_Tax_ID = table4.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL4 on (table4.C_Tax_ID = tableTRL4.C_Tax_ID and tableTRL4.AD_Language = ?) " +
      "        WHERE 2=2 " +
      " AND ad_org_acctschema.ad_org_id=?" +
      "        AND 1=1 ";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":"  AND AD_Org_AcctSchema.AD_Org_ID = ?  ");
    strSql = strSql + 
      "        AND AD_Org_AcctSchema.AD_Org_Acctschema_ID = ? " +
      "        AND AD_Org_AcctSchema.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Org_AcctSchema.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
        OrgSchemaData objectOrgSchemaData = new OrgSchemaData();
        objectOrgSchemaData.created = UtilSql.getValue(result, "created");
        objectOrgSchemaData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectOrgSchemaData.updated = UtilSql.getValue(result, "updated");
        objectOrgSchemaData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectOrgSchemaData.updatedby = UtilSql.getValue(result, "updatedby");
        objectOrgSchemaData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectOrgSchemaData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectOrgSchemaData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectOrgSchemaData.adOrgAcctschemaId = UtilSql.getValue(result, "ad_org_acctschema_id");
        objectOrgSchemaData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectOrgSchemaData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectOrgSchemaData.isactive = UtilSql.getValue(result, "isactive");
        objectOrgSchemaData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectOrgSchemaData.cAcctschemaIdr = UtilSql.getValue(result, "c_acctschema_idr");
        objectOrgSchemaData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectOrgSchemaData.cTaxIdr = UtilSql.getValue(result, "c_tax_idr");
        objectOrgSchemaData.isbpnewaccount = UtilSql.getValue(result, "isbpnewaccount");
        objectOrgSchemaData.adSequenceBpId = UtilSql.getValue(result, "ad_sequence_bp_id");
        objectOrgSchemaData.adSequencePrId = UtilSql.getValue(result, "ad_sequence_pr_id");
        objectOrgSchemaData.isprnewaccount = UtilSql.getValue(result, "isprnewaccount");
        objectOrgSchemaData.acctLength = UtilSql.getValue(result, "acct_length");
        objectOrgSchemaData.subacctLength = UtilSql.getValue(result, "subacct_length");
        objectOrgSchemaData.language = UtilSql.getValue(result, "language");
        objectOrgSchemaData.adUserClient = "";
        objectOrgSchemaData.adOrgClient = "";
        objectOrgSchemaData.createdby = "";
        objectOrgSchemaData.trBgcolor = "";
        objectOrgSchemaData.totalCount = "";
        objectOrgSchemaData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOrgSchemaData);
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
    OrgSchemaData objectOrgSchemaData[] = new OrgSchemaData[vector.size()];
    vector.copyInto(objectOrgSchemaData);
    return(objectOrgSchemaData);
  }

/**
Create a registry
 */
  public static OrgSchemaData[] set(String adOrgId, String updatedby, String cTaxId, String cAcctschemaId, String createdby, String isprnewaccount, String adClientId, String isactive, String adSequencePrId, String adOrgAcctschemaId, String subacctLength, String acctLength, String adSequenceBpId, String isbpnewaccount)    throws ServletException {
    OrgSchemaData objectOrgSchemaData[] = new OrgSchemaData[1];
    objectOrgSchemaData[0] = new OrgSchemaData();
    objectOrgSchemaData[0].created = "";
    objectOrgSchemaData[0].createdbyr = "";
    objectOrgSchemaData[0].updated = "";
    objectOrgSchemaData[0].updatedTimeStamp = "";
    objectOrgSchemaData[0].updatedby = updatedby;
    objectOrgSchemaData[0].updatedbyr = "";
    objectOrgSchemaData[0].adClientId = adClientId;
    objectOrgSchemaData[0].adClientIdr = "";
    objectOrgSchemaData[0].adOrgAcctschemaId = adOrgAcctschemaId;
    objectOrgSchemaData[0].adOrgId = adOrgId;
    objectOrgSchemaData[0].adOrgIdr = "";
    objectOrgSchemaData[0].isactive = isactive;
    objectOrgSchemaData[0].cAcctschemaId = cAcctschemaId;
    objectOrgSchemaData[0].cAcctschemaIdr = "";
    objectOrgSchemaData[0].cTaxId = cTaxId;
    objectOrgSchemaData[0].cTaxIdr = "";
    objectOrgSchemaData[0].isbpnewaccount = isbpnewaccount;
    objectOrgSchemaData[0].adSequenceBpId = adSequenceBpId;
    objectOrgSchemaData[0].adSequencePrId = adSequencePrId;
    objectOrgSchemaData[0].isprnewaccount = isprnewaccount;
    objectOrgSchemaData[0].acctLength = acctLength;
    objectOrgSchemaData[0].subacctLength = subacctLength;
    objectOrgSchemaData[0].language = "";
    return objectOrgSchemaData;
  }

/**
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_Org_AcctSchema.AD_Org_ID AS NAME" +
      "        FROM AD_Org_AcctSchema" +
      "        WHERE AD_Org_AcctSchema.AD_Org_Acctschema_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Org left join (select AD_Org_ID, Name from AD_Org) table1 on (AD_Org.AD_Org_ID = table1.AD_Org_ID) WHERE AD_Org.AD_Org_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Org left join (select AD_Org_ID, Name from AD_Org) table1 on (AD_Org.AD_Org_ID = table1.AD_Org_ID) WHERE AD_Org.AD_Org_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
      "        UPDATE AD_Org_AcctSchema" +
      "        SET AD_Client_ID = (?) , AD_Org_Acctschema_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , C_Acctschema_ID = (?) , C_Tax_ID = (?) , IsBpNewAccount = (?) , AD_Sequence_Bp_ID = (?) , AD_Sequence_Pr_ID = (?) , IsPrNewAccount = (?) , Acct_Length = TO_NUMBER(?) , SubAcct_Length = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Org_AcctSchema.AD_Org_Acctschema_ID = ? " +
      "                 AND AD_Org_AcctSchema.AD_Org_ID = ? " +
      "        AND AD_Org_AcctSchema.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Org_AcctSchema.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbpnewaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSequenceBpId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSequencePrId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprnewaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctLength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subacctLength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
      "        INSERT INTO AD_Org_AcctSchema " +
      "        (AD_Client_ID, AD_Org_Acctschema_ID, AD_Org_ID, Isactive, C_Acctschema_ID, C_Tax_ID, IsBpNewAccount, AD_Sequence_Bp_ID, AD_Sequence_Pr_ID, IsPrNewAccount, Acct_Length, SubAcct_Length, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbpnewaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSequenceBpId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSequencePrId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprnewaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctLength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subacctLength);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adOrgId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Org_AcctSchema" +
      "        WHERE AD_Org_AcctSchema.AD_Org_Acctschema_ID = ? " +
      "                 AND AD_Org_AcctSchema.AD_Org_ID = ? " +
      "        AND AD_Org_AcctSchema.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Org_AcctSchema.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Org_AcctSchema" +
      "        WHERE AD_Org_AcctSchema.AD_Org_Acctschema_ID = ? " +
      "                 AND AD_Org_AcctSchema.AD_Org_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
      "          FROM AD_Org_AcctSchema" +
      "         WHERE AD_Org_AcctSchema.AD_Org_Acctschema_ID = ? ";

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
      "          FROM AD_Org_AcctSchema" +
      "         WHERE AD_Org_AcctSchema.AD_Org_Acctschema_ID = ? ";

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
