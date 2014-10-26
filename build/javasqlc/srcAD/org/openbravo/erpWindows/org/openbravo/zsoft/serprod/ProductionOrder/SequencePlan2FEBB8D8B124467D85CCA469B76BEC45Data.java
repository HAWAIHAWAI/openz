//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.ProductionOrder;

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
class SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data implements FieldProvider {
static Logger log4j = Logger.getLogger(SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssmProductionorderTaskdepVId;
  public String zssmProductionorderVId;
  public String zssmProductionorderVIdr;
  public String zspmProjecttaskdepId;
  public String isactive;
  public String sortno;
  public String adClientId;
  public String dependsontask;
  public String dependsontaskr;
  public String adOrgId;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String description;
  public String stockrotation;
  public String dependentstatuscheck;
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
    else if (fieldName.equalsIgnoreCase("zssm_productionorder_taskdep_v_id") || fieldName.equals("zssmProductionorderTaskdepVId"))
      return zssmProductionorderTaskdepVId;
    else if (fieldName.equalsIgnoreCase("zssm_productionorder_v_id") || fieldName.equals("zssmProductionorderVId"))
      return zssmProductionorderVId;
    else if (fieldName.equalsIgnoreCase("zssm_productionorder_v_idr") || fieldName.equals("zssmProductionorderVIdr"))
      return zssmProductionorderVIdr;
    else if (fieldName.equalsIgnoreCase("zspm_projecttaskdep_id") || fieldName.equals("zspmProjecttaskdepId"))
      return zspmProjecttaskdepId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("sortno"))
      return sortno;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("dependsontask"))
      return dependsontask;
    else if (fieldName.equalsIgnoreCase("dependsontaskr"))
      return dependsontaskr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("stockrotation"))
      return stockrotation;
    else if (fieldName.equalsIgnoreCase("dependentstatuscheck"))
      return dependentstatuscheck;
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
  public static SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmProductionorderVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssmProductionorderVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmProductionorderVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssm_productionorder_taskdep_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_productionorder_taskdep_v.CreatedBy) as CreatedByR, " +
      "        to_char(zssm_productionorder_taskdep_v.Updated, ?) as updated, " +
      "        to_char(zssm_productionorder_taskdep_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssm_productionorder_taskdep_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_productionorder_taskdep_v.UpdatedBy) as UpdatedByR," +
      "        zssm_productionorder_taskdep_v.Zssm_Productionorder_Taskdep_V_ID, " +
      "zssm_productionorder_taskdep_v.Zssm_ProductionOrder_V_ID, " +
      "(CASE WHEN zssm_productionorder_taskdep_v.Zssm_ProductionOrder_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS Zssm_ProductionOrder_V_IDR, " +
      "zssm_productionorder_taskdep_v.Zspm_Projecttaskdep_ID, " +
      "COALESCE(zssm_productionorder_taskdep_v.Isactive, 'N') AS Isactive, " +
      "zssm_productionorder_taskdep_v.SortNo, " +
      "zssm_productionorder_taskdep_v.AD_Client_ID, " +
      "zssm_productionorder_taskdep_v.DependsOnTask, " +
      "(CASE WHEN zssm_productionorder_taskdep_v.DependsOnTask IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS DependsOnTaskR, " +
      "zssm_productionorder_taskdep_v.AD_Org_ID, " +
      "zssm_productionorder_taskdep_v.C_Projecttask_ID, " +
      "(CASE WHEN zssm_productionorder_taskdep_v.C_Projecttask_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "zssm_productionorder_taskdep_v.Description, " +
      "COALESCE(zssm_productionorder_taskdep_v.StockRotation, 'N') AS StockRotation, " +
      "COALESCE(zssm_productionorder_taskdep_v.DependentStatusCheck, 'N') AS DependentStatusCheck, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_productionorder_taskdep_v left join (select Zssm_ProductionOrder_V_ID, Value, Name from Zssm_ProductionOrder_V) table1 on (zssm_productionorder_taskdep_v.Zssm_ProductionOrder_V_ID = table1.Zssm_ProductionOrder_V_ID) left join (select C_ProjectTask_ID, Name from C_ProjectTask) table2 on (zssm_productionorder_taskdep_v.DependsOnTask =  table2.C_ProjectTask_ID) left join (select C_ProjectTask_ID, Name from C_ProjectTask) table3 on (zssm_productionorder_taskdep_v.C_Projecttask_ID =  table3.C_ProjectTask_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssmProductionorderVId==null || zssmProductionorderVId.equals(""))?"":"  AND zssm_productionorder_taskdep_v.Zssm_ProductionOrder_V_ID = ?  ");
    strSql = strSql + 
      "        AND zssm_productionorder_taskdep_v.Zssm_Productionorder_Taskdep_V_ID = ? " +
      "        AND zssm_productionorder_taskdep_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssm_productionorder_taskdep_v.AD_Org_ID IN (";
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
      if (zssmProductionorderVId != null && !(zssmProductionorderVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
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
        SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data = new SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data();
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.created = UtilSql.getValue(result, "created");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.updated = UtilSql.getValue(result, "updated");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.zssmProductionorderTaskdepVId = UtilSql.getValue(result, "zssm_productionorder_taskdep_v_id");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.zssmProductionorderVId = UtilSql.getValue(result, "zssm_productionorder_v_id");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.zssmProductionorderVIdr = UtilSql.getValue(result, "zssm_productionorder_v_idr");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.zspmProjecttaskdepId = UtilSql.getValue(result, "zspm_projecttaskdep_id");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.isactive = UtilSql.getValue(result, "isactive");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.sortno = UtilSql.getValue(result, "sortno");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.dependsontask = UtilSql.getValue(result, "dependsontask");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.dependsontaskr = UtilSql.getValue(result, "dependsontaskr");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.description = UtilSql.getValue(result, "description");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.stockrotation = UtilSql.getValue(result, "stockrotation");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.dependentstatuscheck = UtilSql.getValue(result, "dependentstatuscheck");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.language = UtilSql.getValue(result, "language");
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.adUserClient = "";
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.adOrgClient = "";
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.createdby = "";
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.trBgcolor = "";
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.totalCount = "";
        objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data);
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
    SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[] = new SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[vector.size()];
    vector.copyInto(objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data);
    return(objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data);
  }

/**
Create a registry
 */
  public static SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[] set(String zssmProductionorderVId, String adClientId, String dependentstatuscheck, String adOrgId, String zssmProductionorderTaskdepVId, String isactive, String updatedby, String updatedbyr, String createdby, String createdbyr, String zspmProjecttaskdepId, String dependsontask, String stockrotation, String description, String cProjecttaskId, String sortno)    throws ServletException {
    SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[] = new SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[1];
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0] = new SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data();
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].created = "";
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].createdbyr = createdbyr;
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].updated = "";
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].updatedTimeStamp = "";
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].updatedby = updatedby;
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].updatedbyr = updatedbyr;
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].zssmProductionorderTaskdepVId = zssmProductionorderTaskdepVId;
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].zssmProductionorderVId = zssmProductionorderVId;
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].zssmProductionorderVIdr = "";
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].zspmProjecttaskdepId = zspmProjecttaskdepId;
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].isactive = isactive;
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].sortno = sortno;
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].adClientId = adClientId;
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].dependsontask = dependsontask;
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].dependsontaskr = "";
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].adOrgId = adOrgId;
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].cProjecttaskId = cProjecttaskId;
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].cProjecttaskIdr = "";
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].description = description;
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].stockrotation = stockrotation;
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].dependentstatuscheck = dependentstatuscheck;
    objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0].language = "";
    return objectSequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2A8B0CA9880E41CA9DA0A849E8FC55C3_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefC1218B169193460985C60C8E591DFA81_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT zssm_productionorder_taskdep_v.Zssm_ProductionOrder_V_ID AS NAME" +
      "        FROM zssm_productionorder_taskdep_v" +
      "        WHERE zssm_productionorder_taskdep_v.Zssm_Productionorder_Taskdep_V_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String zssmProductionorderVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zssm_productionorder_v left join (select Zssm_ProductionOrder_V_ID, Value, Name from Zssm_ProductionOrder_V) table1 on (zssm_productionorder_v.Zssm_ProductionOrder_V_ID = table1.Zssm_ProductionOrder_V_ID) WHERE zssm_productionorder_v.Zssm_ProductionOrder_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zssmProductionorderVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zssm_productionorder_v left join (select Zssm_ProductionOrder_V_ID, Value, Name from Zssm_ProductionOrder_V) table1 on (zssm_productionorder_v.Zssm_ProductionOrder_V_ID = table1.Zssm_ProductionOrder_V_ID) WHERE zssm_productionorder_v.Zssm_ProductionOrder_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);

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
      "        UPDATE zssm_productionorder_taskdep_v" +
      "        SET Zssm_Productionorder_Taskdep_V_ID = (?) , Zssm_ProductionOrder_V_ID = (?) , Zspm_Projecttaskdep_ID = (?) , Isactive = (?) , SortNo = TO_NUMBER(?) , AD_Client_ID = (?) , DependsOnTask = (?) , AD_Org_ID = (?) , C_Projecttask_ID = (?) , Description = (?) , StockRotation = (?) , DependentStatusCheck = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssm_productionorder_taskdep_v.Zssm_Productionorder_Taskdep_V_ID = ? " +
      "                 AND zssm_productionorder_taskdep_v.Zssm_ProductionOrder_V_ID = ? " +
      "        AND zssm_productionorder_taskdep_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_productionorder_taskdep_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderTaskdepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmProjecttaskdepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sortno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dependsontask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stockrotation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dependentstatuscheck);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderTaskdepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
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
      "        INSERT INTO zssm_productionorder_taskdep_v " +
      "        (Zssm_Productionorder_Taskdep_V_ID, Zssm_ProductionOrder_V_ID, Zspm_Projecttaskdep_ID, Isactive, SortNo, AD_Client_ID, DependsOnTask, AD_Org_ID, C_Projecttask_ID, Description, StockRotation, DependentStatusCheck, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderTaskdepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmProjecttaskdepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sortno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dependsontask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stockrotation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dependentstatuscheck);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zssmProductionorderVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_productionorder_taskdep_v" +
      "        WHERE zssm_productionorder_taskdep_v.Zssm_Productionorder_Taskdep_V_ID = ? " +
      "                 AND zssm_productionorder_taskdep_v.Zssm_ProductionOrder_V_ID = ? " +
      "        AND zssm_productionorder_taskdep_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_productionorder_taskdep_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zssmProductionorderVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_productionorder_taskdep_v" +
      "        WHERE zssm_productionorder_taskdep_v.Zssm_Productionorder_Taskdep_V_ID = ? " +
      "                 AND zssm_productionorder_taskdep_v.Zssm_ProductionOrder_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);

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
      "          FROM zssm_productionorder_taskdep_v" +
      "         WHERE zssm_productionorder_taskdep_v.Zssm_Productionorder_Taskdep_V_ID = ? ";

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
      "          FROM zssm_productionorder_taskdep_v" +
      "         WHERE zssm_productionorder_taskdep_v.Zssm_Productionorder_Taskdep_V_ID = ? ";

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
