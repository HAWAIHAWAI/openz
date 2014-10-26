//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.info;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ProductCategoryComboData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductCategoryComboData.class);
  private String InitRecordNumber="0";
  public String mProductCategoryId;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductCategoryComboData[] select(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg)    throws ServletException {
    return select(connectionProvider, adUserClient, adUserOrg, 0, 0);
  }

  public static ProductCategoryComboData[] select(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         select null as m_product_category_id, null as name from dual" +
      "         union" +
      "         select m_product_category_id,name from m_product_category p where" +
      "          p.isactive='Y'" +
      "          AND p.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "          AND p.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ",'0')" +
      "          order by name";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
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
        ProductCategoryComboData objectProductCategoryComboData = new ProductCategoryComboData();
        objectProductCategoryComboData.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectProductCategoryComboData.name = UtilSql.getValue(result, "name");
        objectProductCategoryComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductCategoryComboData);
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
    ProductCategoryComboData objectProductCategoryComboData[] = new ProductCategoryComboData[vector.size()];
    vector.copyInto(objectProductCategoryComboData);
    return(objectProductCategoryComboData);
  }

  public static ProductCategoryComboData[] selectWinSpec(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String windowId)    throws ServletException {
    return selectWinSpec(connectionProvider, adUserClient, adUserOrg, windowId, 0, 0);
  }

  public static ProductCategoryComboData[] selectWinSpec(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String windowId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         select null as m_product_category_id, null as name from dual" +
      "         union" +
      "         select m_product_category_id,name from m_product_category p where" +
      "          p.isactive='Y'" +
      "          AND p.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "          AND p.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ",'0')" +
      "          AND zssi_isCategorySelectableinWindow(?,p.m_product_category_id)='Y'" +
      "          order by name";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);

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
        ProductCategoryComboData objectProductCategoryComboData = new ProductCategoryComboData();
        objectProductCategoryComboData.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectProductCategoryComboData.name = UtilSql.getValue(result, "name");
        objectProductCategoryComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductCategoryComboData);
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
    ProductCategoryComboData objectProductCategoryComboData[] = new ProductCategoryComboData[vector.size()];
    vector.copyInto(objectProductCategoryComboData);
    return(objectProductCategoryComboData);
  }
}
