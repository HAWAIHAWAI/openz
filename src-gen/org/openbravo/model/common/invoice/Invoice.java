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
package org.openbravo.model.common.invoice;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.gl.GLCharge;
import org.openbravo.model.financialmgmt.payment.DebtPayment;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.financialmgmt.tax.Withholding;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.project.ProjectTask;
import org.openbravo.zsoft.smartui.Zssi_invoice_textmodule;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity Invoice (stored in table C_Invoice).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Invoice extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Invoice";
    public static final String ENTITY_NAME = "Invoice";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ISSOTRX = "isSOTrx";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DOCSTATUS = "docStatus";
    public static final String PROPERTY_DOCACTION = "docAction";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_DOCTYPE = "docType";
    public static final String PROPERTY_DOCTYPETARGET = "docTypeTarget";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ISPRINTED = "isPrinted";
    public static final String PROPERTY_SALESREP = "salesRep";
    public static final String PROPERTY_DATEINVOICED = "dateInvoiced";
    public static final String PROPERTY_DATEPRINTED = "datePrinted";
    public static final String PROPERTY_DATEACCT = "dateAcct";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_BPARTNERLOCATION = "bPartnerLocation";
    public static final String PROPERTY_POREFERENCE = "pOReference";
    public static final String PROPERTY_ISDISCOUNTPRINTED = "isDiscountPrinted";
    public static final String PROPERTY_DATEORDERED = "dateOrdered";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_PAYMENTRULE = "paymentRule";
    public static final String PROPERTY_PAYMENTTERM = "paymentTerm";
    public static final String PROPERTY_CHARGE = "charge";
    public static final String PROPERTY_CHARGEAMT = "chargeAmt";
    public static final String PROPERTY_TOTALLINES = "totalLines";
    public static final String PROPERTY_GRANDTOTAL = "grandTotal";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_ISTAXINCLUDED = "isTaxIncluded";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_CREATEFROM = "createFrom";
    public static final String PROPERTY_GENERATETO = "generateTo";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_COPYFROM = "copyFrom";
    public static final String PROPERTY_ISSELFSERVICE = "isSelfService";
    public static final String PROPERTY_ORGTRX = "orgTrx";
    public static final String PROPERTY_USER1 = "user1";
    public static final String PROPERTY_USER2 = "user2";
    public static final String PROPERTY_WITHHOLDINGAMOUNT = "withholdingamount";
    public static final String PROPERTY_TAXDATE = "taxdate";
    public static final String PROPERTY_WITHHOLDING = "withholding";
    public static final String PROPERTY_ISPAID = "isPaid";
    public static final String PROPERTY_TOTALPAID = "totalPaid";
    public static final String PROPERTY_OUTSTANDINGAMT = "outstandingAmt";
    public static final String PROPERTY_DAYSTILLDUE = "daysTillDue";
    public static final String PROPERTY_DUEAMT = "dueAmt";
    public static final String PROPERTY_LASTCALCULATEDONDATE =
        "lastCalculatedOnDate";
    public static final String PROPERTY_UPDATEPAYMENTMONITOR =
        "updatePaymentMonitor";
    public static final String PROPERTY_ISGROSSINVOICE = "isGrossInvoice";
    public static final String PROPERTY_WRITEOFFAMT = "writeoffamt";
    public static final String PROPERTY_DISCOUNTAMT = "discountamt";
    public static final String PROPERTY_PROJECTPHASE = "projectphase";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_DELIVERYRULE = "deliveryrule";
    public static final String PROPERTY_BTNREINVOICEPROJECTEXPENSES =
        "btnreinvoiceprojectexpenses";
    public static final String PROPERTY_PERFORMANCEPERIODSTART =
        "performancePeriodStart";
    public static final String PROPERTY_PERFORMANCEPERIODEND =
        "performancePeriodEnd";
    public static final String PROPERTY_ISPAYMENTSHEDULESUMMARY =
        "isPaymentshedulesummary";
    public static final String PROPERTY_TRANSACTIONDATE = "transactionDate";
    public static final String PROPERTY_INTERNALNOTE = "internalnote";
    public static final String PROPERTY_SCHEDTRANSACTIONDATE =
        "schedTransactionDate";
    public static final String PROPERTY_TRANSACTIONREFERENCE =
        "transactionreference";
    public static final String PROPERTY_INVOICELINELIST = "invoiceLineList";
    public static final String PROPERTY_REVERSEDINVOICESLIST =
        "reversedInvoicesList";
    public static final String PROPERTY_INVOICETAXLIST = "invoiceTaxList";
    public static final String PROPERTY_ZSSIINVOICETEXTMODULELIST =
        "zssiInvoiceTextmoduleList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST =
        "financialMgmtDebtPaymentList";

    public Invoice() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_DOCSTATUS, "DR");
        setDefaultValue(PROPERTY_DOCACTION, "CO");
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_ISPRINTED, false);
        setDefaultValue(PROPERTY_ISDISCOUNTPRINTED, false);
        setDefaultValue(PROPERTY_PAYMENTRULE, "P");
        setDefaultValue(PROPERTY_ISTAXINCLUDED, false);
        setDefaultValue(PROPERTY_CREATEFROM, false);
        setDefaultValue(PROPERTY_GENERATETO, false);
        setDefaultValue(PROPERTY_COPYFROM, false);
        setDefaultValue(PROPERTY_ISSELFSERVICE, false);
        setDefaultValue(PROPERTY_ISPAID, false);
        setDefaultValue(PROPERTY_TOTALPAID, new BigDecimal(0));
        setDefaultValue(PROPERTY_OUTSTANDINGAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_DAYSTILLDUE, (long) 0);
        setDefaultValue(PROPERTY_DUEAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_UPDATEPAYMENTMONITOR, false);
        setDefaultValue(PROPERTY_ISGROSSINVOICE, false);
        setDefaultValue(PROPERTY_WRITEOFFAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_DISCOUNTAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_DELIVERYRULE, "A");
        setDefaultValue(PROPERTY_BTNREINVOICEPROJECTEXPENSES, false);
        setDefaultValue(PROPERTY_ISPAYMENTSHEDULESUMMARY, false);
        setDefaultValue(PROPERTY_INVOICELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_REVERSEDINVOICESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICETAXLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSSIINVOICETEXTMODULELIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST,
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

    public Boolean isSOTrx() {
        return (Boolean) get(PROPERTY_ISSOTRX);
    }

    public void setSOTrx(Boolean isSOTrx) {
        set(PROPERTY_ISSOTRX, isSOTrx);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getDocStatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocStatus(String docStatus) {
        set(PROPERTY_DOCSTATUS, docStatus);
    }

    public String getDocAction() {
        return (String) get(PROPERTY_DOCACTION);
    }

    public void setDocAction(String docAction) {
        set(PROPERTY_DOCACTION, docAction);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public DocumentType getDocType() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDocType(DocumentType docType) {
        set(PROPERTY_DOCTYPE, docType);
    }

    public DocumentType getDocTypeTarget() {
        return (DocumentType) get(PROPERTY_DOCTYPETARGET);
    }

    public void setDocTypeTarget(DocumentType docTypeTarget) {
        set(PROPERTY_DOCTYPETARGET, docTypeTarget);
    }

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isPrinted() {
        return (Boolean) get(PROPERTY_ISPRINTED);
    }

    public void setPrinted(Boolean isPrinted) {
        set(PROPERTY_ISPRINTED, isPrinted);
    }

    public User getSalesRep() {
        return (User) get(PROPERTY_SALESREP);
    }

    public void setSalesRep(User salesRep) {
        set(PROPERTY_SALESREP, salesRep);
    }

    public Date getDateInvoiced() {
        return (Date) get(PROPERTY_DATEINVOICED);
    }

    public void setDateInvoiced(Date dateInvoiced) {
        set(PROPERTY_DATEINVOICED, dateInvoiced);
    }

    public Date getDatePrinted() {
        return (Date) get(PROPERTY_DATEPRINTED);
    }

    public void setDatePrinted(Date datePrinted) {
        set(PROPERTY_DATEPRINTED, datePrinted);
    }

    public Date getDateAcct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateAcct(Date dateAcct) {
        set(PROPERTY_DATEACCT, dateAcct);
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

    public Boolean isDiscountPrinted() {
        return (Boolean) get(PROPERTY_ISDISCOUNTPRINTED);
    }

    public void setDiscountPrinted(Boolean isDiscountPrinted) {
        set(PROPERTY_ISDISCOUNTPRINTED, isDiscountPrinted);
    }

    public Date getDateOrdered() {
        return (Date) get(PROPERTY_DATEORDERED);
    }

    public void setDateOrdered(Date dateOrdered) {
        set(PROPERTY_DATEORDERED, dateOrdered);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public String getPaymentRule() {
        return (String) get(PROPERTY_PAYMENTRULE);
    }

    public void setPaymentRule(String paymentRule) {
        set(PROPERTY_PAYMENTRULE, paymentRule);
    }

    public PaymentTerm getPaymentTerm() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERM);
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        set(PROPERTY_PAYMENTTERM, paymentTerm);
    }

    public GLCharge getCharge() {
        return (GLCharge) get(PROPERTY_CHARGE);
    }

    public void setCharge(GLCharge charge) {
        set(PROPERTY_CHARGE, charge);
    }

    public BigDecimal getChargeAmt() {
        return (BigDecimal) get(PROPERTY_CHARGEAMT);
    }

    public void setChargeAmt(BigDecimal chargeAmt) {
        set(PROPERTY_CHARGEAMT, chargeAmt);
    }

    public BigDecimal getTotalLines() {
        return (BigDecimal) get(PROPERTY_TOTALLINES);
    }

    public void setTotalLines(BigDecimal totalLines) {
        set(PROPERTY_TOTALLINES, totalLines);
    }

    public BigDecimal getGrandTotal() {
        return (BigDecimal) get(PROPERTY_GRANDTOTAL);
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        set(PROPERTY_GRANDTOTAL, grandTotal);
    }

    public PriceList getPriceList() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(PriceList priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public Boolean isTaxIncluded() {
        return (Boolean) get(PROPERTY_ISTAXINCLUDED);
    }

    public void setTaxIncluded(Boolean isTaxIncluded) {
        set(PROPERTY_ISTAXINCLUDED, isTaxIncluded);
    }

    public Campaign getCampaign() {
        return (Campaign) get(PROPERTY_CAMPAIGN);
    }

    public void setCampaign(Campaign campaign) {
        set(PROPERTY_CAMPAIGN, campaign);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public ABCActivity getActivity() {
        return (ABCActivity) get(PROPERTY_ACTIVITY);
    }

    public void setActivity(ABCActivity activity) {
        set(PROPERTY_ACTIVITY, activity);
    }

    public Boolean isCreateFrom() {
        return (Boolean) get(PROPERTY_CREATEFROM);
    }

    public void setCreateFrom(Boolean createFrom) {
        set(PROPERTY_CREATEFROM, createFrom);
    }

    public Boolean isGenerateTo() {
        return (Boolean) get(PROPERTY_GENERATETO);
    }

    public void setGenerateTo(Boolean generateTo) {
        set(PROPERTY_GENERATETO, generateTo);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public Boolean isCopyFrom() {
        return (Boolean) get(PROPERTY_COPYFROM);
    }

    public void setCopyFrom(Boolean copyFrom) {
        set(PROPERTY_COPYFROM, copyFrom);
    }

    public Boolean isSelfService() {
        return (Boolean) get(PROPERTY_ISSELFSERVICE);
    }

    public void setSelfService(Boolean isSelfService) {
        set(PROPERTY_ISSELFSERVICE, isSelfService);
    }

    public Organization getOrgTrx() {
        return (Organization) get(PROPERTY_ORGTRX);
    }

    public void setOrgTrx(Organization orgTrx) {
        set(PROPERTY_ORGTRX, orgTrx);
    }

    public String getUser1() {
        return (String) get(PROPERTY_USER1);
    }

    public void setUser1(String user1) {
        set(PROPERTY_USER1, user1);
    }

    public String getUser2() {
        return (String) get(PROPERTY_USER2);
    }

    public void setUser2(String user2) {
        set(PROPERTY_USER2, user2);
    }

    public BigDecimal getWithholdingamount() {
        return (BigDecimal) get(PROPERTY_WITHHOLDINGAMOUNT);
    }

    public void setWithholdingamount(BigDecimal withholdingamount) {
        set(PROPERTY_WITHHOLDINGAMOUNT, withholdingamount);
    }

    public Date getTaxdate() {
        return (Date) get(PROPERTY_TAXDATE);
    }

    public void setTaxdate(Date taxdate) {
        set(PROPERTY_TAXDATE, taxdate);
    }

    public Withholding getWithholding() {
        return (Withholding) get(PROPERTY_WITHHOLDING);
    }

    public void setWithholding(Withholding withholding) {
        set(PROPERTY_WITHHOLDING, withholding);
    }

    public Boolean isPaid() {
        return (Boolean) get(PROPERTY_ISPAID);
    }

    public void setPaid(Boolean isPaid) {
        set(PROPERTY_ISPAID, isPaid);
    }

    public BigDecimal getTotalPaid() {
        return (BigDecimal) get(PROPERTY_TOTALPAID);
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        set(PROPERTY_TOTALPAID, totalPaid);
    }

    public BigDecimal getOutstandingAmt() {
        return (BigDecimal) get(PROPERTY_OUTSTANDINGAMT);
    }

    public void setOutstandingAmt(BigDecimal outstandingAmt) {
        set(PROPERTY_OUTSTANDINGAMT, outstandingAmt);
    }

    public Long getDaysTillDue() {
        return (Long) get(PROPERTY_DAYSTILLDUE);
    }

    public void setDaysTillDue(Long daysTillDue) {
        set(PROPERTY_DAYSTILLDUE, daysTillDue);
    }

    public BigDecimal getDueAmt() {
        return (BigDecimal) get(PROPERTY_DUEAMT);
    }

    public void setDueAmt(BigDecimal dueAmt) {
        set(PROPERTY_DUEAMT, dueAmt);
    }

    public Date getLastCalculatedOnDate() {
        return (Date) get(PROPERTY_LASTCALCULATEDONDATE);
    }

    public void setLastCalculatedOnDate(Date lastCalculatedOnDate) {
        set(PROPERTY_LASTCALCULATEDONDATE, lastCalculatedOnDate);
    }

    public Boolean isUpdatePaymentMonitor() {
        return (Boolean) get(PROPERTY_UPDATEPAYMENTMONITOR);
    }

    public void setUpdatePaymentMonitor(Boolean updatePaymentMonitor) {
        set(PROPERTY_UPDATEPAYMENTMONITOR, updatePaymentMonitor);
    }

    public Boolean isGrossInvoice() {
        return (Boolean) get(PROPERTY_ISGROSSINVOICE);
    }

    public void setGrossInvoice(Boolean isGrossInvoice) {
        set(PROPERTY_ISGROSSINVOICE, isGrossInvoice);
    }

    public BigDecimal getWriteoffamt() {
        return (BigDecimal) get(PROPERTY_WRITEOFFAMT);
    }

    public void setWriteoffamt(BigDecimal writeoffamt) {
        set(PROPERTY_WRITEOFFAMT, writeoffamt);
    }

    public BigDecimal getDiscountamt() {
        return (BigDecimal) get(PROPERTY_DISCOUNTAMT);
    }

    public void setDiscountamt(BigDecimal discountamt) {
        set(PROPERTY_DISCOUNTAMT, discountamt);
    }

    public ProjectPhase getProjectphase() {
        return (ProjectPhase) get(PROPERTY_PROJECTPHASE);
    }

    public void setProjectphase(ProjectPhase projectphase) {
        set(PROPERTY_PROJECTPHASE, projectphase);
    }

    public ProjectTask getProjecttask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjecttask(ProjectTask projecttask) {
        set(PROPERTY_PROJECTTASK, projecttask);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public String getDeliveryrule() {
        return (String) get(PROPERTY_DELIVERYRULE);
    }

    public void setDeliveryrule(String deliveryrule) {
        set(PROPERTY_DELIVERYRULE, deliveryrule);
    }

    public Boolean isBtnreinvoiceprojectexpenses() {
        return (Boolean) get(PROPERTY_BTNREINVOICEPROJECTEXPENSES);
    }

    public void setBtnreinvoiceprojectexpenses(
        Boolean btnreinvoiceprojectexpenses) {
        set(PROPERTY_BTNREINVOICEPROJECTEXPENSES, btnreinvoiceprojectexpenses);
    }

    public Date getPerformancePeriodStart() {
        return (Date) get(PROPERTY_PERFORMANCEPERIODSTART);
    }

    public void setPerformancePeriodStart(Date performancePeriodStart) {
        set(PROPERTY_PERFORMANCEPERIODSTART, performancePeriodStart);
    }

    public Date getPerformancePeriodEnd() {
        return (Date) get(PROPERTY_PERFORMANCEPERIODEND);
    }

    public void setPerformancePeriodEnd(Date performancePeriodEnd) {
        set(PROPERTY_PERFORMANCEPERIODEND, performancePeriodEnd);
    }

    public Boolean isPaymentshedulesummary() {
        return (Boolean) get(PROPERTY_ISPAYMENTSHEDULESUMMARY);
    }

    public void setPaymentshedulesummary(Boolean isPaymentshedulesummary) {
        set(PROPERTY_ISPAYMENTSHEDULESUMMARY, isPaymentshedulesummary);
    }

    public Date getTransactionDate() {
        return (Date) get(PROPERTY_TRANSACTIONDATE);
    }

    public void setTransactionDate(Date transactionDate) {
        set(PROPERTY_TRANSACTIONDATE, transactionDate);
    }

    public String getInternalnote() {
        return (String) get(PROPERTY_INTERNALNOTE);
    }

    public void setInternalnote(String internalnote) {
        set(PROPERTY_INTERNALNOTE, internalnote);
    }

    public Date getSchedTransactionDate() {
        return (Date) get(PROPERTY_SCHEDTRANSACTIONDATE);
    }

    public void setSchedTransactionDate(Date schedTransactionDate) {
        set(PROPERTY_SCHEDTRANSACTIONDATE, schedTransactionDate);
    }

    public String getTransactionreference() {
        return (String) get(PROPERTY_TRANSACTIONREFERENCE);
    }

    public void setTransactionreference(String transactionreference) {
        set(PROPERTY_TRANSACTIONREFERENCE, transactionreference);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineList() {
        return (List<InvoiceLine>) get(PROPERTY_INVOICELINELIST);
    }

    public void setInvoiceLineList(List<InvoiceLine> invoiceLineList) {
        set(PROPERTY_INVOICELINELIST, invoiceLineList);
    }

    @SuppressWarnings("unchecked")
    public List<ReversedInvoice> getReversedInvoicesList() {
        return (List<ReversedInvoice>) get(PROPERTY_REVERSEDINVOICESLIST);
    }

    public void setReversedInvoicesList(
        List<ReversedInvoice> reversedInvoicesList) {
        set(PROPERTY_REVERSEDINVOICESLIST, reversedInvoicesList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceTax> getInvoiceTaxList() {
        return (List<InvoiceTax>) get(PROPERTY_INVOICETAXLIST);
    }

    public void setInvoiceTaxList(List<InvoiceTax> invoiceTaxList) {
        set(PROPERTY_INVOICETAXLIST, invoiceTaxList);
    }

    @SuppressWarnings("unchecked")
    public List<Zssi_invoice_textmodule> getZssiInvoiceTextmoduleList() {
        return (List<Zssi_invoice_textmodule>) get(PROPERTY_ZSSIINVOICETEXTMODULELIST);
    }

    public void setZssiInvoiceTextmoduleList(
        List<Zssi_invoice_textmodule> zssiInvoiceTextmoduleList) {
        set(PROPERTY_ZSSIINVOICETEXTMODULELIST, zssiInvoiceTextmoduleList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPayment> getFinancialMgmtDebtPaymentList() {
        return (List<DebtPayment>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST);
    }

    public void setFinancialMgmtDebtPaymentList(
        List<DebtPayment> financialMgmtDebtPaymentList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST, financialMgmtDebtPaymentList);
    }
}
