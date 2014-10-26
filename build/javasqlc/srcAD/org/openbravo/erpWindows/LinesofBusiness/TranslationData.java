//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.LinesofBusiness;

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
class TranslationData implements FieldProvider {
static Logger log4j = Logger.getLogger(TranslationData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cLineofbusinessTrlId;
  public String cLineofbusinessId;
  public String cLineofbusinessIdr;
  public String adClientId;
  public String adLanguage;
  public String adLanguager;
  public String name;
  public String adOrgId;
  public String isactive;
  public String istranslated;
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
    else if (fieldName.equalsIgnoreCase("c_lineofbusiness_trl_id") || fieldName.equals("cLineofbusinessTrlId"))
      return cLineofbusinessTrlId;
    else if (fieldName.equalsIgnoreCase("c_lineofbusiness_id") || fieldName.equals("cLineofbusinessId"))
      return cLineofbusinessId;
    else if (fieldName.equalsIgnoreCase("c_lineofbusiness_idr") || fieldName.equals("cLineofbusinessIdr"))
      return cLineofbusinessIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("istranslated"))
      return istranslated;
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
  public static TranslationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cLineofbusinessId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cLineofbusinessId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TranslationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cLineofbusinessId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_lineofbusiness_trl.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_lineofbusiness_trl.CreatedBy) as CreatedByR, " +
      "        to_char(c_lineofbusiness_trl.Updated, ?) as updated, " +
      "        to_char(c_lineofbusiness_trl.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_lineofbusiness_trl.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_lineofbusiness_trl.UpdatedBy) as UpdatedByR," +
      "        c_lineofbusiness_trl.C_Lineofbusiness_Trl_ID, " +
      "c_lineofbusiness_trl.C_Lineofbusiness_ID, " +
      "(CASE WHEN c_lineofbusiness_trl.C_Lineofbusiness_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS C_Lineofbusiness_IDR, " +
      "c_lineofbusiness_trl.AD_Client_ID, " +
      "c_lineofbusiness_trl.AD_Language, " +
      "(CASE WHEN c_lineofbusiness_trl.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "c_lineofbusiness_trl.Name, " +
      "c_lineofbusiness_trl.AD_Org_ID, " +
      "COALESCE(c_lineofbusiness_trl.Isactive, 'N') AS Isactive, " +
      "COALESCE(c_lineofbusiness_trl.Istranslated, 'N') AS Istranslated, " +
      "        ? AS LANGUAGE " +
      "        FROM c_lineofbusiness_trl left join (select C_Lineofbusiness_ID, Name from C_Lineofbusiness) table1 on (c_lineofbusiness_trl.C_Lineofbusiness_ID = table1.C_Lineofbusiness_ID) left join (select C_Lineofbusiness_ID,AD_Language, Name from c_lineofbusiness_TRL) tableTRL1 on (table1.C_Lineofbusiness_ID = tableTRL1.C_Lineofbusiness_ID and tableTRL1.AD_Language = ?)  left join (select AD_Language, Name from AD_Language) table2 on (c_lineofbusiness_trl.AD_Language =  table2.AD_Language)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cLineofbusinessId==null || cLineofbusinessId.equals(""))?"":"  AND c_lineofbusiness_trl.C_Lineofbusiness_ID = ?  ");
    strSql = strSql + 
      "        AND c_lineofbusiness_trl.C_Lineofbusiness_Trl_ID = ? " +
      "        AND c_lineofbusiness_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_lineofbusiness_trl.AD_Org_ID IN (";
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
      if (cLineofbusinessId != null && !(cLineofbusinessId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLineofbusinessId);
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
        TranslationData objectTranslationData = new TranslationData();
        objectTranslationData.created = UtilSql.getValue(result, "created");
        objectTranslationData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTranslationData.updated = UtilSql.getValue(result, "updated");
        objectTranslationData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTranslationData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTranslationData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTranslationData.cLineofbusinessTrlId = UtilSql.getValue(result, "c_lineofbusiness_trl_id");
        objectTranslationData.cLineofbusinessId = UtilSql.getValue(result, "c_lineofbusiness_id");
        objectTranslationData.cLineofbusinessIdr = UtilSql.getValue(result, "c_lineofbusiness_idr");
        objectTranslationData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTranslationData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectTranslationData.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectTranslationData.name = UtilSql.getValue(result, "name");
        objectTranslationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTranslationData.isactive = UtilSql.getValue(result, "isactive");
        objectTranslationData.istranslated = UtilSql.getValue(result, "istranslated");
        objectTranslationData.language = UtilSql.getValue(result, "language");
        objectTranslationData.adUserClient = "";
        objectTranslationData.adOrgClient = "";
        objectTranslationData.createdby = "";
        objectTranslationData.trBgcolor = "";
        objectTranslationData.totalCount = "";
        objectTranslationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTranslationData);
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
    TranslationData objectTranslationData[] = new TranslationData[vector.size()];
    vector.copyInto(objectTranslationData);
    return(objectTranslationData);
  }

/**
Create a registry
 */
  public static TranslationData[] set(String cLineofbusinessId, String cLineofbusinessTrlId, String adLanguage, String istranslated, String name, String createdby, String createdbyr, String adOrgId, String adClientId, String updatedby, String updatedbyr, String isactive)    throws ServletException {
    TranslationData objectTranslationData[] = new TranslationData[1];
    objectTranslationData[0] = new TranslationData();
    objectTranslationData[0].created = "";
    objectTranslationData[0].createdbyr = createdbyr;
    objectTranslationData[0].updated = "";
    objectTranslationData[0].updatedTimeStamp = "";
    objectTranslationData[0].updatedby = updatedby;
    objectTranslationData[0].updatedbyr = updatedbyr;
    objectTranslationData[0].cLineofbusinessTrlId = cLineofbusinessTrlId;
    objectTranslationData[0].cLineofbusinessId = cLineofbusinessId;
    objectTranslationData[0].cLineofbusinessIdr = "";
    objectTranslationData[0].adClientId = adClientId;
    objectTranslationData[0].adLanguage = adLanguage;
    objectTranslationData[0].adLanguager = "";
    objectTranslationData[0].name = name;
    objectTranslationData[0].adOrgId = adOrgId;
    objectTranslationData[0].isactive = isactive;
    objectTranslationData[0].istranslated = istranslated;
    objectTranslationData[0].language = "";
    return objectTranslationData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefDFB521345D0245BE9459512EFE158997_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef5419A9B3160341139304C8577119AC76_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT c_lineofbusiness_trl.C_Lineofbusiness_ID AS NAME" +
      "        FROM c_lineofbusiness_trl" +
      "        WHERE c_lineofbusiness_trl.C_Lineofbusiness_Trl_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String cLineofbusinessId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM c_lineofbusiness left join (select C_Lineofbusiness_ID, Name from C_Lineofbusiness) table1 on (c_lineofbusiness.C_Lineofbusiness_ID = table1.C_Lineofbusiness_ID) left join (select C_Lineofbusiness_ID,AD_Language, Name from c_lineofbusiness_TRL) tableTRL1 on (table1.C_Lineofbusiness_ID = tableTRL1.C_Lineofbusiness_ID and tableTRL1.AD_Language = ?)  WHERE c_lineofbusiness.C_Lineofbusiness_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLineofbusinessId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String cLineofbusinessId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM c_lineofbusiness left join (select C_Lineofbusiness_ID, Name from C_Lineofbusiness) table1 on (c_lineofbusiness.C_Lineofbusiness_ID = table1.C_Lineofbusiness_ID) left join (select C_Lineofbusiness_ID,AD_Language, Name from c_lineofbusiness_TRL) tableTRL1 on (table1.C_Lineofbusiness_ID = tableTRL1.C_Lineofbusiness_ID and tableTRL1.AD_Language = ?)  WHERE c_lineofbusiness.C_Lineofbusiness_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLineofbusinessId);

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
      "        UPDATE c_lineofbusiness_trl" +
      "        SET C_Lineofbusiness_Trl_ID = (?) , C_Lineofbusiness_ID = (?) , AD_Client_ID = (?) , AD_Language = (?) , Name = (?) , AD_Org_ID = (?) , Isactive = (?) , Istranslated = (?) , updated = now(), updatedby = ? " +
      "        WHERE c_lineofbusiness_trl.C_Lineofbusiness_Trl_ID = ? " +
      "                 AND c_lineofbusiness_trl.C_Lineofbusiness_ID = ? " +
      "        AND c_lineofbusiness_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_lineofbusiness_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLineofbusinessTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLineofbusinessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLineofbusinessTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLineofbusinessId);
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
      "        INSERT INTO c_lineofbusiness_trl " +
      "        (C_Lineofbusiness_Trl_ID, C_Lineofbusiness_ID, AD_Client_ID, AD_Language, Name, AD_Org_ID, Isactive, Istranslated, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLineofbusinessTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLineofbusinessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cLineofbusinessId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_lineofbusiness_trl" +
      "        WHERE c_lineofbusiness_trl.C_Lineofbusiness_Trl_ID = ? " +
      "                 AND c_lineofbusiness_trl.C_Lineofbusiness_ID = ? " +
      "        AND c_lineofbusiness_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_lineofbusiness_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLineofbusinessId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cLineofbusinessId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_lineofbusiness_trl" +
      "        WHERE c_lineofbusiness_trl.C_Lineofbusiness_Trl_ID = ? " +
      "                 AND c_lineofbusiness_trl.C_Lineofbusiness_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLineofbusinessId);

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
      "          FROM c_lineofbusiness_trl" +
      "         WHERE c_lineofbusiness_trl.C_Lineofbusiness_Trl_ID = ? ";

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
      "          FROM c_lineofbusiness_trl" +
      "         WHERE c_lineofbusiness_trl.C_Lineofbusiness_Trl_ID = ? ";

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
