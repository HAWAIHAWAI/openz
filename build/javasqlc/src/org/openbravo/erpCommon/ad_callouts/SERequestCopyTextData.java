//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class SERequestCopyTextData implements FieldProvider {
static Logger log4j = Logger.getLogger(SERequestCopyTextData.class);
  private String InitRecordNumber="0";
  public String mailheader;
  public String mailtext;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("mailheader"))
      return mailheader;
    else if (fieldName.equalsIgnoreCase("mailtext"))
      return mailtext;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SERequestCopyTextData[] select(ConnectionProvider connectionProvider, String r_mailtext_id)    throws ServletException {
    return select(connectionProvider, r_mailtext_id, 0, 0);
  }

  public static SERequestCopyTextData[] select(ConnectionProvider connectionProvider, String r_mailtext_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MailHeader, MailText " +
      "        FROM R_MailText " +
      "        WHERE R_MailText_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, r_mailtext_id);

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
        SERequestCopyTextData objectSERequestCopyTextData = new SERequestCopyTextData();
        objectSERequestCopyTextData.mailheader = UtilSql.getValue(result, "mailheader");
        objectSERequestCopyTextData.mailtext = UtilSql.getValue(result, "mailtext");
        objectSERequestCopyTextData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSERequestCopyTextData);
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
    SERequestCopyTextData objectSERequestCopyTextData[] = new SERequestCopyTextData[vector.size()];
    vector.copyInto(objectSERequestCopyTextData);
    return(objectSERequestCopyTextData);
  }
}
