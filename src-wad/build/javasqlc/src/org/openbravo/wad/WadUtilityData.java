//Sqlc generated V1.O00-1
package org.openbravo.wad;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;

class WadUtilityData implements FieldProvider {
static Logger log4j = Logger.getLogger(WadUtilityData.class);
  private String InitRecordNumber="0";
  public String text;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("text"))
      return text;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Get the translate of a text
 */
  public static String getTranslatedText(ConnectionProvider connectionProvider, String value, String adLanguage)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(TO_CHAR(MT.MSGTEXT)), ?) AS TEXT " +
      "        FROM AD_MESSAGE M, AD_MESSAGE_TRL MT " +
      "        WHERE M.AD_MESSAGE_ID = MT.AD_MESSAGE_ID " +
      "        AND M.VALUE = ? " +
      "        AND MT.AD_LANGUAGE = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "text");
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
