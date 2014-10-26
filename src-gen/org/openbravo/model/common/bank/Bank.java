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
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Country;
import org.openbravo.model.common.geography.Location;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity Bank (stored in table C_Bank).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Bank extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Bank";
    public static final String ENTITY_NAME = "Bank";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_ROUTINGNO = "routingNo";
    public static final String PROPERTY_LOCATION = "location";
    public static final String PROPERTY_SWIFTCODE = "swiftCode";
    public static final String PROPERTY_ISOWNBANK = "isOwnBank";
    public static final String PROPERTY_CODEBANK = "codebank";
    public static final String PROPERTY_CODEBRANCH = "codebranch";
    public static final String PROPERTY_DIGITCONTROL = "digitcontrol";
    public static final String PROPERTY_INENUMBER = "iNENumber";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_COUNTRY = "country";
    public static final String PROPERTY_BANKACCOUNTLIST = "bankAccountList";

    public Bank() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISOWNBANK, true);
        setDefaultValue(PROPERTY_BANKACCOUNTLIST, new ArrayList<Object>());
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

    public String getRoutingNo() {
        return (String) get(PROPERTY_ROUTINGNO);
    }

    public void setRoutingNo(String routingNo) {
        set(PROPERTY_ROUTINGNO, routingNo);
    }

    public Location getLocation() {
        return (Location) get(PROPERTY_LOCATION);
    }

    public void setLocation(Location location) {
        set(PROPERTY_LOCATION, location);
    }

    public String getSwiftCode() {
        return (String) get(PROPERTY_SWIFTCODE);
    }

    public void setSwiftCode(String swiftCode) {
        set(PROPERTY_SWIFTCODE, swiftCode);
    }

    public Boolean isOwnBank() {
        return (Boolean) get(PROPERTY_ISOWNBANK);
    }

    public void setOwnBank(Boolean isOwnBank) {
        set(PROPERTY_ISOWNBANK, isOwnBank);
    }

    public String getCodebank() {
        return (String) get(PROPERTY_CODEBANK);
    }

    public void setCodebank(String codebank) {
        set(PROPERTY_CODEBANK, codebank);
    }

    public String getCodebranch() {
        return (String) get(PROPERTY_CODEBRANCH);
    }

    public void setCodebranch(String codebranch) {
        set(PROPERTY_CODEBRANCH, codebranch);
    }

    public String getDigitcontrol() {
        return (String) get(PROPERTY_DIGITCONTROL);
    }

    public void setDigitcontrol(String digitcontrol) {
        set(PROPERTY_DIGITCONTROL, digitcontrol);
    }

    public String getINENumber() {
        return (String) get(PROPERTY_INENUMBER);
    }

    public void setINENumber(String iNENumber) {
        set(PROPERTY_INENUMBER, iNENumber);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public Country getCountry() {
        return (Country) get(PROPERTY_COUNTRY);
    }

    public void setCountry(Country country) {
        set(PROPERTY_COUNTRY, country);
    }

    @SuppressWarnings("unchecked")
    public List<BankAccount> getBankAccountList() {
        return (List<BankAccount>) get(PROPERTY_BANKACCOUNTLIST);
    }

    public void setBankAccountList(List<BankAccount> bankAccountList) {
        set(PROPERTY_BANKACCOUNTLIST, bankAccountList);
    }
}
