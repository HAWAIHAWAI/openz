//Sqlc generated V1.O00-1
package org.openbravo.wad;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;
import org.openbravo.database.RDBMSIndependent;
import org.openbravo.exception.*;

class WadData implements FieldProvider {
static Logger log4j = Logger.getLogger(WadData.class);
  private String InitRecordNumber="0";
  public String name;
  public String classname;
  public String displayname;
  public String loadonstartup;
  public String value;
  public String line;
  public String auth;
  public String buildxml;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("classname"))
      return classname;
    else if (fieldName.equalsIgnoreCase("displayname"))
      return displayname;
    else if (fieldName.equalsIgnoreCase("loadonstartup"))
      return loadonstartup;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("auth"))
      return auth;
    else if (fieldName.equalsIgnoreCase("buildxml"))
      return buildxml;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Names of the columns of the fields of a tab
 */
  public static WadData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

/**
Names of the columns of the fields of a tab
 */
  public static WadData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT MAX(COALESCE(ACTION, '') || AD_MODEL_OBJECT_ID) AS NAME, CLASSNAME, CLASSNAME AS DISPLAYNAME, " +
      "      MAX(LOADONSTARTUP) AS LOADONSTARTUP, '' AS VALUE, '' AS LINE, '' AS AUTH, '' as buildxml" +
      "      FROM AD_MODEL_OBJECT " +
      "      WHERE ISACTIVE = 'Y' " +
      "      AND OBJECT_TYPE = 'S'" +
      "      GROUP BY CLASSNAME" +
      "      ORDER BY NAME";

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
        WadData objectWadData = new WadData();
        objectWadData.name = UtilSql.getValue(result, "name");
        objectWadData.classname = UtilSql.getValue(result, "classname");
        objectWadData.displayname = UtilSql.getValue(result, "displayname");
        objectWadData.loadonstartup = UtilSql.getValue(result, "loadonstartup");
        objectWadData.value = UtilSql.getValue(result, "value");
        objectWadData.line = UtilSql.getValue(result, "line");
        objectWadData.auth = UtilSql.getValue(result, "auth");
        objectWadData.buildxml = UtilSql.getValue(result, "buildxml");
        objectWadData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWadData);
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
    WadData objectWadData[] = new WadData[vector.size()];
    vector.copyInto(objectWadData);
    return(objectWadData);
  }

/**
Create a registry
 */
  public static WadData[] set()    throws ServletException {
    WadData objectWadData[] = new WadData[1];
    objectWadData[0] = new WadData();
    objectWadData[0].name = "";
    objectWadData[0].classname = "";
    objectWadData[0].displayname = "";
    objectWadData[0].loadonstartup = "";
    objectWadData[0].value = "";
    objectWadData[0].line = "";
    objectWadData[0].auth = "";
    objectWadData[0].buildxml = "";
    return objectWadData;
  }

/**
Names of the columns of the fields of a tab
 */
  public static WadData[] selectMapping(ConnectionProvider connectionProvider)    throws ServletException {
    return selectMapping(connectionProvider, 0, 0);
  }

/**
Names of the columns of the fields of a tab
 */
  public static WadData[] selectMapping(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT MAX(MO.ACTION || MO.AD_MODEL_OBJECT_ID) AS NAME, MOM.MAPPINGNAME AS CLASSNAME, MO.CLASSNAME AS DISPLAYNAME " +
      "      FROM AD_MODEL_OBJECT MO, AD_MODEL_OBJECT_MAPPING MOM" +
      "      WHERE MO.ISACTIVE = 'Y'" +
      "      AND MO.OBJECT_TYPE = 'S' " +
      "      AND MO.AD_MODEL_OBJECT_ID = MOM.AD_MODEL_OBJECT_ID " +
      "      AND MOM.ISACTIVE = 'Y' " +
      "      GROUP BY MO.CLASSNAME, MOM.MAPPINGNAME" +
      "      ORDER BY NAME";

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
        WadData objectWadData = new WadData();
        objectWadData.name = UtilSql.getValue(result, "name");
        objectWadData.classname = UtilSql.getValue(result, "classname");
        objectWadData.displayname = UtilSql.getValue(result, "displayname");
        objectWadData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWadData);
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
    WadData objectWadData[] = new WadData[vector.size()];
    vector.copyInto(objectWadData);
    return(objectWadData);
  }

/**
Names of the columns of the fields of a tab
 */
  public static WadData[] selectFilter(ConnectionProvider connectionProvider)    throws ServletException {
    return selectFilter(connectionProvider, 0, 0);
  }

/**
Names of the columns of the fields of a tab
 */
  public static WadData[] selectFilter(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT MAX(COALESCE(ACTION, '') || AD_MODEL_OBJECT_ID) AS NAME, CLASSNAME, CLASSNAME AS DISPLAYNAME" +
      "      FROM AD_MODEL_OBJECT " +
      "      WHERE ISACTIVE = 'Y' " +
      "      AND OBJECT_TYPE = 'F'" +
      "      GROUP BY SEQNO,CLASSNAME" +
      "      ORDER BY SEQNO,NAME";

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
        WadData objectWadData = new WadData();
        objectWadData.name = UtilSql.getValue(result, "name");
        objectWadData.classname = UtilSql.getValue(result, "classname");
        objectWadData.displayname = UtilSql.getValue(result, "displayname");
        objectWadData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWadData);
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
    WadData objectWadData[] = new WadData[vector.size()];
    vector.copyInto(objectWadData);
    return(objectWadData);
  }

/**
Names of the columns of the fields of a tab
 */
  public static WadData[] selectSessionTimeOut(ConnectionProvider connectionProvider)    throws ServletException {
    return selectSessionTimeOut(connectionProvider, 0, 0);
  }

/**
Names of the columns of the fields of a tab
 */
  public static WadData[] selectSessionTimeOut(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT P.VALUE" +
      "      FROM AD_MODEL_OBJECT O, AD_MODEL_OBJECT_PARA P" +
      "      WHERE O.ISACTIVE = 'Y' " +
      "      AND O.OBJECT_TYPE = 'ST'" +
      "      AND P.AD_MODEL_OBJECT_ID = O.AD_MODEL_OBJECT_ID" +
      "      AND UPPER(P.NAME) = 'TIMEOUT' ";

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
        WadData objectWadData = new WadData();
        objectWadData.value = UtilSql.getValue(result, "value");
        objectWadData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWadData);
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
    WadData objectWadData[] = new WadData[vector.size()];
    vector.copyInto(objectWadData);
    return(objectWadData);
  }

/**
Names of the columns of the fields of a tab
 */
  public static WadData[] selectResource(ConnectionProvider connectionProvider)    throws ServletException {
    return selectResource(connectionProvider, 0, 0);
  }

/**
Names of the columns of the fields of a tab
 */
  public static WadData[] selectResource(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NAME, CLASSNAME, (SELECT MAX(VALUE)" +
      "                                 FROM AD_MODEL_OBJECT_PARA P" +
      "                                WHERE O.AD_MODEL_OBJECT_ID = P.AD_MODEL_OBJECT_ID" +
      "                                  AND UPPER(P.NAME) = 'AUTH') AS AUTH " +
      "      FROM AD_MODEL_OBJECT  O" +
      "      WHERE ISACTIVE = 'Y' " +
      "      AND OBJECT_TYPE = 'R'" +
      "      ORDER BY seqno";

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
        WadData objectWadData = new WadData();
        objectWadData.name = UtilSql.getValue(result, "name");
        objectWadData.classname = UtilSql.getValue(result, "classname");
        objectWadData.auth = UtilSql.getValue(result, "auth");
        objectWadData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWadData);
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
    WadData objectWadData[] = new WadData[vector.size()];
    vector.copyInto(objectWadData);
    return(objectWadData);
  }

/**
Names of the columns of the fields of a tab
 */
  public static WadData[] selectFilterMapping(ConnectionProvider connectionProvider)    throws ServletException {
    return selectFilterMapping(connectionProvider, 0, 0);
  }

/**
Names of the columns of the fields of a tab
 */
  public static WadData[] selectFilterMapping(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT MAX(MO.ACTION || MO.AD_MODEL_OBJECT_ID) AS NAME, MOM.MAPPINGNAME AS CLASSNAME, MO.CLASSNAME AS DISPLAYNAME " +
      "      FROM AD_MODEL_OBJECT MO, AD_MODEL_OBJECT_MAPPING MOM" +
      "      WHERE MO.ISACTIVE = 'Y'" +
      "      AND MO.OBJECT_TYPE = 'F' " +
      "      AND MO.AD_MODEL_OBJECT_ID = MOM.AD_MODEL_OBJECT_ID " +
      "      AND MOM.ISACTIVE = 'Y'" +
      "      GROUP BY MO.CLASSNAME, MOM.MAPPINGNAME, MO.SEQNO " +
      "      ORDER BY SEQNO,NAME";

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
        WadData objectWadData = new WadData();
        objectWadData.name = UtilSql.getValue(result, "name");
        objectWadData.classname = UtilSql.getValue(result, "classname");
        objectWadData.displayname = UtilSql.getValue(result, "displayname");
        objectWadData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWadData);
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
    WadData objectWadData[] = new WadData[vector.size()];
    vector.copyInto(objectWadData);
    return(objectWadData);
  }

/**
Selects all model object parameters of object type C
 */
  public static WadData[] selectContextParams(ConnectionProvider connectionProvider)    throws ServletException {
    return selectContextParams(connectionProvider, 0, 0);
  }

/**
Selects all model object parameters of object type C
 */
  public static WadData[] selectContextParams(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT P.NAME, P.VALUE" +
      "      FROM AD_MODEL_OBJECT MO, AD_MODEL_OBJECT_PARA P" +
      "      WHERE MO.ISACTIVE = 'Y'" +
      "      AND MO.OBJECT_TYPE = 'C' " +
      "      AND MO.AD_MODEL_OBJECT_ID = P.AD_MODEL_OBJECT_ID " +
      "      AND P.ISACTIVE = 'Y'" +
      "      ORDER BY MO.SEQNO, P.LINE, P.NAME";

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
        WadData objectWadData = new WadData();
        objectWadData.name = UtilSql.getValue(result, "name");
        objectWadData.value = UtilSql.getValue(result, "value");
        objectWadData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWadData);
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
    WadData objectWadData[] = new WadData[vector.size()];
    vector.copyInto(objectWadData);
    return(objectWadData);
  }

/**
Names of the columns of the fields of a tab
 */
  public static WadData[] selectParams(ConnectionProvider connectionProvider, String objectType, String classname)    throws ServletException {
    return selectParams(connectionProvider, objectType, classname, 0, 0);
  }

/**
Names of the columns of the fields of a tab
 */
  public static WadData[] selectParams(ConnectionProvider connectionProvider, String objectType, String classname, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT MAX(LINE) AS  LINE, P.NAME, MAX(P.VALUE) AS VALUE" +
      "      FROM AD_MODEL_OBJECT MO, AD_MODEL_OBJECT_PARA P" +
      "      WHERE MO.ISACTIVE = 'Y'" +
      "      AND MO.OBJECT_TYPE = ? " +
      "      AND MO.CLASSNAME = ?" +
      "      AND MO.AD_MODEL_OBJECT_ID = P.AD_MODEL_OBJECT_ID " +
      "      AND P.ISACTIVE = 'Y'" +
      "      GROUP BY P.NAME " +
      "      ORDER BY LINE, NAME";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, objectType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, classname);

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
        WadData objectWadData = new WadData();
        objectWadData.line = UtilSql.getValue(result, "line");
        objectWadData.name = UtilSql.getValue(result, "name");
        objectWadData.value = UtilSql.getValue(result, "value");
        objectWadData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWadData);
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
    WadData objectWadData[] = new WadData[vector.size()];
    vector.copyInto(objectWadData);
    return(objectWadData);
  }

/**
Names of the columns of the fields of a tab
 */
  public static WadData[] selectListener(ConnectionProvider connectionProvider)    throws ServletException {
    return selectListener(connectionProvider, 0, 0);
  }

/**
Names of the columns of the fields of a tab
 */
  public static WadData[] selectListener(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(ACTION, '') || AD_MODEL_OBJECT_ID AS NAME, CLASSNAME, CLASSNAME AS DISPLAYNAME" +
      "      FROM AD_MODEL_OBJECT " +
      "      WHERE ISACTIVE = 'Y' " +
      "      AND OBJECT_TYPE = 'L'" +
      "      ORDER BY SEQNO, NAME";

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
        WadData objectWadData = new WadData();
        objectWadData.name = UtilSql.getValue(result, "name");
        objectWadData.classname = UtilSql.getValue(result, "classname");
        objectWadData.displayname = UtilSql.getValue(result, "displayname");
        objectWadData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWadData);
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
    WadData objectWadData[] = new WadData[vector.size()];
    vector.copyInto(objectWadData);
    return(objectWadData);
  }

/**
Names of the columns of the fields of a tab
 */
  public static String selectPixelSize(ConnectionProvider connectionProvider, String adLanguage)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT PIXELSIZE " +
      "      FROM AD_LANGUAGE " +
      "      WHERE AD_LANGUAGE = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "pixelsize");
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

  public static boolean genereteWebXml(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         select (case when count(*)=0 then 0 else 1 end) as buildxml" +
      "          from ad_system_info" +
      "         where last_build < (select max(updated)" +
      "                               from (select max(updated) as updated" +
      "                                       from ad_model_object" +
      "                                      union" +
      "                                     select max(updated) " +
      "                                       from ad_model_object_mapping) upd) ";

    ResultSet result;
    boolean boolReturn = true;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "buildxml").equals("0");
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

/**
procedure AD_Update_Table_Identifier
 */
  public static WadData updateIdentifiers(ConnectionProvider connectionProvider, String quick)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL AD_Update_Table_Identifier(NULL, ?)";

    WadData objectWadData = new WadData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quick);

      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(quick);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
        log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
        throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
        log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectWadData);
  }
}
