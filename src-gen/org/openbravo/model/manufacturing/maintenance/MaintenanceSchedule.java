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
package org.openbravo.model.manufacturing.maintenance;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.manufacturing.floorshop.Machine;
import org.openbravo.model.manufacturing.floorshop.MachineType;
import org.openbravo.model.materialmgmt.transaction.InternalConsumption;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity ManufacturingMaintenanceSchedule (stored in table MA_Maint_Scheduled).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class MaintenanceSchedule extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "MA_Maint_Scheduled";
    public static final String ENTITY_NAME = "ManufacturingMaintenanceSchedule";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_MAINTENANCE = "maintenance";
    public static final String PROPERTY_MAINTPART = "maintPart";
    public static final String PROPERTY_MACHINE = "machine";
    public static final String PROPERTY_MACHINETYPE = "machineType";
    public static final String PROPERTY_MAINTENANCETYPE = "maintenanceType";
    public static final String PROPERTY_SCHEDULEDDATE = "scheduleddate";
    public static final String PROPERTY_CONFIRMED = "confirmed";
    public static final String PROPERTY_SHIFT = "shift";
    public static final String PROPERTY_RESULT = "result";
    public static final String PROPERTY_OBSERVATION = "observation";
    public static final String PROPERTY_USEDTIME = "usedtime";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_MAINTOPERATION = "maintOperation";
    public static final String PROPERTY_INTERNALCONSUMPTION =
        "internalConsumption";

    public MaintenanceSchedule() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_CONFIRMED, false);
        setDefaultValue(PROPERTY_RESULT, false);
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

    public Maintenance getMaintenance() {
        return (Maintenance) get(PROPERTY_MAINTENANCE);
    }

    public void setMaintenance(Maintenance maintenance) {
        set(PROPERTY_MAINTENANCE, maintenance);
    }

    public MainteanceOrder getMaintPart() {
        return (MainteanceOrder) get(PROPERTY_MAINTPART);
    }

    public void setMaintPart(MainteanceOrder maintPart) {
        set(PROPERTY_MAINTPART, maintPart);
    }

    public Machine getMachine() {
        return (Machine) get(PROPERTY_MACHINE);
    }

    public void setMachine(Machine machine) {
        set(PROPERTY_MACHINE, machine);
    }

    public MachineType getMachineType() {
        return (MachineType) get(PROPERTY_MACHINETYPE);
    }

    public void setMachineType(MachineType machineType) {
        set(PROPERTY_MACHINETYPE, machineType);
    }

    public String getMaintenanceType() {
        return (String) get(PROPERTY_MAINTENANCETYPE);
    }

    public void setMaintenanceType(String maintenanceType) {
        set(PROPERTY_MAINTENANCETYPE, maintenanceType);
    }

    public Date getScheduleddate() {
        return (Date) get(PROPERTY_SCHEDULEDDATE);
    }

    public void setScheduleddate(Date scheduleddate) {
        set(PROPERTY_SCHEDULEDDATE, scheduleddate);
    }

    public Boolean isConfirmed() {
        return (Boolean) get(PROPERTY_CONFIRMED);
    }

    public void setConfirmed(Boolean confirmed) {
        set(PROPERTY_CONFIRMED, confirmed);
    }

    public String getShift() {
        return (String) get(PROPERTY_SHIFT);
    }

    public void setShift(String shift) {
        set(PROPERTY_SHIFT, shift);
    }

    public Boolean isResult() {
        return (Boolean) get(PROPERTY_RESULT);
    }

    public void setResult(Boolean result) {
        set(PROPERTY_RESULT, result);
    }

    public String getObservation() {
        return (String) get(PROPERTY_OBSERVATION);
    }

    public void setObservation(String observation) {
        set(PROPERTY_OBSERVATION, observation);
    }

    public BigDecimal getUsedtime() {
        return (BigDecimal) get(PROPERTY_USEDTIME);
    }

    public void setUsedtime(BigDecimal usedtime) {
        set(PROPERTY_USEDTIME, usedtime);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Task getMaintOperation() {
        return (Task) get(PROPERTY_MAINTOPERATION);
    }

    public void setMaintOperation(Task maintOperation) {
        set(PROPERTY_MAINTOPERATION, maintOperation);
    }

    public InternalConsumption getInternalConsumption() {
        return (InternalConsumption) get(PROPERTY_INTERNALCONSUMPTION);
    }

    public void setInternalConsumption(InternalConsumption internalConsumption) {
        set(PROPERTY_INTERNALCONSUMPTION, internalConsumption);
    }
}
