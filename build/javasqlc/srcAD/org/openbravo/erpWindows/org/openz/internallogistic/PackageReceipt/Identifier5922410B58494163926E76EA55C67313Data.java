//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openz.internallogistic.PackageReceipt;

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
class Identifier5922410B58494163926E76EA55C67313Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Identifier5922410B58494163926E76EA55C67313Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String ilsInoutpackageVId;
  public String ilsInoutpackageVIdr;
  public String serialnumber;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String isunavailable;
  public String ilsSnrinoutlineVId;
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
    else if (fieldName.equalsIgnoreCase("ils_inoutpackage_v_id") || fieldName.equals("ilsInoutpackageVId"))
      return ilsInoutpackageVId;
    else if (fieldName.equalsIgnoreCase("ils_inoutpackage_v_idr") || fieldName.equals("ilsInoutpackageVIdr"))
      return ilsInoutpackageVIdr;
    else if (fieldName.equalsIgnoreCase("serialnumber"))
      return serialnumber;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isunavailable"))
      return isunavailable;
    else if (fieldName.equalsIgnoreCase("ils_snrinoutline_v_id") || fieldName.equals("ilsSnrinoutlineVId"))
      return ilsSnrinoutlineVId;
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
  public static Identifier5922410B58494163926E76EA55C67313Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String ilsInoutpackageVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, ilsInoutpackageVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Identifier5922410B58494163926E76EA55C67313Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String ilsInoutpackageVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ils_snrinoutline_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ils_snrinoutline_v.CreatedBy) as CreatedByR, " +
      "        to_char(ils_snrinoutline_v.Updated, ?) as updated, " +
      "        to_char(ils_snrinoutline_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ils_snrinoutline_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ils_snrinoutline_v.UpdatedBy) as UpdatedByR," +
      "        ils_snrinoutline_v.ILS_Inoutpackage_V_ID, " +
      "(CASE WHEN ils_snrinoutline_v.ILS_Inoutpackage_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table1.Movementdate, 'DD-MM-YYYY')),'') ) END) AS ILS_Inoutpackage_V_IDR, " +
      "ils_snrinoutline_v.Serialnumber, " +
      "ils_snrinoutline_v.AD_Client_ID, " +
      "ils_snrinoutline_v.AD_Org_ID, " +
      "COALESCE(ils_snrinoutline_v.Isactive, 'N') AS Isactive, " +
      "COALESCE(ils_snrinoutline_v.Isunavailable, 'N') AS Isunavailable, " +
      "ils_snrinoutline_v.ILS_Snrinoutline_V_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM ils_snrinoutline_v left join (select ILS_Inoutpackage_V_ID, DocumentNo, Movementdate from ILS_Inoutpackage_V) table1 on (ils_snrinoutline_v.ILS_Inoutpackage_V_ID = table1.ILS_Inoutpackage_V_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((ilsInoutpackageVId==null || ilsInoutpackageVId.equals(""))?"":"  AND ils_snrinoutline_v.ILS_Inoutpackage_V_ID = ?  ");
    strSql = strSql + 
      "        AND ils_snrinoutline_v.ILS_Snrinoutline_V_ID = ? " +
      "        AND ils_snrinoutline_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ils_snrinoutline_v.AD_Org_ID IN (";
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
      if (ilsInoutpackageVId != null && !(ilsInoutpackageVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutpackageVId);
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
        Identifier5922410B58494163926E76EA55C67313Data objectIdentifier5922410B58494163926E76EA55C67313Data = new Identifier5922410B58494163926E76EA55C67313Data();
        objectIdentifier5922410B58494163926E76EA55C67313Data.created = UtilSql.getValue(result, "created");
        objectIdentifier5922410B58494163926E76EA55C67313Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectIdentifier5922410B58494163926E76EA55C67313Data.updated = UtilSql.getValue(result, "updated");
        objectIdentifier5922410B58494163926E76EA55C67313Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectIdentifier5922410B58494163926E76EA55C67313Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectIdentifier5922410B58494163926E76EA55C67313Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectIdentifier5922410B58494163926E76EA55C67313Data.ilsInoutpackageVId = UtilSql.getValue(result, "ils_inoutpackage_v_id");
        objectIdentifier5922410B58494163926E76EA55C67313Data.ilsInoutpackageVIdr = UtilSql.getValue(result, "ils_inoutpackage_v_idr");
        objectIdentifier5922410B58494163926E76EA55C67313Data.serialnumber = UtilSql.getValue(result, "serialnumber");
        objectIdentifier5922410B58494163926E76EA55C67313Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectIdentifier5922410B58494163926E76EA55C67313Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectIdentifier5922410B58494163926E76EA55C67313Data.isactive = UtilSql.getValue(result, "isactive");
        objectIdentifier5922410B58494163926E76EA55C67313Data.isunavailable = UtilSql.getValue(result, "isunavailable");
        objectIdentifier5922410B58494163926E76EA55C67313Data.ilsSnrinoutlineVId = UtilSql.getValue(result, "ils_snrinoutline_v_id");
        objectIdentifier5922410B58494163926E76EA55C67313Data.language = UtilSql.getValue(result, "language");
        objectIdentifier5922410B58494163926E76EA55C67313Data.adUserClient = "";
        objectIdentifier5922410B58494163926E76EA55C67313Data.adOrgClient = "";
        objectIdentifier5922410B58494163926E76EA55C67313Data.createdby = "";
        objectIdentifier5922410B58494163926E76EA55C67313Data.trBgcolor = "";
        objectIdentifier5922410B58494163926E76EA55C67313Data.totalCount = "";
        objectIdentifier5922410B58494163926E76EA55C67313Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectIdentifier5922410B58494163926E76EA55C67313Data);
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
    Identifier5922410B58494163926E76EA55C67313Data objectIdentifier5922410B58494163926E76EA55C67313Data[] = new Identifier5922410B58494163926E76EA55C67313Data[vector.size()];
    vector.copyInto(objectIdentifier5922410B58494163926E76EA55C67313Data);
    return(objectIdentifier5922410B58494163926E76EA55C67313Data);
  }

/**
Create a registry
 */
  public static Identifier5922410B58494163926E76EA55C67313Data[] set(String ilsInoutpackageVId, String ilsSnrinoutlineVId, String adOrgId, String adClientId, String isunavailable, String updatedby, String updatedbyr, String createdby, String createdbyr, String isactive, String serialnumber)    throws ServletException {
    Identifier5922410B58494163926E76EA55C67313Data objectIdentifier5922410B58494163926E76EA55C67313Data[] = new Identifier5922410B58494163926E76EA55C67313Data[1];
    objectIdentifier5922410B58494163926E76EA55C67313Data[0] = new Identifier5922410B58494163926E76EA55C67313Data();
    objectIdentifier5922410B58494163926E76EA55C67313Data[0].created = "";
    objectIdentifier5922410B58494163926E76EA55C67313Data[0].createdbyr = createdbyr;
    objectIdentifier5922410B58494163926E76EA55C67313Data[0].updated = "";
    objectIdentifier5922410B58494163926E76EA55C67313Data[0].updatedTimeStamp = "";
    objectIdentifier5922410B58494163926E76EA55C67313Data[0].updatedby = updatedby;
    objectIdentifier5922410B58494163926E76EA55C67313Data[0].updatedbyr = updatedbyr;
    objectIdentifier5922410B58494163926E76EA55C67313Data[0].ilsInoutpackageVId = ilsInoutpackageVId;
    objectIdentifier5922410B58494163926E76EA55C67313Data[0].ilsInoutpackageVIdr = "";
    objectIdentifier5922410B58494163926E76EA55C67313Data[0].serialnumber = serialnumber;
    objectIdentifier5922410B58494163926E76EA55C67313Data[0].adClientId = adClientId;
    objectIdentifier5922410B58494163926E76EA55C67313Data[0].adOrgId = adOrgId;
    objectIdentifier5922410B58494163926E76EA55C67313Data[0].isactive = isactive;
    objectIdentifier5922410B58494163926E76EA55C67313Data[0].isunavailable = isunavailable;
    objectIdentifier5922410B58494163926E76EA55C67313Data[0].ilsSnrinoutlineVId = ilsSnrinoutlineVId;
    objectIdentifier5922410B58494163926E76EA55C67313Data[0].language = "";
    return objectIdentifier5922410B58494163926E76EA55C67313Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef0A55F0E27BE345A9854425F5A842BF60_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef7D47ACA98A37438793337F5F39F800F2_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT ils_snrinoutline_v.ILS_Inoutpackage_V_ID AS NAME" +
      "        FROM ils_snrinoutline_v" +
      "        WHERE ils_snrinoutline_v.ILS_Snrinoutline_V_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String ilsInoutpackageVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.Movementdate, 'DD-MM-YYYY')) AS NAME FROM ils_inoutpackage_v left join (select ILS_Inoutpackage_V_ID, DocumentNo, Movementdate from ILS_Inoutpackage_V) table1 on (ils_inoutpackage_v.ILS_Inoutpackage_V_ID = table1.ILS_Inoutpackage_V_ID) WHERE ils_inoutpackage_v.ILS_Inoutpackage_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutpackageVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String ilsInoutpackageVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.Movementdate, 'DD-MM-YYYY')) AS NAME FROM ils_inoutpackage_v left join (select ILS_Inoutpackage_V_ID, DocumentNo, Movementdate from ILS_Inoutpackage_V) table1 on (ils_inoutpackage_v.ILS_Inoutpackage_V_ID = table1.ILS_Inoutpackage_V_ID) WHERE ils_inoutpackage_v.ILS_Inoutpackage_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutpackageVId);

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
      "        UPDATE ils_snrinoutline_v" +
      "        SET ILS_Inoutpackage_V_ID = (?) , Serialnumber = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , Isunavailable = (?) , ILS_Snrinoutline_V_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE ils_snrinoutline_v.ILS_Snrinoutline_V_ID = ? " +
      "                 AND ils_snrinoutline_v.ILS_Inoutpackage_V_ID = ? " +
      "        AND ils_snrinoutline_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ils_snrinoutline_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutpackageVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isunavailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsSnrinoutlineVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsSnrinoutlineVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutpackageVId);
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
      "        INSERT INTO ils_snrinoutline_v " +
      "        (ILS_Inoutpackage_V_ID, Serialnumber, AD_Client_ID, AD_Org_ID, Isactive, Isunavailable, ILS_Snrinoutline_V_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutpackageVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isunavailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsSnrinoutlineVId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String ilsInoutpackageVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ils_snrinoutline_v" +
      "        WHERE ils_snrinoutline_v.ILS_Snrinoutline_V_ID = ? " +
      "                 AND ils_snrinoutline_v.ILS_Inoutpackage_V_ID = ? " +
      "        AND ils_snrinoutline_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ils_snrinoutline_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutpackageVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String ilsInoutpackageVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ils_snrinoutline_v" +
      "        WHERE ils_snrinoutline_v.ILS_Snrinoutline_V_ID = ? " +
      "                 AND ils_snrinoutline_v.ILS_Inoutpackage_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutpackageVId);

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
      "          FROM ils_snrinoutline_v" +
      "         WHERE ils_snrinoutline_v.ILS_Snrinoutline_V_ID = ? ";

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
      "          FROM ils_snrinoutline_v" +
      "         WHERE ils_snrinoutline_v.ILS_Snrinoutline_V_ID = ? ";

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
