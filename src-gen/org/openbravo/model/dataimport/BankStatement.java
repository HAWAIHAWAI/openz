/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SL
 * All portions are Copyright (C) 2008-2009 Openbravo SL
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package org.openbravo.model.dataimport;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.bank.BankAccount;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.cashmgmt.BankStatementLine;
import org.openbravo.model.financialmgmt.gl.GLCharge;
import org.openbravo.model.financialmgmt.payment.DebtPayment;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity DataImportBankStatement (stored in table I_BankStatement).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class BankStatement extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "I_BankStatement";
    public static final String ENTITY_NAME = "DataImportBankStatement";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ISIMPORTED = "isImported";
    public static final String PROPERTY_ERRORMSG = "errorMsg";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_BANKSTATEMENT = "bankStatement";
    public static final String PROPERTY_STATEMENTDATE = "statementDate";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_BANKACCOUNT = "bankAccount";
    public static final String PROPERTY_ROUTINGNO = "routingNo";
    public static final String PROPERTY_BANKACCOUNTNO = "bankAccountNo";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_BPARTNERVALUE = "bPartnerValue";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_INVOICEDOCUMENTNO = "invoiceDocumentNo";
    public static final String PROPERTY_CHARGE = "charge";
    public static final String PROPERTY_CHARGENAME = "chargeName";
    public static final String PROPERTY_CHARGEAMT = "chargeAmt";
    public static final String PROPERTY_BANKSTATEMENTLINE = "bankStatementLine";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_DATEACCT = "dateAcct";
    public static final String PROPERTY_TRXTYPE = "trxType";
    public static final String PROPERTY_REFERENCENO = "referenceNo";
    public static final String PROPERTY_MEMO = "memo";
    public static final String PROPERTY_VALUTADATE = "valutaDate";
    public static final String PROPERTY_ISREVERSAL = "isReversal";
    public static final String PROPERTY_INTERESTAMT = "interestAmt";
    public static final String PROPERTY_TRXAMT = "trxAmt";
    public static final String PROPERTY_LINEDESCRIPTION = "lineDescription";
    public static final String PROPERTY_STMTAMT = "stmtAmt";
    public static final String PROPERTY_DEBTPAYMENT = "debtPayment";

    public BankStatement() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISIMPORTED, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_ISREVERSAL, false);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public Organization getOrg() {
        return (Organization) get(PROPERTY_ORG);
    }

    public void setOrg(Organization org) {
        set(PROPERTY_ORG, org);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ISACTIVE);
    }

    public void setActive(Boolean isActive) {
        set(PROPERTY_ISACTIVE, isActive);
    }

    public Date getCreated() {
        return (Date) get(PROPERTY_CREATED);
    }

    public void setCreated(Date created) {
        set(PROPERTY_CREATED, created);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public Boolean isImported() {
        return (Boolean) get(PROPERTY_ISIMPORTED);
    }

    public void setImported(Boolean isImported) {
        set(PROPERTY_ISIMPORTED, isImported);
    }

    public String getErrorMsg() {
        return (String) get(PROPERTY_ERRORMSG);
    }

    public void setErrorMsg(String errorMsg) {
        set(PROPERTY_ERRORMSG, errorMsg);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public org.openbravo.model.financialmgmt.cashmgmt.BankStatement getBankStatement() {
        return (org.openbravo.model.financialmgmt.cashmgmt.BankStatement) get(PROPERTY_BANKSTATEMENT);
    }

    public void setBankStatement(
        org.openbravo.model.financialmgmt.cashmgmt.BankStatement bankStatement) {
        set(PROPERTY_BANKSTATEMENT, bankStatement);
    }

    public Date getStatementDate() {
        return (Date) get(PROPERTY_STATEMENTDATE);
    }

    public void setStatementDate(Date statementDate) {
        set(PROPERTY_STATEMENTDATE, statementDate);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public BankAccount getBankAccount() {
        return (BankAccount) get(PROPERTY_BANKACCOUNT);
    }

    public void setBankAccount(BankAccount bankAccount) {
        set(PROPERTY_BANKACCOUNT, bankAccount);
    }

    public String getRoutingNo() {
        return (String) get(PROPERTY_ROUTINGNO);
    }

    public void setRoutingNo(String routingNo) {
        set(PROPERTY_ROUTINGNO, routingNo);
    }

    public String getBankAccountNo() {
        return (String) get(PROPERTY_BANKACCOUNTNO);
    }

    public void setBankAccountNo(String bankAccountNo) {
        set(PROPERTY_BANKACCOUNTNO, bankAccountNo);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getBPartnerValue() {
        return (String) get(PROPERTY_BPARTNERVALUE);
    }

    public void setBPartnerValue(String bPartnerValue) {
        set(PROPERTY_BPARTNERVALUE, bPartnerValue);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public String getInvoiceDocumentNo() {
        return (String) get(PROPERTY_INVOICEDOCUMENTNO);
    }

    public void setInvoiceDocumentNo(String invoiceDocumentNo) {
        set(PROPERTY_INVOICEDOCUMENTNO, invoiceDocumentNo);
    }

    public GLCharge getCharge() {
        return (GLCharge) get(PROPERTY_CHARGE);
    }

    public void setCharge(GLCharge charge) {
        set(PROPERTY_CHARGE, charge);
    }

    public String getChargeName() {
        return (String) get(PROPERTY_CHARGENAME);
    }

    public void setChargeName(String chargeName) {
        set(PROPERTY_CHARGENAME, chargeName);
    }

    public BigDecimal getChargeAmt() {
        return (BigDecimal) get(PROPERTY_CHARGEAMT);
    }

    public void setChargeAmt(BigDecimal chargeAmt) {
        set(PROPERTY_CHARGEAMT, chargeAmt);
    }

    public BankStatementLine getBankStatementLine() {
        return (BankStatementLine) get(PROPERTY_BANKSTATEMENTLINE);
    }

    public void setBankStatementLine(BankStatementLine bankStatementLine) {
        set(PROPERTY_BANKSTATEMENTLINE, bankStatementLine);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public Date getDateAcct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateAcct(Date dateAcct) {
        set(PROPERTY_DATEACCT, dateAcct);
    }

    public String getTrxType() {
        return (String) get(PROPERTY_TRXTYPE);
    }

    public void setTrxType(String trxType) {
        set(PROPERTY_TRXTYPE, trxType);
    }

    public String getReferenceNo() {
        return (String) get(PROPERTY_REFERENCENO);
    }

    public void setReferenceNo(String referenceNo) {
        set(PROPERTY_REFERENCENO, referenceNo);
    }

    public String getMemo() {
        return (String) get(PROPERTY_MEMO);
    }

    public void setMemo(String memo) {
        set(PROPERTY_MEMO, memo);
    }

    public Date getValutaDate() {
        return (Date) get(PROPERTY_VALUTADATE);
    }

    public void setValutaDate(Date valutaDate) {
        set(PROPERTY_VALUTADATE, valutaDate);
    }

    public Boolean isReversal() {
        return (Boolean) get(PROPERTY_ISREVERSAL);
    }

    public void setReversal(Boolean isReversal) {
        set(PROPERTY_ISREVERSAL, isReversal);
    }

    public BigDecimal getInterestAmt() {
        return (BigDecimal) get(PROPERTY_INTERESTAMT);
    }

    public void setInterestAmt(BigDecimal interestAmt) {
        set(PROPERTY_INTERESTAMT, interestAmt);
    }

    public BigDecimal getTrxAmt() {
        return (BigDecimal) get(PROPERTY_TRXAMT);
    }

    public void setTrxAmt(BigDecimal trxAmt) {
        set(PROPERTY_TRXAMT, trxAmt);
    }

    public String getLineDescription() {
        return (String) get(PROPERTY_LINEDESCRIPTION);
    }

    public void setLineDescription(String lineDescription) {
        set(PROPERTY_LINEDESCRIPTION, lineDescription);
    }

    public BigDecimal getStmtAmt() {
        return (BigDecimal) get(PROPERTY_STMTAMT);
    }

    public void setStmtAmt(BigDecimal stmtAmt) {
        set(PROPERTY_STMTAMT, stmtAmt);
    }

    public DebtPayment getDebtPayment() {
        return (DebtPayment) get(PROPERTY_DEBTPAYMENT);
    }

    public void setDebtPayment(DebtPayment debtPayment) {
        set(PROPERTY_DEBTPAYMENT, debtPayment);
    }
}
