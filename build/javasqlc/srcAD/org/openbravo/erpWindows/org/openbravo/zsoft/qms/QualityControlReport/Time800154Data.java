//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.qms.QualityControlReport;

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
class Time800154Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Time800154Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String maMeasureTimeId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String maMeasureGroupId;
  public String maMeasureGroupIdr;
  public String isactive;
  public String measurehour;
  public String explode;
  public String processed;
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
    else if (fieldName.equalsIgnoreCase("ma_measure_time_id") || fieldName.equals("maMeasureTimeId"))
      return maMeasureTimeId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ma_measure_group_id") || fieldName.equals("maMeasureGroupId"))
      return maMeasureGroupId;
    else if (fieldName.equalsIgnoreCase("ma_measure_group_idr") || fieldName.equals("maMeasureGroupIdr"))
      return maMeasureGroupIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("measurehour"))
      return measurehour;
    else if (fieldName.equalsIgnoreCase("explode"))
      return explode;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
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
  public static Time800154Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMeasureGroupId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maMeasureGroupId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Time800154Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMeasureGroupId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_Measure_Time.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Measure_Time.CreatedBy) as CreatedByR, " +
      "        to_char(MA_Measure_Time.Updated, ?) as updated, " +
      "        to_char(MA_Measure_Time.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_Measure_Time.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Measure_Time.UpdatedBy) as UpdatedByR," +
      "        MA_Measure_Time.MA_Measure_Time_ID, " +
      "MA_Measure_Time.AD_Client_ID, " +
      "(CASE WHEN MA_Measure_Time.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MA_Measure_Time.AD_Org_ID, " +
      "(CASE WHEN MA_Measure_Time.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MA_Measure_Time.MA_Measure_Group_ID, " +
      "(CASE WHEN MA_Measure_Time.MA_Measure_Group_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table5.Measuredate, 'DD-MM-YYYY')),'') ) END) AS MA_Measure_Group_IDR, " +
      "COALESCE(MA_Measure_Time.IsActive, 'N') AS IsActive, " +
      "TO_CHAR(MA_Measure_Time.Measurehour, 'HH24:MI:SS') AS Measurehour, " +
      "MA_Measure_Time.Explode, " +
      "COALESCE(MA_Measure_Time.Processed, 'N') AS Processed, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_Measure_Time left join (select AD_Client_ID, Name from AD_Client) table1 on (MA_Measure_Time.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MA_Measure_Time.AD_Org_ID = table2.AD_Org_ID) left join (select MA_Measure_Group_ID, MA_CCP_Group_ID, MA_Measure_Shift_ID from MA_Measure_Group) table3 on (MA_Measure_Time.MA_Measure_Group_ID = table3.MA_Measure_Group_ID) left join (select MA_CCP_Group_ID, Name from MA_CCP_Group) table4 on (table3.MA_CCP_Group_ID = table4.MA_CCP_Group_ID) left join (select MA_Measure_Shift_ID, Measuredate from MA_Measure_Shift) table5 on (table3.MA_Measure_Shift_ID = table5.MA_Measure_Shift_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maMeasureGroupId==null || maMeasureGroupId.equals(""))?"":"  AND MA_Measure_Time.MA_Measure_Group_ID = ?  ");
    strSql = strSql + 
      "        AND MA_Measure_Time.MA_Measure_Time_ID = ? " +
      "        AND MA_Measure_Time.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_Measure_Time.AD_Org_ID IN (";
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
      if (maMeasureGroupId != null && !(maMeasureGroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureGroupId);
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
        Time800154Data objectTime800154Data = new Time800154Data();
        objectTime800154Data.created = UtilSql.getValue(result, "created");
        objectTime800154Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTime800154Data.updated = UtilSql.getValue(result, "updated");
        objectTime800154Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTime800154Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectTime800154Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTime800154Data.maMeasureTimeId = UtilSql.getValue(result, "ma_measure_time_id");
        objectTime800154Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTime800154Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectTime800154Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTime800154Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectTime800154Data.maMeasureGroupId = UtilSql.getValue(result, "ma_measure_group_id");
        objectTime800154Data.maMeasureGroupIdr = UtilSql.getValue(result, "ma_measure_group_idr");
        objectTime800154Data.isactive = UtilSql.getValue(result, "isactive");
        objectTime800154Data.measurehour = UtilSql.getValue(result, "measurehour");
        objectTime800154Data.explode = UtilSql.getValue(result, "explode");
        objectTime800154Data.processed = UtilSql.getValue(result, "processed");
        objectTime800154Data.language = UtilSql.getValue(result, "language");
        objectTime800154Data.adUserClient = "";
        objectTime800154Data.adOrgClient = "";
        objectTime800154Data.createdby = "";
        objectTime800154Data.trBgcolor = "";
        objectTime800154Data.totalCount = "";
        objectTime800154Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTime800154Data);
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
    Time800154Data objectTime800154Data[] = new Time800154Data[vector.size()];
    vector.copyInto(objectTime800154Data);
    return(objectTime800154Data);
  }

/**
Create a registry
 */
  public static Time800154Data[] set(String maMeasureGroupId, String isactive, String createdby, String createdbyr, String explode, String maMeasureTimeId, String updatedby, String updatedbyr, String measurehour, String adOrgId, String processed, String adClientId)    throws ServletException {
    Time800154Data objectTime800154Data[] = new Time800154Data[1];
    objectTime800154Data[0] = new Time800154Data();
    objectTime800154Data[0].created = "";
    objectTime800154Data[0].createdbyr = createdbyr;
    objectTime800154Data[0].updated = "";
    objectTime800154Data[0].updatedTimeStamp = "";
    objectTime800154Data[0].updatedby = updatedby;
    objectTime800154Data[0].updatedbyr = updatedbyr;
    objectTime800154Data[0].maMeasureTimeId = maMeasureTimeId;
    objectTime800154Data[0].adClientId = adClientId;
    objectTime800154Data[0].adClientIdr = "";
    objectTime800154Data[0].adOrgId = adOrgId;
    objectTime800154Data[0].adOrgIdr = "";
    objectTime800154Data[0].maMeasureGroupId = maMeasureGroupId;
    objectTime800154Data[0].maMeasureGroupIdr = "";
    objectTime800154Data[0].isactive = isactive;
    objectTime800154Data[0].measurehour = measurehour;
    objectTime800154Data[0].explode = explode;
    objectTime800154Data[0].processed = processed;
    objectTime800154Data[0].language = "";
    return objectTime800154Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef802248_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef802250_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT MA_Measure_Time.MA_Measure_Group_ID AS NAME" +
      "        FROM MA_Measure_Time" +
      "        WHERE MA_Measure_Time.MA_Measure_Time_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String maMeasureGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(table3.Measuredate, 'DD-MM-YYYY')) AS NAME FROM MA_Measure_Group left join (select MA_Measure_Group_ID, MA_CCP_Group_ID, MA_Measure_Shift_ID from MA_Measure_Group) table1 on (MA_Measure_Group.MA_Measure_Group_ID = table1.MA_Measure_Group_ID) left join (select MA_CCP_Group_ID, Name from MA_CCP_Group) table2 on (table1.MA_CCP_Group_ID = table2.MA_CCP_Group_ID) left join (select MA_Measure_Shift_ID, Measuredate from MA_Measure_Shift) table3 on (table1.MA_Measure_Shift_ID = table3.MA_Measure_Shift_ID) WHERE MA_Measure_Group.MA_Measure_Group_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureGroupId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String maMeasureGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(table3.Measuredate, 'DD-MM-YYYY')) AS NAME FROM MA_Measure_Group left join (select MA_Measure_Group_ID, MA_CCP_Group_ID, MA_Measure_Shift_ID from MA_Measure_Group) table1 on (MA_Measure_Group.MA_Measure_Group_ID = table1.MA_Measure_Group_ID) left join (select MA_CCP_Group_ID, Name from MA_CCP_Group) table2 on (table1.MA_CCP_Group_ID = table2.MA_CCP_Group_ID) left join (select MA_Measure_Shift_ID, Measuredate from MA_Measure_Shift) table3 on (table1.MA_Measure_Shift_ID = table3.MA_Measure_Shift_ID) WHERE MA_Measure_Group.MA_Measure_Group_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureGroupId);

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
      "        UPDATE MA_Measure_Time" +
      "        SET MA_Measure_Time_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , MA_Measure_Group_ID = (?) , IsActive = (?) , Measurehour = TO_TIMESTAMP(?,'HH24:MI:SS') , Explode = (?) , Processed = (?) , updated = now(), updatedby = ? " +
      "        WHERE MA_Measure_Time.MA_Measure_Time_ID = ? " +
      "                 AND MA_Measure_Time.MA_Measure_Group_ID = ? " +
      "        AND MA_Measure_Time.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Measure_Time.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureTimeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, measurehour);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, explode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureTimeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureGroupId);
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
      "        INSERT INTO MA_Measure_Time " +
      "        (MA_Measure_Time_ID, AD_Client_ID, AD_Org_ID, MA_Measure_Group_ID, IsActive, Measurehour, Explode, Processed, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_TIMESTAMP(?, 'HH24:MI:SS'), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureTimeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, measurehour);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, explode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maMeasureGroupId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Measure_Time" +
      "        WHERE MA_Measure_Time.MA_Measure_Time_ID = ? " +
      "                 AND MA_Measure_Time.MA_Measure_Group_ID = ? " +
      "        AND MA_Measure_Time.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Measure_Time.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureGroupId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String maMeasureGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Measure_Time" +
      "        WHERE MA_Measure_Time.MA_Measure_Time_ID = ? " +
      "                 AND MA_Measure_Time.MA_Measure_Group_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureGroupId);

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
      "          FROM MA_Measure_Time" +
      "         WHERE MA_Measure_Time.MA_Measure_Time_ID = ? ";

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
      "          FROM MA_Measure_Time" +
      "         WHERE MA_Measure_Time.MA_Measure_Time_ID = ? ";

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
