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

import java.util.Date;

/**
 * Entity class for entity ADSystem (stored in table AD_System).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class System extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_System";
    public static final String ENTITY_NAME = "ADSystem";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_INFO = "info";
    public static final String PROPERTY_VERSION = "version";
    public static final String PROPERTY_RELEASENO = "releaseNo";
    public static final String PROPERTY_TADRECORDRANGE = "tADRecordrange";
    public static final String PROPERTY_TADRECORDRANGEINFO =
        "tADRecordrangeInfo";
    public static final String PROPERTY_TADTRANSACTIONALRANGE =
        "tADTransactionalrange";
    public static final String PROPERTY_TADTHEME = "tADTheme";
    public static final String PROPERTY_INSTANCEKEY = "instanceKey";
    public static final String PROPERTY_ACTIVATIONKEY = "activationKey";

    public System() {
        setDefaultValue(PROPERTY_ISACTIVE, false);
        setDefaultValue(PROPERTY_TADRECORDRANGE, (long) 500);
        setDefaultValue(PROPERTY_TADRECORDRANGEINFO, (long) 500);
        setDefaultValue(PROPERTY_TADTRANSACTIONALRANGE, (long) 1);
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

    public String getInfo() {
        return (String) get(PROPERTY_INFO);
    }

    public void setInfo(String info) {
        set(PROPERTY_INFO, info);
    }

    public String getVersion() {
        return (String) get(PROPERTY_VERSION);
    }

    public void setVersion(String version) {
        set(PROPERTY_VERSION, version);
    }

    public String getReleaseNo() {
        return (String) get(PROPERTY_RELEASENO);
    }

    public void setReleaseNo(String releaseNo) {
        set(PROPERTY_RELEASENO, releaseNo);
    }

    public Long getTADRecordrange() {
        return (Long) get(PROPERTY_TADRECORDRANGE);
    }

    public void setTADRecordrange(Long tADRecordrange) {
        set(PROPERTY_TADRECORDRANGE, tADRecordrange);
    }

    public Long getTADRecordrangeInfo() {
        return (Long) get(PROPERTY_TADRECORDRANGEINFO);
    }

    public void setTADRecordrangeInfo(Long tADRecordrangeInfo) {
        set(PROPERTY_TADRECORDRANGEINFO, tADRecordrangeInfo);
    }

    public Long getTADTransactionalrange() {
        return (Long) get(PROPERTY_TADTRANSACTIONALRANGE);
    }

    public void setTADTransactionalrange(Long tADTransactionalrange) {
        set(PROPERTY_TADTRANSACTIONALRANGE, tADTransactionalrange);
    }

    public String getTADTheme() {
        return (String) get(PROPERTY_TADTHEME);
    }

    public void setTADTheme(String tADTheme) {
        set(PROPERTY_TADTHEME, tADTheme);
    }

    public String getInstanceKey() {
        return (String) get(PROPERTY_INSTANCEKEY);
    }

    public void setInstanceKey(String instanceKey) {
        set(PROPERTY_INSTANCEKEY, instanceKey);
    }

    public String getActivationKey() {
        return (String) get(PROPERTY_ACTIVATIONKEY);
    }

    public void setActivationKey(String activationKey) {
        set(PROPERTY_ACTIVATIONKEY, activationKey);
    }
}
