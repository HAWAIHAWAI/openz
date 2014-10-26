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
package org.openbravo.zsoft.smartui;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCategory;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity zssi_onhanqty (stored in table zssi_onhanqty).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Zssi_onhanqty extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zssi_onhanqty";
    public static final String ENTITY_NAME = "zssi_onhanqty";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_LOCATOR = "locator";
    public static final String PROPERTY_ATTRIBUTESETINSTANCE =
        "attributesetinstance";
    public static final String PROPERTY_UOM = "uom";
    public static final String PROPERTY_QTYONHAND = "qtyOnHand";
    public static final String PROPERTY_QTYRESERVED = "qtyreserved";
    public static final String PROPERTY_QTYINCOMMING = "qtyIncomming";
    public static final String PROPERTY_QTYORDERED = "qtyordered";
    public static final String PROPERTY_QTYINSALE = "qtyInsale";
    public static final String PROPERTY_QTYINFLOW = "qtyinflow";
    public static final String PROPERTY_QTYOUTFLOW = "qtyoutflow";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ZSSIONHANQTYOVERVIEW =
        "zssiOnhanqtyOverview";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";

    public Zssi_onhanqty() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public Locator getLocator() {
        return (Locator) get(PROPERTY_LOCATOR);
    }

    public void setLocator(Locator locator) {
        set(PROPERTY_LOCATOR, locator);
    }

    public AttributeSetInstance getAttributesetinstance() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETINSTANCE);
    }

    public void setAttributesetinstance(
        AttributeSetInstance attributesetinstance) {
        set(PROPERTY_ATTRIBUTESETINSTANCE, attributesetinstance);
    }

    public org.openbravo.model.common.uom.UOM getUom() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUom(org.openbravo.model.common.uom.UOM uom) {
        set(PROPERTY_UOM, uom);
    }

    public Long getQtyOnHand() {
        return (Long) get(PROPERTY_QTYONHAND);
    }

    public void setQtyOnHand(Long qtyOnHand) {
        set(PROPERTY_QTYONHAND, qtyOnHand);
    }

    public Long getQtyreserved() {
        return (Long) get(PROPERTY_QTYRESERVED);
    }

    public void setQtyreserved(Long qtyreserved) {
        set(PROPERTY_QTYRESERVED, qtyreserved);
    }

    public Long getQtyIncomming() {
        return (Long) get(PROPERTY_QTYINCOMMING);
    }

    public void setQtyIncomming(Long qtyIncomming) {
        set(PROPERTY_QTYINCOMMING, qtyIncomming);
    }

    public Long getQtyordered() {
        return (Long) get(PROPERTY_QTYORDERED);
    }

    public void setQtyordered(Long qtyordered) {
        set(PROPERTY_QTYORDERED, qtyordered);
    }

    public Long getQtyInsale() {
        return (Long) get(PROPERTY_QTYINSALE);
    }

    public void setQtyInsale(Long qtyInsale) {
        set(PROPERTY_QTYINSALE, qtyInsale);
    }

    public Long getQtyinflow() {
        return (Long) get(PROPERTY_QTYINFLOW);
    }

    public void setQtyinflow(Long qtyinflow) {
        set(PROPERTY_QTYINFLOW, qtyinflow);
    }

    public Long getQtyoutflow() {
        return (Long) get(PROPERTY_QTYOUTFLOW);
    }

    public void setQtyoutflow(Long qtyoutflow) {
        set(PROPERTY_QTYOUTFLOW, qtyoutflow);
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

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public org.openbravo.zsoft.smartui.zssi_onhanqty_overview getZssiOnhanqtyOverview() {
        return (org.openbravo.zsoft.smartui.zssi_onhanqty_overview) get(PROPERTY_ZSSIONHANQTYOVERVIEW);
    }

    public void setZssiOnhanqtyOverview(
        org.openbravo.zsoft.smartui.zssi_onhanqty_overview zssiOnhanqtyOverview) {
        set(PROPERTY_ZSSIONHANQTYOVERVIEW, zssiOnhanqtyOverview);
    }

    public ProductCategory getProductCategory() {
        return (ProductCategory) get(PROPERTY_PRODUCTCATEGORY);
    }

    public void setProductCategory(ProductCategory productCategory) {
        set(PROPERTY_PRODUCTCATEGORY, productCategory);
    }
}
