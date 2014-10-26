//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class GenerateHelpData implements FieldProvider {
static Logger log4j = Logger.getLogger(GenerateHelpData.class);
  private String InitRecordNumber="0";
  public String adWindowId;
  public String name;
  public String help;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_window_id") || fieldName.equals("adWindowId"))
      return adWindowId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static GenerateHelpData[] select(ConnectionProvider connectionProvider, String adLanguage, String adWindowId)    throws ServletException {
    return select(connectionProvider, adLanguage, adWindowId, 0, 0);
  }

  public static GenerateHelpData[] select(ConnectionProvider connectionProvider, String adLanguage, String adWindowId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT W.AD_WINDOW_ID, (CASE WHEN W_T.NAME IS NULL THEN W.NAME ELSE W_T.NAME END) AS NAME, " +
      "        (CASE WHEN W_T.HELP IS NULL THEN W.HELP ELSE W_T.HELP END) AS HELP" +
      "        FROM AD_WINDOW W left join AD_WINDOW_TRL W_T on W.AD_WINDOW_ID = W_T.AD_WINDOW_ID  " +
      "                                          AND W_T.AD_LANGUAGE = ?        " +
      "        WHERE ";
    strSql = strSql + ((adWindowId==null || adWindowId.equals(""))?"":"  W.AD_WINDOW_ID = ? AND  ");
    strSql = strSql + 
      "W.ISACTIVE = 'Y'  ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adWindowId != null && !(adWindowId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
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
        GenerateHelpData objectGenerateHelpData = new GenerateHelpData();
        objectGenerateHelpData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectGenerateHelpData.name = UtilSql.getValue(result, "name");
        objectGenerateHelpData.help = UtilSql.getValue(result, "help");
        objectGenerateHelpData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGenerateHelpData);
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
    GenerateHelpData objectGenerateHelpData[] = new GenerateHelpData[vector.size()];
    vector.copyInto(objectGenerateHelpData);
    return(objectGenerateHelpData);
  }
}
