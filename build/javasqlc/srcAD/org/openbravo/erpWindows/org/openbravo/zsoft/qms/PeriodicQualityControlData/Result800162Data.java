//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.qms.PeriodicQualityControlData;

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
class Result800162Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Result800162Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String maPcValueId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String maPcCaseId;
  public String maPcCaseIdr;
  public String isactive;
  public String maPcTestId;
  public String maPcTestIdr;
  public String datadate;
  public String testresult;
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
    else if (fieldName.equalsIgnoreCase("ma_pc_value_id") || fieldName.equals("maPcValueId"))
      return maPcValueId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ma_pc_case_id") || fieldName.equals("maPcCaseId"))
      return maPcCaseId;
    else if (fieldName.equalsIgnoreCase("ma_pc_case_idr") || fieldName.equals("maPcCaseIdr"))
      return maPcCaseIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ma_pc_test_id") || fieldName.equals("maPcTestId"))
      return maPcTestId;
    else if (fieldName.equalsIgnoreCase("ma_pc_test_idr") || fieldName.equals("maPcTestIdr"))
      return maPcTestIdr;
    else if (fieldName.equalsIgnoreCase("datadate"))
      return datadate;
    else if (fieldName.equalsIgnoreCase("testresult"))
      return testresult;
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
  public static Result800162Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maPcCaseId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maPcCaseId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Result800162Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maPcCaseId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_PC_Value.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_PC_Value.CreatedBy) as CreatedByR, " +
      "        to_char(MA_PC_Value.Updated, ?) as updated, " +
      "        to_char(MA_PC_Value.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_PC_Value.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_PC_Value.UpdatedBy) as UpdatedByR," +
      "        MA_PC_Value.MA_Pc_Value_ID, " +
      "MA_PC_Value.AD_Client_ID, " +
      "(CASE WHEN MA_PC_Value.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MA_PC_Value.AD_Org_ID, " +
      "(CASE WHEN MA_PC_Value.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MA_PC_Value.MA_Pc_Case_ID, " +
      "(CASE WHEN MA_PC_Value.MA_Pc_Case_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS MA_Pc_Case_IDR, " +
      "COALESCE(MA_PC_Value.IsActive, 'N') AS IsActive, " +
      "MA_PC_Value.MA_Pc_Test_ID, " +
      "(CASE WHEN MA_PC_Value.MA_Pc_Test_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS MA_Pc_Test_IDR, " +
      "MA_PC_Value.Datadate, " +
      "MA_PC_Value.TestResult, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_PC_Value left join (select AD_Client_ID, Name from AD_Client) table1 on (MA_PC_Value.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MA_PC_Value.AD_Org_ID = table2.AD_Org_ID) left join (select MA_Pc_Case_ID, Name from MA_Pc_Case) table3 on (MA_PC_Value.MA_Pc_Case_ID = table3.MA_Pc_Case_ID) left join (select MA_Pc_Test_ID, Name from MA_Pc_Test) table4 on (MA_PC_Value.MA_Pc_Test_ID = table4.MA_Pc_Test_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maPcCaseId==null || maPcCaseId.equals(""))?"":"  AND MA_PC_Value.MA_Pc_Case_ID = ?  ");
    strSql = strSql + 
      "        AND MA_PC_Value.MA_Pc_Value_ID = ? " +
      "        AND MA_PC_Value.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_PC_Value.AD_Org_ID IN (";
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
      if (maPcCaseId != null && !(maPcCaseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maPcCaseId);
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
        Result800162Data objectResult800162Data = new Result800162Data();
        objectResult800162Data.created = UtilSql.getValue(result, "created");
        objectResult800162Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectResult800162Data.updated = UtilSql.getValue(result, "updated");
        objectResult800162Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectResult800162Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectResult800162Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectResult800162Data.maPcValueId = UtilSql.getValue(result, "ma_pc_value_id");
        objectResult800162Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectResult800162Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectResult800162Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectResult800162Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectResult800162Data.maPcCaseId = UtilSql.getValue(result, "ma_pc_case_id");
        objectResult800162Data.maPcCaseIdr = UtilSql.getValue(result, "ma_pc_case_idr");
        objectResult800162Data.isactive = UtilSql.getValue(result, "isactive");
        objectResult800162Data.maPcTestId = UtilSql.getValue(result, "ma_pc_test_id");
        objectResult800162Data.maPcTestIdr = UtilSql.getValue(result, "ma_pc_test_idr");
        objectResult800162Data.datadate = UtilSql.getDateValue(result, "datadate", "dd-MM-yyyy");
        objectResult800162Data.testresult = UtilSql.getValue(result, "testresult");
        objectResult800162Data.language = UtilSql.getValue(result, "language");
        objectResult800162Data.adUserClient = "";
        objectResult800162Data.adOrgClient = "";
        objectResult800162Data.createdby = "";
        objectResult800162Data.trBgcolor = "";
        objectResult800162Data.totalCount = "";
        objectResult800162Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResult800162Data);
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
    Result800162Data objectResult800162Data[] = new Result800162Data[vector.size()];
    vector.copyInto(objectResult800162Data);
    return(objectResult800162Data);
  }

/**
Create a registry
 */
  public static Result800162Data[] set(String maPcCaseId, String maPcTestId, String adClientId, String createdby, String createdbyr, String maPcValueId, String datadate, String updatedby, String updatedbyr, String adOrgId, String isactive, String testresult)    throws ServletException {
    Result800162Data objectResult800162Data[] = new Result800162Data[1];
    objectResult800162Data[0] = new Result800162Data();
    objectResult800162Data[0].created = "";
    objectResult800162Data[0].createdbyr = createdbyr;
    objectResult800162Data[0].updated = "";
    objectResult800162Data[0].updatedTimeStamp = "";
    objectResult800162Data[0].updatedby = updatedby;
    objectResult800162Data[0].updatedbyr = updatedbyr;
    objectResult800162Data[0].maPcValueId = maPcValueId;
    objectResult800162Data[0].adClientId = adClientId;
    objectResult800162Data[0].adClientIdr = "";
    objectResult800162Data[0].adOrgId = adOrgId;
    objectResult800162Data[0].adOrgIdr = "";
    objectResult800162Data[0].maPcCaseId = maPcCaseId;
    objectResult800162Data[0].maPcCaseIdr = "";
    objectResult800162Data[0].isactive = isactive;
    objectResult800162Data[0].maPcTestId = maPcTestId;
    objectResult800162Data[0].maPcTestIdr = "";
    objectResult800162Data[0].datadate = datadate;
    objectResult800162Data[0].testresult = testresult;
    objectResult800162Data[0].language = "";
    return objectResult800162Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef802357_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef802359_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT MA_PC_Value.MA_Pc_Case_ID AS NAME" +
      "        FROM MA_PC_Value" +
      "        WHERE MA_PC_Value.MA_Pc_Value_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String maPcCaseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MA_PC_Case left join (select MA_Pc_Case_ID, Name from MA_Pc_Case) table1 on (MA_PC_Case.MA_Pc_Case_ID = table1.MA_Pc_Case_ID) WHERE MA_PC_Case.MA_Pc_Case_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maPcCaseId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String maPcCaseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MA_PC_Case left join (select MA_Pc_Case_ID, Name from MA_Pc_Case) table1 on (MA_PC_Case.MA_Pc_Case_ID = table1.MA_Pc_Case_ID) WHERE MA_PC_Case.MA_Pc_Case_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maPcCaseId);

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
      "        UPDATE MA_PC_Value" +
      "        SET MA_Pc_Value_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , MA_Pc_Case_ID = (?) , IsActive = (?) , MA_Pc_Test_ID = (?) , Datadate = TO_DATE(?) , TestResult = (?) , updated = now(), updatedby = ? " +
      "        WHERE MA_PC_Value.MA_Pc_Value_ID = ? " +
      "                 AND MA_PC_Value.MA_Pc_Case_ID = ? " +
      "        AND MA_PC_Value.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_PC_Value.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maPcValueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maPcCaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maPcTestId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datadate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, testresult);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maPcValueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maPcCaseId);
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
      "        INSERT INTO MA_PC_Value " +
      "        (MA_Pc_Value_ID, AD_Client_ID, AD_Org_ID, MA_Pc_Case_ID, IsActive, MA_Pc_Test_ID, Datadate, TestResult, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_DATE(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maPcValueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maPcCaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maPcTestId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datadate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, testresult);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maPcCaseId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_PC_Value" +
      "        WHERE MA_PC_Value.MA_Pc_Value_ID = ? " +
      "                 AND MA_PC_Value.MA_Pc_Case_ID = ? " +
      "        AND MA_PC_Value.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_PC_Value.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maPcCaseId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String maPcCaseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_PC_Value" +
      "        WHERE MA_PC_Value.MA_Pc_Value_ID = ? " +
      "                 AND MA_PC_Value.MA_Pc_Case_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maPcCaseId);

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
      "          FROM MA_PC_Value" +
      "         WHERE MA_PC_Value.MA_Pc_Value_ID = ? ";

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
      "          FROM MA_PC_Value" +
      "         WHERE MA_PC_Value.MA_Pc_Value_ID = ? ";

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
