//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Workflow;

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
class NextStepData implements FieldProvider {
static Logger log4j = Logger.getLogger(NextStepData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adWfNodenextId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String adWfNodeId;
  public String adWfNodeIdr;
  public String adWfNextId;
  public String adWfNextIdr;
  public String isactive;
  public String condition;
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
    else if (fieldName.equalsIgnoreCase("ad_wf_nodenext_id") || fieldName.equals("adWfNodenextId"))
      return adWfNodenextId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_wf_node_id") || fieldName.equals("adWfNodeId"))
      return adWfNodeId;
    else if (fieldName.equalsIgnoreCase("ad_wf_node_idr") || fieldName.equals("adWfNodeIdr"))
      return adWfNodeIdr;
    else if (fieldName.equalsIgnoreCase("ad_wf_next_id") || fieldName.equals("adWfNextId"))
      return adWfNextId;
    else if (fieldName.equalsIgnoreCase("ad_wf_next_idr") || fieldName.equals("adWfNextIdr"))
      return adWfNextIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("condition"))
      return condition;
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
  public static NextStepData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adWfNodeId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adWfNodeId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static NextStepData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adWfNodeId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_WF_NodeNext.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_WF_NodeNext.CreatedBy) as CreatedByR, " +
      "        to_char(AD_WF_NodeNext.Updated, ?) as updated, " +
      "        to_char(AD_WF_NodeNext.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_WF_NodeNext.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_WF_NodeNext.UpdatedBy) as UpdatedByR," +
      "        AD_WF_NodeNext.AD_WF_NodeNext_ID, " +
      "AD_WF_NodeNext.AD_Client_ID, " +
      "(CASE WHEN AD_WF_NodeNext.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_WF_NodeNext.AD_Org_ID, " +
      "(CASE WHEN AD_WF_NodeNext.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_WF_NodeNext.AD_WF_Node_ID, " +
      "(CASE WHEN AD_WF_NodeNext.AD_WF_Node_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_WF_Node_IDR, " +
      "AD_WF_NodeNext.AD_WF_Next_ID, " +
      "(CASE WHEN AD_WF_NodeNext.AD_WF_Next_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_WF_Next_IDR, " +
      "COALESCE(AD_WF_NodeNext.IsActive, 'N') AS IsActive, " +
      "AD_WF_NodeNext.Condition, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_WF_NodeNext left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_WF_NodeNext.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_WF_NodeNext.AD_Org_ID = table2.AD_Org_ID) left join (select AD_WF_Node_ID, Name from AD_WF_Node) table3 on (AD_WF_NodeNext.AD_WF_Node_ID = table3.AD_WF_Node_ID) left join (select AD_WF_Node_ID, Name from AD_WF_Node) table4 on (AD_WF_NodeNext.AD_WF_Next_ID =  table4.AD_WF_Node_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adWfNodeId==null || adWfNodeId.equals(""))?"":"  AND AD_WF_NodeNext.AD_WF_Node_ID = ?  ");
    strSql = strSql + 
      "        AND AD_WF_NodeNext.AD_WF_NodeNext_ID = ? " +
      "        AND AD_WF_NodeNext.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_WF_NodeNext.AD_Org_ID IN (";
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
      if (adWfNodeId != null && !(adWfNodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodeId);
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
        NextStepData objectNextStepData = new NextStepData();
        objectNextStepData.created = UtilSql.getValue(result, "created");
        objectNextStepData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectNextStepData.updated = UtilSql.getValue(result, "updated");
        objectNextStepData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectNextStepData.updatedby = UtilSql.getValue(result, "updatedby");
        objectNextStepData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectNextStepData.adWfNodenextId = UtilSql.getValue(result, "ad_wf_nodenext_id");
        objectNextStepData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectNextStepData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectNextStepData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectNextStepData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectNextStepData.adWfNodeId = UtilSql.getValue(result, "ad_wf_node_id");
        objectNextStepData.adWfNodeIdr = UtilSql.getValue(result, "ad_wf_node_idr");
        objectNextStepData.adWfNextId = UtilSql.getValue(result, "ad_wf_next_id");
        objectNextStepData.adWfNextIdr = UtilSql.getValue(result, "ad_wf_next_idr");
        objectNextStepData.isactive = UtilSql.getValue(result, "isactive");
        objectNextStepData.condition = UtilSql.getValue(result, "condition");
        objectNextStepData.language = UtilSql.getValue(result, "language");
        objectNextStepData.adUserClient = "";
        objectNextStepData.adOrgClient = "";
        objectNextStepData.createdby = "";
        objectNextStepData.trBgcolor = "";
        objectNextStepData.totalCount = "";
        objectNextStepData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectNextStepData);
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
    NextStepData objectNextStepData[] = new NextStepData[vector.size()];
    vector.copyInto(objectNextStepData);
    return(objectNextStepData);
  }

/**
Create a registry
 */
  public static NextStepData[] set(String adWfNodeId, String adWfNodenextId, String adClientId, String isactive, String condition, String adOrgId, String adWfNextId, String createdby, String createdbyr, String updatedby, String updatedbyr)    throws ServletException {
    NextStepData objectNextStepData[] = new NextStepData[1];
    objectNextStepData[0] = new NextStepData();
    objectNextStepData[0].created = "";
    objectNextStepData[0].createdbyr = createdbyr;
    objectNextStepData[0].updated = "";
    objectNextStepData[0].updatedTimeStamp = "";
    objectNextStepData[0].updatedby = updatedby;
    objectNextStepData[0].updatedbyr = updatedbyr;
    objectNextStepData[0].adWfNodenextId = adWfNodenextId;
    objectNextStepData[0].adClientId = adClientId;
    objectNextStepData[0].adClientIdr = "";
    objectNextStepData[0].adOrgId = adOrgId;
    objectNextStepData[0].adOrgIdr = "";
    objectNextStepData[0].adWfNodeId = adWfNodeId;
    objectNextStepData[0].adWfNodeIdr = "";
    objectNextStepData[0].adWfNextId = adWfNextId;
    objectNextStepData[0].adWfNextIdr = "";
    objectNextStepData[0].isactive = isactive;
    objectNextStepData[0].condition = condition;
    objectNextStepData[0].language = "";
    return objectNextStepData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef693_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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

/**
Select for auxiliar field
 */
  public static String selectDef695_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_WF_NodeNext.AD_WF_Node_ID AS NAME" +
      "        FROM AD_WF_NodeNext" +
      "        WHERE AD_WF_NodeNext.AD_WF_NodeNext_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adWfNodeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_WF_Node left join (select AD_WF_Node_ID, Name from AD_WF_Node) table1 on (AD_WF_Node.AD_WF_Node_ID = table1.AD_WF_Node_ID) WHERE AD_WF_Node.AD_WF_Node_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodeId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adWfNodeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_WF_Node left join (select AD_WF_Node_ID, Name from AD_WF_Node) table1 on (AD_WF_Node.AD_WF_Node_ID = table1.AD_WF_Node_ID) WHERE AD_WF_Node.AD_WF_Node_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodeId);

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
      "        UPDATE AD_WF_NodeNext" +
      "        SET AD_WF_NodeNext_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , AD_WF_Node_ID = (?) , AD_WF_Next_ID = (?) , IsActive = (?) , Condition = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_WF_NodeNext.AD_WF_NodeNext_ID = ? " +
      "                 AND AD_WF_NodeNext.AD_WF_Node_ID = ? " +
      "        AND AD_WF_NodeNext.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_WF_NodeNext.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodenextId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNextId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, condition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodenextId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodeId);
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
      "        INSERT INTO AD_WF_NodeNext " +
      "        (AD_WF_NodeNext_ID, AD_Client_ID, AD_Org_ID, AD_WF_Node_ID, AD_WF_Next_ID, IsActive, Condition, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodenextId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNextId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, condition);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adWfNodeId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_WF_NodeNext" +
      "        WHERE AD_WF_NodeNext.AD_WF_NodeNext_ID = ? " +
      "                 AND AD_WF_NodeNext.AD_WF_Node_ID = ? " +
      "        AND AD_WF_NodeNext.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_WF_NodeNext.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodeId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adWfNodeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_WF_NodeNext" +
      "        WHERE AD_WF_NodeNext.AD_WF_NodeNext_ID = ? " +
      "                 AND AD_WF_NodeNext.AD_WF_Node_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodeId);

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
      "          FROM AD_WF_NodeNext" +
      "         WHERE AD_WF_NodeNext.AD_WF_NodeNext_ID = ? ";

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
      "          FROM AD_WF_NodeNext" +
      "         WHERE AD_WF_NodeNext.AD_WF_NodeNext_ID = ? ";

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
