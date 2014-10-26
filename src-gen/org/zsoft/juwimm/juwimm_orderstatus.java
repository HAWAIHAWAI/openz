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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.Order;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity juwimm_orderstatus (stored in table juwimm_orderstatus).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class juwimm_orderstatus extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "juwimm_orderstatus";
    public static final String ENTITY_NAME = "juwimm_orderstatus";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_JUWIMMPROJECTMAN = "juwimmProjectman";
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
    public static final String PROPERTY_JUWIMMMILESTONE1 = "juwimmMilestone1";
    public static final String PROPERTY_JUWIMMMS1PLANNEDDATE =
        "juwimmMs1planneddate";
    public static final String PROPERTY_JUWIMMMS1ESTDATE = "juwimmMs1estdate";
    public static final String PROPERTY_JUWIMMMILESTONE2 = "juwimmMilestone2";
    public static final String PROPERTY_JUWIMMMS2PLANNEDDATE =
        "juwimmMs2planneddate";
    public static final String PROPERTY_JUWIMMMS2ESTDATE = "juwimmMs2estdate";
    public static final String PROPERTY_JUWIMMMILESTONE3 = "juwimmMilestone3";
    public static final String PROPERTY_JUWIMMMS3PLANNEDDATE =
        "juwimmMs3planneddate";
    public static final String PROPERTY_JUWIMMMS3ESTDATE = "juwimmMs3estdate";
    public static final String PROPERTY_JUWIMMMILESTONE4 = "juwimmMilestone4";
    public static final String PROPERTY_JUWIMMMS4PLANNEDDATE =
        "juwimmMs4planneddate";
    public static final String PROPERTY_JUWIMMMS4ESTDATE = "juwimmMs4estdate";
    public static final String PROPERTY_JUWIMMMILESTONE5 = "juwimmMilestone5";
    public static final String PROPERTY_JUWIMMMS5PLANNEDDATE =
        "juwimmMs5planneddate";
    public static final String PROPERTY_JUWIMMMS5ESTDATE = "juwimmMs5estdate";
    public static final String PROPERTY_JUWIMMMILESTONE6 = "juwimmMilestone6";
    public static final String PROPERTY_JUWIMMMS6PLANNEDDATE =
        "juwimmMs6planneddate";
    public static final String PROPERTY_JUWIMMMS6ESTDATE = "juwimmMs6estdate";
    public static final String PROPERTY_JUWIMMMILESTONE7 = "juwimmMilestone7";
    public static final String PROPERTY_JUWIMMMS7PLANNEDDATE =
        "juwimmMs7planneddate";
    public static final String PROPERTY_JUWIMMMS7ESTDATE = "juwimmMs7estdate";
    public static final String PROPERTY_JUWIMMPLANNEDEND = "juwimmPlannedend";
    public static final String PROPERTY_JUWIMMESTEND = "juwimmEstend";
    public static final String PROPERTY_JUWIMMOUPUTREMARKS =
        "juwimmOuputremarks";
    public static final String PROPERTY_JUWIMMLASTACTION = "juwimmLastaction";
    public static final String PROPERTY_JUWIMMNEXTACTION = "juwimmNextaction";
    public static final String PROPERTY_JUWIMMISSUES = "juwimmIssues";
    public static final String PROPERTY_JUWIMMDECISIONS = "juwimmDecisions";
    public static final String PROPERTY_JUWIMMDESCRIPTION = "juwimmDescription";

    public juwimm_orderstatus() {
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

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

    public User getJuwimmProjectman() {
        return (User) get(PROPERTY_JUWIMMPROJECTMAN);
    }

    public void setJuwimmProjectman(User juwimmProjectman) {
        set(PROPERTY_JUWIMMPROJECTMAN, juwimmProjectman);
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

    public String getJuwimmMilestone1() {
        return (String) get(PROPERTY_JUWIMMMILESTONE1);
    }

    public void setJuwimmMilestone1(String juwimmMilestone1) {
        set(PROPERTY_JUWIMMMILESTONE1, juwimmMilestone1);
    }

    public Date getJuwimmMs1planneddate() {
        return (Date) get(PROPERTY_JUWIMMMS1PLANNEDDATE);
    }

    public void setJuwimmMs1planneddate(Date juwimmMs1planneddate) {
        set(PROPERTY_JUWIMMMS1PLANNEDDATE, juwimmMs1planneddate);
    }

    public Date getJuwimmMs1estdate() {
        return (Date) get(PROPERTY_JUWIMMMS1ESTDATE);
    }

    public void setJuwimmMs1estdate(Date juwimmMs1estdate) {
        set(PROPERTY_JUWIMMMS1ESTDATE, juwimmMs1estdate);
    }

    public String getJuwimmMilestone2() {
        return (String) get(PROPERTY_JUWIMMMILESTONE2);
    }

    public void setJuwimmMilestone2(String juwimmMilestone2) {
        set(PROPERTY_JUWIMMMILESTONE2, juwimmMilestone2);
    }

    public Date getJuwimmMs2planneddate() {
        return (Date) get(PROPERTY_JUWIMMMS2PLANNEDDATE);
    }

    public void setJuwimmMs2planneddate(Date juwimmMs2planneddate) {
        set(PROPERTY_JUWIMMMS2PLANNEDDATE, juwimmMs2planneddate);
    }

    public Date getJuwimmMs2estdate() {
        return (Date) get(PROPERTY_JUWIMMMS2ESTDATE);
    }

    public void setJuwimmMs2estdate(Date juwimmMs2estdate) {
        set(PROPERTY_JUWIMMMS2ESTDATE, juwimmMs2estdate);
    }

    public String getJuwimmMilestone3() {
        return (String) get(PROPERTY_JUWIMMMILESTONE3);
    }

    public void setJuwimmMilestone3(String juwimmMilestone3) {
        set(PROPERTY_JUWIMMMILESTONE3, juwimmMilestone3);
    }

    public Date getJuwimmMs3planneddate() {
        return (Date) get(PROPERTY_JUWIMMMS3PLANNEDDATE);
    }

    public void setJuwimmMs3planneddate(Date juwimmMs3planneddate) {
        set(PROPERTY_JUWIMMMS3PLANNEDDATE, juwimmMs3planneddate);
    }

    public Date getJuwimmMs3estdate() {
        return (Date) get(PROPERTY_JUWIMMMS3ESTDATE);
    }

    public void setJuwimmMs3estdate(Date juwimmMs3estdate) {
        set(PROPERTY_JUWIMMMS3ESTDATE, juwimmMs3estdate);
    }

    public String getJuwimmMilestone4() {
        return (String) get(PROPERTY_JUWIMMMILESTONE4);
    }

    public void setJuwimmMilestone4(String juwimmMilestone4) {
        set(PROPERTY_JUWIMMMILESTONE4, juwimmMilestone4);
    }

    public Date getJuwimmMs4planneddate() {
        return (Date) get(PROPERTY_JUWIMMMS4PLANNEDDATE);
    }

    public void setJuwimmMs4planneddate(Date juwimmMs4planneddate) {
        set(PROPERTY_JUWIMMMS4PLANNEDDATE, juwimmMs4planneddate);
    }

    public Date getJuwimmMs4estdate() {
        return (Date) get(PROPERTY_JUWIMMMS4ESTDATE);
    }

    public void setJuwimmMs4estdate(Date juwimmMs4estdate) {
        set(PROPERTY_JUWIMMMS4ESTDATE, juwimmMs4estdate);
    }

    public String getJuwimmMilestone5() {
        return (String) get(PROPERTY_JUWIMMMILESTONE5);
    }

    public void setJuwimmMilestone5(String juwimmMilestone5) {
        set(PROPERTY_JUWIMMMILESTONE5, juwimmMilestone5);
    }

    public Date getJuwimmMs5planneddate() {
        return (Date) get(PROPERTY_JUWIMMMS5PLANNEDDATE);
    }

    public void setJuwimmMs5planneddate(Date juwimmMs5planneddate) {
        set(PROPERTY_JUWIMMMS5PLANNEDDATE, juwimmMs5planneddate);
    }

    public Date getJuwimmMs5estdate() {
        return (Date) get(PROPERTY_JUWIMMMS5ESTDATE);
    }

    public void setJuwimmMs5estdate(Date juwimmMs5estdate) {
        set(PROPERTY_JUWIMMMS5ESTDATE, juwimmMs5estdate);
    }

    public String getJuwimmMilestone6() {
        return (String) get(PROPERTY_JUWIMMMILESTONE6);
    }

    public void setJuwimmMilestone6(String juwimmMilestone6) {
        set(PROPERTY_JUWIMMMILESTONE6, juwimmMilestone6);
    }

    public Date getJuwimmMs6planneddate() {
        return (Date) get(PROPERTY_JUWIMMMS6PLANNEDDATE);
    }

    public void setJuwimmMs6planneddate(Date juwimmMs6planneddate) {
        set(PROPERTY_JUWIMMMS6PLANNEDDATE, juwimmMs6planneddate);
    }

    public Date getJuwimmMs6estdate() {
        return (Date) get(PROPERTY_JUWIMMMS6ESTDATE);
    }

    public void setJuwimmMs6estdate(Date juwimmMs6estdate) {
        set(PROPERTY_JUWIMMMS6ESTDATE, juwimmMs6estdate);
    }

    public String getJuwimmMilestone7() {
        return (String) get(PROPERTY_JUWIMMMILESTONE7);
    }

    public void setJuwimmMilestone7(String juwimmMilestone7) {
        set(PROPERTY_JUWIMMMILESTONE7, juwimmMilestone7);
    }

    public Date getJuwimmMs7planneddate() {
        return (Date) get(PROPERTY_JUWIMMMS7PLANNEDDATE);
    }

    public void setJuwimmMs7planneddate(Date juwimmMs7planneddate) {
        set(PROPERTY_JUWIMMMS7PLANNEDDATE, juwimmMs7planneddate);
    }

    public Date getJuwimmMs7estdate() {
        return (Date) get(PROPERTY_JUWIMMMS7ESTDATE);
    }

    public void setJuwimmMs7estdate(Date juwimmMs7estdate) {
        set(PROPERTY_JUWIMMMS7ESTDATE, juwimmMs7estdate);
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

    public String getJuwimmDescription() {
        return (String) get(PROPERTY_JUWIMMDESCRIPTION);
    }

    public void setJuwimmDescription(String juwimmDescription) {
        set(PROPERTY_JUWIMMDESCRIPTION, juwimmDescription);
    }
}
