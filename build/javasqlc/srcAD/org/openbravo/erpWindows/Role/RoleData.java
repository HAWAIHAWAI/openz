//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Role;

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
class RoleData implements FieldProvider {
static Logger log4j = Logger.getLogger(RoleData.class);
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
  public String isactive;
  public String userlevel;
  public String userlevelr;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String amtapproval;
  public String adTreeMenuId;
  public String adTreeMenuIdr;
  public String theme;
  public String themer;
  public String btnGeneraterole;
  public String processing;
  public String orglist;
  public String ismanual;
  public String clientlist;
  public String adRoleId;
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
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("userlevel"))
      return userlevel;
    else if (fieldName.equalsIgnoreCase("userlevelr"))
      return userlevelr;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("amtapproval"))
      return amtapproval;
    else if (fieldName.equalsIgnoreCase("ad_tree_menu_id") || fieldName.equals("adTreeMenuId"))
      return adTreeMenuId;
    else if (fieldName.equalsIgnoreCase("ad_tree_menu_idr") || fieldName.equals("adTreeMenuIdr"))
      return adTreeMenuIdr;
    else if (fieldName.equalsIgnoreCase("theme"))
      return theme;
    else if (fieldName.equalsIgnoreCase("themer"))
      return themer;
    else if (fieldName.equalsIgnoreCase("btn_generaterole") || fieldName.equals("btnGeneraterole"))
      return btnGeneraterole;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("orglist"))
      return orglist;
    else if (fieldName.equalsIgnoreCase("ismanual"))
      return ismanual;
    else if (fieldName.equalsIgnoreCase("clientlist"))
      return clientlist;
    else if (fieldName.equalsIgnoreCase("ad_role_id") || fieldName.equals("adRoleId"))
      return adRoleId;
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
  public static RoleData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static RoleData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Role.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Role.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Role.Updated, ?) as updated, " +
      "        to_char(AD_Role.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Role.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Role.UpdatedBy) as UpdatedByR," +
      "        AD_Role.AD_Client_ID, " +
      "(CASE WHEN AD_Role.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Role.AD_Org_ID, " +
      "(CASE WHEN AD_Role.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_Role.Name, " +
      "AD_Role.Description, " +
      "COALESCE(AD_Role.IsActive, 'N') AS IsActive, " +
      "AD_Role.UserLevel, " +
      "(CASE WHEN AD_Role.UserLevel IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS UserLevelR, " +
      "AD_Role.C_Currency_ID, " +
      "(CASE WHEN AD_Role.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "AD_Role.AmtApproval, " +
      "AD_Role.AD_Tree_Menu_ID, " +
      "(CASE WHEN AD_Role.AD_Tree_Menu_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_Tree_Menu_IDR, " +
      "AD_Role.Theme, " +
      "(CASE WHEN AD_Role.Theme IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS ThemeR, " +
      "AD_Role.btn_GenerateRole, " +
      "AD_Role.Processing, " +
      "AD_Role.OrgList, " +
      "COALESCE(AD_Role.IsManual, 'N') AS IsManual, " +
      "AD_Role.ClientList, " +
      "AD_Role.AD_Role_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Role left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Role.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_Role.AD_Org_ID = table2.AD_Org_ID) left join ad_ref_list_v list1 on (AD_Role.UserLevel = list1.value and list1.ad_reference_id = '226' and list1.ad_language = ?)  left join (select C_Currency_ID, ISO_Code from C_Currency) table3 on (AD_Role.C_Currency_ID = table3.C_Currency_ID) left join (select AD_Tree_ID, Name from AD_Tree) table4 on (AD_Role.AD_Tree_Menu_ID =  table4.AD_Tree_ID) left join ad_ref_list_v list2 on (AD_Role.Theme = list2.value and list2.ad_reference_id = '800102' and list2.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND AD_Role.AD_Role_ID = ? " +
      "        AND AD_Role.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Role.AD_Org_ID IN (";
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
        RoleData objectRoleData = new RoleData();
        objectRoleData.created = UtilSql.getValue(result, "created");
        objectRoleData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectRoleData.updated = UtilSql.getValue(result, "updated");
        objectRoleData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectRoleData.updatedby = UtilSql.getValue(result, "updatedby");
        objectRoleData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectRoleData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectRoleData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectRoleData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectRoleData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectRoleData.name = UtilSql.getValue(result, "name");
        objectRoleData.description = UtilSql.getValue(result, "description");
        objectRoleData.isactive = UtilSql.getValue(result, "isactive");
        objectRoleData.userlevel = UtilSql.getValue(result, "userlevel");
        objectRoleData.userlevelr = UtilSql.getValue(result, "userlevelr");
        objectRoleData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectRoleData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectRoleData.amtapproval = UtilSql.getValue(result, "amtapproval");
        objectRoleData.adTreeMenuId = UtilSql.getValue(result, "ad_tree_menu_id");
        objectRoleData.adTreeMenuIdr = UtilSql.getValue(result, "ad_tree_menu_idr");
        objectRoleData.theme = UtilSql.getValue(result, "theme");
        objectRoleData.themer = UtilSql.getValue(result, "themer");
        objectRoleData.btnGeneraterole = UtilSql.getValue(result, "btn_generaterole");
        objectRoleData.processing = UtilSql.getValue(result, "processing");
        objectRoleData.orglist = UtilSql.getValue(result, "orglist");
        objectRoleData.ismanual = UtilSql.getValue(result, "ismanual");
        objectRoleData.clientlist = UtilSql.getValue(result, "clientlist");
        objectRoleData.adRoleId = UtilSql.getValue(result, "ad_role_id");
        objectRoleData.language = UtilSql.getValue(result, "language");
        objectRoleData.adUserClient = "";
        objectRoleData.adOrgClient = "";
        objectRoleData.createdby = "";
        objectRoleData.trBgcolor = "";
        objectRoleData.totalCount = "";
        objectRoleData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRoleData);
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
    RoleData objectRoleData[] = new RoleData[vector.size()];
    vector.copyInto(objectRoleData);
    return(objectRoleData);
  }

/**
Create a registry
 */
  public static RoleData[] set(String userlevel, String ismanual, String createdby, String createdbyr, String adClientId, String adOrgId, String theme, String orglist, String amtapproval, String name, String description, String isactive, String clientlist, String btnGeneraterole, String updatedby, String updatedbyr, String processing, String adRoleId, String cCurrencyId, String adTreeMenuId)    throws ServletException {
    RoleData objectRoleData[] = new RoleData[1];
    objectRoleData[0] = new RoleData();
    objectRoleData[0].created = "";
    objectRoleData[0].createdbyr = createdbyr;
    objectRoleData[0].updated = "";
    objectRoleData[0].updatedTimeStamp = "";
    objectRoleData[0].updatedby = updatedby;
    objectRoleData[0].updatedbyr = updatedbyr;
    objectRoleData[0].adClientId = adClientId;
    objectRoleData[0].adClientIdr = "";
    objectRoleData[0].adOrgId = adOrgId;
    objectRoleData[0].adOrgIdr = "";
    objectRoleData[0].name = name;
    objectRoleData[0].description = description;
    objectRoleData[0].isactive = isactive;
    objectRoleData[0].userlevel = userlevel;
    objectRoleData[0].userlevelr = "";
    objectRoleData[0].cCurrencyId = cCurrencyId;
    objectRoleData[0].cCurrencyIdr = "";
    objectRoleData[0].amtapproval = amtapproval;
    objectRoleData[0].adTreeMenuId = adTreeMenuId;
    objectRoleData[0].adTreeMenuIdr = "";
    objectRoleData[0].theme = theme;
    objectRoleData[0].themer = "";
    objectRoleData[0].btnGeneraterole = btnGeneraterole;
    objectRoleData[0].processing = processing;
    objectRoleData[0].orglist = orglist;
    objectRoleData[0].ismanual = ismanual;
    objectRoleData[0].clientlist = clientlist;
    objectRoleData[0].adRoleId = adRoleId;
    objectRoleData[0].language = "";
    return objectRoleData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef718_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef720_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
      "        UPDATE AD_Role" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , Name = (?) , Description = (?) , IsActive = (?) , UserLevel = (?) , C_Currency_ID = (?) , AmtApproval = TO_NUMBER(?) , AD_Tree_Menu_ID = (?) , Theme = (?) , btn_GenerateRole = (?) , Processing = (?) , OrgList = (?) , IsManual = (?) , ClientList = (?) , AD_Role_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Role.AD_Role_ID = ? " +
      "        AND AD_Role.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Role.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userlevel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtapproval);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeMenuId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, theme);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, btnGeneraterole);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orglist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismanual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientlist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
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
      "        INSERT INTO AD_Role " +
      "        (AD_Client_ID, AD_Org_ID, Name, Description, IsActive, UserLevel, C_Currency_ID, AmtApproval, AD_Tree_Menu_ID, Theme, btn_GenerateRole, Processing, OrgList, IsManual, ClientList, AD_Role_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userlevel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtapproval);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeMenuId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, theme);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, btnGeneraterole);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orglist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismanual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientlist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
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
      "        DELETE FROM AD_Role" +
      "        WHERE AD_Role.AD_Role_ID = ? " +
      "        AND AD_Role.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Role.AD_Org_ID IN (";
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
      "        DELETE FROM AD_Role" +
      "        WHERE AD_Role.AD_Role_ID = ? ";

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
      "          FROM AD_Role" +
      "         WHERE AD_Role.AD_Role_ID = ? ";

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
      "          FROM AD_Role" +
      "         WHERE AD_Role.AD_Role_ID = ? ";

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
