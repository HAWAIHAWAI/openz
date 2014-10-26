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
class CheckPointSet800153Data implements FieldProvider {
static Logger log4j = Logger.getLogger(CheckPointSet800153Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String maMeasureGroupId;
  public String adOrgId;
  public String adOrgIdr;
  public String maMeasureShiftId;
  public String maMeasureShiftIdr;
  public String isactive;
  public String maCcpGroupId;
  public String maCcpGroupIdr;
  public String seqno;
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
    else if (fieldName.equalsIgnoreCase("ma_measure_group_id") || fieldName.equals("maMeasureGroupId"))
      return maMeasureGroupId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ma_measure_shift_id") || fieldName.equals("maMeasureShiftId"))
      return maMeasureShiftId;
    else if (fieldName.equalsIgnoreCase("ma_measure_shift_idr") || fieldName.equals("maMeasureShiftIdr"))
      return maMeasureShiftIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ma_ccp_group_id") || fieldName.equals("maCcpGroupId"))
      return maCcpGroupId;
    else if (fieldName.equalsIgnoreCase("ma_ccp_group_idr") || fieldName.equals("maCcpGroupIdr"))
      return maCcpGroupIdr;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
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
  public static CheckPointSet800153Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMeasureShiftId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maMeasureShiftId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CheckPointSet800153Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMeasureShiftId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_Measure_Group.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Measure_Group.CreatedBy) as CreatedByR, " +
      "        to_char(MA_Measure_Group.Updated, ?) as updated, " +
      "        to_char(MA_Measure_Group.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_Measure_Group.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Measure_Group.UpdatedBy) as UpdatedByR," +
      "        MA_Measure_Group.AD_Client_ID, " +
      "(CASE WHEN MA_Measure_Group.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MA_Measure_Group.MA_Measure_Group_ID, " +
      "MA_Measure_Group.AD_Org_ID, " +
      "(CASE WHEN MA_Measure_Group.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MA_Measure_Group.MA_Measure_Shift_ID, " +
      "(CASE WHEN MA_Measure_Group.MA_Measure_Shift_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(table3.Measuredate, 'DD-MM-YYYY')),'') ) END) AS MA_Measure_Shift_IDR, " +
      "COALESCE(MA_Measure_Group.IsActive, 'N') AS IsActive, " +
      "MA_Measure_Group.MA_CCP_Group_ID, " +
      "(CASE WHEN MA_Measure_Group.MA_CCP_Group_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS MA_CCP_Group_IDR, " +
      "MA_Measure_Group.SeqNo, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_Measure_Group left join (select AD_Client_ID, Name from AD_Client) table1 on (MA_Measure_Group.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MA_Measure_Group.AD_Org_ID = table2.AD_Org_ID) left join (select MA_Measure_Shift_ID, Measuredate from MA_Measure_Shift) table3 on (MA_Measure_Group.MA_Measure_Shift_ID = table3.MA_Measure_Shift_ID) left join (select MA_CCP_Group_ID, Name from MA_CCP_Group) table4 on (MA_Measure_Group.MA_CCP_Group_ID = table4.MA_CCP_Group_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maMeasureShiftId==null || maMeasureShiftId.equals(""))?"":"  AND MA_Measure_Group.MA_Measure_Shift_ID = ?  ");
    strSql = strSql + 
      "        AND MA_Measure_Group.MA_Measure_Group_ID = ? " +
      "        AND MA_Measure_Group.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_Measure_Group.AD_Org_ID IN (";
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
      if (maMeasureShiftId != null && !(maMeasureShiftId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureShiftId);
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
        CheckPointSet800153Data objectCheckPointSet800153Data = new CheckPointSet800153Data();
        objectCheckPointSet800153Data.created = UtilSql.getValue(result, "created");
        objectCheckPointSet800153Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCheckPointSet800153Data.updated = UtilSql.getValue(result, "updated");
        objectCheckPointSet800153Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCheckPointSet800153Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectCheckPointSet800153Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCheckPointSet800153Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCheckPointSet800153Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectCheckPointSet800153Data.maMeasureGroupId = UtilSql.getValue(result, "ma_measure_group_id");
        objectCheckPointSet800153Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCheckPointSet800153Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectCheckPointSet800153Data.maMeasureShiftId = UtilSql.getValue(result, "ma_measure_shift_id");
        objectCheckPointSet800153Data.maMeasureShiftIdr = UtilSql.getValue(result, "ma_measure_shift_idr");
        objectCheckPointSet800153Data.isactive = UtilSql.getValue(result, "isactive");
        objectCheckPointSet800153Data.maCcpGroupId = UtilSql.getValue(result, "ma_ccp_group_id");
        objectCheckPointSet800153Data.maCcpGroupIdr = UtilSql.getValue(result, "ma_ccp_group_idr");
        objectCheckPointSet800153Data.seqno = UtilSql.getValue(result, "seqno");
        objectCheckPointSet800153Data.language = UtilSql.getValue(result, "language");
        objectCheckPointSet800153Data.adUserClient = "";
        objectCheckPointSet800153Data.adOrgClient = "";
        objectCheckPointSet800153Data.createdby = "";
        objectCheckPointSet800153Data.trBgcolor = "";
        objectCheckPointSet800153Data.totalCount = "";
        objectCheckPointSet800153Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCheckPointSet800153Data);
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
    CheckPointSet800153Data objectCheckPointSet800153Data[] = new CheckPointSet800153Data[vector.size()];
    vector.copyInto(objectCheckPointSet800153Data);
    return(objectCheckPointSet800153Data);
  }

/**
Create a registry
 */
  public static CheckPointSet800153Data[] set(String maMeasureShiftId, String updatedby, String updatedbyr, String maMeasureGroupId, String maCcpGroupId, String seqno, String createdby, String createdbyr, String adOrgId, String adClientId, String isactive)    throws ServletException {
    CheckPointSet800153Data objectCheckPointSet800153Data[] = new CheckPointSet800153Data[1];
    objectCheckPointSet800153Data[0] = new CheckPointSet800153Data();
    objectCheckPointSet800153Data[0].created = "";
    objectCheckPointSet800153Data[0].createdbyr = createdbyr;
    objectCheckPointSet800153Data[0].updated = "";
    objectCheckPointSet800153Data[0].updatedTimeStamp = "";
    objectCheckPointSet800153Data[0].updatedby = updatedby;
    objectCheckPointSet800153Data[0].updatedbyr = updatedbyr;
    objectCheckPointSet800153Data[0].adClientId = adClientId;
    objectCheckPointSet800153Data[0].adClientIdr = "";
    objectCheckPointSet800153Data[0].maMeasureGroupId = maMeasureGroupId;
    objectCheckPointSet800153Data[0].adOrgId = adOrgId;
    objectCheckPointSet800153Data[0].adOrgIdr = "";
    objectCheckPointSet800153Data[0].maMeasureShiftId = maMeasureShiftId;
    objectCheckPointSet800153Data[0].maMeasureShiftIdr = "";
    objectCheckPointSet800153Data[0].isactive = isactive;
    objectCheckPointSet800153Data[0].maCcpGroupId = maCcpGroupId;
    objectCheckPointSet800153Data[0].maCcpGroupIdr = "";
    objectCheckPointSet800153Data[0].seqno = seqno;
    objectCheckPointSet800153Data[0].language = "";
    return objectCheckPointSet800153Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef802239_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef802375(ConnectionProvider connectionProvider, String MA_MEASURE_SHIFT_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(SEQNO),0)+10 AS DefaultValue FROM MA_MEASURE_GROUP WHERE MA_MEASURE_SHIFT_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MA_MEASURE_SHIFT_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDef802237_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT MA_Measure_Group.MA_Measure_Shift_ID AS NAME" +
      "        FROM MA_Measure_Group" +
      "        WHERE MA_Measure_Group.MA_Measure_Group_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String maMeasureShiftId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(table1.Measuredate, 'DD-MM-YYYY')) AS NAME FROM MA_Measure_Shift left join (select MA_Measure_Shift_ID, Measuredate from MA_Measure_Shift) table1 on (MA_Measure_Shift.MA_Measure_Shift_ID = table1.MA_Measure_Shift_ID) WHERE MA_Measure_Shift.MA_Measure_Shift_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureShiftId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String maMeasureShiftId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(table1.Measuredate, 'DD-MM-YYYY')) AS NAME FROM MA_Measure_Shift left join (select MA_Measure_Shift_ID, Measuredate from MA_Measure_Shift) table1 on (MA_Measure_Shift.MA_Measure_Shift_ID = table1.MA_Measure_Shift_ID) WHERE MA_Measure_Shift.MA_Measure_Shift_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureShiftId);

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
      "        UPDATE MA_Measure_Group" +
      "        SET AD_Client_ID = (?) , MA_Measure_Group_ID = (?) , AD_Org_ID = (?) , MA_Measure_Shift_ID = (?) , IsActive = (?) , MA_CCP_Group_ID = (?) , SeqNo = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE MA_Measure_Group.MA_Measure_Group_ID = ? " +
      "                 AND MA_Measure_Group.MA_Measure_Shift_ID = ? " +
      "        AND MA_Measure_Group.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Measure_Group.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureShiftId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCcpGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureShiftId);
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
      "        INSERT INTO MA_Measure_Group " +
      "        (AD_Client_ID, MA_Measure_Group_ID, AD_Org_ID, MA_Measure_Shift_ID, IsActive, MA_CCP_Group_ID, SeqNo, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureShiftId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCcpGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maMeasureShiftId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Measure_Group" +
      "        WHERE MA_Measure_Group.MA_Measure_Group_ID = ? " +
      "                 AND MA_Measure_Group.MA_Measure_Shift_ID = ? " +
      "        AND MA_Measure_Group.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Measure_Group.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureShiftId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String maMeasureShiftId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Measure_Group" +
      "        WHERE MA_Measure_Group.MA_Measure_Group_ID = ? " +
      "                 AND MA_Measure_Group.MA_Measure_Shift_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureShiftId);

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
      "          FROM MA_Measure_Group" +
      "         WHERE MA_Measure_Group.MA_Measure_Group_ID = ? ";

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
      "          FROM MA_Measure_Group" +
      "         WHERE MA_Measure_Group.MA_Measure_Group_ID = ? ";

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
