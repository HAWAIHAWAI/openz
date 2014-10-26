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
package org.openbravo.zsoft.projects;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectTask;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity zspm_recharge_view (stored in table zspm_recharge_view).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class zspm_recharge_view extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zspm_recharge_view";
    public static final String ENTITY_NAME = "zspm_recharge_view";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_INVOICELINE = "invoiceline";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_ORDERLINE = "orderline";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_QTYINVOICED = "qtyinvoiced";
    public static final String PROPERTY_LINENETAMT = "linenetamt";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_REINVOICEDBY = "reinvoicedby";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_DATEINVOICED = "dateinvoiced";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_TOTALLINES = "totallines";
    public static final String PROPERTY_GRANDTOTAL = "grandtotal";
    public static final String PROPERTY_TOTALPAID = "totalpaid";
    public static final String PROPERTY_TRANSACTIONDATE = "transactiondate";
    public static final String PROPERTY_ISPAID = "ispaid";
    public static final String PROPERTY_DATEORDERED = "dateordered";
    public static final String PROPERTY_SALESREP = "salesrep";
    public static final String PROPERTY_RECHARGEPRODUCT = "rechargeProduct";
    public static final String PROPERTY_RECHARGEQTYINVOICED =
        "rechargeQtyinvoiced";
    public static final String PROPERTY_RECHARGELINENETAMT =
        "rechargeLinenetamt";
    public static final String PROPERTY_RECHARGEINVOICE = "rechargeInvoice";
    public static final String PROPERTY_RECHARGEDATEINVOICED =
        "rechargeDateinvoiced";
    public static final String PROPERTY_RECHARGEBPARTNER = "rechargeBpartner";
    public static final String PROPERTY_RECHARGEORDER = "rechargeOrder";
    public static final String PROPERTY_ISRECHARGED = "isrecharged";
    public static final String PROPERTY_NORECHARGE = "norecharge";
    public static final String PROPERTY_NORECHARGECOMMENT = "norechargecomment";

    public zspm_recharge_view() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISPAID, false);
        setDefaultValue(PROPERTY_ISRECHARGED, false);
        setDefaultValue(PROPERTY_NORECHARGE, false);
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

    public void setActive(Boolean isactive) {
        set(PROPERTY_ISACTIVE, isactive);
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

    public InvoiceLine getInvoiceline() {
        return (InvoiceLine) get(PROPERTY_INVOICELINE);
    }

    public void setInvoiceline(InvoiceLine invoiceline) {
        set(PROPERTY_INVOICELINE, invoiceline);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public OrderLine getOrderline() {
        return (OrderLine) get(PROPERTY_ORDERLINE);
    }

    public void setOrderline(OrderLine orderline) {
        set(PROPERTY_ORDERLINE, orderline);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Long getQtyinvoiced() {
        return (Long) get(PROPERTY_QTYINVOICED);
    }

    public void setQtyinvoiced(Long qtyinvoiced) {
        set(PROPERTY_QTYINVOICED, qtyinvoiced);
    }

    public BigDecimal getLinenetamt() {
        return (BigDecimal) get(PROPERTY_LINENETAMT);
    }

    public void setLinenetamt(BigDecimal linenetamt) {
        set(PROPERTY_LINENETAMT, linenetamt);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public ProjectTask getProjecttask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjecttask(ProjectTask projecttask) {
        set(PROPERTY_PROJECTTASK, projecttask);
    }

    public InvoiceLine getReinvoicedby() {
        return (InvoiceLine) get(PROPERTY_REINVOICEDBY);
    }

    public void setReinvoicedby(InvoiceLine reinvoicedby) {
        set(PROPERTY_REINVOICEDBY, reinvoicedby);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

    public Date getDateinvoiced() {
        return (Date) get(PROPERTY_DATEINVOICED);
    }

    public void setDateinvoiced(Date dateinvoiced) {
        set(PROPERTY_DATEINVOICED, dateinvoiced);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public Long getTotallines() {
        return (Long) get(PROPERTY_TOTALLINES);
    }

    public void setTotallines(Long totallines) {
        set(PROPERTY_TOTALLINES, totallines);
    }

    public BigDecimal getGrandtotal() {
        return (BigDecimal) get(PROPERTY_GRANDTOTAL);
    }

    public void setGrandtotal(BigDecimal grandtotal) {
        set(PROPERTY_GRANDTOTAL, grandtotal);
    }

    public BigDecimal getTotalpaid() {
        return (BigDecimal) get(PROPERTY_TOTALPAID);
    }

    public void setTotalpaid(BigDecimal totalpaid) {
        set(PROPERTY_TOTALPAID, totalpaid);
    }

    public Date getTransactiondate() {
        return (Date) get(PROPERTY_TRANSACTIONDATE);
    }

    public void setTransactiondate(Date transactiondate) {
        set(PROPERTY_TRANSACTIONDATE, transactiondate);
    }

    public Boolean isPaid() {
        return (Boolean) get(PROPERTY_ISPAID);
    }

    public void setPaid(Boolean ispaid) {
        set(PROPERTY_ISPAID, ispaid);
    }

    public Date getDateordered() {
        return (Date) get(PROPERTY_DATEORDERED);
    }

    public void setDateordered(Date dateordered) {
        set(PROPERTY_DATEORDERED, dateordered);
    }

    public User getSalesrep() {
        return (User) get(PROPERTY_SALESREP);
    }

    public void setSalesrep(User salesrep) {
        set(PROPERTY_SALESREP, salesrep);
    }

    public Product getRechargeProduct() {
        return (Product) get(PROPERTY_RECHARGEPRODUCT);
    }

    public void setRechargeProduct(Product rechargeProduct) {
        set(PROPERTY_RECHARGEPRODUCT, rechargeProduct);
    }

    public Long getRechargeQtyinvoiced() {
        return (Long) get(PROPERTY_RECHARGEQTYINVOICED);
    }

    public void setRechargeQtyinvoiced(Long rechargeQtyinvoiced) {
        set(PROPERTY_RECHARGEQTYINVOICED, rechargeQtyinvoiced);
    }

    public BigDecimal getRechargeLinenetamt() {
        return (BigDecimal) get(PROPERTY_RECHARGELINENETAMT);
    }

    public void setRechargeLinenetamt(BigDecimal rechargeLinenetamt) {
        set(PROPERTY_RECHARGELINENETAMT, rechargeLinenetamt);
    }

    public Invoice getRechargeInvoice() {
        return (Invoice) get(PROPERTY_RECHARGEINVOICE);
    }

    public void setRechargeInvoice(Invoice rechargeInvoice) {
        set(PROPERTY_RECHARGEINVOICE, rechargeInvoice);
    }

    public Date getRechargeDateinvoiced() {
        return (Date) get(PROPERTY_RECHARGEDATEINVOICED);
    }

    public void setRechargeDateinvoiced(Date rechargeDateinvoiced) {
        set(PROPERTY_RECHARGEDATEINVOICED, rechargeDateinvoiced);
    }

    public BusinessPartner getRechargeBpartner() {
        return (BusinessPartner) get(PROPERTY_RECHARGEBPARTNER);
    }

    public void setRechargeBpartner(BusinessPartner rechargeBpartner) {
        set(PROPERTY_RECHARGEBPARTNER, rechargeBpartner);
    }

    public Order getRechargeOrder() {
        return (Order) get(PROPERTY_RECHARGEORDER);
    }

    public void setRechargeOrder(Order rechargeOrder) {
        set(PROPERTY_RECHARGEORDER, rechargeOrder);
    }

    public Boolean isRecharged() {
        return (Boolean) get(PROPERTY_ISRECHARGED);
    }

    public void setRecharged(Boolean isrecharged) {
        set(PROPERTY_ISRECHARGED, isrecharged);
    }

    public Boolean isNorecharge() {
        return (Boolean) get(PROPERTY_NORECHARGE);
    }

    public void setNorecharge(Boolean norecharge) {
        set(PROPERTY_NORECHARGE, norecharge);
    }

    public String getNorechargecomment() {
        return (String) get(PROPERTY_NORECHARGECOMMENT);
    }

    public void setNorechargecomment(String norechargecomment) {
        set(PROPERTY_NORECHARGECOMMENT, norechargecomment);
    }
}
