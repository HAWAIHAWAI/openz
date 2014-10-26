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
package org.openbravo.model.pricing.volumediscount;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity PricingVolumeDiscount (stored in table M_Rappel).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class VolumeDiscount extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Rappel";
    public static final String ENTITY_NAME = "PricingVolumeDiscount";
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
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_INCLUDEPRODUCT = "includeProduct";
    public static final String PROPERTY_INCLUDEPRODUCTCATEGORY =
        "includeProductCategory";
    public static final String PROPERTY_SCALED = "scaled";
    public static final String PROPERTY_PRICINGVOLUMEDISCOUNTSCALELIST =
        "pricingVolumeDiscountScaleList";
    public static final String PROPERTY_PRICINGVOLUMEDISCOUNTPRODUCTLIST =
        "pricingVolumeDiscountProductList";
    public static final String PROPERTY_PRICINGVOLUMEDISCOUNTPRODUCTCATEGORYLIST =
        "pricingVolumeDiscountProductCategoryList";

    public VolumeDiscount() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_INCLUDEPRODUCT, "N");
        setDefaultValue(PROPERTY_INCLUDEPRODUCTCATEGORY, "N");
        setDefaultValue(PROPERTY_SCALED, true);
        setDefaultValue(PROPERTY_PRICINGVOLUMEDISCOUNTSCALELIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGVOLUMEDISCOUNTPRODUCTLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGVOLUMEDISCOUNTPRODUCTCATEGORYLIST,
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

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public String getIncludeProduct() {
        return (String) get(PROPERTY_INCLUDEPRODUCT);
    }

    public void setIncludeProduct(String includeProduct) {
        set(PROPERTY_INCLUDEPRODUCT, includeProduct);
    }

    public String getIncludeProductCategory() {
        return (String) get(PROPERTY_INCLUDEPRODUCTCATEGORY);
    }

    public void setIncludeProductCategory(String includeProductCategory) {
        set(PROPERTY_INCLUDEPRODUCTCATEGORY, includeProductCategory);
    }

    public Boolean isScaled() {
        return (Boolean) get(PROPERTY_SCALED);
    }

    public void setScaled(Boolean scaled) {
        set(PROPERTY_SCALED, scaled);
    }

    @SuppressWarnings("unchecked")
    public List<DiscountScale> getPricingVolumeDiscountScaleList() {
        return (List<DiscountScale>) get(PROPERTY_PRICINGVOLUMEDISCOUNTSCALELIST);
    }

    public void setPricingVolumeDiscountScaleList(
        List<DiscountScale> pricingVolumeDiscountScaleList) {
        set(PROPERTY_PRICINGVOLUMEDISCOUNTSCALELIST,
            pricingVolumeDiscountScaleList);
    }

    @SuppressWarnings("unchecked")
    public List<Product> getPricingVolumeDiscountProductList() {
        return (List<Product>) get(PROPERTY_PRICINGVOLUMEDISCOUNTPRODUCTLIST);
    }

    public void setPricingVolumeDiscountProductList(
        List<Product> pricingVolumeDiscountProductList) {
        set(PROPERTY_PRICINGVOLUMEDISCOUNTPRODUCTLIST,
            pricingVolumeDiscountProductList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductCategory> getPricingVolumeDiscountProductCategoryList() {
        return (List<ProductCategory>) get(PROPERTY_PRICINGVOLUMEDISCOUNTPRODUCTCATEGORYLIST);
    }

    public void setPricingVolumeDiscountProductCategoryList(
        List<ProductCategory> pricingVolumeDiscountProductCategoryList) {
        set(PROPERTY_PRICINGVOLUMEDISCOUNTPRODUCTCATEGORYLIST,
            pricingVolumeDiscountProductCategoryList);
    }
}
