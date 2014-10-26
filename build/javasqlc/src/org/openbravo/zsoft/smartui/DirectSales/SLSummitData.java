//Sqlc generated V1.O00-1
package org.openbravo.zsoft.smartui.DirectSales;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class SLSummitData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLSummitData.class);
  private String InitRecordNumber="0";
  public String zssiDirectsalesId;
  public String qty;
  public String priceactual;
  public String mProductId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("zssi_directsales_id") || fieldName.equals("zssiDirectsalesId"))
      return zssiDirectsalesId;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLSummitData[] select(ConnectionProvider connectionProvider, String zssiDirectsalesId)    throws ServletException {
    return select(connectionProvider, zssiDirectsalesId, 0, 0);
  }

  public static SLSummitData[] select(ConnectionProvider connectionProvider, String zssiDirectsalesId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT zssi_directsales_id,qty,priceactual ,m_product_id from zssi_directsales" +
      "             where isactive='Y' and processed='N' and zssi_directsales_id!=? order by created";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiDirectsalesId);

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
        SLSummitData objectSLSummitData = new SLSummitData();
        objectSLSummitData.zssiDirectsalesId = UtilSql.getValue(result, "zssi_directsales_id");
        objectSLSummitData.qty = UtilSql.getValue(result, "qty");
        objectSLSummitData.priceactual = UtilSql.getValue(result, "priceactual");
        objectSLSummitData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectSLSummitData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLSummitData);
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
    SLSummitData objectSLSummitData[] = new SLSummitData[vector.size()];
    vector.copyInto(objectSLSummitData);
    return(objectSLSummitData);
  }

  public static String selectProduct(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT rpad(NAME,80) as name  FROM m_product " +
      "             where m_product_id=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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

  public static int updateText(ConnectionProvider connectionProvider, String TextLineText, String AdClientId, String AdOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE zssi_directsales set textlines=? " +
      "            where ad_client_id=? and ad_org_id=? and processed='N' " +
      "                  and isactive='Y' and posid is null";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, TextLineText);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AdClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AdOrgId);

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
}
