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
import org.openbravo.model.marketing.MailText;
import org.openbravo.model.project.Project;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity RequestionAction (stored in table R_RequestAction).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class RequestionAction extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "R_RequestAction";
    public static final String ENTITY_NAME = "RequestionAction";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_REQUEST = "request";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_ACTIONTYPE = "actionType";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_MAILTEXT = "mailText";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_MAILTEXT17 = "mailText17";
    public static final String PROPERTY_RESULT = "result";
    public static final String PROPERTY_DATENEXTACTION = "dateNextAction";
    public static final String PROPERTY_SALESREP = "salesRep";
    public static final String PROPERTY_DEBTPAYMENT = "debtPayment";
    public static final String PROPERTY_DATEACTION = "dateaction";

    public RequestionAction() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
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

    public Request getRequest() {
        return (Request) get(PROPERTY_REQUEST);
    }

    public void setRequest(Request request) {
        set(PROPERTY_REQUEST, request);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public String getActionType() {
        return (String) get(PROPERTY_ACTIONTYPE);
    }

    public void setActionType(String actionType) {
        set(PROPERTY_ACTIONTYPE, actionType);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
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

    public MailText getMailText() {
        return (MailText) get(PROPERTY_MAILTEXT);
    }

    public void setMailText(MailText mailText) {
        set(PROPERTY_MAILTEXT, mailText);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public String getMailText17() {
        return (String) get(PROPERTY_MAILTEXT17);
    }

    public void setMailText17(String mailText17) {
        set(PROPERTY_MAILTEXT17, mailText17);
    }

    public String getResult() {
        return (String) get(PROPERTY_RESULT);
    }

    public void setResult(String result) {
        set(PROPERTY_RESULT, result);
    }

    public Date getDateNextAction() {
        return (Date) get(PROPERTY_DATENEXTACTION);
    }

    public void setDateNextAction(Date dateNextAction) {
        set(PROPERTY_DATENEXTACTION, dateNextAction);
    }

    public User getSalesRep() {
        return (User) get(PROPERTY_SALESREP);
    }

    public void setSalesRep(User salesRep) {
        set(PROPERTY_SALESREP, salesRep);
    }

    public DebtPayment getDebtPayment() {
        return (DebtPayment) get(PROPERTY_DEBTPAYMENT);
    }

    public void setDebtPayment(DebtPayment debtPayment) {
        set(PROPERTY_DEBTPAYMENT, debtPayment);
    }

    public Date getDateaction() {
        return (Date) get(PROPERTY_DATEACTION);
    }

    public void setDateaction(Date dateaction) {
        set(PROPERTY_DATEACTION, dateaction);
    }
}
