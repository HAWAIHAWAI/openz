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
package org.openbravo.model.financialmgmt.accounting.coa;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.utility.Tree;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity FinancialMgmtElement (stored in table C_Element).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Element extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Element";
    public static final String ENTITY_NAME = "FinancialMgmtElement";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_VFORMAT = "vFormat";
    public static final String PROPERTY_ELEMENTTYPE = "elementType";
    public static final String PROPERTY_ISBALANCING = "isBalancing";
    public static final String PROPERTY_ISNATURALACCOUNT = "isNaturalAccount";
    public static final String PROPERTY_TREE = "tree";
    public static final String PROPERTY_ADD2TREE = "add2Tree";
    public static final String PROPERTY_ADD1TREE = "add1Tree";
    public static final String PROPERTY_ACCTSCHEMA = "acctschema";
    public static final String PROPERTY_FINANCIALMGMTELEMENTVALUELIST =
        "financialMgmtElementValueList";

    public Element() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ELEMENTTYPE, "A");
        setDefaultValue(PROPERTY_ISBALANCING, false);
        setDefaultValue(PROPERTY_ISNATURALACCOUNT, false);
        setDefaultValue(PROPERTY_FINANCIALMGMTELEMENTVALUELIST,
            new ArrayList<Object>());
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getVFormat() {
        return (String) get(PROPERTY_VFORMAT);
    }

    public void setVFormat(String vFormat) {
        set(PROPERTY_VFORMAT, vFormat);
    }

    public String getElementType() {
        return (String) get(PROPERTY_ELEMENTTYPE);
    }

    public void setElementType(String elementType) {
        set(PROPERTY_ELEMENTTYPE, elementType);
    }

    public Boolean isBalancing() {
        return (Boolean) get(PROPERTY_ISBALANCING);
    }

    public void setBalancing(Boolean isBalancing) {
        set(PROPERTY_ISBALANCING, isBalancing);
    }

    public Boolean isNaturalAccount() {
        return (Boolean) get(PROPERTY_ISNATURALACCOUNT);
    }

    public void setNaturalAccount(Boolean isNaturalAccount) {
        set(PROPERTY_ISNATURALACCOUNT, isNaturalAccount);
    }

    public Tree getTree() {
        return (Tree) get(PROPERTY_TREE);
    }

    public void setTree(Tree tree) {
        set(PROPERTY_TREE, tree);
    }

    public Tree getAdd2Tree() {
        return (Tree) get(PROPERTY_ADD2TREE);
    }

    public void setAdd2Tree(Tree add2Tree) {
        set(PROPERTY_ADD2TREE, add2Tree);
    }

    public Tree getAdd1Tree() {
        return (Tree) get(PROPERTY_ADD1TREE);
    }

    public void setAdd1Tree(Tree add1Tree) {
        set(PROPERTY_ADD1TREE, add1Tree);
    }

    public AcctSchema getAcctschema() {
        return (AcctSchema) get(PROPERTY_ACCTSCHEMA);
    }

    public void setAcctschema(AcctSchema acctschema) {
        set(PROPERTY_ACCTSCHEMA, acctschema);
    }

    @SuppressWarnings("unchecked")
    public List<ElementValue> getFinancialMgmtElementValueList() {
        return (List<ElementValue>) get(PROPERTY_FINANCIALMGMTELEMENTVALUELIST);
    }

    public void setFinancialMgmtElementValueList(
        List<ElementValue> financialMgmtElementValueList) {
        set(PROPERTY_FINANCIALMGMTELEMENTVALUELIST,
            financialMgmtElementValueList);
    }
}
