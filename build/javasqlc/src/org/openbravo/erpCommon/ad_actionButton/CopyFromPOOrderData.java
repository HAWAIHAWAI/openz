//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;

class CopyFromPOOrderData implements FieldProvider {
static Logger log4j = Logger.getLogger(CopyFromPOOrderData.class);
  private String InitRecordNumber="0";
  public String cCopyorderlineswithoutprojectanddatepromised;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_copyorderlineswithoutprojectanddatepromised") || fieldName.equals("cCopyorderlineswithoutprojectanddatepromised"))
      return cCopyorderlineswithoutprojectanddatepromised;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Principal select
 */
  public static String insertCOrderlines(Connection conn, ConnectionProvider connectionProvider, String cSourceOrderId, String cDestOrderId, String user)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select c_copyorderlineswithoutprojectanddatepromised(?,?,?)";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSourceOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDestOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_copyorderlineswithoutprojectanddatepromised");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }
}
