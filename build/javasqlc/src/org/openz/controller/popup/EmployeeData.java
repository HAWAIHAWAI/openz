//Sqlc generated V1.O00-1
package org.openz.controller.popup;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class EmployeeData implements FieldProvider {
static Logger log4j = Logger.getLogger(EmployeeData.class);
  private String InitRecordNumber="0";
  public String adUserId;
  public String adClientId;
  public String adOrgId;
  public String cBpartneremployeeViewId;
  public String createdby;
  public String updatedby;
  public String value;
  public String name;
  public String country;
  public String city;
  public String zipcode;
  public String projects;
  public String drivinglicense;
  public String certification;
  public String g26;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_bpartneremployee_view_id") || fieldName.equals("cBpartneremployeeViewId"))
      return cBpartneremployeeViewId;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("country"))
      return country;
    else if (fieldName.equalsIgnoreCase("city"))
      return city;
    else if (fieldName.equalsIgnoreCase("zipcode"))
      return zipcode;
    else if (fieldName.equalsIgnoreCase("projects"))
      return projects;
    else if (fieldName.equalsIgnoreCase("drivinglicense"))
      return drivinglicense;
    else if (fieldName.equalsIgnoreCase("certification"))
      return certification;
    else if (fieldName.equalsIgnoreCase("g26"))
      return g26;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static EmployeeData[] select(ConnectionProvider connectionProvider, String parDateFrom, String parDateTo, String parTaskExclude, String parPlannedResource, String parName, String parValue, String parOrg, String pgLimit, String orderBy)    throws ServletException {
    return select(connectionProvider, parDateFrom, parDateTo, parTaskExclude, parPlannedResource, parName, parValue, parOrg, pgLimit, orderBy, 0, 0);
  }

  public static EmployeeData[] select(ConnectionProvider connectionProvider, String parDateFrom, String parDateTo, String parTaskExclude, String parPlannedResource, String parName, String parValue, String parOrg, String pgLimit, String orderBy, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ad_user_id,ad_client_id, ad_org_id, C_BPARTNEREMPLOYEE_VIEW_ID,CREATEDBY, UPDATEDBY,VALUE," +
      "             NAME,COUNTRY, CITY, ZIPCODE, projects,drivinglicense, certification, g26" +
      "      from (select u.ad_user_id,b.ad_client_id, b.ad_org_id, b.C_BPARTNEREMPLOYEE_VIEW_ID,b.CREATEDBY, b.UPDATEDBY,b.VALUE, b.NAME,b.COUNTRY, b.CITY, b.ZIPCODE," +
      "      c_getemployeeprojectsplanInRange(b.c_bpartner_id, ?,?,?,'Planned') as projects," +
      "      u.sachgebiet as drivinglicense, u.schluesselkontakt as certification,u.Veranstaltungsmanagement as g26" +
      "      from C_BPARTNEREMPLOYEE_VIEW b, ad_user u where" +
      "      b.c_bpartner_id=u.c_bpartner_id " +
      "      and b.isinresourceplan in ('Y',?) " +
      "      and 1=1";
    strSql = strSql + ((parName==null || parName.equals(""))?"":"  AND upper(b.name) like upper(?) ");
    strSql = strSql + ((parValue==null || parValue.equals(""))?"":"  AND b.value like ? ");
    strSql = strSql + ((parOrg==null || parOrg.equals(""))?"":"  AND b.ad_org_id in ('0',?) ");
    strSql = strSql + 
      "      AND 4=4";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":"  LIMIT " + pgLimit);
    strSql = strSql + 
      ") a" +
      "      ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parTaskExclude);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parPlannedResource);
      if (parName != null && !(parName.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parName);
      }
      if (parValue != null && !(parValue.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parValue);
      }
      if (parOrg != null && !(parOrg.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parOrg);
      }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (orderBy != null && !(orderBy.equals(""))) {
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
        EmployeeData objectEmployeeData = new EmployeeData();
        objectEmployeeData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectEmployeeData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectEmployeeData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectEmployeeData.cBpartneremployeeViewId = UtilSql.getValue(result, "c_bpartneremployee_view_id");
        objectEmployeeData.createdby = UtilSql.getValue(result, "createdby");
        objectEmployeeData.updatedby = UtilSql.getValue(result, "updatedby");
        objectEmployeeData.value = UtilSql.getValue(result, "value");
        objectEmployeeData.name = UtilSql.getValue(result, "name");
        objectEmployeeData.country = UtilSql.getValue(result, "country");
        objectEmployeeData.city = UtilSql.getValue(result, "city");
        objectEmployeeData.zipcode = UtilSql.getValue(result, "zipcode");
        objectEmployeeData.projects = UtilSql.getValue(result, "projects");
        objectEmployeeData.drivinglicense = UtilSql.getValue(result, "drivinglicense");
        objectEmployeeData.certification = UtilSql.getValue(result, "certification");
        objectEmployeeData.g26 = UtilSql.getValue(result, "g26");
        objectEmployeeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEmployeeData);
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
    EmployeeData objectEmployeeData[] = new EmployeeData[vector.size()];
    vector.copyInto(objectEmployeeData);
    return(objectEmployeeData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String parPlannedResource, String parName, String parValue, String parOrg, String pgLimit)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT count(*) AS value" +
      "      from C_BPARTNEREMPLOYEE_VIEW b, ad_user u where" +
      "      b.c_bpartner_id=u.c_bpartner_id" +
      "      and b.isinresourceplan in ('Y',?) " +
      "      and 1=1";
    strSql = strSql + ((parName==null || parName.equals(""))?"":"  AND b.name like ? ");
    strSql = strSql + ((parValue==null || parValue.equals(""))?"":"  AND b.value like ? ");
    strSql = strSql + ((parOrg==null || parOrg.equals(""))?"":"  AND b.ad_org_id in ('0',?) ");
    strSql = strSql + 
      "      AND 4=4";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":"  LIMIT " + pgLimit);

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parPlannedResource);
      if (parName != null && !(parName.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parName);
      }
      if (parValue != null && !(parValue.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parValue);
      }
      if (parOrg != null && !(parOrg.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parOrg);
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

  public static EmployeeData[] set()    throws ServletException {
    EmployeeData objectEmployeeData[] = new EmployeeData[1];
    objectEmployeeData[0] = new EmployeeData();
    objectEmployeeData[0].value = "";
    return objectEmployeeData;
  }

  public static String getSalCategory(ConnectionProvider connectionProvider, String userId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT min(b.C_Salary_Category_id) " +
      "       from c_bpartner b,C_Salary_Category s WHERE b.C_Salary_Category_id=s.C_Salary_Category_id " +
      "            and b.c_bpartner_id =  (select c_bpartner_id from ad_user where ad_user_id= ? ) " +
      "            AND s.isactive='Y'" +
      "            AND exists (select 0 from C_Salary_Category_cost c where c.C_Salary_Category_id=s.C_Salary_Category_id " +
      "                         and c.COSTUOM='H')";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "min");
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

  public static String getBegin(ConnectionProvider connectionProvider, String taskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(startdate,'DD-MM-YYYY') from c_projecttask where c_projecttask_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taskId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "to_char");
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

  public static String getEnd(ConnectionProvider connectionProvider, String taskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(enddate,'DD-MM-YYYY') from c_projecttask where c_projecttask_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taskId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "to_char");
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
