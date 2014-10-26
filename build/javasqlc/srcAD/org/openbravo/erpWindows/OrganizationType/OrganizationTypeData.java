//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.OrganizationType;

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
class OrganizationTypeData implements FieldProvider {
static Logger log4j = Logger.getLogger(OrganizationTypeData.class);
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
  public String isactive;
  public String isdefault;
  public String name;
  public String description;
  public String islegalentity;
  public String adOrgtypeId;
  public String isbusinessunit;
  public String isacctlegalentity;
  public String istransactionsallowed;
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
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("islegalentity"))
      return islegalentity;
    else if (fieldName.equalsIgnoreCase("ad_orgtype_id") || fieldName.equals("adOrgtypeId"))
      return adOrgtypeId;
    else if (fieldName.equalsIgnoreCase("isbusinessunit"))
      return isbusinessunit;
    else if (fieldName.equalsIgnoreCase("isacctlegalentity"))
      return isacctlegalentity;
    else if (fieldName.equalsIgnoreCase("istransactionsallowed"))
      return istransactionsallowed;
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
  public static OrganizationTypeData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static OrganizationTypeData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_OrgType.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_OrgType.CreatedBy) as CreatedByR, " +
      "        to_char(AD_OrgType.Updated, ?) as updated, " +
      "        to_char(AD_OrgType.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_OrgType.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_OrgType.UpdatedBy) as UpdatedByR," +
      "        AD_OrgType.AD_Client_ID, " +
      "(CASE WHEN AD_OrgType.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_OrgType.AD_Org_ID, " +
      "(CASE WHEN AD_OrgType.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(AD_OrgType.IsActive, 'N') AS IsActive, " +
      "COALESCE(AD_OrgType.IsDefault, 'N') AS IsDefault, " +
      "AD_OrgType.Name, " +
      "AD_OrgType.Description, " +
      "COALESCE(AD_OrgType.IsLegalEntity, 'N') AS IsLegalEntity, " +
      "AD_OrgType.AD_Orgtype_ID, " +
      "COALESCE(AD_OrgType.IsBusinessUnit, 'N') AS IsBusinessUnit, " +
      "COALESCE(AD_OrgType.IsAcctLegalEntity, 'N') AS IsAcctLegalEntity, " +
      "COALESCE(AD_OrgType.IsTransactionsAllowed, 'N') AS IsTransactionsAllowed, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_OrgType left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_OrgType.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_OrgType.AD_Org_ID = table2.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND AD_OrgType.AD_Orgtype_ID = ? " +
      "        AND AD_OrgType.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_OrgType.AD_Org_ID IN (";
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
        OrganizationTypeData objectOrganizationTypeData = new OrganizationTypeData();
        objectOrganizationTypeData.created = UtilSql.getValue(result, "created");
        objectOrganizationTypeData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectOrganizationTypeData.updated = UtilSql.getValue(result, "updated");
        objectOrganizationTypeData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectOrganizationTypeData.updatedby = UtilSql.getValue(result, "updatedby");
        objectOrganizationTypeData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectOrganizationTypeData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectOrganizationTypeData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectOrganizationTypeData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectOrganizationTypeData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectOrganizationTypeData.isactive = UtilSql.getValue(result, "isactive");
        objectOrganizationTypeData.isdefault = UtilSql.getValue(result, "isdefault");
        objectOrganizationTypeData.name = UtilSql.getValue(result, "name");
        objectOrganizationTypeData.description = UtilSql.getValue(result, "description");
        objectOrganizationTypeData.islegalentity = UtilSql.getValue(result, "islegalentity");
        objectOrganizationTypeData.adOrgtypeId = UtilSql.getValue(result, "ad_orgtype_id");
        objectOrganizationTypeData.isbusinessunit = UtilSql.getValue(result, "isbusinessunit");
        objectOrganizationTypeData.isacctlegalentity = UtilSql.getValue(result, "isacctlegalentity");
        objectOrganizationTypeData.istransactionsallowed = UtilSql.getValue(result, "istransactionsallowed");
        objectOrganizationTypeData.language = UtilSql.getValue(result, "language");
        objectOrganizationTypeData.adUserClient = "";
        objectOrganizationTypeData.adOrgClient = "";
        objectOrganizationTypeData.createdby = "";
        objectOrganizationTypeData.trBgcolor = "";
        objectOrganizationTypeData.totalCount = "";
        objectOrganizationTypeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOrganizationTypeData);
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
    OrganizationTypeData objectOrganizationTypeData[] = new OrganizationTypeData[vector.size()];
    vector.copyInto(objectOrganizationTypeData);
    return(objectOrganizationTypeData);
  }

/**
Create a registry
 */
  public static OrganizationTypeData[] set(String updatedby, String adOrgtypeId, String isacctlegalentity, String isdefault, String isbusinessunit, String isactive, String createdby, String islegalentity, String istransactionsallowed, String name, String description, String adOrgId, String adClientId)    throws ServletException {
    OrganizationTypeData objectOrganizationTypeData[] = new OrganizationTypeData[1];
    objectOrganizationTypeData[0] = new OrganizationTypeData();
    objectOrganizationTypeData[0].created = "";
    objectOrganizationTypeData[0].createdbyr = "";
    objectOrganizationTypeData[0].updated = "";
    objectOrganizationTypeData[0].updatedTimeStamp = "";
    objectOrganizationTypeData[0].updatedby = updatedby;
    objectOrganizationTypeData[0].updatedbyr = "";
    objectOrganizationTypeData[0].adClientId = adClientId;
    objectOrganizationTypeData[0].adClientIdr = "";
    objectOrganizationTypeData[0].adOrgId = adOrgId;
    objectOrganizationTypeData[0].adOrgIdr = "";
    objectOrganizationTypeData[0].isactive = isactive;
    objectOrganizationTypeData[0].isdefault = isdefault;
    objectOrganizationTypeData[0].name = name;
    objectOrganizationTypeData[0].description = description;
    objectOrganizationTypeData[0].islegalentity = islegalentity;
    objectOrganizationTypeData[0].adOrgtypeId = adOrgtypeId;
    objectOrganizationTypeData[0].isbusinessunit = isbusinessunit;
    objectOrganizationTypeData[0].isacctlegalentity = isacctlegalentity;
    objectOrganizationTypeData[0].istransactionsallowed = istransactionsallowed;
    objectOrganizationTypeData[0].language = "";
    return objectOrganizationTypeData;
  }

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_OrgType" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , IsActive = (?) , IsDefault = (?) , Name = (?) , Description = (?) , IsLegalEntity = (?) , AD_Orgtype_ID = (?) , IsBusinessUnit = (?) , IsAcctLegalEntity = (?) , IsTransactionsAllowed = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_OrgType.AD_Orgtype_ID = ? " +
      "        AND AD_OrgType.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_OrgType.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islegalentity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbusinessunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isacctlegalentity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istransactionsallowed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtypeId);
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
      "        INSERT INTO AD_OrgType " +
      "        (AD_Client_ID, AD_Org_ID, IsActive, IsDefault, Name, Description, IsLegalEntity, AD_Orgtype_ID, IsBusinessUnit, IsAcctLegalEntity, IsTransactionsAllowed, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islegalentity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbusinessunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isacctlegalentity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istransactionsallowed);
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
      "        DELETE FROM AD_OrgType" +
      "        WHERE AD_OrgType.AD_Orgtype_ID = ? " +
      "        AND AD_OrgType.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_OrgType.AD_Org_ID IN (";
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
      "        DELETE FROM AD_OrgType" +
      "        WHERE AD_OrgType.AD_Orgtype_ID = ? ";

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
      "          FROM AD_OrgType" +
      "         WHERE AD_OrgType.AD_Orgtype_ID = ? ";

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
      "          FROM AD_OrgType" +
      "         WHERE AD_OrgType.AD_Orgtype_ID = ? ";

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
