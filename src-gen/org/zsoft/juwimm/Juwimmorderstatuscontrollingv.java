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
package org.zsoft.juwimm;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.project.Project;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity juwimm_orderstatus_controlling_v (stored in table juwimm_orderstatus_controlling_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Juwimmorderstatuscontrollingv extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "juwimm_orderstatus_controlling_v";
    public static final String ENTITY_NAME = "juwimm_orderstatus_controlling_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISSOTRX = "isSOTrx";
    public static final String PROPERTY_DOCUMENTNO = "documentno";
    public static final String PROPERTY_DOCSTATUS = "docstatus";
    public static final String PROPERTY_DOCACTION = "docaction";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_SALESREP = "salesrep";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_ISCOMPLETELYINVOICED =
        "iscompletelyinvoiced";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_PROJECTVALUE = "projectValue";
    public static final String PROPERTY_PROJECTNAME = "projectName";
    public static final String PROPERTY_TOTALLINES = "totallines";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_JUWIMMCOMPLETION = "juwimmCompletion";
    public static final String PROPERTY_JUWIMMTIME = "juwimmTime";
    public static final String PROPERTY_JUWIMMRESOURCES = "juwimmResources";
    public static final String PROPERTY_JUWIMMBUDGET = "juwimmBudget";
    public static final String PROPERTY_JUWIMMTEAM = "juwimmTeam";
    public static final String PROPERTY_JUWIMMPLANNEDGOLIVE =
        "juwimmPlannedgolive";
    public static final String PROPERTY_JUWIMMESTGOLIVE = "juwimmEstgolive";
    public static final String PROPERTY_JUWIMMNEXTIMPDATE = "juwimmNextimpdate";
    public static final String PROPERTY_JUWIMMPLANNEDSTART =
        "juwimmPlannedstart";
    public static final String PROPERTY_JUWIMMESTSTART = "juwimmEststart";
    public static final String PROPERTY_JUWIMMPLANNEDEND = "juwimmPlannedend";
    public static final String PROPERTY_JUWIMMESTEND = "juwimmEstend";
    public static final String PROPERTY_JUWIMMOUPUTREMARKS =
        "juwimmOuputremarks";
    public static final String PROPERTY_JUWIMMLASTACTION = "juwimmLastaction";
    public static final String PROPERTY_JUWIMMNEXTACTION = "juwimmNextaction";
    public static final String PROPERTY_JUWIMMISSUES = "juwimmIssues";
    public static final String PROPERTY_JUWIMMDECISIONS = "juwimmDecisions";

    public Juwimmorderstatuscontrollingv() {
        setDefaultValue(PROPERTY_ISSOTRX, false);
        setDefaultValue(PROPERTY_ISCOMPLETELYINVOICED, false);
        setDefaultValue(PROPERTY_ISACTIVE, true);
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

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
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

    public Boolean isSOTrx() {
        return (Boolean) get(PROPERTY_ISSOTRX);
    }

    public void setSOTrx(Boolean isSOTrx) {
        set(PROPERTY_ISSOTRX, isSOTrx);
    }

    public String getDocumentno() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentno(String documentno) {
        set(PROPERTY_DOCUMENTNO, documentno);
    }

    public String getDocstatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocstatus(String docstatus) {
        set(PROPERTY_DOCSTATUS, docstatus);
    }

    public String getDocaction() {
        return (String) get(PROPERTY_DOCACTION);
    }

    public void setDocaction(String docaction) {
        set(PROPERTY_DOCACTION, docaction);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public User getSalesrep() {
        return (User) get(PROPERTY_SALESREP);
    }

    public void setSalesrep(User salesrep) {
        set(PROPERTY_SALESREP, salesrep);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public Boolean isCompletelyinvoiced() {
        return (Boolean) get(PROPERTY_ISCOMPLETELYINVOICED);
    }

    public void setCompletelyinvoiced(Boolean iscompletelyinvoiced) {
        set(PROPERTY_ISCOMPLETELYINVOICED, iscompletelyinvoiced);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public String getProjectValue() {
        return (String) get(PROPERTY_PROJECTVALUE);
    }

    public void setProjectValue(String projectValue) {
        set(PROPERTY_PROJECTVALUE, projectValue);
    }

    public String getProjectName() {
        return (String) get(PROPERTY_PROJECTNAME);
    }

    public void setProjectName(String projectName) {
        set(PROPERTY_PROJECTNAME, projectName);
    }

    public BigDecimal getTotallines() {
        return (BigDecimal) get(PROPERTY_TOTALLINES);
    }

    public void setTotallines(BigDecimal totallines) {
        set(PROPERTY_TOTALLINES, totallines);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
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

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ISACTIVE);
    }

    public void setActive(Boolean isactive) {
        set(PROPERTY_ISACTIVE, isactive);
    }

    public String getJuwimmCompletion() {
        return (String) get(PROPERTY_JUWIMMCOMPLETION);
    }

    public void setJuwimmCompletion(String juwimmCompletion) {
        set(PROPERTY_JUWIMMCOMPLETION, juwimmCompletion);
    }

    public String getJuwimmTime() {
        return (String) get(PROPERTY_JUWIMMTIME);
    }

    public void setJuwimmTime(String juwimmTime) {
        set(PROPERTY_JUWIMMTIME, juwimmTime);
    }

    public String getJuwimmResources() {
        return (String) get(PROPERTY_JUWIMMRESOURCES);
    }

    public void setJuwimmResources(String juwimmResources) {
        set(PROPERTY_JUWIMMRESOURCES, juwimmResources);
    }

    public String getJuwimmBudget() {
        return (String) get(PROPERTY_JUWIMMBUDGET);
    }

    public void setJuwimmBudget(String juwimmBudget) {
        set(PROPERTY_JUWIMMBUDGET, juwimmBudget);
    }

    public org.zsoft.juwimm.juwimm_team getJuwimmTeam() {
        return (org.zsoft.juwimm.juwimm_team) get(PROPERTY_JUWIMMTEAM);
    }

    public void setJuwimmTeam(org.zsoft.juwimm.juwimm_team juwimmTeam) {
        set(PROPERTY_JUWIMMTEAM, juwimmTeam);
    }

    public Date getJuwimmPlannedgolive() {
        return (Date) get(PROPERTY_JUWIMMPLANNEDGOLIVE);
    }

    public void setJuwimmPlannedgolive(Date juwimmPlannedgolive) {
        set(PROPERTY_JUWIMMPLANNEDGOLIVE, juwimmPlannedgolive);
    }

    public Date getJuwimmEstgolive() {
        return (Date) get(PROPERTY_JUWIMMESTGOLIVE);
    }

    public void setJuwimmEstgolive(Date juwimmEstgolive) {
        set(PROPERTY_JUWIMMESTGOLIVE, juwimmEstgolive);
    }

    public Date getJuwimmNextimpdate() {
        return (Date) get(PROPERTY_JUWIMMNEXTIMPDATE);
    }

    public void setJuwimmNextimpdate(Date juwimmNextimpdate) {
        set(PROPERTY_JUWIMMNEXTIMPDATE, juwimmNextimpdate);
    }

    public Date getJuwimmPlannedstart() {
        return (Date) get(PROPERTY_JUWIMMPLANNEDSTART);
    }

    public void setJuwimmPlannedstart(Date juwimmPlannedstart) {
        set(PROPERTY_JUWIMMPLANNEDSTART, juwimmPlannedstart);
    }

    public Date getJuwimmEststart() {
        return (Date) get(PROPERTY_JUWIMMESTSTART);
    }

    public void setJuwimmEststart(Date juwimmEststart) {
        set(PROPERTY_JUWIMMESTSTART, juwimmEststart);
    }

    public Date getJuwimmPlannedend() {
        return (Date) get(PROPERTY_JUWIMMPLANNEDEND);
    }

    public void setJuwimmPlannedend(Date juwimmPlannedend) {
        set(PROPERTY_JUWIMMPLANNEDEND, juwimmPlannedend);
    }

    public Date getJuwimmEstend() {
        return (Date) get(PROPERTY_JUWIMMESTEND);
    }

    public void setJuwimmEstend(Date juwimmEstend) {
        set(PROPERTY_JUWIMMESTEND, juwimmEstend);
    }

    public String getJuwimmOuputremarks() {
        return (String) get(PROPERTY_JUWIMMOUPUTREMARKS);
    }

    public void setJuwimmOuputremarks(String juwimmOuputremarks) {
        set(PROPERTY_JUWIMMOUPUTREMARKS, juwimmOuputremarks);
    }

    public String getJuwimmLastaction() {
        return (String) get(PROPERTY_JUWIMMLASTACTION);
    }

    public void setJuwimmLastaction(String juwimmLastaction) {
        set(PROPERTY_JUWIMMLASTACTION, juwimmLastaction);
    }

    public String getJuwimmNextaction() {
        return (String) get(PROPERTY_JUWIMMNEXTACTION);
    }

    public void setJuwimmNextaction(String juwimmNextaction) {
        set(PROPERTY_JUWIMMNEXTACTION, juwimmNextaction);
    }

    public String getJuwimmIssues() {
        return (String) get(PROPERTY_JUWIMMISSUES);
    }

    public void setJuwimmIssues(String juwimmIssues) {
        set(PROPERTY_JUWIMMISSUES, juwimmIssues);
    }

    public String getJuwimmDecisions() {
        return (String) get(PROPERTY_JUWIMMDECISIONS);
    }

    public void setJuwimmDecisions(String juwimmDecisions) {
        set(PROPERTY_JUWIMMDECISIONS, juwimmDecisions);
    }
}
