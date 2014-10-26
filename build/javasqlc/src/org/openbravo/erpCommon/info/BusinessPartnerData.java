//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.info;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class BusinessPartnerData implements FieldProvider {
static Logger log4j = Logger.getLogger(BusinessPartnerData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String cBpartnerId;
  public String value;
  public String name;
  public String nameHidden;
  public String contact;
  public String cBpartnerContactId;
  public String phone;
  public String pc;
  public String cBpartnerLocationId;
  public String city;
  public String address1;
  public String address2;
  public String rowkey;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("name_hidden") || fieldName.equals("nameHidden"))
      return nameHidden;
    else if (fieldName.equalsIgnoreCase("contact"))
      return contact;
    else if (fieldName.equalsIgnoreCase("c_bpartner_contact_id") || fieldName.equals("cBpartnerContactId"))
      return cBpartnerContactId;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("pc"))
      return pc;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("city"))
      return city;
    else if (fieldName.equalsIgnoreCase("address1"))
      return address1;
    else if (fieldName.equalsIgnoreCase("address2"))
      return address2;
    else if (fieldName.equalsIgnoreCase("rowkey"))
      return rowkey;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static BusinessPartnerData[] select(ConnectionProvider connectionProvider, String rownum, String xclients, String xvendors, String adUserClient, String adUserOrg, String key, String name, String contact, String codigoPostal, String clients, String vendors, String ciudad, String orderBy, String pgLimit)    throws ServletException {
    return select(connectionProvider, rownum, xclients, xvendors, adUserClient, adUserOrg, key, name, contact, codigoPostal, clients, vendors, ciudad, orderBy, pgLimit, 0, 0);
  }

  public static BusinessPartnerData[] select(ConnectionProvider connectionProvider, String rownum, String xclients, String xvendors, String adUserClient, String adUserOrg, String key, String name, String contact, String codigoPostal, String clients, String vendors, String ciudad, String orderBy, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      		SELECT * FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM (      				   " +
      "					select" +
      "                            bp.C_BPartner_ID, bp.value, bp.name as name, " +
      "                            bp.name as name_hidden, " +
      "                            c.name AS Contact, c.ad_user_id as C_BPartner_Contact_ID, coalesce(c.phone,bpl.Phone) as phone, l.Postal AS PC, " +
      "                            bpl.c_bpartner_location_id as C_BPartner_Location_ID," +
      "                            l.City, l.address1,l.address2," +
      "                            bp.C_BPartner_ID || '#' || COALESCE(TO_CHAR(c.ad_user_id), '') || '#' || COALESCE(TO_CHAR(bpl.c_bpartner_location_id),'') || '#' || bp.name AS rowKey  " +
      "                            FROM C_BPARTNER_LOCATION bpl,C_LOCATION l ," +
      "                                 C_BPARTNER bp left join AD_USER c on bp.c_bpartner_id = c.c_bpartner_id " +
      "                                 AND c.IsActive ='Y'";
    strSql = strSql + ((xclients.equals("xclients"))?" AND c.ad_user_id = 'a' ":"");
    strSql = strSql + ((xvendors.equals("xvendors"))?" AND c.ad_user_id = 'a' ":"");
    strSql = strSql + 
      "                            WHERE bp.c_bpartner_id = bpl.c_bpartner_id and " +
      "                                  bpl.IsActive = 'Y' and " +
      "                                  case when bp.isemployee='Y' then (bp.iscustomer='Y' or bp.isvendor='Y') else 1=1 end and" +
      "                                  bpl.c_location_id=l.C_Location_ID and " +
      "                                  case when c.ad_user_id is not null then case when c.c_bpartner_location_id is not null then c.c_bpartner_location_id=bpl.c_bpartner_location_id else bpl.isheadquarter='Y' end else 1=1 end and" +
      "        					        bp.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        					        AND bp.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        					        AND bp.IsSummary='N' " +
      "        					        AND bp.IsActive='Y'";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":" AND UPPER(bp.Value) LIKE UPPER(?)  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":" AND C_IGNORE_ACCENT(bp.Name) LIKE C_IGNORE_ACCENT(?)  ");
    strSql = strSql + ((contact==null || contact.equals("") || contact.equals("%") )?"":" AND UPPER(c.name) LIKE UPPER(?)  ");
    strSql = strSql + ((codigoPostal==null || codigoPostal.equals("") || codigoPostal.equals("%") )?"":" AND UPPER(l.Postal) LIKE UPPER(?)  ");
    strSql = strSql + ((clients.equals("clients"))?" AND bp.ISCUSTOMER = 'Y' ":"");
    strSql = strSql + ((vendors.equals("vendors"))?" AND bp.ISVENDOR ='Y' ":"");
    strSql = strSql + ((ciudad==null || ciudad.equals("") || ciudad.equals("%") )?"":" AND UPPER(l.City) LIKE UPPER(?)  ");
    strSql = strSql + 
      "					        ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "					) A ) B" +
      "			WHERE 1=1";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (xclients != null && !(xclients.equals(""))) {
        }
      if (xvendors != null && !(xvendors.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (contact != null && !(contact.equals("")) && !(contact.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, contact);
      }
      if (codigoPostal != null && !(codigoPostal.equals("")) && !(codigoPostal.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, codigoPostal);
      }
      if (clients != null && !(clients.equals(""))) {
        }
      if (vendors != null && !(vendors.equals(""))) {
        }
      if (ciudad != null && !(ciudad.equals("")) && !(ciudad.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, ciudad);
      }
      if (orderBy != null && !(orderBy.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
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
        BusinessPartnerData objectBusinessPartnerData = new BusinessPartnerData();
        objectBusinessPartnerData.rn1 = UtilSql.getValue(result, "rn1");
        objectBusinessPartnerData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectBusinessPartnerData.value = UtilSql.getValue(result, "value");
        objectBusinessPartnerData.name = UtilSql.getValue(result, "name");
        objectBusinessPartnerData.nameHidden = UtilSql.getValue(result, "name_hidden");
        objectBusinessPartnerData.contact = UtilSql.getValue(result, "contact");
        objectBusinessPartnerData.cBpartnerContactId = UtilSql.getValue(result, "c_bpartner_contact_id");
        objectBusinessPartnerData.phone = UtilSql.getValue(result, "phone");
        objectBusinessPartnerData.pc = UtilSql.getValue(result, "pc");
        objectBusinessPartnerData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectBusinessPartnerData.city = UtilSql.getValue(result, "city");
        objectBusinessPartnerData.address1 = UtilSql.getValue(result, "address1");
        objectBusinessPartnerData.address2 = UtilSql.getValue(result, "address2");
        objectBusinessPartnerData.rowkey = UtilSql.getValue(result, "rowkey");
        objectBusinessPartnerData.position = Long.toString(countRecord);
        objectBusinessPartnerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBusinessPartnerData);
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
    BusinessPartnerData objectBusinessPartnerData[] = new BusinessPartnerData[vector.size()];
    vector.copyInto(objectBusinessPartnerData);
    return(objectBusinessPartnerData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String rownum, String xclients, String xvendors, String adUserClient, String adUserOrg, String key, String name, String contact, String codigoPostal, String clients, String vendors, String ciudad, String pgLimit)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	      SELECT COUNT(*) AS VALUE  " +
      "	        FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS rn1, B.* FROM " +
      "	      (SELECT 1 FROM C_BPARTNER_LOCATION bpl,C_LOCATION l ," +
      "                                 C_BPARTNER bp left join AD_USER c on bp.c_bpartner_id = c.c_bpartner_id " +
      "                                 AND c.IsActive ='Y'";
    strSql = strSql + ((xclients.equals("xclients"))?" AND c.ad_user_id = 'a' ":"");
    strSql = strSql + ((xvendors.equals("xvendors"))?" AND c.ad_user_id = 'a' ":"");
    strSql = strSql + 
      "                            WHERE bp.c_bpartner_id = bpl.c_bpartner_id and " +
      "                                  bpl.IsActive = 'Y' and " +
      "                                  case when bp.isemployee='Y' then (bp.iscustomer='Y' or bp.isvendor='Y') else 1=1 end and" +
      "                                  bpl.c_location_id=l.C_Location_ID and " +
      "                                  case when c.ad_user_id is not null then case when c.c_bpartner_location_id is not null then c.c_bpartner_location_id=bpl.c_bpartner_location_id else bpl.isheadquarter='Y' end else 1=1 end and" +
      "                                    bp.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "                                    AND bp.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "                                    AND bp.IsSummary='N' " +
      "                                    AND bp.IsActive='Y'";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":" AND UPPER(bp.Value) LIKE UPPER(?)  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":" AND C_IGNORE_ACCENT(bp.Name) LIKE C_IGNORE_ACCENT(?)  ");
    strSql = strSql + ((contact==null || contact.equals("") || contact.equals("%") )?"":" AND UPPER(c.name) LIKE UPPER(?)  ");
    strSql = strSql + ((codigoPostal==null || codigoPostal.equals("") || codigoPostal.equals("%") )?"":" AND UPPER(l.Postal) LIKE UPPER(?)  ");
    strSql = strSql + ((clients.equals("clients"))?" AND bp.ISCUSTOMER = 'Y' ":"");
    strSql = strSql + ((vendors.equals("vendors"))?" AND bp.ISVENDOR ='Y' ":"");
    strSql = strSql + ((ciudad==null || ciudad.equals("") || ciudad.equals("%") )?"":" AND UPPER(l.City) LIKE UPPER(?)  ");
    strSql = strSql + 
      "        	                        AND 1=1";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "	        ) B" +
      "	        ) A  ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (xclients != null && !(xclients.equals(""))) {
        }
      if (xvendors != null && !(xvendors.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (contact != null && !(contact.equals("")) && !(contact.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, contact);
      }
      if (codigoPostal != null && !(codigoPostal.equals("")) && !(codigoPostal.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, codigoPostal);
      }
      if (clients != null && !(clients.equals(""))) {
        }
      if (vendors != null && !(vendors.equals(""))) {
        }
      if (ciudad != null && !(ciudad.equals("")) && !(ciudad.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, ciudad);
      }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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

  public static BusinessPartnerData[] set()    throws ServletException {
    BusinessPartnerData objectBusinessPartnerData[] = new BusinessPartnerData[1];
    objectBusinessPartnerData[0] = new BusinessPartnerData();
    objectBusinessPartnerData[0].value = "";
    return objectBusinessPartnerData;
  }

  public static BusinessPartnerData[] selectKey(ConnectionProvider connectionProvider, String xclients, String xvendors, String adUserClient, String adUserOrg, String clients, String vendors, String key, String pgLimit)    throws ServletException {
    return selectKey(connectionProvider, xclients, xvendors, adUserClient, adUserOrg, clients, vendors, key, pgLimit, 0, 0);
  }

  public static BusinessPartnerData[] selectKey(ConnectionProvider connectionProvider, String xclients, String xvendors, String adUserClient, String adUserOrg, String clients, String vendors, String key, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT A.* FROM (                      " +
      "                       select" +
      "                            bp.C_BPartner_ID, bp.value, bp.name as name, " +
      "                            bp.name as name_hidden, " +
      "                            c.name AS Contact, c.ad_user_id as C_BPartner_Contact_ID, bpl.Phone, l.Postal AS PC, " +
      "                            bpl.c_bpartner_location_id as C_BPartner_Location_ID," +
      "                            l.City, l.address1,l.address2," +
      "                            bp.C_BPartner_ID || '#' || COALESCE(TO_CHAR(c.ad_user_id), '') || '#' || COALESCE(TO_CHAR(bpl.c_bpartner_location_id),'') || '#' || bp.name AS rowKey  " +
      "                            FROM C_BPARTNER_LOCATION bpl,C_LOCATION l ," +
      "                                 C_BPARTNER bp left join AD_USER c on bp.c_bpartner_id = c.c_bpartner_id " +
      "                                 AND c.IsActive ='Y'";
    strSql = strSql + ((xclients.equals("xclients"))?" AND c.ad_user_id = 'a' ":"");
    strSql = strSql + ((xvendors.equals("xvendors"))?" AND c.ad_user_id = 'a' ":"");
    strSql = strSql + 
      "                            WHERE bp.c_bpartner_id = bpl.c_bpartner_id and " +
      "                                  bpl.IsActive = 'Y' and " +
      "                                  bpl.c_location_id=l.C_Location_ID and " +
      "                                  case when c.ad_user_id is not null then case when c.c_bpartner_location_id is not null then c.c_bpartner_location_id=bpl.c_bpartner_location_id else bpl.isheadquarter='Y' end else 1=1 end and" +
      "                                    bp.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "                                    AND bp.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "                                    AND bp.IsSummary='N' " +
      "                                    AND bp.IsActive='Y'";
    strSql = strSql + ((clients.equals("clients"))?" AND bp.ISCUSTOMER = 'Y' ":"");
    strSql = strSql + ((vendors.equals("vendors"))?" AND bp.ISVENDOR ='Y' ":"");
    strSql = strSql + 
      "                            AND UPPER(bp.VALUE) LIKE UPPER(?)" +
      "                            ORDER BY bp.name";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "      ) A ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (xclients != null && !(xclients.equals(""))) {
        }
      if (xvendors != null && !(xvendors.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (clients != null && !(clients.equals(""))) {
        }
      if (vendors != null && !(vendors.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      if (pgLimit != null && !(pgLimit.equals(""))) {
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
        BusinessPartnerData objectBusinessPartnerData = new BusinessPartnerData();
        objectBusinessPartnerData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectBusinessPartnerData.value = UtilSql.getValue(result, "value");
        objectBusinessPartnerData.name = UtilSql.getValue(result, "name");
        objectBusinessPartnerData.nameHidden = UtilSql.getValue(result, "name_hidden");
        objectBusinessPartnerData.contact = UtilSql.getValue(result, "contact");
        objectBusinessPartnerData.cBpartnerContactId = UtilSql.getValue(result, "c_bpartner_contact_id");
        objectBusinessPartnerData.phone = UtilSql.getValue(result, "phone");
        objectBusinessPartnerData.pc = UtilSql.getValue(result, "pc");
        objectBusinessPartnerData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectBusinessPartnerData.city = UtilSql.getValue(result, "city");
        objectBusinessPartnerData.address1 = UtilSql.getValue(result, "address1");
        objectBusinessPartnerData.address2 = UtilSql.getValue(result, "address2");
        objectBusinessPartnerData.rowkey = UtilSql.getValue(result, "rowkey");
        objectBusinessPartnerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBusinessPartnerData);
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
    BusinessPartnerData objectBusinessPartnerData[] = new BusinessPartnerData[vector.size()];
    vector.copyInto(objectBusinessPartnerData);
    return(objectBusinessPartnerData);
  }

  public static String existsActual(ConnectionProvider connectionProvider, String description, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT bp.name as name" +
      "        FROM C_BPARTNER bp " +
      "        WHERE UPPER(bp.name) = UPPER(?)" +
      "        AND bp.C_BPartner_ID = ? " +
      "        ORDER BY bp.name";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String existsActualValue(ConnectionProvider connectionProvider, String description, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT bp.value as value" +
      "        FROM C_BPARTNER bp " +
      "        WHERE UPPER(bp.name) = UPPER(?)" +
      "        AND bp.C_BPartner_ID = ? " +
      "        ORDER BY bp.value";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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

  public static String issotrxwindow(ConnectionProvider connectionProvider, String windowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT issotrx from ad_window where ad_window_id= ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "issotrx");
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
