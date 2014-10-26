//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.Tradeareas;

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
class Countries1B88DFA301A247509076941ED292A958Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Countries1B88DFA301A247509076941ED292A958Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssiTradeareaCountryId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String zssiTradeareaId;
  public String cCountryId;
  public String cCountryIdr;
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
    else if (fieldName.equalsIgnoreCase("zssi_tradearea_country_id") || fieldName.equals("zssiTradeareaCountryId"))
      return zssiTradeareaCountryId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("zssi_tradearea_id") || fieldName.equals("zssiTradeareaId"))
      return zssiTradeareaId;
    else if (fieldName.equalsIgnoreCase("c_country_id") || fieldName.equals("cCountryId"))
      return cCountryId;
    else if (fieldName.equalsIgnoreCase("c_country_idr") || fieldName.equals("cCountryIdr"))
      return cCountryIdr;
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
  public static Countries1B88DFA301A247509076941ED292A958Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssiTradeareaId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssiTradeareaId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Countries1B88DFA301A247509076941ED292A958Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssiTradeareaId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_tradearea_country.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_tradearea_country.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_tradearea_country.Updated, ?) as updated, " +
      "        to_char(zssi_tradearea_country.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_tradearea_country.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_tradearea_country.UpdatedBy) as UpdatedByR," +
      "        zssi_tradearea_country.Zssi_Tradearea_Country_ID, " +
      "zssi_tradearea_country.AD_Client_ID, " +
      "(CASE WHEN zssi_tradearea_country.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "zssi_tradearea_country.AD_Org_ID, " +
      "(CASE WHEN zssi_tradearea_country.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zssi_tradearea_country.Zssi_Tradearea_ID, " +
      "zssi_tradearea_country.C_Country_ID, " +
      "(CASE WHEN zssi_tradearea_country.C_Country_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_Country_IDR, " +
      "COALESCE(zssi_tradearea_country.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_tradearea_country left join (select AD_Client_ID, Name from AD_Client) table1 on (zssi_tradearea_country.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (zssi_tradearea_country.AD_Org_ID = table2.AD_Org_ID) left join (select C_Country_ID, Name from C_Country) table3 on (zssi_tradearea_country.C_Country_ID = table3.C_Country_ID) left join (select C_Country_ID,AD_Language, Name from C_Country_TRL) tableTRL3 on (table3.C_Country_ID = tableTRL3.C_Country_ID and tableTRL3.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssiTradeareaId==null || zssiTradeareaId.equals(""))?"":"  AND zssi_tradearea_country.Zssi_Tradearea_ID = ?  ");
    strSql = strSql + 
      "        AND zssi_tradearea_country.Zssi_Tradearea_Country_ID = ? " +
      "        AND zssi_tradearea_country.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_tradearea_country.AD_Org_ID IN (";
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
      if (zssiTradeareaId != null && !(zssiTradeareaId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);
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
        Countries1B88DFA301A247509076941ED292A958Data objectCountries1B88DFA301A247509076941ED292A958Data = new Countries1B88DFA301A247509076941ED292A958Data();
        objectCountries1B88DFA301A247509076941ED292A958Data.created = UtilSql.getValue(result, "created");
        objectCountries1B88DFA301A247509076941ED292A958Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCountries1B88DFA301A247509076941ED292A958Data.updated = UtilSql.getValue(result, "updated");
        objectCountries1B88DFA301A247509076941ED292A958Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCountries1B88DFA301A247509076941ED292A958Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectCountries1B88DFA301A247509076941ED292A958Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCountries1B88DFA301A247509076941ED292A958Data.zssiTradeareaCountryId = UtilSql.getValue(result, "zssi_tradearea_country_id");
        objectCountries1B88DFA301A247509076941ED292A958Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCountries1B88DFA301A247509076941ED292A958Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectCountries1B88DFA301A247509076941ED292A958Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCountries1B88DFA301A247509076941ED292A958Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectCountries1B88DFA301A247509076941ED292A958Data.zssiTradeareaId = UtilSql.getValue(result, "zssi_tradearea_id");
        objectCountries1B88DFA301A247509076941ED292A958Data.cCountryId = UtilSql.getValue(result, "c_country_id");
        objectCountries1B88DFA301A247509076941ED292A958Data.cCountryIdr = UtilSql.getValue(result, "c_country_idr");
        objectCountries1B88DFA301A247509076941ED292A958Data.isactive = UtilSql.getValue(result, "isactive");
        objectCountries1B88DFA301A247509076941ED292A958Data.language = UtilSql.getValue(result, "language");
        objectCountries1B88DFA301A247509076941ED292A958Data.adUserClient = "";
        objectCountries1B88DFA301A247509076941ED292A958Data.adOrgClient = "";
        objectCountries1B88DFA301A247509076941ED292A958Data.createdby = "";
        objectCountries1B88DFA301A247509076941ED292A958Data.trBgcolor = "";
        objectCountries1B88DFA301A247509076941ED292A958Data.totalCount = "";
        objectCountries1B88DFA301A247509076941ED292A958Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCountries1B88DFA301A247509076941ED292A958Data);
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
    Countries1B88DFA301A247509076941ED292A958Data objectCountries1B88DFA301A247509076941ED292A958Data[] = new Countries1B88DFA301A247509076941ED292A958Data[vector.size()];
    vector.copyInto(objectCountries1B88DFA301A247509076941ED292A958Data);
    return(objectCountries1B88DFA301A247509076941ED292A958Data);
  }

/**
Create a registry
 */
  public static Countries1B88DFA301A247509076941ED292A958Data[] set(String zssiTradeareaId, String isactive, String zssiTradeareaCountryId, String adClientId, String adOrgId, String createdby, String createdbyr, String updatedby, String updatedbyr, String cCountryId)    throws ServletException {
    Countries1B88DFA301A247509076941ED292A958Data objectCountries1B88DFA301A247509076941ED292A958Data[] = new Countries1B88DFA301A247509076941ED292A958Data[1];
    objectCountries1B88DFA301A247509076941ED292A958Data[0] = new Countries1B88DFA301A247509076941ED292A958Data();
    objectCountries1B88DFA301A247509076941ED292A958Data[0].created = "";
    objectCountries1B88DFA301A247509076941ED292A958Data[0].createdbyr = createdbyr;
    objectCountries1B88DFA301A247509076941ED292A958Data[0].updated = "";
    objectCountries1B88DFA301A247509076941ED292A958Data[0].updatedTimeStamp = "";
    objectCountries1B88DFA301A247509076941ED292A958Data[0].updatedby = updatedby;
    objectCountries1B88DFA301A247509076941ED292A958Data[0].updatedbyr = updatedbyr;
    objectCountries1B88DFA301A247509076941ED292A958Data[0].zssiTradeareaCountryId = zssiTradeareaCountryId;
    objectCountries1B88DFA301A247509076941ED292A958Data[0].adClientId = adClientId;
    objectCountries1B88DFA301A247509076941ED292A958Data[0].adClientIdr = "";
    objectCountries1B88DFA301A247509076941ED292A958Data[0].adOrgId = adOrgId;
    objectCountries1B88DFA301A247509076941ED292A958Data[0].adOrgIdr = "";
    objectCountries1B88DFA301A247509076941ED292A958Data[0].zssiTradeareaId = zssiTradeareaId;
    objectCountries1B88DFA301A247509076941ED292A958Data[0].cCountryId = cCountryId;
    objectCountries1B88DFA301A247509076941ED292A958Data[0].cCountryIdr = "";
    objectCountries1B88DFA301A247509076941ED292A958Data[0].isactive = isactive;
    objectCountries1B88DFA301A247509076941ED292A958Data[0].language = "";
    return objectCountries1B88DFA301A247509076941ED292A958Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef6D05B1EAA5CF4D33BD1B41ED2E53EDEC_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef77FAAD0EBA2E4C6D8A9B97406A9A9247_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT zssi_tradearea_country.Zssi_Tradearea_ID AS NAME" +
      "        FROM zssi_tradearea_country" +
      "        WHERE zssi_tradearea_country.Zssi_Tradearea_Country_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String zssiTradeareaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zssi_tradearea left join (select Zssi_Tradearea_ID, Name from Zssi_Tradearea) table1 on (zssi_tradearea.Zssi_Tradearea_ID = table1.Zssi_Tradearea_ID) WHERE zssi_tradearea.Zssi_Tradearea_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zssiTradeareaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zssi_tradearea left join (select Zssi_Tradearea_ID, Name from Zssi_Tradearea) table1 on (zssi_tradearea.Zssi_Tradearea_ID = table1.Zssi_Tradearea_ID) WHERE zssi_tradearea.Zssi_Tradearea_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);

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
      "        UPDATE zssi_tradearea_country" +
      "        SET Zssi_Tradearea_Country_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Zssi_Tradearea_ID = (?) , C_Country_ID = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_tradearea_country.Zssi_Tradearea_Country_ID = ? " +
      "                 AND zssi_tradearea_country.Zssi_Tradearea_ID = ? " +
      "        AND zssi_tradearea_country.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_tradearea_country.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);
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
      "        INSERT INTO zssi_tradearea_country " +
      "        (Zssi_Tradearea_Country_ID, AD_Client_ID, AD_Org_ID, Zssi_Tradearea_ID, C_Country_ID, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCountryId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zssiTradeareaId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_tradearea_country" +
      "        WHERE zssi_tradearea_country.Zssi_Tradearea_Country_ID = ? " +
      "                 AND zssi_tradearea_country.Zssi_Tradearea_ID = ? " +
      "        AND zssi_tradearea_country.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_tradearea_country.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zssiTradeareaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_tradearea_country" +
      "        WHERE zssi_tradearea_country.Zssi_Tradearea_Country_ID = ? " +
      "                 AND zssi_tradearea_country.Zssi_Tradearea_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);

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
      "          FROM zssi_tradearea_country" +
      "         WHERE zssi_tradearea_country.Zssi_Tradearea_Country_ID = ? ";

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
      "          FROM zssi_tradearea_country" +
      "         WHERE zssi_tradearea_country.Zssi_Tradearea_Country_ID = ? ";

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
