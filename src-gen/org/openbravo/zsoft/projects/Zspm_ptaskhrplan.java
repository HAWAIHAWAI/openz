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
package org.openbravo.zsoft.projects;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.hcm.SalaryCategory;
import org.openbravo.model.project.ProjectTask;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity zspm_ptaskhrplan (stored in table zspm_ptaskhrplan).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Zspm_ptaskhrplan extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zspm_ptaskhrplan";
    public static final String ENTITY_NAME = "zspm_ptaskhrplan";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SALARYCATEGORY = "salaryCategory";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_COSTUOM = "costuom";
    public static final String PROPERTY_EMPLOYEE = "employee";
    public static final String PROPERTY_OVERTIMEHOURS = "overtimehours";
    public static final String PROPERTY_NIGHTHOURS = "nighthours";
    public static final String PROPERTY_SATURDAY = "saturday";
    public static final String PROPERTY_SUNDAY = "sunday";
    public static final String PROPERTY_HOLIDAY = "holiday";
    public static final String PROPERTY_PLANNEDAMT = "plannedamt";
    public static final String PROPERTY_PLANNDEDPERCENT = "planndedpercent";
    public static final String PROPERTY_TRIGGERAMT = "triggeramt";
    public static final String PROPERTY_SPECIALTIME2 = "specialtime2";
    public static final String PROPERTY_SPECIALTIME1 = "specialtime1";
    public static final String PROPERTY_DATEFROM = "datefrom";
    public static final String PROPERTY_DATETO = "dateto";
    public static final String PROPERTY_SEQNO = "seqno";

    public Zspm_ptaskhrplan() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_QUANTITY, (long) 1);
        setDefaultValue(PROPERTY_COSTUOM, "H");
        setDefaultValue(PROPERTY_OVERTIMEHOURS, (long) 0);
        setDefaultValue(PROPERTY_NIGHTHOURS, (long) 0);
        setDefaultValue(PROPERTY_SATURDAY, (long) 0);
        setDefaultValue(PROPERTY_SUNDAY, (long) 0);
        setDefaultValue(PROPERTY_HOLIDAY, (long) 0);
        setDefaultValue(PROPERTY_PLANNEDAMT, (long) 0);
        setDefaultValue(PROPERTY_PLANNDEDPERCENT, (long) 0);
        setDefaultValue(PROPERTY_TRIGGERAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_SPECIALTIME2, (long) 0);
        setDefaultValue(PROPERTY_SPECIALTIME1, (long) 0);
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

    public ProjectTask getProjecttask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjecttask(ProjectTask projecttask) {
        set(PROPERTY_PROJECTTASK, projecttask);
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

    public String getCostuom() {
        return (String) get(PROPERTY_COSTUOM);
    }

    public void setCostuom(String costuom) {
        set(PROPERTY_COSTUOM, costuom);
    }

    public User getEmployee() {
        return (User) get(PROPERTY_EMPLOYEE);
    }

    public void setEmployee(User employee) {
        set(PROPERTY_EMPLOYEE, employee);
    }

    public Long getOvertimehours() {
        return (Long) get(PROPERTY_OVERTIMEHOURS);
    }

    public void setOvertimehours(Long overtimehours) {
        set(PROPERTY_OVERTIMEHOURS, overtimehours);
    }

    public Long getNighthours() {
        return (Long) get(PROPERTY_NIGHTHOURS);
    }

    public void setNighthours(Long nighthours) {
        set(PROPERTY_NIGHTHOURS, nighthours);
    }

    public Long getSaturday() {
        return (Long) get(PROPERTY_SATURDAY);
    }

    public void setSaturday(Long saturday) {
        set(PROPERTY_SATURDAY, saturday);
    }

    public Long getSunday() {
        return (Long) get(PROPERTY_SUNDAY);
    }

    public void setSunday(Long sunday) {
        set(PROPERTY_SUNDAY, sunday);
    }

    public Long getHoliday() {
        return (Long) get(PROPERTY_HOLIDAY);
    }

    public void setHoliday(Long holiday) {
        set(PROPERTY_HOLIDAY, holiday);
    }

    public Long getPlannedamt() {
        return (Long) get(PROPERTY_PLANNEDAMT);
    }

    public void setPlannedamt(Long plannedamt) {
        set(PROPERTY_PLANNEDAMT, plannedamt);
    }

    public Long getPlanndedpercent() {
        return (Long) get(PROPERTY_PLANNDEDPERCENT);
    }

    public void setPlanndedpercent(Long planndedpercent) {
        set(PROPERTY_PLANNDEDPERCENT, planndedpercent);
    }

    public BigDecimal getTriggeramt() {
        return (BigDecimal) get(PROPERTY_TRIGGERAMT);
    }

    public void setTriggeramt(BigDecimal triggeramt) {
        set(PROPERTY_TRIGGERAMT, triggeramt);
    }

    public Long getSpecialtime2() {
        return (Long) get(PROPERTY_SPECIALTIME2);
    }

    public void setSpecialtime2(Long specialtime2) {
        set(PROPERTY_SPECIALTIME2, specialtime2);
    }

    public Long getSpecialtime1() {
        return (Long) get(PROPERTY_SPECIALTIME1);
    }

    public void setSpecialtime1(Long specialtime1) {
        set(PROPERTY_SPECIALTIME1, specialtime1);
    }

    public Date getDatefrom() {
        return (Date) get(PROPERTY_DATEFROM);
    }

    public void setDatefrom(Date datefrom) {
        set(PROPERTY_DATEFROM, datefrom);
    }

    public Date getDateto() {
        return (Date) get(PROPERTY_DATETO);
    }

    public void setDateto(Date dateto) {
        set(PROPERTY_DATETO, dateto);
    }

    public Long getSeqno() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqno(Long seqno) {
        set(PROPERTY_SEQNO, seqno);
    }
}
