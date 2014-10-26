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
class PrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data implements FieldProvider {
static Logger log4j = Logger.getLogger(PrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String zsprPrintinfoId;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String addressheader;
  public String onelineadr;
  public String address1;
  public String address2;
  public String address3;
  public String address4;
  public String address5;
  public String address6;
  public String address7;
  public String address8;
  public String address9;
  public String isfootergroupstyle;
  public String footer1;
  public String footer2;
  public String footer3;
  public String footer4;
  public String footer5;
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
    else if (fieldName.equalsIgnoreCase("zspr_printinfo_id") || fieldName.equals("zsprPrintinfoId"))
      return zsprPrintinfoId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("addressheader"))
      return addressheader;
    else if (fieldName.equalsIgnoreCase("onelineadr"))
      return onelineadr;
    else if (fieldName.equalsIgnoreCase("address1"))
      return address1;
    else if (fieldName.equalsIgnoreCase("address2"))
      return address2;
    else if (fieldName.equalsIgnoreCase("address3"))
      return address3;
    else if (fieldName.equalsIgnoreCase("address4"))
      return address4;
    else if (fieldName.equalsIgnoreCase("address5"))
      return address5;
    else if (fieldName.equalsIgnoreCase("address6"))
      return address6;
    else if (fieldName.equalsIgnoreCase("address7"))
      return address7;
    else if (fieldName.equalsIgnoreCase("address8"))
      return address8;
    else if (fieldName.equalsIgnoreCase("address9"))
      return address9;
    else if (fieldName.equalsIgnoreCase("isfootergroupstyle"))
      return isfootergroupstyle;
    else if (fieldName.equalsIgnoreCase("footer1"))
      return footer1;
    else if (fieldName.equalsIgnoreCase("footer2"))
      return footer2;
    else if (fieldName.equalsIgnoreCase("footer3"))
      return footer3;
    else if (fieldName.equalsIgnoreCase("footer4"))
      return footer4;
    else if (fieldName.equalsIgnoreCase("footer5"))
      return footer5;
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
  public static PrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String ad_org_id, String adOrgId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, ad_org_id, adOrgId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String ad_org_id, String adOrgId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspr_printinfo.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspr_printinfo.CreatedBy) as CreatedByR, " +
      "        to_char(zspr_printinfo.Updated, ?) as updated, " +
      "        to_char(zspr_printinfo.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspr_printinfo.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspr_printinfo.UpdatedBy) as UpdatedByR," +
      "        zspr_printinfo.AD_Client_ID, " +
      "(CASE WHEN zspr_printinfo.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "zspr_printinfo.Zspr_Printinfo_ID, " +
      "zspr_printinfo.AD_Org_ID, " +
      "(CASE WHEN zspr_printinfo.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(zspr_printinfo.Isactive, 'N') AS Isactive, " +
      "zspr_printinfo.Addressheader, " +
      "zspr_printinfo.Onelineadr, " +
      "zspr_printinfo.Address1, " +
      "zspr_printinfo.Address2, " +
      "zspr_printinfo.Address3, " +
      "zspr_printinfo.Address4, " +
      "zspr_printinfo.Address5, " +
      "zspr_printinfo.Address6, " +
      "zspr_printinfo.Address7, " +
      "zspr_printinfo.Address8, " +
      "zspr_printinfo.Address9, " +
      "COALESCE(zspr_printinfo.Isfootergroupstyle, 'N') AS Isfootergroupstyle, " +
      "zspr_printinfo.Footer1, " +
      "zspr_printinfo.Footer2, " +
      "zspr_printinfo.Footer3, " +
      "zspr_printinfo.Footer4, " +
      "zspr_printinfo.Footer5, " +
      "        ? AS LANGUAGE " +
      "        FROM zspr_printinfo left join (select AD_Client_ID, Name from AD_Client) table1 on (zspr_printinfo.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (zspr_printinfo.AD_Org_ID = table2.AD_Org_ID)" +
      "        WHERE 2=2 " +
      " AND zspr_printinfo.ad_org_id=?" +
      "        AND 1=1 ";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":"  AND zspr_printinfo.AD_Org_ID = ?  ");
    strSql = strSql + 
      "        AND zspr_printinfo.Zspr_Printinfo_ID = ? " +
      "        AND zspr_printinfo.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zspr_printinfo.AD_Org_ID IN (";
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
        PrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data = new PrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data();
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.created = UtilSql.getValue(result, "created");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.updated = UtilSql.getValue(result, "updated");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.zsprPrintinfoId = UtilSql.getValue(result, "zspr_printinfo_id");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.isactive = UtilSql.getValue(result, "isactive");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.addressheader = UtilSql.getValue(result, "addressheader");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.onelineadr = UtilSql.getValue(result, "onelineadr");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.address1 = UtilSql.getValue(result, "address1");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.address2 = UtilSql.getValue(result, "address2");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.address3 = UtilSql.getValue(result, "address3");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.address4 = UtilSql.getValue(result, "address4");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.address5 = UtilSql.getValue(result, "address5");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.address6 = UtilSql.getValue(result, "address6");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.address7 = UtilSql.getValue(result, "address7");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.address8 = UtilSql.getValue(result, "address8");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.address9 = UtilSql.getValue(result, "address9");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.isfootergroupstyle = UtilSql.getValue(result, "isfootergroupstyle");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.footer1 = UtilSql.getValue(result, "footer1");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.footer2 = UtilSql.getValue(result, "footer2");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.footer3 = UtilSql.getValue(result, "footer3");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.footer4 = UtilSql.getValue(result, "footer4");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.footer5 = UtilSql.getValue(result, "footer5");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.language = UtilSql.getValue(result, "language");
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.adUserClient = "";
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.adOrgClient = "";
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.createdby = "";
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.trBgcolor = "";
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.totalCount = "";
        objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data);
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
    PrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[] = new PrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[vector.size()];
    vector.copyInto(objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data);
    return(objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data);
  }

/**
Create a registry
 */
  public static PrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[] set(String adOrgId, String address8, String isactive, String address2, String address6, String onelineadr, String updatedby, String updatedbyr, String isfootergroupstyle, String addressheader, String footer5, String zsprPrintinfoId, String address1, String address3, String footer1, String adClientId, String address7, String address9, String address4, String createdby, String createdbyr, String footer4, String footer2, String address5, String footer3)    throws ServletException {
    PrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[] = new PrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[1];
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0] = new PrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data();
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].created = "";
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].createdbyr = createdbyr;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].updated = "";
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].updatedTimeStamp = "";
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].updatedby = updatedby;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].updatedbyr = updatedbyr;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].adClientId = adClientId;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].adClientIdr = "";
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].zsprPrintinfoId = zsprPrintinfoId;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].adOrgId = adOrgId;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].adOrgIdr = "";
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].isactive = isactive;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].addressheader = addressheader;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].onelineadr = onelineadr;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].address1 = address1;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].address2 = address2;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].address3 = address3;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].address4 = address4;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].address5 = address5;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].address6 = address6;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].address7 = address7;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].address8 = address8;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].address9 = address9;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].isfootergroupstyle = isfootergroupstyle;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].footer1 = footer1;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].footer2 = footer2;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].footer3 = footer3;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].footer4 = footer4;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].footer5 = footer5;
    objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data[0].language = "";
    return objectPrintoutSetup1930504C35B74ABF856CE3EFACA30E86Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef0B4283540BB5418C96C64D3C5267880F_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefC6E91D721EF847E2BCEE9A2CD6253DED_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zspr_printinfo.AD_Org_ID AS NAME" +
      "        FROM zspr_printinfo" +
      "        WHERE zspr_printinfo.Zspr_Printinfo_ID = ?";

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
      "        UPDATE zspr_printinfo" +
      "        SET AD_Client_ID = (?) , Zspr_Printinfo_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , Addressheader = (?) , Onelineadr = (?) , Address1 = (?) , Address2 = (?) , Address3 = (?) , Address4 = (?) , Address5 = (?) , Address6 = (?) , Address7 = (?) , Address8 = (?) , Address9 = (?) , Isfootergroupstyle = (?) , Footer1 = (?) , Footer2 = (?) , Footer3 = (?) , Footer4 = (?) , Footer5 = (?) , updated = now(), updatedby = ? " +
      "        WHERE zspr_printinfo.Zspr_Printinfo_ID = ? " +
      "                 AND zspr_printinfo.AD_Org_ID = ? " +
      "        AND zspr_printinfo.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspr_printinfo.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprPrintinfoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, addressheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onelineadr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address5);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address6);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address7);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address8);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address9);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfootergroupstyle);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer5);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprPrintinfoId);
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
      "        INSERT INTO zspr_printinfo " +
      "        (AD_Client_ID, Zspr_Printinfo_ID, AD_Org_ID, Isactive, Addressheader, Onelineadr, Address1, Address2, Address3, Address4, Address5, Address6, Address7, Address8, Address9, Isfootergroupstyle, Footer1, Footer2, Footer3, Footer4, Footer5, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprPrintinfoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, addressheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onelineadr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address5);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address6);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address7);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address8);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address9);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfootergroupstyle);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer5);
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
      "        DELETE FROM zspr_printinfo" +
      "        WHERE zspr_printinfo.Zspr_Printinfo_ID = ? " +
      "                 AND zspr_printinfo.AD_Org_ID = ? " +
      "        AND zspr_printinfo.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspr_printinfo.AD_Org_ID IN (";
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
      "        DELETE FROM zspr_printinfo" +
      "        WHERE zspr_printinfo.Zspr_Printinfo_ID = ? " +
      "                 AND zspr_printinfo.AD_Org_ID = ? ";

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
      "          FROM zspr_printinfo" +
      "         WHERE zspr_printinfo.Zspr_Printinfo_ID = ? ";

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
      "          FROM zspr_printinfo" +
      "         WHERE zspr_printinfo.Zspr_Printinfo_ID = ? ";

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
