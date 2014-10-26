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
package org.openbravo.model.common.businesspartner;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.system.Language;
import org.openbravo.model.common.bank.BankAccount;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.WarehouseShipper;
import org.openbravo.model.common.hcm.SalaryCategory;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceSchedule;
import org.openbravo.model.common.plm.ApprovedVendor;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.timeandexpense.SheetLine;
import org.openbravo.model.timeandexpense.SheetLineV;
import org.openbravo.zsoft.smartui.Notes4customer;
import org.openbravo.zsoft.smartui.Sales2customer;
import org.openbravo.zsoft.smartui.Zssi_groupofcompanies;

import org.openz.businessplanning.Bplsalesforecast;

import org.zsoft.ecommerce.Zse_ecommercegrant;
import org.zsoft.serial.Snr_serialnumbertracking;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity BusinessPartner (stored in table C_BPartner).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class BusinessPartner extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_BPartner";
    public static final String ENTITY_NAME = "BusinessPartner";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_NAME2 = "name2";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ISSUMMARY = "isSummary";
    public static final String PROPERTY_BPGROUP = "bPGroup";
    public static final String PROPERTY_ISONETIME = "isOneTime";
    public static final String PROPERTY_ISPROSPECT = "isProspect";
    public static final String PROPERTY_ISVENDOR = "isVendor";
    public static final String PROPERTY_ISCUSTOMER = "isCustomer";
    public static final String PROPERTY_ISEMPLOYEE = "isEmployee";
    public static final String PROPERTY_ISSALESREP = "isSalesRep";
    public static final String PROPERTY_REFERENCENO = "referenceNo";
    public static final String PROPERTY_DUNS = "dUNS";
    public static final String PROPERTY_URL = "uRL";
    public static final String PROPERTY_LANGUAGE = "language";
    public static final String PROPERTY_TAXID = "taxID";
    public static final String PROPERTY_ISTAXEXEMPT = "isTaxExempt";
    public static final String PROPERTY_INVOICESCHEDULE = "invoiceSchedule";
    public static final String PROPERTY_RATING = "rating";
    public static final String PROPERTY_SALESVOLUME = "salesVolume";
    public static final String PROPERTY_NUMBEREMPLOYEES = "numberEmployees";
    public static final String PROPERTY_NAICS = "nAICS";
    public static final String PROPERTY_FIRSTSALE = "firstSale";
    public static final String PROPERTY_ACQUSITIONCOST = "acqusitionCost";
    public static final String PROPERTY_POTENTIALLIFETIMEVALUE =
        "potentialLifeTimeValue";
    public static final String PROPERTY_ACTUALLIFETIMEVALUE =
        "actualLifeTimeValue";
    public static final String PROPERTY_SHAREOFCUSTOMER = "shareOfCustomer";
    public static final String PROPERTY_PAYMENTRULE = "paymentRule";
    public static final String PROPERTY_CREDITLIMIT = "creditLimit";
    public static final String PROPERTY_CREDITUSED = "creditUsed";
    public static final String PROPERTY_PAYMENTTERM = "paymentTerm";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_ISDISCOUNTPRINTED = "isDiscountPrinted";
    public static final String PROPERTY_DESCRIPTION42 = "description42";
    public static final String PROPERTY_POREFERENCE = "pOReference";
    public static final String PROPERTY_PAYMENTRULEPO = "paymentRulePO";
    public static final String PROPERTY_PRICELIST45 = "priceList45";
    public static final String PROPERTY_PAYMENTTERM46 = "paymentTerm46";
    public static final String PROPERTY_DOCUMENTCOPIES = "documentCopies";
    public static final String PROPERTY_GREETING = "greeting";
    public static final String PROPERTY_INVOICERULE = "invoiceRule";
    public static final String PROPERTY_DELIVERYRULE = "deliveryRule";
    public static final String PROPERTY_DELIVERYVIARULE = "deliveryViaRule";
    public static final String PROPERTY_SALESREP = "salesRep";
    public static final String PROPERTY_BPARTNERPARENT = "bPartnerParent";
    public static final String PROPERTY_SOCREDITSTATUS = "sOCreditStatus";
    public static final String PROPERTY_FORCEDORG = "forcedOrg";
    public static final String PROPERTY_SHOWPRICEINORDER = "showPriceInOrder";
    public static final String PROPERTY_INVOICEGROUPING = "invoicegrouping";
    public static final String PROPERTY_FIXMONTHDAY = "fixMonthDay";
    public static final String PROPERTY_FIXMONTHDAY2 = "fixMonthDay2";
    public static final String PROPERTY_FIXMONTHDAY3 = "fixmonthday3";
    public static final String PROPERTY_ISWORKER = "isworker";
    public static final String PROPERTY_UPC = "uPC";
    public static final String PROPERTY_SALARYCATEGORY = "salaryCategory";
    public static final String PROPERTY_INVOICEPRINTFORMAT =
        "invoicePrintformat";
    public static final String PROPERTY_LASTDAYS = "lastDays";
    public static final String PROPERTY_BANKACCOUNT = "bankaccount";
    public static final String PROPERTY_BPTAXCATEGORY = "bPTaxCategory";
    public static final String PROPERTY_FIXMONTHDAY68 = "fixmonthday68";
    public static final String PROPERTY_FIXMONTHDAY269 = "fixmonthday269";
    public static final String PROPERTY_FIXMONTHDAY370 = "fixmonthday370";
    public static final String PROPERTY_BANKACCOUNT71 = "bankaccount71";
    public static final String PROPERTY_BPTAXCATEGORY72 = "bpTaxcategory72";
    public static final String PROPERTY_FISCALCODE = "fiscalcode";
    public static final String PROPERTY_ISOFISCALCODE = "iSOFiscalCode";
    public static final String PROPERTY_ZSSIGROUPOFCOMPANIES =
        "zssiGroupofcompanies";
    public static final String PROPERTY_COUNTRY = "country";
    public static final String PROPERTY_CITY = "city";
    public static final String PROPERTY_ZIPCODE = "zipcode";
    public static final String PROPERTY_ISSALESLEAD = "isSalesLead";
    public static final String PROPERTY_OWNCODEATPARTNERSITE =
        "owncodeatpartnersite";
    public static final String PROPERTY_ISPROJECTMANAGER = "isprojectmanager";
    public static final String PROPERTY_ISPROCUREMENTMANAGER =
        "isprocurementmanager";
    public static final String PROPERTY_EXTERNALID = "externalid";
    public static final String PROPERTY_LINEOFBUSINESS = "lineofbusiness";
    public static final String PROPERTY_APPROVALAMT = "approvalamt";
    public static final String PROPERTY_ISAPPROVER = "isApprover";
    public static final String PROPERTY_ISPRAPPROVER = "isprapprover";
    public static final String PROPERTY_EXTERNALSYNCCODE = "externalsynccode";
    public static final String PROPERTY_ISECOMMERCEACTIVE = "isecommerceactive";
    public static final String PROPERTY_ISPAYMENTAPPROVER = "ispaymentapprover";
    public static final String PROPERTY_ISCREDITCARD = "isCreditcard";
    public static final String PROPERTY_BPARTNERORGLIST = "bpartnerOrgList";
    public static final String PROPERTY_ADUSERLIST = "aDUserList";
    public static final String PROPERTY_BUSINESSPARTNERBANKACCOUNTLIST =
        "businessPartnerBankAccountList";
    public static final String PROPERTY_BPARTNEREMPLOYEECALENDARSETTINGSLIST =
        "bpartneremployeeCALENDARSETTINGSList";
    public static final String PROPERTY_EMPLOYEESALARYCATEGORYLIST =
        "employeeSalaryCategoryList";
    public static final String PROPERTY_PRICINGVOLUMEDISCOUNTBUSINESSPARTNERLIST =
        "pricingVolumeDiscountBusinessPartnerList";
    public static final String PROPERTY_APPROVEDVENDORLIST =
        "approvedVendorList";
    public static final String PROPERTY_ZSSINOTES4CUSTOMERLIST =
        "zssiNotes4customerList";
    public static final String PROPERTY_EMPLOYEEACCOUNTSLIST =
        "employeeAccountsList";
    public static final String PROPERTY_ZSSISALES2CUSTOMERLIST =
        "zssiSales2customerList";
    public static final String PROPERTY_WAREHOUSESHIPPERLIST =
        "warehouseShipperList";
    public static final String PROPERTY_FINANCIALMGMTASSETLIST =
        "financialMgmtAssetList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINEVLIST =
        "timeAndExpenseSheetLineVList";
    public static final String PROPERTY_CUSTOMERACCOUNTSLIST =
        "customerAccountsList";
    public static final String PROPERTY_VENDORACCOUNTSLIST =
        "vendorAccountsList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINELIST =
        "timeAndExpenseSheetLineList";
    public static final String PROPERTY_SNRSERIALNUMBERTRACKINGLIST =
        "snrSerialnumbertrackingList";
    public static final String PROPERTY_ZSEECOMMERCEGRANTLIST =
        "zseEcommercegrantList";
    public static final String PROPERTY_EMPLOYEECALENDARVLIST =
        "employeecalendarVList";
    public static final String PROPERTY_BUSINESSPARTNERLOCATIONLIST =
        "businessPartnerLocationList";
    public static final String PROPERTY_REFINVOICETOORDERVIEWLIST =
        "refinvoicetoorderViewList";
    public static final String PROPERTY_INVOICELIST = "invoiceList";
    public static final String PROPERTY_BPARTNEREMPLOYEEEVENTLIST =
        "bpartneremployeeEVENTList";
    public static final String PROPERTY_BUSINESSPARTNERWITHHOLDINGLIST =
        "businessPartnerWithholdingList";
    public static final String PROPERTY_BPLSALESFORECASTLIST =
        "bplSalesforecastList";
    public static final String PROPERTY_ZSSIOPENSHIPMENTLIST =
        "zssiOpenshipmentList";
    public static final String PROPERTY_INVOICECREDITCARDVLIST =
        "invoiceCreditcardVList";
    public static final String PROPERTY_ZSSISALESFORECASTLIST =
        "zssiSalesforecastList";

    public BusinessPartner() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISSUMMARY, false);
        setDefaultValue(PROPERTY_ISONETIME, false);
        setDefaultValue(PROPERTY_ISPROSPECT, false);
        setDefaultValue(PROPERTY_ISVENDOR, false);
        setDefaultValue(PROPERTY_ISCUSTOMER, false);
        setDefaultValue(PROPERTY_ISEMPLOYEE, false);
        setDefaultValue(PROPERTY_ISSALESREP, false);
        setDefaultValue(PROPERTY_ISTAXEXEMPT, false);
        setDefaultValue(PROPERTY_PAYMENTRULE, "R");
        setDefaultValue(PROPERTY_ISDISCOUNTPRINTED, false);
        setDefaultValue(PROPERTY_PAYMENTRULEPO, "R");
        setDefaultValue(PROPERTY_INVOICERULE, "I");
        setDefaultValue(PROPERTY_DELIVERYRULE, "A");
        setDefaultValue(PROPERTY_DELIVERYVIARULE, "D");
        setDefaultValue(PROPERTY_SHOWPRICEINORDER, true);
        setDefaultValue(PROPERTY_INVOICEGROUPING, "000000000000000");
        setDefaultValue(PROPERTY_ISWORKER, false);
        setDefaultValue(PROPERTY_ISSALESLEAD, false);
        setDefaultValue(PROPERTY_ISPROJECTMANAGER, false);
        setDefaultValue(PROPERTY_ISPROCUREMENTMANAGER, false);
        setDefaultValue(PROPERTY_APPROVALAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISAPPROVER, false);
        setDefaultValue(PROPERTY_ISPRAPPROVER, false);
        setDefaultValue(PROPERTY_ISECOMMERCEACTIVE, true);
        setDefaultValue(PROPERTY_ISPAYMENTAPPROVER, false);
        setDefaultValue(PROPERTY_ISCREDITCARD, false);
        setDefaultValue(PROPERTY_BPARTNERORGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADUSERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNERBANKACCOUNTLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_BPARTNEREMPLOYEECALENDARSETTINGSLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_EMPLOYEESALARYCATEGORYLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGVOLUMEDISCOUNTBUSINESSPARTNERLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_APPROVEDVENDORLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSSINOTES4CUSTOMERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EMPLOYEEACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSSISALES2CUSTOMERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_WAREHOUSESHIPPERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_CUSTOMERACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_VENDORACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINELIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_SNRSERIALNUMBERTRACKINGLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSEECOMMERCEGRANTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EMPLOYEECALENDARVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNERLOCATIONLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_REFINVOICETOORDERVIEWLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BPARTNEREMPLOYEEEVENTLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNERWITHHOLDINGLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_BPLSALESFORECASTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSSIOPENSHIPMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICECREDITCARDVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSSISALESFORECASTLIST, new ArrayList<Object>());
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

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getName2() {
        return (String) get(PROPERTY_NAME2);
    }

    public void setName2(String name2) {
        set(PROPERTY_NAME2, name2);
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

    public Category getBPGroup() {
        return (Category) get(PROPERTY_BPGROUP);
    }

    public void setBPGroup(Category bPGroup) {
        set(PROPERTY_BPGROUP, bPGroup);
    }

    public Boolean isOneTime() {
        return (Boolean) get(PROPERTY_ISONETIME);
    }

    public void setOneTime(Boolean isOneTime) {
        set(PROPERTY_ISONETIME, isOneTime);
    }

    public Boolean isProspect() {
        return (Boolean) get(PROPERTY_ISPROSPECT);
    }

    public void setProspect(Boolean isProspect) {
        set(PROPERTY_ISPROSPECT, isProspect);
    }

    public Boolean isVendor() {
        return (Boolean) get(PROPERTY_ISVENDOR);
    }

    public void setVendor(Boolean isVendor) {
        set(PROPERTY_ISVENDOR, isVendor);
    }

    public Boolean isCustomer() {
        return (Boolean) get(PROPERTY_ISCUSTOMER);
    }

    public void setCustomer(Boolean isCustomer) {
        set(PROPERTY_ISCUSTOMER, isCustomer);
    }

    public Boolean isEmployee() {
        return (Boolean) get(PROPERTY_ISEMPLOYEE);
    }

    public void setEmployee(Boolean isEmployee) {
        set(PROPERTY_ISEMPLOYEE, isEmployee);
    }

    public Boolean isSalesRep() {
        return (Boolean) get(PROPERTY_ISSALESREP);
    }

    public void setSalesRep(Boolean isSalesRep) {
        set(PROPERTY_ISSALESREP, isSalesRep);
    }

    public String getReferenceNo() {
        return (String) get(PROPERTY_REFERENCENO);
    }

    public void setReferenceNo(String referenceNo) {
        set(PROPERTY_REFERENCENO, referenceNo);
    }

    public String getDUNS() {
        return (String) get(PROPERTY_DUNS);
    }

    public void setDUNS(String dUNS) {
        set(PROPERTY_DUNS, dUNS);
    }

    public String getURL() {
        return (String) get(PROPERTY_URL);
    }

    public void setURL(String uRL) {
        set(PROPERTY_URL, uRL);
    }

    public Language getLanguage() {
        return (Language) get(PROPERTY_LANGUAGE);
    }

    public void setLanguage(Language language) {
        set(PROPERTY_LANGUAGE, language);
    }

    public String getTaxID() {
        return (String) get(PROPERTY_TAXID);
    }

    public void setTaxID(String taxID) {
        set(PROPERTY_TAXID, taxID);
    }

    public Boolean isTaxExempt() {
        return (Boolean) get(PROPERTY_ISTAXEXEMPT);
    }

    public void setTaxExempt(Boolean isTaxExempt) {
        set(PROPERTY_ISTAXEXEMPT, isTaxExempt);
    }

    public InvoiceSchedule getInvoiceSchedule() {
        return (InvoiceSchedule) get(PROPERTY_INVOICESCHEDULE);
    }

    public void setInvoiceSchedule(InvoiceSchedule invoiceSchedule) {
        set(PROPERTY_INVOICESCHEDULE, invoiceSchedule);
    }

    public String getRating() {
        return (String) get(PROPERTY_RATING);
    }

    public void setRating(String rating) {
        set(PROPERTY_RATING, rating);
    }

    public BigDecimal getSalesVolume() {
        return (BigDecimal) get(PROPERTY_SALESVOLUME);
    }

    public void setSalesVolume(BigDecimal salesVolume) {
        set(PROPERTY_SALESVOLUME, salesVolume);
    }

    public Long getNumberEmployees() {
        return (Long) get(PROPERTY_NUMBEREMPLOYEES);
    }

    public void setNumberEmployees(Long numberEmployees) {
        set(PROPERTY_NUMBEREMPLOYEES, numberEmployees);
    }

    public String getNAICS() {
        return (String) get(PROPERTY_NAICS);
    }

    public void setNAICS(String nAICS) {
        set(PROPERTY_NAICS, nAICS);
    }

    public Date getFirstSale() {
        return (Date) get(PROPERTY_FIRSTSALE);
    }

    public void setFirstSale(Date firstSale) {
        set(PROPERTY_FIRSTSALE, firstSale);
    }

    public BigDecimal getAcqusitionCost() {
        return (BigDecimal) get(PROPERTY_ACQUSITIONCOST);
    }

    public void setAcqusitionCost(BigDecimal acqusitionCost) {
        set(PROPERTY_ACQUSITIONCOST, acqusitionCost);
    }

    public BigDecimal getPotentialLifeTimeValue() {
        return (BigDecimal) get(PROPERTY_POTENTIALLIFETIMEVALUE);
    }

    public void setPotentialLifeTimeValue(BigDecimal potentialLifeTimeValue) {
        set(PROPERTY_POTENTIALLIFETIMEVALUE, potentialLifeTimeValue);
    }

    public BigDecimal getActualLifeTimeValue() {
        return (BigDecimal) get(PROPERTY_ACTUALLIFETIMEVALUE);
    }

    public void setActualLifeTimeValue(BigDecimal actualLifeTimeValue) {
        set(PROPERTY_ACTUALLIFETIMEVALUE, actualLifeTimeValue);
    }

    public Long getShareOfCustomer() {
        return (Long) get(PROPERTY_SHAREOFCUSTOMER);
    }

    public void setShareOfCustomer(Long shareOfCustomer) {
        set(PROPERTY_SHAREOFCUSTOMER, shareOfCustomer);
    }

    public String getPaymentRule() {
        return (String) get(PROPERTY_PAYMENTRULE);
    }

    public void setPaymentRule(String paymentRule) {
        set(PROPERTY_PAYMENTRULE, paymentRule);
    }

    public BigDecimal getCreditLimit() {
        return (BigDecimal) get(PROPERTY_CREDITLIMIT);
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        set(PROPERTY_CREDITLIMIT, creditLimit);
    }

    public BigDecimal getCreditUsed() {
        return (BigDecimal) get(PROPERTY_CREDITUSED);
    }

    public void setCreditUsed(BigDecimal creditUsed) {
        set(PROPERTY_CREDITUSED, creditUsed);
    }

    public PaymentTerm getPaymentTerm() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERM);
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        set(PROPERTY_PAYMENTTERM, paymentTerm);
    }

    public PriceList getPriceList() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(PriceList priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public Boolean isDiscountPrinted() {
        return (Boolean) get(PROPERTY_ISDISCOUNTPRINTED);
    }

    public void setDiscountPrinted(Boolean isDiscountPrinted) {
        set(PROPERTY_ISDISCOUNTPRINTED, isDiscountPrinted);
    }

    public String getDescription42() {
        return (String) get(PROPERTY_DESCRIPTION42);
    }

    public void setDescription42(String description42) {
        set(PROPERTY_DESCRIPTION42, description42);
    }

    public String getPOReference() {
        return (String) get(PROPERTY_POREFERENCE);
    }

    public void setPOReference(String pOReference) {
        set(PROPERTY_POREFERENCE, pOReference);
    }

    public String getPaymentRulePO() {
        return (String) get(PROPERTY_PAYMENTRULEPO);
    }

    public void setPaymentRulePO(String paymentRulePO) {
        set(PROPERTY_PAYMENTRULEPO, paymentRulePO);
    }

    public PriceList getPriceList45() {
        return (PriceList) get(PROPERTY_PRICELIST45);
    }

    public void setPriceList45(PriceList priceList45) {
        set(PROPERTY_PRICELIST45, priceList45);
    }

    public PaymentTerm getPaymentTerm46() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERM46);
    }

    public void setPaymentTerm46(PaymentTerm paymentTerm46) {
        set(PROPERTY_PAYMENTTERM46, paymentTerm46);
    }

    public Long getDocumentCopies() {
        return (Long) get(PROPERTY_DOCUMENTCOPIES);
    }

    public void setDocumentCopies(Long documentCopies) {
        set(PROPERTY_DOCUMENTCOPIES, documentCopies);
    }

    public Greeting getGreeting() {
        return (Greeting) get(PROPERTY_GREETING);
    }

    public void setGreeting(Greeting greeting) {
        set(PROPERTY_GREETING, greeting);
    }

    public String getInvoiceRule() {
        return (String) get(PROPERTY_INVOICERULE);
    }

    public void setInvoiceRule(String invoiceRule) {
        set(PROPERTY_INVOICERULE, invoiceRule);
    }

    public String getDeliveryRule() {
        return (String) get(PROPERTY_DELIVERYRULE);
    }

    public void setDeliveryRule(String deliveryRule) {
        set(PROPERTY_DELIVERYRULE, deliveryRule);
    }

    public String getDeliveryViaRule() {
        return (String) get(PROPERTY_DELIVERYVIARULE);
    }

    public void setDeliveryViaRule(String deliveryViaRule) {
        set(PROPERTY_DELIVERYVIARULE, deliveryViaRule);
    }

    public BusinessPartner getSalesRep() {
        return (BusinessPartner) get(PROPERTY_SALESREP);
    }

    public void setSalesRep(BusinessPartner salesRep) {
        set(PROPERTY_SALESREP, salesRep);
    }

    public String getBPartnerParent() {
        return (String) get(PROPERTY_BPARTNERPARENT);
    }

    public void setBPartnerParent(String bPartnerParent) {
        set(PROPERTY_BPARTNERPARENT, bPartnerParent);
    }

    public String getSOCreditStatus() {
        return (String) get(PROPERTY_SOCREDITSTATUS);
    }

    public void setSOCreditStatus(String sOCreditStatus) {
        set(PROPERTY_SOCREDITSTATUS, sOCreditStatus);
    }

    public Organization getForcedOrg() {
        return (Organization) get(PROPERTY_FORCEDORG);
    }

    public void setForcedOrg(Organization forcedOrg) {
        set(PROPERTY_FORCEDORG, forcedOrg);
    }

    public Boolean isShowPriceInOrder() {
        return (Boolean) get(PROPERTY_SHOWPRICEINORDER);
    }

    public void setShowPriceInOrder(Boolean showPriceInOrder) {
        set(PROPERTY_SHOWPRICEINORDER, showPriceInOrder);
    }

    public String getInvoicegrouping() {
        return (String) get(PROPERTY_INVOICEGROUPING);
    }

    public void setInvoicegrouping(String invoicegrouping) {
        set(PROPERTY_INVOICEGROUPING, invoicegrouping);
    }

    public Long getFixMonthDay() {
        return (Long) get(PROPERTY_FIXMONTHDAY);
    }

    public void setFixMonthDay(Long fixMonthDay) {
        set(PROPERTY_FIXMONTHDAY, fixMonthDay);
    }

    public Long getFixMonthDay2() {
        return (Long) get(PROPERTY_FIXMONTHDAY2);
    }

    public void setFixMonthDay2(Long fixMonthDay2) {
        set(PROPERTY_FIXMONTHDAY2, fixMonthDay2);
    }

    public Long getFixmonthday3() {
        return (Long) get(PROPERTY_FIXMONTHDAY3);
    }

    public void setFixmonthday3(Long fixmonthday3) {
        set(PROPERTY_FIXMONTHDAY3, fixmonthday3);
    }

    public Boolean isWorker() {
        return (Boolean) get(PROPERTY_ISWORKER);
    }

    public void setWorker(Boolean isworker) {
        set(PROPERTY_ISWORKER, isworker);
    }

    public String getUPC() {
        return (String) get(PROPERTY_UPC);
    }

    public void setUPC(String uPC) {
        set(PROPERTY_UPC, uPC);
    }

    public SalaryCategory getSalaryCategory() {
        return (SalaryCategory) get(PROPERTY_SALARYCATEGORY);
    }

    public void setSalaryCategory(SalaryCategory salaryCategory) {
        set(PROPERTY_SALARYCATEGORY, salaryCategory);
    }

    public String getInvoicePrintformat() {
        return (String) get(PROPERTY_INVOICEPRINTFORMAT);
    }

    public void setInvoicePrintformat(String invoicePrintformat) {
        set(PROPERTY_INVOICEPRINTFORMAT, invoicePrintformat);
    }

    public Long getLastDays() {
        return (Long) get(PROPERTY_LASTDAYS);
    }

    public void setLastDays(Long lastDays) {
        set(PROPERTY_LASTDAYS, lastDays);
    }

    public BankAccount getBankaccount() {
        return (BankAccount) get(PROPERTY_BANKACCOUNT);
    }

    public void setBankaccount(BankAccount bankaccount) {
        set(PROPERTY_BANKACCOUNT, bankaccount);
    }

    public TaxCategory getBPTaxCategory() {
        return (TaxCategory) get(PROPERTY_BPTAXCATEGORY);
    }

    public void setBPTaxCategory(TaxCategory bPTaxCategory) {
        set(PROPERTY_BPTAXCATEGORY, bPTaxCategory);
    }

    public Long getFixmonthday68() {
        return (Long) get(PROPERTY_FIXMONTHDAY68);
    }

    public void setFixmonthday68(Long fixmonthday68) {
        set(PROPERTY_FIXMONTHDAY68, fixmonthday68);
    }

    public Long getFixmonthday269() {
        return (Long) get(PROPERTY_FIXMONTHDAY269);
    }

    public void setFixmonthday269(Long fixmonthday269) {
        set(PROPERTY_FIXMONTHDAY269, fixmonthday269);
    }

    public Long getFixmonthday370() {
        return (Long) get(PROPERTY_FIXMONTHDAY370);
    }

    public void setFixmonthday370(Long fixmonthday370) {
        set(PROPERTY_FIXMONTHDAY370, fixmonthday370);
    }

    public BankAccount getBankaccount71() {
        return (BankAccount) get(PROPERTY_BANKACCOUNT71);
    }

    public void setBankaccount71(BankAccount bankaccount71) {
        set(PROPERTY_BANKACCOUNT71, bankaccount71);
    }

    public TaxCategory getBpTaxcategory72() {
        return (TaxCategory) get(PROPERTY_BPTAXCATEGORY72);
    }

    public void setBpTaxcategory72(TaxCategory bpTaxcategory72) {
        set(PROPERTY_BPTAXCATEGORY72, bpTaxcategory72);
    }

    public String getFiscalcode() {
        return (String) get(PROPERTY_FISCALCODE);
    }

    public void setFiscalcode(String fiscalcode) {
        set(PROPERTY_FISCALCODE, fiscalcode);
    }

    public String getISOFiscalCode() {
        return (String) get(PROPERTY_ISOFISCALCODE);
    }

    public void setISOFiscalCode(String iSOFiscalCode) {
        set(PROPERTY_ISOFISCALCODE, iSOFiscalCode);
    }

    public Zssi_groupofcompanies getZssiGroupofcompanies() {
        return (Zssi_groupofcompanies) get(PROPERTY_ZSSIGROUPOFCOMPANIES);
    }

    public void setZssiGroupofcompanies(
        Zssi_groupofcompanies zssiGroupofcompanies) {
        set(PROPERTY_ZSSIGROUPOFCOMPANIES, zssiGroupofcompanies);
    }

    public String getCountry() {
        return (String) get(PROPERTY_COUNTRY);
    }

    public void setCountry(String country) {
        set(PROPERTY_COUNTRY, country);
    }

    public String getCity() {
        return (String) get(PROPERTY_CITY);
    }

    public void setCity(String city) {
        set(PROPERTY_CITY, city);
    }

    public String getZipcode() {
        return (String) get(PROPERTY_ZIPCODE);
    }

    public void setZipcode(String zipcode) {
        set(PROPERTY_ZIPCODE, zipcode);
    }

    public Boolean isSalesLead() {
        return (Boolean) get(PROPERTY_ISSALESLEAD);
    }

    public void setSalesLead(Boolean isSalesLead) {
        set(PROPERTY_ISSALESLEAD, isSalesLead);
    }

    public String getOwncodeatpartnersite() {
        return (String) get(PROPERTY_OWNCODEATPARTNERSITE);
    }

    public void setOwncodeatpartnersite(String owncodeatpartnersite) {
        set(PROPERTY_OWNCODEATPARTNERSITE, owncodeatpartnersite);
    }

    public Boolean isProjectmanager() {
        return (Boolean) get(PROPERTY_ISPROJECTMANAGER);
    }

    public void setProjectmanager(Boolean isprojectmanager) {
        set(PROPERTY_ISPROJECTMANAGER, isprojectmanager);
    }

    public Boolean isProcurementmanager() {
        return (Boolean) get(PROPERTY_ISPROCUREMENTMANAGER);
    }

    public void setProcurementmanager(Boolean isprocurementmanager) {
        set(PROPERTY_ISPROCUREMENTMANAGER, isprocurementmanager);
    }

    public String getExternalid() {
        return (String) get(PROPERTY_EXTERNALID);
    }

    public void setExternalid(String externalid) {
        set(PROPERTY_EXTERNALID, externalid);
    }

    public org.openbravo.model.common.businesspartner.c_lineofbusiness getLineofbusiness() {
        return (org.openbravo.model.common.businesspartner.c_lineofbusiness) get(PROPERTY_LINEOFBUSINESS);
    }

    public void setLineofbusiness(
        org.openbravo.model.common.businesspartner.c_lineofbusiness lineofbusiness) {
        set(PROPERTY_LINEOFBUSINESS, lineofbusiness);
    }

    public BigDecimal getApprovalamt() {
        return (BigDecimal) get(PROPERTY_APPROVALAMT);
    }

    public void setApprovalamt(BigDecimal approvalamt) {
        set(PROPERTY_APPROVALAMT, approvalamt);
    }

    public Boolean isApprover() {
        return (Boolean) get(PROPERTY_ISAPPROVER);
    }

    public void setApprover(Boolean isApprover) {
        set(PROPERTY_ISAPPROVER, isApprover);
    }

    public Boolean isPrapprover() {
        return (Boolean) get(PROPERTY_ISPRAPPROVER);
    }

    public void setPrapprover(Boolean isprapprover) {
        set(PROPERTY_ISPRAPPROVER, isprapprover);
    }

    public String getExternalsynccode() {
        return (String) get(PROPERTY_EXTERNALSYNCCODE);
    }

    public void setExternalsynccode(String externalsynccode) {
        set(PROPERTY_EXTERNALSYNCCODE, externalsynccode);
    }

    public Boolean isEcommerceactive() {
        return (Boolean) get(PROPERTY_ISECOMMERCEACTIVE);
    }

    public void setEcommerceactive(Boolean isecommerceactive) {
        set(PROPERTY_ISECOMMERCEACTIVE, isecommerceactive);
    }

    public Boolean isPaymentapprover() {
        return (Boolean) get(PROPERTY_ISPAYMENTAPPROVER);
    }

    public void setPaymentapprover(Boolean ispaymentapprover) {
        set(PROPERTY_ISPAYMENTAPPROVER, ispaymentapprover);
    }

    public Boolean isCreditcard() {
        return (Boolean) get(PROPERTY_ISCREDITCARD);
    }

    public void setCreditcard(Boolean isCreditcard) {
        set(PROPERTY_ISCREDITCARD, isCreditcard);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.businesspartner.c_bpartner_org> getBpartnerOrgList() {
        return (List<org.openbravo.model.common.businesspartner.c_bpartner_org>) get(PROPERTY_BPARTNERORGLIST);
    }

    public void setBpartnerOrgList(
        List<org.openbravo.model.common.businesspartner.c_bpartner_org> bpartnerOrgList) {
        set(PROPERTY_BPARTNERORGLIST, bpartnerOrgList);
    }

    @SuppressWarnings("unchecked")
    public List<User> getADUserList() {
        return (List<User>) get(PROPERTY_ADUSERLIST);
    }

    public void setADUserList(List<User> aDUserList) {
        set(PROPERTY_ADUSERLIST, aDUserList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.businesspartner.BankAccount> getBusinessPartnerBankAccountList() {
        return (List<org.openbravo.model.common.businesspartner.BankAccount>) get(PROPERTY_BUSINESSPARTNERBANKACCOUNTLIST);
    }

    public void setBusinessPartnerBankAccountList(
        List<org.openbravo.model.common.businesspartner.BankAccount> businessPartnerBankAccountList) {
        set(PROPERTY_BUSINESSPARTNERBANKACCOUNTLIST,
            businessPartnerBankAccountList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.utility.C_bpartneremployeeCALENDARSETTINGS> getBpartneremployeeCALENDARSETTINGSList() {
        return (List<org.openbravo.model.common.utility.C_bpartneremployeeCALENDARSETTINGS>) get(PROPERTY_BPARTNEREMPLOYEECALENDARSETTINGSLIST);
    }

    public void setBpartneremployeeCALENDARSETTINGSList(
        List<org.openbravo.model.common.utility.C_bpartneremployeeCALENDARSETTINGS> bpartneremployeeCALENDARSETTINGSList) {
        set(PROPERTY_BPARTNEREMPLOYEECALENDARSETTINGSLIST,
            bpartneremployeeCALENDARSETTINGSList);
    }

    @SuppressWarnings("unchecked")
    public List<EmployeeSalaryCategory> getEmployeeSalaryCategoryList() {
        return (List<EmployeeSalaryCategory>) get(PROPERTY_EMPLOYEESALARYCATEGORYLIST);
    }

    public void setEmployeeSalaryCategoryList(
        List<EmployeeSalaryCategory> employeeSalaryCategoryList) {
        set(PROPERTY_EMPLOYEESALARYCATEGORYLIST, employeeSalaryCategoryList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.pricing.volumediscount.BusinessPartner> getPricingVolumeDiscountBusinessPartnerList() {
        return (List<org.openbravo.model.pricing.volumediscount.BusinessPartner>) get(PROPERTY_PRICINGVOLUMEDISCOUNTBUSINESSPARTNERLIST);
    }

    public void setPricingVolumeDiscountBusinessPartnerList(
        List<org.openbravo.model.pricing.volumediscount.BusinessPartner> pricingVolumeDiscountBusinessPartnerList) {
        set(PROPERTY_PRICINGVOLUMEDISCOUNTBUSINESSPARTNERLIST,
            pricingVolumeDiscountBusinessPartnerList);
    }

    @SuppressWarnings("unchecked")
    public List<ApprovedVendor> getApprovedVendorList() {
        return (List<ApprovedVendor>) get(PROPERTY_APPROVEDVENDORLIST);
    }

    public void setApprovedVendorList(List<ApprovedVendor> approvedVendorList) {
        set(PROPERTY_APPROVEDVENDORLIST, approvedVendorList);
    }

    @SuppressWarnings("unchecked")
    public List<Notes4customer> getZssiNotes4customerList() {
        return (List<Notes4customer>) get(PROPERTY_ZSSINOTES4CUSTOMERLIST);
    }

    public void setZssiNotes4customerList(
        List<Notes4customer> zssiNotes4customerList) {
        set(PROPERTY_ZSSINOTES4CUSTOMERLIST, zssiNotes4customerList);
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
    public List<Sales2customer> getZssiSales2customerList() {
        return (List<Sales2customer>) get(PROPERTY_ZSSISALES2CUSTOMERLIST);
    }

    public void setZssiSales2customerList(
        List<Sales2customer> zssiSales2customerList) {
        set(PROPERTY_ZSSISALES2CUSTOMERLIST, zssiSales2customerList);
    }

    @SuppressWarnings("unchecked")
    public List<WarehouseShipper> getWarehouseShipperList() {
        return (List<WarehouseShipper>) get(PROPERTY_WAREHOUSESHIPPERLIST);
    }

    public void setWarehouseShipperList(
        List<WarehouseShipper> warehouseShipperList) {
        set(PROPERTY_WAREHOUSESHIPPERLIST, warehouseShipperList);
    }

    @SuppressWarnings("unchecked")
    public List<Asset> getFinancialMgmtAssetList() {
        return (List<Asset>) get(PROPERTY_FINANCIALMGMTASSETLIST);
    }

    public void setFinancialMgmtAssetList(List<Asset> financialMgmtAssetList) {
        set(PROPERTY_FINANCIALMGMTASSETLIST, financialMgmtAssetList);
    }

    @SuppressWarnings("unchecked")
    public List<SheetLineV> getTimeAndExpenseSheetLineVList() {
        return (List<SheetLineV>) get(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST);
    }

    public void setTimeAndExpenseSheetLineVList(
        List<SheetLineV> timeAndExpenseSheetLineVList) {
        set(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST, timeAndExpenseSheetLineVList);
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
    public List<SheetLine> getTimeAndExpenseSheetLineList() {
        return (List<SheetLine>) get(PROPERTY_TIMEANDEXPENSESHEETLINELIST);
    }

    public void setTimeAndExpenseSheetLineList(
        List<SheetLine> timeAndExpenseSheetLineList) {
        set(PROPERTY_TIMEANDEXPENSESHEETLINELIST, timeAndExpenseSheetLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Snr_serialnumbertracking> getSnrSerialnumbertrackingList() {
        return (List<Snr_serialnumbertracking>) get(PROPERTY_SNRSERIALNUMBERTRACKINGLIST);
    }

    public void setSnrSerialnumbertrackingList(
        List<Snr_serialnumbertracking> snrSerialnumbertrackingList) {
        set(PROPERTY_SNRSERIALNUMBERTRACKINGLIST, snrSerialnumbertrackingList);
    }

    @SuppressWarnings("unchecked")
    public List<Zse_ecommercegrant> getZseEcommercegrantList() {
        return (List<Zse_ecommercegrant>) get(PROPERTY_ZSEECOMMERCEGRANTLIST);
    }

    public void setZseEcommercegrantList(
        List<Zse_ecommercegrant> zseEcommercegrantList) {
        set(PROPERTY_ZSEECOMMERCEGRANTLIST, zseEcommercegrantList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.utility.c_employeecalendar_v> getEmployeecalendarVList() {
        return (List<org.openbravo.model.common.utility.c_employeecalendar_v>) get(PROPERTY_EMPLOYEECALENDARVLIST);
    }

    public void setEmployeecalendarVList(
        List<org.openbravo.model.common.utility.c_employeecalendar_v> employeecalendarVList) {
        set(PROPERTY_EMPLOYEECALENDARVLIST, employeecalendarVList);
    }

    @SuppressWarnings("unchecked")
    public List<Location> getBusinessPartnerLocationList() {
        return (List<Location>) get(PROPERTY_BUSINESSPARTNERLOCATIONLIST);
    }

    public void setBusinessPartnerLocationList(
        List<Location> businessPartnerLocationList) {
        set(PROPERTY_BUSINESSPARTNERLOCATIONLIST, businessPartnerLocationList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.sales.c_refinvoicetoorder_view> getRefinvoicetoorderViewList() {
        return (List<org.openbravo.model.sales.c_refinvoicetoorder_view>) get(PROPERTY_REFINVOICETOORDERVIEWLIST);
    }

    public void setRefinvoicetoorderViewList(
        List<org.openbravo.model.sales.c_refinvoicetoorder_view> refinvoicetoorderViewList) {
        set(PROPERTY_REFINVOICETOORDERVIEWLIST, refinvoicetoorderViewList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceList() {
        return (List<Invoice>) get(PROPERTY_INVOICELIST);
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        set(PROPERTY_INVOICELIST, invoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.utility.C_bpartneremployeeEVENT> getBpartneremployeeEVENTList() {
        return (List<org.openbravo.model.common.utility.C_bpartneremployeeEVENT>) get(PROPERTY_BPARTNEREMPLOYEEEVENTLIST);
    }

    public void setBpartneremployeeEVENTList(
        List<org.openbravo.model.common.utility.C_bpartneremployeeEVENT> bpartneremployeeEVENTList) {
        set(PROPERTY_BPARTNEREMPLOYEEEVENTLIST, bpartneremployeeEVENTList);
    }

    @SuppressWarnings("unchecked")
    public List<Withholding> getBusinessPartnerWithholdingList() {
        return (List<Withholding>) get(PROPERTY_BUSINESSPARTNERWITHHOLDINGLIST);
    }

    public void setBusinessPartnerWithholdingList(
        List<Withholding> businessPartnerWithholdingList) {
        set(PROPERTY_BUSINESSPARTNERWITHHOLDINGLIST,
            businessPartnerWithholdingList);
    }

    @SuppressWarnings("unchecked")
    public List<Bplsalesforecast> getBplSalesforecastList() {
        return (List<Bplsalesforecast>) get(PROPERTY_BPLSALESFORECASTLIST);
    }

    public void setBplSalesforecastList(
        List<Bplsalesforecast> bplSalesforecastList) {
        set(PROPERTY_BPLSALESFORECASTLIST, bplSalesforecastList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.zsoft.smartui.zssi_openshipment> getZssiOpenshipmentList() {
        return (List<org.openbravo.zsoft.smartui.zssi_openshipment>) get(PROPERTY_ZSSIOPENSHIPMENTLIST);
    }

    public void setZssiOpenshipmentList(
        List<org.openbravo.zsoft.smartui.zssi_openshipment> zssiOpenshipmentList) {
        set(PROPERTY_ZSSIOPENSHIPMENTLIST, zssiOpenshipmentList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.invoice.invoicecreditcardv> getInvoiceCreditcardVList() {
        return (List<org.openbravo.model.common.invoice.invoicecreditcardv>) get(PROPERTY_INVOICECREDITCARDVLIST);
    }

    public void setInvoiceCreditcardVList(
        List<org.openbravo.model.common.invoice.invoicecreditcardv> invoiceCreditcardVList) {
        set(PROPERTY_INVOICECREDITCARDVLIST, invoiceCreditcardVList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.zsoft.smartui.zssi_salesforecast> getZssiSalesforecastList() {
        return (List<org.openbravo.zsoft.smartui.zssi_salesforecast>) get(PROPERTY_ZSSISALESFORECASTLIST);
    }

    public void setZssiSalesforecastList(
        List<org.openbravo.zsoft.smartui.zssi_salesforecast> zssiSalesforecastList) {
        set(PROPERTY_ZSSISALESFORECASTLIST, zssiSalesforecastList);
    }
}
