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
class FieldAccessData implements FieldProvider {
static Logger log4j = Logger.getLogger(FieldAccessData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adRoleTabaccessFieldId;
  public String adRoleTabaccessId;
  public String adRoleTabaccessIdr;
  public String adFieldId;
  public String adFieldIdr;
  public String visiblesetting;
  public String visiblesettingr;
  public String adClientId;
  public String adOrgId;
  public String editsetting;
  public String editsettingr;
  public String isactive;
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
    else if (fieldName.equalsIgnoreCase("ad_role_tabaccess_field_id") || fieldName.equals("adRoleTabaccessFieldId"))
      return adRoleTabaccessFieldId;
    else if (fieldName.equalsIgnoreCase("ad_role_tabaccess_id") || fieldName.equals("adRoleTabaccessId"))
      return adRoleTabaccessId;
    else if (fieldName.equalsIgnoreCase("ad_role_tabaccess_idr") || fieldName.equals("adRoleTabaccessIdr"))
      return adRoleTabaccessIdr;
    else if (fieldName.equalsIgnoreCase("ad_field_id") || fieldName.equals("adFieldId"))
      return adFieldId;
    else if (fieldName.equalsIgnoreCase("ad_field_idr") || fieldName.equals("adFieldIdr"))
      return adFieldIdr;
    else if (fieldName.equalsIgnoreCase("visiblesetting"))
      return visiblesetting;
    else if (fieldName.equalsIgnoreCase("visiblesettingr"))
      return visiblesettingr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("editsetting"))
      return editsetting;
    else if (fieldName.equalsIgnoreCase("editsettingr"))
      return editsettingr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
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
  public static FieldAccessData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRoleTabaccessId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adRoleTabaccessId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static FieldAccessData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRoleTabaccessId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_role_tabaccess_field.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_role_tabaccess_field.CreatedBy) as CreatedByR, " +
      "        to_char(ad_role_tabaccess_field.Updated, ?) as updated, " +
      "        to_char(ad_role_tabaccess_field.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_role_tabaccess_field.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_role_tabaccess_field.UpdatedBy) as UpdatedByR," +
      "        ad_role_tabaccess_field.AD_Role_Tabaccess_Field_ID, " +
      "ad_role_tabaccess_field.AD_Role_Tabaccess_ID, " +
      "(CASE WHEN ad_role_tabaccess_field.AD_Role_Tabaccess_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS AD_Role_Tabaccess_IDR, " +
      "ad_role_tabaccess_field.AD_Field_ID, " +
      "(CASE WHEN ad_role_tabaccess_field.AD_Field_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS AD_Field_IDR, " +
      "ad_role_tabaccess_field.Visiblesetting, " +
      "(CASE WHEN ad_role_tabaccess_field.Visiblesetting IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS VisiblesettingR, " +
      "ad_role_tabaccess_field.AD_Client_ID, " +
      "ad_role_tabaccess_field.AD_Org_ID, " +
      "ad_role_tabaccess_field.Editsetting, " +
      "(CASE WHEN ad_role_tabaccess_field.Editsetting IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS EditsettingR, " +
      "COALESCE(ad_role_tabaccess_field.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_role_tabaccess_field left join (select AD_Role_Tabaccess_ID, AD_Role_ID, AD_Tab_ID from AD_Role_Tabaccess) table1 on (ad_role_tabaccess_field.AD_Role_Tabaccess_ID = table1.AD_Role_Tabaccess_ID) left join (select AD_Role_ID, Name from AD_Role) table2 on (table1.AD_Role_ID = table2.AD_Role_ID) left join (select AD_Tab_ID, Name, AD_Window_ID from AD_Tab) table3 on (table1.AD_Tab_ID = table3.AD_Tab_ID) left join (select AD_Tab_ID,AD_Language, Name from AD_Tab_TRL) tableTRL3 on (table3.AD_Tab_ID = tableTRL3.AD_Tab_ID and tableTRL3.AD_Language = ?)  left join (select AD_Window_ID, Name from AD_Window) table4 on (table3.AD_Window_ID = table4.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL4 on (table4.AD_Window_ID = tableTRL4.AD_Window_ID and tableTRL4.AD_Language = ?)  left join (select AD_Field_ID, Name from AD_Field) table5 on (ad_role_tabaccess_field.AD_Field_ID = table5.AD_Field_ID) left join (select AD_Field_ID,AD_Language, Name from AD_Field_TRL) tableTRL5 on (table5.AD_Field_ID = tableTRL5.AD_Field_ID and tableTRL5.AD_Language = ?)  left join ad_ref_list_v list1 on (ad_role_tabaccess_field.Visiblesetting = list1.value and list1.ad_reference_id = 'A4801B9D7ADB4BB69EBF727B71C8AB45' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (ad_role_tabaccess_field.Editsetting = list2.value and list2.ad_reference_id = '0765914076274AD79BACA01E75F4D0A1' and list2.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adRoleTabaccessId==null || adRoleTabaccessId.equals(""))?"":"  AND ad_role_tabaccess_field.AD_Role_Tabaccess_ID = ?  ");
    strSql = strSql + 
      "        AND ad_role_tabaccess_field.AD_Role_Tabaccess_Field_ID = ? " +
      "        AND ad_role_tabaccess_field.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_role_tabaccess_field.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (adRoleTabaccessId != null && !(adRoleTabaccessId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleTabaccessId);
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
        FieldAccessData objectFieldAccessData = new FieldAccessData();
        objectFieldAccessData.created = UtilSql.getValue(result, "created");
        objectFieldAccessData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectFieldAccessData.updated = UtilSql.getValue(result, "updated");
        objectFieldAccessData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectFieldAccessData.updatedby = UtilSql.getValue(result, "updatedby");
        objectFieldAccessData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectFieldAccessData.adRoleTabaccessFieldId = UtilSql.getValue(result, "ad_role_tabaccess_field_id");
        objectFieldAccessData.adRoleTabaccessId = UtilSql.getValue(result, "ad_role_tabaccess_id");
        objectFieldAccessData.adRoleTabaccessIdr = UtilSql.getValue(result, "ad_role_tabaccess_idr");
        objectFieldAccessData.adFieldId = UtilSql.getValue(result, "ad_field_id");
        objectFieldAccessData.adFieldIdr = UtilSql.getValue(result, "ad_field_idr");
        objectFieldAccessData.visiblesetting = UtilSql.getValue(result, "visiblesetting");
        objectFieldAccessData.visiblesettingr = UtilSql.getValue(result, "visiblesettingr");
        objectFieldAccessData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectFieldAccessData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectFieldAccessData.editsetting = UtilSql.getValue(result, "editsetting");
        objectFieldAccessData.editsettingr = UtilSql.getValue(result, "editsettingr");
        objectFieldAccessData.isactive = UtilSql.getValue(result, "isactive");
        objectFieldAccessData.language = UtilSql.getValue(result, "language");
        objectFieldAccessData.adUserClient = "";
        objectFieldAccessData.adOrgClient = "";
        objectFieldAccessData.createdby = "";
        objectFieldAccessData.trBgcolor = "";
        objectFieldAccessData.totalCount = "";
        objectFieldAccessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFieldAccessData);
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
    FieldAccessData objectFieldAccessData[] = new FieldAccessData[vector.size()];
    vector.copyInto(objectFieldAccessData);
    return(objectFieldAccessData);
  }

/**
Create a registry
 */
  public static FieldAccessData[] set(String adRoleTabaccessId, String visiblesetting, String adFieldId, String isactive, String adOrgId, String createdby, String createdbyr, String editsetting, String adClientId, String adRoleTabaccessFieldId, String updatedby, String updatedbyr)    throws ServletException {
    FieldAccessData objectFieldAccessData[] = new FieldAccessData[1];
    objectFieldAccessData[0] = new FieldAccessData();
    objectFieldAccessData[0].created = "";
    objectFieldAccessData[0].createdbyr = createdbyr;
    objectFieldAccessData[0].updated = "";
    objectFieldAccessData[0].updatedTimeStamp = "";
    objectFieldAccessData[0].updatedby = updatedby;
    objectFieldAccessData[0].updatedbyr = updatedbyr;
    objectFieldAccessData[0].adRoleTabaccessFieldId = adRoleTabaccessFieldId;
    objectFieldAccessData[0].adRoleTabaccessId = adRoleTabaccessId;
    objectFieldAccessData[0].adRoleTabaccessIdr = "";
    objectFieldAccessData[0].adFieldId = adFieldId;
    objectFieldAccessData[0].adFieldIdr = "";
    objectFieldAccessData[0].visiblesetting = visiblesetting;
    objectFieldAccessData[0].visiblesettingr = "";
    objectFieldAccessData[0].adClientId = adClientId;
    objectFieldAccessData[0].adOrgId = adOrgId;
    objectFieldAccessData[0].editsetting = editsetting;
    objectFieldAccessData[0].editsettingr = "";
    objectFieldAccessData[0].isactive = isactive;
    objectFieldAccessData[0].language = "";
    return objectFieldAccessData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef5251F982A2B146C19BE0BF179832E12C_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef0F12DBCD4B074E959782DFEBA870692D_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_role_tabaccess_field.AD_Role_Tabaccess_ID AS NAME" +
      "        FROM ad_role_tabaccess_field" +
      "        WHERE ad_role_tabaccess_field.AD_Role_Tabaccess_Field_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adRoleTabaccessId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))) AS NAME FROM ad_role_tabaccess left join (select AD_Role_Tabaccess_ID, AD_Role_ID, AD_Tab_ID from AD_Role_Tabaccess) table1 on (ad_role_tabaccess.AD_Role_Tabaccess_ID = table1.AD_Role_Tabaccess_ID) left join (select AD_Role_ID, Name from AD_Role) table2 on (table1.AD_Role_ID = table2.AD_Role_ID) left join (select AD_Tab_ID, Name, AD_Window_ID from AD_Tab) table3 on (table1.AD_Tab_ID = table3.AD_Tab_ID) left join (select AD_Tab_ID,AD_Language, Name from AD_Tab_TRL) tableTRL3 on (table3.AD_Tab_ID = tableTRL3.AD_Tab_ID and tableTRL3.AD_Language = ?)  left join (select AD_Window_ID, Name from AD_Window) table4 on (table3.AD_Window_ID = table4.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL4 on (table4.AD_Window_ID = tableTRL4.AD_Window_ID and tableTRL4.AD_Language = ?)  WHERE ad_role_tabaccess.AD_Role_Tabaccess_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleTabaccessId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adRoleTabaccessId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))) AS NAME FROM ad_role_tabaccess left join (select AD_Role_Tabaccess_ID, AD_Role_ID, AD_Tab_ID from AD_Role_Tabaccess) table1 on (ad_role_tabaccess.AD_Role_Tabaccess_ID = table1.AD_Role_Tabaccess_ID) left join (select AD_Role_ID, Name from AD_Role) table2 on (table1.AD_Role_ID = table2.AD_Role_ID) left join (select AD_Tab_ID, Name, AD_Window_ID from AD_Tab) table3 on (table1.AD_Tab_ID = table3.AD_Tab_ID) left join (select AD_Tab_ID,AD_Language, Name from AD_Tab_TRL) tableTRL3 on (table3.AD_Tab_ID = tableTRL3.AD_Tab_ID and tableTRL3.AD_Language = ?)  left join (select AD_Window_ID, Name from AD_Window) table4 on (table3.AD_Window_ID = table4.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL4 on (table4.AD_Window_ID = tableTRL4.AD_Window_ID and tableTRL4.AD_Language = ?)  WHERE ad_role_tabaccess.AD_Role_Tabaccess_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleTabaccessId);

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
      "        UPDATE ad_role_tabaccess_field" +
      "        SET AD_Role_Tabaccess_Field_ID = (?) , AD_Role_Tabaccess_ID = (?) , AD_Field_ID = (?) , Visiblesetting = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Editsetting = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_role_tabaccess_field.AD_Role_Tabaccess_Field_ID = ? " +
      "                 AND ad_role_tabaccess_field.AD_Role_Tabaccess_ID = ? " +
      "        AND ad_role_tabaccess_field.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_role_tabaccess_field.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleTabaccessFieldId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleTabaccessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, visiblesetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, editsetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleTabaccessFieldId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleTabaccessId);
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
      "        INSERT INTO ad_role_tabaccess_field " +
      "        (AD_Role_Tabaccess_Field_ID, AD_Role_Tabaccess_ID, AD_Field_ID, Visiblesetting, AD_Client_ID, AD_Org_ID, Editsetting, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleTabaccessFieldId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleTabaccessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, visiblesetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, editsetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adRoleTabaccessId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_role_tabaccess_field" +
      "        WHERE ad_role_tabaccess_field.AD_Role_Tabaccess_Field_ID = ? " +
      "                 AND ad_role_tabaccess_field.AD_Role_Tabaccess_ID = ? " +
      "        AND ad_role_tabaccess_field.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_role_tabaccess_field.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleTabaccessId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adRoleTabaccessId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_role_tabaccess_field" +
      "        WHERE ad_role_tabaccess_field.AD_Role_Tabaccess_Field_ID = ? " +
      "                 AND ad_role_tabaccess_field.AD_Role_Tabaccess_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleTabaccessId);

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
      "          FROM ad_role_tabaccess_field" +
      "         WHERE ad_role_tabaccess_field.AD_Role_Tabaccess_Field_ID = ? ";

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
      "          FROM ad_role_tabaccess_field" +
      "         WHERE ad_role_tabaccess_field.AD_Role_Tabaccess_Field_ID = ? ";

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
