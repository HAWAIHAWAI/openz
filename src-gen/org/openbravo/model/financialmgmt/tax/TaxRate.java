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
import org.openbravo.model.common.geography.Country;
import org.openbravo.model.common.geography.Region;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity FinancialMgmtTaxRate (stored in table C_Tax).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class TaxRate extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Tax";
    public static final String ENTITY_NAME = "FinancialMgmtTaxRate";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_VALIDFROM = "validFrom";
    public static final String PROPERTY_ISSUMMARY = "isSummary";
    public static final String PROPERTY_RATE = "rate";
    public static final String PROPERTY_COUNTRY = "country";
    public static final String PROPERTY_REGION = "region";
    public static final String PROPERTY_COUNTRY15 = "country15";
    public static final String PROPERTY_REGION16 = "region16";
    public static final String PROPERTY_ISDEFAULT = "isDefault";
    public static final String PROPERTY_ISTAXEXEMPT = "isTaxExempt";
    public static final String PROPERTY_SOPOTYPE = "sOPOType";
    public static final String PROPERTY_CASCADE = "cascade";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_ISWITHHOLDINGTAX = "isWithholdingTax";
    public static final String PROPERTY_ISNOTAXABLE = "isNoTaxable";
    public static final String PROPERTY_DEDUCPERCENT = "deducpercent";
    public static final String PROPERTY_ORIGINALRATE = "originalrate";
    public static final String PROPERTY_ISTAXUNDEDUCTABLE = "isTaxUndeductable";
    public static final String PROPERTY_ISNOVAT = "isNoVAT";
    public static final String PROPERTY_REVERSECHARGE = "reversecharge";
    public static final String PROPERTY_TAXHINT = "taxhint";
    public static final String PROPERTY_ADDUID2FACT = "adduid2fact";
    public static final String PROPERTY_DATEVKEYUST = "datevkeyust";
    public static final String PROPERTY_DATEVKEYVST = "datevkeyvst";
    public static final String PROPERTY_FINANCIALMGMTTAXZONELIST =
        "financialMgmtTaxZoneList";
    public static final String PROPERTY_FINANCIALMGMTTAXTRLLIST =
        "financialMgmtTaxTrlList";
    public static final String PROPERTY_FINANCIALMGMTTAXRATEACCOUNTSLIST =
        "financialMgmtTaxRateAccountsList";

    public TaxRate() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISSUMMARY, false);
        setDefaultValue(PROPERTY_ISDEFAULT, false);
        setDefaultValue(PROPERTY_ISTAXEXEMPT, false);
        setDefaultValue(PROPERTY_SOPOTYPE, "B");
        setDefaultValue(PROPERTY_CASCADE, false);
        setDefaultValue(PROPERTY_LINE, (long) 10);
        setDefaultValue(PROPERTY_ISWITHHOLDINGTAX, false);
        setDefaultValue(PROPERTY_ISNOTAXABLE, false);
        setDefaultValue(PROPERTY_ISTAXUNDEDUCTABLE, false);
        setDefaultValue(PROPERTY_ISNOVAT, false);
        setDefaultValue(PROPERTY_REVERSECHARGE, false);
        setDefaultValue(PROPERTY_ADDUID2FACT, false);
        setDefaultValue(PROPERTY_FINANCIALMGMTTAXZONELIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTTAXTRLLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTTAXRATEACCOUNTSLIST,
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Date getValidFrom() {
        return (Date) get(PROPERTY_VALIDFROM);
    }

    public void setValidFrom(Date validFrom) {
        set(PROPERTY_VALIDFROM, validFrom);
    }

    public Boolean isSummary() {
        return (Boolean) get(PROPERTY_ISSUMMARY);
    }

    public void setSummary(Boolean isSummary) {
        set(PROPERTY_ISSUMMARY, isSummary);
    }

    public BigDecimal getRate() {
        return (BigDecimal) get(PROPERTY_RATE);
    }

    public void setRate(BigDecimal rate) {
        set(PROPERTY_RATE, rate);
    }

    public Country getCountry() {
        return (Country) get(PROPERTY_COUNTRY);
    }

    public void setCountry(Country country) {
        set(PROPERTY_COUNTRY, country);
    }

    public Region getRegion() {
        return (Region) get(PROPERTY_REGION);
    }

    public void setRegion(Region region) {
        set(PROPERTY_REGION, region);
    }

    public Country getCountry15() {
        return (Country) get(PROPERTY_COUNTRY15);
    }

    public void setCountry15(Country country15) {
        set(PROPERTY_COUNTRY15, country15);
    }

    public Region getRegion16() {
        return (Region) get(PROPERTY_REGION16);
    }

    public void setRegion16(Region region16) {
        set(PROPERTY_REGION16, region16);
    }

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_ISDEFAULT);
    }

    public void setDefault(Boolean isDefault) {
        set(PROPERTY_ISDEFAULT, isDefault);
    }

    public Boolean isTaxExempt() {
        return (Boolean) get(PROPERTY_ISTAXEXEMPT);
    }

    public void setTaxExempt(Boolean isTaxExempt) {
        set(PROPERTY_ISTAXEXEMPT, isTaxExempt);
    }

    public String getSOPOType() {
        return (String) get(PROPERTY_SOPOTYPE);
    }

    public void setSOPOType(String sOPOType) {
        set(PROPERTY_SOPOTYPE, sOPOType);
    }

    public Boolean isCascade() {
        return (Boolean) get(PROPERTY_CASCADE);
    }

    public void setCascade(Boolean cascade) {
        set(PROPERTY_CASCADE, cascade);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public Boolean isWithholdingTax() {
        return (Boolean) get(PROPERTY_ISWITHHOLDINGTAX);
    }

    public void setWithholdingTax(Boolean isWithholdingTax) {
        set(PROPERTY_ISWITHHOLDINGTAX, isWithholdingTax);
    }

    public Boolean isNoTaxable() {
        return (Boolean) get(PROPERTY_ISNOTAXABLE);
    }

    public void setNoTaxable(Boolean isNoTaxable) {
        set(PROPERTY_ISNOTAXABLE, isNoTaxable);
    }

    public BigDecimal getDeducpercent() {
        return (BigDecimal) get(PROPERTY_DEDUCPERCENT);
    }

    public void setDeducpercent(BigDecimal deducpercent) {
        set(PROPERTY_DEDUCPERCENT, deducpercent);
    }

    public BigDecimal getOriginalrate() {
        return (BigDecimal) get(PROPERTY_ORIGINALRATE);
    }

    public void setOriginalrate(BigDecimal originalrate) {
        set(PROPERTY_ORIGINALRATE, originalrate);
    }

    public Boolean isTaxUndeductable() {
        return (Boolean) get(PROPERTY_ISTAXUNDEDUCTABLE);
    }

    public void setTaxUndeductable(Boolean isTaxUndeductable) {
        set(PROPERTY_ISTAXUNDEDUCTABLE, isTaxUndeductable);
    }

    public Boolean isNoVAT() {
        return (Boolean) get(PROPERTY_ISNOVAT);
    }

    public void setNoVAT(Boolean isNoVAT) {
        set(PROPERTY_ISNOVAT, isNoVAT);
    }

    public Boolean isReversecharge() {
        return (Boolean) get(PROPERTY_REVERSECHARGE);
    }

    public void setReversecharge(Boolean reversecharge) {
        set(PROPERTY_REVERSECHARGE, reversecharge);
    }

    public String getTaxhint() {
        return (String) get(PROPERTY_TAXHINT);
    }

    public void setTaxhint(String taxhint) {
        set(PROPERTY_TAXHINT, taxhint);
    }

    public Boolean isAdduid2fact() {
        return (Boolean) get(PROPERTY_ADDUID2FACT);
    }

    public void setAdduid2fact(Boolean adduid2fact) {
        set(PROPERTY_ADDUID2FACT, adduid2fact);
    }

    public String getDatevkeyust() {
        return (String) get(PROPERTY_DATEVKEYUST);
    }

    public void setDatevkeyust(String datevkeyust) {
        set(PROPERTY_DATEVKEYUST, datevkeyust);
    }

    public String getDatevkeyvst() {
        return (String) get(PROPERTY_DATEVKEYVST);
    }

    public void setDatevkeyvst(String datevkeyvst) {
        set(PROPERTY_DATEVKEYVST, datevkeyvst);
    }

    @SuppressWarnings("unchecked")
    public List<TaxZone> getFinancialMgmtTaxZoneList() {
        return (List<TaxZone>) get(PROPERTY_FINANCIALMGMTTAXZONELIST);
    }

    public void setFinancialMgmtTaxZoneList(
        List<TaxZone> financialMgmtTaxZoneList) {
        set(PROPERTY_FINANCIALMGMTTAXZONELIST, financialMgmtTaxZoneList);
    }

    @SuppressWarnings("unchecked")
    public List<TaxTrl> getFinancialMgmtTaxTrlList() {
        return (List<TaxTrl>) get(PROPERTY_FINANCIALMGMTTAXTRLLIST);
    }

    public void setFinancialMgmtTaxTrlList(List<TaxTrl> financialMgmtTaxTrlList) {
        set(PROPERTY_FINANCIALMGMTTAXTRLLIST, financialMgmtTaxTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<TaxRateAccounts> getFinancialMgmtTaxRateAccountsList() {
        return (List<TaxRateAccounts>) get(PROPERTY_FINANCIALMGMTTAXRATEACCOUNTSLIST);
    }

    public void setFinancialMgmtTaxRateAccountsList(
        List<TaxRateAccounts> financialMgmtTaxRateAccountsList) {
        set(PROPERTY_FINANCIALMGMTTAXRATEACCOUNTSLIST,
            financialMgmtTaxRateAccountsList);
    }
}
