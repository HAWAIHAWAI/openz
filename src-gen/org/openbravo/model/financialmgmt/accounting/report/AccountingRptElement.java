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
package org.openbravo.model.financialmgmt.accounting.report;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;
import org.openbravo.model.financialmgmt.accounting.coa.ElementValue;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity FinancialMgmtAccountingRptElement (stored in table AD_AccountingRpt_Element).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class AccountingRptElement extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_AccountingRpt_Element";
    public static final String ENTITY_NAME =
        "FinancialMgmtAccountingRptElement";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ISSUMMARY = "isSummary";
    public static final String PROPERTY_ISSHOWN = "isshown";
    public static final String PROPERTY_FILTEREDBYORGANIZATION =
        "filteredbyorganization";
    public static final String PROPERTY_TEMPORARYFILTERTYPE =
        "temporaryFilterType";
    public static final String PROPERTY_ACCOUNT = "account";
    public static final String PROPERTY_ACCTSCHEMA = "acctSchema";
    public static final String PROPERTY_ISREPORT = "isReport";
    public static final String PROPERTY_REPORTTYPE = "reportType";
    public static final String PROPERTY_ISINITIALBALANCE = "isinitialbalance";

    public AccountingRptElement() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISSUMMARY, true);
        setDefaultValue(PROPERTY_ISSHOWN, true);
        setDefaultValue(PROPERTY_FILTEREDBYORGANIZATION, false);
        setDefaultValue(PROPERTY_ISREPORT, false);
        setDefaultValue(PROPERTY_REPORTTYPE, "dd");
        setDefaultValue(PROPERTY_ISINITIALBALANCE, false);
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

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ISACTIVE);
    }

    public void setActive(Boolean isActive) {
        set(PROPERTY_ISACTIVE, isActive);
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

    public Boolean isSummary() {
        return (Boolean) get(PROPERTY_ISSUMMARY);
    }

    public void setSummary(Boolean isSummary) {
        set(PROPERTY_ISSUMMARY, isSummary);
    }

    public Boolean isShown() {
        return (Boolean) get(PROPERTY_ISSHOWN);
    }

    public void setShown(Boolean isshown) {
        set(PROPERTY_ISSHOWN, isshown);
    }

    public Boolean isFilteredbyorganization() {
        return (Boolean) get(PROPERTY_FILTEREDBYORGANIZATION);
    }

    public void setFilteredbyorganization(Boolean filteredbyorganization) {
        set(PROPERTY_FILTEREDBYORGANIZATION, filteredbyorganization);
    }

    public String getTemporaryFilterType() {
        return (String) get(PROPERTY_TEMPORARYFILTERTYPE);
    }

    public void setTemporaryFilterType(String temporaryFilterType) {
        set(PROPERTY_TEMPORARYFILTERTYPE, temporaryFilterType);
    }

    public ElementValue getAccount() {
        return (ElementValue) get(PROPERTY_ACCOUNT);
    }

    public void setAccount(ElementValue account) {
        set(PROPERTY_ACCOUNT, account);
    }

    public AcctSchema getAcctSchema() {
        return (AcctSchema) get(PROPERTY_ACCTSCHEMA);
    }

    public void setAcctSchema(AcctSchema acctSchema) {
        set(PROPERTY_ACCTSCHEMA, acctSchema);
    }

    public Boolean isReport() {
        return (Boolean) get(PROPERTY_ISREPORT);
    }

    public void setReport(Boolean isReport) {
        set(PROPERTY_ISREPORT, isReport);
    }

    public String getReportType() {
        return (String) get(PROPERTY_REPORTTYPE);
    }

    public void setReportType(String reportType) {
        set(PROPERTY_REPORTTYPE, reportType);
    }

    public Boolean isInitialbalance() {
        return (Boolean) get(PROPERTY_ISINITIALBALANCE);
    }

    public void setInitialbalance(Boolean isinitialbalance) {
        set(PROPERTY_ISINITIALBALANCE, isinitialbalance);
    }
}
