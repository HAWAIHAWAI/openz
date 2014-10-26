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
package org.openbravo.model.financialmgmt.accounting.coa;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.AcctSchemaProcess;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.bank.BankAccountAccounts;
import org.openbravo.model.common.businesspartner.CategoryAccounts;
import org.openbravo.model.common.businesspartner.CustomerAccounts;
import org.openbravo.model.common.businesspartner.EmployeeAccounts;
import org.openbravo.model.common.businesspartner.VendorAccounts;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.OrganizationAcctSchema;
import org.openbravo.model.common.enterprise.WarehouseAccounts;
import org.openbravo.model.common.plm.ProductAccounts;
import org.openbravo.model.financialmgmt.accounting.InterOrgAccounts;
import org.openbravo.model.financialmgmt.assetmgmt.AssetAccounts;
import org.openbravo.model.financialmgmt.assetmgmt.AssetGroupAcct;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.financialmgmt.cashmgmt.CashBookAccounts;
import org.openbravo.model.financialmgmt.gl.GLChargeAccounts;
import org.openbravo.model.financialmgmt.gl.GLItemAccounts;
import org.openbravo.model.financialmgmt.tax.TaxRateAccounts;
import org.openbravo.model.financialmgmt.tax.WithholdingAccounts;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity FinancialMgmtAcctSchema (stored in table C_AcctSchema).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class AcctSchema extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_AcctSchema";
    public static final String ENTITY_NAME = "FinancialMgmtAcctSchema";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_GAAP = "gAAP";
    public static final String PROPERTY_ISACCRUAL = "isAccrual";
    public static final String PROPERTY_COSTINGMETHOD = "costingMethod";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_AUTOPERIODCONTROL = "autoPeriodControl";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_PERIODOPENHISTORY = "periodOpenHistory";
    public static final String PROPERTY_PERIODOPENFUTURE = "periodOpenFuture";
    public static final String PROPERTY_SEPARATOR = "separator";
    public static final String PROPERTY_HASALIAS = "hasAlias";
    public static final String PROPERTY_HASCOMBINATION = "hasCombination";
    public static final String PROPERTY_ISTRADEDISCOUNTPOSTED =
        "isTradeDiscountPosted";
    public static final String PROPERTY_ISDISCOUNTCORRECTSTAX =
        "isDiscountCorrectsTax";
    public static final String PROPERTY_ALLOWNEGATIVE = "allownegative";
    public static final String PROPERTY_PRODUCTACCOUNTSLIST =
        "productAccountsList";
    public static final String PROPERTY_FINANCIALMGMTASSETGROUPACCTLIST =
        "financialMgmtAssetGroupAcctList";
    public static final String PROPERTY_PRODUCTCATEGORYACCOUNTSLIST =
        "productCategoryAccountsList";
    public static final String PROPERTY_FINANCIALMGMTASSETACCOUNTSLIST =
        "financialMgmtAssetAccountsList";
    public static final String PROPERTY_FINANCIALMGMTWITHHOLDINGACCOUNTSLIST =
        "financialMgmtWithholdingAccountsList";
    public static final String PROPERTY_ORGANIZATIONACCTSCHEMALIST =
        "organizationAcctSchemaList";
    public static final String PROPERTY_FINANCIALMGMTACCTSCHEMAGLLIST =
        "financialMgmtAcctSchemaGLList";
    public static final String PROPERTY_EMPLOYEEACCOUNTSLIST =
        "employeeAccountsList";
    public static final String PROPERTY_CACCTSCHEMAPROCESSLIST =
        "cAcctSchemaProcessList";
    public static final String PROPERTY_BUSINESSPARTNERCATEGORYACCOUNTLIST =
        "businessPartnerCategoryAccountList";
    public static final String PROPERTY_FINANCIALMGMTACCTSCHEMADEFAULTLIST =
        "financialMgmtAcctSchemaDefaultList";
    public static final String PROPERTY_CUSTOMERACCOUNTSLIST =
        "customerAccountsList";
    public static final String PROPERTY_VENDORACCOUNTSLIST =
        "vendorAccountsList";
    public static final String PROPERTY_WAREHOUSEACCOUNTSLIST =
        "warehouseAccountsList";
    public static final String PROPERTY_FINANCIALMGMTTAXRATEACCOUNTSLIST =
        "financialMgmtTaxRateAccountsList";
    public static final String PROPERTY_FINANCIALMGMTGLCHARGEACCOUNTSLIST =
        "financialMgmtGLChargeAccountsList";
    public static final String PROPERTY_BANKACCOUNTACCOUNTSLIST =
        "bankAccountAccountsList";
    public static final String PROPERTY_FINANCIALMGMTACCTSCHEMATABLELIST =
        "financialMgmtAcctSchemaTableList";
    public static final String PROPERTY_FINANCIALMGMTINTERORGACCOUNTSLIST =
        "financialMgmtInterOrgAccountsList";
    public static final String PROPERTY_FINANCIALMGMTGLITEMACCOUNTSLIST =
        "financialMgmtGLItemAccountsList";
    public static final String PROPERTY_FINANCIALMGMTACCTSCHEMAELEMENTLIST =
        "financialMgmtAcctSchemaElementList";
    public static final String PROPERTY_FINANCIALMGMTCASHBOOKACCOUNTSLIST =
        "financialMgmtCashBookAccountsList";

    public AcctSchema() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISACCRUAL, true);
        setDefaultValue(PROPERTY_AUTOPERIODCONTROL, false);
        setDefaultValue(PROPERTY_SEPARATOR, "-");
        setDefaultValue(PROPERTY_HASALIAS, false);
        setDefaultValue(PROPERTY_HASCOMBINATION, false);
        setDefaultValue(PROPERTY_ISTRADEDISCOUNTPOSTED, false);
        setDefaultValue(PROPERTY_ISDISCOUNTCORRECTSTAX, false);
        setDefaultValue(PROPERTY_ALLOWNEGATIVE, true);
        setDefaultValue(PROPERTY_PRODUCTACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETGROUPACCTLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTCATEGORYACCOUNTSLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETACCOUNTSLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTWITHHOLDINGACCOUNTSLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONACCTSCHEMALIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCTSCHEMAGLLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_EMPLOYEEACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CACCTSCHEMAPROCESSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNERCATEGORYACCOUNTLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCTSCHEMADEFAULTLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_CUSTOMERACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_VENDORACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_WAREHOUSEACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTTAXRATEACCOUNTSLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLCHARGEACCOUNTSLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_BANKACCOUNTACCOUNTSLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCTSCHEMATABLELIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTINTERORGACCOUNTSLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLITEMACCOUNTSLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCTSCHEMAELEMENTLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTCASHBOOKACCOUNTSLIST,
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getGAAP() {
        return (String) get(PROPERTY_GAAP);
    }

    public void setGAAP(String gAAP) {
        set(PROPERTY_GAAP, gAAP);
    }

    public Boolean isAccrual() {
        return (Boolean) get(PROPERTY_ISACCRUAL);
    }

    public void setAccrual(Boolean isAccrual) {
        set(PROPERTY_ISACCRUAL, isAccrual);
    }

    public String getCostingMethod() {
        return (String) get(PROPERTY_COSTINGMETHOD);
    }

    public void setCostingMethod(String costingMethod) {
        set(PROPERTY_COSTINGMETHOD, costingMethod);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public Boolean isAutoPeriodControl() {
        return (Boolean) get(PROPERTY_AUTOPERIODCONTROL);
    }

    public void setAutoPeriodControl(Boolean autoPeriodControl) {
        set(PROPERTY_AUTOPERIODCONTROL, autoPeriodControl);
    }

    public Period getPeriod() {
        return (Period) get(PROPERTY_PERIOD);
    }

    public void setPeriod(Period period) {
        set(PROPERTY_PERIOD, period);
    }

    public Long getPeriodOpenHistory() {
        return (Long) get(PROPERTY_PERIODOPENHISTORY);
    }

    public void setPeriodOpenHistory(Long periodOpenHistory) {
        set(PROPERTY_PERIODOPENHISTORY, periodOpenHistory);
    }

    public Long getPeriodOpenFuture() {
        return (Long) get(PROPERTY_PERIODOPENFUTURE);
    }

    public void setPeriodOpenFuture(Long periodOpenFuture) {
        set(PROPERTY_PERIODOPENFUTURE, periodOpenFuture);
    }

    public String getSeparator() {
        return (String) get(PROPERTY_SEPARATOR);
    }

    public void setSeparator(String separator) {
        set(PROPERTY_SEPARATOR, separator);
    }

    public Boolean isHasAlias() {
        return (Boolean) get(PROPERTY_HASALIAS);
    }

    public void setHasAlias(Boolean hasAlias) {
        set(PROPERTY_HASALIAS, hasAlias);
    }

    public Boolean isHasCombination() {
        return (Boolean) get(PROPERTY_HASCOMBINATION);
    }

    public void setHasCombination(Boolean hasCombination) {
        set(PROPERTY_HASCOMBINATION, hasCombination);
    }

    public Boolean isTradeDiscountPosted() {
        return (Boolean) get(PROPERTY_ISTRADEDISCOUNTPOSTED);
    }

    public void setTradeDiscountPosted(Boolean isTradeDiscountPosted) {
        set(PROPERTY_ISTRADEDISCOUNTPOSTED, isTradeDiscountPosted);
    }

    public Boolean isDiscountCorrectsTax() {
        return (Boolean) get(PROPERTY_ISDISCOUNTCORRECTSTAX);
    }

    public void setDiscountCorrectsTax(Boolean isDiscountCorrectsTax) {
        set(PROPERTY_ISDISCOUNTCORRECTSTAX, isDiscountCorrectsTax);
    }

    public Boolean isAllownegative() {
        return (Boolean) get(PROPERTY_ALLOWNEGATIVE);
    }

    public void setAllownegative(Boolean allownegative) {
        set(PROPERTY_ALLOWNEGATIVE, allownegative);
    }

    @SuppressWarnings("unchecked")
    public List<ProductAccounts> getProductAccountsList() {
        return (List<ProductAccounts>) get(PROPERTY_PRODUCTACCOUNTSLIST);
    }

    public void setProductAccountsList(
        List<ProductAccounts> productAccountsList) {
        set(PROPERTY_PRODUCTACCOUNTSLIST, productAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<AssetGroupAcct> getFinancialMgmtAssetGroupAcctList() {
        return (List<AssetGroupAcct>) get(PROPERTY_FINANCIALMGMTASSETGROUPACCTLIST);
    }

    public void setFinancialMgmtAssetGroupAcctList(
        List<AssetGroupAcct> financialMgmtAssetGroupAcctList) {
        set(PROPERTY_FINANCIALMGMTASSETGROUPACCTLIST,
            financialMgmtAssetGroupAcctList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.plm.CategoryAccounts> getProductCategoryAccountsList() {
        return (List<org.openbravo.model.common.plm.CategoryAccounts>) get(PROPERTY_PRODUCTCATEGORYACCOUNTSLIST);
    }

    public void setProductCategoryAccountsList(
        List<org.openbravo.model.common.plm.CategoryAccounts> productCategoryAccountsList) {
        set(PROPERTY_PRODUCTCATEGORYACCOUNTSLIST, productCategoryAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<AssetAccounts> getFinancialMgmtAssetAccountsList() {
        return (List<AssetAccounts>) get(PROPERTY_FINANCIALMGMTASSETACCOUNTSLIST);
    }

    public void setFinancialMgmtAssetAccountsList(
        List<AssetAccounts> financialMgmtAssetAccountsList) {
        set(PROPERTY_FINANCIALMGMTASSETACCOUNTSLIST,
            financialMgmtAssetAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<WithholdingAccounts> getFinancialMgmtWithholdingAccountsList() {
        return (List<WithholdingAccounts>) get(PROPERTY_FINANCIALMGMTWITHHOLDINGACCOUNTSLIST);
    }

    public void setFinancialMgmtWithholdingAccountsList(
        List<WithholdingAccounts> financialMgmtWithholdingAccountsList) {
        set(PROPERTY_FINANCIALMGMTWITHHOLDINGACCOUNTSLIST,
            financialMgmtWithholdingAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<OrganizationAcctSchema> getOrganizationAcctSchemaList() {
        return (List<OrganizationAcctSchema>) get(PROPERTY_ORGANIZATIONACCTSCHEMALIST);
    }

    public void setOrganizationAcctSchemaList(
        List<OrganizationAcctSchema> organizationAcctSchemaList) {
        set(PROPERTY_ORGANIZATIONACCTSCHEMALIST, organizationAcctSchemaList);
    }

    @SuppressWarnings("unchecked")
    public List<AcctSchemaGL> getFinancialMgmtAcctSchemaGLList() {
        return (List<AcctSchemaGL>) get(PROPERTY_FINANCIALMGMTACCTSCHEMAGLLIST);
    }

    public void setFinancialMgmtAcctSchemaGLList(
        List<AcctSchemaGL> financialMgmtAcctSchemaGLList) {
        set(PROPERTY_FINANCIALMGMTACCTSCHEMAGLLIST,
            financialMgmtAcctSchemaGLList);
    }

    @SuppressWarnings("unchecked")
    public List<EmployeeAccounts> getEmployeeAccountsList() {
        return (List<EmployeeAccounts>) get(PROPERTY_EMPLOYEEACCOUNTSLIST);
    }

    public void setEmployeeAccountsList(
        List<EmployeeAccounts> employeeAccountsList) {
        set(PROPERTY_EMPLOYEEACCOUNTSLIST, employeeAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<AcctSchemaProcess> getCAcctSchemaProcessList() {
        return (List<AcctSchemaProcess>) get(PROPERTY_CACCTSCHEMAPROCESSLIST);
    }

    public void setCAcctSchemaProcessList(
        List<AcctSchemaProcess> cAcctSchemaProcessList) {
        set(PROPERTY_CACCTSCHEMAPROCESSLIST, cAcctSchemaProcessList);
    }

    @SuppressWarnings("unchecked")
    public List<CategoryAccounts> getBusinessPartnerCategoryAccountList() {
        return (List<CategoryAccounts>) get(PROPERTY_BUSINESSPARTNERCATEGORYACCOUNTLIST);
    }

    public void setBusinessPartnerCategoryAccountList(
        List<CategoryAccounts> businessPartnerCategoryAccountList) {
        set(PROPERTY_BUSINESSPARTNERCATEGORYACCOUNTLIST,
            businessPartnerCategoryAccountList);
    }

    @SuppressWarnings("unchecked")
    public List<AcctSchemaDefault> getFinancialMgmtAcctSchemaDefaultList() {
        return (List<AcctSchemaDefault>) get(PROPERTY_FINANCIALMGMTACCTSCHEMADEFAULTLIST);
    }

    public void setFinancialMgmtAcctSchemaDefaultList(
        List<AcctSchemaDefault> financialMgmtAcctSchemaDefaultList) {
        set(PROPERTY_FINANCIALMGMTACCTSCHEMADEFAULTLIST,
            financialMgmtAcctSchemaDefaultList);
    }

    @SuppressWarnings("unchecked")
    public List<CustomerAccounts> getCustomerAccountsList() {
        return (List<CustomerAccounts>) get(PROPERTY_CUSTOMERACCOUNTSLIST);
    }

    public void setCustomerAccountsList(
        List<CustomerAccounts> customerAccountsList) {
        set(PROPERTY_CUSTOMERACCOUNTSLIST, customerAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<VendorAccounts> getVendorAccountsList() {
        return (List<VendorAccounts>) get(PROPERTY_VENDORACCOUNTSLIST);
    }

    public void setVendorAccountsList(List<VendorAccounts> vendorAccountsList) {
        set(PROPERTY_VENDORACCOUNTSLIST, vendorAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<WarehouseAccounts> getWarehouseAccountsList() {
        return (List<WarehouseAccounts>) get(PROPERTY_WAREHOUSEACCOUNTSLIST);
    }

    public void setWarehouseAccountsList(
        List<WarehouseAccounts> warehouseAccountsList) {
        set(PROPERTY_WAREHOUSEACCOUNTSLIST, warehouseAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<TaxRateAccounts> getFinancialMgmtTaxRateAccountsList() {
        return (List<TaxRateAccounts>) get(PROPERTY_FINANCIALMGMTTAXRATEACCOUNTSLIST);
    }

    public void setFinancialMgmtTaxRateAccountsList(
        List<TaxRateAccounts> financialMgmtTaxRateAccountsList) {
        set(PROPERTY_FINANCIALMGMTTAXRATEACCOUNTSLIST,
            financialMgmtTaxRateAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<GLChargeAccounts> getFinancialMgmtGLChargeAccountsList() {
        return (List<GLChargeAccounts>) get(PROPERTY_FINANCIALMGMTGLCHARGEACCOUNTSLIST);
    }

    public void setFinancialMgmtGLChargeAccountsList(
        List<GLChargeAccounts> financialMgmtGLChargeAccountsList) {
        set(PROPERTY_FINANCIALMGMTGLCHARGEACCOUNTSLIST,
            financialMgmtGLChargeAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<BankAccountAccounts> getBankAccountAccountsList() {
        return (List<BankAccountAccounts>) get(PROPERTY_BANKACCOUNTACCOUNTSLIST);
    }

    public void setBankAccountAccountsList(
        List<BankAccountAccounts> bankAccountAccountsList) {
        set(PROPERTY_BANKACCOUNTACCOUNTSLIST, bankAccountAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<AcctSchemaTable> getFinancialMgmtAcctSchemaTableList() {
        return (List<AcctSchemaTable>) get(PROPERTY_FINANCIALMGMTACCTSCHEMATABLELIST);
    }

    public void setFinancialMgmtAcctSchemaTableList(
        List<AcctSchemaTable> financialMgmtAcctSchemaTableList) {
        set(PROPERTY_FINANCIALMGMTACCTSCHEMATABLELIST,
            financialMgmtAcctSchemaTableList);
    }

    @SuppressWarnings("unchecked")
    public List<InterOrgAccounts> getFinancialMgmtInterOrgAccountsList() {
        return (List<InterOrgAccounts>) get(PROPERTY_FINANCIALMGMTINTERORGACCOUNTSLIST);
    }

    public void setFinancialMgmtInterOrgAccountsList(
        List<InterOrgAccounts> financialMgmtInterOrgAccountsList) {
        set(PROPERTY_FINANCIALMGMTINTERORGACCOUNTSLIST,
            financialMgmtInterOrgAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<GLItemAccounts> getFinancialMgmtGLItemAccountsList() {
        return (List<GLItemAccounts>) get(PROPERTY_FINANCIALMGMTGLITEMACCOUNTSLIST);
    }

    public void setFinancialMgmtGLItemAccountsList(
        List<GLItemAccounts> financialMgmtGLItemAccountsList) {
        set(PROPERTY_FINANCIALMGMTGLITEMACCOUNTSLIST,
            financialMgmtGLItemAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<AcctSchemaElement> getFinancialMgmtAcctSchemaElementList() {
        return (List<AcctSchemaElement>) get(PROPERTY_FINANCIALMGMTACCTSCHEMAELEMENTLIST);
    }

    public void setFinancialMgmtAcctSchemaElementList(
        List<AcctSchemaElement> financialMgmtAcctSchemaElementList) {
        set(PROPERTY_FINANCIALMGMTACCTSCHEMAELEMENTLIST,
            financialMgmtAcctSchemaElementList);
    }

    @SuppressWarnings("unchecked")
    public List<CashBookAccounts> getFinancialMgmtCashBookAccountsList() {
        return (List<CashBookAccounts>) get(PROPERTY_FINANCIALMGMTCASHBOOKACCOUNTSLIST);
    }

    public void setFinancialMgmtCashBookAccountsList(
        List<CashBookAccounts> financialMgmtCashBookAccountsList) {
        set(PROPERTY_FINANCIALMGMTCASHBOOKACCOUNTSLIST,
            financialMgmtCashBookAccountsList);
    }
}
