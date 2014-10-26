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
package org.openbravo.zsoft.serprod;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.project.ProjectTask;
import org.openbravo.zsoft.projects.Zspm_projecttaskdep;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity zssm_productionorder_taskdep_v (stored in table zssm_productionorder_taskdep_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class zssm_productionorder_taskdep_v extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zssm_productionorder_taskdep_v";
    public static final String ENTITY_NAME = "zssm_productionorder_taskdep_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ZSPMPROJECTTASKDEP =
        "zspmProjecttaskdep";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ZSSMPRODUCTIONORDERV =
        "zssmProductionOrderV";
    public static final String PROPERTY_SORTNO = "sortNo";
    public static final String PROPERTY_DEPENDSONTASK = "dependsOnTask";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_STOCKROTATION = "stockRotation";
    public static final String PROPERTY_DEPENDENTSTATUSCHECK =
        "dependentStatusCheck";

    public zssm_productionorder_taskdep_v() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_STOCKROTATION, false);
        setDefaultValue(PROPERTY_DEPENDENTSTATUSCHECK, false);
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

    public Zspm_projecttaskdep getZspmProjecttaskdep() {
        return (Zspm_projecttaskdep) get(PROPERTY_ZSPMPROJECTTASKDEP);
    }

    public void setZspmProjecttaskdep(Zspm_projecttaskdep zspmProjecttaskdep) {
        set(PROPERTY_ZSPMPROJECTTASKDEP, zspmProjecttaskdep);
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

    public org.openbravo.zsoft.serprod.zssm_productionorder_v getZssmProductionOrderV() {
        return (org.openbravo.zsoft.serprod.zssm_productionorder_v) get(PROPERTY_ZSSMPRODUCTIONORDERV);
    }

    public void setZssmProductionOrderV(
        org.openbravo.zsoft.serprod.zssm_productionorder_v zssmProductionOrderV) {
        set(PROPERTY_ZSSMPRODUCTIONORDERV, zssmProductionOrderV);
    }

    public Long getSortNo() {
        return (Long) get(PROPERTY_SORTNO);
    }

    public void setSortNo(Long sortNo) {
        set(PROPERTY_SORTNO, sortNo);
    }

    public ProjectTask getDependsOnTask() {
        return (ProjectTask) get(PROPERTY_DEPENDSONTASK);
    }

    public void setDependsOnTask(ProjectTask dependsOnTask) {
        set(PROPERTY_DEPENDSONTASK, dependsOnTask);
    }

    public ProjectTask getProjecttask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjecttask(ProjectTask projecttask) {
        set(PROPERTY_PROJECTTASK, projecttask);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isStockRotation() {
        return (Boolean) get(PROPERTY_STOCKROTATION);
    }

    public void setStockRotation(Boolean stockRotation) {
        set(PROPERTY_STOCKROTATION, stockRotation);
    }

    public Boolean isDependentStatusCheck() {
        return (Boolean) get(PROPERTY_DEPENDENTSTATUSCHECK);
    }

    public void setDependentStatusCheck(Boolean dependentStatusCheck) {
        set(PROPERTY_DEPENDENTSTATUSCHECK, dependentStatusCheck);
    }
}
