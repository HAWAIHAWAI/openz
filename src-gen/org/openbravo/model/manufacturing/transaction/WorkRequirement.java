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
package org.openbravo.model.manufacturing.transaction;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.manufacturing.processplan.ProcessPlan;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ManufacturingWorkRequirement (stored in table MA_WorkRequirement).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class WorkRequirement extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "MA_WorkRequirement";
    public static final String ENTITY_NAME = "ManufacturingWorkRequirement";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PROCESSPLAN = "processplan";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_LAUNCHDATE = "launchdate";
    public static final String PROPERTY_STARTDATE = "startDate";
    public static final String PROPERTY_ENDDATE = "endDate";
    public static final String PROPERTY_CLOSED = "closed";
    public static final String PROPERTY_EXPLOTE = "explote";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_EXPLODEPHASES = "explodephases";
    public static final String PROPERTY_SECONDARYQTY = "secondaryqty";
    public static final String PROPERTY_SECONDARYUNIT = "secondaryunit";
    public static final String PROPERTY_CONVERSIONRATE = "conversionrate";
    public static final String PROPERTY_MANUFACTURINGWORKREQUIREMENTOPERATIONLIST =
        "manufacturingWorkRequirementOperationList";

    public WorkRequirement() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_CLOSED, false);
        setDefaultValue(PROPERTY_EXPLOTE, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_EXPLODEPHASES, true);
        setDefaultValue(PROPERTY_MANUFACTURINGWORKREQUIREMENTOPERATIONLIST,
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public ProcessPlan getProcessplan() {
        return (ProcessPlan) get(PROPERTY_PROCESSPLAN);
    }

    public void setProcessplan(ProcessPlan processplan) {
        set(PROPERTY_PROCESSPLAN, processplan);
    }

    public BigDecimal getQuantity() {
        return (BigDecimal) get(PROPERTY_QUANTITY);
    }

    public void setQuantity(BigDecimal quantity) {
        set(PROPERTY_QUANTITY, quantity);
    }

    public Date getLaunchdate() {
        return (Date) get(PROPERTY_LAUNCHDATE);
    }

    public void setLaunchdate(Date launchdate) {
        set(PROPERTY_LAUNCHDATE, launchdate);
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

    public Boolean isClosed() {
        return (Boolean) get(PROPERTY_CLOSED);
    }

    public void setClosed(Boolean closed) {
        set(PROPERTY_CLOSED, closed);
    }

    public Boolean isExplote() {
        return (Boolean) get(PROPERTY_EXPLOTE);
    }

    public void setExplote(Boolean explote) {
        set(PROPERTY_EXPLOTE, explote);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Boolean isExplodephases() {
        return (Boolean) get(PROPERTY_EXPLODEPHASES);
    }

    public void setExplodephases(Boolean explodephases) {
        set(PROPERTY_EXPLODEPHASES, explodephases);
    }

    public BigDecimal getSecondaryqty() {
        return (BigDecimal) get(PROPERTY_SECONDARYQTY);
    }

    public void setSecondaryqty(BigDecimal secondaryqty) {
        set(PROPERTY_SECONDARYQTY, secondaryqty);
    }

    public String getSecondaryunit() {
        return (String) get(PROPERTY_SECONDARYUNIT);
    }

    public void setSecondaryunit(String secondaryunit) {
        set(PROPERTY_SECONDARYUNIT, secondaryunit);
    }

    public BigDecimal getConversionrate() {
        return (BigDecimal) get(PROPERTY_CONVERSIONRATE);
    }

    public void setConversionrate(BigDecimal conversionrate) {
        set(PROPERTY_CONVERSIONRATE, conversionrate);
    }

    @SuppressWarnings("unchecked")
    public List<WorkRequirementOperation> getManufacturingWorkRequirementOperationList() {
        return (List<WorkRequirementOperation>) get(PROPERTY_MANUFACTURINGWORKREQUIREMENTOPERATIONLIST);
    }

    public void setManufacturingWorkRequirementOperationList(
        List<WorkRequirementOperation> manufacturingWorkRequirementOperationList) {
        set(PROPERTY_MANUFACTURINGWORKREQUIREMENTOPERATIONLIST,
            manufacturingWorkRequirementOperationList);
    }
}
