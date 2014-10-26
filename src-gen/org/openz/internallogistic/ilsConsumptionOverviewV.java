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
package org.openz.internallogistic;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.materialmgmt.transaction.InternalConsumptionLine;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity ils_consumption_overview_v (stored in table ils_consumption_overview_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ilsConsumptionOverviewV extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ils_consumption_overview_v";
    public static final String ENTITY_NAME = "ils_consumption_overview_v";
    public static final String PROPERTY_OE = "oe";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_SUPERVISOR = "supervisor";
    public static final String PROPERTY_MOVEMENTDATE = "movementdate";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_MOVEMENTQTY = "movementqty";
    public static final String PROPERTY_COSTS = "costs";
    public static final String PROPERTY_COSTTOTAL = "costtotal";
    public static final String PROPERTY_INTERNALCONSUMPTIONLINE =
        "internalConsumptionline";
    public static final String PROPERTY_MOVEMENTTYPE = "movementtype";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";

    public ilsConsumptionOverviewV() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getOe() {
        return (String) get(PROPERTY_OE);
    }

    public void setOe(String oe) {
        set(PROPERTY_OE, oe);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public String getSupervisor() {
        return (String) get(PROPERTY_SUPERVISOR);
    }

    public void setSupervisor(String supervisor) {
        set(PROPERTY_SUPERVISOR, supervisor);
    }

    public Date getMovementdate() {
        return (Date) get(PROPERTY_MOVEMENTDATE);
    }

    public void setMovementdate(Date movementdate) {
        set(PROPERTY_MOVEMENTDATE, movementdate);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getMovementqty() {
        return (BigDecimal) get(PROPERTY_MOVEMENTQTY);
    }

    public void setMovementqty(BigDecimal movementqty) {
        set(PROPERTY_MOVEMENTQTY, movementqty);
    }

    public BigDecimal getCosts() {
        return (BigDecimal) get(PROPERTY_COSTS);
    }

    public void setCosts(BigDecimal costs) {
        set(PROPERTY_COSTS, costs);
    }

    public BigDecimal getCosttotal() {
        return (BigDecimal) get(PROPERTY_COSTTOTAL);
    }

    public void setCosttotal(BigDecimal costtotal) {
        set(PROPERTY_COSTTOTAL, costtotal);
    }

    public InternalConsumptionLine getInternalConsumptionline() {
        return (InternalConsumptionLine) get(PROPERTY_INTERNALCONSUMPTIONLINE);
    }

    public void setInternalConsumptionline(
        InternalConsumptionLine internalConsumptionline) {
        set(PROPERTY_INTERNALCONSUMPTIONLINE, internalConsumptionline);
    }

    public String getMovementtype() {
        return (String) get(PROPERTY_MOVEMENTTYPE);
    }

    public void setMovementtype(String movementtype) {
        set(PROPERTY_MOVEMENTTYPE, movementtype);
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
}
