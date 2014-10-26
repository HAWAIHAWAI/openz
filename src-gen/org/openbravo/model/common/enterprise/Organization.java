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
package org.openbravo.model.common.enterprise;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.RoleOrganization;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.financialmgmt.accounting.InterOrgAccounts;
import org.openbravo.model.financialmgmt.calendar.Calendar;
import org.openbravo.model.financialmgmt.calendar.PeriodControlV;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity Organization (stored in table AD_Org).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Organization extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Org";
    public static final String ENTITY_NAME = "Organization";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ISSUMMARY = "isSummary";
    public static final String PROPERTY_ORGTYPE = "orgtype";
    public static final String PROPERTY_ISPERIODCONTROLALLOWED =
        "isPeriodControlAllowed";
    public static final String PROPERTY_CALENDAR = "calendar";
    public static final String PROPERTY_ISREADY = "isReady";
    public static final String PROPERTY_FINANCIALMGMTPERIODCONTROLVLIST =
        "financialMgmtPeriodControlVList";
    public static final String PROPERTY_ORGCALENDARVLIST = "orgcalendarVList";
    public static final String PROPERTY_WORKCALENDARSETTINGSLIST =
        "wORKCALENDARSETTINGSList";
    public static final String PROPERTY_ORGANIZATIONINFORMATIONLIST =
        "organizationInformationList";
    public static final String PROPERTY_FINANCIALMGMTINTERORGACCOUNTSLIST =
        "financialMgmtInterOrgAccountsList";
    public static final String PROPERTY_FINANCIALMGMTINTERORGACCOUNTSADORGTOIDLIST =
        "financialMgmtInterOrgAccountsADOrgToIDList";
    public static final String PROPERTY_ADROLEORGANIZATIONLIST =
        "aDRoleOrganizationList";
    public static final String PROPERTY_WORKCALENDAREVENTLIST =
        "wORKCALENDAREVENTList";

    public Organization() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISSUMMARY, false);
        setDefaultValue(PROPERTY_ISPERIODCONTROLALLOWED, false);
        setDefaultValue(PROPERTY_ISREADY, false);
        setDefaultValue(PROPERTY_FINANCIALMGMTPERIODCONTROLVLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGCALENDARVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_WORKCALENDARSETTINGSLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONINFORMATIONLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTINTERORGACCOUNTSLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTINTERORGACCOUNTSADORGTOIDLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADROLEORGANIZATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_WORKCALENDAREVENTLIST, new ArrayList<Object>());
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

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
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

    public Boolean isSummary() {
        return (Boolean) get(PROPERTY_ISSUMMARY);
    }

    public void setSummary(Boolean isSummary) {
        set(PROPERTY_ISSUMMARY, isSummary);
    }

    public OrganizationType getOrgtype() {
        return (OrganizationType) get(PROPERTY_ORGTYPE);
    }

    public void setOrgtype(OrganizationType orgtype) {
        set(PROPERTY_ORGTYPE, orgtype);
    }

    public Boolean isPeriodControlAllowed() {
        return (Boolean) get(PROPERTY_ISPERIODCONTROLALLOWED);
    }

    public void setPeriodControlAllowed(Boolean isPeriodControlAllowed) {
        set(PROPERTY_ISPERIODCONTROLALLOWED, isPeriodControlAllowed);
    }

    public Calendar getCalendar() {
        return (Calendar) get(PROPERTY_CALENDAR);
    }

    public void setCalendar(Calendar calendar) {
        set(PROPERTY_CALENDAR, calendar);
    }

    public Boolean isReady() {
        return (Boolean) get(PROPERTY_ISREADY);
    }

    public void setReady(Boolean isReady) {
        set(PROPERTY_ISREADY, isReady);
    }

    @SuppressWarnings("unchecked")
    public List<PeriodControlV> getFinancialMgmtPeriodControlVList() {
        return (List<PeriodControlV>) get(PROPERTY_FINANCIALMGMTPERIODCONTROLVLIST);
    }

    public void setFinancialMgmtPeriodControlVList(
        List<PeriodControlV> financialMgmtPeriodControlVList) {
        set(PROPERTY_FINANCIALMGMTPERIODCONTROLVLIST,
            financialMgmtPeriodControlVList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.utility.c_orgcalendar_v> getOrgcalendarVList() {
        return (List<org.openbravo.model.common.utility.c_orgcalendar_v>) get(PROPERTY_ORGCALENDARVLIST);
    }

    public void setOrgcalendarVList(
        List<org.openbravo.model.common.utility.c_orgcalendar_v> orgcalendarVList) {
        set(PROPERTY_ORGCALENDARVLIST, orgcalendarVList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.utility.C_WORKCALENDARSETTINGS> getWORKCALENDARSETTINGSList() {
        return (List<org.openbravo.model.common.utility.C_WORKCALENDARSETTINGS>) get(PROPERTY_WORKCALENDARSETTINGSLIST);
    }

    public void setWORKCALENDARSETTINGSList(
        List<org.openbravo.model.common.utility.C_WORKCALENDARSETTINGS> wORKCALENDARSETTINGSList) {
        set(PROPERTY_WORKCALENDARSETTINGSLIST, wORKCALENDARSETTINGSList);
    }

    @SuppressWarnings("unchecked")
    public List<OrganizationInformation> getOrganizationInformationList() {
        return (List<OrganizationInformation>) get(PROPERTY_ORGANIZATIONINFORMATIONLIST);
    }

    public void setOrganizationInformationList(
        List<OrganizationInformation> organizationInformationList) {
        set(PROPERTY_ORGANIZATIONINFORMATIONLIST, organizationInformationList);
    }

    @SuppressWarnings("unchecked")
    public List<InterOrgAccounts> getFinancialMgmtInterOrgAccountsList() {
        return (List<InterOrgAccounts>) get(PROPERTY_FINANCIALMGMTINTERORGACCOUNTSLIST);
    }

    public void setFinancialMgmtInterOrgAccountsList(
        List<InterOrgAccounts> financialMgmtInterOrgAccountsList) {
        set(PROPERTY_FINANCIALMGMTINTERORGACCOUNTSLIST,
            financialMgmtInterOrgAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<InterOrgAccounts> getFinancialMgmtInterOrgAccountsADOrgToIDList() {
        return (List<InterOrgAccounts>) get(PROPERTY_FINANCIALMGMTINTERORGACCOUNTSADORGTOIDLIST);
    }

    public void setFinancialMgmtInterOrgAccountsADOrgToIDList(
        List<InterOrgAccounts> financialMgmtInterOrgAccountsADOrgToIDList) {
        set(PROPERTY_FINANCIALMGMTINTERORGACCOUNTSADORGTOIDLIST,
            financialMgmtInterOrgAccountsADOrgToIDList);
    }

    @SuppressWarnings("unchecked")
    public List<RoleOrganization> getADRoleOrganizationList() {
        return (List<RoleOrganization>) get(PROPERTY_ADROLEORGANIZATIONLIST);
    }

    public void setADRoleOrganizationList(
        List<RoleOrganization> aDRoleOrganizationList) {
        set(PROPERTY_ADROLEORGANIZATIONLIST, aDRoleOrganizationList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.utility.C_WORKCALENDAREVENT> getWORKCALENDAREVENTList() {
        return (List<org.openbravo.model.common.utility.C_WORKCALENDAREVENT>) get(PROPERTY_WORKCALENDAREVENTLIST);
    }

    public void setWORKCALENDAREVENTList(
        List<org.openbravo.model.common.utility.C_WORKCALENDAREVENT> wORKCALENDAREVENTList) {
        set(PROPERTY_WORKCALENDAREVENTLIST, wORKCALENDAREVENTList);
    }
}
