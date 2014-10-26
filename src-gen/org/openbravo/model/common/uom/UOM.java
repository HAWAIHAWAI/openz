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
package org.openbravo.model.common.uom;

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
 * Entity class for entity UOM (stored in table C_UOM).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class UOM extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_UOM";
    public static final String ENTITY_NAME = "UOM";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_X12DE355 = "x12DE355";
    public static final String PROPERTY_UOMSYMBOL = "uOMSymbol";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_STDPRECISION = "stdPrecision";
    public static final String PROPERTY_COSTINGPRECISION = "costingPrecision";
    public static final String PROPERTY_ISDEFAULT = "isDefault";
    public static final String PROPERTY_BREAKDOWN = "breakdown";
    public static final String PROPERTY_UOMCONVERSIONLIST = "uOMConversionList";
    public static final String PROPERTY_UOMTRLLIST = "uOMTrlList";

    public UOM() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_STDPRECISION, (long) 0);
        setDefaultValue(PROPERTY_COSTINGPRECISION, (long) 0);
        setDefaultValue(PROPERTY_ISDEFAULT, false);
        setDefaultValue(PROPERTY_BREAKDOWN, false);
        setDefaultValue(PROPERTY_UOMCONVERSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_UOMTRLLIST, new ArrayList<Object>());
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

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public String getX12DE355() {
        return (String) get(PROPERTY_X12DE355);
    }

    public void setX12DE355(String x12DE355) {
        set(PROPERTY_X12DE355, x12DE355);
    }

    public String getUOMSymbol() {
        return (String) get(PROPERTY_UOMSYMBOL);
    }

    public void setUOMSymbol(String uOMSymbol) {
        set(PROPERTY_UOMSYMBOL, uOMSymbol);
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

    public Long getStdPrecision() {
        return (Long) get(PROPERTY_STDPRECISION);
    }

    public void setStdPrecision(Long stdPrecision) {
        set(PROPERTY_STDPRECISION, stdPrecision);
    }

    public Long getCostingPrecision() {
        return (Long) get(PROPERTY_COSTINGPRECISION);
    }

    public void setCostingPrecision(Long costingPrecision) {
        set(PROPERTY_COSTINGPRECISION, costingPrecision);
    }

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_ISDEFAULT);
    }

    public void setDefault(Boolean isDefault) {
        set(PROPERTY_ISDEFAULT, isDefault);
    }

    public Boolean isBreakdown() {
        return (Boolean) get(PROPERTY_BREAKDOWN);
    }

    public void setBreakdown(Boolean breakdown) {
        set(PROPERTY_BREAKDOWN, breakdown);
    }

    @SuppressWarnings("unchecked")
    public List<UOMConversion> getUOMConversionList() {
        return (List<UOMConversion>) get(PROPERTY_UOMCONVERSIONLIST);
    }

    public void setUOMConversionList(List<UOMConversion> uOMConversionList) {
        set(PROPERTY_UOMCONVERSIONLIST, uOMConversionList);
    }

    @SuppressWarnings("unchecked")
    public List<UOMTrl> getUOMTrlList() {
        return (List<UOMTrl>) get(PROPERTY_UOMTRLLIST);
    }

    public void setUOMTrlList(List<UOMTrl> uOMTrlList) {
        set(PROPERTY_UOMTRLLIST, uOMTrlList);
    }
}
