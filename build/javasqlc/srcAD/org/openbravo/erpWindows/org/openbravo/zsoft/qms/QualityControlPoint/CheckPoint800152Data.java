//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.qms.QualityControlPoint;

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
class CheckPoint800152Data implements FieldProvider {
static Logger log4j = Logger.getLogger(CheckPoint800152Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String maCcpId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String maCcpGroupId;
  public String maCcpGroupIdr;
  public String isactive;
  public String name;
  public String description;
  public String valuetype;
  public String valuetyper;
  public String critical;
  public String valuenumber;
  public String seqno;
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
    else if (fieldName.equalsIgnoreCase("ma_ccp_id") || fieldName.equals("maCcpId"))
      return maCcpId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ma_ccp_group_id") || fieldName.equals("maCcpGroupId"))
      return maCcpGroupId;
    else if (fieldName.equalsIgnoreCase("ma_ccp_group_idr") || fieldName.equals("maCcpGroupIdr"))
      return maCcpGroupIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("valuetype"))
      return valuetype;
    else if (fieldName.equalsIgnoreCase("valuetyper"))
      return valuetyper;
    else if (fieldName.equalsIgnoreCase("critical"))
      return critical;
    else if (fieldName.equalsIgnoreCase("valuenumber"))
      return valuenumber;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
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
  public static CheckPoint800152Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maCcpGroupId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maCcpGroupId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CheckPoint800152Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maCcpGroupId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_CCP.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_CCP.CreatedBy) as CreatedByR, " +
      "        to_char(MA_CCP.Updated, ?) as updated, " +
      "        to_char(MA_CCP.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_CCP.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_CCP.UpdatedBy) as UpdatedByR," +
      "        MA_CCP.MA_Ccp_ID, " +
      "MA_CCP.AD_Client_ID, " +
      "(CASE WHEN MA_CCP.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MA_CCP.AD_Org_ID, " +
      "(CASE WHEN MA_CCP.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MA_CCP.MA_CCP_Group_ID, " +
      "(CASE WHEN MA_CCP.MA_CCP_Group_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS MA_CCP_Group_IDR, " +
      "COALESCE(MA_CCP.IsActive, 'N') AS IsActive, " +
      "MA_CCP.Name, " +
      "MA_CCP.Description, " +
      "MA_CCP.Valuetype, " +
      "(CASE WHEN MA_CCP.Valuetype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ValuetypeR, " +
      "COALESCE(MA_CCP.Critical, 'N') AS Critical, " +
      "MA_CCP.Valuenumber, " +
      "MA_CCP.SeqNo, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_CCP left join (select AD_Client_ID, Name from AD_Client) table1 on (MA_CCP.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MA_CCP.AD_Org_ID = table2.AD_Org_ID) left join (select MA_CCP_Group_ID, Name from MA_CCP_Group) table3 on (MA_CCP.MA_CCP_Group_ID = table3.MA_CCP_Group_ID) left join ad_ref_list_v list1 on (MA_CCP.Valuetype = list1.value and list1.ad_reference_id = '800039' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maCcpGroupId==null || maCcpGroupId.equals(""))?"":"  AND MA_CCP.MA_CCP_Group_ID = ?  ");
    strSql = strSql + 
      "        AND MA_CCP.MA_Ccp_ID = ? " +
      "        AND MA_CCP.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_CCP.AD_Org_ID IN (";
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
      if (maCcpGroupId != null && !(maCcpGroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCcpGroupId);
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
        CheckPoint800152Data objectCheckPoint800152Data = new CheckPoint800152Data();
        objectCheckPoint800152Data.created = UtilSql.getValue(result, "created");
        objectCheckPoint800152Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCheckPoint800152Data.updated = UtilSql.getValue(result, "updated");
        objectCheckPoint800152Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCheckPoint800152Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectCheckPoint800152Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCheckPoint800152Data.maCcpId = UtilSql.getValue(result, "ma_ccp_id");
        objectCheckPoint800152Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCheckPoint800152Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectCheckPoint800152Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCheckPoint800152Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectCheckPoint800152Data.maCcpGroupId = UtilSql.getValue(result, "ma_ccp_group_id");
        objectCheckPoint800152Data.maCcpGroupIdr = UtilSql.getValue(result, "ma_ccp_group_idr");
        objectCheckPoint800152Data.isactive = UtilSql.getValue(result, "isactive");
        objectCheckPoint800152Data.name = UtilSql.getValue(result, "name");
        objectCheckPoint800152Data.description = UtilSql.getValue(result, "description");
        objectCheckPoint800152Data.valuetype = UtilSql.getValue(result, "valuetype");
        objectCheckPoint800152Data.valuetyper = UtilSql.getValue(result, "valuetyper");
        objectCheckPoint800152Data.critical = UtilSql.getValue(result, "critical");
        objectCheckPoint800152Data.valuenumber = UtilSql.getValue(result, "valuenumber");
        objectCheckPoint800152Data.seqno = UtilSql.getValue(result, "seqno");
        objectCheckPoint800152Data.language = UtilSql.getValue(result, "language");
        objectCheckPoint800152Data.adUserClient = "";
        objectCheckPoint800152Data.adOrgClient = "";
        objectCheckPoint800152Data.createdby = "";
        objectCheckPoint800152Data.trBgcolor = "";
        objectCheckPoint800152Data.totalCount = "";
        objectCheckPoint800152Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCheckPoint800152Data);
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
    CheckPoint800152Data objectCheckPoint800152Data[] = new CheckPoint800152Data[vector.size()];
    vector.copyInto(objectCheckPoint800152Data);
    return(objectCheckPoint800152Data);
  }

/**
Create a registry
 */
  public static CheckPoint800152Data[] set(String maCcpGroupId, String name, String createdby, String createdbyr, String description, String isactive, String valuenumber, String updatedby, String updatedbyr, String seqno, String adOrgId, String maCcpId, String critical, String adClientId, String valuetype)    throws ServletException {
    CheckPoint800152Data objectCheckPoint800152Data[] = new CheckPoint800152Data[1];
    objectCheckPoint800152Data[0] = new CheckPoint800152Data();
    objectCheckPoint800152Data[0].created = "";
    objectCheckPoint800152Data[0].createdbyr = createdbyr;
    objectCheckPoint800152Data[0].updated = "";
    objectCheckPoint800152Data[0].updatedTimeStamp = "";
    objectCheckPoint800152Data[0].updatedby = updatedby;
    objectCheckPoint800152Data[0].updatedbyr = updatedbyr;
    objectCheckPoint800152Data[0].maCcpId = maCcpId;
    objectCheckPoint800152Data[0].adClientId = adClientId;
    objectCheckPoint800152Data[0].adClientIdr = "";
    objectCheckPoint800152Data[0].adOrgId = adOrgId;
    objectCheckPoint800152Data[0].adOrgIdr = "";
    objectCheckPoint800152Data[0].maCcpGroupId = maCcpGroupId;
    objectCheckPoint800152Data[0].maCcpGroupIdr = "";
    objectCheckPoint800152Data[0].isactive = isactive;
    objectCheckPoint800152Data[0].name = name;
    objectCheckPoint800152Data[0].description = description;
    objectCheckPoint800152Data[0].valuetype = valuetype;
    objectCheckPoint800152Data[0].valuetyper = "";
    objectCheckPoint800152Data[0].critical = critical;
    objectCheckPoint800152Data[0].valuenumber = valuenumber;
    objectCheckPoint800152Data[0].seqno = seqno;
    objectCheckPoint800152Data[0].language = "";
    return objectCheckPoint800152Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef802223_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef802225_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef802315(ConnectionProvider connectionProvider, String MA_CCP_GROUP_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(SEQNO),0)+10 AS DefaultValue FROM MA_CCP WHERE MA_CCP_GROUP_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MA_CCP_GROUP_ID);

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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MA_CCP.MA_CCP_Group_ID AS NAME" +
      "        FROM MA_CCP" +
      "        WHERE MA_CCP.MA_Ccp_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String maCcpGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MA_CCP_Group left join (select MA_CCP_Group_ID, Name from MA_CCP_Group) table1 on (MA_CCP_Group.MA_CCP_Group_ID = table1.MA_CCP_Group_ID) WHERE MA_CCP_Group.MA_CCP_Group_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCcpGroupId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String maCcpGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MA_CCP_Group left join (select MA_CCP_Group_ID, Name from MA_CCP_Group) table1 on (MA_CCP_Group.MA_CCP_Group_ID = table1.MA_CCP_Group_ID) WHERE MA_CCP_Group.MA_CCP_Group_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCcpGroupId);

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
      "        UPDATE MA_CCP" +
      "        SET MA_Ccp_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , MA_CCP_Group_ID = (?) , IsActive = (?) , Name = (?) , Description = (?) , Valuetype = (?) , Critical = (?) , Valuenumber = TO_NUMBER(?) , SeqNo = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE MA_CCP.MA_Ccp_ID = ? " +
      "                 AND MA_CCP.MA_CCP_Group_ID = ? " +
      "        AND MA_CCP.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_CCP.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCcpId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCcpGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, valuetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, critical);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, valuenumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCcpId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCcpGroupId);
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
      "        INSERT INTO MA_CCP " +
      "        (MA_Ccp_ID, AD_Client_ID, AD_Org_ID, MA_CCP_Group_ID, IsActive, Name, Description, Valuetype, Critical, Valuenumber, SeqNo, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCcpId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCcpGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, valuetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, critical);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, valuenumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maCcpGroupId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_CCP" +
      "        WHERE MA_CCP.MA_Ccp_ID = ? " +
      "                 AND MA_CCP.MA_CCP_Group_ID = ? " +
      "        AND MA_CCP.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_CCP.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCcpGroupId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String maCcpGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_CCP" +
      "        WHERE MA_CCP.MA_Ccp_ID = ? " +
      "                 AND MA_CCP.MA_CCP_Group_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCcpGroupId);

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
      "          FROM MA_CCP" +
      "         WHERE MA_CCP.MA_Ccp_ID = ? ";

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
      "          FROM MA_CCP" +
      "         WHERE MA_CCP.MA_Ccp_ID = ? ";

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
