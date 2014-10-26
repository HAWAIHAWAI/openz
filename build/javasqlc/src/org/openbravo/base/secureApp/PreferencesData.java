//Sqlc generated V1.O00-1
package org.openbravo.base.secureApp;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class PreferencesData implements FieldProvider {
static Logger log4j = Logger.getLogger(PreferencesData.class);
  private String InitRecordNumber="0";
  public String attribute;
  public String value;
  public String adWindowId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("attribute"))
      return attribute;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("ad_window_id") || fieldName.equals("adWindowId"))
      return adWindowId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PreferencesData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static PreferencesData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT '' as Attribute, '' as Value, '' as AD_Window_ID " +
      "      FROM dual";

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
        PreferencesData objectPreferencesData = new PreferencesData();
        objectPreferencesData.attribute = UtilSql.getValue(result, "attribute");
        objectPreferencesData.value = UtilSql.getValue(result, "value");
        objectPreferencesData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectPreferencesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPreferencesData);
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
    PreferencesData objectPreferencesData[] = new PreferencesData[vector.size()];
    vector.copyInto(objectPreferencesData);
    return(objectPreferencesData);
  }

  public static PreferencesData[] selectAttributes(ConnectionProvider connectionProvider, String clientlist, String orglist, String adUserId)    throws ServletException {
    return selectAttributes(connectionProvider, clientlist, orglist, adUserId, 0, 0);
  }

  public static PreferencesData[] selectAttributes(ConnectionProvider connectionProvider, String clientlist, String orglist, String adUserId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT Attribute, Value, AD_Window_ID " +
      "        FROM AD_Preference " +
      "        WHERE AD_CLIENT_ID IN (";
    strSql = strSql + ((clientlist==null || clientlist.equals(""))?"":clientlist);
    strSql = strSql + 
      ") " +
      "        AND AD_ORG_ID IN (";
    strSql = strSql + ((orglist==null || orglist.equals(""))?"":orglist);
    strSql = strSql + 
      ") " +
      "        AND ((AD_User_ID IS NULL AND isglobal='Y')  OR AD_User_ID=?)" +
      "        AND IsActive='Y'  " +
      "        ORDER BY Attribute, AD_Client_ID, AD_Org_ID, AD_User_ID";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (clientlist != null && !(clientlist.equals(""))) {
        }
      if (orglist != null && !(orglist.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

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
        PreferencesData objectPreferencesData = new PreferencesData();
        objectPreferencesData.attribute = UtilSql.getValue(result, "attribute");
        objectPreferencesData.value = UtilSql.getValue(result, "value");
        objectPreferencesData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectPreferencesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPreferencesData);
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
    PreferencesData objectPreferencesData[] = new PreferencesData[vector.size()];
    vector.copyInto(objectPreferencesData);
    return(objectPreferencesData);
  }

  public static PreferencesData[] selectRoleAttributes(ConnectionProvider connectionProvider, String clientlist, String orglist, String adRoleId)    throws ServletException {
    return selectRoleAttributes(connectionProvider, clientlist, orglist, adRoleId, 0, 0);
  }

  public static PreferencesData[] selectRoleAttributes(ConnectionProvider connectionProvider, String clientlist, String orglist, String adRoleId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT p.Attribute, p.Value, p.AD_Window_ID " +
      "        FROM AD_Preference p, ad_preference_access pa" +
      "        WHERE pa.AD_CLIENT_ID IN (";
    strSql = strSql + ((clientlist==null || clientlist.equals(""))?"":clientlist);
    strSql = strSql + 
      ") " +
      "        AND pa.AD_ORG_ID IN (";
    strSql = strSql + ((orglist==null || orglist.equals(""))?"":orglist);
    strSql = strSql + 
      ") " +
      "        AND pa.IsActive='Y' " +
      "        AND p.IsActive='Y'" +
      "        AND p.AD_Preference_id=pa.AD_Preference_id" +
      "        AND pa.ad_role_id=?" +
      "        ORDER BY p.Attribute, p.AD_Client_ID, p.AD_Org_ID";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (clientlist != null && !(clientlist.equals(""))) {
        }
      if (orglist != null && !(orglist.equals(""))) {
        }
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
        PreferencesData objectPreferencesData = new PreferencesData();
        objectPreferencesData.attribute = UtilSql.getValue(result, "attribute");
        objectPreferencesData.value = UtilSql.getValue(result, "value");
        objectPreferencesData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectPreferencesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPreferencesData);
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
    PreferencesData objectPreferencesData[] = new PreferencesData[vector.size()];
    vector.copyInto(objectPreferencesData);
    return(objectPreferencesData);
  }
}
