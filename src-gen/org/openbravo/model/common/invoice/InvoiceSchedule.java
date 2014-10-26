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
package org.openbravo.model.common.invoice;

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
 * Entity class for entity InvoiceSchedule (stored in table C_InvoiceSchedule).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class InvoiceSchedule extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_InvoiceSchedule";
    public static final String ENTITY_NAME = "InvoiceSchedule";
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
    public static final String PROPERTY_ISAMOUNT = "isAmount";
    public static final String PROPERTY_AMT = "amt";
    public static final String PROPERTY_INVOICEFREQUENCY = "invoiceFrequency";
    public static final String PROPERTY_INVOICEWEEKDAY = "invoiceWeekDay";
    public static final String PROPERTY_INVOICEWEEKDAYCUTOFF =
        "invoiceWeekDayCutoff";
    public static final String PROPERTY_EVENINVOICEWEEK = "evenInvoiceWeek";
    public static final String PROPERTY_INVOICEDAY = "invoiceDay";
    public static final String PROPERTY_INVOICEDAYCUTOFF = "invoiceDayCutoff";
    public static final String PROPERTY_ISDEFAULT = "isDefault";

    public InvoiceSchedule() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISAMOUNT, false);
        setDefaultValue(PROPERTY_EVENINVOICEWEEK, false);
        setDefaultValue(PROPERTY_INVOICEDAY, (long) 1);
        setDefaultValue(PROPERTY_ISDEFAULT, false);
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

    public Boolean isAmount() {
        return (Boolean) get(PROPERTY_ISAMOUNT);
    }

    public void setAmount(Boolean isAmount) {
        set(PROPERTY_ISAMOUNT, isAmount);
    }

    public BigDecimal getAmt() {
        return (BigDecimal) get(PROPERTY_AMT);
    }

    public void setAmt(BigDecimal amt) {
        set(PROPERTY_AMT, amt);
    }

    public String getInvoiceFrequency() {
        return (String) get(PROPERTY_INVOICEFREQUENCY);
    }

    public void setInvoiceFrequency(String invoiceFrequency) {
        set(PROPERTY_INVOICEFREQUENCY, invoiceFrequency);
    }

    public String getInvoiceWeekDay() {
        return (String) get(PROPERTY_INVOICEWEEKDAY);
    }

    public void setInvoiceWeekDay(String invoiceWeekDay) {
        set(PROPERTY_INVOICEWEEKDAY, invoiceWeekDay);
    }

    public String getInvoiceWeekDayCutoff() {
        return (String) get(PROPERTY_INVOICEWEEKDAYCUTOFF);
    }

    public void setInvoiceWeekDayCutoff(String invoiceWeekDayCutoff) {
        set(PROPERTY_INVOICEWEEKDAYCUTOFF, invoiceWeekDayCutoff);
    }

    public Boolean isEvenInvoiceWeek() {
        return (Boolean) get(PROPERTY_EVENINVOICEWEEK);
    }

    public void setEvenInvoiceWeek(Boolean evenInvoiceWeek) {
        set(PROPERTY_EVENINVOICEWEEK, evenInvoiceWeek);
    }

    public Long getInvoiceDay() {
        return (Long) get(PROPERTY_INVOICEDAY);
    }

    public void setInvoiceDay(Long invoiceDay) {
        set(PROPERTY_INVOICEDAY, invoiceDay);
    }

    public Long getInvoiceDayCutoff() {
        return (Long) get(PROPERTY_INVOICEDAYCUTOFF);
    }

    public void setInvoiceDayCutoff(Long invoiceDayCutoff) {
        set(PROPERTY_INVOICEDAYCUTOFF, invoiceDayCutoff);
    }

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_ISDEFAULT);
    }

    public void setDefault(Boolean isDefault) {
        set(PROPERTY_ISDEFAULT, isDefault);
    }
}
