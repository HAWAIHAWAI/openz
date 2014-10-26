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
package org.openbravo.model.common.plm;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.mrp.Planner;
import org.openbravo.model.mrp.PlanningMethod;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity ProductOrg (stored in table M_Product_Org).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ProductOrg extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Product_Org";
    public static final String ENTITY_NAME = "ProductOrg";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_LOCATOR = "locator";
    public static final String PROPERTY_CAPACITY = "capacity";
    public static final String PROPERTY_DELAYMIN = "delaymin";
    public static final String PROPERTY_MRPPLANNER = "mRPPlanner";
    public static final String PROPERTY_MRPPLANNINGMETHOD = "mRPPlanningmethod";
    public static final String PROPERTY_QTYMAX = "qtymax";
    public static final String PROPERTY_QTYMIN = "qtymin";
    public static final String PROPERTY_QTYSTD = "qtystd";
    public static final String PROPERTY_QTYTYPE = "qtytype";
    public static final String PROPERTY_STOCKMIN = "stockmin";
    public static final String PROPERTY_ABC = "abc";
    public static final String PROPERTY_ISVENDORRECEIPTLOCATOR =
        "isvendorreceiptlocator";
    public static final String PROPERTY_QTYOPTIMAL = "qtyoptimal";

    public ProductOrg() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISVENDORRECEIPTLOCATOR, true);
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

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Locator getLocator() {
        return (Locator) get(PROPERTY_LOCATOR);
    }

    public void setLocator(Locator locator) {
        set(PROPERTY_LOCATOR, locator);
    }

    public BigDecimal getCapacity() {
        return (BigDecimal) get(PROPERTY_CAPACITY);
    }

    public void setCapacity(BigDecimal capacity) {
        set(PROPERTY_CAPACITY, capacity);
    }

    public BigDecimal getDelaymin() {
        return (BigDecimal) get(PROPERTY_DELAYMIN);
    }

    public void setDelaymin(BigDecimal delaymin) {
        set(PROPERTY_DELAYMIN, delaymin);
    }

    public Planner getMRPPlanner() {
        return (Planner) get(PROPERTY_MRPPLANNER);
    }

    public void setMRPPlanner(Planner mRPPlanner) {
        set(PROPERTY_MRPPLANNER, mRPPlanner);
    }

    public PlanningMethod getMRPPlanningmethod() {
        return (PlanningMethod) get(PROPERTY_MRPPLANNINGMETHOD);
    }

    public void setMRPPlanningmethod(PlanningMethod mRPPlanningmethod) {
        set(PROPERTY_MRPPLANNINGMETHOD, mRPPlanningmethod);
    }

    public BigDecimal getQtymax() {
        return (BigDecimal) get(PROPERTY_QTYMAX);
    }

    public void setQtymax(BigDecimal qtymax) {
        set(PROPERTY_QTYMAX, qtymax);
    }

    public BigDecimal getQtymin() {
        return (BigDecimal) get(PROPERTY_QTYMIN);
    }

    public void setQtymin(BigDecimal qtymin) {
        set(PROPERTY_QTYMIN, qtymin);
    }

    public BigDecimal getQtystd() {
        return (BigDecimal) get(PROPERTY_QTYSTD);
    }

    public void setQtystd(BigDecimal qtystd) {
        set(PROPERTY_QTYSTD, qtystd);
    }

    public String getQtytype() {
        return (String) get(PROPERTY_QTYTYPE);
    }

    public void setQtytype(String qtytype) {
        set(PROPERTY_QTYTYPE, qtytype);
    }

    public Long getStockmin() {
        return (Long) get(PROPERTY_STOCKMIN);
    }

    public void setStockmin(Long stockmin) {
        set(PROPERTY_STOCKMIN, stockmin);
    }

    public String getAbc() {
        return (String) get(PROPERTY_ABC);
    }

    public void setAbc(String abc) {
        set(PROPERTY_ABC, abc);
    }

    public Boolean isVendorreceiptlocator() {
        return (Boolean) get(PROPERTY_ISVENDORRECEIPTLOCATOR);
    }

    public void setVendorreceiptlocator(Boolean isvendorreceiptlocator) {
        set(PROPERTY_ISVENDORRECEIPTLOCATOR, isvendorreceiptlocator);
    }

    public Long getQtyoptimal() {
        return (Long) get(PROPERTY_QTYOPTIMAL);
    }

    public void setQtyoptimal(Long qtyoptimal) {
        set(PROPERTY_QTYOPTIMAL, qtyoptimal);
    }
}
