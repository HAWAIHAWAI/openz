//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.UnproducableItems;

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
class UnproducableItemsE78AA074513741EEA950D72A70B1D502Data implements FieldProvider {
static Logger log4j = Logger.getLogger(UnproducableItemsE78AA074513741EEA950D72A70B1D502Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String cause;
  public String mProductId;
  public String mProductIdr;
  public String adClientId;
  public String zssmProductionplanVId;
  public String zssmProductionplanVIdr;
  public String zssmUnproducableitemsVId;
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
    else if (fieldName.equalsIgnoreCase("cause"))
      return cause;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("zssm_productionplan_v_id") || fieldName.equals("zssmProductionplanVId"))
      return zssmProductionplanVId;
    else if (fieldName.equalsIgnoreCase("zssm_productionplan_v_idr") || fieldName.equals("zssmProductionplanVIdr"))
      return zssmProductionplanVIdr;
    else if (fieldName.equalsIgnoreCase("zssm_unproducableitems_v_id") || fieldName.equals("zssmUnproducableitemsVId"))
      return zssmUnproducableitemsVId;
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
  public static UnproducableItemsE78AA074513741EEA950D72A70B1D502Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static UnproducableItemsE78AA074513741EEA950D72A70B1D502Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssm_unproducableitems_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_unproducableitems_v.CreatedBy) as CreatedByR, " +
      "        to_char(zssm_unproducableitems_v.Updated, ?) as updated, " +
      "        to_char(zssm_unproducableitems_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssm_unproducableitems_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_unproducableitems_v.UpdatedBy) as UpdatedByR," +
      "        zssm_unproducableitems_v.AD_Org_ID, " +
      "zssm_unproducableitems_v.Cause, " +
      "zssm_unproducableitems_v.M_Product_ID, " +
      "(CASE WHEN zssm_unproducableitems_v.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "zssm_unproducableitems_v.AD_Client_ID, " +
      "zssm_unproducableitems_v.Zssm_Productionplan_V_ID, " +
      "(CASE WHEN zssm_unproducableitems_v.Zssm_Productionplan_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS Zssm_Productionplan_V_IDR, " +
      "zssm_unproducableitems_v.Zssm_Unproducableitems_V_ID, " +
      "COALESCE(zssm_unproducableitems_v.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_unproducableitems_v left join (select M_Product_ID, Value, Name from M_Product) table1 on (zssm_unproducableitems_v.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  left join (select Zssm_Productionplan_V_ID, Value, Name from Zssm_Productionplan_V) table2 on (zssm_unproducableitems_v.Zssm_Productionplan_V_ID = table2.Zssm_Productionplan_V_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND zssm_unproducableitems_v.Zssm_Unproducableitems_V_ID = ? " +
      "        AND zssm_unproducableitems_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssm_unproducableitems_v.AD_Org_ID IN (";
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
        UnproducableItemsE78AA074513741EEA950D72A70B1D502Data objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data = new UnproducableItemsE78AA074513741EEA950D72A70B1D502Data();
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.created = UtilSql.getValue(result, "created");
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.updated = UtilSql.getValue(result, "updated");
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.cause = UtilSql.getValue(result, "cause");
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.zssmProductionplanVId = UtilSql.getValue(result, "zssm_productionplan_v_id");
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.zssmProductionplanVIdr = UtilSql.getValue(result, "zssm_productionplan_v_idr");
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.zssmUnproducableitemsVId = UtilSql.getValue(result, "zssm_unproducableitems_v_id");
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.isactive = UtilSql.getValue(result, "isactive");
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.language = UtilSql.getValue(result, "language");
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.adUserClient = "";
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.adOrgClient = "";
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.createdby = "";
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.trBgcolor = "";
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.totalCount = "";
        objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data);
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
    UnproducableItemsE78AA074513741EEA950D72A70B1D502Data objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[] = new UnproducableItemsE78AA074513741EEA950D72A70B1D502Data[vector.size()];
    vector.copyInto(objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data);
    return(objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data);
  }

/**
Create a registry
 */
  public static UnproducableItemsE78AA074513741EEA950D72A70B1D502Data[] set(String createdby, String createdbyr, String adClientId, String mProductId, String mProductIdr, String isactive, String zssmProductionplanVId, String updatedby, String updatedbyr, String zssmUnproducableitemsVId, String adOrgId, String cause)    throws ServletException {
    UnproducableItemsE78AA074513741EEA950D72A70B1D502Data objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[] = new UnproducableItemsE78AA074513741EEA950D72A70B1D502Data[1];
    objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[0] = new UnproducableItemsE78AA074513741EEA950D72A70B1D502Data();
    objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[0].created = "";
    objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[0].createdbyr = createdbyr;
    objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[0].updated = "";
    objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[0].updatedTimeStamp = "";
    objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[0].updatedby = updatedby;
    objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[0].updatedbyr = updatedbyr;
    objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[0].adOrgId = adOrgId;
    objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[0].cause = cause;
    objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[0].mProductId = mProductId;
    objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[0].mProductIdr = mProductIdr;
    objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[0].adClientId = adClientId;
    objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[0].zssmProductionplanVId = zssmProductionplanVId;
    objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[0].zssmProductionplanVIdr = "";
    objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[0].zssmUnproducableitemsVId = zssmUnproducableitemsVId;
    objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[0].isactive = isactive;
    objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data[0].language = "";
    return objectUnproducableItemsE78AA074513741EEA950D72A70B1D502Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef19AFFD123DB84EEA82B316849B452211_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef50C92D01E6C74C2F8268D849F8CF6E28_1(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as M_Product_ID FROM M_Product table1 WHERE table1.isActive='Y' AND table1.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_id");
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
  public static String selectDef896F754378B5490B8DDD4CAEA4718D8D_2(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        UPDATE zssm_unproducableitems_v" +
      "        SET AD_Org_ID = (?) , Cause = (?) , M_Product_ID = (?) , AD_Client_ID = (?) , Zssm_Productionplan_V_ID = (?) , Zssm_Unproducableitems_V_ID = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssm_unproducableitems_v.Zssm_Unproducableitems_V_ID = ? " +
      "        AND zssm_unproducableitems_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_unproducableitems_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cause);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmUnproducableitemsVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmUnproducableitemsVId);
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
      "        INSERT INTO zssm_unproducableitems_v " +
      "        (AD_Org_ID, Cause, M_Product_ID, AD_Client_ID, Zssm_Productionplan_V_ID, Zssm_Unproducableitems_V_ID, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cause);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmUnproducableitemsVId);
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
      "        DELETE FROM zssm_unproducableitems_v" +
      "        WHERE zssm_unproducableitems_v.Zssm_Unproducableitems_V_ID = ? " +
      "        AND zssm_unproducableitems_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_unproducableitems_v.AD_Org_ID IN (";
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
      "        DELETE FROM zssm_unproducableitems_v" +
      "        WHERE zssm_unproducableitems_v.Zssm_Unproducableitems_V_ID = ? ";

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
      "          FROM zssm_unproducableitems_v" +
      "         WHERE zssm_unproducableitems_v.Zssm_Unproducableitems_V_ID = ? ";

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
      "          FROM zssm_unproducableitems_v" +
      "         WHERE zssm_unproducableitems_v.Zssm_Unproducableitems_V_ID = ? ";

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
