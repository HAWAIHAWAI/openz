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
package org.openbravo.model.timeandexpense;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.ProductCategory;
import org.openbravo.model.financialmgmt.tax.TaxCategory;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Date;

/**
 * Entity class for entity ResourceType (stored in table S_ResourceType).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ResourceType extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "S_ResourceType";
    public static final String ENTITY_NAME = "ResourceType";
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
    public static final String PROPERTY_ISSINGLEASSIGNMENT =
        "isSingleAssignment";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_ALLOWUOMFRACTIONS = "allowUoMFractions";
    public static final String PROPERTY_TIMESLOTSTART = "timeSlotStart";
    public static final String PROPERTY_TIMESLOTEND = "timeSlotEnd";
    public static final String PROPERTY_ISTIMESLOT = "isTimeSlot";
    public static final String PROPERTY_ISDATESLOT = "isDateSlot";
    public static final String PROPERTY_ONSUNDAY = "onSunday";
    public static final String PROPERTY_ONMONDAY = "onMonday";
    public static final String PROPERTY_ONTUESDAY = "onTuesday";
    public static final String PROPERTY_ONWEDNESDAY = "onWednesday";
    public static final String PROPERTY_ONTHURSDAY = "onThursday";
    public static final String PROPERTY_ONFRIDAY = "onFriday";
    public static final String PROPERTY_ONSATURDAY = "onSaturday";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_TAXCATEGORY = "taxCategory";
    public static final String PROPERTY_CHARGEABLEQTY = "chargeableQty";

    public ResourceType() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISSINGLEASSIGNMENT, false);
        setDefaultValue(PROPERTY_ALLOWUOMFRACTIONS, false);
        setDefaultValue(PROPERTY_ISTIMESLOT, false);
        setDefaultValue(PROPERTY_ISDATESLOT, false);
        setDefaultValue(PROPERTY_ONSUNDAY, false);
        setDefaultValue(PROPERTY_ONMONDAY, true);
        setDefaultValue(PROPERTY_ONTUESDAY, true);
        setDefaultValue(PROPERTY_ONWEDNESDAY, true);
        setDefaultValue(PROPERTY_ONTHURSDAY, true);
        setDefaultValue(PROPERTY_ONFRIDAY, true);
        setDefaultValue(PROPERTY_ONSATURDAY, false);
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

    public Boolean isSingleAssignment() {
        return (Boolean) get(PROPERTY_ISSINGLEASSIGNMENT);
    }

    public void setSingleAssignment(Boolean isSingleAssignment) {
        set(PROPERTY_ISSINGLEASSIGNMENT, isSingleAssignment);
    }

    public org.openbravo.model.common.uom.UOM getUOM() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUOM(org.openbravo.model.common.uom.UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public Boolean isAllowUoMFractions() {
        return (Boolean) get(PROPERTY_ALLOWUOMFRACTIONS);
    }

    public void setAllowUoMFractions(Boolean allowUoMFractions) {
        set(PROPERTY_ALLOWUOMFRACTIONS, allowUoMFractions);
    }

    public Timestamp getTimeSlotStart() {
        return (Timestamp) get(PROPERTY_TIMESLOTSTART);
    }

    public void setTimeSlotStart(Timestamp timeSlotStart) {
        set(PROPERTY_TIMESLOTSTART, timeSlotStart);
    }

    public Timestamp getTimeSlotEnd() {
        return (Timestamp) get(PROPERTY_TIMESLOTEND);
    }

    public void setTimeSlotEnd(Timestamp timeSlotEnd) {
        set(PROPERTY_TIMESLOTEND, timeSlotEnd);
    }

    public Boolean isTimeSlot() {
        return (Boolean) get(PROPERTY_ISTIMESLOT);
    }

    public void setTimeSlot(Boolean isTimeSlot) {
        set(PROPERTY_ISTIMESLOT, isTimeSlot);
    }

    public Boolean isDateSlot() {
        return (Boolean) get(PROPERTY_ISDATESLOT);
    }

    public void setDateSlot(Boolean isDateSlot) {
        set(PROPERTY_ISDATESLOT, isDateSlot);
    }

    public Boolean isOnSunday() {
        return (Boolean) get(PROPERTY_ONSUNDAY);
    }

    public void setOnSunday(Boolean onSunday) {
        set(PROPERTY_ONSUNDAY, onSunday);
    }

    public Boolean isOnMonday() {
        return (Boolean) get(PROPERTY_ONMONDAY);
    }

    public void setOnMonday(Boolean onMonday) {
        set(PROPERTY_ONMONDAY, onMonday);
    }

    public Boolean isOnTuesday() {
        return (Boolean) get(PROPERTY_ONTUESDAY);
    }

    public void setOnTuesday(Boolean onTuesday) {
        set(PROPERTY_ONTUESDAY, onTuesday);
    }

    public Boolean isOnWednesday() {
        return (Boolean) get(PROPERTY_ONWEDNESDAY);
    }

    public void setOnWednesday(Boolean onWednesday) {
        set(PROPERTY_ONWEDNESDAY, onWednesday);
    }

    public Boolean isOnThursday() {
        return (Boolean) get(PROPERTY_ONTHURSDAY);
    }

    public void setOnThursday(Boolean onThursday) {
        set(PROPERTY_ONTHURSDAY, onThursday);
    }

    public Boolean isOnFriday() {
        return (Boolean) get(PROPERTY_ONFRIDAY);
    }

    public void setOnFriday(Boolean onFriday) {
        set(PROPERTY_ONFRIDAY, onFriday);
    }

    public Boolean isOnSaturday() {
        return (Boolean) get(PROPERTY_ONSATURDAY);
    }

    public void setOnSaturday(Boolean onSaturday) {
        set(PROPERTY_ONSATURDAY, onSaturday);
    }

    public ProductCategory getProductCategory() {
        return (ProductCategory) get(PROPERTY_PRODUCTCATEGORY);
    }

    public void setProductCategory(ProductCategory productCategory) {
        set(PROPERTY_PRODUCTCATEGORY, productCategory);
    }

    public TaxCategory getTaxCategory() {
        return (TaxCategory) get(PROPERTY_TAXCATEGORY);
    }

    public void setTaxCategory(TaxCategory taxCategory) {
        set(PROPERTY_TAXCATEGORY, taxCategory);
    }

    public BigDecimal getChargeableQty() {
        return (BigDecimal) get(PROPERTY_CHARGEABLEQTY);
    }

    public void setChargeableQty(BigDecimal chargeableQty) {
        set(PROPERTY_CHARGEABLEQTY, chargeableQty);
    }
}
