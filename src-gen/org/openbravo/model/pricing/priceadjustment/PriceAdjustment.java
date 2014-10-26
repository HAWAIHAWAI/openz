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
package org.openbravo.model.pricing.priceadjustment;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity PricingAdjustment (stored in table M_Offer).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class PriceAdjustment extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Offer";
    public static final String ENTITY_NAME = "PricingAdjustment";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PRIORITY = "priority";
    public static final String PROPERTY_ADDAMT = "addamt";
    public static final String PROPERTY_DISCOUNT = "discount";
    public static final String PROPERTY_FIXED = "fixed";
    public static final String PROPERTY_DATEFROM = "dateFrom";
    public static final String PROPERTY_DATETO = "dateTo";
    public static final String PROPERTY_BPARTNERSELECTION = "bPartnerSelection";
    public static final String PROPERTY_GROUPSELECTION = "groupSelection";
    public static final String PROPERTY_PRODUCTSELECTION = "productSelection";
    public static final String PROPERTY_PRODCATSELECTION = "prodCatSelection";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PRICELISTSELECTION =
        "pricelistSelection";
    public static final String PROPERTY_QTYFROM = "qtyFrom";
    public static final String PROPERTY_QTYTO = "qtyTo";
    public static final String PROPERTY_ISSALESOFFER = "isSalesOffer";
    public static final String PROPERTY_DIRECTPURCHASECALC =
        "directPurchaseCalc";
    public static final String PROPERTY_PRICINGADJUSTMENTBUSINESSPARTNERLIST =
        "pricingAdjustmentBusinessPartnerList";
    public static final String PROPERTY_PRICINGADJUSTMENTPRODUCTCATEGORYLIST =
        "pricingAdjustmentProductCategoryList";
    public static final String PROPERTY_PRICINGADJUSTMENTPRICELISTLIST =
        "pricingAdjustmentPriceListList";
    public static final String PROPERTY_PRICINGADJUSTMENTBUSINESSPARTNERGROUPLIST =
        "pricingAdjustmentBusinessPartnerGroupList";
    public static final String PROPERTY_PRICINGADJUSTMENTPRODUCTLIST =
        "pricingAdjustmentProductList";

    public PriceAdjustment() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ADDAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_DISCOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_BPARTNERSELECTION, "Y");
        setDefaultValue(PROPERTY_GROUPSELECTION, "Y");
        setDefaultValue(PROPERTY_PRODUCTSELECTION, "Y");
        setDefaultValue(PROPERTY_PRODCATSELECTION, "Y");
        setDefaultValue(PROPERTY_PRICELISTSELECTION, "Y");
        setDefaultValue(PROPERTY_ISSALESOFFER, true);
        setDefaultValue(PROPERTY_DIRECTPURCHASECALC, false);
        setDefaultValue(PROPERTY_PRICINGADJUSTMENTBUSINESSPARTNERLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGADJUSTMENTPRODUCTCATEGORYLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGADJUSTMENTPRICELISTLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGADJUSTMENTBUSINESSPARTNERGROUPLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGADJUSTMENTPRODUCTLIST,
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

    public Long getPriority() {
        return (Long) get(PROPERTY_PRIORITY);
    }

    public void setPriority(Long priority) {
        set(PROPERTY_PRIORITY, priority);
    }

    public BigDecimal getAddamt() {
        return (BigDecimal) get(PROPERTY_ADDAMT);
    }

    public void setAddamt(BigDecimal addamt) {
        set(PROPERTY_ADDAMT, addamt);
    }

    public BigDecimal getDiscount() {
        return (BigDecimal) get(PROPERTY_DISCOUNT);
    }

    public void setDiscount(BigDecimal discount) {
        set(PROPERTY_DISCOUNT, discount);
    }

    public BigDecimal getFixed() {
        return (BigDecimal) get(PROPERTY_FIXED);
    }

    public void setFixed(BigDecimal fixed) {
        set(PROPERTY_FIXED, fixed);
    }

    public Date getDateFrom() {
        return (Date) get(PROPERTY_DATEFROM);
    }

    public void setDateFrom(Date dateFrom) {
        set(PROPERTY_DATEFROM, dateFrom);
    }

    public Date getDateTo() {
        return (Date) get(PROPERTY_DATETO);
    }

    public void setDateTo(Date dateTo) {
        set(PROPERTY_DATETO, dateTo);
    }

    public String getBPartnerSelection() {
        return (String) get(PROPERTY_BPARTNERSELECTION);
    }

    public void setBPartnerSelection(String bPartnerSelection) {
        set(PROPERTY_BPARTNERSELECTION, bPartnerSelection);
    }

    public String getGroupSelection() {
        return (String) get(PROPERTY_GROUPSELECTION);
    }

    public void setGroupSelection(String groupSelection) {
        set(PROPERTY_GROUPSELECTION, groupSelection);
    }

    public String getProductSelection() {
        return (String) get(PROPERTY_PRODUCTSELECTION);
    }

    public void setProductSelection(String productSelection) {
        set(PROPERTY_PRODUCTSELECTION, productSelection);
    }

    public String getProdCatSelection() {
        return (String) get(PROPERTY_PRODCATSELECTION);
    }

    public void setProdCatSelection(String prodCatSelection) {
        set(PROPERTY_PRODCATSELECTION, prodCatSelection);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getPricelistSelection() {
        return (String) get(PROPERTY_PRICELISTSELECTION);
    }

    public void setPricelistSelection(String pricelistSelection) {
        set(PROPERTY_PRICELISTSELECTION, pricelistSelection);
    }

    public BigDecimal getQtyFrom() {
        return (BigDecimal) get(PROPERTY_QTYFROM);
    }

    public void setQtyFrom(BigDecimal qtyFrom) {
        set(PROPERTY_QTYFROM, qtyFrom);
    }

    public BigDecimal getQtyTo() {
        return (BigDecimal) get(PROPERTY_QTYTO);
    }

    public void setQtyTo(BigDecimal qtyTo) {
        set(PROPERTY_QTYTO, qtyTo);
    }

    public Boolean isSalesOffer() {
        return (Boolean) get(PROPERTY_ISSALESOFFER);
    }

    public void setSalesOffer(Boolean isSalesOffer) {
        set(PROPERTY_ISSALESOFFER, isSalesOffer);
    }

    public Boolean isDirectPurchaseCalc() {
        return (Boolean) get(PROPERTY_DIRECTPURCHASECALC);
    }

    public void setDirectPurchaseCalc(Boolean directPurchaseCalc) {
        set(PROPERTY_DIRECTPURCHASECALC, directPurchaseCalc);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getPricingAdjustmentBusinessPartnerList() {
        return (List<BusinessPartner>) get(PROPERTY_PRICINGADJUSTMENTBUSINESSPARTNERLIST);
    }

    public void setPricingAdjustmentBusinessPartnerList(
        List<BusinessPartner> pricingAdjustmentBusinessPartnerList) {
        set(PROPERTY_PRICINGADJUSTMENTBUSINESSPARTNERLIST,
            pricingAdjustmentBusinessPartnerList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductCategory> getPricingAdjustmentProductCategoryList() {
        return (List<ProductCategory>) get(PROPERTY_PRICINGADJUSTMENTPRODUCTCATEGORYLIST);
    }

    public void setPricingAdjustmentProductCategoryList(
        List<ProductCategory> pricingAdjustmentProductCategoryList) {
        set(PROPERTY_PRICINGADJUSTMENTPRODUCTCATEGORYLIST,
            pricingAdjustmentProductCategoryList);
    }

    @SuppressWarnings("unchecked")
    public List<PriceList> getPricingAdjustmentPriceListList() {
        return (List<PriceList>) get(PROPERTY_PRICINGADJUSTMENTPRICELISTLIST);
    }

    public void setPricingAdjustmentPriceListList(
        List<PriceList> pricingAdjustmentPriceListList) {
        set(PROPERTY_PRICINGADJUSTMENTPRICELISTLIST,
            pricingAdjustmentPriceListList);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartnerGroup> getPricingAdjustmentBusinessPartnerGroupList() {
        return (List<BusinessPartnerGroup>) get(PROPERTY_PRICINGADJUSTMENTBUSINESSPARTNERGROUPLIST);
    }

    public void setPricingAdjustmentBusinessPartnerGroupList(
        List<BusinessPartnerGroup> pricingAdjustmentBusinessPartnerGroupList) {
        set(PROPERTY_PRICINGADJUSTMENTBUSINESSPARTNERGROUPLIST,
            pricingAdjustmentBusinessPartnerGroupList);
    }

    @SuppressWarnings("unchecked")
    public List<Product> getPricingAdjustmentProductList() {
        return (List<Product>) get(PROPERTY_PRICINGADJUSTMENTPRODUCTLIST);
    }

    public void setPricingAdjustmentProductList(
        List<Product> pricingAdjustmentProductList) {
        set(PROPERTY_PRICINGADJUSTMENTPRODUCTLIST, pricingAdjustmentProductList);
    }
}
