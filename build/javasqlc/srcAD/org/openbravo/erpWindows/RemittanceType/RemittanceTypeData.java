//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.RemittanceType;

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
class RemittanceTypeData implements FieldProvider {
static Logger log4j = Logger.getLogger(RemittanceTypeData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cRemittanceTypeId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String name;
  public String consolidate;
  public String paymentruleconsolidated;
  public String paymentruleconsolidatedr;
  public String statusTo;
  public String statusTor;
  public String statusReturned;
  public String statusReturnedr;
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
    else if (fieldName.equalsIgnoreCase("c_remittance_type_id") || fieldName.equals("cRemittanceTypeId"))
      return cRemittanceTypeId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("consolidate"))
      return consolidate;
    else if (fieldName.equalsIgnoreCase("paymentruleconsolidated"))
      return paymentruleconsolidated;
    else if (fieldName.equalsIgnoreCase("paymentruleconsolidatedr"))
      return paymentruleconsolidatedr;
    else if (fieldName.equalsIgnoreCase("status_to") || fieldName.equals("statusTo"))
      return statusTo;
    else if (fieldName.equalsIgnoreCase("status_tor") || fieldName.equals("statusTor"))
      return statusTor;
    else if (fieldName.equalsIgnoreCase("status_returned") || fieldName.equals("statusReturned"))
      return statusReturned;
    else if (fieldName.equalsIgnoreCase("status_returnedr") || fieldName.equals("statusReturnedr"))
      return statusReturnedr;
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
  public static RemittanceTypeData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static RemittanceTypeData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Remittance_Type.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Remittance_Type.CreatedBy) as CreatedByR, " +
      "        to_char(C_Remittance_Type.Updated, ?) as updated, " +
      "        to_char(C_Remittance_Type.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Remittance_Type.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Remittance_Type.UpdatedBy) as UpdatedByR," +
      "        C_Remittance_Type.C_Remittance_Type_ID, " +
      "C_Remittance_Type.AD_Client_ID, " +
      "(CASE WHEN C_Remittance_Type.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_Remittance_Type.AD_Org_ID, " +
      "(CASE WHEN C_Remittance_Type.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(C_Remittance_Type.IsActive, 'N') AS IsActive, " +
      "C_Remittance_Type.Name, " +
      "COALESCE(C_Remittance_Type.Consolidate, 'N') AS Consolidate, " +
      "C_Remittance_Type.Paymentruleconsolidated, " +
      "(CASE WHEN C_Remittance_Type.Paymentruleconsolidated IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS PaymentruleconsolidatedR, " +
      "C_Remittance_Type.Status_To, " +
      "(CASE WHEN C_Remittance_Type.Status_To IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS Status_ToR, " +
      "C_Remittance_Type.Status_Returned, " +
      "(CASE WHEN C_Remittance_Type.Status_Returned IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS Status_ReturnedR, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Remittance_Type left join (select AD_Client_ID, Name from AD_Client) table1 on (C_Remittance_Type.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_Remittance_Type.AD_Org_ID = table2.AD_Org_ID) left join ad_ref_list_v list1 on (C_Remittance_Type.Paymentruleconsolidated = list1.value and list1.ad_reference_id = '195' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (C_Remittance_Type.Status_To = list2.value and list2.ad_reference_id = '800070' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (C_Remittance_Type.Status_Returned = list3.value and list3.ad_reference_id = '800070' and list3.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_Remittance_Type.C_Remittance_Type_ID = ? " +
      "        AND C_Remittance_Type.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Remittance_Type.AD_Org_ID IN (";
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
        RemittanceTypeData objectRemittanceTypeData = new RemittanceTypeData();
        objectRemittanceTypeData.created = UtilSql.getValue(result, "created");
        objectRemittanceTypeData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectRemittanceTypeData.updated = UtilSql.getValue(result, "updated");
        objectRemittanceTypeData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectRemittanceTypeData.updatedby = UtilSql.getValue(result, "updatedby");
        objectRemittanceTypeData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectRemittanceTypeData.cRemittanceTypeId = UtilSql.getValue(result, "c_remittance_type_id");
        objectRemittanceTypeData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectRemittanceTypeData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectRemittanceTypeData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectRemittanceTypeData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectRemittanceTypeData.isactive = UtilSql.getValue(result, "isactive");
        objectRemittanceTypeData.name = UtilSql.getValue(result, "name");
        objectRemittanceTypeData.consolidate = UtilSql.getValue(result, "consolidate");
        objectRemittanceTypeData.paymentruleconsolidated = UtilSql.getValue(result, "paymentruleconsolidated");
        objectRemittanceTypeData.paymentruleconsolidatedr = UtilSql.getValue(result, "paymentruleconsolidatedr");
        objectRemittanceTypeData.statusTo = UtilSql.getValue(result, "status_to");
        objectRemittanceTypeData.statusTor = UtilSql.getValue(result, "status_tor");
        objectRemittanceTypeData.statusReturned = UtilSql.getValue(result, "status_returned");
        objectRemittanceTypeData.statusReturnedr = UtilSql.getValue(result, "status_returnedr");
        objectRemittanceTypeData.language = UtilSql.getValue(result, "language");
        objectRemittanceTypeData.adUserClient = "";
        objectRemittanceTypeData.adOrgClient = "";
        objectRemittanceTypeData.createdby = "";
        objectRemittanceTypeData.trBgcolor = "";
        objectRemittanceTypeData.totalCount = "";
        objectRemittanceTypeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRemittanceTypeData);
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
    RemittanceTypeData objectRemittanceTypeData[] = new RemittanceTypeData[vector.size()];
    vector.copyInto(objectRemittanceTypeData);
    return(objectRemittanceTypeData);
  }

/**
Create a registry
 */
  public static RemittanceTypeData[] set(String isactive, String adOrgId, String paymentruleconsolidated, String createdby, String createdbyr, String statusReturned, String updatedby, String updatedbyr, String statusTo, String name, String consolidate, String cRemittanceTypeId, String adClientId)    throws ServletException {
    RemittanceTypeData objectRemittanceTypeData[] = new RemittanceTypeData[1];
    objectRemittanceTypeData[0] = new RemittanceTypeData();
    objectRemittanceTypeData[0].created = "";
    objectRemittanceTypeData[0].createdbyr = createdbyr;
    objectRemittanceTypeData[0].updated = "";
    objectRemittanceTypeData[0].updatedTimeStamp = "";
    objectRemittanceTypeData[0].updatedby = updatedby;
    objectRemittanceTypeData[0].updatedbyr = updatedbyr;
    objectRemittanceTypeData[0].cRemittanceTypeId = cRemittanceTypeId;
    objectRemittanceTypeData[0].adClientId = adClientId;
    objectRemittanceTypeData[0].adClientIdr = "";
    objectRemittanceTypeData[0].adOrgId = adOrgId;
    objectRemittanceTypeData[0].adOrgIdr = "";
    objectRemittanceTypeData[0].isactive = isactive;
    objectRemittanceTypeData[0].name = name;
    objectRemittanceTypeData[0].consolidate = consolidate;
    objectRemittanceTypeData[0].paymentruleconsolidated = paymentruleconsolidated;
    objectRemittanceTypeData[0].paymentruleconsolidatedr = "";
    objectRemittanceTypeData[0].statusTo = statusTo;
    objectRemittanceTypeData[0].statusTor = "";
    objectRemittanceTypeData[0].statusReturned = statusReturned;
    objectRemittanceTypeData[0].statusReturnedr = "";
    objectRemittanceTypeData[0].language = "";
    return objectRemittanceTypeData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef800824_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef800826_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_Remittance_Type" +
      "        SET C_Remittance_Type_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , IsActive = (?) , Name = (?) , Consolidate = (?) , Paymentruleconsolidated = (?) , Status_To = (?) , Status_Returned = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Remittance_Type.C_Remittance_Type_ID = ? " +
      "        AND C_Remittance_Type.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Remittance_Type.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRemittanceTypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, consolidate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentruleconsolidated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, statusTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, statusReturned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRemittanceTypeId);
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
      "        INSERT INTO C_Remittance_Type " +
      "        (C_Remittance_Type_ID, AD_Client_ID, AD_Org_ID, IsActive, Name, Consolidate, Paymentruleconsolidated, Status_To, Status_Returned, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRemittanceTypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, consolidate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentruleconsolidated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, statusTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, statusReturned);
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
      "        DELETE FROM C_Remittance_Type" +
      "        WHERE C_Remittance_Type.C_Remittance_Type_ID = ? " +
      "        AND C_Remittance_Type.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Remittance_Type.AD_Org_ID IN (";
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
      "        DELETE FROM C_Remittance_Type" +
      "        WHERE C_Remittance_Type.C_Remittance_Type_ID = ? ";

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
      "          FROM C_Remittance_Type" +
      "         WHERE C_Remittance_Type.C_Remittance_Type_ID = ? ";

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
      "          FROM C_Remittance_Type" +
      "         WHERE C_Remittance_Type.C_Remittance_Type_ID = ? ";

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
