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
package org.openbravo.model.ad.system;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ADClient (stored in table AD_Client).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Client extends BaseOBObject {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Client";
    public static final String ENTITY_NAME = "ADClient";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SMTPHOST = "sMTPHost";
    public static final String PROPERTY_REQUESTEMAIL = "requestEMail";
    public static final String PROPERTY_REQUESTUSER = "requestUser";
    public static final String PROPERTY_REQUESTUSERPW = "requestuserpw";
    public static final String PROPERTY_REQUESTFOLDER = "requestFolder";
    public static final String PROPERTY_LANGUAGE = "language";
    public static final String PROPERTY_ISMULTILINGUALDOCUMENT =
        "isMultiLingualDocument";
    public static final String PROPERTY_ISSMTPAUTHORIZATION =
        "isSmtpAuthorization";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_CLIENTINFORMATIONLIST =
        "clientInformationList";

    public Client() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISMULTILINGUALDOCUMENT, false);
        setDefaultValue(PROPERTY_ISSMTPAUTHORIZATION, false);
        setDefaultValue(PROPERTY_CLIENTINFORMATIONLIST, new ArrayList<Object>());
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

    public String getSMTPHost() {
        return (String) get(PROPERTY_SMTPHOST);
    }

    public void setSMTPHost(String sMTPHost) {
        set(PROPERTY_SMTPHOST, sMTPHost);
    }

    public String getRequestEMail() {
        return (String) get(PROPERTY_REQUESTEMAIL);
    }

    public void setRequestEMail(String requestEMail) {
        set(PROPERTY_REQUESTEMAIL, requestEMail);
    }

    public String getRequestUser() {
        return (String) get(PROPERTY_REQUESTUSER);
    }

    public void setRequestUser(String requestUser) {
        set(PROPERTY_REQUESTUSER, requestUser);
    }

    public String getRequestuserpw() {
        return (String) get(PROPERTY_REQUESTUSERPW);
    }

    public void setRequestuserpw(String requestuserpw) {
        set(PROPERTY_REQUESTUSERPW, requestuserpw);
    }

    public String getRequestFolder() {
        return (String) get(PROPERTY_REQUESTFOLDER);
    }

    public void setRequestFolder(String requestFolder) {
        set(PROPERTY_REQUESTFOLDER, requestFolder);
    }

    public Language getLanguage() {
        return (Language) get(PROPERTY_LANGUAGE);
    }

    public void setLanguage(Language language) {
        set(PROPERTY_LANGUAGE, language);
    }

    public Boolean isMultiLingualDocument() {
        return (Boolean) get(PROPERTY_ISMULTILINGUALDOCUMENT);
    }

    public void setMultiLingualDocument(Boolean isMultiLingualDocument) {
        set(PROPERTY_ISMULTILINGUALDOCUMENT, isMultiLingualDocument);
    }

    public Boolean isSmtpAuthorization() {
        return (Boolean) get(PROPERTY_ISSMTPAUTHORIZATION);
    }

    public void setSmtpAuthorization(Boolean isSmtpAuthorization) {
        set(PROPERTY_ISSMTPAUTHORIZATION, isSmtpAuthorization);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    @SuppressWarnings("unchecked")
    public List<ClientInformation> getClientInformationList() {
        return (List<ClientInformation>) get(PROPERTY_CLIENTINFORMATIONLIST);
    }

    public void setClientInformationList(
        List<ClientInformation> clientInformationList) {
        set(PROPERTY_CLIENTINFORMATIONLIST, clientInformationList);
    }
}
