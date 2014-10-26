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

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Date;

/**
 * Entity class for entity c_additionalfees (stored in table c_additionalfees).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class c_additionalfees extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "c_additionalfees";
    public static final String ENTITY_NAME = "c_additionalfees";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_VALIDFROM = "validfrom";
    public static final String PROPERTY_SATURDAY = "saturday";
    public static final String PROPERTY_SUNDAY = "sunday";
    public static final String PROPERTY_HOLIDAY = "holiday";
    public static final String PROPERTY_NIGHT = "night";
    public static final String PROPERTY_OVERTIME = "overtime";
    public static final String PROPERTY_OVERTIMEBEGIN = "overtimebegin";
    public static final String PROPERTY_NIGHTBEGIN = "nightbegin";
    public static final String PROPERTY_NIGHTEND = "nightend";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";

    public c_additionalfees() {
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

    public Long getNight() {
        return (Long) get(PROPERTY_NIGHT);
    }

    public void setNight(Long night) {
        set(PROPERTY_NIGHT, night);
    }

    public Long getOvertime() {
        return (Long) get(PROPERTY_OVERTIME);
    }

    public void setOvertime(Long overtime) {
        set(PROPERTY_OVERTIME, overtime);
    }

    public BigDecimal getOvertimebegin() {
        return (BigDecimal) get(PROPERTY_OVERTIMEBEGIN);
    }

    public void setOvertimebegin(BigDecimal overtimebegin) {
        set(PROPERTY_OVERTIMEBEGIN, overtimebegin);
    }

    public Timestamp getNightbegin() {
        return (Timestamp) get(PROPERTY_NIGHTBEGIN);
    }

    public void setNightbegin(Timestamp nightbegin) {
        set(PROPERTY_NIGHTBEGIN, nightbegin);
    }

    public Timestamp getNightend() {
        return (Timestamp) get(PROPERTY_NIGHTEND);
    }

    public void setNightend(Timestamp nightend) {
        set(PROPERTY_NIGHTEND, nightend);
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
