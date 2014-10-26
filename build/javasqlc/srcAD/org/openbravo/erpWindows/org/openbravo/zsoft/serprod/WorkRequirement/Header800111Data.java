//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.WorkRequirement;

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
class Header800111Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Header800111Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String maWorkrequirementId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String documentno;
  public String isactive;
  public String maProcessplanId;
  public String maProcessplanIdr;
  public String explodephases;
  public String quantity;
  public String name;
  public String conversionrate;
  public String secondaryqty;
  public String secondaryunit;
  public String launchdate;
  public String startdate;
  public String enddate;
  public String closed;
  public String explote;
  public String processed;
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
    else if (fieldName.equalsIgnoreCase("ma_workrequirement_id") || fieldName.equals("maWorkrequirementId"))
      return maWorkrequirementId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ma_processplan_id") || fieldName.equals("maProcessplanId"))
      return maProcessplanId;
    else if (fieldName.equalsIgnoreCase("ma_processplan_idr") || fieldName.equals("maProcessplanIdr"))
      return maProcessplanIdr;
    else if (fieldName.equalsIgnoreCase("explodephases"))
      return explodephases;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("conversionrate"))
      return conversionrate;
    else if (fieldName.equalsIgnoreCase("secondaryqty"))
      return secondaryqty;
    else if (fieldName.equalsIgnoreCase("secondaryunit"))
      return secondaryunit;
    else if (fieldName.equalsIgnoreCase("launchdate"))
      return launchdate;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("closed"))
      return closed;
    else if (fieldName.equalsIgnoreCase("explote"))
      return explote;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
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
  public static Header800111Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Header800111Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_WorkRequirement.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_WorkRequirement.CreatedBy) as CreatedByR, " +
      "        to_char(MA_WorkRequirement.Updated, ?) as updated, " +
      "        to_char(MA_WorkRequirement.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_WorkRequirement.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_WorkRequirement.UpdatedBy) as UpdatedByR," +
      "        MA_WorkRequirement.MA_Workrequirement_ID, " +
      "MA_WorkRequirement.AD_Client_ID, " +
      "(CASE WHEN MA_WorkRequirement.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MA_WorkRequirement.AD_Org_ID, " +
      "(CASE WHEN MA_WorkRequirement.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MA_WorkRequirement.DocumentNo, " +
      "COALESCE(MA_WorkRequirement.IsActive, 'N') AS IsActive, " +
      "MA_WorkRequirement.MA_Processplan_ID, " +
      "(CASE WHEN MA_WorkRequirement.MA_Processplan_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS MA_Processplan_IDR, " +
      "COALESCE(MA_WorkRequirement.Explodephases, 'N') AS Explodephases, " +
      "MA_WorkRequirement.Quantity, " +
      "MA_WorkRequirement.Name, " +
      "MA_WorkRequirement.Conversionrate, " +
      "MA_WorkRequirement.Secondaryqty, " +
      "MA_WorkRequirement.Secondaryunit, " +
      "MA_WorkRequirement.Launchdate, " +
      "MA_WorkRequirement.StartDate, " +
      "MA_WorkRequirement.EndDate, " +
      "MA_WorkRequirement.Closed, " +
      "MA_WorkRequirement.Explote, " +
      "COALESCE(MA_WorkRequirement.Processed, 'N') AS Processed, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_WorkRequirement left join (select AD_Client_ID, Name from AD_Client) table1 on (MA_WorkRequirement.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MA_WorkRequirement.AD_Org_ID = table2.AD_Org_ID) left join (select MA_Processplan_ID, Name from MA_Processplan) table3 on (MA_WorkRequirement.MA_Processplan_ID = table3.MA_Processplan_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND MA_WorkRequirement.MA_Workrequirement_ID = ? " +
      "        AND MA_WorkRequirement.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_WorkRequirement.AD_Org_ID IN (";
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
        Header800111Data objectHeader800111Data = new Header800111Data();
        objectHeader800111Data.created = UtilSql.getValue(result, "created");
        objectHeader800111Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectHeader800111Data.updated = UtilSql.getValue(result, "updated");
        objectHeader800111Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectHeader800111Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectHeader800111Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectHeader800111Data.maWorkrequirementId = UtilSql.getValue(result, "ma_workrequirement_id");
        objectHeader800111Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectHeader800111Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectHeader800111Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectHeader800111Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectHeader800111Data.documentno = UtilSql.getValue(result, "documentno");
        objectHeader800111Data.isactive = UtilSql.getValue(result, "isactive");
        objectHeader800111Data.maProcessplanId = UtilSql.getValue(result, "ma_processplan_id");
        objectHeader800111Data.maProcessplanIdr = UtilSql.getValue(result, "ma_processplan_idr");
        objectHeader800111Data.explodephases = UtilSql.getValue(result, "explodephases");
        objectHeader800111Data.quantity = UtilSql.getValue(result, "quantity");
        objectHeader800111Data.name = UtilSql.getValue(result, "name");
        objectHeader800111Data.conversionrate = UtilSql.getValue(result, "conversionrate");
        objectHeader800111Data.secondaryqty = UtilSql.getValue(result, "secondaryqty");
        objectHeader800111Data.secondaryunit = UtilSql.getValue(result, "secondaryunit");
        objectHeader800111Data.launchdate = UtilSql.getDateValue(result, "launchdate", "dd-MM-yyyy");
        objectHeader800111Data.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectHeader800111Data.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectHeader800111Data.closed = UtilSql.getValue(result, "closed");
        objectHeader800111Data.explote = UtilSql.getValue(result, "explote");
        objectHeader800111Data.processed = UtilSql.getValue(result, "processed");
        objectHeader800111Data.language = UtilSql.getValue(result, "language");
        objectHeader800111Data.adUserClient = "";
        objectHeader800111Data.adOrgClient = "";
        objectHeader800111Data.createdby = "";
        objectHeader800111Data.trBgcolor = "";
        objectHeader800111Data.totalCount = "";
        objectHeader800111Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectHeader800111Data);
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
    Header800111Data objectHeader800111Data[] = new Header800111Data[vector.size()];
    vector.copyInto(objectHeader800111Data);
    return(objectHeader800111Data);
  }

/**
Create a registry
 */
  public static Header800111Data[] set(String adOrgId, String adClientId, String launchdate, String closed, String secondaryqty, String name, String maWorkrequirementId, String explodephases, String explote, String documentno, String updatedby, String updatedbyr, String enddate, String startdate, String isactive, String secondaryunit, String processed, String maProcessplanId, String createdby, String createdbyr, String quantity, String conversionrate)    throws ServletException {
    Header800111Data objectHeader800111Data[] = new Header800111Data[1];
    objectHeader800111Data[0] = new Header800111Data();
    objectHeader800111Data[0].created = "";
    objectHeader800111Data[0].createdbyr = createdbyr;
    objectHeader800111Data[0].updated = "";
    objectHeader800111Data[0].updatedTimeStamp = "";
    objectHeader800111Data[0].updatedby = updatedby;
    objectHeader800111Data[0].updatedbyr = updatedbyr;
    objectHeader800111Data[0].maWorkrequirementId = maWorkrequirementId;
    objectHeader800111Data[0].adClientId = adClientId;
    objectHeader800111Data[0].adClientIdr = "";
    objectHeader800111Data[0].adOrgId = adOrgId;
    objectHeader800111Data[0].adOrgIdr = "";
    objectHeader800111Data[0].documentno = documentno;
    objectHeader800111Data[0].isactive = isactive;
    objectHeader800111Data[0].maProcessplanId = maProcessplanId;
    objectHeader800111Data[0].maProcessplanIdr = "";
    objectHeader800111Data[0].explodephases = explodephases;
    objectHeader800111Data[0].quantity = quantity;
    objectHeader800111Data[0].name = name;
    objectHeader800111Data[0].conversionrate = conversionrate;
    objectHeader800111Data[0].secondaryqty = secondaryqty;
    objectHeader800111Data[0].secondaryunit = secondaryunit;
    objectHeader800111Data[0].launchdate = launchdate;
    objectHeader800111Data[0].startdate = startdate;
    objectHeader800111Data[0].enddate = enddate;
    objectHeader800111Data[0].closed = closed;
    objectHeader800111Data[0].explote = explote;
    objectHeader800111Data[0].processed = processed;
    objectHeader800111Data[0].language = "";
    return objectHeader800111Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef801556_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef801554_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        UPDATE MA_WorkRequirement" +
      "        SET MA_Workrequirement_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , DocumentNo = (?) , IsActive = (?) , MA_Processplan_ID = (?) , Explodephases = (?) , Quantity = TO_NUMBER(?) , Name = (?) , Conversionrate = TO_NUMBER(?) , Secondaryqty = TO_NUMBER(?) , Secondaryunit = (?) , Launchdate = TO_DATE(?) , StartDate = TO_DATE(?) , EndDate = TO_DATE(?) , Closed = (?) , Explote = (?) , Processed = (?) , updated = now(), updatedby = ? " +
      "        WHERE MA_WorkRequirement.MA_Workrequirement_ID = ? " +
      "        AND MA_WorkRequirement.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_WorkRequirement.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maProcessplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, explodephases);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, conversionrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondaryqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondaryunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, launchdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, explote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
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
      "        INSERT INTO MA_WorkRequirement " +
      "        (MA_Workrequirement_ID, AD_Client_ID, AD_Org_ID, DocumentNo, IsActive, MA_Processplan_ID, Explodephases, Quantity, Name, Conversionrate, Secondaryqty, Secondaryunit, Launchdate, StartDate, EndDate, Closed, Explote, Processed, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maProcessplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, explodephases);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, conversionrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondaryqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondaryunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, launchdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, explote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
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
      "        DELETE FROM MA_WorkRequirement" +
      "        WHERE MA_WorkRequirement.MA_Workrequirement_ID = ? " +
      "        AND MA_WorkRequirement.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_WorkRequirement.AD_Org_ID IN (";
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
      "        DELETE FROM MA_WorkRequirement" +
      "        WHERE MA_WorkRequirement.MA_Workrequirement_ID = ? ";

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
      "          FROM MA_WorkRequirement" +
      "         WHERE MA_WorkRequirement.MA_Workrequirement_ID = ? ";

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
      "          FROM MA_WorkRequirement" +
      "         WHERE MA_WorkRequirement.MA_Workrequirement_ID = ? ";

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
