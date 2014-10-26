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
package org.openbravo.model.ad.system;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.utility.Image;
import org.openbravo.model.ad.utility.Tree;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;
import org.openbravo.model.financialmgmt.calendar.Calendar;
import org.openbravo.model.pricing.pricelist.PriceList;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity ClientInformation (stored in table AD_ClientInfo).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ClientInformation extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_ClientInfo";
    public static final String ENTITY_NAME = "ClientInformation";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ISDISCOUNTLINEAMT = "isDiscountLineAmt";
    public static final String PROPERTY_CALENDAR = "calendar";
    public static final String PROPERTY_ACCTSCHEMA1 = "acctSchema1";
    public static final String PROPERTY_ACCT2ACTIVE = "acct2Active";
    public static final String PROPERTY_ACCTSCHEMA2 = "acctSchema2";
    public static final String PROPERTY_ACCT3ACTIVE = "acct3Active";
    public static final String PROPERTY_ACCTSCHEMA3 = "acctSchema3";
    public static final String PROPERTY_UOMVOLUME = "uOMVolume";
    public static final String PROPERTY_UOMWEIGHT = "uOMWeight";
    public static final String PROPERTY_UOMLENGTH = "uOMLength";
    public static final String PROPERTY_UOMTIME = "uOMTime";
    public static final String PROPERTY_TREEMENU = "treeMenu";
    public static final String PROPERTY_TREEORG = "treeOrg";
    public static final String PROPERTY_TREEBPARTNER = "treeBPartner";
    public static final String PROPERTY_TREEPROJECT = "treeProject";
    public static final String PROPERTY_TREESALESREGION = "treeSalesRegion";
    public static final String PROPERTY_TREEPRODUCT = "treeProduct";
    public static final String PROPERTY_PRODUCTFREIGHT = "productFreight";
    public static final String PROPERTY_BPARTNERCASHTRX = "bPartnerCashTrx";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_ALLOWNEGATIVESTOCK =
        "allowNegativeStock";
    public static final String PROPERTY_CHECKORDERORG = "checkorderorg";
    public static final String PROPERTY_CHECKINOUTORG = "checkinoutorg";
    public static final String PROPERTY_GROUPACCTINVLINES = "groupacctinvlines";
    public static final String PROPERTY_YOURCOMPANYMENUIMAGE =
        "yourCompanyMenuImage";
    public static final String PROPERTY_YOURCOMPANYBIGIMAGE =
        "yourCompanyBigImage";
    public static final String PROPERTY_YOURCOMPANYDOCUMENTIMAGE =
        "yourCompanyDocumentImage";
    public static final String PROPERTY_CLIENT = "client";

    public ClientInformation() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISDISCOUNTLINEAMT, false);
        setDefaultValue(PROPERTY_ACCT2ACTIVE, false);
        setDefaultValue(PROPERTY_ACCT3ACTIVE, false);
        setDefaultValue(PROPERTY_ALLOWNEGATIVESTOCK, true);
        setDefaultValue(PROPERTY_CHECKORDERORG, true);
        setDefaultValue(PROPERTY_CHECKINOUTORG, true);
        setDefaultValue(PROPERTY_GROUPACCTINVLINES, false);
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

    public Boolean isDiscountLineAmt() {
        return (Boolean) get(PROPERTY_ISDISCOUNTLINEAMT);
    }

    public void setDiscountLineAmt(Boolean isDiscountLineAmt) {
        set(PROPERTY_ISDISCOUNTLINEAMT, isDiscountLineAmt);
    }

    public Calendar getCalendar() {
        return (Calendar) get(PROPERTY_CALENDAR);
    }

    public void setCalendar(Calendar calendar) {
        set(PROPERTY_CALENDAR, calendar);
    }

    public AcctSchema getAcctSchema1() {
        return (AcctSchema) get(PROPERTY_ACCTSCHEMA1);
    }

    public void setAcctSchema1(AcctSchema acctSchema1) {
        set(PROPERTY_ACCTSCHEMA1, acctSchema1);
    }

    public Boolean isAcct2Active() {
        return (Boolean) get(PROPERTY_ACCT2ACTIVE);
    }

    public void setAcct2Active(Boolean acct2Active) {
        set(PROPERTY_ACCT2ACTIVE, acct2Active);
    }

    public AcctSchema getAcctSchema2() {
        return (AcctSchema) get(PROPERTY_ACCTSCHEMA2);
    }

    public void setAcctSchema2(AcctSchema acctSchema2) {
        set(PROPERTY_ACCTSCHEMA2, acctSchema2);
    }

    public Boolean isAcct3Active() {
        return (Boolean) get(PROPERTY_ACCT3ACTIVE);
    }

    public void setAcct3Active(Boolean acct3Active) {
        set(PROPERTY_ACCT3ACTIVE, acct3Active);
    }

    public AcctSchema getAcctSchema3() {
        return (AcctSchema) get(PROPERTY_ACCTSCHEMA3);
    }

    public void setAcctSchema3(AcctSchema acctSchema3) {
        set(PROPERTY_ACCTSCHEMA3, acctSchema3);
    }

    public org.openbravo.model.common.uom.UOM getUOMVolume() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOMVOLUME);
    }

    public void setUOMVolume(org.openbravo.model.common.uom.UOM uOMVolume) {
        set(PROPERTY_UOMVOLUME, uOMVolume);
    }

    public org.openbravo.model.common.uom.UOM getUOMWeight() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOMWEIGHT);
    }

    public void setUOMWeight(org.openbravo.model.common.uom.UOM uOMWeight) {
        set(PROPERTY_UOMWEIGHT, uOMWeight);
    }

    public org.openbravo.model.common.uom.UOM getUOMLength() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOMLENGTH);
    }

    public void setUOMLength(org.openbravo.model.common.uom.UOM uOMLength) {
        set(PROPERTY_UOMLENGTH, uOMLength);
    }

    public org.openbravo.model.common.uom.UOM getUOMTime() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOMTIME);
    }

    public void setUOMTime(org.openbravo.model.common.uom.UOM uOMTime) {
        set(PROPERTY_UOMTIME, uOMTime);
    }

    public Tree getTreeMenu() {
        return (Tree) get(PROPERTY_TREEMENU);
    }

    public void setTreeMenu(Tree treeMenu) {
        set(PROPERTY_TREEMENU, treeMenu);
    }

    public Tree getTreeOrg() {
        return (Tree) get(PROPERTY_TREEORG);
    }

    public void setTreeOrg(Tree treeOrg) {
        set(PROPERTY_TREEORG, treeOrg);
    }

    public Tree getTreeBPartner() {
        return (Tree) get(PROPERTY_TREEBPARTNER);
    }

    public void setTreeBPartner(Tree treeBPartner) {
        set(PROPERTY_TREEBPARTNER, treeBPartner);
    }

    public Tree getTreeProject() {
        return (Tree) get(PROPERTY_TREEPROJECT);
    }

    public void setTreeProject(Tree treeProject) {
        set(PROPERTY_TREEPROJECT, treeProject);
    }

    public Tree getTreeSalesRegion() {
        return (Tree) get(PROPERTY_TREESALESREGION);
    }

    public void setTreeSalesRegion(Tree treeSalesRegion) {
        set(PROPERTY_TREESALESREGION, treeSalesRegion);
    }

    public Tree getTreeProduct() {
        return (Tree) get(PROPERTY_TREEPRODUCT);
    }

    public void setTreeProduct(Tree treeProduct) {
        set(PROPERTY_TREEPRODUCT, treeProduct);
    }

    public Product getProductFreight() {
        return (Product) get(PROPERTY_PRODUCTFREIGHT);
    }

    public void setProductFreight(Product productFreight) {
        set(PROPERTY_PRODUCTFREIGHT, productFreight);
    }

    public BusinessPartner getBPartnerCashTrx() {
        return (BusinessPartner) get(PROPERTY_BPARTNERCASHTRX);
    }

    public void setBPartnerCashTrx(BusinessPartner bPartnerCashTrx) {
        set(PROPERTY_BPARTNERCASHTRX, bPartnerCashTrx);
    }

    public PriceList getPriceList() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(PriceList priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public Boolean isAllowNegativeStock() {
        return (Boolean) get(PROPERTY_ALLOWNEGATIVESTOCK);
    }

    public void setAllowNegativeStock(Boolean allowNegativeStock) {
        set(PROPERTY_ALLOWNEGATIVESTOCK, allowNegativeStock);
    }

    public Boolean isCheckorderorg() {
        return (Boolean) get(PROPERTY_CHECKORDERORG);
    }

    public void setCheckorderorg(Boolean checkorderorg) {
        set(PROPERTY_CHECKORDERORG, checkorderorg);
    }

    public Boolean isCheckinoutorg() {
        return (Boolean) get(PROPERTY_CHECKINOUTORG);
    }

    public void setCheckinoutorg(Boolean checkinoutorg) {
        set(PROPERTY_CHECKINOUTORG, checkinoutorg);
    }

    public Boolean isGroupacctinvlines() {
        return (Boolean) get(PROPERTY_GROUPACCTINVLINES);
    }

    public void setGroupacctinvlines(Boolean groupacctinvlines) {
        set(PROPERTY_GROUPACCTINVLINES, groupacctinvlines);
    }

    public Image getYourCompanyMenuImage() {
        return (Image) get(PROPERTY_YOURCOMPANYMENUIMAGE);
    }

    public void setYourCompanyMenuImage(Image yourCompanyMenuImage) {
        set(PROPERTY_YOURCOMPANYMENUIMAGE, yourCompanyMenuImage);
    }

    public Image getYourCompanyBigImage() {
        return (Image) get(PROPERTY_YOURCOMPANYBIGIMAGE);
    }

    public void setYourCompanyBigImage(Image yourCompanyBigImage) {
        set(PROPERTY_YOURCOMPANYBIGIMAGE, yourCompanyBigImage);
    }

    public Image getYourCompanyDocumentImage() {
        return (Image) get(PROPERTY_YOURCOMPANYDOCUMENTIMAGE);
    }

    public void setYourCompanyDocumentImage(Image yourCompanyDocumentImage) {
        set(PROPERTY_YOURCOMPANYDOCUMENTIMAGE, yourCompanyDocumentImage);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }
}
