//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.CalendarEvent;

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
class EventData implements FieldProvider {
static Logger log4j = Logger.getLogger(EventData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cCalendareventId;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String name;
  public String worktime;
  public String reminder;
  public String cColorId;
  public String cColorIdr;
  public String correlation;
  public String correlationr;
  public String adClientId;
  public String isholyday;
  public String isworkcalendar;
  public String isemployeecalendar;
  public String ismachinecalendar;
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
    else if (fieldName.equalsIgnoreCase("c_calendarevent_id") || fieldName.equals("cCalendareventId"))
      return cCalendareventId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("worktime"))
      return worktime;
    else if (fieldName.equalsIgnoreCase("reminder"))
      return reminder;
    else if (fieldName.equalsIgnoreCase("c_color_id") || fieldName.equals("cColorId"))
      return cColorId;
    else if (fieldName.equalsIgnoreCase("c_color_idr") || fieldName.equals("cColorIdr"))
      return cColorIdr;
    else if (fieldName.equalsIgnoreCase("correlation"))
      return correlation;
    else if (fieldName.equalsIgnoreCase("correlationr"))
      return correlationr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("isholyday"))
      return isholyday;
    else if (fieldName.equalsIgnoreCase("isworkcalendar"))
      return isworkcalendar;
    else if (fieldName.equalsIgnoreCase("isemployeecalendar"))
      return isemployeecalendar;
    else if (fieldName.equalsIgnoreCase("ismachinecalendar"))
      return ismachinecalendar;
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
  public static EventData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static EventData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_CALENDAREVENT.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_CALENDAREVENT.CreatedBy) as CreatedByR, " +
      "        to_char(C_CALENDAREVENT.Updated, ?) as updated, " +
      "        to_char(C_CALENDAREVENT.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_CALENDAREVENT.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_CALENDAREVENT.UpdatedBy) as UpdatedByR," +
      "        C_CALENDAREVENT.C_Calendarevent_ID, " +
      "C_CALENDAREVENT.AD_Org_ID, " +
      "(CASE WHEN C_CALENDAREVENT.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(C_CALENDAREVENT.Isactive, 'N') AS Isactive, " +
      "C_CALENDAREVENT.Name, " +
      "C_CALENDAREVENT.Worktime, " +
      "COALESCE(C_CALENDAREVENT.Reminder, 'N') AS Reminder, " +
      "C_CALENDAREVENT.C_Color_ID, " +
      "(CASE WHEN C_CALENDAREVENT.C_Color_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Color_IDR, " +
      "C_CALENDAREVENT.Correlation, " +
      "(CASE WHEN C_CALENDAREVENT.Correlation IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS CorrelationR, " +
      "C_CALENDAREVENT.AD_Client_ID, " +
      "COALESCE(C_CALENDAREVENT.Isholyday, 'N') AS Isholyday, " +
      "COALESCE(C_CALENDAREVENT.Isworkcalendar, 'N') AS Isworkcalendar, " +
      "COALESCE(C_CALENDAREVENT.Isemployeecalendar, 'N') AS Isemployeecalendar, " +
      "COALESCE(C_CALENDAREVENT.Ismachinecalendar, 'N') AS Ismachinecalendar, " +
      "        ? AS LANGUAGE " +
      "        FROM C_CALENDAREVENT left join (select AD_Org_ID, Name from AD_Org) table1 on (C_CALENDAREVENT.AD_Org_ID = table1.AD_Org_ID) left join (select C_Color_ID, Name from C_Color) table2 on (C_CALENDAREVENT.C_Color_ID = table2.C_Color_ID) left join ad_ref_list_v list1 on (C_CALENDAREVENT.Correlation = list1.value and list1.ad_reference_id = '19EF07A3856A47AA8DE44E73AE8C921B' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_CALENDAREVENT.C_Calendarevent_ID = ? " +
      "        AND C_CALENDAREVENT.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_CALENDAREVENT.AD_Org_ID IN (";
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
        EventData objectEventData = new EventData();
        objectEventData.created = UtilSql.getValue(result, "created");
        objectEventData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectEventData.updated = UtilSql.getValue(result, "updated");
        objectEventData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectEventData.updatedby = UtilSql.getValue(result, "updatedby");
        objectEventData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectEventData.cCalendareventId = UtilSql.getValue(result, "c_calendarevent_id");
        objectEventData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectEventData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectEventData.isactive = UtilSql.getValue(result, "isactive");
        objectEventData.name = UtilSql.getValue(result, "name");
        objectEventData.worktime = UtilSql.getValue(result, "worktime");
        objectEventData.reminder = UtilSql.getValue(result, "reminder");
        objectEventData.cColorId = UtilSql.getValue(result, "c_color_id");
        objectEventData.cColorIdr = UtilSql.getValue(result, "c_color_idr");
        objectEventData.correlation = UtilSql.getValue(result, "correlation");
        objectEventData.correlationr = UtilSql.getValue(result, "correlationr");
        objectEventData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectEventData.isholyday = UtilSql.getValue(result, "isholyday");
        objectEventData.isworkcalendar = UtilSql.getValue(result, "isworkcalendar");
        objectEventData.isemployeecalendar = UtilSql.getValue(result, "isemployeecalendar");
        objectEventData.ismachinecalendar = UtilSql.getValue(result, "ismachinecalendar");
        objectEventData.language = UtilSql.getValue(result, "language");
        objectEventData.adUserClient = "";
        objectEventData.adOrgClient = "";
        objectEventData.createdby = "";
        objectEventData.trBgcolor = "";
        objectEventData.totalCount = "";
        objectEventData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEventData);
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
    EventData objectEventData[] = new EventData[vector.size()];
    vector.copyInto(objectEventData);
    return(objectEventData);
  }

/**
Create a registry
 */
  public static EventData[] set(String adClientId, String cCalendareventId, String updatedby, String updatedbyr, String isholyday, String isemployeecalendar, String isworkcalendar, String worktime, String adOrgId, String reminder, String correlation, String name, String createdby, String createdbyr, String isactive, String cColorId, String ismachinecalendar)    throws ServletException {
    EventData objectEventData[] = new EventData[1];
    objectEventData[0] = new EventData();
    objectEventData[0].created = "";
    objectEventData[0].createdbyr = createdbyr;
    objectEventData[0].updated = "";
    objectEventData[0].updatedTimeStamp = "";
    objectEventData[0].updatedby = updatedby;
    objectEventData[0].updatedbyr = updatedbyr;
    objectEventData[0].cCalendareventId = cCalendareventId;
    objectEventData[0].adOrgId = adOrgId;
    objectEventData[0].adOrgIdr = "";
    objectEventData[0].isactive = isactive;
    objectEventData[0].name = name;
    objectEventData[0].worktime = worktime;
    objectEventData[0].reminder = reminder;
    objectEventData[0].cColorId = cColorId;
    objectEventData[0].cColorIdr = "";
    objectEventData[0].correlation = correlation;
    objectEventData[0].correlationr = "";
    objectEventData[0].adClientId = adClientId;
    objectEventData[0].isholyday = isholyday;
    objectEventData[0].isworkcalendar = isworkcalendar;
    objectEventData[0].isemployeecalendar = isemployeecalendar;
    objectEventData[0].ismachinecalendar = ismachinecalendar;
    objectEventData[0].language = "";
    return objectEventData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefC47AFE8748E34EA4ADCA5D9B6263B53C_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef41C811A91C7247E9B6737B33530440AD_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        UPDATE C_CALENDAREVENT" +
      "        SET C_Calendarevent_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , Name = (?) , Worktime = TO_NUMBER(?) , Reminder = (?) , C_Color_ID = (?) , Correlation = (?) , AD_Client_ID = (?) , Isholyday = (?) , Isworkcalendar = (?) , Isemployeecalendar = (?) , Ismachinecalendar = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_CALENDAREVENT.C_Calendarevent_ID = ? " +
      "        AND C_CALENDAREVENT.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_CALENDAREVENT.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reminder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cColorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, correlation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isholyday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isworkcalendar);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isemployeecalendar);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismachinecalendar);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
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
      "        INSERT INTO C_CALENDAREVENT " +
      "        (C_Calendarevent_ID, AD_Org_ID, Isactive, Name, Worktime, Reminder, C_Color_ID, Correlation, AD_Client_ID, Isholyday, Isworkcalendar, Isemployeecalendar, Ismachinecalendar, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reminder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cColorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, correlation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isholyday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isworkcalendar);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isemployeecalendar);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismachinecalendar);
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
      "        DELETE FROM C_CALENDAREVENT" +
      "        WHERE C_CALENDAREVENT.C_Calendarevent_ID = ? " +
      "        AND C_CALENDAREVENT.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_CALENDAREVENT.AD_Org_ID IN (";
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
      "        DELETE FROM C_CALENDAREVENT" +
      "        WHERE C_CALENDAREVENT.C_Calendarevent_ID = ? ";

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
      "          FROM C_CALENDAREVENT" +
      "         WHERE C_CALENDAREVENT.C_Calendarevent_ID = ? ";

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
      "          FROM C_CALENDAREVENT" +
      "         WHERE C_CALENDAREVENT.C_Calendarevent_ID = ? ";

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
