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
class Machines12D998D874EC463F88D0BEB2E3E89DEBData implements FieldProvider {
static Logger log4j = Logger.getLogger(Machines12D998D874EC463F88D0BEB2E3E89DEBData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssmWorkstepPrpVId;
  public String zssmWorkstepPrpVIdr;
  public String zspmPtaskmachineplanId;
  public String isactive;
  public String adClientId;
  public String adOrgId;
  public String maMachineId;
  public String maMachineIdr;
  public String averageduration;
  public String durationunit;
  public String durationunitr;
  public String quantity;
  public String costuom;
  public String zssmWorkstepmachinesVId;
  public String zssmSectionId;
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
    else if (fieldName.equalsIgnoreCase("zspm_ptaskmachineplan_id") || fieldName.equals("zspmPtaskmachineplanId"))
      return zspmPtaskmachineplanId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("ma_machine_idr") || fieldName.equals("maMachineIdr"))
      return maMachineIdr;
    else if (fieldName.equalsIgnoreCase("averageduration"))
      return averageduration;
    else if (fieldName.equalsIgnoreCase("durationunit"))
      return durationunit;
    else if (fieldName.equalsIgnoreCase("durationunitr"))
      return durationunitr;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("costuom"))
      return costuom;
    else if (fieldName.equalsIgnoreCase("zssm_workstepmachines_v_id") || fieldName.equals("zssmWorkstepmachinesVId"))
      return zssmWorkstepmachinesVId;
    else if (fieldName.equalsIgnoreCase("zssm_section_id") || fieldName.equals("zssmSectionId"))
      return zssmSectionId;
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
  public static Machines12D998D874EC463F88D0BEB2E3E89DEBData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepPrpVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssmWorkstepPrpVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Machines12D998D874EC463F88D0BEB2E3E89DEBData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepPrpVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssm_workstepmachines_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_workstepmachines_v.CreatedBy) as CreatedByR, " +
      "        to_char(zssm_workstepmachines_v.Updated, ?) as updated, " +
      "        to_char(zssm_workstepmachines_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssm_workstepmachines_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_workstepmachines_v.UpdatedBy) as UpdatedByR," +
      "        zssm_workstepmachines_v.Zssm_Workstep_Prp_V_ID, " +
      "(CASE WHEN zssm_workstepmachines_v.Zssm_Workstep_Prp_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.IsActive), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS Zssm_Workstep_Prp_V_IDR, " +
      "zssm_workstepmachines_v.Zspm_PTaskMachineplan_ID, " +
      "COALESCE(zssm_workstepmachines_v.IsActive, 'N') AS IsActive, " +
      "zssm_workstepmachines_v.AD_Client_ID, " +
      "zssm_workstepmachines_v.AD_Org_ID, " +
      "zssm_workstepmachines_v.MA_Machine_ID, " +
      "(CASE WHEN zssm_workstepmachines_v.MA_Machine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS MA_Machine_IDR, " +
      "zssm_workstepmachines_v.Averageduration, " +
      "zssm_workstepmachines_v.Durationunit, " +
      "(CASE WHEN zssm_workstepmachines_v.Durationunit IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DurationunitR, " +
      "zssm_workstepmachines_v.Quantity, " +
      "zssm_workstepmachines_v.Costuom, " +
      "zssm_workstepmachines_v.Zssm_WorkstepMachines_V_ID, " +
      "zssm_workstepmachines_v.zssm_section_id, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_workstepmachines_v left join (select Zssm_Workstep_Prp_V_ID, IsActive, Name, M_Product_ID from Zssm_Workstep_Prp_V) table1 on (zssm_workstepmachines_v.Zssm_Workstep_Prp_V_ID = table1.Zssm_Workstep_Prp_V_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  left join (select MA_Machine_ID, Value, Name from MA_Machine) table3 on (zssm_workstepmachines_v.MA_Machine_ID = table3.MA_Machine_ID) left join ad_ref_list_v list1 on (zssm_workstepmachines_v.Durationunit = list1.value and list1.ad_reference_id = 'E05D7AF076184420BE4F7A0CF8CCF806' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssmWorkstepPrpVId==null || zssmWorkstepPrpVId.equals(""))?"":"  AND zssm_workstepmachines_v.Zssm_Workstep_Prp_V_ID = ?  ");
    strSql = strSql + 
      "        AND zssm_workstepmachines_v.Zssm_WorkstepMachines_V_ID = ? " +
      "        AND zssm_workstepmachines_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssm_workstepmachines_v.AD_Org_ID IN (";
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
        Machines12D998D874EC463F88D0BEB2E3E89DEBData objectMachines12D998D874EC463F88D0BEB2E3E89DEBData = new Machines12D998D874EC463F88D0BEB2E3E89DEBData();
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.created = UtilSql.getValue(result, "created");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.updated = UtilSql.getValue(result, "updated");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.updatedby = UtilSql.getValue(result, "updatedby");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.zssmWorkstepPrpVId = UtilSql.getValue(result, "zssm_workstep_prp_v_id");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.zssmWorkstepPrpVIdr = UtilSql.getValue(result, "zssm_workstep_prp_v_idr");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.zspmPtaskmachineplanId = UtilSql.getValue(result, "zspm_ptaskmachineplan_id");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.isactive = UtilSql.getValue(result, "isactive");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.maMachineIdr = UtilSql.getValue(result, "ma_machine_idr");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.averageduration = UtilSql.getValue(result, "averageduration");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.durationunit = UtilSql.getValue(result, "durationunit");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.durationunitr = UtilSql.getValue(result, "durationunitr");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.quantity = UtilSql.getValue(result, "quantity");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.costuom = UtilSql.getValue(result, "costuom");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.zssmWorkstepmachinesVId = UtilSql.getValue(result, "zssm_workstepmachines_v_id");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.zssmSectionId = UtilSql.getValue(result, "zssm_section_id");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.language = UtilSql.getValue(result, "language");
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.adUserClient = "";
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.adOrgClient = "";
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.createdby = "";
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.trBgcolor = "";
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.totalCount = "";
        objectMachines12D998D874EC463F88D0BEB2E3E89DEBData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMachines12D998D874EC463F88D0BEB2E3E89DEBData);
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
    Machines12D998D874EC463F88D0BEB2E3E89DEBData objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[] = new Machines12D998D874EC463F88D0BEB2E3E89DEBData[vector.size()];
    vector.copyInto(objectMachines12D998D874EC463F88D0BEB2E3E89DEBData);
    return(objectMachines12D998D874EC463F88D0BEB2E3E89DEBData);
  }

/**
Create a registry
 */
  public static Machines12D998D874EC463F88D0BEB2E3E89DEBData[] set(String zssmWorkstepPrpVId, String adClientId, String createdby, String createdbyr, String zssmWorkstepmachinesVId, String zssmSectionId, String durationunit, String quantity, String adOrgId, String zspmPtaskmachineplanId, String maMachineId, String averageduration, String updatedby, String updatedbyr, String isactive, String costuom)    throws ServletException {
    Machines12D998D874EC463F88D0BEB2E3E89DEBData objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[] = new Machines12D998D874EC463F88D0BEB2E3E89DEBData[1];
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0] = new Machines12D998D874EC463F88D0BEB2E3E89DEBData();
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].created = "";
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].createdbyr = createdbyr;
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].updated = "";
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].updatedTimeStamp = "";
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].updatedby = updatedby;
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].updatedbyr = updatedbyr;
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].zssmWorkstepPrpVId = zssmWorkstepPrpVId;
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].zssmWorkstepPrpVIdr = "";
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].zspmPtaskmachineplanId = zspmPtaskmachineplanId;
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].isactive = isactive;
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].adClientId = adClientId;
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].adOrgId = adOrgId;
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].maMachineId = maMachineId;
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].maMachineIdr = "";
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].averageduration = averageduration;
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].durationunit = durationunit;
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].durationunitr = "";
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].quantity = quantity;
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].costuom = costuom;
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].zssmWorkstepmachinesVId = zssmWorkstepmachinesVId;
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].zssmSectionId = zssmSectionId;
    objectMachines12D998D874EC463F88D0BEB2E3E89DEBData[0].language = "";
    return objectMachines12D998D874EC463F88D0BEB2E3E89DEBData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1D57B6EC9F064BE2A6E3ECDA5203393C_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDef903367F0D7AE44939A90667F509981E3_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zssm_workstepmachines_v.Zssm_Workstep_Prp_V_ID AS NAME" +
      "        FROM zssm_workstepmachines_v" +
      "        WHERE zssm_workstepmachines_v.Zssm_WorkstepMachines_V_ID = ?";

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
      "        UPDATE zssm_workstepmachines_v" +
      "        SET Zssm_Workstep_Prp_V_ID = (?) , Zspm_PTaskMachineplan_ID = (?) , IsActive = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , MA_Machine_ID = (?) , Averageduration = TO_NUMBER(?) , Durationunit = (?) , Quantity = TO_NUMBER(?) , Costuom = (?) , Zssm_WorkstepMachines_V_ID = (?) , zssm_section_id = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssm_workstepmachines_v.Zssm_WorkstepMachines_V_ID = ? " +
      "                 AND zssm_workstepmachines_v.Zssm_Workstep_Prp_V_ID = ? " +
      "        AND zssm_workstepmachines_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_workstepmachines_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskmachineplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, averageduration);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, durationunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepmachinesVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmSectionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepmachinesVId);
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
      "        INSERT INTO zssm_workstepmachines_v " +
      "        (Zssm_Workstep_Prp_V_ID, Zspm_PTaskMachineplan_ID, IsActive, AD_Client_ID, AD_Org_ID, MA_Machine_ID, Averageduration, Durationunit, Quantity, Costuom, Zssm_WorkstepMachines_V_ID, zssm_section_id, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskmachineplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, averageduration);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, durationunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepmachinesVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmSectionId);
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
      "        DELETE FROM zssm_workstepmachines_v" +
      "        WHERE zssm_workstepmachines_v.Zssm_WorkstepMachines_V_ID = ? " +
      "                 AND zssm_workstepmachines_v.Zssm_Workstep_Prp_V_ID = ? " +
      "        AND zssm_workstepmachines_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_workstepmachines_v.AD_Org_ID IN (";
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
      "        DELETE FROM zssm_workstepmachines_v" +
      "        WHERE zssm_workstepmachines_v.Zssm_WorkstepMachines_V_ID = ? " +
      "                 AND zssm_workstepmachines_v.Zssm_Workstep_Prp_V_ID = ? ";

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
      "          FROM zssm_workstepmachines_v" +
      "         WHERE zssm_workstepmachines_v.Zssm_WorkstepMachines_V_ID = ? ";

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
      "          FROM zssm_workstepmachines_v" +
      "         WHERE zssm_workstepmachines_v.Zssm_WorkstepMachines_V_ID = ? ";

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
