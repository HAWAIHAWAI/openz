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
package org.openbravo.model.sales;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Category;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCategory;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity SalesCommissionLine (stored in table C_CommissionLine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class CommissionLine extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_CommissionLine";
    public static final String ENTITY_NAME = "SalesCommissionLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_COMMISSION = "commission";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_AMTSUBTRACT = "amtSubtract";
    public static final String PROPERTY_AMTMULTIPLIER = "amtMultiplier";
    public static final String PROPERTY_QTYSUBTRACT = "qtySubtract";
    public static final String PROPERTY_QTYMULTIPLIER = "qtyMultiplier";
    public static final String PROPERTY_ISPOSITIVEONLY = "isPositiveOnly";
    public static final String PROPERTY_COMMISSIONORDERS = "commissionOrders";
    public static final String PROPERTY_ORG17 = "org17";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_BPGROUP = "bPGroup";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_SALESREGION = "salesRegion";

    public CommissionLine() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_AMTSUBTRACT, new BigDecimal(0));
        setDefaultValue(PROPERTY_AMTMULTIPLIER, new BigDecimal(0));
        setDefaultValue(PROPERTY_QTYSUBTRACT, new BigDecimal(0));
        setDefaultValue(PROPERTY_QTYMULTIPLIER, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISPOSITIVEONLY, false);
        setDefaultValue(PROPERTY_COMMISSIONORDERS, false);
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

    public Commission getCommission() {
        return (Commission) get(PROPERTY_COMMISSION);
    }

    public void setCommission(Commission commission) {
        set(PROPERTY_COMMISSION, commission);
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

    public BigDecimal getAmtSubtract() {
        return (BigDecimal) get(PROPERTY_AMTSUBTRACT);
    }

    public void setAmtSubtract(BigDecimal amtSubtract) {
        set(PROPERTY_AMTSUBTRACT, amtSubtract);
    }

    public BigDecimal getAmtMultiplier() {
        return (BigDecimal) get(PROPERTY_AMTMULTIPLIER);
    }

    public void setAmtMultiplier(BigDecimal amtMultiplier) {
        set(PROPERTY_AMTMULTIPLIER, amtMultiplier);
    }

    public BigDecimal getQtySubtract() {
        return (BigDecimal) get(PROPERTY_QTYSUBTRACT);
    }

    public void setQtySubtract(BigDecimal qtySubtract) {
        set(PROPERTY_QTYSUBTRACT, qtySubtract);
    }

    public BigDecimal getQtyMultiplier() {
        return (BigDecimal) get(PROPERTY_QTYMULTIPLIER);
    }

    public void setQtyMultiplier(BigDecimal qtyMultiplier) {
        set(PROPERTY_QTYMULTIPLIER, qtyMultiplier);
    }

    public Boolean isPositiveOnly() {
        return (Boolean) get(PROPERTY_ISPOSITIVEONLY);
    }

    public void setPositiveOnly(Boolean isPositiveOnly) {
        set(PROPERTY_ISPOSITIVEONLY, isPositiveOnly);
    }

    public Boolean isCommissionOrders() {
        return (Boolean) get(PROPERTY_COMMISSIONORDERS);
    }

    public void setCommissionOrders(Boolean commissionOrders) {
        set(PROPERTY_COMMISSIONORDERS, commissionOrders);
    }

    public Organization getOrg17() {
        return (Organization) get(PROPERTY_ORG17);
    }

    public void setOrg17(Organization org17) {
        set(PROPERTY_ORG17, org17);
    }

    public ProductCategory getProductCategory() {
        return (ProductCategory) get(PROPERTY_PRODUCTCATEGORY);
    }

    public void setProductCategory(ProductCategory productCategory) {
        set(PROPERTY_PRODUCTCATEGORY, productCategory);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Category getBPGroup() {
        return (Category) get(PROPERTY_BPGROUP);
    }

    public void setBPGroup(Category bPGroup) {
        set(PROPERTY_BPGROUP, bPGroup);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public SalesRegion getSalesRegion() {
        return (SalesRegion) get(PROPERTY_SALESREGION);
    }

    public void setSalesRegion(SalesRegion salesRegion) {
        set(PROPERTY_SALESREGION, salesRegion);
    }
}
