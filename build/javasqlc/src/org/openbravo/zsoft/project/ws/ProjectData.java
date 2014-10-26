//Sqlc generated V1.O00-1
package org.openbravo.zsoft.project.ws;

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
  public String id;
  public String name;
  public String value;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProjectData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static ProjectData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT c_project_id as id,name,value" +
      "              FROM C_PROJECT " +
      "             WHERE c_project.projectstatus = 'OR' and c_project.isactive='Y'" +
      "                   AND projectcategory != 'B'   AND projectcategory != 'C'";

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
        ProjectData objectProjectData = new ProjectData();
        objectProjectData.id = UtilSql.getValue(result, "id");
        objectProjectData.name = UtilSql.getValue(result, "name");
        objectProjectData.value = UtilSql.getValue(result, "value");
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

  public static String selectorg4proj(ConnectionProvider connectionProvider, String orgID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT ad_org_id as orgid" +
      "              FROM C_PROJECT " +
      "             WHERE c_project.c_project_id = ?   ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "orgid");
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

  public static String giveFeedback(ConnectionProvider connectionProvider, String employeeID, String workdate, String projectID, String phaseID, String taskID, String hour_from, String hour_to)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                SELECT zspm_giveFeedback(?,?,?,?,?,?,?) FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, employeeID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phaseID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taskID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hour_from);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hour_to);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zspm_givefeedback");
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
