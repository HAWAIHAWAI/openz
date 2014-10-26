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
class OrgSpecificData implements FieldProvider {
static Logger log4j = Logger.getLogger(OrgSpecificData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adSequenceOrgId;
  public String adSequenceId;
  public String adSequenceIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String name;
  public String adClientId;
  public String isactive;
  public String isautosequence;
  public String istableid;
  public String incrementno;
  public String currentnext;
  public String startnewyear;
  public String startno;
  public String prefix;
  public String vformat;
  public String suffix;
  public String currentnextsys;
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
    else if (fieldName.equalsIgnoreCase("ad_sequence_org_id") || fieldName.equals("adSequenceOrgId"))
      return adSequenceOrgId;
    else if (fieldName.equalsIgnoreCase("ad_sequence_id") || fieldName.equals("adSequenceId"))
      return adSequenceId;
    else if (fieldName.equalsIgnoreCase("ad_sequence_idr") || fieldName.equals("adSequenceIdr"))
      return adSequenceIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isautosequence"))
      return isautosequence;
    else if (fieldName.equalsIgnoreCase("istableid"))
      return istableid;
    else if (fieldName.equalsIgnoreCase("incrementno"))
      return incrementno;
    else if (fieldName.equalsIgnoreCase("currentnext"))
      return currentnext;
    else if (fieldName.equalsIgnoreCase("startnewyear"))
      return startnewyear;
    else if (fieldName.equalsIgnoreCase("startno"))
      return startno;
    else if (fieldName.equalsIgnoreCase("prefix"))
      return prefix;
    else if (fieldName.equalsIgnoreCase("vformat"))
      return vformat;
    else if (fieldName.equalsIgnoreCase("suffix"))
      return suffix;
    else if (fieldName.equalsIgnoreCase("currentnextsys"))
      return currentnextsys;
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
  public static OrgSpecificData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adSequenceId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adSequenceId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static OrgSpecificData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adSequenceId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_sequence_org.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_sequence_org.CreatedBy) as CreatedByR, " +
      "        to_char(ad_sequence_org.Updated, ?) as updated, " +
      "        to_char(ad_sequence_org.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_sequence_org.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_sequence_org.UpdatedBy) as UpdatedByR," +
      "        ad_sequence_org.AD_Sequence_Org_ID, " +
      "ad_sequence_org.AD_Sequence_ID, " +
      "(CASE WHEN ad_sequence_org.AD_Sequence_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Sequence_IDR, " +
      "ad_sequence_org.AD_Org_ID, " +
      "(CASE WHEN ad_sequence_org.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "ad_sequence_org.Name, " +
      "ad_sequence_org.AD_Client_ID, " +
      "COALESCE(ad_sequence_org.Isactive, 'N') AS Isactive, " +
      "COALESCE(ad_sequence_org.Isautosequence, 'N') AS Isautosequence, " +
      "COALESCE(ad_sequence_org.Istableid, 'N') AS Istableid, " +
      "ad_sequence_org.Incrementno, " +
      "ad_sequence_org.Currentnext, " +
      "COALESCE(ad_sequence_org.Startnewyear, 'N') AS Startnewyear, " +
      "ad_sequence_org.Startno, " +
      "ad_sequence_org.Prefix, " +
      "ad_sequence_org.Vformat, " +
      "ad_sequence_org.Suffix, " +
      "ad_sequence_org.Currentnextsys, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_sequence_org left join (select AD_Sequence_ID, Name from AD_Sequence) table1 on (ad_sequence_org.AD_Sequence_ID = table1.AD_Sequence_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (ad_sequence_org.AD_Org_ID = table2.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adSequenceId==null || adSequenceId.equals(""))?"":"  AND ad_sequence_org.AD_Sequence_ID = ?  ");
    strSql = strSql + 
      "        AND ad_sequence_org.AD_Sequence_Org_ID = ? " +
      "        AND ad_sequence_org.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_sequence_org.AD_Org_ID IN (";
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
      if (adSequenceId != null && !(adSequenceId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSequenceId);
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
        OrgSpecificData objectOrgSpecificData = new OrgSpecificData();
        objectOrgSpecificData.created = UtilSql.getValue(result, "created");
        objectOrgSpecificData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectOrgSpecificData.updated = UtilSql.getValue(result, "updated");
        objectOrgSpecificData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectOrgSpecificData.updatedby = UtilSql.getValue(result, "updatedby");
        objectOrgSpecificData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectOrgSpecificData.adSequenceOrgId = UtilSql.getValue(result, "ad_sequence_org_id");
        objectOrgSpecificData.adSequenceId = UtilSql.getValue(result, "ad_sequence_id");
        objectOrgSpecificData.adSequenceIdr = UtilSql.getValue(result, "ad_sequence_idr");
        objectOrgSpecificData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectOrgSpecificData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectOrgSpecificData.name = UtilSql.getValue(result, "name");
        objectOrgSpecificData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectOrgSpecificData.isactive = UtilSql.getValue(result, "isactive");
        objectOrgSpecificData.isautosequence = UtilSql.getValue(result, "isautosequence");
        objectOrgSpecificData.istableid = UtilSql.getValue(result, "istableid");
        objectOrgSpecificData.incrementno = UtilSql.getValue(result, "incrementno");
        objectOrgSpecificData.currentnext = UtilSql.getValue(result, "currentnext");
        objectOrgSpecificData.startnewyear = UtilSql.getValue(result, "startnewyear");
        objectOrgSpecificData.startno = UtilSql.getValue(result, "startno");
        objectOrgSpecificData.prefix = UtilSql.getValue(result, "prefix");
        objectOrgSpecificData.vformat = UtilSql.getValue(result, "vformat");
        objectOrgSpecificData.suffix = UtilSql.getValue(result, "suffix");
        objectOrgSpecificData.currentnextsys = UtilSql.getValue(result, "currentnextsys");
        objectOrgSpecificData.language = UtilSql.getValue(result, "language");
        objectOrgSpecificData.adUserClient = "";
        objectOrgSpecificData.adOrgClient = "";
        objectOrgSpecificData.createdby = "";
        objectOrgSpecificData.trBgcolor = "";
        objectOrgSpecificData.totalCount = "";
        objectOrgSpecificData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOrgSpecificData);
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
    OrgSpecificData objectOrgSpecificData[] = new OrgSpecificData[vector.size()];
    vector.copyInto(objectOrgSpecificData);
    return(objectOrgSpecificData);
  }

/**
Create a registry
 */
  public static OrgSpecificData[] set(String adSequenceId, String adOrgId, String incrementno, String updatedby, String updatedbyr, String istableid, String name, String currentnextsys, String vformat, String startno, String isactive, String currentnext, String adSequenceOrgId, String prefix, String suffix, String startnewyear, String adClientId, String createdby, String createdbyr, String isautosequence)    throws ServletException {
    OrgSpecificData objectOrgSpecificData[] = new OrgSpecificData[1];
    objectOrgSpecificData[0] = new OrgSpecificData();
    objectOrgSpecificData[0].created = "";
    objectOrgSpecificData[0].createdbyr = createdbyr;
    objectOrgSpecificData[0].updated = "";
    objectOrgSpecificData[0].updatedTimeStamp = "";
    objectOrgSpecificData[0].updatedby = updatedby;
    objectOrgSpecificData[0].updatedbyr = updatedbyr;
    objectOrgSpecificData[0].adSequenceOrgId = adSequenceOrgId;
    objectOrgSpecificData[0].adSequenceId = adSequenceId;
    objectOrgSpecificData[0].adSequenceIdr = "";
    objectOrgSpecificData[0].adOrgId = adOrgId;
    objectOrgSpecificData[0].adOrgIdr = "";
    objectOrgSpecificData[0].name = name;
    objectOrgSpecificData[0].adClientId = adClientId;
    objectOrgSpecificData[0].isactive = isactive;
    objectOrgSpecificData[0].isautosequence = isautosequence;
    objectOrgSpecificData[0].istableid = istableid;
    objectOrgSpecificData[0].incrementno = incrementno;
    objectOrgSpecificData[0].currentnext = currentnext;
    objectOrgSpecificData[0].startnewyear = startnewyear;
    objectOrgSpecificData[0].startno = startno;
    objectOrgSpecificData[0].prefix = prefix;
    objectOrgSpecificData[0].vformat = vformat;
    objectOrgSpecificData[0].suffix = suffix;
    objectOrgSpecificData[0].currentnextsys = currentnextsys;
    objectOrgSpecificData[0].language = "";
    return objectOrgSpecificData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefA2DA2F6382FF44DD9D743A3E478F90F5_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefDDC4751D853C4387963E731CB9EF2CDF_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT ad_sequence_org.AD_Sequence_ID AS NAME" +
      "        FROM ad_sequence_org" +
      "        WHERE ad_sequence_org.AD_Sequence_Org_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adSequenceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Sequence left join (select AD_Sequence_ID, Name from AD_Sequence) table1 on (AD_Sequence.AD_Sequence_ID = table1.AD_Sequence_ID) WHERE AD_Sequence.AD_Sequence_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSequenceId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adSequenceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Sequence left join (select AD_Sequence_ID, Name from AD_Sequence) table1 on (AD_Sequence.AD_Sequence_ID = table1.AD_Sequence_ID) WHERE AD_Sequence.AD_Sequence_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSequenceId);

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
      "        UPDATE ad_sequence_org" +
      "        SET AD_Sequence_Org_ID = (?) , AD_Sequence_ID = (?) , AD_Org_ID = (?) , Name = (?) , AD_Client_ID = (?) , Isactive = (?) , Isautosequence = (?) , Istableid = (?) , Incrementno = TO_NUMBER(?) , Currentnext = TO_NUMBER(?) , Startnewyear = (?) , Startno = TO_NUMBER(?) , Prefix = (?) , Vformat = (?) , Suffix = (?) , Currentnextsys = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE ad_sequence_org.AD_Sequence_Org_ID = ? " +
      "                 AND ad_sequence_org.AD_Sequence_ID = ? " +
      "        AND ad_sequence_org.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_sequence_org.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSequenceOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSequenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isautosequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istableid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, incrementno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currentnext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startnewyear);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, prefix);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, suffix);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currentnextsys);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSequenceOrgId);
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
      "        INSERT INTO ad_sequence_org " +
      "        (AD_Sequence_Org_ID, AD_Sequence_ID, AD_Org_ID, Name, AD_Client_ID, Isactive, Isautosequence, Istableid, Incrementno, Currentnext, Startnewyear, Startno, Prefix, Vformat, Suffix, Currentnextsys, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSequenceOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSequenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isautosequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istableid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, incrementno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currentnext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startnewyear);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, prefix);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, suffix);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currentnextsys);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adSequenceId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_sequence_org" +
      "        WHERE ad_sequence_org.AD_Sequence_Org_ID = ? " +
      "                 AND ad_sequence_org.AD_Sequence_ID = ? " +
      "        AND ad_sequence_org.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_sequence_org.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adSequenceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_sequence_org" +
      "        WHERE ad_sequence_org.AD_Sequence_Org_ID = ? " +
      "                 AND ad_sequence_org.AD_Sequence_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSequenceId);

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
      "          FROM ad_sequence_org" +
      "         WHERE ad_sequence_org.AD_Sequence_Org_ID = ? ";

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
      "          FROM ad_sequence_org" +
      "         WHERE ad_sequence_org.AD_Sequence_Org_ID = ? ";

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
