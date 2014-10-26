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
package org.openbravo.model.financialmgmt.calendar;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.OrganizationClosing;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity FinancialMgmtYear (stored in table C_Year).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Year extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Year";
    public static final String ENTITY_NAME = "FinancialMgmtYear";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_CALENDAR = "calendar";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_CREATEREGFACTACCT = "createRegFactAcct";
    public static final String PROPERTY_DROPREGFACTACCT = "dropRegFactAcct";
    public static final String PROPERTY_ORGANIZATIONCLOSINGLIST =
        "organizationClosingList";
    public static final String PROPERTY_FINANCIALMGMTPERIODLIST =
        "financialMgmtPeriodList";

    public Year() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_CREATEREGFACTACCT, false);
        setDefaultValue(PROPERTY_DROPREGFACTACCT, false);
        setDefaultValue(PROPERTY_ORGANIZATIONCLOSINGLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTPERIODLIST,
            new ArrayList<Object>());
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

    public String getYear() {
        return (String) get(PROPERTY_YEAR);
    }

    public void setYear(String year) {
        set(PROPERTY_YEAR, year);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Calendar getCalendar() {
        return (Calendar) get(PROPERTY_CALENDAR);
    }

    public void setCalendar(Calendar calendar) {
        set(PROPERTY_CALENDAR, calendar);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Boolean isCreateRegFactAcct() {
        return (Boolean) get(PROPERTY_CREATEREGFACTACCT);
    }

    public void setCreateRegFactAcct(Boolean createRegFactAcct) {
        set(PROPERTY_CREATEREGFACTACCT, createRegFactAcct);
    }

    public Boolean isDropRegFactAcct() {
        return (Boolean) get(PROPERTY_DROPREGFACTACCT);
    }

    public void setDropRegFactAcct(Boolean dropRegFactAcct) {
        set(PROPERTY_DROPREGFACTACCT, dropRegFactAcct);
    }

    @SuppressWarnings("unchecked")
    public List<OrganizationClosing> getOrganizationClosingList() {
        return (List<OrganizationClosing>) get(PROPERTY_ORGANIZATIONCLOSINGLIST);
    }

    public void setOrganizationClosingList(
        List<OrganizationClosing> organizationClosingList) {
        set(PROPERTY_ORGANIZATIONCLOSINGLIST, organizationClosingList);
    }

    @SuppressWarnings("unchecked")
    public List<Period> getFinancialMgmtPeriodList() {
        return (List<Period>) get(PROPERTY_FINANCIALMGMTPERIODLIST);
    }

    public void setFinancialMgmtPeriodList(List<Period> financialMgmtPeriodList) {
        set(PROPERTY_FINANCIALMGMTPERIODLIST, financialMgmtPeriodList);
    }
}
