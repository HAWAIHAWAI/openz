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
package org.openbravo.model.common.businesspartner;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Country;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity BusinessPartnerBankAccount (stored in table C_BP_BankAccount).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class BankAccount extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_BP_BankAccount";
    public static final String ENTITY_NAME = "BusinessPartnerBankAccount";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_BANKACCOUNTTYPE = "bankAccountType";
    public static final String PROPERTY_ROUTINGNO = "routingNo";
    public static final String PROPERTY_ACCOUNTNO = "accountNo";
    public static final String PROPERTY_CREDITCARDTYPE = "creditCardType";
    public static final String PROPERTY_CREDITCARDNUMBER = "creditCardNumber";
    public static final String PROPERTY_CREDITCARDEXPMM = "creditCardExpMM";
    public static final String PROPERTY_CREDITCARDEXPYY = "creditCardExpYY";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_STREET = "street";
    public static final String PROPERTY_CITY = "city";
    public static final String PROPERTY_STATE = "state";
    public static final String PROPERTY_ZIP = "zip";
    public static final String PROPERTY_IDENTDL = "identDL";
    public static final String PROPERTY_EMAIL = "eMail";
    public static final String PROPERTY_IDENTSSN = "identSSN";
    public static final String PROPERTY_AVSZIP = "avsZip";
    public static final String PROPERTY_COUNTRY = "country";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_BANKNAME = "bankName";
    public static final String PROPERTY_IBAN = "iban";
    public static final String PROPERTY_SHOWACCOUNTNO = "showAccountNo";
    public static final String PROPERTY_SHOWIBAN = "showiban";
    public static final String PROPERTY_DISPLAYEDACCOUNT = "displayedaccount";
    public static final String PROPERTY_COUNTRY32 = "country32";
    public static final String PROPERTY_SWIFTCODE = "swiftCode";
    public static final String PROPERTY_TEXT1 = "text1";

    public BankAccount() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_CREDITCARDEXPYY, (long) 2000);
        setDefaultValue(PROPERTY_SHOWACCOUNTNO, false);
        setDefaultValue(PROPERTY_SHOWIBAN, false);
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

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ISACTIVE);
    }

    public void setActive(Boolean isActive) {
        set(PROPERTY_ISACTIVE, isActive);
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

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public String getBankAccountType() {
        return (String) get(PROPERTY_BANKACCOUNTTYPE);
    }

    public void setBankAccountType(String bankAccountType) {
        set(PROPERTY_BANKACCOUNTTYPE, bankAccountType);
    }

    public String getRoutingNo() {
        return (String) get(PROPERTY_ROUTINGNO);
    }

    public void setRoutingNo(String routingNo) {
        set(PROPERTY_ROUTINGNO, routingNo);
    }

    public String getAccountNo() {
        return (String) get(PROPERTY_ACCOUNTNO);
    }

    public void setAccountNo(String accountNo) {
        set(PROPERTY_ACCOUNTNO, accountNo);
    }

    public String getCreditCardType() {
        return (String) get(PROPERTY_CREDITCARDTYPE);
    }

    public void setCreditCardType(String creditCardType) {
        set(PROPERTY_CREDITCARDTYPE, creditCardType);
    }

    public String getCreditCardNumber() {
        return (String) get(PROPERTY_CREDITCARDNUMBER);
    }

    public void setCreditCardNumber(String creditCardNumber) {
        set(PROPERTY_CREDITCARDNUMBER, creditCardNumber);
    }

    public Long getCreditCardExpMM() {
        return (Long) get(PROPERTY_CREDITCARDEXPMM);
    }

    public void setCreditCardExpMM(Long creditCardExpMM) {
        set(PROPERTY_CREDITCARDEXPMM, creditCardExpMM);
    }

    public Long getCreditCardExpYY() {
        return (Long) get(PROPERTY_CREDITCARDEXPYY);
    }

    public void setCreditCardExpYY(Long creditCardExpYY) {
        set(PROPERTY_CREDITCARDEXPYY, creditCardExpYY);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getStreet() {
        return (String) get(PROPERTY_STREET);
    }

    public void setStreet(String street) {
        set(PROPERTY_STREET, street);
    }

    public String getCity() {
        return (String) get(PROPERTY_CITY);
    }

    public void setCity(String city) {
        set(PROPERTY_CITY, city);
    }

    public String getState() {
        return (String) get(PROPERTY_STATE);
    }

    public void setState(String state) {
        set(PROPERTY_STATE, state);
    }

    public String getZip() {
        return (String) get(PROPERTY_ZIP);
    }

    public void setZip(String zip) {
        set(PROPERTY_ZIP, zip);
    }

    public String getIdentDL() {
        return (String) get(PROPERTY_IDENTDL);
    }

    public void setIdentDL(String identDL) {
        set(PROPERTY_IDENTDL, identDL);
    }

    public String getEMail() {
        return (String) get(PROPERTY_EMAIL);
    }

    public void setEMail(String eMail) {
        set(PROPERTY_EMAIL, eMail);
    }

    public String getIdentSSN() {
        return (String) get(PROPERTY_IDENTSSN);
    }

    public void setIdentSSN(String identSSN) {
        set(PROPERTY_IDENTSSN, identSSN);
    }

    public String getAvsZip() {
        return (String) get(PROPERTY_AVSZIP);
    }

    public void setAvsZip(String avsZip) {
        set(PROPERTY_AVSZIP, avsZip);
    }

    public String getCountry() {
        return (String) get(PROPERTY_COUNTRY);
    }

    public void setCountry(String country) {
        set(PROPERTY_COUNTRY, country);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public String getBankName() {
        return (String) get(PROPERTY_BANKNAME);
    }

    public void setBankName(String bankName) {
        set(PROPERTY_BANKNAME, bankName);
    }

    public String getIban() {
        return (String) get(PROPERTY_IBAN);
    }

    public void setIban(String iban) {
        set(PROPERTY_IBAN, iban);
    }

    public Boolean isShowAccountNo() {
        return (Boolean) get(PROPERTY_SHOWACCOUNTNO);
    }

    public void setShowAccountNo(Boolean showAccountNo) {
        set(PROPERTY_SHOWACCOUNTNO, showAccountNo);
    }

    public Boolean isShowiban() {
        return (Boolean) get(PROPERTY_SHOWIBAN);
    }

    public void setShowiban(Boolean showiban) {
        set(PROPERTY_SHOWIBAN, showiban);
    }

    public String getDisplayedaccount() {
        return (String) get(PROPERTY_DISPLAYEDACCOUNT);
    }

    public void setDisplayedaccount(String displayedaccount) {
        set(PROPERTY_DISPLAYEDACCOUNT, displayedaccount);
    }

    public Country getCountry32() {
        return (Country) get(PROPERTY_COUNTRY32);
    }

    public void setCountry32(Country country32) {
        set(PROPERTY_COUNTRY32, country32);
    }

    public String getSwiftCode() {
        return (String) get(PROPERTY_SWIFTCODE);
    }

    public void setSwiftCode(String swiftCode) {
        set(PROPERTY_SWIFTCODE, swiftCode);
    }

    public String getText1() {
        return (String) get(PROPERTY_TEXT1);
    }

    public void setText1(String text1) {
        set(PROPERTY_TEXT1, text1);
    }
}
