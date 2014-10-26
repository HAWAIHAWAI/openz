//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.WorkRequirement;

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
class Operation800112Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Operation800112Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String maWrphaseId;
  public String adOrgId;
  public String adOrgIdr;
  public String maWorkrequirementId;
  public String maWorkrequirementIdr;
  public String description;
  public String isactive;
  public String maSequenceId;
  public String maSequenceIdr;
  public String maProcessId;
  public String maProcessIdr;
  public String seqno;
  public String quantity;
  public String donequantity;
  public String costcenteruse;
  public String preptime;
  public String noqty;
  public String groupuse;
  public String closed;
  public String outsourced;
  public String name;
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
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ma_wrphase_id") || fieldName.equals("maWrphaseId"))
      return maWrphaseId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ma_workrequirement_id") || fieldName.equals("maWorkrequirementId"))
      return maWorkrequirementId;
    else if (fieldName.equalsIgnoreCase("ma_workrequirement_idr") || fieldName.equals("maWorkrequirementIdr"))
      return maWorkrequirementIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ma_sequence_id") || fieldName.equals("maSequenceId"))
      return maSequenceId;
    else if (fieldName.equalsIgnoreCase("ma_sequence_idr") || fieldName.equals("maSequenceIdr"))
      return maSequenceIdr;
    else if (fieldName.equalsIgnoreCase("ma_process_id") || fieldName.equals("maProcessId"))
      return maProcessId;
    else if (fieldName.equalsIgnoreCase("ma_process_idr") || fieldName.equals("maProcessIdr"))
      return maProcessIdr;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("donequantity"))
      return donequantity;
    else if (fieldName.equalsIgnoreCase("costcenteruse"))
      return costcenteruse;
    else if (fieldName.equalsIgnoreCase("preptime"))
      return preptime;
    else if (fieldName.equalsIgnoreCase("noqty"))
      return noqty;
    else if (fieldName.equalsIgnoreCase("groupuse"))
      return groupuse;
    else if (fieldName.equalsIgnoreCase("closed"))
      return closed;
    else if (fieldName.equalsIgnoreCase("outsourced"))
      return outsourced;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
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
  public static Operation800112Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maWorkrequirementId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maWorkrequirementId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Operation800112Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maWorkrequirementId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_WRPhase.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_WRPhase.CreatedBy) as CreatedByR, " +
      "        to_char(MA_WRPhase.Updated, ?) as updated, " +
      "        to_char(MA_WRPhase.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_WRPhase.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_WRPhase.UpdatedBy) as UpdatedByR," +
      "        MA_WRPhase.AD_Client_ID, " +
      "(CASE WHEN MA_WRPhase.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MA_WRPhase.MA_Wrphase_ID, " +
      "MA_WRPhase.AD_Org_ID, " +
      "(CASE WHEN MA_WRPhase.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MA_WRPhase.MA_Workrequirement_ID, " +
      "(CASE WHEN MA_WRPhase.MA_Workrequirement_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.StartDate, 'DD-MM-YYYY')),'') ) END) AS MA_Workrequirement_IDR, " +
      "MA_WRPhase.Description, " +
      "COALESCE(MA_WRPhase.IsActive, 'N') AS IsActive, " +
      "MA_WRPhase.MA_Sequence_ID, " +
      "(CASE WHEN MA_WRPhase.MA_Sequence_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS MA_Sequence_IDR, " +
      "MA_WRPhase.MA_Process_ID, " +
      "(CASE WHEN MA_WRPhase.MA_Process_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS MA_Process_IDR, " +
      "MA_WRPhase.SeqNo, " +
      "MA_WRPhase.Quantity, " +
      "MA_WRPhase.Donequantity, " +
      "MA_WRPhase.CostCenterUse, " +
      "MA_WRPhase.Preptime, " +
      "COALESCE(MA_WRPhase.Noqty, 'N') AS Noqty, " +
      "COALESCE(MA_WRPhase.Groupuse, 'N') AS Groupuse, " +
      "MA_WRPhase.Closed, " +
      "COALESCE(MA_WRPhase.Outsourced, 'N') AS Outsourced, " +
      "MA_WRPhase.Name, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_WRPhase left join (select AD_Client_ID, Name from AD_Client) table1 on (MA_WRPhase.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MA_WRPhase.AD_Org_ID = table2.AD_Org_ID) left join (select MA_Workrequirement_ID, DocumentNo, StartDate from MA_Workrequirement) table3 on (MA_WRPhase.MA_Workrequirement_ID = table3.MA_Workrequirement_ID) left join (select MA_Sequence_ID, Name from MA_Sequence) table4 on (MA_WRPhase.MA_Sequence_ID = table4.MA_Sequence_ID) left join (select MA_Process_ID, Name from MA_Process) table5 on (MA_WRPhase.MA_Process_ID = table5.MA_Process_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maWorkrequirementId==null || maWorkrequirementId.equals(""))?"":"  AND MA_WRPhase.MA_Workrequirement_ID = ?  ");
    strSql = strSql + 
      "        AND MA_WRPhase.MA_Wrphase_ID = ? " +
      "        AND MA_WRPhase.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_WRPhase.AD_Org_ID IN (";
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
      if (maWorkrequirementId != null && !(maWorkrequirementId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
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
        Operation800112Data objectOperation800112Data = new Operation800112Data();
        objectOperation800112Data.created = UtilSql.getValue(result, "created");
        objectOperation800112Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectOperation800112Data.updated = UtilSql.getValue(result, "updated");
        objectOperation800112Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectOperation800112Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectOperation800112Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectOperation800112Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectOperation800112Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectOperation800112Data.maWrphaseId = UtilSql.getValue(result, "ma_wrphase_id");
        objectOperation800112Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectOperation800112Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectOperation800112Data.maWorkrequirementId = UtilSql.getValue(result, "ma_workrequirement_id");
        objectOperation800112Data.maWorkrequirementIdr = UtilSql.getValue(result, "ma_workrequirement_idr");
        objectOperation800112Data.description = UtilSql.getValue(result, "description");
        objectOperation800112Data.isactive = UtilSql.getValue(result, "isactive");
        objectOperation800112Data.maSequenceId = UtilSql.getValue(result, "ma_sequence_id");
        objectOperation800112Data.maSequenceIdr = UtilSql.getValue(result, "ma_sequence_idr");
        objectOperation800112Data.maProcessId = UtilSql.getValue(result, "ma_process_id");
        objectOperation800112Data.maProcessIdr = UtilSql.getValue(result, "ma_process_idr");
        objectOperation800112Data.seqno = UtilSql.getValue(result, "seqno");
        objectOperation800112Data.quantity = UtilSql.getValue(result, "quantity");
        objectOperation800112Data.donequantity = UtilSql.getValue(result, "donequantity");
        objectOperation800112Data.costcenteruse = UtilSql.getValue(result, "costcenteruse");
        objectOperation800112Data.preptime = UtilSql.getValue(result, "preptime");
        objectOperation800112Data.noqty = UtilSql.getValue(result, "noqty");
        objectOperation800112Data.groupuse = UtilSql.getValue(result, "groupuse");
        objectOperation800112Data.closed = UtilSql.getValue(result, "closed");
        objectOperation800112Data.outsourced = UtilSql.getValue(result, "outsourced");
        objectOperation800112Data.name = UtilSql.getValue(result, "name");
        objectOperation800112Data.language = UtilSql.getValue(result, "language");
        objectOperation800112Data.adUserClient = "";
        objectOperation800112Data.adOrgClient = "";
        objectOperation800112Data.createdby = "";
        objectOperation800112Data.trBgcolor = "";
        objectOperation800112Data.totalCount = "";
        objectOperation800112Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOperation800112Data);
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
    Operation800112Data objectOperation800112Data[] = new Operation800112Data[vector.size()];
    vector.copyInto(objectOperation800112Data);
    return(objectOperation800112Data);
  }

/**
Create a registry
 */
  public static Operation800112Data[] set(String maWorkrequirementId, String createdby, String createdbyr, String maWrphaseId, String preptime, String groupuse, String name, String closed, String isactive, String outsourced, String seqno, String adClientId, String costcenteruse, String adOrgId, String maProcessId, String maSequenceId, String noqty, String quantity, String description, String donequantity, String updatedby, String updatedbyr)    throws ServletException {
    Operation800112Data objectOperation800112Data[] = new Operation800112Data[1];
    objectOperation800112Data[0] = new Operation800112Data();
    objectOperation800112Data[0].created = "";
    objectOperation800112Data[0].createdbyr = createdbyr;
    objectOperation800112Data[0].updated = "";
    objectOperation800112Data[0].updatedTimeStamp = "";
    objectOperation800112Data[0].updatedby = updatedby;
    objectOperation800112Data[0].updatedbyr = updatedbyr;
    objectOperation800112Data[0].adClientId = adClientId;
    objectOperation800112Data[0].adClientIdr = "";
    objectOperation800112Data[0].maWrphaseId = maWrphaseId;
    objectOperation800112Data[0].adOrgId = adOrgId;
    objectOperation800112Data[0].adOrgIdr = "";
    objectOperation800112Data[0].maWorkrequirementId = maWorkrequirementId;
    objectOperation800112Data[0].maWorkrequirementIdr = "";
    objectOperation800112Data[0].description = description;
    objectOperation800112Data[0].isactive = isactive;
    objectOperation800112Data[0].maSequenceId = maSequenceId;
    objectOperation800112Data[0].maSequenceIdr = "";
    objectOperation800112Data[0].maProcessId = maProcessId;
    objectOperation800112Data[0].maProcessIdr = "";
    objectOperation800112Data[0].seqno = seqno;
    objectOperation800112Data[0].quantity = quantity;
    objectOperation800112Data[0].donequantity = donequantity;
    objectOperation800112Data[0].costcenteruse = costcenteruse;
    objectOperation800112Data[0].preptime = preptime;
    objectOperation800112Data[0].noqty = noqty;
    objectOperation800112Data[0].groupuse = groupuse;
    objectOperation800112Data[0].closed = closed;
    objectOperation800112Data[0].outsourced = outsourced;
    objectOperation800112Data[0].name = name;
    objectOperation800112Data[0].language = "";
    return objectOperation800112Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef801569_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef801759(ConnectionProvider connectionProvider, String MA_WORKREQUIREMENT_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(SEQNO),0)+10 AS DefaultValue FROM MA_WRPHASE WHERE MA_WORKREQUIREMENT_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MA_WORKREQUIREMENT_ID);

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
  public static String selectDef801571_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT MA_WRPhase.MA_Workrequirement_ID AS NAME" +
      "        FROM MA_WRPhase" +
      "        WHERE MA_WRPhase.MA_Wrphase_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String maWorkrequirementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.StartDate, 'DD-MM-YYYY')) AS NAME FROM MA_WorkRequirement left join (select MA_Workrequirement_ID, DocumentNo, StartDate from MA_Workrequirement) table1 on (MA_WorkRequirement.MA_Workrequirement_ID = table1.MA_Workrequirement_ID) WHERE MA_WorkRequirement.MA_Workrequirement_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String maWorkrequirementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.StartDate, 'DD-MM-YYYY')) AS NAME FROM MA_WorkRequirement left join (select MA_Workrequirement_ID, DocumentNo, StartDate from MA_Workrequirement) table1 on (MA_WorkRequirement.MA_Workrequirement_ID = table1.MA_Workrequirement_ID) WHERE MA_WorkRequirement.MA_Workrequirement_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);

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
      "        UPDATE MA_WRPhase" +
      "        SET AD_Client_ID = (?) , MA_Wrphase_ID = (?) , AD_Org_ID = (?) , MA_Workrequirement_ID = (?) , Description = (?) , IsActive = (?) , MA_Sequence_ID = (?) , MA_Process_ID = (?) , SeqNo = TO_NUMBER(?) , Quantity = TO_NUMBER(?) , Donequantity = TO_NUMBER(?) , CostCenterUse = TO_NUMBER(?) , Preptime = TO_NUMBER(?) , Noqty = (?) , Groupuse = (?) , Closed = (?) , Outsourced = (?) , Name = (?) , updated = now(), updatedby = ? " +
      "        WHERE MA_WRPhase.MA_Wrphase_ID = ? " +
      "                 AND MA_WRPhase.MA_Workrequirement_ID = ? " +
      "        AND MA_WRPhase.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_WRPhase.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWrphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maSequenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, donequantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costcenteruse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, preptime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, noqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupuse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outsourced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWrphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
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
      "        INSERT INTO MA_WRPhase " +
      "        (AD_Client_ID, MA_Wrphase_ID, AD_Org_ID, MA_Workrequirement_ID, Description, IsActive, MA_Sequence_ID, MA_Process_ID, SeqNo, Quantity, Donequantity, CostCenterUse, Preptime, Noqty, Groupuse, Closed, Outsourced, Name, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWrphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maSequenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, donequantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costcenteruse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, preptime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, noqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupuse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outsourced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maWorkrequirementId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_WRPhase" +
      "        WHERE MA_WRPhase.MA_Wrphase_ID = ? " +
      "                 AND MA_WRPhase.MA_Workrequirement_ID = ? " +
      "        AND MA_WRPhase.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_WRPhase.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String maWorkrequirementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_WRPhase" +
      "        WHERE MA_WRPhase.MA_Wrphase_ID = ? " +
      "                 AND MA_WRPhase.MA_Workrequirement_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);

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
      "          FROM MA_WRPhase" +
      "         WHERE MA_WRPhase.MA_Wrphase_ID = ? ";

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
      "          FROM MA_WRPhase" +
      "         WHERE MA_WRPhase.MA_Wrphase_ID = ? ";

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
