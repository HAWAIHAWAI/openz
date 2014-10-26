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
package org.openbravo.model.project;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.system.Language;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.geography.Location;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.pricing.pricelist.PriceListVersion;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity ProjectHeaderV (stored in table C_Project_Header_V).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ProjectHeaderV extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Project_Header_V";
    public static final String ENTITY_NAME = "ProjectHeaderV";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_LANGUAGE = "language";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_PROJECTNAME = "projectName";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_NOTE = "note";
    public static final String PROPERTY_ISSUMMARY = "isSummary";
    public static final String PROPERTY_PROJECTCATEGORY = "projectCategory";
    public static final String PROPERTY_ORGLOCATION = "orgLocation";
    public static final String PROPERTY_TAXID = "taxID";
    public static final String PROPERTY_PROJECTTYPE = "projectType";
    public static final String PROPERTY_PROJECTTYPENAME = "projectTypeName";
    public static final String PROPERTY_PHASE = "phase";
    public static final String PROPERTY_PROJECTPHASENAME = "projectPhaseName";
    public static final String PROPERTY_SALESREP = "salesRep";
    public static final String PROPERTY_SALESREPNAME = "salesRepName";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_BPVALUE = "bPValue";
    public static final String PROPERTY_BPGREETING = "bPGreeting";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_NAME2 = "name2";
    public static final String PROPERTY_BPCONTACTGREETING = "bPContactGreeting";
    public static final String PROPERTY_TITLE = "title";
    public static final String PROPERTY_CONTACTNAME = "contactName";
    public static final String PROPERTY_LOCATION = "location";
    public static final String PROPERTY_REFERENCENO = "referenceNo";
    public static final String PROPERTY_PAYMENTTERM = "paymentTerm";
    public static final String PROPERTY_PAYMENTTERMNOTE = "paymentTermNote";
    public static final String PROPERTY_POREFERENCE = "pOReference";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_PRICELISTVERSION = "priceListVersion";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_PLANNEDAMT = "plannedAmt";
    public static final String PROPERTY_PLANNEDQTY = "plannedQty";
    public static final String PROPERTY_PLANNEDMARGINAMT = "plannedMarginAmt";
    public static final String PROPERTY_INVOICEDAMT = "invoicedAmt";
    public static final String PROPERTY_INVOICEDQTY = "invoicedQty";
    public static final String PROPERTY_PROJECTBALANCEAMT = "projectBalanceAmt";
    public static final String PROPERTY_ISCOMMITMENT = "isCommitment";
    public static final String PROPERTY_COMMITTEDAMT = "committedAmt";
    public static final String PROPERTY_COMMITTEDQTY = "committedQty";
    public static final String PROPERTY_DATECONTRACT = "dateContract";
    public static final String PROPERTY_DATEFINISH = "dateFinish";
    public static final String PROPERTY_ISCOMMITCEILING = "isCommitCeiling";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_PROJECT = "project";

    public ProjectHeaderV() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISSUMMARY, false);
        setDefaultValue(PROPERTY_ISCOMMITMENT, false);
        setDefaultValue(PROPERTY_ISCOMMITCEILING, false);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
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

    public Language getLanguage() {
        return (Language) get(PROPERTY_LANGUAGE);
    }

    public void setLanguage(Language language) {
        set(PROPERTY_LANGUAGE, language);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
    }

    public String getProjectName() {
        return (String) get(PROPERTY_PROJECTNAME);
    }

    public void setProjectName(String projectName) {
        set(PROPERTY_PROJECTNAME, projectName);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getNote() {
        return (String) get(PROPERTY_NOTE);
    }

    public void setNote(String note) {
        set(PROPERTY_NOTE, note);
    }

    public Boolean isSummary() {
        return (Boolean) get(PROPERTY_ISSUMMARY);
    }

    public void setSummary(Boolean isSummary) {
        set(PROPERTY_ISSUMMARY, isSummary);
    }

    public String getProjectCategory() {
        return (String) get(PROPERTY_PROJECTCATEGORY);
    }

    public void setProjectCategory(String projectCategory) {
        set(PROPERTY_PROJECTCATEGORY, projectCategory);
    }

    public Location getOrgLocation() {
        return (Location) get(PROPERTY_ORGLOCATION);
    }

    public void setOrgLocation(Location orgLocation) {
        set(PROPERTY_ORGLOCATION, orgLocation);
    }

    public String getTaxID() {
        return (String) get(PROPERTY_TAXID);
    }

    public void setTaxID(String taxID) {
        set(PROPERTY_TAXID, taxID);
    }

    public ProjectType getProjectType() {
        return (ProjectType) get(PROPERTY_PROJECTTYPE);
    }

    public void setProjectType(ProjectType projectType) {
        set(PROPERTY_PROJECTTYPE, projectType);
    }

    public String getProjectTypeName() {
        return (String) get(PROPERTY_PROJECTTYPENAME);
    }

    public void setProjectTypeName(String projectTypeName) {
        set(PROPERTY_PROJECTTYPENAME, projectTypeName);
    }

    public StandardPhase getPhase() {
        return (StandardPhase) get(PROPERTY_PHASE);
    }

    public void setPhase(StandardPhase phase) {
        set(PROPERTY_PHASE, phase);
    }

    public String getProjectPhaseName() {
        return (String) get(PROPERTY_PROJECTPHASENAME);
    }

    public void setProjectPhaseName(String projectPhaseName) {
        set(PROPERTY_PROJECTPHASENAME, projectPhaseName);
    }

    public User getSalesRep() {
        return (User) get(PROPERTY_SALESREP);
    }

    public void setSalesRep(User salesRep) {
        set(PROPERTY_SALESREP, salesRep);
    }

    public String getSalesRepName() {
        return (String) get(PROPERTY_SALESREPNAME);
    }

    public void setSalesRepName(String salesRepName) {
        set(PROPERTY_SALESREPNAME, salesRepName);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public String getBPValue() {
        return (String) get(PROPERTY_BPVALUE);
    }

    public void setBPValue(String bPValue) {
        set(PROPERTY_BPVALUE, bPValue);
    }

    public String getBPGreeting() {
        return (String) get(PROPERTY_BPGREETING);
    }

    public void setBPGreeting(String bPGreeting) {
        set(PROPERTY_BPGREETING, bPGreeting);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getName2() {
        return (String) get(PROPERTY_NAME2);
    }

    public void setName2(String name2) {
        set(PROPERTY_NAME2, name2);
    }

    public String getBPContactGreeting() {
        return (String) get(PROPERTY_BPCONTACTGREETING);
    }

    public void setBPContactGreeting(String bPContactGreeting) {
        set(PROPERTY_BPCONTACTGREETING, bPContactGreeting);
    }

    public String getTitle() {
        return (String) get(PROPERTY_TITLE);
    }

    public void setTitle(String title) {
        set(PROPERTY_TITLE, title);
    }

    public String getContactName() {
        return (String) get(PROPERTY_CONTACTNAME);
    }

    public void setContactName(String contactName) {
        set(PROPERTY_CONTACTNAME, contactName);
    }

    public Location getLocation() {
        return (Location) get(PROPERTY_LOCATION);
    }

    public void setLocation(Location location) {
        set(PROPERTY_LOCATION, location);
    }

    public String getReferenceNo() {
        return (String) get(PROPERTY_REFERENCENO);
    }

    public void setReferenceNo(String referenceNo) {
        set(PROPERTY_REFERENCENO, referenceNo);
    }

    public String getPaymentTerm() {
        return (String) get(PROPERTY_PAYMENTTERM);
    }

    public void setPaymentTerm(String paymentTerm) {
        set(PROPERTY_PAYMENTTERM, paymentTerm);
    }

    public String getPaymentTermNote() {
        return (String) get(PROPERTY_PAYMENTTERMNOTE);
    }

    public void setPaymentTermNote(String paymentTermNote) {
        set(PROPERTY_PAYMENTTERMNOTE, paymentTermNote);
    }

    public String getPOReference() {
        return (String) get(PROPERTY_POREFERENCE);
    }

    public void setPOReference(String pOReference) {
        set(PROPERTY_POREFERENCE, pOReference);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public PriceListVersion getPriceListVersion() {
        return (PriceListVersion) get(PROPERTY_PRICELISTVERSION);
    }

    public void setPriceListVersion(PriceListVersion priceListVersion) {
        set(PROPERTY_PRICELISTVERSION, priceListVersion);
    }

    public Campaign getCampaign() {
        return (Campaign) get(PROPERTY_CAMPAIGN);
    }

    public void setCampaign(Campaign campaign) {
        set(PROPERTY_CAMPAIGN, campaign);
    }

    public BigDecimal getPlannedAmt() {
        return (BigDecimal) get(PROPERTY_PLANNEDAMT);
    }

    public void setPlannedAmt(BigDecimal plannedAmt) {
        set(PROPERTY_PLANNEDAMT, plannedAmt);
    }

    public BigDecimal getPlannedQty() {
        return (BigDecimal) get(PROPERTY_PLANNEDQTY);
    }

    public void setPlannedQty(BigDecimal plannedQty) {
        set(PROPERTY_PLANNEDQTY, plannedQty);
    }

    public BigDecimal getPlannedMarginAmt() {
        return (BigDecimal) get(PROPERTY_PLANNEDMARGINAMT);
    }

    public void setPlannedMarginAmt(BigDecimal plannedMarginAmt) {
        set(PROPERTY_PLANNEDMARGINAMT, plannedMarginAmt);
    }

    public BigDecimal getInvoicedAmt() {
        return (BigDecimal) get(PROPERTY_INVOICEDAMT);
    }

    public void setInvoicedAmt(BigDecimal invoicedAmt) {
        set(PROPERTY_INVOICEDAMT, invoicedAmt);
    }

    public BigDecimal getInvoicedQty() {
        return (BigDecimal) get(PROPERTY_INVOICEDQTY);
    }

    public void setInvoicedQty(BigDecimal invoicedQty) {
        set(PROPERTY_INVOICEDQTY, invoicedQty);
    }

    public BigDecimal getProjectBalanceAmt() {
        return (BigDecimal) get(PROPERTY_PROJECTBALANCEAMT);
    }

    public void setProjectBalanceAmt(BigDecimal projectBalanceAmt) {
        set(PROPERTY_PROJECTBALANCEAMT, projectBalanceAmt);
    }

    public Boolean isCommitment() {
        return (Boolean) get(PROPERTY_ISCOMMITMENT);
    }

    public void setCommitment(Boolean isCommitment) {
        set(PROPERTY_ISCOMMITMENT, isCommitment);
    }

    public BigDecimal getCommittedAmt() {
        return (BigDecimal) get(PROPERTY_COMMITTEDAMT);
    }

    public void setCommittedAmt(BigDecimal committedAmt) {
        set(PROPERTY_COMMITTEDAMT, committedAmt);
    }

    public BigDecimal getCommittedQty() {
        return (BigDecimal) get(PROPERTY_COMMITTEDQTY);
    }

    public void setCommittedQty(BigDecimal committedQty) {
        set(PROPERTY_COMMITTEDQTY, committedQty);
    }

    public Date getDateContract() {
        return (Date) get(PROPERTY_DATECONTRACT);
    }

    public void setDateContract(Date dateContract) {
        set(PROPERTY_DATECONTRACT, dateContract);
    }

    public Date getDateFinish() {
        return (Date) get(PROPERTY_DATEFINISH);
    }

    public void setDateFinish(Date dateFinish) {
        set(PROPERTY_DATEFINISH, dateFinish);
    }

    public Boolean isCommitCeiling() {
        return (Boolean) get(PROPERTY_ISCOMMITCEILING);
    }

    public void setCommitCeiling(Boolean isCommitCeiling) {
        set(PROPERTY_ISCOMMITCEILING, isCommitCeiling);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }
}
