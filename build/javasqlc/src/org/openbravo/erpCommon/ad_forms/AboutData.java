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

class AboutData implements FieldProvider {
static Logger log4j = Logger.getLogger(AboutData.class);
  private String InitRecordNumber="0";
  public String version;
  public String versionLabel;
  public String versionId;
  public String lang;
  public String translatedby;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("version"))
      return version;
    else if (fieldName.equalsIgnoreCase("version_label") || fieldName.equals("versionLabel"))
      return versionLabel;
    else if (fieldName.equalsIgnoreCase("version_id") || fieldName.equals("versionId"))
      return versionId;
    else if (fieldName.equalsIgnoreCase("lang"))
      return lang;
    else if (fieldName.equalsIgnoreCase("translatedby"))
      return translatedby;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AboutData select(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT VERSION, VERSION_LABEL, VERSION_ID, " +
      "               '' as LANG, '' as TRANSLATEDBY" +
      "          FROM AD_MODULE" +
      "         WHERE AD_MODULE_ID ='0'";

    ResultSet result;
    AboutData objectAboutData = new AboutData();
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if(result.next()) {
        objectAboutData.version = UtilSql.getValue(result, "version");
        objectAboutData.versionLabel = UtilSql.getValue(result, "version_label");
        objectAboutData.versionId = UtilSql.getValue(result, "version_id");
        objectAboutData.lang = UtilSql.getValue(result, "lang");
        objectAboutData.translatedby = UtilSql.getValue(result, "translatedby");
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
    return(objectAboutData);
  }

  public static AboutData[] selectTranslators(ConnectionProvider connectionProvider)    throws ServletException {
    return selectTranslators(connectionProvider, 0, 0);
  }

  public static AboutData[] selectTranslators(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME AS LANG, TRANSLATEDBY" +
      "          FROM AD_LANGUAGE" +
      "         WHERE TRANSLATEDBY IS NOT NULL" +
      "           AND (ISSYSTEMLANGUAGE  = 'Y'" +
      "                OR ISBASELANGUAGE = 'Y')" +
      "         ORDER BY NAME";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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
        AboutData objectAboutData = new AboutData();
        objectAboutData.lang = UtilSql.getValue(result, "lang");
        objectAboutData.translatedby = UtilSql.getValue(result, "translatedby");
        objectAboutData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAboutData);
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
    AboutData objectAboutData[] = new AboutData[vector.size()];
    vector.copyInto(objectAboutData);
    return(objectAboutData);
  }

  public static AboutData[] set()    throws ServletException {
    AboutData objectAboutData[] = new AboutData[1];
    objectAboutData[0] = new AboutData();
    objectAboutData[0].lang = "";
    objectAboutData[0].translatedby = "";
    return objectAboutData;
  }
}
