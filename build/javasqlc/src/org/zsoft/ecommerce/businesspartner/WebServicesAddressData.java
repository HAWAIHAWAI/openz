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

class WebServicesAddressData implements FieldProvider {
static Logger log4j = Logger.getLogger(WebServicesAddressData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String cBpartnerId;
  public String cLocationId;
  public String address1;
  public String address2;
  public String city;
  public String postal;
  public String region;
  public String uidnumber;
  public String isbillto;
  public String isshipto;
  public String country;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_location_id") || fieldName.equals("cLocationId"))
      return cLocationId;
    else if (fieldName.equalsIgnoreCase("address1"))
      return address1;
    else if (fieldName.equalsIgnoreCase("address2"))
      return address2;
    else if (fieldName.equalsIgnoreCase("city"))
      return city;
    else if (fieldName.equalsIgnoreCase("postal"))
      return postal;
    else if (fieldName.equalsIgnoreCase("region"))
      return region;
    else if (fieldName.equalsIgnoreCase("uidnumber"))
      return uidnumber;
    else if (fieldName.equalsIgnoreCase("isbillto"))
      return isbillto;
    else if (fieldName.equalsIgnoreCase("isshipto"))
      return isshipto;
    else if (fieldName.equalsIgnoreCase("country"))
      return country;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static WebServicesAddressData[] select(ConnectionProvider connectionProvider, String customerId)    throws ServletException {
    return select(connectionProvider, customerId, 0, 0);
  }

  public static WebServicesAddressData[] select(ConnectionProvider connectionProvider, String customerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "              SELECT L.AD_CLIENT_ID, B.C_BPARTNER_ID, L.C_LOCATION_ID, L.ADDRESS1, L.ADDRESS2, L.CITY, L.POSTAL," +
      "                   R.NAME AS REGION,B.uidnumber,b.isbillto,b.isshipto," +
      "               C.COUNTRYCODE AS COUNTRY" +
      "               FROM C_LOCATION L" +
      "               LEFT JOIN C_BPARTNER_LOCATION B ON L.C_LOCATION_ID = B.C_LOCATION_ID " +
      "               LEFT OUTER JOIN C_REGION R ON L.C_REGION_ID = R.C_REGION_ID" +
      "               LEFT JOIN C_COUNTRY C ON L.C_COUNTRY_ID = C.C_COUNTRY_ID" +
      "               WHERE B.C_BPARTNER_ID = ?";

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
        WebServicesAddressData objectWebServicesAddressData = new WebServicesAddressData();
        objectWebServicesAddressData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectWebServicesAddressData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectWebServicesAddressData.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectWebServicesAddressData.address1 = UtilSql.getValue(result, "address1");
        objectWebServicesAddressData.address2 = UtilSql.getValue(result, "address2");
        objectWebServicesAddressData.city = UtilSql.getValue(result, "city");
        objectWebServicesAddressData.postal = UtilSql.getValue(result, "postal");
        objectWebServicesAddressData.region = UtilSql.getValue(result, "region");
        objectWebServicesAddressData.uidnumber = UtilSql.getValue(result, "uidnumber");
        objectWebServicesAddressData.isbillto = UtilSql.getValue(result, "isbillto");
        objectWebServicesAddressData.isshipto = UtilSql.getValue(result, "isshipto");
        objectWebServicesAddressData.country = UtilSql.getValue(result, "country");
        objectWebServicesAddressData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWebServicesAddressData);
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
    WebServicesAddressData objectWebServicesAddressData[] = new WebServicesAddressData[vector.size()];
    vector.copyInto(objectWebServicesAddressData);
    return(objectWebServicesAddressData);
  }

  public static String updateAddress(ConnectionProvider connectionProvider, String customerId, String adUser, String address1, String address2, String city, String postal, String country, String isbillto, String isshipto, String uidnumber, String cLocationId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                SELECT zsse_updateAddress(?,?,?,?,?,?,?,?,?,?,?) FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, customerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, city);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, country);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbillto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isshipto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uidnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zsse_updateaddress");
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
