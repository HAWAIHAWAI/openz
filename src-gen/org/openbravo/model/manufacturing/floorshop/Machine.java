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
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.manufacturing.maintenance.Maintenance;
import org.openbravo.zsoft.projects.Zspm_ctaskmachineplan;
import org.openbravo.zsoft.projects.Zspm_ptaskmachineplan;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ManufacturingMachine (stored in table MA_Machine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Machine extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "MA_Machine";
    public static final String ENTITY_NAME = "ManufacturingMachine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PURCHASEYEAR = "purchaseyear";
    public static final String PROPERTY_USECYCLE = "usecycle";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_MACHINETYPE = "machineType";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_ISMOVEDINPROJECTS = "ismovedinprojects";
    public static final String PROPERTY_ASSETVALUEAMT = "assetvalueamt";
    public static final String PROPERTY_WEIGHT = "weight";
    public static final String PROPERTY_SNRMASTERDATA = "sNRMasterdata";
    public static final String PROPERTY_ISINRESOURCEPLAN = "isinresourceplan";
    public static final String PROPERTY_COLOR = "color";
    public static final String PROPERTY_MANUFACTURINGMACHINECOSTLIST =
        "manufacturingMachineCostList";
    public static final String PROPERTY_ZSPMPTASKMACHINEPLANLIST =
        "zspmPtaskmachineplanList";
    public static final String PROPERTY_MACHINECALENDARVLIST =
        "machinecalendarVList";
    public static final String PROPERTY_MACHINEEVENTLIST = "machineEVENTList";
    public static final String PROPERTY_MACHINECALENDARSETTINGSLIST =
        "machineCALENDARSETTINGSList";
    public static final String PROPERTY_ZSPMCTASKMACHINEPLANLIST =
        "zspmCtaskmachineplanList";
    public static final String PROPERTY_MANUFACTURINGMAINTENANCELIST =
        "manufacturingMaintenanceList";

    public Machine() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISMOVEDINPROJECTS, false);
        setDefaultValue(PROPERTY_ISINRESOURCEPLAN, true);
        setDefaultValue(PROPERTY_MANUFACTURINGMACHINECOSTLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSPMPTASKMACHINEPLANLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_MACHINECALENDARVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MACHINEEVENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MACHINECALENDARSETTINGSLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSPMCTASKMACHINEPLANLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGMAINTENANCELIST,
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

    public Date getPurchaseyear() {
        return (Date) get(PROPERTY_PURCHASEYEAR);
    }

    public void setPurchaseyear(Date purchaseyear) {
        set(PROPERTY_PURCHASEYEAR, purchaseyear);
    }

    public Long getUsecycle() {
        return (Long) get(PROPERTY_USECYCLE);
    }

    public void setUsecycle(Long usecycle) {
        set(PROPERTY_USECYCLE, usecycle);
    }

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
    }

    public MachineType getMachineType() {
        return (MachineType) get(PROPERTY_MACHINETYPE);
    }

    public void setMachineType(MachineType machineType) {
        set(PROPERTY_MACHINETYPE, machineType);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public Boolean isMovedinprojects() {
        return (Boolean) get(PROPERTY_ISMOVEDINPROJECTS);
    }

    public void setMovedinprojects(Boolean ismovedinprojects) {
        set(PROPERTY_ISMOVEDINPROJECTS, ismovedinprojects);
    }

    public BigDecimal getAssetvalueamt() {
        return (BigDecimal) get(PROPERTY_ASSETVALUEAMT);
    }

    public void setAssetvalueamt(BigDecimal assetvalueamt) {
        set(PROPERTY_ASSETVALUEAMT, assetvalueamt);
    }

    public Long getWeight() {
        return (Long) get(PROPERTY_WEIGHT);
    }

    public void setWeight(Long weight) {
        set(PROPERTY_WEIGHT, weight);
    }

    public org.zsoft.serial.snr_masterdata getSNRMasterdata() {
        return (org.zsoft.serial.snr_masterdata) get(PROPERTY_SNRMASTERDATA);
    }

    public void setSNRMasterdata(org.zsoft.serial.snr_masterdata sNRMasterdata) {
        set(PROPERTY_SNRMASTERDATA, sNRMasterdata);
    }

    public Boolean isInresourceplan() {
        return (Boolean) get(PROPERTY_ISINRESOURCEPLAN);
    }

    public void setInresourceplan(Boolean isinresourceplan) {
        set(PROPERTY_ISINRESOURCEPLAN, isinresourceplan);
    }

    public org.openbravo.model.common.enterprise.c_color getColor() {
        return (org.openbravo.model.common.enterprise.c_color) get(PROPERTY_COLOR);
    }

    public void setColor(org.openbravo.model.common.enterprise.c_color color) {
        set(PROPERTY_COLOR, color);
    }

    @SuppressWarnings("unchecked")
    public List<MachineCost> getManufacturingMachineCostList() {
        return (List<MachineCost>) get(PROPERTY_MANUFACTURINGMACHINECOSTLIST);
    }

    public void setManufacturingMachineCostList(
        List<MachineCost> manufacturingMachineCostList) {
        set(PROPERTY_MANUFACTURINGMACHINECOSTLIST, manufacturingMachineCostList);
    }

    @SuppressWarnings("unchecked")
    public List<Zspm_ptaskmachineplan> getZspmPtaskmachineplanList() {
        return (List<Zspm_ptaskmachineplan>) get(PROPERTY_ZSPMPTASKMACHINEPLANLIST);
    }

    public void setZspmPtaskmachineplanList(
        List<Zspm_ptaskmachineplan> zspmPtaskmachineplanList) {
        set(PROPERTY_ZSPMPTASKMACHINEPLANLIST, zspmPtaskmachineplanList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.utility.c_machinecalendar_v> getMachinecalendarVList() {
        return (List<org.openbravo.model.common.utility.c_machinecalendar_v>) get(PROPERTY_MACHINECALENDARVLIST);
    }

    public void setMachinecalendarVList(
        List<org.openbravo.model.common.utility.c_machinecalendar_v> machinecalendarVList) {
        set(PROPERTY_MACHINECALENDARVLIST, machinecalendarVList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.utility.ma_machineEVENT> getMachineEVENTList() {
        return (List<org.openbravo.model.common.utility.ma_machineEVENT>) get(PROPERTY_MACHINEEVENTLIST);
    }

    public void setMachineEVENTList(
        List<org.openbravo.model.common.utility.ma_machineEVENT> machineEVENTList) {
        set(PROPERTY_MACHINEEVENTLIST, machineEVENTList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.utility.ma_machineCALENDARSETTINGS> getMachineCALENDARSETTINGSList() {
        return (List<org.openbravo.model.common.utility.ma_machineCALENDARSETTINGS>) get(PROPERTY_MACHINECALENDARSETTINGSLIST);
    }

    public void setMachineCALENDARSETTINGSList(
        List<org.openbravo.model.common.utility.ma_machineCALENDARSETTINGS> machineCALENDARSETTINGSList) {
        set(PROPERTY_MACHINECALENDARSETTINGSLIST, machineCALENDARSETTINGSList);
    }

    @SuppressWarnings("unchecked")
    public List<Zspm_ctaskmachineplan> getZspmCtaskmachineplanList() {
        return (List<Zspm_ctaskmachineplan>) get(PROPERTY_ZSPMCTASKMACHINEPLANLIST);
    }

    public void setZspmCtaskmachineplanList(
        List<Zspm_ctaskmachineplan> zspmCtaskmachineplanList) {
        set(PROPERTY_ZSPMCTASKMACHINEPLANLIST, zspmCtaskmachineplanList);
    }

    @SuppressWarnings("unchecked")
    public List<Maintenance> getManufacturingMaintenanceList() {
        return (List<Maintenance>) get(PROPERTY_MANUFACTURINGMAINTENANCELIST);
    }

    public void setManufacturingMaintenanceList(
        List<Maintenance> manufacturingMaintenanceList) {
        set(PROPERTY_MANUFACTURINGMAINTENANCELIST, manufacturingMaintenanceList);
    }
}
