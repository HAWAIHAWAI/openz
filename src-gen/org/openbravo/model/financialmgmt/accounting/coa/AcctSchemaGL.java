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
package org.openbravo.model.financialmgmt.accounting.coa;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity FinancialMgmtAcctSchemaGL (stored in table C_AcctSchema_GL).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class AcctSchemaGL extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_AcctSchema_GL";
    public static final String ENTITY_NAME = "FinancialMgmtAcctSchemaGL";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ACCTSCHEMA = "acctSchema";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_USESUSPENSEBALANCING =
        "useSuspenseBalancing";
    public static final String PROPERTY_SUSPENSEBALANCINGACCT =
        "suspenseBalancingAcct";
    public static final String PROPERTY_USESUSPENSEERROR = "useSuspenseError";
    public static final String PROPERTY_SUSPENSEERRORACCT = "suspenseErrorAcct";
    public static final String PROPERTY_USECURRENCYBALANCING =
        "useCurrencyBalancing";
    public static final String PROPERTY_CURRENCYBALANCINGACCT =
        "currencyBalancingAcct";
    public static final String PROPERTY_RETAINEDEARNINGACCT =
        "retainedEarningAcct";
    public static final String PROPERTY_INCOMESUMMARYACCT = "incomeSummaryAcct";
    public static final String PROPERTY_INTERCOMPANYDUETOACCT =
        "intercompanyDueToAcct";
    public static final String PROPERTY_INTERCOMPANYDUEFROMACCT =
        "intercompanyDueFromAcct";
    public static final String PROPERTY_PPVOFFSETACCT = "pPVOffsetAcct";
    public static final String PROPERTY_CFSORDERACCT = "cFSOrderAcct";

    public AcctSchemaGL() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_USESUSPENSEBALANCING, false);
        setDefaultValue(PROPERTY_USESUSPENSEERROR, false);
        setDefaultValue(PROPERTY_USECURRENCYBALANCING, false);
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

    public Boolean isUseSuspenseBalancing() {
        return (Boolean) get(PROPERTY_USESUSPENSEBALANCING);
    }

    public void setUseSuspenseBalancing(Boolean useSuspenseBalancing) {
        set(PROPERTY_USESUSPENSEBALANCING, useSuspenseBalancing);
    }

    public AccountingCombination getSuspenseBalancingAcct() {
        return (AccountingCombination) get(PROPERTY_SUSPENSEBALANCINGACCT);
    }

    public void setSuspenseBalancingAcct(
        AccountingCombination suspenseBalancingAcct) {
        set(PROPERTY_SUSPENSEBALANCINGACCT, suspenseBalancingAcct);
    }

    public Boolean isUseSuspenseError() {
        return (Boolean) get(PROPERTY_USESUSPENSEERROR);
    }

    public void setUseSuspenseError(Boolean useSuspenseError) {
        set(PROPERTY_USESUSPENSEERROR, useSuspenseError);
    }

    public AccountingCombination getSuspenseErrorAcct() {
        return (AccountingCombination) get(PROPERTY_SUSPENSEERRORACCT);
    }

    public void setSuspenseErrorAcct(AccountingCombination suspenseErrorAcct) {
        set(PROPERTY_SUSPENSEERRORACCT, suspenseErrorAcct);
    }

    public Boolean isUseCurrencyBalancing() {
        return (Boolean) get(PROPERTY_USECURRENCYBALANCING);
    }

    public void setUseCurrencyBalancing(Boolean useCurrencyBalancing) {
        set(PROPERTY_USECURRENCYBALANCING, useCurrencyBalancing);
    }

    public AccountingCombination getCurrencyBalancingAcct() {
        return (AccountingCombination) get(PROPERTY_CURRENCYBALANCINGACCT);
    }

    public void setCurrencyBalancingAcct(
        AccountingCombination currencyBalancingAcct) {
        set(PROPERTY_CURRENCYBALANCINGACCT, currencyBalancingAcct);
    }

    public AccountingCombination getRetainedEarningAcct() {
        return (AccountingCombination) get(PROPERTY_RETAINEDEARNINGACCT);
    }

    public void setRetainedEarningAcct(
        AccountingCombination retainedEarningAcct) {
        set(PROPERTY_RETAINEDEARNINGACCT, retainedEarningAcct);
    }

    public AccountingCombination getIncomeSummaryAcct() {
        return (AccountingCombination) get(PROPERTY_INCOMESUMMARYACCT);
    }

    public void setIncomeSummaryAcct(AccountingCombination incomeSummaryAcct) {
        set(PROPERTY_INCOMESUMMARYACCT, incomeSummaryAcct);
    }

    public AccountingCombination getIntercompanyDueToAcct() {
        return (AccountingCombination) get(PROPERTY_INTERCOMPANYDUETOACCT);
    }

    public void setIntercompanyDueToAcct(
        AccountingCombination intercompanyDueToAcct) {
        set(PROPERTY_INTERCOMPANYDUETOACCT, intercompanyDueToAcct);
    }

    public AccountingCombination getIntercompanyDueFromAcct() {
        return (AccountingCombination) get(PROPERTY_INTERCOMPANYDUEFROMACCT);
    }

    public void setIntercompanyDueFromAcct(
        AccountingCombination intercompanyDueFromAcct) {
        set(PROPERTY_INTERCOMPANYDUEFROMACCT, intercompanyDueFromAcct);
    }

    public AccountingCombination getPPVOffsetAcct() {
        return (AccountingCombination) get(PROPERTY_PPVOFFSETACCT);
    }

    public void setPPVOffsetAcct(AccountingCombination pPVOffsetAcct) {
        set(PROPERTY_PPVOFFSETACCT, pPVOffsetAcct);
    }

    public AccountingCombination getCFSOrderAcct() {
        return (AccountingCombination) get(PROPERTY_CFSORDERACCT);
    }

    public void setCFSOrderAcct(AccountingCombination cFSOrderAcct) {
        set(PROPERTY_CFSORDERACCT, cFSOrderAcct);
    }
}
