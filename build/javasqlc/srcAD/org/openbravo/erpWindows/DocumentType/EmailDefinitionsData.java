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
class EmailDefinitionsData implements FieldProvider {
static Logger log4j = Logger.getLogger(EmailDefinitionsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String cPocEmaildefinitionId;
  public String adOrgId;
  public String adOrgIdr;
  public String cPocDoctypeTemplateId;
  public String cPocDoctypeTemplateIdr;
  public String isactive;
  public String isdefault;
  public String subject;
  public String body;
  public String adLanguage;
  public String adLanguager;
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
    else if (fieldName.equalsIgnoreCase("c_poc_emaildefinition_id") || fieldName.equals("cPocEmaildefinitionId"))
      return cPocEmaildefinitionId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_poc_doctype_template_id") || fieldName.equals("cPocDoctypeTemplateId"))
      return cPocDoctypeTemplateId;
    else if (fieldName.equalsIgnoreCase("c_poc_doctype_template_idr") || fieldName.equals("cPocDoctypeTemplateIdr"))
      return cPocDoctypeTemplateIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("subject"))
      return subject;
    else if (fieldName.equalsIgnoreCase("body"))
      return body;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
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
  public static EmailDefinitionsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cPocDoctypeTemplateId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cPocDoctypeTemplateId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static EmailDefinitionsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cPocDoctypeTemplateId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_POC_EMAILDEFINITION.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_POC_EMAILDEFINITION.CreatedBy) as CreatedByR, " +
      "        to_char(C_POC_EMAILDEFINITION.Updated, ?) as updated, " +
      "        to_char(C_POC_EMAILDEFINITION.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_POC_EMAILDEFINITION.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_POC_EMAILDEFINITION.UpdatedBy) as UpdatedByR," +
      "        C_POC_EMAILDEFINITION.AD_Client_ID, " +
      "(CASE WHEN C_POC_EMAILDEFINITION.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_POC_EMAILDEFINITION.C_Poc_Emaildefinition_ID, " +
      "C_POC_EMAILDEFINITION.AD_Org_ID, " +
      "(CASE WHEN C_POC_EMAILDEFINITION.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_POC_EMAILDEFINITION.C_Poc_Doctype_Template_ID, " +
      "(CASE WHEN C_POC_EMAILDEFINITION.C_Poc_Doctype_Template_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Poc_Doctype_Template_IDR, " +
      "COALESCE(C_POC_EMAILDEFINITION.Isactive, 'N') AS Isactive, " +
      "COALESCE(C_POC_EMAILDEFINITION.Isdefault, 'N') AS Isdefault, " +
      "C_POC_EMAILDEFINITION.Subject, " +
      "C_POC_EMAILDEFINITION.Body, " +
      "C_POC_EMAILDEFINITION.AD_Language, " +
      "(CASE WHEN C_POC_EMAILDEFINITION.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "        ? AS LANGUAGE " +
      "        FROM C_POC_EMAILDEFINITION left join (select AD_Client_ID, Name from AD_Client) table1 on (C_POC_EMAILDEFINITION.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_POC_EMAILDEFINITION.AD_Org_ID = table2.AD_Org_ID) left join (select C_Poc_Doctype_Template_ID, Name from C_Poc_Doctype_Template) table3 on (C_POC_EMAILDEFINITION.C_Poc_Doctype_Template_ID = table3.C_Poc_Doctype_Template_ID) left join (select AD_Language, Name from AD_Language) table4 on (C_POC_EMAILDEFINITION.AD_Language =  table4.AD_Language)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cPocDoctypeTemplateId==null || cPocDoctypeTemplateId.equals(""))?"":"  AND C_POC_EMAILDEFINITION.C_Poc_Doctype_Template_ID = ?  ");
    strSql = strSql + 
      "        AND C_POC_EMAILDEFINITION.C_Poc_Emaildefinition_ID = ? " +
      "        AND C_POC_EMAILDEFINITION.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_POC_EMAILDEFINITION.AD_Org_ID IN (";
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
      if (cPocDoctypeTemplateId != null && !(cPocDoctypeTemplateId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);
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
        EmailDefinitionsData objectEmailDefinitionsData = new EmailDefinitionsData();
        objectEmailDefinitionsData.created = UtilSql.getValue(result, "created");
        objectEmailDefinitionsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectEmailDefinitionsData.updated = UtilSql.getValue(result, "updated");
        objectEmailDefinitionsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectEmailDefinitionsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectEmailDefinitionsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectEmailDefinitionsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectEmailDefinitionsData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectEmailDefinitionsData.cPocEmaildefinitionId = UtilSql.getValue(result, "c_poc_emaildefinition_id");
        objectEmailDefinitionsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectEmailDefinitionsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectEmailDefinitionsData.cPocDoctypeTemplateId = UtilSql.getValue(result, "c_poc_doctype_template_id");
        objectEmailDefinitionsData.cPocDoctypeTemplateIdr = UtilSql.getValue(result, "c_poc_doctype_template_idr");
        objectEmailDefinitionsData.isactive = UtilSql.getValue(result, "isactive");
        objectEmailDefinitionsData.isdefault = UtilSql.getValue(result, "isdefault");
        objectEmailDefinitionsData.subject = UtilSql.getValue(result, "subject");
        objectEmailDefinitionsData.body = UtilSql.getValue(result, "body");
        objectEmailDefinitionsData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectEmailDefinitionsData.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectEmailDefinitionsData.language = UtilSql.getValue(result, "language");
        objectEmailDefinitionsData.adUserClient = "";
        objectEmailDefinitionsData.adOrgClient = "";
        objectEmailDefinitionsData.createdby = "";
        objectEmailDefinitionsData.trBgcolor = "";
        objectEmailDefinitionsData.totalCount = "";
        objectEmailDefinitionsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEmailDefinitionsData);
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
    EmailDefinitionsData objectEmailDefinitionsData[] = new EmailDefinitionsData[vector.size()];
    vector.copyInto(objectEmailDefinitionsData);
    return(objectEmailDefinitionsData);
  }

/**
Create a registry
 */
  public static EmailDefinitionsData[] set(String cPocDoctypeTemplateId, String updatedby, String updatedbyr, String isactive, String subject, String createdby, String createdbyr, String body, String adLanguage, String cPocEmaildefinitionId, String adClientId, String adOrgId, String isdefault)    throws ServletException {
    EmailDefinitionsData objectEmailDefinitionsData[] = new EmailDefinitionsData[1];
    objectEmailDefinitionsData[0] = new EmailDefinitionsData();
    objectEmailDefinitionsData[0].created = "";
    objectEmailDefinitionsData[0].createdbyr = createdbyr;
    objectEmailDefinitionsData[0].updated = "";
    objectEmailDefinitionsData[0].updatedTimeStamp = "";
    objectEmailDefinitionsData[0].updatedby = updatedby;
    objectEmailDefinitionsData[0].updatedbyr = updatedbyr;
    objectEmailDefinitionsData[0].adClientId = adClientId;
    objectEmailDefinitionsData[0].adClientIdr = "";
    objectEmailDefinitionsData[0].cPocEmaildefinitionId = cPocEmaildefinitionId;
    objectEmailDefinitionsData[0].adOrgId = adOrgId;
    objectEmailDefinitionsData[0].adOrgIdr = "";
    objectEmailDefinitionsData[0].cPocDoctypeTemplateId = cPocDoctypeTemplateId;
    objectEmailDefinitionsData[0].cPocDoctypeTemplateIdr = "";
    objectEmailDefinitionsData[0].isactive = isactive;
    objectEmailDefinitionsData[0].isdefault = isdefault;
    objectEmailDefinitionsData[0].subject = subject;
    objectEmailDefinitionsData[0].body = body;
    objectEmailDefinitionsData[0].adLanguage = adLanguage;
    objectEmailDefinitionsData[0].adLanguager = "";
    objectEmailDefinitionsData[0].language = "";
    return objectEmailDefinitionsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1000500063_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef1000500061_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT C_POC_EMAILDEFINITION.C_Poc_Doctype_Template_ID AS NAME" +
      "        FROM C_POC_EMAILDEFINITION" +
      "        WHERE C_POC_EMAILDEFINITION.C_Poc_Emaildefinition_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cPocDoctypeTemplateId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_POC_DOCTYPE_TEMPLATE left join (select C_Poc_Doctype_Template_ID, Name from C_Poc_Doctype_Template) table1 on (C_POC_DOCTYPE_TEMPLATE.C_Poc_Doctype_Template_ID = table1.C_Poc_Doctype_Template_ID) WHERE C_POC_DOCTYPE_TEMPLATE.C_Poc_Doctype_Template_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cPocDoctypeTemplateId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_POC_DOCTYPE_TEMPLATE left join (select C_Poc_Doctype_Template_ID, Name from C_Poc_Doctype_Template) table1 on (C_POC_DOCTYPE_TEMPLATE.C_Poc_Doctype_Template_ID = table1.C_Poc_Doctype_Template_ID) WHERE C_POC_DOCTYPE_TEMPLATE.C_Poc_Doctype_Template_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);

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
      "        UPDATE C_POC_EMAILDEFINITION" +
      "        SET AD_Client_ID = (?) , C_Poc_Emaildefinition_ID = (?) , AD_Org_ID = (?) , C_Poc_Doctype_Template_ID = (?) , Isactive = (?) , Isdefault = (?) , Subject = (?) , Body = (?) , AD_Language = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_POC_EMAILDEFINITION.C_Poc_Emaildefinition_ID = ? " +
      "                 AND C_POC_EMAILDEFINITION.C_Poc_Doctype_Template_ID = ? " +
      "        AND C_POC_EMAILDEFINITION.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_POC_EMAILDEFINITION.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocEmaildefinitionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, body);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocEmaildefinitionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);
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
      "        INSERT INTO C_POC_EMAILDEFINITION " +
      "        (AD_Client_ID, C_Poc_Emaildefinition_ID, AD_Org_ID, C_Poc_Doctype_Template_ID, Isactive, Isdefault, Subject, Body, AD_Language, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocEmaildefinitionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, body);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cPocDoctypeTemplateId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_POC_EMAILDEFINITION" +
      "        WHERE C_POC_EMAILDEFINITION.C_Poc_Emaildefinition_ID = ? " +
      "                 AND C_POC_EMAILDEFINITION.C_Poc_Doctype_Template_ID = ? " +
      "        AND C_POC_EMAILDEFINITION.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_POC_EMAILDEFINITION.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cPocDoctypeTemplateId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_POC_EMAILDEFINITION" +
      "        WHERE C_POC_EMAILDEFINITION.C_Poc_Emaildefinition_ID = ? " +
      "                 AND C_POC_EMAILDEFINITION.C_Poc_Doctype_Template_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);

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
      "          FROM C_POC_EMAILDEFINITION" +
      "         WHERE C_POC_EMAILDEFINITION.C_Poc_Emaildefinition_ID = ? ";

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
      "          FROM C_POC_EMAILDEFINITION" +
      "         WHERE C_POC_EMAILDEFINITION.C_Poc_Emaildefinition_ID = ? ";

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
