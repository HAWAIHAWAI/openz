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
package org.openbravo.model.common.bank;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity BankAccount (stored in table C_BankAccount).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class BankAccount extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_BankAccount";
    public static final String ENTITY_NAME = "BankAccount";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BANK = "bank";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_BANKACCOUNTTYPE = "bankAccountType";
    public static final String PROPERTY_ACCOUNTNO = "accountNo";
    public static final String PROPERTY_CURRENTBALANCE = "currentBalance";
    public static final String PROPERTY_CREDITLIMIT = "creditLimit";
    public static final String PROPERTY_ISDEFAULT = "isDefault";
    public static final String PROPERTY_CODEACCOUNT = "codeaccount";
    public static final String PROPERTY_DIGITCONTROL = "digitcontrol";
    public static final String PROPERTY_IBAN = "iban";
    public static final String PROPERTY_GENERICACCOUNT = "genericAccount";
    public static final String PROPERTY_SHOWGENERIC = "showGeneric";
    public static final String PROPERTY_SHOWSPANISH = "showSpanish";
    public static final String PROPERTY_SHOWIBAN = "showIBAN";
    public static final String PROPERTY_DISPLAYEDACCOUNT = "displayedAccount";
    public static final String PROPERTY_BANKACCOUNTACCOUNTSLIST =
        "bankAccountAccountsList";

    public BankAccount() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISDEFAULT, false);
        setDefaultValue(PROPERTY_SHOWGENERIC, false);
        setDefaultValue(PROPERTY_SHOWSPANISH, false);
        setDefaultValue(PROPERTY_SHOWIBAN, false);
        setDefaultValue(PROPERTY_BANKACCOUNTACCOUNTSLIST,
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

    public Bank getBank() {
        return (Bank) get(PROPERTY_BANK);
    }

    public void setBank(Bank bank) {
        set(PROPERTY_BANK, bank);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public String getBankAccountType() {
        return (String) get(PROPERTY_BANKACCOUNTTYPE);
    }

    public void setBankAccountType(String bankAccountType) {
        set(PROPERTY_BANKACCOUNTTYPE, bankAccountType);
    }

    public String getAccountNo() {
        return (String) get(PROPERTY_ACCOUNTNO);
    }

    public void setAccountNo(String accountNo) {
        set(PROPERTY_ACCOUNTNO, accountNo);
    }

    public BigDecimal getCurrentBalance() {
        return (BigDecimal) get(PROPERTY_CURRENTBALANCE);
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        set(PROPERTY_CURRENTBALANCE, currentBalance);
    }

    public BigDecimal getCreditLimit() {
        return (BigDecimal) get(PROPERTY_CREDITLIMIT);
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        set(PROPERTY_CREDITLIMIT, creditLimit);
    }

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_ISDEFAULT);
    }

    public void setDefault(Boolean isDefault) {
        set(PROPERTY_ISDEFAULT, isDefault);
    }

    public String getCodeaccount() {
        return (String) get(PROPERTY_CODEACCOUNT);
    }

    public void setCodeaccount(String codeaccount) {
        set(PROPERTY_CODEACCOUNT, codeaccount);
    }

    public String getDigitcontrol() {
        return (String) get(PROPERTY_DIGITCONTROL);
    }

    public void setDigitcontrol(String digitcontrol) {
        set(PROPERTY_DIGITCONTROL, digitcontrol);
    }

    public String getIban() {
        return (String) get(PROPERTY_IBAN);
    }

    public void setIban(String iban) {
        set(PROPERTY_IBAN, iban);
    }

    public String getGenericAccount() {
        return (String) get(PROPERTY_GENERICACCOUNT);
    }

    public void setGenericAccount(String genericAccount) {
        set(PROPERTY_GENERICACCOUNT, genericAccount);
    }

    public Boolean isShowGeneric() {
        return (Boolean) get(PROPERTY_SHOWGENERIC);
    }

    public void setShowGeneric(Boolean showGeneric) {
        set(PROPERTY_SHOWGENERIC, showGeneric);
    }

    public Boolean isShowSpanish() {
        return (Boolean) get(PROPERTY_SHOWSPANISH);
    }

    public void setShowSpanish(Boolean showSpanish) {
        set(PROPERTY_SHOWSPANISH, showSpanish);
    }

    public Boolean isShowIBAN() {
        return (Boolean) get(PROPERTY_SHOWIBAN);
    }

    public void setShowIBAN(Boolean showIBAN) {
        set(PROPERTY_SHOWIBAN, showIBAN);
    }

    public String getDisplayedAccount() {
        return (String) get(PROPERTY_DISPLAYEDACCOUNT);
    }

    public void setDisplayedAccount(String displayedAccount) {
        set(PROPERTY_DISPLAYEDACCOUNT, displayedAccount);
    }

    @SuppressWarnings("unchecked")
    public List<BankAccountAccounts> getBankAccountAccountsList() {
        return (List<BankAccountAccounts>) get(PROPERTY_BANKACCOUNTACCOUNTSLIST);
    }

    public void setBankAccountAccountsList(
        List<BankAccountAccounts> bankAccountAccountsList) {
        set(PROPERTY_BANKACCOUNTACCOUNTSLIST, bankAccountAccountsList);
    }
}
