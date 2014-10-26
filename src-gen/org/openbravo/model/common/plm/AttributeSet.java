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
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity AttributeSet (stored in table M_AttributeSet).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class AttributeSet extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_AttributeSet";
    public static final String ENTITY_NAME = "AttributeSet";
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
    public static final String PROPERTY_ISSERNO = "isSerNo";
    public static final String PROPERTY_SERNOCTL = "serNoCtl";
    public static final String PROPERTY_ISLOT = "isLot";
    public static final String PROPERTY_LOTCTL = "lotCtl";
    public static final String PROPERTY_ISGUARANTEEDATE = "isGuaranteeDate";
    public static final String PROPERTY_GUARANTEEDAYS = "guaranteeDays";
    public static final String PROPERTY_ISLOCKABLE = "isLockable";
    public static final String PROPERTY_ATTRIBUTEUSELIST = "attributeUseList";

    public AttributeSet() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISSERNO, false);
        setDefaultValue(PROPERTY_ISLOT, false);
        setDefaultValue(PROPERTY_ISGUARANTEEDATE, false);
        setDefaultValue(PROPERTY_ISLOCKABLE, false);
        setDefaultValue(PROPERTY_ATTRIBUTEUSELIST, new ArrayList<Object>());
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

    public Boolean isSerNo() {
        return (Boolean) get(PROPERTY_ISSERNO);
    }

    public void setSerNo(Boolean isSerNo) {
        set(PROPERTY_ISSERNO, isSerNo);
    }

    public SerialNumberControl getSerNoCtl() {
        return (SerialNumberControl) get(PROPERTY_SERNOCTL);
    }

    public void setSerNoCtl(SerialNumberControl serNoCtl) {
        set(PROPERTY_SERNOCTL, serNoCtl);
    }

    public Boolean isLot() {
        return (Boolean) get(PROPERTY_ISLOT);
    }

    public void setLot(Boolean isLot) {
        set(PROPERTY_ISLOT, isLot);
    }

    public LotControl getLotCtl() {
        return (LotControl) get(PROPERTY_LOTCTL);
    }

    public void setLotCtl(LotControl lotCtl) {
        set(PROPERTY_LOTCTL, lotCtl);
    }

    public Boolean isGuaranteeDate() {
        return (Boolean) get(PROPERTY_ISGUARANTEEDATE);
    }

    public void setGuaranteeDate(Boolean isGuaranteeDate) {
        set(PROPERTY_ISGUARANTEEDATE, isGuaranteeDate);
    }

    public Long getGuaranteeDays() {
        return (Long) get(PROPERTY_GUARANTEEDAYS);
    }

    public void setGuaranteeDays(Long guaranteeDays) {
        set(PROPERTY_GUARANTEEDAYS, guaranteeDays);
    }

    public Boolean isLockable() {
        return (Boolean) get(PROPERTY_ISLOCKABLE);
    }

    public void setLockable(Boolean isLockable) {
        set(PROPERTY_ISLOCKABLE, isLockable);
    }

    @SuppressWarnings("unchecked")
    public List<AttributeUse> getAttributeUseList() {
        return (List<AttributeUse>) get(PROPERTY_ATTRIBUTEUSELIST);
    }

    public void setAttributeUseList(List<AttributeUse> attributeUseList) {
        set(PROPERTY_ATTRIBUTEUSELIST, attributeUseList);
    }
}
