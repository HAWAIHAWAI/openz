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
package org.openbravo.model.materialmgmt.transaction;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.manufacturing.cost.CostcenterVersion;
import org.openbravo.model.manufacturing.transaction.ProductionRunEmployee;
import org.openbravo.model.manufacturing.transaction.WorkRequirementOperation;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity MaterialMgmtProductionPlan (stored in table M_ProductionPlan).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ProductionPlan extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_ProductionPlan";
    public static final String ENTITY_NAME = "MaterialMgmtProductionPlan";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PRODUCTION = "production";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_PRODUCTIONQTY = "productionQty";
    public static final String PROPERTY_LOCATOR = "locator";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_CONVERSIONRATE = "conversionrate";
    public static final String PROPERTY_COSTCENTERUSE = "costcenteruse";
    public static final String PROPERTY_WRPHASE = "wrphase";
    public static final String PROPERTY_NEEDEDQUANTITY = "neededquantity";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_REJECTEDQUANTITY = "rejectedquantity";
    public static final String PROPERTY_SECONDARYQTY = "secondaryqty";
    public static final String PROPERTY_SECONDARYUNIT = "secondaryunit";
    public static final String PROPERTY_USEDMATERIAL = "usedmaterial";
    public static final String PROPERTY_CALCCOST = "calccost";
    public static final String PROPERTY_COSTCENTERVERSION = "costcenterVersion";
    public static final String PROPERTY_OUTSOURCED = "outsourced";
    public static final String PROPERTY_MANUFACTURINGPRODUCTIONRUNEMPLOYEELIST =
        "manufacturingProductionRunEmployeeList";

    public ProductionPlan() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_USEDMATERIAL, false);
        setDefaultValue(PROPERTY_OUTSOURCED, false);
        setDefaultValue(PROPERTY_MANUFACTURINGPRODUCTIONRUNEMPLOYEELIST,
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

    public ProductionTransaction getProduction() {
        return (ProductionTransaction) get(PROPERTY_PRODUCTION);
    }

    public void setProduction(ProductionTransaction production) {
        set(PROPERTY_PRODUCTION, production);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getProductionQty() {
        return (BigDecimal) get(PROPERTY_PRODUCTIONQTY);
    }

    public void setProductionQty(BigDecimal productionQty) {
        set(PROPERTY_PRODUCTIONQTY, productionQty);
    }

    public Locator getLocator() {
        return (Locator) get(PROPERTY_LOCATOR);
    }

    public void setLocator(Locator locator) {
        set(PROPERTY_LOCATOR, locator);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public BigDecimal getConversionrate() {
        return (BigDecimal) get(PROPERTY_CONVERSIONRATE);
    }

    public void setConversionrate(BigDecimal conversionrate) {
        set(PROPERTY_CONVERSIONRATE, conversionrate);
    }

    public BigDecimal getCostcenteruse() {
        return (BigDecimal) get(PROPERTY_COSTCENTERUSE);
    }

    public void setCostcenteruse(BigDecimal costcenteruse) {
        set(PROPERTY_COSTCENTERUSE, costcenteruse);
    }

    public WorkRequirementOperation getWrphase() {
        return (WorkRequirementOperation) get(PROPERTY_WRPHASE);
    }

    public void setWrphase(WorkRequirementOperation wrphase) {
        set(PROPERTY_WRPHASE, wrphase);
    }

    public Long getNeededquantity() {
        return (Long) get(PROPERTY_NEEDEDQUANTITY);
    }

    public void setNeededquantity(Long neededquantity) {
        set(PROPERTY_NEEDEDQUANTITY, neededquantity);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Long getRejectedquantity() {
        return (Long) get(PROPERTY_REJECTEDQUANTITY);
    }

    public void setRejectedquantity(Long rejectedquantity) {
        set(PROPERTY_REJECTEDQUANTITY, rejectedquantity);
    }

    public BigDecimal getSecondaryqty() {
        return (BigDecimal) get(PROPERTY_SECONDARYQTY);
    }

    public void setSecondaryqty(BigDecimal secondaryqty) {
        set(PROPERTY_SECONDARYQTY, secondaryqty);
    }

    public String getSecondaryunit() {
        return (String) get(PROPERTY_SECONDARYUNIT);
    }

    public void setSecondaryunit(String secondaryunit) {
        set(PROPERTY_SECONDARYUNIT, secondaryunit);
    }

    public Boolean isUsedmaterial() {
        return (Boolean) get(PROPERTY_USEDMATERIAL);
    }

    public void setUsedmaterial(Boolean usedmaterial) {
        set(PROPERTY_USEDMATERIAL, usedmaterial);
    }

    public BigDecimal getCalccost() {
        return (BigDecimal) get(PROPERTY_CALCCOST);
    }

    public void setCalccost(BigDecimal calccost) {
        set(PROPERTY_CALCCOST, calccost);
    }

    public CostcenterVersion getCostcenterVersion() {
        return (CostcenterVersion) get(PROPERTY_COSTCENTERVERSION);
    }

    public void setCostcenterVersion(CostcenterVersion costcenterVersion) {
        set(PROPERTY_COSTCENTERVERSION, costcenterVersion);
    }

    public Boolean isOutsourced() {
        return (Boolean) get(PROPERTY_OUTSOURCED);
    }

    public void setOutsourced(Boolean outsourced) {
        set(PROPERTY_OUTSOURCED, outsourced);
    }

    @SuppressWarnings("unchecked")
    public List<ProductionRunEmployee> getManufacturingProductionRunEmployeeList() {
        return (List<ProductionRunEmployee>) get(PROPERTY_MANUFACTURINGPRODUCTIONRUNEMPLOYEELIST);
    }

    public void setManufacturingProductionRunEmployeeList(
        List<ProductionRunEmployee> manufacturingProductionRunEmployeeList) {
        set(PROPERTY_MANUFACTURINGPRODUCTIONRUNEMPLOYEELIST,
            manufacturingProductionRunEmployeeList);
    }
}
