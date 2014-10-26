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
package org.openz.timeservice;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.hcm.SalaryCategory;
import org.openbravo.model.manufacturing.floorshop.Machine;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectTask;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Date;

/**
 * Entity class for entity tsrv_feedback_v (stored in table tsrv_feedback_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class tsrv_feedback_v extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "tsrv_feedback_v";
    public static final String ENTITY_NAME = "tsrv_feedback_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_CALENDAREVENT = "calendarevent";
    public static final String PROPERTY_EMPLOYEE = "employee";
    public static final String PROPERTY_MACHINE = "machine";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_WORKDATE = "workdate";
    public static final String PROPERTY_HOURFROM = "hourFrom";
    public static final String PROPERTY_HOURTO = "hourTo";
    public static final String PROPERTY_ACTUALCOSTAMOUNT = "actualcostamount";
    public static final String PROPERTY_SALARYCATEGORY = "salaryCategory";
    public static final String PROPERTY_HOURS = "hours";
    public static final String PROPERTY_BREAKTIME = "breaktime";
    public static final String PROPERTY_TRAVELTIME = "traveltime";
    public static final String PROPERTY_TIMEUNDERHELMET = "timeunderhelmet";
    public static final String PROPERTY_TIMEUNDERHELMET2 = "timeunderhelmet2";
    public static final String PROPERTY_TRIGGERAMT = "triggeramt";
    public static final String PROPERTY_OVERTIMEHOURS = "overtimehours";
    public static final String PROPERTY_NIGHTHOURS = "nighthours";
    public static final String PROPERTY_ISSATURDAY = "issaturday";
    public static final String PROPERTY_ISSUNDAY = "issunday";
    public static final String PROPERTY_ISHOLIDAY = "isholiday";

    public tsrv_feedback_v() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISSATURDAY, false);
        setDefaultValue(PROPERTY_ISSUNDAY, false);
        setDefaultValue(PROPERTY_ISHOLIDAY, false);
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

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public ProjectTask getProjecttask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjecttask(ProjectTask projecttask) {
        set(PROPERTY_PROJECTTASK, projecttask);
    }

    public org.openbravo.model.common.utility.C_CALENDAREVENT getCalendarevent() {
        return (org.openbravo.model.common.utility.C_CALENDAREVENT) get(PROPERTY_CALENDAREVENT);
    }

    public void setCalendarevent(
        org.openbravo.model.common.utility.C_CALENDAREVENT calendarevent) {
        set(PROPERTY_CALENDAREVENT, calendarevent);
    }

    public User getEmployee() {
        return (User) get(PROPERTY_EMPLOYEE);
    }

    public void setEmployee(User employee) {
        set(PROPERTY_EMPLOYEE, employee);
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

    public BigDecimal getBreaktime() {
        return (BigDecimal) get(PROPERTY_BREAKTIME);
    }

    public void setBreaktime(BigDecimal breaktime) {
        set(PROPERTY_BREAKTIME, breaktime);
    }

    public BigDecimal getTraveltime() {
        return (BigDecimal) get(PROPERTY_TRAVELTIME);
    }

    public void setTraveltime(BigDecimal traveltime) {
        set(PROPERTY_TRAVELTIME, traveltime);
    }

    public BigDecimal getTimeunderhelmet() {
        return (BigDecimal) get(PROPERTY_TIMEUNDERHELMET);
    }

    public void setTimeunderhelmet(BigDecimal timeunderhelmet) {
        set(PROPERTY_TIMEUNDERHELMET, timeunderhelmet);
    }

    public BigDecimal getTimeunderhelmet2() {
        return (BigDecimal) get(PROPERTY_TIMEUNDERHELMET2);
    }

    public void setTimeunderhelmet2(BigDecimal timeunderhelmet2) {
        set(PROPERTY_TIMEUNDERHELMET2, timeunderhelmet2);
    }

    public BigDecimal getTriggeramt() {
        return (BigDecimal) get(PROPERTY_TRIGGERAMT);
    }

    public void setTriggeramt(BigDecimal triggeramt) {
        set(PROPERTY_TRIGGERAMT, triggeramt);
    }

    public BigDecimal getOvertimehours() {
        return (BigDecimal) get(PROPERTY_OVERTIMEHOURS);
    }

    public void setOvertimehours(BigDecimal overtimehours) {
        set(PROPERTY_OVERTIMEHOURS, overtimehours);
    }

    public BigDecimal getNighthours() {
        return (BigDecimal) get(PROPERTY_NIGHTHOURS);
    }

    public void setNighthours(BigDecimal nighthours) {
        set(PROPERTY_NIGHTHOURS, nighthours);
    }

    public Boolean isSaturday() {
        return (Boolean) get(PROPERTY_ISSATURDAY);
    }

    public void setSaturday(Boolean issaturday) {
        set(PROPERTY_ISSATURDAY, issaturday);
    }

    public Boolean isSunday() {
        return (Boolean) get(PROPERTY_ISSUNDAY);
    }

    public void setSunday(Boolean issunday) {
        set(PROPERTY_ISSUNDAY, issunday);
    }

    public Boolean isHoliday() {
        return (Boolean) get(PROPERTY_ISHOLIDAY);
    }

    public void setHoliday(Boolean isholiday) {
        set(PROPERTY_ISHOLIDAY, isholiday);
    }
}
