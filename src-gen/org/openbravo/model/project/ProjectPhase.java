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
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.plm.Product;
import org.openbravo.zsoft.projects.Zspm_projectphasedep;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ProjectPhase (stored in table C_ProjectPhase).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ProjectPhase extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_ProjectPhase";
    public static final String ENTITY_NAME = "ProjectPhase";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_STARTDATE = "startDate";
    public static final String PROPERTY_ENDDATE = "endDate";
    public static final String PROPERTY_ISCOMPLETE = "isComplete";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_PRICEACTUAL = "priceActual";
    public static final String PROPERTY_GENERATEORDER = "generateOrder";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_PHASE = "phase";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_HELP = "help";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_QTY = "qty";
    public static final String PROPERTY_SEQNO = "seqNo";
    public static final String PROPERTY_COMMITTEDAMT = "committedAmt";
    public static final String PROPERTY_ISCOMMITCEILING = "isCommitCeiling";
    public static final String PROPERTY_DATECONTRACT = "datecontract";
    public static final String PROPERTY_SCHEDULESTATUS = "schedulestatus";
    public static final String PROPERTY_ACTUALCOST = "actualcost";
    public static final String PROPERTY_PLANNEDCOST = "plannedcost";
    public static final String PROPERTY_PERCENTDONE = "percentdone";
    public static final String PROPERTY_OUTSOURCING = "outsourcing";
    public static final String PROPERTY_PHASEBEGUN = "phasebegun";
    public static final String PROPERTY_BEGINPHASE = "beginphase";
    public static final String PROPERTY_ENDPHASE = "endphase";
    public static final String PROPERTY_MATERIALCOST = "materialcost";
    public static final String PROPERTY_MACHINECOST = "machinecost";
    public static final String PROPERTY_INVOICEDAMT = "invoicedamt";
    public static final String PROPERTY_EXPENSES = "expenses";
    public static final String PROPERTY_SERVCOST = "servcost";
    public static final String PROPERTY_INDIRECTCOST = "indirectcost";
    public static final String PROPERTY_ZSPMPROJECTPHASEDEPLIST =
        "zspmProjectphasedepList";

    public ProjectPhase() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISCOMPLETE, false);
        setDefaultValue(PROPERTY_GENERATEORDER, false);
        setDefaultValue(PROPERTY_ISCOMMITCEILING, false);
        setDefaultValue(PROPERTY_OUTSOURCING, false);
        setDefaultValue(PROPERTY_PHASEBEGUN, false);
        setDefaultValue(PROPERTY_BEGINPHASE, false);
        setDefaultValue(PROPERTY_ENDPHASE, false);
        setDefaultValue(PROPERTY_ZSPMPROJECTPHASEDEPLIST,
            new ArrayList<Object>());
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Date getStartDate() {
        return (Date) get(PROPERTY_STARTDATE);
    }

    public void setStartDate(Date startDate) {
        set(PROPERTY_STARTDATE, startDate);
    }

    public Date getEndDate() {
        return (Date) get(PROPERTY_ENDDATE);
    }

    public void setEndDate(Date endDate) {
        set(PROPERTY_ENDDATE, endDate);
    }

    public Boolean isComplete() {
        return (Boolean) get(PROPERTY_ISCOMPLETE);
    }

    public void setComplete(Boolean isComplete) {
        set(PROPERTY_ISCOMPLETE, isComplete);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getPriceActual() {
        return (BigDecimal) get(PROPERTY_PRICEACTUAL);
    }

    public void setPriceActual(BigDecimal priceActual) {
        set(PROPERTY_PRICEACTUAL, priceActual);
    }

    public Boolean isGenerateOrder() {
        return (Boolean) get(PROPERTY_GENERATEORDER);
    }

    public void setGenerateOrder(Boolean generateOrder) {
        set(PROPERTY_GENERATEORDER, generateOrder);
    }

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

    public StandardPhase getPhase() {
        return (StandardPhase) get(PROPERTY_PHASE);
    }

    public void setPhase(StandardPhase phase) {
        set(PROPERTY_PHASE, phase);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public String getHelp() {
        return (String) get(PROPERTY_HELP);
    }

    public void setHelp(String help) {
        set(PROPERTY_HELP, help);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public BigDecimal getQty() {
        return (BigDecimal) get(PROPERTY_QTY);
    }

    public void setQty(BigDecimal qty) {
        set(PROPERTY_QTY, qty);
    }

    public Long getSeqNo() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqNo(Long seqNo) {
        set(PROPERTY_SEQNO, seqNo);
    }

    public BigDecimal getCommittedAmt() {
        return (BigDecimal) get(PROPERTY_COMMITTEDAMT);
    }

    public void setCommittedAmt(BigDecimal committedAmt) {
        set(PROPERTY_COMMITTEDAMT, committedAmt);
    }

    public Boolean isCommitCeiling() {
        return (Boolean) get(PROPERTY_ISCOMMITCEILING);
    }

    public void setCommitCeiling(Boolean isCommitCeiling) {
        set(PROPERTY_ISCOMMITCEILING, isCommitCeiling);
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

    public Boolean isPhasebegun() {
        return (Boolean) get(PROPERTY_PHASEBEGUN);
    }

    public void setPhasebegun(Boolean phasebegun) {
        set(PROPERTY_PHASEBEGUN, phasebegun);
    }

    public Boolean isBeginphase() {
        return (Boolean) get(PROPERTY_BEGINPHASE);
    }

    public void setBeginphase(Boolean beginphase) {
        set(PROPERTY_BEGINPHASE, beginphase);
    }

    public Boolean isEndphase() {
        return (Boolean) get(PROPERTY_ENDPHASE);
    }

    public void setEndphase(Boolean endphase) {
        set(PROPERTY_ENDPHASE, endphase);
    }

    public BigDecimal getMaterialcost() {
        return (BigDecimal) get(PROPERTY_MATERIALCOST);
    }

    public void setMaterialcost(BigDecimal materialcost) {
        set(PROPERTY_MATERIALCOST, materialcost);
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

    public BigDecimal getIndirectcost() {
        return (BigDecimal) get(PROPERTY_INDIRECTCOST);
    }

    public void setIndirectcost(BigDecimal indirectcost) {
        set(PROPERTY_INDIRECTCOST, indirectcost);
    }

    @SuppressWarnings("unchecked")
    public List<Zspm_projectphasedep> getZspmProjectphasedepList() {
        return (List<Zspm_projectphasedep>) get(PROPERTY_ZSPMPROJECTPHASEDEPLIST);
    }

    public void setZspmProjectphasedepList(
        List<Zspm_projectphasedep> zspmProjectphasedepList) {
        set(PROPERTY_ZSPMPROJECTPHASEDEPLIST, zspmProjectphasedepList);
    }
}
