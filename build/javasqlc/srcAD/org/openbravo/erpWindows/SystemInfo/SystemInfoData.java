//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.SystemInfo;

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
class SystemInfoData implements FieldProvider {
static Logger log4j = Logger.getLogger(SystemInfoData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String codeRevision;
  public String adSystemInfoId;
  public String antVersion;
  public String adClientId;
  public String servletContainer;
  public String adOrgId;
  public String servletContainerVersion;
  public String isactive;
  public String webserver;
  public String webserverVersion;
  public String customizationAllowed;
  public String isproxyrequired;
  public String systemIdentifier;
  public String proxyPort;
  public String proxyServer;
  public String postponeDate;
  public String systemStatus;
  public String systemStatusr;
  public String yourItServiceLoginImage;
  public String yourCompanyBigImage;
  public String yourCompanyDocumentImage;
  public String supportContact;
  public String obVersion;
  public String obInstallmode;
  public String lastBuild;
  public String lastDbupdate;
  public String dbChecksum;
  public String yourCompanyLoginImage;
  public String yourCompanyMenuImage;
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
    else if (fieldName.equalsIgnoreCase("code_revision") || fieldName.equals("codeRevision"))
      return codeRevision;
    else if (fieldName.equalsIgnoreCase("ad_system_info_id") || fieldName.equals("adSystemInfoId"))
      return adSystemInfoId;
    else if (fieldName.equalsIgnoreCase("ant_version") || fieldName.equals("antVersion"))
      return antVersion;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("servlet_container") || fieldName.equals("servletContainer"))
      return servletContainer;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("servlet_container_version") || fieldName.equals("servletContainerVersion"))
      return servletContainerVersion;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("webserver"))
      return webserver;
    else if (fieldName.equalsIgnoreCase("webserver_version") || fieldName.equals("webserverVersion"))
      return webserverVersion;
    else if (fieldName.equalsIgnoreCase("customization_allowed") || fieldName.equals("customizationAllowed"))
      return customizationAllowed;
    else if (fieldName.equalsIgnoreCase("isproxyrequired"))
      return isproxyrequired;
    else if (fieldName.equalsIgnoreCase("system_identifier") || fieldName.equals("systemIdentifier"))
      return systemIdentifier;
    else if (fieldName.equalsIgnoreCase("proxy_port") || fieldName.equals("proxyPort"))
      return proxyPort;
    else if (fieldName.equalsIgnoreCase("proxy_server") || fieldName.equals("proxyServer"))
      return proxyServer;
    else if (fieldName.equalsIgnoreCase("postpone_date") || fieldName.equals("postponeDate"))
      return postponeDate;
    else if (fieldName.equalsIgnoreCase("system_status") || fieldName.equals("systemStatus"))
      return systemStatus;
    else if (fieldName.equalsIgnoreCase("system_statusr") || fieldName.equals("systemStatusr"))
      return systemStatusr;
    else if (fieldName.equalsIgnoreCase("your_it_service_login_image") || fieldName.equals("yourItServiceLoginImage"))
      return yourItServiceLoginImage;
    else if (fieldName.equalsIgnoreCase("your_company_big_image") || fieldName.equals("yourCompanyBigImage"))
      return yourCompanyBigImage;
    else if (fieldName.equalsIgnoreCase("your_company_document_image") || fieldName.equals("yourCompanyDocumentImage"))
      return yourCompanyDocumentImage;
    else if (fieldName.equalsIgnoreCase("support_contact") || fieldName.equals("supportContact"))
      return supportContact;
    else if (fieldName.equalsIgnoreCase("ob_version") || fieldName.equals("obVersion"))
      return obVersion;
    else if (fieldName.equalsIgnoreCase("ob_installmode") || fieldName.equals("obInstallmode"))
      return obInstallmode;
    else if (fieldName.equalsIgnoreCase("last_build") || fieldName.equals("lastBuild"))
      return lastBuild;
    else if (fieldName.equalsIgnoreCase("last_dbupdate") || fieldName.equals("lastDbupdate"))
      return lastDbupdate;
    else if (fieldName.equalsIgnoreCase("db_checksum") || fieldName.equals("dbChecksum"))
      return dbChecksum;
    else if (fieldName.equalsIgnoreCase("your_company_login_image") || fieldName.equals("yourCompanyLoginImage"))
      return yourCompanyLoginImage;
    else if (fieldName.equalsIgnoreCase("your_company_menu_image") || fieldName.equals("yourCompanyMenuImage"))
      return yourCompanyMenuImage;
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
  public static SystemInfoData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static SystemInfoData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_System_Info.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_System_Info.CreatedBy) as CreatedByR, " +
      "        to_char(AD_System_Info.Updated, ?) as updated, " +
      "        to_char(AD_System_Info.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_System_Info.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_System_Info.UpdatedBy) as UpdatedByR," +
      "        AD_System_Info.Code_Revision, " +
      "AD_System_Info.AD_System_Info_ID, " +
      "AD_System_Info.ANT_Version, " +
      "AD_System_Info.AD_Client_ID, " +
      "AD_System_Info.Servlet_Container, " +
      "AD_System_Info.AD_Org_ID, " +
      "AD_System_Info.Servlet_Container_Version, " +
      "COALESCE(AD_System_Info.IsActive, 'N') AS IsActive, " +
      "AD_System_Info.Webserver, " +
      "AD_System_Info.Webserver_Version, " +
      "COALESCE(AD_System_Info.Customization_Allowed, 'N') AS Customization_Allowed, " +
      "COALESCE(AD_System_Info.Isproxyrequired, 'N') AS Isproxyrequired, " +
      "AD_System_Info.System_Identifier, " +
      "AD_System_Info.Proxy_Port, " +
      "AD_System_Info.Proxy_Server, " +
      "AD_System_Info.Postpone_Date, " +
      "AD_System_Info.System_Status, " +
      "(CASE WHEN AD_System_Info.System_Status IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS System_StatusR, " +
      "AD_System_Info.Your_It_Service_Login_Image, " +
      "AD_System_Info.Your_Company_Big_Image, " +
      "AD_System_Info.Your_Company_Document_Image, " +
      "AD_System_Info.Support_Contact, " +
      "AD_System_Info.OB_Version, " +
      "AD_System_Info.OB_Installmode, " +
      "AD_System_Info.Last_Build, " +
      "AD_System_Info.Last_DBUpdate, " +
      "AD_System_Info.DB_Checksum, " +
      "AD_System_Info.Your_Company_Login_Image, " +
      "AD_System_Info.Your_Company_Menu_Image, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_System_Info left join ad_ref_list_v list1 on (AD_System_Info.System_Status = list1.value and list1.ad_reference_id = '865D46B9A1C148D1A119F2F0F7F55589' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND AD_System_Info.AD_System_Info_ID = ? " +
      "        AND AD_System_Info.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_System_Info.AD_Org_ID IN (";
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
        SystemInfoData objectSystemInfoData = new SystemInfoData();
        objectSystemInfoData.created = UtilSql.getValue(result, "created");
        objectSystemInfoData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSystemInfoData.updated = UtilSql.getValue(result, "updated");
        objectSystemInfoData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSystemInfoData.updatedby = UtilSql.getValue(result, "updatedby");
        objectSystemInfoData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSystemInfoData.codeRevision = UtilSql.getValue(result, "code_revision");
        objectSystemInfoData.adSystemInfoId = UtilSql.getValue(result, "ad_system_info_id");
        objectSystemInfoData.antVersion = UtilSql.getValue(result, "ant_version");
        objectSystemInfoData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSystemInfoData.servletContainer = UtilSql.getValue(result, "servlet_container");
        objectSystemInfoData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSystemInfoData.servletContainerVersion = UtilSql.getValue(result, "servlet_container_version");
        objectSystemInfoData.isactive = UtilSql.getValue(result, "isactive");
        objectSystemInfoData.webserver = UtilSql.getValue(result, "webserver");
        objectSystemInfoData.webserverVersion = UtilSql.getValue(result, "webserver_version");
        objectSystemInfoData.customizationAllowed = UtilSql.getValue(result, "customization_allowed");
        objectSystemInfoData.isproxyrequired = UtilSql.getValue(result, "isproxyrequired");
        objectSystemInfoData.systemIdentifier = UtilSql.getValue(result, "system_identifier");
        objectSystemInfoData.proxyPort = UtilSql.getValue(result, "proxy_port");
        objectSystemInfoData.proxyServer = UtilSql.getValue(result, "proxy_server");
        objectSystemInfoData.postponeDate = UtilSql.getDateValue(result, "postpone_date", "dd-MM-yyyy");
        objectSystemInfoData.systemStatus = UtilSql.getValue(result, "system_status");
        objectSystemInfoData.systemStatusr = UtilSql.getValue(result, "system_statusr");
        objectSystemInfoData.yourItServiceLoginImage = UtilSql.getValue(result, "your_it_service_login_image");
        objectSystemInfoData.yourCompanyBigImage = UtilSql.getValue(result, "your_company_big_image");
        objectSystemInfoData.yourCompanyDocumentImage = UtilSql.getValue(result, "your_company_document_image");
        objectSystemInfoData.supportContact = UtilSql.getValue(result, "support_contact");
        objectSystemInfoData.obVersion = UtilSql.getValue(result, "ob_version");
        objectSystemInfoData.obInstallmode = UtilSql.getValue(result, "ob_installmode");
        objectSystemInfoData.lastBuild = UtilSql.getDateValue(result, "last_build", "dd-MM-yyyy");
        objectSystemInfoData.lastDbupdate = UtilSql.getDateValue(result, "last_dbupdate", "dd-MM-yyyy");
        objectSystemInfoData.dbChecksum = UtilSql.getValue(result, "db_checksum");
        objectSystemInfoData.yourCompanyLoginImage = UtilSql.getValue(result, "your_company_login_image");
        objectSystemInfoData.yourCompanyMenuImage = UtilSql.getValue(result, "your_company_menu_image");
        objectSystemInfoData.language = UtilSql.getValue(result, "language");
        objectSystemInfoData.adUserClient = "";
        objectSystemInfoData.adOrgClient = "";
        objectSystemInfoData.createdby = "";
        objectSystemInfoData.trBgcolor = "";
        objectSystemInfoData.totalCount = "";
        objectSystemInfoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSystemInfoData);
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
    SystemInfoData objectSystemInfoData[] = new SystemInfoData[vector.size()];
    vector.copyInto(objectSystemInfoData);
    return(objectSystemInfoData);
  }

/**
Create a registry
 */
  public static SystemInfoData[] set(String yourCompanyLoginImage, String updatedby, String updatedbyr, String antVersion, String proxyPort, String webserver, String webserverVersion, String yourCompanyDocumentImage, String createdby, String createdbyr, String yourCompanyBigImage, String adSystemInfoId, String servletContainer, String obInstallmode, String adOrgId, String yourCompanyMenuImage, String obVersion, String dbChecksum, String adClientId, String customizationAllowed, String postponeDate, String yourItServiceLoginImage, String lastDbupdate, String supportContact, String isproxyrequired, String lastBuild, String servletContainerVersion, String systemStatus, String systemIdentifier, String codeRevision, String isactive, String proxyServer)    throws ServletException {
    SystemInfoData objectSystemInfoData[] = new SystemInfoData[1];
    objectSystemInfoData[0] = new SystemInfoData();
    objectSystemInfoData[0].created = "";
    objectSystemInfoData[0].createdbyr = createdbyr;
    objectSystemInfoData[0].updated = "";
    objectSystemInfoData[0].updatedTimeStamp = "";
    objectSystemInfoData[0].updatedby = updatedby;
    objectSystemInfoData[0].updatedbyr = updatedbyr;
    objectSystemInfoData[0].codeRevision = codeRevision;
    objectSystemInfoData[0].adSystemInfoId = adSystemInfoId;
    objectSystemInfoData[0].antVersion = antVersion;
    objectSystemInfoData[0].adClientId = adClientId;
    objectSystemInfoData[0].servletContainer = servletContainer;
    objectSystemInfoData[0].adOrgId = adOrgId;
    objectSystemInfoData[0].servletContainerVersion = servletContainerVersion;
    objectSystemInfoData[0].isactive = isactive;
    objectSystemInfoData[0].webserver = webserver;
    objectSystemInfoData[0].webserverVersion = webserverVersion;
    objectSystemInfoData[0].customizationAllowed = customizationAllowed;
    objectSystemInfoData[0].isproxyrequired = isproxyrequired;
    objectSystemInfoData[0].systemIdentifier = systemIdentifier;
    objectSystemInfoData[0].proxyPort = proxyPort;
    objectSystemInfoData[0].proxyServer = proxyServer;
    objectSystemInfoData[0].postponeDate = postponeDate;
    objectSystemInfoData[0].systemStatus = systemStatus;
    objectSystemInfoData[0].systemStatusr = "";
    objectSystemInfoData[0].yourItServiceLoginImage = yourItServiceLoginImage;
    objectSystemInfoData[0].yourCompanyBigImage = yourCompanyBigImage;
    objectSystemInfoData[0].yourCompanyDocumentImage = yourCompanyDocumentImage;
    objectSystemInfoData[0].supportContact = supportContact;
    objectSystemInfoData[0].obVersion = obVersion;
    objectSystemInfoData[0].obInstallmode = obInstallmode;
    objectSystemInfoData[0].lastBuild = lastBuild;
    objectSystemInfoData[0].lastDbupdate = lastDbupdate;
    objectSystemInfoData[0].dbChecksum = dbChecksum;
    objectSystemInfoData[0].yourCompanyLoginImage = yourCompanyLoginImage;
    objectSystemInfoData[0].yourCompanyMenuImage = yourCompanyMenuImage;
    objectSystemInfoData[0].language = "";
    return objectSystemInfoData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1005400222_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef1005400220_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_System_Info" +
      "        SET Code_Revision = (?) , AD_System_Info_ID = (?) , ANT_Version = (?) , AD_Client_ID = (?) , Servlet_Container = (?) , AD_Org_ID = (?) , Servlet_Container_Version = (?) , IsActive = (?) , Webserver = (?) , Webserver_Version = (?) , Customization_Allowed = (?) , Isproxyrequired = (?) , System_Identifier = (?) , Proxy_Port = TO_NUMBER(?) , Proxy_Server = (?) , Postpone_Date = TO_DATE(?) , System_Status = (?) , Your_It_Service_Login_Image = (?) , Your_Company_Big_Image = (?) , Your_Company_Document_Image = (?) , Support_Contact = (?) , OB_Version = (?) , OB_Installmode = (?) , Last_Build = TO_DATE(?) , Last_DBUpdate = TO_DATE(?) , DB_Checksum = (?) , Your_Company_Login_Image = (?) , Your_Company_Menu_Image = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_System_Info.AD_System_Info_ID = ? " +
      "        AND AD_System_Info.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_System_Info.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, codeRevision);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSystemInfoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, antVersion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servletContainer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servletContainerVersion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, webserver);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, webserverVersion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, customizationAllowed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isproxyrequired);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, systemIdentifier);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proxyPort);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proxyServer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postponeDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, systemStatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yourItServiceLoginImage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yourCompanyBigImage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yourCompanyDocumentImage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, supportContact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, obVersion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, obInstallmode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastBuild);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastDbupdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dbChecksum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yourCompanyLoginImage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yourCompanyMenuImage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSystemInfoId);
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
      "        INSERT INTO AD_System_Info " +
      "        (Code_Revision, AD_System_Info_ID, ANT_Version, AD_Client_ID, Servlet_Container, AD_Org_ID, Servlet_Container_Version, IsActive, Webserver, Webserver_Version, Customization_Allowed, Isproxyrequired, System_Identifier, Proxy_Port, Proxy_Server, Postpone_Date, System_Status, Your_It_Service_Login_Image, Your_Company_Big_Image, Your_Company_Document_Image, Support_Contact, OB_Version, OB_Installmode, Last_Build, Last_DBUpdate, DB_Checksum, Your_Company_Login_Image, Your_Company_Menu_Image, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, codeRevision);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSystemInfoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, antVersion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servletContainer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servletContainerVersion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, webserver);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, webserverVersion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, customizationAllowed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isproxyrequired);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, systemIdentifier);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proxyPort);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proxyServer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postponeDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, systemStatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yourItServiceLoginImage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yourCompanyBigImage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yourCompanyDocumentImage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, supportContact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, obVersion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, obInstallmode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastBuild);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastDbupdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dbChecksum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yourCompanyLoginImage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yourCompanyMenuImage);
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
      "        DELETE FROM AD_System_Info" +
      "        WHERE AD_System_Info.AD_System_Info_ID = ? " +
      "        AND AD_System_Info.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_System_Info.AD_Org_ID IN (";
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
      "        DELETE FROM AD_System_Info" +
      "        WHERE AD_System_Info.AD_System_Info_ID = ? ";

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
      "          FROM AD_System_Info" +
      "         WHERE AD_System_Info.AD_System_Info_ID = ? ";

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
      "          FROM AD_System_Info" +
      "         WHERE AD_System_Info.AD_System_Info_ID = ? ";

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
