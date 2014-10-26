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
class EditableGridGroupsData implements FieldProvider {
static Logger log4j = Logger.getLogger(EditableGridGroupsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adRefGroupId;
  public String adReferenceId;
  public String adReferenceIdr;
  public String line;
  public String adClientId;
  public String adOrgId;
  public String isautoheader;
  public String idcolumn;
  public String hasselectline;
  public String hasselectallbelow;
  public String hasevenodd;
  public String hasexpander;
  public String headerformatbold;
  public String colsvisibleoninit;
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
    else if (fieldName.equalsIgnoreCase("ad_ref_group_id") || fieldName.equals("adRefGroupId"))
      return adRefGroupId;
    else if (fieldName.equalsIgnoreCase("ad_reference_id") || fieldName.equals("adReferenceId"))
      return adReferenceId;
    else if (fieldName.equalsIgnoreCase("ad_reference_idr") || fieldName.equals("adReferenceIdr"))
      return adReferenceIdr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isautoheader"))
      return isautoheader;
    else if (fieldName.equalsIgnoreCase("idcolumn"))
      return idcolumn;
    else if (fieldName.equalsIgnoreCase("hasselectline"))
      return hasselectline;
    else if (fieldName.equalsIgnoreCase("hasselectallbelow"))
      return hasselectallbelow;
    else if (fieldName.equalsIgnoreCase("hasevenodd"))
      return hasevenodd;
    else if (fieldName.equalsIgnoreCase("hasexpander"))
      return hasexpander;
    else if (fieldName.equalsIgnoreCase("headerformatbold"))
      return headerformatbold;
    else if (fieldName.equalsIgnoreCase("colsvisibleoninit"))
      return colsvisibleoninit;
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
  public static EditableGridGroupsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adReferenceId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adReferenceId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static EditableGridGroupsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adReferenceId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_ref_group.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_group.CreatedBy) as CreatedByR, " +
      "        to_char(ad_ref_group.Updated, ?) as updated, " +
      "        to_char(ad_ref_group.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_ref_group.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_group.UpdatedBy) as UpdatedByR," +
      "        ad_ref_group.AD_Ref_Group_ID, " +
      "ad_ref_group.AD_Reference_ID, " +
      "(CASE WHEN ad_ref_group.AD_Reference_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(list1.name),'') ) END) AS AD_Reference_IDR, " +
      "ad_ref_group.Line, " +
      "ad_ref_group.AD_Client_ID, " +
      "ad_ref_group.AD_Org_ID, " +
      "COALESCE(ad_ref_group.Isautoheader, 'N') AS Isautoheader, " +
      "ad_ref_group.Idcolumn, " +
      "COALESCE(ad_ref_group.Hasselectline, 'N') AS Hasselectline, " +
      "COALESCE(ad_ref_group.Hasselectallbelow, 'N') AS Hasselectallbelow, " +
      "COALESCE(ad_ref_group.Hasevenodd, 'N') AS Hasevenodd, " +
      "COALESCE(ad_ref_group.Hasexpander, 'N') AS Hasexpander, " +
      "COALESCE(ad_ref_group.Headerformatbold, 'N') AS Headerformatbold, " +
      "COALESCE(ad_ref_group.Colsvisibleoninit, 'N') AS Colsvisibleoninit, " +
      "ad_ref_group.Leadingemptycols, " +
      "ad_ref_group.Level, " +
      "COALESCE(ad_ref_group.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_ref_group left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table1 on (ad_ref_group.AD_Reference_ID = table1.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL1 on (table1.AD_Reference_ID = tableTRL1.AD_Reference_ID and tableTRL1.AD_Language = ?)  left join ad_ref_list_v list1 on (table1.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adReferenceId==null || adReferenceId.equals(""))?"":"  AND ad_ref_group.AD_Reference_ID = ?  ");
    strSql = strSql + 
      "        AND ad_ref_group.AD_Ref_Group_ID = ? " +
      "        AND ad_ref_group.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_ref_group.AD_Org_ID IN (";
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
      if (adReferenceId != null && !(adReferenceId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
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
        EditableGridGroupsData objectEditableGridGroupsData = new EditableGridGroupsData();
        objectEditableGridGroupsData.created = UtilSql.getValue(result, "created");
        objectEditableGridGroupsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectEditableGridGroupsData.updated = UtilSql.getValue(result, "updated");
        objectEditableGridGroupsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectEditableGridGroupsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectEditableGridGroupsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectEditableGridGroupsData.adRefGroupId = UtilSql.getValue(result, "ad_ref_group_id");
        objectEditableGridGroupsData.adReferenceId = UtilSql.getValue(result, "ad_reference_id");
        objectEditableGridGroupsData.adReferenceIdr = UtilSql.getValue(result, "ad_reference_idr");
        objectEditableGridGroupsData.line = UtilSql.getValue(result, "line");
        objectEditableGridGroupsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectEditableGridGroupsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectEditableGridGroupsData.isautoheader = UtilSql.getValue(result, "isautoheader");
        objectEditableGridGroupsData.idcolumn = UtilSql.getValue(result, "idcolumn");
        objectEditableGridGroupsData.hasselectline = UtilSql.getValue(result, "hasselectline");
        objectEditableGridGroupsData.hasselectallbelow = UtilSql.getValue(result, "hasselectallbelow");
        objectEditableGridGroupsData.hasevenodd = UtilSql.getValue(result, "hasevenodd");
        objectEditableGridGroupsData.hasexpander = UtilSql.getValue(result, "hasexpander");
        objectEditableGridGroupsData.headerformatbold = UtilSql.getValue(result, "headerformatbold");
        objectEditableGridGroupsData.colsvisibleoninit = UtilSql.getValue(result, "colsvisibleoninit");
        objectEditableGridGroupsData.leadingemptycols = UtilSql.getValue(result, "leadingemptycols");
        objectEditableGridGroupsData.level = UtilSql.getValue(result, "level");
        objectEditableGridGroupsData.isactive = UtilSql.getValue(result, "isactive");
        objectEditableGridGroupsData.language = UtilSql.getValue(result, "language");
        objectEditableGridGroupsData.adUserClient = "";
        objectEditableGridGroupsData.adOrgClient = "";
        objectEditableGridGroupsData.createdby = "";
        objectEditableGridGroupsData.trBgcolor = "";
        objectEditableGridGroupsData.totalCount = "";
        objectEditableGridGroupsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEditableGridGroupsData);
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
    EditableGridGroupsData objectEditableGridGroupsData[] = new EditableGridGroupsData[vector.size()];
    vector.copyInto(objectEditableGridGroupsData);
    return(objectEditableGridGroupsData);
  }

/**
Create a registry
 */
  public static EditableGridGroupsData[] set(String adReferenceId, String colsvisibleoninit, String headerformatbold, String hasexpander, String createdby, String createdbyr, String isactive, String level, String isautoheader, String updatedby, String updatedbyr, String adClientId, String idcolumn, String leadingemptycols, String adOrgId, String adRefGroupId, String hasevenodd, String hasselectline, String hasselectallbelow, String line)    throws ServletException {
    EditableGridGroupsData objectEditableGridGroupsData[] = new EditableGridGroupsData[1];
    objectEditableGridGroupsData[0] = new EditableGridGroupsData();
    objectEditableGridGroupsData[0].created = "";
    objectEditableGridGroupsData[0].createdbyr = createdbyr;
    objectEditableGridGroupsData[0].updated = "";
    objectEditableGridGroupsData[0].updatedTimeStamp = "";
    objectEditableGridGroupsData[0].updatedby = updatedby;
    objectEditableGridGroupsData[0].updatedbyr = updatedbyr;
    objectEditableGridGroupsData[0].adRefGroupId = adRefGroupId;
    objectEditableGridGroupsData[0].adReferenceId = adReferenceId;
    objectEditableGridGroupsData[0].adReferenceIdr = "";
    objectEditableGridGroupsData[0].line = line;
    objectEditableGridGroupsData[0].adClientId = adClientId;
    objectEditableGridGroupsData[0].adOrgId = adOrgId;
    objectEditableGridGroupsData[0].isautoheader = isautoheader;
    objectEditableGridGroupsData[0].idcolumn = idcolumn;
    objectEditableGridGroupsData[0].hasselectline = hasselectline;
    objectEditableGridGroupsData[0].hasselectallbelow = hasselectallbelow;
    objectEditableGridGroupsData[0].hasevenodd = hasevenodd;
    objectEditableGridGroupsData[0].hasexpander = hasexpander;
    objectEditableGridGroupsData[0].headerformatbold = headerformatbold;
    objectEditableGridGroupsData[0].colsvisibleoninit = colsvisibleoninit;
    objectEditableGridGroupsData[0].leadingemptycols = leadingemptycols;
    objectEditableGridGroupsData[0].level = level;
    objectEditableGridGroupsData[0].isactive = isactive;
    objectEditableGridGroupsData[0].language = "";
    return objectEditableGridGroupsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef3D040AC7B9D3407DB943BCDD9FDCC369_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefA1CBD281C1D7468EBA006C97C1BC467D_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef0DFA31B6C1874378A805AEF24123868C(ConnectionProvider connectionProvider, String ad_reference_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(LINE),0)+10 AS DefaultValue FROM AD_REF_GROUP WHERE ad_reference_id=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_reference_id);

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
      "        SELECT ad_ref_group.AD_Reference_ID AS NAME" +
      "        FROM ad_ref_group" +
      "        WHERE ad_ref_group.AD_Ref_Group_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adReferenceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), '')) || ' - ' || list1.name) AS NAME FROM AD_Reference left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table1 on (AD_Reference.AD_Reference_ID = table1.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL1 on (table1.AD_Reference_ID = tableTRL1.AD_Reference_ID and tableTRL1.AD_Language = ?)  left join ad_ref_list_v list1 on (table1.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  WHERE AD_Reference.AD_Reference_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adReferenceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), '')) || ' - ' || list1.name) AS NAME FROM AD_Reference left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table1 on (AD_Reference.AD_Reference_ID = table1.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL1 on (table1.AD_Reference_ID = tableTRL1.AD_Reference_ID and tableTRL1.AD_Language = ?)  left join ad_ref_list_v list1 on (table1.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  WHERE AD_Reference.AD_Reference_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);

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
      "        UPDATE ad_ref_group" +
      "        SET AD_Ref_Group_ID = (?) , AD_Reference_ID = (?) , Line = TO_NUMBER(?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Isautoheader = (?) , Idcolumn = (?) , Hasselectline = (?) , Hasselectallbelow = (?) , Hasevenodd = (?) , Hasexpander = (?) , Headerformatbold = (?) , Colsvisibleoninit = (?) , Leadingemptycols = TO_NUMBER(?) , Level = TO_NUMBER(?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_ref_group.AD_Ref_Group_ID = ? " +
      "                 AND ad_ref_group.AD_Reference_ID = ? " +
      "        AND ad_ref_group.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_group.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isautoheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, idcolumn);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);
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
      "        INSERT INTO ad_ref_group " +
      "        (AD_Ref_Group_ID, AD_Reference_ID, Line, AD_Client_ID, AD_Org_ID, Isautoheader, Idcolumn, Hasselectline, Hasselectallbelow, Hasevenodd, Hasexpander, Headerformatbold, Colsvisibleoninit, Leadingemptycols, Level, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isautoheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, idcolumn);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adReferenceId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_group" +
      "        WHERE ad_ref_group.AD_Ref_Group_ID = ? " +
      "                 AND ad_ref_group.AD_Reference_ID = ? " +
      "        AND ad_ref_group.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_group.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adReferenceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_group" +
      "        WHERE ad_ref_group.AD_Ref_Group_ID = ? " +
      "                 AND ad_ref_group.AD_Reference_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);

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
      "          FROM ad_ref_group" +
      "         WHERE ad_ref_group.AD_Ref_Group_ID = ? ";

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
      "          FROM ad_ref_group" +
      "         WHERE ad_ref_group.AD_Ref_Group_ID = ? ";

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
