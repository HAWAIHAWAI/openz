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
class Technicaldocuments67B2887D8FE040AE96053F090478F7E2Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Technicaldocuments67B2887D8FE040AE96053F090478F7E2Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssmWorkstepVId;
  public String zssmWorkstepVIdr;
  public String isactive;
  public String adClientId;
  public String name;
  public String adOrgId;
  public String zssmTechdocUrl;
  public String zssmWorksteptechdocVId;
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
    else if (fieldName.equalsIgnoreCase("zssm_workstep_v_id") || fieldName.equals("zssmWorkstepVId"))
      return zssmWorkstepVId;
    else if (fieldName.equalsIgnoreCase("zssm_workstep_v_idr") || fieldName.equals("zssmWorkstepVIdr"))
      return zssmWorkstepVIdr;
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
    else if (fieldName.equalsIgnoreCase("zssm_worksteptechdoc_v_id") || fieldName.equals("zssmWorksteptechdocVId"))
      return zssmWorksteptechdocVId;
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
  public static Technicaldocuments67B2887D8FE040AE96053F090478F7E2Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssmWorkstepVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Technicaldocuments67B2887D8FE040AE96053F090478F7E2Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssm_WorkstepTechDoc_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_WorkstepTechDoc_v.CreatedBy) as CreatedByR, " +
      "        to_char(zssm_WorkstepTechDoc_v.Updated, ?) as updated, " +
      "        to_char(zssm_WorkstepTechDoc_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssm_WorkstepTechDoc_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_WorkstepTechDoc_v.UpdatedBy) as UpdatedByR," +
      "        zssm_WorkstepTechDoc_v.Zssm_Workstep_V_ID, " +
      "(CASE WHEN zssm_WorkstepTechDoc_v.Zssm_Workstep_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Zssm_Prj_Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.SeqNo), ''))),'') ) END) AS Zssm_Workstep_V_IDR, " +
      "COALESCE(zssm_WorkstepTechDoc_v.IsActive, 'N') AS IsActive, " +
      "zssm_WorkstepTechDoc_v.AD_Client_ID, " +
      "zssm_WorkstepTechDoc_v.Name, " +
      "zssm_WorkstepTechDoc_v.AD_Org_ID, " +
      "zssm_WorkstepTechDoc_v.Zssm_Techdoc_Url, " +
      "zssm_WorkstepTechDoc_v.Zssm_WorkstepTechDoc_V_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_WorkstepTechDoc_v left join (select Zssm_Workstep_V_ID, Value, Name, Zssm_Prj_Name, SeqNo from Zssm_Workstep_V) table1 on (zssm_WorkstepTechDoc_v.Zssm_Workstep_V_ID = table1.Zssm_Workstep_V_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssmWorkstepVId==null || zssmWorkstepVId.equals(""))?"":"  AND zssm_WorkstepTechDoc_v.Zssm_Workstep_V_ID = ?  ");
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
      if (zssmWorkstepVId != null && !(zssmWorkstepVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
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
        Technicaldocuments67B2887D8FE040AE96053F090478F7E2Data objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data = new Technicaldocuments67B2887D8FE040AE96053F090478F7E2Data();
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.created = UtilSql.getValue(result, "created");
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.updated = UtilSql.getValue(result, "updated");
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.zssmWorkstepVId = UtilSql.getValue(result, "zssm_workstep_v_id");
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.zssmWorkstepVIdr = UtilSql.getValue(result, "zssm_workstep_v_idr");
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.isactive = UtilSql.getValue(result, "isactive");
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.name = UtilSql.getValue(result, "name");
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.zssmTechdocUrl = UtilSql.getValue(result, "zssm_techdoc_url");
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.zssmWorksteptechdocVId = UtilSql.getValue(result, "zssm_worksteptechdoc_v_id");
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.language = UtilSql.getValue(result, "language");
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.adUserClient = "";
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.adOrgClient = "";
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.createdby = "";
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.trBgcolor = "";
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.totalCount = "";
        objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data);
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
    Technicaldocuments67B2887D8FE040AE96053F090478F7E2Data objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[] = new Technicaldocuments67B2887D8FE040AE96053F090478F7E2Data[vector.size()];
    vector.copyInto(objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data);
    return(objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data);
  }

/**
Create a registry
 */
  public static Technicaldocuments67B2887D8FE040AE96053F090478F7E2Data[] set(String zssmWorkstepVId, String updatedby, String updatedbyr, String isactive, String adOrgId, String zssmTechdocUrl, String adClientId, String createdby, String createdbyr, String name, String zssmWorksteptechdocVId)    throws ServletException {
    Technicaldocuments67B2887D8FE040AE96053F090478F7E2Data objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[] = new Technicaldocuments67B2887D8FE040AE96053F090478F7E2Data[1];
    objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[0] = new Technicaldocuments67B2887D8FE040AE96053F090478F7E2Data();
    objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[0].created = "";
    objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[0].createdbyr = createdbyr;
    objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[0].updated = "";
    objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[0].updatedTimeStamp = "";
    objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[0].updatedby = updatedby;
    objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[0].updatedbyr = updatedbyr;
    objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[0].zssmWorkstepVId = zssmWorkstepVId;
    objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[0].zssmWorkstepVIdr = "";
    objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[0].isactive = isactive;
    objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[0].adClientId = adClientId;
    objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[0].name = name;
    objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[0].adOrgId = adOrgId;
    objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[0].zssmTechdocUrl = zssmTechdocUrl;
    objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[0].zssmWorksteptechdocVId = zssmWorksteptechdocVId;
    objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data[0].language = "";
    return objectTechnicaldocuments67B2887D8FE040AE96053F090478F7E2Data;
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
      "        SELECT zssm_WorkstepTechDoc_v.Zssm_Workstep_V_ID AS NAME" +
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
  public static String selectParent(ConnectionProvider connectionProvider, String zssmWorkstepVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Zssm_Prj_Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.SeqNo), ''))) AS NAME FROM zssm_workstep_v left join (select Zssm_Workstep_V_ID, Value, Name, Zssm_Prj_Name, SeqNo from Zssm_Workstep_V) table1 on (zssm_workstep_v.Zssm_Workstep_V_ID = table1.Zssm_Workstep_V_ID) WHERE zssm_workstep_v.Zssm_Workstep_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zssmWorkstepVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Zssm_Prj_Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.SeqNo), ''))) AS NAME FROM zssm_workstep_v left join (select Zssm_Workstep_V_ID, Value, Name, Zssm_Prj_Name, SeqNo from Zssm_Workstep_V) table1 on (zssm_workstep_v.Zssm_Workstep_V_ID = table1.Zssm_Workstep_V_ID) WHERE zssm_workstep_v.Zssm_Workstep_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);

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
      "        SET Zssm_Workstep_V_ID = (?) , IsActive = (?) , AD_Client_ID = (?) , Name = (?) , AD_Org_ID = (?) , Zssm_Techdoc_Url = (?) , Zssm_WorkstepTechDoc_V_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssm_WorkstepTechDoc_v.Zssm_WorkstepTechDoc_V_ID = ? " +
      "                 AND zssm_WorkstepTechDoc_v.Zssm_Workstep_V_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmTechdocUrl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorksteptechdocVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorksteptechdocVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
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
      "        (Zssm_Workstep_V_ID, IsActive, AD_Client_ID, Name, AD_Org_ID, Zssm_Techdoc_Url, Zssm_WorkstepTechDoc_V_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmTechdocUrl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorksteptechdocVId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zssmWorkstepVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_WorkstepTechDoc_v" +
      "        WHERE zssm_WorkstepTechDoc_v.Zssm_WorkstepTechDoc_V_ID = ? " +
      "                 AND zssm_WorkstepTechDoc_v.Zssm_Workstep_V_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zssmWorkstepVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_WorkstepTechDoc_v" +
      "        WHERE zssm_WorkstepTechDoc_v.Zssm_WorkstepTechDoc_V_ID = ? " +
      "                 AND zssm_WorkstepTechDoc_v.Zssm_Workstep_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);

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
