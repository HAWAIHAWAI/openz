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
package org.openbravo.model.common.interaction;

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
 * Entity class for entity RequestProcessor (stored in table R_RequestProcessor).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class RequestProcessor extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "R_RequestProcessor";
    public static final String ENTITY_NAME = "RequestProcessor";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_FREQUENCY = "frequency";
    public static final String PROPERTY_FREQUENCYTYPE = "frequencyType";
    public static final String PROPERTY_DATELASTRUN = "dateLastRun";
    public static final String PROPERTY_DATENEXTRUN = "dateNextRun";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_OVERDUEALERTDAYS = "overdueAlertDays";
    public static final String PROPERTY_OVERDUEASSIGNDAYS = "overdueAssignDays";
    public static final String PROPERTY_SUPERVISOR = "supervisor";

    public RequestProcessor() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSING, false);
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Long getFrequency() {
        return (Long) get(PROPERTY_FREQUENCY);
    }

    public void setFrequency(Long frequency) {
        set(PROPERTY_FREQUENCY, frequency);
    }

    public String getFrequencyType() {
        return (String) get(PROPERTY_FREQUENCYTYPE);
    }

    public void setFrequencyType(String frequencyType) {
        set(PROPERTY_FREQUENCYTYPE, frequencyType);
    }

    public Date getDateLastRun() {
        return (Date) get(PROPERTY_DATELASTRUN);
    }

    public void setDateLastRun(Date dateLastRun) {
        set(PROPERTY_DATELASTRUN, dateLastRun);
    }

    public Date getDateNextRun() {
        return (Date) get(PROPERTY_DATENEXTRUN);
    }

    public void setDateNextRun(Date dateNextRun) {
        set(PROPERTY_DATENEXTRUN, dateNextRun);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Long getOverdueAlertDays() {
        return (Long) get(PROPERTY_OVERDUEALERTDAYS);
    }

    public void setOverdueAlertDays(Long overdueAlertDays) {
        set(PROPERTY_OVERDUEALERTDAYS, overdueAlertDays);
    }

    public Long getOverdueAssignDays() {
        return (Long) get(PROPERTY_OVERDUEASSIGNDAYS);
    }

    public void setOverdueAssignDays(Long overdueAssignDays) {
        set(PROPERTY_OVERDUEASSIGNDAYS, overdueAssignDays);
    }

    public User getSupervisor() {
        return (User) get(PROPERTY_SUPERVISOR);
    }

    public void setSupervisor(User supervisor) {
        set(PROPERTY_SUPERVISOR, supervisor);
    }
}
