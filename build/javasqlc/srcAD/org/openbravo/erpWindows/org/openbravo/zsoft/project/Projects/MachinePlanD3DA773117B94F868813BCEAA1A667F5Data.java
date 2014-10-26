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
class MachinePlanD3DA773117B94F868813BCEAA1A667F5Data implements FieldProvider {
static Logger log4j = Logger.getLogger(MachinePlanD3DA773117B94F868813BCEAA1A667F5Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String zspmPtaskmachineplanId;
  public String adClientId;
  public String isactive;
  public String adOrgId;
  public String maMachineId;
  public String maMachineIdr;
  public String quantity;
  public String costuom;
  public String costuomr;
  public String datefrom;
  public String dateto;
  public String plannedamt;
  public String planndedpercent;
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
    else if (fieldName.equalsIgnoreCase("zspm_ptaskmachineplan_id") || fieldName.equals("zspmPtaskmachineplanId"))
      return zspmPtaskmachineplanId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("ma_machine_idr") || fieldName.equals("maMachineIdr"))
      return maMachineIdr;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("costuom"))
      return costuom;
    else if (fieldName.equalsIgnoreCase("costuomr"))
      return costuomr;
    else if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("dateto"))
      return dateto;
    else if (fieldName.equalsIgnoreCase("plannedamt"))
      return plannedamt;
    else if (fieldName.equalsIgnoreCase("planndedpercent"))
      return planndedpercent;
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
  public static MachinePlanD3DA773117B94F868813BCEAA1A667F5Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjecttaskId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cProjecttaskId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static MachinePlanD3DA773117B94F868813BCEAA1A667F5Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjecttaskId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspm_ptaskmachineplan.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_ptaskmachineplan.CreatedBy) as CreatedByR, " +
      "        to_char(zspm_ptaskmachineplan.Updated, ?) as updated, " +
      "        to_char(zspm_ptaskmachineplan.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspm_ptaskmachineplan.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_ptaskmachineplan.UpdatedBy) as UpdatedByR," +
      "        zspm_ptaskmachineplan.C_Projecttask_ID, " +
      "(CASE WHEN zspm_ptaskmachineplan.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "zspm_ptaskmachineplan.Zspm_Ptaskmachineplan_ID, " +
      "zspm_ptaskmachineplan.AD_Client_ID, " +
      "COALESCE(zspm_ptaskmachineplan.Isactive, 'N') AS Isactive, " +
      "zspm_ptaskmachineplan.AD_Org_ID, " +
      "zspm_ptaskmachineplan.MA_Machine_ID, " +
      "(CASE WHEN zspm_ptaskmachineplan.MA_Machine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS MA_Machine_IDR, " +
      "zspm_ptaskmachineplan.Quantity, " +
      "zspm_ptaskmachineplan.Costuom, " +
      "(CASE WHEN zspm_ptaskmachineplan.Costuom IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS CostuomR, " +
      "zspm_ptaskmachineplan.Datefrom, " +
      "zspm_ptaskmachineplan.Dateto, " +
      "zspm_ptaskmachineplan.Plannedamt, " +
      "zspm_ptaskmachineplan.Planndedpercent, " +
      "        ? AS LANGUAGE " +
      "        FROM zspm_ptaskmachineplan left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table1 on (zspm_ptaskmachineplan.C_Projecttask_ID = table1.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (table1.C_Project_ID = table2.C_Project_ID) left join (select MA_Machine_ID, Value, Name from MA_Machine) table3 on (zspm_ptaskmachineplan.MA_Machine_ID = table3.MA_Machine_ID) left join ad_ref_list_v list1 on (zspm_ptaskmachineplan.Costuom = list1.value and list1.ad_reference_id = 'DE781226949D4A9F8782BA610C3621C6' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cProjecttaskId==null || cProjecttaskId.equals(""))?"":"  AND zspm_ptaskmachineplan.C_Projecttask_ID = ?  ");
    strSql = strSql + 
      "        AND zspm_ptaskmachineplan.Zspm_Ptaskmachineplan_ID = ? " +
      "        AND zspm_ptaskmachineplan.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zspm_ptaskmachineplan.AD_Org_ID IN (";
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
        MachinePlanD3DA773117B94F868813BCEAA1A667F5Data objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data = new MachinePlanD3DA773117B94F868813BCEAA1A667F5Data();
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.created = UtilSql.getValue(result, "created");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.updated = UtilSql.getValue(result, "updated");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.zspmPtaskmachineplanId = UtilSql.getValue(result, "zspm_ptaskmachineplan_id");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.isactive = UtilSql.getValue(result, "isactive");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.maMachineIdr = UtilSql.getValue(result, "ma_machine_idr");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.quantity = UtilSql.getValue(result, "quantity");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.costuom = UtilSql.getValue(result, "costuom");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.costuomr = UtilSql.getValue(result, "costuomr");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.planndedpercent = UtilSql.getValue(result, "planndedpercent");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.language = UtilSql.getValue(result, "language");
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.adUserClient = "";
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.adOrgClient = "";
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.createdby = "";
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.trBgcolor = "";
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.totalCount = "";
        objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data);
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
    MachinePlanD3DA773117B94F868813BCEAA1A667F5Data objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[] = new MachinePlanD3DA773117B94F868813BCEAA1A667F5Data[vector.size()];
    vector.copyInto(objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data);
    return(objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data);
  }

/**
Create a registry
 */
  public static MachinePlanD3DA773117B94F868813BCEAA1A667F5Data[] set(String cProjecttaskId, String adClientId, String createdby, String createdbyr, String adOrgId, String datefrom, String dateto, String maMachineId, String isactive, String zspmPtaskmachineplanId, String plannedamt, String quantity, String costuom, String planndedpercent, String updatedby, String updatedbyr)    throws ServletException {
    MachinePlanD3DA773117B94F868813BCEAA1A667F5Data objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[] = new MachinePlanD3DA773117B94F868813BCEAA1A667F5Data[1];
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0] = new MachinePlanD3DA773117B94F868813BCEAA1A667F5Data();
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].created = "";
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].createdbyr = createdbyr;
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].updated = "";
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].updatedTimeStamp = "";
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].updatedby = updatedby;
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].updatedbyr = updatedbyr;
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].cProjecttaskId = cProjecttaskId;
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].cProjecttaskIdr = "";
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].zspmPtaskmachineplanId = zspmPtaskmachineplanId;
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].adClientId = adClientId;
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].isactive = isactive;
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].adOrgId = adOrgId;
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].maMachineId = maMachineId;
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].maMachineIdr = "";
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].quantity = quantity;
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].costuom = costuom;
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].costuomr = "";
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].datefrom = datefrom;
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].dateto = dateto;
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].plannedamt = plannedamt;
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].planndedpercent = planndedpercent;
    objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data[0].language = "";
    return objectMachinePlanD3DA773117B94F868813BCEAA1A667F5Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef7040A3DED26F4DDBBC5B0790E3AA76DC_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef8BE5FB2E250B493E9B44754507C2E6E4_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT zspm_ptaskmachineplan.C_Projecttask_ID AS NAME" +
      "        FROM zspm_ptaskmachineplan" +
      "        WHERE zspm_ptaskmachineplan.Zspm_Ptaskmachineplan_ID = ?";

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
      "        UPDATE zspm_ptaskmachineplan" +
      "        SET C_Projecttask_ID = (?) , Zspm_Ptaskmachineplan_ID = (?) , AD_Client_ID = (?) , Isactive = (?) , AD_Org_ID = (?) , MA_Machine_ID = (?) , Quantity = TO_NUMBER(?) , Costuom = (?) , Datefrom = TO_DATE(?) , Dateto = TO_DATE(?) , Plannedamt = TO_NUMBER(?) , Planndedpercent = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE zspm_ptaskmachineplan.Zspm_Ptaskmachineplan_ID = ? " +
      "                 AND zspm_ptaskmachineplan.C_Projecttask_ID = ? " +
      "        AND zspm_ptaskmachineplan.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_ptaskmachineplan.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskmachineplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planndedpercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskmachineplanId);
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
      "        INSERT INTO zspm_ptaskmachineplan " +
      "        (C_Projecttask_ID, Zspm_Ptaskmachineplan_ID, AD_Client_ID, Isactive, AD_Org_ID, MA_Machine_ID, Quantity, Costuom, Datefrom, Dateto, Plannedamt, Planndedpercent, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskmachineplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planndedpercent);
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
      "        DELETE FROM zspm_ptaskmachineplan" +
      "        WHERE zspm_ptaskmachineplan.Zspm_Ptaskmachineplan_ID = ? " +
      "                 AND zspm_ptaskmachineplan.C_Projecttask_ID = ? " +
      "        AND zspm_ptaskmachineplan.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_ptaskmachineplan.AD_Org_ID IN (";
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
      "        DELETE FROM zspm_ptaskmachineplan" +
      "        WHERE zspm_ptaskmachineplan.Zspm_Ptaskmachineplan_ID = ? " +
      "                 AND zspm_ptaskmachineplan.C_Projecttask_ID = ? ";

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
      "          FROM zspm_ptaskmachineplan" +
      "         WHERE zspm_ptaskmachineplan.Zspm_Ptaskmachineplan_ID = ? ";

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
      "          FROM zspm_ptaskmachineplan" +
      "         WHERE zspm_ptaskmachineplan.Zspm_Ptaskmachineplan_ID = ? ";

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
