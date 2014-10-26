//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.AdditionalFees;

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
class AdditionalFeesData implements FieldProvider {
static Logger log4j = Logger.getLogger(AdditionalFeesData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String cAdditionalfeesId;
  public String isactive;
  public String validfrom;
  public String saturday;
  public String sunday;
  public String holiday;
  public String overtime;
  public String overtimebegin;
  public String night;
  public String nightbegin;
  public String nightend;
  public String adClientId;
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
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_additionalfees_id") || fieldName.equals("cAdditionalfeesId"))
      return cAdditionalfeesId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("validfrom"))
      return validfrom;
    else if (fieldName.equalsIgnoreCase("saturday"))
      return saturday;
    else if (fieldName.equalsIgnoreCase("sunday"))
      return sunday;
    else if (fieldName.equalsIgnoreCase("holiday"))
      return holiday;
    else if (fieldName.equalsIgnoreCase("overtime"))
      return overtime;
    else if (fieldName.equalsIgnoreCase("overtimebegin"))
      return overtimebegin;
    else if (fieldName.equalsIgnoreCase("night"))
      return night;
    else if (fieldName.equalsIgnoreCase("nightbegin"))
      return nightbegin;
    else if (fieldName.equalsIgnoreCase("nightend"))
      return nightend;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
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
  public static AdditionalFeesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static AdditionalFeesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_additionalfees.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_additionalfees.CreatedBy) as CreatedByR, " +
      "        to_char(c_additionalfees.Updated, ?) as updated, " +
      "        to_char(c_additionalfees.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_additionalfees.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_additionalfees.UpdatedBy) as UpdatedByR," +
      "        c_additionalfees.AD_Org_ID, " +
      "(CASE WHEN c_additionalfees.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "c_additionalfees.C_Additionalfees_ID, " +
      "COALESCE(c_additionalfees.Isactive, 'N') AS Isactive, " +
      "c_additionalfees.Validfrom, " +
      "c_additionalfees.Saturday, " +
      "c_additionalfees.Sunday, " +
      "c_additionalfees.Holiday, " +
      "c_additionalfees.Overtime, " +
      "c_additionalfees.Overtimebegin, " +
      "c_additionalfees.Night, " +
      "TO_CHAR(c_additionalfees.Nightbegin, 'HH24:MI:SS') AS Nightbegin, " +
      "TO_CHAR(c_additionalfees.Nightend, 'HH24:MI:SS') AS Nightend, " +
      "c_additionalfees.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM c_additionalfees left join (select AD_Org_ID, Name from AD_Org) table1 on (c_additionalfees.AD_Org_ID = table1.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND c_additionalfees.C_Additionalfees_ID = ? " +
      "        AND c_additionalfees.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_additionalfees.AD_Org_ID IN (";
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
        AdditionalFeesData objectAdditionalFeesData = new AdditionalFeesData();
        objectAdditionalFeesData.created = UtilSql.getValue(result, "created");
        objectAdditionalFeesData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectAdditionalFeesData.updated = UtilSql.getValue(result, "updated");
        objectAdditionalFeesData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectAdditionalFeesData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAdditionalFeesData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectAdditionalFeesData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAdditionalFeesData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectAdditionalFeesData.cAdditionalfeesId = UtilSql.getValue(result, "c_additionalfees_id");
        objectAdditionalFeesData.isactive = UtilSql.getValue(result, "isactive");
        objectAdditionalFeesData.validfrom = UtilSql.getDateValue(result, "validfrom", "dd-MM-yyyy");
        objectAdditionalFeesData.saturday = UtilSql.getValue(result, "saturday");
        objectAdditionalFeesData.sunday = UtilSql.getValue(result, "sunday");
        objectAdditionalFeesData.holiday = UtilSql.getValue(result, "holiday");
        objectAdditionalFeesData.overtime = UtilSql.getValue(result, "overtime");
        objectAdditionalFeesData.overtimebegin = UtilSql.getValue(result, "overtimebegin");
        objectAdditionalFeesData.night = UtilSql.getValue(result, "night");
        objectAdditionalFeesData.nightbegin = UtilSql.getValue(result, "nightbegin");
        objectAdditionalFeesData.nightend = UtilSql.getValue(result, "nightend");
        objectAdditionalFeesData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAdditionalFeesData.language = UtilSql.getValue(result, "language");
        objectAdditionalFeesData.adUserClient = "";
        objectAdditionalFeesData.adOrgClient = "";
        objectAdditionalFeesData.createdby = "";
        objectAdditionalFeesData.trBgcolor = "";
        objectAdditionalFeesData.totalCount = "";
        objectAdditionalFeesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAdditionalFeesData);
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
    AdditionalFeesData objectAdditionalFeesData[] = new AdditionalFeesData[vector.size()];
    vector.copyInto(objectAdditionalFeesData);
    return(objectAdditionalFeesData);
  }

/**
Create a registry
 */
  public static AdditionalFeesData[] set(String nightbegin, String isactive, String overtime, String sunday, String adClientId, String adOrgId, String night, String cAdditionalfeesId, String saturday, String holiday, String createdby, String createdbyr, String validfrom, String updatedby, String updatedbyr, String nightend, String overtimebegin)    throws ServletException {
    AdditionalFeesData objectAdditionalFeesData[] = new AdditionalFeesData[1];
    objectAdditionalFeesData[0] = new AdditionalFeesData();
    objectAdditionalFeesData[0].created = "";
    objectAdditionalFeesData[0].createdbyr = createdbyr;
    objectAdditionalFeesData[0].updated = "";
    objectAdditionalFeesData[0].updatedTimeStamp = "";
    objectAdditionalFeesData[0].updatedby = updatedby;
    objectAdditionalFeesData[0].updatedbyr = updatedbyr;
    objectAdditionalFeesData[0].adOrgId = adOrgId;
    objectAdditionalFeesData[0].adOrgIdr = "";
    objectAdditionalFeesData[0].cAdditionalfeesId = cAdditionalfeesId;
    objectAdditionalFeesData[0].isactive = isactive;
    objectAdditionalFeesData[0].validfrom = validfrom;
    objectAdditionalFeesData[0].saturday = saturday;
    objectAdditionalFeesData[0].sunday = sunday;
    objectAdditionalFeesData[0].holiday = holiday;
    objectAdditionalFeesData[0].overtime = overtime;
    objectAdditionalFeesData[0].overtimebegin = overtimebegin;
    objectAdditionalFeesData[0].night = night;
    objectAdditionalFeesData[0].nightbegin = nightbegin;
    objectAdditionalFeesData[0].nightend = nightend;
    objectAdditionalFeesData[0].adClientId = adClientId;
    objectAdditionalFeesData[0].language = "";
    return objectAdditionalFeesData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef59729EF6A37D4BE08FC961EF17CB1C48_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefC59A449B9B234CA5A085D3AE1403F7E7_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        UPDATE c_additionalfees" +
      "        SET AD_Org_ID = (?) , C_Additionalfees_ID = (?) , Isactive = (?) , Validfrom = TO_DATE(?) , Saturday = TO_NUMBER(?) , Sunday = TO_NUMBER(?) , Holiday = TO_NUMBER(?) , Overtime = TO_NUMBER(?) , Overtimebegin = TO_NUMBER(?) , Night = TO_NUMBER(?) , Nightbegin = TO_TIMESTAMP(?,'HH24:MI:SS') , Nightend = TO_TIMESTAMP(?,'HH24:MI:SS') , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE c_additionalfees.C_Additionalfees_ID = ? " +
      "        AND c_additionalfees.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_additionalfees.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAdditionalfeesId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, saturday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sunday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, holiday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, overtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, overtimebegin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, night);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nightbegin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nightend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAdditionalfeesId);
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
      "        INSERT INTO c_additionalfees " +
      "        (AD_Org_ID, C_Additionalfees_ID, Isactive, Validfrom, Saturday, Sunday, Holiday, Overtime, Overtimebegin, Night, Nightbegin, Nightend, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_TIMESTAMP(?, 'HH24:MI:SS'), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAdditionalfeesId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, saturday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sunday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, holiday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, overtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, overtimebegin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, night);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nightbegin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nightend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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
      "        DELETE FROM c_additionalfees" +
      "        WHERE c_additionalfees.C_Additionalfees_ID = ? " +
      "        AND c_additionalfees.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_additionalfees.AD_Org_ID IN (";
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
      "        DELETE FROM c_additionalfees" +
      "        WHERE c_additionalfees.C_Additionalfees_ID = ? ";

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
      "          FROM c_additionalfees" +
      "         WHERE c_additionalfees.C_Additionalfees_ID = ? ";

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
      "          FROM c_additionalfees" +
      "         WHERE c_additionalfees.C_Additionalfees_ID = ? ";

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
