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
package org.openbravo.model.common.enterprise;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.geography.Location;

import org.zsoft.ecommerce.Zse_warehouse_shop;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity Warehouse (stored in table M_Warehouse).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Warehouse extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Warehouse";
    public static final String ENTITY_NAME = "Warehouse";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_LOCATION = "location";
    public static final String PROPERTY_SEPARATOR = "separator";
    public static final String PROPERTY_ISSHIPPER = "isShipper";
    public static final String PROPERTY_SHIPPERCODE = "shippercode";
    public static final String PROPERTY_FROMDOCUMENTNO = "fromDocumentNo";
    public static final String PROPERTY_TODOCUMENTNO = "toDocumentNo";
    public static final String PROPERTY_ISBLOCKED = "isblocked";
    public static final String PROPERTY_WAREHOUSESHIPPERLIST =
        "warehouseShipperList";
    public static final String PROPERTY_WAREHOUSEACCOUNTSLIST =
        "warehouseAccountsList";
    public static final String PROPERTY_LOCATORLIST = "locatorList";
    public static final String PROPERTY_ZSEWAREHOUSESHOPLIST =
        "zseWarehouseShopList";

    public Warehouse() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_SEPARATOR, "*");
        setDefaultValue(PROPERTY_ISSHIPPER, false);
        setDefaultValue(PROPERTY_ISBLOCKED, false);
        setDefaultValue(PROPERTY_WAREHOUSESHIPPERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_WAREHOUSEACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LOCATORLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSEWAREHOUSESHOPLIST, new ArrayList<Object>());
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

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
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

    public Location getLocation() {
        return (Location) get(PROPERTY_LOCATION);
    }

    public void setLocation(Location location) {
        set(PROPERTY_LOCATION, location);
    }

    public String getSeparator() {
        return (String) get(PROPERTY_SEPARATOR);
    }

    public void setSeparator(String separator) {
        set(PROPERTY_SEPARATOR, separator);
    }

    public Boolean isShipper() {
        return (Boolean) get(PROPERTY_ISSHIPPER);
    }

    public void setShipper(Boolean isShipper) {
        set(PROPERTY_ISSHIPPER, isShipper);
    }

    public String getShippercode() {
        return (String) get(PROPERTY_SHIPPERCODE);
    }

    public void setShippercode(String shippercode) {
        set(PROPERTY_SHIPPERCODE, shippercode);
    }

    public Long getFromDocumentNo() {
        return (Long) get(PROPERTY_FROMDOCUMENTNO);
    }

    public void setFromDocumentNo(Long fromDocumentNo) {
        set(PROPERTY_FROMDOCUMENTNO, fromDocumentNo);
    }

    public Long getToDocumentNo() {
        return (Long) get(PROPERTY_TODOCUMENTNO);
    }

    public void setToDocumentNo(Long toDocumentNo) {
        set(PROPERTY_TODOCUMENTNO, toDocumentNo);
    }

    public Boolean isBlocked() {
        return (Boolean) get(PROPERTY_ISBLOCKED);
    }

    public void setBlocked(Boolean isblocked) {
        set(PROPERTY_ISBLOCKED, isblocked);
    }

    @SuppressWarnings("unchecked")
    public List<WarehouseShipper> getWarehouseShipperList() {
        return (List<WarehouseShipper>) get(PROPERTY_WAREHOUSESHIPPERLIST);
    }

    public void setWarehouseShipperList(
        List<WarehouseShipper> warehouseShipperList) {
        set(PROPERTY_WAREHOUSESHIPPERLIST, warehouseShipperList);
    }

    @SuppressWarnings("unchecked")
    public List<WarehouseAccounts> getWarehouseAccountsList() {
        return (List<WarehouseAccounts>) get(PROPERTY_WAREHOUSEACCOUNTSLIST);
    }

    public void setWarehouseAccountsList(
        List<WarehouseAccounts> warehouseAccountsList) {
        set(PROPERTY_WAREHOUSEACCOUNTSLIST, warehouseAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<Locator> getLocatorList() {
        return (List<Locator>) get(PROPERTY_LOCATORLIST);
    }

    public void setLocatorList(List<Locator> locatorList) {
        set(PROPERTY_LOCATORLIST, locatorList);
    }

    @SuppressWarnings("unchecked")
    public List<Zse_warehouse_shop> getZseWarehouseShopList() {
        return (List<Zse_warehouse_shop>) get(PROPERTY_ZSEWAREHOUSESHOPLIST);
    }

    public void setZseWarehouseShopList(
        List<Zse_warehouse_shop> zseWarehouseShopList) {
        set(PROPERTY_ZSEWAREHOUSESHOPLIST, zseWarehouseShopList);
    }
}
