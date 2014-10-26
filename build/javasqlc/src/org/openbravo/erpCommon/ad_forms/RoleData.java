//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class RoleData implements FieldProvider {
static Logger log4j = Logger.getLogger(RoleData.class);
  private String InitRecordNumber="0";
  public String organization;
  public String client;
  public String role;
  public String password;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("organization"))
      return organization;
    else if (fieldName.equalsIgnoreCase("client"))
      return client;
    else if (fieldName.equalsIgnoreCase("role"))
      return role;
    else if (fieldName.equalsIgnoreCase("password"))
      return password;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RoleData[] select(ConnectionProvider connectionProvider, String adRoleId)    throws ServletException {
    return select(connectionProvider, adRoleId, 0, 0);
  }

  public static RoleData[] select(ConnectionProvider connectionProvider, String adRoleId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG.NAME AS ORGANIZATION, AD_CLIENT.NAME AS CLIENT, AD_ROLE.NAME AS ROLE, '' as password" +
      "        FROM AD_ROLE_ORGACCESS, AD_ORG, AD_CLIENT, AD_ROLE" +
      "        WHERE AD_ROLE_ORGACCESS.AD_ROLE_ID = ?" +
      "        AND AD_ROLE_ORGACCESS.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "        AND AD_ORG.AD_CLIENT_ID = AD_CLIENT.AD_CLIENT_ID" +
      "        AND AD_ROLE.AD_ROLE_ID = AD_ROLE_ORGACCESS.AD_ROLE_ID";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);

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
        RoleData objectRoleData = new RoleData();
        objectRoleData.organization = UtilSql.getValue(result, "organization");
        objectRoleData.client = UtilSql.getValue(result, "client");
        objectRoleData.role = UtilSql.getValue(result, "role");
        objectRoleData.password = UtilSql.getValue(result, "password");
        objectRoleData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRoleData);
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
    RoleData objectRoleData[] = new RoleData[vector.size()];
    vector.copyInto(objectRoleData);
    return(objectRoleData);
  }

  public static String nombreUsuario(ConnectionProvider connectionProvider, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME FROM AD_USER WHERE AD_USER_ID=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

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

  public static RoleData[] validPassword(ConnectionProvider connectionProvider, String adUserId, String password)    throws ServletException {
    return validPassword(connectionProvider, adUserId, password, 0, 0);
  }

  public static RoleData[] validPassword(ConnectionProvider connectionProvider, String adUserId, String password, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) AS ROLE FROM AD_USER " +
      "        WHERE AD_USER_ID = ? " +
      "        AND PASSWORD = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, password);

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
        RoleData objectRoleData = new RoleData();
        objectRoleData.role = UtilSql.getValue(result, "role");
        objectRoleData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRoleData);
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
    RoleData objectRoleData[] = new RoleData[vector.size()];
    vector.copyInto(objectRoleData);
    return(objectRoleData);
  }

  public static String isPasswordUpdateAllowed(ConnectionProvider connectionProvider, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT coalesce(value,'Y') AS isPasswordUpdateAllowed" +
      "        FROM AD_PREFERENCE" +
      "        WHERE  attribute= 'isPasswordUpdateAllowed' and AD_USER_ID = ? ";

    ResultSet result;
    String strReturn = "Y";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ispasswordupdateallowed");
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

  public static String getPassword(ConnectionProvider connectionProvider, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PASSWORD AS password " +
      "        FROM AD_USER " +
      "        WHERE   AD_USER_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "password");
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

  public static int update(ConnectionProvider connectionProvider, String password, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_USER SET PASSWORD = ?, UPDATED=now(), UPDATEDBY = ? WHERE AD_USER_ID = ? AND USERNAME!='test'";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, password);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

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

  public static String getIsRTL(ConnectionProvider connectionProvider, String adLanguage)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT ISRTL" +
      "		FROM AD_LANGUAGE" +
      "		WHERE AD_LANGUAGE = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "isrtl");
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

  public static int saveDefaultOptions(ConnectionProvider connectionProvider, String adlanguage, String adroleid, String adclientid, String adorgid, String mwarehouseid, String aduserid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_USER SET " +
      "            DEFAULT_AD_LANGUAGE = ?," +
      "            DEFAULT_AD_ROLE_ID = ?," +
      "            DEFAULT_AD_CLIENT_ID = ?," +
      "            DEFAULT_AD_ORG_ID = ?," +
      "            DEFAULT_M_WAREHOUSE_ID = ?" +
      "        WHERE AD_USER_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adlanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adroleid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adclientid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adorgid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mwarehouseid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aduserid);

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
}
