//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.finance.GLBatch;

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
class GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data implements FieldProvider {
static Logger log4j = Logger.getLogger(GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String zsfiManualacctId;
  public String adOrgId;
  public String adOrgIdr;
  public String documentno;
  public String isactive;
  public String acctdate;
  public String description;
  public String glstatus;
  public String glstatusr;
  public String aAssetId;
  public String aAssetIdr;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjectphaseId;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String post;
  public String processing;
  public String unpost;
  public String cancel;
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
    else if (fieldName.equalsIgnoreCase("zsfi_manualacct_id") || fieldName.equals("zsfiManualacctId"))
      return zsfiManualacctId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("acctdate"))
      return acctdate;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("glstatus"))
      return glstatus;
    else if (fieldName.equalsIgnoreCase("glstatusr"))
      return glstatusr;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("post"))
      return post;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("unpost"))
      return unpost;
    else if (fieldName.equalsIgnoreCase("cancel"))
      return cancel;
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
  public static GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zsfi_manualacct.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zsfi_manualacct.CreatedBy) as CreatedByR, " +
      "        to_char(zsfi_manualacct.Updated, ?) as updated, " +
      "        to_char(zsfi_manualacct.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zsfi_manualacct.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zsfi_manualacct.UpdatedBy) as UpdatedByR," +
      "        zsfi_manualacct.AD_Client_ID, " +
      "(CASE WHEN zsfi_manualacct.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "zsfi_manualacct.Zsfi_Manualacct_ID, " +
      "zsfi_manualacct.AD_Org_ID, " +
      "(CASE WHEN zsfi_manualacct.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zsfi_manualacct.DocumentNo, " +
      "COALESCE(zsfi_manualacct.Isactive, 'N') AS Isactive, " +
      "zsfi_manualacct.Acctdate, " +
      "zsfi_manualacct.Description, " +
      "zsfi_manualacct.Glstatus, " +
      "(CASE WHEN zsfi_manualacct.Glstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS GlstatusR, " +
      "zsfi_manualacct.A_Asset_ID, " +
      "(CASE WHEN zsfi_manualacct.A_Asset_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "zsfi_manualacct.C_Project_ID, " +
      "(CASE WHEN zsfi_manualacct.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "zsfi_manualacct.C_Projectphase_ID, " +
      "zsfi_manualacct.C_Projecttask_ID, " +
      "(CASE WHEN zsfi_manualacct.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "zsfi_manualacct.Post, " +
      "COALESCE(zsfi_manualacct.Processing, 'N') AS Processing, " +
      "zsfi_manualacct.Unpost, " +
      "zsfi_manualacct.Cancel, " +
      "        ? AS LANGUAGE " +
      "        FROM zsfi_manualacct left join (select AD_Client_ID, Name from AD_Client) table1 on (zsfi_manualacct.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (zsfi_manualacct.AD_Org_ID = table2.AD_Org_ID) left join ad_ref_list_v list1 on (zsfi_manualacct.Glstatus = list1.value and list1.ad_reference_id = '44E25BEF5DE54641AD01F956A1F1C096' and list1.ad_language = ?)  left join (select A_Asset_ID, Name from A_Asset) table3 on (zsfi_manualacct.A_Asset_ID = table3.A_Asset_ID) left join (select C_Project_ID, Value, Name from C_Project) table4 on (zsfi_manualacct.C_Project_ID = table4.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table5 on (zsfi_manualacct.C_Projecttask_ID = table5.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table6 on (table5.C_Project_ID = table6.C_Project_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND zsfi_manualacct.Zsfi_Manualacct_ID = ? " +
      "        AND zsfi_manualacct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zsfi_manualacct.AD_Org_ID IN (";
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
        GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data = new GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data();
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.created = UtilSql.getValue(result, "created");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.updated = UtilSql.getValue(result, "updated");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.zsfiManualacctId = UtilSql.getValue(result, "zsfi_manualacct_id");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.documentno = UtilSql.getValue(result, "documentno");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.isactive = UtilSql.getValue(result, "isactive");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.acctdate = UtilSql.getDateValue(result, "acctdate", "dd-MM-yyyy");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.description = UtilSql.getValue(result, "description");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.glstatus = UtilSql.getValue(result, "glstatus");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.glstatusr = UtilSql.getValue(result, "glstatusr");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.post = UtilSql.getValue(result, "post");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.processing = UtilSql.getValue(result, "processing");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.unpost = UtilSql.getValue(result, "unpost");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.cancel = UtilSql.getValue(result, "cancel");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.language = UtilSql.getValue(result, "language");
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.adUserClient = "";
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.adOrgClient = "";
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.createdby = "";
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.trBgcolor = "";
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.totalCount = "";
        objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data);
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
    GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[] = new GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[vector.size()];
    vector.copyInto(objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data);
    return(objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data);
  }

/**
Create a registry
 */
  public static GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[] set(String unpost, String cancel, String isactive, String description, String post, String cProjectphaseId, String cProjecttaskId, String glstatus, String documentno, String zsfiManualacctId, String aAssetId, String cProjectId, String adOrgId, String acctdate, String adClientId, String createdby, String createdbyr, String processing, String updatedby, String updatedbyr)    throws ServletException {
    GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[] = new GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[1];
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0] = new GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data();
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].created = "";
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].createdbyr = createdbyr;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].updated = "";
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].updatedTimeStamp = "";
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].updatedby = updatedby;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].updatedbyr = updatedbyr;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].adClientId = adClientId;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].adClientIdr = "";
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].zsfiManualacctId = zsfiManualacctId;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].adOrgId = adOrgId;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].adOrgIdr = "";
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].documentno = documentno;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].isactive = isactive;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].acctdate = acctdate;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].description = description;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].glstatus = glstatus;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].glstatusr = "";
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].aAssetId = aAssetId;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].aAssetIdr = "";
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].cProjectId = cProjectId;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].cProjectIdr = "";
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].cProjectphaseId = cProjectphaseId;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].cProjecttaskId = cProjecttaskId;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].cProjecttaskIdr = "";
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].post = post;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].processing = processing;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].unpost = unpost;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].cancel = cancel;
    objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0].language = "";
    return objectGLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef9F1A49AD744741069EBE46B7B5376B30_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef6929408566E04C0BB0AA1809D9BC13D9_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE zsfi_manualacct" +
      "        SET AD_Client_ID = (?) , Zsfi_Manualacct_ID = (?) , AD_Org_ID = (?) , DocumentNo = (?) , Isactive = (?) , Acctdate = TO_DATE(?) , Description = (?) , Glstatus = (?) , A_Asset_ID = (?) , C_Project_ID = (?) , C_Projectphase_ID = (?) , C_Projecttask_ID = (?) , Post = (?) , Processing = (?) , Unpost = (?) , Cancel = (?) , updated = now(), updatedby = ? " +
      "        WHERE zsfi_manualacct.Zsfi_Manualacct_ID = ? " +
      "        AND zsfi_manualacct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zsfi_manualacct.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiManualacctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, post);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unpost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiManualacctId);
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
      "        INSERT INTO zsfi_manualacct " +
      "        (AD_Client_ID, Zsfi_Manualacct_ID, AD_Org_ID, DocumentNo, Isactive, Acctdate, Description, Glstatus, A_Asset_ID, C_Project_ID, C_Projectphase_ID, C_Projecttask_ID, Post, Processing, Unpost, Cancel, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiManualacctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, post);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unpost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancel);
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
      "        DELETE FROM zsfi_manualacct" +
      "        WHERE zsfi_manualacct.Zsfi_Manualacct_ID = ? " +
      "        AND zsfi_manualacct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zsfi_manualacct.AD_Org_ID IN (";
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
      "        DELETE FROM zsfi_manualacct" +
      "        WHERE zsfi_manualacct.Zsfi_Manualacct_ID = ? ";

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
      "          FROM zsfi_manualacct" +
      "         WHERE zsfi_manualacct.Zsfi_Manualacct_ID = ? ";

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
      "          FROM zsfi_manualacct" +
      "         WHERE zsfi_manualacct.Zsfi_Manualacct_ID = ? ";

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
