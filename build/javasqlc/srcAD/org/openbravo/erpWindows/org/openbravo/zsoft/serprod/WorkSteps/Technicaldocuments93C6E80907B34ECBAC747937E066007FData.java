//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.WorkSteps;

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
class Technicaldocuments93C6E80907B34ECBAC747937E066007FData implements FieldProvider {
static Logger log4j = Logger.getLogger(Technicaldocuments93C6E80907B34ECBAC747937E066007FData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssmWorkstepPrpVId;
  public String zssmWorkstepPrpVIdr;
  public String zssmWorksteptechdocVId;
  public String zssmPtasktechdocId;
  public String isactive;
  public String adClientId;
  public String name;
  public String adOrgId;
  public String zssmTechdocUrl;
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
    else if (fieldName.equalsIgnoreCase("zssm_workstep_prp_v_id") || fieldName.equals("zssmWorkstepPrpVId"))
      return zssmWorkstepPrpVId;
    else if (fieldName.equalsIgnoreCase("zssm_workstep_prp_v_idr") || fieldName.equals("zssmWorkstepPrpVIdr"))
      return zssmWorkstepPrpVIdr;
    else if (fieldName.equalsIgnoreCase("zssm_worksteptechdoc_v_id") || fieldName.equals("zssmWorksteptechdocVId"))
      return zssmWorksteptechdocVId;
    else if (fieldName.equalsIgnoreCase("zssm_ptasktechdoc_id") || fieldName.equals("zssmPtasktechdocId"))
      return zssmPtasktechdocId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("zssm_techdoc_url") || fieldName.equals("zssmTechdocUrl"))
      return zssmTechdocUrl;
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
  public static Technicaldocuments93C6E80907B34ECBAC747937E066007FData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepPrpVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssmWorkstepPrpVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Technicaldocuments93C6E80907B34ECBAC747937E066007FData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepPrpVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssm_WorkstepTechDoc_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_WorkstepTechDoc_v.CreatedBy) as CreatedByR, " +
      "        to_char(zssm_WorkstepTechDoc_v.Updated, ?) as updated, " +
      "        to_char(zssm_WorkstepTechDoc_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssm_WorkstepTechDoc_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_WorkstepTechDoc_v.UpdatedBy) as UpdatedByR," +
      "        zssm_WorkstepTechDoc_v.Zssm_Workstep_Prp_V_ID, " +
      "(CASE WHEN zssm_WorkstepTechDoc_v.Zssm_Workstep_Prp_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.IsActive), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS Zssm_Workstep_Prp_V_IDR, " +
      "zssm_WorkstepTechDoc_v.Zssm_WorkstepTechDoc_V_ID, " +
      "zssm_WorkstepTechDoc_v.Zssm_PTaskTechDoc_ID, " +
      "COALESCE(zssm_WorkstepTechDoc_v.IsActive, 'N') AS IsActive, " +
      "zssm_WorkstepTechDoc_v.AD_Client_ID, " +
      "zssm_WorkstepTechDoc_v.Name, " +
      "zssm_WorkstepTechDoc_v.AD_Org_ID, " +
      "zssm_WorkstepTechDoc_v.Zssm_Techdoc_Url, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_WorkstepTechDoc_v left join (select Zssm_Workstep_Prp_V_ID, IsActive, Name, M_Product_ID from Zssm_Workstep_Prp_V) table1 on (zssm_WorkstepTechDoc_v.Zssm_Workstep_Prp_V_ID = table1.Zssm_Workstep_Prp_V_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssmWorkstepPrpVId==null || zssmWorkstepPrpVId.equals(""))?"":"  AND zssm_WorkstepTechDoc_v.Zssm_Workstep_Prp_V_ID = ?  ");
    strSql = strSql + 
      "        AND zssm_WorkstepTechDoc_v.Zssm_WorkstepTechDoc_V_ID = ? " +
      "        AND zssm_WorkstepTechDoc_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssm_WorkstepTechDoc_v.AD_Org_ID IN (";
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
      if (zssmWorkstepPrpVId != null && !(zssmWorkstepPrpVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);
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
        Technicaldocuments93C6E80907B34ECBAC747937E066007FData objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData = new Technicaldocuments93C6E80907B34ECBAC747937E066007FData();
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.created = UtilSql.getValue(result, "created");
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.updated = UtilSql.getValue(result, "updated");
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.zssmWorkstepPrpVId = UtilSql.getValue(result, "zssm_workstep_prp_v_id");
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.zssmWorkstepPrpVIdr = UtilSql.getValue(result, "zssm_workstep_prp_v_idr");
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.zssmWorksteptechdocVId = UtilSql.getValue(result, "zssm_worksteptechdoc_v_id");
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.zssmPtasktechdocId = UtilSql.getValue(result, "zssm_ptasktechdoc_id");
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.isactive = UtilSql.getValue(result, "isactive");
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.name = UtilSql.getValue(result, "name");
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.zssmTechdocUrl = UtilSql.getValue(result, "zssm_techdoc_url");
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.language = UtilSql.getValue(result, "language");
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.adUserClient = "";
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.adOrgClient = "";
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.createdby = "";
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.trBgcolor = "";
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.totalCount = "";
        objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData);
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
    Technicaldocuments93C6E80907B34ECBAC747937E066007FData objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[] = new Technicaldocuments93C6E80907B34ECBAC747937E066007FData[vector.size()];
    vector.copyInto(objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData);
    return(objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData);
  }

/**
Create a registry
 */
  public static Technicaldocuments93C6E80907B34ECBAC747937E066007FData[] set(String zssmWorkstepPrpVId, String updatedby, String updatedbyr, String isactive, String adOrgId, String zssmTechdocUrl, String adClientId, String createdby, String createdbyr, String zssmWorksteptechdocVId, String name, String zssmPtasktechdocId)    throws ServletException {
    Technicaldocuments93C6E80907B34ECBAC747937E066007FData objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[] = new Technicaldocuments93C6E80907B34ECBAC747937E066007FData[1];
    objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[0] = new Technicaldocuments93C6E80907B34ECBAC747937E066007FData();
    objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[0].created = "";
    objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[0].createdbyr = createdbyr;
    objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[0].updated = "";
    objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[0].updatedTimeStamp = "";
    objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[0].updatedby = updatedby;
    objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[0].updatedbyr = updatedbyr;
    objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[0].zssmWorkstepPrpVId = zssmWorkstepPrpVId;
    objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[0].zssmWorkstepPrpVIdr = "";
    objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[0].zssmWorksteptechdocVId = zssmWorksteptechdocVId;
    objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[0].zssmPtasktechdocId = zssmPtasktechdocId;
    objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[0].isactive = isactive;
    objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[0].adClientId = adClientId;
    objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[0].name = name;
    objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[0].adOrgId = adOrgId;
    objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[0].zssmTechdocUrl = zssmTechdocUrl;
    objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData[0].language = "";
    return objectTechnicaldocuments93C6E80907B34ECBAC747937E066007FData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefE9B6FB29578A4D5BB63FAFBCCCAF770B_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as UpdatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

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
  public static String selectDef0E43D1DC987A49B38E9F0586C4DFCE6B_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as CreatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

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
      "        SELECT zssm_WorkstepTechDoc_v.Zssm_Workstep_Prp_V_ID AS NAME" +
      "        FROM zssm_WorkstepTechDoc_v" +
      "        WHERE zssm_WorkstepTechDoc_v.Zssm_WorkstepTechDoc_V_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String zssmWorkstepPrpVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.IsActive), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))) AS NAME FROM zssm_workstep_prp_v left join (select Zssm_Workstep_Prp_V_ID, IsActive, Name, M_Product_ID from Zssm_Workstep_Prp_V) table1 on (zssm_workstep_prp_v.Zssm_Workstep_Prp_V_ID = table1.Zssm_Workstep_Prp_V_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  WHERE zssm_workstep_prp_v.Zssm_Workstep_Prp_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String zssmWorkstepPrpVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.IsActive), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))) AS NAME FROM zssm_workstep_prp_v left join (select Zssm_Workstep_Prp_V_ID, IsActive, Name, M_Product_ID from Zssm_Workstep_Prp_V) table1 on (zssm_workstep_prp_v.Zssm_Workstep_Prp_V_ID = table1.Zssm_Workstep_Prp_V_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  WHERE zssm_workstep_prp_v.Zssm_Workstep_Prp_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);

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
      "        UPDATE zssm_WorkstepTechDoc_v" +
      "        SET Zssm_Workstep_Prp_V_ID = (?) , Zssm_WorkstepTechDoc_V_ID = (?) , Zssm_PTaskTechDoc_ID = (?) , IsActive = (?) , AD_Client_ID = (?) , Name = (?) , AD_Org_ID = (?) , Zssm_Techdoc_Url = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssm_WorkstepTechDoc_v.Zssm_WorkstepTechDoc_V_ID = ? " +
      "                 AND zssm_WorkstepTechDoc_v.Zssm_Workstep_Prp_V_ID = ? " +
      "        AND zssm_WorkstepTechDoc_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_WorkstepTechDoc_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorksteptechdocVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmPtasktechdocId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmTechdocUrl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorksteptechdocVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);
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
      "        INSERT INTO zssm_WorkstepTechDoc_v " +
      "        (Zssm_Workstep_Prp_V_ID, Zssm_WorkstepTechDoc_V_ID, Zssm_PTaskTechDoc_ID, IsActive, AD_Client_ID, Name, AD_Org_ID, Zssm_Techdoc_Url, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorksteptechdocVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmPtasktechdocId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmTechdocUrl);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zssmWorkstepPrpVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_WorkstepTechDoc_v" +
      "        WHERE zssm_WorkstepTechDoc_v.Zssm_WorkstepTechDoc_V_ID = ? " +
      "                 AND zssm_WorkstepTechDoc_v.Zssm_Workstep_Prp_V_ID = ? " +
      "        AND zssm_WorkstepTechDoc_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_WorkstepTechDoc_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zssmWorkstepPrpVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_WorkstepTechDoc_v" +
      "        WHERE zssm_WorkstepTechDoc_v.Zssm_WorkstepTechDoc_V_ID = ? " +
      "                 AND zssm_WorkstepTechDoc_v.Zssm_Workstep_Prp_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);

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
      "          FROM zssm_WorkstepTechDoc_v" +
      "         WHERE zssm_WorkstepTechDoc_v.Zssm_WorkstepTechDoc_V_ID = ? ";

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
      "          FROM zssm_WorkstepTechDoc_v" +
      "         WHERE zssm_WorkstepTechDoc_v.Zssm_WorkstepTechDoc_V_ID = ? ";

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
