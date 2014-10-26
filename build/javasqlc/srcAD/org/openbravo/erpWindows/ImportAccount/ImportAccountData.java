//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ImportAccount;

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
class ImportAccountData implements FieldProvider {
static Logger log4j = Logger.getLogger(ImportAccountData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String isactive;
  public String iElementvalueId;
  public String iIsimported;
  public String cElementvalueId;
  public String cElementvalueIdr;
  public String iErrormsg;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String elementname;
  public String cElementId;
  public String cElementIdr;
  public String value;
  public String name;
  public String description;
  public String accounttype;
  public String accountsign;
  public String issummary;
  public String parentvalue;
  public String parentelementvalueId;
  public String parentelementvalueIdr;
  public String postactual;
  public String postbudget;
  public String poststatistical;
  public String postencumbrance;
  public String isdoccontrolled;
  public String defaultAccount;
  public String adColumnId;
  public String adColumnIdr;
  public String elementlevel;
  public String processing;
  public String processed;
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
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("i_elementvalue_id") || fieldName.equals("iElementvalueId"))
      return iElementvalueId;
    else if (fieldName.equalsIgnoreCase("i_isimported") || fieldName.equals("iIsimported"))
      return iIsimported;
    else if (fieldName.equalsIgnoreCase("c_elementvalue_id") || fieldName.equals("cElementvalueId"))
      return cElementvalueId;
    else if (fieldName.equalsIgnoreCase("c_elementvalue_idr") || fieldName.equals("cElementvalueIdr"))
      return cElementvalueIdr;
    else if (fieldName.equalsIgnoreCase("i_errormsg") || fieldName.equals("iErrormsg"))
      return iErrormsg;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("elementname"))
      return elementname;
    else if (fieldName.equalsIgnoreCase("c_element_id") || fieldName.equals("cElementId"))
      return cElementId;
    else if (fieldName.equalsIgnoreCase("c_element_idr") || fieldName.equals("cElementIdr"))
      return cElementIdr;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("accounttype"))
      return accounttype;
    else if (fieldName.equalsIgnoreCase("accountsign"))
      return accountsign;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("parentvalue"))
      return parentvalue;
    else if (fieldName.equalsIgnoreCase("parentelementvalue_id") || fieldName.equals("parentelementvalueId"))
      return parentelementvalueId;
    else if (fieldName.equalsIgnoreCase("parentelementvalue_idr") || fieldName.equals("parentelementvalueIdr"))
      return parentelementvalueIdr;
    else if (fieldName.equalsIgnoreCase("postactual"))
      return postactual;
    else if (fieldName.equalsIgnoreCase("postbudget"))
      return postbudget;
    else if (fieldName.equalsIgnoreCase("poststatistical"))
      return poststatistical;
    else if (fieldName.equalsIgnoreCase("postencumbrance"))
      return postencumbrance;
    else if (fieldName.equalsIgnoreCase("isdoccontrolled"))
      return isdoccontrolled;
    else if (fieldName.equalsIgnoreCase("default_account") || fieldName.equals("defaultAccount"))
      return defaultAccount;
    else if (fieldName.equalsIgnoreCase("ad_column_id") || fieldName.equals("adColumnId"))
      return adColumnId;
    else if (fieldName.equalsIgnoreCase("ad_column_idr") || fieldName.equals("adColumnIdr"))
      return adColumnIdr;
    else if (fieldName.equalsIgnoreCase("elementlevel"))
      return elementlevel;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
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
  public static ImportAccountData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ImportAccountData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(I_ElementValue.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = I_ElementValue.CreatedBy) as CreatedByR, " +
      "        to_char(I_ElementValue.Updated, ?) as updated, " +
      "        to_char(I_ElementValue.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        I_ElementValue.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = I_ElementValue.UpdatedBy) as UpdatedByR," +
      "        COALESCE(I_ElementValue.IsActive, 'N') AS IsActive, " +
      "I_ElementValue.I_ElementValue_ID, " +
      "COALESCE(I_ElementValue.I_IsImported, 'N') AS I_IsImported, " +
      "I_ElementValue.C_ElementValue_ID, " +
      "(CASE WHEN I_ElementValue.C_ElementValue_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS C_ElementValue_IDR, " +
      "I_ElementValue.I_ErrorMsg, " +
      "I_ElementValue.AD_Client_ID, " +
      "(CASE WHEN I_ElementValue.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "I_ElementValue.AD_Org_ID, " +
      "(CASE WHEN I_ElementValue.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "I_ElementValue.ElementName, " +
      "I_ElementValue.C_Element_ID, " +
      "(CASE WHEN I_ElementValue.C_Element_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Element_IDR, " +
      "I_ElementValue.Value, " +
      "I_ElementValue.Name, " +
      "I_ElementValue.Description, " +
      "I_ElementValue.AccountType, " +
      "I_ElementValue.AccountSign, " +
      "COALESCE(I_ElementValue.IsSummary, 'N') AS IsSummary, " +
      "I_ElementValue.ParentValue, " +
      "I_ElementValue.ParentElementValue_ID, " +
      "(CASE WHEN I_ElementValue.ParentElementValue_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS ParentElementValue_IDR, " +
      "COALESCE(I_ElementValue.PostActual, 'N') AS PostActual, " +
      "COALESCE(I_ElementValue.PostBudget, 'N') AS PostBudget, " +
      "COALESCE(I_ElementValue.PostStatistical, 'N') AS PostStatistical, " +
      "COALESCE(I_ElementValue.PostEncumbrance, 'N') AS PostEncumbrance, " +
      "COALESCE(I_ElementValue.IsDocControlled, 'N') AS IsDocControlled, " +
      "I_ElementValue.Default_Account, " +
      "I_ElementValue.AD_Column_ID, " +
      "(CASE WHEN I_ElementValue.AD_Column_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.ColumnName), ''))),'') ) END) AS AD_Column_IDR, " +
      "I_ElementValue.Elementlevel, " +
      "I_ElementValue.Processing, " +
      "COALESCE(I_ElementValue.Processed, 'N') AS Processed, " +
      "        ? AS LANGUAGE " +
      "        FROM I_ElementValue left join (select C_ElementValue_ID, Value, Name from C_ElementValue) table1 on (I_ElementValue.C_ElementValue_ID = table1.C_ElementValue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL1 on (table1.C_ElementValue_ID = tableTRL1.C_ElementValue_ID and tableTRL1.AD_Language = ?)  left join (select AD_Client_ID, Name from AD_Client) table2 on (I_ElementValue.AD_Client_ID = table2.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table3 on (I_ElementValue.AD_Org_ID = table3.AD_Org_ID) left join (select C_Element_ID, Name from C_Element) table4 on (I_ElementValue.C_Element_ID = table4.C_Element_ID) left join (select C_ElementValue_ID, value, Name from C_ElementValue) table5 on (I_ElementValue.ParentElementValue_ID =  table5.C_ElementValue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL5 on (table5.C_ElementValue_ID = tableTRL5.C_ElementValue_ID and tableTRL5.AD_Language = ?)  left join (select AD_Column_ID, ColumnName from AD_Column) table6 on (I_ElementValue.AD_Column_ID =  table6.AD_Column_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND I_ElementValue.I_ElementValue_ID = ? " +
      "        AND I_ElementValue.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND I_ElementValue.AD_Org_ID IN (";
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
        ImportAccountData objectImportAccountData = new ImportAccountData();
        objectImportAccountData.created = UtilSql.getValue(result, "created");
        objectImportAccountData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectImportAccountData.updated = UtilSql.getValue(result, "updated");
        objectImportAccountData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectImportAccountData.updatedby = UtilSql.getValue(result, "updatedby");
        objectImportAccountData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectImportAccountData.isactive = UtilSql.getValue(result, "isactive");
        objectImportAccountData.iElementvalueId = UtilSql.getValue(result, "i_elementvalue_id");
        objectImportAccountData.iIsimported = UtilSql.getValue(result, "i_isimported");
        objectImportAccountData.cElementvalueId = UtilSql.getValue(result, "c_elementvalue_id");
        objectImportAccountData.cElementvalueIdr = UtilSql.getValue(result, "c_elementvalue_idr");
        objectImportAccountData.iErrormsg = UtilSql.getValue(result, "i_errormsg");
        objectImportAccountData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectImportAccountData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectImportAccountData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectImportAccountData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectImportAccountData.elementname = UtilSql.getValue(result, "elementname");
        objectImportAccountData.cElementId = UtilSql.getValue(result, "c_element_id");
        objectImportAccountData.cElementIdr = UtilSql.getValue(result, "c_element_idr");
        objectImportAccountData.value = UtilSql.getValue(result, "value");
        objectImportAccountData.name = UtilSql.getValue(result, "name");
        objectImportAccountData.description = UtilSql.getValue(result, "description");
        objectImportAccountData.accounttype = UtilSql.getValue(result, "accounttype");
        objectImportAccountData.accountsign = UtilSql.getValue(result, "accountsign");
        objectImportAccountData.issummary = UtilSql.getValue(result, "issummary");
        objectImportAccountData.parentvalue = UtilSql.getValue(result, "parentvalue");
        objectImportAccountData.parentelementvalueId = UtilSql.getValue(result, "parentelementvalue_id");
        objectImportAccountData.parentelementvalueIdr = UtilSql.getValue(result, "parentelementvalue_idr");
        objectImportAccountData.postactual = UtilSql.getValue(result, "postactual");
        objectImportAccountData.postbudget = UtilSql.getValue(result, "postbudget");
        objectImportAccountData.poststatistical = UtilSql.getValue(result, "poststatistical");
        objectImportAccountData.postencumbrance = UtilSql.getValue(result, "postencumbrance");
        objectImportAccountData.isdoccontrolled = UtilSql.getValue(result, "isdoccontrolled");
        objectImportAccountData.defaultAccount = UtilSql.getValue(result, "default_account");
        objectImportAccountData.adColumnId = UtilSql.getValue(result, "ad_column_id");
        objectImportAccountData.adColumnIdr = UtilSql.getValue(result, "ad_column_idr");
        objectImportAccountData.elementlevel = UtilSql.getValue(result, "elementlevel");
        objectImportAccountData.processing = UtilSql.getValue(result, "processing");
        objectImportAccountData.processed = UtilSql.getValue(result, "processed");
        objectImportAccountData.language = UtilSql.getValue(result, "language");
        objectImportAccountData.adUserClient = "";
        objectImportAccountData.adOrgClient = "";
        objectImportAccountData.createdby = "";
        objectImportAccountData.trBgcolor = "";
        objectImportAccountData.totalCount = "";
        objectImportAccountData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImportAccountData);
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
    ImportAccountData objectImportAccountData[] = new ImportAccountData[vector.size()];
    vector.copyInto(objectImportAccountData);
    return(objectImportAccountData);
  }

/**
Create a registry
 */
  public static ImportAccountData[] set(String created, String poststatistical, String description, String iErrormsg, String value, String accountsign, String parentelementvalueId, String name, String processed, String postbudget, String isactive, String accounttype, String postactual, String iIsimported, String defaultAccount, String adOrgId, String adClientId, String cElementId, String iElementvalueId, String processing, String updatedby, String updatedbyr, String adColumnId, String issummary, String elementname, String isdoccontrolled, String elementlevel, String parentvalue, String createdby, String createdbyr, String postencumbrance, String cElementvalueId)    throws ServletException {
    ImportAccountData objectImportAccountData[] = new ImportAccountData[1];
    objectImportAccountData[0] = new ImportAccountData();
    objectImportAccountData[0].created = created;
    objectImportAccountData[0].createdbyr = createdbyr;
    objectImportAccountData[0].updated = "";
    objectImportAccountData[0].updatedTimeStamp = "";
    objectImportAccountData[0].updatedby = updatedby;
    objectImportAccountData[0].updatedbyr = updatedbyr;
    objectImportAccountData[0].isactive = isactive;
    objectImportAccountData[0].iElementvalueId = iElementvalueId;
    objectImportAccountData[0].iIsimported = iIsimported;
    objectImportAccountData[0].cElementvalueId = cElementvalueId;
    objectImportAccountData[0].cElementvalueIdr = "";
    objectImportAccountData[0].iErrormsg = iErrormsg;
    objectImportAccountData[0].adClientId = adClientId;
    objectImportAccountData[0].adClientIdr = "";
    objectImportAccountData[0].adOrgId = adOrgId;
    objectImportAccountData[0].adOrgIdr = "";
    objectImportAccountData[0].elementname = elementname;
    objectImportAccountData[0].cElementId = cElementId;
    objectImportAccountData[0].cElementIdr = "";
    objectImportAccountData[0].value = value;
    objectImportAccountData[0].name = name;
    objectImportAccountData[0].description = description;
    objectImportAccountData[0].accounttype = accounttype;
    objectImportAccountData[0].accountsign = accountsign;
    objectImportAccountData[0].issummary = issummary;
    objectImportAccountData[0].parentvalue = parentvalue;
    objectImportAccountData[0].parentelementvalueId = parentelementvalueId;
    objectImportAccountData[0].parentelementvalueIdr = "";
    objectImportAccountData[0].postactual = postactual;
    objectImportAccountData[0].postbudget = postbudget;
    objectImportAccountData[0].poststatistical = poststatistical;
    objectImportAccountData[0].postencumbrance = postencumbrance;
    objectImportAccountData[0].isdoccontrolled = isdoccontrolled;
    objectImportAccountData[0].defaultAccount = defaultAccount;
    objectImportAccountData[0].adColumnId = adColumnId;
    objectImportAccountData[0].adColumnIdr = "";
    objectImportAccountData[0].elementlevel = elementlevel;
    objectImportAccountData[0].processing = processing;
    objectImportAccountData[0].processed = processed;
    objectImportAccountData[0].language = "";
    return objectImportAccountData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef7908_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDef7928_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET IsActive = (?) , I_ElementValue_ID = (?) , I_IsImported = (?) , C_ElementValue_ID = (?) , I_ErrorMsg = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , ElementName = (?) , C_Element_ID = (?) , Value = (?) , Name = (?) , Description = (?) , AccountType = (?) , AccountSign = (?) , IsSummary = (?) , ParentValue = (?) , ParentElementValue_ID = (?) , PostActual = (?) , PostBudget = (?) , PostStatistical = (?) , PostEncumbrance = (?) , IsDocControlled = (?) , Default_Account = (?) , AD_Column_ID = (?) , Elementlevel = (?) , Processing = (?) , Processed = (?) , updated = now(), updatedby = ? " +
      "        WHERE I_ElementValue.I_ElementValue_ID = ? " +
      "        AND I_ElementValue.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND I_ElementValue.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iIsimported);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iErrormsg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, elementname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accounttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountsign);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentelementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postbudget);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poststatistical);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postencumbrance);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdoccontrolled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, elementlevel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);
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
      "        INSERT INTO I_ElementValue " +
      "        (IsActive, I_ElementValue_ID, I_IsImported, C_ElementValue_ID, I_ErrorMsg, AD_Client_ID, AD_Org_ID, ElementName, C_Element_ID, Value, Name, Description, AccountType, AccountSign, IsSummary, ParentValue, ParentElementValue_ID, PostActual, PostBudget, PostStatistical, PostEncumbrance, IsDocControlled, Default_Account, AD_Column_ID, Elementlevel, Processing, Processed, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iIsimported);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iErrormsg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, elementname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accounttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountsign);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentelementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postbudget);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poststatistical);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postencumbrance);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdoccontrolled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, elementlevel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
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
      "        DELETE FROM I_ElementValue" +
      "        WHERE I_ElementValue.I_ElementValue_ID = ? " +
      "        AND I_ElementValue.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND I_ElementValue.AD_Org_ID IN (";
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
      "        DELETE FROM I_ElementValue" +
      "        WHERE I_ElementValue.I_ElementValue_ID = ? ";

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
      "          FROM I_ElementValue" +
      "         WHERE I_ElementValue.I_ElementValue_ID = ? ";

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
      "          FROM I_ElementValue" +
      "         WHERE I_ElementValue.I_ElementValue_ID = ? ";

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
