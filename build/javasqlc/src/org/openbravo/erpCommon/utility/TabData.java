//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;

public class TabData implements FieldProvider {
static Logger log4j = Logger.getLogger(TabData.class);
  private String InitRecordNumber="0";
  public String mappingname;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("mappingname"))
      return mappingname;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static String selectUrl(ConnectionProvider connectionProvider, String tabId, String type)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select mappingname" +
      "        from ad_model_object_mapping m, " +
      "             ad_model_object o" +
      "       where o.ad_tab_id = ?" +
      "         and o.ad_model_object_id = m.ad_model_object_id" +
      "         and mappingname like '%'||(case when ? = 'R'  then 'Relation'" +
      "                                         when ? = 'E'  then 'Edition' " +
      "                                         when ? = 'X'  then 'Excel' end)||'%'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "mappingname");
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
