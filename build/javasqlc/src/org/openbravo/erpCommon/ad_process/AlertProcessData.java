//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class AlertProcessData implements FieldProvider {
static Logger log4j = Logger.getLogger(AlertProcessData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String isactive;
  public String adUserId;
  public String adRoleId;
  public String recordId;
  public String description;
  public String referencekeyId;
  public String adAlertruleId;
  public String sql;
  public String name;
  public String smtphost;
  public String requestuser;
  public String requestuserpw;
  public String mailto;
  public String mailfrom;
  public String adLanguage;
  public String isfixed;
  public String fixed;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_role_id") || fieldName.equals("adRoleId"))
      return adRoleId;
    else if (fieldName.equalsIgnoreCase("record_id") || fieldName.equals("recordId"))
      return recordId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("referencekey_id") || fieldName.equals("referencekeyId"))
      return referencekeyId;
    else if (fieldName.equalsIgnoreCase("ad_alertrule_id") || fieldName.equals("adAlertruleId"))
      return adAlertruleId;
    else if (fieldName.equalsIgnoreCase("sql"))
      return sql;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("smtphost"))
      return smtphost;
    else if (fieldName.equalsIgnoreCase("requestuser"))
      return requestuser;
    else if (fieldName.equalsIgnoreCase("requestuserpw"))
      return requestuserpw;
    else if (fieldName.equalsIgnoreCase("mailto"))
      return mailto;
    else if (fieldName.equalsIgnoreCase("mailfrom"))
      return mailfrom;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("isfixed"))
      return isfixed;
    else if (fieldName.equalsIgnoreCase("fixed"))
      return fixed;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AlertProcessData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static AlertProcessData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT '' AS AD_CLIENT_ID," +
      "               '' AS AD_ORG_ID," +
      "               '' AS CREATED," +
      "               '' AS CREATEDBY," +
      "               '' AS UPDATED," +
      "               '' AS UPDATEDBY," +
      "               '' AS ISACTIVE," +
      "               '' AS AD_USER_ID," +
      "               '' AS AD_ROLE_ID," +
      "               '' AS RECORD_ID," +
      "               '' AS DESCRIPTION," +
      "               '' AS REFERENCEKEY_ID, " +
      "               '' AS AD_ALERTRULE_ID," +
      "               '' AS SQL," +
      "               '' AS NAME," +
      "               '' AS SMTPHOST," +
      "               '' AS REQUESTUSER," +
      "               '' AS REQUESTUSERPW," +
      "               '' AS MAILTO," +
      "               '' AS MAILFROM," +
      "               '' AS AD_LANGUAGE," +
      "               '' AS isfixed," +
      "               '' AS fixed" +
      "          FROM DUAL";

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
        AlertProcessData objectAlertProcessData = new AlertProcessData();
        objectAlertProcessData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAlertProcessData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAlertProcessData.created = UtilSql.getValue(result, "created");
        objectAlertProcessData.createdby = UtilSql.getValue(result, "createdby");
        objectAlertProcessData.updated = UtilSql.getValue(result, "updated");
        objectAlertProcessData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAlertProcessData.isactive = UtilSql.getValue(result, "isactive");
        objectAlertProcessData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectAlertProcessData.adRoleId = UtilSql.getValue(result, "ad_role_id");
        objectAlertProcessData.recordId = UtilSql.getValue(result, "record_id");
        objectAlertProcessData.description = UtilSql.getValue(result, "description");
        objectAlertProcessData.referencekeyId = UtilSql.getValue(result, "referencekey_id");
        objectAlertProcessData.adAlertruleId = UtilSql.getValue(result, "ad_alertrule_id");
        objectAlertProcessData.sql = UtilSql.getValue(result, "sql");
        objectAlertProcessData.name = UtilSql.getValue(result, "name");
        objectAlertProcessData.smtphost = UtilSql.getValue(result, "smtphost");
        objectAlertProcessData.requestuser = UtilSql.getValue(result, "requestuser");
        objectAlertProcessData.requestuserpw = UtilSql.getValue(result, "requestuserpw");
        objectAlertProcessData.mailto = UtilSql.getValue(result, "mailto");
        objectAlertProcessData.mailfrom = UtilSql.getValue(result, "mailfrom");
        objectAlertProcessData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectAlertProcessData.isfixed = UtilSql.getValue(result, "isfixed");
        objectAlertProcessData.fixed = UtilSql.getValue(result, "fixed");
        objectAlertProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAlertProcessData);
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
    AlertProcessData objectAlertProcessData[] = new AlertProcessData[vector.size()];
    vector.copyInto(objectAlertProcessData);
    return(objectAlertProcessData);
  }

  public static AlertProcessData[] selectAlert(ConnectionProvider connectionProvider, String sql)    throws ServletException {
    return selectAlert(connectionProvider, sql, 0, 0);
  }

  public static AlertProcessData[] selectAlert(ConnectionProvider connectionProvider, String sql, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT * " +
      "            FROM (";
    strSql = strSql + ((sql==null || sql.equals(""))?"":sql);
    strSql = strSql + 
      ") AAA ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (sql != null && !(sql.equals(""))) {
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
        AlertProcessData objectAlertProcessData = new AlertProcessData();
        objectAlertProcessData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAlertProcessData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAlertProcessData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectAlertProcessData.createdby = UtilSql.getValue(result, "createdby");
        objectAlertProcessData.updated = UtilSql.getValue(result, "updated");
        objectAlertProcessData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAlertProcessData.recordId = UtilSql.getValue(result, "record_id");
        objectAlertProcessData.referencekeyId = UtilSql.getValue(result, "referencekey_id");
        objectAlertProcessData.description = UtilSql.getValue(result, "description");
        objectAlertProcessData.isactive = UtilSql.getValue(result, "isactive");
        objectAlertProcessData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectAlertProcessData.adRoleId = UtilSql.getValue(result, "ad_role_id");
        objectAlertProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAlertProcessData);
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
    AlertProcessData objectAlertProcessData[] = new AlertProcessData[vector.size()];
    vector.copyInto(objectAlertProcessData);
    return(objectAlertProcessData);
  }

  public static int DeleteWhenNotFixed(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		DELETE FROM ad_alert using ad_alertrule where ad_alert.isfixed='N' AND ad_alert.ad_alertrule_id=ad_alertrule.ad_alertrule_id and ad_alertrule.fixed='N'";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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

  public static String existsReference(ConnectionProvider connectionProvider, String alertRule, String ref)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT COUNT(*) AS EXISTING" +
      "            FROM AD_ALERT" +
      "           WHERE AD_ALERTRULE_ID = ?" +
      "             AND REFERENCEKEY_ID = ?" +
      "             AND ISACTIVE = 'Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alertRule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ref);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "existing");
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

  public static AlertProcessData[] selectSQL(ConnectionProvider connectionProvider)    throws ServletException {
    return selectSQL(connectionProvider, 0, 0);
  }

  public static AlertProcessData[] selectSQL(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ALERTRULE_ID, SQL, NAME" +
      "          FROM AD_ALERTRULE" +
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
        AlertProcessData objectAlertProcessData = new AlertProcessData();
        objectAlertProcessData.adAlertruleId = UtilSql.getValue(result, "ad_alertrule_id");
        objectAlertProcessData.sql = UtilSql.getValue(result, "sql");
        objectAlertProcessData.name = UtilSql.getValue(result, "name");
        objectAlertProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAlertProcessData);
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
    AlertProcessData objectAlertProcessData[] = new AlertProcessData[vector.size()];
    vector.copyInto(objectAlertProcessData);
    return(objectAlertProcessData);
  }

  public static int InsertAlert(ConnectionProvider connectionProvider, String alertId, String clientId, String orgId, String created, String createdBy, String ruleId, String recordId, String referenceKey, String description, String user, String role)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO AD_ALERT" +
      "        (AD_ALERT_ID, AD_CLIENT_ID, AD_ORG_ID,                                                                                                                                                                                    " +
      "         ISACTIVE, CREATED, CREATEDBY, " +
      "         UPDATED, UPDATEDBY, " +
      "         AD_ALERTRULE_ID, RECORD_ID, REFERENCEKEY_ID, " +
      "         DESCRIPTION, AD_USER_ID, AD_ROLE_ID)" +
      "        VALUES" +
      "         (?,?,?," +
      "          'Y',TO_DATE(?),?," +
      "          now(),0," +
      "          ?,?,?," +
      "          ?,?,?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alertId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, created);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ruleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recordId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceKey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, role);

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

  public static int updateAlert(ConnectionProvider connectionProvider, String alertRuleId, String sql)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_ALERT" +
      "           SET ISACTIVE  = 'N'," +
      "               UPDATED   = NOW()," +
      "               UPDATEDBY = 0 " +
      "         WHERE AD_ALERTRULE_ID = ?" +
      "           AND ISACTIVE = 'Y'" +
      "           AND NOT EXISTS " +
      "                   (SELECT 1 FROM (";
    strSql = strSql + ((sql==null || sql.equals(""))?"":sql);
    strSql = strSql + 
      ") A WHERE 1=1" +
      "                              AND A.REFERENCEKEY_ID = AD_ALERT.REFERENCEKEY_ID)" +
      "           AND ((select deactvatewhennotapplied from AD_ALERTRULE where AD_ALERTRULE_ID = ?)='Y')";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alertRuleId);
      if (sql != null && !(sql.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alertRuleId);

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

  public static AlertProcessData[] prepareMails(ConnectionProvider connectionProvider, String alertRuleId, String alertId, String adUserId)    throws ServletException {
    return prepareMails(connectionProvider, alertRuleId, alertId, adUserId, 0, 0);
  }

  public static AlertProcessData[] prepareMails(ConnectionProvider connectionProvider, String alertRuleId, String alertId, String adUserId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT C.SMTPHOST," +
      "                 REQUESTUSER," +
      "                 REQUESTUSERPW," +
      "                 C.REQUESTEMAIL AS MAILFROM," +
      "                 U.EMAIL AS MAILTO," +
      "                 A.DESCRIPTION as DESCRIPTION," +
      "                 A.RECORD_ID as RECORD_ID," +
      "                 C.AD_LANGUAGE" +
      "            FROM AD_ALERTRECIPIENT R," +
      "                 AD_USER U," +
      "                 AD_CLIENT C," +
      "                 AD_ALERT A" +
      "           WHERE R.AD_ALERTRULE_ID = ?" +
      "             AND SENDEMAIL = 'Y'" +
      "             AND A.AD_ALERTRULE_ID=?" +
      "             AND R.AD_USER_ID = U.AD_USER_ID" +
      "             AND C.AD_CLIENT_ID = U.AD_CLIENT_ID" +
      "             AND A.AD_ALERT_ID= ? " +
      "           UNION" +
      "           SELECT C.SMTPHOST," +
      "                 REQUESTUSER," +
      "                 REQUESTUSERPW," +
      "                 C.REQUESTEMAIL AS MAILFROM," +
      "                 U.EMAIL AS MAILTO," +
      "                 A.DESCRIPTION as DESCRIPTION," +
      "                 A.RECORD_ID as RECORD_ID," +
      "                 C.AD_LANGUAGE" +
      "            FROM AD_ALERTRULE R," +
      "                 AD_USER U," +
      "                 AD_CLIENT C," +
      "                 AD_ALERT A" +
      "           WHERE R.AD_ALERTRULE_ID = ?" +
      "             AND R.sendemailtouser = 'Y'" +
      "             AND A.AD_ALERTRULE_ID=R.AD_ALERTRULE_ID " +
      "             AND A.AD_USER_ID = U.AD_USER_ID" +
      "             AND U.AD_USER_ID = ?" +
      "             AND C.AD_CLIENT_ID = U.AD_CLIENT_ID" +
      "             AND A.AD_ALERT_ID= ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alertRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alertRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alertId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alertRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alertId);

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
        AlertProcessData objectAlertProcessData = new AlertProcessData();
        objectAlertProcessData.smtphost = UtilSql.getValue(result, "smtphost");
        objectAlertProcessData.requestuser = UtilSql.getValue(result, "requestuser");
        objectAlertProcessData.requestuserpw = UtilSql.getValue(result, "requestuserpw");
        objectAlertProcessData.mailfrom = UtilSql.getValue(result, "mailfrom");
        objectAlertProcessData.mailto = UtilSql.getValue(result, "mailto");
        objectAlertProcessData.description = UtilSql.getValue(result, "description");
        objectAlertProcessData.recordId = UtilSql.getValue(result, "record_id");
        objectAlertProcessData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectAlertProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAlertProcessData);
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
    AlertProcessData objectAlertProcessData[] = new AlertProcessData[vector.size()];
    vector.copyInto(objectAlertProcessData);
    return(objectAlertProcessData);
  }
}
