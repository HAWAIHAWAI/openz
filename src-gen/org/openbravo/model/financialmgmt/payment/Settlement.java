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
package org.openbravo.model.financialmgmt.payment;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.project.Project;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity FinancialMgmtSettlement (stored in table C_Settlement).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Settlement extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Settlement";
    public static final String ENTITY_NAME = "FinancialMgmtSettlement";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DATETRX = "dateTrx";
    public static final String PROPERTY_DOCTYPE = "docType";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_USER1 = "user1";
    public static final String PROPERTY_USER2 = "user2";
    public static final String PROPERTY_CREATEFROM = "createFrom";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_CANCELEDNOTCHARGEAMT =
        "cancelednotchargeamt";
    public static final String PROPERTY_GENERATEDAMT = "generatedamt";
    public static final String PROPERTY_CHARGEDAMT = "chargedamt";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_CREATEFILE = "createFile";
    public static final String PROPERTY_DATEACCT = "dateAcct";
    public static final String PROPERTY_SETTLEMENTTYPE = "settlementtype";
    public static final String PROPERTY_SETTLEMENTOPEN = "settlementOpen";
    public static final String PROPERTY_COPYFROM = "copyFrom";
    public static final String PROPERTY_ISGENERATED = "isGenerated";
    public static final String PROPERTY_ISTEMPLATE = "isTemplate";
    public static final String PROPERTY_DOCSTATUS = "docstatus";
    public static final String PROPERTY_BANKSTATEMENTLINE = "bankstatementline";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST =
        "financialMgmtDebtPaymentGenerateVList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTCANCELVLIST =
        "financialMgmtDebtPaymentCancelVList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTCSETTLEMENTCANCELIDLIST =
        "financialMgmtDebtPaymentCSettlementCancelIDList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTCSETTLEMENTGENERATEIDLIST =
        "financialMgmtDebtPaymentCSettlementGenerateIDList";

    public Settlement() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_PROCESSED, "N");
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_CREATEFROM, false);
        setDefaultValue(PROPERTY_CANCELEDNOTCHARGEAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_GENERATEDAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_CHARGEDAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_CREATEFILE, false);
        setDefaultValue(PROPERTY_SETTLEMENTOPEN, false);
        setDefaultValue(PROPERTY_COPYFROM, false);
        setDefaultValue(PROPERTY_ISGENERATED, false);
        setDefaultValue(PROPERTY_ISTEMPLATE, false);
        setDefaultValue(PROPERTY_DOCSTATUS, "CO");
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTCANCELVLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTCSETTLEMENTCANCELIDLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTCSETTLEMENTGENERATEIDLIST,
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

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Date getDateTrx() {
        return (Date) get(PROPERTY_DATETRX);
    }

    public void setDateTrx(Date dateTrx) {
        set(PROPERTY_DATETRX, dateTrx);
    }

    public DocumentType getDocType() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDocType(DocumentType docType) {
        set(PROPERTY_DOCTYPE, docType);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Campaign getCampaign() {
        return (Campaign) get(PROPERTY_CAMPAIGN);
    }

    public void setCampaign(Campaign campaign) {
        set(PROPERTY_CAMPAIGN, campaign);
    }

    public ABCActivity getActivity() {
        return (ABCActivity) get(PROPERTY_ACTIVITY);
    }

    public void setActivity(ABCActivity activity) {
        set(PROPERTY_ACTIVITY, activity);
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

    public Boolean isCreateFrom() {
        return (Boolean) get(PROPERTY_CREATEFROM);
    }

    public void setCreateFrom(Boolean createFrom) {
        set(PROPERTY_CREATEFROM, createFrom);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public BigDecimal getCancelednotchargeamt() {
        return (BigDecimal) get(PROPERTY_CANCELEDNOTCHARGEAMT);
    }

    public void setCancelednotchargeamt(BigDecimal cancelednotchargeamt) {
        set(PROPERTY_CANCELEDNOTCHARGEAMT, cancelednotchargeamt);
    }

    public BigDecimal getGeneratedamt() {
        return (BigDecimal) get(PROPERTY_GENERATEDAMT);
    }

    public void setGeneratedamt(BigDecimal generatedamt) {
        set(PROPERTY_GENERATEDAMT, generatedamt);
    }

    public BigDecimal getChargedamt() {
        return (BigDecimal) get(PROPERTY_CHARGEDAMT);
    }

    public void setChargedamt(BigDecimal chargedamt) {
        set(PROPERTY_CHARGEDAMT, chargedamt);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isCreateFile() {
        return (Boolean) get(PROPERTY_CREATEFILE);
    }

    public void setCreateFile(Boolean createFile) {
        set(PROPERTY_CREATEFILE, createFile);
    }

    public Date getDateAcct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateAcct(Date dateAcct) {
        set(PROPERTY_DATEACCT, dateAcct);
    }

    public String getSettlementtype() {
        return (String) get(PROPERTY_SETTLEMENTTYPE);
    }

    public void setSettlementtype(String settlementtype) {
        set(PROPERTY_SETTLEMENTTYPE, settlementtype);
    }

    public Boolean isSettlementOpen() {
        return (Boolean) get(PROPERTY_SETTLEMENTOPEN);
    }

    public void setSettlementOpen(Boolean settlementOpen) {
        set(PROPERTY_SETTLEMENTOPEN, settlementOpen);
    }

    public Boolean isCopyFrom() {
        return (Boolean) get(PROPERTY_COPYFROM);
    }

    public void setCopyFrom(Boolean copyFrom) {
        set(PROPERTY_COPYFROM, copyFrom);
    }

    public Boolean isGenerated() {
        return (Boolean) get(PROPERTY_ISGENERATED);
    }

    public void setGenerated(Boolean isGenerated) {
        set(PROPERTY_ISGENERATED, isGenerated);
    }

    public Boolean isTemplate() {
        return (Boolean) get(PROPERTY_ISTEMPLATE);
    }

    public void setTemplate(Boolean isTemplate) {
        set(PROPERTY_ISTEMPLATE, isTemplate);
    }

    public String getDocstatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocstatus(String docstatus) {
        set(PROPERTY_DOCSTATUS, docstatus);
    }

    public String getBankstatementline() {
        return (String) get(PROPERTY_BANKSTATEMENTLINE);
    }

    public void setBankstatementline(String bankstatementline) {
        set(PROPERTY_BANKSTATEMENTLINE, bankstatementline);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPaymentGenerateV> getFinancialMgmtDebtPaymentGenerateVList() {
        return (List<DebtPaymentGenerateV>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST);
    }

    public void setFinancialMgmtDebtPaymentGenerateVList(
        List<DebtPaymentGenerateV> financialMgmtDebtPaymentGenerateVList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST,
            financialMgmtDebtPaymentGenerateVList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPaymentCancelV> getFinancialMgmtDebtPaymentCancelVList() {
        return (List<DebtPaymentCancelV>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTCANCELVLIST);
    }

    public void setFinancialMgmtDebtPaymentCancelVList(
        List<DebtPaymentCancelV> financialMgmtDebtPaymentCancelVList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTCANCELVLIST,
            financialMgmtDebtPaymentCancelVList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPayment> getFinancialMgmtDebtPaymentCSettlementCancelIDList() {
        return (List<DebtPayment>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTCSETTLEMENTCANCELIDLIST);
    }

    public void setFinancialMgmtDebtPaymentCSettlementCancelIDList(
        List<DebtPayment> financialMgmtDebtPaymentCSettlementCancelIDList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTCSETTLEMENTCANCELIDLIST,
            financialMgmtDebtPaymentCSettlementCancelIDList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPayment> getFinancialMgmtDebtPaymentCSettlementGenerateIDList() {
        return (List<DebtPayment>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTCSETTLEMENTGENERATEIDLIST);
    }

    public void setFinancialMgmtDebtPaymentCSettlementGenerateIDList(
        List<DebtPayment> financialMgmtDebtPaymentCSettlementGenerateIDList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTCSETTLEMENTGENERATEIDLIST,
            financialMgmtDebtPaymentCSettlementGenerateIDList);
    }
}
