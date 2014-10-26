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
package org.openbravo.model.sales;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.order.OrderLine;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity SalesCommissionDetail (stored in table C_CommissionDetail).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class CommissionDetail extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_CommissionDetail";
    public static final String ENTITY_NAME = "SalesCommissionDetail";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_COMMISSIONAMT = "commissionAmt";
    public static final String PROPERTY_REFERENCE = "reference";
    public static final String PROPERTY_ORDERLINE = "orderLine";
    public static final String PROPERTY_INVOICELINE = "invoiceLine";
    public static final String PROPERTY_INFO = "info";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_ACTUALAMT = "actualAmt";
    public static final String PROPERTY_CONVERTEDAMT = "convertedAmt";
    public static final String PROPERTY_ACTUALQTY = "actualQty";

    public CommissionDetail() {
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

    public CommissionAmount getCommissionAmt() {
        return (CommissionAmount) get(PROPERTY_COMMISSIONAMT);
    }

    public void setCommissionAmt(CommissionAmount commissionAmt) {
        set(PROPERTY_COMMISSIONAMT, commissionAmt);
    }

    public String getReference() {
        return (String) get(PROPERTY_REFERENCE);
    }

    public void setReference(String reference) {
        set(PROPERTY_REFERENCE, reference);
    }

    public OrderLine getOrderLine() {
        return (OrderLine) get(PROPERTY_ORDERLINE);
    }

    public void setOrderLine(OrderLine orderLine) {
        set(PROPERTY_ORDERLINE, orderLine);
    }

    public InvoiceLine getInvoiceLine() {
        return (InvoiceLine) get(PROPERTY_INVOICELINE);
    }

    public void setInvoiceLine(InvoiceLine invoiceLine) {
        set(PROPERTY_INVOICELINE, invoiceLine);
    }

    public String getInfo() {
        return (String) get(PROPERTY_INFO);
    }

    public void setInfo(String info) {
        set(PROPERTY_INFO, info);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public BigDecimal getActualAmt() {
        return (BigDecimal) get(PROPERTY_ACTUALAMT);
    }

    public void setActualAmt(BigDecimal actualAmt) {
        set(PROPERTY_ACTUALAMT, actualAmt);
    }

    public BigDecimal getConvertedAmt() {
        return (BigDecimal) get(PROPERTY_CONVERTEDAMT);
    }

    public void setConvertedAmt(BigDecimal convertedAmt) {
        set(PROPERTY_CONVERTEDAMT, convertedAmt);
    }

    public BigDecimal getActualQty() {
        return (BigDecimal) get(PROPERTY_ACTUALQTY);
    }

    public void setActualQty(BigDecimal actualQty) {
        set(PROPERTY_ACTUALQTY, actualQty);
    }
}
