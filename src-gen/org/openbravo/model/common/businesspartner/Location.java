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
package org.openbravo.model.common.businesspartner;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.sales.SalesRegion;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity BusinessPartnerLocation (stored in table C_BPartner_Location).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Location extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_BPartner_Location";
    public static final String ENTITY_NAME = "BusinessPartnerLocation";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_ISBILLTO = "isBillTo";
    public static final String PROPERTY_ISSHIPTO = "isShipTo";
    public static final String PROPERTY_ISPAYFROM = "isPayFrom";
    public static final String PROPERTY_ISREMITTO = "isRemitTo";
    public static final String PROPERTY_PHONE = "phone";
    public static final String PROPERTY_PHONE2 = "phone2";
    public static final String PROPERTY_FAX = "fax";
    public static final String PROPERTY_SALESREGION = "salesRegion";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_LOCATION = "location";
    public static final String PROPERTY_ISTAXLOCATION = "isTaxLocation";
    public static final String PROPERTY_UPC = "uPC";
    public static final String PROPERTY_ISHEADQUARTER = "isheadquarter";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_UIDNUMBER = "uidnumber";
    public static final String PROPERTY_EORIIDENTIFICATION =
        "eoriidentification";
    public static final String PROPERTY_DEVIANTBPNAME = "deviantBpName";

    public Location() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_NAME, ".");
        setDefaultValue(PROPERTY_ISBILLTO, true);
        setDefaultValue(PROPERTY_ISSHIPTO, true);
        setDefaultValue(PROPERTY_ISPAYFROM, true);
        setDefaultValue(PROPERTY_ISREMITTO, true);
        setDefaultValue(PROPERTY_ISTAXLOCATION, false);
        setDefaultValue(PROPERTY_ISHEADQUARTER, false);
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

    public Boolean isBillTo() {
        return (Boolean) get(PROPERTY_ISBILLTO);
    }

    public void setBillTo(Boolean isBillTo) {
        set(PROPERTY_ISBILLTO, isBillTo);
    }

    public Boolean isShipTo() {
        return (Boolean) get(PROPERTY_ISSHIPTO);
    }

    public void setShipTo(Boolean isShipTo) {
        set(PROPERTY_ISSHIPTO, isShipTo);
    }

    public Boolean isPayFrom() {
        return (Boolean) get(PROPERTY_ISPAYFROM);
    }

    public void setPayFrom(Boolean isPayFrom) {
        set(PROPERTY_ISPAYFROM, isPayFrom);
    }

    public Boolean isRemitTo() {
        return (Boolean) get(PROPERTY_ISREMITTO);
    }

    public void setRemitTo(Boolean isRemitTo) {
        set(PROPERTY_ISREMITTO, isRemitTo);
    }

    public String getPhone() {
        return (String) get(PROPERTY_PHONE);
    }

    public void setPhone(String phone) {
        set(PROPERTY_PHONE, phone);
    }

    public String getPhone2() {
        return (String) get(PROPERTY_PHONE2);
    }

    public void setPhone2(String phone2) {
        set(PROPERTY_PHONE2, phone2);
    }

    public String getFax() {
        return (String) get(PROPERTY_FAX);
    }

    public void setFax(String fax) {
        set(PROPERTY_FAX, fax);
    }

    public SalesRegion getSalesRegion() {
        return (SalesRegion) get(PROPERTY_SALESREGION);
    }

    public void setSalesRegion(SalesRegion salesRegion) {
        set(PROPERTY_SALESREGION, salesRegion);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public org.openbravo.model.common.geography.Location getLocation() {
        return (org.openbravo.model.common.geography.Location) get(PROPERTY_LOCATION);
    }

    public void setLocation(
        org.openbravo.model.common.geography.Location location) {
        set(PROPERTY_LOCATION, location);
    }

    public Boolean isTaxLocation() {
        return (Boolean) get(PROPERTY_ISTAXLOCATION);
    }

    public void setTaxLocation(Boolean isTaxLocation) {
        set(PROPERTY_ISTAXLOCATION, isTaxLocation);
    }

    public String getUPC() {
        return (String) get(PROPERTY_UPC);
    }

    public void setUPC(String uPC) {
        set(PROPERTY_UPC, uPC);
    }

    public Boolean isHeadquarter() {
        return (Boolean) get(PROPERTY_ISHEADQUARTER);
    }

    public void setHeadquarter(Boolean isheadquarter) {
        set(PROPERTY_ISHEADQUARTER, isheadquarter);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public String getUidnumber() {
        return (String) get(PROPERTY_UIDNUMBER);
    }

    public void setUidnumber(String uidnumber) {
        set(PROPERTY_UIDNUMBER, uidnumber);
    }

    public String getEoriidentification() {
        return (String) get(PROPERTY_EORIIDENTIFICATION);
    }

    public void setEoriidentification(String eoriidentification) {
        set(PROPERTY_EORIIDENTIFICATION, eoriidentification);
    }

    public String getDeviantBpName() {
        return (String) get(PROPERTY_DEVIANTBPNAME);
    }

    public void setDeviantBpName(String deviantBpName) {
        set(PROPERTY_DEVIANTBPNAME, deviantBpName);
    }
}
