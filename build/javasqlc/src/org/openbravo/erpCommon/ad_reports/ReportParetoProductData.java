//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;
import org.openbravo.database.RDBMSIndependent;
import org.openbravo.exception.*;

class ReportParetoProductData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportParetoProductData.class);
  private String InitRecordNumber="0";
  public String orgid;
  public String searchkey;
  public String name;
  public String unit;
  public String qty;
  public String cost;
  public String value;
  public String percentage;
  public String isabc;
  public String padre;
  public String id;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("orgid"))
      return orgid;
    else if (fieldName.equalsIgnoreCase("searchkey"))
      return searchkey;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("unit"))
      return unit;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("cost"))
      return cost;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("percentage"))
      return percentage;
    else if (fieldName.equalsIgnoreCase("isabc"))
      return isabc;
    else if (fieldName.equalsIgnoreCase("padre"))
      return padre;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportParetoProductData[] select(ConnectionProvider connectionProvider, String mWarehouseId, String adClientId, String language, String cCurrencyBase, String cCurrencyConv, String adOrgId)    throws ServletException {
    return select(connectionProvider, mWarehouseId, adClientId, language, cCurrencyBase, cCurrencyConv, adOrgId, 0, 0);
  }

  public static ReportParetoProductData[] select(ConnectionProvider connectionProvider, String mWarehouseId, String adClientId, String language, String cCurrencyBase, String cCurrencyConv, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select orgid, searchkey, name, unit, qty, cost, value, percentage," +
      "      m_get_pareto_abc(?, ad_org_id, ?, percentage) as isabc, '' as padre, '' as id" +
      "      from (" +
      "        select ad_column_identifier('AD_Org',w.ad_org_id, ?) as orgid," +
      "          p.value as searchkey, p.name as name," +
      "          ad_column_identifier('C_Uom', p.c_uom_id, ?) as unit," +
      "          w.ad_org_id, sd.m_product_id, sum(sd.qtyonhand) as qty," +
      "          c_currency_convert(c.cost, ?, ?, to_date(now()), w.ad_client_id, w.ad_org_id) as cost, " +
      "          c_currency_convert(sum(sd.qtyonhand*c.cost), ?, ?, to_date(now()), w.ad_client_id, w.ad_org_id) as value, " +
      "          100*sum(sd.qtyonhand*c.cost)/(" +
      "            select sum(c_aux.cost * sd_aux.qtyonhand)" +
      "            from m_locator l_aux, m_warehouse w_aux, m_storage_detail sd_aux, m_costing c_aux" +
      "            where sd_aux.m_locator_id = l_aux.m_locator_id" +
      "              and l_aux.m_warehouse_id = w_aux.m_warehouse_id" +
      "              and w_aux.ad_org_id = w.ad_org_id" +
      "              and sd_aux.m_product_id = c_aux.m_product_id" +
      "              and sd_aux.qtyonhand > 0" +
      "              and c_aux.datefrom = (select max(c_aux1.datefrom)" +
      "                                    from m_costing c_aux1" +
      "                                    where c_aux1.m_product_id = c_aux.m_product_id" +
      "                                      and c_aux1.ad_client_id = ?" +
      "                                      and datefrom <= now())" +
      "              and c_aux.dateto > now()" +
      "              and c_aux.ad_client_id = ?" +
      "              and w_aux.ad_client_id = c_aux.ad_client_id" +
      "              and 1=1";
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":"  AND w_aux.M_WAREHOUSE_ID = ?  ");
    strSql = strSql + 
      "              and 2=2";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":"  AND w_aux.AD_ORG_ID = ?  ");
    strSql = strSql + 
      "              ) as percentage" +
      "          from m_locator l, m_warehouse w, m_storage_detail sd, m_costing c, m_product p" +
      "          where sd.m_locator_id = l.m_locator_id" +
      "            and l.m_warehouse_id = w.m_warehouse_id" +
      "            and sd.m_product_id = c.m_product_id" +
      "            and sd.m_product_id = p.m_product_id" +
      "            and sd.qtyonhand > 0" +
      "            and c.datefrom = (select max(c1.datefrom)" +
      "                              from m_costing c1" +
      "                              where c.m_product_id = c1.m_product_id" +
      "                                and c1.ad_client_id = ?" +
      "                                and c1.datefrom <= now())" +
      "            and c.dateto > now()" +
      "            and c.ad_client_id=?" +
      "            and w.ad_client_id=c.ad_client_id" +
      "            and 3=3";
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":"  AND W.M_WAREHOUSE_ID = ?  ");
    strSql = strSql + 
      "            and 4=4";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":"  AND W.AD_ORG_ID = ?  ");
    strSql = strSql + 
      "          group by w.ad_org_id, sd.m_product_id, c.cost, w.ad_client_id, w.ad_org_id, p.name, p.value, p.c_uom_id) a" +
      "        order by orgid, percentage desc";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
        ReportParetoProductData objectReportParetoProductData = new ReportParetoProductData();
        objectReportParetoProductData.orgid = UtilSql.getValue(result, "orgid");
        objectReportParetoProductData.searchkey = UtilSql.getValue(result, "searchkey");
        objectReportParetoProductData.name = UtilSql.getValue(result, "name");
        objectReportParetoProductData.unit = UtilSql.getValue(result, "unit");
        objectReportParetoProductData.qty = UtilSql.getValue(result, "qty");
        objectReportParetoProductData.cost = UtilSql.getValue(result, "cost");
        objectReportParetoProductData.value = UtilSql.getValue(result, "value");
        objectReportParetoProductData.percentage = UtilSql.getValue(result, "percentage");
        objectReportParetoProductData.isabc = UtilSql.getValue(result, "isabc");
        objectReportParetoProductData.padre = UtilSql.getValue(result, "padre");
        objectReportParetoProductData.id = UtilSql.getValue(result, "id");
        objectReportParetoProductData.rownum = Long.toString(countRecord);
        objectReportParetoProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportParetoProductData);
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
    ReportParetoProductData objectReportParetoProductData[] = new ReportParetoProductData[vector.size()];
    vector.copyInto(objectReportParetoProductData);
    return(objectReportParetoProductData);
  }

  public static ReportParetoProductData[] set()    throws ServletException {
    ReportParetoProductData objectReportParetoProductData[] = new ReportParetoProductData[1];
    objectReportParetoProductData[0] = new ReportParetoProductData();
    objectReportParetoProductData[0].orgid = "";
    objectReportParetoProductData[0].searchkey = "";
    objectReportParetoProductData[0].name = "";
    objectReportParetoProductData[0].unit = "";
    objectReportParetoProductData[0].qty = "";
    objectReportParetoProductData[0].cost = "";
    objectReportParetoProductData[0].value = "";
    objectReportParetoProductData[0].percentage = "";
    objectReportParetoProductData[0].isabc = "";
    objectReportParetoProductData[0].padre = "";
    objectReportParetoProductData[0].id = "";
    return objectReportParetoProductData;
  }

  public static ReportParetoProductData[] selectWarehouseDouble(ConnectionProvider connectionProvider, String adUserClient)    throws ServletException {
    return selectWarehouseDouble(connectionProvider, adUserClient, 0, 0);
  }

  public static ReportParetoProductData[] selectWarehouseDouble(ConnectionProvider connectionProvider, String adUserClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_WAREHOUSE.AD_ORG_ID AS PADRE, M_WAREHOUSE.M_WAREHOUSE_ID AS ID, TO_CHAR(M_WAREHOUSE.NAME) AS NAME" +
      "        FROM M_WAREHOUSE" +
      "        WHERE 1=1" +
      "         AND M_WAREHOUSE.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "         UNION " +
      "        SELECT null AS PADRE, M_WAREHOUSE.M_WAREHOUSE_ID AS ID, TO_CHAR(M_WAREHOUSE.NAME) AS NAME" +
      "        FROM M_WAREHOUSE" +
      "        WHERE 2=2 AND M_WAREHOUSE.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")    " +
      "        ORDER BY PADRE, NAME";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
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
        ReportParetoProductData objectReportParetoProductData = new ReportParetoProductData();
        objectReportParetoProductData.padre = UtilSql.getValue(result, "padre");
        objectReportParetoProductData.id = UtilSql.getValue(result, "id");
        objectReportParetoProductData.name = UtilSql.getValue(result, "name");
        objectReportParetoProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportParetoProductData);
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
    ReportParetoProductData objectReportParetoProductData[] = new ReportParetoProductData[vector.size()];
    vector.copyInto(objectReportParetoProductData);
    return(objectReportParetoProductData);
  }

  public static ReportParetoProductData mUpdateParetoProduct0(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_UPDATE_PARETO_PRODUCT0(?)";

    ReportParetoProductData objectReportParetoProductData = new ReportParetoProductData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
        log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
        throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
        log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectReportParetoProductData);
  }
}
