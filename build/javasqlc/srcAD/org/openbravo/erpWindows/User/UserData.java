//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.User;

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
class UserData implements FieldProvider {
static Logger log4j = Logger.getLogger(UserData.class);
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
  public String description;
  public String comments;
  public String isactive;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String username;
  public String password;
  public String adOrgtrxId;
  public String defaultAdRoleId;
  public String defaultAdRoleIdr;
  public String defaultAdLanguage;
  public String defaultAdLanguager;
  public String defaultAdClientId;
  public String defaultAdClientIdr;
  public String defaultAdOrgId;
  public String defaultAdOrgIdr;
  public String defaultMWarehouseId;
  public String defaultMWarehouseIdr;
  public String phone2;
  public String birthday;
  public String cBpartnerLocationId;
  public String phone;
  public String fax;
  public String lastresult;
  public String lastcontact;
  public String title;
  public String cGreetingId;
  public String firstname;
  public String lastname;
  public String emailuserpw;
  public String emailuser;
  public String processing;
  public String supervisorId;
  public String email;
  public String adUserId;
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
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("comments"))
      return comments;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("username"))
      return username;
    else if (fieldName.equalsIgnoreCase("password"))
      return password;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("default_ad_role_id") || fieldName.equals("defaultAdRoleId"))
      return defaultAdRoleId;
    else if (fieldName.equalsIgnoreCase("default_ad_role_idr") || fieldName.equals("defaultAdRoleIdr"))
      return defaultAdRoleIdr;
    else if (fieldName.equalsIgnoreCase("default_ad_language") || fieldName.equals("defaultAdLanguage"))
      return defaultAdLanguage;
    else if (fieldName.equalsIgnoreCase("default_ad_languager") || fieldName.equals("defaultAdLanguager"))
      return defaultAdLanguager;
    else if (fieldName.equalsIgnoreCase("default_ad_client_id") || fieldName.equals("defaultAdClientId"))
      return defaultAdClientId;
    else if (fieldName.equalsIgnoreCase("default_ad_client_idr") || fieldName.equals("defaultAdClientIdr"))
      return defaultAdClientIdr;
    else if (fieldName.equalsIgnoreCase("default_ad_org_id") || fieldName.equals("defaultAdOrgId"))
      return defaultAdOrgId;
    else if (fieldName.equalsIgnoreCase("default_ad_org_idr") || fieldName.equals("defaultAdOrgIdr"))
      return defaultAdOrgIdr;
    else if (fieldName.equalsIgnoreCase("default_m_warehouse_id") || fieldName.equals("defaultMWarehouseId"))
      return defaultMWarehouseId;
    else if (fieldName.equalsIgnoreCase("default_m_warehouse_idr") || fieldName.equals("defaultMWarehouseIdr"))
      return defaultMWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("phone2"))
      return phone2;
    else if (fieldName.equalsIgnoreCase("birthday"))
      return birthday;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("fax"))
      return fax;
    else if (fieldName.equalsIgnoreCase("lastresult"))
      return lastresult;
    else if (fieldName.equalsIgnoreCase("lastcontact"))
      return lastcontact;
    else if (fieldName.equalsIgnoreCase("title"))
      return title;
    else if (fieldName.equalsIgnoreCase("c_greeting_id") || fieldName.equals("cGreetingId"))
      return cGreetingId;
    else if (fieldName.equalsIgnoreCase("firstname"))
      return firstname;
    else if (fieldName.equalsIgnoreCase("lastname"))
      return lastname;
    else if (fieldName.equalsIgnoreCase("emailuserpw"))
      return emailuserpw;
    else if (fieldName.equalsIgnoreCase("emailuser"))
      return emailuser;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("supervisor_id") || fieldName.equals("supervisorId"))
      return supervisorId;
    else if (fieldName.equalsIgnoreCase("email"))
      return email;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
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
  public static UserData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static UserData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_User.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_User.CreatedBy) as CreatedByR, " +
      "        to_char(AD_User.Updated, ?) as updated, " +
      "        to_char(AD_User.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_User.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_User.UpdatedBy) as UpdatedByR," +
      "        AD_User.AD_Client_ID, " +
      "(CASE WHEN AD_User.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_User.AD_Org_ID, " +
      "(CASE WHEN AD_User.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_User.Name, " +
      "AD_User.Description, " +
      "AD_User.Comments, " +
      "COALESCE(AD_User.IsActive, 'N') AS IsActive, " +
      "AD_User.C_BPartner_ID, " +
      "(CASE WHEN AD_User.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "AD_User.UserName, " +
      "AD_User.Password, " +
      "AD_User.AD_OrgTrx_ID, " +
      "AD_User.Default_Ad_Role_ID, " +
      "(CASE WHEN AD_User.Default_Ad_Role_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS Default_Ad_Role_IDR, " +
      "AD_User.Default_Ad_Language, " +
      "(CASE WHEN AD_User.Default_Ad_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS Default_Ad_LanguageR, " +
      "AD_User.Default_Ad_Client_ID, " +
      "(CASE WHEN AD_User.Default_Ad_Client_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS Default_Ad_Client_IDR, " +
      "AD_User.Default_Ad_Org_ID, " +
      "(CASE WHEN AD_User.Default_Ad_Org_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS Default_Ad_Org_IDR, " +
      "AD_User.Default_M_Warehouse_ID, " +
      "(CASE WHEN AD_User.Default_M_Warehouse_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS Default_M_Warehouse_IDR, " +
      "AD_User.Phone2, " +
      "AD_User.Birthday, " +
      "AD_User.C_BPartner_Location_ID, " +
      "AD_User.Phone, " +
      "AD_User.Fax, " +
      "AD_User.LastResult, " +
      "AD_User.LastContact, " +
      "AD_User.Title, " +
      "AD_User.C_Greeting_ID, " +
      "AD_User.Firstname, " +
      "AD_User.Lastname, " +
      "AD_User.EmailUserPW, " +
      "AD_User.EmailUser, " +
      "AD_User.Processing, " +
      "AD_User.Supervisor_ID, " +
      "AD_User.Email, " +
      "AD_User.AD_User_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_User left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_User.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_User.AD_Org_ID = table2.AD_Org_ID) left join (select C_BPartner_ID, Name from C_BPartner) table3 on (AD_User.C_BPartner_ID = table3.C_BPartner_ID) left join (select AD_Role_ID, Name from AD_Role) table4 on (AD_User.Default_Ad_Role_ID =  table4.AD_Role_ID) left join (select AD_Language, Name from AD_Language) table5 on (AD_User.Default_Ad_Language =  table5.AD_Language) left join (select AD_Client_ID, Name from AD_Client) table6 on (AD_User.Default_Ad_Client_ID =  table6.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table7 on (AD_User.Default_Ad_Org_ID =  table7.AD_Org_ID) left join (select M_Warehouse_ID, Name from M_Warehouse) table8 on (AD_User.Default_M_Warehouse_ID =  table8.M_Warehouse_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND AD_User.AD_User_ID = ? " +
      "        AND AD_User.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_User.AD_Org_ID IN (";
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
        UserData objectUserData = new UserData();
        objectUserData.created = UtilSql.getValue(result, "created");
        objectUserData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectUserData.updated = UtilSql.getValue(result, "updated");
        objectUserData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectUserData.updatedby = UtilSql.getValue(result, "updatedby");
        objectUserData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectUserData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectUserData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectUserData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectUserData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectUserData.name = UtilSql.getValue(result, "name");
        objectUserData.description = UtilSql.getValue(result, "description");
        objectUserData.comments = UtilSql.getValue(result, "comments");
        objectUserData.isactive = UtilSql.getValue(result, "isactive");
        objectUserData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectUserData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectUserData.username = UtilSql.getValue(result, "username");
        objectUserData.password = UtilSql.getValue(result, "password");
        objectUserData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectUserData.defaultAdRoleId = UtilSql.getValue(result, "default_ad_role_id");
        objectUserData.defaultAdRoleIdr = UtilSql.getValue(result, "default_ad_role_idr");
        objectUserData.defaultAdLanguage = UtilSql.getValue(result, "default_ad_language");
        objectUserData.defaultAdLanguager = UtilSql.getValue(result, "default_ad_languager");
        objectUserData.defaultAdClientId = UtilSql.getValue(result, "default_ad_client_id");
        objectUserData.defaultAdClientIdr = UtilSql.getValue(result, "default_ad_client_idr");
        objectUserData.defaultAdOrgId = UtilSql.getValue(result, "default_ad_org_id");
        objectUserData.defaultAdOrgIdr = UtilSql.getValue(result, "default_ad_org_idr");
        objectUserData.defaultMWarehouseId = UtilSql.getValue(result, "default_m_warehouse_id");
        objectUserData.defaultMWarehouseIdr = UtilSql.getValue(result, "default_m_warehouse_idr");
        objectUserData.phone2 = UtilSql.getValue(result, "phone2");
        objectUserData.birthday = UtilSql.getDateValue(result, "birthday", "dd-MM-yyyy");
        objectUserData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectUserData.phone = UtilSql.getValue(result, "phone");
        objectUserData.fax = UtilSql.getValue(result, "fax");
        objectUserData.lastresult = UtilSql.getValue(result, "lastresult");
        objectUserData.lastcontact = UtilSql.getDateValue(result, "lastcontact", "dd-MM-yyyy");
        objectUserData.title = UtilSql.getValue(result, "title");
        objectUserData.cGreetingId = UtilSql.getValue(result, "c_greeting_id");
        objectUserData.firstname = UtilSql.getValue(result, "firstname");
        objectUserData.lastname = UtilSql.getValue(result, "lastname");
        objectUserData.emailuserpw = UtilSql.getValue(result, "emailuserpw");
        objectUserData.emailuser = UtilSql.getValue(result, "emailuser");
        objectUserData.processing = UtilSql.getValue(result, "processing");
        objectUserData.supervisorId = UtilSql.getValue(result, "supervisor_id");
        objectUserData.email = UtilSql.getValue(result, "email");
        objectUserData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectUserData.language = UtilSql.getValue(result, "language");
        objectUserData.adUserClient = "";
        objectUserData.adOrgClient = "";
        objectUserData.createdby = "";
        objectUserData.trBgcolor = "";
        objectUserData.totalCount = "";
        objectUserData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectUserData);
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
    UserData objectUserData[] = new UserData[vector.size()];
    vector.copyInto(objectUserData);
    return(objectUserData);
  }

/**
Create a registry
 */
  public static UserData[] set(String cBpartnerLocationId, String defaultAdOrgId, String emailuser, String emailuserpw, String isactive, String supervisorId, String firstname, String lastcontact, String defaultAdLanguage, String defaultAdRoleId, String birthday, String processing, String name, String adClientId, String adUserId, String defaultAdClientId, String username, String email, String adOrgId, String fax, String password, String defaultMWarehouseId, String cGreetingId, String title, String comments, String phone, String lastname, String updatedby, String updatedbyr, String adOrgtrxId, String description, String cBpartnerId, String lastresult, String createdby, String createdbyr, String phone2)    throws ServletException {
    UserData objectUserData[] = new UserData[1];
    objectUserData[0] = new UserData();
    objectUserData[0].created = "";
    objectUserData[0].createdbyr = createdbyr;
    objectUserData[0].updated = "";
    objectUserData[0].updatedTimeStamp = "";
    objectUserData[0].updatedby = updatedby;
    objectUserData[0].updatedbyr = updatedbyr;
    objectUserData[0].adClientId = adClientId;
    objectUserData[0].adClientIdr = "";
    objectUserData[0].adOrgId = adOrgId;
    objectUserData[0].adOrgIdr = "";
    objectUserData[0].name = name;
    objectUserData[0].description = description;
    objectUserData[0].comments = comments;
    objectUserData[0].isactive = isactive;
    objectUserData[0].cBpartnerId = cBpartnerId;
    objectUserData[0].cBpartnerIdr = "";
    objectUserData[0].username = username;
    objectUserData[0].password = password;
    objectUserData[0].adOrgtrxId = adOrgtrxId;
    objectUserData[0].defaultAdRoleId = defaultAdRoleId;
    objectUserData[0].defaultAdRoleIdr = "";
    objectUserData[0].defaultAdLanguage = defaultAdLanguage;
    objectUserData[0].defaultAdLanguager = "";
    objectUserData[0].defaultAdClientId = defaultAdClientId;
    objectUserData[0].defaultAdClientIdr = "";
    objectUserData[0].defaultAdOrgId = defaultAdOrgId;
    objectUserData[0].defaultAdOrgIdr = "";
    objectUserData[0].defaultMWarehouseId = defaultMWarehouseId;
    objectUserData[0].defaultMWarehouseIdr = "";
    objectUserData[0].phone2 = phone2;
    objectUserData[0].birthday = birthday;
    objectUserData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectUserData[0].phone = phone;
    objectUserData[0].fax = fax;
    objectUserData[0].lastresult = lastresult;
    objectUserData[0].lastcontact = lastcontact;
    objectUserData[0].title = title;
    objectUserData[0].cGreetingId = cGreetingId;
    objectUserData[0].firstname = firstname;
    objectUserData[0].lastname = lastname;
    objectUserData[0].emailuserpw = emailuserpw;
    objectUserData[0].emailuser = emailuser;
    objectUserData[0].processing = processing;
    objectUserData[0].supervisorId = supervisorId;
    objectUserData[0].email = email;
    objectUserData[0].adUserId = adUserId;
    objectUserData[0].language = "";
    return objectUserData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef626_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef624_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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

  public static int updatepassword(ConnectionProvider connectionProvider, String Password, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_User" +
      "        SET Password = ? " +
      "        WHERE AD_User.AD_User_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Password);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

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

  public static String checkpassword(ConnectionProvider connectionProvider, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) as total_count" +
      "          FROM AD_User" +
      "         WHERE AD_User.AD_User_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total_count");
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
      "        UPDATE AD_User" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , Name = (?) , Description = (?) , Comments = (?) , IsActive = (?) , C_BPartner_ID = (?) , UserName = (?) , AD_OrgTrx_ID = (?) , Default_Ad_Role_ID = (?) , Default_Ad_Language = (?) , Default_Ad_Client_ID = (?) , Default_Ad_Org_ID = (?) , Default_M_Warehouse_ID = (?) , Birthday = TO_DATE(?) , C_BPartner_Location_ID = (?) , Phone = (?) , Fax = (?) , LastResult = (?) , LastContact = TO_DATE(?) , Title = (?) , Phone2 = (?) , Firstname = (?) , Lastname = (?) , C_Greeting_ID = (?) , EmailUser = (?) , Processing = (?) , Supervisor_ID = (?) , Email = (?) , AD_User_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_User.AD_User_ID = ? " +
      "        AND AD_User.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_User.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, comments);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, username);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultMWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, birthday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastresult);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastcontact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, title);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGreetingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emailuser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, supervisorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
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
      "        INSERT INTO AD_User " +
      "        (AD_Client_ID, AD_Org_ID, Name, Description, Comments, IsActive, C_BPartner_ID, UserName, Password, AD_OrgTrx_ID, Default_Ad_Role_ID, Default_Ad_Language, Default_Ad_Client_ID, Default_Ad_Org_ID, Default_M_Warehouse_ID, Phone2, Birthday, C_BPartner_Location_ID, Phone, Fax, LastResult, LastContact, Title, C_Greeting_ID, Firstname, Lastname, EmailUserPW, EmailUser, Processing, Supervisor_ID, Email, AD_User_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, comments);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, username);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, password);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultMWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, birthday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastresult);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastcontact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, title);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGreetingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emailuserpw);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emailuser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, supervisorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
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
      "        DELETE FROM AD_User" +
      "        WHERE AD_User.AD_User_ID = ? " +
      "        AND AD_User.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_User.AD_Org_ID IN (";
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
      "        DELETE FROM AD_User" +
      "        WHERE AD_User.AD_User_ID = ? ";

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
      "          FROM AD_User" +
      "         WHERE AD_User.AD_User_ID = ? ";

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
      "          FROM AD_User" +
      "         WHERE AD_User.AD_User_ID = ? ";

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
