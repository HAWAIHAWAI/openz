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
package org.openbravo.model.common.plm;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity Attribute (stored in table M_Attribute).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Attribute extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Attribute";
    public static final String ENTITY_NAME = "Attribute";
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
    public static final String PROPERTY_ISMANDATORY = "isMandatory";
    public static final String PROPERTY_ISINSTANCEATTRIBUTE =
        "isInstanceAttribute";
    public static final String PROPERTY_ISLIST = "isList";
    public static final String PROPERTY_ATTRIBUTEUSELIST = "attributeUseList";
    public static final String PROPERTY_ATTRIBUTEVALUELIST =
        "attributeValueList";
    public static final String PROPERTY_ATTRIBUTEINSTANCELIST =
        "attributeInstanceList";

    public Attribute() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISMANDATORY, false);
        setDefaultValue(PROPERTY_ISINSTANCEATTRIBUTE, false);
        setDefaultValue(PROPERTY_ISLIST, true);
        setDefaultValue(PROPERTY_ATTRIBUTEUSELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ATTRIBUTEVALUELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ATTRIBUTEINSTANCELIST, new ArrayList<Object>());
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

    public Boolean isMandatory() {
        return (Boolean) get(PROPERTY_ISMANDATORY);
    }

    public void setMandatory(Boolean isMandatory) {
        set(PROPERTY_ISMANDATORY, isMandatory);
    }

    public Boolean isInstanceAttribute() {
        return (Boolean) get(PROPERTY_ISINSTANCEATTRIBUTE);
    }

    public void setInstanceAttribute(Boolean isInstanceAttribute) {
        set(PROPERTY_ISINSTANCEATTRIBUTE, isInstanceAttribute);
    }

    public Boolean isList() {
        return (Boolean) get(PROPERTY_ISLIST);
    }

    public void setList(Boolean isList) {
        set(PROPERTY_ISLIST, isList);
    }

    @SuppressWarnings("unchecked")
    public List<AttributeUse> getAttributeUseList() {
        return (List<AttributeUse>) get(PROPERTY_ATTRIBUTEUSELIST);
    }

    public void setAttributeUseList(List<AttributeUse> attributeUseList) {
        set(PROPERTY_ATTRIBUTEUSELIST, attributeUseList);
    }

    @SuppressWarnings("unchecked")
    public List<AttributeValue> getAttributeValueList() {
        return (List<AttributeValue>) get(PROPERTY_ATTRIBUTEVALUELIST);
    }

    public void setAttributeValueList(List<AttributeValue> attributeValueList) {
        set(PROPERTY_ATTRIBUTEVALUELIST, attributeValueList);
    }

    @SuppressWarnings("unchecked")
    public List<AttributeInstance> getAttributeInstanceList() {
        return (List<AttributeInstance>) get(PROPERTY_ATTRIBUTEINSTANCELIST);
    }

    public void setAttributeInstanceList(
        List<AttributeInstance> attributeInstanceList) {
        set(PROPERTY_ATTRIBUTEINSTANCELIST, attributeInstanceList);
    }
}
