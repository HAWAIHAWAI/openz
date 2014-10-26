//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.AttributeSet;

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
class AttributeSetData implements FieldProvider {
static Logger log4j = Logger.getLogger(AttributeSetData.class);
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
  public String islot;
  public String guaranteedays;
  public String mSernoctlId;
  public String islockable;
  public String isguaranteedate;
  public String isserno;
  public String mAttributesetId;
  public String mLotctlId;
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
    else if (fieldName.equalsIgnoreCase("islot"))
      return islot;
    else if (fieldName.equalsIgnoreCase("guaranteedays"))
      return guaranteedays;
    else if (fieldName.equalsIgnoreCase("m_sernoctl_id") || fieldName.equals("mSernoctlId"))
      return mSernoctlId;
    else if (fieldName.equalsIgnoreCase("islockable"))
      return islockable;
    else if (fieldName.equalsIgnoreCase("isguaranteedate"))
      return isguaranteedate;
    else if (fieldName.equalsIgnoreCase("isserno"))
      return isserno;
    else if (fieldName.equalsIgnoreCase("m_attributeset_id") || fieldName.equals("mAttributesetId"))
      return mAttributesetId;
    else if (fieldName.equalsIgnoreCase("m_lotctl_id") || fieldName.equals("mLotctlId"))
      return mLotctlId;
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
  public static AttributeSetData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static AttributeSetData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_AttributeSet.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_AttributeSet.CreatedBy) as CreatedByR, " +
      "        to_char(M_AttributeSet.Updated, ?) as updated, " +
      "        to_char(M_AttributeSet.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_AttributeSet.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_AttributeSet.UpdatedBy) as UpdatedByR," +
      "        M_AttributeSet.AD_Client_ID, " +
      "(CASE WHEN M_AttributeSet.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "M_AttributeSet.AD_Org_ID, " +
      "(CASE WHEN M_AttributeSet.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "M_AttributeSet.Name, " +
      "M_AttributeSet.Description, " +
      "COALESCE(M_AttributeSet.IsActive, 'N') AS IsActive, " +
      "COALESCE(M_AttributeSet.IsLot, 'N') AS IsLot, " +
      "M_AttributeSet.GuaranteeDays, " +
      "M_AttributeSet.M_SerNoCtl_ID, " +
      "COALESCE(M_AttributeSet.IsLockable, 'N') AS IsLockable, " +
      "COALESCE(M_AttributeSet.IsGuaranteeDate, 'N') AS IsGuaranteeDate, " +
      "COALESCE(M_AttributeSet.IsSerNo, 'N') AS IsSerNo, " +
      "M_AttributeSet.M_AttributeSet_ID, " +
      "M_AttributeSet.M_LotCtl_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM M_AttributeSet left join (select AD_Client_ID, Name from AD_Client) table1 on (M_AttributeSet.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (M_AttributeSet.AD_Org_ID = table2.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND M_AttributeSet.M_AttributeSet_ID = ? " +
      "        AND M_AttributeSet.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND M_AttributeSet.AD_Org_ID IN (";
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
        AttributeSetData objectAttributeSetData = new AttributeSetData();
        objectAttributeSetData.created = UtilSql.getValue(result, "created");
        objectAttributeSetData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectAttributeSetData.updated = UtilSql.getValue(result, "updated");
        objectAttributeSetData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectAttributeSetData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAttributeSetData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectAttributeSetData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAttributeSetData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectAttributeSetData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAttributeSetData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectAttributeSetData.name = UtilSql.getValue(result, "name");
        objectAttributeSetData.description = UtilSql.getValue(result, "description");
        objectAttributeSetData.isactive = UtilSql.getValue(result, "isactive");
        objectAttributeSetData.islot = UtilSql.getValue(result, "islot");
        objectAttributeSetData.guaranteedays = UtilSql.getValue(result, "guaranteedays");
        objectAttributeSetData.mSernoctlId = UtilSql.getValue(result, "m_sernoctl_id");
        objectAttributeSetData.islockable = UtilSql.getValue(result, "islockable");
        objectAttributeSetData.isguaranteedate = UtilSql.getValue(result, "isguaranteedate");
        objectAttributeSetData.isserno = UtilSql.getValue(result, "isserno");
        objectAttributeSetData.mAttributesetId = UtilSql.getValue(result, "m_attributeset_id");
        objectAttributeSetData.mLotctlId = UtilSql.getValue(result, "m_lotctl_id");
        objectAttributeSetData.language = UtilSql.getValue(result, "language");
        objectAttributeSetData.adUserClient = "";
        objectAttributeSetData.adOrgClient = "";
        objectAttributeSetData.createdby = "";
        objectAttributeSetData.trBgcolor = "";
        objectAttributeSetData.totalCount = "";
        objectAttributeSetData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAttributeSetData);
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
    AttributeSetData objectAttributeSetData[] = new AttributeSetData[vector.size()];
    vector.copyInto(objectAttributeSetData);
    return(objectAttributeSetData);
  }

/**
Create a registry
 */
  public static AttributeSetData[] set(String mAttributesetId, String islot, String createdby, String createdbyr, String adOrgId, String mSernoctlId, String mLotctlId, String islockable, String name, String updatedby, String updatedbyr, String isguaranteedate, String adClientId, String guaranteedays, String description, String isactive, String isserno)    throws ServletException {
    AttributeSetData objectAttributeSetData[] = new AttributeSetData[1];
    objectAttributeSetData[0] = new AttributeSetData();
    objectAttributeSetData[0].created = "";
    objectAttributeSetData[0].createdbyr = createdbyr;
    objectAttributeSetData[0].updated = "";
    objectAttributeSetData[0].updatedTimeStamp = "";
    objectAttributeSetData[0].updatedby = updatedby;
    objectAttributeSetData[0].updatedbyr = updatedbyr;
    objectAttributeSetData[0].adClientId = adClientId;
    objectAttributeSetData[0].adClientIdr = "";
    objectAttributeSetData[0].adOrgId = adOrgId;
    objectAttributeSetData[0].adOrgIdr = "";
    objectAttributeSetData[0].name = name;
    objectAttributeSetData[0].description = description;
    objectAttributeSetData[0].isactive = isactive;
    objectAttributeSetData[0].islot = islot;
    objectAttributeSetData[0].guaranteedays = guaranteedays;
    objectAttributeSetData[0].mSernoctlId = mSernoctlId;
    objectAttributeSetData[0].islockable = islockable;
    objectAttributeSetData[0].isguaranteedate = isguaranteedate;
    objectAttributeSetData[0].isserno = isserno;
    objectAttributeSetData[0].mAttributesetId = mAttributesetId;
    objectAttributeSetData[0].mLotctlId = mLotctlId;
    objectAttributeSetData[0].language = "";
    return objectAttributeSetData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef8495_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef8496_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
      "        UPDATE M_AttributeSet" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , Name = (?) , Description = (?) , IsActive = (?) , IsLot = (?) , GuaranteeDays = TO_NUMBER(?) , M_SerNoCtl_ID = (?) , IsLockable = (?) , IsGuaranteeDate = (?) , IsSerNo = (?) , M_AttributeSet_ID = (?) , M_LotCtl_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_AttributeSet.M_AttributeSet_ID = ? " +
      "        AND M_AttributeSet.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_AttributeSet.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islot);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mSernoctlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islockable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isguaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isserno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLotctlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetId);
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
      "        INSERT INTO M_AttributeSet " +
      "        (AD_Client_ID, AD_Org_ID, Name, Description, IsActive, IsLot, GuaranteeDays, M_SerNoCtl_ID, IsLockable, IsGuaranteeDate, IsSerNo, M_AttributeSet_ID, M_LotCtl_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islot);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mSernoctlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islockable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isguaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isserno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLotctlId);
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
      "        DELETE FROM M_AttributeSet" +
      "        WHERE M_AttributeSet.M_AttributeSet_ID = ? " +
      "        AND M_AttributeSet.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_AttributeSet.AD_Org_ID IN (";
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
      "        DELETE FROM M_AttributeSet" +
      "        WHERE M_AttributeSet.M_AttributeSet_ID = ? ";

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
      "          FROM M_AttributeSet" +
      "         WHERE M_AttributeSet.M_AttributeSet_ID = ? ";

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
      "          FROM M_AttributeSet" +
      "         WHERE M_AttributeSet.M_AttributeSet_ID = ? ";

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
