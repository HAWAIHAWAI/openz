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
package org.openbravo.model.ad.alert;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.ui.Tab;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ADAlertRule (stored in table AD_AlertRule).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class AlertRule extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_AlertRule";
    public static final String ENTITY_NAME = "ADAlertRule";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_TAB = "tab";
    public static final String PROPERTY_FILTERCLAUSE = "filterClause";
    public static final String PROPERTY_SQL = "sql";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_FIXED = "fixed";
    public static final String PROPERTY_DEACTVATEWHENNOTAPPLIED =
        "deactvatewhennotapplied";
    public static final String PROPERTY_SENDEMAILTOUSER = "sendemailtouser";
    public static final String PROPERTY_ADALERTLIST = "aDAlertList";
    public static final String PROPERTY_ADALERTRECIPIENTLIST =
        "aDAlertRecipientList";
    public static final String PROPERTY_ADALERTRULETRLLIST =
        "aDAlertRuleTrlList";

    public AlertRule() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_TYPE, "D");
        setDefaultValue(PROPERTY_FIXED, true);
        setDefaultValue(PROPERTY_DEACTVATEWHENNOTAPPLIED, true);
        setDefaultValue(PROPERTY_SENDEMAILTOUSER, false);
        setDefaultValue(PROPERTY_ADALERTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADALERTRECIPIENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADALERTRULETRLLIST, new ArrayList<Object>());
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

    public Tab getTab() {
        return (Tab) get(PROPERTY_TAB);
    }

    public void setTab(Tab tab) {
        set(PROPERTY_TAB, tab);
    }

    public String getFilterClause() {
        return (String) get(PROPERTY_FILTERCLAUSE);
    }

    public void setFilterClause(String filterClause) {
        set(PROPERTY_FILTERCLAUSE, filterClause);
    }

    public String getSql() {
        return (String) get(PROPERTY_SQL);
    }

    public void setSql(String sql) {
        set(PROPERTY_SQL, sql);
    }

    public String getType() {
        return (String) get(PROPERTY_TYPE);
    }

    public void setType(String type) {
        set(PROPERTY_TYPE, type);
    }

    public Boolean isFixed() {
        return (Boolean) get(PROPERTY_FIXED);
    }

    public void setFixed(Boolean fixed) {
        set(PROPERTY_FIXED, fixed);
    }

    public Boolean isDeactvatewhennotapplied() {
        return (Boolean) get(PROPERTY_DEACTVATEWHENNOTAPPLIED);
    }

    public void setDeactvatewhennotapplied(Boolean deactvatewhennotapplied) {
        set(PROPERTY_DEACTVATEWHENNOTAPPLIED, deactvatewhennotapplied);
    }

    public Boolean isSendemailtouser() {
        return (Boolean) get(PROPERTY_SENDEMAILTOUSER);
    }

    public void setSendemailtouser(Boolean sendemailtouser) {
        set(PROPERTY_SENDEMAILTOUSER, sendemailtouser);
    }

    @SuppressWarnings("unchecked")
    public List<Alert> getADAlertList() {
        return (List<Alert>) get(PROPERTY_ADALERTLIST);
    }

    public void setADAlertList(List<Alert> aDAlertList) {
        set(PROPERTY_ADALERTLIST, aDAlertList);
    }

    @SuppressWarnings("unchecked")
    public List<AlertRecipient> getADAlertRecipientList() {
        return (List<AlertRecipient>) get(PROPERTY_ADALERTRECIPIENTLIST);
    }

    public void setADAlertRecipientList(
        List<AlertRecipient> aDAlertRecipientList) {
        set(PROPERTY_ADALERTRECIPIENTLIST, aDAlertRecipientList);
    }

    @SuppressWarnings("unchecked")
    public List<AlertRuleTrl> getADAlertRuleTrlList() {
        return (List<AlertRuleTrl>) get(PROPERTY_ADALERTRULETRLLIST);
    }

    public void setADAlertRuleTrlList(List<AlertRuleTrl> aDAlertRuleTrlList) {
        set(PROPERTY_ADALERTRULETRLLIST, aDAlertRuleTrlList);
    }
}
