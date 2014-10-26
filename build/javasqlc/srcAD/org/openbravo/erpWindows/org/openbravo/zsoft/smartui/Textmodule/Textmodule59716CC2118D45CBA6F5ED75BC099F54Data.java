//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.Textmodule;

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
class Textmodule59716CC2118D45CBA6F5ED75BC099F54Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Textmodule59716CC2118D45CBA6F5ED75BC099F54Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssiTextmoduleId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String islower;
  public String position;
  public String name;
  public String isactive;
  public String text;
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
    else if (fieldName.equalsIgnoreCase("zssi_textmodule_id") || fieldName.equals("zssiTextmoduleId"))
      return zssiTextmoduleId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("islower"))
      return islower;
    else if (fieldName.equalsIgnoreCase("position"))
      return position;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("text"))
      return text;
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
  public static Textmodule59716CC2118D45CBA6F5ED75BC099F54Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Textmodule59716CC2118D45CBA6F5ED75BC099F54Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_textmodule.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_textmodule.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_textmodule.Updated, ?) as updated, " +
      "        to_char(zssi_textmodule.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_textmodule.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_textmodule.UpdatedBy) as UpdatedByR," +
      "        zssi_textmodule.Zssi_Textmodule_ID, " +
      "zssi_textmodule.AD_Client_ID, " +
      "(CASE WHEN zssi_textmodule.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "zssi_textmodule.AD_Org_ID, " +
      "(CASE WHEN zssi_textmodule.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zssi_textmodule.C_Doctype_ID, " +
      "(CASE WHEN zssi_textmodule.C_Doctype_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_Doctype_IDR, " +
      "COALESCE(zssi_textmodule.Islower, 'N') AS Islower, " +
      "zssi_textmodule.Position, " +
      "zssi_textmodule.Name, " +
      "COALESCE(zssi_textmodule.Isactive, 'N') AS Isactive, " +
      "zssi_textmodule.Text, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_textmodule left join (select AD_Client_ID, Name from AD_Client) table1 on (zssi_textmodule.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (zssi_textmodule.AD_Org_ID = table2.AD_Org_ID) left join (select C_Doctype_ID, Name from C_Doctype) table3 on (zssi_textmodule.C_Doctype_ID = table3.C_Doctype_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL3 on (table3.C_DocType_ID = tableTRL3.C_DocType_ID and tableTRL3.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND zssi_textmodule.Zssi_Textmodule_ID = ? " +
      "        AND zssi_textmodule.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_textmodule.AD_Org_ID IN (";
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
        Textmodule59716CC2118D45CBA6F5ED75BC099F54Data objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data = new Textmodule59716CC2118D45CBA6F5ED75BC099F54Data();
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.created = UtilSql.getValue(result, "created");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.updated = UtilSql.getValue(result, "updated");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.zssiTextmoduleId = UtilSql.getValue(result, "zssi_textmodule_id");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.islower = UtilSql.getValue(result, "islower");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.position = UtilSql.getValue(result, "position");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.name = UtilSql.getValue(result, "name");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.isactive = UtilSql.getValue(result, "isactive");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.text = UtilSql.getValue(result, "text");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.language = UtilSql.getValue(result, "language");
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.adUserClient = "";
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.adOrgClient = "";
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.createdby = "";
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.trBgcolor = "";
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.totalCount = "";
        objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data);
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
    Textmodule59716CC2118D45CBA6F5ED75BC099F54Data objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[] = new Textmodule59716CC2118D45CBA6F5ED75BC099F54Data[vector.size()];
    vector.copyInto(objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data);
    return(objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data);
  }

/**
Create a registry
 */
  public static Textmodule59716CC2118D45CBA6F5ED75BC099F54Data[] set(String islower, String name, String createdby, String createdbyr, String cDoctypeId, String adClientId, String text, String adOrgId, String isactive, String zssiTextmoduleId, String updatedby, String updatedbyr, String position)    throws ServletException {
    Textmodule59716CC2118D45CBA6F5ED75BC099F54Data objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[] = new Textmodule59716CC2118D45CBA6F5ED75BC099F54Data[1];
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0] = new Textmodule59716CC2118D45CBA6F5ED75BC099F54Data();
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].created = "";
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].createdbyr = createdbyr;
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].updated = "";
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].updatedTimeStamp = "";
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].updatedby = updatedby;
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].updatedbyr = updatedbyr;
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].zssiTextmoduleId = zssiTextmoduleId;
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].adClientId = adClientId;
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].adClientIdr = "";
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].adOrgId = adOrgId;
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].adOrgIdr = "";
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].cDoctypeId = cDoctypeId;
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].cDoctypeIdr = "";
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].islower = islower;
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].position = position;
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].name = name;
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].isactive = isactive;
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].text = text;
    objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data[0].language = "";
    return objectTextmodule59716CC2118D45CBA6F5ED75BC099F54Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefE59985C821D842C198203D0042A34358_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef860DD93166114F49A0AD08062BD67479_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        UPDATE zssi_textmodule" +
      "        SET Zssi_Textmodule_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_Doctype_ID = (?) , Islower = (?) , Position = TO_NUMBER(?) , Name = (?) , Isactive = (?) , Text = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_textmodule.Zssi_Textmodule_ID = ? " +
      "        AND zssi_textmodule.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_textmodule.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islower);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, position);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleId);
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
      "        INSERT INTO zssi_textmodule " +
      "        (Zssi_Textmodule_ID, AD_Client_ID, AD_Org_ID, C_Doctype_ID, Islower, Position, Name, Isactive, Text, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islower);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, position);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
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
      "        DELETE FROM zssi_textmodule" +
      "        WHERE zssi_textmodule.Zssi_Textmodule_ID = ? " +
      "        AND zssi_textmodule.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_textmodule.AD_Org_ID IN (";
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
      "        DELETE FROM zssi_textmodule" +
      "        WHERE zssi_textmodule.Zssi_Textmodule_ID = ? ";

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
      "          FROM zssi_textmodule" +
      "         WHERE zssi_textmodule.Zssi_Textmodule_ID = ? ";

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
      "          FROM zssi_textmodule" +
      "         WHERE zssi_textmodule.Zssi_Textmodule_ID = ? ";

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
