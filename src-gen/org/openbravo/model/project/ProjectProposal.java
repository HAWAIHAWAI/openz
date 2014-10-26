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
import org.openbravo.model.financialmgmt.payment.PaymentTerm;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ProjectProposal (stored in table C_ProjectProposal).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ProjectProposal extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_ProjectProposal";
    public static final String ENTITY_NAME = "ProjectProposal";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_DATESEND = "datesend";
    public static final String PROPERTY_BPARTNERLOCATION = "bPartnerLocation";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_COPYFROM = "copyFrom";
    public static final String PROPERTY_HEADERNOTE = "headerNote";
    public static final String PROPERTY_FOOTNOTE = "footNote";
    public static final String PROPERTY_ISSOTRX = "isSOTrx";
    public static final String PROPERTY_PAYMENTTERM = "paymentTerm";
    public static final String PROPERTY_PAYMENTRULE = "paymentRule";
    public static final String PROPERTY_PROJECTWON = "projectwon";
    public static final String PROPERTY_PROJECTPROJECTPROPOSALTASKLIST =
        "projectProjectProposalTaskList";
    public static final String PROPERTY_PROJECTPROPOSALLINELIST =
        "projectProposalLineList";

    public ProjectProposal() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_COPYFROM, false);
        setDefaultValue(PROPERTY_ISSOTRX, true);
        setDefaultValue(PROPERTY_PROJECTWON, false);
        setDefaultValue(PROPERTY_PROJECTPROJECTPROPOSALTASKLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTPROPOSALLINELIST,
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

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public Date getDatesend() {
        return (Date) get(PROPERTY_DATESEND);
    }

    public void setDatesend(Date datesend) {
        set(PROPERTY_DATESEND, datesend);
    }

    public Location getBPartnerLocation() {
        return (Location) get(PROPERTY_BPARTNERLOCATION);
    }

    public void setBPartnerLocation(Location bPartnerLocation) {
        set(PROPERTY_BPARTNERLOCATION, bPartnerLocation);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public Boolean isCopyFrom() {
        return (Boolean) get(PROPERTY_COPYFROM);
    }

    public void setCopyFrom(Boolean copyFrom) {
        set(PROPERTY_COPYFROM, copyFrom);
    }

    public String getHeaderNote() {
        return (String) get(PROPERTY_HEADERNOTE);
    }

    public void setHeaderNote(String headerNote) {
        set(PROPERTY_HEADERNOTE, headerNote);
    }

    public String getFootNote() {
        return (String) get(PROPERTY_FOOTNOTE);
    }

    public void setFootNote(String footNote) {
        set(PROPERTY_FOOTNOTE, footNote);
    }

    public Boolean isSOTrx() {
        return (Boolean) get(PROPERTY_ISSOTRX);
    }

    public void setSOTrx(Boolean isSOTrx) {
        set(PROPERTY_ISSOTRX, isSOTrx);
    }

    public PaymentTerm getPaymentTerm() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERM);
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        set(PROPERTY_PAYMENTTERM, paymentTerm);
    }

    public String getPaymentRule() {
        return (String) get(PROPERTY_PAYMENTRULE);
    }

    public void setPaymentRule(String paymentRule) {
        set(PROPERTY_PAYMENTRULE, paymentRule);
    }

    public Boolean isProjectwon() {
        return (Boolean) get(PROPERTY_PROJECTWON);
    }

    public void setProjectwon(Boolean projectwon) {
        set(PROPERTY_PROJECTWON, projectwon);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectProposalTask> getProjectProjectProposalTaskList() {
        return (List<ProjectProposalTask>) get(PROPERTY_PROJECTPROJECTPROPOSALTASKLIST);
    }

    public void setProjectProjectProposalTaskList(
        List<ProjectProposalTask> projectProjectProposalTaskList) {
        set(PROPERTY_PROJECTPROJECTPROPOSALTASKLIST,
            projectProjectProposalTaskList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectProposalLine> getProjectProposalLineList() {
        return (List<ProjectProposalLine>) get(PROPERTY_PROJECTPROPOSALLINELIST);
    }

    public void setProjectProposalLineList(
        List<ProjectProposalLine> projectProposalLineList) {
        set(PROPERTY_PROJECTPROPOSALLINELIST, projectProposalLineList);
    }
}
