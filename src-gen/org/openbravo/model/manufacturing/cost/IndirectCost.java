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
package org.openbravo.model.manufacturing.cost;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.zsoft.projects.Zspm_ctaskindcostplan;
import org.openbravo.zsoft.projects.Zspm_ptaskindcostplan;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ManufacturingIndirectCost (stored in table MA_Indirect_Cost).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class IndirectCost extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "MA_Indirect_Cost";
    public static final String ENTITY_NAME = "ManufacturingIndirectCost";
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
    public static final String PROPERTY_COSTTYPE = "costType";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_ADDAUTO2PROJECT = "addauto2project";
    public static final String PROPERTY_MANUFACTURINGINDIRECTCOSTVALUELIST =
        "manufacturingIndirectCostValueList";
    public static final String PROPERTY_ZSPMCTASKINDCOSTPLANLIST =
        "zspmCtaskindcostplanList";
    public static final String PROPERTY_ZSPMPTASKINDCOSTPLANLIST =
        "zspmPtaskindcostplanList";

    public IndirectCost() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ADDAUTO2PROJECT, false);
        setDefaultValue(PROPERTY_MANUFACTURINGINDIRECTCOSTVALUELIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSPMCTASKINDCOSTPLANLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSPMPTASKINDCOSTPLANLIST,
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

    public String getCostType() {
        return (String) get(PROPERTY_COSTTYPE);
    }

    public void setCostType(String costType) {
        set(PROPERTY_COSTTYPE, costType);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public Boolean isAddauto2project() {
        return (Boolean) get(PROPERTY_ADDAUTO2PROJECT);
    }

    public void setAddauto2project(Boolean addauto2project) {
        set(PROPERTY_ADDAUTO2PROJECT, addauto2project);
    }

    @SuppressWarnings("unchecked")
    public List<IndirectCostValue> getManufacturingIndirectCostValueList() {
        return (List<IndirectCostValue>) get(PROPERTY_MANUFACTURINGINDIRECTCOSTVALUELIST);
    }

    public void setManufacturingIndirectCostValueList(
        List<IndirectCostValue> manufacturingIndirectCostValueList) {
        set(PROPERTY_MANUFACTURINGINDIRECTCOSTVALUELIST,
            manufacturingIndirectCostValueList);
    }

    @SuppressWarnings("unchecked")
    public List<Zspm_ctaskindcostplan> getZspmCtaskindcostplanList() {
        return (List<Zspm_ctaskindcostplan>) get(PROPERTY_ZSPMCTASKINDCOSTPLANLIST);
    }

    public void setZspmCtaskindcostplanList(
        List<Zspm_ctaskindcostplan> zspmCtaskindcostplanList) {
        set(PROPERTY_ZSPMCTASKINDCOSTPLANLIST, zspmCtaskindcostplanList);
    }

    @SuppressWarnings("unchecked")
    public List<Zspm_ptaskindcostplan> getZspmPtaskindcostplanList() {
        return (List<Zspm_ptaskindcostplan>) get(PROPERTY_ZSPMPTASKINDCOSTPLANLIST);
    }

    public void setZspmPtaskindcostplanList(
        List<Zspm_ptaskindcostplan> zspmPtaskindcostplanList) {
        set(PROPERTY_ZSPMPTASKINDCOSTPLANLIST, zspmPtaskindcostplanList);
    }
}
