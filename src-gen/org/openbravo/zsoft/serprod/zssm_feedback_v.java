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
package org.openbravo.zsoft.serprod;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.hcm.SalaryCategory;
import org.openbravo.model.manufacturing.floorshop.Machine;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Date;

/**
 * Entity class for entity zssm_feedback_v (stored in table zssm_feedback_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class zssm_feedback_v extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zssm_feedback_v";
    public static final String ENTITY_NAME = "zssm_feedback_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ZSSMPRODUCTIONORDERV =
        "zssmProductionorderV";
    public static final String PROPERTY_ZSSMWORKSTEPV = "zssmWorkstepV";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_MACHINE = "machine";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_WORKDATE = "workdate";
    public static final String PROPERTY_HOURFROM = "hourFrom";
    public static final String PROPERTY_HOURTO = "hourTo";
    public static final String PROPERTY_ACTUALCOSTAMOUNT = "actualcostamount";
    public static final String PROPERTY_SALARYCATEGORY = "salaryCategory";
    public static final String PROPERTY_HOURS = "hours";
    public static final String PROPERTY_URL = "url";

    public zssm_feedback_v() {
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

    public org.openbravo.zsoft.serprod.zssm_productionorder_v getZssmProductionorderV() {
        return (org.openbravo.zsoft.serprod.zssm_productionorder_v) get(PROPERTY_ZSSMPRODUCTIONORDERV);
    }

    public void setZssmProductionorderV(
        org.openbravo.zsoft.serprod.zssm_productionorder_v zssmProductionorderV) {
        set(PROPERTY_ZSSMPRODUCTIONORDERV, zssmProductionorderV);
    }

    public org.openbravo.zsoft.serprod.zssm_workstep_v getZssmWorkstepV() {
        return (org.openbravo.zsoft.serprod.zssm_workstep_v) get(PROPERTY_ZSSMWORKSTEPV);
    }

    public void setZssmWorkstepV(
        org.openbravo.zsoft.serprod.zssm_workstep_v zssmWorkstepV) {
        set(PROPERTY_ZSSMWORKSTEPV, zssmWorkstepV);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public Machine getMachine() {
        return (Machine) get(PROPERTY_MACHINE);
    }

    public void setMachine(Machine machine) {
        set(PROPERTY_MACHINE, machine);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Date getWorkdate() {
        return (Date) get(PROPERTY_WORKDATE);
    }

    public void setWorkdate(Date workdate) {
        set(PROPERTY_WORKDATE, workdate);
    }

    public Timestamp getHourFrom() {
        return (Timestamp) get(PROPERTY_HOURFROM);
    }

    public void setHourFrom(Timestamp hourFrom) {
        set(PROPERTY_HOURFROM, hourFrom);
    }

    public Timestamp getHourTo() {
        return (Timestamp) get(PROPERTY_HOURTO);
    }

    public void setHourTo(Timestamp hourTo) {
        set(PROPERTY_HOURTO, hourTo);
    }

    public BigDecimal getActualcostamount() {
        return (BigDecimal) get(PROPERTY_ACTUALCOSTAMOUNT);
    }

    public void setActualcostamount(BigDecimal actualcostamount) {
        set(PROPERTY_ACTUALCOSTAMOUNT, actualcostamount);
    }

    public SalaryCategory getSalaryCategory() {
        return (SalaryCategory) get(PROPERTY_SALARYCATEGORY);
    }

    public void setSalaryCategory(SalaryCategory salaryCategory) {
        set(PROPERTY_SALARYCATEGORY, salaryCategory);
    }

    public BigDecimal getHours() {
        return (BigDecimal) get(PROPERTY_HOURS);
    }

    public void setHours(BigDecimal hours) {
        set(PROPERTY_HOURS, hours);
    }

    public String getUrl() {
        return (String) get(PROPERTY_URL);
    }

    public void setUrl(String url) {
        set(PROPERTY_URL, url);
    }
}
