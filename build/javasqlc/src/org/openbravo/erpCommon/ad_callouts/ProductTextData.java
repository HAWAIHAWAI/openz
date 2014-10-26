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

class ProductTextData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductTextData.class);
  private String InitRecordNumber="0";
  public String cpyProddesc2docnote;
  public String proddescOrdernum;
  public String cpyProddocnote2docnote;
  public String proddocnoteOrdernum;
  public String cpyVendpnumber2docnote;
  public String vendpnumberdnOrdernum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("cpy_proddesc2docnote") || fieldName.equals("cpyProddesc2docnote"))
      return cpyProddesc2docnote;
    else if (fieldName.equalsIgnoreCase("proddesc_ordernum") || fieldName.equals("proddescOrdernum"))
      return proddescOrdernum;
    else if (fieldName.equalsIgnoreCase("cpy_proddocnote2docnote") || fieldName.equals("cpyProddocnote2docnote"))
      return cpyProddocnote2docnote;
    else if (fieldName.equalsIgnoreCase("proddocnote_ordernum") || fieldName.equals("proddocnoteOrdernum"))
      return proddocnoteOrdernum;
    else if (fieldName.equalsIgnoreCase("cpy_vendpnumber2docnote") || fieldName.equals("cpyVendpnumber2docnote"))
      return cpyVendpnumber2docnote;
    else if (fieldName.equalsIgnoreCase("vendpnumberdn_ordernum") || fieldName.equals("vendpnumberdnOrdernum"))
      return vendpnumberdnOrdernum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductTextData[] select(ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    return select(connectionProvider, adOrgId, 0, 0);
  }

  public static ProductTextData[] select(ConnectionProvider connectionProvider, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       select cpy_proddesc2docnote , coalesce(proddesc_ordernum,0) as proddesc_ordernum, " +
      "              cpy_proddocnote2docnote, coalesce(proddocnote_ordernum,0) as proddocnote_ordernum," +
      "              cpy_vendpnumber2docnote, coalesce(vendpnumberdn_ordernum,0) as vendpnumberdn_ordernum " +
      "       from zspr_printinfo" +
      "       where AD_Org_ID IN ('0',?)" +
      "       order by AD_Org_ID desc";

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
        ProductTextData objectProductTextData = new ProductTextData();
        objectProductTextData.cpyProddesc2docnote = UtilSql.getValue(result, "cpy_proddesc2docnote");
        objectProductTextData.proddescOrdernum = UtilSql.getValue(result, "proddesc_ordernum");
        objectProductTextData.cpyProddocnote2docnote = UtilSql.getValue(result, "cpy_proddocnote2docnote");
        objectProductTextData.proddocnoteOrdernum = UtilSql.getValue(result, "proddocnote_ordernum");
        objectProductTextData.cpyVendpnumber2docnote = UtilSql.getValue(result, "cpy_vendpnumber2docnote");
        objectProductTextData.vendpnumberdnOrdernum = UtilSql.getValue(result, "vendpnumberdn_ordernum");
        objectProductTextData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductTextData);
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
    ProductTextData objectProductTextData[] = new ProductTextData[vector.size()];
    vector.copyInto(objectProductTextData);
    return(objectProductTextData);
  }

  public static String getVendorProductNo(ConnectionProvider connectionProvider, String mProductId, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT vendorproductno  " +
      "            FROM m_product_po" +
      "            WHERE " +
      "            m_product_id = ?" +
      "            AND c_bpartner_id = ?" +
      "            AND ISACTIVE ='Y'" +
      "            LIMIT 1";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "vendorproductno");
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

  public static String getProductDocNote(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT documentnote  " +
      "            FROM m_product" +
      "            WHERE m_product_id = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "documentnote");
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

  public static String getProductDescription(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT description  " +
      "            FROM m_product" +
      "            WHERE m_product_id = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "description");
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
