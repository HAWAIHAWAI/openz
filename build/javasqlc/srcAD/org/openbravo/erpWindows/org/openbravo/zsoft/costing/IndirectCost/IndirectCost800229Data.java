//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.costing.IndirectCost;

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
class IndirectCost800229Data implements FieldProvider {
static Logger log4j = Logger.getLogger(IndirectCost800229Data.class);
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
  public String aAssetId;
  public String aAssetIdr;
  public String costType;
  public String costTyper;
  public String addauto2project;
  public String maIndirectCostId;
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
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("cost_type") || fieldName.equals("costType"))
      return costType;
    else if (fieldName.equalsIgnoreCase("cost_typer") || fieldName.equals("costTyper"))
      return costTyper;
    else if (fieldName.equalsIgnoreCase("addauto2project"))
      return addauto2project;
    else if (fieldName.equalsIgnoreCase("ma_indirect_cost_id") || fieldName.equals("maIndirectCostId"))
      return maIndirectCostId;
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
  public static IndirectCost800229Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static IndirectCost800229Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_Indirect_Cost.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Indirect_Cost.CreatedBy) as CreatedByR, " +
      "        to_char(MA_Indirect_Cost.Updated, ?) as updated, " +
      "        to_char(MA_Indirect_Cost.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_Indirect_Cost.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Indirect_Cost.UpdatedBy) as UpdatedByR," +
      "        MA_Indirect_Cost.AD_Client_ID, " +
      "(CASE WHEN MA_Indirect_Cost.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MA_Indirect_Cost.AD_Org_ID, " +
      "(CASE WHEN MA_Indirect_Cost.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MA_Indirect_Cost.Name, " +
      "MA_Indirect_Cost.Description, " +
      "COALESCE(MA_Indirect_Cost.IsActive, 'N') AS IsActive, " +
      "MA_Indirect_Cost.A_Asset_ID, " +
      "(CASE WHEN MA_Indirect_Cost.A_Asset_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "MA_Indirect_Cost.Cost_Type, " +
      "(CASE WHEN MA_Indirect_Cost.Cost_Type IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS Cost_TypeR, " +
      "COALESCE(MA_Indirect_Cost.Addauto2project, 'N') AS Addauto2project, " +
      "MA_Indirect_Cost.MA_Indirect_Cost_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_Indirect_Cost left join (select AD_Client_ID, Name from AD_Client) table1 on (MA_Indirect_Cost.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MA_Indirect_Cost.AD_Org_ID = table2.AD_Org_ID) left join (select A_Asset_ID, Name from A_Asset) table3 on (MA_Indirect_Cost.A_Asset_ID =  table3.A_Asset_ID) left join ad_ref_list_v list1 on (MA_Indirect_Cost.Cost_Type = list1.value and list1.ad_reference_id = '800089' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND MA_Indirect_Cost.MA_Indirect_Cost_ID = ? " +
      "        AND MA_Indirect_Cost.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_Indirect_Cost.AD_Org_ID IN (";
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
        IndirectCost800229Data objectIndirectCost800229Data = new IndirectCost800229Data();
        objectIndirectCost800229Data.created = UtilSql.getValue(result, "created");
        objectIndirectCost800229Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectIndirectCost800229Data.updated = UtilSql.getValue(result, "updated");
        objectIndirectCost800229Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectIndirectCost800229Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectIndirectCost800229Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectIndirectCost800229Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectIndirectCost800229Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectIndirectCost800229Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectIndirectCost800229Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectIndirectCost800229Data.name = UtilSql.getValue(result, "name");
        objectIndirectCost800229Data.description = UtilSql.getValue(result, "description");
        objectIndirectCost800229Data.isactive = UtilSql.getValue(result, "isactive");
        objectIndirectCost800229Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectIndirectCost800229Data.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectIndirectCost800229Data.costType = UtilSql.getValue(result, "cost_type");
        objectIndirectCost800229Data.costTyper = UtilSql.getValue(result, "cost_typer");
        objectIndirectCost800229Data.addauto2project = UtilSql.getValue(result, "addauto2project");
        objectIndirectCost800229Data.maIndirectCostId = UtilSql.getValue(result, "ma_indirect_cost_id");
        objectIndirectCost800229Data.language = UtilSql.getValue(result, "language");
        objectIndirectCost800229Data.adUserClient = "";
        objectIndirectCost800229Data.adOrgClient = "";
        objectIndirectCost800229Data.createdby = "";
        objectIndirectCost800229Data.trBgcolor = "";
        objectIndirectCost800229Data.totalCount = "";
        objectIndirectCost800229Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectIndirectCost800229Data);
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
    IndirectCost800229Data objectIndirectCost800229Data[] = new IndirectCost800229Data[vector.size()];
    vector.copyInto(objectIndirectCost800229Data);
    return(objectIndirectCost800229Data);
  }

/**
Create a registry
 */
  public static IndirectCost800229Data[] set(String adClientId, String name, String createdby, String createdbyr, String addauto2project, String adOrgId, String maIndirectCostId, String description, String updatedby, String updatedbyr, String aAssetId, String isactive, String costType)    throws ServletException {
    IndirectCost800229Data objectIndirectCost800229Data[] = new IndirectCost800229Data[1];
    objectIndirectCost800229Data[0] = new IndirectCost800229Data();
    objectIndirectCost800229Data[0].created = "";
    objectIndirectCost800229Data[0].createdbyr = createdbyr;
    objectIndirectCost800229Data[0].updated = "";
    objectIndirectCost800229Data[0].updatedTimeStamp = "";
    objectIndirectCost800229Data[0].updatedby = updatedby;
    objectIndirectCost800229Data[0].updatedbyr = updatedbyr;
    objectIndirectCost800229Data[0].adClientId = adClientId;
    objectIndirectCost800229Data[0].adClientIdr = "";
    objectIndirectCost800229Data[0].adOrgId = adOrgId;
    objectIndirectCost800229Data[0].adOrgIdr = "";
    objectIndirectCost800229Data[0].name = name;
    objectIndirectCost800229Data[0].description = description;
    objectIndirectCost800229Data[0].isactive = isactive;
    objectIndirectCost800229Data[0].aAssetId = aAssetId;
    objectIndirectCost800229Data[0].aAssetIdr = "";
    objectIndirectCost800229Data[0].costType = costType;
    objectIndirectCost800229Data[0].costTyper = "";
    objectIndirectCost800229Data[0].addauto2project = addauto2project;
    objectIndirectCost800229Data[0].maIndirectCostId = maIndirectCostId;
    objectIndirectCost800229Data[0].language = "";
    return objectIndirectCost800229Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef803181_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef803183_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        UPDATE MA_Indirect_Cost" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , Name = (?) , Description = (?) , IsActive = (?) , A_Asset_ID = (?) , Cost_Type = (?) , Addauto2project = (?) , MA_Indirect_Cost_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE MA_Indirect_Cost.MA_Indirect_Cost_ID = ? " +
      "        AND MA_Indirect_Cost.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Indirect_Cost.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, addauto2project);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostId);
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
      "        INSERT INTO MA_Indirect_Cost " +
      "        (AD_Client_ID, AD_Org_ID, Name, Description, IsActive, A_Asset_ID, Cost_Type, Addauto2project, MA_Indirect_Cost_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, addauto2project);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostId);
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
      "        DELETE FROM MA_Indirect_Cost" +
      "        WHERE MA_Indirect_Cost.MA_Indirect_Cost_ID = ? " +
      "        AND MA_Indirect_Cost.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Indirect_Cost.AD_Org_ID IN (";
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
      "        DELETE FROM MA_Indirect_Cost" +
      "        WHERE MA_Indirect_Cost.MA_Indirect_Cost_ID = ? ";

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
      "          FROM MA_Indirect_Cost" +
      "         WHERE MA_Indirect_Cost.MA_Indirect_Cost_ID = ? ";

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
      "          FROM MA_Indirect_Cost" +
      "         WHERE MA_Indirect_Cost.MA_Indirect_Cost_ID = ? ";

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
