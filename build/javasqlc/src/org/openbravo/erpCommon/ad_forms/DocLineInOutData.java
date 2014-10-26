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

class DocLineInOutData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineInOutData.class);
  private String InitRecordNumber="0";
  public String adOrgId;
  public String mProductId;
  public String line;
  public String description;
  public String cUomId;
  public String mInoutlineId;
  public String movementqty;
  public String mLocatorId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineInOutData[] select(ConnectionProvider connectionProvider, String M_InOut_ID)    throws ServletException {
    return select(connectionProvider, M_InOut_ID, 0, 0);
  }

  public static DocLineInOutData[] select(ConnectionProvider connectionProvider, String M_InOut_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT IO.AD_ORG_ID, IO.M_PRODUCT_ID, IO.LINE, IO.DESCRIPTION," +
      "          IO.C_UOM_ID, IO.M_INOUTLINE_ID, IO.MOVEMENTQTY, IO.M_LOCATOR_ID" +
      "          FROM M_InOutLine IO , M_PRODUCT P" +
      "          WHERE P.M_PRODUCT_ID=IO.M_PRODUCT_ID AND P.PRODUCTTYPE='I' AND " +
      "                IO.M_LOCATOR_ID is not null AND" +
      "                M_InOut_ID=? ORDER BY Line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_InOut_ID);

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
        DocLineInOutData objectDocLineInOutData = new DocLineInOutData();
        objectDocLineInOutData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineInOutData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocLineInOutData.line = UtilSql.getValue(result, "line");
        objectDocLineInOutData.description = UtilSql.getValue(result, "description");
        objectDocLineInOutData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectDocLineInOutData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectDocLineInOutData.movementqty = UtilSql.getValue(result, "movementqty");
        objectDocLineInOutData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectDocLineInOutData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineInOutData);
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
    DocLineInOutData objectDocLineInOutData[] = new DocLineInOutData[vector.size()];
    vector.copyInto(objectDocLineInOutData);
    return(objectDocLineInOutData);
  }
}
