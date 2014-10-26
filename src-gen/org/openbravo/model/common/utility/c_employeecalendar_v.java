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
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity c_employeecalendar_v (stored in table c_employeecalendar_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class c_employeecalendar_v extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "c_employeecalendar_v";
    public static final String ENTITY_NAME = "c_employeecalendar_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_EVENT = "event";
    public static final String PROPERTY_WORKTIMEPLAN = "worktimeplan";
    public static final String PROPERTY_WORKBEGINTIME = "workbegintime";
    public static final String PROPERTY_WORKDATE = "workdate";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_PROJECTSPLAN = "projectsplan";
    public static final String PROPERTY_PROJECTSWORKED = "projectsworked";
    public static final String PROPERTY_WORKTIME = "worktime";
    public static final String PROPERTY_PERCENTUSED = "percentused";
    public static final String PROPERTY_PERCENTPLANNED = "percentplanned";

    public c_employeecalendar_v() {
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

    public Organization getOrg() {
        return (Organization) get(PROPERTY_ORG);
    }

    public void setOrg(Organization org) {
        set(PROPERTY_ORG, org);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
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

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ISACTIVE);
    }

    public void setActive(Boolean isactive) {
        set(PROPERTY_ISACTIVE, isactive);
    }

    public String getEvent() {
        return (String) get(PROPERTY_EVENT);
    }

    public void setEvent(String event) {
        set(PROPERTY_EVENT, event);
    }

    public Long getWorktimeplan() {
        return (Long) get(PROPERTY_WORKTIMEPLAN);
    }

    public void setWorktimeplan(Long worktimeplan) {
        set(PROPERTY_WORKTIMEPLAN, worktimeplan);
    }

    public String getWorkbegintime() {
        return (String) get(PROPERTY_WORKBEGINTIME);
    }

    public void setWorkbegintime(String workbegintime) {
        set(PROPERTY_WORKBEGINTIME, workbegintime);
    }

    public Date getWorkdate() {
        return (Date) get(PROPERTY_WORKDATE);
    }

    public void setWorkdate(Date workdate) {
        set(PROPERTY_WORKDATE, workdate);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public String getProjectsplan() {
        return (String) get(PROPERTY_PROJECTSPLAN);
    }

    public void setProjectsplan(String projectsplan) {
        set(PROPERTY_PROJECTSPLAN, projectsplan);
    }

    public String getProjectsworked() {
        return (String) get(PROPERTY_PROJECTSWORKED);
    }

    public void setProjectsworked(String projectsworked) {
        set(PROPERTY_PROJECTSWORKED, projectsworked);
    }

    public Long getWorktime() {
        return (Long) get(PROPERTY_WORKTIME);
    }

    public void setWorktime(Long worktime) {
        set(PROPERTY_WORKTIME, worktime);
    }

    public Long getPercentused() {
        return (Long) get(PROPERTY_PERCENTUSED);
    }

    public void setPercentused(Long percentused) {
        set(PROPERTY_PERCENTUSED, percentused);
    }

    public Long getPercentplanned() {
        return (Long) get(PROPERTY_PERCENTPLANNED);
    }

    public void setPercentplanned(Long percentplanned) {
        set(PROPERTY_PERCENTPLANNED, percentplanned);
    }
}
