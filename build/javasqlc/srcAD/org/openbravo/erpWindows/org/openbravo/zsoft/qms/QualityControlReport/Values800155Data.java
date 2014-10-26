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
class Values800155Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Values800155Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String maMeasureValuesId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String maMeasureTimeId;
  public String maMeasureTimeIdr;
  public String isactive;
  public String maCcpId;
  public String maCcpIdr;
  public String valuetype;
  public String valuetyper;
  public String vString;
  public String vNumber;
  public String vChar;
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
    else if (fieldName.equalsIgnoreCase("ma_measure_values_id") || fieldName.equals("maMeasureValuesId"))
      return maMeasureValuesId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ma_measure_time_id") || fieldName.equals("maMeasureTimeId"))
      return maMeasureTimeId;
    else if (fieldName.equalsIgnoreCase("ma_measure_time_idr") || fieldName.equals("maMeasureTimeIdr"))
      return maMeasureTimeIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ma_ccp_id") || fieldName.equals("maCcpId"))
      return maCcpId;
    else if (fieldName.equalsIgnoreCase("ma_ccp_idr") || fieldName.equals("maCcpIdr"))
      return maCcpIdr;
    else if (fieldName.equalsIgnoreCase("valuetype"))
      return valuetype;
    else if (fieldName.equalsIgnoreCase("valuetyper"))
      return valuetyper;
    else if (fieldName.equalsIgnoreCase("v_string") || fieldName.equals("vString"))
      return vString;
    else if (fieldName.equalsIgnoreCase("v_number") || fieldName.equals("vNumber"))
      return vNumber;
    else if (fieldName.equalsIgnoreCase("v_char") || fieldName.equals("vChar"))
      return vChar;
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
  public static Values800155Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMeasureTimeId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maMeasureTimeId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Values800155Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMeasureTimeId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_Measure_Values.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Measure_Values.CreatedBy) as CreatedByR, " +
      "        to_char(MA_Measure_Values.Updated, ?) as updated, " +
      "        to_char(MA_Measure_Values.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_Measure_Values.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Measure_Values.UpdatedBy) as UpdatedByR," +
      "        MA_Measure_Values.MA_Measure_Values_ID, " +
      "MA_Measure_Values.AD_Client_ID, " +
      "(CASE WHEN MA_Measure_Values.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MA_Measure_Values.AD_Org_ID, " +
      "(CASE WHEN MA_Measure_Values.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MA_Measure_Values.MA_Measure_Time_ID, " +
      "(CASE WHEN MA_Measure_Values.MA_Measure_Time_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table6.Measuredate, 'DD-MM-YYYY')),'') ) END) AS MA_Measure_Time_IDR, " +
      "COALESCE(MA_Measure_Values.IsActive, 'N') AS IsActive, " +
      "MA_Measure_Values.MA_Ccp_ID, " +
      "(CASE WHEN MA_Measure_Values.MA_Ccp_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS MA_Ccp_IDR, " +
      "MA_Measure_Values.Valuetype, " +
      "(CASE WHEN MA_Measure_Values.Valuetype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ValuetypeR, " +
      "MA_Measure_Values.V_String, " +
      "MA_Measure_Values.V_Number, " +
      "COALESCE(MA_Measure_Values.V_Char, 'N') AS V_Char, " +
      "MA_Measure_Values.SeqNo, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_Measure_Values left join (select AD_Client_ID, Name from AD_Client) table1 on (MA_Measure_Values.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MA_Measure_Values.AD_Org_ID = table2.AD_Org_ID) left join (select MA_Measure_Time_ID, MA_Measure_Group_ID from MA_Measure_Time) table3 on (MA_Measure_Values.MA_Measure_Time_ID = table3.MA_Measure_Time_ID) left join (select MA_Measure_Group_ID, MA_CCP_Group_ID, MA_Measure_Shift_ID from MA_Measure_Group) table4 on (table3.MA_Measure_Group_ID = table4.MA_Measure_Group_ID) left join (select MA_CCP_Group_ID, Name from MA_CCP_Group) table5 on (table4.MA_CCP_Group_ID = table5.MA_CCP_Group_ID) left join (select MA_Measure_Shift_ID, Measuredate from MA_Measure_Shift) table6 on (table4.MA_Measure_Shift_ID = table6.MA_Measure_Shift_ID) left join (select MA_Ccp_ID, Name from MA_Ccp) table7 on (MA_Measure_Values.MA_Ccp_ID = table7.MA_Ccp_ID) left join ad_ref_list_v list1 on (MA_Measure_Values.Valuetype = list1.value and list1.ad_reference_id = '800039' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maMeasureTimeId==null || maMeasureTimeId.equals(""))?"":"  AND MA_Measure_Values.MA_Measure_Time_ID = ?  ");
    strSql = strSql + 
      "        AND MA_Measure_Values.MA_Measure_Values_ID = ? " +
      "        AND MA_Measure_Values.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_Measure_Values.AD_Org_ID IN (";
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
      if (maMeasureTimeId != null && !(maMeasureTimeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureTimeId);
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
        Values800155Data objectValues800155Data = new Values800155Data();
        objectValues800155Data.created = UtilSql.getValue(result, "created");
        objectValues800155Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectValues800155Data.updated = UtilSql.getValue(result, "updated");
        objectValues800155Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectValues800155Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectValues800155Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectValues800155Data.maMeasureValuesId = UtilSql.getValue(result, "ma_measure_values_id");
        objectValues800155Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectValues800155Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectValues800155Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectValues800155Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectValues800155Data.maMeasureTimeId = UtilSql.getValue(result, "ma_measure_time_id");
        objectValues800155Data.maMeasureTimeIdr = UtilSql.getValue(result, "ma_measure_time_idr");
        objectValues800155Data.isactive = UtilSql.getValue(result, "isactive");
        objectValues800155Data.maCcpId = UtilSql.getValue(result, "ma_ccp_id");
        objectValues800155Data.maCcpIdr = UtilSql.getValue(result, "ma_ccp_idr");
        objectValues800155Data.valuetype = UtilSql.getValue(result, "valuetype");
        objectValues800155Data.valuetyper = UtilSql.getValue(result, "valuetyper");
        objectValues800155Data.vString = UtilSql.getValue(result, "v_string");
        objectValues800155Data.vNumber = UtilSql.getValue(result, "v_number");
        objectValues800155Data.vChar = UtilSql.getValue(result, "v_char");
        objectValues800155Data.seqno = UtilSql.getValue(result, "seqno");
        objectValues800155Data.language = UtilSql.getValue(result, "language");
        objectValues800155Data.adUserClient = "";
        objectValues800155Data.adOrgClient = "";
        objectValues800155Data.createdby = "";
        objectValues800155Data.trBgcolor = "";
        objectValues800155Data.totalCount = "";
        objectValues800155Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectValues800155Data);
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
    Values800155Data objectValues800155Data[] = new Values800155Data[vector.size()];
    vector.copyInto(objectValues800155Data);
    return(objectValues800155Data);
  }

/**
Create a registry
 */
  public static Values800155Data[] set(String maMeasureTimeId, String maMeasureValuesId, String seqno, String adOrgId, String isactive, String valuetype, String maCcpId, String vChar, String createdby, String createdbyr, String vString, String adClientId, String updatedby, String updatedbyr, String vNumber)    throws ServletException {
    Values800155Data objectValues800155Data[] = new Values800155Data[1];
    objectValues800155Data[0] = new Values800155Data();
    objectValues800155Data[0].created = "";
    objectValues800155Data[0].createdbyr = createdbyr;
    objectValues800155Data[0].updated = "";
    objectValues800155Data[0].updatedTimeStamp = "";
    objectValues800155Data[0].updatedby = updatedby;
    objectValues800155Data[0].updatedbyr = updatedbyr;
    objectValues800155Data[0].maMeasureValuesId = maMeasureValuesId;
    objectValues800155Data[0].adClientId = adClientId;
    objectValues800155Data[0].adClientIdr = "";
    objectValues800155Data[0].adOrgId = adOrgId;
    objectValues800155Data[0].adOrgIdr = "";
    objectValues800155Data[0].maMeasureTimeId = maMeasureTimeId;
    objectValues800155Data[0].maMeasureTimeIdr = "";
    objectValues800155Data[0].isactive = isactive;
    objectValues800155Data[0].maCcpId = maCcpId;
    objectValues800155Data[0].maCcpIdr = "";
    objectValues800155Data[0].valuetype = valuetype;
    objectValues800155Data[0].valuetyper = "";
    objectValues800155Data[0].vString = vString;
    objectValues800155Data[0].vNumber = vNumber;
    objectValues800155Data[0].vChar = vChar;
    objectValues800155Data[0].seqno = seqno;
    objectValues800155Data[0].language = "";
    return objectValues800155Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef802316(ConnectionProvider connectionProvider, String MA_MEASURE_TIME_ID, String MA_CCP_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(SEQNO),0)+10 AS DefaultValue FROM MA_MEASURE_VALUES WHERE MA_MEASURE_TIME_ID=? AND MA_CCP_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MA_MEASURE_TIME_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MA_CCP_ID);

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
  public static String selectDef802258_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef802260_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT MA_Measure_Values.MA_Measure_Time_ID AS NAME" +
      "        FROM MA_Measure_Values" +
      "        WHERE MA_Measure_Values.MA_Measure_Values_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String maMeasureTimeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table3.Name), '')) || ' - ' || TO_CHAR(table4.Measuredate, 'DD-MM-YYYY')) AS NAME FROM MA_Measure_Time left join (select MA_Measure_Time_ID, MA_Measure_Group_ID from MA_Measure_Time) table1 on (MA_Measure_Time.MA_Measure_Time_ID = table1.MA_Measure_Time_ID) left join (select MA_Measure_Group_ID, MA_CCP_Group_ID, MA_Measure_Shift_ID from MA_Measure_Group) table2 on (table1.MA_Measure_Group_ID = table2.MA_Measure_Group_ID) left join (select MA_CCP_Group_ID, Name from MA_CCP_Group) table3 on (table2.MA_CCP_Group_ID = table3.MA_CCP_Group_ID) left join (select MA_Measure_Shift_ID, Measuredate from MA_Measure_Shift) table4 on (table2.MA_Measure_Shift_ID = table4.MA_Measure_Shift_ID) WHERE MA_Measure_Time.MA_Measure_Time_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureTimeId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String maMeasureTimeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table3.Name), '')) || ' - ' || TO_CHAR(table4.Measuredate, 'DD-MM-YYYY')) AS NAME FROM MA_Measure_Time left join (select MA_Measure_Time_ID, MA_Measure_Group_ID from MA_Measure_Time) table1 on (MA_Measure_Time.MA_Measure_Time_ID = table1.MA_Measure_Time_ID) left join (select MA_Measure_Group_ID, MA_CCP_Group_ID, MA_Measure_Shift_ID from MA_Measure_Group) table2 on (table1.MA_Measure_Group_ID = table2.MA_Measure_Group_ID) left join (select MA_CCP_Group_ID, Name from MA_CCP_Group) table3 on (table2.MA_CCP_Group_ID = table3.MA_CCP_Group_ID) left join (select MA_Measure_Shift_ID, Measuredate from MA_Measure_Shift) table4 on (table2.MA_Measure_Shift_ID = table4.MA_Measure_Shift_ID) WHERE MA_Measure_Time.MA_Measure_Time_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureTimeId);

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
      "        UPDATE MA_Measure_Values" +
      "        SET MA_Measure_Values_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , MA_Measure_Time_ID = (?) , IsActive = (?) , MA_Ccp_ID = (?) , Valuetype = (?) , V_String = (?) , V_Number = TO_NUMBER(?) , V_Char = (?) , SeqNo = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE MA_Measure_Values.MA_Measure_Values_ID = ? " +
      "                 AND MA_Measure_Values.MA_Measure_Time_ID = ? " +
      "        AND MA_Measure_Values.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Measure_Values.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureValuesId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureTimeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCcpId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, valuetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vString);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vNumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vChar);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureValuesId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureTimeId);
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
      "        INSERT INTO MA_Measure_Values " +
      "        (MA_Measure_Values_ID, AD_Client_ID, AD_Org_ID, MA_Measure_Time_ID, IsActive, MA_Ccp_ID, Valuetype, V_String, V_Number, V_Char, SeqNo, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureValuesId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureTimeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCcpId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, valuetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vString);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vNumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vChar);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maMeasureTimeId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Measure_Values" +
      "        WHERE MA_Measure_Values.MA_Measure_Values_ID = ? " +
      "                 AND MA_Measure_Values.MA_Measure_Time_ID = ? " +
      "        AND MA_Measure_Values.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Measure_Values.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureTimeId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String maMeasureTimeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Measure_Values" +
      "        WHERE MA_Measure_Values.MA_Measure_Values_ID = ? " +
      "                 AND MA_Measure_Values.MA_Measure_Time_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureTimeId);

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
      "          FROM MA_Measure_Values" +
      "         WHERE MA_Measure_Values.MA_Measure_Values_ID = ? ";

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
      "          FROM MA_Measure_Values" +
      "         WHERE MA_Measure_Values.MA_Measure_Values_ID = ? ";

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
