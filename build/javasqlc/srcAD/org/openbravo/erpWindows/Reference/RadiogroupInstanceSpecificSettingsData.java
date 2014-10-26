//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Reference;

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
class RadiogroupInstanceSpecificSettingsData implements FieldProvider {
static Logger log4j = Logger.getLogger(RadiogroupInstanceSpecificSettingsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adRefRadiogroupInstanceId;
  public String adRefRadiogroupId;
  public String adRefRadiogroupIdr;
  public String line;
  public String adClientId;
  public String name;
  public String value;
  public String adOrgId;
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
    else if (fieldName.equalsIgnoreCase("ad_ref_radiogroup_instance_id") || fieldName.equals("adRefRadiogroupInstanceId"))
      return adRefRadiogroupInstanceId;
    else if (fieldName.equalsIgnoreCase("ad_ref_radiogroup_id") || fieldName.equals("adRefRadiogroupId"))
      return adRefRadiogroupId;
    else if (fieldName.equalsIgnoreCase("ad_ref_radiogroup_idr") || fieldName.equals("adRefRadiogroupIdr"))
      return adRefRadiogroupIdr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
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
  public static RadiogroupInstanceSpecificSettingsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefRadiogroupId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adRefRadiogroupId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static RadiogroupInstanceSpecificSettingsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefRadiogroupId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_ref_radiogroup_instance.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_radiogroup_instance.CreatedBy) as CreatedByR, " +
      "        to_char(ad_ref_radiogroup_instance.Updated, ?) as updated, " +
      "        to_char(ad_ref_radiogroup_instance.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_ref_radiogroup_instance.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_radiogroup_instance.UpdatedBy) as UpdatedByR," +
      "        ad_ref_radiogroup_instance.AD_Ref_Radiogroup_Instance_ID, " +
      "ad_ref_radiogroup_instance.AD_Ref_Radiogroup_ID, " +
      "(CASE WHEN ad_ref_radiogroup_instance.AD_Ref_Radiogroup_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Ref_Radiogroup_IDR, " +
      "ad_ref_radiogroup_instance.Line, " +
      "ad_ref_radiogroup_instance.AD_Client_ID, " +
      "ad_ref_radiogroup_instance.Name, " +
      "ad_ref_radiogroup_instance.Value, " +
      "ad_ref_radiogroup_instance.AD_Org_ID, " +
      "COALESCE(ad_ref_radiogroup_instance.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_ref_radiogroup_instance left join (select AD_Ref_Radiogroup_ID, Name from AD_Ref_Radiogroup) table1 on (ad_ref_radiogroup_instance.AD_Ref_Radiogroup_ID = table1.AD_Ref_Radiogroup_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adRefRadiogroupId==null || adRefRadiogroupId.equals(""))?"":"  AND ad_ref_radiogroup_instance.AD_Ref_Radiogroup_ID = ?  ");
    strSql = strSql + 
      "        AND ad_ref_radiogroup_instance.AD_Ref_Radiogroup_Instance_ID = ? " +
      "        AND ad_ref_radiogroup_instance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_ref_radiogroup_instance.AD_Org_ID IN (";
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
      if (adRefRadiogroupId != null && !(adRefRadiogroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefRadiogroupId);
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
        RadiogroupInstanceSpecificSettingsData objectRadiogroupInstanceSpecificSettingsData = new RadiogroupInstanceSpecificSettingsData();
        objectRadiogroupInstanceSpecificSettingsData.created = UtilSql.getValue(result, "created");
        objectRadiogroupInstanceSpecificSettingsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectRadiogroupInstanceSpecificSettingsData.updated = UtilSql.getValue(result, "updated");
        objectRadiogroupInstanceSpecificSettingsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectRadiogroupInstanceSpecificSettingsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectRadiogroupInstanceSpecificSettingsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectRadiogroupInstanceSpecificSettingsData.adRefRadiogroupInstanceId = UtilSql.getValue(result, "ad_ref_radiogroup_instance_id");
        objectRadiogroupInstanceSpecificSettingsData.adRefRadiogroupId = UtilSql.getValue(result, "ad_ref_radiogroup_id");
        objectRadiogroupInstanceSpecificSettingsData.adRefRadiogroupIdr = UtilSql.getValue(result, "ad_ref_radiogroup_idr");
        objectRadiogroupInstanceSpecificSettingsData.line = UtilSql.getValue(result, "line");
        objectRadiogroupInstanceSpecificSettingsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectRadiogroupInstanceSpecificSettingsData.name = UtilSql.getValue(result, "name");
        objectRadiogroupInstanceSpecificSettingsData.value = UtilSql.getValue(result, "value");
        objectRadiogroupInstanceSpecificSettingsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectRadiogroupInstanceSpecificSettingsData.isactive = UtilSql.getValue(result, "isactive");
        objectRadiogroupInstanceSpecificSettingsData.language = UtilSql.getValue(result, "language");
        objectRadiogroupInstanceSpecificSettingsData.adUserClient = "";
        objectRadiogroupInstanceSpecificSettingsData.adOrgClient = "";
        objectRadiogroupInstanceSpecificSettingsData.createdby = "";
        objectRadiogroupInstanceSpecificSettingsData.trBgcolor = "";
        objectRadiogroupInstanceSpecificSettingsData.totalCount = "";
        objectRadiogroupInstanceSpecificSettingsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRadiogroupInstanceSpecificSettingsData);
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
    RadiogroupInstanceSpecificSettingsData objectRadiogroupInstanceSpecificSettingsData[] = new RadiogroupInstanceSpecificSettingsData[vector.size()];
    vector.copyInto(objectRadiogroupInstanceSpecificSettingsData);
    return(objectRadiogroupInstanceSpecificSettingsData);
  }

/**
Create a registry
 */
  public static RadiogroupInstanceSpecificSettingsData[] set(String adRefRadiogroupId, String isactive, String createdby, String createdbyr, String updatedby, String updatedbyr, String line, String value, String adClientId, String adRefRadiogroupInstanceId, String name, String adOrgId)    throws ServletException {
    RadiogroupInstanceSpecificSettingsData objectRadiogroupInstanceSpecificSettingsData[] = new RadiogroupInstanceSpecificSettingsData[1];
    objectRadiogroupInstanceSpecificSettingsData[0] = new RadiogroupInstanceSpecificSettingsData();
    objectRadiogroupInstanceSpecificSettingsData[0].created = "";
    objectRadiogroupInstanceSpecificSettingsData[0].createdbyr = createdbyr;
    objectRadiogroupInstanceSpecificSettingsData[0].updated = "";
    objectRadiogroupInstanceSpecificSettingsData[0].updatedTimeStamp = "";
    objectRadiogroupInstanceSpecificSettingsData[0].updatedby = updatedby;
    objectRadiogroupInstanceSpecificSettingsData[0].updatedbyr = updatedbyr;
    objectRadiogroupInstanceSpecificSettingsData[0].adRefRadiogroupInstanceId = adRefRadiogroupInstanceId;
    objectRadiogroupInstanceSpecificSettingsData[0].adRefRadiogroupId = adRefRadiogroupId;
    objectRadiogroupInstanceSpecificSettingsData[0].adRefRadiogroupIdr = "";
    objectRadiogroupInstanceSpecificSettingsData[0].line = line;
    objectRadiogroupInstanceSpecificSettingsData[0].adClientId = adClientId;
    objectRadiogroupInstanceSpecificSettingsData[0].name = name;
    objectRadiogroupInstanceSpecificSettingsData[0].value = value;
    objectRadiogroupInstanceSpecificSettingsData[0].adOrgId = adOrgId;
    objectRadiogroupInstanceSpecificSettingsData[0].isactive = isactive;
    objectRadiogroupInstanceSpecificSettingsData[0].language = "";
    return objectRadiogroupInstanceSpecificSettingsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef10013257F0344F6AA5F3E5600F46A4D3_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef87648F4B6D4F4FD18EBD6B69A8996B8B_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT ad_ref_radiogroup_instance.AD_Ref_Radiogroup_ID AS NAME" +
      "        FROM ad_ref_radiogroup_instance" +
      "        WHERE ad_ref_radiogroup_instance.AD_Ref_Radiogroup_Instance_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adRefRadiogroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM ad_ref_radiogroup left join (select AD_Ref_Radiogroup_ID, Name from AD_Ref_Radiogroup) table1 on (ad_ref_radiogroup.AD_Ref_Radiogroup_ID = table1.AD_Ref_Radiogroup_ID) WHERE ad_ref_radiogroup.AD_Ref_Radiogroup_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefRadiogroupId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adRefRadiogroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM ad_ref_radiogroup left join (select AD_Ref_Radiogroup_ID, Name from AD_Ref_Radiogroup) table1 on (ad_ref_radiogroup.AD_Ref_Radiogroup_ID = table1.AD_Ref_Radiogroup_ID) WHERE ad_ref_radiogroup.AD_Ref_Radiogroup_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefRadiogroupId);

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
      "        UPDATE ad_ref_radiogroup_instance" +
      "        SET AD_Ref_Radiogroup_Instance_ID = (?) , AD_Ref_Radiogroup_ID = (?) , Line = TO_NUMBER(?) , AD_Client_ID = (?) , Name = (?) , Value = (?) , AD_Org_ID = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_ref_radiogroup_instance.AD_Ref_Radiogroup_Instance_ID = ? " +
      "                 AND ad_ref_radiogroup_instance.AD_Ref_Radiogroup_ID = ? " +
      "        AND ad_ref_radiogroup_instance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_radiogroup_instance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefRadiogroupInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefRadiogroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefRadiogroupInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefRadiogroupId);
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
      "        INSERT INTO ad_ref_radiogroup_instance " +
      "        (AD_Ref_Radiogroup_Instance_ID, AD_Ref_Radiogroup_ID, Line, AD_Client_ID, Name, Value, AD_Org_ID, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefRadiogroupInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefRadiogroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adRefRadiogroupId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_radiogroup_instance" +
      "        WHERE ad_ref_radiogroup_instance.AD_Ref_Radiogroup_Instance_ID = ? " +
      "                 AND ad_ref_radiogroup_instance.AD_Ref_Radiogroup_ID = ? " +
      "        AND ad_ref_radiogroup_instance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_radiogroup_instance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefRadiogroupId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adRefRadiogroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_radiogroup_instance" +
      "        WHERE ad_ref_radiogroup_instance.AD_Ref_Radiogroup_Instance_ID = ? " +
      "                 AND ad_ref_radiogroup_instance.AD_Ref_Radiogroup_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefRadiogroupId);

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
      "          FROM ad_ref_radiogroup_instance" +
      "         WHERE ad_ref_radiogroup_instance.AD_Ref_Radiogroup_Instance_ID = ? ";

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
      "          FROM ad_ref_radiogroup_instance" +
      "         WHERE ad_ref_radiogroup_instance.AD_Ref_Radiogroup_Instance_ID = ? ";

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
