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
class IndirectCostCC031130A16B4896B47BE80EBBBBF635Data implements FieldProvider {
static Logger log4j = Logger.getLogger(IndirectCostCC031130A16B4896B47BE80EBBBBF635Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String zspmPtaskindcostplanId;
  public String adClientId;
  public String isactive;
  public String adOrgId;
  public String maIndirectCostId;
  public String maIndirectCostIdr;
  public String actualcostamount;
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
    else if (fieldName.equalsIgnoreCase("zspm_ptaskindcostplan_id") || fieldName.equals("zspmPtaskindcostplanId"))
      return zspmPtaskindcostplanId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ma_indirect_cost_id") || fieldName.equals("maIndirectCostId"))
      return maIndirectCostId;
    else if (fieldName.equalsIgnoreCase("ma_indirect_cost_idr") || fieldName.equals("maIndirectCostIdr"))
      return maIndirectCostIdr;
    else if (fieldName.equalsIgnoreCase("actualcostamount"))
      return actualcostamount;
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
  public static IndirectCostCC031130A16B4896B47BE80EBBBBF635Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjecttaskId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cProjecttaskId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static IndirectCostCC031130A16B4896B47BE80EBBBBF635Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjecttaskId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspm_ptaskindcostplan.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_ptaskindcostplan.CreatedBy) as CreatedByR, " +
      "        to_char(zspm_ptaskindcostplan.Updated, ?) as updated, " +
      "        to_char(zspm_ptaskindcostplan.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspm_ptaskindcostplan.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_ptaskindcostplan.UpdatedBy) as UpdatedByR," +
      "        zspm_ptaskindcostplan.C_Projecttask_ID, " +
      "(CASE WHEN zspm_ptaskindcostplan.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "zspm_ptaskindcostplan.Zspm_Ptaskindcostplan_ID, " +
      "zspm_ptaskindcostplan.AD_Client_ID, " +
      "COALESCE(zspm_ptaskindcostplan.Isactive, 'N') AS Isactive, " +
      "zspm_ptaskindcostplan.AD_Org_ID, " +
      "zspm_ptaskindcostplan.MA_Indirect_Cost_ID, " +
      "(CASE WHEN zspm_ptaskindcostplan.MA_Indirect_Cost_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS MA_Indirect_Cost_IDR, " +
      "zspm_ptaskindcostplan.Actualcostamount, " +
      "        ? AS LANGUAGE " +
      "        FROM zspm_ptaskindcostplan left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table1 on (zspm_ptaskindcostplan.C_Projecttask_ID = table1.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (table1.C_Project_ID = table2.C_Project_ID) left join (select MA_Indirect_Cost_ID, Name from MA_Indirect_Cost) table3 on (zspm_ptaskindcostplan.MA_Indirect_Cost_ID = table3.MA_Indirect_Cost_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cProjecttaskId==null || cProjecttaskId.equals(""))?"":"  AND zspm_ptaskindcostplan.C_Projecttask_ID = ?  ");
    strSql = strSql + 
      "        AND zspm_ptaskindcostplan.Zspm_Ptaskindcostplan_ID = ? " +
      "        AND zspm_ptaskindcostplan.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zspm_ptaskindcostplan.AD_Org_ID IN (";
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
        IndirectCostCC031130A16B4896B47BE80EBBBBF635Data objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data = new IndirectCostCC031130A16B4896B47BE80EBBBBF635Data();
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.created = UtilSql.getValue(result, "created");
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.updated = UtilSql.getValue(result, "updated");
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.zspmPtaskindcostplanId = UtilSql.getValue(result, "zspm_ptaskindcostplan_id");
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.isactive = UtilSql.getValue(result, "isactive");
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.maIndirectCostId = UtilSql.getValue(result, "ma_indirect_cost_id");
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.maIndirectCostIdr = UtilSql.getValue(result, "ma_indirect_cost_idr");
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.actualcostamount = UtilSql.getValue(result, "actualcostamount");
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.language = UtilSql.getValue(result, "language");
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.adUserClient = "";
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.adOrgClient = "";
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.createdby = "";
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.trBgcolor = "";
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.totalCount = "";
        objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data);
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
    IndirectCostCC031130A16B4896B47BE80EBBBBF635Data objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[] = new IndirectCostCC031130A16B4896B47BE80EBBBBF635Data[vector.size()];
    vector.copyInto(objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data);
    return(objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data);
  }

/**
Create a registry
 */
  public static IndirectCostCC031130A16B4896B47BE80EBBBBF635Data[] set(String cProjecttaskId, String adOrgId, String zspmPtaskindcostplanId, String actualcostamount, String updatedby, String updatedbyr, String adClientId, String isactive, String maIndirectCostId, String createdby, String createdbyr)    throws ServletException {
    IndirectCostCC031130A16B4896B47BE80EBBBBF635Data objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[] = new IndirectCostCC031130A16B4896B47BE80EBBBBF635Data[1];
    objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[0] = new IndirectCostCC031130A16B4896B47BE80EBBBBF635Data();
    objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[0].created = "";
    objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[0].createdbyr = createdbyr;
    objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[0].updated = "";
    objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[0].updatedTimeStamp = "";
    objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[0].updatedby = updatedby;
    objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[0].updatedbyr = updatedbyr;
    objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[0].cProjecttaskId = cProjecttaskId;
    objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[0].cProjecttaskIdr = "";
    objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[0].zspmPtaskindcostplanId = zspmPtaskindcostplanId;
    objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[0].adClientId = adClientId;
    objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[0].isactive = isactive;
    objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[0].adOrgId = adOrgId;
    objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[0].maIndirectCostId = maIndirectCostId;
    objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[0].maIndirectCostIdr = "";
    objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[0].actualcostamount = actualcostamount;
    objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data[0].language = "";
    return objectIndirectCostCC031130A16B4896B47BE80EBBBBF635Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2D77BA9A6FDE47BABADF505FEA3DBDDE_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefDB88456CB4AA48B083EEC60A44C7EDBF_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT zspm_ptaskindcostplan.C_Projecttask_ID AS NAME" +
      "        FROM zspm_ptaskindcostplan" +
      "        WHERE zspm_ptaskindcostplan.Zspm_Ptaskindcostplan_ID = ?";

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
      "        UPDATE zspm_ptaskindcostplan" +
      "        SET C_Projecttask_ID = (?) , Zspm_Ptaskindcostplan_ID = (?) , AD_Client_ID = (?) , Isactive = (?) , AD_Org_ID = (?) , MA_Indirect_Cost_ID = (?) , Actualcostamount = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE zspm_ptaskindcostplan.Zspm_Ptaskindcostplan_ID = ? " +
      "                 AND zspm_ptaskindcostplan.C_Projecttask_ID = ? " +
      "        AND zspm_ptaskindcostplan.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_ptaskindcostplan.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskindcostplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskindcostplanId);
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
      "        INSERT INTO zspm_ptaskindcostplan " +
      "        (C_Projecttask_ID, Zspm_Ptaskindcostplan_ID, AD_Client_ID, Isactive, AD_Org_ID, MA_Indirect_Cost_ID, Actualcostamount, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskindcostplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
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
      "        DELETE FROM zspm_ptaskindcostplan" +
      "        WHERE zspm_ptaskindcostplan.Zspm_Ptaskindcostplan_ID = ? " +
      "                 AND zspm_ptaskindcostplan.C_Projecttask_ID = ? " +
      "        AND zspm_ptaskindcostplan.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_ptaskindcostplan.AD_Org_ID IN (";
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
      "        DELETE FROM zspm_ptaskindcostplan" +
      "        WHERE zspm_ptaskindcostplan.Zspm_Ptaskindcostplan_ID = ? " +
      "                 AND zspm_ptaskindcostplan.C_Projecttask_ID = ? ";

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
      "          FROM zspm_ptaskindcostplan" +
      "         WHERE zspm_ptaskindcostplan.Zspm_Ptaskindcostplan_ID = ? ";

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
      "          FROM zspm_ptaskindcostplan" +
      "         WHERE zspm_ptaskindcostplan.Zspm_Ptaskindcostplan_ID = ? ";

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
