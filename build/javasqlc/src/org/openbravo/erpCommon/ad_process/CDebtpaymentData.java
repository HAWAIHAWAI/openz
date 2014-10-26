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

class CDebtpaymentData implements FieldProvider {
static Logger log4j = Logger.getLogger(CDebtpaymentData.class);
  private String InitRecordNumber="0";
  public String cDebtPaymentId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String isreceipt;
  public String cSettlementCancelId;
  public String cSettlementGenerateId;
  public String description;
  public String cInvoiceId;
  public String cBpartnerId;
  public String cCurrencyId;
  public String cCashlineId;
  public String cBankaccountId;
  public String cCashbookId;
  public String paymentrule;
  public String ispaid;
  public String amount;
  public String writeoffamt;
  public String dateplanned;
  public String ismanual;
  public String isvalid;
  public String cBankstatementlineId;
  public String changesettlementcancel;
  public String cancelProcessed;
  public String generateProcessed;
  public String glitemamt;
  public String isdirectposting;
  public String cGlitemId;
  public String status;
  public String statusInitial;
  public String cProjectId;
  public String cOrderId;
  public String isautomaticgenerated;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
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
    else if (fieldName.equalsIgnoreCase("isreceipt"))
      return isreceipt;
    else if (fieldName.equalsIgnoreCase("c_settlement_cancel_id") || fieldName.equals("cSettlementCancelId"))
      return cSettlementCancelId;
    else if (fieldName.equalsIgnoreCase("c_settlement_generate_id") || fieldName.equals("cSettlementGenerateId"))
      return cSettlementGenerateId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_cashline_id") || fieldName.equals("cCashlineId"))
      return cCashlineId;
    else if (fieldName.equalsIgnoreCase("c_bankaccount_id") || fieldName.equals("cBankaccountId"))
      return cBankaccountId;
    else if (fieldName.equalsIgnoreCase("c_cashbook_id") || fieldName.equals("cCashbookId"))
      return cCashbookId;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("ispaid"))
      return ispaid;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("writeoffamt"))
      return writeoffamt;
    else if (fieldName.equalsIgnoreCase("dateplanned"))
      return dateplanned;
    else if (fieldName.equalsIgnoreCase("ismanual"))
      return ismanual;
    else if (fieldName.equalsIgnoreCase("isvalid"))
      return isvalid;
    else if (fieldName.equalsIgnoreCase("c_bankstatementline_id") || fieldName.equals("cBankstatementlineId"))
      return cBankstatementlineId;
    else if (fieldName.equalsIgnoreCase("changesettlementcancel"))
      return changesettlementcancel;
    else if (fieldName.equalsIgnoreCase("cancel_processed") || fieldName.equals("cancelProcessed"))
      return cancelProcessed;
    else if (fieldName.equalsIgnoreCase("generate_processed") || fieldName.equals("generateProcessed"))
      return generateProcessed;
    else if (fieldName.equalsIgnoreCase("glitemamt"))
      return glitemamt;
    else if (fieldName.equalsIgnoreCase("isdirectposting"))
      return isdirectposting;
    else if (fieldName.equalsIgnoreCase("c_glitem_id") || fieldName.equals("cGlitemId"))
      return cGlitemId;
    else if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("status_initial") || fieldName.equals("statusInitial"))
      return statusInitial;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("isautomaticgenerated"))
      return isautomaticgenerated;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CDebtpaymentData[] select(ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    return select(connectionProvider, adClientId, 0, 0);
  }

  public static CDebtpaymentData[] select(ConnectionProvider connectionProvider, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_DEBT_PAYMENT_ID, AD_CLIENT_ID, AD_ORG_ID, " +
      "           ISACTIVE, CREATED, CREATEDBY, " +
      "           UPDATED, UPDATEDBY, ISRECEIPT, " +
      "           C_SETTLEMENT_CANCEL_ID, C_SETTLEMENT_GENERATE_ID, DESCRIPTION, " +
      "           C_INVOICE_ID, C_BPARTNER_ID, C_CURRENCY_ID, " +
      "           C_CASHLINE_ID, C_BANKACCOUNT_ID, C_CASHBOOK_ID, " +
      "           PAYMENTRULE, ISPAID, AMOUNT, " +
      "           WRITEOFFAMT, DATEPLANNED, ISMANUAL, " +
      "           ISVALID, C_BANKSTATEMENTLINE_ID, CHANGESETTLEMENTCANCEL, " +
      "           CANCEL_PROCESSED, GENERATE_PROCESSED, GLITEMAMT, " +
      "           ISDIRECTPOSTING, C_GLITEM_ID, STATUS, " +
      "           STATUS_INITIAL, C_PROJECT_ID, C_ORDER_ID, " +
      "           ISAUTOMATICGENERATED" +
      "        FROM C_DEBT_PAYMENT" +
      "			  WHERE AD_Client_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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
        CDebtpaymentData objectCDebtpaymentData = new CDebtpaymentData();
        objectCDebtpaymentData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectCDebtpaymentData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCDebtpaymentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCDebtpaymentData.isactive = UtilSql.getValue(result, "isactive");
        objectCDebtpaymentData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectCDebtpaymentData.createdby = UtilSql.getValue(result, "createdby");
        objectCDebtpaymentData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectCDebtpaymentData.updatedby = UtilSql.getValue(result, "updatedby");
        objectCDebtpaymentData.isreceipt = UtilSql.getValue(result, "isreceipt");
        objectCDebtpaymentData.cSettlementCancelId = UtilSql.getValue(result, "c_settlement_cancel_id");
        objectCDebtpaymentData.cSettlementGenerateId = UtilSql.getValue(result, "c_settlement_generate_id");
        objectCDebtpaymentData.description = UtilSql.getValue(result, "description");
        objectCDebtpaymentData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCDebtpaymentData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCDebtpaymentData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCDebtpaymentData.cCashlineId = UtilSql.getValue(result, "c_cashline_id");
        objectCDebtpaymentData.cBankaccountId = UtilSql.getValue(result, "c_bankaccount_id");
        objectCDebtpaymentData.cCashbookId = UtilSql.getValue(result, "c_cashbook_id");
        objectCDebtpaymentData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectCDebtpaymentData.ispaid = UtilSql.getValue(result, "ispaid");
        objectCDebtpaymentData.amount = UtilSql.getValue(result, "amount");
        objectCDebtpaymentData.writeoffamt = UtilSql.getValue(result, "writeoffamt");
        objectCDebtpaymentData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectCDebtpaymentData.ismanual = UtilSql.getValue(result, "ismanual");
        objectCDebtpaymentData.isvalid = UtilSql.getValue(result, "isvalid");
        objectCDebtpaymentData.cBankstatementlineId = UtilSql.getValue(result, "c_bankstatementline_id");
        objectCDebtpaymentData.changesettlementcancel = UtilSql.getValue(result, "changesettlementcancel");
        objectCDebtpaymentData.cancelProcessed = UtilSql.getValue(result, "cancel_processed");
        objectCDebtpaymentData.generateProcessed = UtilSql.getValue(result, "generate_processed");
        objectCDebtpaymentData.glitemamt = UtilSql.getValue(result, "glitemamt");
        objectCDebtpaymentData.isdirectposting = UtilSql.getValue(result, "isdirectposting");
        objectCDebtpaymentData.cGlitemId = UtilSql.getValue(result, "c_glitem_id");
        objectCDebtpaymentData.status = UtilSql.getValue(result, "status");
        objectCDebtpaymentData.statusInitial = UtilSql.getValue(result, "status_initial");
        objectCDebtpaymentData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCDebtpaymentData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectCDebtpaymentData.isautomaticgenerated = UtilSql.getValue(result, "isautomaticgenerated");
        objectCDebtpaymentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCDebtpaymentData);
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
    CDebtpaymentData objectCDebtpaymentData[] = new CDebtpaymentData[vector.size()];
    vector.copyInto(objectCDebtpaymentData);
    return(objectCDebtpaymentData);
  }

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_DEBT_PAYMENT (C_DEBT_PAYMENT_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, C_BPARTNER_ID, C_CURRENCY_ID, PAYMENTRULE, ISPAID, AMOUNT, DATEPLANNED, ISMANUAL, ISVALID, CHANGESETTLEMENTCANCEL, CANCEL_PROCESSED, GENERATE_PROCESSED, GLITEMAMT, ISDIRECTPOSTING, STATUS, STATUS_INITIAL, C_ORDER_ID) " +
      "        VALUES ( ?, ?, ?, 'Y', TO_DATE(now()), ?, TO_DATE(now()), ?, ?, ?, ?, ?, TO_NUMBER(?), TO_DATE(?), ?, ?, ?, ?, ?, TO_NUMBER(?), ?, ?, ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismanual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvalid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changesettlementcancel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancelProcessed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateProcessed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glitemamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdirectposting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, statusInitial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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
