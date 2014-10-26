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
package org.openbravo.model.common.plm;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity ApprovedVendor (stored in table M_Product_PO).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ApprovedVendor extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Product_PO";
    public static final String ENTITY_NAME = "ApprovedVendor";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ISCURRENTVENDOR = "isCurrentVendor";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_PRICEPO = "pricePO";
    public static final String PROPERTY_PRICEEFFECTIVE = "priceEffective";
    public static final String PROPERTY_PRICELASTPO = "priceLastPO";
    public static final String PROPERTY_PRICELASTINV = "priceLastInv";
    public static final String PROPERTY_VENDORPRODUCTNO = "vendorProductNo";
    public static final String PROPERTY_UPC = "uPC";
    public static final String PROPERTY_VENDORCATEGORY = "vendorCategory";
    public static final String PROPERTY_DISCONTINUED = "discontinued";
    public static final String PROPERTY_DISCONTINUEDBY = "discontinuedBy";
    public static final String PROPERTY_ORDERMIN = "orderMin";
    public static final String PROPERTY_ORDERPACK = "orderPack";
    public static final String PROPERTY_COSTPERORDER = "costPerOrder";
    public static final String PROPERTY_DELIVERYTIMEPROMISED =
        "deliveryTimePromised";
    public static final String PROPERTY_DELIVERYTIMEACTUAL =
        "deliveryTimeActual";
    public static final String PROPERTY_QUALITYRATING = "qualityRating";
    public static final String PROPERTY_ROYALTYAMT = "royaltyAmt";
    public static final String PROPERTY_MANUFACTURER = "manufacturer";
    public static final String PROPERTY_CAPACITY = "capacity";
    public static final String PROPERTY_QTYSTD = "qtystd";
    public static final String PROPERTY_ISMULTIPLEOFMINIMUMQTY =
        "ismultipleofminimumqty";

    public ApprovedVendor() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISCURRENTVENDOR, true);
        setDefaultValue(PROPERTY_DISCONTINUED, false);
        setDefaultValue(PROPERTY_ISMULTIPLEOFMINIMUMQTY, false);
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

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
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

    public Boolean isCurrentVendor() {
        return (Boolean) get(PROPERTY_ISCURRENTVENDOR);
    }

    public void setCurrentVendor(Boolean isCurrentVendor) {
        set(PROPERTY_ISCURRENTVENDOR, isCurrentVendor);
    }

    public org.openbravo.model.common.uom.UOM getUOM() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUOM(org.openbravo.model.common.uom.UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public BigDecimal getPriceList() {
        return (BigDecimal) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(BigDecimal priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public BigDecimal getPricePO() {
        return (BigDecimal) get(PROPERTY_PRICEPO);
    }

    public void setPricePO(BigDecimal pricePO) {
        set(PROPERTY_PRICEPO, pricePO);
    }

    public Date getPriceEffective() {
        return (Date) get(PROPERTY_PRICEEFFECTIVE);
    }

    public void setPriceEffective(Date priceEffective) {
        set(PROPERTY_PRICEEFFECTIVE, priceEffective);
    }

    public BigDecimal getPriceLastPO() {
        return (BigDecimal) get(PROPERTY_PRICELASTPO);
    }

    public void setPriceLastPO(BigDecimal priceLastPO) {
        set(PROPERTY_PRICELASTPO, priceLastPO);
    }

    public BigDecimal getPriceLastInv() {
        return (BigDecimal) get(PROPERTY_PRICELASTINV);
    }

    public void setPriceLastInv(BigDecimal priceLastInv) {
        set(PROPERTY_PRICELASTINV, priceLastInv);
    }

    public String getVendorProductNo() {
        return (String) get(PROPERTY_VENDORPRODUCTNO);
    }

    public void setVendorProductNo(String vendorProductNo) {
        set(PROPERTY_VENDORPRODUCTNO, vendorProductNo);
    }

    public String getUPC() {
        return (String) get(PROPERTY_UPC);
    }

    public void setUPC(String uPC) {
        set(PROPERTY_UPC, uPC);
    }

    public String getVendorCategory() {
        return (String) get(PROPERTY_VENDORCATEGORY);
    }

    public void setVendorCategory(String vendorCategory) {
        set(PROPERTY_VENDORCATEGORY, vendorCategory);
    }

    public Boolean isDiscontinued() {
        return (Boolean) get(PROPERTY_DISCONTINUED);
    }

    public void setDiscontinued(Boolean discontinued) {
        set(PROPERTY_DISCONTINUED, discontinued);
    }

    public Date getDiscontinuedBy() {
        return (Date) get(PROPERTY_DISCONTINUEDBY);
    }

    public void setDiscontinuedBy(Date discontinuedBy) {
        set(PROPERTY_DISCONTINUEDBY, discontinuedBy);
    }

    public BigDecimal getOrderMin() {
        return (BigDecimal) get(PROPERTY_ORDERMIN);
    }

    public void setOrderMin(BigDecimal orderMin) {
        set(PROPERTY_ORDERMIN, orderMin);
    }

    public BigDecimal getOrderPack() {
        return (BigDecimal) get(PROPERTY_ORDERPACK);
    }

    public void setOrderPack(BigDecimal orderPack) {
        set(PROPERTY_ORDERPACK, orderPack);
    }

    public BigDecimal getCostPerOrder() {
        return (BigDecimal) get(PROPERTY_COSTPERORDER);
    }

    public void setCostPerOrder(BigDecimal costPerOrder) {
        set(PROPERTY_COSTPERORDER, costPerOrder);
    }

    public Long getDeliveryTimePromised() {
        return (Long) get(PROPERTY_DELIVERYTIMEPROMISED);
    }

    public void setDeliveryTimePromised(Long deliveryTimePromised) {
        set(PROPERTY_DELIVERYTIMEPROMISED, deliveryTimePromised);
    }

    public Long getDeliveryTimeActual() {
        return (Long) get(PROPERTY_DELIVERYTIMEACTUAL);
    }

    public void setDeliveryTimeActual(Long deliveryTimeActual) {
        set(PROPERTY_DELIVERYTIMEACTUAL, deliveryTimeActual);
    }

    public Long getQualityRating() {
        return (Long) get(PROPERTY_QUALITYRATING);
    }

    public void setQualityRating(Long qualityRating) {
        set(PROPERTY_QUALITYRATING, qualityRating);
    }

    public BigDecimal getRoyaltyAmt() {
        return (BigDecimal) get(PROPERTY_ROYALTYAMT);
    }

    public void setRoyaltyAmt(BigDecimal royaltyAmt) {
        set(PROPERTY_ROYALTYAMT, royaltyAmt);
    }

    public String getManufacturer() {
        return (String) get(PROPERTY_MANUFACTURER);
    }

    public void setManufacturer(String manufacturer) {
        set(PROPERTY_MANUFACTURER, manufacturer);
    }

    public BigDecimal getCapacity() {
        return (BigDecimal) get(PROPERTY_CAPACITY);
    }

    public void setCapacity(BigDecimal capacity) {
        set(PROPERTY_CAPACITY, capacity);
    }

    public BigDecimal getQtystd() {
        return (BigDecimal) get(PROPERTY_QTYSTD);
    }

    public void setQtystd(BigDecimal qtystd) {
        set(PROPERTY_QTYSTD, qtystd);
    }

    public Boolean isMultipleofminimumqty() {
        return (Boolean) get(PROPERTY_ISMULTIPLEOFMINIMUMQTY);
    }

    public void setMultipleofminimumqty(Boolean ismultipleofminimumqty) {
        set(PROPERTY_ISMULTIPLEOFMINIMUMQTY, ismultipleofminimumqty);
    }
}
