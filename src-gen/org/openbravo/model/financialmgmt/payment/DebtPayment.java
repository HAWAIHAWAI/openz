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
package org.openbravo.model.financialmgmt.payment;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.bank.BankAccount;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.financialmgmt.cashmgmt.BankStatementLine;
import org.openbravo.model.financialmgmt.cashmgmt.CashBook;
import org.openbravo.model.financialmgmt.cashmgmt.CashJournalLine;
import org.openbravo.model.financialmgmt.gl.GLItem;
import org.openbravo.model.financialmgmt.tax.Withholding;
import org.openbravo.model.project.Project;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity FinancialMgmtDebtPayment (stored in table C_Debt_Payment).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class DebtPayment extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Debt_Payment";
    public static final String ENTITY_NAME = "FinancialMgmtDebtPayment";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ISRECEIPT = "isReceipt";
    public static final String PROPERTY_SETTLEMENTCANCEL = "settlementCancel";
    public static final String PROPERTY_SETTLEMENTGENERATE =
        "settlementGenerate";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_CASHLINE = "cashLine";
    public static final String PROPERTY_BANKACCOUNT = "bankAccount";
    public static final String PROPERTY_CASHBOOK = "cashBook";
    public static final String PROPERTY_PAYMENTRULE = "paymentRule";
    public static final String PROPERTY_ISPAID = "isPaid";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_WRITEOFFAMT = "writeOffAmt";
    public static final String PROPERTY_DATEPLANNED = "dateplanned";
    public static final String PROPERTY_ISMANUAL = "isManual";
    public static final String PROPERTY_ISVALID = "isValid";
    public static final String PROPERTY_BANKSTATEMENTLINE = "bankStatementLine";
    public static final String PROPERTY_CHANGESETTLEMENTCANCEL =
        "changesettlementcancel";
    public static final String PROPERTY_CANCELPROCESSED = "cancelProcessed";
    public static final String PROPERTY_GENERATEPROCESSED = "generateProcessed";
    public static final String PROPERTY_GLITEMAMT = "gLItemAmt";
    public static final String PROPERTY_ISDIRECTPOSTING = "isdirectposting";
    public static final String PROPERTY_GLITEM = "glitem";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ISAUTOMATICGENERATED =
        "isAutomaticGenerated";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_STATUSINITIAL = "statusInitial";
    public static final String PROPERTY_WITHHOLDING = "withholding";
    public static final String PROPERTY_WITHHOLDINGAMOUNT = "withholdingamount";
    public static final String PROPERTY_DISCOUNTAMT = "discountamt";
    public static final String PROPERTY_ISAPPROVED = "isapproved";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTBALREPLACELIST =
        "financialMgmtDebtPaymentBalReplaceList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTBALANCINGLIST =
        "financialMgmtDebtPaymentBalancingList";

    public DebtPayment() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISPAID, false);
        setDefaultValue(PROPERTY_AMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_WRITEOFFAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISMANUAL, false);
        setDefaultValue(PROPERTY_ISVALID, false);
        setDefaultValue(PROPERTY_CHANGESETTLEMENTCANCEL, false);
        setDefaultValue(PROPERTY_CANCELPROCESSED, false);
        setDefaultValue(PROPERTY_GENERATEPROCESSED, false);
        setDefaultValue(PROPERTY_GLITEMAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISDIRECTPOSTING, false);
        setDefaultValue(PROPERTY_ISAUTOMATICGENERATED, false);
        setDefaultValue(PROPERTY_STATUS, "DE");
        setDefaultValue(PROPERTY_STATUSINITIAL, "DE");
        setDefaultValue(PROPERTY_WITHHOLDINGAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_DISCOUNTAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISAPPROVED, false);
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALREPLACELIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALANCINGLIST,
            new ArrayList<Object>());
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

    public Boolean isReceipt() {
        return (Boolean) get(PROPERTY_ISRECEIPT);
    }

    public void setReceipt(Boolean isReceipt) {
        set(PROPERTY_ISRECEIPT, isReceipt);
    }

    public Settlement getSettlementCancel() {
        return (Settlement) get(PROPERTY_SETTLEMENTCANCEL);
    }

    public void setSettlementCancel(Settlement settlementCancel) {
        set(PROPERTY_SETTLEMENTCANCEL, settlementCancel);
    }

    public Settlement getSettlementGenerate() {
        return (Settlement) get(PROPERTY_SETTLEMENTGENERATE);
    }

    public void setSettlementGenerate(Settlement settlementGenerate) {
        set(PROPERTY_SETTLEMENTGENERATE, settlementGenerate);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public CashJournalLine getCashLine() {
        return (CashJournalLine) get(PROPERTY_CASHLINE);
    }

    public void setCashLine(CashJournalLine cashLine) {
        set(PROPERTY_CASHLINE, cashLine);
    }

    public BankAccount getBankAccount() {
        return (BankAccount) get(PROPERTY_BANKACCOUNT);
    }

    public void setBankAccount(BankAccount bankAccount) {
        set(PROPERTY_BANKACCOUNT, bankAccount);
    }

    public CashBook getCashBook() {
        return (CashBook) get(PROPERTY_CASHBOOK);
    }

    public void setCashBook(CashBook cashBook) {
        set(PROPERTY_CASHBOOK, cashBook);
    }

    public String getPaymentRule() {
        return (String) get(PROPERTY_PAYMENTRULE);
    }

    public void setPaymentRule(String paymentRule) {
        set(PROPERTY_PAYMENTRULE, paymentRule);
    }

    public Boolean isPaid() {
        return (Boolean) get(PROPERTY_ISPAID);
    }

    public void setPaid(Boolean isPaid) {
        set(PROPERTY_ISPAID, isPaid);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public BigDecimal getWriteOffAmt() {
        return (BigDecimal) get(PROPERTY_WRITEOFFAMT);
    }

    public void setWriteOffAmt(BigDecimal writeOffAmt) {
        set(PROPERTY_WRITEOFFAMT, writeOffAmt);
    }

    public Date getDateplanned() {
        return (Date) get(PROPERTY_DATEPLANNED);
    }

    public void setDateplanned(Date dateplanned) {
        set(PROPERTY_DATEPLANNED, dateplanned);
    }

    public Boolean isManual() {
        return (Boolean) get(PROPERTY_ISMANUAL);
    }

    public void setManual(Boolean isManual) {
        set(PROPERTY_ISMANUAL, isManual);
    }

    public Boolean isValid() {
        return (Boolean) get(PROPERTY_ISVALID);
    }

    public void setValid(Boolean isValid) {
        set(PROPERTY_ISVALID, isValid);
    }

    public BankStatementLine getBankStatementLine() {
        return (BankStatementLine) get(PROPERTY_BANKSTATEMENTLINE);
    }

    public void setBankStatementLine(BankStatementLine bankStatementLine) {
        set(PROPERTY_BANKSTATEMENTLINE, bankStatementLine);
    }

    public Boolean isChangesettlementcancel() {
        return (Boolean) get(PROPERTY_CHANGESETTLEMENTCANCEL);
    }

    public void setChangesettlementcancel(Boolean changesettlementcancel) {
        set(PROPERTY_CHANGESETTLEMENTCANCEL, changesettlementcancel);
    }

    public Boolean isCancelProcessed() {
        return (Boolean) get(PROPERTY_CANCELPROCESSED);
    }

    public void setCancelProcessed(Boolean cancelProcessed) {
        set(PROPERTY_CANCELPROCESSED, cancelProcessed);
    }

    public Boolean isGenerateProcessed() {
        return (Boolean) get(PROPERTY_GENERATEPROCESSED);
    }

    public void setGenerateProcessed(Boolean generateProcessed) {
        set(PROPERTY_GENERATEPROCESSED, generateProcessed);
    }

    public BigDecimal getGLItemAmt() {
        return (BigDecimal) get(PROPERTY_GLITEMAMT);
    }

    public void setGLItemAmt(BigDecimal gLItemAmt) {
        set(PROPERTY_GLITEMAMT, gLItemAmt);
    }

    public Boolean isDirectposting() {
        return (Boolean) get(PROPERTY_ISDIRECTPOSTING);
    }

    public void setDirectposting(Boolean isdirectposting) {
        set(PROPERTY_ISDIRECTPOSTING, isdirectposting);
    }

    public GLItem getGlitem() {
        return (GLItem) get(PROPERTY_GLITEM);
    }

    public void setGlitem(GLItem glitem) {
        set(PROPERTY_GLITEM, glitem);
    }

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Boolean isAutomaticGenerated() {
        return (Boolean) get(PROPERTY_ISAUTOMATICGENERATED);
    }

    public void setAutomaticGenerated(Boolean isAutomaticGenerated) {
        set(PROPERTY_ISAUTOMATICGENERATED, isAutomaticGenerated);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public String getStatusInitial() {
        return (String) get(PROPERTY_STATUSINITIAL);
    }

    public void setStatusInitial(String statusInitial) {
        set(PROPERTY_STATUSINITIAL, statusInitial);
    }

    public Withholding getWithholding() {
        return (Withholding) get(PROPERTY_WITHHOLDING);
    }

    public void setWithholding(Withholding withholding) {
        set(PROPERTY_WITHHOLDING, withholding);
    }

    public BigDecimal getWithholdingamount() {
        return (BigDecimal) get(PROPERTY_WITHHOLDINGAMOUNT);
    }

    public void setWithholdingamount(BigDecimal withholdingamount) {
        set(PROPERTY_WITHHOLDINGAMOUNT, withholdingamount);
    }

    public BigDecimal getDiscountamt() {
        return (BigDecimal) get(PROPERTY_DISCOUNTAMT);
    }

    public void setDiscountamt(BigDecimal discountamt) {
        set(PROPERTY_DISCOUNTAMT, discountamt);
    }

    public Boolean isApproved() {
        return (Boolean) get(PROPERTY_ISAPPROVED);
    }

    public void setApproved(Boolean isapproved) {
        set(PROPERTY_ISAPPROVED, isapproved);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPaymentBalReplace> getFinancialMgmtDebtPaymentBalReplaceList() {
        return (List<DebtPaymentBalReplace>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALREPLACELIST);
    }

    public void setFinancialMgmtDebtPaymentBalReplaceList(
        List<DebtPaymentBalReplace> financialMgmtDebtPaymentBalReplaceList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALREPLACELIST,
            financialMgmtDebtPaymentBalReplaceList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPaymentBalancing> getFinancialMgmtDebtPaymentBalancingList() {
        return (List<DebtPaymentBalancing>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALANCINGLIST);
    }

    public void setFinancialMgmtDebtPaymentBalancingList(
        List<DebtPaymentBalancing> financialMgmtDebtPaymentBalancingList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALANCINGLIST,
            financialMgmtDebtPaymentBalancingList);
    }
}
