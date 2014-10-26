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

class WebServicesCustomerData implements FieldProvider {
static Logger log4j = Logger.getLogger(WebServicesCustomerData.class);
  private String InitRecordNumber="0";
  public String id;
  public String orgId;
  public String searchkey;
  public String name;
  public String description;
  public String bpgroup;
  public String isblocked;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("org_id") || fieldName.equals("orgId"))
      return orgId;
    else if (fieldName.equalsIgnoreCase("searchkey"))
      return searchkey;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("bpgroup"))
      return bpgroup;
    else if (fieldName.equalsIgnoreCase("isblocked"))
      return isblocked;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static WebServicesCustomerData[] select(ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    return select(connectionProvider, adOrgId, 0, 0);
  }

  public static WebServicesCustomerData[] select(ConnectionProvider connectionProvider, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	         SELECT BP.C_BPARTNER_ID AS ID, BP.AD_ORG_ID AS ORG_ID, " +
      "       				BP.VALUE AS SEARCHKEY, BP.NAME, BP.DESCRIPTION , BPG.VALUE as BPGROUP," +
      "       				CASE BP.isecommerceactive when 'Y' then 'N' else 'Y' end as isblocked" +
      "  			   FROM C_BPARTNER BP, C_BP_GROUP BPG" +
      " 			  WHERE BP.c_bp_group_id=BPG.c_bp_group_id" +
      " 			    AND BP.AD_ORG_ID = ?" +
      "   				AND BP.ISACTIVE = 'Y'" +
      "   				AND BP.ISCUSTOMER='Y'";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
        WebServicesCustomerData objectWebServicesCustomerData = new WebServicesCustomerData();
        objectWebServicesCustomerData.id = UtilSql.getValue(result, "id");
        objectWebServicesCustomerData.orgId = UtilSql.getValue(result, "org_id");
        objectWebServicesCustomerData.searchkey = UtilSql.getValue(result, "searchkey");
        objectWebServicesCustomerData.name = UtilSql.getValue(result, "name");
        objectWebServicesCustomerData.description = UtilSql.getValue(result, "description");
        objectWebServicesCustomerData.bpgroup = UtilSql.getValue(result, "bpgroup");
        objectWebServicesCustomerData.isblocked = UtilSql.getValue(result, "isblocked");
        objectWebServicesCustomerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWebServicesCustomerData);
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
    WebServicesCustomerData objectWebServicesCustomerData[] = new WebServicesCustomerData[vector.size()];
    vector.copyInto(objectWebServicesCustomerData);
    return(objectWebServicesCustomerData);
  }

  public static WebServicesCustomerData[] selectCustomerById(ConnectionProvider connectionProvider, String adCustomerId)    throws ServletException {
    return selectCustomerById(connectionProvider, adCustomerId, 0, 0);
  }

  public static WebServicesCustomerData[] selectCustomerById(ConnectionProvider connectionProvider, String adCustomerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	         SELECT BP.C_BPARTNER_ID AS ID, BP.AD_ORG_ID AS ORG_ID, " +
      "                BP.VALUE AS SEARCHKEY, BP.NAME, BPG.VALUE as BPGROUP," +
      "         		CASE BP.isecommerceactive when 'Y' then 'N' else 'Y' end as isblocked" +
      "               FROM C_BPARTNER BP, C_BP_GROUP BPG" +
      "              WHERE BP.c_bp_group_id=BPG.c_bp_group_id" +
      "          	    AND BP.C_BPARTNER_ID = ?" +
      "                AND BP.ISCUSTOMER = 'Y'";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCustomerId);

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
        WebServicesCustomerData objectWebServicesCustomerData = new WebServicesCustomerData();
        objectWebServicesCustomerData.id = UtilSql.getValue(result, "id");
        objectWebServicesCustomerData.orgId = UtilSql.getValue(result, "org_id");
        objectWebServicesCustomerData.searchkey = UtilSql.getValue(result, "searchkey");
        objectWebServicesCustomerData.name = UtilSql.getValue(result, "name");
        objectWebServicesCustomerData.bpgroup = UtilSql.getValue(result, "bpgroup");
        objectWebServicesCustomerData.isblocked = UtilSql.getValue(result, "isblocked");
        objectWebServicesCustomerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWebServicesCustomerData);
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
    WebServicesCustomerData objectWebServicesCustomerData[] = new WebServicesCustomerData[vector.size()];
    vector.copyInto(objectWebServicesCustomerData);
    return(objectWebServicesCustomerData);
  }

  public static WebServicesCustomerData[] selectCustomer(ConnectionProvider connectionProvider, String adOrgId, String name, String seachKey)    throws ServletException {
    return selectCustomer(connectionProvider, adOrgId, name, seachKey, 0, 0);
  }

  public static WebServicesCustomerData[] selectCustomer(ConnectionProvider connectionProvider, String adOrgId, String name, String seachKey, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	         SELECT BP.C_BPARTNER_ID AS ID, BP.AD_ORG_ID AS ORG_ID, " +
      "	         		BP.VALUE AS SEARCHKEY, BP.NAME,BPG.VALUE as BPGROUP" +
      "               FROM C_BPARTNER BP, C_BP_GROUP BPG" +
      "              WHERE BP.c_bp_group_id=BPG.c_bp_group_id" +
      "          	    AND BP.AD_ORG_ID = ?         	    " +
      "                AND BP.ISCUSTOMER = 'Y'" +
      "                AND 1 = 1";
    strSql = strSql + ((name==null || name.equals(""))?"":"  AND BP.NAME like ? ");
    strSql = strSql + ((seachKey==null || seachKey.equals(""))?"":"  AND BP.VALUE like ? ");

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      if (name != null && !(name.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (seachKey != null && !(seachKey.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, seachKey);
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
        WebServicesCustomerData objectWebServicesCustomerData = new WebServicesCustomerData();
        objectWebServicesCustomerData.id = UtilSql.getValue(result, "id");
        objectWebServicesCustomerData.orgId = UtilSql.getValue(result, "org_id");
        objectWebServicesCustomerData.searchkey = UtilSql.getValue(result, "searchkey");
        objectWebServicesCustomerData.name = UtilSql.getValue(result, "name");
        objectWebServicesCustomerData.bpgroup = UtilSql.getValue(result, "bpgroup");
        objectWebServicesCustomerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWebServicesCustomerData);
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
    WebServicesCustomerData objectWebServicesCustomerData[] = new WebServicesCustomerData[vector.size()];
    vector.copyInto(objectWebServicesCustomerData);
    return(objectWebServicesCustomerData);
  }

  public static String updateCustomer(Connection conn, ConnectionProvider connectionProvider, String customerId, String searchKey, String name, String adUser, String adOrg, String bpGroup)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                SELECT zsse_updateCustomer(?,?,?,?,?,?) FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, customerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, searchKey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpGroup);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zsse_updatecustomer");
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

  public static int deleteECPaymentMethods(Connection conn, ConnectionProvider connectionProvider, String bPartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "             DELETE FROM  ZSE_ECOMMERCEGRANT" +
      "                    WHERE  C_BPARTNER_ID=?" +
      "                    AND PAYMENTMETHOD IS NOT NULL";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bPartnerId);

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

  public static int insertECPaymentMethod(Connection conn, ConnectionProvider connectionProvider, String clientId, String orgId, String adUser, String bPartnerId, String ecPaymentMethod)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "             INSERT INTO ZSE_ECOMMERCEGRANT(ZSE_ECOMMERCEGRANT_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY," +
      "                                            C_BPARTNER_ID, PAYMENTMETHOD)" +
      "                    VALUES (get_uuid(),?,?,?,?,?,?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bPartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ecPaymentMethod);

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

  public static String getCustomerUID(ConnectionProvider connectionProvider, String customerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                SELECT uidnumber from c_bpartner_location where isheadquarter='Y'  " +
      "                and c_bpartner_id= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, customerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "uidnumber");
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
