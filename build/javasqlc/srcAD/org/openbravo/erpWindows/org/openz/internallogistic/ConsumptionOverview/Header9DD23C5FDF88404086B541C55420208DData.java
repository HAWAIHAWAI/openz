//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openz.internallogistic.ConsumptionOverview;

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
class Header9DD23C5FDF88404086B541C55420208DData implements FieldProvider {
static Logger log4j = Logger.getLogger(Header9DD23C5FDF88404086B541C55420208DData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mInternalConsumptionlineId;
  public String mInternalConsumptionlineIdr;
  public String mProductId;
  public String mProductIdr;
  public String movementdate;
  public String movementqty;
  public String costs;
  public String costtotal;
  public String movementtype;
  public String movementtyper;
  public String adUserId;
  public String adUserIdr;
  public String supervisorId;
  public String ilsConsumptionOverviewVId;
  public String oe;
  public String adClientId;
  public String adOrgId;
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
    else if (fieldName.equalsIgnoreCase("m_internal_consumptionline_id") || fieldName.equals("mInternalConsumptionlineId"))
      return mInternalConsumptionlineId;
    else if (fieldName.equalsIgnoreCase("m_internal_consumptionline_idr") || fieldName.equals("mInternalConsumptionlineIdr"))
      return mInternalConsumptionlineIdr;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("costs"))
      return costs;
    else if (fieldName.equalsIgnoreCase("costtotal"))
      return costtotal;
    else if (fieldName.equalsIgnoreCase("movementtype"))
      return movementtype;
    else if (fieldName.equalsIgnoreCase("movementtyper"))
      return movementtyper;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("supervisor_id") || fieldName.equals("supervisorId"))
      return supervisorId;
    else if (fieldName.equalsIgnoreCase("ils_consumption_overview_v_id") || fieldName.equals("ilsConsumptionOverviewVId"))
      return ilsConsumptionOverviewVId;
    else if (fieldName.equalsIgnoreCase("oe"))
      return oe;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
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
  public static Header9DD23C5FDF88404086B541C55420208DData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Header9DD23C5FDF88404086B541C55420208DData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ils_consumption_overview_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ils_consumption_overview_v.CreatedBy) as CreatedByR, " +
      "        to_char(ils_consumption_overview_v.Updated, ?) as updated, " +
      "        to_char(ils_consumption_overview_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ils_consumption_overview_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ils_consumption_overview_v.UpdatedBy) as UpdatedByR," +
      "        ils_consumption_overview_v.M_Internal_Consumptionline_ID, " +
      "(CASE WHEN ils_consumption_overview_v.M_Internal_Consumptionline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.MovementQty), ''))),'') ) END) AS M_Internal_Consumptionline_IDR, " +
      "ils_consumption_overview_v.M_Product_ID, " +
      "(CASE WHEN ils_consumption_overview_v.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "ils_consumption_overview_v.Movementdate, " +
      "ils_consumption_overview_v.Movementqty, " +
      "ils_consumption_overview_v.Costs, " +
      "ils_consumption_overview_v.Costtotal, " +
      "ils_consumption_overview_v.Movementtype, " +
      "(CASE WHEN ils_consumption_overview_v.Movementtype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS MovementtypeR, " +
      "ils_consumption_overview_v.AD_User_ID, " +
      "(CASE WHEN ils_consumption_overview_v.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "ils_consumption_overview_v.Supervisor_ID, " +
      "ils_consumption_overview_v.ILS_Consumption_Overview_V_ID, " +
      "ils_consumption_overview_v.Oe, " +
      "ils_consumption_overview_v.AD_Client_ID, " +
      "ils_consumption_overview_v.AD_Org_ID, " +
      "COALESCE(ils_consumption_overview_v.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM ils_consumption_overview_v left join (select M_Internal_Consumptionline_ID, M_Internal_Consumption_ID, M_Product_ID, MovementQty from M_Internal_Consumptionline) table1 on (ils_consumption_overview_v.M_Internal_Consumptionline_ID = table1.M_Internal_Consumptionline_ID) left join (select M_Internal_Consumption_ID, Name from M_Internal_Consumption) table2 on (table1.M_Internal_Consumption_ID = table2.M_Internal_Consumption_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (table1.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  left join (select M_Product_ID, Value, Name from M_Product) table4 on (ils_consumption_overview_v.M_Product_ID = table4.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL4 on (table4.M_Product_ID = tableTRL4.M_Product_ID and tableTRL4.AD_Language = ?)  left join ad_ref_list_v list1 on (ils_consumption_overview_v.Movementtype = list1.value and list1.ad_reference_id = '189' and list1.ad_language = ?)  left join (select AD_User_ID, Name from AD_User) table5 on (ils_consumption_overview_v.AD_User_ID = table5.AD_User_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND ils_consumption_overview_v.ILS_Consumption_Overview_V_ID = ? " +
      "        AND ils_consumption_overview_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ils_consumption_overview_v.AD_Org_ID IN (";
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
        Header9DD23C5FDF88404086B541C55420208DData objectHeader9DD23C5FDF88404086B541C55420208DData = new Header9DD23C5FDF88404086B541C55420208DData();
        objectHeader9DD23C5FDF88404086B541C55420208DData.created = UtilSql.getValue(result, "created");
        objectHeader9DD23C5FDF88404086B541C55420208DData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectHeader9DD23C5FDF88404086B541C55420208DData.updated = UtilSql.getValue(result, "updated");
        objectHeader9DD23C5FDF88404086B541C55420208DData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectHeader9DD23C5FDF88404086B541C55420208DData.updatedby = UtilSql.getValue(result, "updatedby");
        objectHeader9DD23C5FDF88404086B541C55420208DData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectHeader9DD23C5FDF88404086B541C55420208DData.mInternalConsumptionlineId = UtilSql.getValue(result, "m_internal_consumptionline_id");
        objectHeader9DD23C5FDF88404086B541C55420208DData.mInternalConsumptionlineIdr = UtilSql.getValue(result, "m_internal_consumptionline_idr");
        objectHeader9DD23C5FDF88404086B541C55420208DData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectHeader9DD23C5FDF88404086B541C55420208DData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectHeader9DD23C5FDF88404086B541C55420208DData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectHeader9DD23C5FDF88404086B541C55420208DData.movementqty = UtilSql.getValue(result, "movementqty");
        objectHeader9DD23C5FDF88404086B541C55420208DData.costs = UtilSql.getValue(result, "costs");
        objectHeader9DD23C5FDF88404086B541C55420208DData.costtotal = UtilSql.getValue(result, "costtotal");
        objectHeader9DD23C5FDF88404086B541C55420208DData.movementtype = UtilSql.getValue(result, "movementtype");
        objectHeader9DD23C5FDF88404086B541C55420208DData.movementtyper = UtilSql.getValue(result, "movementtyper");
        objectHeader9DD23C5FDF88404086B541C55420208DData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectHeader9DD23C5FDF88404086B541C55420208DData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectHeader9DD23C5FDF88404086B541C55420208DData.supervisorId = UtilSql.getValue(result, "supervisor_id");
        objectHeader9DD23C5FDF88404086B541C55420208DData.ilsConsumptionOverviewVId = UtilSql.getValue(result, "ils_consumption_overview_v_id");
        objectHeader9DD23C5FDF88404086B541C55420208DData.oe = UtilSql.getValue(result, "oe");
        objectHeader9DD23C5FDF88404086B541C55420208DData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectHeader9DD23C5FDF88404086B541C55420208DData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectHeader9DD23C5FDF88404086B541C55420208DData.isactive = UtilSql.getValue(result, "isactive");
        objectHeader9DD23C5FDF88404086B541C55420208DData.language = UtilSql.getValue(result, "language");
        objectHeader9DD23C5FDF88404086B541C55420208DData.adUserClient = "";
        objectHeader9DD23C5FDF88404086B541C55420208DData.adOrgClient = "";
        objectHeader9DD23C5FDF88404086B541C55420208DData.createdby = "";
        objectHeader9DD23C5FDF88404086B541C55420208DData.trBgcolor = "";
        objectHeader9DD23C5FDF88404086B541C55420208DData.totalCount = "";
        objectHeader9DD23C5FDF88404086B541C55420208DData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectHeader9DD23C5FDF88404086B541C55420208DData);
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
    Header9DD23C5FDF88404086B541C55420208DData objectHeader9DD23C5FDF88404086B541C55420208DData[] = new Header9DD23C5FDF88404086B541C55420208DData[vector.size()];
    vector.copyInto(objectHeader9DD23C5FDF88404086B541C55420208DData);
    return(objectHeader9DD23C5FDF88404086B541C55420208DData);
  }

/**
Create a registry
 */
  public static Header9DD23C5FDF88404086B541C55420208DData[] set(String movementtype, String createdby, String createdbyr, String updatedby, String updatedbyr, String costtotal, String isactive, String adOrgId, String mProductId, String mProductIdr, String oe, String movementqty, String adUserId, String adClientId, String movementdate, String costs, String mInternalConsumptionlineId, String supervisorId, String ilsConsumptionOverviewVId)    throws ServletException {
    Header9DD23C5FDF88404086B541C55420208DData objectHeader9DD23C5FDF88404086B541C55420208DData[] = new Header9DD23C5FDF88404086B541C55420208DData[1];
    objectHeader9DD23C5FDF88404086B541C55420208DData[0] = new Header9DD23C5FDF88404086B541C55420208DData();
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].created = "";
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].createdbyr = createdbyr;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].updated = "";
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].updatedTimeStamp = "";
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].updatedby = updatedby;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].updatedbyr = updatedbyr;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].mInternalConsumptionlineId = mInternalConsumptionlineId;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].mInternalConsumptionlineIdr = "";
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].mProductId = mProductId;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].mProductIdr = mProductIdr;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].movementdate = movementdate;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].movementqty = movementqty;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].costs = costs;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].costtotal = costtotal;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].movementtype = movementtype;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].movementtyper = "";
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].adUserId = adUserId;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].adUserIdr = "";
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].supervisorId = supervisorId;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].ilsConsumptionOverviewVId = ilsConsumptionOverviewVId;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].oe = oe;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].adClientId = adClientId;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].adOrgId = adOrgId;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].isactive = isactive;
    objectHeader9DD23C5FDF88404086B541C55420208DData[0].language = "";
    return objectHeader9DD23C5FDF88404086B541C55420208DData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefE69397393CA0419282A32E714C2386D2_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef86D2483FD3044AA98264CE6EF86B674A_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef57AC0E3A9D1A4B30BE7585B57BC0B9CC_2(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE ils_consumption_overview_v" +
      "        SET M_Internal_Consumptionline_ID = (?) , M_Product_ID = (?) , Movementdate = TO_DATE(?) , Movementqty = TO_NUMBER(?) , Costs = TO_NUMBER(?) , Costtotal = TO_NUMBER(?) , Movementtype = (?) , AD_User_ID = (?) , Supervisor_ID = (?) , ILS_Consumption_Overview_V_ID = (?) , Oe = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE ils_consumption_overview_v.ILS_Consumption_Overview_V_ID = ? " +
      "        AND ils_consumption_overview_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ils_consumption_overview_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costs);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, supervisorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsConsumptionOverviewVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, oe);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsConsumptionOverviewVId);
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
      "        INSERT INTO ils_consumption_overview_v " +
      "        (M_Internal_Consumptionline_ID, M_Product_ID, Movementdate, Movementqty, Costs, Costtotal, Movementtype, AD_User_ID, Supervisor_ID, ILS_Consumption_Overview_V_ID, Oe, AD_Client_ID, AD_Org_ID, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costs);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, supervisorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsConsumptionOverviewVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, oe);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
      "        DELETE FROM ils_consumption_overview_v" +
      "        WHERE ils_consumption_overview_v.ILS_Consumption_Overview_V_ID = ? " +
      "        AND ils_consumption_overview_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ils_consumption_overview_v.AD_Org_ID IN (";
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
      "        DELETE FROM ils_consumption_overview_v" +
      "        WHERE ils_consumption_overview_v.ILS_Consumption_Overview_V_ID = ? ";

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
      "          FROM ils_consumption_overview_v" +
      "         WHERE ils_consumption_overview_v.ILS_Consumption_Overview_V_ID = ? ";

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
      "          FROM ils_consumption_overview_v" +
      "         WHERE ils_consumption_overview_v.ILS_Consumption_Overview_V_ID = ? ";

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
