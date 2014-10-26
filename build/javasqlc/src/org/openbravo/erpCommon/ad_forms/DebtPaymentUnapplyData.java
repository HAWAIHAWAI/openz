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

class DebtPaymentUnapplyData implements FieldProvider {
static Logger log4j = Logger.getLogger(DebtPaymentUnapplyData.class);
  private String InitRecordNumber="0";
  public String cDebtPaymentId;
  public String cSettlementCancelId;
  public String cSettlementGenerateId;
  public String settlementCancel;
  public String settlementGenerate;
  public String invoice;
  public String dateplanned;
  public String bpartner;
  public String amount;
  public String currency;
  public String paymentrule;
  public String iscancel;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
    else if (fieldName.equalsIgnoreCase("c_settlement_cancel_id") || fieldName.equals("cSettlementCancelId"))
      return cSettlementCancelId;
    else if (fieldName.equalsIgnoreCase("c_settlement_generate_id") || fieldName.equals("cSettlementGenerateId"))
      return cSettlementGenerateId;
    else if (fieldName.equalsIgnoreCase("settlement_cancel") || fieldName.equals("settlementCancel"))
      return settlementCancel;
    else if (fieldName.equalsIgnoreCase("settlement_generate") || fieldName.equals("settlementGenerate"))
      return settlementGenerate;
    else if (fieldName.equalsIgnoreCase("invoice"))
      return invoice;
    else if (fieldName.equalsIgnoreCase("dateplanned"))
      return dateplanned;
    else if (fieldName.equalsIgnoreCase("bpartner"))
      return bpartner;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("currency"))
      return currency;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("iscancel"))
      return iscancel;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DebtPaymentUnapplyData[] select(ConnectionProvider connectionProvider, String adLanguage, String adOrgClient, String adUserClient)    throws ServletException {
    return select(connectionProvider, adLanguage, adOrgClient, adUserClient, 0, 0);
  }

  public static DebtPaymentUnapplyData[] select(ConnectionProvider connectionProvider, String adLanguage, String adOrgClient, String adUserClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT c_debt_payment.c_debt_payment_id, c_debt_payment.c_settlement_cancel_id, " +
      "      c_debt_payment.c_settlement_generate_id, AD_Column_Identifier(TO_CHAR('C_Settlement'),TO_CHAR(s1.C_Settlement_Id),TO_CHAR(?)) AS settlement_cancel, " +
      "      AD_Column_Identifier(TO_CHAR('C_Settlement'),TO_CHAR(s2.C_Settlement_Id),TO_CHAR(?)) AS settlement_generate,AD_Column_Identifier(TO_CHAR('C_Invoice'),TO_CHAR(c_invoice.c_invoice_id),TO_CHAR(?)) AS invoice, c_debt_payment.DATEPLANNED," +
      "      c_bpartner.NAME AS bpartner, c_debt_payment.AMOUNT AS amount, c_currency.ISO_CODE AS currency, ad_ref_list_v.NAME AS paymentrule," +
      "      '' as iscancel" +
      "      FROM c_debt_payment left join c_settlement s1 on s1.c_settlement_id = c_debt_payment.c_settlement_cancel_id" +
      "                          left join c_settlement s2 on s2.c_settlement_id = c_debt_payment.c_settlement_generate_id" +
      "                          left join c_invoice       on c_invoice.C_INVOICE_ID = c_debt_payment.C_INVOICE_ID," +
      "      c_bpartner,  ad_ref_list_v, c_currency" +
      "      WHERE  c_bpartner.C_BPARTNER_ID = c_debt_payment.C_BPARTNER_ID" +
      "      AND c_debt_payment.paymentrule = ad_ref_list_v.VALUE" +
      "      AND ad_ref_list_v.ad_reference_id = '195'" +
      "      AND ad_ref_list_v.ad_language = ? " +
      "      AND c_debt_payment.C_CURRENCY_ID = c_currency.c_currency_id" +
      "      AND c_debt_payment.ispaid = 'Y'" +
      "      AND c_debt_payment.c_cashline_id IS NULL" +
      "      AND c_debt_payment.c_bankstatementline_id IS NULL" +
      "      AND c_debt_payment.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "      AND c_debt_payment.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "      ORDER BY c_debt_payment.DATEPLANNED";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
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
        DebtPaymentUnapplyData objectDebtPaymentUnapplyData = new DebtPaymentUnapplyData();
        objectDebtPaymentUnapplyData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectDebtPaymentUnapplyData.cSettlementCancelId = UtilSql.getValue(result, "c_settlement_cancel_id");
        objectDebtPaymentUnapplyData.cSettlementGenerateId = UtilSql.getValue(result, "c_settlement_generate_id");
        objectDebtPaymentUnapplyData.settlementCancel = UtilSql.getValue(result, "settlement_cancel");
        objectDebtPaymentUnapplyData.settlementGenerate = UtilSql.getValue(result, "settlement_generate");
        objectDebtPaymentUnapplyData.invoice = UtilSql.getValue(result, "invoice");
        objectDebtPaymentUnapplyData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectDebtPaymentUnapplyData.bpartner = UtilSql.getValue(result, "bpartner");
        objectDebtPaymentUnapplyData.amount = UtilSql.getValue(result, "amount");
        objectDebtPaymentUnapplyData.currency = UtilSql.getValue(result, "currency");
        objectDebtPaymentUnapplyData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectDebtPaymentUnapplyData.iscancel = UtilSql.getValue(result, "iscancel");
        objectDebtPaymentUnapplyData.rownum = Long.toString(countRecord);
        objectDebtPaymentUnapplyData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDebtPaymentUnapplyData);
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
    DebtPaymentUnapplyData objectDebtPaymentUnapplyData[] = new DebtPaymentUnapplyData[vector.size()];
    vector.copyInto(objectDebtPaymentUnapplyData);
    return(objectDebtPaymentUnapplyData);
  }

  public static DebtPaymentUnapplyData[] set()    throws ServletException {
    DebtPaymentUnapplyData objectDebtPaymentUnapplyData[] = new DebtPaymentUnapplyData[1];
    objectDebtPaymentUnapplyData[0] = new DebtPaymentUnapplyData();
    objectDebtPaymentUnapplyData[0].cDebtPaymentId = "";
    objectDebtPaymentUnapplyData[0].cSettlementCancelId = "";
    objectDebtPaymentUnapplyData[0].cSettlementGenerateId = "";
    objectDebtPaymentUnapplyData[0].settlementCancel = "";
    objectDebtPaymentUnapplyData[0].settlementGenerate = "";
    objectDebtPaymentUnapplyData[0].invoice = "";
    objectDebtPaymentUnapplyData[0].dateplanned = "";
    objectDebtPaymentUnapplyData[0].bpartner = "";
    objectDebtPaymentUnapplyData[0].amount = "";
    objectDebtPaymentUnapplyData[0].currency = "";
    objectDebtPaymentUnapplyData[0].paymentrule = "";
    objectDebtPaymentUnapplyData[0].iscancel = "";
    return objectDebtPaymentUnapplyData;
  }

  public static DebtPaymentUnapplyData[] selectRecord(ConnectionProvider connectionProvider, String cDebtPaymentId)    throws ServletException {
    return selectRecord(connectionProvider, cDebtPaymentId, 0, 0);
  }

  public static DebtPaymentUnapplyData[] selectRecord(ConnectionProvider connectionProvider, String cDebtPaymentId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT (CASE WHEN C_SETTLEMENT_CANCEL_ID IS NULL THEN 'N' ELSE 'Y' END) AS ISCANCEL, C_DEBT_PAYMENT_ID FROM C_DEBT_PAYMENT" +
      "      WHERE C_DEBT_PAYMENT_ID IN ";
    strSql = strSql + ((cDebtPaymentId==null || cDebtPaymentId.equals(""))?"":cDebtPaymentId);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (cDebtPaymentId != null && !(cDebtPaymentId.equals(""))) {
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
        DebtPaymentUnapplyData objectDebtPaymentUnapplyData = new DebtPaymentUnapplyData();
        objectDebtPaymentUnapplyData.iscancel = UtilSql.getValue(result, "iscancel");
        objectDebtPaymentUnapplyData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectDebtPaymentUnapplyData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDebtPaymentUnapplyData);
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
    DebtPaymentUnapplyData objectDebtPaymentUnapplyData[] = new DebtPaymentUnapplyData[vector.size()];
    vector.copyInto(objectDebtPaymentUnapplyData);
    return(objectDebtPaymentUnapplyData);
  }

  public static int updateGenerate(ConnectionProvider connectionProvider, String cDebtPaymentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_DEBT_PAYMENT SET ispaid = 'N'" +
      "      WHERE c_debt_payment_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);

      updateCount = st.executeUpdate();
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
    return(updateCount);
  }

  public static int updateCancel(ConnectionProvider connectionProvider, String cDebtPaymentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_DEBT_PAYMENT SET ispaid = 'N', c_settlement_cancel_id = NULL, CANCEL_PROCESSED = 'N'" +
      "      WHERE c_debt_payment_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);

      updateCount = st.executeUpdate();
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
    return(updateCount);
  }
}
