//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openz.internallogistic.ShipmentReceipt;

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
class IdentifierF665ADB84C934431BA8A6DBD0D47264BData implements FieldProvider {
static Logger log4j = Logger.getLogger(IdentifierF665ADB84C934431BA8A6DBD0D47264BData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String ilsInoutlineVId;
  public String ilsInoutlineVIdr;
  public String adClientId;
  public String serialnumber;
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
    else if (fieldName.equalsIgnoreCase("ils_inoutline_v_id") || fieldName.equals("ilsInoutlineVId"))
      return ilsInoutlineVId;
    else if (fieldName.equalsIgnoreCase("ils_inoutline_v_idr") || fieldName.equals("ilsInoutlineVIdr"))
      return ilsInoutlineVIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("serialnumber"))
      return serialnumber;
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
  public static IdentifierF665ADB84C934431BA8A6DBD0D47264BData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String ilsInoutlineVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, ilsInoutlineVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static IdentifierF665ADB84C934431BA8A6DBD0D47264BData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String ilsInoutlineVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ils_snrinoutline_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ils_snrinoutline_v.CreatedBy) as CreatedByR, " +
      "        to_char(ils_snrinoutline_v.Updated, ?) as updated, " +
      "        to_char(ils_snrinoutline_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ils_snrinoutline_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ils_snrinoutline_v.UpdatedBy) as UpdatedByR," +
      "        ils_snrinoutline_v.ILS_Inoutline_V_ID, " +
      "(CASE WHEN ils_snrinoutline_v.ILS_Inoutline_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.MovementDate, 'DD-MM-YYYY')),'') ) END) AS ILS_Inoutline_V_IDR, " +
      "ils_snrinoutline_v.AD_Client_ID, " +
      "ils_snrinoutline_v.Serialnumber, " +
      "ils_snrinoutline_v.AD_Org_ID, " +
      "COALESCE(ils_snrinoutline_v.Isactive, 'N') AS Isactive, " +
      "COALESCE(ils_snrinoutline_v.Isunavailable, 'N') AS Isunavailable, " +
      "ils_snrinoutline_v.ILS_Snrinoutline_V_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM ils_snrinoutline_v left join (select ILS_Inoutline_V_ID, Line, M_Product_ID, ILS_Inout_V_ID from ILS_Inoutline_V) table1 on (ils_snrinoutline_v.ILS_Inoutline_V_ID = table1.ILS_Inoutline_V_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  left join (select ILS_Inout_V_ID, DocumentNo, MovementDate from ILS_Inout_V) table3 on (table1.ILS_Inout_V_ID = table3.ILS_Inout_V_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((ilsInoutlineVId==null || ilsInoutlineVId.equals(""))?"":"  AND ils_snrinoutline_v.ILS_Inoutline_V_ID = ?  ");
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (ilsInoutlineVId != null && !(ilsInoutlineVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutlineVId);
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
        IdentifierF665ADB84C934431BA8A6DBD0D47264BData objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData = new IdentifierF665ADB84C934431BA8A6DBD0D47264BData();
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.created = UtilSql.getValue(result, "created");
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.updated = UtilSql.getValue(result, "updated");
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.updatedby = UtilSql.getValue(result, "updatedby");
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.ilsInoutlineVId = UtilSql.getValue(result, "ils_inoutline_v_id");
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.ilsInoutlineVIdr = UtilSql.getValue(result, "ils_inoutline_v_idr");
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.serialnumber = UtilSql.getValue(result, "serialnumber");
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.isactive = UtilSql.getValue(result, "isactive");
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.isunavailable = UtilSql.getValue(result, "isunavailable");
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.ilsSnrinoutlineVId = UtilSql.getValue(result, "ils_snrinoutline_v_id");
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.language = UtilSql.getValue(result, "language");
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.adUserClient = "";
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.adOrgClient = "";
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.createdby = "";
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.trBgcolor = "";
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.totalCount = "";
        objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData);
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
    IdentifierF665ADB84C934431BA8A6DBD0D47264BData objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[] = new IdentifierF665ADB84C934431BA8A6DBD0D47264BData[vector.size()];
    vector.copyInto(objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData);
    return(objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData);
  }

/**
Create a registry
 */
  public static IdentifierF665ADB84C934431BA8A6DBD0D47264BData[] set(String ilsInoutlineVId, String ilsSnrinoutlineVId, String adOrgId, String adClientId, String isunavailable, String updatedby, String updatedbyr, String createdby, String createdbyr, String serialnumber, String isactive)    throws ServletException {
    IdentifierF665ADB84C934431BA8A6DBD0D47264BData objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[] = new IdentifierF665ADB84C934431BA8A6DBD0D47264BData[1];
    objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[0] = new IdentifierF665ADB84C934431BA8A6DBD0D47264BData();
    objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[0].created = "";
    objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[0].createdbyr = createdbyr;
    objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[0].updated = "";
    objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[0].updatedTimeStamp = "";
    objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[0].updatedby = updatedby;
    objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[0].updatedbyr = updatedbyr;
    objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[0].ilsInoutlineVId = ilsInoutlineVId;
    objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[0].ilsInoutlineVIdr = "";
    objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[0].adClientId = adClientId;
    objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[0].serialnumber = serialnumber;
    objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[0].adOrgId = adOrgId;
    objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[0].isactive = isactive;
    objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[0].isunavailable = isunavailable;
    objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[0].ilsSnrinoutlineVId = ilsSnrinoutlineVId;
    objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData[0].language = "";
    return objectIdentifierF665ADB84C934431BA8A6DBD0D47264BData;
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
      "        SELECT ils_snrinoutline_v.ILS_Inoutline_V_ID AS NAME" +
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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String ilsInoutlineVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Line), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), '')) || ' - ' || TO_CHAR(table3.MovementDate, 'DD-MM-YYYY')) AS NAME FROM ils_inoutline_v left join (select ILS_Inoutline_V_ID, Line, M_Product_ID, ILS_Inout_V_ID from ILS_Inoutline_V) table1 on (ils_inoutline_v.ILS_Inoutline_V_ID = table1.ILS_Inoutline_V_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  left join (select ILS_Inout_V_ID, DocumentNo, MovementDate from ILS_Inout_V) table3 on (table1.ILS_Inout_V_ID = table3.ILS_Inout_V_ID) WHERE ils_inoutline_v.ILS_Inoutline_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutlineVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String ilsInoutlineVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Line), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), '')) || ' - ' || TO_CHAR(table3.MovementDate, 'DD-MM-YYYY')) AS NAME FROM ils_inoutline_v left join (select ILS_Inoutline_V_ID, Line, M_Product_ID, ILS_Inout_V_ID from ILS_Inoutline_V) table1 on (ils_inoutline_v.ILS_Inoutline_V_ID = table1.ILS_Inoutline_V_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  left join (select ILS_Inout_V_ID, DocumentNo, MovementDate from ILS_Inout_V) table3 on (table1.ILS_Inout_V_ID = table3.ILS_Inout_V_ID) WHERE ils_inoutline_v.ILS_Inoutline_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutlineVId);

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
      "        SET ILS_Inoutline_V_ID = (?) , AD_Client_ID = (?) , Serialnumber = (?) , AD_Org_ID = (?) , Isactive = (?) , Isunavailable = (?) , ILS_Snrinoutline_V_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE ils_snrinoutline_v.ILS_Snrinoutline_V_ID = ? " +
      "                 AND ils_snrinoutline_v.ILS_Inoutline_V_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutlineVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isunavailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsSnrinoutlineVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsSnrinoutlineVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutlineVId);
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
      "        (ILS_Inoutline_V_ID, AD_Client_ID, Serialnumber, AD_Org_ID, Isactive, Isunavailable, ILS_Snrinoutline_V_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutlineVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialnumber);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String ilsInoutlineVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ils_snrinoutline_v" +
      "        WHERE ils_snrinoutline_v.ILS_Snrinoutline_V_ID = ? " +
      "                 AND ils_snrinoutline_v.ILS_Inoutline_V_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutlineVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String ilsInoutlineVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ils_snrinoutline_v" +
      "        WHERE ils_snrinoutline_v.ILS_Snrinoutline_V_ID = ? " +
      "                 AND ils_snrinoutline_v.ILS_Inoutline_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutlineVId);

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
