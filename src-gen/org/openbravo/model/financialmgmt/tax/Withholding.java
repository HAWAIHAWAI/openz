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
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity FinancialMgmtWithholding (stored in table C_Withholding).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Withholding extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Withholding";
    public static final String ENTITY_NAME = "FinancialMgmtWithholding";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PAYMENTTERM = "paymentTerm";
    public static final String PROPERTY_ISTAXWITHHOLDING = "isTaxWithholding";
    public static final String PROPERTY_ISTAXPRORATED = "isTaxProrated";
    public static final String PROPERTY_ISPAIDTO3PARTY = "isPaidTo3Party";
    public static final String PROPERTY_BENEFICIARY = "beneficiary";
    public static final String PROPERTY_ISPERCENTWITHHOLDING =
        "isPercentWithholding";
    public static final String PROPERTY_PERCENT = "percent";
    public static final String PROPERTY_FIXAMT = "fixAmt";
    public static final String PROPERTY_THRESHOLDMIN = "thresholdmin";
    public static final String PROPERTY_THRESHOLDMAX = "thresholdMax";
    public static final String PROPERTY_MINAMT = "minAmt";
    public static final String PROPERTY_MAXAMT = "maxAmt";
    public static final String PROPERTY_RATE = "rate";
    public static final String PROPERTY_FINANCIALMGMTWITHHOLDINGACCOUNTSLIST =
        "financialMgmtWithholdingAccountsList";

    public Withholding() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISTAXWITHHOLDING, false);
        setDefaultValue(PROPERTY_ISTAXPRORATED, false);
        setDefaultValue(PROPERTY_ISPAIDTO3PARTY, false);
        setDefaultValue(PROPERTY_ISPERCENTWITHHOLDING, false);
        setDefaultValue(PROPERTY_RATE, new BigDecimal(0));
        setDefaultValue(PROPERTY_FINANCIALMGMTWITHHOLDINGACCOUNTSLIST,
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public PaymentTerm getPaymentTerm() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERM);
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        set(PROPERTY_PAYMENTTERM, paymentTerm);
    }

    public Boolean isTaxWithholding() {
        return (Boolean) get(PROPERTY_ISTAXWITHHOLDING);
    }

    public void setTaxWithholding(Boolean isTaxWithholding) {
        set(PROPERTY_ISTAXWITHHOLDING, isTaxWithholding);
    }

    public Boolean isTaxProrated() {
        return (Boolean) get(PROPERTY_ISTAXPRORATED);
    }

    public void setTaxProrated(Boolean isTaxProrated) {
        set(PROPERTY_ISTAXPRORATED, isTaxProrated);
    }

    public Boolean isPaidTo3Party() {
        return (Boolean) get(PROPERTY_ISPAIDTO3PARTY);
    }

    public void setPaidTo3Party(Boolean isPaidTo3Party) {
        set(PROPERTY_ISPAIDTO3PARTY, isPaidTo3Party);
    }

    public BusinessPartner getBeneficiary() {
        return (BusinessPartner) get(PROPERTY_BENEFICIARY);
    }

    public void setBeneficiary(BusinessPartner beneficiary) {
        set(PROPERTY_BENEFICIARY, beneficiary);
    }

    public Boolean isPercentWithholding() {
        return (Boolean) get(PROPERTY_ISPERCENTWITHHOLDING);
    }

    public void setPercentWithholding(Boolean isPercentWithholding) {
        set(PROPERTY_ISPERCENTWITHHOLDING, isPercentWithholding);
    }

    public BigDecimal getPercent() {
        return (BigDecimal) get(PROPERTY_PERCENT);
    }

    public void setPercent(BigDecimal percent) {
        set(PROPERTY_PERCENT, percent);
    }

    public BigDecimal getFixAmt() {
        return (BigDecimal) get(PROPERTY_FIXAMT);
    }

    public void setFixAmt(BigDecimal fixAmt) {
        set(PROPERTY_FIXAMT, fixAmt);
    }

    public BigDecimal getThresholdmin() {
        return (BigDecimal) get(PROPERTY_THRESHOLDMIN);
    }

    public void setThresholdmin(BigDecimal thresholdmin) {
        set(PROPERTY_THRESHOLDMIN, thresholdmin);
    }

    public BigDecimal getThresholdMax() {
        return (BigDecimal) get(PROPERTY_THRESHOLDMAX);
    }

    public void setThresholdMax(BigDecimal thresholdMax) {
        set(PROPERTY_THRESHOLDMAX, thresholdMax);
    }

    public BigDecimal getMinAmt() {
        return (BigDecimal) get(PROPERTY_MINAMT);
    }

    public void setMinAmt(BigDecimal minAmt) {
        set(PROPERTY_MINAMT, minAmt);
    }

    public BigDecimal getMaxAmt() {
        return (BigDecimal) get(PROPERTY_MAXAMT);
    }

    public void setMaxAmt(BigDecimal maxAmt) {
        set(PROPERTY_MAXAMT, maxAmt);
    }

    public BigDecimal getRate() {
        return (BigDecimal) get(PROPERTY_RATE);
    }

    public void setRate(BigDecimal rate) {
        set(PROPERTY_RATE, rate);
    }

    @SuppressWarnings("unchecked")
    public List<WithholdingAccounts> getFinancialMgmtWithholdingAccountsList() {
        return (List<WithholdingAccounts>) get(PROPERTY_FINANCIALMGMTWITHHOLDINGACCOUNTSLIST);
    }

    public void setFinancialMgmtWithholdingAccountsList(
        List<WithholdingAccounts> financialMgmtWithholdingAccountsList) {
        set(PROPERTY_FINANCIALMGMTWITHHOLDINGACCOUNTSLIST,
            financialMgmtWithholdingAccountsList);
    }
}
