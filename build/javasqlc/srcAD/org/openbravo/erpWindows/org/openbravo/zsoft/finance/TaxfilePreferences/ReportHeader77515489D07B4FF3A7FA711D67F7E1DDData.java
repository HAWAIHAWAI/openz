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
class ReportHeader77515489D07B4FF3A7FA711D67F7E1DDData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String zsprBwaheaderId;
  public String adOrgId;
  public String adOrgIdr;
  public String name;
  public String headertext;
  public String subheadertext;
  public String footertext;
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
    else if (fieldName.equalsIgnoreCase("zspr_bwaheader_id") || fieldName.equals("zsprBwaheaderId"))
      return zsprBwaheaderId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("headertext"))
      return headertext;
    else if (fieldName.equalsIgnoreCase("subheadertext"))
      return subheadertext;
    else if (fieldName.equalsIgnoreCase("footertext"))
      return footertext;
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
  public static ReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspr_bwaheader.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspr_bwaheader.CreatedBy) as CreatedByR, " +
      "        to_char(zspr_bwaheader.Updated, ?) as updated, " +
      "        to_char(zspr_bwaheader.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspr_bwaheader.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspr_bwaheader.UpdatedBy) as UpdatedByR," +
      "        zspr_bwaheader.AD_Client_ID, " +
      "(CASE WHEN zspr_bwaheader.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "zspr_bwaheader.Zspr_Bwaheader_ID, " +
      "zspr_bwaheader.AD_Org_ID, " +
      "(CASE WHEN zspr_bwaheader.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zspr_bwaheader.Name, " +
      "zspr_bwaheader.Headertext, " +
      "zspr_bwaheader.Subheadertext, " +
      "zspr_bwaheader.Footertext, " +
      "COALESCE(zspr_bwaheader.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM zspr_bwaheader left join (select AD_Client_ID, Name from AD_Client) table1 on (zspr_bwaheader.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (zspr_bwaheader.AD_Org_ID = table2.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND zspr_bwaheader.Zspr_Bwaheader_ID = ? " +
      "        AND zspr_bwaheader.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zspr_bwaheader.AD_Org_ID IN (";
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
        ReportHeader77515489D07B4FF3A7FA711D67F7E1DDData objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData = new ReportHeader77515489D07B4FF3A7FA711D67F7E1DDData();
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.created = UtilSql.getValue(result, "created");
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.updated = UtilSql.getValue(result, "updated");
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.updatedby = UtilSql.getValue(result, "updatedby");
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.zsprBwaheaderId = UtilSql.getValue(result, "zspr_bwaheader_id");
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.name = UtilSql.getValue(result, "name");
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.headertext = UtilSql.getValue(result, "headertext");
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.subheadertext = UtilSql.getValue(result, "subheadertext");
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.footertext = UtilSql.getValue(result, "footertext");
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.isactive = UtilSql.getValue(result, "isactive");
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.language = UtilSql.getValue(result, "language");
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.adUserClient = "";
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.adOrgClient = "";
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.createdby = "";
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.trBgcolor = "";
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.totalCount = "";
        objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData);
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
    ReportHeader77515489D07B4FF3A7FA711D67F7E1DDData objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[] = new ReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[vector.size()];
    vector.copyInto(objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData);
    return(objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData);
  }

/**
Create a registry
 */
  public static ReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[] set(String isactive, String updatedby, String updatedbyr, String adClientId, String createdby, String createdbyr, String zsprBwaheaderId, String subheadertext, String name, String adOrgId, String footertext, String headertext)    throws ServletException {
    ReportHeader77515489D07B4FF3A7FA711D67F7E1DDData objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[] = new ReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[1];
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0] = new ReportHeader77515489D07B4FF3A7FA711D67F7E1DDData();
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0].created = "";
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0].createdbyr = createdbyr;
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0].updated = "";
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0].updatedTimeStamp = "";
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0].updatedby = updatedby;
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0].updatedbyr = updatedbyr;
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0].adClientId = adClientId;
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0].adClientIdr = "";
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0].zsprBwaheaderId = zsprBwaheaderId;
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0].adOrgId = adOrgId;
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0].adOrgIdr = "";
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0].name = name;
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0].headertext = headertext;
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0].subheadertext = subheadertext;
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0].footertext = footertext;
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0].isactive = isactive;
    objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[0].language = "";
    return objectReportHeader77515489D07B4FF3A7FA711D67F7E1DDData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefEF7FCEDAE8B84DE48529DD2D0985F085_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef8BAD56001EC94FE4A56793B61948C8F6_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE zspr_bwaheader" +
      "        SET AD_Client_ID = (?) , Zspr_Bwaheader_ID = (?) , AD_Org_ID = (?) , Name = (?) , Headertext = (?) , Subheadertext = (?) , Footertext = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE zspr_bwaheader.Zspr_Bwaheader_ID = ? " +
      "        AND zspr_bwaheader.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspr_bwaheader.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, headertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subheadertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
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
      "        INSERT INTO zspr_bwaheader " +
      "        (AD_Client_ID, Zspr_Bwaheader_ID, AD_Org_ID, Name, Headertext, Subheadertext, Footertext, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, headertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subheadertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footertext);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspr_bwaheader" +
      "        WHERE zspr_bwaheader.Zspr_Bwaheader_ID = ? " +
      "        AND zspr_bwaheader.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspr_bwaheader.AD_Org_ID IN (";
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
      "        DELETE FROM zspr_bwaheader" +
      "        WHERE zspr_bwaheader.Zspr_Bwaheader_ID = ? ";

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
      "          FROM zspr_bwaheader" +
      "         WHERE zspr_bwaheader.Zspr_Bwaheader_ID = ? ";

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
      "          FROM zspr_bwaheader" +
      "         WHERE zspr_bwaheader.Zspr_Bwaheader_ID = ? ";

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
