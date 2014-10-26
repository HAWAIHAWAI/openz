//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.AccountingSchema;

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
class DocumentsData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocumentsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cAcctschemaTableDoctypeId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String cAcctschemaTableId;
  public String cAcctschemaTableIdr;
  public String docbasetype;
  public String docbasetyper;
  public String allownegative;
  public String adCreatefactTemplateId;
  public String adCreatefactTemplateIdr;
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
    else if (fieldName.equalsIgnoreCase("c_acctschema_table_doctype_id") || fieldName.equals("cAcctschemaTableDoctypeId"))
      return cAcctschemaTableDoctypeId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_acctschema_table_id") || fieldName.equals("cAcctschemaTableId"))
      return cAcctschemaTableId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_table_idr") || fieldName.equals("cAcctschemaTableIdr"))
      return cAcctschemaTableIdr;
    else if (fieldName.equalsIgnoreCase("docbasetype"))
      return docbasetype;
    else if (fieldName.equalsIgnoreCase("docbasetyper"))
      return docbasetyper;
    else if (fieldName.equalsIgnoreCase("allownegative"))
      return allownegative;
    else if (fieldName.equalsIgnoreCase("ad_createfact_template_id") || fieldName.equals("adCreatefactTemplateId"))
      return adCreatefactTemplateId;
    else if (fieldName.equalsIgnoreCase("ad_createfact_template_idr") || fieldName.equals("adCreatefactTemplateIdr"))
      return adCreatefactTemplateIdr;
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
  public static DocumentsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cAcctschemaTableId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cAcctschemaTableId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static DocumentsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cAcctschemaTableId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_AcctSchema_Table_DocType.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_AcctSchema_Table_DocType.CreatedBy) as CreatedByR, " +
      "        to_char(C_AcctSchema_Table_DocType.Updated, ?) as updated, " +
      "        to_char(C_AcctSchema_Table_DocType.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_AcctSchema_Table_DocType.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_AcctSchema_Table_DocType.UpdatedBy) as UpdatedByR," +
      "        C_AcctSchema_Table_DocType.C_Acctschema_Table_Doctype_ID, " +
      "C_AcctSchema_Table_DocType.AD_Client_ID, " +
      "(CASE WHEN C_AcctSchema_Table_DocType.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_AcctSchema_Table_DocType.AD_Org_ID, " +
      "(CASE WHEN C_AcctSchema_Table_DocType.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(C_AcctSchema_Table_DocType.Isactive, 'N') AS Isactive, " +
      "C_AcctSchema_Table_DocType.C_Acctschema_Table_ID, " +
      "(CASE WHEN C_AcctSchema_Table_DocType.C_Acctschema_Table_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Acctschema_Table_IDR, " +
      "C_AcctSchema_Table_DocType.Docbasetype, " +
      "(CASE WHEN C_AcctSchema_Table_DocType.Docbasetype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DocbasetypeR, " +
      "COALESCE(C_AcctSchema_Table_DocType.AllowNegative, 'N') AS AllowNegative, " +
      "C_AcctSchema_Table_DocType.AD_Createfact_Template_ID, " +
      "(CASE WHEN C_AcctSchema_Table_DocType.AD_Createfact_Template_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS AD_Createfact_Template_IDR, " +
      "        ? AS LANGUAGE " +
      "        FROM C_AcctSchema_Table_DocType left join (select AD_Client_ID, Name from AD_Client) table1 on (C_AcctSchema_Table_DocType.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_AcctSchema_Table_DocType.AD_Org_ID = table2.AD_Org_ID) left join (select C_Acctschema_Table_ID, C_AcctSchema_ID, AD_Table_ID from C_Acctschema_Table) table3 on (C_AcctSchema_Table_DocType.C_Acctschema_Table_ID = table3.C_Acctschema_Table_ID) left join (select C_AcctSchema_ID, Name from C_AcctSchema) table4 on (table3.C_AcctSchema_ID = table4.C_AcctSchema_ID) left join (select AD_Table_ID, Name from AD_Table) table5 on (table3.AD_Table_ID =  table5.AD_Table_ID) left join ad_ref_list_v list1 on (C_AcctSchema_Table_DocType.Docbasetype = list1.value and list1.ad_reference_id = '183' and list1.ad_language = ?)  left join (select AD_Createfact_Template_ID, Name from AD_Createfact_Template) table6 on (C_AcctSchema_Table_DocType.AD_Createfact_Template_ID = table6.AD_Createfact_Template_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cAcctschemaTableId==null || cAcctschemaTableId.equals(""))?"":"  AND C_AcctSchema_Table_DocType.C_Acctschema_Table_ID = ?  ");
    strSql = strSql + 
      "        AND C_AcctSchema_Table_DocType.C_Acctschema_Table_Doctype_ID = ? " +
      "        AND C_AcctSchema_Table_DocType.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_AcctSchema_Table_DocType.AD_Org_ID IN (";
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
      if (cAcctschemaTableId != null && !(cAcctschemaTableId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaTableId);
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
        DocumentsData objectDocumentsData = new DocumentsData();
        objectDocumentsData.created = UtilSql.getValue(result, "created");
        objectDocumentsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectDocumentsData.updated = UtilSql.getValue(result, "updated");
        objectDocumentsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectDocumentsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDocumentsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectDocumentsData.cAcctschemaTableDoctypeId = UtilSql.getValue(result, "c_acctschema_table_doctype_id");
        objectDocumentsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocumentsData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectDocumentsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocumentsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectDocumentsData.isactive = UtilSql.getValue(result, "isactive");
        objectDocumentsData.cAcctschemaTableId = UtilSql.getValue(result, "c_acctschema_table_id");
        objectDocumentsData.cAcctschemaTableIdr = UtilSql.getValue(result, "c_acctschema_table_idr");
        objectDocumentsData.docbasetype = UtilSql.getValue(result, "docbasetype");
        objectDocumentsData.docbasetyper = UtilSql.getValue(result, "docbasetyper");
        objectDocumentsData.allownegative = UtilSql.getValue(result, "allownegative");
        objectDocumentsData.adCreatefactTemplateId = UtilSql.getValue(result, "ad_createfact_template_id");
        objectDocumentsData.adCreatefactTemplateIdr = UtilSql.getValue(result, "ad_createfact_template_idr");
        objectDocumentsData.language = UtilSql.getValue(result, "language");
        objectDocumentsData.adUserClient = "";
        objectDocumentsData.adOrgClient = "";
        objectDocumentsData.createdby = "";
        objectDocumentsData.trBgcolor = "";
        objectDocumentsData.totalCount = "";
        objectDocumentsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocumentsData);
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
    DocumentsData objectDocumentsData[] = new DocumentsData[vector.size()];
    vector.copyInto(objectDocumentsData);
    return(objectDocumentsData);
  }

/**
Create a registry
 */
  public static DocumentsData[] set(String cAcctschemaTableId, String adClientId, String docbasetype, String adOrgId, String createdby, String cAcctschemaTableDoctypeId, String allownegative, String isactive, String updatedby, String adCreatefactTemplateId)    throws ServletException {
    DocumentsData objectDocumentsData[] = new DocumentsData[1];
    objectDocumentsData[0] = new DocumentsData();
    objectDocumentsData[0].created = "";
    objectDocumentsData[0].createdbyr = "";
    objectDocumentsData[0].updated = "";
    objectDocumentsData[0].updatedTimeStamp = "";
    objectDocumentsData[0].updatedby = updatedby;
    objectDocumentsData[0].updatedbyr = "";
    objectDocumentsData[0].cAcctschemaTableDoctypeId = cAcctschemaTableDoctypeId;
    objectDocumentsData[0].adClientId = adClientId;
    objectDocumentsData[0].adClientIdr = "";
    objectDocumentsData[0].adOrgId = adOrgId;
    objectDocumentsData[0].adOrgIdr = "";
    objectDocumentsData[0].isactive = isactive;
    objectDocumentsData[0].cAcctschemaTableId = cAcctschemaTableId;
    objectDocumentsData[0].cAcctschemaTableIdr = "";
    objectDocumentsData[0].docbasetype = docbasetype;
    objectDocumentsData[0].docbasetyper = "";
    objectDocumentsData[0].allownegative = allownegative;
    objectDocumentsData[0].adCreatefactTemplateId = adCreatefactTemplateId;
    objectDocumentsData[0].adCreatefactTemplateIdr = "";
    objectDocumentsData[0].language = "";
    return objectDocumentsData;
  }

/**
Select for auxiliar field
 */
  public static String selectAuxFB4C3FF138DD4B2AB582E7BFBEF5CA7F(ConnectionProvider connectionProvider, String C_Acctschema_Table_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select ad_table_id from c_acctschema_table where c_acctschema_table_id=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Acctschema_Table_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_table_id");
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
      "        SELECT C_AcctSchema_Table_DocType.C_Acctschema_Table_ID AS NAME" +
      "        FROM C_AcctSchema_Table_DocType" +
      "        WHERE C_AcctSchema_Table_DocType.C_Acctschema_Table_Doctype_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cAcctschemaTableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))) AS NAME FROM C_AcctSchema_Table left join (select C_Acctschema_Table_ID, C_AcctSchema_ID, AD_Table_ID from C_Acctschema_Table) table1 on (C_AcctSchema_Table.C_Acctschema_Table_ID = table1.C_Acctschema_Table_ID) left join (select C_AcctSchema_ID, Name from C_AcctSchema) table2 on (table1.C_AcctSchema_ID = table2.C_AcctSchema_ID) left join (select AD_Table_ID, Name from AD_Table) table3 on (table1.AD_Table_ID =  table3.AD_Table_ID) WHERE C_AcctSchema_Table.C_Acctschema_Table_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaTableId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cAcctschemaTableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))) AS NAME FROM C_AcctSchema_Table left join (select C_Acctschema_Table_ID, C_AcctSchema_ID, AD_Table_ID from C_Acctschema_Table) table1 on (C_AcctSchema_Table.C_Acctschema_Table_ID = table1.C_Acctschema_Table_ID) left join (select C_AcctSchema_ID, Name from C_AcctSchema) table2 on (table1.C_AcctSchema_ID = table2.C_AcctSchema_ID) left join (select AD_Table_ID, Name from AD_Table) table3 on (table1.AD_Table_ID =  table3.AD_Table_ID) WHERE C_AcctSchema_Table.C_Acctschema_Table_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaTableId);

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
      "        UPDATE C_AcctSchema_Table_DocType" +
      "        SET C_Acctschema_Table_Doctype_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , C_Acctschema_Table_ID = (?) , Docbasetype = (?) , AllowNegative = (?) , AD_Createfact_Template_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_AcctSchema_Table_DocType.C_Acctschema_Table_Doctype_ID = ? " +
      "                 AND C_AcctSchema_Table_DocType.C_Acctschema_Table_ID = ? " +
      "        AND C_AcctSchema_Table_DocType.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_AcctSchema_Table_DocType.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaTableDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allownegative);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCreatefactTemplateId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaTableDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaTableId);
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
      "        INSERT INTO C_AcctSchema_Table_DocType " +
      "        (C_Acctschema_Table_Doctype_ID, AD_Client_ID, AD_Org_ID, Isactive, C_Acctschema_Table_ID, Docbasetype, AllowNegative, AD_Createfact_Template_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaTableDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allownegative);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCreatefactTemplateId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cAcctschemaTableId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_AcctSchema_Table_DocType" +
      "        WHERE C_AcctSchema_Table_DocType.C_Acctschema_Table_Doctype_ID = ? " +
      "                 AND C_AcctSchema_Table_DocType.C_Acctschema_Table_ID = ? " +
      "        AND C_AcctSchema_Table_DocType.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_AcctSchema_Table_DocType.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaTableId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cAcctschemaTableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_AcctSchema_Table_DocType" +
      "        WHERE C_AcctSchema_Table_DocType.C_Acctschema_Table_Doctype_ID = ? " +
      "                 AND C_AcctSchema_Table_DocType.C_Acctschema_Table_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaTableId);

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
      "          FROM C_AcctSchema_Table_DocType" +
      "         WHERE C_AcctSchema_Table_DocType.C_Acctschema_Table_Doctype_ID = ? ";

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
      "          FROM C_AcctSchema_Table_DocType" +
      "         WHERE C_AcctSchema_Table_DocType.C_Acctschema_Table_Doctype_ID = ? ";

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
