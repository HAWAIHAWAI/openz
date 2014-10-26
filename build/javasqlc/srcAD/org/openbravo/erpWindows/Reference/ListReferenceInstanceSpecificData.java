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
class ListReferenceInstanceSpecificData implements FieldProvider {
static Logger log4j = Logger.getLogger(ListReferenceInstanceSpecificData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adRefListinstanceId;
  public String adRefListId;
  public String adRefListIdr;
  public String adReferenceId;
  public String adReferenceIdr;
  public String adClientId;
  public String adOrgId;
  public String ishidden;
  public String value;
  public String isactive;
  public String name;
  public String seqno;
  public String isdefault;
  public String adWindowId;
  public String adWindowIdr;
  public String adTabId;
  public String adTabIdr;
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
    else if (fieldName.equalsIgnoreCase("ad_ref_listinstance_id") || fieldName.equals("adRefListinstanceId"))
      return adRefListinstanceId;
    else if (fieldName.equalsIgnoreCase("ad_ref_list_id") || fieldName.equals("adRefListId"))
      return adRefListId;
    else if (fieldName.equalsIgnoreCase("ad_ref_list_idr") || fieldName.equals("adRefListIdr"))
      return adRefListIdr;
    else if (fieldName.equalsIgnoreCase("ad_reference_id") || fieldName.equals("adReferenceId"))
      return adReferenceId;
    else if (fieldName.equalsIgnoreCase("ad_reference_idr") || fieldName.equals("adReferenceIdr"))
      return adReferenceIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ishidden"))
      return ishidden;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("ad_window_id") || fieldName.equals("adWindowId"))
      return adWindowId;
    else if (fieldName.equalsIgnoreCase("ad_window_idr") || fieldName.equals("adWindowIdr"))
      return adWindowIdr;
    else if (fieldName.equalsIgnoreCase("ad_tab_id") || fieldName.equals("adTabId"))
      return adTabId;
    else if (fieldName.equalsIgnoreCase("ad_tab_idr") || fieldName.equals("adTabIdr"))
      return adTabIdr;
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
  public static ListReferenceInstanceSpecificData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefListId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adRefListId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ListReferenceInstanceSpecificData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefListId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_ref_listinstance.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_listinstance.CreatedBy) as CreatedByR, " +
      "        to_char(ad_ref_listinstance.Updated, ?) as updated, " +
      "        to_char(ad_ref_listinstance.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_ref_listinstance.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_listinstance.UpdatedBy) as UpdatedByR," +
      "        ad_ref_listinstance.AD_Ref_Listinstance_ID, " +
      "ad_ref_listinstance.AD_Ref_List_ID, " +
      "(CASE WHEN ad_ref_listinstance.AD_Ref_List_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS AD_Ref_List_IDR, " +
      "ad_ref_listinstance.AD_Reference_ID, " +
      "(CASE WHEN ad_ref_listinstance.AD_Reference_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(list1.name),'') ) END) AS AD_Reference_IDR, " +
      "ad_ref_listinstance.AD_Client_ID, " +
      "ad_ref_listinstance.AD_Org_ID, " +
      "COALESCE(ad_ref_listinstance.Ishidden, 'N') AS Ishidden, " +
      "ad_ref_listinstance.Value, " +
      "COALESCE(ad_ref_listinstance.Isactive, 'N') AS Isactive, " +
      "ad_ref_listinstance.Name, " +
      "ad_ref_listinstance.Seqno, " +
      "COALESCE(ad_ref_listinstance.Isdefault, 'N') AS Isdefault, " +
      "ad_ref_listinstance.AD_Window_ID, " +
      "(CASE WHEN ad_ref_listinstance.AD_Window_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS AD_Window_IDR, " +
      "ad_ref_listinstance.AD_Tab_ID, " +
      "(CASE WHEN ad_ref_listinstance.AD_Tab_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS AD_Tab_IDR, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_ref_listinstance left join (select AD_Ref_List_ID, Name from AD_Ref_List) table1 on (ad_ref_listinstance.AD_Ref_List_ID = table1.AD_Ref_List_ID) left join (select AD_Ref_List_ID,AD_Language, Name from AD_Ref_List_TRL) tableTRL1 on (table1.AD_Ref_List_ID = tableTRL1.AD_Ref_List_ID and tableTRL1.AD_Language = ?)  left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table2 on (ad_ref_listinstance.AD_Reference_ID = table2.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL2 on (table2.AD_Reference_ID = tableTRL2.AD_Reference_ID and tableTRL2.AD_Language = ?)  left join ad_ref_list_v list1 on (table2.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  left join (select AD_Window_ID, Name from AD_Window) table3 on (ad_ref_listinstance.AD_Window_ID = table3.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL3 on (table3.AD_Window_ID = tableTRL3.AD_Window_ID and tableTRL3.AD_Language = ?)  left join (select AD_Tab_ID, Name, AD_Window_ID from AD_Tab) table4 on (ad_ref_listinstance.AD_Tab_ID = table4.AD_Tab_ID) left join (select AD_Tab_ID,AD_Language, Name from AD_Tab_TRL) tableTRL4 on (table4.AD_Tab_ID = tableTRL4.AD_Tab_ID and tableTRL4.AD_Language = ?)  left join (select AD_Window_ID, Name from AD_Window) table5 on (table4.AD_Window_ID = table5.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL5 on (table5.AD_Window_ID = tableTRL5.AD_Window_ID and tableTRL5.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adRefListId==null || adRefListId.equals(""))?"":"  AND ad_ref_listinstance.AD_Ref_List_ID = ?  ");
    strSql = strSql + 
      "        AND ad_ref_listinstance.AD_Ref_Listinstance_ID = ? " +
      "        AND ad_ref_listinstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_ref_listinstance.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (adRefListId != null && !(adRefListId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListId);
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
        ListReferenceInstanceSpecificData objectListReferenceInstanceSpecificData = new ListReferenceInstanceSpecificData();
        objectListReferenceInstanceSpecificData.created = UtilSql.getValue(result, "created");
        objectListReferenceInstanceSpecificData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectListReferenceInstanceSpecificData.updated = UtilSql.getValue(result, "updated");
        objectListReferenceInstanceSpecificData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectListReferenceInstanceSpecificData.updatedby = UtilSql.getValue(result, "updatedby");
        objectListReferenceInstanceSpecificData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectListReferenceInstanceSpecificData.adRefListinstanceId = UtilSql.getValue(result, "ad_ref_listinstance_id");
        objectListReferenceInstanceSpecificData.adRefListId = UtilSql.getValue(result, "ad_ref_list_id");
        objectListReferenceInstanceSpecificData.adRefListIdr = UtilSql.getValue(result, "ad_ref_list_idr");
        objectListReferenceInstanceSpecificData.adReferenceId = UtilSql.getValue(result, "ad_reference_id");
        objectListReferenceInstanceSpecificData.adReferenceIdr = UtilSql.getValue(result, "ad_reference_idr");
        objectListReferenceInstanceSpecificData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectListReferenceInstanceSpecificData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectListReferenceInstanceSpecificData.ishidden = UtilSql.getValue(result, "ishidden");
        objectListReferenceInstanceSpecificData.value = UtilSql.getValue(result, "value");
        objectListReferenceInstanceSpecificData.isactive = UtilSql.getValue(result, "isactive");
        objectListReferenceInstanceSpecificData.name = UtilSql.getValue(result, "name");
        objectListReferenceInstanceSpecificData.seqno = UtilSql.getValue(result, "seqno");
        objectListReferenceInstanceSpecificData.isdefault = UtilSql.getValue(result, "isdefault");
        objectListReferenceInstanceSpecificData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectListReferenceInstanceSpecificData.adWindowIdr = UtilSql.getValue(result, "ad_window_idr");
        objectListReferenceInstanceSpecificData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectListReferenceInstanceSpecificData.adTabIdr = UtilSql.getValue(result, "ad_tab_idr");
        objectListReferenceInstanceSpecificData.language = UtilSql.getValue(result, "language");
        objectListReferenceInstanceSpecificData.adUserClient = "";
        objectListReferenceInstanceSpecificData.adOrgClient = "";
        objectListReferenceInstanceSpecificData.createdby = "";
        objectListReferenceInstanceSpecificData.trBgcolor = "";
        objectListReferenceInstanceSpecificData.totalCount = "";
        objectListReferenceInstanceSpecificData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectListReferenceInstanceSpecificData);
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
    ListReferenceInstanceSpecificData objectListReferenceInstanceSpecificData[] = new ListReferenceInstanceSpecificData[vector.size()];
    vector.copyInto(objectListReferenceInstanceSpecificData);
    return(objectListReferenceInstanceSpecificData);
  }

/**
Create a registry
 */
  public static ListReferenceInstanceSpecificData[] set(String adRefListId, String updatedby, String updatedbyr, String seqno, String adClientId, String isactive, String adTabId, String adWindowId, String adRefListinstanceId, String name, String value, String adOrgId, String adReferenceId, String ishidden, String isdefault, String createdby, String createdbyr)    throws ServletException {
    ListReferenceInstanceSpecificData objectListReferenceInstanceSpecificData[] = new ListReferenceInstanceSpecificData[1];
    objectListReferenceInstanceSpecificData[0] = new ListReferenceInstanceSpecificData();
    objectListReferenceInstanceSpecificData[0].created = "";
    objectListReferenceInstanceSpecificData[0].createdbyr = createdbyr;
    objectListReferenceInstanceSpecificData[0].updated = "";
    objectListReferenceInstanceSpecificData[0].updatedTimeStamp = "";
    objectListReferenceInstanceSpecificData[0].updatedby = updatedby;
    objectListReferenceInstanceSpecificData[0].updatedbyr = updatedbyr;
    objectListReferenceInstanceSpecificData[0].adRefListinstanceId = adRefListinstanceId;
    objectListReferenceInstanceSpecificData[0].adRefListId = adRefListId;
    objectListReferenceInstanceSpecificData[0].adRefListIdr = "";
    objectListReferenceInstanceSpecificData[0].adReferenceId = adReferenceId;
    objectListReferenceInstanceSpecificData[0].adReferenceIdr = "";
    objectListReferenceInstanceSpecificData[0].adClientId = adClientId;
    objectListReferenceInstanceSpecificData[0].adOrgId = adOrgId;
    objectListReferenceInstanceSpecificData[0].ishidden = ishidden;
    objectListReferenceInstanceSpecificData[0].value = value;
    objectListReferenceInstanceSpecificData[0].isactive = isactive;
    objectListReferenceInstanceSpecificData[0].name = name;
    objectListReferenceInstanceSpecificData[0].seqno = seqno;
    objectListReferenceInstanceSpecificData[0].isdefault = isdefault;
    objectListReferenceInstanceSpecificData[0].adWindowId = adWindowId;
    objectListReferenceInstanceSpecificData[0].adWindowIdr = "";
    objectListReferenceInstanceSpecificData[0].adTabId = adTabId;
    objectListReferenceInstanceSpecificData[0].adTabIdr = "";
    objectListReferenceInstanceSpecificData[0].language = "";
    return objectListReferenceInstanceSpecificData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefAF3D277F70304A38964CAE2A24C8EC44_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef57AA0E1D92A94D2EA1FF8A19A2F689C9_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_ref_listinstance.AD_Ref_List_ID AS NAME" +
      "        FROM ad_ref_listinstance" +
      "        WHERE ad_ref_listinstance.AD_Ref_Listinstance_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adRefListId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM AD_Ref_List left join (select AD_Ref_List_ID, Name from AD_Ref_List) table1 on (AD_Ref_List.AD_Ref_List_ID = table1.AD_Ref_List_ID) left join (select AD_Ref_List_ID,AD_Language, Name from AD_Ref_List_TRL) tableTRL1 on (table1.AD_Ref_List_ID = tableTRL1.AD_Ref_List_ID and tableTRL1.AD_Language = ?)  WHERE AD_Ref_List.AD_Ref_List_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adRefListId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM AD_Ref_List left join (select AD_Ref_List_ID, Name from AD_Ref_List) table1 on (AD_Ref_List.AD_Ref_List_ID = table1.AD_Ref_List_ID) left join (select AD_Ref_List_ID,AD_Language, Name from AD_Ref_List_TRL) tableTRL1 on (table1.AD_Ref_List_ID = tableTRL1.AD_Ref_List_ID and tableTRL1.AD_Language = ?)  WHERE AD_Ref_List.AD_Ref_List_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListId);

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
      "        UPDATE ad_ref_listinstance" +
      "        SET AD_Ref_Listinstance_ID = (?) , AD_Ref_List_ID = (?) , AD_Reference_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Ishidden = (?) , Value = (?) , Isactive = (?) , Name = (?) , Seqno = TO_NUMBER(?) , Isdefault = (?) , AD_Window_ID = (?) , AD_Tab_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_ref_listinstance.AD_Ref_Listinstance_ID = ? " +
      "                 AND ad_ref_listinstance.AD_Ref_List_ID = ? " +
      "        AND ad_ref_listinstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_listinstance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ishidden);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListId);
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
      "        INSERT INTO ad_ref_listinstance " +
      "        (AD_Ref_Listinstance_ID, AD_Ref_List_ID, AD_Reference_ID, AD_Client_ID, AD_Org_ID, Ishidden, Value, Isactive, Name, Seqno, Isdefault, AD_Window_ID, AD_Tab_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ishidden);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adRefListId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_listinstance" +
      "        WHERE ad_ref_listinstance.AD_Ref_Listinstance_ID = ? " +
      "                 AND ad_ref_listinstance.AD_Ref_List_ID = ? " +
      "        AND ad_ref_listinstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_listinstance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adRefListId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_listinstance" +
      "        WHERE ad_ref_listinstance.AD_Ref_Listinstance_ID = ? " +
      "                 AND ad_ref_listinstance.AD_Ref_List_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListId);

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
      "          FROM ad_ref_listinstance" +
      "         WHERE ad_ref_listinstance.AD_Ref_Listinstance_ID = ? ";

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
      "          FROM ad_ref_listinstance" +
      "         WHERE ad_ref_listinstance.AD_Ref_Listinstance_ID = ? ";

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
