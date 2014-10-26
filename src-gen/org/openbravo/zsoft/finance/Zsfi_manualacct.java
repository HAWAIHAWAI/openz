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
package org.openbravo.zsoft.finance;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.project.ProjectTask;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity zsfi_manualacct (stored in table zsfi_manualacct).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Zsfi_manualacct extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zsfi_manualacct";
    public static final String ENTITY_NAME = "zsfi_manualacct";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ACCTDATE = "acctdate";
    public static final String PROPERTY_GLSTATUS = "glstatus";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_POST = "post";
    public static final String PROPERTY_CANCEL = "cancel";
    public static final String PROPERTY_UNPOST = "unpost";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_PROJECTPHASE = "projectphase";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_ZSFIMACCTLINELIST = "zsfiMacctlineList";

    public Zsfi_manualacct() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_GLSTATUS, "OP");
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_POST, false);
        setDefaultValue(PROPERTY_CANCEL, false);
        setDefaultValue(PROPERTY_UNPOST, false);
        setDefaultValue(PROPERTY_ZSFIMACCTLINELIST, new ArrayList<Object>());
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Date getAcctdate() {
        return (Date) get(PROPERTY_ACCTDATE);
    }

    public void setAcctdate(Date acctdate) {
        set(PROPERTY_ACCTDATE, acctdate);
    }

    public String getGlstatus() {
        return (String) get(PROPERTY_GLSTATUS);
    }

    public void setGlstatus(String glstatus) {
        set(PROPERTY_GLSTATUS, glstatus);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Boolean isPost() {
        return (Boolean) get(PROPERTY_POST);
    }

    public void setPost(Boolean post) {
        set(PROPERTY_POST, post);
    }

    public Boolean isCancel() {
        return (Boolean) get(PROPERTY_CANCEL);
    }

    public void setCancel(Boolean cancel) {
        set(PROPERTY_CANCEL, cancel);
    }

    public Boolean isUnpost() {
        return (Boolean) get(PROPERTY_UNPOST);
    }

    public void setUnpost(Boolean unpost) {
        set(PROPERTY_UNPOST, unpost);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public ProjectPhase getProjectphase() {
        return (ProjectPhase) get(PROPERTY_PROJECTPHASE);
    }

    public void setProjectphase(ProjectPhase projectphase) {
        set(PROPERTY_PROJECTPHASE, projectphase);
    }

    public ProjectTask getProjecttask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjecttask(ProjectTask projecttask) {
        set(PROPERTY_PROJECTTASK, projecttask);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    @SuppressWarnings("unchecked")
    public List<Zsfi_macctline> getZsfiMacctlineList() {
        return (List<Zsfi_macctline>) get(PROPERTY_ZSFIMACCTLINELIST);
    }

    public void setZsfiMacctlineList(List<Zsfi_macctline> zsfiMacctlineList) {
        set(PROPERTY_ZSFIMACCTLINELIST, zsfiMacctlineList);
    }
}
