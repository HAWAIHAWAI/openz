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

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity zssm_workstepactivities_v (stored in table zssm_workstepactivities_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class zssm_workstepactivities_v extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zssm_workstepactivities_v";
    public static final String ENTITY_NAME = "zssm_workstepactivities_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ZSPMPTASKHRPLAN = "zspmPTaskHRPlan";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ZSSMWORKSTEPV = "zssmWorkstepV";
    public static final String PROPERTY_ZSSMWORKSTEPPRPV = "zssmWorkstepPrpV";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SALARYCATEGORY = "salaryCategory";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_PLANNEDQUANTITY = "plannedQuantity";
    public static final String PROPERTY_COSTUOM = "costuom";
    public static final String PROPERTY_AVERAGEDURATION = "averageDuration";
    public static final String PROPERTY_PLANNEDAVERAGEDURATION =
        "plannedAverageduration";
    public static final String PROPERTY_DURATIONUNIT = "durationUnit";
    public static final String PROPERTY_PLANNEDDURATIONUNIT =
        "plannedDurationunit";
    public static final String PROPERTY_ZSSMSECTION = "zssmSection";
    public static final String PROPERTY_EMPLOYEE = "employee";
    public static final String PROPERTY_DATEFROM = "datefrom";
    public static final String PROPERTY_SPECIFICATION = "specification";
    public static final String PROPERTY_SHIFT = "shift";

    public zssm_workstepactivities_v() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_QUANTITY, (long) 1);
        setDefaultValue(PROPERTY_COSTUOM, "H");
        setDefaultValue(PROPERTY_AVERAGEDURATION, new BigDecimal(1));
        setDefaultValue(PROPERTY_DURATIONUNIT, "1");
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

    public String getZspmPTaskHRPlan() {
        return (String) get(PROPERTY_ZSPMPTASKHRPLAN);
    }

    public void setZspmPTaskHRPlan(String zspmPTaskHRPlan) {
        set(PROPERTY_ZSPMPTASKHRPLAN, zspmPTaskHRPlan);
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

    public org.openbravo.zsoft.serprod.zssm_workstep_v getZssmWorkstepV() {
        return (org.openbravo.zsoft.serprod.zssm_workstep_v) get(PROPERTY_ZSSMWORKSTEPV);
    }

    public void setZssmWorkstepV(
        org.openbravo.zsoft.serprod.zssm_workstep_v zssmWorkstepV) {
        set(PROPERTY_ZSSMWORKSTEPV, zssmWorkstepV);
    }

    public org.openbravo.zsoft.serprod.zssm_workstep_prp_v getZssmWorkstepPrpV() {
        return (org.openbravo.zsoft.serprod.zssm_workstep_prp_v) get(PROPERTY_ZSSMWORKSTEPPRPV);
    }

    public void setZssmWorkstepPrpV(
        org.openbravo.zsoft.serprod.zssm_workstep_prp_v zssmWorkstepPrpV) {
        set(PROPERTY_ZSSMWORKSTEPPRPV, zssmWorkstepPrpV);
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

    public SalaryCategory getSalaryCategory() {
        return (SalaryCategory) get(PROPERTY_SALARYCATEGORY);
    }

    public void setSalaryCategory(SalaryCategory salaryCategory) {
        set(PROPERTY_SALARYCATEGORY, salaryCategory);
    }

    public Long getQuantity() {
        return (Long) get(PROPERTY_QUANTITY);
    }

    public void setQuantity(Long quantity) {
        set(PROPERTY_QUANTITY, quantity);
    }

    public Long getPlannedQuantity() {
        return (Long) get(PROPERTY_PLANNEDQUANTITY);
    }

    public void setPlannedQuantity(Long plannedQuantity) {
        set(PROPERTY_PLANNEDQUANTITY, plannedQuantity);
    }

    public String getCostuom() {
        return (String) get(PROPERTY_COSTUOM);
    }

    public void setCostuom(String costuom) {
        set(PROPERTY_COSTUOM, costuom);
    }

    public BigDecimal getAverageDuration() {
        return (BigDecimal) get(PROPERTY_AVERAGEDURATION);
    }

    public void setAverageDuration(BigDecimal averageDuration) {
        set(PROPERTY_AVERAGEDURATION, averageDuration);
    }

    public Long getPlannedAverageduration() {
        return (Long) get(PROPERTY_PLANNEDAVERAGEDURATION);
    }

    public void setPlannedAverageduration(Long plannedAverageduration) {
        set(PROPERTY_PLANNEDAVERAGEDURATION, plannedAverageduration);
    }

    public String getDurationUnit() {
        return (String) get(PROPERTY_DURATIONUNIT);
    }

    public void setDurationUnit(String durationUnit) {
        set(PROPERTY_DURATIONUNIT, durationUnit);
    }

    public String getPlannedDurationunit() {
        return (String) get(PROPERTY_PLANNEDDURATIONUNIT);
    }

    public void setPlannedDurationunit(String plannedDurationunit) {
        set(PROPERTY_PLANNEDDURATIONUNIT, plannedDurationunit);
    }

    public org.openbravo.zsoft.serprod.zssm_section getZssmSection() {
        return (org.openbravo.zsoft.serprod.zssm_section) get(PROPERTY_ZSSMSECTION);
    }

    public void setZssmSection(
        org.openbravo.zsoft.serprod.zssm_section zssmSection) {
        set(PROPERTY_ZSSMSECTION, zssmSection);
    }

    public User getEmployee() {
        return (User) get(PROPERTY_EMPLOYEE);
    }

    public void setEmployee(User employee) {
        set(PROPERTY_EMPLOYEE, employee);
    }

    public Date getDatefrom() {
        return (Date) get(PROPERTY_DATEFROM);
    }

    public void setDatefrom(Date datefrom) {
        set(PROPERTY_DATEFROM, datefrom);
    }

    public BigDecimal getSpecification() {
        return (BigDecimal) get(PROPERTY_SPECIFICATION);
    }

    public void setSpecification(BigDecimal specification) {
        set(PROPERTY_SPECIFICATION, specification);
    }

    public String getShift() {
        return (String) get(PROPERTY_SHIFT);
    }

    public void setShift(String shift) {
        set(PROPERTY_SHIFT, shift);
    }
}
