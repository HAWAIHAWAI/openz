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
package org.openbravo.model.common.interaction;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.payment.DebtPayment;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.marketing.MailText;
import org.openbravo.model.project.Project;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity Request (stored in table R_Request).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Request extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "R_Request";
    public static final String ENTITY_NAME = "Request";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_REQUESTAMT = "requestAmt";
    public static final String PROPERTY_PRIORITY = "priority";
    public static final String PROPERTY_DUETYPE = "dueType";
    public static final String PROPERTY_SUMMARY = "summary";
    public static final String PROPERTY_ISESCALATED = "isEscalated";
    public static final String PROPERTY_DATELASTACTION = "dateLastAction";
    public static final String PROPERTY_LASTRESULT = "lastResult";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ACTIONTYPE = "actionType";
    public static final String PROPERTY_MAILTEXT = "mailText";
    public static final String PROPERTY_MAILSUBJECT = "mailSubject";
    public static final String PROPERTY_MAILTEXT26 = "mailText26";
    public static final String PROPERTY_RESULT = "result";
    public static final String PROPERTY_NEXTACTION = "nextAction";
    public static final String PROPERTY_DATENEXTACTION = "dateNextAction";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_REQUESTTYPE = "requestType";
    public static final String PROPERTY_SALESREP = "salesRep";
    public static final String PROPERTY_ISSELFSERVICE = "isSelfService";
    public static final String PROPERTY_DEBTPAYMENT = "debtPayment";

    public Request() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PRIORITY, "5");
        setDefaultValue(PROPERTY_DUETYPE, "5");
        setDefaultValue(PROPERTY_ISESCALATED, false);
        setDefaultValue(PROPERTY_NEXTACTION, "F");
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_ISSELFSERVICE, false);
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

    public BigDecimal getRequestAmt() {
        return (BigDecimal) get(PROPERTY_REQUESTAMT);
    }

    public void setRequestAmt(BigDecimal requestAmt) {
        set(PROPERTY_REQUESTAMT, requestAmt);
    }

    public String getPriority() {
        return (String) get(PROPERTY_PRIORITY);
    }

    public void setPriority(String priority) {
        set(PROPERTY_PRIORITY, priority);
    }

    public String getDueType() {
        return (String) get(PROPERTY_DUETYPE);
    }

    public void setDueType(String dueType) {
        set(PROPERTY_DUETYPE, dueType);
    }

    public String getSummary() {
        return (String) get(PROPERTY_SUMMARY);
    }

    public void setSummary(String summary) {
        set(PROPERTY_SUMMARY, summary);
    }

    public Boolean isEscalated() {
        return (Boolean) get(PROPERTY_ISESCALATED);
    }

    public void setEscalated(Boolean isEscalated) {
        set(PROPERTY_ISESCALATED, isEscalated);
    }

    public Date getDateLastAction() {
        return (Date) get(PROPERTY_DATELASTACTION);
    }

    public void setDateLastAction(Date dateLastAction) {
        set(PROPERTY_DATELASTACTION, dateLastAction);
    }

    public String getLastResult() {
        return (String) get(PROPERTY_LASTRESULT);
    }

    public void setLastResult(String lastResult) {
        set(PROPERTY_LASTRESULT, lastResult);
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

    public Campaign getCampaign() {
        return (Campaign) get(PROPERTY_CAMPAIGN);
    }

    public void setCampaign(Campaign campaign) {
        set(PROPERTY_CAMPAIGN, campaign);
    }

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public String getActionType() {
        return (String) get(PROPERTY_ACTIONTYPE);
    }

    public void setActionType(String actionType) {
        set(PROPERTY_ACTIONTYPE, actionType);
    }

    public MailText getMailText() {
        return (MailText) get(PROPERTY_MAILTEXT);
    }

    public void setMailText(MailText mailText) {
        set(PROPERTY_MAILTEXT, mailText);
    }

    public String getMailSubject() {
        return (String) get(PROPERTY_MAILSUBJECT);
    }

    public void setMailSubject(String mailSubject) {
        set(PROPERTY_MAILSUBJECT, mailSubject);
    }

    public String getMailText26() {
        return (String) get(PROPERTY_MAILTEXT26);
    }

    public void setMailText26(String mailText26) {
        set(PROPERTY_MAILTEXT26, mailText26);
    }

    public String getResult() {
        return (String) get(PROPERTY_RESULT);
    }

    public void setResult(String result) {
        set(PROPERTY_RESULT, result);
    }

    public String getNextAction() {
        return (String) get(PROPERTY_NEXTACTION);
    }

    public void setNextAction(String nextAction) {
        set(PROPERTY_NEXTACTION, nextAction);
    }

    public Date getDateNextAction() {
        return (Date) get(PROPERTY_DATENEXTACTION);
    }

    public void setDateNextAction(Date dateNextAction) {
        set(PROPERTY_DATENEXTACTION, dateNextAction);
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

    public RequestType getRequestType() {
        return (RequestType) get(PROPERTY_REQUESTTYPE);
    }

    public void setRequestType(RequestType requestType) {
        set(PROPERTY_REQUESTTYPE, requestType);
    }

    public User getSalesRep() {
        return (User) get(PROPERTY_SALESREP);
    }

    public void setSalesRep(User salesRep) {
        set(PROPERTY_SALESREP, salesRep);
    }

    public Boolean isSelfService() {
        return (Boolean) get(PROPERTY_ISSELFSERVICE);
    }

    public void setSelfService(Boolean isSelfService) {
        set(PROPERTY_ISSELFSERVICE, isSelfService);
    }

    public DebtPayment getDebtPayment() {
        return (DebtPayment) get(PROPERTY_DEBTPAYMENT);
    }

    public void setDebtPayment(DebtPayment debtPayment) {
        set(PROPERTY_DEBTPAYMENT, debtPayment);
    }
}
