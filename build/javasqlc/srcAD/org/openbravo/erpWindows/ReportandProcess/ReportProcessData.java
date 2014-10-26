//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ReportandProcess;

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
class ReportProcessData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportProcessData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adModuleId;
  public String adModuleIdr;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String value;
  public String name;
  public String description;
  public String help;
  public String isactive;
  public String accesslevel;
  public String accesslevelr;
  public String uipattern;
  public String uipatternr;
  public String manualresponse;
  public String isreport;
  public String isuserstartable;
  public String classname;
  public String procedurename;
  public String isbackground;
  public String isdirectprint;
  public String isjasper;
  public String isdirectservletcall;
  public String jrname;
  public String isexternalservice;
  public String serviceType;
  public String serviceTyper;
  public String serviceSource;
  public String adProcessId;
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
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
    else if (fieldName.equalsIgnoreCase("ad_module_idr") || fieldName.equals("adModuleIdr"))
      return adModuleIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("accesslevel"))
      return accesslevel;
    else if (fieldName.equalsIgnoreCase("accesslevelr"))
      return accesslevelr;
    else if (fieldName.equalsIgnoreCase("uipattern"))
      return uipattern;
    else if (fieldName.equalsIgnoreCase("uipatternr"))
      return uipatternr;
    else if (fieldName.equalsIgnoreCase("manualresponse"))
      return manualresponse;
    else if (fieldName.equalsIgnoreCase("isreport"))
      return isreport;
    else if (fieldName.equalsIgnoreCase("isuserstartable"))
      return isuserstartable;
    else if (fieldName.equalsIgnoreCase("classname"))
      return classname;
    else if (fieldName.equalsIgnoreCase("procedurename"))
      return procedurename;
    else if (fieldName.equalsIgnoreCase("isbackground"))
      return isbackground;
    else if (fieldName.equalsIgnoreCase("isdirectprint"))
      return isdirectprint;
    else if (fieldName.equalsIgnoreCase("isjasper"))
      return isjasper;
    else if (fieldName.equalsIgnoreCase("isdirectservletcall"))
      return isdirectservletcall;
    else if (fieldName.equalsIgnoreCase("jrname"))
      return jrname;
    else if (fieldName.equalsIgnoreCase("isexternalservice"))
      return isexternalservice;
    else if (fieldName.equalsIgnoreCase("service_type") || fieldName.equals("serviceType"))
      return serviceType;
    else if (fieldName.equalsIgnoreCase("service_typer") || fieldName.equals("serviceTyper"))
      return serviceTyper;
    else if (fieldName.equalsIgnoreCase("service_source") || fieldName.equals("serviceSource"))
      return serviceSource;
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
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
  public static ReportProcessData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ReportProcessData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Process.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Process.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Process.Updated, ?) as updated, " +
      "        to_char(AD_Process.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Process.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Process.UpdatedBy) as UpdatedByR," +
      "        AD_Process.AD_Module_ID, " +
      "(CASE WHEN AD_Process.AD_Module_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Version), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Module_IDR, " +
      "AD_Process.AD_Client_ID, " +
      "(CASE WHEN AD_Process.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Process.AD_Org_ID, " +
      "(CASE WHEN AD_Process.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_Process.Value, " +
      "AD_Process.Name, " +
      "AD_Process.Description, " +
      "AD_Process.Help, " +
      "COALESCE(AD_Process.IsActive, 'N') AS IsActive, " +
      "AD_Process.AccessLevel, " +
      "(CASE WHEN AD_Process.AccessLevel IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS AccessLevelR, " +
      "AD_Process.UIPattern, " +
      "(CASE WHEN AD_Process.UIPattern IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS UIPatternR, " +
      "COALESCE(AD_Process.Manualresponse, 'N') AS Manualresponse, " +
      "COALESCE(AD_Process.IsReport, 'N') AS IsReport, " +
      "COALESCE(AD_Process.IsUserStartable, 'N') AS IsUserStartable, " +
      "AD_Process.Classname, " +
      "AD_Process.ProcedureName, " +
      "COALESCE(AD_Process.IsBackground, 'N') AS IsBackground, " +
      "COALESCE(AD_Process.IsDirectPrint, 'N') AS IsDirectPrint, " +
      "COALESCE(AD_Process.IsJasper, 'N') AS IsJasper, " +
      "COALESCE(AD_Process.Isdirectservletcall, 'N') AS Isdirectservletcall, " +
      "AD_Process.Jrname, " +
      "COALESCE(AD_Process.Isexternalservice, 'N') AS Isexternalservice, " +
      "AD_Process.Service_Type, " +
      "(CASE WHEN AD_Process.Service_Type IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS Service_TypeR, " +
      "AD_Process.Service_Source, " +
      "AD_Process.AD_Process_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Process left join (select AD_Module_ID, Name, Version, AD_Language from AD_Module) table1 on (AD_Process.AD_Module_ID = table1.AD_Module_ID) left join (select AD_Language, Name from AD_Language) table2 on (table1.AD_Language =  table2.AD_Language) left join (select AD_Client_ID, Name from AD_Client) table3 on (AD_Process.AD_Client_ID = table3.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table4 on (AD_Process.AD_Org_ID = table4.AD_Org_ID) left join ad_ref_list_v list1 on (AD_Process.AccessLevel = list1.value and list1.ad_reference_id = '5' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (AD_Process.UIPattern = list2.value and list2.ad_reference_id = '55BB57CFEF7E4EA0B3F429E4A55586D8' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (AD_Process.Service_Type = list3.value and list3.ad_reference_id = '1004400002' and list3.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND AD_Process.AD_Process_ID = ? " +
      "        AND AD_Process.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Process.AD_Org_ID IN (";
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
        ReportProcessData objectReportProcessData = new ReportProcessData();
        objectReportProcessData.created = UtilSql.getValue(result, "created");
        objectReportProcessData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectReportProcessData.updated = UtilSql.getValue(result, "updated");
        objectReportProcessData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectReportProcessData.updatedby = UtilSql.getValue(result, "updatedby");
        objectReportProcessData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectReportProcessData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectReportProcessData.adModuleIdr = UtilSql.getValue(result, "ad_module_idr");
        objectReportProcessData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectReportProcessData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectReportProcessData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportProcessData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectReportProcessData.value = UtilSql.getValue(result, "value");
        objectReportProcessData.name = UtilSql.getValue(result, "name");
        objectReportProcessData.description = UtilSql.getValue(result, "description");
        objectReportProcessData.help = UtilSql.getValue(result, "help");
        objectReportProcessData.isactive = UtilSql.getValue(result, "isactive");
        objectReportProcessData.accesslevel = UtilSql.getValue(result, "accesslevel");
        objectReportProcessData.accesslevelr = UtilSql.getValue(result, "accesslevelr");
        objectReportProcessData.uipattern = UtilSql.getValue(result, "uipattern");
        objectReportProcessData.uipatternr = UtilSql.getValue(result, "uipatternr");
        objectReportProcessData.manualresponse = UtilSql.getValue(result, "manualresponse");
        objectReportProcessData.isreport = UtilSql.getValue(result, "isreport");
        objectReportProcessData.isuserstartable = UtilSql.getValue(result, "isuserstartable");
        objectReportProcessData.classname = UtilSql.getValue(result, "classname");
        objectReportProcessData.procedurename = UtilSql.getValue(result, "procedurename");
        objectReportProcessData.isbackground = UtilSql.getValue(result, "isbackground");
        objectReportProcessData.isdirectprint = UtilSql.getValue(result, "isdirectprint");
        objectReportProcessData.isjasper = UtilSql.getValue(result, "isjasper");
        objectReportProcessData.isdirectservletcall = UtilSql.getValue(result, "isdirectservletcall");
        objectReportProcessData.jrname = UtilSql.getValue(result, "jrname");
        objectReportProcessData.isexternalservice = UtilSql.getValue(result, "isexternalservice");
        objectReportProcessData.serviceType = UtilSql.getValue(result, "service_type");
        objectReportProcessData.serviceTyper = UtilSql.getValue(result, "service_typer");
        objectReportProcessData.serviceSource = UtilSql.getValue(result, "service_source");
        objectReportProcessData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectReportProcessData.language = UtilSql.getValue(result, "language");
        objectReportProcessData.adUserClient = "";
        objectReportProcessData.adOrgClient = "";
        objectReportProcessData.createdby = "";
        objectReportProcessData.trBgcolor = "";
        objectReportProcessData.totalCount = "";
        objectReportProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportProcessData);
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
    ReportProcessData objectReportProcessData[] = new ReportProcessData[vector.size()];
    vector.copyInto(objectReportProcessData);
    return(objectReportProcessData);
  }

/**
Create a registry
 */
  public static ReportProcessData[] set(String isdirectservletcall, String adOrgId, String adModuleId, String isuserstartable, String name, String createdby, String createdbyr, String value, String isjasper, String manualresponse, String serviceType, String isbackground, String jrname, String adProcessId, String uipattern, String description, String updatedby, String updatedbyr, String adClientId, String help, String isreport, String isexternalservice, String accesslevel, String isactive, String isdirectprint, String procedurename, String serviceSource, String classname)    throws ServletException {
    ReportProcessData objectReportProcessData[] = new ReportProcessData[1];
    objectReportProcessData[0] = new ReportProcessData();
    objectReportProcessData[0].created = "";
    objectReportProcessData[0].createdbyr = createdbyr;
    objectReportProcessData[0].updated = "";
    objectReportProcessData[0].updatedTimeStamp = "";
    objectReportProcessData[0].updatedby = updatedby;
    objectReportProcessData[0].updatedbyr = updatedbyr;
    objectReportProcessData[0].adModuleId = adModuleId;
    objectReportProcessData[0].adModuleIdr = "";
    objectReportProcessData[0].adClientId = adClientId;
    objectReportProcessData[0].adClientIdr = "";
    objectReportProcessData[0].adOrgId = adOrgId;
    objectReportProcessData[0].adOrgIdr = "";
    objectReportProcessData[0].value = value;
    objectReportProcessData[0].name = name;
    objectReportProcessData[0].description = description;
    objectReportProcessData[0].help = help;
    objectReportProcessData[0].isactive = isactive;
    objectReportProcessData[0].accesslevel = accesslevel;
    objectReportProcessData[0].accesslevelr = "";
    objectReportProcessData[0].uipattern = uipattern;
    objectReportProcessData[0].uipatternr = "";
    objectReportProcessData[0].manualresponse = manualresponse;
    objectReportProcessData[0].isreport = isreport;
    objectReportProcessData[0].isuserstartable = isuserstartable;
    objectReportProcessData[0].classname = classname;
    objectReportProcessData[0].procedurename = procedurename;
    objectReportProcessData[0].isbackground = isbackground;
    objectReportProcessData[0].isdirectprint = isdirectprint;
    objectReportProcessData[0].isjasper = isjasper;
    objectReportProcessData[0].isdirectservletcall = isdirectservletcall;
    objectReportProcessData[0].jrname = jrname;
    objectReportProcessData[0].isexternalservice = isexternalservice;
    objectReportProcessData[0].serviceType = serviceType;
    objectReportProcessData[0].serviceTyper = "";
    objectReportProcessData[0].serviceSource = serviceSource;
    objectReportProcessData[0].adProcessId = adProcessId;
    objectReportProcessData[0].language = "";
    return objectReportProcessData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef5661EC317B633D0FE040007F01004528(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(AD_MODULE_ID) FROM AD_MODULE WHERE ISDEFAULT='Y' ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "max");
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
  public static String selectDef2806_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef2808_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
      "        UPDATE AD_Process" +
      "        SET AD_Module_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Value = (?) , Name = (?) , Description = (?) , Help = (?) , IsActive = (?) , AccessLevel = (?) , UIPattern = (?) , Manualresponse = (?) , IsReport = (?) , IsUserStartable = (?) , Classname = (?) , ProcedureName = (?) , IsBackground = (?) , IsDirectPrint = (?) , IsJasper = (?) , Isdirectservletcall = (?) , Jrname = (?) , Isexternalservice = (?) , Service_Type = (?) , Service_Source = (?) , AD_Process_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Process.AD_Process_ID = ? " +
      "        AND AD_Process.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Process.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accesslevel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uipattern);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, manualresponse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreport);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isuserstartable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, classname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, procedurename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbackground);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdirectprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isjasper);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdirectservletcall);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, jrname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isexternalservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serviceType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serviceSource);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
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
      "        INSERT INTO AD_Process " +
      "        (AD_Module_ID, AD_Client_ID, AD_Org_ID, Value, Name, Description, Help, IsActive, AccessLevel, UIPattern, Manualresponse, IsReport, IsUserStartable, Classname, ProcedureName, IsBackground, IsDirectPrint, IsJasper, Isdirectservletcall, Jrname, Isexternalservice, Service_Type, Service_Source, AD_Process_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accesslevel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uipattern);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, manualresponse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreport);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isuserstartable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, classname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, procedurename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbackground);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdirectprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isjasper);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdirectservletcall);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, jrname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isexternalservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serviceType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serviceSource);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
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
      "        DELETE FROM AD_Process" +
      "        WHERE AD_Process.AD_Process_ID = ? " +
      "        AND AD_Process.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Process.AD_Org_ID IN (";
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
      "        DELETE FROM AD_Process" +
      "        WHERE AD_Process.AD_Process_ID = ? ";

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
      "          FROM AD_Process" +
      "         WHERE AD_Process.AD_Process_ID = ? ";

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
      "          FROM AD_Process" +
      "         WHERE AD_Process.AD_Process_ID = ? ";

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
