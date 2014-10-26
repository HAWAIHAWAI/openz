//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.bid.ProposalTracker;

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
class ProposalList800035Data implements FieldProvider {
static Logger log4j = Logger.getLogger(ProposalList800035Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String firstname;
  public String todatesend;
  public String fromdatesend;
  public String lastname;
  public String cProjectproposalId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cProjectId;
  public String cProjectIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String issotrx;
  public String datesend;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String adUserId;
  public String adUserIdr;
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
    else if (fieldName.equalsIgnoreCase("firstname"))
      return firstname;
    else if (fieldName.equalsIgnoreCase("todatesend"))
      return todatesend;
    else if (fieldName.equalsIgnoreCase("fromdatesend"))
      return fromdatesend;
    else if (fieldName.equalsIgnoreCase("lastname"))
      return lastname;
    else if (fieldName.equalsIgnoreCase("c_projectproposal_id") || fieldName.equals("cProjectproposalId"))
      return cProjectproposalId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("datesend"))
      return datesend;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
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
  public static ProposalList800035Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProposalList800035Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Projectproposal_V.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Projectproposal_V.CreatedBy) as CreatedByR, " +
      "        to_char(C_Projectproposal_V.Updated, ?) as updated, " +
      "        to_char(C_Projectproposal_V.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Projectproposal_V.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Projectproposal_V.UpdatedBy) as UpdatedByR," +
      "        C_Projectproposal_V.Firstname, " +
      "C_Projectproposal_V.Todatesend, " +
      "C_Projectproposal_V.Fromdatesend, " +
      "C_Projectproposal_V.Lastname, " +
      "C_Projectproposal_V.C_Projectproposal_ID, " +
      "C_Projectproposal_V.AD_Client_ID, " +
      "(CASE WHEN C_Projectproposal_V.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_Projectproposal_V.AD_Org_ID, " +
      "(CASE WHEN C_Projectproposal_V.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Projectproposal_V.C_Project_ID, " +
      "(CASE WHEN C_Projectproposal_V.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "C_Projectproposal_V.C_BPartner_ID, " +
      "(CASE WHEN C_Projectproposal_V.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "COALESCE(C_Projectproposal_V.IsSOTrx, 'N') AS IsSOTrx, " +
      "C_Projectproposal_V.Datesend, " +
      "C_Projectproposal_V.C_BPartner_Location_ID, " +
      "(CASE WHEN C_Projectproposal_V.C_BPartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_BPartner_Location_IDR, " +
      "C_Projectproposal_V.AD_User_ID, " +
      "(CASE WHEN C_Projectproposal_V.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Projectproposal_V left join (select AD_Client_ID, Name from AD_Client) table1 on (C_Projectproposal_V.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_Projectproposal_V.AD_Org_ID = table2.AD_Org_ID) left join (select C_Project_ID, Value, Name from C_Project) table3 on (C_Projectproposal_V.C_Project_ID = table3.C_Project_ID) left join (select C_BPartner_ID, Name from C_BPartner) table4 on (C_Projectproposal_V.C_BPartner_ID = table4.C_BPartner_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table5 on (C_Projectproposal_V.C_BPartner_Location_ID = table5.C_BPartner_Location_ID) left join (select AD_User_ID, Name from AD_User) table6 on (C_Projectproposal_V.AD_User_ID = table6.AD_User_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_Projectproposal_V.C_Projectproposal_ID = ? " +
      "        AND C_Projectproposal_V.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Projectproposal_V.AD_Org_ID IN (";
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
        ProposalList800035Data objectProposalList800035Data = new ProposalList800035Data();
        objectProposalList800035Data.created = UtilSql.getValue(result, "created");
        objectProposalList800035Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectProposalList800035Data.updated = UtilSql.getValue(result, "updated");
        objectProposalList800035Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectProposalList800035Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectProposalList800035Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectProposalList800035Data.firstname = UtilSql.getValue(result, "firstname");
        objectProposalList800035Data.todatesend = UtilSql.getDateValue(result, "todatesend", "dd-MM-yyyy");
        objectProposalList800035Data.fromdatesend = UtilSql.getDateValue(result, "fromdatesend", "dd-MM-yyyy");
        objectProposalList800035Data.lastname = UtilSql.getValue(result, "lastname");
        objectProposalList800035Data.cProjectproposalId = UtilSql.getValue(result, "c_projectproposal_id");
        objectProposalList800035Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProposalList800035Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectProposalList800035Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProposalList800035Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectProposalList800035Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectProposalList800035Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectProposalList800035Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectProposalList800035Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectProposalList800035Data.issotrx = UtilSql.getValue(result, "issotrx");
        objectProposalList800035Data.datesend = UtilSql.getDateValue(result, "datesend", "dd-MM-yyyy");
        objectProposalList800035Data.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectProposalList800035Data.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectProposalList800035Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectProposalList800035Data.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectProposalList800035Data.language = UtilSql.getValue(result, "language");
        objectProposalList800035Data.adUserClient = "";
        objectProposalList800035Data.adOrgClient = "";
        objectProposalList800035Data.createdby = "";
        objectProposalList800035Data.trBgcolor = "";
        objectProposalList800035Data.totalCount = "";
        objectProposalList800035Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProposalList800035Data);
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
    ProposalList800035Data objectProposalList800035Data[] = new ProposalList800035Data[vector.size()];
    vector.copyInto(objectProposalList800035Data);
    return(objectProposalList800035Data);
  }

/**
Create a registry
 */
  public static ProposalList800035Data[] set(String fromdatesend, String todatesend, String cProjectId, String issotrx, String lastname, String adClientId, String firstname, String adUserId, String datesend, String cProjectproposalId, String cBpartnerId, String cBpartnerIdr, String adOrgId, String cBpartnerLocationId)    throws ServletException {
    ProposalList800035Data objectProposalList800035Data[] = new ProposalList800035Data[1];
    objectProposalList800035Data[0] = new ProposalList800035Data();
    objectProposalList800035Data[0].created = "";
    objectProposalList800035Data[0].createdbyr = "";
    objectProposalList800035Data[0].updated = "";
    objectProposalList800035Data[0].updatedTimeStamp = "";
    objectProposalList800035Data[0].updatedby = "";
    objectProposalList800035Data[0].updatedbyr = "";
    objectProposalList800035Data[0].firstname = firstname;
    objectProposalList800035Data[0].todatesend = todatesend;
    objectProposalList800035Data[0].fromdatesend = fromdatesend;
    objectProposalList800035Data[0].lastname = lastname;
    objectProposalList800035Data[0].cProjectproposalId = cProjectproposalId;
    objectProposalList800035Data[0].adClientId = adClientId;
    objectProposalList800035Data[0].adClientIdr = "";
    objectProposalList800035Data[0].adOrgId = adOrgId;
    objectProposalList800035Data[0].adOrgIdr = "";
    objectProposalList800035Data[0].cProjectId = cProjectId;
    objectProposalList800035Data[0].cProjectIdr = "";
    objectProposalList800035Data[0].cBpartnerId = cBpartnerId;
    objectProposalList800035Data[0].cBpartnerIdr = cBpartnerIdr;
    objectProposalList800035Data[0].issotrx = issotrx;
    objectProposalList800035Data[0].datesend = datesend;
    objectProposalList800035Data[0].cBpartnerLocationId = cBpartnerLocationId;
    objectProposalList800035Data[0].cBpartnerLocationIdr = "";
    objectProposalList800035Data[0].adUserId = adUserId;
    objectProposalList800035Data[0].adUserIdr = "";
    objectProposalList800035Data[0].language = "";
    return objectProposalList800035Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef800482_0(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_BPartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_bpartner_id");
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
      "        UPDATE C_Projectproposal_V" +
      "        SET Firstname = (?) , Todatesend = TO_DATE(?) , Fromdatesend = TO_DATE(?) , Lastname = (?) , C_Projectproposal_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_Project_ID = (?) , C_BPartner_ID = (?) , IsSOTrx = (?) , Datesend = TO_DATE(?) , C_BPartner_Location_ID = (?) , AD_User_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Projectproposal_V.C_Projectproposal_ID = ? " +
      "        AND C_Projectproposal_V.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Projectproposal_V.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, todatesend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fromdatesend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectproposalId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datesend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectproposalId);
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
      "        INSERT INTO C_Projectproposal_V " +
      "        (Firstname, Todatesend, Fromdatesend, Lastname, C_Projectproposal_ID, AD_Client_ID, AD_Org_ID, C_Project_ID, C_BPartner_ID, IsSOTrx, Datesend, C_BPartner_Location_ID, AD_User_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, todatesend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fromdatesend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectproposalId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datesend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
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
      "        DELETE FROM C_Projectproposal_V" +
      "        WHERE C_Projectproposal_V.C_Projectproposal_ID = ? " +
      "        AND C_Projectproposal_V.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Projectproposal_V.AD_Org_ID IN (";
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
      "        DELETE FROM C_Projectproposal_V" +
      "        WHERE C_Projectproposal_V.C_Projectproposal_ID = ? ";

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
      "          FROM C_Projectproposal_V" +
      "         WHERE C_Projectproposal_V.C_Projectproposal_ID = ? ";

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
      "          FROM C_Projectproposal_V" +
      "         WHERE C_Projectproposal_V.C_Projectproposal_ID = ? ";

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
