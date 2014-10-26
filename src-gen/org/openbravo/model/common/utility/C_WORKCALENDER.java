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
package org.openbravo.model.common.utility;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.sql.Timestamp;

import java.util.Date;

/**
 * Entity class for entity C_WORKCALENDER (stored in table C_WORKCALENDER).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class C_WORKCALENDER extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_WORKCALENDER";
    public static final String ENTITY_NAME = "C_WORKCALENDER";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_WORKDATE = "workdate";
    public static final String PROPERTY_WORKTIME = "worktime";
    public static final String PROPERTY_DAYNAME = "dayname";
    public static final String PROPERTY_ISWORKDAY = "isworkday";
    public static final String PROPERTY_ISWEEKEND = "isweekend";
    public static final String PROPERTY_ISHOLIDAY = "isholiday";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_WORKBEGINTIME = "workbegintime";

    public C_WORKCALENDER() {
        setDefaultValue(PROPERTY_WORKTIME, (long) 8);
        setDefaultValue(PROPERTY_ISWORKDAY, true);
        setDefaultValue(PROPERTY_ISWEEKEND, false);
        setDefaultValue(PROPERTY_ISHOLIDAY, false);
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

    public Date getWorkdate() {
        return (Date) get(PROPERTY_WORKDATE);
    }

    public void setWorkdate(Date workdate) {
        set(PROPERTY_WORKDATE, workdate);
    }

    public Long getWorktime() {
        return (Long) get(PROPERTY_WORKTIME);
    }

    public void setWorktime(Long worktime) {
        set(PROPERTY_WORKTIME, worktime);
    }

    public String getDayname() {
        return (String) get(PROPERTY_DAYNAME);
    }

    public void setDayname(String dayname) {
        set(PROPERTY_DAYNAME, dayname);
    }

    public Boolean isWorkday() {
        return (Boolean) get(PROPERTY_ISWORKDAY);
    }

    public void setWorkday(Boolean isworkday) {
        set(PROPERTY_ISWORKDAY, isworkday);
    }

    public Boolean isWeekend() {
        return (Boolean) get(PROPERTY_ISWEEKEND);
    }

    public void setWeekend(Boolean isweekend) {
        set(PROPERTY_ISWEEKEND, isweekend);
    }

    public Boolean isHoliday() {
        return (Boolean) get(PROPERTY_ISHOLIDAY);
    }

    public void setHoliday(Boolean isholiday) {
        set(PROPERTY_ISHOLIDAY, isholiday);
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

    public Timestamp getWorkbegintime() {
        return (Timestamp) get(PROPERTY_WORKBEGINTIME);
    }

    public void setWorkbegintime(Timestamp workbegintime) {
        set(PROPERTY_WORKBEGINTIME, workbegintime);
    }
}
