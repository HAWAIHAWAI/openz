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
package org.openbravo.model.common.interaction;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity EmailInteraction (stored in table C_POC_EMAIL).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class EmailInteraction extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_POC_EMAIL";
    public static final String ENTITY_NAME = "EmailInteraction";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ADDRESSFROM = "addressFrom";
    public static final String PROPERTY_ADDRESSTO = "addressTo";
    public static final String PROPERTY_ADDRESSCC = "addressCc";
    public static final String PROPERTY_ADDRESSBCC = "addressBcc";
    public static final String PROPERTY_DATEOFEMAIL = "dateofemail";
    public static final String PROPERTY_SUBJECT = "subject";
    public static final String PROPERTY_BODY = "body";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_EMAILTYPE = "emailType";
    public static final String PROPERTY_CONTACTEMAILINTERACTIONLIST =
        "contactEmailInteractionList";

    public EmailInteraction() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_CONTACTEMAILINTERACTIONLIST,
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

    public String getAddressFrom() {
        return (String) get(PROPERTY_ADDRESSFROM);
    }

    public void setAddressFrom(String addressFrom) {
        set(PROPERTY_ADDRESSFROM, addressFrom);
    }

    public String getAddressTo() {
        return (String) get(PROPERTY_ADDRESSTO);
    }

    public void setAddressTo(String addressTo) {
        set(PROPERTY_ADDRESSTO, addressTo);
    }

    public String getAddressCc() {
        return (String) get(PROPERTY_ADDRESSCC);
    }

    public void setAddressCc(String addressCc) {
        set(PROPERTY_ADDRESSCC, addressCc);
    }

    public String getAddressBcc() {
        return (String) get(PROPERTY_ADDRESSBCC);
    }

    public void setAddressBcc(String addressBcc) {
        set(PROPERTY_ADDRESSBCC, addressBcc);
    }

    public Date getDateofemail() {
        return (Date) get(PROPERTY_DATEOFEMAIL);
    }

    public void setDateofemail(Date dateofemail) {
        set(PROPERTY_DATEOFEMAIL, dateofemail);
    }

    public String getSubject() {
        return (String) get(PROPERTY_SUBJECT);
    }

    public void setSubject(String subject) {
        set(PROPERTY_SUBJECT, subject);
    }

    public String getBody() {
        return (String) get(PROPERTY_BODY);
    }

    public void setBody(String body) {
        set(PROPERTY_BODY, body);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public String getEmailType() {
        return (String) get(PROPERTY_EMAILTYPE);
    }

    public void setEmailType(String emailType) {
        set(PROPERTY_EMAILTYPE, emailType);
    }

    @SuppressWarnings("unchecked")
    public List<ContactEmailInteraction> getContactEmailInteractionList() {
        return (List<ContactEmailInteraction>) get(PROPERTY_CONTACTEMAILINTERACTIONLIST);
    }

    public void setContactEmailInteractionList(
        List<ContactEmailInteraction> contactEmailInteractionList) {
        set(PROPERTY_CONTACTEMAILINTERACTIONLIST, contactEmailInteractionList);
    }
}
