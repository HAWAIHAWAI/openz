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
package org.openbravo.model.common.businesspartner;

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
 * Entity class for entity BusinessPartnerCategoryAccount (stored in table C_BP_Group_Acct).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class CategoryAccounts extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_BP_Group_Acct";
    public static final String ENTITY_NAME = "BusinessPartnerCategoryAccount";
    public static final String PROPERTY_ACCTSCHEMA = "acctSchema";
    public static final String PROPERTY_BPGROUP = "bPGroup";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_RECEIVABLEACCT = "receivableAcct";
    public static final String PROPERTY_PREPAYMENTACCT = "prepaymentAcct";
    public static final String PROPERTY_LIABILITYACCT = "liabilityAcct";
    public static final String PROPERTY_LIABILITYSERVICESACCT =
        "liabilityServicesAcct";
    public static final String PROPERTY_PREPAYMENTACCT13 = "prepaymentAcct13";
    public static final String PROPERTY_PAYDISCOUNTEXPACCT =
        "payDiscountExpAcct";
    public static final String PROPERTY_PAYDISCOUNTREVACCT =
        "payDiscountRevAcct";
    public static final String PROPERTY_WRITEOFFACCT = "writeOffAcct";
    public static final String PROPERTY_UNREALIZEDGAINACCT =
        "unrealizedGainAcct";
    public static final String PROPERTY_UNREALIZEDLOSSACCT =
        "unrealizedLossAcct";
    public static final String PROPERTY_REALIZEDGAINACCT = "realizedGainAcct";
    public static final String PROPERTY_REALIZEDLOSSACCT = "realizedLossAcct";
    public static final String PROPERTY_NOTINVOICEDRECEIPTSACCT =
        "notInvoicedReceiptsAcct";
    public static final String PROPERTY_UNEARNEDREVENUEACCT =
        "unEarnedRevenueAcct";
    public static final String PROPERTY_NOTINVOICEDREVENUEACCT =
        "notInvoicedRevenueAcct";
    public static final String PROPERTY_NOTINVOICEDRECEIVABLESACCT =
        "notInvoicedReceivablesAcct";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_STATUS = "status";

    public CategoryAccounts() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSING, false);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public AcctSchema getAcctSchema() {
        return (AcctSchema) get(PROPERTY_ACCTSCHEMA);
    }

    public void setAcctSchema(AcctSchema acctSchema) {
        set(PROPERTY_ACCTSCHEMA, acctSchema);
    }

    public Category getBPGroup() {
        return (Category) get(PROPERTY_BPGROUP);
    }

    public void setBPGroup(Category bPGroup) {
        set(PROPERTY_BPGROUP, bPGroup);
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

    public AccountingCombination getReceivableAcct() {
        return (AccountingCombination) get(PROPERTY_RECEIVABLEACCT);
    }

    public void setReceivableAcct(AccountingCombination receivableAcct) {
        set(PROPERTY_RECEIVABLEACCT, receivableAcct);
    }

    public AccountingCombination getPrepaymentAcct() {
        return (AccountingCombination) get(PROPERTY_PREPAYMENTACCT);
    }

    public void setPrepaymentAcct(AccountingCombination prepaymentAcct) {
        set(PROPERTY_PREPAYMENTACCT, prepaymentAcct);
    }

    public AccountingCombination getLiabilityAcct() {
        return (AccountingCombination) get(PROPERTY_LIABILITYACCT);
    }

    public void setLiabilityAcct(AccountingCombination liabilityAcct) {
        set(PROPERTY_LIABILITYACCT, liabilityAcct);
    }

    public AccountingCombination getLiabilityServicesAcct() {
        return (AccountingCombination) get(PROPERTY_LIABILITYSERVICESACCT);
    }

    public void setLiabilityServicesAcct(
        AccountingCombination liabilityServicesAcct) {
        set(PROPERTY_LIABILITYSERVICESACCT, liabilityServicesAcct);
    }

    public AccountingCombination getPrepaymentAcct13() {
        return (AccountingCombination) get(PROPERTY_PREPAYMENTACCT13);
    }

    public void setPrepaymentAcct13(AccountingCombination prepaymentAcct13) {
        set(PROPERTY_PREPAYMENTACCT13, prepaymentAcct13);
    }

    public AccountingCombination getPayDiscountExpAcct() {
        return (AccountingCombination) get(PROPERTY_PAYDISCOUNTEXPACCT);
    }

    public void setPayDiscountExpAcct(AccountingCombination payDiscountExpAcct) {
        set(PROPERTY_PAYDISCOUNTEXPACCT, payDiscountExpAcct);
    }

    public AccountingCombination getPayDiscountRevAcct() {
        return (AccountingCombination) get(PROPERTY_PAYDISCOUNTREVACCT);
    }

    public void setPayDiscountRevAcct(AccountingCombination payDiscountRevAcct) {
        set(PROPERTY_PAYDISCOUNTREVACCT, payDiscountRevAcct);
    }

    public AccountingCombination getWriteOffAcct() {
        return (AccountingCombination) get(PROPERTY_WRITEOFFACCT);
    }

    public void setWriteOffAcct(AccountingCombination writeOffAcct) {
        set(PROPERTY_WRITEOFFACCT, writeOffAcct);
    }

    public AccountingCombination getUnrealizedGainAcct() {
        return (AccountingCombination) get(PROPERTY_UNREALIZEDGAINACCT);
    }

    public void setUnrealizedGainAcct(AccountingCombination unrealizedGainAcct) {
        set(PROPERTY_UNREALIZEDGAINACCT, unrealizedGainAcct);
    }

    public AccountingCombination getUnrealizedLossAcct() {
        return (AccountingCombination) get(PROPERTY_UNREALIZEDLOSSACCT);
    }

    public void setUnrealizedLossAcct(AccountingCombination unrealizedLossAcct) {
        set(PROPERTY_UNREALIZEDLOSSACCT, unrealizedLossAcct);
    }

    public AccountingCombination getRealizedGainAcct() {
        return (AccountingCombination) get(PROPERTY_REALIZEDGAINACCT);
    }

    public void setRealizedGainAcct(AccountingCombination realizedGainAcct) {
        set(PROPERTY_REALIZEDGAINACCT, realizedGainAcct);
    }

    public AccountingCombination getRealizedLossAcct() {
        return (AccountingCombination) get(PROPERTY_REALIZEDLOSSACCT);
    }

    public void setRealizedLossAcct(AccountingCombination realizedLossAcct) {
        set(PROPERTY_REALIZEDLOSSACCT, realizedLossAcct);
    }

    public AccountingCombination getNotInvoicedReceiptsAcct() {
        return (AccountingCombination) get(PROPERTY_NOTINVOICEDRECEIPTSACCT);
    }

    public void setNotInvoicedReceiptsAcct(
        AccountingCombination notInvoicedReceiptsAcct) {
        set(PROPERTY_NOTINVOICEDRECEIPTSACCT, notInvoicedReceiptsAcct);
    }

    public AccountingCombination getUnEarnedRevenueAcct() {
        return (AccountingCombination) get(PROPERTY_UNEARNEDREVENUEACCT);
    }

    public void setUnEarnedRevenueAcct(
        AccountingCombination unEarnedRevenueAcct) {
        set(PROPERTY_UNEARNEDREVENUEACCT, unEarnedRevenueAcct);
    }

    public AccountingCombination getNotInvoicedRevenueAcct() {
        return (AccountingCombination) get(PROPERTY_NOTINVOICEDREVENUEACCT);
    }

    public void setNotInvoicedRevenueAcct(
        AccountingCombination notInvoicedRevenueAcct) {
        set(PROPERTY_NOTINVOICEDREVENUEACCT, notInvoicedRevenueAcct);
    }

    public AccountingCombination getNotInvoicedReceivablesAcct() {
        return (AccountingCombination) get(PROPERTY_NOTINVOICEDRECEIVABLESACCT);
    }

    public void setNotInvoicedReceivablesAcct(
        AccountingCombination notInvoicedReceivablesAcct) {
        set(PROPERTY_NOTINVOICEDRECEIVABLESACCT, notInvoicedReceivablesAcct);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }
}
