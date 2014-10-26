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
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity ADHeartbeatLog (stored in table AD_Heartbeat_Log).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class HeartbeatLog extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Heartbeat_Log";
    public static final String ENTITY_NAME = "ADHeartbeatLog";
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
    public static final String PROPERTY_ISPROXYREQUIRED = "isproxyrequired";
    public static final String PROPERTY_PROXYSERVER = "proxyServer";
    public static final String PROPERTY_PROXYPORT = "proxyPort";
    public static final String PROPERTY_ACTIVITYRATE = "activityRate";
    public static final String PROPERTY_COMPLEXITYRATE = "complexityRate";
    public static final String PROPERTY_OS = "os";
    public static final String PROPERTY_VERSION = "version";
    public static final String PROPERTY_DB = "db";
    public static final String PROPERTY_VERSION18 = "version18";
    public static final String PROPERTY_SERVLETCONTAINER = "servletContainer";
    public static final String PROPERTY_SERVLETCONTAINERVERSION =
        "servletContainerVersion";
    public static final String PROPERTY_WEBSERVER = "webserver";
    public static final String PROPERTY_WEBSERVERVERSION = "webserverVersion";
    public static final String PROPERTY_JAVAVERSION = "javaVersion";
    public static final String PROPERTY_ANTVERSION = "aNTVersion";
    public static final String PROPERTY_VERSION25 = "version25";
    public static final String PROPERTY_INSTALLMODE = "installmode";
    public static final String PROPERTY_NUMREGISTEREDUSERS =
        "nUMRegisteredUsers";
    public static final String PROPERTY_CODEREVISION = "codeRevision";
    public static final String PROPERTY_BEATTYPE = "beatType";

    public HeartbeatLog() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISHEARTBEATACTIVE, false);
        setDefaultValue(PROPERTY_ISPROXYREQUIRED, false);
        setDefaultValue(PROPERTY_CODEREVISION, "0");
        setDefaultValue(PROPERTY_BEATTYPE, "U");
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

    public BigDecimal getActivityRate() {
        return (BigDecimal) get(PROPERTY_ACTIVITYRATE);
    }

    public void setActivityRate(BigDecimal activityRate) {
        set(PROPERTY_ACTIVITYRATE, activityRate);
    }

    public BigDecimal getComplexityRate() {
        return (BigDecimal) get(PROPERTY_COMPLEXITYRATE);
    }

    public void setComplexityRate(BigDecimal complexityRate) {
        set(PROPERTY_COMPLEXITYRATE, complexityRate);
    }

    public String getOs() {
        return (String) get(PROPERTY_OS);
    }

    public void setOs(String os) {
        set(PROPERTY_OS, os);
    }

    public String getVersion() {
        return (String) get(PROPERTY_VERSION);
    }

    public void setVersion(String version) {
        set(PROPERTY_VERSION, version);
    }

    public String getDb() {
        return (String) get(PROPERTY_DB);
    }

    public void setDb(String db) {
        set(PROPERTY_DB, db);
    }

    public String getVersion18() {
        return (String) get(PROPERTY_VERSION18);
    }

    public void setVersion18(String version18) {
        set(PROPERTY_VERSION18, version18);
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

    public String getJavaVersion() {
        return (String) get(PROPERTY_JAVAVERSION);
    }

    public void setJavaVersion(String javaVersion) {
        set(PROPERTY_JAVAVERSION, javaVersion);
    }

    public String getANTVersion() {
        return (String) get(PROPERTY_ANTVERSION);
    }

    public void setANTVersion(String aNTVersion) {
        set(PROPERTY_ANTVERSION, aNTVersion);
    }

    public String getVersion25() {
        return (String) get(PROPERTY_VERSION25);
    }

    public void setVersion25(String version25) {
        set(PROPERTY_VERSION25, version25);
    }

    public String getInstallmode() {
        return (String) get(PROPERTY_INSTALLMODE);
    }

    public void setInstallmode(String installmode) {
        set(PROPERTY_INSTALLMODE, installmode);
    }

    public Long getNUMRegisteredUsers() {
        return (Long) get(PROPERTY_NUMREGISTEREDUSERS);
    }

    public void setNUMRegisteredUsers(Long nUMRegisteredUsers) {
        set(PROPERTY_NUMREGISTEREDUSERS, nUMRegisteredUsers);
    }

    public String getCodeRevision() {
        return (String) get(PROPERTY_CODEREVISION);
    }

    public void setCodeRevision(String codeRevision) {
        set(PROPERTY_CODEREVISION, codeRevision);
    }

    public String getBeatType() {
        return (String) get(PROPERTY_BEATTYPE);
    }

    public void setBeatType(String beatType) {
        set(PROPERTY_BEATTYPE, beatType);
    }
}
