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
package org.openbravo.model.ad.access;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.system.ADChangeLog;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ADSession (stored in table AD_Session).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Session extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Session";
    public static final String ENTITY_NAME = "ADSession";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_WEBSESSION = "webSession";
    public static final String PROPERTY_REMOTEADDR = "remoteAddr";
    public static final String PROPERTY_REMOTEHOST = "remoteHost";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_SESSIONACTIVE = "sessionActive";
    public static final String PROPERTY_SERVERURL = "serverUrl";
    public static final String PROPERTY_ADCHANGELOGLIST = "aDChangeLogList";

    public Session() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_SESSIONACTIVE, false);
        setDefaultValue(PROPERTY_ADCHANGELOGLIST, new ArrayList<Object>());
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

    public String getWebSession() {
        return (String) get(PROPERTY_WEBSESSION);
    }

    public void setWebSession(String webSession) {
        set(PROPERTY_WEBSESSION, webSession);
    }

    public String getRemoteAddr() {
        return (String) get(PROPERTY_REMOTEADDR);
    }

    public void setRemoteAddr(String remoteAddr) {
        set(PROPERTY_REMOTEADDR, remoteAddr);
    }

    public String getRemoteHost() {
        return (String) get(PROPERTY_REMOTEHOST);
    }

    public void setRemoteHost(String remoteHost) {
        set(PROPERTY_REMOTEHOST, remoteHost);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Boolean isSessionActive() {
        return (Boolean) get(PROPERTY_SESSIONACTIVE);
    }

    public void setSessionActive(Boolean sessionActive) {
        set(PROPERTY_SESSIONACTIVE, sessionActive);
    }

    public String getServerUrl() {
        return (String) get(PROPERTY_SERVERURL);
    }

    public void setServerUrl(String serverUrl) {
        set(PROPERTY_SERVERURL, serverUrl);
    }

    @SuppressWarnings("unchecked")
    public List<ADChangeLog> getADChangeLogList() {
        return (List<ADChangeLog>) get(PROPERTY_ADCHANGELOGLIST);
    }

    public void setADChangeLogList(List<ADChangeLog> aDChangeLogList) {
        set(PROPERTY_ADCHANGELOGLIST, aDChangeLogList);
    }
}
