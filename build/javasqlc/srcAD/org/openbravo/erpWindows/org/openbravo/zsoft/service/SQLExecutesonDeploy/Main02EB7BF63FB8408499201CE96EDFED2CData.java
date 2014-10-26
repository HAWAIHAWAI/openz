//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.service.SQLExecutesonDeploy;

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
class Main02EB7BF63FB8408499201CE96EDFED2CData implements FieldProvider {
static Logger log4j = Logger.getLogger(Main02EB7BF63FB8408499201CE96EDFED2CData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zsseExecuteondeployId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String isstandard;
  public String isactive;
  public String description;
  public String seqno;
  public String sqlstmt;
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
    else if (fieldName.equalsIgnoreCase("zsse_executeondeploy_id") || fieldName.equals("zsseExecuteondeployId"))
      return zsseExecuteondeployId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isstandard"))
      return isstandard;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("sqlstmt"))
      return sqlstmt;
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
  public static Main02EB7BF63FB8408499201CE96EDFED2CData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Main02EB7BF63FB8408499201CE96EDFED2CData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zsse_executeondeploy.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zsse_executeondeploy.CreatedBy) as CreatedByR, " +
      "        to_char(zsse_executeondeploy.Updated, ?) as updated, " +
      "        to_char(zsse_executeondeploy.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zsse_executeondeploy.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zsse_executeondeploy.UpdatedBy) as UpdatedByR," +
      "        zsse_executeondeploy.Zsse_Executeondeploy_ID, " +
      "zsse_executeondeploy.AD_Client_ID, " +
      "(CASE WHEN zsse_executeondeploy.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "zsse_executeondeploy.AD_Org_ID, " +
      "(CASE WHEN zsse_executeondeploy.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(zsse_executeondeploy.Isstandard, 'N') AS Isstandard, " +
      "COALESCE(zsse_executeondeploy.Isactive, 'N') AS Isactive, " +
      "zsse_executeondeploy.Description, " +
      "zsse_executeondeploy.Seqno, " +
      "zsse_executeondeploy.Sqlstmt, " +
      "        ? AS LANGUAGE " +
      "        FROM zsse_executeondeploy left join (select AD_Client_ID, Name from AD_Client) table1 on (zsse_executeondeploy.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (zsse_executeondeploy.AD_Org_ID = table2.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND zsse_executeondeploy.Zsse_Executeondeploy_ID = ? " +
      "        AND zsse_executeondeploy.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zsse_executeondeploy.AD_Org_ID IN (";
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
        Main02EB7BF63FB8408499201CE96EDFED2CData objectMain02EB7BF63FB8408499201CE96EDFED2CData = new Main02EB7BF63FB8408499201CE96EDFED2CData();
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.created = UtilSql.getValue(result, "created");
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.updated = UtilSql.getValue(result, "updated");
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.updatedby = UtilSql.getValue(result, "updatedby");
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.zsseExecuteondeployId = UtilSql.getValue(result, "zsse_executeondeploy_id");
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.isstandard = UtilSql.getValue(result, "isstandard");
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.isactive = UtilSql.getValue(result, "isactive");
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.description = UtilSql.getValue(result, "description");
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.seqno = UtilSql.getValue(result, "seqno");
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.sqlstmt = UtilSql.getValue(result, "sqlstmt");
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.language = UtilSql.getValue(result, "language");
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.adUserClient = "";
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.adOrgClient = "";
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.createdby = "";
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.trBgcolor = "";
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.totalCount = "";
        objectMain02EB7BF63FB8408499201CE96EDFED2CData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMain02EB7BF63FB8408499201CE96EDFED2CData);
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
    Main02EB7BF63FB8408499201CE96EDFED2CData objectMain02EB7BF63FB8408499201CE96EDFED2CData[] = new Main02EB7BF63FB8408499201CE96EDFED2CData[vector.size()];
    vector.copyInto(objectMain02EB7BF63FB8408499201CE96EDFED2CData);
    return(objectMain02EB7BF63FB8408499201CE96EDFED2CData);
  }

/**
Create a registry
 */
  public static Main02EB7BF63FB8408499201CE96EDFED2CData[] set(String zsseExecuteondeployId, String createdby, String createdbyr, String sqlstmt, String adOrgId, String description, String seqno, String isstandard, String isactive, String updatedby, String updatedbyr, String adClientId)    throws ServletException {
    Main02EB7BF63FB8408499201CE96EDFED2CData objectMain02EB7BF63FB8408499201CE96EDFED2CData[] = new Main02EB7BF63FB8408499201CE96EDFED2CData[1];
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0] = new Main02EB7BF63FB8408499201CE96EDFED2CData();
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0].created = "";
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0].createdbyr = createdbyr;
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0].updated = "";
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0].updatedTimeStamp = "";
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0].updatedby = updatedby;
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0].updatedbyr = updatedbyr;
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0].zsseExecuteondeployId = zsseExecuteondeployId;
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0].adClientId = adClientId;
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0].adClientIdr = "";
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0].adOrgId = adOrgId;
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0].adOrgIdr = "";
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0].isstandard = isstandard;
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0].isactive = isactive;
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0].description = description;
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0].seqno = seqno;
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0].sqlstmt = sqlstmt;
    objectMain02EB7BF63FB8408499201CE96EDFED2CData[0].language = "";
    return objectMain02EB7BF63FB8408499201CE96EDFED2CData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1E43ECEA397343EABD7B9838437EECDE_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefBEBFE4513B0F4059995DDC142F615D2A(ConnectionProvider connectionProvider, String AD_CLIENT_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(SEQNO),0)+10 AS DefaultValue FROM ZSSE_EXECUTEONDEPLOY where AD_CLIENT_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_CLIENT_ID);

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
  public static String selectDef1ED390E2CF9141FA81E582A206AFA920_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE zsse_executeondeploy" +
      "        SET Zsse_Executeondeploy_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Isstandard = (?) , Isactive = (?) , Description = (?) , Seqno = TO_NUMBER(?) , Sqlstmt = (?) , updated = now(), updatedby = ? " +
      "        WHERE zsse_executeondeploy.Zsse_Executeondeploy_ID = ? " +
      "        AND zsse_executeondeploy.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zsse_executeondeploy.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsseExecuteondeployId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isstandard);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sqlstmt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsseExecuteondeployId);
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
      "        INSERT INTO zsse_executeondeploy " +
      "        (Zsse_Executeondeploy_ID, AD_Client_ID, AD_Org_ID, Isstandard, Isactive, Description, Seqno, Sqlstmt, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsseExecuteondeployId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isstandard);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sqlstmt);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zsse_executeondeploy" +
      "        WHERE zsse_executeondeploy.Zsse_Executeondeploy_ID = ? " +
      "        AND zsse_executeondeploy.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zsse_executeondeploy.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zsse_executeondeploy" +
      "        WHERE zsse_executeondeploy.Zsse_Executeondeploy_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);

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
      "          FROM zsse_executeondeploy" +
      "         WHERE zsse_executeondeploy.Zsse_Executeondeploy_ID = ? ";

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
      "          FROM zsse_executeondeploy" +
      "         WHERE zsse_executeondeploy.Zsse_Executeondeploy_ID = ? ";

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
