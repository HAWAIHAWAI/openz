//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ShowSessionData implements FieldProvider {
static Logger log4j = Logger.getLogger(ShowSessionData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ShowSessionData[] select(ConnectionProvider connectionProvider, String windows)    throws ServletException {
    return select(connectionProvider, windows, 0, 0);
  }

  public static ShowSessionData[] select(ConnectionProvider connectionProvider, String windows, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_WINDOW_ID AS ID, NAME FROM AD_WINDOW WHERE ISACTIVE='Y' ";
    strSql = strSql + ((windows==null || windows.equals(""))?"":" AND AD_WINDOW.AD_WINDOW_ID IN " + windows);
    strSql = strSql + 
      "      ORDER BY NAME";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (windows != null && !(windows.equals(""))) {
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
        ShowSessionData objectShowSessionData = new ShowSessionData();
        objectShowSessionData.id = UtilSql.getValue(result, "id");
        objectShowSessionData.name = UtilSql.getValue(result, "name");
        objectShowSessionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectShowSessionData);
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
    ShowSessionData objectShowSessionData[] = new ShowSessionData[vector.size()];
    vector.copyInto(objectShowSessionData);
    return(objectShowSessionData);
  }

  public static ShowSessionData[] selectTrl(ConnectionProvider connectionProvider, String windows, String adLanguage)    throws ServletException {
    return selectTrl(connectionProvider, windows, adLanguage, 0, 0);
  }

  public static ShowSessionData[] selectTrl(ConnectionProvider connectionProvider, String windows, String adLanguage, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_WINDOW.AD_WINDOW_ID AS ID, (case when AD_WINDOW_TRL.NAME IS NULL then AD_WINDOW.NAME else AD_WINDOW_TRL.NAME end) AS NAME " +
      "      FROM AD_WINDOW, AD_WINDOW_TRL " +
      "      WHERE AD_WINDOW.ISACTIVE='Y' ";
    strSql = strSql + ((windows==null || windows.equals(""))?"":" AND AD_WINDOW.AD_WINDOW_ID IN " + windows);
    strSql = strSql + 
      "      AND AD_WINDOW.AD_WINDOW_ID = AD_WINDOW_TRL.AD_WINDOW_ID" +
      "      AND AD_WINDOW_TRL.AD_LANGUAGE = ? " +
      "      ORDER BY 2";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (windows != null && !(windows.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);

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
        ShowSessionData objectShowSessionData = new ShowSessionData();
        objectShowSessionData.id = UtilSql.getValue(result, "id");
        objectShowSessionData.name = UtilSql.getValue(result, "name");
        objectShowSessionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectShowSessionData);
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
    ShowSessionData objectShowSessionData[] = new ShowSessionData[vector.size()];
    vector.copyInto(objectShowSessionData);
    return(objectShowSessionData);
  }
}
