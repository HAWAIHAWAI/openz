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
package org.openbravo.model.ad.ui;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ADWFNode (stored in table AD_WF_Node).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class WFNode extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_WF_Node";
    public static final String ENTITY_NAME = "ADWFNode";
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
    public static final String PROPERTY_HELP = "help";
    public static final String PROPERTY_WORKFLOW = "workflow";
    public static final String PROPERTY_ISCENTRALLYMAINTAINED =
        "isCentrallyMaintained";
    public static final String PROPERTY_ACTION = "action";
    public static final String PROPERTY_WINDOW = "window";
    public static final String PROPERTY_WORKFLOW15 = "workflow15";
    public static final String PROPERTY_TASK = "task";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_FORM = "form";
    public static final String PROPERTY_XPOSITION = "xposition";
    public static final String PROPERTY_YPOSITION = "yposition";
    public static final String PROPERTY_ADWFNODETRLLIST = "aDWFNodeTrlList";
    public static final String PROPERTY_ADWFNODENEXTLIST = "aDWFNodeNextList";

    public WFNode() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISCENTRALLYMAINTAINED, true);
        setDefaultValue(PROPERTY_ADWFNODETRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADWFNODENEXTLIST, new ArrayList<Object>());
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

    public String getHelp() {
        return (String) get(PROPERTY_HELP);
    }

    public void setHelp(String help) {
        set(PROPERTY_HELP, help);
    }

    public Workflow getWorkflow() {
        return (Workflow) get(PROPERTY_WORKFLOW);
    }

    public void setWorkflow(Workflow workflow) {
        set(PROPERTY_WORKFLOW, workflow);
    }

    public Boolean isCentrallyMaintained() {
        return (Boolean) get(PROPERTY_ISCENTRALLYMAINTAINED);
    }

    public void setCentrallyMaintained(Boolean isCentrallyMaintained) {
        set(PROPERTY_ISCENTRALLYMAINTAINED, isCentrallyMaintained);
    }

    public String getAction() {
        return (String) get(PROPERTY_ACTION);
    }

    public void setAction(String action) {
        set(PROPERTY_ACTION, action);
    }

    public Window getWindow() {
        return (Window) get(PROPERTY_WINDOW);
    }

    public void setWindow(Window window) {
        set(PROPERTY_WINDOW, window);
    }

    public Workflow getWorkflow15() {
        return (Workflow) get(PROPERTY_WORKFLOW15);
    }

    public void setWorkflow15(Workflow workflow15) {
        set(PROPERTY_WORKFLOW15, workflow15);
    }

    public Task getTask() {
        return (Task) get(PROPERTY_TASK);
    }

    public void setTask(Task task) {
        set(PROPERTY_TASK, task);
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

    public Long getXposition() {
        return (Long) get(PROPERTY_XPOSITION);
    }

    public void setXposition(Long xposition) {
        set(PROPERTY_XPOSITION, xposition);
    }

    public Long getYposition() {
        return (Long) get(PROPERTY_YPOSITION);
    }

    public void setYposition(Long yposition) {
        set(PROPERTY_YPOSITION, yposition);
    }

    @SuppressWarnings("unchecked")
    public List<WFNodeTrl> getADWFNodeTrlList() {
        return (List<WFNodeTrl>) get(PROPERTY_ADWFNODETRLLIST);
    }

    public void setADWFNodeTrlList(List<WFNodeTrl> aDWFNodeTrlList) {
        set(PROPERTY_ADWFNODETRLLIST, aDWFNodeTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<WFNodeNext> getADWFNodeNextList() {
        return (List<WFNodeNext>) get(PROPERTY_ADWFNODENEXTLIST);
    }

    public void setADWFNodeNextList(List<WFNodeNext> aDWFNodeNextList) {
        set(PROPERTY_ADWFNODENEXTLIST, aDWFNodeNextList);
    }
}
