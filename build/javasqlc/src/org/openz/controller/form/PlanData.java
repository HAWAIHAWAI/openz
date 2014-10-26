//Sqlc generated V1.O00-1
package org.openz.controller.form;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class PlanData implements FieldProvider {
static Logger log4j = Logger.getLogger(PlanData.class);
  private String InitRecordNumber="0";
  public String datefrom;
  public String dateto;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("dateto"))
      return dateto;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PlanData[] init(ConnectionProvider connectionProvider)    throws ServletException {
    return init(connectionProvider, 0, 0);
  }

  public static PlanData[] init(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     SELECT '' as DateFrom, '' as DateTo from dual";

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
        PlanData objectPlanData = new PlanData();
        objectPlanData.datefrom = UtilSql.getValue(result, "datefrom");
        objectPlanData.dateto = UtilSql.getValue(result, "dateto");
        objectPlanData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPlanData);
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
    PlanData objectPlanData[] = new PlanData[vector.size()];
    vector.copyInto(objectPlanData);
    return(objectPlanData);
  }

  public static String createPlan(ConnectionProvider connectionProvider, String DateFrom, String format, String DateTo, String Org, String PlanOrCotract)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zssi_resourceplan_wdfix(to_timestamp(?,?)::timestamp without time zone,to_timestamp(?,?)::timestamp without time zone,?,?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, format);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, format);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, PlanOrCotract);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zssi_resourceplan_wdfix");
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

  public static String createPlanSmall(ConnectionProvider connectionProvider, String DateFrom, String format, String DateTo, String Org, String PlanOrCotract, String withmachines, String Project)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zssi_resourceplan_wdfix_small(to_timestamp(?,?)::timestamp without time zone,to_timestamp(?,?)::timestamp without time zone,?,?,?,?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, format);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, format);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, PlanOrCotract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, withmachines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Project);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zssi_resourceplan_wdfix_small");
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

  public static String RefreshInterval(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT coalesce(value,'0') AS refreshintervall" +
      "        FROM AD_PREFERENCE" +
      "        WHERE  attribute= 'REFRESHINTERVAL' ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "refreshintervall");
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
