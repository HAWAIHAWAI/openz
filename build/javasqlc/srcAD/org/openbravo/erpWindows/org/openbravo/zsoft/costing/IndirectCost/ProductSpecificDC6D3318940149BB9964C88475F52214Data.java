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
class ProductSpecificDC6D3318940149BB9964C88475F52214Data implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductSpecificDC6D3318940149BB9964C88475F52214Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String maIndirectCostValueId;
  public String maIndirectCostValueIdr;
  public String maIndirectCostValueProductId;
  public String isactive;
  public String adClientId;
  public String mProductId;
  public String mProductIdr;
  public String adOrgId;
  public String cost;
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
    else if (fieldName.equalsIgnoreCase("ma_indirect_cost_value_id") || fieldName.equals("maIndirectCostValueId"))
      return maIndirectCostValueId;
    else if (fieldName.equalsIgnoreCase("ma_indirect_cost_value_idr") || fieldName.equals("maIndirectCostValueIdr"))
      return maIndirectCostValueIdr;
    else if (fieldName.equalsIgnoreCase("ma_indirect_cost_value_product_id") || fieldName.equals("maIndirectCostValueProductId"))
      return maIndirectCostValueProductId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("cost"))
      return cost;
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
  public static ProductSpecificDC6D3318940149BB9964C88475F52214Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maIndirectCostValueId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maIndirectCostValueId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProductSpecificDC6D3318940149BB9964C88475F52214Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maIndirectCostValueId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ma_indirect_cost_value_product.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ma_indirect_cost_value_product.CreatedBy) as CreatedByR, " +
      "        to_char(ma_indirect_cost_value_product.Updated, ?) as updated, " +
      "        to_char(ma_indirect_cost_value_product.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ma_indirect_cost_value_product.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ma_indirect_cost_value_product.UpdatedBy) as UpdatedByR," +
      "        ma_indirect_cost_value_product.MA_Indirect_Cost_Value_ID, " +
      "(CASE WHEN ma_indirect_cost_value_product.MA_Indirect_Cost_Value_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table1.DateFrom, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.empCost), ''))),'') ) END) AS MA_Indirect_Cost_Value_IDR, " +
      "ma_indirect_cost_value_product.MA_Indirect_Cost_Value_Product_ID, " +
      "COALESCE(ma_indirect_cost_value_product.Isactive, 'N') AS Isactive, " +
      "ma_indirect_cost_value_product.AD_Client_ID, " +
      "ma_indirect_cost_value_product.M_Product_ID, " +
      "(CASE WHEN ma_indirect_cost_value_product.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "ma_indirect_cost_value_product.AD_Org_ID, " +
      "ma_indirect_cost_value_product.Cost, " +
      "        ? AS LANGUAGE " +
      "        FROM ma_indirect_cost_value_product left join (select MA_Indirect_Cost_Value_ID, MA_Indirect_Cost_ID, DateFrom, empCost from MA_Indirect_Cost_Value) table1 on (ma_indirect_cost_value_product.MA_Indirect_Cost_Value_ID = table1.MA_Indirect_Cost_Value_ID) left join (select MA_Indirect_Cost_ID, Name from MA_Indirect_Cost) table2 on (table1.MA_Indirect_Cost_ID = table2.MA_Indirect_Cost_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (ma_indirect_cost_value_product.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maIndirectCostValueId==null || maIndirectCostValueId.equals(""))?"":"  AND ma_indirect_cost_value_product.MA_Indirect_Cost_Value_ID = ?  ");
    strSql = strSql + 
      "        AND ma_indirect_cost_value_product.MA_Indirect_Cost_Value_Product_ID = ? " +
      "        AND ma_indirect_cost_value_product.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ma_indirect_cost_value_product.AD_Org_ID IN (";
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
      if (maIndirectCostValueId != null && !(maIndirectCostValueId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostValueId);
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
        ProductSpecificDC6D3318940149BB9964C88475F52214Data objectProductSpecificDC6D3318940149BB9964C88475F52214Data = new ProductSpecificDC6D3318940149BB9964C88475F52214Data();
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.created = UtilSql.getValue(result, "created");
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.updated = UtilSql.getValue(result, "updated");
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.maIndirectCostValueId = UtilSql.getValue(result, "ma_indirect_cost_value_id");
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.maIndirectCostValueIdr = UtilSql.getValue(result, "ma_indirect_cost_value_idr");
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.maIndirectCostValueProductId = UtilSql.getValue(result, "ma_indirect_cost_value_product_id");
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.isactive = UtilSql.getValue(result, "isactive");
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.cost = UtilSql.getValue(result, "cost");
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.language = UtilSql.getValue(result, "language");
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.adUserClient = "";
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.adOrgClient = "";
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.createdby = "";
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.trBgcolor = "";
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.totalCount = "";
        objectProductSpecificDC6D3318940149BB9964C88475F52214Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductSpecificDC6D3318940149BB9964C88475F52214Data);
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
    ProductSpecificDC6D3318940149BB9964C88475F52214Data objectProductSpecificDC6D3318940149BB9964C88475F52214Data[] = new ProductSpecificDC6D3318940149BB9964C88475F52214Data[vector.size()];
    vector.copyInto(objectProductSpecificDC6D3318940149BB9964C88475F52214Data);
    return(objectProductSpecificDC6D3318940149BB9964C88475F52214Data);
  }

/**
Create a registry
 */
  public static ProductSpecificDC6D3318940149BB9964C88475F52214Data[] set(String maIndirectCostValueId, String updatedby, String updatedbyr, String adOrgId, String maIndirectCostValueProductId, String adClientId, String isactive, String mProductId, String mProductIdr, String createdby, String createdbyr, String cost)    throws ServletException {
    ProductSpecificDC6D3318940149BB9964C88475F52214Data objectProductSpecificDC6D3318940149BB9964C88475F52214Data[] = new ProductSpecificDC6D3318940149BB9964C88475F52214Data[1];
    objectProductSpecificDC6D3318940149BB9964C88475F52214Data[0] = new ProductSpecificDC6D3318940149BB9964C88475F52214Data();
    objectProductSpecificDC6D3318940149BB9964C88475F52214Data[0].created = "";
    objectProductSpecificDC6D3318940149BB9964C88475F52214Data[0].createdbyr = createdbyr;
    objectProductSpecificDC6D3318940149BB9964C88475F52214Data[0].updated = "";
    objectProductSpecificDC6D3318940149BB9964C88475F52214Data[0].updatedTimeStamp = "";
    objectProductSpecificDC6D3318940149BB9964C88475F52214Data[0].updatedby = updatedby;
    objectProductSpecificDC6D3318940149BB9964C88475F52214Data[0].updatedbyr = updatedbyr;
    objectProductSpecificDC6D3318940149BB9964C88475F52214Data[0].maIndirectCostValueId = maIndirectCostValueId;
    objectProductSpecificDC6D3318940149BB9964C88475F52214Data[0].maIndirectCostValueIdr = "";
    objectProductSpecificDC6D3318940149BB9964C88475F52214Data[0].maIndirectCostValueProductId = maIndirectCostValueProductId;
    objectProductSpecificDC6D3318940149BB9964C88475F52214Data[0].isactive = isactive;
    objectProductSpecificDC6D3318940149BB9964C88475F52214Data[0].adClientId = adClientId;
    objectProductSpecificDC6D3318940149BB9964C88475F52214Data[0].mProductId = mProductId;
    objectProductSpecificDC6D3318940149BB9964C88475F52214Data[0].mProductIdr = mProductIdr;
    objectProductSpecificDC6D3318940149BB9964C88475F52214Data[0].adOrgId = adOrgId;
    objectProductSpecificDC6D3318940149BB9964C88475F52214Data[0].cost = cost;
    objectProductSpecificDC6D3318940149BB9964C88475F52214Data[0].language = "";
    return objectProductSpecificDC6D3318940149BB9964C88475F52214Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef200512AAB7274C4C91FA3E923C1817B2_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefBA45323C6CDC40EEA1C297A806CEE75F_1(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef30DD6C8BD1B1414DB274131D54681374_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT ma_indirect_cost_value_product.MA_Indirect_Cost_Value_ID AS NAME" +
      "        FROM ma_indirect_cost_value_product" +
      "        WHERE ma_indirect_cost_value_product.MA_Indirect_Cost_Value_Product_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String maIndirectCostValueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(table1.DateFrom, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.empCost), ''))) AS NAME FROM MA_Indirect_Cost_Value left join (select MA_Indirect_Cost_Value_ID, MA_Indirect_Cost_ID, DateFrom, empCost from MA_Indirect_Cost_Value) table1 on (MA_Indirect_Cost_Value.MA_Indirect_Cost_Value_ID = table1.MA_Indirect_Cost_Value_ID) left join (select MA_Indirect_Cost_ID, Name from MA_Indirect_Cost) table2 on (table1.MA_Indirect_Cost_ID = table2.MA_Indirect_Cost_ID) WHERE MA_Indirect_Cost_Value.MA_Indirect_Cost_Value_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostValueId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String maIndirectCostValueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(table1.DateFrom, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.empCost), ''))) AS NAME FROM MA_Indirect_Cost_Value left join (select MA_Indirect_Cost_Value_ID, MA_Indirect_Cost_ID, DateFrom, empCost from MA_Indirect_Cost_Value) table1 on (MA_Indirect_Cost_Value.MA_Indirect_Cost_Value_ID = table1.MA_Indirect_Cost_Value_ID) left join (select MA_Indirect_Cost_ID, Name from MA_Indirect_Cost) table2 on (table1.MA_Indirect_Cost_ID = table2.MA_Indirect_Cost_ID) WHERE MA_Indirect_Cost_Value.MA_Indirect_Cost_Value_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostValueId);

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
      "        UPDATE ma_indirect_cost_value_product" +
      "        SET MA_Indirect_Cost_Value_ID = (?) , MA_Indirect_Cost_Value_Product_ID = (?) , Isactive = (?) , AD_Client_ID = (?) , M_Product_ID = (?) , AD_Org_ID = (?) , Cost = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE ma_indirect_cost_value_product.MA_Indirect_Cost_Value_Product_ID = ? " +
      "                 AND ma_indirect_cost_value_product.MA_Indirect_Cost_Value_ID = ? " +
      "        AND ma_indirect_cost_value_product.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ma_indirect_cost_value_product.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostValueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostValueProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostValueProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostValueId);
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
      "        INSERT INTO ma_indirect_cost_value_product " +
      "        (MA_Indirect_Cost_Value_ID, MA_Indirect_Cost_Value_Product_ID, Isactive, AD_Client_ID, M_Product_ID, AD_Org_ID, Cost, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostValueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostValueProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cost);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maIndirectCostValueId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ma_indirect_cost_value_product" +
      "        WHERE ma_indirect_cost_value_product.MA_Indirect_Cost_Value_Product_ID = ? " +
      "                 AND ma_indirect_cost_value_product.MA_Indirect_Cost_Value_ID = ? " +
      "        AND ma_indirect_cost_value_product.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ma_indirect_cost_value_product.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostValueId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String maIndirectCostValueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ma_indirect_cost_value_product" +
      "        WHERE ma_indirect_cost_value_product.MA_Indirect_Cost_Value_Product_ID = ? " +
      "                 AND ma_indirect_cost_value_product.MA_Indirect_Cost_Value_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostValueId);

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
      "          FROM ma_indirect_cost_value_product" +
      "         WHERE ma_indirect_cost_value_product.MA_Indirect_Cost_Value_Product_ID = ? ";

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
      "          FROM ma_indirect_cost_value_product" +
      "         WHERE ma_indirect_cost_value_product.MA_Indirect_Cost_Value_Product_ID = ? ";

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
