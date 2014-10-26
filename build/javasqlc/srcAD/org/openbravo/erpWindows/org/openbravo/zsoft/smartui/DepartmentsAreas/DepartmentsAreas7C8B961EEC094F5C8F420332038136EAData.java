//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.DepartmentsAreas;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

/**
WAD Generated class
 */
class DepartmentsAreas7C8B961EEC094F5C8F420332038136EAData implements FieldProvider {
static Logger log4j = Logger.getLogger(DepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String cUserDepartmentId;
  public String adClientId;
  public String name;
  public String description;
  public String isactive;
  public String language;
  public String adUserClient;
  public String adOrgClient;
  public String createdby;
  public String trBgcolor;
  public String totalCount;
  public String dateTimeFormat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdbyr"))
      return createdbyr;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updated_time_stamp") || fieldName.equals("updatedTimeStamp"))
      return updatedTimeStamp;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("updatedbyr"))
      return updatedbyr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_user_department_id") || fieldName.equals("cUserDepartmentId"))
      return cUserDepartmentId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("language"))
      return language;
    else if (fieldName.equals("adUserClient"))
      return adUserClient;
    else if (fieldName.equals("adOrgClient"))
      return adOrgClient;
    else if (fieldName.equals("createdby"))
      return createdby;
    else if (fieldName.equals("trBgcolor"))
      return trBgcolor;
    else if (fieldName.equals("totalCount"))
      return totalCount;
    else if (fieldName.equals("dateTimeFormat"))
      return dateTimeFormat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for edit
 */
  public static DepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static DepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_User_Department.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_User_Department.CreatedBy) as CreatedByR, " +
      "        to_char(C_User_Department.Updated, ?) as updated, " +
      "        to_char(C_User_Department.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_User_Department.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_User_Department.UpdatedBy) as UpdatedByR," +
      "        C_User_Department.AD_Org_ID, " +
      "(CASE WHEN C_User_Department.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_User_Department.C_User_Department_ID, " +
      "C_User_Department.AD_Client_ID, " +
      "C_User_Department.Name, " +
      "C_User_Department.Description, " +
      "COALESCE(C_User_Department.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM C_User_Department left join (select AD_Org_ID, Name from AD_Org) table1 on (C_User_Department.AD_Org_ID = table1.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_User_Department.C_User_Department_ID = ? " +
      "        AND C_User_Department.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_User_Department.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
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
        DepartmentsAreas7C8B961EEC094F5C8F420332038136EAData objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData = new DepartmentsAreas7C8B961EEC094F5C8F420332038136EAData();
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.created = UtilSql.getValue(result, "created");
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.updated = UtilSql.getValue(result, "updated");
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.cUserDepartmentId = UtilSql.getValue(result, "c_user_department_id");
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.name = UtilSql.getValue(result, "name");
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.description = UtilSql.getValue(result, "description");
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.isactive = UtilSql.getValue(result, "isactive");
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.language = UtilSql.getValue(result, "language");
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.adUserClient = "";
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.adOrgClient = "";
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.createdby = "";
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.trBgcolor = "";
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.totalCount = "";
        objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData);
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
    DepartmentsAreas7C8B961EEC094F5C8F420332038136EAData objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[] = new DepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[vector.size()];
    vector.copyInto(objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData);
    return(objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData);
  }

/**
Create a registry
 */
  public static DepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[] set(String description, String adOrgId, String adClientId, String updatedby, String updatedbyr, String isactive, String name, String cUserDepartmentId, String createdby, String createdbyr)    throws ServletException {
    DepartmentsAreas7C8B961EEC094F5C8F420332038136EAData objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[] = new DepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[1];
    objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[0] = new DepartmentsAreas7C8B961EEC094F5C8F420332038136EAData();
    objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[0].created = "";
    objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[0].createdbyr = createdbyr;
    objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[0].updated = "";
    objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[0].updatedTimeStamp = "";
    objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[0].updatedby = updatedby;
    objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[0].updatedbyr = updatedbyr;
    objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[0].adOrgId = adOrgId;
    objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[0].adOrgIdr = "";
    objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[0].cUserDepartmentId = cUserDepartmentId;
    objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[0].adClientId = adClientId;
    objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[0].name = name;
    objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[0].description = description;
    objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[0].isactive = isactive;
    objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData[0].language = "";
    return objectDepartmentsAreas7C8B961EEC094F5C8F420332038136EAData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef67459333EA184240BE4C4A1279C99A9E_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Updatedby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updatedby");
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

/**
Select for auxiliar field
 */
  public static String selectDef6EFF7546989645D6B0776FBA3DDEE7B7_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Createdby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "createdby");
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_User_Department" +
      "        SET AD_Org_ID = (?) , C_User_Department_ID = (?) , AD_Client_ID = (?) , Name = (?) , Description = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_User_Department.C_User_Department_ID = ? " +
      "        AND C_User_Department.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_User_Department.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_User_Department " +
      "        (AD_Org_ID, C_User_Department_ID, AD_Client_ID, Name, Description, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_User_Department" +
      "        WHERE C_User_Department.C_User_Department_ID = ? " +
      "        AND C_User_Department.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_User_Department.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_User_Department" +
      "        WHERE C_User_Department.C_User_Department_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

/**
Select for relation
 */
  public static String selectOrg(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID" +
      "          FROM C_User_Department" +
      "         WHERE C_User_Department.C_User_Department_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_id");
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

  public static String getCurrentDBTimestamp(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp" +
      "          FROM C_User_Department" +
      "         WHERE C_User_Department.C_User_Department_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updated_time_stamp");
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
