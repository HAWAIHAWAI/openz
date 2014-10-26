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
package org.openbravo.zsoft.finance;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.coa.ElementValue;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.project.ProjectTask;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity zsfi_macctline (stored in table zsfi_macctline).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Zsfi_macctline extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zsfi_macctline";
    public static final String ENTITY_NAME = "zsfi_macctline";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ZSFIMANUALACCT = "zsfiManualacct";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_AMT = "amt";
    public static final String PROPERTY_ISDR2CR = "isdr2cr";
    public static final String PROPERTY_ISGROSS = "isgross";
    public static final String PROPERTY_ACCTCR = "acctcr";
    public static final String PROPERTY_ACCTDR = "acctdr";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_CANCEL = "cancel";
    public static final String PROPERTY_GLSTATUS = "glstatus";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_PROJECTPHASE = "projectphase";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_ACCTDATE = "acctdate";

    public Zsfi_macctline() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_AMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISDR2CR, true);
        setDefaultValue(PROPERTY_ISGROSS, true);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_CANCEL, false);
        setDefaultValue(PROPERTY_GLSTATUS, "OP");
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

    public Zsfi_manualacct getZsfiManualacct() {
        return (Zsfi_manualacct) get(PROPERTY_ZSFIMANUALACCT);
    }

    public void setZsfiManualacct(Zsfi_manualacct zsfiManualacct) {
        set(PROPERTY_ZSFIMANUALACCT, zsfiManualacct);
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

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public BigDecimal getAmt() {
        return (BigDecimal) get(PROPERTY_AMT);
    }

    public void setAmt(BigDecimal amt) {
        set(PROPERTY_AMT, amt);
    }

    public Boolean isDr2cr() {
        return (Boolean) get(PROPERTY_ISDR2CR);
    }

    public void setDr2cr(Boolean isdr2cr) {
        set(PROPERTY_ISDR2CR, isdr2cr);
    }

    public Boolean isGross() {
        return (Boolean) get(PROPERTY_ISGROSS);
    }

    public void setGross(Boolean isgross) {
        set(PROPERTY_ISGROSS, isgross);
    }

    public ElementValue getAcctcr() {
        return (ElementValue) get(PROPERTY_ACCTCR);
    }

    public void setAcctcr(ElementValue acctcr) {
        set(PROPERTY_ACCTCR, acctcr);
    }

    public ElementValue getAcctdr() {
        return (ElementValue) get(PROPERTY_ACCTDR);
    }

    public void setAcctdr(ElementValue acctdr) {
        set(PROPERTY_ACCTDR, acctdr);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Boolean isCancel() {
        return (Boolean) get(PROPERTY_CANCEL);
    }

    public void setCancel(Boolean cancel) {
        set(PROPERTY_CANCEL, cancel);
    }

    public String getGlstatus() {
        return (String) get(PROPERTY_GLSTATUS);
    }

    public void setGlstatus(String glstatus) {
        set(PROPERTY_GLSTATUS, glstatus);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public ProjectPhase getProjectphase() {
        return (ProjectPhase) get(PROPERTY_PROJECTPHASE);
    }

    public void setProjectphase(ProjectPhase projectphase) {
        set(PROPERTY_PROJECTPHASE, projectphase);
    }

    public ProjectTask getProjecttask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjecttask(ProjectTask projecttask) {
        set(PROPERTY_PROJECTTASK, projecttask);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public Date getAcctdate() {
        return (Date) get(PROPERTY_ACCTDATE);
    }

    public void setAcctdate(Date acctdate) {
        set(PROPERTY_ACCTDATE, acctdate);
    }
}
