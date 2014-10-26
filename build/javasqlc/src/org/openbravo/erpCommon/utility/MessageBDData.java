//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class MessageBDData implements FieldProvider {
static Logger log4j = Logger.getLogger(MessageBDData.class);
  private String InitRecordNumber="0";
  public String msgtype;
  public String msgtip;
  public String msgtext;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("msgtype"))
      return msgtype;
    else if (fieldName.equalsIgnoreCase("msgtip"))
      return msgtip;
    else if (fieldName.equalsIgnoreCase("msgtext"))
      return msgtext;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static MessageBDData[] messageInfo(ConnectionProvider connectionProvider, String value, String language)    throws ServletException {
    return messageInfo(connectionProvider, value, language, 0, 0);
  }

  public static MessageBDData[] messageInfo(ConnectionProvider connectionProvider, String value, String language, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_MESSAGE.MSGTYPE, COALESCE(AD_MESSAGE_TRL.MSGTIP, AD_MESSAGE.MSGTIP) AS MSGTIP, " +
      "      zssi_getText(?,?) AS MSGTEXT " +
      "      FROM AD_MESSAGE left join AD_MESSAGE_TRL on AD_MESSAGE.AD_MESSAGE_ID = AD_MESSAGE_TRL.AD_MESSAGE_ID " +
      "                                              AND AD_MESSAGE_TRL.AD_LANGUAGE = ?" +
      "      WHERE UPPER(AD_MESSAGE.VALUE)=UPPER(?) " +
      "      AND AD_MESSAGE.IsActive = 'Y'";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);

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
        MessageBDData objectMessageBDData = new MessageBDData();
        objectMessageBDData.msgtype = UtilSql.getValue(result, "msgtype");
        objectMessageBDData.msgtip = UtilSql.getValue(result, "msgtip");
        objectMessageBDData.msgtext = UtilSql.getValue(result, "msgtext");
        objectMessageBDData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMessageBDData);
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
    MessageBDData objectMessageBDData[] = new MessageBDData[vector.size()];
    vector.copyInto(objectMessageBDData);
    return(objectMessageBDData);
  }

  public static String messageLanguage(ConnectionProvider connectionProvider, String value, String language)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT zssi_getText(?,?) AS MSGTEXT from dual";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "msgtext");
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

  public static String columnnameLanguage(ConnectionProvider connectionProvider, String value, String language)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT zssi_getElementTextByColumname(?,?) AS MSGTEXT from dual";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "msgtext");
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
