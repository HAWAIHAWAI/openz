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
package org.openbravo.model.financialmgmt.accounting;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.financialmgmt.accounting.coa.AccountingCombination;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity RevenueRecognitionPlan (stored in table C_RevenueRecognition_Plan).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class RevenueRecognitionPlan extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_RevenueRecognition_Plan";
    public static final String ENTITY_NAME = "RevenueRecognitionPlan";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACCTSCHEMA = "acctSchema";
    public static final String PROPERTY_REVENUERECOGNITION =
        "revenueRecognition";
    public static final String PROPERTY_INVOICELINE = "invoiceLine";
    public static final String PROPERTY_UNEARNEDREVENUEACCT =
        "unEarnedRevenueAcct";
    public static final String PROPERTY_REVENUEACCT = "revenueAcct";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_TOTALAMT = "totalAmt";
    public static final String PROPERTY_RECOGNIZEDAMT = "recognizedAmt";

    public RevenueRecognitionPlan() {
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

    public AcctSchema getAcctSchema() {
        return (AcctSchema) get(PROPERTY_ACCTSCHEMA);
    }

    public void setAcctSchema(AcctSchema acctSchema) {
        set(PROPERTY_ACCTSCHEMA, acctSchema);
    }

    public RevenueRecognition getRevenueRecognition() {
        return (RevenueRecognition) get(PROPERTY_REVENUERECOGNITION);
    }

    public void setRevenueRecognition(RevenueRecognition revenueRecognition) {
        set(PROPERTY_REVENUERECOGNITION, revenueRecognition);
    }

    public InvoiceLine getInvoiceLine() {
        return (InvoiceLine) get(PROPERTY_INVOICELINE);
    }

    public void setInvoiceLine(InvoiceLine invoiceLine) {
        set(PROPERTY_INVOICELINE, invoiceLine);
    }

    public AccountingCombination getUnEarnedRevenueAcct() {
        return (AccountingCombination) get(PROPERTY_UNEARNEDREVENUEACCT);
    }

    public void setUnEarnedRevenueAcct(
        AccountingCombination unEarnedRevenueAcct) {
        set(PROPERTY_UNEARNEDREVENUEACCT, unEarnedRevenueAcct);
    }

    public AccountingCombination getRevenueAcct() {
        return (AccountingCombination) get(PROPERTY_REVENUEACCT);
    }

    public void setRevenueAcct(AccountingCombination revenueAcct) {
        set(PROPERTY_REVENUEACCT, revenueAcct);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public BigDecimal getTotalAmt() {
        return (BigDecimal) get(PROPERTY_TOTALAMT);
    }

    public void setTotalAmt(BigDecimal totalAmt) {
        set(PROPERTY_TOTALAMT, totalAmt);
    }

    public BigDecimal getRecognizedAmt() {
        return (BigDecimal) get(PROPERTY_RECOGNIZEDAMT);
    }

    public void setRecognizedAmt(BigDecimal recognizedAmt) {
        set(PROPERTY_RECOGNIZEDAMT, recognizedAmt);
    }
}
