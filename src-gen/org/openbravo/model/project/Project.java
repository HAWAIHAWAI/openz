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
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.manufacturing.floorshop.Machine;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.pricing.pricelist.PriceListVersion;
import org.openbravo.zsoft.projects.Zspm_ptaskfeedbackline;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity Project (stored in table C_Project).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Project extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Project";
    public static final String ENTITY_NAME = "Project";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_NOTE = "note";
    public static final String PROPERTY_ISSUMMARY = "isSummary";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_BPARTNERLOCATION = "bPartnerLocation";
    public static final String PROPERTY_POREFERENCE = "pOReference";
    public static final String PROPERTY_PAYMENTTERM = "paymentTerm";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_CREATETEMPPRICELIST =
        "createtemppricelist";
    public static final String PROPERTY_PRICELISTVERSION = "priceListVersion";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_ISCOMMITMENT = "isCommitment";
    public static final String PROPERTY_PLANNEDAMT = "plannedAmt";
    public static final String PROPERTY_PLANNEDQTY = "plannedQty";
    public static final String PROPERTY_PLANNEDMARGINAMT = "plannedMarginAmt";
    public static final String PROPERTY_COMMITTEDAMT = "committedAmt";
    public static final String PROPERTY_DATECONTRACT = "dateContract";
    public static final String PROPERTY_DATEFINISH = "dateFinish";
    public static final String PROPERTY_GENERATETO = "generateTo";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_SALESREP = "salesRep";
    public static final String PROPERTY_COPYFROM = "copyFrom";
    public static final String PROPERTY_PROJECTTYPE = "projectType";
    public static final String PROPERTY_COMMITTEDQTY = "committedQty";
    public static final String PROPERTY_INVOICEDAMT = "invoicedAmt";
    public static final String PROPERTY_INVOICEDQTY = "invoicedQty";
    public static final String PROPERTY_PROJECTBALANCEAMT = "projectBalanceAmt";
    public static final String PROPERTY_PHASE = "phase";
    public static final String PROPERTY_PROJECTPHASE = "projectPhase";
    public static final String PROPERTY_ISCOMMITCEILING = "isCommitCeiling";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_PROJECTCATEGORY = "projectCategory";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PUBLICPRIVATE = "publicprivate";
    public static final String PROPERTY_PROJECTSTATUS = "projectstatus";
    public static final String PROPERTY_PROJECTKIND = "projectkind";
    public static final String PROPERTY_BILLTO = "billTo";
    public static final String PROPERTY_PROJECTPHASE48 = "projectphase48";
    public static final String PROPERTY_GENERATEORDER = "generateOrder";
    public static final String PROPERTY_CHANGEPROJECTSTATUS =
        "changeProjectStatus";
    public static final String PROPERTY_LOCATION = "location";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_PAYMENTRULE = "paymentRule";
    public static final String PROPERTY_INVOICETOPROJECT = "invoiceToProject";
    public static final String PROPERTY_PLANNEDPOAMT = "plannedPOAmt";
    public static final String PROPERTY_LASTPLANNEDPROPOSALDATE =
        "lastPlannedProposalDate";
    public static final String PROPERTY_DOCUMENTCOPIES = "documentCopies";
    public static final String PROPERTY_ACCOUNTNO = "accountNo";
    public static final String PROPERTY_EXPEXPENSES = "expexpenses";
    public static final String PROPERTY_EXPMARGIN = "expmargin";
    public static final String PROPERTY_EXPREINVOICING = "expreinvoicing";
    public static final String PROPERTY_RESPONSIBLE = "responsible";
    public static final String PROPERTY_SERVCOST = "servcost";
    public static final String PROPERTY_SERVMARGIN = "servmargin";
    public static final String PROPERTY_SERVREVENUE = "servrevenue";
    public static final String PROPERTY_SETPROJECTTYPE = "setprojecttype";
    public static final String PROPERTY_STARTDATE = "startdate";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_SCHEDULESTATUS = "schedulestatus";
    public static final String PROPERTY_ACTUALCOSTAMOUNT = "actualcostamount";
    public static final String PROPERTY_PERCENTDONEYET = "percentdoneyet";
    public static final String PROPERTY_ESTIMATEDAMT = "estimatedamt";
    public static final String PROPERTY_QTYOFPRODUCT = "qtyofproduct";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_CLOSEPROJECT = "closeproject";
    public static final String PROPERTY_MATERIALCOST = "materialcost";
    public static final String PROPERTY_INDIRECTCOST = "indirectcost";
    public static final String PROPERTY_MACHINECOST = "machinecost";
    public static final String PROPERTY_EXPENSES = "expenses";
    public static final String PROPERTY_REOPENPROJECT = "reopenproject";
    public static final String PROPERTY_PLANNEDMARGINPERCENT =
        "plannedmarginpercent";
    public static final String PROPERTY_MARGINAMT = "marginamt";
    public static final String PROPERTY_MARGINPERCENT = "marginpercent";
    public static final String PROPERTY_MATERIALCOSTPLAN = "materialcostplan";
    public static final String PROPERTY_INDIRECTCOSTPLAN = "indirectcostplan";
    public static final String PROPERTY_MACHINECOSTPLAN = "machinecostplan";
    public static final String PROPERTY_SERVCOSTPLAN = "servcostplan";
    public static final String PROPERTY_EXPENSESPLAN = "expensesplan";
    public static final String PROPERTY_EXTERNALSERVICEPLAN =
        "externalserviceplan";
    public static final String PROPERTY_EXTERNALSERVICE = "externalservice";
    public static final String PROPERTY_ISHIDDEN = "ishidden";
    public static final String PROPERTY_MACHINE = "machine";
    public static final String PROPERTY_PROJECTACCOUNTSLIST =
        "projectAccountsList";
    public static final String PROPERTY_TSRVFEEDBACKVLIST = "tsrvFeedbackVList";
    public static final String PROPERTY_PROJECTINVOICEOVERVIEWLIST =
        "projectInvoiceOverviewList";
    public static final String PROPERTY_PROJECTLINELIST = "projectLineList";
    public static final String PROPERTY_PROJECTISSUELIST = "projectIssueList";
    public static final String PROPERTY_ZSPMRECHARGEVIEWLIST =
        "zspmRechargeViewList";
    public static final String PROPERTY_PROJECTVENDORLIST = "projectVendorList";
    public static final String PROPERTY_ZSPMPTASKFEEDBACKLINELIST =
        "zspmPtaskfeedbacklineList";
    public static final String PROPERTY_PROJECTPROPOSALLIST =
        "projectProposalList";
    public static final String PROPERTY_PROJECTDETAILSVLIST =
        "projectDetailsVList";
    public static final String PROPERTY_PROJECTTASKLIST = "projectTaskList";

    public Project() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISSUMMARY, false);
        setDefaultValue(PROPERTY_CREATETEMPPRICELIST, false);
        setDefaultValue(PROPERTY_ISCOMMITMENT, false);
        setDefaultValue(PROPERTY_GENERATETO, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_COPYFROM, false);
        setDefaultValue(PROPERTY_ISCOMMITCEILING, false);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_PROJECTSTATUS, "OP");
        setDefaultValue(PROPERTY_GENERATEORDER, false);
        setDefaultValue(PROPERTY_INVOICETOPROJECT, false);
        setDefaultValue(PROPERTY_DOCUMENTCOPIES, (long) 1);
        setDefaultValue(PROPERTY_SETPROJECTTYPE, false);
        setDefaultValue(PROPERTY_SCHEDULESTATUS, "OK");
        setDefaultValue(PROPERTY_CLOSEPROJECT, false);
        setDefaultValue(PROPERTY_REOPENPROJECT, false);
        setDefaultValue(PROPERTY_PLANNEDMARGINPERCENT, (long) 0);
        setDefaultValue(PROPERTY_MARGINAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_MARGINPERCENT, (long) 0);
        setDefaultValue(PROPERTY_MATERIALCOSTPLAN, new BigDecimal(0));
        setDefaultValue(PROPERTY_INDIRECTCOSTPLAN, new BigDecimal(0));
        setDefaultValue(PROPERTY_MACHINECOSTPLAN, new BigDecimal(0));
        setDefaultValue(PROPERTY_SERVCOSTPLAN, new BigDecimal(0));
        setDefaultValue(PROPERTY_EXPENSESPLAN, new BigDecimal(0));
        setDefaultValue(PROPERTY_EXTERNALSERVICEPLAN, new BigDecimal(0));
        setDefaultValue(PROPERTY_EXTERNALSERVICE, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISHIDDEN, false);
        setDefaultValue(PROPERTY_PROJECTACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TSRVFEEDBACKVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTINVOICEOVERVIEWLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTISSUELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSPMRECHARGEVIEWLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTVENDORLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSPMPTASKFEEDBACKLINELIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTPROPOSALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTDETAILSVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTTASKLIST, new ArrayList<Object>());
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

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public Location getBPartnerLocation() {
        return (Location) get(PROPERTY_BPARTNERLOCATION);
    }

    public void setBPartnerLocation(Location bPartnerLocation) {
        set(PROPERTY_BPARTNERLOCATION, bPartnerLocation);
    }

    public String getPOReference() {
        return (String) get(PROPERTY_POREFERENCE);
    }

    public void setPOReference(String pOReference) {
        set(PROPERTY_POREFERENCE, pOReference);
    }

    public PaymentTerm getPaymentTerm() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERM);
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        set(PROPERTY_PAYMENTTERM, paymentTerm);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public Boolean isCreatetemppricelist() {
        return (Boolean) get(PROPERTY_CREATETEMPPRICELIST);
    }

    public void setCreatetemppricelist(Boolean createtemppricelist) {
        set(PROPERTY_CREATETEMPPRICELIST, createtemppricelist);
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

    public Boolean isCommitment() {
        return (Boolean) get(PROPERTY_ISCOMMITMENT);
    }

    public void setCommitment(Boolean isCommitment) {
        set(PROPERTY_ISCOMMITMENT, isCommitment);
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

    public BigDecimal getCommittedAmt() {
        return (BigDecimal) get(PROPERTY_COMMITTEDAMT);
    }

    public void setCommittedAmt(BigDecimal committedAmt) {
        set(PROPERTY_COMMITTEDAMT, committedAmt);
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

    public Boolean isGenerateTo() {
        return (Boolean) get(PROPERTY_GENERATETO);
    }

    public void setGenerateTo(Boolean generateTo) {
        set(PROPERTY_GENERATETO, generateTo);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public User getSalesRep() {
        return (User) get(PROPERTY_SALESREP);
    }

    public void setSalesRep(User salesRep) {
        set(PROPERTY_SALESREP, salesRep);
    }

    public Boolean isCopyFrom() {
        return (Boolean) get(PROPERTY_COPYFROM);
    }

    public void setCopyFrom(Boolean copyFrom) {
        set(PROPERTY_COPYFROM, copyFrom);
    }

    public ProjectType getProjectType() {
        return (ProjectType) get(PROPERTY_PROJECTTYPE);
    }

    public void setProjectType(ProjectType projectType) {
        set(PROPERTY_PROJECTTYPE, projectType);
    }

    public BigDecimal getCommittedQty() {
        return (BigDecimal) get(PROPERTY_COMMITTEDQTY);
    }

    public void setCommittedQty(BigDecimal committedQty) {
        set(PROPERTY_COMMITTEDQTY, committedQty);
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

    public StandardPhase getPhase() {
        return (StandardPhase) get(PROPERTY_PHASE);
    }

    public void setPhase(StandardPhase phase) {
        set(PROPERTY_PHASE, phase);
    }

    public ProjectPhase getProjectPhase() {
        return (ProjectPhase) get(PROPERTY_PROJECTPHASE);
    }

    public void setProjectPhase(ProjectPhase projectPhase) {
        set(PROPERTY_PROJECTPHASE, projectPhase);
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

    public String getProjectCategory() {
        return (String) get(PROPERTY_PROJECTCATEGORY);
    }

    public void setProjectCategory(String projectCategory) {
        set(PROPERTY_PROJECTCATEGORY, projectCategory);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public String getPublicprivate() {
        return (String) get(PROPERTY_PUBLICPRIVATE);
    }

    public void setPublicprivate(String publicprivate) {
        set(PROPERTY_PUBLICPRIVATE, publicprivate);
    }

    public String getProjectstatus() {
        return (String) get(PROPERTY_PROJECTSTATUS);
    }

    public void setProjectstatus(String projectstatus) {
        set(PROPERTY_PROJECTSTATUS, projectstatus);
    }

    public String getProjectkind() {
        return (String) get(PROPERTY_PROJECTKIND);
    }

    public void setProjectkind(String projectkind) {
        set(PROPERTY_PROJECTKIND, projectkind);
    }

    public Location getBillTo() {
        return (Location) get(PROPERTY_BILLTO);
    }

    public void setBillTo(Location billTo) {
        set(PROPERTY_BILLTO, billTo);
    }

    public String getProjectphase48() {
        return (String) get(PROPERTY_PROJECTPHASE48);
    }

    public void setProjectphase48(String projectphase48) {
        set(PROPERTY_PROJECTPHASE48, projectphase48);
    }

    public Boolean isGenerateOrder() {
        return (Boolean) get(PROPERTY_GENERATEORDER);
    }

    public void setGenerateOrder(Boolean generateOrder) {
        set(PROPERTY_GENERATEORDER, generateOrder);
    }

    public String getChangeProjectStatus() {
        return (String) get(PROPERTY_CHANGEPROJECTSTATUS);
    }

    public void setChangeProjectStatus(String changeProjectStatus) {
        set(PROPERTY_CHANGEPROJECTSTATUS, changeProjectStatus);
    }

    public org.openbravo.model.common.geography.Location getLocation() {
        return (org.openbravo.model.common.geography.Location) get(PROPERTY_LOCATION);
    }

    public void setLocation(
        org.openbravo.model.common.geography.Location location) {
        set(PROPERTY_LOCATION, location);
    }

    public PriceList getPriceList() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(PriceList priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public String getPaymentRule() {
        return (String) get(PROPERTY_PAYMENTRULE);
    }

    public void setPaymentRule(String paymentRule) {
        set(PROPERTY_PAYMENTRULE, paymentRule);
    }

    public Boolean isInvoiceToProject() {
        return (Boolean) get(PROPERTY_INVOICETOPROJECT);
    }

    public void setInvoiceToProject(Boolean invoiceToProject) {
        set(PROPERTY_INVOICETOPROJECT, invoiceToProject);
    }

    public BigDecimal getPlannedPOAmt() {
        return (BigDecimal) get(PROPERTY_PLANNEDPOAMT);
    }

    public void setPlannedPOAmt(BigDecimal plannedPOAmt) {
        set(PROPERTY_PLANNEDPOAMT, plannedPOAmt);
    }

    public Date getLastPlannedProposalDate() {
        return (Date) get(PROPERTY_LASTPLANNEDPROPOSALDATE);
    }

    public void setLastPlannedProposalDate(Date lastPlannedProposalDate) {
        set(PROPERTY_LASTPLANNEDPROPOSALDATE, lastPlannedProposalDate);
    }

    public Long getDocumentCopies() {
        return (Long) get(PROPERTY_DOCUMENTCOPIES);
    }

    public void setDocumentCopies(Long documentCopies) {
        set(PROPERTY_DOCUMENTCOPIES, documentCopies);
    }

    public String getAccountNo() {
        return (String) get(PROPERTY_ACCOUNTNO);
    }

    public void setAccountNo(String accountNo) {
        set(PROPERTY_ACCOUNTNO, accountNo);
    }

    public BigDecimal getExpexpenses() {
        return (BigDecimal) get(PROPERTY_EXPEXPENSES);
    }

    public void setExpexpenses(BigDecimal expexpenses) {
        set(PROPERTY_EXPEXPENSES, expexpenses);
    }

    public BigDecimal getExpmargin() {
        return (BigDecimal) get(PROPERTY_EXPMARGIN);
    }

    public void setExpmargin(BigDecimal expmargin) {
        set(PROPERTY_EXPMARGIN, expmargin);
    }

    public BigDecimal getExpreinvoicing() {
        return (BigDecimal) get(PROPERTY_EXPREINVOICING);
    }

    public void setExpreinvoicing(BigDecimal expreinvoicing) {
        set(PROPERTY_EXPREINVOICING, expreinvoicing);
    }

    public User getResponsible() {
        return (User) get(PROPERTY_RESPONSIBLE);
    }

    public void setResponsible(User responsible) {
        set(PROPERTY_RESPONSIBLE, responsible);
    }

    public BigDecimal getServcost() {
        return (BigDecimal) get(PROPERTY_SERVCOST);
    }

    public void setServcost(BigDecimal servcost) {
        set(PROPERTY_SERVCOST, servcost);
    }

    public BigDecimal getServmargin() {
        return (BigDecimal) get(PROPERTY_SERVMARGIN);
    }

    public void setServmargin(BigDecimal servmargin) {
        set(PROPERTY_SERVMARGIN, servmargin);
    }

    public BigDecimal getServrevenue() {
        return (BigDecimal) get(PROPERTY_SERVREVENUE);
    }

    public void setServrevenue(BigDecimal servrevenue) {
        set(PROPERTY_SERVREVENUE, servrevenue);
    }

    public Boolean isSetprojecttype() {
        return (Boolean) get(PROPERTY_SETPROJECTTYPE);
    }

    public void setSetprojecttype(Boolean setprojecttype) {
        set(PROPERTY_SETPROJECTTYPE, setprojecttype);
    }

    public Date getStartdate() {
        return (Date) get(PROPERTY_STARTDATE);
    }

    public void setStartdate(Date startdate) {
        set(PROPERTY_STARTDATE, startdate);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public String getSchedulestatus() {
        return (String) get(PROPERTY_SCHEDULESTATUS);
    }

    public void setSchedulestatus(String schedulestatus) {
        set(PROPERTY_SCHEDULESTATUS, schedulestatus);
    }

    public BigDecimal getActualcostamount() {
        return (BigDecimal) get(PROPERTY_ACTUALCOSTAMOUNT);
    }

    public void setActualcostamount(BigDecimal actualcostamount) {
        set(PROPERTY_ACTUALCOSTAMOUNT, actualcostamount);
    }

    public Long getPercentdoneyet() {
        return (Long) get(PROPERTY_PERCENTDONEYET);
    }

    public void setPercentdoneyet(Long percentdoneyet) {
        set(PROPERTY_PERCENTDONEYET, percentdoneyet);
    }

    public BigDecimal getEstimatedamt() {
        return (BigDecimal) get(PROPERTY_ESTIMATEDAMT);
    }

    public void setEstimatedamt(BigDecimal estimatedamt) {
        set(PROPERTY_ESTIMATEDAMT, estimatedamt);
    }

    public Long getQtyofproduct() {
        return (Long) get(PROPERTY_QTYOFPRODUCT);
    }

    public void setQtyofproduct(Long qtyofproduct) {
        set(PROPERTY_QTYOFPRODUCT, qtyofproduct);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Boolean isCloseproject() {
        return (Boolean) get(PROPERTY_CLOSEPROJECT);
    }

    public void setCloseproject(Boolean closeproject) {
        set(PROPERTY_CLOSEPROJECT, closeproject);
    }

    public BigDecimal getMaterialcost() {
        return (BigDecimal) get(PROPERTY_MATERIALCOST);
    }

    public void setMaterialcost(BigDecimal materialcost) {
        set(PROPERTY_MATERIALCOST, materialcost);
    }

    public BigDecimal getIndirectcost() {
        return (BigDecimal) get(PROPERTY_INDIRECTCOST);
    }

    public void setIndirectcost(BigDecimal indirectcost) {
        set(PROPERTY_INDIRECTCOST, indirectcost);
    }

    public BigDecimal getMachinecost() {
        return (BigDecimal) get(PROPERTY_MACHINECOST);
    }

    public void setMachinecost(BigDecimal machinecost) {
        set(PROPERTY_MACHINECOST, machinecost);
    }

    public BigDecimal getExpenses() {
        return (BigDecimal) get(PROPERTY_EXPENSES);
    }

    public void setExpenses(BigDecimal expenses) {
        set(PROPERTY_EXPENSES, expenses);
    }

    public Boolean isReopenproject() {
        return (Boolean) get(PROPERTY_REOPENPROJECT);
    }

    public void setReopenproject(Boolean reopenproject) {
        set(PROPERTY_REOPENPROJECT, reopenproject);
    }

    public Long getPlannedmarginpercent() {
        return (Long) get(PROPERTY_PLANNEDMARGINPERCENT);
    }

    public void setPlannedmarginpercent(Long plannedmarginpercent) {
        set(PROPERTY_PLANNEDMARGINPERCENT, plannedmarginpercent);
    }

    public BigDecimal getMarginamt() {
        return (BigDecimal) get(PROPERTY_MARGINAMT);
    }

    public void setMarginamt(BigDecimal marginamt) {
        set(PROPERTY_MARGINAMT, marginamt);
    }

    public Long getMarginpercent() {
        return (Long) get(PROPERTY_MARGINPERCENT);
    }

    public void setMarginpercent(Long marginpercent) {
        set(PROPERTY_MARGINPERCENT, marginpercent);
    }

    public BigDecimal getMaterialcostplan() {
        return (BigDecimal) get(PROPERTY_MATERIALCOSTPLAN);
    }

    public void setMaterialcostplan(BigDecimal materialcostplan) {
        set(PROPERTY_MATERIALCOSTPLAN, materialcostplan);
    }

    public BigDecimal getIndirectcostplan() {
        return (BigDecimal) get(PROPERTY_INDIRECTCOSTPLAN);
    }

    public void setIndirectcostplan(BigDecimal indirectcostplan) {
        set(PROPERTY_INDIRECTCOSTPLAN, indirectcostplan);
    }

    public BigDecimal getMachinecostplan() {
        return (BigDecimal) get(PROPERTY_MACHINECOSTPLAN);
    }

    public void setMachinecostplan(BigDecimal machinecostplan) {
        set(PROPERTY_MACHINECOSTPLAN, machinecostplan);
    }

    public BigDecimal getServcostplan() {
        return (BigDecimal) get(PROPERTY_SERVCOSTPLAN);
    }

    public void setServcostplan(BigDecimal servcostplan) {
        set(PROPERTY_SERVCOSTPLAN, servcostplan);
    }

    public BigDecimal getExpensesplan() {
        return (BigDecimal) get(PROPERTY_EXPENSESPLAN);
    }

    public void setExpensesplan(BigDecimal expensesplan) {
        set(PROPERTY_EXPENSESPLAN, expensesplan);
    }

    public BigDecimal getExternalserviceplan() {
        return (BigDecimal) get(PROPERTY_EXTERNALSERVICEPLAN);
    }

    public void setExternalserviceplan(BigDecimal externalserviceplan) {
        set(PROPERTY_EXTERNALSERVICEPLAN, externalserviceplan);
    }

    public BigDecimal getExternalservice() {
        return (BigDecimal) get(PROPERTY_EXTERNALSERVICE);
    }

    public void setExternalservice(BigDecimal externalservice) {
        set(PROPERTY_EXTERNALSERVICE, externalservice);
    }

    public Boolean isHidden() {
        return (Boolean) get(PROPERTY_ISHIDDEN);
    }

    public void setHidden(Boolean ishidden) {
        set(PROPERTY_ISHIDDEN, ishidden);
    }

    public Machine getMachine() {
        return (Machine) get(PROPERTY_MACHINE);
    }

    public void setMachine(Machine machine) {
        set(PROPERTY_MACHINE, machine);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectAccounts> getProjectAccountsList() {
        return (List<ProjectAccounts>) get(PROPERTY_PROJECTACCOUNTSLIST);
    }

    public void setProjectAccountsList(
        List<ProjectAccounts> projectAccountsList) {
        set(PROPERTY_PROJECTACCOUNTSLIST, projectAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openz.timeservice.tsrv_feedback_v> getTsrvFeedbackVList() {
        return (List<org.openz.timeservice.tsrv_feedback_v>) get(PROPERTY_TSRVFEEDBACKVLIST);
    }

    public void setTsrvFeedbackVList(
        List<org.openz.timeservice.tsrv_feedback_v> tsrvFeedbackVList) {
        set(PROPERTY_TSRVFEEDBACKVLIST, tsrvFeedbackVList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.project.c_project_invoice_overview> getProjectInvoiceOverviewList() {
        return (List<org.openbravo.model.project.c_project_invoice_overview>) get(PROPERTY_PROJECTINVOICEOVERVIEWLIST);
    }

    public void setProjectInvoiceOverviewList(
        List<org.openbravo.model.project.c_project_invoice_overview> projectInvoiceOverviewList) {
        set(PROPERTY_PROJECTINVOICEOVERVIEWLIST, projectInvoiceOverviewList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectLine> getProjectLineList() {
        return (List<ProjectLine>) get(PROPERTY_PROJECTLINELIST);
    }

    public void setProjectLineList(List<ProjectLine> projectLineList) {
        set(PROPERTY_PROJECTLINELIST, projectLineList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectIssue> getProjectIssueList() {
        return (List<ProjectIssue>) get(PROPERTY_PROJECTISSUELIST);
    }

    public void setProjectIssueList(List<ProjectIssue> projectIssueList) {
        set(PROPERTY_PROJECTISSUELIST, projectIssueList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.zsoft.projects.zspm_recharge_view> getZspmRechargeViewList() {
        return (List<org.openbravo.zsoft.projects.zspm_recharge_view>) get(PROPERTY_ZSPMRECHARGEVIEWLIST);
    }

    public void setZspmRechargeViewList(
        List<org.openbravo.zsoft.projects.zspm_recharge_view> zspmRechargeViewList) {
        set(PROPERTY_ZSPMRECHARGEVIEWLIST, zspmRechargeViewList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectVendor> getProjectVendorList() {
        return (List<ProjectVendor>) get(PROPERTY_PROJECTVENDORLIST);
    }

    public void setProjectVendorList(List<ProjectVendor> projectVendorList) {
        set(PROPERTY_PROJECTVENDORLIST, projectVendorList);
    }

    @SuppressWarnings("unchecked")
    public List<Zspm_ptaskfeedbackline> getZspmPtaskfeedbacklineList() {
        return (List<Zspm_ptaskfeedbackline>) get(PROPERTY_ZSPMPTASKFEEDBACKLINELIST);
    }

    public void setZspmPtaskfeedbacklineList(
        List<Zspm_ptaskfeedbackline> zspmPtaskfeedbacklineList) {
        set(PROPERTY_ZSPMPTASKFEEDBACKLINELIST, zspmPtaskfeedbacklineList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectProposal> getProjectProposalList() {
        return (List<ProjectProposal>) get(PROPERTY_PROJECTPROPOSALLIST);
    }

    public void setProjectProposalList(
        List<ProjectProposal> projectProposalList) {
        set(PROPERTY_PROJECTPROPOSALLIST, projectProposalList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectDetailsV> getProjectDetailsVList() {
        return (List<ProjectDetailsV>) get(PROPERTY_PROJECTDETAILSVLIST);
    }

    public void setProjectDetailsVList(
        List<ProjectDetailsV> projectDetailsVList) {
        set(PROPERTY_PROJECTDETAILSVLIST, projectDetailsVList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectTask> getProjectTaskList() {
        return (List<ProjectTask>) get(PROPERTY_PROJECTTASKLIST);
    }

    public void setProjectTaskList(List<ProjectTask> projectTaskList) {
        set(PROPERTY_PROJECTTASKLIST, projectTaskList);
    }
}
