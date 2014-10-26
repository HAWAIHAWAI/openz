//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.DocumentSequence;

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
class SequenceData implements FieldProvider {
static Logger log4j = Logger.getLogger(SequenceData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adSequenceId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String name;
  public String description;
  public String isactive;
  public String isautosequence;
  public String istableid;
  public String vformat;
  public String incrementno;
  public String currentnext;
  public String currentnextsys;
  public String startnewyear;
  public String startno;
  public String prefix;
  public String suffix;
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
    else if (fieldName.equalsIgnoreCase("ad_sequence_id") || fieldName.equals("adSequenceId"))
      return adSequenceId;
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
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isautosequence"))
      return isautosequence;
    else if (fieldName.equalsIgnoreCase("istableid"))
      return istableid;
    else if (fieldName.equalsIgnoreCase("vformat"))
      return vformat;
    else if (fieldName.equalsIgnoreCase("incrementno"))
      return incrementno;
    else if (fieldName.equalsIgnoreCase("currentnext"))
      return currentnext;
    else if (fieldName.equalsIgnoreCase("currentnextsys"))
      return currentnextsys;
    else if (fieldName.equalsIgnoreCase("startnewyear"))
      return startnewyear;
    else if (fieldName.equalsIgnoreCase("startno"))
      return startno;
    else if (fieldName.equalsIgnoreCase("prefix"))
      return prefix;
    else if (fieldName.equalsIgnoreCase("suffix"))
      return suffix;
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
  public static SequenceData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static SequenceData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Sequence.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Sequence.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Sequence.Updated, ?) as updated, " +
      "        to_char(AD_Sequence.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Sequence.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Sequence.UpdatedBy) as UpdatedByR," +
      "        AD_Sequence.AD_Sequence_ID, " +
      "AD_Sequence.AD_Client_ID, " +
      "(CASE WHEN AD_Sequence.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Sequence.AD_Org_ID, " +
      "(CASE WHEN AD_Sequence.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_Sequence.Name, " +
      "AD_Sequence.Description, " +
      "COALESCE(AD_Sequence.IsActive, 'N') AS IsActive, " +
      "COALESCE(AD_Sequence.IsAutoSequence, 'N') AS IsAutoSequence, " +
      "COALESCE(AD_Sequence.IsTableID, 'N') AS IsTableID, " +
      "AD_Sequence.VFormat, " +
      "AD_Sequence.IncrementNo, " +
      "AD_Sequence.CurrentNext, " +
      "AD_Sequence.CurrentNextSys, " +
      "COALESCE(AD_Sequence.StartNewYear, 'N') AS StartNewYear, " +
      "AD_Sequence.StartNo, " +
      "AD_Sequence.Prefix, " +
      "AD_Sequence.Suffix, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Sequence left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Sequence.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_Sequence.AD_Org_ID = table2.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND AD_Sequence.AD_Sequence_ID = ? " +
      "        AND AD_Sequence.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Sequence.AD_Org_ID IN (";
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
        SequenceData objectSequenceData = new SequenceData();
        objectSequenceData.created = UtilSql.getValue(result, "created");
        objectSequenceData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSequenceData.updated = UtilSql.getValue(result, "updated");
        objectSequenceData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSequenceData.updatedby = UtilSql.getValue(result, "updatedby");
        objectSequenceData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSequenceData.adSequenceId = UtilSql.getValue(result, "ad_sequence_id");
        objectSequenceData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSequenceData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectSequenceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSequenceData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectSequenceData.name = UtilSql.getValue(result, "name");
        objectSequenceData.description = UtilSql.getValue(result, "description");
        objectSequenceData.isactive = UtilSql.getValue(result, "isactive");
        objectSequenceData.isautosequence = UtilSql.getValue(result, "isautosequence");
        objectSequenceData.istableid = UtilSql.getValue(result, "istableid");
        objectSequenceData.vformat = UtilSql.getValue(result, "vformat");
        objectSequenceData.incrementno = UtilSql.getValue(result, "incrementno");
        objectSequenceData.currentnext = UtilSql.getValue(result, "currentnext");
        objectSequenceData.currentnextsys = UtilSql.getValue(result, "currentnextsys");
        objectSequenceData.startnewyear = UtilSql.getValue(result, "startnewyear");
        objectSequenceData.startno = UtilSql.getValue(result, "startno");
        objectSequenceData.prefix = UtilSql.getValue(result, "prefix");
        objectSequenceData.suffix = UtilSql.getValue(result, "suffix");
        objectSequenceData.language = UtilSql.getValue(result, "language");
        objectSequenceData.adUserClient = "";
        objectSequenceData.adOrgClient = "";
        objectSequenceData.createdby = "";
        objectSequenceData.trBgcolor = "";
        objectSequenceData.totalCount = "";
        objectSequenceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSequenceData);
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
    SequenceData objectSequenceData[] = new SequenceData[vector.size()];
    vector.copyInto(objectSequenceData);
    return(objectSequenceData);
  }

/**
Create a registry
 */
  public static SequenceData[] set(String startno, String name, String adOrgId, String istableid, String startnewyear, String updatedby, String updatedbyr, String createdby, String createdbyr, String currentnext, String suffix, String vformat, String description, String isautosequence, String prefix, String incrementno, String currentnextsys, String adSequenceId, String adClientId, String isactive)    throws ServletException {
    SequenceData objectSequenceData[] = new SequenceData[1];
    objectSequenceData[0] = new SequenceData();
    objectSequenceData[0].created = "";
    objectSequenceData[0].createdbyr = createdbyr;
    objectSequenceData[0].updated = "";
    objectSequenceData[0].updatedTimeStamp = "";
    objectSequenceData[0].updatedby = updatedby;
    objectSequenceData[0].updatedbyr = updatedbyr;
    objectSequenceData[0].adSequenceId = adSequenceId;
    objectSequenceData[0].adClientId = adClientId;
    objectSequenceData[0].adClientIdr = "";
    objectSequenceData[0].adOrgId = adOrgId;
    objectSequenceData[0].adOrgIdr = "";
    objectSequenceData[0].name = name;
    objectSequenceData[0].description = description;
    objectSequenceData[0].isactive = isactive;
    objectSequenceData[0].isautosequence = isautosequence;
    objectSequenceData[0].istableid = istableid;
    objectSequenceData[0].vformat = vformat;
    objectSequenceData[0].incrementno = incrementno;
    objectSequenceData[0].currentnext = currentnext;
    objectSequenceData[0].currentnextsys = currentnextsys;
    objectSequenceData[0].startnewyear = startnewyear;
    objectSequenceData[0].startno = startno;
    objectSequenceData[0].prefix = prefix;
    objectSequenceData[0].suffix = suffix;
    objectSequenceData[0].language = "";
    return objectSequenceData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef630_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as UpdatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

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
  public static String selectDef628_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as CreatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_Sequence" +
      "        SET AD_Sequence_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Name = (?) , Description = (?) , IsActive = (?) , IsAutoSequence = (?) , IsTableID = (?) , VFormat = (?) , IncrementNo = TO_NUMBER(?) , CurrentNext = TO_NUMBER(?) , CurrentNextSys = TO_NUMBER(?) , StartNewYear = (?) , StartNo = TO_NUMBER(?) , Prefix = (?) , Suffix = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Sequence.AD_Sequence_ID = ? " +
      "        AND AD_Sequence.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Sequence.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSequenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isautosequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istableid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, incrementno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currentnext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currentnextsys);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startnewyear);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, prefix);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, suffix);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSequenceId);
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
      "        INSERT INTO AD_Sequence " +
      "        (AD_Sequence_ID, AD_Client_ID, AD_Org_ID, Name, Description, IsActive, IsAutoSequence, IsTableID, VFormat, IncrementNo, CurrentNext, CurrentNextSys, StartNewYear, StartNo, Prefix, Suffix, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSequenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isautosequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istableid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, incrementno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currentnext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currentnextsys);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startnewyear);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, prefix);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, suffix);
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
      "        DELETE FROM AD_Sequence" +
      "        WHERE AD_Sequence.AD_Sequence_ID = ? " +
      "        AND AD_Sequence.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Sequence.AD_Org_ID IN (";
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
      "        DELETE FROM AD_Sequence" +
      "        WHERE AD_Sequence.AD_Sequence_ID = ? ";

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
      "          FROM AD_Sequence" +
      "         WHERE AD_Sequence.AD_Sequence_ID = ? ";

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
      "          FROM AD_Sequence" +
      "         WHERE AD_Sequence.AD_Sequence_ID = ? ";

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
