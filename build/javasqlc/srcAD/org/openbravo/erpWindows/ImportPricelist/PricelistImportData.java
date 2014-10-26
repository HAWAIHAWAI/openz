//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ImportPricelist;

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
class PricelistImportData implements FieldProvider {
static Logger log4j = Logger.getLogger(PricelistImportData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String plistname;
  public String iPricelistId;
  public String plistversionname;
  public String adClientId;
  public String productvalue;
  public String adOrgId;
  public String pricelist;
  public String pricestd;
  public String pricelimit;
  public String isactive;
  public String isimported;
  public String btnprocess;
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
    else if (fieldName.equalsIgnoreCase("plistname"))
      return plistname;
    else if (fieldName.equalsIgnoreCase("i_pricelist_id") || fieldName.equals("iPricelistId"))
      return iPricelistId;
    else if (fieldName.equalsIgnoreCase("plistversionname"))
      return plistversionname;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("productvalue"))
      return productvalue;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isimported"))
      return isimported;
    else if (fieldName.equalsIgnoreCase("btnprocess"))
      return btnprocess;
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
  public static PricelistImportData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PricelistImportData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(I_pricelist.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = I_pricelist.CreatedBy) as CreatedByR, " +
      "        to_char(I_pricelist.Updated, ?) as updated, " +
      "        to_char(I_pricelist.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        I_pricelist.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = I_pricelist.UpdatedBy) as UpdatedByR," +
      "        I_pricelist.Plistname, " +
      "I_pricelist.I_Pricelist_ID, " +
      "I_pricelist.Plistversionname, " +
      "I_pricelist.AD_Client_ID, " +
      "I_pricelist.Productvalue, " +
      "I_pricelist.AD_Org_ID, " +
      "I_pricelist.Pricelist, " +
      "I_pricelist.Pricestd, " +
      "I_pricelist.Pricelimit, " +
      "COALESCE(I_pricelist.Isactive, 'N') AS Isactive, " +
      "COALESCE(I_pricelist.Isimported, 'N') AS Isimported, " +
      "I_pricelist.Btnprocess, " +
      "        ? AS LANGUAGE " +
      "        FROM I_pricelist" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND I_pricelist.I_Pricelist_ID = ? " +
      "        AND I_pricelist.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND I_pricelist.AD_Org_ID IN (";
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
        PricelistImportData objectPricelistImportData = new PricelistImportData();
        objectPricelistImportData.created = UtilSql.getValue(result, "created");
        objectPricelistImportData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPricelistImportData.updated = UtilSql.getValue(result, "updated");
        objectPricelistImportData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPricelistImportData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPricelistImportData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPricelistImportData.plistname = UtilSql.getValue(result, "plistname");
        objectPricelistImportData.iPricelistId = UtilSql.getValue(result, "i_pricelist_id");
        objectPricelistImportData.plistversionname = UtilSql.getValue(result, "plistversionname");
        objectPricelistImportData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPricelistImportData.productvalue = UtilSql.getValue(result, "productvalue");
        objectPricelistImportData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPricelistImportData.pricelist = UtilSql.getValue(result, "pricelist");
        objectPricelistImportData.pricestd = UtilSql.getValue(result, "pricestd");
        objectPricelistImportData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectPricelistImportData.isactive = UtilSql.getValue(result, "isactive");
        objectPricelistImportData.isimported = UtilSql.getValue(result, "isimported");
        objectPricelistImportData.btnprocess = UtilSql.getValue(result, "btnprocess");
        objectPricelistImportData.language = UtilSql.getValue(result, "language");
        objectPricelistImportData.adUserClient = "";
        objectPricelistImportData.adOrgClient = "";
        objectPricelistImportData.createdby = "";
        objectPricelistImportData.trBgcolor = "";
        objectPricelistImportData.totalCount = "";
        objectPricelistImportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPricelistImportData);
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
    PricelistImportData objectPricelistImportData[] = new PricelistImportData[vector.size()];
    vector.copyInto(objectPricelistImportData);
    return(objectPricelistImportData);
  }

/**
Create a registry
 */
  public static PricelistImportData[] set(String productvalue, String adOrgId, String pricelist, String plistversionname, String pricestd, String plistname, String createdby, String createdbyr, String updatedby, String updatedbyr, String isimported, String btnprocess, String iPricelistId, String isactive, String pricelimit, String adClientId)    throws ServletException {
    PricelistImportData objectPricelistImportData[] = new PricelistImportData[1];
    objectPricelistImportData[0] = new PricelistImportData();
    objectPricelistImportData[0].created = "";
    objectPricelistImportData[0].createdbyr = createdbyr;
    objectPricelistImportData[0].updated = "";
    objectPricelistImportData[0].updatedTimeStamp = "";
    objectPricelistImportData[0].updatedby = updatedby;
    objectPricelistImportData[0].updatedbyr = updatedbyr;
    objectPricelistImportData[0].plistname = plistname;
    objectPricelistImportData[0].iPricelistId = iPricelistId;
    objectPricelistImportData[0].plistversionname = plistversionname;
    objectPricelistImportData[0].adClientId = adClientId;
    objectPricelistImportData[0].productvalue = productvalue;
    objectPricelistImportData[0].adOrgId = adOrgId;
    objectPricelistImportData[0].pricelist = pricelist;
    objectPricelistImportData[0].pricestd = pricestd;
    objectPricelistImportData[0].pricelimit = pricelimit;
    objectPricelistImportData[0].isactive = isactive;
    objectPricelistImportData[0].isimported = isimported;
    objectPricelistImportData[0].btnprocess = btnprocess;
    objectPricelistImportData[0].language = "";
    return objectPricelistImportData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef3CBB14D0B8AD43FC8082540C9DCB2C08_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef79ADCD5E407A45FB93C7C8ECB65FF040_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_pricelist" +
      "        SET Plistname = (?) , I_Pricelist_ID = (?) , Plistversionname = (?) , AD_Client_ID = (?) , Productvalue = (?) , AD_Org_ID = (?) , Pricelist = TO_NUMBER(?) , Pricestd = TO_NUMBER(?) , Pricelimit = TO_NUMBER(?) , Isactive = (?) , Isimported = (?) , Btnprocess = (?) , updated = now(), updatedby = ? " +
      "        WHERE I_pricelist.I_Pricelist_ID = ? " +
      "        AND I_pricelist.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND I_pricelist.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plistname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plistversionname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isimported);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, btnprocess);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iPricelistId);
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
      "        INSERT INTO I_pricelist " +
      "        (Plistname, I_Pricelist_ID, Plistversionname, AD_Client_ID, Productvalue, AD_Org_ID, Pricelist, Pricestd, Pricelimit, Isactive, Isimported, Btnprocess, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plistname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plistversionname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isimported);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, btnprocess);
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
      "        DELETE FROM I_pricelist" +
      "        WHERE I_pricelist.I_Pricelist_ID = ? " +
      "        AND I_pricelist.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND I_pricelist.AD_Org_ID IN (";
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
      "        DELETE FROM I_pricelist" +
      "        WHERE I_pricelist.I_Pricelist_ID = ? ";

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
      "          FROM I_pricelist" +
      "         WHERE I_pricelist.I_Pricelist_ID = ? ";

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
      "          FROM I_pricelist" +
      "         WHERE I_pricelist.I_Pricelist_ID = ? ";

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
