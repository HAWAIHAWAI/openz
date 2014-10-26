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
import org.openbravo.zsoft.finance.Zsfi_discount;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity FinancialMgmtPaymentTerm (stored in table C_PaymentTerm).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class PaymentTerm extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_PaymentTerm";
    public static final String ENTITY_NAME = "FinancialMgmtPaymentTerm";
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
    public static final String PROPERTY_DOCUMENTNOTE = "documentNote";
    public static final String PROPERTY_ISDUEFIXED = "isDueFixed";
    public static final String PROPERTY_NETDAYS = "netDays";
    public static final String PROPERTY_FIXMONTHDAY = "fixMonthDay";
    public static final String PROPERTY_FIXMONTHOFFSET = "fixMonthOffset";
    public static final String PROPERTY_ISNEXTBUSINESSDAY = "isNextBusinessDay";
    public static final String PROPERTY_ISDEFAULT = "isDefault";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_NETDAY = "netDay";
    public static final String PROPERTY_ISVALID = "isValid";
    public static final String PROPERTY_FIXMONTHDAY2 = "fixMonthDay2";
    public static final String PROPERTY_FIXMONTHDAY3 = "fixmonthday3";
    public static final String PROPERTY_FINANCIALMGMTPAYMENTTERMTRLLIST =
        "financialMgmtPaymentTermTrlList";
    public static final String PROPERTY_FINANCIALMGMTPAYMENTTERMLINELIST =
        "financialMgmtPaymentTermLineList";
    public static final String PROPERTY_ZSFIDISCOUNTLIST = "zsfiDiscountList";

    public PaymentTerm() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISDUEFIXED, false);
        setDefaultValue(PROPERTY_ISNEXTBUSINESSDAY, false);
        setDefaultValue(PROPERTY_ISDEFAULT, false);
        setDefaultValue(PROPERTY_ISVALID, false);
        setDefaultValue(PROPERTY_FINANCIALMGMTPAYMENTTERMTRLLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTPAYMENTTERMLINELIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSFIDISCOUNTLIST, new ArrayList<Object>());
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

    public String getDocumentNote() {
        return (String) get(PROPERTY_DOCUMENTNOTE);
    }

    public void setDocumentNote(String documentNote) {
        set(PROPERTY_DOCUMENTNOTE, documentNote);
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

    public Long getFixMonthDay() {
        return (Long) get(PROPERTY_FIXMONTHDAY);
    }

    public void setFixMonthDay(Long fixMonthDay) {
        set(PROPERTY_FIXMONTHDAY, fixMonthDay);
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

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_ISDEFAULT);
    }

    public void setDefault(Boolean isDefault) {
        set(PROPERTY_ISDEFAULT, isDefault);
    }

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
    }

    public String getNetDay() {
        return (String) get(PROPERTY_NETDAY);
    }

    public void setNetDay(String netDay) {
        set(PROPERTY_NETDAY, netDay);
    }

    public Boolean isValid() {
        return (Boolean) get(PROPERTY_ISVALID);
    }

    public void setValid(Boolean isValid) {
        set(PROPERTY_ISVALID, isValid);
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

    @SuppressWarnings("unchecked")
    public List<PaymentTermTrl> getFinancialMgmtPaymentTermTrlList() {
        return (List<PaymentTermTrl>) get(PROPERTY_FINANCIALMGMTPAYMENTTERMTRLLIST);
    }

    public void setFinancialMgmtPaymentTermTrlList(
        List<PaymentTermTrl> financialMgmtPaymentTermTrlList) {
        set(PROPERTY_FINANCIALMGMTPAYMENTTERMTRLLIST,
            financialMgmtPaymentTermTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<PaymentTermLine> getFinancialMgmtPaymentTermLineList() {
        return (List<PaymentTermLine>) get(PROPERTY_FINANCIALMGMTPAYMENTTERMLINELIST);
    }

    public void setFinancialMgmtPaymentTermLineList(
        List<PaymentTermLine> financialMgmtPaymentTermLineList) {
        set(PROPERTY_FINANCIALMGMTPAYMENTTERMLINELIST,
            financialMgmtPaymentTermLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Zsfi_discount> getZsfiDiscountList() {
        return (List<Zsfi_discount>) get(PROPERTY_ZSFIDISCOUNTLIST);
    }

    public void setZsfiDiscountList(List<Zsfi_discount> zsfiDiscountList) {
        set(PROPERTY_ZSFIDISCOUNTLIST, zsfiDiscountList);
    }
}
