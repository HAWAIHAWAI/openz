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
package org.openbravo.model.manufacturing.floorshop;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity ManufacturingMachineCost (stored in table MA_Machine_Cost).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class MachineCost extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "MA_Machine_Cost";
    public static final String ENTITY_NAME = "ManufacturingMachineCost";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_MACHINE = "machine";
    public static final String PROPERTY_COST = "cost";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_VALIDFROM = "validFrom";
    public static final String PROPERTY_COSTUOM = "costuom";
    public static final String PROPERTY_AMORTIZATION = "amortization";
    public static final String PROPERTY_CONSUME = "consume";
    public static final String PROPERTY_COSTUOMYEAR = "costuomyear";
    public static final String PROPERTY_DAYHOURS = "dayhours";
    public static final String PROPERTY_DAYSYEAR = "daysyear";
    public static final String PROPERTY_IMPRODUCTIVEHOURSYEAR =
        "improductivehoursyear";
    public static final String PROPERTY_PURCHASEAMT = "purchaseamt";
    public static final String PROPERTY_TOOLSETAMT = "toolsetamt";
    public static final String PROPERTY_YEARVALUE = "yearvalue";

    public MachineCost() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
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

    public Machine getMachine() {
        return (Machine) get(PROPERTY_MACHINE);
    }

    public void setMachine(Machine machine) {
        set(PROPERTY_MACHINE, machine);
    }

    public BigDecimal getCost() {
        return (BigDecimal) get(PROPERTY_COST);
    }

    public void setCost(BigDecimal cost) {
        set(PROPERTY_COST, cost);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ISACTIVE);
    }

    public void setActive(Boolean isActive) {
        set(PROPERTY_ISACTIVE, isActive);
    }

    public Date getValidFrom() {
        return (Date) get(PROPERTY_VALIDFROM);
    }

    public void setValidFrom(Date validFrom) {
        set(PROPERTY_VALIDFROM, validFrom);
    }

    public String getCostuom() {
        return (String) get(PROPERTY_COSTUOM);
    }

    public void setCostuom(String costuom) {
        set(PROPERTY_COSTUOM, costuom);
    }

    public Long getAmortization() {
        return (Long) get(PROPERTY_AMORTIZATION);
    }

    public void setAmortization(Long amortization) {
        set(PROPERTY_AMORTIZATION, amortization);
    }

    public BigDecimal getConsume() {
        return (BigDecimal) get(PROPERTY_CONSUME);
    }

    public void setConsume(BigDecimal consume) {
        set(PROPERTY_CONSUME, consume);
    }

    public BigDecimal getCostuomyear() {
        return (BigDecimal) get(PROPERTY_COSTUOMYEAR);
    }

    public void setCostuomyear(BigDecimal costuomyear) {
        set(PROPERTY_COSTUOMYEAR, costuomyear);
    }

    public BigDecimal getDayhours() {
        return (BigDecimal) get(PROPERTY_DAYHOURS);
    }

    public void setDayhours(BigDecimal dayhours) {
        set(PROPERTY_DAYHOURS, dayhours);
    }

    public Long getDaysyear() {
        return (Long) get(PROPERTY_DAYSYEAR);
    }

    public void setDaysyear(Long daysyear) {
        set(PROPERTY_DAYSYEAR, daysyear);
    }

    public BigDecimal getImproductivehoursyear() {
        return (BigDecimal) get(PROPERTY_IMPRODUCTIVEHOURSYEAR);
    }

    public void setImproductivehoursyear(BigDecimal improductivehoursyear) {
        set(PROPERTY_IMPRODUCTIVEHOURSYEAR, improductivehoursyear);
    }

    public BigDecimal getPurchaseamt() {
        return (BigDecimal) get(PROPERTY_PURCHASEAMT);
    }

    public void setPurchaseamt(BigDecimal purchaseamt) {
        set(PROPERTY_PURCHASEAMT, purchaseamt);
    }

    public BigDecimal getToolsetamt() {
        return (BigDecimal) get(PROPERTY_TOOLSETAMT);
    }

    public void setToolsetamt(BigDecimal toolsetamt) {
        set(PROPERTY_TOOLSETAMT, toolsetamt);
    }

    public BigDecimal getYearvalue() {
        return (BigDecimal) get(PROPERTY_YEARVALUE);
    }

    public void setYearvalue(BigDecimal yearvalue) {
        set(PROPERTY_YEARVALUE, yearvalue);
    }
}
