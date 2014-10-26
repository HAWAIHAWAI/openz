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
package org.openbravo.model.common.hcm;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity SalaryCategoryCost (stored in table C_Salary_Category_Cost).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SalaryCategoryCost extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Salary_Category_Cost";
    public static final String ENTITY_NAME = "SalaryCategoryCost";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_SALARYCATEGORY = "salaryCategory";
    public static final String PROPERTY_DATEFROM = "dateFrom";
    public static final String PROPERTY_COST = "cost";
    public static final String PROPERTY_COSTUOM = "costuom";
    public static final String PROPERTY_SPECIAL1 = "special1";
    public static final String PROPERTY_SPECIAL2 = "special2";
    public static final String PROPERTY_TRIGGERAMT = "triggeramt";

    public SalaryCategoryCost() {
        setDefaultValue(PROPERTY_SPECIAL1, new BigDecimal(0));
        setDefaultValue(PROPERTY_SPECIAL2, new BigDecimal(0));
        setDefaultValue(PROPERTY_TRIGGERAMT, new BigDecimal(0));
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

    public SalaryCategory getSalaryCategory() {
        return (SalaryCategory) get(PROPERTY_SALARYCATEGORY);
    }

    public void setSalaryCategory(SalaryCategory salaryCategory) {
        set(PROPERTY_SALARYCATEGORY, salaryCategory);
    }

    public Date getDateFrom() {
        return (Date) get(PROPERTY_DATEFROM);
    }

    public void setDateFrom(Date dateFrom) {
        set(PROPERTY_DATEFROM, dateFrom);
    }

    public BigDecimal getCost() {
        return (BigDecimal) get(PROPERTY_COST);
    }

    public void setCost(BigDecimal cost) {
        set(PROPERTY_COST, cost);
    }

    public String getCostuom() {
        return (String) get(PROPERTY_COSTUOM);
    }

    public void setCostuom(String costuom) {
        set(PROPERTY_COSTUOM, costuom);
    }

    public BigDecimal getSpecial1() {
        return (BigDecimal) get(PROPERTY_SPECIAL1);
    }

    public void setSpecial1(BigDecimal special1) {
        set(PROPERTY_SPECIAL1, special1);
    }

    public BigDecimal getSpecial2() {
        return (BigDecimal) get(PROPERTY_SPECIAL2);
    }

    public void setSpecial2(BigDecimal special2) {
        set(PROPERTY_SPECIAL2, special2);
    }

    public BigDecimal getTriggeramt() {
        return (BigDecimal) get(PROPERTY_TRIGGERAMT);
    }

    public void setTriggeramt(BigDecimal triggeramt) {
        set(PROPERTY_TRIGGERAMT, triggeramt);
    }
}
