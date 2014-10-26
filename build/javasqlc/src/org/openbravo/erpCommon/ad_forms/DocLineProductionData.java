//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class DocLineProductionData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineProductionData.class);
  private String InitRecordNumber="0";
  public String adOrgId;
  public String mProductionlineId;
  public String mProductId;
  public String movementqty;
  public String productiontype;
  public String mLocatorId;
  public String mWarehouseId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("m_productionline_id") || fieldName.equals("mProductionlineId"))
      return mProductionlineId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("productiontype"))
      return productiontype;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineProductionData[] select(ConnectionProvider connectionProvider, String mProductionId)    throws ServletException {
    return select(connectionProvider, mProductionId, 0, 0);
  }

  public static DocLineProductionData[] select(ConnectionProvider connectionProvider, String mProductionId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT '' as AD_ORG_ID, '' as M_PRODUCTIONLINE_ID, '' as M_PRODUCT_ID, 0 as MOVEMENTQTY, '' as PRODUCTIONTYPE, '' as M_LOCATOR_ID, '' as M_WAREHOUSE_ID" +
      "         FROM dual where '1' = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductionId);

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
        DocLineProductionData objectDocLineProductionData = new DocLineProductionData();
        objectDocLineProductionData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineProductionData.mProductionlineId = UtilSql.getValue(result, "m_productionline_id");
        objectDocLineProductionData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocLineProductionData.movementqty = UtilSql.getValue(result, "movementqty");
        objectDocLineProductionData.productiontype = UtilSql.getValue(result, "productiontype");
        objectDocLineProductionData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectDocLineProductionData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectDocLineProductionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineProductionData);
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
    DocLineProductionData objectDocLineProductionData[] = new DocLineProductionData[vector.size()];
    vector.copyInto(objectDocLineProductionData);
    return(objectDocLineProductionData);
  }
}
