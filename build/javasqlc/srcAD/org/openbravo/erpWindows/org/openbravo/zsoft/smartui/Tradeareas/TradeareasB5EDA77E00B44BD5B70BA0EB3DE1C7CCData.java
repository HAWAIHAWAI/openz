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
class TradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData implements FieldProvider {
static Logger log4j = Logger.getLogger(TradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssiTradeareaId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String name;
  public String text;
  public String isordertext;
  public String isshipmentext;
  public String isinvoicetext;
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
    else if (fieldName.equalsIgnoreCase("zssi_tradearea_id") || fieldName.equals("zssiTradeareaId"))
      return zssiTradeareaId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("text"))
      return text;
    else if (fieldName.equalsIgnoreCase("isordertext"))
      return isordertext;
    else if (fieldName.equalsIgnoreCase("isshipmentext"))
      return isshipmentext;
    else if (fieldName.equalsIgnoreCase("isinvoicetext"))
      return isinvoicetext;
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
  public static TradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_tradearea.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_tradearea.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_tradearea.Updated, ?) as updated, " +
      "        to_char(zssi_tradearea.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_tradearea.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_tradearea.UpdatedBy) as UpdatedByR," +
      "        zssi_tradearea.Zssi_Tradearea_ID, " +
      "zssi_tradearea.AD_Client_ID, " +
      "(CASE WHEN zssi_tradearea.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "zssi_tradearea.AD_Org_ID, " +
      "(CASE WHEN zssi_tradearea.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zssi_tradearea.Name, " +
      "zssi_tradearea.Text, " +
      "COALESCE(zssi_tradearea.Isordertext, 'N') AS Isordertext, " +
      "COALESCE(zssi_tradearea.Isshipmentext, 'N') AS Isshipmentext, " +
      "COALESCE(zssi_tradearea.Isinvoicetext, 'N') AS Isinvoicetext, " +
      "COALESCE(zssi_tradearea.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_tradearea left join (select AD_Client_ID, Name from AD_Client) table1 on (zssi_tradearea.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (zssi_tradearea.AD_Org_ID = table2.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND zssi_tradearea.Zssi_Tradearea_ID = ? " +
      "        AND zssi_tradearea.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_tradearea.AD_Org_ID IN (";
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
        TradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData = new TradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData();
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.created = UtilSql.getValue(result, "created");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.updated = UtilSql.getValue(result, "updated");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.zssiTradeareaId = UtilSql.getValue(result, "zssi_tradearea_id");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.name = UtilSql.getValue(result, "name");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.text = UtilSql.getValue(result, "text");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.isordertext = UtilSql.getValue(result, "isordertext");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.isshipmentext = UtilSql.getValue(result, "isshipmentext");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.isinvoicetext = UtilSql.getValue(result, "isinvoicetext");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.isactive = UtilSql.getValue(result, "isactive");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.language = UtilSql.getValue(result, "language");
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.adUserClient = "";
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.adOrgClient = "";
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.createdby = "";
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.trBgcolor = "";
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.totalCount = "";
        objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData);
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
    TradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[] = new TradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[vector.size()];
    vector.copyInto(objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData);
    return(objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData);
  }

/**
Create a registry
 */
  public static TradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[] set(String isactive, String isordertext, String createdby, String createdbyr, String zssiTradeareaId, String adOrgId, String updatedby, String updatedbyr, String text, String isshipmentext, String isinvoicetext, String adClientId, String name)    throws ServletException {
    TradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[] = new TradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[1];
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0] = new TradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData();
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].created = "";
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].createdbyr = createdbyr;
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].updated = "";
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].updatedTimeStamp = "";
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].updatedby = updatedby;
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].updatedbyr = updatedbyr;
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].zssiTradeareaId = zssiTradeareaId;
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].adClientId = adClientId;
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].adClientIdr = "";
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].adOrgId = adOrgId;
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].adOrgIdr = "";
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].name = name;
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].text = text;
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].isordertext = isordertext;
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].isshipmentext = isshipmentext;
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].isinvoicetext = isinvoicetext;
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].isactive = isactive;
    objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData[0].language = "";
    return objectTradeareasB5EDA77E00B44BD5B70BA0EB3DE1C7CCData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefF4D52EC2944242C8A095CE4B5FC4267A_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef889C3C54A62C4F64AF07161309A324A2_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        UPDATE zssi_tradearea" +
      "        SET Zssi_Tradearea_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Name = (?) , Text = (?) , Isordertext = (?) , Isshipmentext = (?) , Isinvoicetext = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_tradearea.Zssi_Tradearea_ID = ? " +
      "        AND zssi_tradearea.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_tradearea.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isordertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isshipmentext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoicetext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
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
      "        INSERT INTO zssi_tradearea " +
      "        (Zssi_Tradearea_ID, AD_Client_ID, AD_Org_ID, Name, Text, Isordertext, Isshipmentext, Isinvoicetext, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isordertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isshipmentext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoicetext);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_tradearea" +
      "        WHERE zssi_tradearea.Zssi_Tradearea_ID = ? " +
      "        AND zssi_tradearea.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_tradearea.AD_Org_ID IN (";
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
      "        DELETE FROM zssi_tradearea" +
      "        WHERE zssi_tradearea.Zssi_Tradearea_ID = ? ";

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
      "          FROM zssi_tradearea" +
      "         WHERE zssi_tradearea.Zssi_Tradearea_ID = ? ";

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
      "          FROM zssi_tradearea" +
      "         WHERE zssi_tradearea.Zssi_Tradearea_ID = ? ";

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
