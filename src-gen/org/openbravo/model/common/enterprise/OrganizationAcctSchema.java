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
package org.openbravo.model.common.enterprise;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;
import org.openbravo.model.financialmgmt.tax.TaxRate;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity OrganizationAcctSchema (stored in table AD_Org_AcctSchema).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class OrganizationAcctSchema extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Org_AcctSchema";
    public static final String ENTITY_NAME = "OrganizationAcctSchema";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACCTSCHEMA = "acctschema";
    public static final String PROPERTY_SEQUENCEBP = "sequenceBp";
    public static final String PROPERTY_SEQUENCEPR = "sequencePr";
    public static final String PROPERTY_ISBPNEWACCOUNT = "isBpNewAccount";
    public static final String PROPERTY_ISPRNEWACCOUNT = "isPrNewAccount";
    public static final String PROPERTY_ACCTLENGTH = "acctLength";
    public static final String PROPERTY_SUBACCTLENGTH = "subAcctLength";
    public static final String PROPERTY_TAX = "tax";

    public OrganizationAcctSchema() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISBPNEWACCOUNT, false);
        setDefaultValue(PROPERTY_ISPRNEWACCOUNT, false);
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

    public AcctSchema getAcctschema() {
        return (AcctSchema) get(PROPERTY_ACCTSCHEMA);
    }

    public void setAcctschema(AcctSchema acctschema) {
        set(PROPERTY_ACCTSCHEMA, acctschema);
    }

    public Sequence getSequenceBp() {
        return (Sequence) get(PROPERTY_SEQUENCEBP);
    }

    public void setSequenceBp(Sequence sequenceBp) {
        set(PROPERTY_SEQUENCEBP, sequenceBp);
    }

    public Sequence getSequencePr() {
        return (Sequence) get(PROPERTY_SEQUENCEPR);
    }

    public void setSequencePr(Sequence sequencePr) {
        set(PROPERTY_SEQUENCEPR, sequencePr);
    }

    public Boolean isBpNewAccount() {
        return (Boolean) get(PROPERTY_ISBPNEWACCOUNT);
    }

    public void setBpNewAccount(Boolean isBpNewAccount) {
        set(PROPERTY_ISBPNEWACCOUNT, isBpNewAccount);
    }

    public Boolean isPrNewAccount() {
        return (Boolean) get(PROPERTY_ISPRNEWACCOUNT);
    }

    public void setPrNewAccount(Boolean isPrNewAccount) {
        set(PROPERTY_ISPRNEWACCOUNT, isPrNewAccount);
    }

    public Long getAcctLength() {
        return (Long) get(PROPERTY_ACCTLENGTH);
    }

    public void setAcctLength(Long acctLength) {
        set(PROPERTY_ACCTLENGTH, acctLength);
    }

    public Long getSubAcctLength() {
        return (Long) get(PROPERTY_SUBACCTLENGTH);
    }

    public void setSubAcctLength(Long subAcctLength) {
        set(PROPERTY_SUBACCTLENGTH, subAcctLength);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }
}
