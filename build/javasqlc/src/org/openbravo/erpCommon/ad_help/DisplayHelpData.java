//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_help;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class DisplayHelpData implements FieldProvider {
static Logger log4j = Logger.getLogger(DisplayHelpData.class);
  private String InitRecordNumber="0";
  public String tabid;
  public String tabname;
  public String tabhelp;
  public String tabhelpname;
  public String tabidname;
  public String fieldid;
  public String fieldname;
  public String fieldhelp;
  public String fieldhelpname;
  public String fieldidname;
  public String name;
  public String help;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("tabid"))
      return tabid;
    else if (fieldName.equalsIgnoreCase("tabname"))
      return tabname;
    else if (fieldName.equalsIgnoreCase("tabhelp"))
      return tabhelp;
    else if (fieldName.equalsIgnoreCase("tabhelpname"))
      return tabhelpname;
    else if (fieldName.equalsIgnoreCase("tabidname"))
      return tabidname;
    else if (fieldName.equalsIgnoreCase("fieldid"))
      return fieldid;
    else if (fieldName.equalsIgnoreCase("fieldname"))
      return fieldname;
    else if (fieldName.equalsIgnoreCase("fieldhelp"))
      return fieldhelp;
    else if (fieldName.equalsIgnoreCase("fieldhelpname"))
      return fieldhelpname;
    else if (fieldName.equalsIgnoreCase("fieldidname"))
      return fieldidname;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DisplayHelpData[] select(ConnectionProvider connectionProvider, String windowId)    throws ServletException {
    return select(connectionProvider, windowId, 0, 0);
  }

  public static DisplayHelpData[] select(ConnectionProvider connectionProvider, String windowId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT AD_TAB.ad_tab_id AS tabid, AD_TAB.NAME AS tabname, AD_TAB.HELP AS tabhelp, ('paramTabHelp' || AD_TAB.AD_TAB_ID) AS tabhelpname," +
      "          ('paramTabName' || AD_TAB.AD_TAB_ID) AS tabidname, " +
      "          AD_FIELD.ad_field_id AS fieldid, AD_FIELD.NAME AS fieldname, AD_FIELD.HELP AS fieldhelp, ('paramFieldHelp' || AD_FIELD.AD_FIELD_ID) AS fieldhelpname," +
      "          ('paramFieldName' || AD_FIELD.AD_FIELD_ID) AS fieldidname, '' AS NAME, '' AS HELP" +
      "          FROM AD_TAB, AD_FIELD" +
      "          WHERE AD_TAB.ad_tab_id = AD_FIELD.ad_tab_id" +
      "          AND AD_TAB.isactive='Y'" +
      "          AND AD_FIELD.isactive = 'Y'" +
      "          AND AD_FIELD.ISDISPLAYED = 'Y'" +
      "          AND AD_TAB.ad_window_id = ? " +
      "          ORDER BY AD_TAB.seqno, AD_TAB.AD_TAB_ID, AD_FIELD.SEQNO, AD_FIELD.AD_FIELD_ID";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);

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
        DisplayHelpData objectDisplayHelpData = new DisplayHelpData();
        objectDisplayHelpData.tabid = UtilSql.getValue(result, "tabid");
        objectDisplayHelpData.tabname = UtilSql.getValue(result, "tabname");
        objectDisplayHelpData.tabhelp = UtilSql.getValue(result, "tabhelp");
        objectDisplayHelpData.tabhelpname = UtilSql.getValue(result, "tabhelpname");
        objectDisplayHelpData.tabidname = UtilSql.getValue(result, "tabidname");
        objectDisplayHelpData.fieldid = UtilSql.getValue(result, "fieldid");
        objectDisplayHelpData.fieldname = UtilSql.getValue(result, "fieldname");
        objectDisplayHelpData.fieldhelp = UtilSql.getValue(result, "fieldhelp");
        objectDisplayHelpData.fieldhelpname = UtilSql.getValue(result, "fieldhelpname");
        objectDisplayHelpData.fieldidname = UtilSql.getValue(result, "fieldidname");
        objectDisplayHelpData.name = UtilSql.getValue(result, "name");
        objectDisplayHelpData.help = UtilSql.getValue(result, "help");
        objectDisplayHelpData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDisplayHelpData);
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
    DisplayHelpData objectDisplayHelpData[] = new DisplayHelpData[vector.size()];
    vector.copyInto(objectDisplayHelpData);
    return(objectDisplayHelpData);
  }

  public static DisplayHelpData[] selectTrl(ConnectionProvider connectionProvider, String adLanguage, String windowId)    throws ServletException {
    return selectTrl(connectionProvider, adLanguage, windowId, 0, 0);
  }

  public static DisplayHelpData[] selectTrl(ConnectionProvider connectionProvider, String adLanguage, String windowId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TAB.ad_tab_id AS tabid, " +
      "        (CASE WHEN AD_TAB_TRL.NAME IS NULL THEN '*' || AD_TAB.NAME ELSE AD_TAB_TRL.NAME END) AS tabname, " +
      "        (CASE WHEN AD_TAB_TRL.HELP IS NULL THEN (CASE WHEN AD_TAB.HELP IS NOT NULL THEN '*' END) || AD_TAB.HELP ELSE AD_TAB_TRL.HELP END) AS tabhelp, " +
      "        ('paramTabHelp' || AD_TAB.AD_TAB_ID) AS tabhelpname, ('paramTabName' || AD_TAB.AD_TAB_ID) AS tabidname, " +
      "        AD_FIELD.ad_field_id AS fieldid, (CASE WHEN AD_FIELD_TRL.NAME IS NULL THEN '*' || AD_FIELD.NAME ELSE AD_FIELD_TRL.NAME END) AS fieldname, " +
      "        (CASE WHEN AD_FIELD_TRL.HELP IS NULL THEN (CASE WHEN AD_FIELD.HELP IS NOT NULL THEN '*' END) || AD_FIELD.HELP ELSE AD_FIELD_TRL.HELP END) AS fieldhelp, " +
      "        ('paramFieldHelp' || AD_FIELD.AD_FIELD_ID) AS fieldhelpname, ('paramFieldName' || AD_FIELD.AD_FIELD_ID) AS fieldidname " +
      "        FROM AD_TAB left join AD_TAB_TRL on AD_TAB.AD_TAB_ID = AD_TAB_TRL.AD_TAB_ID" +
      "                                        and AD_TAB_TRL.AD_LANGUAGE = ?,                     " +
      "             AD_FIELD left join AD_FIELD_TRL on AD_FIELD.AD_FIELD_ID = AD_FIELD_TRL.AD_FIELD_ID" +
      "                                        and AD_FIELD_TRL.AD_LANGUAGE = ?" +
      "        WHERE AD_TAB.ad_tab_id = AD_FIELD.ad_tab_id" +
      "        AND AD_TAB.isactive='Y'" +
      "        AND AD_FIELD.isactive = 'Y'" +
      "        AND AD_FIELD.ISDISPLAYED = 'Y'" +
      "        AND AD_TAB.ad_window_id = ? " +
      "        ORDER BY AD_TAB.seqno, AD_TAB.AD_TAB_ID, AD_FIELD.SEQNO, AD_FIELD.AD_FIELD_ID";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);

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
        DisplayHelpData objectDisplayHelpData = new DisplayHelpData();
        objectDisplayHelpData.tabid = UtilSql.getValue(result, "tabid");
        objectDisplayHelpData.tabname = UtilSql.getValue(result, "tabname");
        objectDisplayHelpData.tabhelp = UtilSql.getValue(result, "tabhelp");
        objectDisplayHelpData.tabhelpname = UtilSql.getValue(result, "tabhelpname");
        objectDisplayHelpData.tabidname = UtilSql.getValue(result, "tabidname");
        objectDisplayHelpData.fieldid = UtilSql.getValue(result, "fieldid");
        objectDisplayHelpData.fieldname = UtilSql.getValue(result, "fieldname");
        objectDisplayHelpData.fieldhelp = UtilSql.getValue(result, "fieldhelp");
        objectDisplayHelpData.fieldhelpname = UtilSql.getValue(result, "fieldhelpname");
        objectDisplayHelpData.fieldidname = UtilSql.getValue(result, "fieldidname");
        objectDisplayHelpData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDisplayHelpData);
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
    DisplayHelpData objectDisplayHelpData[] = new DisplayHelpData[vector.size()];
    vector.copyInto(objectDisplayHelpData);
    return(objectDisplayHelpData);
  }

  public static DisplayHelpData[] set()    throws ServletException {
    DisplayHelpData objectDisplayHelpData[] = new DisplayHelpData[1];
    objectDisplayHelpData[0] = new DisplayHelpData();
    objectDisplayHelpData[0].tabid = "";
    objectDisplayHelpData[0].tabname = "";
    objectDisplayHelpData[0].tabhelp = "";
    objectDisplayHelpData[0].tabhelpname = "";
    objectDisplayHelpData[0].tabidname = "";
    objectDisplayHelpData[0].fieldid = "";
    objectDisplayHelpData[0].fieldname = "";
    objectDisplayHelpData[0].fieldhelp = "";
    objectDisplayHelpData[0].fieldhelpname = "";
    objectDisplayHelpData[0].fieldidname = "";
    return objectDisplayHelpData;
  }

  public static String windowName(ConnectionProvider connectionProvider, String windowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME FROM AD_WINDOW WHERE AD_WINDOW_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);

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

  public static String windowNameTrl(ConnectionProvider connectionProvider, String adLanguage, String windowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (CASE WHEN AD_WINDOW_TRL.NAME IS NULL THEN '*' || AD_WINDOW.NAME ELSE AD_WINDOW_TRL.NAME END) AS NAME" +
      "        FROM AD_WINDOW left join AD_WINDOW_TRL on AD_WINDOW.AD_WINDOW_ID = AD_WINDOW_TRL.AD_WINDOW_ID " +
      "                                              AND AD_WINDOW_TRL.AD_LANGUAGE =?" +
      "        WHERE AD_WINDOW.AD_WINDOW_ID = ? " +
      "        AND AD_WINDOW.ISACTIVE = 'Y'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);

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

  public static String windowHelp(ConnectionProvider connectionProvider, String windowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT HELP FROM AD_WINDOW WHERE AD_WINDOW_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "help");
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

  public static DisplayHelpData[] selectForm(ConnectionProvider connectionProvider, String formName)    throws ServletException {
    return selectForm(connectionProvider, formName, 0, 0);
  }

  public static DisplayHelpData[] selectForm(ConnectionProvider connectionProvider, String formName, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME, HELP" +
      "        FROM AD_FORM" +
      "        WHERE AD_FORM_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, formName);

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
        DisplayHelpData objectDisplayHelpData = new DisplayHelpData();
        objectDisplayHelpData.name = UtilSql.getValue(result, "name");
        objectDisplayHelpData.help = UtilSql.getValue(result, "help");
        objectDisplayHelpData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDisplayHelpData);
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
    DisplayHelpData objectDisplayHelpData[] = new DisplayHelpData[vector.size()];
    vector.copyInto(objectDisplayHelpData);
    return(objectDisplayHelpData);
  }

  public static DisplayHelpData[] selectFormTrl(ConnectionProvider connectionProvider, String adLanguage, String formName)    throws ServletException {
    return selectFormTrl(connectionProvider, adLanguage, formName, 0, 0);
  }

  public static DisplayHelpData[] selectFormTrl(ConnectionProvider connectionProvider, String adLanguage, String formName, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (CASE WHEN AD_FORM_TRL.NAME IS NULL THEN '***' || AD_FORM.NAME ELSE AD_FORM_TRL.NAME END) AS NAME," +
      "               (CASE WHEN AD_FORM_TRL.HELP IS NULL THEN '***' || AD_FORM.HELP ELSE AD_FORM_TRL.HELP END) AS HELP" +
      "        FROM AD_FORM left join AD_FORM_TRL on AD_FORM.AD_FORM_ID = AD_FORM_TRL.AD_FORM_ID " +
      "                                              AND AD_FORM_TRL.AD_LANGUAGE =?" +
      "        WHERE AD_FORM.AD_FORM_ID = ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, formName);

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
        DisplayHelpData objectDisplayHelpData = new DisplayHelpData();
        objectDisplayHelpData.name = UtilSql.getValue(result, "name");
        objectDisplayHelpData.help = UtilSql.getValue(result, "help");
        objectDisplayHelpData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDisplayHelpData);
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
    DisplayHelpData objectDisplayHelpData[] = new DisplayHelpData[vector.size()];
    vector.copyInto(objectDisplayHelpData);
    return(objectDisplayHelpData);
  }

  public static DisplayHelpData[] selectProcess(ConnectionProvider connectionProvider, String processName)    throws ServletException {
    return selectProcess(connectionProvider, processName, 0, 0);
  }

  public static DisplayHelpData[] selectProcess(ConnectionProvider connectionProvider, String processName, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME, HELP" +
      "        FROM AD_PROCESS" +
      "        WHERE AD_PROCESS_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processName);

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
        DisplayHelpData objectDisplayHelpData = new DisplayHelpData();
        objectDisplayHelpData.name = UtilSql.getValue(result, "name");
        objectDisplayHelpData.help = UtilSql.getValue(result, "help");
        objectDisplayHelpData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDisplayHelpData);
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
    DisplayHelpData objectDisplayHelpData[] = new DisplayHelpData[vector.size()];
    vector.copyInto(objectDisplayHelpData);
    return(objectDisplayHelpData);
  }

  public static DisplayHelpData[] selectProcessTrl(ConnectionProvider connectionProvider, String adLanguage, String processName)    throws ServletException {
    return selectProcessTrl(connectionProvider, adLanguage, processName, 0, 0);
  }

  public static DisplayHelpData[] selectProcessTrl(ConnectionProvider connectionProvider, String adLanguage, String processName, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (CASE WHEN AD_PROCESS_TRL.NAME IS NULL THEN '***' || AD_PROCESS.NAME ELSE AD_PROCESS_TRL.NAME END) AS NAME," +
      "               (CASE WHEN AD_PROCESS_TRL.HELP IS NULL THEN '***' || AD_PROCESS.HELP ELSE AD_PROCESS_TRL.HELP END) AS HELP" +
      "        FROM AD_PROCESS left join AD_PROCESS_TRL on AD_PROCESS.AD_PROCESS_ID = AD_PROCESS_TRL.AD_PROCESS_ID " +
      "                                                    AND AD_PROCESS_TRL.AD_LANGUAGE =?" +
      "        WHERE AD_PROCESS.AD_PROCESS_ID = ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processName);

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
        DisplayHelpData objectDisplayHelpData = new DisplayHelpData();
        objectDisplayHelpData.name = UtilSql.getValue(result, "name");
        objectDisplayHelpData.help = UtilSql.getValue(result, "help");
        objectDisplayHelpData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDisplayHelpData);
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
    DisplayHelpData objectDisplayHelpData[] = new DisplayHelpData[vector.size()];
    vector.copyInto(objectDisplayHelpData);
    return(objectDisplayHelpData);
  }

  public static String windowHelpTrl(ConnectionProvider connectionProvider, String windowId, String adLanguage)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (CASE WHEN AD_WINDOW_TRL.HELP IS NULL THEN (CASE WHEN AD_WINDOW.HELP IS NOT NULL THEN '*' END) || AD_WINDOW.HELP ELSE AD_WINDOW_TRL.HELP END) AS HELP " +
      "        FROM AD_WINDOW left join AD_WINDOW_TRL on AD_WINDOW.AD_WINDOW_ID = AD_WINDOW_TRL.AD_WINDOW_ID" +
      "                                              and AD_WINDOW_TRL.AD_LANGUAGE = ?" +
      "        WHERE AD_WINDOW.AD_WINDOW_ID = ? " +
      "        AND AD_WINDOW.ISACTIVE = 'Y'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "help");
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
