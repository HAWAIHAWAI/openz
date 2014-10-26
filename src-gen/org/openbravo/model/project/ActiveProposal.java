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
package org.openbravo.model.project;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity ActiveProposalV (stored in table C_Projectproposal_V).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ActiveProposal extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Projectproposal_V";
    public static final String ENTITY_NAME = "ActiveProposalV";
    public static final String PROPERTY_FROMDATESEND = "fromdatesend";
    public static final String PROPERTY_TODATESEND = "todatesend";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_BPARTNERLOCATION = "bPartnerLocation";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ISSOTRX = "isSOTrx";
    public static final String PROPERTY_FIRSTNAME = "firstname";
    public static final String PROPERTY_LASTNAME = "lastname";
    public static final String PROPERTY_DATESEND = "datesend";

    public ActiveProposal() {
        setDefaultValue(PROPERTY_ISSOTRX, false);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public Date getFromdatesend() {
        return (Date) get(PROPERTY_FROMDATESEND);
    }

    public void setFromdatesend(Date fromdatesend) {
        set(PROPERTY_FROMDATESEND, fromdatesend);
    }

    public Date getTodatesend() {
        return (Date) get(PROPERTY_TODATESEND);
    }

    public void setTodatesend(Date todatesend) {
        set(PROPERTY_TODATESEND, todatesend);
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

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public Location getBPartnerLocation() {
        return (Location) get(PROPERTY_BPARTNERLOCATION);
    }

    public void setBPartnerLocation(Location bPartnerLocation) {
        set(PROPERTY_BPARTNERLOCATION, bPartnerLocation);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Boolean isSOTrx() {
        return (Boolean) get(PROPERTY_ISSOTRX);
    }

    public void setSOTrx(Boolean isSOTrx) {
        set(PROPERTY_ISSOTRX, isSOTrx);
    }

    public String getFirstname() {
        return (String) get(PROPERTY_FIRSTNAME);
    }

    public void setFirstname(String firstname) {
        set(PROPERTY_FIRSTNAME, firstname);
    }

    public String getLastname() {
        return (String) get(PROPERTY_LASTNAME);
    }

    public void setLastname(String lastname) {
        set(PROPERTY_LASTNAME, lastname);
    }

    public Date getDatesend() {
        return (Date) get(PROPERTY_DATESEND);
    }

    public void setDatesend(Date datesend) {
        set(PROPERTY_DATESEND, datesend);
    }
}
