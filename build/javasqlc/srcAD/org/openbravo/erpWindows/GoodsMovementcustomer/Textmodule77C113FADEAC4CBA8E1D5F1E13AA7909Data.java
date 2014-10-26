//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.GoodsMovementcustomer;

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
class Textmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Textmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssiMinoutTextmoduleId;
  public String mInoutId;
  public String mInoutIdr;
  public String zssiTextmoduleId;
  public String zssiTextmoduleIdr;
  public String adClientId;
  public String line;
  public String islower;
  public String adOrgId;
  public String ismodified;
  public String text;
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
    else if (fieldName.equalsIgnoreCase("zssi_minout_textmodule_id") || fieldName.equals("zssiMinoutTextmoduleId"))
      return zssiMinoutTextmoduleId;
    else if (fieldName.equalsIgnoreCase("m_inout_id") || fieldName.equals("mInoutId"))
      return mInoutId;
    else if (fieldName.equalsIgnoreCase("m_inout_idr") || fieldName.equals("mInoutIdr"))
      return mInoutIdr;
    else if (fieldName.equalsIgnoreCase("zssi_textmodule_id") || fieldName.equals("zssiTextmoduleId"))
      return zssiTextmoduleId;
    else if (fieldName.equalsIgnoreCase("zssi_textmodule_idr") || fieldName.equals("zssiTextmoduleIdr"))
      return zssiTextmoduleIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("islower"))
      return islower;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ismodified"))
      return ismodified;
    else if (fieldName.equalsIgnoreCase("text"))
      return text;
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
  public static Textmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mInoutId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, mInoutId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Textmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mInoutId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_minout_textmodule.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_minout_textmodule.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_minout_textmodule.Updated, ?) as updated, " +
      "        to_char(zssi_minout_textmodule.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_minout_textmodule.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_minout_textmodule.UpdatedBy) as UpdatedByR," +
      "        zssi_minout_textmodule.Zssi_Minout_Textmodule_ID, " +
      "zssi_minout_textmodule.M_Inout_ID, " +
      "(CASE WHEN zssi_minout_textmodule.M_Inout_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table1.MovementDate, 'DD-MM-YYYY')),'') ) END) AS M_Inout_IDR, " +
      "zssi_minout_textmodule.Zssi_Textmodule_ID, " +
      "(CASE WHEN zssi_minout_textmodule.Zssi_Textmodule_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Position), ''))),'') ) END) AS Zssi_Textmodule_IDR, " +
      "zssi_minout_textmodule.AD_Client_ID, " +
      "zssi_minout_textmodule.Line, " +
      "COALESCE(zssi_minout_textmodule.Islower, 'N') AS Islower, " +
      "zssi_minout_textmodule.AD_Org_ID, " +
      "COALESCE(zssi_minout_textmodule.Ismodified, 'N') AS Ismodified, " +
      "zssi_minout_textmodule.Text, " +
      "COALESCE(zssi_minout_textmodule.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_minout_textmodule left join (select M_Inout_ID, DocumentNo, MovementDate from M_Inout) table1 on (zssi_minout_textmodule.M_Inout_ID = table1.M_Inout_ID) left join (select Zssi_Textmodule_ID, Name, Position from Zssi_Textmodule) table2 on (zssi_minout_textmodule.Zssi_Textmodule_ID = table2.Zssi_Textmodule_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((mInoutId==null || mInoutId.equals(""))?"":"  AND zssi_minout_textmodule.M_Inout_ID = ?  ");
    strSql = strSql + 
      "        AND zssi_minout_textmodule.Zssi_Minout_Textmodule_ID = ? " +
      "        AND zssi_minout_textmodule.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_minout_textmodule.AD_Org_ID IN (";
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
      if (mInoutId != null && !(mInoutId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
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
        Textmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data = new Textmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data();
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.created = UtilSql.getValue(result, "created");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.updated = UtilSql.getValue(result, "updated");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.zssiMinoutTextmoduleId = UtilSql.getValue(result, "zssi_minout_textmodule_id");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.mInoutId = UtilSql.getValue(result, "m_inout_id");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.mInoutIdr = UtilSql.getValue(result, "m_inout_idr");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.zssiTextmoduleId = UtilSql.getValue(result, "zssi_textmodule_id");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.zssiTextmoduleIdr = UtilSql.getValue(result, "zssi_textmodule_idr");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.line = UtilSql.getValue(result, "line");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.islower = UtilSql.getValue(result, "islower");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.ismodified = UtilSql.getValue(result, "ismodified");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.text = UtilSql.getValue(result, "text");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.isactive = UtilSql.getValue(result, "isactive");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.language = UtilSql.getValue(result, "language");
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.adUserClient = "";
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.adOrgClient = "";
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.createdby = "";
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.trBgcolor = "";
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.totalCount = "";
        objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data);
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
    Textmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[] = new Textmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[vector.size()];
    vector.copyInto(objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data);
    return(objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data);
  }

/**
Create a registry
 */
  public static Textmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[] set(String mInoutId, String ismodified, String line, String createdby, String createdbyr, String islower, String adClientId, String zssiTextmoduleId, String zssiMinoutTextmoduleId, String text, String adOrgId, String updatedby, String updatedbyr, String isactive)    throws ServletException {
    Textmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[] = new Textmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[1];
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0] = new Textmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data();
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].created = "";
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].createdbyr = createdbyr;
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].updated = "";
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].updatedTimeStamp = "";
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].updatedby = updatedby;
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].updatedbyr = updatedbyr;
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].zssiMinoutTextmoduleId = zssiMinoutTextmoduleId;
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].mInoutId = mInoutId;
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].mInoutIdr = "";
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].zssiTextmoduleId = zssiTextmoduleId;
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].zssiTextmoduleIdr = "";
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].adClientId = adClientId;
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].line = line;
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].islower = islower;
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].adOrgId = adOrgId;
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].ismodified = ismodified;
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].text = text;
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].isactive = isactive;
    objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data[0].language = "";
    return objectTextmodule77C113FADEAC4CBA8E1D5F1E13AA7909Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefCBC79DB8248F4377A71DB387FB21E449(ConnectionProvider connectionProvider, String m_inout_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(LINE),0)+10 AS DefaultValue FROM ZSSI_MINOUT_TEXTMODULE WHERE m_inout_id=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_inout_id);

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
  public static String selectDefA4D9ED03176B4BF9A1FCECB934838E90_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefE6E26D5D44704D05BAE3A10CBADAC9F2_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT zssi_minout_textmodule.M_Inout_ID AS NAME" +
      "        FROM zssi_minout_textmodule" +
      "        WHERE zssi_minout_textmodule.Zssi_Minout_Textmodule_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String mInoutId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.MovementDate, 'DD-MM-YYYY')) AS NAME FROM M_InOut left join (select M_Inout_ID, DocumentNo, MovementDate from M_Inout) table1 on (M_InOut.M_Inout_ID = table1.M_Inout_ID) WHERE M_InOut.M_Inout_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String mInoutId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.MovementDate, 'DD-MM-YYYY')) AS NAME FROM M_InOut left join (select M_Inout_ID, DocumentNo, MovementDate from M_Inout) table1 on (M_InOut.M_Inout_ID = table1.M_Inout_ID) WHERE M_InOut.M_Inout_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);

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
      "        UPDATE zssi_minout_textmodule" +
      "        SET Zssi_Minout_Textmodule_ID = (?) , M_Inout_ID = (?) , Zssi_Textmodule_ID = (?) , AD_Client_ID = (?) , Line = TO_NUMBER(?) , Islower = (?) , AD_Org_ID = (?) , Ismodified = (?) , Text = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_minout_textmodule.Zssi_Minout_Textmodule_ID = ? " +
      "                 AND zssi_minout_textmodule.M_Inout_ID = ? " +
      "        AND zssi_minout_textmodule.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_minout_textmodule.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiMinoutTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islower);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismodified);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiMinoutTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
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
      "        INSERT INTO zssi_minout_textmodule " +
      "        (Zssi_Minout_Textmodule_ID, M_Inout_ID, Zssi_Textmodule_ID, AD_Client_ID, Line, Islower, AD_Org_ID, Ismodified, Text, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiMinoutTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islower);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismodified);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String mInoutId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_minout_textmodule" +
      "        WHERE zssi_minout_textmodule.Zssi_Minout_Textmodule_ID = ? " +
      "                 AND zssi_minout_textmodule.M_Inout_ID = ? " +
      "        AND zssi_minout_textmodule.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_minout_textmodule.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String mInoutId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_minout_textmodule" +
      "        WHERE zssi_minout_textmodule.Zssi_Minout_Textmodule_ID = ? " +
      "                 AND zssi_minout_textmodule.M_Inout_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);

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
      "          FROM zssi_minout_textmodule" +
      "         WHERE zssi_minout_textmodule.Zssi_Minout_Textmodule_ID = ? ";

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
      "          FROM zssi_minout_textmodule" +
      "         WHERE zssi_minout_textmodule.Zssi_Minout_Textmodule_ID = ? ";

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
