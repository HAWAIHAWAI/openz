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
package org.openbravo.model.ad.access;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.utility.Tree;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity AD_Role (stored in table AD_Role).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Role extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Role";
    public static final String ENTITY_NAME = "AD_Role";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_USERLEVEL = "userLevel";
    public static final String PROPERTY_CLIENTLIST = "clientList";
    public static final String PROPERTY_ORGLIST = "orgList";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_AMTAPPROVAL = "amtApproval";
    public static final String PROPERTY_TREEMENU = "treeMenu";
    public static final String PROPERTY_ISMANUAL = "isManual";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_BTNGENERATEROLE = "btnGenerateRole";
    public static final String PROPERTY_THEME = "theme";
    public static final String PROPERTY_ROLETABACCESSLIST = "roleTabaccessList";
    public static final String PROPERTY_ADUSERROLESLIST = "aDUserRolesList";
    public static final String PROPERTY_ADFORMACCESSLIST = "aDFormAccessList";
    public static final String PROPERTY_ADTASKACCESSLIST = "aDTaskAccessList";
    public static final String PROPERTY_ADWINDOWACCESSLIST =
        "aDWindowAccessList";
    public static final String PROPERTY_ADPROCESSACCESSLIST =
        "aDProcessAccessList";
    public static final String PROPERTY_ADTABLEACCESSLIST = "aDTableAccessList";
    public static final String PROPERTY_ADROLEORGANIZATIONLIST =
        "aDRoleOrganizationList";
    public static final String PROPERTY_ADWORKFLOWACCESSLIST =
        "aDWorkflowAccessList";
    public static final String PROPERTY_PREFERENCEACCESSLIST =
        "preferenceAccessList";

    public Role() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISMANUAL, false);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_BTNGENERATEROLE, false);
        setDefaultValue(PROPERTY_ROLETABACCESSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADUSERROLESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADFORMACCESSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADTASKACCESSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADWINDOWACCESSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADPROCESSACCESSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADTABLEACCESSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADROLEORGANIZATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADWORKFLOWACCESSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PREFERENCEACCESSLIST, new ArrayList<Object>());
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getUserLevel() {
        return (String) get(PROPERTY_USERLEVEL);
    }

    public void setUserLevel(String userLevel) {
        set(PROPERTY_USERLEVEL, userLevel);
    }

    public String getClientList() {
        return (String) get(PROPERTY_CLIENTLIST);
    }

    public void setClientList(String clientList) {
        set(PROPERTY_CLIENTLIST, clientList);
    }

    public String getOrgList() {
        return (String) get(PROPERTY_ORGLIST);
    }

    public void setOrgList(String orgList) {
        set(PROPERTY_ORGLIST, orgList);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public BigDecimal getAmtApproval() {
        return (BigDecimal) get(PROPERTY_AMTAPPROVAL);
    }

    public void setAmtApproval(BigDecimal amtApproval) {
        set(PROPERTY_AMTAPPROVAL, amtApproval);
    }

    public Tree getTreeMenu() {
        return (Tree) get(PROPERTY_TREEMENU);
    }

    public void setTreeMenu(Tree treeMenu) {
        set(PROPERTY_TREEMENU, treeMenu);
    }

    public Boolean isManual() {
        return (Boolean) get(PROPERTY_ISMANUAL);
    }

    public void setManual(Boolean isManual) {
        set(PROPERTY_ISMANUAL, isManual);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Boolean isBtnGenerateRole() {
        return (Boolean) get(PROPERTY_BTNGENERATEROLE);
    }

    public void setBtnGenerateRole(Boolean btnGenerateRole) {
        set(PROPERTY_BTNGENERATEROLE, btnGenerateRole);
    }

    public String getTheme() {
        return (String) get(PROPERTY_THEME);
    }

    public void setTheme(String theme) {
        set(PROPERTY_THEME, theme);
    }

    @SuppressWarnings("unchecked")
    public List<Adroletabaccess> getRoleTabaccessList() {
        return (List<Adroletabaccess>) get(PROPERTY_ROLETABACCESSLIST);
    }

    public void setRoleTabaccessList(List<Adroletabaccess> roleTabaccessList) {
        set(PROPERTY_ROLETABACCESSLIST, roleTabaccessList);
    }

    @SuppressWarnings("unchecked")
    public List<UserRoles> getADUserRolesList() {
        return (List<UserRoles>) get(PROPERTY_ADUSERROLESLIST);
    }

    public void setADUserRolesList(List<UserRoles> aDUserRolesList) {
        set(PROPERTY_ADUSERROLESLIST, aDUserRolesList);
    }

    @SuppressWarnings("unchecked")
    public List<FormAccess> getADFormAccessList() {
        return (List<FormAccess>) get(PROPERTY_ADFORMACCESSLIST);
    }

    public void setADFormAccessList(List<FormAccess> aDFormAccessList) {
        set(PROPERTY_ADFORMACCESSLIST, aDFormAccessList);
    }

    @SuppressWarnings("unchecked")
    public List<TaskAccess> getADTaskAccessList() {
        return (List<TaskAccess>) get(PROPERTY_ADTASKACCESSLIST);
    }

    public void setADTaskAccessList(List<TaskAccess> aDTaskAccessList) {
        set(PROPERTY_ADTASKACCESSLIST, aDTaskAccessList);
    }

    @SuppressWarnings("unchecked")
    public List<WindowAccess> getADWindowAccessList() {
        return (List<WindowAccess>) get(PROPERTY_ADWINDOWACCESSLIST);
    }

    public void setADWindowAccessList(List<WindowAccess> aDWindowAccessList) {
        set(PROPERTY_ADWINDOWACCESSLIST, aDWindowAccessList);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessAccess> getADProcessAccessList() {
        return (List<ProcessAccess>) get(PROPERTY_ADPROCESSACCESSLIST);
    }

    public void setADProcessAccessList(List<ProcessAccess> aDProcessAccessList) {
        set(PROPERTY_ADPROCESSACCESSLIST, aDProcessAccessList);
    }

    @SuppressWarnings("unchecked")
    public List<TableAccess> getADTableAccessList() {
        return (List<TableAccess>) get(PROPERTY_ADTABLEACCESSLIST);
    }

    public void setADTableAccessList(List<TableAccess> aDTableAccessList) {
        set(PROPERTY_ADTABLEACCESSLIST, aDTableAccessList);
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
    public List<WorkflowAccess> getADWorkflowAccessList() {
        return (List<WorkflowAccess>) get(PROPERTY_ADWORKFLOWACCESSLIST);
    }

    public void setADWorkflowAccessList(
        List<WorkflowAccess> aDWorkflowAccessList) {
        set(PROPERTY_ADWORKFLOWACCESSLIST, aDWorkflowAccessList);
    }

    @SuppressWarnings("unchecked")
    public List<Ad_preference_access> getPreferenceAccessList() {
        return (List<Ad_preference_access>) get(PROPERTY_PREFERENCEACCESSLIST);
    }

    public void setPreferenceAccessList(
        List<Ad_preference_access> preferenceAccessList) {
        set(PROPERTY_PREFERENCEACCESSLIST, preferenceAccessList);
    }
}
