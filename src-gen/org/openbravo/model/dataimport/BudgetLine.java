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
package org.openbravo.model.dataimport;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Category;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCategory;
import org.openbravo.model.financialmgmt.accounting.Budget;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;
import org.openbravo.model.financialmgmt.accounting.coa.ElementValue;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.project.Project;
import org.openbravo.model.sales.SalesRegion;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity DataImportBudgetLine (stored in table I_Budgetline).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class BudgetLine extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "I_Budgetline";
    public static final String ENTITY_NAME = "DataImportBudgetLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BUDGETLINE = "budgetline";
    public static final String PROPERTY_ELEMENTVALUE = "elementvalue";
    public static final String PROPERTY_ELEMENTVALUEIDENT = "elementvalueident";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_PERIODIDENT = "periodident";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_PRODUCTIDENT = "productident";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_PARTNERIDENT = "partnerident";
    public static final String PROPERTY_ORGTRX = "orgTrx";
    public static final String PROPERTY_ORGTRXIDENT = "orgtrxident";
    public static final String PROPERTY_SALESREGION = "salesRegion";
    public static final String PROPERTY_SALESREGIONIDENT = "salesregionident";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_PROJECTIDENT = "projectident";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_CAMPAIGNIDENT = "campaignident";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_ACTIVITYIDENT = "activityident";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SEQNO = "seqNo";
    public static final String PROPERTY_BPGROUP = "bPGroup";
    public static final String PROPERTY_BPGROUPIDENT = "bpgroupident";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_PRODCATEGORYIDENT = "prodcategoryident";
    public static final String PROPERTY_BUDGET = "budget";
    public static final String PROPERTY_QTY = "qty";
    public static final String PROPERTY_PRICE = "price";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_ERRORMSG = "errorMsg";
    public static final String PROPERTY_ISIMPORTED = "isImported";
    public static final String PROPERTY_CURRENCYIDENT = "currencyident";
    public static final String PROPERTY_ACCTSCHEMA = "acctschema";
    public static final String PROPERTY_ACCTSCHEMAIDENT = "acctschemaident";

    public BudgetLine() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_ISIMPORTED, false);
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

    public org.openbravo.model.financialmgmt.accounting.BudgetLine getBudgetline() {
        return (org.openbravo.model.financialmgmt.accounting.BudgetLine) get(PROPERTY_BUDGETLINE);
    }

    public void setBudgetline(
        org.openbravo.model.financialmgmt.accounting.BudgetLine budgetline) {
        set(PROPERTY_BUDGETLINE, budgetline);
    }

    public ElementValue getElementvalue() {
        return (ElementValue) get(PROPERTY_ELEMENTVALUE);
    }

    public void setElementvalue(ElementValue elementvalue) {
        set(PROPERTY_ELEMENTVALUE, elementvalue);
    }

    public String getElementvalueident() {
        return (String) get(PROPERTY_ELEMENTVALUEIDENT);
    }

    public void setElementvalueident(String elementvalueident) {
        set(PROPERTY_ELEMENTVALUEIDENT, elementvalueident);
    }

    public Period getPeriod() {
        return (Period) get(PROPERTY_PERIOD);
    }

    public void setPeriod(Period period) {
        set(PROPERTY_PERIOD, period);
    }

    public String getPeriodident() {
        return (String) get(PROPERTY_PERIODIDENT);
    }

    public void setPeriodident(String periodident) {
        set(PROPERTY_PERIODIDENT, periodident);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public org.openbravo.model.common.uom.UOM getUOM() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUOM(org.openbravo.model.common.uom.UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public String getProductident() {
        return (String) get(PROPERTY_PRODUCTIDENT);
    }

    public void setProductident(String productident) {
        set(PROPERTY_PRODUCTIDENT, productident);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public String getPartnerident() {
        return (String) get(PROPERTY_PARTNERIDENT);
    }

    public void setPartnerident(String partnerident) {
        set(PROPERTY_PARTNERIDENT, partnerident);
    }

    public Organization getOrgTrx() {
        return (Organization) get(PROPERTY_ORGTRX);
    }

    public void setOrgTrx(Organization orgTrx) {
        set(PROPERTY_ORGTRX, orgTrx);
    }

    public String getOrgtrxident() {
        return (String) get(PROPERTY_ORGTRXIDENT);
    }

    public void setOrgtrxident(String orgtrxident) {
        set(PROPERTY_ORGTRXIDENT, orgtrxident);
    }

    public SalesRegion getSalesRegion() {
        return (SalesRegion) get(PROPERTY_SALESREGION);
    }

    public void setSalesRegion(SalesRegion salesRegion) {
        set(PROPERTY_SALESREGION, salesRegion);
    }

    public String getSalesregionident() {
        return (String) get(PROPERTY_SALESREGIONIDENT);
    }

    public void setSalesregionident(String salesregionident) {
        set(PROPERTY_SALESREGIONIDENT, salesregionident);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public String getProjectident() {
        return (String) get(PROPERTY_PROJECTIDENT);
    }

    public void setProjectident(String projectident) {
        set(PROPERTY_PROJECTIDENT, projectident);
    }

    public Campaign getCampaign() {
        return (Campaign) get(PROPERTY_CAMPAIGN);
    }

    public void setCampaign(Campaign campaign) {
        set(PROPERTY_CAMPAIGN, campaign);
    }

    public String getCampaignident() {
        return (String) get(PROPERTY_CAMPAIGNIDENT);
    }

    public void setCampaignident(String campaignident) {
        set(PROPERTY_CAMPAIGNIDENT, campaignident);
    }

    public ABCActivity getActivity() {
        return (ABCActivity) get(PROPERTY_ACTIVITY);
    }

    public void setActivity(ABCActivity activity) {
        set(PROPERTY_ACTIVITY, activity);
    }

    public String getActivityident() {
        return (String) get(PROPERTY_ACTIVITYIDENT);
    }

    public void setActivityident(String activityident) {
        set(PROPERTY_ACTIVITYIDENT, activityident);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Long getSeqNo() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqNo(Long seqNo) {
        set(PROPERTY_SEQNO, seqNo);
    }

    public Category getBPGroup() {
        return (Category) get(PROPERTY_BPGROUP);
    }

    public void setBPGroup(Category bPGroup) {
        set(PROPERTY_BPGROUP, bPGroup);
    }

    public String getBpgroupident() {
        return (String) get(PROPERTY_BPGROUPIDENT);
    }

    public void setBpgroupident(String bpgroupident) {
        set(PROPERTY_BPGROUPIDENT, bpgroupident);
    }

    public ProductCategory getProductCategory() {
        return (ProductCategory) get(PROPERTY_PRODUCTCATEGORY);
    }

    public void setProductCategory(ProductCategory productCategory) {
        set(PROPERTY_PRODUCTCATEGORY, productCategory);
    }

    public String getProdcategoryident() {
        return (String) get(PROPERTY_PRODCATEGORYIDENT);
    }

    public void setProdcategoryident(String prodcategoryident) {
        set(PROPERTY_PRODCATEGORYIDENT, prodcategoryident);
    }

    public Budget getBudget() {
        return (Budget) get(PROPERTY_BUDGET);
    }

    public void setBudget(Budget budget) {
        set(PROPERTY_BUDGET, budget);
    }

    public BigDecimal getQty() {
        return (BigDecimal) get(PROPERTY_QTY);
    }

    public void setQty(BigDecimal qty) {
        set(PROPERTY_QTY, qty);
    }

    public BigDecimal getPrice() {
        return (BigDecimal) get(PROPERTY_PRICE);
    }

    public void setPrice(BigDecimal price) {
        set(PROPERTY_PRICE, price);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getErrorMsg() {
        return (String) get(PROPERTY_ERRORMSG);
    }

    public void setErrorMsg(String errorMsg) {
        set(PROPERTY_ERRORMSG, errorMsg);
    }

    public Boolean isImported() {
        return (Boolean) get(PROPERTY_ISIMPORTED);
    }

    public void setImported(Boolean isImported) {
        set(PROPERTY_ISIMPORTED, isImported);
    }

    public String getCurrencyident() {
        return (String) get(PROPERTY_CURRENCYIDENT);
    }

    public void setCurrencyident(String currencyident) {
        set(PROPERTY_CURRENCYIDENT, currencyident);
    }

    public AcctSchema getAcctschema() {
        return (AcctSchema) get(PROPERTY_ACCTSCHEMA);
    }

    public void setAcctschema(AcctSchema acctschema) {
        set(PROPERTY_ACCTSCHEMA, acctschema);
    }

    public String getAcctschemaident() {
        return (String) get(PROPERTY_ACCTSCHEMAIDENT);
    }

    public void setAcctschemaident(String acctschemaident) {
        set(PROPERTY_ACCTSCHEMAIDENT, acctschemaident);
    }
}
