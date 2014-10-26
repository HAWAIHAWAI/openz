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
class DocumentDefinitionData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocumentDefinitionData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String name;
  public String orgfiltered;
  public String description;
  public String cDoctypeReversedId;
  public String printname;
  public String documentnote;
  public String isactive;
  public String isdefault;
  public String glCategoryId;
  public String glCategoryIdr;
  public String issotrx;
  public String docbasetype;
  public String docbasetyper;
  public String adTableId;
  public String adTableIdr;
  public String docsubtypeso;
  public String docsubtypesor;
  public String cDoctypeinvoiceId;
  public String cDoctypeinvoiceIdr;
  public String cDoctypeshipmentId;
  public String cDoctypeshipmentIdr;
  public String isdocnocontrolled;
  public String docnosequenceId;
  public String docnosequenceIdr;
  public String cDoctypeId;
  public String documentcopies;
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
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("orgfiltered"))
      return orgfiltered;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_doctype_reversed_id") || fieldName.equals("cDoctypeReversedId"))
      return cDoctypeReversedId;
    else if (fieldName.equalsIgnoreCase("printname"))
      return printname;
    else if (fieldName.equalsIgnoreCase("documentnote"))
      return documentnote;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("gl_category_id") || fieldName.equals("glCategoryId"))
      return glCategoryId;
    else if (fieldName.equalsIgnoreCase("gl_category_idr") || fieldName.equals("glCategoryIdr"))
      return glCategoryIdr;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("docbasetype"))
      return docbasetype;
    else if (fieldName.equalsIgnoreCase("docbasetyper"))
      return docbasetyper;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("ad_table_idr") || fieldName.equals("adTableIdr"))
      return adTableIdr;
    else if (fieldName.equalsIgnoreCase("docsubtypeso"))
      return docsubtypeso;
    else if (fieldName.equalsIgnoreCase("docsubtypesor"))
      return docsubtypesor;
    else if (fieldName.equalsIgnoreCase("c_doctypeinvoice_id") || fieldName.equals("cDoctypeinvoiceId"))
      return cDoctypeinvoiceId;
    else if (fieldName.equalsIgnoreCase("c_doctypeinvoice_idr") || fieldName.equals("cDoctypeinvoiceIdr"))
      return cDoctypeinvoiceIdr;
    else if (fieldName.equalsIgnoreCase("c_doctypeshipment_id") || fieldName.equals("cDoctypeshipmentId"))
      return cDoctypeshipmentId;
    else if (fieldName.equalsIgnoreCase("c_doctypeshipment_idr") || fieldName.equals("cDoctypeshipmentIdr"))
      return cDoctypeshipmentIdr;
    else if (fieldName.equalsIgnoreCase("isdocnocontrolled"))
      return isdocnocontrolled;
    else if (fieldName.equalsIgnoreCase("docnosequence_id") || fieldName.equals("docnosequenceId"))
      return docnosequenceId;
    else if (fieldName.equalsIgnoreCase("docnosequence_idr") || fieldName.equals("docnosequenceIdr"))
      return docnosequenceIdr;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("documentcopies"))
      return documentcopies;
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
  public static DocumentDefinitionData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static DocumentDefinitionData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_DocType.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_DocType.CreatedBy) as CreatedByR, " +
      "        to_char(C_DocType.Updated, ?) as updated, " +
      "        to_char(C_DocType.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_DocType.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_DocType.UpdatedBy) as UpdatedByR," +
      "        C_DocType.AD_Client_ID, " +
      "(CASE WHEN C_DocType.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_DocType.AD_Org_ID, " +
      "(CASE WHEN C_DocType.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_DocType.Name, " +
      "COALESCE(C_DocType.Orgfiltered, 'N') AS Orgfiltered, " +
      "C_DocType.Description, " +
      "C_DocType.C_Doctype_Reversed_ID, " +
      "C_DocType.PrintName, " +
      "C_DocType.DocumentNote, " +
      "COALESCE(C_DocType.IsActive, 'N') AS IsActive, " +
      "COALESCE(C_DocType.IsDefault, 'N') AS IsDefault, " +
      "C_DocType.GL_Category_ID, " +
      "(CASE WHEN C_DocType.GL_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS GL_Category_IDR, " +
      "COALESCE(C_DocType.IsSOTrx, 'N') AS IsSOTrx, " +
      "C_DocType.DocBaseType, " +
      "(CASE WHEN C_DocType.DocBaseType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DocBaseTypeR, " +
      "C_DocType.AD_Table_ID, " +
      "(CASE WHEN C_DocType.AD_Table_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.TableName), ''))),'') ) END) AS AD_Table_IDR, " +
      "C_DocType.DocSubTypeSO, " +
      "(CASE WHEN C_DocType.DocSubTypeSO IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS DocSubTypeSOR, " +
      "C_DocType.C_DocTypeInvoice_ID, " +
      "(CASE WHEN C_DocType.C_DocTypeInvoice_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS C_DocTypeInvoice_IDR, " +
      "C_DocType.C_DocTypeShipment_ID, " +
      "(CASE WHEN C_DocType.C_DocTypeShipment_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS C_DocTypeShipment_IDR, " +
      "COALESCE(C_DocType.IsDocNoControlled, 'N') AS IsDocNoControlled, " +
      "C_DocType.DocNoSequence_ID, " +
      "(CASE WHEN C_DocType.DocNoSequence_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS DocNoSequence_IDR, " +
      "C_DocType.C_DocType_ID, " +
      "C_DocType.DocumentCopies, " +
      "        ? AS LANGUAGE " +
      "        FROM C_DocType left join (select AD_Client_ID, Name from AD_Client) table1 on (C_DocType.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_DocType.AD_Org_ID = table2.AD_Org_ID) left join (select GL_Category_ID, Name from GL_Category) table3 on (C_DocType.GL_Category_ID = table3.GL_Category_ID) left join ad_ref_list_v list1 on (C_DocType.DocBaseType = list1.value and list1.ad_reference_id = '183' and list1.ad_language = ?)  left join (select AD_Table_ID, TableName from AD_Table) table4 on (C_DocType.AD_Table_ID = table4.AD_Table_ID) left join ad_ref_list_v list2 on (C_DocType.DocSubTypeSO = list2.value and list2.ad_reference_id = '148' and list2.ad_language = ?)  left join (select C_DocType_ID, Name from C_DocType) table5 on (C_DocType.C_DocTypeInvoice_ID =  table5.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL5 on (table5.C_DocType_ID = tableTRL5.C_DocType_ID and tableTRL5.AD_Language = ?)  left join (select C_DocType_ID, Name from C_DocType) table6 on (C_DocType.C_DocTypeShipment_ID =  table6.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL6 on (table6.C_DocType_ID = tableTRL6.C_DocType_ID and tableTRL6.AD_Language = ?)  left join (select AD_Sequence_ID, Name from AD_Sequence) table7 on (C_DocType.DocNoSequence_ID =  table7.AD_Sequence_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_DocType.C_DocType_ID = ? " +
      "        AND C_DocType.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_DocType.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
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
        DocumentDefinitionData objectDocumentDefinitionData = new DocumentDefinitionData();
        objectDocumentDefinitionData.created = UtilSql.getValue(result, "created");
        objectDocumentDefinitionData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectDocumentDefinitionData.updated = UtilSql.getValue(result, "updated");
        objectDocumentDefinitionData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectDocumentDefinitionData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDocumentDefinitionData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectDocumentDefinitionData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocumentDefinitionData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectDocumentDefinitionData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocumentDefinitionData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectDocumentDefinitionData.name = UtilSql.getValue(result, "name");
        objectDocumentDefinitionData.orgfiltered = UtilSql.getValue(result, "orgfiltered");
        objectDocumentDefinitionData.description = UtilSql.getValue(result, "description");
        objectDocumentDefinitionData.cDoctypeReversedId = UtilSql.getValue(result, "c_doctype_reversed_id");
        objectDocumentDefinitionData.printname = UtilSql.getValue(result, "printname");
        objectDocumentDefinitionData.documentnote = UtilSql.getValue(result, "documentnote");
        objectDocumentDefinitionData.isactive = UtilSql.getValue(result, "isactive");
        objectDocumentDefinitionData.isdefault = UtilSql.getValue(result, "isdefault");
        objectDocumentDefinitionData.glCategoryId = UtilSql.getValue(result, "gl_category_id");
        objectDocumentDefinitionData.glCategoryIdr = UtilSql.getValue(result, "gl_category_idr");
        objectDocumentDefinitionData.issotrx = UtilSql.getValue(result, "issotrx");
        objectDocumentDefinitionData.docbasetype = UtilSql.getValue(result, "docbasetype");
        objectDocumentDefinitionData.docbasetyper = UtilSql.getValue(result, "docbasetyper");
        objectDocumentDefinitionData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectDocumentDefinitionData.adTableIdr = UtilSql.getValue(result, "ad_table_idr");
        objectDocumentDefinitionData.docsubtypeso = UtilSql.getValue(result, "docsubtypeso");
        objectDocumentDefinitionData.docsubtypesor = UtilSql.getValue(result, "docsubtypesor");
        objectDocumentDefinitionData.cDoctypeinvoiceId = UtilSql.getValue(result, "c_doctypeinvoice_id");
        objectDocumentDefinitionData.cDoctypeinvoiceIdr = UtilSql.getValue(result, "c_doctypeinvoice_idr");
        objectDocumentDefinitionData.cDoctypeshipmentId = UtilSql.getValue(result, "c_doctypeshipment_id");
        objectDocumentDefinitionData.cDoctypeshipmentIdr = UtilSql.getValue(result, "c_doctypeshipment_idr");
        objectDocumentDefinitionData.isdocnocontrolled = UtilSql.getValue(result, "isdocnocontrolled");
        objectDocumentDefinitionData.docnosequenceId = UtilSql.getValue(result, "docnosequence_id");
        objectDocumentDefinitionData.docnosequenceIdr = UtilSql.getValue(result, "docnosequence_idr");
        objectDocumentDefinitionData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectDocumentDefinitionData.documentcopies = UtilSql.getValue(result, "documentcopies");
        objectDocumentDefinitionData.language = UtilSql.getValue(result, "language");
        objectDocumentDefinitionData.adUserClient = "";
        objectDocumentDefinitionData.adOrgClient = "";
        objectDocumentDefinitionData.createdby = "";
        objectDocumentDefinitionData.trBgcolor = "";
        objectDocumentDefinitionData.totalCount = "";
        objectDocumentDefinitionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocumentDefinitionData);
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
    DocumentDefinitionData objectDocumentDefinitionData[] = new DocumentDefinitionData[vector.size()];
    vector.copyInto(objectDocumentDefinitionData);
    return(objectDocumentDefinitionData);
  }

/**
Create a registry
 */
  public static DocumentDefinitionData[] set(String cDoctypeId, String glCategoryId, String adTableId, String isdocnocontrolled, String isactive, String createdby, String createdbyr, String description, String documentnote, String docnosequenceId, String adOrgId, String docbasetype, String docsubtypeso, String documentcopies, String cDoctypeshipmentId, String name, String printname, String orgfiltered, String cDoctypeinvoiceId, String adClientId, String isdefault, String updatedby, String updatedbyr, String issotrx, String cDoctypeReversedId)    throws ServletException {
    DocumentDefinitionData objectDocumentDefinitionData[] = new DocumentDefinitionData[1];
    objectDocumentDefinitionData[0] = new DocumentDefinitionData();
    objectDocumentDefinitionData[0].created = "";
    objectDocumentDefinitionData[0].createdbyr = createdbyr;
    objectDocumentDefinitionData[0].updated = "";
    objectDocumentDefinitionData[0].updatedTimeStamp = "";
    objectDocumentDefinitionData[0].updatedby = updatedby;
    objectDocumentDefinitionData[0].updatedbyr = updatedbyr;
    objectDocumentDefinitionData[0].adClientId = adClientId;
    objectDocumentDefinitionData[0].adClientIdr = "";
    objectDocumentDefinitionData[0].adOrgId = adOrgId;
    objectDocumentDefinitionData[0].adOrgIdr = "";
    objectDocumentDefinitionData[0].name = name;
    objectDocumentDefinitionData[0].orgfiltered = orgfiltered;
    objectDocumentDefinitionData[0].description = description;
    objectDocumentDefinitionData[0].cDoctypeReversedId = cDoctypeReversedId;
    objectDocumentDefinitionData[0].printname = printname;
    objectDocumentDefinitionData[0].documentnote = documentnote;
    objectDocumentDefinitionData[0].isactive = isactive;
    objectDocumentDefinitionData[0].isdefault = isdefault;
    objectDocumentDefinitionData[0].glCategoryId = glCategoryId;
    objectDocumentDefinitionData[0].glCategoryIdr = "";
    objectDocumentDefinitionData[0].issotrx = issotrx;
    objectDocumentDefinitionData[0].docbasetype = docbasetype;
    objectDocumentDefinitionData[0].docbasetyper = "";
    objectDocumentDefinitionData[0].adTableId = adTableId;
    objectDocumentDefinitionData[0].adTableIdr = "";
    objectDocumentDefinitionData[0].docsubtypeso = docsubtypeso;
    objectDocumentDefinitionData[0].docsubtypesor = "";
    objectDocumentDefinitionData[0].cDoctypeinvoiceId = cDoctypeinvoiceId;
    objectDocumentDefinitionData[0].cDoctypeinvoiceIdr = "";
    objectDocumentDefinitionData[0].cDoctypeshipmentId = cDoctypeshipmentId;
    objectDocumentDefinitionData[0].cDoctypeshipmentIdr = "";
    objectDocumentDefinitionData[0].isdocnocontrolled = isdocnocontrolled;
    objectDocumentDefinitionData[0].docnosequenceId = docnosequenceId;
    objectDocumentDefinitionData[0].docnosequenceIdr = "";
    objectDocumentDefinitionData[0].cDoctypeId = cDoctypeId;
    objectDocumentDefinitionData[0].documentcopies = documentcopies;
    objectDocumentDefinitionData[0].language = "";
    return objectDocumentDefinitionData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1506_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef1508_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_DocType" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , Name = (?) , Orgfiltered = (?) , Description = (?) , C_Doctype_Reversed_ID = (?) , PrintName = (?) , DocumentNote = (?) , IsActive = (?) , IsDefault = (?) , GL_Category_ID = (?) , IsSOTrx = (?) , DocBaseType = (?) , AD_Table_ID = (?) , DocSubTypeSO = (?) , C_DocTypeInvoice_ID = (?) , C_DocTypeShipment_ID = (?) , IsDocNoControlled = (?) , DocNoSequence_ID = (?) , C_DocType_ID = (?) , DocumentCopies = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE C_DocType.C_DocType_ID = ? " +
      "        AND C_DocType.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_DocType.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgfiltered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeReversedId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docsubtypeso);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeinvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeshipmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdocnocontrolled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docnosequenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentcopies);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
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
      "        INSERT INTO C_DocType " +
      "        (AD_Client_ID, AD_Org_ID, Name, Orgfiltered, Description, C_Doctype_Reversed_ID, PrintName, DocumentNote, IsActive, IsDefault, GL_Category_ID, IsSOTrx, DocBaseType, AD_Table_ID, DocSubTypeSO, C_DocTypeInvoice_ID, C_DocTypeShipment_ID, IsDocNoControlled, DocNoSequence_ID, C_DocType_ID, DocumentCopies, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgfiltered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeReversedId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docsubtypeso);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeinvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeshipmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdocnocontrolled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docnosequenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentcopies);
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
      "        DELETE FROM C_DocType" +
      "        WHERE C_DocType.C_DocType_ID = ? " +
      "        AND C_DocType.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_DocType.AD_Org_ID IN (";
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
      "        DELETE FROM C_DocType" +
      "        WHERE C_DocType.C_DocType_ID = ? ";

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
      "          FROM C_DocType" +
      "         WHERE C_DocType.C_DocType_ID = ? ";

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
      "          FROM C_DocType" +
      "         WHERE C_DocType.C_DocType_ID = ? ";

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
