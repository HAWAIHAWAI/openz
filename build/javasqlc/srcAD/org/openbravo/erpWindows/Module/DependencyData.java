//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Module;

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
class DependencyData implements FieldProvider {
static Logger log4j = Logger.getLogger(DependencyData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adModuleDependencyId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String adModuleId;
  public String adModuleIdr;
  public String adDependentModuleId;
  public String adDependentModuleIdr;
  public String startversion;
  public String endversion;
  public String isincluded;
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
    else if (fieldName.equalsIgnoreCase("ad_module_dependency_id") || fieldName.equals("adModuleDependencyId"))
      return adModuleDependencyId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
    else if (fieldName.equalsIgnoreCase("ad_module_idr") || fieldName.equals("adModuleIdr"))
      return adModuleIdr;
    else if (fieldName.equalsIgnoreCase("ad_dependent_module_id") || fieldName.equals("adDependentModuleId"))
      return adDependentModuleId;
    else if (fieldName.equalsIgnoreCase("ad_dependent_module_idr") || fieldName.equals("adDependentModuleIdr"))
      return adDependentModuleIdr;
    else if (fieldName.equalsIgnoreCase("startversion"))
      return startversion;
    else if (fieldName.equalsIgnoreCase("endversion"))
      return endversion;
    else if (fieldName.equalsIgnoreCase("isincluded"))
      return isincluded;
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
  public static DependencyData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adModuleId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adModuleId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static DependencyData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adModuleId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Module_Dependency.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Module_Dependency.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Module_Dependency.Updated, ?) as updated, " +
      "        to_char(AD_Module_Dependency.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Module_Dependency.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Module_Dependency.UpdatedBy) as UpdatedByR," +
      "        AD_Module_Dependency.AD_Module_Dependency_ID, " +
      "AD_Module_Dependency.AD_Client_ID, " +
      "(CASE WHEN AD_Module_Dependency.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Module_Dependency.AD_Org_ID, " +
      "(CASE WHEN AD_Module_Dependency.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(AD_Module_Dependency.IsActive, 'N') AS IsActive, " +
      "AD_Module_Dependency.AD_Module_ID, " +
      "(CASE WHEN AD_Module_Dependency.AD_Module_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Version), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_Module_IDR, " +
      "AD_Module_Dependency.AD_Dependent_Module_ID, " +
      "(CASE WHEN AD_Module_Dependency.AD_Dependent_Module_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_Dependent_Module_IDR, " +
      "AD_Module_Dependency.StartVersion, " +
      "AD_Module_Dependency.EndVersion, " +
      "COALESCE(AD_Module_Dependency.IsIncluded, 'N') AS IsIncluded, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Module_Dependency left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Module_Dependency.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_Module_Dependency.AD_Org_ID = table2.AD_Org_ID) left join (select AD_Module_ID, Name, Version, AD_Language from AD_Module) table3 on (AD_Module_Dependency.AD_Module_ID = table3.AD_Module_ID) left join (select AD_Language, Name from AD_Language) table4 on (table3.AD_Language =  table4.AD_Language) left join (select AD_Module_ID, Name from AD_Module) table5 on (AD_Module_Dependency.AD_Dependent_Module_ID =  table5.AD_Module_ID)" +
      "        WHERE 2=2 " +
      " AND AD_Module_Dependency.IsIncluded='N'" +
      "        AND 1=1 ";
    strSql = strSql + ((adModuleId==null || adModuleId.equals(""))?"":"  AND AD_Module_Dependency.AD_Module_ID = ?  ");
    strSql = strSql + 
      "        AND AD_Module_Dependency.AD_Module_Dependency_ID = ? " +
      "        AND AD_Module_Dependency.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Module_Dependency.AD_Org_ID IN (";
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
      if (adModuleId != null && !(adModuleId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      }
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
        DependencyData objectDependencyData = new DependencyData();
        objectDependencyData.created = UtilSql.getValue(result, "created");
        objectDependencyData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectDependencyData.updated = UtilSql.getValue(result, "updated");
        objectDependencyData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectDependencyData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDependencyData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectDependencyData.adModuleDependencyId = UtilSql.getValue(result, "ad_module_dependency_id");
        objectDependencyData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDependencyData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectDependencyData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDependencyData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectDependencyData.isactive = UtilSql.getValue(result, "isactive");
        objectDependencyData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectDependencyData.adModuleIdr = UtilSql.getValue(result, "ad_module_idr");
        objectDependencyData.adDependentModuleId = UtilSql.getValue(result, "ad_dependent_module_id");
        objectDependencyData.adDependentModuleIdr = UtilSql.getValue(result, "ad_dependent_module_idr");
        objectDependencyData.startversion = UtilSql.getValue(result, "startversion");
        objectDependencyData.endversion = UtilSql.getValue(result, "endversion");
        objectDependencyData.isincluded = UtilSql.getValue(result, "isincluded");
        objectDependencyData.language = UtilSql.getValue(result, "language");
        objectDependencyData.adUserClient = "";
        objectDependencyData.adOrgClient = "";
        objectDependencyData.createdby = "";
        objectDependencyData.trBgcolor = "";
        objectDependencyData.totalCount = "";
        objectDependencyData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDependencyData);
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
    DependencyData objectDependencyData[] = new DependencyData[vector.size()];
    vector.copyInto(objectDependencyData);
    return(objectDependencyData);
  }

/**
Create a registry
 */
  public static DependencyData[] set(String adModuleId, String endversion, String adDependentModuleId, String updatedby, String isactive, String adClientId, String startversion, String createdby, String adModuleDependencyId, String adOrgId, String isincluded)    throws ServletException {
    DependencyData objectDependencyData[] = new DependencyData[1];
    objectDependencyData[0] = new DependencyData();
    objectDependencyData[0].created = "";
    objectDependencyData[0].createdbyr = "";
    objectDependencyData[0].updated = "";
    objectDependencyData[0].updatedTimeStamp = "";
    objectDependencyData[0].updatedby = updatedby;
    objectDependencyData[0].updatedbyr = "";
    objectDependencyData[0].adModuleDependencyId = adModuleDependencyId;
    objectDependencyData[0].adClientId = adClientId;
    objectDependencyData[0].adClientIdr = "";
    objectDependencyData[0].adOrgId = adOrgId;
    objectDependencyData[0].adOrgIdr = "";
    objectDependencyData[0].isactive = isactive;
    objectDependencyData[0].adModuleId = adModuleId;
    objectDependencyData[0].adModuleIdr = "";
    objectDependencyData[0].adDependentModuleId = adDependentModuleId;
    objectDependencyData[0].adDependentModuleIdr = "";
    objectDependencyData[0].startversion = startversion;
    objectDependencyData[0].endversion = endversion;
    objectDependencyData[0].isincluded = isincluded;
    objectDependencyData[0].language = "";
    return objectDependencyData;
  }

/**
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_Module_Dependency.AD_Module_ID AS NAME" +
      "        FROM AD_Module_Dependency" +
      "        WHERE AD_Module_Dependency.AD_Module_Dependency_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

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

/**
Select for parent field
 */
  public static String selectParent(ConnectionProvider connectionProvider, String adModuleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Version), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))) AS NAME FROM AD_Module left join (select AD_Module_ID, Name, Version, AD_Language from AD_Module) table1 on (AD_Module.AD_Module_ID = table1.AD_Module_ID) left join (select AD_Language, Name from AD_Language) table2 on (table1.AD_Language =  table2.AD_Language) WHERE AD_Module.AD_Module_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);

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

/**
Select for parent field
 */
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adModuleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Version), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))) AS NAME FROM AD_Module left join (select AD_Module_ID, Name, Version, AD_Language from AD_Module) table1 on (AD_Module.AD_Module_ID = table1.AD_Module_ID) left join (select AD_Language, Name from AD_Language) table2 on (table1.AD_Language =  table2.AD_Language) WHERE AD_Module.AD_Module_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);

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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_Module_Dependency" +
      "        SET AD_Module_Dependency_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , IsActive = (?) , AD_Module_ID = (?) , AD_Dependent_Module_ID = (?) , StartVersion = (?) , EndVersion = (?) , IsIncluded = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Module_Dependency.AD_Module_Dependency_ID = ? " +
      "                 AND AD_Module_Dependency.AD_Module_ID = ? " +
      "        AND AD_Module_Dependency.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Module_Dependency.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleDependencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDependentModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startversion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, endversion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleDependencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
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
      "        INSERT INTO AD_Module_Dependency " +
      "        (AD_Module_Dependency_ID, AD_Client_ID, AD_Org_ID, IsActive, AD_Module_ID, AD_Dependent_Module_ID, StartVersion, EndVersion, IsIncluded, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleDependencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDependentModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startversion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, endversion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isincluded);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adModuleId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Module_Dependency" +
      "        WHERE AD_Module_Dependency.AD_Module_Dependency_ID = ? " +
      "                 AND AD_Module_Dependency.AD_Module_ID = ? " +
      "        AND AD_Module_Dependency.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Module_Dependency.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adModuleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Module_Dependency" +
      "        WHERE AD_Module_Dependency.AD_Module_Dependency_ID = ? " +
      "                 AND AD_Module_Dependency.AD_Module_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);

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
      "          FROM AD_Module_Dependency" +
      "         WHERE AD_Module_Dependency.AD_Module_Dependency_ID = ? ";

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
      "          FROM AD_Module_Dependency" +
      "         WHERE AD_Module_Dependency.AD_Module_Dependency_ID = ? ";

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
