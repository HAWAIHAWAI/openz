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
package org.zsoft.serial;

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
 * Entity class for entity snr_currentbom_serials (stored in table snr_currentbom_serials).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class snr_currentbom_serials extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "snr_currentbom_serials";
    public static final String ENTITY_NAME = "snr_currentbom_serials";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_SNRCURRENTBOMV = "sNRCurrentbomV";
    public static final String PROPERTY_SNRMASTERDATA = "sNRMasterdata";
    public static final String PROPERTY_SNRBATCHMASTERDATA =
        "sNRBatchmasterdata";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_QTY = "qty";

    public snr_currentbom_serials() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_QTY, (long) 0);
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

    public org.zsoft.serial.snr_currentbom_v getSNRCurrentbomV() {
        return (org.zsoft.serial.snr_currentbom_v) get(PROPERTY_SNRCURRENTBOMV);
    }

    public void setSNRCurrentbomV(
        org.zsoft.serial.snr_currentbom_v sNRCurrentbomV) {
        set(PROPERTY_SNRCURRENTBOMV, sNRCurrentbomV);
    }

    public org.zsoft.serial.snr_masterdata getSNRMasterdata() {
        return (org.zsoft.serial.snr_masterdata) get(PROPERTY_SNRMASTERDATA);
    }

    public void setSNRMasterdata(org.zsoft.serial.snr_masterdata sNRMasterdata) {
        set(PROPERTY_SNRMASTERDATA, sNRMasterdata);
    }

    public Snr_batchmasterdata getSNRBatchmasterdata() {
        return (Snr_batchmasterdata) get(PROPERTY_SNRBATCHMASTERDATA);
    }

    public void setSNRBatchmasterdata(Snr_batchmasterdata sNRBatchmasterdata) {
        set(PROPERTY_SNRBATCHMASTERDATA, sNRBatchmasterdata);
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

    public Long getQty() {
        return (Long) get(PROPERTY_QTY);
    }

    public void setQty(Long qty) {
        set(PROPERTY_QTY, qty);
    }
}
