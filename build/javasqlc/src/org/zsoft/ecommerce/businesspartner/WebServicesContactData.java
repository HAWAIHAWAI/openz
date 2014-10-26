//Sqlc generated V1.O00-1
package org.zsoft.ecommerce.businesspartner;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class WebServicesContactData implements FieldProvider {
static Logger log4j = Logger.getLogger(WebServicesContactData.class);
  private String InitRecordNumber="0";
  public String adUserId;
  public String adClientId;
  public String cBpartnerId;
  public String firstname;
  public String lastname;
  public String name;
  public String email;
  public String phone;
  public String phone2;
  public String fax;
  public String greeting;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("firstname"))
      return firstname;
    else if (fieldName.equalsIgnoreCase("lastname"))
      return lastname;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("email"))
      return email;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("phone2"))
      return phone2;
    else if (fieldName.equalsIgnoreCase("fax"))
      return fax;
    else if (fieldName.equalsIgnoreCase("greeting"))
      return greeting;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static WebServicesContactData[] select(ConnectionProvider connectionProvider, String customerId, String contactId)    throws ServletException {
    return select(connectionProvider, customerId, contactId, 0, 0);
  }

  public static WebServicesContactData[] select(ConnectionProvider connectionProvider, String customerId, String contactId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	        SELECT US.AD_USER_ID, US.AD_CLIENT_ID, US.C_BPARTNER_ID," +
      "                   US.FIRSTNAME, US.LASTNAME, US.NAME, US.EMAIL, US.PHONE, US.PHONE2, US.FAX," +
      "                   GT.GREETING" +
      "              FROM AD_USER US, C_GREETING GT" +
      "             WHERE GT.C_GREETING_ID=US.C_GREETING_ID and C_BPARTNER_ID = ?" +
      "			   AND AD_USER_ID = ?	";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, customerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contactId);

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
        WebServicesContactData objectWebServicesContactData = new WebServicesContactData();
        objectWebServicesContactData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectWebServicesContactData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectWebServicesContactData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectWebServicesContactData.firstname = UtilSql.getValue(result, "firstname");
        objectWebServicesContactData.lastname = UtilSql.getValue(result, "lastname");
        objectWebServicesContactData.name = UtilSql.getValue(result, "name");
        objectWebServicesContactData.email = UtilSql.getValue(result, "email");
        objectWebServicesContactData.phone = UtilSql.getValue(result, "phone");
        objectWebServicesContactData.phone2 = UtilSql.getValue(result, "phone2");
        objectWebServicesContactData.fax = UtilSql.getValue(result, "fax");
        objectWebServicesContactData.greeting = UtilSql.getValue(result, "greeting");
        objectWebServicesContactData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWebServicesContactData);
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
    WebServicesContactData objectWebServicesContactData[] = new WebServicesContactData[vector.size()];
    vector.copyInto(objectWebServicesContactData);
    return(objectWebServicesContactData);
  }

  public static WebServicesContactData[] selectContacts(ConnectionProvider connectionProvider, String customerId)    throws ServletException {
    return selectContacts(connectionProvider, customerId, 0, 0);
  }

  public static WebServicesContactData[] selectContacts(ConnectionProvider connectionProvider, String customerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT US.AD_USER_ID, US.AD_CLIENT_ID, US.C_BPARTNER_ID," +
      "                   US.FIRSTNAME, US.LASTNAME, US.NAME, US.EMAIL, US.PHONE, US.PHONE2, US.FAX," +
      "                   GT.GREETING" +
      "              FROM AD_USER US left join C_GREETING GT on GT.C_GREETING_ID=US.C_GREETING_ID " +
      "              WHERE US.C_BPARTNER_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, customerId);

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
        WebServicesContactData objectWebServicesContactData = new WebServicesContactData();
        objectWebServicesContactData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectWebServicesContactData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectWebServicesContactData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectWebServicesContactData.firstname = UtilSql.getValue(result, "firstname");
        objectWebServicesContactData.lastname = UtilSql.getValue(result, "lastname");
        objectWebServicesContactData.name = UtilSql.getValue(result, "name");
        objectWebServicesContactData.email = UtilSql.getValue(result, "email");
        objectWebServicesContactData.phone = UtilSql.getValue(result, "phone");
        objectWebServicesContactData.phone2 = UtilSql.getValue(result, "phone2");
        objectWebServicesContactData.fax = UtilSql.getValue(result, "fax");
        objectWebServicesContactData.greeting = UtilSql.getValue(result, "greeting");
        objectWebServicesContactData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWebServicesContactData);
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
    WebServicesContactData objectWebServicesContactData[] = new WebServicesContactData[vector.size()];
    vector.copyInto(objectWebServicesContactData);
    return(objectWebServicesContactData);
  }

  public static String updateContact(ConnectionProvider connectionProvider, String customerId, String adUser, String firstName, String lastName, String name, String email, String phone, String phone2, String fax, String greeting, String contactId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                SELECT zsse_updateContacts(?,?,?,?,?,?,?,?,?,?,?) FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, customerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, greeting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contactId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zsse_updatecontacts");
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
