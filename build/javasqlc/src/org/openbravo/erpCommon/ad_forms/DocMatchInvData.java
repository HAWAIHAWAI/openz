//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class DocMatchInvData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocMatchInvData.class);
  private String InitRecordNumber="0";
  public String mMatchinvId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String mInoutlineId;
  public String cInvoicelineId;
  public String mProductId;
  public String datetrx;
  public String qty;
  public String processing;
  public String processed;
  public String posted;
  public String dateacct;
  public String datedoc;
  public String cBpartnerId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_matchinv_id") || fieldName.equals("mMatchinvId"))
      return mMatchinvId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_id") || fieldName.equals("cInvoicelineId"))
      return cInvoicelineId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("datetrx"))
      return datetrx;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("datedoc"))
      return datedoc;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocMatchInvData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static DocMatchInvData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT '' AS M_MATCHINV_ID, '' AS AD_CLIENT_ID, '' AS AD_ORG_ID, '' AS ISACTIVE," +
      "          '' AS CREATED, '' AS CREATEDBY, '' AS UPDATED, '' AS UPDATEDBY, '' AS M_INOUTLINE_ID," +
      "          '' AS C_INVOICELINE_ID, '' AS M_PRODUCT_ID, '' AS DATETRX, '' AS QTY, '' AS PROCESSING," +
      "          '' AS PROCESSED, '' AS POSTED, '' AS DATEACCT, '' AS DATEDOC, '' AS C_BPARTNER_ID" +
      "        FROM DUAL";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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
        DocMatchInvData objectDocMatchInvData = new DocMatchInvData();
        objectDocMatchInvData.mMatchinvId = UtilSql.getValue(result, "m_matchinv_id");
        objectDocMatchInvData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocMatchInvData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocMatchInvData.isactive = UtilSql.getValue(result, "isactive");
        objectDocMatchInvData.created = UtilSql.getValue(result, "created");
        objectDocMatchInvData.createdby = UtilSql.getValue(result, "createdby");
        objectDocMatchInvData.updated = UtilSql.getValue(result, "updated");
        objectDocMatchInvData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDocMatchInvData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectDocMatchInvData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectDocMatchInvData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocMatchInvData.datetrx = UtilSql.getValue(result, "datetrx");
        objectDocMatchInvData.qty = UtilSql.getValue(result, "qty");
        objectDocMatchInvData.processing = UtilSql.getValue(result, "processing");
        objectDocMatchInvData.processed = UtilSql.getValue(result, "processed");
        objectDocMatchInvData.posted = UtilSql.getValue(result, "posted");
        objectDocMatchInvData.dateacct = UtilSql.getValue(result, "dateacct");
        objectDocMatchInvData.datedoc = UtilSql.getValue(result, "datedoc");
        objectDocMatchInvData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocMatchInvData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocMatchInvData);
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
    DocMatchInvData objectDocMatchInvData[] = new DocMatchInvData[vector.size()];
    vector.copyInto(objectDocMatchInvData);
    return(objectDocMatchInvData);
  }

  public static DocMatchInvData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id)    throws ServletException {
    return selectRegistro(connectionProvider, client, id, 0, 0);
  }

  public static DocMatchInvData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT M.M_MATCHINV_ID, M.AD_CLIENT_ID, M.AD_ORG_ID, M.ISACTIVE, M.CREATED, M.CREATEDBY, M.UPDATED," +
      "        M.UPDATEDBY, M.M_INOUTLINE_ID, M.C_INVOICELINE_ID, M.M_PRODUCT_ID, M.DATETRX, M.QTY, M.PROCESSING," +
      "        M.PROCESSED, M.POSTED, M.DATETRX AS DATEACCT, M.DATETRX AS DATEDOC, I.C_BPARTNER_ID" +
      "      FROM M_MATCHINV M, C_INVOICELINE IL, C_INVOICE I" +
      "      WHERE IL.C_INVOICELINE_ID = M.C_INVOICELINE_ID" +
      "        AND IL.C_INVOICE_ID = I.C_INVOICE_ID" +
      "        AND M.AD_Client_ID=?" +
      "        AND M.M_MATCHINV_ID=?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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
        DocMatchInvData objectDocMatchInvData = new DocMatchInvData();
        objectDocMatchInvData.mMatchinvId = UtilSql.getValue(result, "m_matchinv_id");
        objectDocMatchInvData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocMatchInvData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocMatchInvData.isactive = UtilSql.getValue(result, "isactive");
        objectDocMatchInvData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectDocMatchInvData.createdby = UtilSql.getValue(result, "createdby");
        objectDocMatchInvData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectDocMatchInvData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDocMatchInvData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectDocMatchInvData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectDocMatchInvData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocMatchInvData.datetrx = UtilSql.getDateValue(result, "datetrx", "dd-MM-yyyy");
        objectDocMatchInvData.qty = UtilSql.getValue(result, "qty");
        objectDocMatchInvData.processing = UtilSql.getValue(result, "processing");
        objectDocMatchInvData.processed = UtilSql.getValue(result, "processed");
        objectDocMatchInvData.posted = UtilSql.getValue(result, "posted");
        objectDocMatchInvData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocMatchInvData.datedoc = UtilSql.getDateValue(result, "datedoc", "dd-MM-yyyy");
        objectDocMatchInvData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocMatchInvData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocMatchInvData);
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
    DocMatchInvData objectDocMatchInvData[] = new DocMatchInvData[vector.size()];
    vector.copyInto(objectDocMatchInvData);
    return(objectDocMatchInvData);
  }

  public static String selectProductAverageCost(ConnectionProvider connectionProvider, String mProductID, String date, String AdOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(M_GET_PRODUCT_COST(?, TO_DATE(?), TO_CHAR(NULL),?),0) FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AdOrgId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "coalesce");
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

  public static String selectInvoiceExpense(ConnectionProvider connectionProvider, String adClientId, String cInvoiceLineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT LINENETAMT" +
      "      FROM C_INVOICELINE" +
      "      WHERE AD_CLIENT_ID = ?" +
      "        AND C_INVOICELINE_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceLineId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "linenetamt");
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
