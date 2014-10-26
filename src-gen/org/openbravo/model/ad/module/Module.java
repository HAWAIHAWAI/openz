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
package org.openbravo.model.ad.module;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.datamodel.ModuleScriptorder;
import org.openbravo.model.ad.domain.ModelImplementation;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.system.Language;
import org.openbravo.model.ad.system.NamingException;
import org.openbravo.model.ad.utility.ReferenceDataStore;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ADModule (stored in table AD_Module).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Module extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Module";
    public static final String ENTITY_NAME = "ADModule";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_VERSION = "version";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_HELP = "help";
    public static final String PROPERTY_URL = "uRL";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_LICENSE = "license";
    public static final String PROPERTY_ISINDEVELOPMENT = "isInDevelopment";
    public static final String PROPERTY_ISDEFAULT = "isDefault";
    public static final String PROPERTY_SEQNO = "seqno";
    public static final String PROPERTY_JAVAPACKAGE = "javaPackage";
    public static final String PROPERTY_LICENSETYPE = "licenseType";
    public static final String PROPERTY_AUTHOR = "author";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_UPDATEAVAILABLE = "updateAvailable";
    public static final String PROPERTY_ISTRANSLATIONREQUIRED =
        "isTranslationRequired";
    public static final String PROPERTY_LANGUAGE = "language";
    public static final String PROPERTY_HASCHARTOFACCOUNTS =
        "hasChartOfAccounts";
    public static final String PROPERTY_ISTRANSLATIONMODULE =
        "isTranslationModule";
    public static final String PROPERTY_HASREFERENCEDATA = "hasReferenceData";
    public static final String PROPERTY_UPDATEINFO = "updateInfo";
    public static final String PROPERTY_UPDATEVER = "updateVer";
    public static final String PROPERTY_REFERENCEDATAINFO = "referenceDataInfo";
    public static final String PROPERTY_VERSIONLABEL = "versionLabel";
    public static final String PROPERTY_VERSION32 = "version32";
    public static final String PROPERTY_ISCOMMERCIAL = "isCommercial";
    public static final String PROPERTY_ISPARTOFDISTRIBUTION =
        "ispartofdistribution";
    public static final String PROPERTY_ORDERNUMBER = "ordernumber";
    public static final String PROPERTY_MODULESCRIPTORDERLIST =
        "moduleScriptorderList";
    public static final String PROPERTY_REFERENCEDATASTORELIST =
        "referenceDataStoreList";
    public static final String PROPERTY_MODULESQLLIST = "moduleSqlList";
    public static final String PROPERTY_ADMODELIMPLEMENTATIONLIST =
        "aDModelImplementationList";
    public static final String PROPERTY_DATAPACKAGELIST = "dataPackageList";
    public static final String PROPERTY_MODULEDEPENDENCYLIST =
        "moduleDependencyList";
    public static final String PROPERTY_NAMINGEXCEPTIONLIST =
        "namingExceptionList";
    public static final String PROPERTY_MODULEDBPREFIXLIST =
        "moduleDBPrefixList";
    public static final String PROPERTY_MODULELOGLIST = "moduleLogList";

    public Module() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_TYPE, "M");
        setDefaultValue(PROPERTY_ISINDEVELOPMENT, false);
        setDefaultValue(PROPERTY_ISDEFAULT, false);
        setDefaultValue(PROPERTY_STATUS, "A");
        setDefaultValue(PROPERTY_ISTRANSLATIONREQUIRED, false);
        setDefaultValue(PROPERTY_HASCHARTOFACCOUNTS, false);
        setDefaultValue(PROPERTY_ISTRANSLATIONMODULE, false);
        setDefaultValue(PROPERTY_HASREFERENCEDATA, false);
        setDefaultValue(PROPERTY_ISCOMMERCIAL, false);
        setDefaultValue(PROPERTY_ISPARTOFDISTRIBUTION, true);
        setDefaultValue(PROPERTY_ORDERNUMBER, (long) 0);
        setDefaultValue(PROPERTY_MODULESCRIPTORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_REFERENCEDATASTORELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MODULESQLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADMODELIMPLEMENTATIONLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_DATAPACKAGELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MODULEDEPENDENCYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_NAMINGEXCEPTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MODULEDBPREFIXLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MODULELOGLIST, new ArrayList<Object>());
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

    public String getVersion() {
        return (String) get(PROPERTY_VERSION);
    }

    public void setVersion(String version) {
        set(PROPERTY_VERSION, version);
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

    public String getURL() {
        return (String) get(PROPERTY_URL);
    }

    public void setURL(String uRL) {
        set(PROPERTY_URL, uRL);
    }

    public String getType() {
        return (String) get(PROPERTY_TYPE);
    }

    public void setType(String type) {
        set(PROPERTY_TYPE, type);
    }

    public String getLicense() {
        return (String) get(PROPERTY_LICENSE);
    }

    public void setLicense(String license) {
        set(PROPERTY_LICENSE, license);
    }

    public Boolean isInDevelopment() {
        return (Boolean) get(PROPERTY_ISINDEVELOPMENT);
    }

    public void setInDevelopment(Boolean isInDevelopment) {
        set(PROPERTY_ISINDEVELOPMENT, isInDevelopment);
    }

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_ISDEFAULT);
    }

    public void setDefault(Boolean isDefault) {
        set(PROPERTY_ISDEFAULT, isDefault);
    }

    public Long getSeqno() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqno(Long seqno) {
        set(PROPERTY_SEQNO, seqno);
    }

    public String getJavaPackage() {
        return (String) get(PROPERTY_JAVAPACKAGE);
    }

    public void setJavaPackage(String javaPackage) {
        set(PROPERTY_JAVAPACKAGE, javaPackage);
    }

    public String getLicenseType() {
        return (String) get(PROPERTY_LICENSETYPE);
    }

    public void setLicenseType(String licenseType) {
        set(PROPERTY_LICENSETYPE, licenseType);
    }

    public String getAuthor() {
        return (String) get(PROPERTY_AUTHOR);
    }

    public void setAuthor(String author) {
        set(PROPERTY_AUTHOR, author);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public String getUpdateAvailable() {
        return (String) get(PROPERTY_UPDATEAVAILABLE);
    }

    public void setUpdateAvailable(String updateAvailable) {
        set(PROPERTY_UPDATEAVAILABLE, updateAvailable);
    }

    public Boolean isTranslationRequired() {
        return (Boolean) get(PROPERTY_ISTRANSLATIONREQUIRED);
    }

    public void setTranslationRequired(Boolean isTranslationRequired) {
        set(PROPERTY_ISTRANSLATIONREQUIRED, isTranslationRequired);
    }

    public Language getLanguage() {
        return (Language) get(PROPERTY_LANGUAGE);
    }

    public void setLanguage(Language language) {
        set(PROPERTY_LANGUAGE, language);
    }

    public Boolean isHasChartOfAccounts() {
        return (Boolean) get(PROPERTY_HASCHARTOFACCOUNTS);
    }

    public void setHasChartOfAccounts(Boolean hasChartOfAccounts) {
        set(PROPERTY_HASCHARTOFACCOUNTS, hasChartOfAccounts);
    }

    public Boolean isTranslationModule() {
        return (Boolean) get(PROPERTY_ISTRANSLATIONMODULE);
    }

    public void setTranslationModule(Boolean isTranslationModule) {
        set(PROPERTY_ISTRANSLATIONMODULE, isTranslationModule);
    }

    public Boolean isHasReferenceData() {
        return (Boolean) get(PROPERTY_HASREFERENCEDATA);
    }

    public void setHasReferenceData(Boolean hasReferenceData) {
        set(PROPERTY_HASREFERENCEDATA, hasReferenceData);
    }

    public String getUpdateInfo() {
        return (String) get(PROPERTY_UPDATEINFO);
    }

    public void setUpdateInfo(String updateInfo) {
        set(PROPERTY_UPDATEINFO, updateInfo);
    }

    public String getUpdateVer() {
        return (String) get(PROPERTY_UPDATEVER);
    }

    public void setUpdateVer(String updateVer) {
        set(PROPERTY_UPDATEVER, updateVer);
    }

    public String getReferenceDataInfo() {
        return (String) get(PROPERTY_REFERENCEDATAINFO);
    }

    public void setReferenceDataInfo(String referenceDataInfo) {
        set(PROPERTY_REFERENCEDATAINFO, referenceDataInfo);
    }

    public String getVersionLabel() {
        return (String) get(PROPERTY_VERSIONLABEL);
    }

    public void setVersionLabel(String versionLabel) {
        set(PROPERTY_VERSIONLABEL, versionLabel);
    }

    public String getVersion32() {
        return (String) get(PROPERTY_VERSION32);
    }

    public void setVersion32(String version32) {
        set(PROPERTY_VERSION32, version32);
    }

    public Boolean isCommercial() {
        return (Boolean) get(PROPERTY_ISCOMMERCIAL);
    }

    public void setCommercial(Boolean isCommercial) {
        set(PROPERTY_ISCOMMERCIAL, isCommercial);
    }

    public Boolean isPartofdistribution() {
        return (Boolean) get(PROPERTY_ISPARTOFDISTRIBUTION);
    }

    public void setPartofdistribution(Boolean ispartofdistribution) {
        set(PROPERTY_ISPARTOFDISTRIBUTION, ispartofdistribution);
    }

    public Long getOrdernumber() {
        return (Long) get(PROPERTY_ORDERNUMBER);
    }

    public void setOrdernumber(Long ordernumber) {
        set(PROPERTY_ORDERNUMBER, ordernumber);
    }

    @SuppressWarnings("unchecked")
    public List<ModuleScriptorder> getModuleScriptorderList() {
        return (List<ModuleScriptorder>) get(PROPERTY_MODULESCRIPTORDERLIST);
    }

    public void setModuleScriptorderList(
        List<ModuleScriptorder> moduleScriptorderList) {
        set(PROPERTY_MODULESCRIPTORDERLIST, moduleScriptorderList);
    }

    @SuppressWarnings("unchecked")
    public List<ReferenceDataStore> getReferenceDataStoreList() {
        return (List<ReferenceDataStore>) get(PROPERTY_REFERENCEDATASTORELIST);
    }

    public void setReferenceDataStoreList(
        List<ReferenceDataStore> referenceDataStoreList) {
        set(PROPERTY_REFERENCEDATASTORELIST, referenceDataStoreList);
    }

    @SuppressWarnings("unchecked")
    public List<Ad_module_sql> getModuleSqlList() {
        return (List<Ad_module_sql>) get(PROPERTY_MODULESQLLIST);
    }

    public void setModuleSqlList(List<Ad_module_sql> moduleSqlList) {
        set(PROPERTY_MODULESQLLIST, moduleSqlList);
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
    public List<DataPackage> getDataPackageList() {
        return (List<DataPackage>) get(PROPERTY_DATAPACKAGELIST);
    }

    public void setDataPackageList(List<DataPackage> dataPackageList) {
        set(PROPERTY_DATAPACKAGELIST, dataPackageList);
    }

    @SuppressWarnings("unchecked")
    public List<ModuleDependency> getModuleDependencyList() {
        return (List<ModuleDependency>) get(PROPERTY_MODULEDEPENDENCYLIST);
    }

    public void setModuleDependencyList(
        List<ModuleDependency> moduleDependencyList) {
        set(PROPERTY_MODULEDEPENDENCYLIST, moduleDependencyList);
    }

    @SuppressWarnings("unchecked")
    public List<NamingException> getNamingExceptionList() {
        return (List<NamingException>) get(PROPERTY_NAMINGEXCEPTIONLIST);
    }

    public void setNamingExceptionList(
        List<NamingException> namingExceptionList) {
        set(PROPERTY_NAMINGEXCEPTIONLIST, namingExceptionList);
    }

    @SuppressWarnings("unchecked")
    public List<ModuleDBPrefix> getModuleDBPrefixList() {
        return (List<ModuleDBPrefix>) get(PROPERTY_MODULEDBPREFIXLIST);
    }

    public void setModuleDBPrefixList(List<ModuleDBPrefix> moduleDBPrefixList) {
        set(PROPERTY_MODULEDBPREFIXLIST, moduleDBPrefixList);
    }

    @SuppressWarnings("unchecked")
    public List<ModuleLog> getModuleLogList() {
        return (List<ModuleLog>) get(PROPERTY_MODULELOGLIST);
    }

    public void setModuleLogList(List<ModuleLog> moduleLogList) {
        set(PROPERTY_MODULELOGLIST, moduleLogList);
    }
}
