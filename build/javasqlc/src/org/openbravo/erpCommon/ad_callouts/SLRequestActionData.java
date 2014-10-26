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

class SLRequestActionData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLRequestActionData.class);
  private String InitRecordNumber="0";
  public String email;
  public String emailuser;
  public String emailuserpw;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("email"))
      return email;
    else if (fieldName.equalsIgnoreCase("emailuser"))
      return emailuser;
    else if (fieldName.equalsIgnoreCase("emailuserpw"))
      return emailuserpw;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLRequestActionData[] select(ConnectionProvider connectionProvider, String ad_user_id)    throws ServletException {
    return select(connectionProvider, ad_user_id, 0, 0);
  }

  public static SLRequestActionData[] select(ConnectionProvider connectionProvider, String ad_user_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT EMAIL, EMAILUSER, EMAILUSERPW, NAME " +
      "        FROM AD_USER " +
      "        WHERE AD_USER_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_user_id);

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
        SLRequestActionData objectSLRequestActionData = new SLRequestActionData();
        objectSLRequestActionData.email = UtilSql.getValue(result, "email");
        objectSLRequestActionData.emailuser = UtilSql.getValue(result, "emailuser");
        objectSLRequestActionData.emailuserpw = UtilSql.getValue(result, "emailuserpw");
        objectSLRequestActionData.name = UtilSql.getValue(result, "name");
        objectSLRequestActionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLRequestActionData);
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
    SLRequestActionData objectSLRequestActionData[] = new SLRequestActionData[vector.size()];
    vector.copyInto(objectSLRequestActionData);
    return(objectSLRequestActionData);
  }

  public static String SMTPHost(ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT SMTPHost FROM AD_Client " +
      "        WHERE AD_Client_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "smtphost");
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

  public static String BPemail(ConnectionProvider connectionProvider, String c_bpartner_id, String ad_user_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT U.EMAIL" +
      "        FROM C_BPARTNER BP, AD_USER U" +
      "        WHERE BP.C_BPARTNER_ID = U.C_BPARTNER_ID" +
      "        AND BP.C_BPARTNER_ID = ?" +
      "        AND U.AD_USER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_bpartner_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_user_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "email");
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
