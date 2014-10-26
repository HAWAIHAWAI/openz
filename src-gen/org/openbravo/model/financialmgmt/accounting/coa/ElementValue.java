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
import org.openbravo.model.common.bank.BankAccount;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity FinancialMgmtElementValue (stored in table C_ElementValue).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ElementValue extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_ElementValue";
    public static final String ENTITY_NAME = "FinancialMgmtElementValue";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ACCOUNTTYPE = "accountType";
    public static final String PROPERTY_ACCOUNTSIGN = "accountSign";
    public static final String PROPERTY_ISDOCCONTROLLED = "isDocControlled";
    public static final String PROPERTY_ELEMENT = "element";
    public static final String PROPERTY_ISSUMMARY = "isSummary";
    public static final String PROPERTY_VALIDFROM = "validFrom";
    public static final String PROPERTY_VALIDTO = "validTo";
    public static final String PROPERTY_POSTACTUAL = "postActual";
    public static final String PROPERTY_POSTBUDGET = "postBudget";
    public static final String PROPERTY_POSTENCUMBRANCE = "postEncumbrance";
    public static final String PROPERTY_POSTSTATISTICAL = "postStatistical";
    public static final String PROPERTY_ISBANKACCOUNT = "isBankAccount";
    public static final String PROPERTY_BANKACCOUNT = "bankAccount";
    public static final String PROPERTY_ISFOREIGNCURRENCY = "isForeignCurrency";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_SHOWELEMENT = "showElement";
    public static final String PROPERTY_SHOWVALUECOND = "showValueCond";
    public static final String PROPERTY_ELEMENTLEVEL = "elementLevel";
    public static final String PROPERTY_NOMANUALACCT = "nomanualacct";
    public static final String PROPERTY_DATEVUSEAUTO = "datevuseauto";
    public static final String PROPERTY_FINANCIALMGMTELEMENTVALUETRLLIST =
        "financialMgmtElementValueTrlList";
    public static final String PROPERTY_FINANCIALMGMTELEMENTVALUEOPERANDLIST =
        "financialMgmtElementValueOperandList";

    public ElementValue() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ACCOUNTTYPE, "E");
        setDefaultValue(PROPERTY_ACCOUNTSIGN, "N");
        setDefaultValue(PROPERTY_ISDOCCONTROLLED, false);
        setDefaultValue(PROPERTY_ISSUMMARY, false);
        setDefaultValue(PROPERTY_POSTACTUAL, true);
        setDefaultValue(PROPERTY_POSTBUDGET, true);
        setDefaultValue(PROPERTY_POSTENCUMBRANCE, true);
        setDefaultValue(PROPERTY_POSTSTATISTICAL, true);
        setDefaultValue(PROPERTY_ISBANKACCOUNT, false);
        setDefaultValue(PROPERTY_ISFOREIGNCURRENCY, false);
        setDefaultValue(PROPERTY_SHOWELEMENT, true);
        setDefaultValue(PROPERTY_SHOWVALUECOND, "A");
        setDefaultValue(PROPERTY_ELEMENTLEVEL, "C");
        setDefaultValue(PROPERTY_NOMANUALACCT, false);
        setDefaultValue(PROPERTY_DATEVUSEAUTO, false);
        setDefaultValue(PROPERTY_FINANCIALMGMTELEMENTVALUETRLLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTELEMENTVALUEOPERANDLIST,
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

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
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

    public String getAccountType() {
        return (String) get(PROPERTY_ACCOUNTTYPE);
    }

    public void setAccountType(String accountType) {
        set(PROPERTY_ACCOUNTTYPE, accountType);
    }

    public String getAccountSign() {
        return (String) get(PROPERTY_ACCOUNTSIGN);
    }

    public void setAccountSign(String accountSign) {
        set(PROPERTY_ACCOUNTSIGN, accountSign);
    }

    public Boolean isDocControlled() {
        return (Boolean) get(PROPERTY_ISDOCCONTROLLED);
    }

    public void setDocControlled(Boolean isDocControlled) {
        set(PROPERTY_ISDOCCONTROLLED, isDocControlled);
    }

    public Element getElement() {
        return (Element) get(PROPERTY_ELEMENT);
    }

    public void setElement(Element element) {
        set(PROPERTY_ELEMENT, element);
    }

    public Boolean isSummary() {
        return (Boolean) get(PROPERTY_ISSUMMARY);
    }

    public void setSummary(Boolean isSummary) {
        set(PROPERTY_ISSUMMARY, isSummary);
    }

    public Date getValidFrom() {
        return (Date) get(PROPERTY_VALIDFROM);
    }

    public void setValidFrom(Date validFrom) {
        set(PROPERTY_VALIDFROM, validFrom);
    }

    public Date getValidTo() {
        return (Date) get(PROPERTY_VALIDTO);
    }

    public void setValidTo(Date validTo) {
        set(PROPERTY_VALIDTO, validTo);
    }

    public Boolean isPostActual() {
        return (Boolean) get(PROPERTY_POSTACTUAL);
    }

    public void setPostActual(Boolean postActual) {
        set(PROPERTY_POSTACTUAL, postActual);
    }

    public Boolean isPostBudget() {
        return (Boolean) get(PROPERTY_POSTBUDGET);
    }

    public void setPostBudget(Boolean postBudget) {
        set(PROPERTY_POSTBUDGET, postBudget);
    }

    public Boolean isPostEncumbrance() {
        return (Boolean) get(PROPERTY_POSTENCUMBRANCE);
    }

    public void setPostEncumbrance(Boolean postEncumbrance) {
        set(PROPERTY_POSTENCUMBRANCE, postEncumbrance);
    }

    public Boolean isPostStatistical() {
        return (Boolean) get(PROPERTY_POSTSTATISTICAL);
    }

    public void setPostStatistical(Boolean postStatistical) {
        set(PROPERTY_POSTSTATISTICAL, postStatistical);
    }

    public Boolean isBankAccount() {
        return (Boolean) get(PROPERTY_ISBANKACCOUNT);
    }

    public void setBankAccount(Boolean isBankAccount) {
        set(PROPERTY_ISBANKACCOUNT, isBankAccount);
    }

    public BankAccount getBankAccount() {
        return (BankAccount) get(PROPERTY_BANKACCOUNT);
    }

    public void setBankAccount(BankAccount bankAccount) {
        set(PROPERTY_BANKACCOUNT, bankAccount);
    }

    public Boolean isForeignCurrency() {
        return (Boolean) get(PROPERTY_ISFOREIGNCURRENCY);
    }

    public void setForeignCurrency(Boolean isForeignCurrency) {
        set(PROPERTY_ISFOREIGNCURRENCY, isForeignCurrency);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public Boolean isShowElement() {
        return (Boolean) get(PROPERTY_SHOWELEMENT);
    }

    public void setShowElement(Boolean showElement) {
        set(PROPERTY_SHOWELEMENT, showElement);
    }

    public String getShowValueCond() {
        return (String) get(PROPERTY_SHOWVALUECOND);
    }

    public void setShowValueCond(String showValueCond) {
        set(PROPERTY_SHOWVALUECOND, showValueCond);
    }

    public String getElementLevel() {
        return (String) get(PROPERTY_ELEMENTLEVEL);
    }

    public void setElementLevel(String elementLevel) {
        set(PROPERTY_ELEMENTLEVEL, elementLevel);
    }

    public Boolean isNomanualacct() {
        return (Boolean) get(PROPERTY_NOMANUALACCT);
    }

    public void setNomanualacct(Boolean nomanualacct) {
        set(PROPERTY_NOMANUALACCT, nomanualacct);
    }

    public Boolean isDatevuseauto() {
        return (Boolean) get(PROPERTY_DATEVUSEAUTO);
    }

    public void setDatevuseauto(Boolean datevuseauto) {
        set(PROPERTY_DATEVUSEAUTO, datevuseauto);
    }

    @SuppressWarnings("unchecked")
    public List<ElementValueTrl> getFinancialMgmtElementValueTrlList() {
        return (List<ElementValueTrl>) get(PROPERTY_FINANCIALMGMTELEMENTVALUETRLLIST);
    }

    public void setFinancialMgmtElementValueTrlList(
        List<ElementValueTrl> financialMgmtElementValueTrlList) {
        set(PROPERTY_FINANCIALMGMTELEMENTVALUETRLLIST,
            financialMgmtElementValueTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<ElementValueOperand> getFinancialMgmtElementValueOperandList() {
        return (List<ElementValueOperand>) get(PROPERTY_FINANCIALMGMTELEMENTVALUEOPERANDLIST);
    }

    public void setFinancialMgmtElementValueOperandList(
        List<ElementValueOperand> financialMgmtElementValueOperandList) {
        set(PROPERTY_FINANCIALMGMTELEMENTVALUEOPERANDLIST,
            financialMgmtElementValueOperandList);
    }
}
