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
import org.openbravo.model.financialmgmt.tax.TaxRate;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity BusinessPartnerWithholding (stored in table C_BP_Withholding).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Withholding extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_BP_Withholding";
    public static final String ENTITY_NAME = "BusinessPartnerWithholding";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_WITHHOLDING = "withholding";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ISMANDATORYWITHHOLDING =
        "isMandatoryWithholding";
    public static final String PROPERTY_ISTEMPORARYEXEMPT = "isTemporaryExempt";
    public static final String PROPERTY_EXEMPTREASON = "exemptReason";
    public static final String PROPERTY_PERCENTWH = "percentWh";
    public static final String PROPERTY_PERCENT = "percent";
    public static final String PROPERTY_INCLUDETAX = "includeTax";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_ISDEFAULT = "isdefault";

    public Withholding() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISMANDATORYWITHHOLDING, false);
        setDefaultValue(PROPERTY_ISTEMPORARYEXEMPT, false);
        setDefaultValue(PROPERTY_PERCENTWH, false);
        setDefaultValue(PROPERTY_INCLUDETAX, false);
        setDefaultValue(PROPERTY_ISDEFAULT, false);
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

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public org.openbravo.model.financialmgmt.tax.Withholding getWithholding() {
        return (org.openbravo.model.financialmgmt.tax.Withholding) get(PROPERTY_WITHHOLDING);
    }

    public void setWithholding(
        org.openbravo.model.financialmgmt.tax.Withholding withholding) {
        set(PROPERTY_WITHHOLDING, withholding);
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

    public Boolean isMandatoryWithholding() {
        return (Boolean) get(PROPERTY_ISMANDATORYWITHHOLDING);
    }

    public void setMandatoryWithholding(Boolean isMandatoryWithholding) {
        set(PROPERTY_ISMANDATORYWITHHOLDING, isMandatoryWithholding);
    }

    public Boolean isTemporaryExempt() {
        return (Boolean) get(PROPERTY_ISTEMPORARYEXEMPT);
    }

    public void setTemporaryExempt(Boolean isTemporaryExempt) {
        set(PROPERTY_ISTEMPORARYEXEMPT, isTemporaryExempt);
    }

    public String getExemptReason() {
        return (String) get(PROPERTY_EXEMPTREASON);
    }

    public void setExemptReason(String exemptReason) {
        set(PROPERTY_EXEMPTREASON, exemptReason);
    }

    public Boolean isPercentWh() {
        return (Boolean) get(PROPERTY_PERCENTWH);
    }

    public void setPercentWh(Boolean percentWh) {
        set(PROPERTY_PERCENTWH, percentWh);
    }

    public BigDecimal getPercent() {
        return (BigDecimal) get(PROPERTY_PERCENT);
    }

    public void setPercent(BigDecimal percent) {
        set(PROPERTY_PERCENT, percent);
    }

    public Boolean isIncludeTax() {
        return (Boolean) get(PROPERTY_INCLUDETAX);
    }

    public void setIncludeTax(Boolean includeTax) {
        set(PROPERTY_INCLUDETAX, includeTax);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_ISDEFAULT);
    }

    public void setDefault(Boolean isdefault) {
        set(PROPERTY_ISDEFAULT, isdefault);
    }
}
