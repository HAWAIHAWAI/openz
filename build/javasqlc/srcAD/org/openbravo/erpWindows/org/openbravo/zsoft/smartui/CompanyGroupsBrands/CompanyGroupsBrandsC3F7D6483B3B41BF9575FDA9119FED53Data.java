//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.CompanyGroupsBrands;

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
class CompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data implements FieldProvider {
static Logger log4j = Logger.getLogger(CompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String zssiGroupofcompaniesId;
  public String adClientId;
  public String name;
  public String description;
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
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("zssi_groupofcompanies_id") || fieldName.equals("zssiGroupofcompaniesId"))
      return zssiGroupofcompaniesId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
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
  public static CompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_groupofcompanies.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_groupofcompanies.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_groupofcompanies.Updated, ?) as updated, " +
      "        to_char(zssi_groupofcompanies.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_groupofcompanies.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_groupofcompanies.UpdatedBy) as UpdatedByR," +
      "        zssi_groupofcompanies.AD_Org_ID, " +
      "(CASE WHEN zssi_groupofcompanies.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zssi_groupofcompanies.Zssi_Groupofcompanies_ID, " +
      "zssi_groupofcompanies.AD_Client_ID, " +
      "zssi_groupofcompanies.Name, " +
      "zssi_groupofcompanies.Description, " +
      "COALESCE(zssi_groupofcompanies.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_groupofcompanies left join (select AD_Org_ID, Name from AD_Org) table1 on (zssi_groupofcompanies.AD_Org_ID = table1.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND zssi_groupofcompanies.Zssi_Groupofcompanies_ID = ? " +
      "        AND zssi_groupofcompanies.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_groupofcompanies.AD_Org_ID IN (";
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
        CompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data = new CompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data();
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.created = UtilSql.getValue(result, "created");
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.updated = UtilSql.getValue(result, "updated");
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.zssiGroupofcompaniesId = UtilSql.getValue(result, "zssi_groupofcompanies_id");
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.name = UtilSql.getValue(result, "name");
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.description = UtilSql.getValue(result, "description");
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.isactive = UtilSql.getValue(result, "isactive");
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.language = UtilSql.getValue(result, "language");
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.adUserClient = "";
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.adOrgClient = "";
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.createdby = "";
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.trBgcolor = "";
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.totalCount = "";
        objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data);
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
    CompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[] = new CompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[vector.size()];
    vector.copyInto(objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data);
    return(objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data);
  }

/**
Create a registry
 */
  public static CompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[] set(String updatedby, String updatedbyr, String adClientId, String name, String description, String createdby, String createdbyr, String zssiGroupofcompaniesId, String isactive, String adOrgId)    throws ServletException {
    CompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[] = new CompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[1];
    objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[0] = new CompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data();
    objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[0].created = "";
    objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[0].createdbyr = createdbyr;
    objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[0].updated = "";
    objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[0].updatedTimeStamp = "";
    objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[0].updatedby = updatedby;
    objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[0].updatedbyr = updatedbyr;
    objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[0].adOrgId = adOrgId;
    objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[0].adOrgIdr = "";
    objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[0].zssiGroupofcompaniesId = zssiGroupofcompaniesId;
    objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[0].adClientId = adClientId;
    objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[0].name = name;
    objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[0].description = description;
    objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[0].isactive = isactive;
    objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data[0].language = "";
    return objectCompanyGroupsBrandsC3F7D6483B3B41BF9575FDA9119FED53Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefA36E0B44C90A446AA42FCDD2994265DE_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef40DBBA0BDE1B4D4489B9F3110C8C18C4_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE zssi_groupofcompanies" +
      "        SET AD_Org_ID = (?) , Zssi_Groupofcompanies_ID = (?) , AD_Client_ID = (?) , Name = (?) , Description = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_groupofcompanies.Zssi_Groupofcompanies_ID = ? " +
      "        AND zssi_groupofcompanies.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_groupofcompanies.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiGroupofcompaniesId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiGroupofcompaniesId);
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
      "        INSERT INTO zssi_groupofcompanies " +
      "        (AD_Org_ID, Zssi_Groupofcompanies_ID, AD_Client_ID, Name, Description, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiGroupofcompaniesId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_groupofcompanies" +
      "        WHERE zssi_groupofcompanies.Zssi_Groupofcompanies_ID = ? " +
      "        AND zssi_groupofcompanies.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_groupofcompanies.AD_Org_ID IN (";
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
      "        DELETE FROM zssi_groupofcompanies" +
      "        WHERE zssi_groupofcompanies.Zssi_Groupofcompanies_ID = ? ";

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
      "          FROM zssi_groupofcompanies" +
      "         WHERE zssi_groupofcompanies.Zssi_Groupofcompanies_ID = ? ";

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
      "          FROM zssi_groupofcompanies" +
      "         WHERE zssi_groupofcompanies.Zssi_Groupofcompanies_ID = ? ";

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
