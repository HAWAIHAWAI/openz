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

class WarehouseComboData implements FieldProvider {
static Logger log4j = Logger.getLogger(WarehouseComboData.class);
  private String InitRecordNumber="0";
  public String mWarehouseId;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static WarehouseComboData[] select(ConnectionProvider connectionProvider, String rol, String client)    throws ServletException {
    return select(connectionProvider, rol, client, 0, 0);
  }

  public static WarehouseComboData[] select(ConnectionProvider connectionProvider, String rol, String client, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_Warehouse.M_Warehouse_ID, M_Warehouse.Name AS Name " +
      "        FROM M_Warehouse, AD_ORG , AD_ROLE_ORGACCESS" +
      "        WHERE M_Warehouse.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "        AND AD_ORG.AD_ORG_ID = AD_ROLE_ORGACCESS.AD_ORG_ID" +
      "        AND M_Warehouse.IsActive='Y' " +
      "        AND AD_ROLE_ORGACCESS.AD_ROLE_ID = ? " +
      "        AND M_Warehouse.AD_Client_ID = ? " +
      "        ORDER BY M_Warehouse.Value";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rol);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

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
        WarehouseComboData objectWarehouseComboData = new WarehouseComboData();
        objectWarehouseComboData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectWarehouseComboData.name = UtilSql.getValue(result, "name");
        objectWarehouseComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWarehouseComboData);
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
    WarehouseComboData objectWarehouseComboData[] = new WarehouseComboData[vector.size()];
    vector.copyInto(objectWarehouseComboData);
    return(objectWarehouseComboData);
  }

  public static WarehouseComboData[] selectFilter(ConnectionProvider connectionProvider, String adUserClient)    throws ServletException {
    return selectFilter(connectionProvider, adUserClient, 0, 0);
  }

  public static WarehouseComboData[] selectFilter(ConnectionProvider connectionProvider, String adUserClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_Warehouse_ID, Name AS Name " +
      "        FROM M_Warehouse " +
      "        WHERE IsActive='Y' " +
      "        AND AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        ORDER BY Value";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
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
        WarehouseComboData objectWarehouseComboData = new WarehouseComboData();
        objectWarehouseComboData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectWarehouseComboData.name = UtilSql.getValue(result, "name");
        objectWarehouseComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWarehouseComboData);
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
    WarehouseComboData objectWarehouseComboData[] = new WarehouseComboData[vector.size()];
    vector.copyInto(objectWarehouseComboData);
    return(objectWarehouseComboData);
  }

  public static boolean isRoleClientWarehouse(ConnectionProvider connectionProvider, String rol, String client, String warehouse)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) AS TOTAL" +
      "        FROM M_Warehouse, AD_ORG , AD_ROLE_ORGACCESS" +
      "        WHERE M_Warehouse.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "        AND AD_ORG.AD_ORG_ID = AD_ROLE_ORGACCESS.AD_ORG_ID" +
      "        AND M_Warehouse.IsActive='Y' " +
      "        AND AD_ROLE_ORGACCESS.AD_ROLE_ID = ? " +
      "        AND M_Warehouse.AD_Client_ID = ? " +
      "        AND M_Warehouse.M_Warehouse_ID = ?";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rol);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }
}
