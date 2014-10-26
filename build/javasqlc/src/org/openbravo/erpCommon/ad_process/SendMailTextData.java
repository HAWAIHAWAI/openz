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

class SendMailTextData implements FieldProvider {
static Logger log4j = Logger.getLogger(SendMailTextData.class);
  private String InitRecordNumber="0";
  public String name;
  public String email;
  public String adUserId;
  public String mailheader;
  public String mailtext;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("email"))
      return email;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("mailheader"))
      return mailheader;
    else if (fieldName.equalsIgnoreCase("mailtext"))
      return mailtext;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SendMailTextData[] select(Connection conn, ConnectionProvider connectionProvider, String rInterestareaId)    throws ServletException {
    return select(conn, connectionProvider, rInterestareaId, 0, 0);
  }

  public static SendMailTextData[] select(Connection conn, ConnectionProvider connectionProvider, String rInterestareaId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT u.Name, u.EMail, u.AD_User_ID, '' as mailheader, '' as mailtext " +
      "        FROM R_ContactInterest ci, AD_User u " +
      "        WHERE ci.AD_User_ID=u.AD_User_ID " +
      "        AND ci.IsActive='Y' " +
      "        AND u.IsActive='Y' " +
      "        AND ci.OptOutDate IS NULL " +
      "        AND u.EMail IS NOT NULL " +
      "        AND ci.R_InterestArea_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rInterestareaId);

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
        SendMailTextData objectSendMailTextData = new SendMailTextData();
        objectSendMailTextData.name = UtilSql.getValue(result, "name");
        objectSendMailTextData.email = UtilSql.getValue(result, "email");
        objectSendMailTextData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectSendMailTextData.mailheader = UtilSql.getValue(result, "mailheader");
        objectSendMailTextData.mailtext = UtilSql.getValue(result, "mailtext");
        objectSendMailTextData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSendMailTextData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    SendMailTextData objectSendMailTextData[] = new SendMailTextData[vector.size()];
    vector.copyInto(objectSendMailTextData);
    return(objectSendMailTextData);
  }

  public static SendMailTextData[] selectBPGroup(Connection conn, ConnectionProvider connectionProvider, String cBpGroupId)    throws ServletException {
    return selectBPGroup(conn, connectionProvider, cBpGroupId, 0, 0);
  }

  public static SendMailTextData[] selectBPGroup(Connection conn, ConnectionProvider connectionProvider, String cBpGroupId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT u.Name, u.EMail, u.AD_User_ID " +
      "        FROM AD_User u, C_BPartner bp" +
      "        WHERE u.C_BPartner_ID=bp.C_BPartner_ID " +
      "        AND u.IsActive='Y' " +
      "        AND bp.IsActive='Y' " +
      "        AND u.EMail IS NOT NULL " +
      "        AND bp.C_BP_Group_ID = ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpGroupId);

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
        SendMailTextData objectSendMailTextData = new SendMailTextData();
        objectSendMailTextData.name = UtilSql.getValue(result, "name");
        objectSendMailTextData.email = UtilSql.getValue(result, "email");
        objectSendMailTextData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectSendMailTextData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSendMailTextData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    SendMailTextData objectSendMailTextData[] = new SendMailTextData[vector.size()];
    vector.copyInto(objectSendMailTextData);
    return(objectSendMailTextData);
  }

  public static SendMailTextData[] selectMailData(Connection conn, ConnectionProvider connectionProvider, String rMailtextId)    throws ServletException {
    return selectMailData(conn, connectionProvider, rMailtextId, 0, 0);
  }

  public static SendMailTextData[] selectMailData(Connection conn, ConnectionProvider connectionProvider, String rMailtextId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT mailheader, mailtext" +
      "        FROM R_MailText" +
      "        WHERE IsActive='Y' " +
      "        AND R_MailText_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rMailtextId);

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
        SendMailTextData objectSendMailTextData = new SendMailTextData();
        objectSendMailTextData.mailheader = UtilSql.getValue(result, "mailheader");
        objectSendMailTextData.mailtext = UtilSql.getValue(result, "mailtext");
        objectSendMailTextData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSendMailTextData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    SendMailTextData objectSendMailTextData[] = new SendMailTextData[vector.size()];
    vector.copyInto(objectSendMailTextData);
    return(objectSendMailTextData);
  }

  public static int update(Connection conn, ConnectionProvider connectionProvider, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_User SET IsActive='N', Help=Help||' - Invalid User EMail' WHERE AD_User_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

      updateCount = st.executeUpdate();
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
    return(updateCount);
  }
}
