//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.DocumentType;

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
class ReportTemplatesData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportTemplatesData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cPocDoctypeTemplateId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String name;
  public String isactive;
  public String isdefault;
  public String templatelocation;
  public String templatefilename;
  public String reportfilename;
  public String cDoctypeId;
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
    else if (fieldName.equalsIgnoreCase("c_poc_doctype_template_id") || fieldName.equals("cPocDoctypeTemplateId"))
      return cPocDoctypeTemplateId;
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
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("templatelocation"))
      return templatelocation;
    else if (fieldName.equalsIgnoreCase("templatefilename"))
      return templatefilename;
    else if (fieldName.equalsIgnoreCase("reportfilename"))
      return reportfilename;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
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
  public static ReportTemplatesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String C_DocType_ID, String cDoctypeId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, C_DocType_ID, cDoctypeId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ReportTemplatesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String C_DocType_ID, String cDoctypeId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_POC_DOCTYPE_TEMPLATE.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_POC_DOCTYPE_TEMPLATE.CreatedBy) as CreatedByR, " +
      "        to_char(C_POC_DOCTYPE_TEMPLATE.Updated, ?) as updated, " +
      "        to_char(C_POC_DOCTYPE_TEMPLATE.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_POC_DOCTYPE_TEMPLATE.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_POC_DOCTYPE_TEMPLATE.UpdatedBy) as UpdatedByR," +
      "        C_POC_DOCTYPE_TEMPLATE.C_Poc_Doctype_Template_ID, " +
      "C_POC_DOCTYPE_TEMPLATE.AD_Client_ID, " +
      "(CASE WHEN C_POC_DOCTYPE_TEMPLATE.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_POC_DOCTYPE_TEMPLATE.AD_Org_ID, " +
      "(CASE WHEN C_POC_DOCTYPE_TEMPLATE.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_POC_DOCTYPE_TEMPLATE.Name, " +
      "COALESCE(C_POC_DOCTYPE_TEMPLATE.Isactive, 'N') AS Isactive, " +
      "COALESCE(C_POC_DOCTYPE_TEMPLATE.Isdefault, 'N') AS Isdefault, " +
      "C_POC_DOCTYPE_TEMPLATE.Templatelocation, " +
      "C_POC_DOCTYPE_TEMPLATE.Templatefilename, " +
      "C_POC_DOCTYPE_TEMPLATE.Reportfilename, " +
      "C_POC_DOCTYPE_TEMPLATE.C_Doctype_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_POC_DOCTYPE_TEMPLATE left join (select AD_Client_ID, Name from AD_Client) table1 on (C_POC_DOCTYPE_TEMPLATE.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_POC_DOCTYPE_TEMPLATE.AD_Org_ID = table2.AD_Org_ID)" +
      "        WHERE 2=2 " +
      " AND C_POC_DOCTYPE_TEMPLATE.C_DocType_ID = ?" +
      "        AND 1=1 ";
    strSql = strSql + ((cDoctypeId==null || cDoctypeId.equals(""))?"":"  AND C_POC_DOCTYPE_TEMPLATE.C_Doctype_ID = ?  ");
    strSql = strSql + 
      "        AND C_POC_DOCTYPE_TEMPLATE.C_Poc_Doctype_Template_ID = ? " +
      "        AND C_POC_DOCTYPE_TEMPLATE.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_POC_DOCTYPE_TEMPLATE.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_DocType_ID);
      if (cDoctypeId != null && !(cDoctypeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
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
        ReportTemplatesData objectReportTemplatesData = new ReportTemplatesData();
        objectReportTemplatesData.created = UtilSql.getValue(result, "created");
        objectReportTemplatesData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectReportTemplatesData.updated = UtilSql.getValue(result, "updated");
        objectReportTemplatesData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectReportTemplatesData.updatedby = UtilSql.getValue(result, "updatedby");
        objectReportTemplatesData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectReportTemplatesData.cPocDoctypeTemplateId = UtilSql.getValue(result, "c_poc_doctype_template_id");
        objectReportTemplatesData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectReportTemplatesData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectReportTemplatesData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportTemplatesData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectReportTemplatesData.name = UtilSql.getValue(result, "name");
        objectReportTemplatesData.isactive = UtilSql.getValue(result, "isactive");
        objectReportTemplatesData.isdefault = UtilSql.getValue(result, "isdefault");
        objectReportTemplatesData.templatelocation = UtilSql.getValue(result, "templatelocation");
        objectReportTemplatesData.templatefilename = UtilSql.getValue(result, "templatefilename");
        objectReportTemplatesData.reportfilename = UtilSql.getValue(result, "reportfilename");
        objectReportTemplatesData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectReportTemplatesData.language = UtilSql.getValue(result, "language");
        objectReportTemplatesData.adUserClient = "";
        objectReportTemplatesData.adOrgClient = "";
        objectReportTemplatesData.createdby = "";
        objectReportTemplatesData.trBgcolor = "";
        objectReportTemplatesData.totalCount = "";
        objectReportTemplatesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportTemplatesData);
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
    ReportTemplatesData objectReportTemplatesData[] = new ReportTemplatesData[vector.size()];
    vector.copyInto(objectReportTemplatesData);
    return(objectReportTemplatesData);
  }

/**
Create a registry
 */
  public static ReportTemplatesData[] set(String cDoctypeId, String createdby, String createdbyr, String adOrgId, String updatedby, String updatedbyr, String templatelocation, String name, String isdefault, String adClientId, String templatefilename, String reportfilename, String isactive, String cPocDoctypeTemplateId)    throws ServletException {
    ReportTemplatesData objectReportTemplatesData[] = new ReportTemplatesData[1];
    objectReportTemplatesData[0] = new ReportTemplatesData();
    objectReportTemplatesData[0].created = "";
    objectReportTemplatesData[0].createdbyr = createdbyr;
    objectReportTemplatesData[0].updated = "";
    objectReportTemplatesData[0].updatedTimeStamp = "";
    objectReportTemplatesData[0].updatedby = updatedby;
    objectReportTemplatesData[0].updatedbyr = updatedbyr;
    objectReportTemplatesData[0].cPocDoctypeTemplateId = cPocDoctypeTemplateId;
    objectReportTemplatesData[0].adClientId = adClientId;
    objectReportTemplatesData[0].adClientIdr = "";
    objectReportTemplatesData[0].adOrgId = adOrgId;
    objectReportTemplatesData[0].adOrgIdr = "";
    objectReportTemplatesData[0].name = name;
    objectReportTemplatesData[0].isactive = isactive;
    objectReportTemplatesData[0].isdefault = isdefault;
    objectReportTemplatesData[0].templatelocation = templatelocation;
    objectReportTemplatesData[0].templatefilename = templatefilename;
    objectReportTemplatesData[0].reportfilename = reportfilename;
    objectReportTemplatesData[0].cDoctypeId = cDoctypeId;
    objectReportTemplatesData[0].language = "";
    return objectReportTemplatesData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1000500021_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef1000500023_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT C_POC_DOCTYPE_TEMPLATE.C_Doctype_ID AS NAME" +
      "        FROM C_POC_DOCTYPE_TEMPLATE" +
      "        WHERE C_POC_DOCTYPE_TEMPLATE.C_Poc_Doctype_Template_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String cDoctypeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_DocType left join (select C_Doctype_ID, Name from C_Doctype) table1 on (C_DocType.C_Doctype_ID = table1.C_Doctype_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL1 on (table1.C_DocType_ID = tableTRL1.C_DocType_ID and tableTRL1.AD_Language = ?)  WHERE C_DocType.C_Doctype_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String cDoctypeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_DocType left join (select C_Doctype_ID, Name from C_Doctype) table1 on (C_DocType.C_Doctype_ID = table1.C_Doctype_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL1 on (table1.C_DocType_ID = tableTRL1.C_DocType_ID and tableTRL1.AD_Language = ?)  WHERE C_DocType.C_Doctype_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);

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
      "        UPDATE C_POC_DOCTYPE_TEMPLATE" +
      "        SET C_Poc_Doctype_Template_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Name = (?) , Isactive = (?) , Isdefault = (?) , Templatelocation = (?) , Templatefilename = (?) , Reportfilename = (?) , C_Doctype_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_POC_DOCTYPE_TEMPLATE.C_Poc_Doctype_Template_ID = ? " +
      "                 AND C_POC_DOCTYPE_TEMPLATE.C_Doctype_ID = ? " +
      "        AND C_POC_DOCTYPE_TEMPLATE.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_POC_DOCTYPE_TEMPLATE.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, templatelocation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, templatefilename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reportfilename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
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
      "        INSERT INTO C_POC_DOCTYPE_TEMPLATE " +
      "        (C_Poc_Doctype_Template_ID, AD_Client_ID, AD_Org_ID, Name, Isactive, Isdefault, Templatelocation, Templatefilename, Reportfilename, C_Doctype_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, templatelocation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, templatefilename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reportfilename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cDoctypeId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_POC_DOCTYPE_TEMPLATE" +
      "        WHERE C_POC_DOCTYPE_TEMPLATE.C_Poc_Doctype_Template_ID = ? " +
      "                 AND C_POC_DOCTYPE_TEMPLATE.C_Doctype_ID = ? " +
      "        AND C_POC_DOCTYPE_TEMPLATE.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_POC_DOCTYPE_TEMPLATE.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cDoctypeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_POC_DOCTYPE_TEMPLATE" +
      "        WHERE C_POC_DOCTYPE_TEMPLATE.C_Poc_Doctype_Template_ID = ? " +
      "                 AND C_POC_DOCTYPE_TEMPLATE.C_Doctype_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);

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
      "          FROM C_POC_DOCTYPE_TEMPLATE" +
      "         WHERE C_POC_DOCTYPE_TEMPLATE.C_Poc_Doctype_Template_ID = ? ";

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
      "          FROM C_POC_DOCTYPE_TEMPLATE" +
      "         WHERE C_POC_DOCTYPE_TEMPLATE.C_Poc_Doctype_Template_ID = ? ";

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
