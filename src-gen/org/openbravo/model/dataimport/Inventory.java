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
package org.openbravo.model.dataimport;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.materialmgmt.transaction.InventoryCount;
import org.openbravo.model.materialmgmt.transaction.InventoryCountLine;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity DataImportInventory (stored in table I_Inventory).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Inventory extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "I_Inventory";
    public static final String ENTITY_NAME = "DataImportInventory";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_LOT = "lot";
    public static final String PROPERTY_INVENTORYLINE = "inventoryLine";
    public static final String PROPERTY_LOCATOR = "locator";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_QTYBOOK = "qtyBook";
    public static final String PROPERTY_QTYCOUNT = "qtyCount";
    public static final String PROPERTY_SERNO = "serNo";
    public static final String PROPERTY_UPC = "uPC";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_WAREHOUSEVALUE = "warehouseValue";
    public static final String PROPERTY_X = "X";
    public static final String PROPERTY_Y = "Y";
    public static final String PROPERTY_Z = "Z";
    public static final String PROPERTY_LOCATORVALUE = "locatorValue";
    public static final String PROPERTY_ERRORMSG = "errorMsg";
    public static final String PROPERTY_ISIMPORTED = "isImported";
    public static final String PROPERTY_INVENTORY = "inventory";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_MOVEMENTDATE = "movementDate";

    public Inventory() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_ISIMPORTED, false);
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

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getLot() {
        return (String) get(PROPERTY_LOT);
    }

    public void setLot(String lot) {
        set(PROPERTY_LOT, lot);
    }

    public InventoryCountLine getInventoryLine() {
        return (InventoryCountLine) get(PROPERTY_INVENTORYLINE);
    }

    public void setInventoryLine(InventoryCountLine inventoryLine) {
        set(PROPERTY_INVENTORYLINE, inventoryLine);
    }

    public Locator getLocator() {
        return (Locator) get(PROPERTY_LOCATOR);
    }

    public void setLocator(Locator locator) {
        set(PROPERTY_LOCATOR, locator);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getQtyBook() {
        return (BigDecimal) get(PROPERTY_QTYBOOK);
    }

    public void setQtyBook(BigDecimal qtyBook) {
        set(PROPERTY_QTYBOOK, qtyBook);
    }

    public BigDecimal getQtyCount() {
        return (BigDecimal) get(PROPERTY_QTYCOUNT);
    }

    public void setQtyCount(BigDecimal qtyCount) {
        set(PROPERTY_QTYCOUNT, qtyCount);
    }

    public String getSerNo() {
        return (String) get(PROPERTY_SERNO);
    }

    public void setSerNo(String serNo) {
        set(PROPERTY_SERNO, serNo);
    }

    public String getUPC() {
        return (String) get(PROPERTY_UPC);
    }

    public void setUPC(String uPC) {
        set(PROPERTY_UPC, uPC);
    }

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
    }

    public String getWarehouseValue() {
        return (String) get(PROPERTY_WAREHOUSEVALUE);
    }

    public void setWarehouseValue(String warehouseValue) {
        set(PROPERTY_WAREHOUSEVALUE, warehouseValue);
    }

    public String getX() {
        return (String) get(PROPERTY_X);
    }

    public void setX(String X) {
        set(PROPERTY_X, X);
    }

    public String getY() {
        return (String) get(PROPERTY_Y);
    }

    public void setY(String Y) {
        set(PROPERTY_Y, Y);
    }

    public String getZ() {
        return (String) get(PROPERTY_Z);
    }

    public void setZ(String Z) {
        set(PROPERTY_Z, Z);
    }

    public String getLocatorValue() {
        return (String) get(PROPERTY_LOCATORVALUE);
    }

    public void setLocatorValue(String locatorValue) {
        set(PROPERTY_LOCATORVALUE, locatorValue);
    }

    public String getErrorMsg() {
        return (String) get(PROPERTY_ERRORMSG);
    }

    public void setErrorMsg(String errorMsg) {
        set(PROPERTY_ERRORMSG, errorMsg);
    }

    public Boolean isImported() {
        return (Boolean) get(PROPERTY_ISIMPORTED);
    }

    public void setImported(Boolean isImported) {
        set(PROPERTY_ISIMPORTED, isImported);
    }

    public InventoryCount getInventory() {
        return (InventoryCount) get(PROPERTY_INVENTORY);
    }

    public void setInventory(InventoryCount inventory) {
        set(PROPERTY_INVENTORY, inventory);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public Date getMovementDate() {
        return (Date) get(PROPERTY_MOVEMENTDATE);
    }

    public void setMovementDate(Date movementDate) {
        set(PROPERTY_MOVEMENTDATE, movementDate);
    }
}
