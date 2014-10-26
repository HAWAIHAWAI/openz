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

import java.util.Date;

/**
 * Entity class for entity C_CALENDAREVENT (stored in table C_CALENDAREVENT).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class C_CALENDAREVENT extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_CALENDAREVENT";
    public static final String ENTITY_NAME = "C_CALENDAREVENT";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_WORKTIME = "worktime";
    public static final String PROPERTY_REMINDER = "reminder";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_ISHOLYDAY = "isholyday";
    public static final String PROPERTY_ISWORKCALENDAR = "isworkcalendar";
    public static final String PROPERTY_ISEMPLOYEECALENDAR =
        "isemployeecalendar";
    public static final String PROPERTY_ISMACHINECALENDAR = "ismachinecalendar";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CORRELATION = "correlation";
    public static final String PROPERTY_COLOR = "color";

    public C_CALENDAREVENT() {
        setDefaultValue(PROPERTY_REMINDER, false);
        setDefaultValue(PROPERTY_ISHOLYDAY, false);
        setDefaultValue(PROPERTY_ISWORKCALENDAR, false);
        setDefaultValue(PROPERTY_ISEMPLOYEECALENDAR, false);
        setDefaultValue(PROPERTY_ISMACHINECALENDAR, false);
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

    public Long getWorktime() {
        return (Long) get(PROPERTY_WORKTIME);
    }

    public void setWorktime(Long worktime) {
        set(PROPERTY_WORKTIME, worktime);
    }

    public Boolean isReminder() {
        return (Boolean) get(PROPERTY_REMINDER);
    }

    public void setReminder(Boolean reminder) {
        set(PROPERTY_REMINDER, reminder);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public Boolean isHolyday() {
        return (Boolean) get(PROPERTY_ISHOLYDAY);
    }

    public void setHolyday(Boolean isholyday) {
        set(PROPERTY_ISHOLYDAY, isholyday);
    }

    public Boolean isWorkcalendar() {
        return (Boolean) get(PROPERTY_ISWORKCALENDAR);
    }

    public void setWorkcalendar(Boolean isworkcalendar) {
        set(PROPERTY_ISWORKCALENDAR, isworkcalendar);
    }

    public Boolean isEmployeecalendar() {
        return (Boolean) get(PROPERTY_ISEMPLOYEECALENDAR);
    }

    public void setEmployeecalendar(Boolean isemployeecalendar) {
        set(PROPERTY_ISEMPLOYEECALENDAR, isemployeecalendar);
    }

    public Boolean isMachinecalendar() {
        return (Boolean) get(PROPERTY_ISMACHINECALENDAR);
    }

    public void setMachinecalendar(Boolean ismachinecalendar) {
        set(PROPERTY_ISMACHINECALENDAR, ismachinecalendar);
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

    public String getCorrelation() {
        return (String) get(PROPERTY_CORRELATION);
    }

    public void setCorrelation(String correlation) {
        set(PROPERTY_CORRELATION, correlation);
    }

    public org.openbravo.model.common.enterprise.c_color getColor() {
        return (org.openbravo.model.common.enterprise.c_color) get(PROPERTY_COLOR);
    }

    public void setColor(org.openbravo.model.common.enterprise.c_color color) {
        set(PROPERTY_COLOR, color);
    }
}
