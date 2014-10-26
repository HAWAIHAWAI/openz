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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCategory;
import org.openbravo.model.project.ProjectTask;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity mrp_criticalitems_v (stored in table mrp_criticalitems_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Mrpcriticalitemsv extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "mrp_criticalitems_v";
    public static final String ENTITY_NAME = "mrp_criticalitems_v";
    public static final String PROPERTY_MRPINOUTPLANV = "mRPInoutplanV";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_ESTIMATEDSTOCKQTY = "estimatedStockQty";
    public static final String PROPERTY_DOCUMENTTYPE = "documenttype";
    public static final String PROPERTY_ORDERLINE = "orderline";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_MOVEMENTQTY = "movementqty";
    public static final String PROPERTY_PLANNEDDATE = "planneddate";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_ZSSIONHANQTYOVERVIEW =
        "zssiOnhanqtyOverview";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_UOM = "uom";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ISACTIVE = "isactive";

    public Mrpcriticalitemsv() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public Mrpinoutplanv getMRPInoutplanV() {
        return (Mrpinoutplanv) get(PROPERTY_MRPINOUTPLANV);
    }

    public void setMRPInoutplanV(Mrpinoutplanv mRPInoutplanV) {
        set(PROPERTY_MRPINOUTPLANV, mRPInoutplanV);
    }

    public Organization getOrg() {
        return (Organization) get(PROPERTY_ORG);
    }

    public void setOrg(Organization org) {
        set(PROPERTY_ORG, org);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
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

    public Long getEstimatedStockQty() {
        return (Long) get(PROPERTY_ESTIMATEDSTOCKQTY);
    }

    public void setEstimatedStockQty(Long estimatedStockQty) {
        set(PROPERTY_ESTIMATEDSTOCKQTY, estimatedStockQty);
    }

    public String getDocumenttype() {
        return (String) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumenttype(String documenttype) {
        set(PROPERTY_DOCUMENTTYPE, documenttype);
    }

    public OrderLine getOrderline() {
        return (OrderLine) get(PROPERTY_ORDERLINE);
    }

    public void setOrderline(OrderLine orderline) {
        set(PROPERTY_ORDERLINE, orderline);
    }

    public ProjectTask getProjecttask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjecttask(ProjectTask projecttask) {
        set(PROPERTY_PROJECTTASK, projecttask);
    }

    public Long getMovementqty() {
        return (Long) get(PROPERTY_MOVEMENTQTY);
    }

    public void setMovementqty(Long movementqty) {
        set(PROPERTY_MOVEMENTQTY, movementqty);
    }

    public Date getPlanneddate() {
        return (Date) get(PROPERTY_PLANNEDDATE);
    }

    public void setPlanneddate(Date planneddate) {
        set(PROPERTY_PLANNEDDATE, planneddate);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
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

    public org.openbravo.model.common.uom.UOM getUom() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUom(org.openbravo.model.common.uom.UOM uom) {
        set(PROPERTY_UOM, uom);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ISACTIVE);
    }

    public void setActive(Boolean isactive) {
        set(PROPERTY_ISACTIVE, isactive);
    }
}
