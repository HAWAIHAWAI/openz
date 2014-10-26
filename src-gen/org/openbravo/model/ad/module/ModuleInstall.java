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
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity ADModuleInstall (stored in table AD_Module_Install).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ModuleInstall extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Module_Install";
    public static final String ENTITY_NAME = "ADModuleInstall";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_MODULE = "module";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_VERSION = "version";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_HELP = "help";
    public static final String PROPERTY_URL = "url";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_LICENSE = "license";
    public static final String PROPERTY_ISINDEVELOPMENT = "isindevelopment";
    public static final String PROPERTY_ISDEFAULT = "isdefault";
    public static final String PROPERTY_SEQNO = "seqno";
    public static final String PROPERTY_JAVAPACKAGE = "javapackage";
    public static final String PROPERTY_LICENSETYPE = "licensetype";
    public static final String PROPERTY_AUTHOR = "author";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_UPDATEAVAILABLE = "updateAvailable";
    public static final String PROPERTY_ISTRANSLATIONREQUIRED =
        "istranslationrequired";
    public static final String PROPERTY_LANGUAGE = "language";
    public static final String PROPERTY_HASCHARTOFACCOUNTS =
        "haschartofaccounts";
    public static final String PROPERTY_ISTRANSLATIONMODULE =
        "istranslationmodule";
    public static final String PROPERTY_HASREFERENCEDATA = "hasreferencedata";
    public static final String PROPERTY_ISREGISTERED = "isregistered";
    public static final String PROPERTY_UPDATEINFO = "updateinfo";
    public static final String PROPERTY_UPDATEVER = "updateVer";
    public static final String PROPERTY_REFERENCEDATAINFO = "referencedatainfo";
    public static final String PROPERTY_VERSIONLABEL = "versionLabel";
    public static final String PROPERTY_VERSION34 = "version34";
    public static final String PROPERTY_ISCOMMERCIAL = "iscommercial";

    public ModuleInstall() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_TYPE, "M");
        setDefaultValue(PROPERTY_ISINDEVELOPMENT, false);
        setDefaultValue(PROPERTY_ISDEFAULT, false);
        setDefaultValue(PROPERTY_STATUS, "I");
        setDefaultValue(PROPERTY_ISTRANSLATIONREQUIRED, false);
        setDefaultValue(PROPERTY_HASCHARTOFACCOUNTS, false);
        setDefaultValue(PROPERTY_ISTRANSLATIONMODULE, false);
        setDefaultValue(PROPERTY_HASREFERENCEDATA, false);
        setDefaultValue(PROPERTY_ISREGISTERED, false);
        setDefaultValue(PROPERTY_ISCOMMERCIAL, false);
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

    public String getModule() {
        return (String) get(PROPERTY_MODULE);
    }

    public void setModule(String module) {
        set(PROPERTY_MODULE, module);
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

    public String getUrl() {
        return (String) get(PROPERTY_URL);
    }

    public void setUrl(String url) {
        set(PROPERTY_URL, url);
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

    public Boolean isIndevelopment() {
        return (Boolean) get(PROPERTY_ISINDEVELOPMENT);
    }

    public void setIndevelopment(Boolean isindevelopment) {
        set(PROPERTY_ISINDEVELOPMENT, isindevelopment);
    }

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_ISDEFAULT);
    }

    public void setDefault(Boolean isdefault) {
        set(PROPERTY_ISDEFAULT, isdefault);
    }

    public Long getSeqno() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqno(Long seqno) {
        set(PROPERTY_SEQNO, seqno);
    }

    public String getJavapackage() {
        return (String) get(PROPERTY_JAVAPACKAGE);
    }

    public void setJavapackage(String javapackage) {
        set(PROPERTY_JAVAPACKAGE, javapackage);
    }

    public String getLicensetype() {
        return (String) get(PROPERTY_LICENSETYPE);
    }

    public void setLicensetype(String licensetype) {
        set(PROPERTY_LICENSETYPE, licensetype);
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

    public Boolean isTranslationrequired() {
        return (Boolean) get(PROPERTY_ISTRANSLATIONREQUIRED);
    }

    public void setTranslationrequired(Boolean istranslationrequired) {
        set(PROPERTY_ISTRANSLATIONREQUIRED, istranslationrequired);
    }

    public String getLanguage() {
        return (String) get(PROPERTY_LANGUAGE);
    }

    public void setLanguage(String language) {
        set(PROPERTY_LANGUAGE, language);
    }

    public Boolean isHaschartofaccounts() {
        return (Boolean) get(PROPERTY_HASCHARTOFACCOUNTS);
    }

    public void setHaschartofaccounts(Boolean haschartofaccounts) {
        set(PROPERTY_HASCHARTOFACCOUNTS, haschartofaccounts);
    }

    public Boolean isTranslationmodule() {
        return (Boolean) get(PROPERTY_ISTRANSLATIONMODULE);
    }

    public void setTranslationmodule(Boolean istranslationmodule) {
        set(PROPERTY_ISTRANSLATIONMODULE, istranslationmodule);
    }

    public Boolean isHasreferencedata() {
        return (Boolean) get(PROPERTY_HASREFERENCEDATA);
    }

    public void setHasreferencedata(Boolean hasreferencedata) {
        set(PROPERTY_HASREFERENCEDATA, hasreferencedata);
    }

    public Boolean isRegistered() {
        return (Boolean) get(PROPERTY_ISREGISTERED);
    }

    public void setRegistered(Boolean isregistered) {
        set(PROPERTY_ISREGISTERED, isregistered);
    }

    public String getUpdateinfo() {
        return (String) get(PROPERTY_UPDATEINFO);
    }

    public void setUpdateinfo(String updateinfo) {
        set(PROPERTY_UPDATEINFO, updateinfo);
    }

    public String getUpdateVer() {
        return (String) get(PROPERTY_UPDATEVER);
    }

    public void setUpdateVer(String updateVer) {
        set(PROPERTY_UPDATEVER, updateVer);
    }

    public String getReferencedatainfo() {
        return (String) get(PROPERTY_REFERENCEDATAINFO);
    }

    public void setReferencedatainfo(String referencedatainfo) {
        set(PROPERTY_REFERENCEDATAINFO, referencedatainfo);
    }

    public String getVersionLabel() {
        return (String) get(PROPERTY_VERSIONLABEL);
    }

    public void setVersionLabel(String versionLabel) {
        set(PROPERTY_VERSIONLABEL, versionLabel);
    }

    public String getVersion34() {
        return (String) get(PROPERTY_VERSION34);
    }

    public void setVersion34(String version34) {
        set(PROPERTY_VERSION34, version34);
    }

    public Boolean isCommercial() {
        return (Boolean) get(PROPERTY_ISCOMMERCIAL);
    }

    public void setCommercial(Boolean iscommercial) {
        set(PROPERTY_ISCOMMERCIAL, iscommercial);
    }
}
