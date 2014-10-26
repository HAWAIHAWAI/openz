//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Workcalender;

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
class WorkcalenderData implements FieldProvider {
static Logger log4j = Logger.getLogger(WorkcalenderData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String workdate;
  public String cWorkcalenderId;
  public String dayname;
  public String daynamer;
  public String worktime;
  public String workbegintime;
  public String isholiday;
  public String isworkday;
  public String isweekend;
  public String adOrgId;
  public String adOrgIdr;
  public String adClientId;
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
    else if (fieldName.equalsIgnoreCase("workdate"))
      return workdate;
    else if (fieldName.equalsIgnoreCase("c_workcalender_id") || fieldName.equals("cWorkcalenderId"))
      return cWorkcalenderId;
    else if (fieldName.equalsIgnoreCase("dayname"))
      return dayname;
    else if (fieldName.equalsIgnoreCase("daynamer"))
      return daynamer;
    else if (fieldName.equalsIgnoreCase("worktime"))
      return worktime;
    else if (fieldName.equalsIgnoreCase("workbegintime"))
      return workbegintime;
    else if (fieldName.equalsIgnoreCase("isholiday"))
      return isholiday;
    else if (fieldName.equalsIgnoreCase("isworkday"))
      return isworkday;
    else if (fieldName.equalsIgnoreCase("isweekend"))
      return isweekend;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
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
  public static WorkcalenderData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static WorkcalenderData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_WORKCALENDER.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_WORKCALENDER.CreatedBy) as CreatedByR, " +
      "        to_char(C_WORKCALENDER.Updated, ?) as updated, " +
      "        to_char(C_WORKCALENDER.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_WORKCALENDER.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_WORKCALENDER.UpdatedBy) as UpdatedByR," +
      "        C_WORKCALENDER.Workdate, " +
      "C_WORKCALENDER.C_Workcalender_ID, " +
      "C_WORKCALENDER.Dayname, " +
      "(CASE WHEN C_WORKCALENDER.Dayname IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DaynameR, " +
      "C_WORKCALENDER.Worktime, " +
      "TO_CHAR(C_WORKCALENDER.Workbegintime, 'HH24:MI:SS') AS Workbegintime, " +
      "COALESCE(C_WORKCALENDER.Isholiday, 'N') AS Isholiday, " +
      "COALESCE(C_WORKCALENDER.Isworkday, 'N') AS Isworkday, " +
      "COALESCE(C_WORKCALENDER.Isweekend, 'N') AS Isweekend, " +
      "C_WORKCALENDER.AD_Org_ID, " +
      "(CASE WHEN C_WORKCALENDER.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_WORKCALENDER.AD_Client_ID, " +
      "COALESCE(C_WORKCALENDER.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM C_WORKCALENDER left join ad_ref_list_v list1 on (C_WORKCALENDER.Dayname = list1.value and list1.ad_reference_id = '167' and list1.ad_language = ?)  left join (select AD_Org_ID, Name from AD_Org) table1 on (C_WORKCALENDER.AD_Org_ID = table1.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_WORKCALENDER.C_Workcalender_ID = ? " +
      "        AND C_WORKCALENDER.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_WORKCALENDER.AD_Org_ID IN (";
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
        WorkcalenderData objectWorkcalenderData = new WorkcalenderData();
        objectWorkcalenderData.created = UtilSql.getValue(result, "created");
        objectWorkcalenderData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectWorkcalenderData.updated = UtilSql.getValue(result, "updated");
        objectWorkcalenderData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectWorkcalenderData.updatedby = UtilSql.getValue(result, "updatedby");
        objectWorkcalenderData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectWorkcalenderData.workdate = UtilSql.getDateValue(result, "workdate", "dd-MM-yyyy");
        objectWorkcalenderData.cWorkcalenderId = UtilSql.getValue(result, "c_workcalender_id");
        objectWorkcalenderData.dayname = UtilSql.getValue(result, "dayname");
        objectWorkcalenderData.daynamer = UtilSql.getValue(result, "daynamer");
        objectWorkcalenderData.worktime = UtilSql.getValue(result, "worktime");
        objectWorkcalenderData.workbegintime = UtilSql.getValue(result, "workbegintime");
        objectWorkcalenderData.isholiday = UtilSql.getValue(result, "isholiday");
        objectWorkcalenderData.isworkday = UtilSql.getValue(result, "isworkday");
        objectWorkcalenderData.isweekend = UtilSql.getValue(result, "isweekend");
        objectWorkcalenderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectWorkcalenderData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectWorkcalenderData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectWorkcalenderData.isactive = UtilSql.getValue(result, "isactive");
        objectWorkcalenderData.language = UtilSql.getValue(result, "language");
        objectWorkcalenderData.adUserClient = "";
        objectWorkcalenderData.adOrgClient = "";
        objectWorkcalenderData.createdby = "";
        objectWorkcalenderData.trBgcolor = "";
        objectWorkcalenderData.totalCount = "";
        objectWorkcalenderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWorkcalenderData);
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
    WorkcalenderData objectWorkcalenderData[] = new WorkcalenderData[vector.size()];
    vector.copyInto(objectWorkcalenderData);
    return(objectWorkcalenderData);
  }

/**
Create a registry
 */
  public static WorkcalenderData[] set(String workdate, String worktime, String adOrgId, String isholiday, String dayname, String cWorkcalenderId, String isweekend, String workbegintime, String updatedby, String updatedbyr, String createdby, String createdbyr, String adClientId, String isactive, String isworkday)    throws ServletException {
    WorkcalenderData objectWorkcalenderData[] = new WorkcalenderData[1];
    objectWorkcalenderData[0] = new WorkcalenderData();
    objectWorkcalenderData[0].created = "";
    objectWorkcalenderData[0].createdbyr = createdbyr;
    objectWorkcalenderData[0].updated = "";
    objectWorkcalenderData[0].updatedTimeStamp = "";
    objectWorkcalenderData[0].updatedby = updatedby;
    objectWorkcalenderData[0].updatedbyr = updatedbyr;
    objectWorkcalenderData[0].workdate = workdate;
    objectWorkcalenderData[0].cWorkcalenderId = cWorkcalenderId;
    objectWorkcalenderData[0].dayname = dayname;
    objectWorkcalenderData[0].daynamer = "";
    objectWorkcalenderData[0].worktime = worktime;
    objectWorkcalenderData[0].workbegintime = workbegintime;
    objectWorkcalenderData[0].isholiday = isholiday;
    objectWorkcalenderData[0].isworkday = isworkday;
    objectWorkcalenderData[0].isweekend = isweekend;
    objectWorkcalenderData[0].adOrgId = adOrgId;
    objectWorkcalenderData[0].adOrgIdr = "";
    objectWorkcalenderData[0].adClientId = adClientId;
    objectWorkcalenderData[0].isactive = isactive;
    objectWorkcalenderData[0].language = "";
    return objectWorkcalenderData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef8EF10D11901742719533E5D1A4D503F0_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef52BA0BE8304F41429D5059A306FFEE31_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        UPDATE C_WORKCALENDER" +
      "        SET Workdate = TO_DATE(?) , C_Workcalender_ID = (?) , Dayname = (?) , Worktime = TO_NUMBER(?) , Workbegintime = TO_TIMESTAMP(?,'HH24:MI:SS') , Isholiday = (?) , Isworkday = (?) , Isweekend = (?) , AD_Org_ID = (?) , AD_Client_ID = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_WORKCALENDER.C_Workcalender_ID = ? " +
      "        AND C_WORKCALENDER.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_WORKCALENDER.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cWorkcalenderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isholiday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isworkday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isweekend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cWorkcalenderId);
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
      "        INSERT INTO C_WORKCALENDER " +
      "        (Workdate, C_Workcalender_ID, Dayname, Worktime, Workbegintime, Isholiday, Isworkday, Isweekend, AD_Org_ID, AD_Client_ID, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES (TO_DATE(?), (?), (?), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cWorkcalenderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isholiday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isworkday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isweekend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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
      "        DELETE FROM C_WORKCALENDER" +
      "        WHERE C_WORKCALENDER.C_Workcalender_ID = ? " +
      "        AND C_WORKCALENDER.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_WORKCALENDER.AD_Org_ID IN (";
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
      "        DELETE FROM C_WORKCALENDER" +
      "        WHERE C_WORKCALENDER.C_Workcalender_ID = ? ";

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
      "          FROM C_WORKCALENDER" +
      "         WHERE C_WORKCALENDER.C_Workcalender_ID = ? ";

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
      "          FROM C_WORKCALENDER" +
      "         WHERE C_WORKCALENDER.C_Workcalender_ID = ? ";

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
