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
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.project.ProjectTask;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity zssm_productionplan_task_v (stored in table zssm_productionplan_task_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class zssm_productionplan_task_v extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zssm_productionplan_task_v";
    public static final String ENTITY_NAME = "zssm_productionplan_task_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ZSSMPRODUCTIONPLANTASK =
        "zssmProductionplanTask";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SORTNO = "sortNo";
    public static final String PROPERTY_ZSSMPRODUCTIONPLANV =
        "zssmProductionplanV";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ASSEMBLY = "assembly";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_FORCEMATERIALSCAN = "forceMaterialScan";
    public static final String PROPERTY_STARTONLYWITHCOMPLETEMATERIAL =
        "startOnlyWithCompleteMaterial";
    public static final String PROPERTY_PERCENTREJECTS = "percentRejects";
    public static final String PROPERTY_ISSUINGLOCATOR = "issuingLocator";
    public static final String PROPERTY_RECEIVINGLOCATOR = "receivingLocator";

    public zssm_productionplan_task_v() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ASSEMBLY, false);
        setDefaultValue(PROPERTY_FORCEMATERIALSCAN, false);
        setDefaultValue(PROPERTY_STARTONLYWITHCOMPLETEMATERIAL, false);
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

    public org.openbravo.zsoft.serprod.zssm_productionplan_task getZssmProductionplanTask() {
        return (org.openbravo.zsoft.serprod.zssm_productionplan_task) get(PROPERTY_ZSSMPRODUCTIONPLANTASK);
    }

    public void setZssmProductionplanTask(
        org.openbravo.zsoft.serprod.zssm_productionplan_task zssmProductionplanTask) {
        set(PROPERTY_ZSSMPRODUCTIONPLANTASK, zssmProductionplanTask);
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

    public Long getSortNo() {
        return (Long) get(PROPERTY_SORTNO);
    }

    public void setSortNo(Long sortNo) {
        set(PROPERTY_SORTNO, sortNo);
    }

    public org.openbravo.zsoft.serprod.zssm_productionplan_v getZssmProductionplanV() {
        return (org.openbravo.zsoft.serprod.zssm_productionplan_v) get(PROPERTY_ZSSMPRODUCTIONPLANV);
    }

    public void setZssmProductionplanV(
        org.openbravo.zsoft.serprod.zssm_productionplan_v zssmProductionplanV) {
        set(PROPERTY_ZSSMPRODUCTIONPLANV, zssmProductionplanV);
    }

    public ProjectTask getProjecttask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjecttask(ProjectTask projecttask) {
        set(PROPERTY_PROJECTTASK, projecttask);
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

    public Boolean isAssembly() {
        return (Boolean) get(PROPERTY_ASSEMBLY);
    }

    public void setAssembly(Boolean assembly) {
        set(PROPERTY_ASSEMBLY, assembly);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Boolean isForceMaterialScan() {
        return (Boolean) get(PROPERTY_FORCEMATERIALSCAN);
    }

    public void setForceMaterialScan(Boolean forceMaterialScan) {
        set(PROPERTY_FORCEMATERIALSCAN, forceMaterialScan);
    }

    public Boolean isStartOnlyWithCompleteMaterial() {
        return (Boolean) get(PROPERTY_STARTONLYWITHCOMPLETEMATERIAL);
    }

    public void setStartOnlyWithCompleteMaterial(
        Boolean startOnlyWithCompleteMaterial) {
        set(PROPERTY_STARTONLYWITHCOMPLETEMATERIAL,
            startOnlyWithCompleteMaterial);
    }

    public Long getPercentRejects() {
        return (Long) get(PROPERTY_PERCENTREJECTS);
    }

    public void setPercentRejects(Long percentRejects) {
        set(PROPERTY_PERCENTREJECTS, percentRejects);
    }

    public Locator getIssuingLocator() {
        return (Locator) get(PROPERTY_ISSUINGLOCATOR);
    }

    public void setIssuingLocator(Locator issuingLocator) {
        set(PROPERTY_ISSUINGLOCATOR, issuingLocator);
    }

    public Locator getReceivingLocator() {
        return (Locator) get(PROPERTY_RECEIVINGLOCATOR);
    }

    public void setReceivingLocator(Locator receivingLocator) {
        set(PROPERTY_RECEIVINGLOCATOR, receivingLocator);
    }
}
