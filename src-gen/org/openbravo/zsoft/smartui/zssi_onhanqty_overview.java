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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCategory;
import org.openbravo.model.mrp.Mrpinoutplanv;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity zssi_onhanqty_overview (stored in table zssi_onhanqty_overview).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class zssi_onhanqty_overview extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zssi_onhanqty_overview";
    public static final String ENTITY_NAME = "zssi_onhanqty_overview";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_ATTRIBUTESETINSTANCE =
        "attributesetinstance";
    public static final String PROPERTY_UOM = "uom";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_QTYONHAND = "qtyonhand";
    public static final String PROPERTY_QTYRESERVED = "qtyreserved";
    public static final String PROPERTY_QTYINCOMMING = "qtyincomming";
    public static final String PROPERTY_QTYORDERED = "qtyordered";
    public static final String PROPERTY_QTYINSALE = "qtyinsale";
    public static final String PROPERTY_QTYINFLOW = "qtyinflow";
    public static final String PROPERTY_QTYOUTFLOW = "qtyoutflow";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_MRPINOUTPLANVLIST = "mrpInoutplanVList";
    public static final String PROPERTY_ZSSIONHANQTYLIST = "zssiOnhanqtyList";

    public zssi_onhanqty_overview() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_MRPINOUTPLANVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSSIONHANQTYLIST, new ArrayList<Object>());
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

    public ProductCategory getProductCategory() {
        return (ProductCategory) get(PROPERTY_PRODUCTCATEGORY);
    }

    public void setProductCategory(ProductCategory productCategory) {
        set(PROPERTY_PRODUCTCATEGORY, productCategory);
    }

    public Long getQtyonhand() {
        return (Long) get(PROPERTY_QTYONHAND);
    }

    public void setQtyonhand(Long qtyonhand) {
        set(PROPERTY_QTYONHAND, qtyonhand);
    }

    public Long getQtyreserved() {
        return (Long) get(PROPERTY_QTYRESERVED);
    }

    public void setQtyreserved(Long qtyreserved) {
        set(PROPERTY_QTYRESERVED, qtyreserved);
    }

    public Long getQtyincomming() {
        return (Long) get(PROPERTY_QTYINCOMMING);
    }

    public void setQtyincomming(Long qtyincomming) {
        set(PROPERTY_QTYINCOMMING, qtyincomming);
    }

    public Long getQtyordered() {
        return (Long) get(PROPERTY_QTYORDERED);
    }

    public void setQtyordered(Long qtyordered) {
        set(PROPERTY_QTYORDERED, qtyordered);
    }

    public Long getQtyinsale() {
        return (Long) get(PROPERTY_QTYINSALE);
    }

    public void setQtyinsale(Long qtyinsale) {
        set(PROPERTY_QTYINSALE, qtyinsale);
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

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    @SuppressWarnings("unchecked")
    public List<Mrpinoutplanv> getMrpInoutplanVList() {
        return (List<Mrpinoutplanv>) get(PROPERTY_MRPINOUTPLANVLIST);
    }

    public void setMrpInoutplanVList(List<Mrpinoutplanv> mrpInoutplanVList) {
        set(PROPERTY_MRPINOUTPLANVLIST, mrpInoutplanVList);
    }

    @SuppressWarnings("unchecked")
    public List<Zssi_onhanqty> getZssiOnhanqtyList() {
        return (List<Zssi_onhanqty>) get(PROPERTY_ZSSIONHANQTYLIST);
    }

    public void setZssiOnhanqtyList(List<Zssi_onhanqty> zssiOnhanqtyList) {
        set(PROPERTY_ZSSIONHANQTYLIST, zssiOnhanqtyList);
    }
}
