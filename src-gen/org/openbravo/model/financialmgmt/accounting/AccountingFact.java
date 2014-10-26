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
package org.openbravo.model.financialmgmt.accounting;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Location;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;
import org.openbravo.model.financialmgmt.accounting.coa.ElementValue;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.financialmgmt.gl.GLCategory;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.financialmgmt.tax.Withholding;
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
 * Entity class for entity FinancialMgmtAccountingFact (stored in table Fact_Acct).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class AccountingFact extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Fact_Acct";
    public static final String ENTITY_NAME = "FinancialMgmtAccountingFact";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACCTSCHEMA = "acctSchema";
    public static final String PROPERTY_ACCOUNT = "account";
    public static final String PROPERTY_DATETRX = "dateTrx";
    public static final String PROPERTY_DATEACCT = "dateAcct";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_RECORD = "record";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_LOCATOR = "locator";
    public static final String PROPERTY_POSTINGTYPE = "postingType";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_AMTSOURCEDR = "amtSourceDr";
    public static final String PROPERTY_AMTSOURCECR = "amtSourceCr";
    public static final String PROPERTY_AMTACCTDR = "amtAcctDr";
    public static final String PROPERTY_AMTACCTCR = "amtAcctCr";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_QTY = "qty";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_ORGTRX = "orgTrx";
    public static final String PROPERTY_LOCFROM = "locFrom";
    public static final String PROPERTY_LOCTO = "locTo";
    public static final String PROPERTY_SALESREGION = "salesRegion";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_USER1 = "user1";
    public static final String PROPERTY_USER2 = "user2";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_FACTACCTGROUP = "factAcctGroup";
    public static final String PROPERTY_SEQNO = "seqNo";
    public static final String PROPERTY_FACTACCTTYPE = "factAcctType";
    public static final String PROPERTY_DOCBASETYPE = "docBaseType";
    public static final String PROPERTY_ACCTVALUE = "acctValue";
    public static final String PROPERTY_ACCTDESCRIPTION = "acctDescription";
    public static final String PROPERTY_RECORDID2 = "recordID2";
    public static final String PROPERTY_WITHHOLDING = "withholding";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_UIDNUMBER = "uidnumber";

    public AccountingFact() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_FACTACCTTYPE, false);
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

    public AcctSchema getAcctSchema() {
        return (AcctSchema) get(PROPERTY_ACCTSCHEMA);
    }

    public void setAcctSchema(AcctSchema acctSchema) {
        set(PROPERTY_ACCTSCHEMA, acctSchema);
    }

    public ElementValue getAccount() {
        return (ElementValue) get(PROPERTY_ACCOUNT);
    }

    public void setAccount(ElementValue account) {
        set(PROPERTY_ACCOUNT, account);
    }

    public Date getDateTrx() {
        return (Date) get(PROPERTY_DATETRX);
    }

    public void setDateTrx(Date dateTrx) {
        set(PROPERTY_DATETRX, dateTrx);
    }

    public Date getDateAcct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateAcct(Date dateAcct) {
        set(PROPERTY_DATEACCT, dateAcct);
    }

    public Period getPeriod() {
        return (Period) get(PROPERTY_PERIOD);
    }

    public void setPeriod(Period period) {
        set(PROPERTY_PERIOD, period);
    }

    public Table getTable() {
        return (Table) get(PROPERTY_TABLE);
    }

    public void setTable(Table table) {
        set(PROPERTY_TABLE, table);
    }

    public String getRecord() {
        return (String) get(PROPERTY_RECORD);
    }

    public void setRecord(String record) {
        set(PROPERTY_RECORD, record);
    }

    public String getLine() {
        return (String) get(PROPERTY_LINE);
    }

    public void setLine(String line) {
        set(PROPERTY_LINE, line);
    }

    public GLCategory getCategory() {
        return (GLCategory) get(PROPERTY_CATEGORY);
    }

    public void setCategory(GLCategory category) {
        set(PROPERTY_CATEGORY, category);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public Locator getLocator() {
        return (Locator) get(PROPERTY_LOCATOR);
    }

    public void setLocator(Locator locator) {
        set(PROPERTY_LOCATOR, locator);
    }

    public String getPostingType() {
        return (String) get(PROPERTY_POSTINGTYPE);
    }

    public void setPostingType(String postingType) {
        set(PROPERTY_POSTINGTYPE, postingType);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public BigDecimal getAmtSourceDr() {
        return (BigDecimal) get(PROPERTY_AMTSOURCEDR);
    }

    public void setAmtSourceDr(BigDecimal amtSourceDr) {
        set(PROPERTY_AMTSOURCEDR, amtSourceDr);
    }

    public BigDecimal getAmtSourceCr() {
        return (BigDecimal) get(PROPERTY_AMTSOURCECR);
    }

    public void setAmtSourceCr(BigDecimal amtSourceCr) {
        set(PROPERTY_AMTSOURCECR, amtSourceCr);
    }

    public BigDecimal getAmtAcctDr() {
        return (BigDecimal) get(PROPERTY_AMTACCTDR);
    }

    public void setAmtAcctDr(BigDecimal amtAcctDr) {
        set(PROPERTY_AMTACCTDR, amtAcctDr);
    }

    public BigDecimal getAmtAcctCr() {
        return (BigDecimal) get(PROPERTY_AMTACCTCR);
    }

    public void setAmtAcctCr(BigDecimal amtAcctCr) {
        set(PROPERTY_AMTACCTCR, amtAcctCr);
    }

    public org.openbravo.model.common.uom.UOM getUOM() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUOM(org.openbravo.model.common.uom.UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public BigDecimal getQty() {
        return (BigDecimal) get(PROPERTY_QTY);
    }

    public void setQty(BigDecimal qty) {
        set(PROPERTY_QTY, qty);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public Organization getOrgTrx() {
        return (Organization) get(PROPERTY_ORGTRX);
    }

    public void setOrgTrx(Organization orgTrx) {
        set(PROPERTY_ORGTRX, orgTrx);
    }

    public Location getLocFrom() {
        return (Location) get(PROPERTY_LOCFROM);
    }

    public void setLocFrom(Location locFrom) {
        set(PROPERTY_LOCFROM, locFrom);
    }

    public Location getLocTo() {
        return (Location) get(PROPERTY_LOCTO);
    }

    public void setLocTo(Location locTo) {
        set(PROPERTY_LOCTO, locTo);
    }

    public SalesRegion getSalesRegion() {
        return (SalesRegion) get(PROPERTY_SALESREGION);
    }

    public void setSalesRegion(SalesRegion salesRegion) {
        set(PROPERTY_SALESREGION, salesRegion);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Campaign getCampaign() {
        return (Campaign) get(PROPERTY_CAMPAIGN);
    }

    public void setCampaign(Campaign campaign) {
        set(PROPERTY_CAMPAIGN, campaign);
    }

    public ABCActivity getActivity() {
        return (ABCActivity) get(PROPERTY_ACTIVITY);
    }

    public void setActivity(ABCActivity activity) {
        set(PROPERTY_ACTIVITY, activity);
    }

    public String getUser1() {
        return (String) get(PROPERTY_USER1);
    }

    public void setUser1(String user1) {
        set(PROPERTY_USER1, user1);
    }

    public String getUser2() {
        return (String) get(PROPERTY_USER2);
    }

    public void setUser2(String user2) {
        set(PROPERTY_USER2, user2);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public String getFactAcctGroup() {
        return (String) get(PROPERTY_FACTACCTGROUP);
    }

    public void setFactAcctGroup(String factAcctGroup) {
        set(PROPERTY_FACTACCTGROUP, factAcctGroup);
    }

    public Long getSeqNo() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqNo(Long seqNo) {
        set(PROPERTY_SEQNO, seqNo);
    }

    public Boolean isFactAcctType() {
        return (Boolean) get(PROPERTY_FACTACCTTYPE);
    }

    public void setFactAcctType(Boolean factAcctType) {
        set(PROPERTY_FACTACCTTYPE, factAcctType);
    }

    public String getDocBaseType() {
        return (String) get(PROPERTY_DOCBASETYPE);
    }

    public void setDocBaseType(String docBaseType) {
        set(PROPERTY_DOCBASETYPE, docBaseType);
    }

    public String getAcctValue() {
        return (String) get(PROPERTY_ACCTVALUE);
    }

    public void setAcctValue(String acctValue) {
        set(PROPERTY_ACCTVALUE, acctValue);
    }

    public String getAcctDescription() {
        return (String) get(PROPERTY_ACCTDESCRIPTION);
    }

    public void setAcctDescription(String acctDescription) {
        set(PROPERTY_ACCTDESCRIPTION, acctDescription);
    }

    public String getRecordID2() {
        return (String) get(PROPERTY_RECORDID2);
    }

    public void setRecordID2(String recordID2) {
        set(PROPERTY_RECORDID2, recordID2);
    }

    public Withholding getWithholding() {
        return (Withholding) get(PROPERTY_WITHHOLDING);
    }

    public void setWithholding(Withholding withholding) {
        set(PROPERTY_WITHHOLDING, withholding);
    }

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public String getUidnumber() {
        return (String) get(PROPERTY_UIDNUMBER);
    }

    public void setUidnumber(String uidnumber) {
        set(PROPERTY_UIDNUMBER, uidnumber);
    }
}
