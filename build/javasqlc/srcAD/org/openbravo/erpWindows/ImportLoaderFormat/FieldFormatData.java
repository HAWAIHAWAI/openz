//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ImportLoaderFormat;

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
class FieldFormatData implements FieldProvider {
static Logger log4j = Logger.getLogger(FieldFormatData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adImpformatRowId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String adImpformatId;
  public String adImpformatIdr;
  public String seqno;
  public String name;
  public String isactive;
  public String adColumnId;
  public String adColumnIdr;
  public String datatype;
  public String datatyper;
  public String dataformat;
  public String startno;
  public String endno;
  public String decimalpoint;
  public String divideby100;
  public String constantvalue;
  public String callout;
  public String script;
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
    else if (fieldName.equalsIgnoreCase("ad_impformat_row_id") || fieldName.equals("adImpformatRowId"))
      return adImpformatRowId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_impformat_id") || fieldName.equals("adImpformatId"))
      return adImpformatId;
    else if (fieldName.equalsIgnoreCase("ad_impformat_idr") || fieldName.equals("adImpformatIdr"))
      return adImpformatIdr;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_column_id") || fieldName.equals("adColumnId"))
      return adColumnId;
    else if (fieldName.equalsIgnoreCase("ad_column_idr") || fieldName.equals("adColumnIdr"))
      return adColumnIdr;
    else if (fieldName.equalsIgnoreCase("datatype"))
      return datatype;
    else if (fieldName.equalsIgnoreCase("datatyper"))
      return datatyper;
    else if (fieldName.equalsIgnoreCase("dataformat"))
      return dataformat;
    else if (fieldName.equalsIgnoreCase("startno"))
      return startno;
    else if (fieldName.equalsIgnoreCase("endno"))
      return endno;
    else if (fieldName.equalsIgnoreCase("decimalpoint"))
      return decimalpoint;
    else if (fieldName.equalsIgnoreCase("divideby100"))
      return divideby100;
    else if (fieldName.equalsIgnoreCase("constantvalue"))
      return constantvalue;
    else if (fieldName.equalsIgnoreCase("callout"))
      return callout;
    else if (fieldName.equalsIgnoreCase("script"))
      return script;
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
  public static FieldFormatData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adImpformatId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adImpformatId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static FieldFormatData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adImpformatId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_ImpFormat_Row.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_ImpFormat_Row.CreatedBy) as CreatedByR, " +
      "        to_char(AD_ImpFormat_Row.Updated, ?) as updated, " +
      "        to_char(AD_ImpFormat_Row.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_ImpFormat_Row.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_ImpFormat_Row.UpdatedBy) as UpdatedByR," +
      "        AD_ImpFormat_Row.AD_ImpFormat_Row_ID, " +
      "AD_ImpFormat_Row.AD_Client_ID, " +
      "(CASE WHEN AD_ImpFormat_Row.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_ImpFormat_Row.AD_Org_ID, " +
      "(CASE WHEN AD_ImpFormat_Row.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_ImpFormat_Row.AD_ImpFormat_ID, " +
      "(CASE WHEN AD_ImpFormat_Row.AD_ImpFormat_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_ImpFormat_IDR, " +
      "AD_ImpFormat_Row.SeqNo, " +
      "AD_ImpFormat_Row.Name, " +
      "COALESCE(AD_ImpFormat_Row.IsActive, 'N') AS IsActive, " +
      "AD_ImpFormat_Row.AD_Column_ID, " +
      "(CASE WHEN AD_ImpFormat_Row.AD_Column_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.ColumnName), ''))),'') ) END) AS AD_Column_IDR, " +
      "AD_ImpFormat_Row.DataType, " +
      "(CASE WHEN AD_ImpFormat_Row.DataType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DataTypeR, " +
      "AD_ImpFormat_Row.DataFormat, " +
      "AD_ImpFormat_Row.StartNo, " +
      "AD_ImpFormat_Row.EndNo, " +
      "AD_ImpFormat_Row.DecimalPoint, " +
      "COALESCE(AD_ImpFormat_Row.DivideBy100, 'N') AS DivideBy100, " +
      "AD_ImpFormat_Row.ConstantValue, " +
      "AD_ImpFormat_Row.Callout, " +
      "AD_ImpFormat_Row.Script, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_ImpFormat_Row left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_ImpFormat_Row.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_ImpFormat_Row.AD_Org_ID = table2.AD_Org_ID) left join (select AD_ImpFormat_ID, Name from AD_ImpFormat) table3 on (AD_ImpFormat_Row.AD_ImpFormat_ID = table3.AD_ImpFormat_ID) left join (select AD_Column_ID, ColumnName from AD_Column) table4 on (AD_ImpFormat_Row.AD_Column_ID = table4.AD_Column_ID) left join ad_ref_list_v list1 on (AD_ImpFormat_Row.DataType = list1.value and list1.ad_reference_id = '210' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adImpformatId==null || adImpformatId.equals(""))?"":"  AND AD_ImpFormat_Row.AD_ImpFormat_ID = ?  ");
    strSql = strSql + 
      "        AND AD_ImpFormat_Row.AD_ImpFormat_Row_ID = ? " +
      "        AND AD_ImpFormat_Row.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_ImpFormat_Row.AD_Org_ID IN (";
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
      if (adImpformatId != null && !(adImpformatId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImpformatId);
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
        FieldFormatData objectFieldFormatData = new FieldFormatData();
        objectFieldFormatData.created = UtilSql.getValue(result, "created");
        objectFieldFormatData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectFieldFormatData.updated = UtilSql.getValue(result, "updated");
        objectFieldFormatData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectFieldFormatData.updatedby = UtilSql.getValue(result, "updatedby");
        objectFieldFormatData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectFieldFormatData.adImpformatRowId = UtilSql.getValue(result, "ad_impformat_row_id");
        objectFieldFormatData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectFieldFormatData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectFieldFormatData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectFieldFormatData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectFieldFormatData.adImpformatId = UtilSql.getValue(result, "ad_impformat_id");
        objectFieldFormatData.adImpformatIdr = UtilSql.getValue(result, "ad_impformat_idr");
        objectFieldFormatData.seqno = UtilSql.getValue(result, "seqno");
        objectFieldFormatData.name = UtilSql.getValue(result, "name");
        objectFieldFormatData.isactive = UtilSql.getValue(result, "isactive");
        objectFieldFormatData.adColumnId = UtilSql.getValue(result, "ad_column_id");
        objectFieldFormatData.adColumnIdr = UtilSql.getValue(result, "ad_column_idr");
        objectFieldFormatData.datatype = UtilSql.getValue(result, "datatype");
        objectFieldFormatData.datatyper = UtilSql.getValue(result, "datatyper");
        objectFieldFormatData.dataformat = UtilSql.getValue(result, "dataformat");
        objectFieldFormatData.startno = UtilSql.getValue(result, "startno");
        objectFieldFormatData.endno = UtilSql.getValue(result, "endno");
        objectFieldFormatData.decimalpoint = UtilSql.getValue(result, "decimalpoint");
        objectFieldFormatData.divideby100 = UtilSql.getValue(result, "divideby100");
        objectFieldFormatData.constantvalue = UtilSql.getValue(result, "constantvalue");
        objectFieldFormatData.callout = UtilSql.getValue(result, "callout");
        objectFieldFormatData.script = UtilSql.getValue(result, "script");
        objectFieldFormatData.language = UtilSql.getValue(result, "language");
        objectFieldFormatData.adUserClient = "";
        objectFieldFormatData.adOrgClient = "";
        objectFieldFormatData.createdby = "";
        objectFieldFormatData.trBgcolor = "";
        objectFieldFormatData.totalCount = "";
        objectFieldFormatData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFieldFormatData);
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
    FieldFormatData objectFieldFormatData[] = new FieldFormatData[vector.size()];
    vector.copyInto(objectFieldFormatData);
    return(objectFieldFormatData);
  }

/**
Create a registry
 */
  public static FieldFormatData[] set(String adImpformatId, String name, String endno, String divideby100, String adClientId, String isactive, String datatype, String adOrgId, String constantvalue, String createdby, String createdbyr, String adColumnId, String decimalpoint, String dataformat, String adImpformatRowId, String script, String seqno, String callout, String startno, String updatedby, String updatedbyr)    throws ServletException {
    FieldFormatData objectFieldFormatData[] = new FieldFormatData[1];
    objectFieldFormatData[0] = new FieldFormatData();
    objectFieldFormatData[0].created = "";
    objectFieldFormatData[0].createdbyr = createdbyr;
    objectFieldFormatData[0].updated = "";
    objectFieldFormatData[0].updatedTimeStamp = "";
    objectFieldFormatData[0].updatedby = updatedby;
    objectFieldFormatData[0].updatedbyr = updatedbyr;
    objectFieldFormatData[0].adImpformatRowId = adImpformatRowId;
    objectFieldFormatData[0].adClientId = adClientId;
    objectFieldFormatData[0].adClientIdr = "";
    objectFieldFormatData[0].adOrgId = adOrgId;
    objectFieldFormatData[0].adOrgIdr = "";
    objectFieldFormatData[0].adImpformatId = adImpformatId;
    objectFieldFormatData[0].adImpformatIdr = "";
    objectFieldFormatData[0].seqno = seqno;
    objectFieldFormatData[0].name = name;
    objectFieldFormatData[0].isactive = isactive;
    objectFieldFormatData[0].adColumnId = adColumnId;
    objectFieldFormatData[0].adColumnIdr = "";
    objectFieldFormatData[0].datatype = datatype;
    objectFieldFormatData[0].datatyper = "";
    objectFieldFormatData[0].dataformat = dataformat;
    objectFieldFormatData[0].startno = startno;
    objectFieldFormatData[0].endno = endno;
    objectFieldFormatData[0].decimalpoint = decimalpoint;
    objectFieldFormatData[0].divideby100 = divideby100;
    objectFieldFormatData[0].constantvalue = constantvalue;
    objectFieldFormatData[0].callout = callout;
    objectFieldFormatData[0].script = script;
    objectFieldFormatData[0].language = "";
    return objectFieldFormatData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef4686_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef4691(ConnectionProvider connectionProvider, String AD_ImpFormat_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(SeqNo),0)+10 AS DefaultValue FROM AD_ImpFormat_Row WHERE AD_ImpFormat_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_ImpFormat_ID);

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
Select for auxiliar field
 */
  public static String selectDef4688_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ImpFormat_Row.AD_ImpFormat_ID AS NAME" +
      "        FROM AD_ImpFormat_Row" +
      "        WHERE AD_ImpFormat_Row.AD_ImpFormat_Row_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adImpformatId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_ImpFormat left join (select AD_ImpFormat_ID, Name from AD_ImpFormat) table1 on (AD_ImpFormat.AD_ImpFormat_ID = table1.AD_ImpFormat_ID) WHERE AD_ImpFormat.AD_ImpFormat_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImpformatId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adImpformatId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_ImpFormat left join (select AD_ImpFormat_ID, Name from AD_ImpFormat) table1 on (AD_ImpFormat.AD_ImpFormat_ID = table1.AD_ImpFormat_ID) WHERE AD_ImpFormat.AD_ImpFormat_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImpformatId);

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
      "        UPDATE AD_ImpFormat_Row" +
      "        SET AD_ImpFormat_Row_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , AD_ImpFormat_ID = (?) , SeqNo = TO_NUMBER(?) , Name = (?) , IsActive = (?) , AD_Column_ID = (?) , DataType = (?) , DataFormat = (?) , StartNo = TO_NUMBER(?) , EndNo = TO_NUMBER(?) , DecimalPoint = (?) , DivideBy100 = (?) , ConstantValue = (?) , Callout = (?) , Script = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_ImpFormat_Row.AD_ImpFormat_Row_ID = ? " +
      "                 AND AD_ImpFormat_Row.AD_ImpFormat_ID = ? " +
      "        AND AD_ImpFormat_Row.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_ImpFormat_Row.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImpformatRowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImpformatId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datatype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dataformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, endno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, decimalpoint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, divideby100);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, constantvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, callout);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, script);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImpformatRowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImpformatId);
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
      "        INSERT INTO AD_ImpFormat_Row " +
      "        (AD_ImpFormat_Row_ID, AD_Client_ID, AD_Org_ID, AD_ImpFormat_ID, SeqNo, Name, IsActive, AD_Column_ID, DataType, DataFormat, StartNo, EndNo, DecimalPoint, DivideBy100, ConstantValue, Callout, Script, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImpformatRowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImpformatId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datatype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dataformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, endno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, decimalpoint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, divideby100);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, constantvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, callout);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, script);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adImpformatId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_ImpFormat_Row" +
      "        WHERE AD_ImpFormat_Row.AD_ImpFormat_Row_ID = ? " +
      "                 AND AD_ImpFormat_Row.AD_ImpFormat_ID = ? " +
      "        AND AD_ImpFormat_Row.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_ImpFormat_Row.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImpformatId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adImpformatId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_ImpFormat_Row" +
      "        WHERE AD_ImpFormat_Row.AD_ImpFormat_Row_ID = ? " +
      "                 AND AD_ImpFormat_Row.AD_ImpFormat_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImpformatId);

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
      "          FROM AD_ImpFormat_Row" +
      "         WHERE AD_ImpFormat_Row.AD_ImpFormat_Row_ID = ? ";

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
      "          FROM AD_ImpFormat_Row" +
      "         WHERE AD_ImpFormat_Row.AD_ImpFormat_Row_ID = ? ";

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
