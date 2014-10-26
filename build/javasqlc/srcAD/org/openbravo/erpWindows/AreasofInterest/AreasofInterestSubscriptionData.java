//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.AreasofInterest;

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
class AreasofInterestSubscriptionData implements FieldProvider {
static Logger log4j = Logger.getLogger(AreasofInterestSubscriptionData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String rInterestareaId;
  public String rInterestareaIdr;
  public String adUserId;
  public String adUserIdr;
  public String isactive;
  public String subscribedate;
  public String optoutdate;
  public String rContactinterestId;
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
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("r_interestarea_id") || fieldName.equals("rInterestareaId"))
      return rInterestareaId;
    else if (fieldName.equalsIgnoreCase("r_interestarea_idr") || fieldName.equals("rInterestareaIdr"))
      return rInterestareaIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("subscribedate"))
      return subscribedate;
    else if (fieldName.equalsIgnoreCase("optoutdate"))
      return optoutdate;
    else if (fieldName.equalsIgnoreCase("r_contactinterest_id") || fieldName.equals("rContactinterestId"))
      return rContactinterestId;
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
  public static AreasofInterestSubscriptionData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String R_InterestArea_ID, String rInterestareaId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, R_InterestArea_ID, rInterestareaId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static AreasofInterestSubscriptionData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String R_InterestArea_ID, String rInterestareaId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(R_ContactInterest.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = R_ContactInterest.CreatedBy) as CreatedByR, " +
      "        to_char(R_ContactInterest.Updated, ?) as updated, " +
      "        to_char(R_ContactInterest.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        R_ContactInterest.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = R_ContactInterest.UpdatedBy) as UpdatedByR," +
      "        R_ContactInterest.AD_Client_ID, " +
      "(CASE WHEN R_ContactInterest.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "R_ContactInterest.AD_Org_ID, " +
      "(CASE WHEN R_ContactInterest.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "R_ContactInterest.R_InterestArea_ID, " +
      "(CASE WHEN R_ContactInterest.R_InterestArea_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS R_InterestArea_IDR, " +
      "R_ContactInterest.AD_User_ID, " +
      "(CASE WHEN R_ContactInterest.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "COALESCE(R_ContactInterest.IsActive, 'N') AS IsActive, " +
      "R_ContactInterest.SubscribeDate, " +
      "R_ContactInterest.OptOutDate, " +
      "R_ContactInterest.R_ContactInterest_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM R_ContactInterest left join (select AD_Client_ID, Name from AD_Client) table1 on (R_ContactInterest.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (R_ContactInterest.AD_Org_ID = table2.AD_Org_ID) left join (select R_InterestArea_ID, Name from R_InterestArea) table3 on (R_ContactInterest.R_InterestArea_ID = table3.R_InterestArea_ID) left join (select AD_User_ID, Name from AD_User) table4 on (R_ContactInterest.AD_User_ID = table4.AD_User_ID)" +
      "        WHERE 2=2 " +
      " AND R_ContactInterest.R_InterestArea_ID = ?" +
      "        AND 1=1 ";
    strSql = strSql + ((rInterestareaId==null || rInterestareaId.equals(""))?"":"  AND R_ContactInterest.R_InterestArea_ID = ?  ");
    strSql = strSql + 
      "        AND R_ContactInterest.R_ContactInterest_ID = ? " +
      "        AND R_ContactInterest.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND R_ContactInterest.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, R_InterestArea_ID);
      if (rInterestareaId != null && !(rInterestareaId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, rInterestareaId);
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
        AreasofInterestSubscriptionData objectAreasofInterestSubscriptionData = new AreasofInterestSubscriptionData();
        objectAreasofInterestSubscriptionData.created = UtilSql.getValue(result, "created");
        objectAreasofInterestSubscriptionData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectAreasofInterestSubscriptionData.updated = UtilSql.getValue(result, "updated");
        objectAreasofInterestSubscriptionData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectAreasofInterestSubscriptionData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAreasofInterestSubscriptionData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectAreasofInterestSubscriptionData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAreasofInterestSubscriptionData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectAreasofInterestSubscriptionData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAreasofInterestSubscriptionData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectAreasofInterestSubscriptionData.rInterestareaId = UtilSql.getValue(result, "r_interestarea_id");
        objectAreasofInterestSubscriptionData.rInterestareaIdr = UtilSql.getValue(result, "r_interestarea_idr");
        objectAreasofInterestSubscriptionData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectAreasofInterestSubscriptionData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectAreasofInterestSubscriptionData.isactive = UtilSql.getValue(result, "isactive");
        objectAreasofInterestSubscriptionData.subscribedate = UtilSql.getDateValue(result, "subscribedate", "dd-MM-yyyy");
        objectAreasofInterestSubscriptionData.optoutdate = UtilSql.getDateValue(result, "optoutdate", "dd-MM-yyyy");
        objectAreasofInterestSubscriptionData.rContactinterestId = UtilSql.getValue(result, "r_contactinterest_id");
        objectAreasofInterestSubscriptionData.language = UtilSql.getValue(result, "language");
        objectAreasofInterestSubscriptionData.adUserClient = "";
        objectAreasofInterestSubscriptionData.adOrgClient = "";
        objectAreasofInterestSubscriptionData.createdby = "";
        objectAreasofInterestSubscriptionData.trBgcolor = "";
        objectAreasofInterestSubscriptionData.totalCount = "";
        objectAreasofInterestSubscriptionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAreasofInterestSubscriptionData);
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
    AreasofInterestSubscriptionData objectAreasofInterestSubscriptionData[] = new AreasofInterestSubscriptionData[vector.size()];
    vector.copyInto(objectAreasofInterestSubscriptionData);
    return(objectAreasofInterestSubscriptionData);
  }

/**
Create a registry
 */
  public static AreasofInterestSubscriptionData[] set(String rInterestareaId, String subscribedate, String optoutdate, String isactive, String rContactinterestId, String createdby, String createdbyr, String adOrgId, String updatedby, String updatedbyr, String adClientId, String adUserId)    throws ServletException {
    AreasofInterestSubscriptionData objectAreasofInterestSubscriptionData[] = new AreasofInterestSubscriptionData[1];
    objectAreasofInterestSubscriptionData[0] = new AreasofInterestSubscriptionData();
    objectAreasofInterestSubscriptionData[0].created = "";
    objectAreasofInterestSubscriptionData[0].createdbyr = createdbyr;
    objectAreasofInterestSubscriptionData[0].updated = "";
    objectAreasofInterestSubscriptionData[0].updatedTimeStamp = "";
    objectAreasofInterestSubscriptionData[0].updatedby = updatedby;
    objectAreasofInterestSubscriptionData[0].updatedbyr = updatedbyr;
    objectAreasofInterestSubscriptionData[0].adClientId = adClientId;
    objectAreasofInterestSubscriptionData[0].adClientIdr = "";
    objectAreasofInterestSubscriptionData[0].adOrgId = adOrgId;
    objectAreasofInterestSubscriptionData[0].adOrgIdr = "";
    objectAreasofInterestSubscriptionData[0].rInterestareaId = rInterestareaId;
    objectAreasofInterestSubscriptionData[0].rInterestareaIdr = "";
    objectAreasofInterestSubscriptionData[0].adUserId = adUserId;
    objectAreasofInterestSubscriptionData[0].adUserIdr = "";
    objectAreasofInterestSubscriptionData[0].isactive = isactive;
    objectAreasofInterestSubscriptionData[0].subscribedate = subscribedate;
    objectAreasofInterestSubscriptionData[0].optoutdate = optoutdate;
    objectAreasofInterestSubscriptionData[0].rContactinterestId = rContactinterestId;
    objectAreasofInterestSubscriptionData[0].language = "";
    return objectAreasofInterestSubscriptionData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef7762_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef7763_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT R_ContactInterest.R_InterestArea_ID AS NAME" +
      "        FROM R_ContactInterest" +
      "        WHERE R_ContactInterest.R_ContactInterest_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String rInterestareaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM R_InterestArea left join (select R_InterestArea_ID, Name from R_InterestArea) table1 on (R_InterestArea.R_InterestArea_ID = table1.R_InterestArea_ID) WHERE R_InterestArea.R_InterestArea_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rInterestareaId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String rInterestareaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM R_InterestArea left join (select R_InterestArea_ID, Name from R_InterestArea) table1 on (R_InterestArea.R_InterestArea_ID = table1.R_InterestArea_ID) WHERE R_InterestArea.R_InterestArea_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rInterestareaId);

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
      "        UPDATE R_ContactInterest" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , R_InterestArea_ID = (?) , AD_User_ID = (?) , IsActive = (?) , SubscribeDate = TO_DATE(?) , OptOutDate = TO_DATE(?) , R_ContactInterest_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE R_ContactInterest.R_ContactInterest_ID = ? " +
      "                 AND R_ContactInterest.R_InterestArea_ID = ? " +
      "        AND R_ContactInterest.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND R_ContactInterest.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rInterestareaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subscribedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, optoutdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rContactinterestId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rContactinterestId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rInterestareaId);
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
      "        INSERT INTO R_ContactInterest " +
      "        (AD_Client_ID, AD_Org_ID, R_InterestArea_ID, AD_User_ID, IsActive, SubscribeDate, OptOutDate, R_ContactInterest_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rInterestareaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subscribedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, optoutdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rContactinterestId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String rInterestareaId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM R_ContactInterest" +
      "        WHERE R_ContactInterest.R_ContactInterest_ID = ? " +
      "                 AND R_ContactInterest.R_InterestArea_ID = ? " +
      "        AND R_ContactInterest.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND R_ContactInterest.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rInterestareaId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String rInterestareaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM R_ContactInterest" +
      "        WHERE R_ContactInterest.R_ContactInterest_ID = ? " +
      "                 AND R_ContactInterest.R_InterestArea_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rInterestareaId);

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
      "          FROM R_ContactInterest" +
      "         WHERE R_ContactInterest.R_ContactInterest_ID = ? ";

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
      "          FROM R_ContactInterest" +
      "         WHERE R_ContactInterest.R_ContactInterest_ID = ? ";

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
