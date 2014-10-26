//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.CommissionPayment;

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
class AmountsData implements FieldProvider {
static Logger log4j = Logger.getLogger(AmountsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cCommissionamtId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cCommissionrunId;
  public String cCommissionrunIdr;
  public String cCommissionlineId;
  public String cCommissionlineIdr;
  public String isactive;
  public String convertedamt;
  public String actualqty;
  public String commissionamt;
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
    else if (fieldName.equalsIgnoreCase("c_commissionamt_id") || fieldName.equals("cCommissionamtId"))
      return cCommissionamtId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_commissionrun_id") || fieldName.equals("cCommissionrunId"))
      return cCommissionrunId;
    else if (fieldName.equalsIgnoreCase("c_commissionrun_idr") || fieldName.equals("cCommissionrunIdr"))
      return cCommissionrunIdr;
    else if (fieldName.equalsIgnoreCase("c_commissionline_id") || fieldName.equals("cCommissionlineId"))
      return cCommissionlineId;
    else if (fieldName.equalsIgnoreCase("c_commissionline_idr") || fieldName.equals("cCommissionlineIdr"))
      return cCommissionlineIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("convertedamt"))
      return convertedamt;
    else if (fieldName.equalsIgnoreCase("actualqty"))
      return actualqty;
    else if (fieldName.equalsIgnoreCase("commissionamt"))
      return commissionamt;
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
  public static AmountsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cCommissionrunId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cCommissionrunId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static AmountsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cCommissionrunId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_CommissionAmt.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_CommissionAmt.CreatedBy) as CreatedByR, " +
      "        to_char(C_CommissionAmt.Updated, ?) as updated, " +
      "        to_char(C_CommissionAmt.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_CommissionAmt.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_CommissionAmt.UpdatedBy) as UpdatedByR," +
      "        C_CommissionAmt.C_CommissionAmt_ID, " +
      "C_CommissionAmt.AD_Client_ID, " +
      "(CASE WHEN C_CommissionAmt.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_CommissionAmt.AD_Org_ID, " +
      "(CASE WHEN C_CommissionAmt.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_CommissionAmt.C_CommissionRun_ID, " +
      "(CASE WHEN C_CommissionAmt.C_CommissionRun_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'') ) END) AS C_CommissionRun_IDR, " +
      "C_CommissionAmt.C_CommissionLine_ID, " +
      "(CASE WHEN C_CommissionAmt.C_CommissionLine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Line), ''))),'') ) END) AS C_CommissionLine_IDR, " +
      "COALESCE(C_CommissionAmt.IsActive, 'N') AS IsActive, " +
      "C_CommissionAmt.ConvertedAmt, " +
      "C_CommissionAmt.ActualQty, " +
      "C_CommissionAmt.CommissionAmt, " +
      "        ? AS LANGUAGE " +
      "        FROM C_CommissionAmt left join (select AD_Client_ID, Name from AD_Client) table1 on (C_CommissionAmt.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_CommissionAmt.AD_Org_ID = table2.AD_Org_ID) left join (select C_CommissionRun_ID, DocumentNo from C_CommissionRun) table3 on (C_CommissionAmt.C_CommissionRun_ID = table3.C_CommissionRun_ID) left join (select C_CommissionLine_ID, C_Commission_ID, Line from C_CommissionLine) table4 on (C_CommissionAmt.C_CommissionLine_ID = table4.C_CommissionLine_ID) left join (select C_Commission_ID, Name from C_Commission) table5 on (table4.C_Commission_ID = table5.C_Commission_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cCommissionrunId==null || cCommissionrunId.equals(""))?"":"  AND C_CommissionAmt.C_CommissionRun_ID = ?  ");
    strSql = strSql + 
      "        AND C_CommissionAmt.C_CommissionAmt_ID = ? " +
      "        AND C_CommissionAmt.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_CommissionAmt.AD_Org_ID IN (";
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
      if (cCommissionrunId != null && !(cCommissionrunId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionrunId);
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
        AmountsData objectAmountsData = new AmountsData();
        objectAmountsData.created = UtilSql.getValue(result, "created");
        objectAmountsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectAmountsData.updated = UtilSql.getValue(result, "updated");
        objectAmountsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectAmountsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAmountsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectAmountsData.cCommissionamtId = UtilSql.getValue(result, "c_commissionamt_id");
        objectAmountsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAmountsData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectAmountsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAmountsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectAmountsData.cCommissionrunId = UtilSql.getValue(result, "c_commissionrun_id");
        objectAmountsData.cCommissionrunIdr = UtilSql.getValue(result, "c_commissionrun_idr");
        objectAmountsData.cCommissionlineId = UtilSql.getValue(result, "c_commissionline_id");
        objectAmountsData.cCommissionlineIdr = UtilSql.getValue(result, "c_commissionline_idr");
        objectAmountsData.isactive = UtilSql.getValue(result, "isactive");
        objectAmountsData.convertedamt = UtilSql.getValue(result, "convertedamt");
        objectAmountsData.actualqty = UtilSql.getValue(result, "actualqty");
        objectAmountsData.commissionamt = UtilSql.getValue(result, "commissionamt");
        objectAmountsData.language = UtilSql.getValue(result, "language");
        objectAmountsData.adUserClient = "";
        objectAmountsData.adOrgClient = "";
        objectAmountsData.createdby = "";
        objectAmountsData.trBgcolor = "";
        objectAmountsData.totalCount = "";
        objectAmountsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAmountsData);
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
    AmountsData objectAmountsData[] = new AmountsData[vector.size()];
    vector.copyInto(objectAmountsData);
    return(objectAmountsData);
  }

/**
Create a registry
 */
  public static AmountsData[] set(String cCommissionrunId, String convertedamt, String updatedby, String updatedbyr, String adClientId, String actualqty, String cCommissionamtId, String commissionamt, String isactive, String createdby, String createdbyr, String cCommissionlineId, String adOrgId)    throws ServletException {
    AmountsData objectAmountsData[] = new AmountsData[1];
    objectAmountsData[0] = new AmountsData();
    objectAmountsData[0].created = "";
    objectAmountsData[0].createdbyr = createdbyr;
    objectAmountsData[0].updated = "";
    objectAmountsData[0].updatedTimeStamp = "";
    objectAmountsData[0].updatedby = updatedby;
    objectAmountsData[0].updatedbyr = updatedbyr;
    objectAmountsData[0].cCommissionamtId = cCommissionamtId;
    objectAmountsData[0].adClientId = adClientId;
    objectAmountsData[0].adClientIdr = "";
    objectAmountsData[0].adOrgId = adOrgId;
    objectAmountsData[0].adOrgIdr = "";
    objectAmountsData[0].cCommissionrunId = cCommissionrunId;
    objectAmountsData[0].cCommissionrunIdr = "";
    objectAmountsData[0].cCommissionlineId = cCommissionlineId;
    objectAmountsData[0].cCommissionlineIdr = "";
    objectAmountsData[0].isactive = isactive;
    objectAmountsData[0].convertedamt = convertedamt;
    objectAmountsData[0].actualqty = actualqty;
    objectAmountsData[0].commissionamt = commissionamt;
    objectAmountsData[0].language = "";
    return objectAmountsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef5691_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef5689_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
      "        SELECT C_CommissionAmt.C_CommissionRun_ID AS NAME" +
      "        FROM C_CommissionAmt" +
      "        WHERE C_CommissionAmt.C_CommissionAmt_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cCommissionrunId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), ''))) AS NAME FROM C_CommissionRun left join (select C_CommissionRun_ID, DocumentNo from C_CommissionRun) table1 on (C_CommissionRun.C_CommissionRun_ID = table1.C_CommissionRun_ID) WHERE C_CommissionRun.C_CommissionRun_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionrunId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cCommissionrunId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), ''))) AS NAME FROM C_CommissionRun left join (select C_CommissionRun_ID, DocumentNo from C_CommissionRun) table1 on (C_CommissionRun.C_CommissionRun_ID = table1.C_CommissionRun_ID) WHERE C_CommissionRun.C_CommissionRun_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionrunId);

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
      "        UPDATE C_CommissionAmt" +
      "        SET C_CommissionAmt_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_CommissionRun_ID = (?) , C_CommissionLine_ID = (?) , IsActive = (?) , ConvertedAmt = TO_NUMBER(?) , ActualQty = TO_NUMBER(?) , CommissionAmt = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE C_CommissionAmt.C_CommissionAmt_ID = ? " +
      "                 AND C_CommissionAmt.C_CommissionRun_ID = ? " +
      "        AND C_CommissionAmt.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_CommissionAmt.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionamtId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionrunId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, convertedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, commissionamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionamtId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionrunId);
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
      "        INSERT INTO C_CommissionAmt " +
      "        (C_CommissionAmt_ID, AD_Client_ID, AD_Org_ID, C_CommissionRun_ID, C_CommissionLine_ID, IsActive, ConvertedAmt, ActualQty, CommissionAmt, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionamtId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionrunId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, convertedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, commissionamt);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cCommissionrunId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_CommissionAmt" +
      "        WHERE C_CommissionAmt.C_CommissionAmt_ID = ? " +
      "                 AND C_CommissionAmt.C_CommissionRun_ID = ? " +
      "        AND C_CommissionAmt.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_CommissionAmt.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionrunId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cCommissionrunId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_CommissionAmt" +
      "        WHERE C_CommissionAmt.C_CommissionAmt_ID = ? " +
      "                 AND C_CommissionAmt.C_CommissionRun_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionrunId);

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
      "          FROM C_CommissionAmt" +
      "         WHERE C_CommissionAmt.C_CommissionAmt_ID = ? ";

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
      "          FROM C_CommissionAmt" +
      "         WHERE C_CommissionAmt.C_CommissionAmt_ID = ? ";

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
