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
package org.openbravo.model.financialmgmt.payment;

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
 * Entity class for entity FinancialMgmtPaymentTermLine (stored in table C_Paymenttermline).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class PaymentTermLine extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Paymenttermline";
    public static final String ENTITY_NAME = "FinancialMgmtPaymentTermLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PAYMENTTERM = "paymentTerm";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_PERCENTAGE = "percentage";
    public static final String PROPERTY_ONREMAINDER = "onremainder";
    public static final String PROPERTY_EXCLUDETAX = "excludetax";
    public static final String PROPERTY_PAYMENTRULE = "paymentRule";
    public static final String PROPERTY_ISDUEFIXED = "isDueFixed";
    public static final String PROPERTY_NETDAYS = "netDays";
    public static final String PROPERTY_FIXMONTHCUTOFF = "fixMonthCutoff";
    public static final String PROPERTY_FIXMONTHDAY = "fixMonthDay";
    public static final String PROPERTY_FIXMONTHDAY2 = "fixMonthDay2";
    public static final String PROPERTY_FIXMONTHDAY3 = "fixmonthday3";
    public static final String PROPERTY_FIXMONTHOFFSET = "fixMonthOffset";
    public static final String PROPERTY_ISNEXTBUSINESSDAY = "isNextBusinessDay";
    public static final String PROPERTY_NETDAY = "netDay";

    public PaymentTermLine() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PERCENTAGE, new BigDecimal(100));
        setDefaultValue(PROPERTY_ONREMAINDER, true);
        setDefaultValue(PROPERTY_EXCLUDETAX, false);
        setDefaultValue(PROPERTY_ISDUEFIXED, false);
        setDefaultValue(PROPERTY_ISNEXTBUSINESSDAY, true);
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

    public PaymentTerm getPaymentTerm() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERM);
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        set(PROPERTY_PAYMENTTERM, paymentTerm);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public BigDecimal getPercentage() {
        return (BigDecimal) get(PROPERTY_PERCENTAGE);
    }

    public void setPercentage(BigDecimal percentage) {
        set(PROPERTY_PERCENTAGE, percentage);
    }

    public Boolean isOnremainder() {
        return (Boolean) get(PROPERTY_ONREMAINDER);
    }

    public void setOnremainder(Boolean onremainder) {
        set(PROPERTY_ONREMAINDER, onremainder);
    }

    public Boolean isExcludetax() {
        return (Boolean) get(PROPERTY_EXCLUDETAX);
    }

    public void setExcludetax(Boolean excludetax) {
        set(PROPERTY_EXCLUDETAX, excludetax);
    }

    public String getPaymentRule() {
        return (String) get(PROPERTY_PAYMENTRULE);
    }

    public void setPaymentRule(String paymentRule) {
        set(PROPERTY_PAYMENTRULE, paymentRule);
    }

    public Boolean isDueFixed() {
        return (Boolean) get(PROPERTY_ISDUEFIXED);
    }

    public void setDueFixed(Boolean isDueFixed) {
        set(PROPERTY_ISDUEFIXED, isDueFixed);
    }

    public Long getNetDays() {
        return (Long) get(PROPERTY_NETDAYS);
    }

    public void setNetDays(Long netDays) {
        set(PROPERTY_NETDAYS, netDays);
    }

    public Long getFixMonthCutoff() {
        return (Long) get(PROPERTY_FIXMONTHCUTOFF);
    }

    public void setFixMonthCutoff(Long fixMonthCutoff) {
        set(PROPERTY_FIXMONTHCUTOFF, fixMonthCutoff);
    }

    public Long getFixMonthDay() {
        return (Long) get(PROPERTY_FIXMONTHDAY);
    }

    public void setFixMonthDay(Long fixMonthDay) {
        set(PROPERTY_FIXMONTHDAY, fixMonthDay);
    }

    public Long getFixMonthDay2() {
        return (Long) get(PROPERTY_FIXMONTHDAY2);
    }

    public void setFixMonthDay2(Long fixMonthDay2) {
        set(PROPERTY_FIXMONTHDAY2, fixMonthDay2);
    }

    public Long getFixmonthday3() {
        return (Long) get(PROPERTY_FIXMONTHDAY3);
    }

    public void setFixmonthday3(Long fixmonthday3) {
        set(PROPERTY_FIXMONTHDAY3, fixmonthday3);
    }

    public Long getFixMonthOffset() {
        return (Long) get(PROPERTY_FIXMONTHOFFSET);
    }

    public void setFixMonthOffset(Long fixMonthOffset) {
        set(PROPERTY_FIXMONTHOFFSET, fixMonthOffset);
    }

    public Boolean isNextBusinessDay() {
        return (Boolean) get(PROPERTY_ISNEXTBUSINESSDAY);
    }

    public void setNextBusinessDay(Boolean isNextBusinessDay) {
        set(PROPERTY_ISNEXTBUSINESSDAY, isNextBusinessDay);
    }

    public String getNetDay() {
        return (String) get(PROPERTY_NETDAY);
    }

    public void setNetDay(String netDay) {
        set(PROPERTY_NETDAY, netDay);
    }
}
