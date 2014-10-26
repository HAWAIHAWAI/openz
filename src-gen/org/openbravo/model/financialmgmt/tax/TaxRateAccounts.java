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
package org.openbravo.model.financialmgmt.tax;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.coa.AccountingCombination;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity FinancialMgmtTaxRateAccounts (stored in table C_Tax_Acct).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class TaxRateAccounts extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Tax_Acct";
    public static final String ENTITY_NAME = "FinancialMgmtTaxRateAccounts";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_ACCTSCHEMA = "acctSchema";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DUEACCT = "dueAcct";
    public static final String PROPERTY_LIABILITYACCT = "liabilityAcct";
    public static final String PROPERTY_CREDITACCT = "creditAcct";
    public static final String PROPERTY_RECEIVABLESACCT = "receivablesAcct";
    public static final String PROPERTY_EXPENSEACCT = "expenseAcct";
    public static final String PROPERTY_PREVENUEACCT = "pRevenueAcct";
    public static final String PROPERTY_PEXPENSEACCT = "pExpenseAcct";
    public static final String PROPERTY_ARDISCOUNTACCT = "arDiscountAcct";
    public static final String PROPERTY_APDISCOUNTACCT = "apDiscountAcct";
    public static final String PROPERTY_WRITEOFFACCT = "writeoffAcct";

    public TaxRateAccounts() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
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

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public AcctSchema getAcctSchema() {
        return (AcctSchema) get(PROPERTY_ACCTSCHEMA);
    }

    public void setAcctSchema(AcctSchema acctSchema) {
        set(PROPERTY_ACCTSCHEMA, acctSchema);
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

    public AccountingCombination getDueAcct() {
        return (AccountingCombination) get(PROPERTY_DUEACCT);
    }

    public void setDueAcct(AccountingCombination dueAcct) {
        set(PROPERTY_DUEACCT, dueAcct);
    }

    public AccountingCombination getLiabilityAcct() {
        return (AccountingCombination) get(PROPERTY_LIABILITYACCT);
    }

    public void setLiabilityAcct(AccountingCombination liabilityAcct) {
        set(PROPERTY_LIABILITYACCT, liabilityAcct);
    }

    public AccountingCombination getCreditAcct() {
        return (AccountingCombination) get(PROPERTY_CREDITACCT);
    }

    public void setCreditAcct(AccountingCombination creditAcct) {
        set(PROPERTY_CREDITACCT, creditAcct);
    }

    public AccountingCombination getReceivablesAcct() {
        return (AccountingCombination) get(PROPERTY_RECEIVABLESACCT);
    }

    public void setReceivablesAcct(AccountingCombination receivablesAcct) {
        set(PROPERTY_RECEIVABLESACCT, receivablesAcct);
    }

    public AccountingCombination getExpenseAcct() {
        return (AccountingCombination) get(PROPERTY_EXPENSEACCT);
    }

    public void setExpenseAcct(AccountingCombination expenseAcct) {
        set(PROPERTY_EXPENSEACCT, expenseAcct);
    }

    public AccountingCombination getPRevenueAcct() {
        return (AccountingCombination) get(PROPERTY_PREVENUEACCT);
    }

    public void setPRevenueAcct(AccountingCombination pRevenueAcct) {
        set(PROPERTY_PREVENUEACCT, pRevenueAcct);
    }

    public AccountingCombination getPExpenseAcct() {
        return (AccountingCombination) get(PROPERTY_PEXPENSEACCT);
    }

    public void setPExpenseAcct(AccountingCombination pExpenseAcct) {
        set(PROPERTY_PEXPENSEACCT, pExpenseAcct);
    }

    public AccountingCombination getArDiscountAcct() {
        return (AccountingCombination) get(PROPERTY_ARDISCOUNTACCT);
    }

    public void setArDiscountAcct(AccountingCombination arDiscountAcct) {
        set(PROPERTY_ARDISCOUNTACCT, arDiscountAcct);
    }

    public AccountingCombination getApDiscountAcct() {
        return (AccountingCombination) get(PROPERTY_APDISCOUNTACCT);
    }

    public void setApDiscountAcct(AccountingCombination apDiscountAcct) {
        set(PROPERTY_APDISCOUNTACCT, apDiscountAcct);
    }

    public AccountingCombination getWriteoffAcct() {
        return (AccountingCombination) get(PROPERTY_WRITEOFFACCT);
    }

    public void setWriteoffAcct(AccountingCombination writeoffAcct) {
        set(PROPERTY_WRITEOFFACCT, writeoffAcct);
    }
}
