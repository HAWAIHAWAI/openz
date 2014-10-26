//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.info;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ProjectData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProjectData.class);
  private String InitRecordNumber="0";
  public String cProjectId;
  public String value;
  public String valueHidden;
  public String name;
  public String cBpartnerId;
  public String nameHidden;
  public String bpartner;
  public String projectstatus;
  public String rowkey;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("value_hidden") || fieldName.equals("valueHidden"))
      return valueHidden;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("name_hidden") || fieldName.equals("nameHidden"))
      return nameHidden;
    else if (fieldName.equalsIgnoreCase("bpartner"))
      return bpartner;
    else if (fieldName.equalsIgnoreCase("projectstatus"))
      return projectstatus;
    else if (fieldName.equalsIgnoreCase("rowkey"))
      return rowkey;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProjectData[] select(ConnectionProvider connectionProvider, String language, String pstatus, String adUserClient, String adUserOrg, String key, String name, String bpartner, String orderBy, String pgLimit)    throws ServletException {
    return select(connectionProvider, language, pstatus, adUserClient, adUserOrg, key, name, bpartner, orderBy, pgLimit, 0, 0);
  }

  public static ProjectData[] select(ConnectionProvider connectionProvider, String language, String pstatus, String adUserClient, String adUserOrg, String key, String name, String bpartner, String orderBy, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT * FROM  (  " +
      "        SELECT P.C_PROJECT_ID, P.VALUE, REPLACE(P.VALUE, '''', CHR(92) || '''') AS VALUE_HIDDEN, P.NAME, P.C_BPARTNER_ID, " +
      "        REPLACE(P.NAME, '''', CHR(92) || CHR(92) || '''') AS NAME_HIDDEN, " +
      "        B.NAME AS BPARTNER, L.NAME AS PROJECTSTATUS," +
      "        p.c_Project_Id || '#' || p.value || ' - ' || p.name as rowkey" +
      "        FROM C_PROJECT P LEFT JOIN C_BPARTNER B ON P.C_BPARTNER_ID = B.C_BPARTNER_ID , AD_REF_LIST_V L " +
      "        WHERE P.PROJECTSTATUS = L.VALUE " +
      "        AND L.AD_REFERENCE_ID = '800002' " +
      "        AND L.AD_LANGUAGE = ?" +
      "        AND (P.projectstatus = 'OR' or P.projectstatus = ?)" +
      "        AND P.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND P.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND P.ISACTIVE = 'Y'";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(P.Value) LIKE UPPER(?)  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  AND UPPER(P.Name) LIKE UPPER(?)  ");
    strSql = strSql + ((bpartner==null || bpartner.equals(""))?"":"  AND P.C_BPARTNER_ID = ?  ");
    strSql = strSql + 
      "        AND P.projectcategory!='PRP'" +
      "        ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + 
      "		)  B" +
      "		WHERE 1=1";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pstatus);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (bpartner != null && !(bpartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartner);
      }
      if (orderBy != null && !(orderBy.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
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
        ProjectData objectProjectData = new ProjectData();
        objectProjectData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectProjectData.value = UtilSql.getValue(result, "value");
        objectProjectData.valueHidden = UtilSql.getValue(result, "value_hidden");
        objectProjectData.name = UtilSql.getValue(result, "name");
        objectProjectData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectProjectData.nameHidden = UtilSql.getValue(result, "name_hidden");
        objectProjectData.bpartner = UtilSql.getValue(result, "bpartner");
        objectProjectData.projectstatus = UtilSql.getValue(result, "projectstatus");
        objectProjectData.rowkey = UtilSql.getValue(result, "rowkey");
        objectProjectData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjectData);
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
    ProjectData objectProjectData[] = new ProjectData[vector.size()];
    vector.copyInto(objectProjectData);
    return(objectProjectData);
  }

  public static ProjectData[] set()    throws ServletException {
    ProjectData objectProjectData[] = new ProjectData[1];
    objectProjectData[0] = new ProjectData();
    objectProjectData[0].cProjectId = "";
    objectProjectData[0].value = "";
    objectProjectData[0].valueHidden = "";
    objectProjectData[0].name = "";
    objectProjectData[0].cBpartnerId = "";
    objectProjectData[0].nameHidden = "";
    objectProjectData[0].bpartner = "";
    objectProjectData[0].projectstatus = "";
    objectProjectData[0].rowkey = "";
    return objectProjectData;
  }

  public static String countRows(ConnectionProvider connectionProvider, String language, String pstatus, String adUserClient, String adUserOrg, String key, String name, String bpartner, String pgLimit)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT(*) AS VALUE FROM ( " +
      "        SELECT 1" +
      "        FROM C_PROJECT P LEFT JOIN C_BPARTNER B ON P.C_BPARTNER_ID = B.C_BPARTNER_ID , AD_REF_LIST_V L " +
      "        WHERE P.PROJECTSTATUS = L.VALUE " +
      "        AND L.AD_REFERENCE_ID = '800002' " +
      "        AND L.AD_LANGUAGE = ? " +
      "        AND (P.projectstatus = 'OR' or P.projectstatus = ?)" +
      "        AND P.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND P.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND P.ISACTIVE = 'Y'";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(P.Value) LIKE UPPER(?)  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  AND UPPER(P.Name) LIKE UPPER(?)  ");
    strSql = strSql + ((bpartner==null || bpartner.equals(""))?"":"  AND P.C_BPARTNER_ID = ?  ");
    strSql = strSql + 
      "        AND P.projectcategory!='PRP'" +
      "        AND 1=1";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "		) B";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pstatus);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (bpartner != null && !(bpartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartner);
      }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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

  public static ProjectData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String bpartner, String key)    throws ServletException {
    return selectKey(connectionProvider, adUserClient, adUserOrg, bpartner, key, 0, 0);
  }

  public static ProjectData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String bpartner, String key, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT P.C_PROJECT_ID, P.VALUE, P.NAME, P.C_BPARTNER_ID, B.NAME AS BPARTNER" +
      "        FROM C_PROJECT P, C_BPARTNER B " +
      "        WHERE P.C_BPARTNER_ID = B.C_BPARTNER_ID " +
      "        AND P.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND P.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND P.ISACTIVE = 'Y'";
    strSql = strSql + ((bpartner==null || bpartner.equals(""))?"":"  AND P.C_BPARTNER_ID = ?  ");
    strSql = strSql + 
      "        AND P.projectstatus = 'OR'" +
      "        AND UPPER(P.VALUE) LIKE UPPER(?)" +
      "        ORDER BY P.NAME";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (bpartner != null && !(bpartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartner);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

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
        ProjectData objectProjectData = new ProjectData();
        objectProjectData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectProjectData.value = UtilSql.getValue(result, "value");
        objectProjectData.name = UtilSql.getValue(result, "name");
        objectProjectData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectProjectData.bpartner = UtilSql.getValue(result, "bpartner");
        objectProjectData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjectData);
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
    ProjectData objectProjectData[] = new ProjectData[vector.size()];
    vector.copyInto(objectProjectData);
    return(objectProjectData);
  }

  public static String selectTercero(ConnectionProvider connectionProvider, String cBparnterId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME FROM C_BPARTNER WHERE C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBparnterId);

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
}
