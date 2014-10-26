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
import org.openbravo.model.ad.system.Language;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.hcm.SalaryCategory;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity c_bpartneremployee_view (stored in table c_bpartneremployee_view).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class C_bpartneremployee_view extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "c_bpartneremployee_view";
    public static final String ENTITY_NAME = "c_bpartneremployee_view";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_BPGROUP = "bpGroup";
    public static final String PROPERTY_ISEMPLOYEE = "isemployee";
    public static final String PROPERTY_ISSALESREP = "issalesrep";
    public static final String PROPERTY_REFERENCENO = "referenceno";
    public static final String PROPERTY_LANGUAGE = "language";
    public static final String PROPERTY_TAXID = "taxid";
    public static final String PROPERTY_ISTAXEXEMPT = "istaxexempt";
    public static final String PROPERTY_GREETING = "greeting";
    public static final String PROPERTY_ISWORKER = "isworker";
    public static final String PROPERTY_COUNTRY = "country";
    public static final String PROPERTY_CITY = "city";
    public static final String PROPERTY_ZIPCODE = "zipcode";
    public static final String PROPERTY_ISPROJECTMANAGER = "isprojectmanager";
    public static final String PROPERTY_ISPROCUREMENTMANAGER =
        "isprocurementmanager";
    public static final String PROPERTY_APPROVALAMT = "approvalamt";
    public static final String PROPERTY_ISAPPROVER = "isapprover";
    public static final String PROPERTY_ISPRAPPROVER = "isprapprover";
    public static final String PROPERTY_ISPAYMENTAPPROVER = "ispaymentapprover";
    public static final String PROPERTY_SALARYCATEGORY = "salaryCategory";
    public static final String PROPERTY_RATING = "rating";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_ISINRESOURCEPLAN = "isinresourceplan";

    public C_bpartneremployee_view() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISEMPLOYEE, true);
        setDefaultValue(PROPERTY_ISSALESREP, false);
        setDefaultValue(PROPERTY_ISTAXEXEMPT, false);
        setDefaultValue(PROPERTY_ISWORKER, false);
        setDefaultValue(PROPERTY_ISPROJECTMANAGER, false);
        setDefaultValue(PROPERTY_ISPROCUREMENTMANAGER, false);
        setDefaultValue(PROPERTY_APPROVALAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISAPPROVER, false);
        setDefaultValue(PROPERTY_ISPRAPPROVER, false);
        setDefaultValue(PROPERTY_ISPAYMENTAPPROVER, false);
        setDefaultValue(PROPERTY_RATING, false);
        setDefaultValue(PROPERTY_ISINRESOURCEPLAN, true);
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

    public Date getCreated() {
        return (Date) get(PROPERTY_CREATED);
    }

    public void setCreated(Date created) {
        set(PROPERTY_CREATED, created);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ISACTIVE);
    }

    public void setActive(Boolean isactive) {
        set(PROPERTY_ISACTIVE, isactive);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
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

    public Category getBpGroup() {
        return (Category) get(PROPERTY_BPGROUP);
    }

    public void setBpGroup(Category bpGroup) {
        set(PROPERTY_BPGROUP, bpGroup);
    }

    public Boolean isEmployee() {
        return (Boolean) get(PROPERTY_ISEMPLOYEE);
    }

    public void setEmployee(Boolean isemployee) {
        set(PROPERTY_ISEMPLOYEE, isemployee);
    }

    public Boolean isSalesrep() {
        return (Boolean) get(PROPERTY_ISSALESREP);
    }

    public void setSalesrep(Boolean issalesrep) {
        set(PROPERTY_ISSALESREP, issalesrep);
    }

    public String getReferenceno() {
        return (String) get(PROPERTY_REFERENCENO);
    }

    public void setReferenceno(String referenceno) {
        set(PROPERTY_REFERENCENO, referenceno);
    }

    public Language getLanguage() {
        return (Language) get(PROPERTY_LANGUAGE);
    }

    public void setLanguage(Language language) {
        set(PROPERTY_LANGUAGE, language);
    }

    public String getTaxid() {
        return (String) get(PROPERTY_TAXID);
    }

    public void setTaxid(String taxid) {
        set(PROPERTY_TAXID, taxid);
    }

    public Boolean isTaxexempt() {
        return (Boolean) get(PROPERTY_ISTAXEXEMPT);
    }

    public void setTaxexempt(Boolean istaxexempt) {
        set(PROPERTY_ISTAXEXEMPT, istaxexempt);
    }

    public Greeting getGreeting() {
        return (Greeting) get(PROPERTY_GREETING);
    }

    public void setGreeting(Greeting greeting) {
        set(PROPERTY_GREETING, greeting);
    }

    public Boolean isWorker() {
        return (Boolean) get(PROPERTY_ISWORKER);
    }

    public void setWorker(Boolean isworker) {
        set(PROPERTY_ISWORKER, isworker);
    }

    public String getCountry() {
        return (String) get(PROPERTY_COUNTRY);
    }

    public void setCountry(String country) {
        set(PROPERTY_COUNTRY, country);
    }

    public String getCity() {
        return (String) get(PROPERTY_CITY);
    }

    public void setCity(String city) {
        set(PROPERTY_CITY, city);
    }

    public String getZipcode() {
        return (String) get(PROPERTY_ZIPCODE);
    }

    public void setZipcode(String zipcode) {
        set(PROPERTY_ZIPCODE, zipcode);
    }

    public Boolean isProjectmanager() {
        return (Boolean) get(PROPERTY_ISPROJECTMANAGER);
    }

    public void setProjectmanager(Boolean isprojectmanager) {
        set(PROPERTY_ISPROJECTMANAGER, isprojectmanager);
    }

    public Boolean isProcurementmanager() {
        return (Boolean) get(PROPERTY_ISPROCUREMENTMANAGER);
    }

    public void setProcurementmanager(Boolean isprocurementmanager) {
        set(PROPERTY_ISPROCUREMENTMANAGER, isprocurementmanager);
    }

    public BigDecimal getApprovalamt() {
        return (BigDecimal) get(PROPERTY_APPROVALAMT);
    }

    public void setApprovalamt(BigDecimal approvalamt) {
        set(PROPERTY_APPROVALAMT, approvalamt);
    }

    public Boolean isApprover() {
        return (Boolean) get(PROPERTY_ISAPPROVER);
    }

    public void setApprover(Boolean isapprover) {
        set(PROPERTY_ISAPPROVER, isapprover);
    }

    public Boolean isPrapprover() {
        return (Boolean) get(PROPERTY_ISPRAPPROVER);
    }

    public void setPrapprover(Boolean isprapprover) {
        set(PROPERTY_ISPRAPPROVER, isprapprover);
    }

    public Boolean isPaymentapprover() {
        return (Boolean) get(PROPERTY_ISPAYMENTAPPROVER);
    }

    public void setPaymentapprover(Boolean ispaymentapprover) {
        set(PROPERTY_ISPAYMENTAPPROVER, ispaymentapprover);
    }

    public SalaryCategory getSalaryCategory() {
        return (SalaryCategory) get(PROPERTY_SALARYCATEGORY);
    }

    public void setSalaryCategory(SalaryCategory salaryCategory) {
        set(PROPERTY_SALARYCATEGORY, salaryCategory);
    }

    public Boolean isRating() {
        return (Boolean) get(PROPERTY_RATING);
    }

    public void setRating(Boolean rating) {
        set(PROPERTY_RATING, rating);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public Boolean isInresourceplan() {
        return (Boolean) get(PROPERTY_ISINRESOURCEPLAN);
    }

    public void setInresourceplan(Boolean isinresourceplan) {
        set(PROPERTY_ISINRESOURCEPLAN, isinresourceplan);
    }
}
