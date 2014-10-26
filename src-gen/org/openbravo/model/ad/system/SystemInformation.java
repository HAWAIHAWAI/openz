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
package org.openbravo.model.ad.system;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.utility.Image;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity ADSystemInformation (stored in table AD_System_Info).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SystemInformation extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_System_Info";
    public static final String ENTITY_NAME = "ADSystemInformation";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SYSTEMIDENTIFIER = "systemIdentifier";
    public static final String PROPERTY_ISHEARTBEATACTIVE = "isheartbeatactive";
    public static final String PROPERTY_POSTPONEDATE = "postponeDate";
    public static final String PROPERTY_ISPROXYREQUIRED = "isproxyrequired";
    public static final String PROPERTY_PROXYSERVER = "proxyServer";
    public static final String PROPERTY_PROXYPORT = "proxyPort";
    public static final String PROPERTY_TESTPROXY = "testproxy";
    public static final String PROPERTY_ANTVERSION = "aNTVersion";
    public static final String PROPERTY_VERSION = "version";
    public static final String PROPERTY_INSTALLMODE = "installmode";
    public static final String PROPERTY_CODEREVISION = "codeRevision";
    public static final String PROPERTY_SERVLETCONTAINER = "servletContainer";
    public static final String PROPERTY_SERVLETCONTAINERVERSION =
        "servletContainerVersion";
    public static final String PROPERTY_WEBSERVER = "webserver";
    public static final String PROPERTY_WEBSERVERVERSION = "webserverVersion";
    public static final String PROPERTY_CUSTOMIZATIONALLOWED =
        "customizationAllowed";
    public static final String PROPERTY_LASTBUILD = "lastBuild";
    public static final String PROPERTY_LASTDBUPDATE = "lastDBUpdate";
    public static final String PROPERTY_CHECKSUM = "checksum";
    public static final String PROPERTY_YOURCOMPANYLOGINIMAGE =
        "yourCompanyLoginImage";
    public static final String PROPERTY_YOURITSERVICELOGINIMAGE =
        "yourItServiceLoginImage";
    public static final String PROPERTY_YOURCOMPANYMENUIMAGE =
        "yourCompanyMenuImage";
    public static final String PROPERTY_YOURCOMPANYBIGIMAGE =
        "yourCompanyBigImage";
    public static final String PROPERTY_YOURCOMPANYDOCUMENTIMAGE =
        "yourCompanyDocumentImage";
    public static final String PROPERTY_SUPPORTCONTACT = "supportContact";
    public static final String PROPERTY_SYSTEMSTATUS = "systemStatus";

    public SystemInformation() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISHEARTBEATACTIVE, false);
        setDefaultValue(PROPERTY_ISPROXYREQUIRED, false);
        setDefaultValue(PROPERTY_TESTPROXY, "N");
        setDefaultValue(PROPERTY_CODEREVISION, "0");
        setDefaultValue(PROPERTY_CUSTOMIZATIONALLOWED, false);
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

    public String getSystemIdentifier() {
        return (String) get(PROPERTY_SYSTEMIDENTIFIER);
    }

    public void setSystemIdentifier(String systemIdentifier) {
        set(PROPERTY_SYSTEMIDENTIFIER, systemIdentifier);
    }

    public Boolean isHeartbeatactive() {
        return (Boolean) get(PROPERTY_ISHEARTBEATACTIVE);
    }

    public void setHeartbeatactive(Boolean isheartbeatactive) {
        set(PROPERTY_ISHEARTBEATACTIVE, isheartbeatactive);
    }

    public Date getPostponeDate() {
        return (Date) get(PROPERTY_POSTPONEDATE);
    }

    public void setPostponeDate(Date postponeDate) {
        set(PROPERTY_POSTPONEDATE, postponeDate);
    }

    public Boolean isProxyrequired() {
        return (Boolean) get(PROPERTY_ISPROXYREQUIRED);
    }

    public void setProxyrequired(Boolean isproxyrequired) {
        set(PROPERTY_ISPROXYREQUIRED, isproxyrequired);
    }

    public String getProxyServer() {
        return (String) get(PROPERTY_PROXYSERVER);
    }

    public void setProxyServer(String proxyServer) {
        set(PROPERTY_PROXYSERVER, proxyServer);
    }

    public Long getProxyPort() {
        return (Long) get(PROPERTY_PROXYPORT);
    }

    public void setProxyPort(Long proxyPort) {
        set(PROPERTY_PROXYPORT, proxyPort);
    }

    public String getTestproxy() {
        return (String) get(PROPERTY_TESTPROXY);
    }

    public void setTestproxy(String testproxy) {
        set(PROPERTY_TESTPROXY, testproxy);
    }

    public String getANTVersion() {
        return (String) get(PROPERTY_ANTVERSION);
    }

    public void setANTVersion(String aNTVersion) {
        set(PROPERTY_ANTVERSION, aNTVersion);
    }

    public String getVersion() {
        return (String) get(PROPERTY_VERSION);
    }

    public void setVersion(String version) {
        set(PROPERTY_VERSION, version);
    }

    public String getInstallmode() {
        return (String) get(PROPERTY_INSTALLMODE);
    }

    public void setInstallmode(String installmode) {
        set(PROPERTY_INSTALLMODE, installmode);
    }

    public String getCodeRevision() {
        return (String) get(PROPERTY_CODEREVISION);
    }

    public void setCodeRevision(String codeRevision) {
        set(PROPERTY_CODEREVISION, codeRevision);
    }

    public String getServletContainer() {
        return (String) get(PROPERTY_SERVLETCONTAINER);
    }

    public void setServletContainer(String servletContainer) {
        set(PROPERTY_SERVLETCONTAINER, servletContainer);
    }

    public String getServletContainerVersion() {
        return (String) get(PROPERTY_SERVLETCONTAINERVERSION);
    }

    public void setServletContainerVersion(String servletContainerVersion) {
        set(PROPERTY_SERVLETCONTAINERVERSION, servletContainerVersion);
    }

    public String getWebserver() {
        return (String) get(PROPERTY_WEBSERVER);
    }

    public void setWebserver(String webserver) {
        set(PROPERTY_WEBSERVER, webserver);
    }

    public String getWebserverVersion() {
        return (String) get(PROPERTY_WEBSERVERVERSION);
    }

    public void setWebserverVersion(String webserverVersion) {
        set(PROPERTY_WEBSERVERVERSION, webserverVersion);
    }

    public Boolean isCustomizationAllowed() {
        return (Boolean) get(PROPERTY_CUSTOMIZATIONALLOWED);
    }

    public void setCustomizationAllowed(Boolean customizationAllowed) {
        set(PROPERTY_CUSTOMIZATIONALLOWED, customizationAllowed);
    }

    public Date getLastBuild() {
        return (Date) get(PROPERTY_LASTBUILD);
    }

    public void setLastBuild(Date lastBuild) {
        set(PROPERTY_LASTBUILD, lastBuild);
    }

    public Date getLastDBUpdate() {
        return (Date) get(PROPERTY_LASTDBUPDATE);
    }

    public void setLastDBUpdate(Date lastDBUpdate) {
        set(PROPERTY_LASTDBUPDATE, lastDBUpdate);
    }

    public String getChecksum() {
        return (String) get(PROPERTY_CHECKSUM);
    }

    public void setChecksum(String checksum) {
        set(PROPERTY_CHECKSUM, checksum);
    }

    public Image getYourCompanyLoginImage() {
        return (Image) get(PROPERTY_YOURCOMPANYLOGINIMAGE);
    }

    public void setYourCompanyLoginImage(Image yourCompanyLoginImage) {
        set(PROPERTY_YOURCOMPANYLOGINIMAGE, yourCompanyLoginImage);
    }

    public Image getYourItServiceLoginImage() {
        return (Image) get(PROPERTY_YOURITSERVICELOGINIMAGE);
    }

    public void setYourItServiceLoginImage(Image yourItServiceLoginImage) {
        set(PROPERTY_YOURITSERVICELOGINIMAGE, yourItServiceLoginImage);
    }

    public Image getYourCompanyMenuImage() {
        return (Image) get(PROPERTY_YOURCOMPANYMENUIMAGE);
    }

    public void setYourCompanyMenuImage(Image yourCompanyMenuImage) {
        set(PROPERTY_YOURCOMPANYMENUIMAGE, yourCompanyMenuImage);
    }

    public Image getYourCompanyBigImage() {
        return (Image) get(PROPERTY_YOURCOMPANYBIGIMAGE);
    }

    public void setYourCompanyBigImage(Image yourCompanyBigImage) {
        set(PROPERTY_YOURCOMPANYBIGIMAGE, yourCompanyBigImage);
    }

    public Image getYourCompanyDocumentImage() {
        return (Image) get(PROPERTY_YOURCOMPANYDOCUMENTIMAGE);
    }

    public void setYourCompanyDocumentImage(Image yourCompanyDocumentImage) {
        set(PROPERTY_YOURCOMPANYDOCUMENTIMAGE, yourCompanyDocumentImage);
    }

    public String getSupportContact() {
        return (String) get(PROPERTY_SUPPORTCONTACT);
    }

    public void setSupportContact(String supportContact) {
        set(PROPERTY_SUPPORTCONTACT, supportContact);
    }

    public String getSystemStatus() {
        return (String) get(PROPERTY_SYSTEMSTATUS);
    }

    public void setSystemStatus(String systemStatus) {
        set(PROPERTY_SYSTEMSTATUS, systemStatus);
    }
}
