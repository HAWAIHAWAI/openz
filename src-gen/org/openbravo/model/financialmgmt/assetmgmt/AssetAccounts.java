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
package org.openbravo.model.financialmgmt.assetmgmt;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.coa.AccountingCombination;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity FinancialMgmtAssetAccounts (stored in table A_Asset_Acct).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class AssetAccounts extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "A_Asset_Acct";
    public static final String ENTITY_NAME = "FinancialMgmtAssetAccounts";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_ACCTSCHEMA = "acctSchema";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DEPRECIATIONACCT = "depreciationAcct";
    public static final String PROPERTY_ACCUMDEPRECIATIONACCT =
        "accumdepreciationAcct";
    public static final String PROPERTY_DISPOSALLOSS = "disposalLoss";
    public static final String PROPERTY_DISPOSALGAIN = "disposalGain";

    public AssetAccounts() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
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

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public AcctSchema getAcctSchema() {
        return (AcctSchema) get(PROPERTY_ACCTSCHEMA);
    }

    public void setAcctSchema(AcctSchema acctSchema) {
        set(PROPERTY_ACCTSCHEMA, acctSchema);
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

    public AccountingCombination getDepreciationAcct() {
        return (AccountingCombination) get(PROPERTY_DEPRECIATIONACCT);
    }

    public void setDepreciationAcct(AccountingCombination depreciationAcct) {
        set(PROPERTY_DEPRECIATIONACCT, depreciationAcct);
    }

    public AccountingCombination getAccumdepreciationAcct() {
        return (AccountingCombination) get(PROPERTY_ACCUMDEPRECIATIONACCT);
    }

    public void setAccumdepreciationAcct(
        AccountingCombination accumdepreciationAcct) {
        set(PROPERTY_ACCUMDEPRECIATIONACCT, accumdepreciationAcct);
    }

    public AccountingCombination getDisposalLoss() {
        return (AccountingCombination) get(PROPERTY_DISPOSALLOSS);
    }

    public void setDisposalLoss(AccountingCombination disposalLoss) {
        set(PROPERTY_DISPOSALLOSS, disposalLoss);
    }

    public AccountingCombination getDisposalGain() {
        return (AccountingCombination) get(PROPERTY_DISPOSALGAIN);
    }

    public void setDisposalGain(AccountingCombination disposalGain) {
        set(PROPERTY_DISPOSALGAIN, disposalGain);
    }
}
