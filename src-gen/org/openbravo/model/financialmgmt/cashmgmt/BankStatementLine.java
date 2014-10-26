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
package org.openbravo.model.financialmgmt.cashmgmt;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.gl.GLCharge;
import org.openbravo.model.financialmgmt.gl.GLItem;
import org.openbravo.model.financialmgmt.payment.DPManagement;
import org.openbravo.model.financialmgmt.payment.DebtPayment;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity FinancialMgmtBankStatementLine (stored in table C_BankStatementLine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class BankStatementLine extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_BankStatementLine";
    public static final String ENTITY_NAME = "FinancialMgmtBankStatementLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BANKSTATEMENT = "bankStatement";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_VALUTADATE = "valutaDate";
    public static final String PROPERTY_DATEACCT = "dateAcct";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_TRXAMT = "trxAmt";
    public static final String PROPERTY_STMTAMT = "stmtAmt";
    public static final String PROPERTY_CHARGE = "charge";
    public static final String PROPERTY_CHARGEAMT = "chargeAmt";
    public static final String PROPERTY_MEMO = "memo";
    public static final String PROPERTY_REFERENCENO = "referenceNo";
    public static final String PROPERTY_DEBTPAYMENT = "debtPayment";
    public static final String PROPERTY_CONVERTCHARGEAMT = "convertChargeAmt";
    public static final String PROPERTY_DEBTPAYMENTCREATE = "debtPaymentCreate";
    public static final String PROPERTY_DPMANAGEMENT = "dpManagement";
    public static final String PROPERTY_GLITEM = "glitem";
    public static final String PROPERTY_DISCOUNTAMT = "discountamt";
    public static final String PROPERTY_ISVOIDED = "isvoided";
    public static final String PROPERTY_SEPAEXPORTENABLED = "sepaexportenabled";
    public static final String PROPERTY_VOIDLINE = "voidline";

    public BankStatementLine() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_CONVERTCHARGEAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_DEBTPAYMENTCREATE, false);
        setDefaultValue(PROPERTY_DISCOUNTAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISVOIDED, false);
        setDefaultValue(PROPERTY_SEPAEXPORTENABLED, false);
        setDefaultValue(PROPERTY_VOIDLINE, false);
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

    public BankStatement getBankStatement() {
        return (BankStatement) get(PROPERTY_BANKSTATEMENT);
    }

    public void setBankStatement(BankStatement bankStatement) {
        set(PROPERTY_BANKSTATEMENT, bankStatement);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Date getValutaDate() {
        return (Date) get(PROPERTY_VALUTADATE);
    }

    public void setValutaDate(Date valutaDate) {
        set(PROPERTY_VALUTADATE, valutaDate);
    }

    public Date getDateAcct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateAcct(Date dateAcct) {
        set(PROPERTY_DATEACCT, dateAcct);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public BigDecimal getTrxAmt() {
        return (BigDecimal) get(PROPERTY_TRXAMT);
    }

    public void setTrxAmt(BigDecimal trxAmt) {
        set(PROPERTY_TRXAMT, trxAmt);
    }

    public BigDecimal getStmtAmt() {
        return (BigDecimal) get(PROPERTY_STMTAMT);
    }

    public void setStmtAmt(BigDecimal stmtAmt) {
        set(PROPERTY_STMTAMT, stmtAmt);
    }

    public GLCharge getCharge() {
        return (GLCharge) get(PROPERTY_CHARGE);
    }

    public void setCharge(GLCharge charge) {
        set(PROPERTY_CHARGE, charge);
    }

    public BigDecimal getChargeAmt() {
        return (BigDecimal) get(PROPERTY_CHARGEAMT);
    }

    public void setChargeAmt(BigDecimal chargeAmt) {
        set(PROPERTY_CHARGEAMT, chargeAmt);
    }

    public String getMemo() {
        return (String) get(PROPERTY_MEMO);
    }

    public void setMemo(String memo) {
        set(PROPERTY_MEMO, memo);
    }

    public String getReferenceNo() {
        return (String) get(PROPERTY_REFERENCENO);
    }

    public void setReferenceNo(String referenceNo) {
        set(PROPERTY_REFERENCENO, referenceNo);
    }

    public DebtPayment getDebtPayment() {
        return (DebtPayment) get(PROPERTY_DEBTPAYMENT);
    }

    public void setDebtPayment(DebtPayment debtPayment) {
        set(PROPERTY_DEBTPAYMENT, debtPayment);
    }

    public BigDecimal getConvertChargeAmt() {
        return (BigDecimal) get(PROPERTY_CONVERTCHARGEAMT);
    }

    public void setConvertChargeAmt(BigDecimal convertChargeAmt) {
        set(PROPERTY_CONVERTCHARGEAMT, convertChargeAmt);
    }

    public Boolean isDebtPaymentCreate() {
        return (Boolean) get(PROPERTY_DEBTPAYMENTCREATE);
    }

    public void setDebtPaymentCreate(Boolean debtPaymentCreate) {
        set(PROPERTY_DEBTPAYMENTCREATE, debtPaymentCreate);
    }

    public DPManagement getDpManagement() {
        return (DPManagement) get(PROPERTY_DPMANAGEMENT);
    }

    public void setDpManagement(DPManagement dpManagement) {
        set(PROPERTY_DPMANAGEMENT, dpManagement);
    }

    public GLItem getGlitem() {
        return (GLItem) get(PROPERTY_GLITEM);
    }

    public void setGlitem(GLItem glitem) {
        set(PROPERTY_GLITEM, glitem);
    }

    public BigDecimal getDiscountamt() {
        return (BigDecimal) get(PROPERTY_DISCOUNTAMT);
    }

    public void setDiscountamt(BigDecimal discountamt) {
        set(PROPERTY_DISCOUNTAMT, discountamt);
    }

    public Boolean isVoided() {
        return (Boolean) get(PROPERTY_ISVOIDED);
    }

    public void setVoided(Boolean isvoided) {
        set(PROPERTY_ISVOIDED, isvoided);
    }

    public Boolean isSepaexportenabled() {
        return (Boolean) get(PROPERTY_SEPAEXPORTENABLED);
    }

    public void setSepaexportenabled(Boolean sepaexportenabled) {
        set(PROPERTY_SEPAEXPORTENABLED, sepaexportenabled);
    }

    public Boolean isVoidline() {
        return (Boolean) get(PROPERTY_VOIDLINE);
    }

    public void setVoidline(Boolean voidline) {
        set(PROPERTY_VOIDLINE, voidline);
    }
}
