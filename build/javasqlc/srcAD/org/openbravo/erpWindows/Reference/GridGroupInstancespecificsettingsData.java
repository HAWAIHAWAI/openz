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
class GridGroupInstancespecificsettingsData implements FieldProvider {
static Logger log4j = Logger.getLogger(GridGroupInstancespecificsettingsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adRefGroupinstanceId;
  public String adRefGroupId;
  public String adRefGroupIdr;
  public String line;
  public String adClientId;
  public String isautoheader;
  public String adOrgId;
  public String hasselectline;
  public String hasselectliner;
  public String hasselectallbelow;
  public String hasselectallbelowr;
  public String hasevenodd;
  public String hasevenoddr;
  public String hasexpander;
  public String hasexpanderr;
  public String headerformatbold;
  public String headerformatboldr;
  public String colsvisibleoninit;
  public String colsvisibleoninitr;
  public String leadingemptycols;
  public String level;
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
    else if (fieldName.equalsIgnoreCase("ad_ref_groupinstance_id") || fieldName.equals("adRefGroupinstanceId"))
      return adRefGroupinstanceId;
    else if (fieldName.equalsIgnoreCase("ad_ref_group_id") || fieldName.equals("adRefGroupId"))
      return adRefGroupId;
    else if (fieldName.equalsIgnoreCase("ad_ref_group_idr") || fieldName.equals("adRefGroupIdr"))
      return adRefGroupIdr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("isautoheader"))
      return isautoheader;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("hasselectline"))
      return hasselectline;
    else if (fieldName.equalsIgnoreCase("hasselectliner"))
      return hasselectliner;
    else if (fieldName.equalsIgnoreCase("hasselectallbelow"))
      return hasselectallbelow;
    else if (fieldName.equalsIgnoreCase("hasselectallbelowr"))
      return hasselectallbelowr;
    else if (fieldName.equalsIgnoreCase("hasevenodd"))
      return hasevenodd;
    else if (fieldName.equalsIgnoreCase("hasevenoddr"))
      return hasevenoddr;
    else if (fieldName.equalsIgnoreCase("hasexpander"))
      return hasexpander;
    else if (fieldName.equalsIgnoreCase("hasexpanderr"))
      return hasexpanderr;
    else if (fieldName.equalsIgnoreCase("headerformatbold"))
      return headerformatbold;
    else if (fieldName.equalsIgnoreCase("headerformatboldr"))
      return headerformatboldr;
    else if (fieldName.equalsIgnoreCase("colsvisibleoninit"))
      return colsvisibleoninit;
    else if (fieldName.equalsIgnoreCase("colsvisibleoninitr"))
      return colsvisibleoninitr;
    else if (fieldName.equalsIgnoreCase("leadingemptycols"))
      return leadingemptycols;
    else if (fieldName.equalsIgnoreCase("level"))
      return level;
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
  public static GridGroupInstancespecificsettingsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefGroupId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adRefGroupId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static GridGroupInstancespecificsettingsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefGroupId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_ref_groupinstance.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_groupinstance.CreatedBy) as CreatedByR, " +
      "        to_char(ad_ref_groupinstance.Updated, ?) as updated, " +
      "        to_char(ad_ref_groupinstance.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_ref_groupinstance.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_groupinstance.UpdatedBy) as UpdatedByR," +
      "        ad_ref_groupinstance.AD_Ref_Groupinstance_ID, " +
      "ad_ref_groupinstance.AD_Ref_Group_ID, " +
      "(CASE WHEN ad_ref_groupinstance.AD_Ref_Group_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(list1.name),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Idcolumn), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Level), ''))),'') ) END) AS AD_Ref_Group_IDR, " +
      "ad_ref_groupinstance.Line, " +
      "ad_ref_groupinstance.AD_Client_ID, " +
      "COALESCE(ad_ref_groupinstance.Isautoheader, 'N') AS Isautoheader, " +
      "ad_ref_groupinstance.AD_Org_ID, " +
      "ad_ref_groupinstance.Hasselectline, " +
      "(CASE WHEN ad_ref_groupinstance.Hasselectline IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS HasselectlineR, " +
      "ad_ref_groupinstance.Hasselectallbelow, " +
      "(CASE WHEN ad_ref_groupinstance.Hasselectallbelow IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS HasselectallbelowR, " +
      "ad_ref_groupinstance.Hasevenodd, " +
      "(CASE WHEN ad_ref_groupinstance.Hasevenodd IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS HasevenoddR, " +
      "ad_ref_groupinstance.Hasexpander, " +
      "(CASE WHEN ad_ref_groupinstance.Hasexpander IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list5.name),'') ) END) AS HasexpanderR, " +
      "ad_ref_groupinstance.Headerformatbold, " +
      "(CASE WHEN ad_ref_groupinstance.Headerformatbold IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list6.name),'') ) END) AS HeaderformatboldR, " +
      "ad_ref_groupinstance.Colsvisibleoninit, " +
      "(CASE WHEN ad_ref_groupinstance.Colsvisibleoninit IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list7.name),'') ) END) AS ColsvisibleoninitR, " +
      "ad_ref_groupinstance.Leadingemptycols, " +
      "ad_ref_groupinstance.Level, " +
      "COALESCE(ad_ref_groupinstance.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_ref_groupinstance left join (select AD_Ref_Group_ID, AD_Reference_ID, Idcolumn, Level from AD_Ref_Group) table1 on (ad_ref_groupinstance.AD_Ref_Group_ID = table1.AD_Ref_Group_ID) left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table2 on (table1.AD_Reference_ID = table2.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL2 on (table2.AD_Reference_ID = tableTRL2.AD_Reference_ID and tableTRL2.AD_Language = ?)  left join ad_ref_list_v list1 on (table2.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (ad_ref_groupinstance.Hasselectline = list2.value and list2.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (ad_ref_groupinstance.Hasselectallbelow = list3.value and list3.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list3.ad_language = ?)  left join ad_ref_list_v list4 on (ad_ref_groupinstance.Hasevenodd = list4.value and list4.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list4.ad_language = ?)  left join ad_ref_list_v list5 on (ad_ref_groupinstance.Hasexpander = list5.value and list5.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list5.ad_language = ?)  left join ad_ref_list_v list6 on (ad_ref_groupinstance.Headerformatbold = list6.value and list6.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list6.ad_language = ?)  left join ad_ref_list_v list7 on (ad_ref_groupinstance.Colsvisibleoninit = list7.value and list7.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list7.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adRefGroupId==null || adRefGroupId.equals(""))?"":"  AND ad_ref_groupinstance.AD_Ref_Group_ID = ?  ");
    strSql = strSql + 
      "        AND ad_ref_groupinstance.AD_Ref_Groupinstance_ID = ? " +
      "        AND ad_ref_groupinstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_ref_groupinstance.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (adRefGroupId != null && !(adRefGroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);
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
        GridGroupInstancespecificsettingsData objectGridGroupInstancespecificsettingsData = new GridGroupInstancespecificsettingsData();
        objectGridGroupInstancespecificsettingsData.created = UtilSql.getValue(result, "created");
        objectGridGroupInstancespecificsettingsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectGridGroupInstancespecificsettingsData.updated = UtilSql.getValue(result, "updated");
        objectGridGroupInstancespecificsettingsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectGridGroupInstancespecificsettingsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectGridGroupInstancespecificsettingsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectGridGroupInstancespecificsettingsData.adRefGroupinstanceId = UtilSql.getValue(result, "ad_ref_groupinstance_id");
        objectGridGroupInstancespecificsettingsData.adRefGroupId = UtilSql.getValue(result, "ad_ref_group_id");
        objectGridGroupInstancespecificsettingsData.adRefGroupIdr = UtilSql.getValue(result, "ad_ref_group_idr");
        objectGridGroupInstancespecificsettingsData.line = UtilSql.getValue(result, "line");
        objectGridGroupInstancespecificsettingsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectGridGroupInstancespecificsettingsData.isautoheader = UtilSql.getValue(result, "isautoheader");
        objectGridGroupInstancespecificsettingsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectGridGroupInstancespecificsettingsData.hasselectline = UtilSql.getValue(result, "hasselectline");
        objectGridGroupInstancespecificsettingsData.hasselectliner = UtilSql.getValue(result, "hasselectliner");
        objectGridGroupInstancespecificsettingsData.hasselectallbelow = UtilSql.getValue(result, "hasselectallbelow");
        objectGridGroupInstancespecificsettingsData.hasselectallbelowr = UtilSql.getValue(result, "hasselectallbelowr");
        objectGridGroupInstancespecificsettingsData.hasevenodd = UtilSql.getValue(result, "hasevenodd");
        objectGridGroupInstancespecificsettingsData.hasevenoddr = UtilSql.getValue(result, "hasevenoddr");
        objectGridGroupInstancespecificsettingsData.hasexpander = UtilSql.getValue(result, "hasexpander");
        objectGridGroupInstancespecificsettingsData.hasexpanderr = UtilSql.getValue(result, "hasexpanderr");
        objectGridGroupInstancespecificsettingsData.headerformatbold = UtilSql.getValue(result, "headerformatbold");
        objectGridGroupInstancespecificsettingsData.headerformatboldr = UtilSql.getValue(result, "headerformatboldr");
        objectGridGroupInstancespecificsettingsData.colsvisibleoninit = UtilSql.getValue(result, "colsvisibleoninit");
        objectGridGroupInstancespecificsettingsData.colsvisibleoninitr = UtilSql.getValue(result, "colsvisibleoninitr");
        objectGridGroupInstancespecificsettingsData.leadingemptycols = UtilSql.getValue(result, "leadingemptycols");
        objectGridGroupInstancespecificsettingsData.level = UtilSql.getValue(result, "level");
        objectGridGroupInstancespecificsettingsData.isactive = UtilSql.getValue(result, "isactive");
        objectGridGroupInstancespecificsettingsData.language = UtilSql.getValue(result, "language");
        objectGridGroupInstancespecificsettingsData.adUserClient = "";
        objectGridGroupInstancespecificsettingsData.adOrgClient = "";
        objectGridGroupInstancespecificsettingsData.createdby = "";
        objectGridGroupInstancespecificsettingsData.trBgcolor = "";
        objectGridGroupInstancespecificsettingsData.totalCount = "";
        objectGridGroupInstancespecificsettingsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGridGroupInstancespecificsettingsData);
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
    GridGroupInstancespecificsettingsData objectGridGroupInstancespecificsettingsData[] = new GridGroupInstancespecificsettingsData[vector.size()];
    vector.copyInto(objectGridGroupInstancespecificsettingsData);
    return(objectGridGroupInstancespecificsettingsData);
  }

/**
Create a registry
 */
  public static GridGroupInstancespecificsettingsData[] set(String adRefGroupId, String adClientId, String level, String isautoheader, String updatedby, String updatedbyr, String leadingemptycols, String headerformatbold, String colsvisibleoninit, String adRefGroupinstanceId, String adOrgId, String isactive, String createdby, String createdbyr, String line, String hasselectline, String hasexpander, String hasevenodd, String hasselectallbelow)    throws ServletException {
    GridGroupInstancespecificsettingsData objectGridGroupInstancespecificsettingsData[] = new GridGroupInstancespecificsettingsData[1];
    objectGridGroupInstancespecificsettingsData[0] = new GridGroupInstancespecificsettingsData();
    objectGridGroupInstancespecificsettingsData[0].created = "";
    objectGridGroupInstancespecificsettingsData[0].createdbyr = createdbyr;
    objectGridGroupInstancespecificsettingsData[0].updated = "";
    objectGridGroupInstancespecificsettingsData[0].updatedTimeStamp = "";
    objectGridGroupInstancespecificsettingsData[0].updatedby = updatedby;
    objectGridGroupInstancespecificsettingsData[0].updatedbyr = updatedbyr;
    objectGridGroupInstancespecificsettingsData[0].adRefGroupinstanceId = adRefGroupinstanceId;
    objectGridGroupInstancespecificsettingsData[0].adRefGroupId = adRefGroupId;
    objectGridGroupInstancespecificsettingsData[0].adRefGroupIdr = "";
    objectGridGroupInstancespecificsettingsData[0].line = line;
    objectGridGroupInstancespecificsettingsData[0].adClientId = adClientId;
    objectGridGroupInstancespecificsettingsData[0].isautoheader = isautoheader;
    objectGridGroupInstancespecificsettingsData[0].adOrgId = adOrgId;
    objectGridGroupInstancespecificsettingsData[0].hasselectline = hasselectline;
    objectGridGroupInstancespecificsettingsData[0].hasselectliner = "";
    objectGridGroupInstancespecificsettingsData[0].hasselectallbelow = hasselectallbelow;
    objectGridGroupInstancespecificsettingsData[0].hasselectallbelowr = "";
    objectGridGroupInstancespecificsettingsData[0].hasevenodd = hasevenodd;
    objectGridGroupInstancespecificsettingsData[0].hasevenoddr = "";
    objectGridGroupInstancespecificsettingsData[0].hasexpander = hasexpander;
    objectGridGroupInstancespecificsettingsData[0].hasexpanderr = "";
    objectGridGroupInstancespecificsettingsData[0].headerformatbold = headerformatbold;
    objectGridGroupInstancespecificsettingsData[0].headerformatboldr = "";
    objectGridGroupInstancespecificsettingsData[0].colsvisibleoninit = colsvisibleoninit;
    objectGridGroupInstancespecificsettingsData[0].colsvisibleoninitr = "";
    objectGridGroupInstancespecificsettingsData[0].leadingemptycols = leadingemptycols;
    objectGridGroupInstancespecificsettingsData[0].level = level;
    objectGridGroupInstancespecificsettingsData[0].isactive = isactive;
    objectGridGroupInstancespecificsettingsData[0].language = "";
    return objectGridGroupInstancespecificsettingsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef18BB3E360A21450481E71D7CB1A3175F_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef15410E5EFB824833AD19173F8655A7E6_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT ad_ref_groupinstance.AD_Ref_Group_ID AS NAME" +
      "        FROM ad_ref_groupinstance" +
      "        WHERE ad_ref_groupinstance.AD_Ref_Groupinstance_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adRefGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), '')) || ' - ' || list1.name || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Idcolumn), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Level), ''))) AS NAME FROM ad_ref_group left join (select AD_Ref_Group_ID, AD_Reference_ID, Idcolumn, Level from AD_Ref_Group) table1 on (ad_ref_group.AD_Ref_Group_ID = table1.AD_Ref_Group_ID) left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table2 on (table1.AD_Reference_ID = table2.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL2 on (table2.AD_Reference_ID = tableTRL2.AD_Reference_ID and tableTRL2.AD_Language = ?)  left join ad_ref_list_v list1 on (table2.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  WHERE ad_ref_group.AD_Ref_Group_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adRefGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), '')) || ' - ' || list1.name || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Idcolumn), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Level), ''))) AS NAME FROM ad_ref_group left join (select AD_Ref_Group_ID, AD_Reference_ID, Idcolumn, Level from AD_Ref_Group) table1 on (ad_ref_group.AD_Ref_Group_ID = table1.AD_Ref_Group_ID) left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table2 on (table1.AD_Reference_ID = table2.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL2 on (table2.AD_Reference_ID = tableTRL2.AD_Reference_ID and tableTRL2.AD_Language = ?)  left join ad_ref_list_v list1 on (table2.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  WHERE ad_ref_group.AD_Ref_Group_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);

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
      "        UPDATE ad_ref_groupinstance" +
      "        SET AD_Ref_Groupinstance_ID = (?) , AD_Ref_Group_ID = (?) , Line = TO_NUMBER(?) , AD_Client_ID = (?) , Isautoheader = (?) , AD_Org_ID = (?) , Hasselectline = (?) , Hasselectallbelow = (?) , Hasevenodd = (?) , Hasexpander = (?) , Headerformatbold = (?) , Colsvisibleoninit = (?) , Leadingemptycols = TO_NUMBER(?) , Level = TO_NUMBER(?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_ref_groupinstance.AD_Ref_Groupinstance_ID = ? " +
      "                 AND ad_ref_groupinstance.AD_Ref_Group_ID = ? " +
      "        AND ad_ref_groupinstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_groupinstance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isautoheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hasselectline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hasselectallbelow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hasevenodd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hasexpander);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, headerformatbold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colsvisibleoninit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, leadingemptycols);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);
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
      "        INSERT INTO ad_ref_groupinstance " +
      "        (AD_Ref_Groupinstance_ID, AD_Ref_Group_ID, Line, AD_Client_ID, Isautoheader, AD_Org_ID, Hasselectline, Hasselectallbelow, Hasevenodd, Hasexpander, Headerformatbold, Colsvisibleoninit, Leadingemptycols, Level, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isautoheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hasselectline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hasselectallbelow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hasevenodd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hasexpander);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, headerformatbold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colsvisibleoninit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, leadingemptycols);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adRefGroupId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_groupinstance" +
      "        WHERE ad_ref_groupinstance.AD_Ref_Groupinstance_ID = ? " +
      "                 AND ad_ref_groupinstance.AD_Ref_Group_ID = ? " +
      "        AND ad_ref_groupinstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_groupinstance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adRefGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_groupinstance" +
      "        WHERE ad_ref_groupinstance.AD_Ref_Groupinstance_ID = ? " +
      "                 AND ad_ref_groupinstance.AD_Ref_Group_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);

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
      "          FROM ad_ref_groupinstance" +
      "         WHERE ad_ref_groupinstance.AD_Ref_Groupinstance_ID = ? ";

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
      "          FROM ad_ref_groupinstance" +
      "         WHERE ad_ref_groupinstance.AD_Ref_Groupinstance_ID = ? ";

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
