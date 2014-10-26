//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.finance.TaxfilePreferences;

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
class Accounts72F73BF6666D4ADFB44A57EEDF3715D9Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Accounts72F73BF6666D4ADFB44A57EEDF3715D9Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zsprBwaprefacctId;
  public String cAcctschemaId;
  public String cAcctschemaIdr;
  public String acctmatch;
  public String isactive;
  public String adClientId;
  public String adOrgId;
  public String zsprBwaprefsId;
  public String zsprBwaprefsIdr;
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
    else if (fieldName.equalsIgnoreCase("zspr_bwaprefacct_id") || fieldName.equals("zsprBwaprefacctId"))
      return zsprBwaprefacctId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_idr") || fieldName.equals("cAcctschemaIdr"))
      return cAcctschemaIdr;
    else if (fieldName.equalsIgnoreCase("acctmatch"))
      return acctmatch;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("zspr_bwaprefs_id") || fieldName.equals("zsprBwaprefsId"))
      return zsprBwaprefsId;
    else if (fieldName.equalsIgnoreCase("zspr_bwaprefs_idr") || fieldName.equals("zsprBwaprefsIdr"))
      return zsprBwaprefsIdr;
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
  public static Accounts72F73BF6666D4ADFB44A57EEDF3715D9Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zsprBwaprefsId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zsprBwaprefsId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Accounts72F73BF6666D4ADFB44A57EEDF3715D9Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zsprBwaprefsId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspr_bwaprefacct.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspr_bwaprefacct.CreatedBy) as CreatedByR, " +
      "        to_char(zspr_bwaprefacct.Updated, ?) as updated, " +
      "        to_char(zspr_bwaprefacct.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspr_bwaprefacct.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspr_bwaprefacct.UpdatedBy) as UpdatedByR," +
      "        zspr_bwaprefacct.Zspr_Bwaprefacct_ID, " +
      "zspr_bwaprefacct.C_Acctschema_ID, " +
      "(CASE WHEN zspr_bwaprefacct.C_Acctschema_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_Acctschema_IDR, " +
      "zspr_bwaprefacct.Acctmatch, " +
      "COALESCE(zspr_bwaprefacct.Isactive, 'N') AS Isactive, " +
      "zspr_bwaprefacct.AD_Client_ID, " +
      "zspr_bwaprefacct.AD_Org_ID, " +
      "zspr_bwaprefacct.Zspr_Bwaprefs_ID, " +
      "(CASE WHEN zspr_bwaprefacct.Zspr_Bwaprefs_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS Zspr_Bwaprefs_IDR, " +
      "        ? AS LANGUAGE " +
      "        FROM zspr_bwaprefacct left join (select C_Acctschema_ID, Name from C_Acctschema) table1 on (zspr_bwaprefacct.C_Acctschema_ID = table1.C_Acctschema_ID) left join (select Zspr_Bwaprefs_ID, Name, Zspr_Bwaheader_ID from Zspr_Bwaprefs) table2 on (zspr_bwaprefacct.Zspr_Bwaprefs_ID = table2.Zspr_Bwaprefs_ID) left join (select Zspr_Bwaheader_ID, Name from Zspr_Bwaheader) table3 on (table2.Zspr_Bwaheader_ID = table3.Zspr_Bwaheader_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zsprBwaprefsId==null || zsprBwaprefsId.equals(""))?"":"  AND zspr_bwaprefacct.Zspr_Bwaprefs_ID = ?  ");
    strSql = strSql + 
      "        AND zspr_bwaprefacct.Zspr_Bwaprefacct_ID = ? " +
      "        AND zspr_bwaprefacct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zspr_bwaprefacct.AD_Org_ID IN (";
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
      if (zsprBwaprefsId != null && !(zsprBwaprefsId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);
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
        Accounts72F73BF6666D4ADFB44A57EEDF3715D9Data objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data = new Accounts72F73BF6666D4ADFB44A57EEDF3715D9Data();
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.created = UtilSql.getValue(result, "created");
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.updated = UtilSql.getValue(result, "updated");
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.zsprBwaprefacctId = UtilSql.getValue(result, "zspr_bwaprefacct_id");
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.cAcctschemaIdr = UtilSql.getValue(result, "c_acctschema_idr");
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.acctmatch = UtilSql.getValue(result, "acctmatch");
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.isactive = UtilSql.getValue(result, "isactive");
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.zsprBwaprefsId = UtilSql.getValue(result, "zspr_bwaprefs_id");
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.zsprBwaprefsIdr = UtilSql.getValue(result, "zspr_bwaprefs_idr");
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.language = UtilSql.getValue(result, "language");
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.adUserClient = "";
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.adOrgClient = "";
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.createdby = "";
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.trBgcolor = "";
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.totalCount = "";
        objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data);
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
    Accounts72F73BF6666D4ADFB44A57EEDF3715D9Data objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[] = new Accounts72F73BF6666D4ADFB44A57EEDF3715D9Data[vector.size()];
    vector.copyInto(objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data);
    return(objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data);
  }

/**
Create a registry
 */
  public static Accounts72F73BF6666D4ADFB44A57EEDF3715D9Data[] set(String zsprBwaprefsId, String updatedby, String updatedbyr, String adClientId, String isactive, String cAcctschemaId, String zsprBwaprefacctId, String createdby, String createdbyr, String adOrgId, String zsprBwaprefsIdr, String acctmatch)    throws ServletException {
    Accounts72F73BF6666D4ADFB44A57EEDF3715D9Data objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[] = new Accounts72F73BF6666D4ADFB44A57EEDF3715D9Data[1];
    objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[0] = new Accounts72F73BF6666D4ADFB44A57EEDF3715D9Data();
    objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[0].created = "";
    objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[0].createdbyr = createdbyr;
    objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[0].updated = "";
    objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[0].updatedTimeStamp = "";
    objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[0].updatedby = updatedby;
    objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[0].updatedbyr = updatedbyr;
    objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[0].zsprBwaprefacctId = zsprBwaprefacctId;
    objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[0].cAcctschemaId = cAcctschemaId;
    objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[0].cAcctschemaIdr = "";
    objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[0].acctmatch = acctmatch;
    objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[0].isactive = isactive;
    objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[0].adClientId = adClientId;
    objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[0].adOrgId = adOrgId;
    objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[0].zsprBwaprefsId = zsprBwaprefsId;
    objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[0].zsprBwaprefsIdr = zsprBwaprefsIdr;
    objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data[0].language = "";
    return objectAccounts72F73BF6666D4ADFB44A57EEDF3715D9Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefD2F139747BCC41C1B0114FEF6E88A6E4_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefC0F0269AAA7A403FBF0957944B1C629C_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefDD6167FF8B6541E4A6B06D8749E2C64A_2(ConnectionProvider connectionProvider, String Zspr_Bwaprefs_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '')  || ' - ' || COALESCE(TO_CHAR(table2.Name), '') ) as Zspr_Bwaprefs_ID FROM Zspr_Bwaprefs table1 left join Zspr_Bwaheader table2 on (table1.Zspr_Bwaheader_ID = table2.Zspr_Bwaheader_ID) WHERE table1.isActive='Y' AND table1.Zspr_Bwaprefs_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Zspr_Bwaprefs_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zspr_bwaprefs_id");
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
      "        SELECT zspr_bwaprefacct.Zspr_Bwaprefs_ID AS NAME" +
      "        FROM zspr_bwaprefacct" +
      "        WHERE zspr_bwaprefacct.Zspr_Bwaprefacct_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String zsprBwaprefsId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))) AS NAME FROM zspr_bwaprefs left join (select Zspr_Bwaprefs_ID, Name, Zspr_Bwaheader_ID from Zspr_Bwaprefs) table1 on (zspr_bwaprefs.Zspr_Bwaprefs_ID = table1.Zspr_Bwaprefs_ID) left join (select Zspr_Bwaheader_ID, Name from Zspr_Bwaheader) table2 on (table1.Zspr_Bwaheader_ID = table2.Zspr_Bwaheader_ID) WHERE zspr_bwaprefs.Zspr_Bwaprefs_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zsprBwaprefsId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))) AS NAME FROM zspr_bwaprefs left join (select Zspr_Bwaprefs_ID, Name, Zspr_Bwaheader_ID from Zspr_Bwaprefs) table1 on (zspr_bwaprefs.Zspr_Bwaprefs_ID = table1.Zspr_Bwaprefs_ID) left join (select Zspr_Bwaheader_ID, Name from Zspr_Bwaheader) table2 on (table1.Zspr_Bwaheader_ID = table2.Zspr_Bwaheader_ID) WHERE zspr_bwaprefs.Zspr_Bwaprefs_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);

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
      "        UPDATE zspr_bwaprefacct" +
      "        SET Zspr_Bwaprefacct_ID = (?) , C_Acctschema_ID = (?) , Acctmatch = (?) , Isactive = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Zspr_Bwaprefs_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zspr_bwaprefacct.Zspr_Bwaprefacct_ID = ? " +
      "                 AND zspr_bwaprefacct.Zspr_Bwaprefs_ID = ? " +
      "        AND zspr_bwaprefacct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspr_bwaprefacct.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefacctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctmatch);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefacctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);
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
      "        INSERT INTO zspr_bwaprefacct " +
      "        (Zspr_Bwaprefacct_ID, C_Acctschema_ID, Acctmatch, Isactive, AD_Client_ID, AD_Org_ID, Zspr_Bwaprefs_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefacctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctmatch);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zsprBwaprefsId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspr_bwaprefacct" +
      "        WHERE zspr_bwaprefacct.Zspr_Bwaprefacct_ID = ? " +
      "                 AND zspr_bwaprefacct.Zspr_Bwaprefs_ID = ? " +
      "        AND zspr_bwaprefacct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspr_bwaprefacct.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zsprBwaprefsId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspr_bwaprefacct" +
      "        WHERE zspr_bwaprefacct.Zspr_Bwaprefacct_ID = ? " +
      "                 AND zspr_bwaprefacct.Zspr_Bwaprefs_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);

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
      "          FROM zspr_bwaprefacct" +
      "         WHERE zspr_bwaprefacct.Zspr_Bwaprefacct_ID = ? ";

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
      "          FROM zspr_bwaprefacct" +
      "         WHERE zspr_bwaprefacct.Zspr_Bwaprefacct_ID = ? ";

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
