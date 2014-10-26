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
import org.openbravo.model.ad.access.ProcessAccess;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.domain.ModelImplementation;
import org.openbravo.model.ad.module.Module;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ADProcess (stored in table AD_Process).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Process extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Process";
    public static final String ENTITY_NAME = "ADProcess";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_HELP = "help";
    public static final String PROPERTY_ACCESSLEVEL = "accessLevel";
    public static final String PROPERTY_ISUSERSTARTABLE = "isUserStartable";
    public static final String PROPERTY_PROCEDURENAME = "procedureName";
    public static final String PROPERTY_ISREPORT = "isReport";
    public static final String PROPERTY_ISDIRECTPRINT = "isDirectPrint";
    public static final String PROPERTY_CLASSNAME = "classname";
    public static final String PROPERTY_ISBACKGROUND = "isBackground";
    public static final String PROPERTY_ISJASPER = "isJasper";
    public static final String PROPERTY_JRNAME = "jrname";
    public static final String PROPERTY_SERVICETYPE = "serviceType";
    public static final String PROPERTY_ISEXTERNALSERVICE = "isexternalservice";
    public static final String PROPERTY_SERVICESOURCE = "serviceSource";
    public static final String PROPERTY_MODULE = "module";
    public static final String PROPERTY_UIPATTERN = "uIPattern";
    public static final String PROPERTY_MANUALRESPONSE = "manualresponse";
    public static final String PROPERTY_ISDIRECTSERVLETCALL =
        "isdirectservletcall";
    public static final String PROPERTY_ADPROCESSPARAMETERLIST =
        "aDProcessParameterList";
    public static final String PROPERTY_ADMODELIMPLEMENTATIONLIST =
        "aDModelImplementationList";
    public static final String PROPERTY_ADPROCESSTRLLIST = "aDProcessTrlList";
    public static final String PROPERTY_PROCESSREQUESTLIST =
        "processRequestList";
    public static final String PROPERTY_ADPROCESSSCHEDULINGLIST =
        "aDProcessSchedulingList";
    public static final String PROPERTY_ADPROCESSACCESSLIST =
        "aDProcessAccessList";

    public Process() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISUSERSTARTABLE, false);
        setDefaultValue(PROPERTY_ISREPORT, false);
        setDefaultValue(PROPERTY_ISDIRECTPRINT, false);
        setDefaultValue(PROPERTY_ISBACKGROUND, false);
        setDefaultValue(PROPERTY_ISJASPER, false);
        setDefaultValue(PROPERTY_ISEXTERNALSERVICE, false);
        setDefaultValue(PROPERTY_UIPATTERN, "S");
        setDefaultValue(PROPERTY_MANUALRESPONSE, false);
        setDefaultValue(PROPERTY_ISDIRECTSERVLETCALL, false);
        setDefaultValue(PROPERTY_ADPROCESSPARAMETERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADMODELIMPLEMENTATIONLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADPROCESSTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCESSREQUESTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADPROCESSSCHEDULINGLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADPROCESSACCESSLIST, new ArrayList<Object>());
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

    public String getHelp() {
        return (String) get(PROPERTY_HELP);
    }

    public void setHelp(String help) {
        set(PROPERTY_HELP, help);
    }

    public String getAccessLevel() {
        return (String) get(PROPERTY_ACCESSLEVEL);
    }

    public void setAccessLevel(String accessLevel) {
        set(PROPERTY_ACCESSLEVEL, accessLevel);
    }

    public Boolean isUserStartable() {
        return (Boolean) get(PROPERTY_ISUSERSTARTABLE);
    }

    public void setUserStartable(Boolean isUserStartable) {
        set(PROPERTY_ISUSERSTARTABLE, isUserStartable);
    }

    public String getProcedureName() {
        return (String) get(PROPERTY_PROCEDURENAME);
    }

    public void setProcedureName(String procedureName) {
        set(PROPERTY_PROCEDURENAME, procedureName);
    }

    public Boolean isReport() {
        return (Boolean) get(PROPERTY_ISREPORT);
    }

    public void setReport(Boolean isReport) {
        set(PROPERTY_ISREPORT, isReport);
    }

    public Boolean isDirectPrint() {
        return (Boolean) get(PROPERTY_ISDIRECTPRINT);
    }

    public void setDirectPrint(Boolean isDirectPrint) {
        set(PROPERTY_ISDIRECTPRINT, isDirectPrint);
    }

    public String getClassname() {
        return (String) get(PROPERTY_CLASSNAME);
    }

    public void setClassname(String classname) {
        set(PROPERTY_CLASSNAME, classname);
    }

    public Boolean isBackground() {
        return (Boolean) get(PROPERTY_ISBACKGROUND);
    }

    public void setBackground(Boolean isBackground) {
        set(PROPERTY_ISBACKGROUND, isBackground);
    }

    public Boolean isJasper() {
        return (Boolean) get(PROPERTY_ISJASPER);
    }

    public void setJasper(Boolean isJasper) {
        set(PROPERTY_ISJASPER, isJasper);
    }

    public String getJrname() {
        return (String) get(PROPERTY_JRNAME);
    }

    public void setJrname(String jrname) {
        set(PROPERTY_JRNAME, jrname);
    }

    public String getServiceType() {
        return (String) get(PROPERTY_SERVICETYPE);
    }

    public void setServiceType(String serviceType) {
        set(PROPERTY_SERVICETYPE, serviceType);
    }

    public Boolean isExternalservice() {
        return (Boolean) get(PROPERTY_ISEXTERNALSERVICE);
    }

    public void setExternalservice(Boolean isexternalservice) {
        set(PROPERTY_ISEXTERNALSERVICE, isexternalservice);
    }

    public String getServiceSource() {
        return (String) get(PROPERTY_SERVICESOURCE);
    }

    public void setServiceSource(String serviceSource) {
        set(PROPERTY_SERVICESOURCE, serviceSource);
    }

    public Module getModule() {
        return (Module) get(PROPERTY_MODULE);
    }

    public void setModule(Module module) {
        set(PROPERTY_MODULE, module);
    }

    public String getUIPattern() {
        return (String) get(PROPERTY_UIPATTERN);
    }

    public void setUIPattern(String uIPattern) {
        set(PROPERTY_UIPATTERN, uIPattern);
    }

    public Boolean isManualresponse() {
        return (Boolean) get(PROPERTY_MANUALRESPONSE);
    }

    public void setManualresponse(Boolean manualresponse) {
        set(PROPERTY_MANUALRESPONSE, manualresponse);
    }

    public Boolean isDirectservletcall() {
        return (Boolean) get(PROPERTY_ISDIRECTSERVLETCALL);
    }

    public void setDirectservletcall(Boolean isdirectservletcall) {
        set(PROPERTY_ISDIRECTSERVLETCALL, isdirectservletcall);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessParameter> getADProcessParameterList() {
        return (List<ProcessParameter>) get(PROPERTY_ADPROCESSPARAMETERLIST);
    }

    public void setADProcessParameterList(
        List<ProcessParameter> aDProcessParameterList) {
        set(PROPERTY_ADPROCESSPARAMETERLIST, aDProcessParameterList);
    }

    @SuppressWarnings("unchecked")
    public List<ModelImplementation> getADModelImplementationList() {
        return (List<ModelImplementation>) get(PROPERTY_ADMODELIMPLEMENTATIONLIST);
    }

    public void setADModelImplementationList(
        List<ModelImplementation> aDModelImplementationList) {
        set(PROPERTY_ADMODELIMPLEMENTATIONLIST, aDModelImplementationList);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessTrl> getADProcessTrlList() {
        return (List<ProcessTrl>) get(PROPERTY_ADPROCESSTRLLIST);
    }

    public void setADProcessTrlList(List<ProcessTrl> aDProcessTrlList) {
        set(PROPERTY_ADPROCESSTRLLIST, aDProcessTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessRequest> getProcessRequestList() {
        return (List<ProcessRequest>) get(PROPERTY_PROCESSREQUESTLIST);
    }

    public void setProcessRequestList(List<ProcessRequest> processRequestList) {
        set(PROPERTY_PROCESSREQUESTLIST, processRequestList);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessScheduling> getADProcessSchedulingList() {
        return (List<ProcessScheduling>) get(PROPERTY_ADPROCESSSCHEDULINGLIST);
    }

    public void setADProcessSchedulingList(
        List<ProcessScheduling> aDProcessSchedulingList) {
        set(PROPERTY_ADPROCESSSCHEDULINGLIST, aDProcessSchedulingList);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessAccess> getADProcessAccessList() {
        return (List<ProcessAccess>) get(PROPERTY_ADPROCESSACCESSLIST);
    }

    public void setADProcessAccessList(List<ProcessAccess> aDProcessAccessList) {
        set(PROPERTY_ADPROCESSACCESSLIST, aDProcessAccessList);
    }
}
