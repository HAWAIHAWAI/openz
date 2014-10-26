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
package org.openbravo.model.mrp;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity MRPPlanningMethodLine (stored in table MRP_PlanningMethodLine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class PlanningMethodLine extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "MRP_PlanningMethodLine";
    public static final String ENTITY_NAME = "MRPPlanningMethodLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_MRPPLANNINGMETHOD = "mRPPlanningmethod";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_INOUTTRXTYPE = "inouttrxtype";
    public static final String PROPERTY_WEIGHTING = "weighting";
    public static final String PROPERTY_DAYSFROM = "daysfrom";
    public static final String PROPERTY_DAYSTO = "daysto";

    public PlanningMethodLine() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_WEIGHTING, new BigDecimal(1));
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

    public PlanningMethod getMRPPlanningmethod() {
        return (PlanningMethod) get(PROPERTY_MRPPLANNINGMETHOD);
    }

    public void setMRPPlanningmethod(PlanningMethod mRPPlanningmethod) {
        set(PROPERTY_MRPPLANNINGMETHOD, mRPPlanningmethod);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public String getInouttrxtype() {
        return (String) get(PROPERTY_INOUTTRXTYPE);
    }

    public void setInouttrxtype(String inouttrxtype) {
        set(PROPERTY_INOUTTRXTYPE, inouttrxtype);
    }

    public BigDecimal getWeighting() {
        return (BigDecimal) get(PROPERTY_WEIGHTING);
    }

    public void setWeighting(BigDecimal weighting) {
        set(PROPERTY_WEIGHTING, weighting);
    }

    public Long getDaysfrom() {
        return (Long) get(PROPERTY_DAYSFROM);
    }

    public void setDaysfrom(Long daysfrom) {
        set(PROPERTY_DAYSFROM, daysfrom);
    }

    public Long getDaysto() {
        return (Long) get(PROPERTY_DAYSTO);
    }

    public void setDaysto(Long daysto) {
        set(PROPERTY_DAYSTO, daysto);
    }
}
