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
package org.zsoft.ecommerce;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity zse_shop (stored in table zse_shop).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class zse_shop extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zse_shop";
    public static final String ENTITY_NAME = "zse_shop";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_URL = "url";
    public static final String PROPERTY_ZSEPRODUCTSHOPLIST =
        "zseProductShopList";
    public static final String PROPERTY_ZSEECOMMERCEGRANTLIST =
        "zseEcommercegrantList";
    public static final String PROPERTY_ZSEWAREHOUSESHOPLIST =
        "zseWarehouseShopList";

    public zse_shop() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ZSEPRODUCTSHOPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSEECOMMERCEGRANTLIST, new ArrayList<Object>());
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

    public void setActive(Boolean isactive) {
        set(PROPERTY_ISACTIVE, isactive);
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

    public String getUrl() {
        return (String) get(PROPERTY_URL);
    }

    public void setUrl(String url) {
        set(PROPERTY_URL, url);
    }

    @SuppressWarnings("unchecked")
    public List<Zse_product_shop> getZseProductShopList() {
        return (List<Zse_product_shop>) get(PROPERTY_ZSEPRODUCTSHOPLIST);
    }

    public void setZseProductShopList(List<Zse_product_shop> zseProductShopList) {
        set(PROPERTY_ZSEPRODUCTSHOPLIST, zseProductShopList);
    }

    @SuppressWarnings("unchecked")
    public List<Zse_ecommercegrant> getZseEcommercegrantList() {
        return (List<Zse_ecommercegrant>) get(PROPERTY_ZSEECOMMERCEGRANTLIST);
    }

    public void setZseEcommercegrantList(
        List<Zse_ecommercegrant> zseEcommercegrantList) {
        set(PROPERTY_ZSEECOMMERCEGRANTLIST, zseEcommercegrantList);
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
