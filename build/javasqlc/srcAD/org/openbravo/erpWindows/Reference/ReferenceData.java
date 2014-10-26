//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Reference;

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
class ReferenceData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReferenceData.class);
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
  public String adModuleId;
  public String adModuleIdr;
  public String name;
  public String description;
  public String help;
  public String isactive;
  public String validationtype;
  public String validationtyper;
  public String showinfomenu;
  public String vformat;
  public String popupsmallicon;
  public String popupbigicon;
  public String columns;
  public String detailsidfield;
  public String isuserdefinablelist;
  public String adReferenceId;
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
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
    else if (fieldName.equalsIgnoreCase("ad_module_idr") || fieldName.equals("adModuleIdr"))
      return adModuleIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("validationtype"))
      return validationtype;
    else if (fieldName.equalsIgnoreCase("validationtyper"))
      return validationtyper;
    else if (fieldName.equalsIgnoreCase("showinfomenu"))
      return showinfomenu;
    else if (fieldName.equalsIgnoreCase("vformat"))
      return vformat;
    else if (fieldName.equalsIgnoreCase("popupsmallicon"))
      return popupsmallicon;
    else if (fieldName.equalsIgnoreCase("popupbigicon"))
      return popupbigicon;
    else if (fieldName.equalsIgnoreCase("columns"))
      return columns;
    else if (fieldName.equalsIgnoreCase("detailsidfield"))
      return detailsidfield;
    else if (fieldName.equalsIgnoreCase("isuserdefinablelist"))
      return isuserdefinablelist;
    else if (fieldName.equalsIgnoreCase("ad_reference_id") || fieldName.equals("adReferenceId"))
      return adReferenceId;
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
  public static ReferenceData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ReferenceData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Reference.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Reference.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Reference.Updated, ?) as updated, " +
      "        to_char(AD_Reference.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Reference.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Reference.UpdatedBy) as UpdatedByR," +
      "        AD_Reference.AD_Client_ID, " +
      "(CASE WHEN AD_Reference.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Reference.AD_Org_ID, " +
      "(CASE WHEN AD_Reference.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_Reference.AD_Module_ID, " +
      "(CASE WHEN AD_Reference.AD_Module_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Version), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_Module_IDR, " +
      "AD_Reference.Name, " +
      "AD_Reference.Description, " +
      "AD_Reference.Help, " +
      "COALESCE(AD_Reference.IsActive, 'N') AS IsActive, " +
      "AD_Reference.ValidationType, " +
      "(CASE WHEN AD_Reference.ValidationType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ValidationTypeR, " +
      "COALESCE(AD_Reference.Showinfomenu, 'N') AS Showinfomenu, " +
      "AD_Reference.VFormat, " +
      "AD_Reference.Popupsmallicon, " +
      "AD_Reference.Popupbigicon, " +
      "AD_Reference.Columns, " +
      "AD_Reference.Detailsidfield, " +
      "COALESCE(AD_Reference.Isuserdefinablelist, 'N') AS Isuserdefinablelist, " +
      "AD_Reference.AD_Reference_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Reference left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Reference.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_Reference.AD_Org_ID = table2.AD_Org_ID) left join (select AD_Module_ID, Name, Version, AD_Language from AD_Module) table3 on (AD_Reference.AD_Module_ID = table3.AD_Module_ID) left join (select AD_Language, Name from AD_Language) table4 on (table3.AD_Language =  table4.AD_Language) left join ad_ref_list_v list1 on (AD_Reference.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND AD_Reference.AD_Reference_ID = ? " +
      "        AND AD_Reference.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Reference.AD_Org_ID IN (";
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
        ReferenceData objectReferenceData = new ReferenceData();
        objectReferenceData.created = UtilSql.getValue(result, "created");
        objectReferenceData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectReferenceData.updated = UtilSql.getValue(result, "updated");
        objectReferenceData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectReferenceData.updatedby = UtilSql.getValue(result, "updatedby");
        objectReferenceData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectReferenceData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectReferenceData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectReferenceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReferenceData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectReferenceData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectReferenceData.adModuleIdr = UtilSql.getValue(result, "ad_module_idr");
        objectReferenceData.name = UtilSql.getValue(result, "name");
        objectReferenceData.description = UtilSql.getValue(result, "description");
        objectReferenceData.help = UtilSql.getValue(result, "help");
        objectReferenceData.isactive = UtilSql.getValue(result, "isactive");
        objectReferenceData.validationtype = UtilSql.getValue(result, "validationtype");
        objectReferenceData.validationtyper = UtilSql.getValue(result, "validationtyper");
        objectReferenceData.showinfomenu = UtilSql.getValue(result, "showinfomenu");
        objectReferenceData.vformat = UtilSql.getValue(result, "vformat");
        objectReferenceData.popupsmallicon = UtilSql.getValue(result, "popupsmallicon");
        objectReferenceData.popupbigicon = UtilSql.getValue(result, "popupbigicon");
        objectReferenceData.columns = UtilSql.getValue(result, "columns");
        objectReferenceData.detailsidfield = UtilSql.getValue(result, "detailsidfield");
        objectReferenceData.isuserdefinablelist = UtilSql.getValue(result, "isuserdefinablelist");
        objectReferenceData.adReferenceId = UtilSql.getValue(result, "ad_reference_id");
        objectReferenceData.language = UtilSql.getValue(result, "language");
        objectReferenceData.adUserClient = "";
        objectReferenceData.adOrgClient = "";
        objectReferenceData.createdby = "";
        objectReferenceData.trBgcolor = "";
        objectReferenceData.totalCount = "";
        objectReferenceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReferenceData);
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
    ReferenceData objectReferenceData[] = new ReferenceData[vector.size()];
    vector.copyInto(objectReferenceData);
    return(objectReferenceData);
  }

/**
Create a registry
 */
  public static ReferenceData[] set(String detailsidfield, String adReferenceId, String validationtype, String isactive, String description, String help, String columns, String vformat, String createdby, String createdbyr, String updatedby, String updatedbyr, String adClientId, String adModuleId, String adOrgId, String popupbigicon, String showinfomenu, String isuserdefinablelist, String popupsmallicon, String name)    throws ServletException {
    ReferenceData objectReferenceData[] = new ReferenceData[1];
    objectReferenceData[0] = new ReferenceData();
    objectReferenceData[0].created = "";
    objectReferenceData[0].createdbyr = createdbyr;
    objectReferenceData[0].updated = "";
    objectReferenceData[0].updatedTimeStamp = "";
    objectReferenceData[0].updatedby = updatedby;
    objectReferenceData[0].updatedbyr = updatedbyr;
    objectReferenceData[0].adClientId = adClientId;
    objectReferenceData[0].adClientIdr = "";
    objectReferenceData[0].adOrgId = adOrgId;
    objectReferenceData[0].adOrgIdr = "";
    objectReferenceData[0].adModuleId = adModuleId;
    objectReferenceData[0].adModuleIdr = "";
    objectReferenceData[0].name = name;
    objectReferenceData[0].description = description;
    objectReferenceData[0].help = help;
    objectReferenceData[0].isactive = isactive;
    objectReferenceData[0].validationtype = validationtype;
    objectReferenceData[0].validationtyper = "";
    objectReferenceData[0].showinfomenu = showinfomenu;
    objectReferenceData[0].vformat = vformat;
    objectReferenceData[0].popupsmallicon = popupsmallicon;
    objectReferenceData[0].popupbigicon = popupbigicon;
    objectReferenceData[0].columns = columns;
    objectReferenceData[0].detailsidfield = detailsidfield;
    objectReferenceData[0].isuserdefinablelist = isuserdefinablelist;
    objectReferenceData[0].adReferenceId = adReferenceId;
    objectReferenceData[0].language = "";
    return objectReferenceData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef555_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef557_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef5661DEEC430FFC21E040007F01004C04(ConnectionProvider connectionProvider)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_Reference" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , AD_Module_ID = (?) , Name = (?) , Description = (?) , Help = (?) , IsActive = (?) , ValidationType = (?) , Showinfomenu = (?) , VFormat = (?) , Popupsmallicon = (?) , Popupbigicon = (?) , Columns = TO_NUMBER(?) , Detailsidfield = (?) , Isuserdefinablelist = (?) , AD_Reference_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Reference.AD_Reference_ID = ? " +
      "        AND AD_Reference.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Reference.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validationtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showinfomenu);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, popupsmallicon);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, popupbigicon);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, columns);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, detailsidfield);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isuserdefinablelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
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
      "        INSERT INTO AD_Reference " +
      "        (AD_Client_ID, AD_Org_ID, AD_Module_ID, Name, Description, Help, IsActive, ValidationType, Showinfomenu, VFormat, Popupsmallicon, Popupbigicon, Columns, Detailsidfield, Isuserdefinablelist, AD_Reference_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validationtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showinfomenu);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, popupsmallicon);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, popupbigicon);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, columns);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, detailsidfield);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isuserdefinablelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
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
      "        DELETE FROM AD_Reference" +
      "        WHERE AD_Reference.AD_Reference_ID = ? " +
      "        AND AD_Reference.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Reference.AD_Org_ID IN (";
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
      "        DELETE FROM AD_Reference" +
      "        WHERE AD_Reference.AD_Reference_ID = ? ";

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
      "          FROM AD_Reference" +
      "         WHERE AD_Reference.AD_Reference_ID = ? ";

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
      "          FROM AD_Reference" +
      "         WHERE AD_Reference.AD_Reference_ID = ? ";

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
