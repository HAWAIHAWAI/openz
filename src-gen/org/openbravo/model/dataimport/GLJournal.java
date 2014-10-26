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
package org.openbravo.model.dataimport;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Location;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.accounting.coa.AccountingCombination;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;
import org.openbravo.model.financialmgmt.accounting.coa.ElementValue;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.financialmgmt.gl.GLBatch;
import org.openbravo.model.financialmgmt.gl.GLCategory;
import org.openbravo.model.financialmgmt.gl.GLJournalLine;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.project.Project;
import org.openbravo.model.sales.SalesRegion;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity DataImportGLJournal (stored in table I_GLJournal).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class GLJournal extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "I_GLJournal";
    public static final String ENTITY_NAME = "DataImportGLJournal";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_CLIENTVALUE = "clientValue";
    public static final String PROPERTY_ORGDOC = "orgDoc";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ISIMPORTED = "isImported";
    public static final String PROPERTY_ERRORMSG = "errorMsg";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_JOURNALBATCH = "journalBatch";
    public static final String PROPERTY_BATCHDOCUMENTNO = "batchDocumentNo";
    public static final String PROPERTY_BATCHDESCRIPTION = "batchDescription";
    public static final String PROPERTY_JOURNAL = "journal";
    public static final String PROPERTY_JOURNALDOCUMENTNO = "journalDocumentNo";
    public static final String PROPERTY_POSTINGTYPE = "postingType";
    public static final String PROPERTY_ACCTSCHEMA = "acctSchema";
    public static final String PROPERTY_ACCTSCHEMANAME = "acctSchemaName";
    public static final String PROPERTY_DOCTYPE = "docType";
    public static final String PROPERTY_DOCTYPENAME = "docTypeName";
    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_CATEGORYNAME = "categoryName";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_BUDGET = "budget";
    public static final String PROPERTY_JOURNALLINE = "journalLine";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_DATEACCT = "dateAcct";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_AMTSOURCEDR = "amtSourceDr";
    public static final String PROPERTY_AMTACCTDR = "amtAcctDr";
    public static final String PROPERTY_AMTSOURCECR = "amtSourceCr";
    public static final String PROPERTY_AMTACCTCR = "amtAcctCr";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_ISOCODE = "iSOCode";
    public static final String PROPERTY_CURRENCYRATETYPE = "currencyRateType";
    public static final String PROPERTY_CURRENCYRATE = "currencyRate";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_QTY = "qty";
    public static final String PROPERTY_VALIDCOMBINATION = "validCombination";
    public static final String PROPERTY_ORGVALUE = "orgValue";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ACCOUNT = "account";
    public static final String PROPERTY_ACCOUNTVALUE = "accountValue";
    public static final String PROPERTY_ORGTRX = "orgTrx";
    public static final String PROPERTY_ORGTRXVALUE = "orgTrxValue";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_PRODUCTVALUE = "productValue";
    public static final String PROPERTY_UPC = "uPC";
    public static final String PROPERTY_SKU = "sKU";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_BPARTNERVALUE = "bPartnerValue";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_PROJECTVALUE = "projectValue";
    public static final String PROPERTY_LOCTO = "locTo";
    public static final String PROPERTY_LOCFROM = "locFrom";
    public static final String PROPERTY_SALESREGION = "salesRegion";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_USER1 = "user1";
    public static final String PROPERTY_USER2 = "user2";

    public GLJournal() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISIMPORTED, false);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
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

    public String getClientValue() {
        return (String) get(PROPERTY_CLIENTVALUE);
    }

    public void setClientValue(String clientValue) {
        set(PROPERTY_CLIENTVALUE, clientValue);
    }

    public Organization getOrgDoc() {
        return (Organization) get(PROPERTY_ORGDOC);
    }

    public void setOrgDoc(Organization orgDoc) {
        set(PROPERTY_ORGDOC, orgDoc);
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

    public Boolean isImported() {
        return (Boolean) get(PROPERTY_ISIMPORTED);
    }

    public void setImported(Boolean isImported) {
        set(PROPERTY_ISIMPORTED, isImported);
    }

    public String getErrorMsg() {
        return (String) get(PROPERTY_ERRORMSG);
    }

    public void setErrorMsg(String errorMsg) {
        set(PROPERTY_ERRORMSG, errorMsg);
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

    public GLBatch getJournalBatch() {
        return (GLBatch) get(PROPERTY_JOURNALBATCH);
    }

    public void setJournalBatch(GLBatch journalBatch) {
        set(PROPERTY_JOURNALBATCH, journalBatch);
    }

    public String getBatchDocumentNo() {
        return (String) get(PROPERTY_BATCHDOCUMENTNO);
    }

    public void setBatchDocumentNo(String batchDocumentNo) {
        set(PROPERTY_BATCHDOCUMENTNO, batchDocumentNo);
    }

    public String getBatchDescription() {
        return (String) get(PROPERTY_BATCHDESCRIPTION);
    }

    public void setBatchDescription(String batchDescription) {
        set(PROPERTY_BATCHDESCRIPTION, batchDescription);
    }

    public org.openbravo.model.financialmgmt.gl.GLJournal getJournal() {
        return (org.openbravo.model.financialmgmt.gl.GLJournal) get(PROPERTY_JOURNAL);
    }

    public void setJournal(
        org.openbravo.model.financialmgmt.gl.GLJournal journal) {
        set(PROPERTY_JOURNAL, journal);
    }

    public String getJournalDocumentNo() {
        return (String) get(PROPERTY_JOURNALDOCUMENTNO);
    }

    public void setJournalDocumentNo(String journalDocumentNo) {
        set(PROPERTY_JOURNALDOCUMENTNO, journalDocumentNo);
    }

    public String getPostingType() {
        return (String) get(PROPERTY_POSTINGTYPE);
    }

    public void setPostingType(String postingType) {
        set(PROPERTY_POSTINGTYPE, postingType);
    }

    public AcctSchema getAcctSchema() {
        return (AcctSchema) get(PROPERTY_ACCTSCHEMA);
    }

    public void setAcctSchema(AcctSchema acctSchema) {
        set(PROPERTY_ACCTSCHEMA, acctSchema);
    }

    public String getAcctSchemaName() {
        return (String) get(PROPERTY_ACCTSCHEMANAME);
    }

    public void setAcctSchemaName(String acctSchemaName) {
        set(PROPERTY_ACCTSCHEMANAME, acctSchemaName);
    }

    public DocumentType getDocType() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDocType(DocumentType docType) {
        set(PROPERTY_DOCTYPE, docType);
    }

    public String getDocTypeName() {
        return (String) get(PROPERTY_DOCTYPENAME);
    }

    public void setDocTypeName(String docTypeName) {
        set(PROPERTY_DOCTYPENAME, docTypeName);
    }

    public GLCategory getCategory() {
        return (GLCategory) get(PROPERTY_CATEGORY);
    }

    public void setCategory(GLCategory category) {
        set(PROPERTY_CATEGORY, category);
    }

    public String getCategoryName() {
        return (String) get(PROPERTY_CATEGORYNAME);
    }

    public void setCategoryName(String categoryName) {
        set(PROPERTY_CATEGORYNAME, categoryName);
    }

    public Period getPeriod() {
        return (Period) get(PROPERTY_PERIOD);
    }

    public void setPeriod(Period period) {
        set(PROPERTY_PERIOD, period);
    }

    public String getBudget() {
        return (String) get(PROPERTY_BUDGET);
    }

    public void setBudget(String budget) {
        set(PROPERTY_BUDGET, budget);
    }

    public GLJournalLine getJournalLine() {
        return (GLJournalLine) get(PROPERTY_JOURNALLINE);
    }

    public void setJournalLine(GLJournalLine journalLine) {
        set(PROPERTY_JOURNALLINE, journalLine);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public Date getDateAcct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateAcct(Date dateAcct) {
        set(PROPERTY_DATEACCT, dateAcct);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public BigDecimal getAmtSourceDr() {
        return (BigDecimal) get(PROPERTY_AMTSOURCEDR);
    }

    public void setAmtSourceDr(BigDecimal amtSourceDr) {
        set(PROPERTY_AMTSOURCEDR, amtSourceDr);
    }

    public BigDecimal getAmtAcctDr() {
        return (BigDecimal) get(PROPERTY_AMTACCTDR);
    }

    public void setAmtAcctDr(BigDecimal amtAcctDr) {
        set(PROPERTY_AMTACCTDR, amtAcctDr);
    }

    public BigDecimal getAmtSourceCr() {
        return (BigDecimal) get(PROPERTY_AMTSOURCECR);
    }

    public void setAmtSourceCr(BigDecimal amtSourceCr) {
        set(PROPERTY_AMTSOURCECR, amtSourceCr);
    }

    public BigDecimal getAmtAcctCr() {
        return (BigDecimal) get(PROPERTY_AMTACCTCR);
    }

    public void setAmtAcctCr(BigDecimal amtAcctCr) {
        set(PROPERTY_AMTACCTCR, amtAcctCr);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public String getISOCode() {
        return (String) get(PROPERTY_ISOCODE);
    }

    public void setISOCode(String iSOCode) {
        set(PROPERTY_ISOCODE, iSOCode);
    }

    public String getCurrencyRateType() {
        return (String) get(PROPERTY_CURRENCYRATETYPE);
    }

    public void setCurrencyRateType(String currencyRateType) {
        set(PROPERTY_CURRENCYRATETYPE, currencyRateType);
    }

    public BigDecimal getCurrencyRate() {
        return (BigDecimal) get(PROPERTY_CURRENCYRATE);
    }

    public void setCurrencyRate(BigDecimal currencyRate) {
        set(PROPERTY_CURRENCYRATE, currencyRate);
    }

    public org.openbravo.model.common.uom.UOM getUOM() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUOM(org.openbravo.model.common.uom.UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public BigDecimal getQty() {
        return (BigDecimal) get(PROPERTY_QTY);
    }

    public void setQty(BigDecimal qty) {
        set(PROPERTY_QTY, qty);
    }

    public AccountingCombination getValidCombination() {
        return (AccountingCombination) get(PROPERTY_VALIDCOMBINATION);
    }

    public void setValidCombination(AccountingCombination validCombination) {
        set(PROPERTY_VALIDCOMBINATION, validCombination);
    }

    public String getOrgValue() {
        return (String) get(PROPERTY_ORGVALUE);
    }

    public void setOrgValue(String orgValue) {
        set(PROPERTY_ORGVALUE, orgValue);
    }

    public Organization getOrg() {
        return (Organization) get(PROPERTY_ORG);
    }

    public void setOrg(Organization org) {
        set(PROPERTY_ORG, org);
    }

    public ElementValue getAccount() {
        return (ElementValue) get(PROPERTY_ACCOUNT);
    }

    public void setAccount(ElementValue account) {
        set(PROPERTY_ACCOUNT, account);
    }

    public String getAccountValue() {
        return (String) get(PROPERTY_ACCOUNTVALUE);
    }

    public void setAccountValue(String accountValue) {
        set(PROPERTY_ACCOUNTVALUE, accountValue);
    }

    public Organization getOrgTrx() {
        return (Organization) get(PROPERTY_ORGTRX);
    }

    public void setOrgTrx(Organization orgTrx) {
        set(PROPERTY_ORGTRX, orgTrx);
    }

    public String getOrgTrxValue() {
        return (String) get(PROPERTY_ORGTRXVALUE);
    }

    public void setOrgTrxValue(String orgTrxValue) {
        set(PROPERTY_ORGTRXVALUE, orgTrxValue);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public String getProductValue() {
        return (String) get(PROPERTY_PRODUCTVALUE);
    }

    public void setProductValue(String productValue) {
        set(PROPERTY_PRODUCTVALUE, productValue);
    }

    public String getUPC() {
        return (String) get(PROPERTY_UPC);
    }

    public void setUPC(String uPC) {
        set(PROPERTY_UPC, uPC);
    }

    public String getSKU() {
        return (String) get(PROPERTY_SKU);
    }

    public void setSKU(String sKU) {
        set(PROPERTY_SKU, sKU);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public String getBPartnerValue() {
        return (String) get(PROPERTY_BPARTNERVALUE);
    }

    public void setBPartnerValue(String bPartnerValue) {
        set(PROPERTY_BPARTNERVALUE, bPartnerValue);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public String getProjectValue() {
        return (String) get(PROPERTY_PROJECTVALUE);
    }

    public void setProjectValue(String projectValue) {
        set(PROPERTY_PROJECTVALUE, projectValue);
    }

    public Location getLocTo() {
        return (Location) get(PROPERTY_LOCTO);
    }

    public void setLocTo(Location locTo) {
        set(PROPERTY_LOCTO, locTo);
    }

    public Location getLocFrom() {
        return (Location) get(PROPERTY_LOCFROM);
    }

    public void setLocFrom(Location locFrom) {
        set(PROPERTY_LOCFROM, locFrom);
    }

    public SalesRegion getSalesRegion() {
        return (SalesRegion) get(PROPERTY_SALESREGION);
    }

    public void setSalesRegion(SalesRegion salesRegion) {
        set(PROPERTY_SALESREGION, salesRegion);
    }

    public ABCActivity getActivity() {
        return (ABCActivity) get(PROPERTY_ACTIVITY);
    }

    public void setActivity(ABCActivity activity) {
        set(PROPERTY_ACTIVITY, activity);
    }

    public Campaign getCampaign() {
        return (Campaign) get(PROPERTY_CAMPAIGN);
    }

    public void setCampaign(Campaign campaign) {
        set(PROPERTY_CAMPAIGN, campaign);
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
}
