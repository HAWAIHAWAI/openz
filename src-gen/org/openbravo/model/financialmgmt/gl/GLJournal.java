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
package org.openbravo.model.financialmgmt.gl;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;
import org.openbravo.model.financialmgmt.calendar.Period;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity FinancialMgmtGLJournal (stored in table GL_Journal).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class GLJournal extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "GL_Journal";
    public static final String ENTITY_NAME = "FinancialMgmtGLJournal";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACCTSCHEMA = "acctSchema";
    public static final String PROPERTY_DOCTYPE = "docType";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DOCSTATUS = "docStatus";
    public static final String PROPERTY_DOCACTION = "docAction";
    public static final String PROPERTY_ISAPPROVED = "isApproved";
    public static final String PROPERTY_ISPRINTED = "isPrinted";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_POSTINGTYPE = "postingType";
    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_DATEDOC = "dateDoc";
    public static final String PROPERTY_DATEACCT = "dateAcct";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_CURRENCYRATETYPE = "currencyRateType";
    public static final String PROPERTY_CURRENCYRATE = "currencyRate";
    public static final String PROPERTY_JOURNALBATCH = "journalBatch";
    public static final String PROPERTY_TOTALDR = "totalDr";
    public static final String PROPERTY_TOTALCR = "totalCr";
    public static final String PROPERTY_CONTROLAMT = "controlAmt";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_ISOPENING = "isOpening";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLINELIST =
        "financialMgmtGLJournalLineList";

    public GLJournal() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_DOCSTATUS, "DR");
        setDefaultValue(PROPERTY_DOCACTION, "CO");
        setDefaultValue(PROPERTY_ISAPPROVED, true);
        setDefaultValue(PROPERTY_ISPRINTED, false);
        setDefaultValue(PROPERTY_CURRENCYRATETYPE, "S");
        setDefaultValue(PROPERTY_CURRENCYRATE, new BigDecimal(1));
        setDefaultValue(PROPERTY_TOTALDR, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALCR, new BigDecimal(0));
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_ISOPENING, false);
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST,
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

    public AcctSchema getAcctSchema() {
        return (AcctSchema) get(PROPERTY_ACCTSCHEMA);
    }

    public void setAcctSchema(AcctSchema acctSchema) {
        set(PROPERTY_ACCTSCHEMA, acctSchema);
    }

    public DocumentType getDocType() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDocType(DocumentType docType) {
        set(PROPERTY_DOCTYPE, docType);
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

    public Boolean isApproved() {
        return (Boolean) get(PROPERTY_ISAPPROVED);
    }

    public void setApproved(Boolean isApproved) {
        set(PROPERTY_ISAPPROVED, isApproved);
    }

    public Boolean isPrinted() {
        return (Boolean) get(PROPERTY_ISPRINTED);
    }

    public void setPrinted(Boolean isPrinted) {
        set(PROPERTY_ISPRINTED, isPrinted);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getPostingType() {
        return (String) get(PROPERTY_POSTINGTYPE);
    }

    public void setPostingType(String postingType) {
        set(PROPERTY_POSTINGTYPE, postingType);
    }

    public GLCategory getCategory() {
        return (GLCategory) get(PROPERTY_CATEGORY);
    }

    public void setCategory(GLCategory category) {
        set(PROPERTY_CATEGORY, category);
    }

    public Date getDateDoc() {
        return (Date) get(PROPERTY_DATEDOC);
    }

    public void setDateDoc(Date dateDoc) {
        set(PROPERTY_DATEDOC, dateDoc);
    }

    public Date getDateAcct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateAcct(Date dateAcct) {
        set(PROPERTY_DATEACCT, dateAcct);
    }

    public Period getPeriod() {
        return (Period) get(PROPERTY_PERIOD);
    }

    public void setPeriod(Period period) {
        set(PROPERTY_PERIOD, period);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
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

    public GLBatch getJournalBatch() {
        return (GLBatch) get(PROPERTY_JOURNALBATCH);
    }

    public void setJournalBatch(GLBatch journalBatch) {
        set(PROPERTY_JOURNALBATCH, journalBatch);
    }

    public BigDecimal getTotalDr() {
        return (BigDecimal) get(PROPERTY_TOTALDR);
    }

    public void setTotalDr(BigDecimal totalDr) {
        set(PROPERTY_TOTALDR, totalDr);
    }

    public BigDecimal getTotalCr() {
        return (BigDecimal) get(PROPERTY_TOTALCR);
    }

    public void setTotalCr(BigDecimal totalCr) {
        set(PROPERTY_TOTALCR, totalCr);
    }

    public BigDecimal getControlAmt() {
        return (BigDecimal) get(PROPERTY_CONTROLAMT);
    }

    public void setControlAmt(BigDecimal controlAmt) {
        set(PROPERTY_CONTROLAMT, controlAmt);
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

    public Boolean isOpening() {
        return (Boolean) get(PROPERTY_ISOPENING);
    }

    public void setOpening(Boolean isOpening) {
        set(PROPERTY_ISOPENING, isOpening);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournalLine> getFinancialMgmtGLJournalLineList() {
        return (List<GLJournalLine>) get(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST);
    }

    public void setFinancialMgmtGLJournalLineList(
        List<GLJournalLine> financialMgmtGLJournalLineList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST,
            financialMgmtGLJournalLineList);
    }
}
