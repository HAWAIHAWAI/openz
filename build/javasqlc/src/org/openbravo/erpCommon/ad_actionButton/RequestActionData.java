//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class RequestActionData implements FieldProvider {
static Logger log4j = Logger.getLogger(RequestActionData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String documentno;
  public String actiontype;
  public String summary;
  public String mailsubject;
  public String mailtext;
  public String cBpartnerId;
  public String adUserId;
  public String salesrepId;
  public String updatedby;
  public String email;
  public String emailuser;
  public String emailuserpw;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("actiontype"))
      return actiontype;
    else if (fieldName.equalsIgnoreCase("summary"))
      return summary;
    else if (fieldName.equalsIgnoreCase("mailsubject"))
      return mailsubject;
    else if (fieldName.equalsIgnoreCase("mailtext"))
      return mailtext;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("email"))
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

  public static RequestActionData[] select(Connection conn, ConnectionProvider connectionProvider, String rRequestId)    throws ServletException {
    return select(conn, connectionProvider, rRequestId, 0, 0);
  }

  public static RequestActionData[] select(Connection conn, ConnectionProvider connectionProvider, String rRequestId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_Client_ID, DocumentNo, ActionType, Summary, MailSubject,MailText, " +
      "        C_BPartner_ID,AD_User_ID, SalesRep_ID, UpdatedBy, '' AS EMail, '' AS EMailUser, '' AS EMailUserPw, '' AS NAME " +
      "        FROM R_Request " +
      "        WHERE R_Request_ID = ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rRequestId);

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
        RequestActionData objectRequestActionData = new RequestActionData();
        objectRequestActionData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectRequestActionData.documentno = UtilSql.getValue(result, "documentno");
        objectRequestActionData.actiontype = UtilSql.getValue(result, "actiontype");
        objectRequestActionData.summary = UtilSql.getValue(result, "summary");
        objectRequestActionData.mailsubject = UtilSql.getValue(result, "mailsubject");
        objectRequestActionData.mailtext = UtilSql.getValue(result, "mailtext");
        objectRequestActionData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectRequestActionData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectRequestActionData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectRequestActionData.updatedby = UtilSql.getValue(result, "updatedby");
        objectRequestActionData.email = UtilSql.getValue(result, "email");
        objectRequestActionData.emailuser = UtilSql.getValue(result, "emailuser");
        objectRequestActionData.emailuserpw = UtilSql.getValue(result, "emailuserpw");
        objectRequestActionData.name = UtilSql.getValue(result, "name");
        objectRequestActionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequestActionData);
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
    RequestActionData objectRequestActionData[] = new RequestActionData[vector.size()];
    vector.copyInto(objectRequestActionData);
    return(objectRequestActionData);
  }

  public static String selectEmailTo(Connection conn, ConnectionProvider connectionProvider, String adUserId, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT bpc.EMail AS NAME " +
      "        FROM C_BPartner bp INNER JOIN AD_User bpc ON (bp.C_BPartner_ID=bpc.C_BPartner_ID) " +
      "        WHERE ";
    strSql = strSql + ((adUserId==null || adUserId.equals(""))?"":"  bpc.AD_User_ID = ? AND  ");
    strSql = strSql + 
      "bp.C_BPartner_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      if (adUserId != null && !(adUserId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static int update(Connection conn, ConnectionProvider connectionProvider, String resulttxt, String rRequestId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE R_Request SET Result=? WHERE R_Request_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, resulttxt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rRequestId);

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
