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
class ReportStructure4B9AA850B2334D80959C56152C32E25EData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportStructure4B9AA850B2334D80959C56152C32E25EData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String zsprBwaprefsId;
  public String adOrgId;
  public String adOrgIdr;
  public String zsprBwaheaderId;
  public String zsprBwaheaderIdr;
  public String name;
  public String orderno;
  public String isasset;
  public String sumfrombeginning;
  public String allwowonlypositive;
  public String allwowonlynegative;
  public String dontprintdetails;
  public String issuminfooter;
  public String isparent;
  public String parentpref;
  public String parentprefr;
  public String isactive;
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
    else if (fieldName.equalsIgnoreCase("zspr_bwaprefs_id") || fieldName.equals("zsprBwaprefsId"))
      return zsprBwaprefsId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("zspr_bwaheader_id") || fieldName.equals("zsprBwaheaderId"))
      return zsprBwaheaderId;
    else if (fieldName.equalsIgnoreCase("zspr_bwaheader_idr") || fieldName.equals("zsprBwaheaderIdr"))
      return zsprBwaheaderIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("orderno"))
      return orderno;
    else if (fieldName.equalsIgnoreCase("isasset"))
      return isasset;
    else if (fieldName.equalsIgnoreCase("sumfrombeginning"))
      return sumfrombeginning;
    else if (fieldName.equalsIgnoreCase("allwowonlypositive"))
      return allwowonlypositive;
    else if (fieldName.equalsIgnoreCase("allwowonlynegative"))
      return allwowonlynegative;
    else if (fieldName.equalsIgnoreCase("dontprintdetails"))
      return dontprintdetails;
    else if (fieldName.equalsIgnoreCase("issuminfooter"))
      return issuminfooter;
    else if (fieldName.equalsIgnoreCase("isparent"))
      return isparent;
    else if (fieldName.equalsIgnoreCase("parentpref"))
      return parentpref;
    else if (fieldName.equalsIgnoreCase("parentprefr"))
      return parentprefr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
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
  public static ReportStructure4B9AA850B2334D80959C56152C32E25EData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zsprBwaheaderId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zsprBwaheaderId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ReportStructure4B9AA850B2334D80959C56152C32E25EData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zsprBwaheaderId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspr_bwaprefs.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspr_bwaprefs.CreatedBy) as CreatedByR, " +
      "        to_char(zspr_bwaprefs.Updated, ?) as updated, " +
      "        to_char(zspr_bwaprefs.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspr_bwaprefs.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspr_bwaprefs.UpdatedBy) as UpdatedByR," +
      "        zspr_bwaprefs.AD_Client_ID, " +
      "(CASE WHEN zspr_bwaprefs.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "zspr_bwaprefs.Zspr_Bwaprefs_ID, " +
      "zspr_bwaprefs.AD_Org_ID, " +
      "(CASE WHEN zspr_bwaprefs.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zspr_bwaprefs.Zspr_Bwaheader_ID, " +
      "(CASE WHEN zspr_bwaprefs.Zspr_Bwaheader_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS Zspr_Bwaheader_IDR, " +
      "zspr_bwaprefs.Name, " +
      "zspr_bwaprefs.Orderno, " +
      "COALESCE(zspr_bwaprefs.Isasset, 'N') AS Isasset, " +
      "COALESCE(zspr_bwaprefs.Sumfrombeginning, 'N') AS Sumfrombeginning, " +
      "COALESCE(zspr_bwaprefs.Allwowonlypositive, 'N') AS Allwowonlypositive, " +
      "COALESCE(zspr_bwaprefs.Allwowonlynegative, 'N') AS Allwowonlynegative, " +
      "COALESCE(zspr_bwaprefs.Dontprintdetails, 'N') AS Dontprintdetails, " +
      "COALESCE(zspr_bwaprefs.Issuminfooter, 'N') AS Issuminfooter, " +
      "COALESCE(zspr_bwaprefs.Isparent, 'N') AS Isparent, " +
      "zspr_bwaprefs.Parentpref, " +
      "(CASE WHEN zspr_bwaprefs.Parentpref IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS ParentprefR, " +
      "COALESCE(zspr_bwaprefs.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM zspr_bwaprefs left join (select AD_Client_ID, Name from AD_Client) table1 on (zspr_bwaprefs.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (zspr_bwaprefs.AD_Org_ID = table2.AD_Org_ID) left join (select Zspr_Bwaheader_ID, Name from Zspr_Bwaheader) table3 on (zspr_bwaprefs.Zspr_Bwaheader_ID = table3.Zspr_Bwaheader_ID) left join (select Zspr_Bwaprefs_ID, Name from zspr_bwaprefs) table4 on (zspr_bwaprefs.Parentpref =  table4.Zspr_Bwaprefs_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zsprBwaheaderId==null || zsprBwaheaderId.equals(""))?"":"  AND zspr_bwaprefs.Zspr_Bwaheader_ID = ?  ");
    strSql = strSql + 
      "        AND zspr_bwaprefs.Zspr_Bwaprefs_ID = ? " +
      "        AND zspr_bwaprefs.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zspr_bwaprefs.AD_Org_ID IN (";
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
      if (zsprBwaheaderId != null && !(zsprBwaheaderId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);
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
        ReportStructure4B9AA850B2334D80959C56152C32E25EData objectReportStructure4B9AA850B2334D80959C56152C32E25EData = new ReportStructure4B9AA850B2334D80959C56152C32E25EData();
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.created = UtilSql.getValue(result, "created");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.updated = UtilSql.getValue(result, "updated");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.updatedby = UtilSql.getValue(result, "updatedby");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.zsprBwaprefsId = UtilSql.getValue(result, "zspr_bwaprefs_id");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.zsprBwaheaderId = UtilSql.getValue(result, "zspr_bwaheader_id");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.zsprBwaheaderIdr = UtilSql.getValue(result, "zspr_bwaheader_idr");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.name = UtilSql.getValue(result, "name");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.orderno = UtilSql.getValue(result, "orderno");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.isasset = UtilSql.getValue(result, "isasset");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.sumfrombeginning = UtilSql.getValue(result, "sumfrombeginning");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.allwowonlypositive = UtilSql.getValue(result, "allwowonlypositive");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.allwowonlynegative = UtilSql.getValue(result, "allwowonlynegative");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.dontprintdetails = UtilSql.getValue(result, "dontprintdetails");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.issuminfooter = UtilSql.getValue(result, "issuminfooter");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.isparent = UtilSql.getValue(result, "isparent");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.parentpref = UtilSql.getValue(result, "parentpref");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.parentprefr = UtilSql.getValue(result, "parentprefr");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.isactive = UtilSql.getValue(result, "isactive");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.language = UtilSql.getValue(result, "language");
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.adUserClient = "";
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.adOrgClient = "";
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.createdby = "";
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.trBgcolor = "";
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.totalCount = "";
        objectReportStructure4B9AA850B2334D80959C56152C32E25EData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportStructure4B9AA850B2334D80959C56152C32E25EData);
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
    ReportStructure4B9AA850B2334D80959C56152C32E25EData objectReportStructure4B9AA850B2334D80959C56152C32E25EData[] = new ReportStructure4B9AA850B2334D80959C56152C32E25EData[vector.size()];
    vector.copyInto(objectReportStructure4B9AA850B2334D80959C56152C32E25EData);
    return(objectReportStructure4B9AA850B2334D80959C56152C32E25EData);
  }

/**
Create a registry
 */
  public static ReportStructure4B9AA850B2334D80959C56152C32E25EData[] set(String zsprBwaheaderId, String issuminfooter, String dontprintdetails, String sumfrombeginning, String createdby, String createdbyr, String orderno, String isparent, String allwowonlypositive, String zsprBwaprefsId, String isasset, String allwowonlynegative, String name, String parentpref, String adClientId, String zsprBwaheaderIdr, String updatedby, String updatedbyr, String isactive, String adOrgId)    throws ServletException {
    ReportStructure4B9AA850B2334D80959C56152C32E25EData objectReportStructure4B9AA850B2334D80959C56152C32E25EData[] = new ReportStructure4B9AA850B2334D80959C56152C32E25EData[1];
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0] = new ReportStructure4B9AA850B2334D80959C56152C32E25EData();
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].created = "";
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].createdbyr = createdbyr;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].updated = "";
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].updatedTimeStamp = "";
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].updatedby = updatedby;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].updatedbyr = updatedbyr;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].adClientId = adClientId;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].adClientIdr = "";
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].zsprBwaprefsId = zsprBwaprefsId;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].adOrgId = adOrgId;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].adOrgIdr = "";
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].zsprBwaheaderId = zsprBwaheaderId;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].zsprBwaheaderIdr = zsprBwaheaderIdr;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].name = name;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].orderno = orderno;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].isasset = isasset;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].sumfrombeginning = sumfrombeginning;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].allwowonlypositive = allwowonlypositive;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].allwowonlynegative = allwowonlynegative;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].dontprintdetails = dontprintdetails;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].issuminfooter = issuminfooter;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].isparent = isparent;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].parentpref = parentpref;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].parentprefr = "";
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].isactive = isactive;
    objectReportStructure4B9AA850B2334D80959C56152C32E25EData[0].language = "";
    return objectReportStructure4B9AA850B2334D80959C56152C32E25EData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2A4340D638AA4565B316C624809B9EC0_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef4B61594118DA437491F87B3F9385C069_1(ConnectionProvider connectionProvider, String Zspr_Bwaheader_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Zspr_Bwaheader_ID FROM Zspr_Bwaheader table1 WHERE table1.isActive='Y' AND table1.Zspr_Bwaheader_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Zspr_Bwaheader_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zspr_bwaheader_id");
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
  public static String selectDef7343457F219649ED9DEE3FE9A9573ECE_2(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zspr_bwaprefs.Zspr_Bwaheader_ID AS NAME" +
      "        FROM zspr_bwaprefs" +
      "        WHERE zspr_bwaprefs.Zspr_Bwaprefs_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String zsprBwaheaderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zspr_bwaheader left join (select Zspr_Bwaheader_ID, Name from Zspr_Bwaheader) table1 on (zspr_bwaheader.Zspr_Bwaheader_ID = table1.Zspr_Bwaheader_ID) WHERE zspr_bwaheader.Zspr_Bwaheader_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zsprBwaheaderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zspr_bwaheader left join (select Zspr_Bwaheader_ID, Name from Zspr_Bwaheader) table1 on (zspr_bwaheader.Zspr_Bwaheader_ID = table1.Zspr_Bwaheader_ID) WHERE zspr_bwaheader.Zspr_Bwaheader_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);

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
      "        UPDATE zspr_bwaprefs" +
      "        SET AD_Client_ID = (?) , Zspr_Bwaprefs_ID = (?) , AD_Org_ID = (?) , Zspr_Bwaheader_ID = (?) , Name = (?) , Orderno = TO_NUMBER(?) , Isasset = (?) , Sumfrombeginning = (?) , Allwowonlypositive = (?) , Allwowonlynegative = (?) , Dontprintdetails = (?) , Issuminfooter = (?) , Isparent = (?) , Parentpref = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE zspr_bwaprefs.Zspr_Bwaprefs_ID = ? " +
      "                 AND zspr_bwaprefs.Zspr_Bwaheader_ID = ? " +
      "        AND zspr_bwaprefs.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspr_bwaprefs.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isasset);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sumfrombeginning);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allwowonlypositive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allwowonlynegative);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dontprintdetails);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issuminfooter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isparent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentpref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);
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
      "        INSERT INTO zspr_bwaprefs " +
      "        (AD_Client_ID, Zspr_Bwaprefs_ID, AD_Org_ID, Zspr_Bwaheader_ID, Name, Orderno, Isasset, Sumfrombeginning, Allwowonlypositive, Allwowonlynegative, Dontprintdetails, Issuminfooter, Isparent, Parentpref, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isasset);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sumfrombeginning);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allwowonlypositive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allwowonlynegative);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dontprintdetails);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issuminfooter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isparent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentpref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zsprBwaheaderId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspr_bwaprefs" +
      "        WHERE zspr_bwaprefs.Zspr_Bwaprefs_ID = ? " +
      "                 AND zspr_bwaprefs.Zspr_Bwaheader_ID = ? " +
      "        AND zspr_bwaprefs.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspr_bwaprefs.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zsprBwaheaderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspr_bwaprefs" +
      "        WHERE zspr_bwaprefs.Zspr_Bwaprefs_ID = ? " +
      "                 AND zspr_bwaprefs.Zspr_Bwaheader_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);

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
      "          FROM zspr_bwaprefs" +
      "         WHERE zspr_bwaprefs.Zspr_Bwaprefs_ID = ? ";

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
      "          FROM zspr_bwaprefs" +
      "         WHERE zspr_bwaprefs.Zspr_Bwaprefs_ID = ? ";

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
