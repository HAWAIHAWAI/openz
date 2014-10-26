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
import org.openbravo.model.financialmgmt.accounting.ADCreatefactTemplate;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchemaTable;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity AcctSchemaTableDocType (stored in table C_AcctSchema_Table_DocType).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class AcctSchemaTableDocType extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_AcctSchema_Table_DocType";
    public static final String ENTITY_NAME = "AcctSchemaTableDocType";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ACCTSCHEMATABLE = "acctschemaTable";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ALLOWNEGATIVE = "allowNegative";
    public static final String PROPERTY_DOCBASETYPE = "docbasetype";
    public static final String PROPERTY_CREATEFACTTEMPLATE =
        "createfactTemplate";

    public AcctSchemaTableDocType() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ALLOWNEGATIVE, false);
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

    public AcctSchemaTable getAcctschemaTable() {
        return (AcctSchemaTable) get(PROPERTY_ACCTSCHEMATABLE);
    }

    public void setAcctschemaTable(AcctSchemaTable acctschemaTable) {
        set(PROPERTY_ACCTSCHEMATABLE, acctschemaTable);
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

    public Boolean isAllowNegative() {
        return (Boolean) get(PROPERTY_ALLOWNEGATIVE);
    }

    public void setAllowNegative(Boolean allowNegative) {
        set(PROPERTY_ALLOWNEGATIVE, allowNegative);
    }

    public String getDocbasetype() {
        return (String) get(PROPERTY_DOCBASETYPE);
    }

    public void setDocbasetype(String docbasetype) {
        set(PROPERTY_DOCBASETYPE, docbasetype);
    }

    public ADCreatefactTemplate getCreatefactTemplate() {
        return (ADCreatefactTemplate) get(PROPERTY_CREATEFACTTEMPLATE);
    }

    public void setCreatefactTemplate(ADCreatefactTemplate createfactTemplate) {
        set(PROPERTY_CREATEFACTTEMPLATE, createfactTemplate);
    }
}
