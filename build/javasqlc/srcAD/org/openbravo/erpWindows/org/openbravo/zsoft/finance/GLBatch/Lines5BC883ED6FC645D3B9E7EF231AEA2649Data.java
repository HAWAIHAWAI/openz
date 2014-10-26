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
class Lines5BC883ED6FC645D3B9E7EF231AEA2649Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Lines5BC883ED6FC645D3B9E7EF231AEA2649Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zsfiMacctlineId;
  public String zsfiManualacctId;
  public String zsfiManualacctIdr;
  public String line;
  public String acctdate;
  public String adClientId;
  public String acctcr;
  public String acctcrr;
  public String adOrgId;
  public String isactive;
  public String acctdr;
  public String acctdrr;
  public String amt;
  public String isdr2cr;
  public String isgross;
  public String cTaxId;
  public String cTaxIdr;
  public String description;
  public String aAssetId;
  public String aAssetIdr;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String glstatus;
  public String glstatusr;
  public String cancel;
  public String processing;
  public String cProjectphaseId;
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
    else if (fieldName.equalsIgnoreCase("zsfi_macctline_id") || fieldName.equals("zsfiMacctlineId"))
      return zsfiMacctlineId;
    else if (fieldName.equalsIgnoreCase("zsfi_manualacct_id") || fieldName.equals("zsfiManualacctId"))
      return zsfiManualacctId;
    else if (fieldName.equalsIgnoreCase("zsfi_manualacct_idr") || fieldName.equals("zsfiManualacctIdr"))
      return zsfiManualacctIdr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("acctdate"))
      return acctdate;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("acctcr"))
      return acctcr;
    else if (fieldName.equalsIgnoreCase("acctcrr"))
      return acctcrr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("acctdr"))
      return acctdr;
    else if (fieldName.equalsIgnoreCase("acctdrr"))
      return acctdrr;
    else if (fieldName.equalsIgnoreCase("amt"))
      return amt;
    else if (fieldName.equalsIgnoreCase("isdr2cr"))
      return isdr2cr;
    else if (fieldName.equalsIgnoreCase("isgross"))
      return isgross;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("c_tax_idr") || fieldName.equals("cTaxIdr"))
      return cTaxIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("glstatus"))
      return glstatus;
    else if (fieldName.equalsIgnoreCase("glstatusr"))
      return glstatusr;
    else if (fieldName.equalsIgnoreCase("cancel"))
      return cancel;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
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
  public static Lines5BC883ED6FC645D3B9E7EF231AEA2649Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zsfiManualacctId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zsfiManualacctId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Lines5BC883ED6FC645D3B9E7EF231AEA2649Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zsfiManualacctId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zsfi_macctline.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zsfi_macctline.CreatedBy) as CreatedByR, " +
      "        to_char(zsfi_macctline.Updated, ?) as updated, " +
      "        to_char(zsfi_macctline.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zsfi_macctline.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zsfi_macctline.UpdatedBy) as UpdatedByR," +
      "        zsfi_macctline.Zsfi_Macctline_ID, " +
      "zsfi_macctline.Zsfi_Manualacct_ID, " +
      "(CASE WHEN zsfi_macctline.Zsfi_Manualacct_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Description), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), ''))),'') ) END) AS Zsfi_Manualacct_IDR, " +
      "zsfi_macctline.Line, " +
      "zsfi_macctline.Acctdate, " +
      "zsfi_macctline.AD_Client_ID, " +
      "zsfi_macctline.Acctcr, " +
      "(CASE WHEN zsfi_macctline.Acctcr IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS AcctcrR, " +
      "zsfi_macctline.AD_Org_ID, " +
      "COALESCE(zsfi_macctline.Isactive, 'N') AS Isactive, " +
      "zsfi_macctline.Acctdr, " +
      "(CASE WHEN zsfi_macctline.Acctdr IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS AcctdrR, " +
      "zsfi_macctline.Amt, " +
      "COALESCE(zsfi_macctline.Isdr2cr, 'N') AS Isdr2cr, " +
      "COALESCE(zsfi_macctline.Isgross, 'N') AS Isgross, " +
      "zsfi_macctline.C_Tax_ID, " +
      "(CASE WHEN zsfi_macctline.C_Tax_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_Tax_IDR, " +
      "zsfi_macctline.Description, " +
      "zsfi_macctline.A_Asset_ID, " +
      "(CASE WHEN zsfi_macctline.A_Asset_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "zsfi_macctline.C_Project_ID, " +
      "(CASE WHEN zsfi_macctline.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "zsfi_macctline.C_Projecttask_ID, " +
      "(CASE WHEN zsfi_macctline.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "zsfi_macctline.Glstatus, " +
      "(CASE WHEN zsfi_macctline.Glstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS GlstatusR, " +
      "zsfi_macctline.Cancel, " +
      "COALESCE(zsfi_macctline.Processing, 'N') AS Processing, " +
      "zsfi_macctline.C_Projectphase_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zsfi_macctline left join (select Zsfi_Manualacct_ID, Description, DocumentNo from Zsfi_Manualacct) table1 on (zsfi_macctline.Zsfi_Manualacct_ID = table1.Zsfi_Manualacct_ID) left join (select C_ElementValue_ID, value, Name from C_ElementValue) table2 on (zsfi_macctline.Acctcr =  table2.C_ElementValue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL2 on (table2.C_ElementValue_ID = tableTRL2.C_ElementValue_ID and tableTRL2.AD_Language = ?)  left join (select C_ElementValue_ID, value, Name from C_ElementValue) table3 on (zsfi_macctline.Acctdr =  table3.C_ElementValue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL3 on (table3.C_ElementValue_ID = tableTRL3.C_ElementValue_ID and tableTRL3.AD_Language = ?)  left join (select C_Tax_ID, Name from C_Tax) table4 on (zsfi_macctline.C_Tax_ID = table4.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL4 on (table4.C_Tax_ID = tableTRL4.C_Tax_ID and tableTRL4.AD_Language = ?)  left join (select A_Asset_ID, Name from A_Asset) table5 on (zsfi_macctline.A_Asset_ID = table5.A_Asset_ID) left join (select C_Project_ID, Value, Name from C_Project) table6 on (zsfi_macctline.C_Project_ID = table6.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table7 on (zsfi_macctline.C_Projecttask_ID = table7.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table8 on (table7.C_Project_ID = table8.C_Project_ID) left join ad_ref_list_v list1 on (zsfi_macctline.Glstatus = list1.value and list1.ad_reference_id = '44E25BEF5DE54641AD01F956A1F1C096' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zsfiManualacctId==null || zsfiManualacctId.equals(""))?"":"  AND zsfi_macctline.Zsfi_Manualacct_ID = ?  ");
    strSql = strSql + 
      "        AND zsfi_macctline.Zsfi_Macctline_ID = ? " +
      "        AND zsfi_macctline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zsfi_macctline.AD_Org_ID IN (";
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
      if (zsfiManualacctId != null && !(zsfiManualacctId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiManualacctId);
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
        Lines5BC883ED6FC645D3B9E7EF231AEA2649Data objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data = new Lines5BC883ED6FC645D3B9E7EF231AEA2649Data();
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.created = UtilSql.getValue(result, "created");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.updated = UtilSql.getValue(result, "updated");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.zsfiMacctlineId = UtilSql.getValue(result, "zsfi_macctline_id");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.zsfiManualacctId = UtilSql.getValue(result, "zsfi_manualacct_id");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.zsfiManualacctIdr = UtilSql.getValue(result, "zsfi_manualacct_idr");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.line = UtilSql.getValue(result, "line");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.acctdate = UtilSql.getDateValue(result, "acctdate", "dd-MM-yyyy");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.acctcr = UtilSql.getValue(result, "acctcr");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.acctcrr = UtilSql.getValue(result, "acctcrr");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.isactive = UtilSql.getValue(result, "isactive");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.acctdr = UtilSql.getValue(result, "acctdr");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.acctdrr = UtilSql.getValue(result, "acctdrr");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.amt = UtilSql.getValue(result, "amt");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.isdr2cr = UtilSql.getValue(result, "isdr2cr");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.isgross = UtilSql.getValue(result, "isgross");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.cTaxIdr = UtilSql.getValue(result, "c_tax_idr");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.description = UtilSql.getValue(result, "description");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.glstatus = UtilSql.getValue(result, "glstatus");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.glstatusr = UtilSql.getValue(result, "glstatusr");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.cancel = UtilSql.getValue(result, "cancel");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.processing = UtilSql.getValue(result, "processing");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.language = UtilSql.getValue(result, "language");
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.adUserClient = "";
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.adOrgClient = "";
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.createdby = "";
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.trBgcolor = "";
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.totalCount = "";
        objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data);
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
    Lines5BC883ED6FC645D3B9E7EF231AEA2649Data objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[] = new Lines5BC883ED6FC645D3B9E7EF231AEA2649Data[vector.size()];
    vector.copyInto(objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data);
    return(objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data);
  }

/**
Create a registry
 */
  public static Lines5BC883ED6FC645D3B9E7EF231AEA2649Data[] set(String zsfiManualacctId, String isdr2cr, String description, String isactive, String createdby, String createdbyr, String isgross, String amt, String acctcr, String zsfiMacctlineId, String cancel, String cProjectId, String cProjectphaseId, String cTaxId, String updatedby, String updatedbyr, String aAssetId, String line, String acctdr, String adClientId, String processing, String adOrgId, String acctdate, String glstatus, String cProjecttaskId)    throws ServletException {
    Lines5BC883ED6FC645D3B9E7EF231AEA2649Data objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[] = new Lines5BC883ED6FC645D3B9E7EF231AEA2649Data[1];
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0] = new Lines5BC883ED6FC645D3B9E7EF231AEA2649Data();
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].created = "";
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].createdbyr = createdbyr;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].updated = "";
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].updatedTimeStamp = "";
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].updatedby = updatedby;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].updatedbyr = updatedbyr;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].zsfiMacctlineId = zsfiMacctlineId;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].zsfiManualacctId = zsfiManualacctId;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].zsfiManualacctIdr = "";
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].line = line;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].acctdate = acctdate;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].adClientId = adClientId;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].acctcr = acctcr;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].acctcrr = "";
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].adOrgId = adOrgId;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].isactive = isactive;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].acctdr = acctdr;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].acctdrr = "";
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].amt = amt;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].isdr2cr = isdr2cr;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].isgross = isgross;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].cTaxId = cTaxId;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].cTaxIdr = "";
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].description = description;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].aAssetId = aAssetId;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].aAssetIdr = "";
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].cProjectId = cProjectId;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].cProjectIdr = "";
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].cProjecttaskId = cProjecttaskId;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].cProjecttaskIdr = "";
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].glstatus = glstatus;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].glstatusr = "";
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].cancel = cancel;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].processing = processing;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].cProjectphaseId = cProjectphaseId;
    objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data[0].language = "";
    return objectLines5BC883ED6FC645D3B9E7EF231AEA2649Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef9AF5C23B79C94B179EBFB567E84553B6_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefA7918FD8CA9040A1919DD3A17E9B128F(ConnectionProvider connectionProvider, String Zsfi_Manualacct_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_project_id AS DefaultValue FROM zsfi_manualacct WHERE Zsfi_Manualacct_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Zsfi_Manualacct_ID);

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
  public static String selectDef582E7F472BE04A27BC7AD1D4711C284E(ConnectionProvider connectionProvider, String Zsfi_Manualacct_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_projectphase_id AS DefaultValue FROM zsfi_manualacct WHERE Zsfi_Manualacct_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Zsfi_Manualacct_ID);

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
  public static String selectDef9205C068E7444FE891B5A7A86C4384F8_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef6CA1EA8689424B18A0447B41F8DDF14E(ConnectionProvider connectionProvider, String Zsfi_Manualacct_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT a_asset_id AS DefaultValue FROM zsfi_manualacct WHERE Zsfi_Manualacct_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Zsfi_Manualacct_ID);

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
  public static String selectDef37ED3A70E58949918FFC67ECE58F10BD(ConnectionProvider connectionProvider, String Zsfi_Manualacct_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(LINE),0)+10 AS DefaultValue FROM ZSFI_MACCTLINE WHERE Zsfi_Manualacct_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Zsfi_Manualacct_ID);

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
  public static String selectDefEDED11C4C803480B9E751FA98AA97AA9(ConnectionProvider connectionProvider, String Zsfi_Manualacct_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_projecttask_id AS DefaultValue FROM zsfi_manualacct WHERE Zsfi_Manualacct_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Zsfi_Manualacct_ID);

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
      "        SELECT zsfi_macctline.Zsfi_Manualacct_ID AS NAME" +
      "        FROM zsfi_macctline" +
      "        WHERE zsfi_macctline.Zsfi_Macctline_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String zsfiManualacctId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Description), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), ''))) AS NAME FROM zsfi_manualacct left join (select Zsfi_Manualacct_ID, Description, DocumentNo from Zsfi_Manualacct) table1 on (zsfi_manualacct.Zsfi_Manualacct_ID = table1.Zsfi_Manualacct_ID) WHERE zsfi_manualacct.Zsfi_Manualacct_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiManualacctId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zsfiManualacctId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Description), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), ''))) AS NAME FROM zsfi_manualacct left join (select Zsfi_Manualacct_ID, Description, DocumentNo from Zsfi_Manualacct) table1 on (zsfi_manualacct.Zsfi_Manualacct_ID = table1.Zsfi_Manualacct_ID) WHERE zsfi_manualacct.Zsfi_Manualacct_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiManualacctId);

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
      "        UPDATE zsfi_macctline" +
      "        SET Zsfi_Macctline_ID = (?) , Zsfi_Manualacct_ID = (?) , Line = TO_NUMBER(?) , Acctdate = TO_DATE(?) , AD_Client_ID = (?) , Acctcr = (?) , AD_Org_ID = (?) , Isactive = (?) , Acctdr = (?) , Amt = TO_NUMBER(?) , Isdr2cr = (?) , Isgross = (?) , C_Tax_ID = (?) , Description = (?) , A_Asset_ID = (?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , Glstatus = (?) , Cancel = (?) , Processing = (?) , C_Projectphase_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zsfi_macctline.Zsfi_Macctline_ID = ? " +
      "                 AND zsfi_macctline.Zsfi_Manualacct_ID = ? " +
      "        AND zsfi_macctline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zsfi_macctline.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiMacctlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiManualacctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctcr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctdr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdr2cr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isgross);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiMacctlineId);
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
      "        INSERT INTO zsfi_macctline " +
      "        (Zsfi_Macctline_ID, Zsfi_Manualacct_ID, Line, Acctdate, AD_Client_ID, Acctcr, AD_Org_ID, Isactive, Acctdr, Amt, Isdr2cr, Isgross, C_Tax_ID, Description, A_Asset_ID, C_Project_ID, C_Projecttask_ID, Glstatus, Cancel, Processing, C_Projectphase_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), TO_DATE(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiMacctlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiManualacctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctcr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctdr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdr2cr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isgross);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zsfiManualacctId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zsfi_macctline" +
      "        WHERE zsfi_macctline.Zsfi_Macctline_ID = ? " +
      "                 AND zsfi_macctline.Zsfi_Manualacct_ID = ? " +
      "        AND zsfi_macctline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zsfi_macctline.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zsfiManualacctId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zsfi_macctline" +
      "        WHERE zsfi_macctline.Zsfi_Macctline_ID = ? " +
      "                 AND zsfi_macctline.Zsfi_Manualacct_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiManualacctId);

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
      "          FROM zsfi_macctline" +
      "         WHERE zsfi_macctline.Zsfi_Macctline_ID = ? ";

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
      "          FROM zsfi_macctline" +
      "         WHERE zsfi_macctline.Zsfi_Macctline_ID = ? ";

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
