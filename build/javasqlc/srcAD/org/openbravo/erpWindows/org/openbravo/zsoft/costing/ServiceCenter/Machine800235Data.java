//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.costing.ServiceCenter;

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
class Machine800235Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Machine800235Data.class);
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
  public String maCostcenterVersionId;
  public String maCostcenterVersionIdr;
  public String isactive;
  public String maMachineId;
  public String maMachineIdr;
  public String use;
  public String maCostcenterMachineId;
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
    else if (fieldName.equalsIgnoreCase("ma_costcenter_version_id") || fieldName.equals("maCostcenterVersionId"))
      return maCostcenterVersionId;
    else if (fieldName.equalsIgnoreCase("ma_costcenter_version_idr") || fieldName.equals("maCostcenterVersionIdr"))
      return maCostcenterVersionIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("ma_machine_idr") || fieldName.equals("maMachineIdr"))
      return maMachineIdr;
    else if (fieldName.equalsIgnoreCase("use"))
      return use;
    else if (fieldName.equalsIgnoreCase("ma_costcenter_machine_id") || fieldName.equals("maCostcenterMachineId"))
      return maCostcenterMachineId;
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
  public static Machine800235Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maCostcenterVersionId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maCostcenterVersionId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Machine800235Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maCostcenterVersionId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_CostCenter_Machine.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_CostCenter_Machine.CreatedBy) as CreatedByR, " +
      "        to_char(MA_CostCenter_Machine.Updated, ?) as updated, " +
      "        to_char(MA_CostCenter_Machine.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_CostCenter_Machine.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_CostCenter_Machine.UpdatedBy) as UpdatedByR," +
      "        MA_CostCenter_Machine.AD_Client_ID, " +
      "(CASE WHEN MA_CostCenter_Machine.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MA_CostCenter_Machine.AD_Org_ID, " +
      "(CASE WHEN MA_CostCenter_Machine.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MA_CostCenter_Machine.MA_Costcenter_Version_ID, " +
      "(CASE WHEN MA_CostCenter_Machine.MA_Costcenter_Version_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.ValidFrom, 'DD-MM-YYYY')),'') ) END) AS MA_Costcenter_Version_IDR, " +
      "COALESCE(MA_CostCenter_Machine.IsActive, 'N') AS IsActive, " +
      "MA_CostCenter_Machine.MA_Machine_ID, " +
      "(CASE WHEN MA_CostCenter_Machine.MA_Machine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS MA_Machine_IDR, " +
      "MA_CostCenter_Machine.Use, " +
      "MA_CostCenter_Machine.MA_Costcenter_Machine_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_CostCenter_Machine left join (select AD_Client_ID, Name from AD_Client) table1 on (MA_CostCenter_Machine.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MA_CostCenter_Machine.AD_Org_ID = table2.AD_Org_ID) left join (select MA_Costcenter_Version_ID, DocumentNo, MA_Costcenter_ID, ValidFrom from MA_Costcenter_Version) table3 on (MA_CostCenter_Machine.MA_Costcenter_Version_ID = table3.MA_Costcenter_Version_ID) left join (select MA_Costcenter_ID, Name from MA_Costcenter) table4 on (table3.MA_Costcenter_ID = table4.MA_Costcenter_ID) left join (select MA_Machine_ID, Value, Name from MA_Machine) table5 on (MA_CostCenter_Machine.MA_Machine_ID = table5.MA_Machine_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maCostcenterVersionId==null || maCostcenterVersionId.equals(""))?"":"  AND MA_CostCenter_Machine.MA_Costcenter_Version_ID = ?  ");
    strSql = strSql + 
      "        AND MA_CostCenter_Machine.MA_Costcenter_Machine_ID = ? " +
      "        AND MA_CostCenter_Machine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_CostCenter_Machine.AD_Org_ID IN (";
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
      if (maCostcenterVersionId != null && !(maCostcenterVersionId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);
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
        Machine800235Data objectMachine800235Data = new Machine800235Data();
        objectMachine800235Data.created = UtilSql.getValue(result, "created");
        objectMachine800235Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMachine800235Data.updated = UtilSql.getValue(result, "updated");
        objectMachine800235Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMachine800235Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectMachine800235Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMachine800235Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMachine800235Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectMachine800235Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMachine800235Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectMachine800235Data.maCostcenterVersionId = UtilSql.getValue(result, "ma_costcenter_version_id");
        objectMachine800235Data.maCostcenterVersionIdr = UtilSql.getValue(result, "ma_costcenter_version_idr");
        objectMachine800235Data.isactive = UtilSql.getValue(result, "isactive");
        objectMachine800235Data.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectMachine800235Data.maMachineIdr = UtilSql.getValue(result, "ma_machine_idr");
        objectMachine800235Data.use = UtilSql.getValue(result, "use");
        objectMachine800235Data.maCostcenterMachineId = UtilSql.getValue(result, "ma_costcenter_machine_id");
        objectMachine800235Data.language = UtilSql.getValue(result, "language");
        objectMachine800235Data.adUserClient = "";
        objectMachine800235Data.adOrgClient = "";
        objectMachine800235Data.createdby = "";
        objectMachine800235Data.trBgcolor = "";
        objectMachine800235Data.totalCount = "";
        objectMachine800235Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMachine800235Data);
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
    Machine800235Data objectMachine800235Data[] = new Machine800235Data[vector.size()];
    vector.copyInto(objectMachine800235Data);
    return(objectMachine800235Data);
  }

/**
Create a registry
 */
  public static Machine800235Data[] set(String maCostcenterVersionId, String isactive, String createdby, String createdbyr, String maCostcenterMachineId, String adOrgId, String updatedby, String updatedbyr, String maMachineId, String use, String adClientId)    throws ServletException {
    Machine800235Data objectMachine800235Data[] = new Machine800235Data[1];
    objectMachine800235Data[0] = new Machine800235Data();
    objectMachine800235Data[0].created = "";
    objectMachine800235Data[0].createdbyr = createdbyr;
    objectMachine800235Data[0].updated = "";
    objectMachine800235Data[0].updatedTimeStamp = "";
    objectMachine800235Data[0].updatedby = updatedby;
    objectMachine800235Data[0].updatedbyr = updatedbyr;
    objectMachine800235Data[0].adClientId = adClientId;
    objectMachine800235Data[0].adClientIdr = "";
    objectMachine800235Data[0].adOrgId = adOrgId;
    objectMachine800235Data[0].adOrgIdr = "";
    objectMachine800235Data[0].maCostcenterVersionId = maCostcenterVersionId;
    objectMachine800235Data[0].maCostcenterVersionIdr = "";
    objectMachine800235Data[0].isactive = isactive;
    objectMachine800235Data[0].maMachineId = maMachineId;
    objectMachine800235Data[0].maMachineIdr = "";
    objectMachine800235Data[0].use = use;
    objectMachine800235Data[0].maCostcenterMachineId = maCostcenterMachineId;
    objectMachine800235Data[0].language = "";
    return objectMachine800235Data;
  }

/**
Select for auxiliar field
 */
  public static String selectAux800047(ConnectionProvider connectionProvider, String MA_COSTCENTER_VERSION_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M.AD_ORG_ID FROM MA_COSTCENTER M, MA_COSTCENTER_VERSION MV WHERE M.MA_COSTCENTER_ID = MV.MA_COSTCENTER_ID " +
      "AND MV.MA_COSTCENTER_VERSION_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MA_COSTCENTER_VERSION_ID);

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

/**
Select for auxiliar field
 */
  public static String selectDef803309_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef803311_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT MA_CostCenter_Machine.MA_Costcenter_Version_ID AS NAME" +
      "        FROM MA_CostCenter_Machine" +
      "        WHERE MA_CostCenter_Machine.MA_Costcenter_Machine_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String maCostcenterVersionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(table1.ValidFrom, 'DD-MM-YYYY')) AS NAME FROM MA_Costcenter_Version left join (select MA_Costcenter_Version_ID, DocumentNo, MA_Costcenter_ID, ValidFrom from MA_Costcenter_Version) table1 on (MA_Costcenter_Version.MA_Costcenter_Version_ID = table1.MA_Costcenter_Version_ID) left join (select MA_Costcenter_ID, Name from MA_Costcenter) table2 on (table1.MA_Costcenter_ID = table2.MA_Costcenter_ID) WHERE MA_Costcenter_Version.MA_Costcenter_Version_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String maCostcenterVersionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(table1.ValidFrom, 'DD-MM-YYYY')) AS NAME FROM MA_Costcenter_Version left join (select MA_Costcenter_Version_ID, DocumentNo, MA_Costcenter_ID, ValidFrom from MA_Costcenter_Version) table1 on (MA_Costcenter_Version.MA_Costcenter_Version_ID = table1.MA_Costcenter_Version_ID) left join (select MA_Costcenter_ID, Name from MA_Costcenter) table2 on (table1.MA_Costcenter_ID = table2.MA_Costcenter_ID) WHERE MA_Costcenter_Version.MA_Costcenter_Version_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);

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
      "        UPDATE MA_CostCenter_Machine" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , MA_Costcenter_Version_ID = (?) , IsActive = (?) , MA_Machine_ID = (?) , Use = TO_NUMBER(?) , MA_Costcenter_Machine_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE MA_CostCenter_Machine.MA_Costcenter_Machine_ID = ? " +
      "                 AND MA_CostCenter_Machine.MA_Costcenter_Version_ID = ? " +
      "        AND MA_CostCenter_Machine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_CostCenter_Machine.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, use);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);
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
      "        INSERT INTO MA_CostCenter_Machine " +
      "        (AD_Client_ID, AD_Org_ID, MA_Costcenter_Version_ID, IsActive, MA_Machine_ID, Use, MA_Costcenter_Machine_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, use);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterMachineId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maCostcenterVersionId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_CostCenter_Machine" +
      "        WHERE MA_CostCenter_Machine.MA_Costcenter_Machine_ID = ? " +
      "                 AND MA_CostCenter_Machine.MA_Costcenter_Version_ID = ? " +
      "        AND MA_CostCenter_Machine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_CostCenter_Machine.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String maCostcenterVersionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_CostCenter_Machine" +
      "        WHERE MA_CostCenter_Machine.MA_Costcenter_Machine_ID = ? " +
      "                 AND MA_CostCenter_Machine.MA_Costcenter_Version_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);

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
      "          FROM MA_CostCenter_Machine" +
      "         WHERE MA_CostCenter_Machine.MA_Costcenter_Machine_ID = ? ";

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
      "          FROM MA_CostCenter_Machine" +
      "         WHERE MA_CostCenter_Machine.MA_Costcenter_Machine_ID = ? ";

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
