//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.InternalMaterialMovements;

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
class InternalMaterialMovementsData implements FieldProvider {
static Logger log4j = Logger.getLogger(InternalMaterialMovementsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String documentno;
  public String movementtype;
  public String movementtyper;
  public String name;
  public String description;
  public String movementdate;
  public String dateacct;
  public String aAssetId;
  public String aAssetIdr;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String processed;
  public String processing;
  public String posted;
  public String cProjectphaseId;
  public String mInternalConsumptionId;
  public String copyfromprojecttask;
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
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("movementtype"))
      return movementtype;
    else if (fieldName.equalsIgnoreCase("movementtyper"))
      return movementtyper;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
    else if (fieldName.equalsIgnoreCase("m_internal_consumption_id") || fieldName.equals("mInternalConsumptionId"))
      return mInternalConsumptionId;
    else if (fieldName.equalsIgnoreCase("copyfromprojecttask"))
      return copyfromprojecttask;
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
  public static InternalMaterialMovementsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static InternalMaterialMovementsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_Internal_Consumption.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Internal_Consumption.CreatedBy) as CreatedByR, " +
      "        to_char(M_Internal_Consumption.Updated, ?) as updated, " +
      "        to_char(M_Internal_Consumption.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_Internal_Consumption.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Internal_Consumption.UpdatedBy) as UpdatedByR," +
      "        M_Internal_Consumption.AD_Client_ID, " +
      "(CASE WHEN M_Internal_Consumption.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "M_Internal_Consumption.AD_Org_ID, " +
      "(CASE WHEN M_Internal_Consumption.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "M_Internal_Consumption.DocumentNo, " +
      "M_Internal_Consumption.Movementtype, " +
      "(CASE WHEN M_Internal_Consumption.Movementtype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS MovementtypeR, " +
      "M_Internal_Consumption.Name, " +
      "M_Internal_Consumption.Description, " +
      "M_Internal_Consumption.MovementDate, " +
      "M_Internal_Consumption.Dateacct, " +
      "M_Internal_Consumption.A_Asset_ID, " +
      "(CASE WHEN M_Internal_Consumption.A_Asset_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "M_Internal_Consumption.C_Project_ID, " +
      "(CASE WHEN M_Internal_Consumption.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "M_Internal_Consumption.C_Projecttask_ID, " +
      "(CASE WHEN M_Internal_Consumption.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "COALESCE(M_Internal_Consumption.Processed, 'N') AS Processed, " +
      "M_Internal_Consumption.Processing, " +
      "M_Internal_Consumption.Posted, " +
      "M_Internal_Consumption.C_Projectphase_ID, " +
      "M_Internal_Consumption.M_Internal_Consumption_ID, " +
      "M_Internal_Consumption.Copyfromprojecttask, " +
      "COALESCE(M_Internal_Consumption.IsActive, 'N') AS IsActive, " +
      "        ? AS LANGUAGE " +
      "        FROM M_Internal_Consumption left join (select AD_Client_ID, Name from AD_Client) table1 on (M_Internal_Consumption.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (M_Internal_Consumption.AD_Org_ID = table2.AD_Org_ID) left join ad_ref_list_v list1 on (M_Internal_Consumption.Movementtype = list1.value and list1.ad_reference_id = '362FC668AFAA4120A2E7F9B6A22FAE4C' and list1.ad_language = ?)  left join (select A_Asset_ID, Name from A_Asset) table3 on (M_Internal_Consumption.A_Asset_ID = table3.A_Asset_ID) left join (select C_Project_ID, Value, Name from C_Project) table4 on (M_Internal_Consumption.C_Project_ID = table4.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table5 on (M_Internal_Consumption.C_Projecttask_ID = table5.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table6 on (table5.C_Project_ID = table6.C_Project_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND M_Internal_Consumption.M_Internal_Consumption_ID = ? " +
      "        AND M_Internal_Consumption.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND M_Internal_Consumption.AD_Org_ID IN (";
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
        InternalMaterialMovementsData objectInternalMaterialMovementsData = new InternalMaterialMovementsData();
        objectInternalMaterialMovementsData.created = UtilSql.getValue(result, "created");
        objectInternalMaterialMovementsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectInternalMaterialMovementsData.updated = UtilSql.getValue(result, "updated");
        objectInternalMaterialMovementsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectInternalMaterialMovementsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectInternalMaterialMovementsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectInternalMaterialMovementsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectInternalMaterialMovementsData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectInternalMaterialMovementsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectInternalMaterialMovementsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectInternalMaterialMovementsData.documentno = UtilSql.getValue(result, "documentno");
        objectInternalMaterialMovementsData.movementtype = UtilSql.getValue(result, "movementtype");
        objectInternalMaterialMovementsData.movementtyper = UtilSql.getValue(result, "movementtyper");
        objectInternalMaterialMovementsData.name = UtilSql.getValue(result, "name");
        objectInternalMaterialMovementsData.description = UtilSql.getValue(result, "description");
        objectInternalMaterialMovementsData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectInternalMaterialMovementsData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectInternalMaterialMovementsData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectInternalMaterialMovementsData.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectInternalMaterialMovementsData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectInternalMaterialMovementsData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectInternalMaterialMovementsData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectInternalMaterialMovementsData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectInternalMaterialMovementsData.processed = UtilSql.getValue(result, "processed");
        objectInternalMaterialMovementsData.processing = UtilSql.getValue(result, "processing");
        objectInternalMaterialMovementsData.posted = UtilSql.getValue(result, "posted");
        objectInternalMaterialMovementsData.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectInternalMaterialMovementsData.mInternalConsumptionId = UtilSql.getValue(result, "m_internal_consumption_id");
        objectInternalMaterialMovementsData.copyfromprojecttask = UtilSql.getValue(result, "copyfromprojecttask");
        objectInternalMaterialMovementsData.isactive = UtilSql.getValue(result, "isactive");
        objectInternalMaterialMovementsData.language = UtilSql.getValue(result, "language");
        objectInternalMaterialMovementsData.adUserClient = "";
        objectInternalMaterialMovementsData.adOrgClient = "";
        objectInternalMaterialMovementsData.createdby = "";
        objectInternalMaterialMovementsData.trBgcolor = "";
        objectInternalMaterialMovementsData.totalCount = "";
        objectInternalMaterialMovementsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInternalMaterialMovementsData);
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
    InternalMaterialMovementsData objectInternalMaterialMovementsData[] = new InternalMaterialMovementsData[vector.size()];
    vector.copyInto(objectInternalMaterialMovementsData);
    return(objectInternalMaterialMovementsData);
  }

/**
Create a registry
 */
  public static InternalMaterialMovementsData[] set(String processing, String movementdate, String mInternalConsumptionId, String aAssetId, String copyfromprojecttask, String name, String movementtype, String adClientId, String processed, String description, String adOrgId, String cProjectId, String cProjectIdr, String updatedby, String updatedbyr, String cProjectphaseId, String createdby, String createdbyr, String isactive, String documentno, String cProjecttaskId, String dateacct, String posted)    throws ServletException {
    InternalMaterialMovementsData objectInternalMaterialMovementsData[] = new InternalMaterialMovementsData[1];
    objectInternalMaterialMovementsData[0] = new InternalMaterialMovementsData();
    objectInternalMaterialMovementsData[0].created = "";
    objectInternalMaterialMovementsData[0].createdbyr = createdbyr;
    objectInternalMaterialMovementsData[0].updated = "";
    objectInternalMaterialMovementsData[0].updatedTimeStamp = "";
    objectInternalMaterialMovementsData[0].updatedby = updatedby;
    objectInternalMaterialMovementsData[0].updatedbyr = updatedbyr;
    objectInternalMaterialMovementsData[0].adClientId = adClientId;
    objectInternalMaterialMovementsData[0].adClientIdr = "";
    objectInternalMaterialMovementsData[0].adOrgId = adOrgId;
    objectInternalMaterialMovementsData[0].adOrgIdr = "";
    objectInternalMaterialMovementsData[0].documentno = documentno;
    objectInternalMaterialMovementsData[0].movementtype = movementtype;
    objectInternalMaterialMovementsData[0].movementtyper = "";
    objectInternalMaterialMovementsData[0].name = name;
    objectInternalMaterialMovementsData[0].description = description;
    objectInternalMaterialMovementsData[0].movementdate = movementdate;
    objectInternalMaterialMovementsData[0].dateacct = dateacct;
    objectInternalMaterialMovementsData[0].aAssetId = aAssetId;
    objectInternalMaterialMovementsData[0].aAssetIdr = "";
    objectInternalMaterialMovementsData[0].cProjectId = cProjectId;
    objectInternalMaterialMovementsData[0].cProjectIdr = cProjectIdr;
    objectInternalMaterialMovementsData[0].cProjecttaskId = cProjecttaskId;
    objectInternalMaterialMovementsData[0].cProjecttaskIdr = "";
    objectInternalMaterialMovementsData[0].processed = processed;
    objectInternalMaterialMovementsData[0].processing = processing;
    objectInternalMaterialMovementsData[0].posted = posted;
    objectInternalMaterialMovementsData[0].cProjectphaseId = cProjectphaseId;
    objectInternalMaterialMovementsData[0].mInternalConsumptionId = mInternalConsumptionId;
    objectInternalMaterialMovementsData[0].copyfromprojecttask = copyfromprojecttask;
    objectInternalMaterialMovementsData[0].isactive = isactive;
    objectInternalMaterialMovementsData[0].language = "";
    return objectInternalMaterialMovementsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef47EA6E294B68429BB1D2A2F5295BCDD4_0(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as C_Project_ID FROM C_Project table1 WHERE table1.isActive='Y' AND table1.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_project_id");
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
  public static String selectDef802755_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef802753_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        UPDATE M_Internal_Consumption" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , DocumentNo = (?) , Movementtype = (?) , Name = (?) , Description = (?) , MovementDate = TO_DATE(?) , Dateacct = TO_DATE(?) , A_Asset_ID = (?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , Processed = (?) , Processing = (?) , Posted = (?) , C_Projectphase_ID = (?) , M_Internal_Consumption_ID = (?) , Copyfromprojecttask = (?) , IsActive = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_Internal_Consumption.M_Internal_Consumption_ID = ? " +
      "        AND M_Internal_Consumption.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Internal_Consumption.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfromprojecttask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionId);
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
      "        INSERT INTO M_Internal_Consumption " +
      "        (AD_Client_ID, AD_Org_ID, DocumentNo, Movementtype, Name, Description, MovementDate, Dateacct, A_Asset_ID, C_Project_ID, C_Projecttask_ID, Processed, Processing, Posted, C_Projectphase_ID, M_Internal_Consumption_ID, Copyfromprojecttask, IsActive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfromprojecttask);
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
      "        DELETE FROM M_Internal_Consumption" +
      "        WHERE M_Internal_Consumption.M_Internal_Consumption_ID = ? " +
      "        AND M_Internal_Consumption.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Internal_Consumption.AD_Org_ID IN (";
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
      "        DELETE FROM M_Internal_Consumption" +
      "        WHERE M_Internal_Consumption.M_Internal_Consumption_ID = ? ";

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
      "          FROM M_Internal_Consumption" +
      "         WHERE M_Internal_Consumption.M_Internal_Consumption_ID = ? ";

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
      "          FROM M_Internal_Consumption" +
      "         WHERE M_Internal_Consumption.M_Internal_Consumption_ID = ? ";

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
