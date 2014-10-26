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
package org.openbravo.model.shipping;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Country;
import org.openbravo.model.common.geography.Region;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity ShippingShippingCompanyFreight (stored in table M_Freight).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ShippingCompanyFreight extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Freight";
    public static final String ENTITY_NAME = "ShippingShippingCompanyFreight";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SHIPPER = "shipper";
    public static final String PROPERTY_FREIGHTCATEGORY = "freightCategory";
    public static final String PROPERTY_VALIDFROM = "validFrom";
    public static final String PROPERTY_COUNTRY = "country";
    public static final String PROPERTY_COUNTRY12 = "country12";
    public static final String PROPERTY_REGION = "region";
    public static final String PROPERTY_REGION14 = "region14";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_FREIGHTAMT = "freightAmt";
    public static final String PROPERTY_FREIGHTUNIT = "freightUnit";
    public static final String PROPERTY_ISPRICE = "isprice";
    public static final String PROPERTY_LINEROUND = "lineRound";
    public static final String PROPERTY_QTYFROM = "qtyfrom";
    public static final String PROPERTY_QTYTO = "qtyto";
    public static final String PROPERTY_TOTALROUND = "totalRound";

    public ShippingCompanyFreight() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISPRICE, false);
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

    public ShippingCompany getShipper() {
        return (ShippingCompany) get(PROPERTY_SHIPPER);
    }

    public void setShipper(ShippingCompany shipper) {
        set(PROPERTY_SHIPPER, shipper);
    }

    public FreightCategory getFreightCategory() {
        return (FreightCategory) get(PROPERTY_FREIGHTCATEGORY);
    }

    public void setFreightCategory(FreightCategory freightCategory) {
        set(PROPERTY_FREIGHTCATEGORY, freightCategory);
    }

    public Date getValidFrom() {
        return (Date) get(PROPERTY_VALIDFROM);
    }

    public void setValidFrom(Date validFrom) {
        set(PROPERTY_VALIDFROM, validFrom);
    }

    public Country getCountry() {
        return (Country) get(PROPERTY_COUNTRY);
    }

    public void setCountry(Country country) {
        set(PROPERTY_COUNTRY, country);
    }

    public Country getCountry12() {
        return (Country) get(PROPERTY_COUNTRY12);
    }

    public void setCountry12(Country country12) {
        set(PROPERTY_COUNTRY12, country12);
    }

    public Region getRegion() {
        return (Region) get(PROPERTY_REGION);
    }

    public void setRegion(Region region) {
        set(PROPERTY_REGION, region);
    }

    public Region getRegion14() {
        return (Region) get(PROPERTY_REGION14);
    }

    public void setRegion14(Region region14) {
        set(PROPERTY_REGION14, region14);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public BigDecimal getFreightAmt() {
        return (BigDecimal) get(PROPERTY_FREIGHTAMT);
    }

    public void setFreightAmt(BigDecimal freightAmt) {
        set(PROPERTY_FREIGHTAMT, freightAmt);
    }

    public String getFreightUnit() {
        return (String) get(PROPERTY_FREIGHTUNIT);
    }

    public void setFreightUnit(String freightUnit) {
        set(PROPERTY_FREIGHTUNIT, freightUnit);
    }

    public Boolean isPrice() {
        return (Boolean) get(PROPERTY_ISPRICE);
    }

    public void setPrice(Boolean isprice) {
        set(PROPERTY_ISPRICE, isprice);
    }

    public String getLineRound() {
        return (String) get(PROPERTY_LINEROUND);
    }

    public void setLineRound(String lineRound) {
        set(PROPERTY_LINEROUND, lineRound);
    }

    public BigDecimal getQtyfrom() {
        return (BigDecimal) get(PROPERTY_QTYFROM);
    }

    public void setQtyfrom(BigDecimal qtyfrom) {
        set(PROPERTY_QTYFROM, qtyfrom);
    }

    public BigDecimal getQtyto() {
        return (BigDecimal) get(PROPERTY_QTYTO);
    }

    public void setQtyto(BigDecimal qtyto) {
        set(PROPERTY_QTYTO, qtyto);
    }

    public String getTotalRound() {
        return (String) get(PROPERTY_TOTALROUND);
    }

    public void setTotalRound(String totalRound) {
        set(PROPERTY_TOTALROUND, totalRound);
    }
}
