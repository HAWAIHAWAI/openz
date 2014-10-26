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
package org.openbravo.model.ad.domain;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.module.Module;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.ui.Form;
import org.openbravo.model.ad.ui.Process;
import org.openbravo.model.ad.ui.Tab;
import org.openbravo.model.ad.ui.Task;
import org.openbravo.model.ad.ui.Workflow;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ADModelImplementation (stored in table AD_Model_Object).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ModelImplementation extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Model_Object";
    public static final String ENTITY_NAME = "ADModelImplementation";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTION = "action";
    public static final String PROPERTY_TAB = "tab";
    public static final String PROPERTY_CLASSNAME = "classname";
    public static final String PROPERTY_ISDEFAULT = "isDefault";
    public static final String PROPERTY_TASK = "task";
    public static final String PROPERTY_WORKFLOW = "workflow";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_FORM = "form";
    public static final String PROPERTY_REFERENCE = "reference";
    public static final String PROPERTY_CALLOUT = "callout";
    public static final String PROPERTY_MODULE = "module";
    public static final String PROPERTY_OBJECTTYPE = "objectType";
    public static final String PROPERTY_LOADONSTARTUP = "loadonstartup";
    public static final String PROPERTY_SEQNO = "seqno";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_MODELIMPLEMENTATIONPARAMETERLIST =
        "modelImplementationParameterList";
    public static final String PROPERTY_ADMODELIMPLEMENTATIONMAPPINGLIST =
        "aDModelImplementationMappingList";

    public ModelImplementation() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISDEFAULT, false);
        setDefaultValue(PROPERTY_OBJECTTYPE, "S");
        setDefaultValue(PROPERTY_MODELIMPLEMENTATIONPARAMETERLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADMODELIMPLEMENTATIONMAPPINGLIST,
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

    public String getAction() {
        return (String) get(PROPERTY_ACTION);
    }

    public void setAction(String action) {
        set(PROPERTY_ACTION, action);
    }

    public Tab getTab() {
        return (Tab) get(PROPERTY_TAB);
    }

    public void setTab(Tab tab) {
        set(PROPERTY_TAB, tab);
    }

    public String getClassname() {
        return (String) get(PROPERTY_CLASSNAME);
    }

    public void setClassname(String classname) {
        set(PROPERTY_CLASSNAME, classname);
    }

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_ISDEFAULT);
    }

    public void setDefault(Boolean isDefault) {
        set(PROPERTY_ISDEFAULT, isDefault);
    }

    public Task getTask() {
        return (Task) get(PROPERTY_TASK);
    }

    public void setTask(Task task) {
        set(PROPERTY_TASK, task);
    }

    public Workflow getWorkflow() {
        return (Workflow) get(PROPERTY_WORKFLOW);
    }

    public void setWorkflow(Workflow workflow) {
        set(PROPERTY_WORKFLOW, workflow);
    }

    public Process getProcess() {
        return (Process) get(PROPERTY_PROCESS);
    }

    public void setProcess(Process process) {
        set(PROPERTY_PROCESS, process);
    }

    public Form getForm() {
        return (Form) get(PROPERTY_FORM);
    }

    public void setForm(Form form) {
        set(PROPERTY_FORM, form);
    }

    public Reference getReference() {
        return (Reference) get(PROPERTY_REFERENCE);
    }

    public void setReference(Reference reference) {
        set(PROPERTY_REFERENCE, reference);
    }

    public Callout getCallout() {
        return (Callout) get(PROPERTY_CALLOUT);
    }

    public void setCallout(Callout callout) {
        set(PROPERTY_CALLOUT, callout);
    }

    public Module getModule() {
        return (Module) get(PROPERTY_MODULE);
    }

    public void setModule(Module module) {
        set(PROPERTY_MODULE, module);
    }

    public String getObjectType() {
        return (String) get(PROPERTY_OBJECTTYPE);
    }

    public void setObjectType(String objectType) {
        set(PROPERTY_OBJECTTYPE, objectType);
    }

    public Long getLoadonstartup() {
        return (Long) get(PROPERTY_LOADONSTARTUP);
    }

    public void setLoadonstartup(Long loadonstartup) {
        set(PROPERTY_LOADONSTARTUP, loadonstartup);
    }

    public Long getSeqno() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqno(Long seqno) {
        set(PROPERTY_SEQNO, seqno);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    @SuppressWarnings("unchecked")
    public List<ModelImplementationParameter> getModelImplementationParameterList() {
        return (List<ModelImplementationParameter>) get(PROPERTY_MODELIMPLEMENTATIONPARAMETERLIST);
    }

    public void setModelImplementationParameterList(
        List<ModelImplementationParameter> modelImplementationParameterList) {
        set(PROPERTY_MODELIMPLEMENTATIONPARAMETERLIST,
            modelImplementationParameterList);
    }

    @SuppressWarnings("unchecked")
    public List<ModelImplementationMapping> getADModelImplementationMappingList() {
        return (List<ModelImplementationMapping>) get(PROPERTY_ADMODELIMPLEMENTATIONMAPPINGLIST);
    }

    public void setADModelImplementationMappingList(
        List<ModelImplementationMapping> aDModelImplementationMappingList) {
        set(PROPERTY_ADMODELIMPLEMENTATIONMAPPINGLIST,
            aDModelImplementationMappingList);
    }
}
