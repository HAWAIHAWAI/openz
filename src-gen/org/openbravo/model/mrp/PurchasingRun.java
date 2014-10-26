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
package org.openbravo.model.mrp;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Category;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCategory;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity MRPPurchasingRun (stored in table MRP_Run_Purchase).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class PurchasingRun extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "MRP_Run_Purchase";
    public static final String ENTITY_NAME = "MRPPurchasingRun";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DATEDOC = "dateDoc";
    public static final String PROPERTY_MRPPLANNER = "mRPPlanner";
    public static final String PROPERTY_VENDOR = "vendor";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_BPGROUP = "bPGroup";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_TIMEHORIZON = "timehorizon";
    public static final String PROPERTY_SECURITYMARGIN = "securitymargin";
    public static final String PROPERTY_SIMULATE = "simulate";
    public static final String PROPERTY_LAUNCHPO = "launchpo";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_MRPPURCHASINGRUNLINELIST =
        "mRPPurchasingRunLineList";

    public PurchasingRun() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_SECURITYMARGIN, (long) 0);
        setDefaultValue(PROPERTY_SIMULATE, false);
        setDefaultValue(PROPERTY_LAUNCHPO, false);
        setDefaultValue(PROPERTY_MRPPURCHASINGRUNLINELIST,
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Date getDateDoc() {
        return (Date) get(PROPERTY_DATEDOC);
    }

    public void setDateDoc(Date dateDoc) {
        set(PROPERTY_DATEDOC, dateDoc);
    }

    public Planner getMRPPlanner() {
        return (Planner) get(PROPERTY_MRPPLANNER);
    }

    public void setMRPPlanner(Planner mRPPlanner) {
        set(PROPERTY_MRPPLANNER, mRPPlanner);
    }

    public BusinessPartner getVendor() {
        return (BusinessPartner) get(PROPERTY_VENDOR);
    }

    public void setVendor(BusinessPartner vendor) {
        set(PROPERTY_VENDOR, vendor);
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

    public Long getTimehorizon() {
        return (Long) get(PROPERTY_TIMEHORIZON);
    }

    public void setTimehorizon(Long timehorizon) {
        set(PROPERTY_TIMEHORIZON, timehorizon);
    }

    public Long getSecuritymargin() {
        return (Long) get(PROPERTY_SECURITYMARGIN);
    }

    public void setSecuritymargin(Long securitymargin) {
        set(PROPERTY_SECURITYMARGIN, securitymargin);
    }

    public Boolean isSimulate() {
        return (Boolean) get(PROPERTY_SIMULATE);
    }

    public void setSimulate(Boolean simulate) {
        set(PROPERTY_SIMULATE, simulate);
    }

    public Boolean isLaunchpo() {
        return (Boolean) get(PROPERTY_LAUNCHPO);
    }

    public void setLaunchpo(Boolean launchpo) {
        set(PROPERTY_LAUNCHPO, launchpo);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    @SuppressWarnings("unchecked")
    public List<PurchasingRunLine> getMRPPurchasingRunLineList() {
        return (List<PurchasingRunLine>) get(PROPERTY_MRPPURCHASINGRUNLINELIST);
    }

    public void setMRPPurchasingRunLineList(
        List<PurchasingRunLine> mRPPurchasingRunLineList) {
        set(PROPERTY_MRPPURCHASINGRUNLINELIST, mRPPurchasingRunLineList);
    }
}
