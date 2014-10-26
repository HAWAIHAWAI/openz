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
 * Entity class for entity C_WORKCALENDARSETTINGS (stored in table C_WORKCALENDARSETTINGS).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class C_WORKCALENDARSETTINGS extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_WORKCALENDARSETTINGS";
    public static final String ENTITY_NAME = "C_WORKCALENDARSETTINGS";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_VALIDFROM = "validfrom";
    public static final String PROPERTY_WORKTIMEMONDAY = "worktimemonday";
    public static final String PROPERTY_WORKBEGINTIMEMONDAY =
        "workbegintimemonday";
    public static final String PROPERTY_WORKTIMETUESDAY = "worktimetuesday";
    public static final String PROPERTY_WORKBEGINTIMETUESDAY =
        "workbegintimetuesday";
    public static final String PROPERTY_WORKTIMEWEDNESDAY = "worktimewednesday";
    public static final String PROPERTY_WORKBEGINTIMEWEDNESDAY =
        "workbegintimewednesday";
    public static final String PROPERTY_WORKTIMETHURSDAY = "worktimethursday";
    public static final String PROPERTY_WORKBEGINTIMETHURSDAY =
        "workbegintimethursday";
    public static final String PROPERTY_WORKTIMEFRIDAY = "worktimefriday";
    public static final String PROPERTY_WORKBEGINTIMEFRIDAY =
        "workbegintimefriday";
    public static final String PROPERTY_WORKTIMESATURDAY = "worktimesaturday";
    public static final String PROPERTY_WORKBEGINTIMESATURDAY =
        "workbegintimesaturday";
    public static final String PROPERTY_WORKTIMESUNDAY = "worktimesunday";
    public static final String PROPERTY_WORKBEGINTIMESUNDAY =
        "workbegintimesunday";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";

    public C_WORKCALENDARSETTINGS() {
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

    public Date getValidfrom() {
        return (Date) get(PROPERTY_VALIDFROM);
    }

    public void setValidfrom(Date validfrom) {
        set(PROPERTY_VALIDFROM, validfrom);
    }

    public Long getWorktimemonday() {
        return (Long) get(PROPERTY_WORKTIMEMONDAY);
    }

    public void setWorktimemonday(Long worktimemonday) {
        set(PROPERTY_WORKTIMEMONDAY, worktimemonday);
    }

    public Timestamp getWorkbegintimemonday() {
        return (Timestamp) get(PROPERTY_WORKBEGINTIMEMONDAY);
    }

    public void setWorkbegintimemonday(Timestamp workbegintimemonday) {
        set(PROPERTY_WORKBEGINTIMEMONDAY, workbegintimemonday);
    }

    public Long getWorktimetuesday() {
        return (Long) get(PROPERTY_WORKTIMETUESDAY);
    }

    public void setWorktimetuesday(Long worktimetuesday) {
        set(PROPERTY_WORKTIMETUESDAY, worktimetuesday);
    }

    public Timestamp getWorkbegintimetuesday() {
        return (Timestamp) get(PROPERTY_WORKBEGINTIMETUESDAY);
    }

    public void setWorkbegintimetuesday(Timestamp workbegintimetuesday) {
        set(PROPERTY_WORKBEGINTIMETUESDAY, workbegintimetuesday);
    }

    public Long getWorktimewednesday() {
        return (Long) get(PROPERTY_WORKTIMEWEDNESDAY);
    }

    public void setWorktimewednesday(Long worktimewednesday) {
        set(PROPERTY_WORKTIMEWEDNESDAY, worktimewednesday);
    }

    public Timestamp getWorkbegintimewednesday() {
        return (Timestamp) get(PROPERTY_WORKBEGINTIMEWEDNESDAY);
    }

    public void setWorkbegintimewednesday(Timestamp workbegintimewednesday) {
        set(PROPERTY_WORKBEGINTIMEWEDNESDAY, workbegintimewednesday);
    }

    public Long getWorktimethursday() {
        return (Long) get(PROPERTY_WORKTIMETHURSDAY);
    }

    public void setWorktimethursday(Long worktimethursday) {
        set(PROPERTY_WORKTIMETHURSDAY, worktimethursday);
    }

    public Timestamp getWorkbegintimethursday() {
        return (Timestamp) get(PROPERTY_WORKBEGINTIMETHURSDAY);
    }

    public void setWorkbegintimethursday(Timestamp workbegintimethursday) {
        set(PROPERTY_WORKBEGINTIMETHURSDAY, workbegintimethursday);
    }

    public Long getWorktimefriday() {
        return (Long) get(PROPERTY_WORKTIMEFRIDAY);
    }

    public void setWorktimefriday(Long worktimefriday) {
        set(PROPERTY_WORKTIMEFRIDAY, worktimefriday);
    }

    public Timestamp getWorkbegintimefriday() {
        return (Timestamp) get(PROPERTY_WORKBEGINTIMEFRIDAY);
    }

    public void setWorkbegintimefriday(Timestamp workbegintimefriday) {
        set(PROPERTY_WORKBEGINTIMEFRIDAY, workbegintimefriday);
    }

    public Long getWorktimesaturday() {
        return (Long) get(PROPERTY_WORKTIMESATURDAY);
    }

    public void setWorktimesaturday(Long worktimesaturday) {
        set(PROPERTY_WORKTIMESATURDAY, worktimesaturday);
    }

    public Timestamp getWorkbegintimesaturday() {
        return (Timestamp) get(PROPERTY_WORKBEGINTIMESATURDAY);
    }

    public void setWorkbegintimesaturday(Timestamp workbegintimesaturday) {
        set(PROPERTY_WORKBEGINTIMESATURDAY, workbegintimesaturday);
    }

    public Long getWorktimesunday() {
        return (Long) get(PROPERTY_WORKTIMESUNDAY);
    }

    public void setWorktimesunday(Long worktimesunday) {
        set(PROPERTY_WORKTIMESUNDAY, worktimesunday);
    }

    public Timestamp getWorkbegintimesunday() {
        return (Timestamp) get(PROPERTY_WORKBEGINTIMESUNDAY);
    }

    public void setWorkbegintimesunday(Timestamp workbegintimesunday) {
        set(PROPERTY_WORKBEGINTIMESUNDAY, workbegintimesunday);
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
}
