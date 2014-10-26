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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.mrp.Mrpinoutplanv;
import org.openbravo.zsoft.projects.Zspm_projecttaskbom;
import org.openbravo.zsoft.projects.Zspm_projecttaskdep;
import org.openbravo.zsoft.projects.Zspm_ptaskfeedbackline;
import org.openbravo.zsoft.projects.Zspm_ptaskhrplan;
import org.openbravo.zsoft.projects.Zspm_ptaskindcostplan;
import org.openbravo.zsoft.projects.Zspm_ptaskmachineplan;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ProjectTask (stored in table C_ProjectTask).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ProjectTask extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_ProjectTask";
    public static final String ENTITY_NAME = "ProjectTask";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_TASK = "task";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SEQNO = "seqNo";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_HELP = "help";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_PROJECTPHASE = "projectphase";
    public static final String PROPERTY_QTY = "qty";
    public static final String PROPERTY_STARTDATE = "startDate";
    public static final String PROPERTY_ENDDATE = "enddate";
    public static final String PROPERTY_ISCOMPLETE = "iscomplete";
    public static final String PROPERTY_PRICEACTUAL = "priceActual";
    public static final String PROPERTY_COMMITTEDAMT = "committedamt";
    public static final String PROPERTY_ISCOMMITCEILING = "iscommitceiling";
    public static final String PROPERTY_DATECONTRACT = "datecontract";
    public static final String PROPERTY_SCHEDULESTATUS = "schedulestatus";
    public static final String PROPERTY_ACTUALCOST = "actualcost";
    public static final String PROPERTY_PLANNEDCOST = "plannedcost";
    public static final String PROPERTY_PERCENTDONE = "percentdone";
    public static final String PROPERTY_OUTSOURCING = "outsourcing";
    public static final String PROPERTY_TASKBEGUN = "taskbegun";
    public static final String PROPERTY_ISMATERIALDISPOSED =
        "ismaterialdisposed";
    public static final String PROPERTY_ISTASKCANCELLED = "istaskcancelled";
    public static final String PROPERTY_CREATEBOM = "createbom";
    public static final String PROPERTY_PLANMATERIAL = "planmaterial";
    public static final String PROPERTY_UNPLANMATERIAL = "unplanmaterial";
    public static final String PROPERTY_CANCELTASK = "canceltask";
    public static final String PROPERTY_BEGINTASK = "begintask";
    public static final String PROPERTY_ENDTASK = "endtask";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_MATERIALCOST = "materialcost";
    public static final String PROPERTY_INDIRECTCOST = "indirectcost";
    public static final String PROPERTY_MACHINECOST = "machinecost";
    public static final String PROPERTY_INVOICEDAMT = "invoicedamt";
    public static final String PROPERTY_EXPENSES = "expenses";
    public static final String PROPERTY_SERVCOST = "servcost";
    public static final String PROPERTY_MATERIALCOSTPLAN = "materialcostplan";
    public static final String PROPERTY_INDIRECTCOSTPLAN = "indirectcostplan";
    public static final String PROPERTY_MACHINECOSTPLAN = "machinecostplan";
    public static final String PROPERTY_SERVCOSTPLAN = "servcostplan";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_GETMATERIALFROMSTOCK =
        "getmaterialfromstock";
    public static final String PROPERTY_GOTOPURCHASING = "gotopurchasing";
    public static final String PROPERTY_RETURNMATERIALTOSTOCK =
        "returnmaterialtostock";
    public static final String PROPERTY_PREPLANMATERIAL = "preplanmaterial";
    public static final String PROPERTY_COLOR = "color";
    public static final String PROPERTY_EXPENSESPLAN = "expensesplan";
    public static final String PROPERTY_FEEDBACKFINISHED = "feedbackfinished";
    public static final String PROPERTY_COPYPTASK = "copyptask";
    public static final String PROPERTY_EXTERNALSERVICEPLAN =
        "externalserviceplan";
    public static final String PROPERTY_EXTERNALSERVICE = "externalservice";
    public static final String PROPERTY_ZSPMPROJECTTASKBOMVIEWLIST =
        "zspmProjecttaskbomViewList";
    public static final String PROPERTY_PROJECTTASKEXPENSEPLANLIST =
        "projecttaskexpenseplanList";
    public static final String PROPERTY_ZSPMMATERIALMOVEMENTSVIEWLIST =
        "zspmMaterialmovementsViewList";
    public static final String PROPERTY_ZSPMPTASKMACHINEPLANLIST =
        "zspmPtaskmachineplanList";
    public static final String PROPERTY_ZSPMPROJECTTASKBOMLIST =
        "zspmProjecttaskbomList";
    public static final String PROPERTY_ZSPMPTASKHRPLANLIST =
        "zspmPtaskhrplanList";
    public static final String PROPERTY_ZSPMPTASKFEEDBACKLINELIST =
        "zspmPtaskfeedbacklineList";
    public static final String PROPERTY_ZSSMPTASKTECHDOCLIST =
        "zssmPTaskTechDocList";
    public static final String PROPERTY_MRPINOUTPLANVLIST = "mrpInoutplanVList";
    public static final String PROPERTY_ZSPMPROJECTTASKDEPLIST =
        "zspmProjecttaskdepList";
    public static final String PROPERTY_ZSPMPTASKINDCOSTPLANLIST =
        "zspmPtaskindcostplanList";

    public ProjectTask() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISCOMPLETE, false);
        setDefaultValue(PROPERTY_ISCOMMITCEILING, false);
        setDefaultValue(PROPERTY_SCHEDULESTATUS, "OK");
        setDefaultValue(PROPERTY_OUTSOURCING, false);
        setDefaultValue(PROPERTY_TASKBEGUN, false);
        setDefaultValue(PROPERTY_ISMATERIALDISPOSED, false);
        setDefaultValue(PROPERTY_ISTASKCANCELLED, false);
        setDefaultValue(PROPERTY_CREATEBOM, false);
        setDefaultValue(PROPERTY_PLANMATERIAL, false);
        setDefaultValue(PROPERTY_UNPLANMATERIAL, false);
        setDefaultValue(PROPERTY_CANCELTASK, false);
        setDefaultValue(PROPERTY_BEGINTASK, false);
        setDefaultValue(PROPERTY_ENDTASK, false);
        setDefaultValue(PROPERTY_GETMATERIALFROMSTOCK, false);
        setDefaultValue(PROPERTY_GOTOPURCHASING, false);
        setDefaultValue(PROPERTY_RETURNMATERIALTOSTOCK, false);
        setDefaultValue(PROPERTY_PREPLANMATERIAL, false);
        setDefaultValue(PROPERTY_FEEDBACKFINISHED, false);
        setDefaultValue(PROPERTY_COPYPTASK, false);
        setDefaultValue(PROPERTY_EXTERNALSERVICEPLAN, new BigDecimal(0));
        setDefaultValue(PROPERTY_EXTERNALSERVICE, new BigDecimal(0));
        setDefaultValue(PROPERTY_ZSPMPROJECTTASKBOMVIEWLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTTASKEXPENSEPLANLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSPMMATERIALMOVEMENTSVIEWLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSPMPTASKMACHINEPLANLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSPMPROJECTTASKBOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSPMPTASKHRPLANLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSPMPTASKFEEDBACKLINELIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSSMPTASKTECHDOCLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MRPINOUTPLANVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSPMPROJECTTASKDEPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSPMPTASKINDCOSTPLANLIST,
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

    public StandardTask getTask() {
        return (StandardTask) get(PROPERTY_TASK);
    }

    public void setTask(StandardTask task) {
        set(PROPERTY_TASK, task);
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

    public Long getSeqNo() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqNo(Long seqNo) {
        set(PROPERTY_SEQNO, seqNo);
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

    public String getHelp() {
        return (String) get(PROPERTY_HELP);
    }

    public void setHelp(String help) {
        set(PROPERTY_HELP, help);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public ProjectPhase getProjectphase() {
        return (ProjectPhase) get(PROPERTY_PROJECTPHASE);
    }

    public void setProjectphase(ProjectPhase projectphase) {
        set(PROPERTY_PROJECTPHASE, projectphase);
    }

    public BigDecimal getQty() {
        return (BigDecimal) get(PROPERTY_QTY);
    }

    public void setQty(BigDecimal qty) {
        set(PROPERTY_QTY, qty);
    }

    public Date getStartDate() {
        return (Date) get(PROPERTY_STARTDATE);
    }

    public void setStartDate(Date startDate) {
        set(PROPERTY_STARTDATE, startDate);
    }

    public Date getEnddate() {
        return (Date) get(PROPERTY_ENDDATE);
    }

    public void setEnddate(Date enddate) {
        set(PROPERTY_ENDDATE, enddate);
    }

    public Boolean isComplete() {
        return (Boolean) get(PROPERTY_ISCOMPLETE);
    }

    public void setComplete(Boolean iscomplete) {
        set(PROPERTY_ISCOMPLETE, iscomplete);
    }

    public BigDecimal getPriceActual() {
        return (BigDecimal) get(PROPERTY_PRICEACTUAL);
    }

    public void setPriceActual(BigDecimal priceActual) {
        set(PROPERTY_PRICEACTUAL, priceActual);
    }

    public BigDecimal getCommittedamt() {
        return (BigDecimal) get(PROPERTY_COMMITTEDAMT);
    }

    public void setCommittedamt(BigDecimal committedamt) {
        set(PROPERTY_COMMITTEDAMT, committedamt);
    }

    public Boolean isCommitceiling() {
        return (Boolean) get(PROPERTY_ISCOMMITCEILING);
    }

    public void setCommitceiling(Boolean iscommitceiling) {
        set(PROPERTY_ISCOMMITCEILING, iscommitceiling);
    }

    public Date getDatecontract() {
        return (Date) get(PROPERTY_DATECONTRACT);
    }

    public void setDatecontract(Date datecontract) {
        set(PROPERTY_DATECONTRACT, datecontract);
    }

    public String getSchedulestatus() {
        return (String) get(PROPERTY_SCHEDULESTATUS);
    }

    public void setSchedulestatus(String schedulestatus) {
        set(PROPERTY_SCHEDULESTATUS, schedulestatus);
    }

    public BigDecimal getActualcost() {
        return (BigDecimal) get(PROPERTY_ACTUALCOST);
    }

    public void setActualcost(BigDecimal actualcost) {
        set(PROPERTY_ACTUALCOST, actualcost);
    }

    public BigDecimal getPlannedcost() {
        return (BigDecimal) get(PROPERTY_PLANNEDCOST);
    }

    public void setPlannedcost(BigDecimal plannedcost) {
        set(PROPERTY_PLANNEDCOST, plannedcost);
    }

    public Long getPercentdone() {
        return (Long) get(PROPERTY_PERCENTDONE);
    }

    public void setPercentdone(Long percentdone) {
        set(PROPERTY_PERCENTDONE, percentdone);
    }

    public Boolean isOutsourcing() {
        return (Boolean) get(PROPERTY_OUTSOURCING);
    }

    public void setOutsourcing(Boolean outsourcing) {
        set(PROPERTY_OUTSOURCING, outsourcing);
    }

    public Boolean isTaskbegun() {
        return (Boolean) get(PROPERTY_TASKBEGUN);
    }

    public void setTaskbegun(Boolean taskbegun) {
        set(PROPERTY_TASKBEGUN, taskbegun);
    }

    public Boolean isMaterialdisposed() {
        return (Boolean) get(PROPERTY_ISMATERIALDISPOSED);
    }

    public void setMaterialdisposed(Boolean ismaterialdisposed) {
        set(PROPERTY_ISMATERIALDISPOSED, ismaterialdisposed);
    }

    public Boolean isTaskcancelled() {
        return (Boolean) get(PROPERTY_ISTASKCANCELLED);
    }

    public void setTaskcancelled(Boolean istaskcancelled) {
        set(PROPERTY_ISTASKCANCELLED, istaskcancelled);
    }

    public Boolean isCreatebom() {
        return (Boolean) get(PROPERTY_CREATEBOM);
    }

    public void setCreatebom(Boolean createbom) {
        set(PROPERTY_CREATEBOM, createbom);
    }

    public Boolean isPlanmaterial() {
        return (Boolean) get(PROPERTY_PLANMATERIAL);
    }

    public void setPlanmaterial(Boolean planmaterial) {
        set(PROPERTY_PLANMATERIAL, planmaterial);
    }

    public Boolean isUnplanmaterial() {
        return (Boolean) get(PROPERTY_UNPLANMATERIAL);
    }

    public void setUnplanmaterial(Boolean unplanmaterial) {
        set(PROPERTY_UNPLANMATERIAL, unplanmaterial);
    }

    public Boolean isCanceltask() {
        return (Boolean) get(PROPERTY_CANCELTASK);
    }

    public void setCanceltask(Boolean canceltask) {
        set(PROPERTY_CANCELTASK, canceltask);
    }

    public Boolean isBegintask() {
        return (Boolean) get(PROPERTY_BEGINTASK);
    }

    public void setBegintask(Boolean begintask) {
        set(PROPERTY_BEGINTASK, begintask);
    }

    public Boolean isEndtask() {
        return (Boolean) get(PROPERTY_ENDTASK);
    }

    public void setEndtask(Boolean endtask) {
        set(PROPERTY_ENDTASK, endtask);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public BigDecimal getMaterialcost() {
        return (BigDecimal) get(PROPERTY_MATERIALCOST);
    }

    public void setMaterialcost(BigDecimal materialcost) {
        set(PROPERTY_MATERIALCOST, materialcost);
    }

    public BigDecimal getIndirectcost() {
        return (BigDecimal) get(PROPERTY_INDIRECTCOST);
    }

    public void setIndirectcost(BigDecimal indirectcost) {
        set(PROPERTY_INDIRECTCOST, indirectcost);
    }

    public BigDecimal getMachinecost() {
        return (BigDecimal) get(PROPERTY_MACHINECOST);
    }

    public void setMachinecost(BigDecimal machinecost) {
        set(PROPERTY_MACHINECOST, machinecost);
    }

    public BigDecimal getInvoicedamt() {
        return (BigDecimal) get(PROPERTY_INVOICEDAMT);
    }

    public void setInvoicedamt(BigDecimal invoicedamt) {
        set(PROPERTY_INVOICEDAMT, invoicedamt);
    }

    public BigDecimal getExpenses() {
        return (BigDecimal) get(PROPERTY_EXPENSES);
    }

    public void setExpenses(BigDecimal expenses) {
        set(PROPERTY_EXPENSES, expenses);
    }

    public BigDecimal getServcost() {
        return (BigDecimal) get(PROPERTY_SERVCOST);
    }

    public void setServcost(BigDecimal servcost) {
        set(PROPERTY_SERVCOST, servcost);
    }

    public BigDecimal getMaterialcostplan() {
        return (BigDecimal) get(PROPERTY_MATERIALCOSTPLAN);
    }

    public void setMaterialcostplan(BigDecimal materialcostplan) {
        set(PROPERTY_MATERIALCOSTPLAN, materialcostplan);
    }

    public BigDecimal getIndirectcostplan() {
        return (BigDecimal) get(PROPERTY_INDIRECTCOSTPLAN);
    }

    public void setIndirectcostplan(BigDecimal indirectcostplan) {
        set(PROPERTY_INDIRECTCOSTPLAN, indirectcostplan);
    }

    public BigDecimal getMachinecostplan() {
        return (BigDecimal) get(PROPERTY_MACHINECOSTPLAN);
    }

    public void setMachinecostplan(BigDecimal machinecostplan) {
        set(PROPERTY_MACHINECOSTPLAN, machinecostplan);
    }

    public BigDecimal getServcostplan() {
        return (BigDecimal) get(PROPERTY_SERVCOSTPLAN);
    }

    public void setServcostplan(BigDecimal servcostplan) {
        set(PROPERTY_SERVCOSTPLAN, servcostplan);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Boolean isGetmaterialfromstock() {
        return (Boolean) get(PROPERTY_GETMATERIALFROMSTOCK);
    }

    public void setGetmaterialfromstock(Boolean getmaterialfromstock) {
        set(PROPERTY_GETMATERIALFROMSTOCK, getmaterialfromstock);
    }

    public Boolean isGotopurchasing() {
        return (Boolean) get(PROPERTY_GOTOPURCHASING);
    }

    public void setGotopurchasing(Boolean gotopurchasing) {
        set(PROPERTY_GOTOPURCHASING, gotopurchasing);
    }

    public Boolean isReturnmaterialtostock() {
        return (Boolean) get(PROPERTY_RETURNMATERIALTOSTOCK);
    }

    public void setReturnmaterialtostock(Boolean returnmaterialtostock) {
        set(PROPERTY_RETURNMATERIALTOSTOCK, returnmaterialtostock);
    }

    public Boolean isPreplanmaterial() {
        return (Boolean) get(PROPERTY_PREPLANMATERIAL);
    }

    public void setPreplanmaterial(Boolean preplanmaterial) {
        set(PROPERTY_PREPLANMATERIAL, preplanmaterial);
    }

    public org.openbravo.model.common.enterprise.c_color getColor() {
        return (org.openbravo.model.common.enterprise.c_color) get(PROPERTY_COLOR);
    }

    public void setColor(org.openbravo.model.common.enterprise.c_color color) {
        set(PROPERTY_COLOR, color);
    }

    public BigDecimal getExpensesplan() {
        return (BigDecimal) get(PROPERTY_EXPENSESPLAN);
    }

    public void setExpensesplan(BigDecimal expensesplan) {
        set(PROPERTY_EXPENSESPLAN, expensesplan);
    }

    public Boolean isFeedbackfinished() {
        return (Boolean) get(PROPERTY_FEEDBACKFINISHED);
    }

    public void setFeedbackfinished(Boolean feedbackfinished) {
        set(PROPERTY_FEEDBACKFINISHED, feedbackfinished);
    }

    public Boolean isCopyptask() {
        return (Boolean) get(PROPERTY_COPYPTASK);
    }

    public void setCopyptask(Boolean copyptask) {
        set(PROPERTY_COPYPTASK, copyptask);
    }

    public BigDecimal getExternalserviceplan() {
        return (BigDecimal) get(PROPERTY_EXTERNALSERVICEPLAN);
    }

    public void setExternalserviceplan(BigDecimal externalserviceplan) {
        set(PROPERTY_EXTERNALSERVICEPLAN, externalserviceplan);
    }

    public BigDecimal getExternalservice() {
        return (BigDecimal) get(PROPERTY_EXTERNALSERVICE);
    }

    public void setExternalservice(BigDecimal externalservice) {
        set(PROPERTY_EXTERNALSERVICE, externalservice);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.zsoft.projects.zspm_projecttaskbom_view> getZspmProjecttaskbomViewList() {
        return (List<org.openbravo.zsoft.projects.zspm_projecttaskbom_view>) get(PROPERTY_ZSPMPROJECTTASKBOMVIEWLIST);
    }

    public void setZspmProjecttaskbomViewList(
        List<org.openbravo.zsoft.projects.zspm_projecttaskbom_view> zspmProjecttaskbomViewList) {
        set(PROPERTY_ZSPMPROJECTTASKBOMVIEWLIST, zspmProjecttaskbomViewList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.project.C_projecttaskexpenseplan> getProjecttaskexpenseplanList() {
        return (List<org.openbravo.model.project.C_projecttaskexpenseplan>) get(PROPERTY_PROJECTTASKEXPENSEPLANLIST);
    }

    public void setProjecttaskexpenseplanList(
        List<org.openbravo.model.project.C_projecttaskexpenseplan> projecttaskexpenseplanList) {
        set(PROPERTY_PROJECTTASKEXPENSEPLANLIST, projecttaskexpenseplanList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.zsoft.projects.zspm_materialmovements_view> getZspmMaterialmovementsViewList() {
        return (List<org.openbravo.zsoft.projects.zspm_materialmovements_view>) get(PROPERTY_ZSPMMATERIALMOVEMENTSVIEWLIST);
    }

    public void setZspmMaterialmovementsViewList(
        List<org.openbravo.zsoft.projects.zspm_materialmovements_view> zspmMaterialmovementsViewList) {
        set(PROPERTY_ZSPMMATERIALMOVEMENTSVIEWLIST,
            zspmMaterialmovementsViewList);
    }

    @SuppressWarnings("unchecked")
    public List<Zspm_ptaskmachineplan> getZspmPtaskmachineplanList() {
        return (List<Zspm_ptaskmachineplan>) get(PROPERTY_ZSPMPTASKMACHINEPLANLIST);
    }

    public void setZspmPtaskmachineplanList(
        List<Zspm_ptaskmachineplan> zspmPtaskmachineplanList) {
        set(PROPERTY_ZSPMPTASKMACHINEPLANLIST, zspmPtaskmachineplanList);
    }

    @SuppressWarnings("unchecked")
    public List<Zspm_projecttaskbom> getZspmProjecttaskbomList() {
        return (List<Zspm_projecttaskbom>) get(PROPERTY_ZSPMPROJECTTASKBOMLIST);
    }

    public void setZspmProjecttaskbomList(
        List<Zspm_projecttaskbom> zspmProjecttaskbomList) {
        set(PROPERTY_ZSPMPROJECTTASKBOMLIST, zspmProjecttaskbomList);
    }

    @SuppressWarnings("unchecked")
    public List<Zspm_ptaskhrplan> getZspmPtaskhrplanList() {
        return (List<Zspm_ptaskhrplan>) get(PROPERTY_ZSPMPTASKHRPLANLIST);
    }

    public void setZspmPtaskhrplanList(
        List<Zspm_ptaskhrplan> zspmPtaskhrplanList) {
        set(PROPERTY_ZSPMPTASKHRPLANLIST, zspmPtaskhrplanList);
    }

    @SuppressWarnings("unchecked")
    public List<Zspm_ptaskfeedbackline> getZspmPtaskfeedbacklineList() {
        return (List<Zspm_ptaskfeedbackline>) get(PROPERTY_ZSPMPTASKFEEDBACKLINELIST);
    }

    public void setZspmPtaskfeedbacklineList(
        List<Zspm_ptaskfeedbackline> zspmPtaskfeedbacklineList) {
        set(PROPERTY_ZSPMPTASKFEEDBACKLINELIST, zspmPtaskfeedbacklineList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.zsoft.serprod.zssm_ptasktechdoc> getZssmPTaskTechDocList() {
        return (List<org.openbravo.zsoft.serprod.zssm_ptasktechdoc>) get(PROPERTY_ZSSMPTASKTECHDOCLIST);
    }

    public void setZssmPTaskTechDocList(
        List<org.openbravo.zsoft.serprod.zssm_ptasktechdoc> zssmPTaskTechDocList) {
        set(PROPERTY_ZSSMPTASKTECHDOCLIST, zssmPTaskTechDocList);
    }

    @SuppressWarnings("unchecked")
    public List<Mrpinoutplanv> getMrpInoutplanVList() {
        return (List<Mrpinoutplanv>) get(PROPERTY_MRPINOUTPLANVLIST);
    }

    public void setMrpInoutplanVList(List<Mrpinoutplanv> mrpInoutplanVList) {
        set(PROPERTY_MRPINOUTPLANVLIST, mrpInoutplanVList);
    }

    @SuppressWarnings("unchecked")
    public List<Zspm_projecttaskdep> getZspmProjecttaskdepList() {
        return (List<Zspm_projecttaskdep>) get(PROPERTY_ZSPMPROJECTTASKDEPLIST);
    }

    public void setZspmProjecttaskdepList(
        List<Zspm_projecttaskdep> zspmProjecttaskdepList) {
        set(PROPERTY_ZSPMPROJECTTASKDEPLIST, zspmProjecttaskdepList);
    }

    @SuppressWarnings("unchecked")
    public List<Zspm_ptaskindcostplan> getZspmPtaskindcostplanList() {
        return (List<Zspm_ptaskindcostplan>) get(PROPERTY_ZSPMPTASKINDCOSTPLANLIST);
    }

    public void setZspmPtaskindcostplanList(
        List<Zspm_ptaskindcostplan> zspmPtaskindcostplanList) {
        set(PROPERTY_ZSPMPTASKINDCOSTPLANLIST, zspmPtaskindcostplanList);
    }
}
