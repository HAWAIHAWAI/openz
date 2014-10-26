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
package org.openbravo.model.financialmgmt.gl;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.coa.AccountingCombination;
import org.openbravo.model.financialmgmt.payment.DebtPayment;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.financialmgmt.tax.Withholding;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity FinancialMgmtGLJournalLine (stored in table GL_JournalLine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class GLJournalLine extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "GL_JournalLine";
    public static final String ENTITY_NAME = "FinancialMgmtGLJournalLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_JOURNAL = "journal";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_ISGENERATED = "isGenerated";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_AMTSOURCEDR = "amtSourceDr";
    public static final String PROPERTY_AMTSOURCECR = "amtSourceCr";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_CURRENCYRATETYPE = "currencyRateType";
    public static final String PROPERTY_CURRENCYRATE = "currencyRate";
    public static final String PROPERTY_DATEACCT = "dateAcct";
    public static final String PROPERTY_AMTACCTDR = "amtAcctDr";
    public static final String PROPERTY_AMTACCTCR = "amtAcctCr";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_QTY = "qty";
    public static final String PROPERTY_VALIDCOMBINATION = "validCombination";
    public static final String PROPERTY_DEBTPAYMENT = "debtPayment";
    public static final String PROPERTY_WITHHOLDING = "withholding";
    public static final String PROPERTY_TAX = "tax";

    public GLJournalLine() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISGENERATED, false);
        setDefaultValue(PROPERTY_CURRENCYRATETYPE, "S");
        setDefaultValue(PROPERTY_CURRENCYRATE, new BigDecimal(1));
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

    public GLJournal getJournal() {
        return (GLJournal) get(PROPERTY_JOURNAL);
    }

    public void setJournal(GLJournal journal) {
        set(PROPERTY_JOURNAL, journal);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public Boolean isGenerated() {
        return (Boolean) get(PROPERTY_ISGENERATED);
    }

    public void setGenerated(Boolean isGenerated) {
        set(PROPERTY_ISGENERATED, isGenerated);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public BigDecimal getAmtSourceDr() {
        return (BigDecimal) get(PROPERTY_AMTSOURCEDR);
    }

    public void setAmtSourceDr(BigDecimal amtSourceDr) {
        set(PROPERTY_AMTSOURCEDR, amtSourceDr);
    }

    public BigDecimal getAmtSourceCr() {
        return (BigDecimal) get(PROPERTY_AMTSOURCECR);
    }

    public void setAmtSourceCr(BigDecimal amtSourceCr) {
        set(PROPERTY_AMTSOURCECR, amtSourceCr);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public String getCurrencyRateType() {
        return (String) get(PROPERTY_CURRENCYRATETYPE);
    }

    public void setCurrencyRateType(String currencyRateType) {
        set(PROPERTY_CURRENCYRATETYPE, currencyRateType);
    }

    public BigDecimal getCurrencyRate() {
        return (BigDecimal) get(PROPERTY_CURRENCYRATE);
    }

    public void setCurrencyRate(BigDecimal currencyRate) {
        set(PROPERTY_CURRENCYRATE, currencyRate);
    }

    public Date getDateAcct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateAcct(Date dateAcct) {
        set(PROPERTY_DATEACCT, dateAcct);
    }

    public BigDecimal getAmtAcctDr() {
        return (BigDecimal) get(PROPERTY_AMTACCTDR);
    }

    public void setAmtAcctDr(BigDecimal amtAcctDr) {
        set(PROPERTY_AMTACCTDR, amtAcctDr);
    }

    public BigDecimal getAmtAcctCr() {
        return (BigDecimal) get(PROPERTY_AMTACCTCR);
    }

    public void setAmtAcctCr(BigDecimal amtAcctCr) {
        set(PROPERTY_AMTACCTCR, amtAcctCr);
    }

    public org.openbravo.model.common.uom.UOM getUOM() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUOM(org.openbravo.model.common.uom.UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public BigDecimal getQty() {
        return (BigDecimal) get(PROPERTY_QTY);
    }

    public void setQty(BigDecimal qty) {
        set(PROPERTY_QTY, qty);
    }

    public AccountingCombination getValidCombination() {
        return (AccountingCombination) get(PROPERTY_VALIDCOMBINATION);
    }

    public void setValidCombination(AccountingCombination validCombination) {
        set(PROPERTY_VALIDCOMBINATION, validCombination);
    }

    public DebtPayment getDebtPayment() {
        return (DebtPayment) get(PROPERTY_DEBTPAYMENT);
    }

    public void setDebtPayment(DebtPayment debtPayment) {
        set(PROPERTY_DEBTPAYMENT, debtPayment);
    }

    public Withholding getWithholding() {
        return (Withholding) get(PROPERTY_WITHHOLDING);
    }

    public void setWithholding(Withholding withholding) {
        set(PROPERTY_WITHHOLDING, withholding);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }
}
