//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.mrp.PlanningMethod;

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
class Lines800253Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Lines800253Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String mrpPlanningmethodlineId;
  public String adOrgId;
  public String adOrgIdr;
  public String mrpPlanningmethodId;
  public String mrpPlanningmethodIdr;
  public String line;
  public String isactive;
  public String inouttrxtype;
  public String inouttrxtyper;
  public String weighting;
  public String daysfrom;
  public String daysto;
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
    else if (fieldName.equalsIgnoreCase("mrp_planningmethodline_id") || fieldName.equals("mrpPlanningmethodlineId"))
      return mrpPlanningmethodlineId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("mrp_planningmethod_id") || fieldName.equals("mrpPlanningmethodId"))
      return mrpPlanningmethodId;
    else if (fieldName.equalsIgnoreCase("mrp_planningmethod_idr") || fieldName.equals("mrpPlanningmethodIdr"))
      return mrpPlanningmethodIdr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("inouttrxtype"))
      return inouttrxtype;
    else if (fieldName.equalsIgnoreCase("inouttrxtyper"))
      return inouttrxtyper;
    else if (fieldName.equalsIgnoreCase("weighting"))
      return weighting;
    else if (fieldName.equalsIgnoreCase("daysfrom"))
      return daysfrom;
    else if (fieldName.equalsIgnoreCase("daysto"))
      return daysto;
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
  public static Lines800253Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mrpPlanningmethodId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, mrpPlanningmethodId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Lines800253Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mrpPlanningmethodId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MRP_PlanningMethodLine.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MRP_PlanningMethodLine.CreatedBy) as CreatedByR, " +
      "        to_char(MRP_PlanningMethodLine.Updated, ?) as updated, " +
      "        to_char(MRP_PlanningMethodLine.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MRP_PlanningMethodLine.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MRP_PlanningMethodLine.UpdatedBy) as UpdatedByR," +
      "        MRP_PlanningMethodLine.AD_Client_ID, " +
      "(CASE WHEN MRP_PlanningMethodLine.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MRP_PlanningMethodLine.MRP_Planningmethodline_ID, " +
      "MRP_PlanningMethodLine.AD_Org_ID, " +
      "(CASE WHEN MRP_PlanningMethodLine.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MRP_PlanningMethodLine.MRP_Planningmethod_ID, " +
      "(CASE WHEN MRP_PlanningMethodLine.MRP_Planningmethod_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS MRP_Planningmethod_IDR, " +
      "MRP_PlanningMethodLine.Line, " +
      "COALESCE(MRP_PlanningMethodLine.IsActive, 'N') AS IsActive, " +
      "MRP_PlanningMethodLine.Inouttrxtype, " +
      "(CASE WHEN MRP_PlanningMethodLine.Inouttrxtype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS InouttrxtypeR, " +
      "MRP_PlanningMethodLine.Weighting, " +
      "MRP_PlanningMethodLine.Daysfrom, " +
      "MRP_PlanningMethodLine.Daysto, " +
      "        ? AS LANGUAGE " +
      "        FROM MRP_PlanningMethodLine left join (select AD_Client_ID, Name from AD_Client) table1 on (MRP_PlanningMethodLine.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MRP_PlanningMethodLine.AD_Org_ID = table2.AD_Org_ID) left join (select MRP_Planningmethod_ID, Name from MRP_Planningmethod) table3 on (MRP_PlanningMethodLine.MRP_Planningmethod_ID = table3.MRP_Planningmethod_ID) left join ad_ref_list_v list1 on (MRP_PlanningMethodLine.Inouttrxtype = list1.value and list1.ad_reference_id = '800098' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((mrpPlanningmethodId==null || mrpPlanningmethodId.equals(""))?"":"  AND MRP_PlanningMethodLine.MRP_Planningmethod_ID = ?  ");
    strSql = strSql + 
      "        AND MRP_PlanningMethodLine.MRP_Planningmethodline_ID = ? " +
      "        AND MRP_PlanningMethodLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MRP_PlanningMethodLine.AD_Org_ID IN (";
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
      if (mrpPlanningmethodId != null && !(mrpPlanningmethodId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlanningmethodId);
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
        Lines800253Data objectLines800253Data = new Lines800253Data();
        objectLines800253Data.created = UtilSql.getValue(result, "created");
        objectLines800253Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectLines800253Data.updated = UtilSql.getValue(result, "updated");
        objectLines800253Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectLines800253Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectLines800253Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectLines800253Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectLines800253Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectLines800253Data.mrpPlanningmethodlineId = UtilSql.getValue(result, "mrp_planningmethodline_id");
        objectLines800253Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectLines800253Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectLines800253Data.mrpPlanningmethodId = UtilSql.getValue(result, "mrp_planningmethod_id");
        objectLines800253Data.mrpPlanningmethodIdr = UtilSql.getValue(result, "mrp_planningmethod_idr");
        objectLines800253Data.line = UtilSql.getValue(result, "line");
        objectLines800253Data.isactive = UtilSql.getValue(result, "isactive");
        objectLines800253Data.inouttrxtype = UtilSql.getValue(result, "inouttrxtype");
        objectLines800253Data.inouttrxtyper = UtilSql.getValue(result, "inouttrxtyper");
        objectLines800253Data.weighting = UtilSql.getValue(result, "weighting");
        objectLines800253Data.daysfrom = UtilSql.getValue(result, "daysfrom");
        objectLines800253Data.daysto = UtilSql.getValue(result, "daysto");
        objectLines800253Data.language = UtilSql.getValue(result, "language");
        objectLines800253Data.adUserClient = "";
        objectLines800253Data.adOrgClient = "";
        objectLines800253Data.createdby = "";
        objectLines800253Data.trBgcolor = "";
        objectLines800253Data.totalCount = "";
        objectLines800253Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLines800253Data);
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
    Lines800253Data objectLines800253Data[] = new Lines800253Data[vector.size()];
    vector.copyInto(objectLines800253Data);
    return(objectLines800253Data);
  }

/**
Create a registry
 */
  public static Lines800253Data[] set(String mrpPlanningmethodId, String mrpPlanningmethodlineId, String adClientId, String createdby, String createdbyr, String daysto, String inouttrxtype, String updatedby, String updatedbyr, String adOrgId, String weighting, String line, String isactive, String daysfrom)    throws ServletException {
    Lines800253Data objectLines800253Data[] = new Lines800253Data[1];
    objectLines800253Data[0] = new Lines800253Data();
    objectLines800253Data[0].created = "";
    objectLines800253Data[0].createdbyr = createdbyr;
    objectLines800253Data[0].updated = "";
    objectLines800253Data[0].updatedTimeStamp = "";
    objectLines800253Data[0].updatedby = updatedby;
    objectLines800253Data[0].updatedbyr = updatedbyr;
    objectLines800253Data[0].adClientId = adClientId;
    objectLines800253Data[0].adClientIdr = "";
    objectLines800253Data[0].mrpPlanningmethodlineId = mrpPlanningmethodlineId;
    objectLines800253Data[0].adOrgId = adOrgId;
    objectLines800253Data[0].adOrgIdr = "";
    objectLines800253Data[0].mrpPlanningmethodId = mrpPlanningmethodId;
    objectLines800253Data[0].mrpPlanningmethodIdr = "";
    objectLines800253Data[0].line = line;
    objectLines800253Data[0].isactive = isactive;
    objectLines800253Data[0].inouttrxtype = inouttrxtype;
    objectLines800253Data[0].inouttrxtyper = "";
    objectLines800253Data[0].weighting = weighting;
    objectLines800253Data[0].daysfrom = daysfrom;
    objectLines800253Data[0].daysto = daysto;
    objectLines800253Data[0].language = "";
    return objectLines800253Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef803574_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef803576_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef803578(ConnectionProvider connectionProvider, String MRP_Planningmethodline_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(LINE),0)+10 AS DefaultValue FROM MRP_PLANNINGMETHODLINE WHERE MRP_Planningmethodline.MRP_Planningmethodline_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MRP_Planningmethodline_ID);

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
      "        SELECT MRP_PlanningMethodLine.MRP_Planningmethod_ID AS NAME" +
      "        FROM MRP_PlanningMethodLine" +
      "        WHERE MRP_PlanningMethodLine.MRP_Planningmethodline_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String mrpPlanningmethodId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MRP_PlanningMethod left join (select MRP_Planningmethod_ID, Name from MRP_Planningmethod) table1 on (MRP_PlanningMethod.MRP_Planningmethod_ID = table1.MRP_Planningmethod_ID) WHERE MRP_PlanningMethod.MRP_Planningmethod_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlanningmethodId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String mrpPlanningmethodId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MRP_PlanningMethod left join (select MRP_Planningmethod_ID, Name from MRP_Planningmethod) table1 on (MRP_PlanningMethod.MRP_Planningmethod_ID = table1.MRP_Planningmethod_ID) WHERE MRP_PlanningMethod.MRP_Planningmethod_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlanningmethodId);

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
      "        UPDATE MRP_PlanningMethodLine" +
      "        SET AD_Client_ID = (?) , MRP_Planningmethodline_ID = (?) , AD_Org_ID = (?) , MRP_Planningmethod_ID = (?) , Line = TO_NUMBER(?) , IsActive = (?) , Inouttrxtype = (?) , Weighting = TO_NUMBER(?) , Daysfrom = TO_NUMBER(?) , Daysto = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE MRP_PlanningMethodLine.MRP_Planningmethodline_ID = ? " +
      "                 AND MRP_PlanningMethodLine.MRP_Planningmethod_ID = ? " +
      "        AND MRP_PlanningMethodLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MRP_PlanningMethodLine.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlanningmethodlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlanningmethodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, inouttrxtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weighting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, daysfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, daysto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlanningmethodlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlanningmethodId);
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
      "        INSERT INTO MRP_PlanningMethodLine " +
      "        (AD_Client_ID, MRP_Planningmethodline_ID, AD_Org_ID, MRP_Planningmethod_ID, Line, IsActive, Inouttrxtype, Weighting, Daysfrom, Daysto, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlanningmethodlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlanningmethodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, inouttrxtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weighting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, daysfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, daysto);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String mrpPlanningmethodId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MRP_PlanningMethodLine" +
      "        WHERE MRP_PlanningMethodLine.MRP_Planningmethodline_ID = ? " +
      "                 AND MRP_PlanningMethodLine.MRP_Planningmethod_ID = ? " +
      "        AND MRP_PlanningMethodLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MRP_PlanningMethodLine.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlanningmethodId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String mrpPlanningmethodId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MRP_PlanningMethodLine" +
      "        WHERE MRP_PlanningMethodLine.MRP_Planningmethodline_ID = ? " +
      "                 AND MRP_PlanningMethodLine.MRP_Planningmethod_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlanningmethodId);

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
      "          FROM MRP_PlanningMethodLine" +
      "         WHERE MRP_PlanningMethodLine.MRP_Planningmethodline_ID = ? ";

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
      "          FROM MRP_PlanningMethodLine" +
      "         WHERE MRP_PlanningMethodLine.MRP_Planningmethodline_ID = ? ";

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
