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

class CopyFromInvoiceData implements FieldProvider {
static Logger log4j = Logger.getLogger(CopyFromInvoiceData.class);
  private String InitRecordNumber="0";
  public String cInvoicelineId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_invoiceline_id") || fieldName.equals("cInvoicelineId"))
      return cInvoicelineId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CopyFromInvoiceData[] select(Connection conn, ConnectionProvider connectionProvider, String cInvoiceId, String userclient, String userorg)    throws ServletException {
    return select(conn, connectionProvider, cInvoiceId, userclient, userorg, 0, 0);
  }

  public static CopyFromInvoiceData[] select(Connection conn, ConnectionProvider connectionProvider, String cInvoiceId, String userclient, String userorg, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_InvoiceLine_ID FROM C_InvoiceLine " +
      "        WHERE C_Invoice_ID = ? " +
      "        AND AD_CLIENT_ID IN (";
    strSql = strSql + ((userclient==null || userclient.equals(""))?"":userclient);
    strSql = strSql + 
      ") " +
      "        AND AD_ORG_ID IN (";
    strSql = strSql + ((userorg==null || userorg.equals(""))?"":userorg);
    strSql = strSql + 
      ") " +
      "        AND ISACTIVE = 'Y'";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      if (userclient != null && !(userclient.equals(""))) {
        }
      if (userorg != null && !(userorg.equals(""))) {
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
        CopyFromInvoiceData objectCopyFromInvoiceData = new CopyFromInvoiceData();
        objectCopyFromInvoiceData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCopyFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromInvoiceData);
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
    CopyFromInvoiceData objectCopyFromInvoiceData[] = new CopyFromInvoiceData[vector.size()];
    vector.copyInto(objectCopyFromInvoiceData);
    return(objectCopyFromInvoiceData);
  }

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String cNewInvoiceId, String cInvoiceId, String adClientId, String adUserId, String cInvoicelineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_INVOICELINE (C_InvoiceLine_ID, C_Invoice_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, " +
      "        CREATED, CREATEDBY, UPDATED, UPDATEDBY, LINE, DESCRIPTION, M_PRODUCT_ID, " +
      "        QTYINVOICED, PRICELIST, PRICEACTUAL, PRICELIMIT, LINENETAMT, C_CHARGE_ID, CHARGEAMT, C_UOM_ID, C_TAX_ID, " +
      "        S_RESOURCEASSIGNMENT_ID, TAXAMT, M_ATTRIBUTESETINSTANCE_ID, ISDESCRIPTION, QUANTITYORDER, M_PRODUCT_UOM_ID, " +
      "        PRICESTD,c_project_id ,c_projecttask_id,a_asset_id)" +
      "        SELECT ?, ?, ?, (select ad_org_id from c_invoice where c_invoice_id = ? ), 'Y', now(), ?, now(), ?," +
      "        (SELECT COALESCE(MAX(LINE),0)+10 FROM C_InvoiceLine WHERE C_InvoiceLine_ID = ?), DESCRIPTION, M_PRODUCT_ID, " +
      "        QTYINVOICED, PRICELIST, PRICEACTUAL, PRICELIMIT, LINENETAMT, C_CHARGE_ID, CHARGEAMT, C_UOM_ID, C_TAX_ID, " +
      "        S_RESOURCEASSIGNMENT_ID, TAXAMT, M_ATTRIBUTESETINSTANCE_ID, ISDESCRIPTION, QUANTITYORDER, M_PRODUCT_UOM_ID, " +
      "        PRICESTD,c_project_id ,c_projecttask_id,a_asset_id" +
      "        FROM C_INVOICELINE " +
      "        WHERE C_INVOICELINE_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cNewInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);

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
