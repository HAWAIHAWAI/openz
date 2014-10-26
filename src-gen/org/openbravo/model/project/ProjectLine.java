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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCategory;
import org.openbravo.model.financialmgmt.tax.TaxRate;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity ProjectLine (stored in table C_ProjectLine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ProjectLine extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_ProjectLine";
    public static final String ENTITY_NAME = "ProjectLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PLANNEDQTY = "plannedQty";
    public static final String PROPERTY_PLANNEDPRICE = "plannedPrice";
    public static final String PROPERTY_PLANNEDAMT = "plannedAmt";
    public static final String PROPERTY_PLANNEDMARGINAMT = "plannedMarginAmt";
    public static final String PROPERTY_COMMITTEDAMT = "committedAmt";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_INVOICEDAMT = "invoicedAmt";
    public static final String PROPERTY_INVOICEDQTY = "invoicedQty";
    public static final String PROPERTY_COMMITTEDQTY = "committedQty";
    public static final String PROPERTY_PROJECTISSUE = "projectIssue";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_ORDERPO = "orderPO";
    public static final String PROPERTY_ISPRINTED = "isPrinted";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_DOPRICING = "doPricing";
    public static final String PROPERTY_PLANNEDPOPRICE = "plannedpoprice";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_PRODUCTDESCRIPTION =
        "productDescription";
    public static final String PROPERTY_PRODUCTNAME = "productName";
    public static final String PROPERTY_PRODUCTVALUE = "productValue";

    public ProjectLine() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PLANNEDQTY, new BigDecimal(1));
        setDefaultValue(PROPERTY_PLANNEDAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_PLANNEDMARGINAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_COMMITTEDAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_INVOICEDAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_INVOICEDQTY, new BigDecimal(0));
        setDefaultValue(PROPERTY_COMMITTEDQTY, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISPRINTED, true);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_DOPRICING, false);
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

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public BigDecimal getPlannedQty() {
        return (BigDecimal) get(PROPERTY_PLANNEDQTY);
    }

    public void setPlannedQty(BigDecimal plannedQty) {
        set(PROPERTY_PLANNEDQTY, plannedQty);
    }

    public BigDecimal getPlannedPrice() {
        return (BigDecimal) get(PROPERTY_PLANNEDPRICE);
    }

    public void setPlannedPrice(BigDecimal plannedPrice) {
        set(PROPERTY_PLANNEDPRICE, plannedPrice);
    }

    public BigDecimal getPlannedAmt() {
        return (BigDecimal) get(PROPERTY_PLANNEDAMT);
    }

    public void setPlannedAmt(BigDecimal plannedAmt) {
        set(PROPERTY_PLANNEDAMT, plannedAmt);
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

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public ProductCategory getProductCategory() {
        return (ProductCategory) get(PROPERTY_PRODUCTCATEGORY);
    }

    public void setProductCategory(ProductCategory productCategory) {
        set(PROPERTY_PRODUCTCATEGORY, productCategory);
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

    public BigDecimal getCommittedQty() {
        return (BigDecimal) get(PROPERTY_COMMITTEDQTY);
    }

    public void setCommittedQty(BigDecimal committedQty) {
        set(PROPERTY_COMMITTEDQTY, committedQty);
    }

    public ProjectIssue getProjectIssue() {
        return (ProjectIssue) get(PROPERTY_PROJECTISSUE);
    }

    public void setProjectIssue(ProjectIssue projectIssue) {
        set(PROPERTY_PROJECTISSUE, projectIssue);
    }

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

    public Order getOrderPO() {
        return (Order) get(PROPERTY_ORDERPO);
    }

    public void setOrderPO(Order orderPO) {
        set(PROPERTY_ORDERPO, orderPO);
    }

    public Boolean isPrinted() {
        return (Boolean) get(PROPERTY_ISPRINTED);
    }

    public void setPrinted(Boolean isPrinted) {
        set(PROPERTY_ISPRINTED, isPrinted);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Boolean isDoPricing() {
        return (Boolean) get(PROPERTY_DOPRICING);
    }

    public void setDoPricing(Boolean doPricing) {
        set(PROPERTY_DOPRICING, doPricing);
    }

    public BigDecimal getPlannedpoprice() {
        return (BigDecimal) get(PROPERTY_PLANNEDPOPRICE);
    }

    public void setPlannedpoprice(BigDecimal plannedpoprice) {
        set(PROPERTY_PLANNEDPOPRICE, plannedpoprice);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public String getProductDescription() {
        return (String) get(PROPERTY_PRODUCTDESCRIPTION);
    }

    public void setProductDescription(String productDescription) {
        set(PROPERTY_PRODUCTDESCRIPTION, productDescription);
    }

    public String getProductName() {
        return (String) get(PROPERTY_PRODUCTNAME);
    }

    public void setProductName(String productName) {
        set(PROPERTY_PRODUCTNAME, productName);
    }

    public String getProductValue() {
        return (String) get(PROPERTY_PRODUCTVALUE);
    }

    public void setProductValue(String productValue) {
        set(PROPERTY_PRODUCTVALUE, productValue);
    }
}
