//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.security;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

public class SessionLoginData implements FieldProvider {
static Logger log4j = Logger.getLogger(SessionLoginData.class);
  private String InitRecordNumber="0";
  public String adSessionId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String websession;
  public String remoteAddr;
  public String remoteHost;
  public String processed;
  public String sessionActive;
  public String serverUrl;
  public String supportContact;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_session_id") || fieldName.equals("adSessionId"))
      return adSessionId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("websession"))
      return websession;
    else if (fieldName.equalsIgnoreCase("remote_addr") || fieldName.equals("remoteAddr"))
      return remoteAddr;
    else if (fieldName.equalsIgnoreCase("remote_host") || fieldName.equals("remoteHost"))
      return remoteHost;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("session_active") || fieldName.equals("sessionActive"))
      return sessionActive;
    else if (fieldName.equalsIgnoreCase("server_url") || fieldName.equals("serverUrl"))
      return serverUrl;
    else if (fieldName.equals("supportContact"))
      return supportContact;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SessionLoginData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static SessionLoginData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select * from ad_session";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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
        SessionLoginData objectSessionLoginData = new SessionLoginData();
        objectSessionLoginData.adSessionId = UtilSql.getValue(result, "ad_session_id");
        objectSessionLoginData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSessionLoginData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSessionLoginData.isactive = UtilSql.getValue(result, "isactive");
        objectSessionLoginData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectSessionLoginData.createdby = UtilSql.getValue(result, "createdby");
        objectSessionLoginData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectSessionLoginData.updatedby = UtilSql.getValue(result, "updatedby");
        objectSessionLoginData.websession = UtilSql.getValue(result, "websession");
        objectSessionLoginData.remoteAddr = UtilSql.getValue(result, "remote_addr");
        objectSessionLoginData.remoteHost = UtilSql.getValue(result, "remote_host");
        objectSessionLoginData.processed = UtilSql.getValue(result, "processed");
        objectSessionLoginData.sessionActive = UtilSql.getValue(result, "session_active");
        objectSessionLoginData.serverUrl = UtilSql.getValue(result, "server_url");
        objectSessionLoginData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSessionLoginData);
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
    SessionLoginData objectSessionLoginData[] = new SessionLoginData[vector.size()];
    vector.copyInto(objectSessionLoginData);
    return(objectSessionLoginData);
  }

  public static int insert(ConnectionProvider connectionProvider, String adSessionId, String adClientId, String adOrgId, String isactive, String adUserId, String websession, String remoteAddr, String remoteHost, String processed, String serverURL)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO AD_SESSION (AD_SESSION_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, " +
      "        WEBSESSION, REMOTE_ADDR, REMOTE_HOST, PROCESSED, SESSION_ACTIVE, SERVER_URL) " +
      "        VALUES (?, ?, ?, ?, now(), ?, now(), ?, " +
      "        ?, ?, ?, ?, 'Y',?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSessionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, websession);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, remoteAddr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, remoteHost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serverURL);

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

  public static int update(ConnectionProvider connectionProvider, String isactive, String adUserId, String websession, String remoteAddr, String remoteHost, String processed, String adSessionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_SESSION SET ISACTIVE = ?, UPDATED = now(), UPDATEDBY = ?, " +
      "        WEBSESSION = ?, REMOTE_ADDR = ?, REMOTE_HOST = ?, PROCESSED = ? " +
      "        WHERE AD_SESSION_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, websession);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, remoteAddr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, remoteHost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSessionId);

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

  public static int deactivate(ConnectionProvider connectionProvider, String adSessionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_Session" +
      "        SET ISACTIVE = 'N'  , UPDATED = now()" +
      "        WHERE AD_Session.AD_Session_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSessionId);

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

  public static boolean isSessionActive(ConnectionProvider connectionProvider, String adSessionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) " +
      "          FROM AD_SESSION" +
      "         WHERE AD_SESSION_ID = ?" +
      "           AND ISACTIVE = 'Y'";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSessionId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "count").equals("0");
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
    return(boolReturn);
  }

  public static SessionLoginData[] activeSessions(ConnectionProvider connectionProvider)    throws ServletException {
    return activeSessions(connectionProvider, 0, 0);
  }

  public static SessionLoginData[] activeSessions(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_SESSION_ID, SERVER_URL" +
      "          FROM AD_SESSION" +
      "         WHERE ISACTIVE = 'Y'";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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
        SessionLoginData objectSessionLoginData = new SessionLoginData();
        objectSessionLoginData.adSessionId = UtilSql.getValue(result, "ad_session_id");
        objectSessionLoginData.serverUrl = UtilSql.getValue(result, "server_url");
        objectSessionLoginData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSessionLoginData);
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
    SessionLoginData objectSessionLoginData[] = new SessionLoginData[vector.size()];
    vector.copyInto(objectSessionLoginData);
    return(objectSessionLoginData);
  }

  public static String isLocalSession(ConnectionProvider connectionProvider, String adSessionId, String serverURL)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select 'Y' as islocal from ad_session where ISACTIVE = 'Y' and AD_SESSION_ID=? and SERVER_URL = ?" +
      "        union" +
      "        select 'N' as islocal from dual" +
      "        order by islocal desc limit 1";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSessionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serverURL);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "islocal");
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

  public static String selectSupportContact(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT SUPPORT_CONTACT" +
      "          FROM AD_SYSTEM_INFO";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "support_contact");
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

  public static String selectDefaultTheme(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT TAD_THEME" +
      "          FROM AD_SYSTEM";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "tad_theme");
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

  public static String selectRoleTheme(ConnectionProvider connectionProvider, String adRoleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(AD_ROLE.THEME, AD_SYSTEM.TAD_THEME)" +
      "          FROM AD_SYSTEM, AD_ROLE " +
      "          WHERE AD_ROLE.AD_ROLE_ID= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "coalesce");
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

  public static String selectVersion(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT VERSION_LABEL" +
      "             FROM AD_MODULE" +
      "         WHERE AD_MODULE_ID ='0'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "version_label");
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
