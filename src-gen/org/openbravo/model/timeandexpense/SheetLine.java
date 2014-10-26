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
package org.openbravo.model.timeandexpense;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.project.ProjectTask;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity TimeAndExpenseSheetLine (stored in table S_TimeExpenseLine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SheetLine extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "S_TimeExpenseLine";
    public static final String ENTITY_NAME = "TimeAndExpenseSheetLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_TIMEEXPENSE = "timeExpense";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_ISTIMEREPORT = "isTimeReport";
    public static final String PROPERTY_DATEEXPENSE = "dateExpense";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_QTY = "qty";
    public static final String PROPERTY_EXPENSEAMT = "expenseAmt";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_CONVERTEDAMT = "convertedAmt";
    public static final String PROPERTY_RESOURCEASSIGNMENT =
        "resourceAssignment";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_NOTE = "note";
    public static final String PROPERTY_ISINVOICED = "isInvoiced";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_INVOICELINE = "invoiceLine";
    public static final String PROPERTY_INVOICEPRICE = "invoicePrice";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_ORDERLINE = "orderLine";
    public static final String PROPERTY_PROJECTPHASE = "projectPhase";
    public static final String PROPERTY_PROJECTTASK = "projectTask";
    public static final String PROPERTY_TIMETYPE = "timeType";

    public SheetLine() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISTIMEREPORT, false);
        setDefaultValue(PROPERTY_QTY, new BigDecimal(1));
        setDefaultValue(PROPERTY_ISINVOICED, false);
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

    public Sheet getTimeExpense() {
        return (Sheet) get(PROPERTY_TIMEEXPENSE);
    }

    public void setTimeExpense(Sheet timeExpense) {
        set(PROPERTY_TIMEEXPENSE, timeExpense);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public Boolean isTimeReport() {
        return (Boolean) get(PROPERTY_ISTIMEREPORT);
    }

    public void setTimeReport(Boolean isTimeReport) {
        set(PROPERTY_ISTIMEREPORT, isTimeReport);
    }

    public Date getDateExpense() {
        return (Date) get(PROPERTY_DATEEXPENSE);
    }

    public void setDateExpense(Date dateExpense) {
        set(PROPERTY_DATEEXPENSE, dateExpense);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getQty() {
        return (BigDecimal) get(PROPERTY_QTY);
    }

    public void setQty(BigDecimal qty) {
        set(PROPERTY_QTY, qty);
    }

    public BigDecimal getExpenseAmt() {
        return (BigDecimal) get(PROPERTY_EXPENSEAMT);
    }

    public void setExpenseAmt(BigDecimal expenseAmt) {
        set(PROPERTY_EXPENSEAMT, expenseAmt);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public BigDecimal getConvertedAmt() {
        return (BigDecimal) get(PROPERTY_CONVERTEDAMT);
    }

    public void setConvertedAmt(BigDecimal convertedAmt) {
        set(PROPERTY_CONVERTEDAMT, convertedAmt);
    }

    public String getResourceAssignment() {
        return (String) get(PROPERTY_RESOURCEASSIGNMENT);
    }

    public void setResourceAssignment(String resourceAssignment) {
        set(PROPERTY_RESOURCEASSIGNMENT, resourceAssignment);
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

    public Boolean isInvoiced() {
        return (Boolean) get(PROPERTY_ISINVOICED);
    }

    public void setInvoiced(Boolean isInvoiced) {
        set(PROPERTY_ISINVOICED, isInvoiced);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
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

    public Campaign getCampaign() {
        return (Campaign) get(PROPERTY_CAMPAIGN);
    }

    public void setCampaign(Campaign campaign) {
        set(PROPERTY_CAMPAIGN, campaign);
    }

    public InvoiceLine getInvoiceLine() {
        return (InvoiceLine) get(PROPERTY_INVOICELINE);
    }

    public void setInvoiceLine(InvoiceLine invoiceLine) {
        set(PROPERTY_INVOICELINE, invoiceLine);
    }

    public BigDecimal getInvoicePrice() {
        return (BigDecimal) get(PROPERTY_INVOICEPRICE);
    }

    public void setInvoicePrice(BigDecimal invoicePrice) {
        set(PROPERTY_INVOICEPRICE, invoicePrice);
    }

    public org.openbravo.model.common.uom.UOM getUOM() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUOM(org.openbravo.model.common.uom.UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public OrderLine getOrderLine() {
        return (OrderLine) get(PROPERTY_ORDERLINE);
    }

    public void setOrderLine(OrderLine orderLine) {
        set(PROPERTY_ORDERLINE, orderLine);
    }

    public ProjectPhase getProjectPhase() {
        return (ProjectPhase) get(PROPERTY_PROJECTPHASE);
    }

    public void setProjectPhase(ProjectPhase projectPhase) {
        set(PROPERTY_PROJECTPHASE, projectPhase);
    }

    public ProjectTask getProjectTask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjectTask(ProjectTask projectTask) {
        set(PROPERTY_PROJECTTASK, projectTask);
    }

    public TimeType getTimeType() {
        return (TimeType) get(PROPERTY_TIMETYPE);
    }

    public void setTimeType(TimeType timeType) {
        set(PROPERTY_TIMETYPE, timeType);
    }
}
