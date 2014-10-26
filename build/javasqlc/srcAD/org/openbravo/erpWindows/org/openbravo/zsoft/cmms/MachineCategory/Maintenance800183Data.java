//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.cmms.MachineCategory;

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
class Maintenance800183Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Maintenance800183Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String maMaintenanceId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String maMachineTypeId;
  public String maMachineTypeIdr;
  public String name;
  public String description;
  public String isactive;
  public String maintenanceType;
  public String maintenanceTyper;
  public String maMaintOperationId;
  public String maMaintOperationIdr;
  public String plannedtime;
  public String explode;
  public String maMachineId;
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
    else if (fieldName.equalsIgnoreCase("ma_maintenance_id") || fieldName.equals("maMaintenanceId"))
      return maMaintenanceId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ma_machine_type_id") || fieldName.equals("maMachineTypeId"))
      return maMachineTypeId;
    else if (fieldName.equalsIgnoreCase("ma_machine_type_idr") || fieldName.equals("maMachineTypeIdr"))
      return maMachineTypeIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("maintenance_type") || fieldName.equals("maintenanceType"))
      return maintenanceType;
    else if (fieldName.equalsIgnoreCase("maintenance_typer") || fieldName.equals("maintenanceTyper"))
      return maintenanceTyper;
    else if (fieldName.equalsIgnoreCase("ma_maint_operation_id") || fieldName.equals("maMaintOperationId"))
      return maMaintOperationId;
    else if (fieldName.equalsIgnoreCase("ma_maint_operation_idr") || fieldName.equals("maMaintOperationIdr"))
      return maMaintOperationIdr;
    else if (fieldName.equalsIgnoreCase("plannedtime"))
      return plannedtime;
    else if (fieldName.equalsIgnoreCase("explode"))
      return explode;
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
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
  public static Maintenance800183Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMachineTypeId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maMachineTypeId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Maintenance800183Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMachineTypeId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_Maintenance.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Maintenance.CreatedBy) as CreatedByR, " +
      "        to_char(MA_Maintenance.Updated, ?) as updated, " +
      "        to_char(MA_Maintenance.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_Maintenance.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Maintenance.UpdatedBy) as UpdatedByR," +
      "        MA_Maintenance.MA_Maintenance_ID, " +
      "MA_Maintenance.AD_Client_ID, " +
      "(CASE WHEN MA_Maintenance.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MA_Maintenance.AD_Org_ID, " +
      "(CASE WHEN MA_Maintenance.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MA_Maintenance.MA_Machine_Type_ID, " +
      "(CASE WHEN MA_Maintenance.MA_Machine_Type_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS MA_Machine_Type_IDR, " +
      "MA_Maintenance.Name, " +
      "MA_Maintenance.Description, " +
      "COALESCE(MA_Maintenance.IsActive, 'N') AS IsActive, " +
      "MA_Maintenance.Maintenance_Type, " +
      "(CASE WHEN MA_Maintenance.Maintenance_Type IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS Maintenance_TypeR, " +
      "MA_Maintenance.MA_Maint_Operation_ID, " +
      "(CASE WHEN MA_Maintenance.MA_Maint_Operation_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS MA_Maint_Operation_IDR, " +
      "MA_Maintenance.Plannedtime, " +
      "COALESCE(MA_Maintenance.Explode, 'N') AS Explode, " +
      "MA_Maintenance.MA_Machine_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_Maintenance left join (select AD_Client_ID, Name from AD_Client) table1 on (MA_Maintenance.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MA_Maintenance.AD_Org_ID = table2.AD_Org_ID) left join (select MA_Machine_Type_ID, Name from MA_Machine_Type) table3 on (MA_Maintenance.MA_Machine_Type_ID = table3.MA_Machine_Type_ID) left join ad_ref_list_v list1 on (MA_Maintenance.Maintenance_Type = list1.value and list1.ad_reference_id = '800033' and list1.ad_language = ?)  left join (select MA_Maint_Operation_ID, Name from MA_Maint_Operation) table4 on (MA_Maintenance.MA_Maint_Operation_ID = table4.MA_Maint_Operation_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maMachineTypeId==null || maMachineTypeId.equals(""))?"":"  AND MA_Maintenance.MA_Machine_Type_ID = ?  ");
    strSql = strSql + 
      "        AND MA_Maintenance.MA_Maintenance_ID = ? " +
      "        AND MA_Maintenance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_Maintenance.AD_Org_ID IN (";
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
      if (maMachineTypeId != null && !(maMachineTypeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineTypeId);
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
        Maintenance800183Data objectMaintenance800183Data = new Maintenance800183Data();
        objectMaintenance800183Data.created = UtilSql.getValue(result, "created");
        objectMaintenance800183Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMaintenance800183Data.updated = UtilSql.getValue(result, "updated");
        objectMaintenance800183Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMaintenance800183Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectMaintenance800183Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMaintenance800183Data.maMaintenanceId = UtilSql.getValue(result, "ma_maintenance_id");
        objectMaintenance800183Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMaintenance800183Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectMaintenance800183Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMaintenance800183Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectMaintenance800183Data.maMachineTypeId = UtilSql.getValue(result, "ma_machine_type_id");
        objectMaintenance800183Data.maMachineTypeIdr = UtilSql.getValue(result, "ma_machine_type_idr");
        objectMaintenance800183Data.name = UtilSql.getValue(result, "name");
        objectMaintenance800183Data.description = UtilSql.getValue(result, "description");
        objectMaintenance800183Data.isactive = UtilSql.getValue(result, "isactive");
        objectMaintenance800183Data.maintenanceType = UtilSql.getValue(result, "maintenance_type");
        objectMaintenance800183Data.maintenanceTyper = UtilSql.getValue(result, "maintenance_typer");
        objectMaintenance800183Data.maMaintOperationId = UtilSql.getValue(result, "ma_maint_operation_id");
        objectMaintenance800183Data.maMaintOperationIdr = UtilSql.getValue(result, "ma_maint_operation_idr");
        objectMaintenance800183Data.plannedtime = UtilSql.getValue(result, "plannedtime");
        objectMaintenance800183Data.explode = UtilSql.getValue(result, "explode");
        objectMaintenance800183Data.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectMaintenance800183Data.language = UtilSql.getValue(result, "language");
        objectMaintenance800183Data.adUserClient = "";
        objectMaintenance800183Data.adOrgClient = "";
        objectMaintenance800183Data.createdby = "";
        objectMaintenance800183Data.trBgcolor = "";
        objectMaintenance800183Data.totalCount = "";
        objectMaintenance800183Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMaintenance800183Data);
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
    Maintenance800183Data objectMaintenance800183Data[] = new Maintenance800183Data[vector.size()];
    vector.copyInto(objectMaintenance800183Data);
    return(objectMaintenance800183Data);
  }

/**
Create a registry
 */
  public static Maintenance800183Data[] set(String maMachineTypeId, String adClientId, String maMachineId, String isactive, String adOrgId, String createdby, String createdbyr, String plannedtime, String maMaintenanceId, String description, String name, String explode, String updatedby, String updatedbyr, String maMaintOperationId, String maintenanceType)    throws ServletException {
    Maintenance800183Data objectMaintenance800183Data[] = new Maintenance800183Data[1];
    objectMaintenance800183Data[0] = new Maintenance800183Data();
    objectMaintenance800183Data[0].created = "";
    objectMaintenance800183Data[0].createdbyr = createdbyr;
    objectMaintenance800183Data[0].updated = "";
    objectMaintenance800183Data[0].updatedTimeStamp = "";
    objectMaintenance800183Data[0].updatedby = updatedby;
    objectMaintenance800183Data[0].updatedbyr = updatedbyr;
    objectMaintenance800183Data[0].maMaintenanceId = maMaintenanceId;
    objectMaintenance800183Data[0].adClientId = adClientId;
    objectMaintenance800183Data[0].adClientIdr = "";
    objectMaintenance800183Data[0].adOrgId = adOrgId;
    objectMaintenance800183Data[0].adOrgIdr = "";
    objectMaintenance800183Data[0].maMachineTypeId = maMachineTypeId;
    objectMaintenance800183Data[0].maMachineTypeIdr = "";
    objectMaintenance800183Data[0].name = name;
    objectMaintenance800183Data[0].description = description;
    objectMaintenance800183Data[0].isactive = isactive;
    objectMaintenance800183Data[0].maintenanceType = maintenanceType;
    objectMaintenance800183Data[0].maintenanceTyper = "";
    objectMaintenance800183Data[0].maMaintOperationId = maMaintOperationId;
    objectMaintenance800183Data[0].maMaintOperationIdr = "";
    objectMaintenance800183Data[0].plannedtime = plannedtime;
    objectMaintenance800183Data[0].explode = explode;
    objectMaintenance800183Data[0].maMachineId = maMachineId;
    objectMaintenance800183Data[0].language = "";
    return objectMaintenance800183Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef802598_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef802600_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT MA_Maintenance.MA_Machine_Type_ID AS NAME" +
      "        FROM MA_Maintenance" +
      "        WHERE MA_Maintenance.MA_Maintenance_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String maMachineTypeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MA_Machine_Type left join (select MA_Machine_Type_ID, Name from MA_Machine_Type) table1 on (MA_Machine_Type.MA_Machine_Type_ID = table1.MA_Machine_Type_ID) WHERE MA_Machine_Type.MA_Machine_Type_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineTypeId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String maMachineTypeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MA_Machine_Type left join (select MA_Machine_Type_ID, Name from MA_Machine_Type) table1 on (MA_Machine_Type.MA_Machine_Type_ID = table1.MA_Machine_Type_ID) WHERE MA_Machine_Type.MA_Machine_Type_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineTypeId);

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
      "        UPDATE MA_Maintenance" +
      "        SET MA_Maintenance_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , MA_Machine_Type_ID = (?) , Name = (?) , Description = (?) , IsActive = (?) , Maintenance_Type = (?) , MA_Maint_Operation_ID = (?) , Plannedtime = TO_NUMBER(?) , Explode = (?) , MA_Machine_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE MA_Maintenance.MA_Maintenance_ID = ? " +
      "                 AND MA_Maintenance.MA_Machine_Type_ID = ? " +
      "        AND MA_Maintenance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Maintenance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintenanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineTypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maintenanceType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintOperationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, explode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintenanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineTypeId);
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
      "        INSERT INTO MA_Maintenance " +
      "        (MA_Maintenance_ID, AD_Client_ID, AD_Org_ID, MA_Machine_Type_ID, Name, Description, IsActive, Maintenance_Type, MA_Maint_Operation_ID, Plannedtime, Explode, MA_Machine_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintenanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineTypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maintenanceType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintOperationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, explode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maMachineTypeId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Maintenance" +
      "        WHERE MA_Maintenance.MA_Maintenance_ID = ? " +
      "                 AND MA_Maintenance.MA_Machine_Type_ID = ? " +
      "        AND MA_Maintenance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Maintenance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineTypeId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String maMachineTypeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Maintenance" +
      "        WHERE MA_Maintenance.MA_Maintenance_ID = ? " +
      "                 AND MA_Maintenance.MA_Machine_Type_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineTypeId);

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
      "          FROM MA_Maintenance" +
      "         WHERE MA_Maintenance.MA_Maintenance_ID = ? ";

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
      "          FROM MA_Maintenance" +
      "         WHERE MA_Maintenance.MA_Maintenance_ID = ? ";

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
