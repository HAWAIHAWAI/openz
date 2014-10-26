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
package org.openbravo.model.ad.ui;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ProcessRequest (stored in table AD_Process_Request).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ProcessRequest extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Process_Request";
    public static final String ENTITY_NAME = "ProcessRequest";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_ISROLESECURITY = "isrolesecurity";
    public static final String PROPERTY_CONTEXT = "context";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_NEXTFIRETIME = "nextFireTime";
    public static final String PROPERTY_PREVIOUSFIRETIME = "previousFireTime";
    public static final String PROPERTY_SCHEDULEDFINISH = "scheduledFinish";
    public static final String PROPERTY_CHANNEL = "channel";
    public static final String PROPERTY_TIMINGOPTION = "timingOption";
    public static final String PROPERTY_STARTTIME = "startTime";
    public static final String PROPERTY_STARTDATE = "startDate";
    public static final String PROPERTY_FREQUENCY = "frequency";
    public static final String PROPERTY_SECONDLYINTERVAL = "secondlyInterval";
    public static final String PROPERTY_MINUTELYINTERVAL = "minutelyInterval";
    public static final String PROPERTY_HOURLYINTERVAL = "hourlyInterval";
    public static final String PROPERTY_DAILYINTERVAL = "dailyInterval";
    public static final String PROPERTY_SECONDLYREPETITIONS =
        "secondlyRepetitions";
    public static final String PROPERTY_MINUTELYREPETITIONS =
        "minutelyRepetitions";
    public static final String PROPERTY_HOURLYREPETITIONS = "hourlyRepetitions";
    public static final String PROPERTY_DAYMON = "dAYMon";
    public static final String PROPERTY_DAYTUE = "dAYTue";
    public static final String PROPERTY_DAYWED = "dAYWed";
    public static final String PROPERTY_DAYTHU = "dAYThu";
    public static final String PROPERTY_DAYFRI = "dAYFri";
    public static final String PROPERTY_DAYSAT = "dAYSat";
    public static final String PROPERTY_DAYSUN = "dAYSun";
    public static final String PROPERTY_MONTHLYOPTION = "monthlyOption";
    public static final String PROPERTY_MONTHLYSPECIFICDAY =
        "monthlySpecificDay";
    public static final String PROPERTY_MONTHLYDAYOFWEEK = "monthlyDayOfWeek";
    public static final String PROPERTY_FINISHES = "finishes";
    public static final String PROPERTY_FINISHESTIME = "finishesTime";
    public static final String PROPERTY_FINISHESDATE = "finishesDate";
    public static final String PROPERTY_DAILYOPTION = "dailyOption";
    public static final String PROPERTY_CRON = "cron";
    public static final String PROPERTY_PROCESSSET = "processSet";
    public static final String PROPERTY_SCHEDULE = "schedule";
    public static final String PROPERTY_RESCHEDULE = "reschedule";
    public static final String PROPERTY_UNSCHEDULE = "unschedule";
    public static final String PROPERTY_PARAMS = "params";
    public static final String PROPERTY_PROCESSEXECUTIONLIST =
        "processExecutionList";

    public ProcessRequest() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISROLESECURITY, true);
        setDefaultValue(PROPERTY_CHANNEL, "Process Scheduler");
        setDefaultValue(PROPERTY_TIMINGOPTION, "I");
        setDefaultValue(PROPERTY_FREQUENCY, "4");
        setDefaultValue(PROPERTY_DAYMON, false);
        setDefaultValue(PROPERTY_DAYTUE, false);
        setDefaultValue(PROPERTY_DAYWED, false);
        setDefaultValue(PROPERTY_DAYTHU, false);
        setDefaultValue(PROPERTY_DAYFRI, false);
        setDefaultValue(PROPERTY_DAYSAT, false);
        setDefaultValue(PROPERTY_DAYSUN, false);
        setDefaultValue(PROPERTY_MONTHLYOPTION, "S");
        setDefaultValue(PROPERTY_FINISHES, false);
        setDefaultValue(PROPERTY_DAILYOPTION, "N");
        setDefaultValue(PROPERTY_SCHEDULE, false);
        setDefaultValue(PROPERTY_RESCHEDULE, false);
        setDefaultValue(PROPERTY_UNSCHEDULE, false);
        setDefaultValue(PROPERTY_PROCESSEXECUTIONLIST, new ArrayList<Object>());
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

    public Process getProcess() {
        return (Process) get(PROPERTY_PROCESS);
    }

    public void setProcess(Process process) {
        set(PROPERTY_PROCESS, process);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public Boolean isRolesecurity() {
        return (Boolean) get(PROPERTY_ISROLESECURITY);
    }

    public void setRolesecurity(Boolean isrolesecurity) {
        set(PROPERTY_ISROLESECURITY, isrolesecurity);
    }

    public String getContext() {
        return (String) get(PROPERTY_CONTEXT);
    }

    public void setContext(String context) {
        set(PROPERTY_CONTEXT, context);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public Date getNextFireTime() {
        return (Date) get(PROPERTY_NEXTFIRETIME);
    }

    public void setNextFireTime(Date nextFireTime) {
        set(PROPERTY_NEXTFIRETIME, nextFireTime);
    }

    public Date getPreviousFireTime() {
        return (Date) get(PROPERTY_PREVIOUSFIRETIME);
    }

    public void setPreviousFireTime(Date previousFireTime) {
        set(PROPERTY_PREVIOUSFIRETIME, previousFireTime);
    }

    public Date getScheduledFinish() {
        return (Date) get(PROPERTY_SCHEDULEDFINISH);
    }

    public void setScheduledFinish(Date scheduledFinish) {
        set(PROPERTY_SCHEDULEDFINISH, scheduledFinish);
    }

    public String getChannel() {
        return (String) get(PROPERTY_CHANNEL);
    }

    public void setChannel(String channel) {
        set(PROPERTY_CHANNEL, channel);
    }

    public String getTimingOption() {
        return (String) get(PROPERTY_TIMINGOPTION);
    }

    public void setTimingOption(String timingOption) {
        set(PROPERTY_TIMINGOPTION, timingOption);
    }

    public Timestamp getStartTime() {
        return (Timestamp) get(PROPERTY_STARTTIME);
    }

    public void setStartTime(Timestamp startTime) {
        set(PROPERTY_STARTTIME, startTime);
    }

    public Date getStartDate() {
        return (Date) get(PROPERTY_STARTDATE);
    }

    public void setStartDate(Date startDate) {
        set(PROPERTY_STARTDATE, startDate);
    }

    public String getFrequency() {
        return (String) get(PROPERTY_FREQUENCY);
    }

    public void setFrequency(String frequency) {
        set(PROPERTY_FREQUENCY, frequency);
    }

    public Long getSecondlyInterval() {
        return (Long) get(PROPERTY_SECONDLYINTERVAL);
    }

    public void setSecondlyInterval(Long secondlyInterval) {
        set(PROPERTY_SECONDLYINTERVAL, secondlyInterval);
    }

    public Long getMinutelyInterval() {
        return (Long) get(PROPERTY_MINUTELYINTERVAL);
    }

    public void setMinutelyInterval(Long minutelyInterval) {
        set(PROPERTY_MINUTELYINTERVAL, minutelyInterval);
    }

    public Long getHourlyInterval() {
        return (Long) get(PROPERTY_HOURLYINTERVAL);
    }

    public void setHourlyInterval(Long hourlyInterval) {
        set(PROPERTY_HOURLYINTERVAL, hourlyInterval);
    }

    public Long getDailyInterval() {
        return (Long) get(PROPERTY_DAILYINTERVAL);
    }

    public void setDailyInterval(Long dailyInterval) {
        set(PROPERTY_DAILYINTERVAL, dailyInterval);
    }

    public Long getSecondlyRepetitions() {
        return (Long) get(PROPERTY_SECONDLYREPETITIONS);
    }

    public void setSecondlyRepetitions(Long secondlyRepetitions) {
        set(PROPERTY_SECONDLYREPETITIONS, secondlyRepetitions);
    }

    public Long getMinutelyRepetitions() {
        return (Long) get(PROPERTY_MINUTELYREPETITIONS);
    }

    public void setMinutelyRepetitions(Long minutelyRepetitions) {
        set(PROPERTY_MINUTELYREPETITIONS, minutelyRepetitions);
    }

    public Long getHourlyRepetitions() {
        return (Long) get(PROPERTY_HOURLYREPETITIONS);
    }

    public void setHourlyRepetitions(Long hourlyRepetitions) {
        set(PROPERTY_HOURLYREPETITIONS, hourlyRepetitions);
    }

    public Boolean isDAYMon() {
        return (Boolean) get(PROPERTY_DAYMON);
    }

    public void setDAYMon(Boolean dAYMon) {
        set(PROPERTY_DAYMON, dAYMon);
    }

    public Boolean isDAYTue() {
        return (Boolean) get(PROPERTY_DAYTUE);
    }

    public void setDAYTue(Boolean dAYTue) {
        set(PROPERTY_DAYTUE, dAYTue);
    }

    public Boolean isDAYWed() {
        return (Boolean) get(PROPERTY_DAYWED);
    }

    public void setDAYWed(Boolean dAYWed) {
        set(PROPERTY_DAYWED, dAYWed);
    }

    public Boolean isDAYThu() {
        return (Boolean) get(PROPERTY_DAYTHU);
    }

    public void setDAYThu(Boolean dAYThu) {
        set(PROPERTY_DAYTHU, dAYThu);
    }

    public Boolean isDAYFri() {
        return (Boolean) get(PROPERTY_DAYFRI);
    }

    public void setDAYFri(Boolean dAYFri) {
        set(PROPERTY_DAYFRI, dAYFri);
    }

    public Boolean isDAYSat() {
        return (Boolean) get(PROPERTY_DAYSAT);
    }

    public void setDAYSat(Boolean dAYSat) {
        set(PROPERTY_DAYSAT, dAYSat);
    }

    public Boolean isDAYSun() {
        return (Boolean) get(PROPERTY_DAYSUN);
    }

    public void setDAYSun(Boolean dAYSun) {
        set(PROPERTY_DAYSUN, dAYSun);
    }

    public String getMonthlyOption() {
        return (String) get(PROPERTY_MONTHLYOPTION);
    }

    public void setMonthlyOption(String monthlyOption) {
        set(PROPERTY_MONTHLYOPTION, monthlyOption);
    }

    public Long getMonthlySpecificDay() {
        return (Long) get(PROPERTY_MONTHLYSPECIFICDAY);
    }

    public void setMonthlySpecificDay(Long monthlySpecificDay) {
        set(PROPERTY_MONTHLYSPECIFICDAY, monthlySpecificDay);
    }

    public String getMonthlyDayOfWeek() {
        return (String) get(PROPERTY_MONTHLYDAYOFWEEK);
    }

    public void setMonthlyDayOfWeek(String monthlyDayOfWeek) {
        set(PROPERTY_MONTHLYDAYOFWEEK, monthlyDayOfWeek);
    }

    public Boolean isFinishes() {
        return (Boolean) get(PROPERTY_FINISHES);
    }

    public void setFinishes(Boolean finishes) {
        set(PROPERTY_FINISHES, finishes);
    }

    public Timestamp getFinishesTime() {
        return (Timestamp) get(PROPERTY_FINISHESTIME);
    }

    public void setFinishesTime(Timestamp finishesTime) {
        set(PROPERTY_FINISHESTIME, finishesTime);
    }

    public Date getFinishesDate() {
        return (Date) get(PROPERTY_FINISHESDATE);
    }

    public void setFinishesDate(Date finishesDate) {
        set(PROPERTY_FINISHESDATE, finishesDate);
    }

    public String getDailyOption() {
        return (String) get(PROPERTY_DAILYOPTION);
    }

    public void setDailyOption(String dailyOption) {
        set(PROPERTY_DAILYOPTION, dailyOption);
    }

    public String getCron() {
        return (String) get(PROPERTY_CRON);
    }

    public void setCron(String cron) {
        set(PROPERTY_CRON, cron);
    }

    public String getProcessSet() {
        return (String) get(PROPERTY_PROCESSSET);
    }

    public void setProcessSet(String processSet) {
        set(PROPERTY_PROCESSSET, processSet);
    }

    public Boolean isSchedule() {
        return (Boolean) get(PROPERTY_SCHEDULE);
    }

    public void setSchedule(Boolean schedule) {
        set(PROPERTY_SCHEDULE, schedule);
    }

    public Boolean isReschedule() {
        return (Boolean) get(PROPERTY_RESCHEDULE);
    }

    public void setReschedule(Boolean reschedule) {
        set(PROPERTY_RESCHEDULE, reschedule);
    }

    public Boolean isUnschedule() {
        return (Boolean) get(PROPERTY_UNSCHEDULE);
    }

    public void setUnschedule(Boolean unschedule) {
        set(PROPERTY_UNSCHEDULE, unschedule);
    }

    public String getParams() {
        return (String) get(PROPERTY_PARAMS);
    }

    public void setParams(String params) {
        set(PROPERTY_PARAMS, params);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessExecution> getProcessExecutionList() {
        return (List<ProcessExecution>) get(PROPERTY_PROCESSEXECUTIONLIST);
    }

    public void setProcessExecutionList(
        List<ProcessExecution> processExecutionList) {
        set(PROPERTY_PROCESSEXECUTIONLIST, processExecutionList);
    }
}
