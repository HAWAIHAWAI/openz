//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.project.Projects;

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
class DependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data implements FieldProvider {
static Logger log4j = Logger.getLogger(DependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String zspmProjecttaskdepId;
  public String isactive;
  public String adClientId;
  public String dependsontask;
  public String dependsontaskr;
  public String adOrgId;
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
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("zspm_projecttaskdep_id") || fieldName.equals("zspmProjecttaskdepId"))
      return zspmProjecttaskdepId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("dependsontask"))
      return dependsontask;
    else if (fieldName.equalsIgnoreCase("dependsontaskr"))
      return dependsontaskr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
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
  public static DependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjecttaskId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cProjecttaskId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static DependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjecttaskId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspm_projecttaskdep.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_projecttaskdep.CreatedBy) as CreatedByR, " +
      "        to_char(zspm_projecttaskdep.Updated, ?) as updated, " +
      "        to_char(zspm_projecttaskdep.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspm_projecttaskdep.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_projecttaskdep.UpdatedBy) as UpdatedByR," +
      "        zspm_projecttaskdep.C_Projecttask_ID, " +
      "(CASE WHEN zspm_projecttaskdep.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "zspm_projecttaskdep.Zspm_Projecttaskdep_ID, " +
      "COALESCE(zspm_projecttaskdep.Isactive, 'N') AS Isactive, " +
      "zspm_projecttaskdep.AD_Client_ID, " +
      "zspm_projecttaskdep.Dependsontask, " +
      "(CASE WHEN zspm_projecttaskdep.Dependsontask IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS DependsontaskR, " +
      "zspm_projecttaskdep.AD_Org_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zspm_projecttaskdep left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table1 on (zspm_projecttaskdep.C_Projecttask_ID = table1.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (table1.C_Project_ID = table2.C_Project_ID) left join (select C_ProjectTask_ID, Name from C_ProjectTask) table3 on (zspm_projecttaskdep.Dependsontask =  table3.C_ProjectTask_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cProjecttaskId==null || cProjecttaskId.equals(""))?"":"  AND zspm_projecttaskdep.C_Projecttask_ID = ?  ");
    strSql = strSql + 
      "        AND zspm_projecttaskdep.Zspm_Projecttaskdep_ID = ? " +
      "        AND zspm_projecttaskdep.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zspm_projecttaskdep.AD_Org_ID IN (";
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
      if (cProjecttaskId != null && !(cProjecttaskId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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
        DependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data = new DependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data();
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.created = UtilSql.getValue(result, "created");
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.updated = UtilSql.getValue(result, "updated");
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.zspmProjecttaskdepId = UtilSql.getValue(result, "zspm_projecttaskdep_id");
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.isactive = UtilSql.getValue(result, "isactive");
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.dependsontask = UtilSql.getValue(result, "dependsontask");
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.dependsontaskr = UtilSql.getValue(result, "dependsontaskr");
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.language = UtilSql.getValue(result, "language");
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.adUserClient = "";
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.adOrgClient = "";
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.createdby = "";
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.trBgcolor = "";
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.totalCount = "";
        objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data);
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
    DependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[] = new DependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[vector.size()];
    vector.copyInto(objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data);
    return(objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data);
  }

/**
Create a registry
 */
  public static DependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[] set(String cProjecttaskId, String updatedby, String updatedbyr, String isactive, String adOrgId, String dependsontask, String createdby, String createdbyr, String adClientId, String zspmProjecttaskdepId)    throws ServletException {
    DependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[] = new DependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[1];
    objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[0] = new DependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data();
    objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[0].created = "";
    objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[0].createdbyr = createdbyr;
    objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[0].updated = "";
    objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[0].updatedTimeStamp = "";
    objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[0].updatedby = updatedby;
    objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[0].updatedbyr = updatedbyr;
    objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[0].cProjecttaskId = cProjecttaskId;
    objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[0].cProjecttaskIdr = "";
    objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[0].zspmProjecttaskdepId = zspmProjecttaskdepId;
    objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[0].isactive = isactive;
    objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[0].adClientId = adClientId;
    objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[0].dependsontask = dependsontask;
    objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[0].dependsontaskr = "";
    objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[0].adOrgId = adOrgId;
    objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data[0].language = "";
    return objectDependentonTasks5D360D3ECFC74814A32B778CEECBC2F8Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef76E55165EF35422DACCAFD88A5FCE747_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefD6F00446FB6044439756A5AECC608867_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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

/**
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zspm_projecttaskdep.C_Projecttask_ID AS NAME" +
      "        FROM zspm_projecttaskdep" +
      "        WHERE zspm_projecttaskdep.Zspm_Projecttaskdep_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))) AS NAME FROM C_ProjectTask left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table1 on (C_ProjectTask.C_Projecttask_ID = table1.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (table1.C_Project_ID = table2.C_Project_ID) WHERE C_ProjectTask.C_Projecttask_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))) AS NAME FROM C_ProjectTask left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table1 on (C_ProjectTask.C_Projecttask_ID = table1.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (table1.C_Project_ID = table2.C_Project_ID) WHERE C_ProjectTask.C_Projecttask_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);

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
      "        UPDATE zspm_projecttaskdep" +
      "        SET C_Projecttask_ID = (?) , Zspm_Projecttaskdep_ID = (?) , Isactive = (?) , AD_Client_ID = (?) , Dependsontask = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zspm_projecttaskdep.Zspm_Projecttaskdep_ID = ? " +
      "                 AND zspm_projecttaskdep.C_Projecttask_ID = ? " +
      "        AND zspm_projecttaskdep.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_projecttaskdep.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmProjecttaskdepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dependsontask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmProjecttaskdepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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
      "        INSERT INTO zspm_projecttaskdep " +
      "        (C_Projecttask_ID, Zspm_Projecttaskdep_ID, Isactive, AD_Client_ID, Dependsontask, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmProjecttaskdepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dependsontask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cProjecttaskId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspm_projecttaskdep" +
      "        WHERE zspm_projecttaskdep.Zspm_Projecttaskdep_ID = ? " +
      "                 AND zspm_projecttaskdep.C_Projecttask_ID = ? " +
      "        AND zspm_projecttaskdep.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_projecttaskdep.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspm_projecttaskdep" +
      "        WHERE zspm_projecttaskdep.Zspm_Projecttaskdep_ID = ? " +
      "                 AND zspm_projecttaskdep.C_Projecttask_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);

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
      "          FROM zspm_projecttaskdep" +
      "         WHERE zspm_projecttaskdep.Zspm_Projecttaskdep_ID = ? ";

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
      "          FROM zspm_projecttaskdep" +
      "         WHERE zspm_projecttaskdep.Zspm_Projecttaskdep_ID = ? ";

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
