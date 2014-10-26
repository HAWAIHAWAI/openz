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
import org.openbravo.model.common.order.Order;
import org.openbravo.model.financialmgmt.gl.GLCharge;
import org.openbravo.model.financialmgmt.gl.GLItem;
import org.openbravo.model.financialmgmt.payment.DebtPayment;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity FinancialMgmtJournalLine (stored in table C_CashLine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class CashJournalLine extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_CashLine";
    public static final String ENTITY_NAME = "FinancialMgmtJournalLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CASH = "cash";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_CASHTYPE = "cashType";
    public static final String PROPERTY_CHARGE = "charge";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_DISCOUNTAMT = "discountAmt";
    public static final String PROPERTY_WRITEOFFAMT = "writeOffAmt";
    public static final String PROPERTY_ISGENERATED = "isGenerated";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_DEBTPAYMENT = "debtPayment";
    public static final String PROPERTY_GLITEM = "glitem";
    public static final String PROPERTY_PAYINADVANCE = "payInAdvance";

    public CashJournalLine() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_CASHTYPE, "E");
        setDefaultValue(PROPERTY_ISGENERATED, false);
        setDefaultValue(PROPERTY_PAYINADVANCE, false);
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

    public CashJournal getCash() {
        return (CashJournal) get(PROPERTY_CASH);
    }

    public void setCash(CashJournal cash) {
        set(PROPERTY_CASH, cash);
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

    public String getCashType() {
        return (String) get(PROPERTY_CASHTYPE);
    }

    public void setCashType(String cashType) {
        set(PROPERTY_CASHTYPE, cashType);
    }

    public GLCharge getCharge() {
        return (GLCharge) get(PROPERTY_CHARGE);
    }

    public void setCharge(GLCharge charge) {
        set(PROPERTY_CHARGE, charge);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public BigDecimal getDiscountAmt() {
        return (BigDecimal) get(PROPERTY_DISCOUNTAMT);
    }

    public void setDiscountAmt(BigDecimal discountAmt) {
        set(PROPERTY_DISCOUNTAMT, discountAmt);
    }

    public BigDecimal getWriteOffAmt() {
        return (BigDecimal) get(PROPERTY_WRITEOFFAMT);
    }

    public void setWriteOffAmt(BigDecimal writeOffAmt) {
        set(PROPERTY_WRITEOFFAMT, writeOffAmt);
    }

    public Boolean isGenerated() {
        return (Boolean) get(PROPERTY_ISGENERATED);
    }

    public void setGenerated(Boolean isGenerated) {
        set(PROPERTY_ISGENERATED, isGenerated);
    }

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

    public DebtPayment getDebtPayment() {
        return (DebtPayment) get(PROPERTY_DEBTPAYMENT);
    }

    public void setDebtPayment(DebtPayment debtPayment) {
        set(PROPERTY_DEBTPAYMENT, debtPayment);
    }

    public GLItem getGlitem() {
        return (GLItem) get(PROPERTY_GLITEM);
    }

    public void setGlitem(GLItem glitem) {
        set(PROPERTY_GLITEM, glitem);
    }

    public Boolean isPayInAdvance() {
        return (Boolean) get(PROPERTY_PAYINADVANCE);
    }

    public void setPayInAdvance(Boolean payInAdvance) {
        set(PROPERTY_PAYINADVANCE, payInAdvance);
    }
}
