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
package org.openbravo.model.common.plm;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.utility.Image;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.manufacturing.processplan.ProcessPlan;
import org.openbravo.model.materialmgmt.cost.Costing;
import org.openbravo.model.materialmgmt.onhandquantity.StorageDetail;
import org.openbravo.model.mrp.Mrpinoutplanv;
import org.openbravo.model.mrp.Planner;
import org.openbravo.model.mrp.PlanningMethod;
import org.openbravo.model.pricing.pricelist.ProductPrice;
import org.openbravo.model.shipping.FreightCategory;
import org.openbravo.model.timeandexpense.ExpenseType;
import org.openbravo.model.timeandexpense.Resource;
import org.openbravo.zsoft.smartui.Zssi_onhanqty;

import org.zsoft.ecommerce.Zse_product_shop;
import org.zsoft.serial.Snr_batchmasterdata;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity Product (stored in table M_Product).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Product extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Product";
    public static final String ENTITY_NAME = "Product";
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
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DOCUMENTNOTE = "documentNote";
    public static final String PROPERTY_HELP = "help";
    public static final String PROPERTY_UPC = "uPC";
    public static final String PROPERTY_SKU = "sKU";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_SALESREP = "salesRep";
    public static final String PROPERTY_ISSUMMARY = "isSummary";
    public static final String PROPERTY_ISSTOCKED = "isStocked";
    public static final String PROPERTY_ISPURCHASED = "isPurchased";
    public static final String PROPERTY_ISSOLD = "isSold";
    public static final String PROPERTY_ISBOM = "isBOM";
    public static final String PROPERTY_ISINVOICEPRINTDETAILS =
        "isInvoicePrintDetails";
    public static final String PROPERTY_ISPICKLISTPRINTDETAILS =
        "isPickListPrintDetails";
    public static final String PROPERTY_ISVERIFIED = "isVerified";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_CLASSIFICATION = "classification";
    public static final String PROPERTY_VOLUME = "volume";
    public static final String PROPERTY_WEIGHT = "weight";
    public static final String PROPERTY_SHELFWIDTH = "shelfWidth";
    public static final String PROPERTY_SHELFHEIGHT = "shelfHeight";
    public static final String PROPERTY_SHELFDEPTH = "shelfDepth";
    public static final String PROPERTY_UNITSPERPALLET = "unitsPerPallet";
    public static final String PROPERTY_RESOURCE = "resource";
    public static final String PROPERTY_DISCONTINUED = "discontinued";
    public static final String PROPERTY_DISCONTINUEDBY = "discontinuedBy";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_EXPENSETYPE = "expenseType";
    public static final String PROPERTY_PRODUCTTYPE = "productType";
    public static final String PROPERTY_IMAGEURL = "imageURL";
    public static final String PROPERTY_DESCRIPTIONURL = "descriptionURL";
    public static final String PROPERTY_GUARANTEEDAYS = "guaranteeDays";
    public static final String PROPERTY_VERSIONNO = "versionNo";
    public static final String PROPERTY_ATTRIBUTESET = "attributeSet";
    public static final String PROPERTY_ATTRIBUTESETINSTANCE =
        "attributeSetInstance";
    public static final String PROPERTY_DOWNLOADURL = "downloadURL";
    public static final String PROPERTY_FREIGHTCATEGORY = "freightCategory";
    public static final String PROPERTY_LOCATOR = "locator";
    public static final String PROPERTY_IMAGE = "image";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_ISPRICEPRINTED = "ispriceprinted";
    public static final String PROPERTY_NAME2 = "name2";
    public static final String PROPERTY_COSTTYPE = "costtype";
    public static final String PROPERTY_COSTSTD = "coststd";
    public static final String PROPERTY_STOCKMIN = "stockMin";
    public static final String PROPERTY_ENFORCEATTRIBUTE = "enforceAttribute";
    public static final String PROPERTY_CALCULATED = "calculated";
    public static final String PROPERTY_PROCESSPLAN = "processplan";
    public static final String PROPERTY_PRODUCTION = "production";
    public static final String PROPERTY_CAPACITY = "capacity";
    public static final String PROPERTY_DELAYMIN = "delaymin";
    public static final String PROPERTY_MRPPLANNER = "mRPPlanner";
    public static final String PROPERTY_MRPPLANNINGMETHOD = "mRPPlanningmethod";
    public static final String PROPERTY_QTYMAX = "qtymax";
    public static final String PROPERTY_QTYMIN = "qtymin";
    public static final String PROPERTY_QTYSTD = "qtystd";
    public static final String PROPERTY_QTYTYPE = "qtytype";
    public static final String PROPERTY_STOCKMIN67 = "stockmin67";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_TYPEOFPRODUCT = "typeofproduct";
    public static final String PROPERTY_ISSERVICEITEM = "isServiceItem";
    public static final String PROPERTY_ISCONSUMABLE = "isConsumable";
    public static final String PROPERTY_ISSPAREPART = "isSparePart";
    public static final String PROPERTY_BUTTONCOPYITEM = "buttoncopyitem";
    public static final String PROPERTY_SETREADY4PRODUCTION =
        "setready4production";
    public static final String PROPERTY_VENDORPRODUCTNO = "vendorProductNo";
    public static final String PROPERTY_BUTTONPRINTBOM = "buttonprintbom";
    public static final String PROPERTY_CUTOFF = "cutoff";
    public static final String PROPERTY_ISFREIGHTPRODUCT = "isFreightProduct";
    public static final String PROPERTY_ISSETITEM = "isSetItem";
    public static final String PROPERTY_ISSUMMARYITEM = "isSummaryItem";
    public static final String PROPERTY_ISSERIALTRACKING = "isSerialTracking";
    public static final String PROPERTY_LENGTH = "length";
    public static final String PROPERTY_WIDTH = "width";
    public static final String PROPERTY_COREDIAMETER = "coreDiameter";
    public static final String PROPERTY_COLORCOUNT = "colorcount";
    public static final String PROPERTY_TEXT = "text";
    public static final String PROPERTY_THEME = "theme";
    public static final String PROPERTY_PALETTETYPE = "palettetype";
    public static final String PROPERTY_CUSTOMERPRODUCTNO = "customerProductNo";
    public static final String PROPERTY_ISBATCHTRACKING = "isbatchtracking";
    public static final String PROPERTY_MANUFACTURER = "manufacturer";
    public static final String PROPERTY_MANUFACTURERNUMBER =
        "manufacturernumber";
    public static final String PROPERTY_PRODUCTACCOUNTSLIST =
        "productAccountsList";
    public static final String PROPERTY_PRODUCTSUBSTITUTELIST =
        "productSubstituteList";
    public static final String PROPERTY_PRODUCTCUSTOMERLIST =
        "productCustomerList";
    public static final String PROPERTY_PRODUCTORGLIST = "productOrgList";
    public static final String PROPERTY_PRODUCTTRLLIST = "productTrlList";
    public static final String PROPERTY_APPROVEDVENDORLIST =
        "approvedVendorList";
    public static final String PROPERTY_PRODUCTBOMLIST = "productBOMList";
    public static final String PROPERTY_REPLENISHLIST = "replenishList";
    public static final String PROPERTY_INDIRECTCOSTVALUEPRODUCTLIST =
        "indirectCostValueProductList";
    public static final String PROPERTY_SNRMASTERDATALIST = "sNRMasterdataList";
    public static final String PROPERTY_ZSEPRODUCTSHOPLIST =
        "zseProductShopList";
    public static final String PROPERTY_MATERIALMGMTCOSTINGLIST =
        "materialMgmtCostingList";
    public static final String PROPERTY_SNRCURRENTBOMVLIST =
        "snrCurrentbomVList";
    public static final String PROPERTY_SNRBATCHMASTERDATALIST =
        "snrBatchmasterdataList";
    public static final String PROPERTY_PRODUCTUOMLIST = "productUOMList";
    public static final String PROPERTY_MRPINOUTPLANVLIST = "mrpInoutplanVList";
    public static final String PROPERTY_MATERIALMGMTSTORAGEDETAILLIST =
        "materialMgmtStorageDetailList";
    public static final String PROPERTY_ZSSIONHANQTYLIST = "zssiOnhanqtyList";
    public static final String PROPERTY_PRICINGPRODUCTPRICELIST =
        "pricingProductPriceList";

    public Product() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISSUMMARY, false);
        setDefaultValue(PROPERTY_ISSTOCKED, true);
        setDefaultValue(PROPERTY_ISPURCHASED, true);
        setDefaultValue(PROPERTY_ISSOLD, true);
        setDefaultValue(PROPERTY_ISBOM, false);
        setDefaultValue(PROPERTY_ISINVOICEPRINTDETAILS, false);
        setDefaultValue(PROPERTY_ISPICKLISTPRINTDETAILS, false);
        setDefaultValue(PROPERTY_ISVERIFIED, false);
        setDefaultValue(PROPERTY_DISCONTINUED, false);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_PRODUCTTYPE, "I");
        setDefaultValue(PROPERTY_ISPRICEPRINTED, true);
        setDefaultValue(PROPERTY_ENFORCEATTRIBUTE, false);
        setDefaultValue(PROPERTY_CALCULATED, true);
        setDefaultValue(PROPERTY_PRODUCTION, false);
        setDefaultValue(PROPERTY_QTYTYPE, false);
        setDefaultValue(PROPERTY_TYPEOFPRODUCT, "ST");
        setDefaultValue(PROPERTY_ISSERVICEITEM, false);
        setDefaultValue(PROPERTY_ISCONSUMABLE, false);
        setDefaultValue(PROPERTY_ISSPAREPART, false);
        setDefaultValue(PROPERTY_BUTTONCOPYITEM, false);
        setDefaultValue(PROPERTY_SETREADY4PRODUCTION, false);
        setDefaultValue(PROPERTY_BUTTONPRINTBOM, false);
        setDefaultValue(PROPERTY_ISFREIGHTPRODUCT, false);
        setDefaultValue(PROPERTY_ISSETITEM, false);
        setDefaultValue(PROPERTY_ISSUMMARYITEM, false);
        setDefaultValue(PROPERTY_ISSERIALTRACKING, false);
        setDefaultValue(PROPERTY_ISBATCHTRACKING, false);
        setDefaultValue(PROPERTY_PRODUCTACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTSUBSTITUTELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTCUSTOMERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTORGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APPROVEDVENDORLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTBOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_REPLENISHLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INDIRECTCOSTVALUEPRODUCTLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_SNRMASTERDATALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSEPRODUCTSHOPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTCOSTINGLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_SNRCURRENTBOMVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SNRBATCHMASTERDATALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTUOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MRPINOUTPLANVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSTORAGEDETAILLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSSIONHANQTYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGPRODUCTPRICELIST,
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getDocumentNote() {
        return (String) get(PROPERTY_DOCUMENTNOTE);
    }

    public void setDocumentNote(String documentNote) {
        set(PROPERTY_DOCUMENTNOTE, documentNote);
    }

    public String getHelp() {
        return (String) get(PROPERTY_HELP);
    }

    public void setHelp(String help) {
        set(PROPERTY_HELP, help);
    }

    public String getUPC() {
        return (String) get(PROPERTY_UPC);
    }

    public void setUPC(String uPC) {
        set(PROPERTY_UPC, uPC);
    }

    public String getSKU() {
        return (String) get(PROPERTY_SKU);
    }

    public void setSKU(String sKU) {
        set(PROPERTY_SKU, sKU);
    }

    public org.openbravo.model.common.uom.UOM getUOM() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUOM(org.openbravo.model.common.uom.UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public User getSalesRep() {
        return (User) get(PROPERTY_SALESREP);
    }

    public void setSalesRep(User salesRep) {
        set(PROPERTY_SALESREP, salesRep);
    }

    public Boolean isSummary() {
        return (Boolean) get(PROPERTY_ISSUMMARY);
    }

    public void setSummary(Boolean isSummary) {
        set(PROPERTY_ISSUMMARY, isSummary);
    }

    public Boolean isStocked() {
        return (Boolean) get(PROPERTY_ISSTOCKED);
    }

    public void setStocked(Boolean isStocked) {
        set(PROPERTY_ISSTOCKED, isStocked);
    }

    public Boolean isPurchased() {
        return (Boolean) get(PROPERTY_ISPURCHASED);
    }

    public void setPurchased(Boolean isPurchased) {
        set(PROPERTY_ISPURCHASED, isPurchased);
    }

    public Boolean isSold() {
        return (Boolean) get(PROPERTY_ISSOLD);
    }

    public void setSold(Boolean isSold) {
        set(PROPERTY_ISSOLD, isSold);
    }

    public Boolean isBOM() {
        return (Boolean) get(PROPERTY_ISBOM);
    }

    public void setBOM(Boolean isBOM) {
        set(PROPERTY_ISBOM, isBOM);
    }

    public Boolean isInvoicePrintDetails() {
        return (Boolean) get(PROPERTY_ISINVOICEPRINTDETAILS);
    }

    public void setInvoicePrintDetails(Boolean isInvoicePrintDetails) {
        set(PROPERTY_ISINVOICEPRINTDETAILS, isInvoicePrintDetails);
    }

    public Boolean isPickListPrintDetails() {
        return (Boolean) get(PROPERTY_ISPICKLISTPRINTDETAILS);
    }

    public void setPickListPrintDetails(Boolean isPickListPrintDetails) {
        set(PROPERTY_ISPICKLISTPRINTDETAILS, isPickListPrintDetails);
    }

    public Boolean isVerified() {
        return (Boolean) get(PROPERTY_ISVERIFIED);
    }

    public void setVerified(Boolean isVerified) {
        set(PROPERTY_ISVERIFIED, isVerified);
    }

    public ProductCategory getProductCategory() {
        return (ProductCategory) get(PROPERTY_PRODUCTCATEGORY);
    }

    public void setProductCategory(ProductCategory productCategory) {
        set(PROPERTY_PRODUCTCATEGORY, productCategory);
    }

    public String getClassification() {
        return (String) get(PROPERTY_CLASSIFICATION);
    }

    public void setClassification(String classification) {
        set(PROPERTY_CLASSIFICATION, classification);
    }

    public BigDecimal getVolume() {
        return (BigDecimal) get(PROPERTY_VOLUME);
    }

    public void setVolume(BigDecimal volume) {
        set(PROPERTY_VOLUME, volume);
    }

    public BigDecimal getWeight() {
        return (BigDecimal) get(PROPERTY_WEIGHT);
    }

    public void setWeight(BigDecimal weight) {
        set(PROPERTY_WEIGHT, weight);
    }

    public BigDecimal getShelfWidth() {
        return (BigDecimal) get(PROPERTY_SHELFWIDTH);
    }

    public void setShelfWidth(BigDecimal shelfWidth) {
        set(PROPERTY_SHELFWIDTH, shelfWidth);
    }

    public BigDecimal getShelfHeight() {
        return (BigDecimal) get(PROPERTY_SHELFHEIGHT);
    }

    public void setShelfHeight(BigDecimal shelfHeight) {
        set(PROPERTY_SHELFHEIGHT, shelfHeight);
    }

    public BigDecimal getShelfDepth() {
        return (BigDecimal) get(PROPERTY_SHELFDEPTH);
    }

    public void setShelfDepth(BigDecimal shelfDepth) {
        set(PROPERTY_SHELFDEPTH, shelfDepth);
    }

    public Long getUnitsPerPallet() {
        return (Long) get(PROPERTY_UNITSPERPALLET);
    }

    public void setUnitsPerPallet(Long unitsPerPallet) {
        set(PROPERTY_UNITSPERPALLET, unitsPerPallet);
    }

    public Resource getResource() {
        return (Resource) get(PROPERTY_RESOURCE);
    }

    public void setResource(Resource resource) {
        set(PROPERTY_RESOURCE, resource);
    }

    public Boolean isDiscontinued() {
        return (Boolean) get(PROPERTY_DISCONTINUED);
    }

    public void setDiscontinued(Boolean discontinued) {
        set(PROPERTY_DISCONTINUED, discontinued);
    }

    public Date getDiscontinuedBy() {
        return (Date) get(PROPERTY_DISCONTINUEDBY);
    }

    public void setDiscontinuedBy(Date discontinuedBy) {
        set(PROPERTY_DISCONTINUEDBY, discontinuedBy);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public ExpenseType getExpenseType() {
        return (ExpenseType) get(PROPERTY_EXPENSETYPE);
    }

    public void setExpenseType(ExpenseType expenseType) {
        set(PROPERTY_EXPENSETYPE, expenseType);
    }

    public String getProductType() {
        return (String) get(PROPERTY_PRODUCTTYPE);
    }

    public void setProductType(String productType) {
        set(PROPERTY_PRODUCTTYPE, productType);
    }

    public String getImageURL() {
        return (String) get(PROPERTY_IMAGEURL);
    }

    public void setImageURL(String imageURL) {
        set(PROPERTY_IMAGEURL, imageURL);
    }

    public String getDescriptionURL() {
        return (String) get(PROPERTY_DESCRIPTIONURL);
    }

    public void setDescriptionURL(String descriptionURL) {
        set(PROPERTY_DESCRIPTIONURL, descriptionURL);
    }

    public Long getGuaranteeDays() {
        return (Long) get(PROPERTY_GUARANTEEDAYS);
    }

    public void setGuaranteeDays(Long guaranteeDays) {
        set(PROPERTY_GUARANTEEDAYS, guaranteeDays);
    }

    public String getVersionNo() {
        return (String) get(PROPERTY_VERSIONNO);
    }

    public void setVersionNo(String versionNo) {
        set(PROPERTY_VERSIONNO, versionNo);
    }

    public AttributeSet getAttributeSet() {
        return (AttributeSet) get(PROPERTY_ATTRIBUTESET);
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        set(PROPERTY_ATTRIBUTESET, attributeSet);
    }

    public AttributeSetInstance getAttributeSetInstance() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETINSTANCE);
    }

    public void setAttributeSetInstance(
        AttributeSetInstance attributeSetInstance) {
        set(PROPERTY_ATTRIBUTESETINSTANCE, attributeSetInstance);
    }

    public String getDownloadURL() {
        return (String) get(PROPERTY_DOWNLOADURL);
    }

    public void setDownloadURL(String downloadURL) {
        set(PROPERTY_DOWNLOADURL, downloadURL);
    }

    public FreightCategory getFreightCategory() {
        return (FreightCategory) get(PROPERTY_FREIGHTCATEGORY);
    }

    public void setFreightCategory(FreightCategory freightCategory) {
        set(PROPERTY_FREIGHTCATEGORY, freightCategory);
    }

    public Locator getLocator() {
        return (Locator) get(PROPERTY_LOCATOR);
    }

    public void setLocator(Locator locator) {
        set(PROPERTY_LOCATOR, locator);
    }

    public Image getImage() {
        return (Image) get(PROPERTY_IMAGE);
    }

    public void setImage(Image image) {
        set(PROPERTY_IMAGE, image);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public Boolean isPriceprinted() {
        return (Boolean) get(PROPERTY_ISPRICEPRINTED);
    }

    public void setPriceprinted(Boolean ispriceprinted) {
        set(PROPERTY_ISPRICEPRINTED, ispriceprinted);
    }

    public String getName2() {
        return (String) get(PROPERTY_NAME2);
    }

    public void setName2(String name2) {
        set(PROPERTY_NAME2, name2);
    }

    public String getCosttype() {
        return (String) get(PROPERTY_COSTTYPE);
    }

    public void setCosttype(String costtype) {
        set(PROPERTY_COSTTYPE, costtype);
    }

    public BigDecimal getCoststd() {
        return (BigDecimal) get(PROPERTY_COSTSTD);
    }

    public void setCoststd(BigDecimal coststd) {
        set(PROPERTY_COSTSTD, coststd);
    }

    public BigDecimal getStockMin() {
        return (BigDecimal) get(PROPERTY_STOCKMIN);
    }

    public void setStockMin(BigDecimal stockMin) {
        set(PROPERTY_STOCKMIN, stockMin);
    }

    public Boolean isEnforceAttribute() {
        return (Boolean) get(PROPERTY_ENFORCEATTRIBUTE);
    }

    public void setEnforceAttribute(Boolean enforceAttribute) {
        set(PROPERTY_ENFORCEATTRIBUTE, enforceAttribute);
    }

    public Boolean isCalculated() {
        return (Boolean) get(PROPERTY_CALCULATED);
    }

    public void setCalculated(Boolean calculated) {
        set(PROPERTY_CALCULATED, calculated);
    }

    public ProcessPlan getProcessplan() {
        return (ProcessPlan) get(PROPERTY_PROCESSPLAN);
    }

    public void setProcessplan(ProcessPlan processplan) {
        set(PROPERTY_PROCESSPLAN, processplan);
    }

    public Boolean isProduction() {
        return (Boolean) get(PROPERTY_PRODUCTION);
    }

    public void setProduction(Boolean production) {
        set(PROPERTY_PRODUCTION, production);
    }

    public BigDecimal getCapacity() {
        return (BigDecimal) get(PROPERTY_CAPACITY);
    }

    public void setCapacity(BigDecimal capacity) {
        set(PROPERTY_CAPACITY, capacity);
    }

    public BigDecimal getDelaymin() {
        return (BigDecimal) get(PROPERTY_DELAYMIN);
    }

    public void setDelaymin(BigDecimal delaymin) {
        set(PROPERTY_DELAYMIN, delaymin);
    }

    public Planner getMRPPlanner() {
        return (Planner) get(PROPERTY_MRPPLANNER);
    }

    public void setMRPPlanner(Planner mRPPlanner) {
        set(PROPERTY_MRPPLANNER, mRPPlanner);
    }

    public PlanningMethod getMRPPlanningmethod() {
        return (PlanningMethod) get(PROPERTY_MRPPLANNINGMETHOD);
    }

    public void setMRPPlanningmethod(PlanningMethod mRPPlanningmethod) {
        set(PROPERTY_MRPPLANNINGMETHOD, mRPPlanningmethod);
    }

    public BigDecimal getQtymax() {
        return (BigDecimal) get(PROPERTY_QTYMAX);
    }

    public void setQtymax(BigDecimal qtymax) {
        set(PROPERTY_QTYMAX, qtymax);
    }

    public BigDecimal getQtymin() {
        return (BigDecimal) get(PROPERTY_QTYMIN);
    }

    public void setQtymin(BigDecimal qtymin) {
        set(PROPERTY_QTYMIN, qtymin);
    }

    public BigDecimal getQtystd() {
        return (BigDecimal) get(PROPERTY_QTYSTD);
    }

    public void setQtystd(BigDecimal qtystd) {
        set(PROPERTY_QTYSTD, qtystd);
    }

    public Boolean isQtytype() {
        return (Boolean) get(PROPERTY_QTYTYPE);
    }

    public void setQtytype(Boolean qtytype) {
        set(PROPERTY_QTYTYPE, qtytype);
    }

    public BigDecimal getStockmin67() {
        return (BigDecimal) get(PROPERTY_STOCKMIN67);
    }

    public void setStockmin67(BigDecimal stockmin67) {
        set(PROPERTY_STOCKMIN67, stockmin67);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public String getTypeofproduct() {
        return (String) get(PROPERTY_TYPEOFPRODUCT);
    }

    public void setTypeofproduct(String typeofproduct) {
        set(PROPERTY_TYPEOFPRODUCT, typeofproduct);
    }

    public Boolean isServiceItem() {
        return (Boolean) get(PROPERTY_ISSERVICEITEM);
    }

    public void setServiceItem(Boolean isServiceItem) {
        set(PROPERTY_ISSERVICEITEM, isServiceItem);
    }

    public Boolean isConsumable() {
        return (Boolean) get(PROPERTY_ISCONSUMABLE);
    }

    public void setConsumable(Boolean isConsumable) {
        set(PROPERTY_ISCONSUMABLE, isConsumable);
    }

    public Boolean isSparePart() {
        return (Boolean) get(PROPERTY_ISSPAREPART);
    }

    public void setSparePart(Boolean isSparePart) {
        set(PROPERTY_ISSPAREPART, isSparePart);
    }

    public Boolean isButtoncopyitem() {
        return (Boolean) get(PROPERTY_BUTTONCOPYITEM);
    }

    public void setButtoncopyitem(Boolean buttoncopyitem) {
        set(PROPERTY_BUTTONCOPYITEM, buttoncopyitem);
    }

    public Boolean isSetready4production() {
        return (Boolean) get(PROPERTY_SETREADY4PRODUCTION);
    }

    public void setSetready4production(Boolean setready4production) {
        set(PROPERTY_SETREADY4PRODUCTION, setready4production);
    }

    public String getVendorProductNo() {
        return (String) get(PROPERTY_VENDORPRODUCTNO);
    }

    public void setVendorProductNo(String vendorProductNo) {
        set(PROPERTY_VENDORPRODUCTNO, vendorProductNo);
    }

    public Boolean isButtonprintbom() {
        return (Boolean) get(PROPERTY_BUTTONPRINTBOM);
    }

    public void setButtonprintbom(Boolean buttonprintbom) {
        set(PROPERTY_BUTTONPRINTBOM, buttonprintbom);
    }

    public Long getCutoff() {
        return (Long) get(PROPERTY_CUTOFF);
    }

    public void setCutoff(Long cutoff) {
        set(PROPERTY_CUTOFF, cutoff);
    }

    public Boolean isFreightProduct() {
        return (Boolean) get(PROPERTY_ISFREIGHTPRODUCT);
    }

    public void setFreightProduct(Boolean isFreightProduct) {
        set(PROPERTY_ISFREIGHTPRODUCT, isFreightProduct);
    }

    public Boolean isSetItem() {
        return (Boolean) get(PROPERTY_ISSETITEM);
    }

    public void setSetItem(Boolean isSetItem) {
        set(PROPERTY_ISSETITEM, isSetItem);
    }

    public Boolean isSummaryItem() {
        return (Boolean) get(PROPERTY_ISSUMMARYITEM);
    }

    public void setSummaryItem(Boolean isSummaryItem) {
        set(PROPERTY_ISSUMMARYITEM, isSummaryItem);
    }

    public Boolean isSerialTracking() {
        return (Boolean) get(PROPERTY_ISSERIALTRACKING);
    }

    public void setSerialTracking(Boolean isSerialTracking) {
        set(PROPERTY_ISSERIALTRACKING, isSerialTracking);
    }

    public BigDecimal getLength() {
        return (BigDecimal) get(PROPERTY_LENGTH);
    }

    public void setLength(BigDecimal length) {
        set(PROPERTY_LENGTH, length);
    }

    public BigDecimal getWidth() {
        return (BigDecimal) get(PROPERTY_WIDTH);
    }

    public void setWidth(BigDecimal width) {
        set(PROPERTY_WIDTH, width);
    }

    public BigDecimal getCoreDiameter() {
        return (BigDecimal) get(PROPERTY_COREDIAMETER);
    }

    public void setCoreDiameter(BigDecimal coreDiameter) {
        set(PROPERTY_COREDIAMETER, coreDiameter);
    }

    public Long getColorcount() {
        return (Long) get(PROPERTY_COLORCOUNT);
    }

    public void setColorcount(Long colorcount) {
        set(PROPERTY_COLORCOUNT, colorcount);
    }

    public String getText() {
        return (String) get(PROPERTY_TEXT);
    }

    public void setText(String text) {
        set(PROPERTY_TEXT, text);
    }

    public String getTheme() {
        return (String) get(PROPERTY_THEME);
    }

    public void setTheme(String theme) {
        set(PROPERTY_THEME, theme);
    }

    public String getPalettetype() {
        return (String) get(PROPERTY_PALETTETYPE);
    }

    public void setPalettetype(String palettetype) {
        set(PROPERTY_PALETTETYPE, palettetype);
    }

    public String getCustomerProductNo() {
        return (String) get(PROPERTY_CUSTOMERPRODUCTNO);
    }

    public void setCustomerProductNo(String customerProductNo) {
        set(PROPERTY_CUSTOMERPRODUCTNO, customerProductNo);
    }

    public Boolean isBatchtracking() {
        return (Boolean) get(PROPERTY_ISBATCHTRACKING);
    }

    public void setBatchtracking(Boolean isbatchtracking) {
        set(PROPERTY_ISBATCHTRACKING, isbatchtracking);
    }

    public String getManufacturer() {
        return (String) get(PROPERTY_MANUFACTURER);
    }

    public void setManufacturer(String manufacturer) {
        set(PROPERTY_MANUFACTURER, manufacturer);
    }

    public String getManufacturernumber() {
        return (String) get(PROPERTY_MANUFACTURERNUMBER);
    }

    public void setManufacturernumber(String manufacturernumber) {
        set(PROPERTY_MANUFACTURERNUMBER, manufacturernumber);
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
    public List<ProductSubstitute> getProductSubstituteList() {
        return (List<ProductSubstitute>) get(PROPERTY_PRODUCTSUBSTITUTELIST);
    }

    public void setProductSubstituteList(
        List<ProductSubstitute> productSubstituteList) {
        set(PROPERTY_PRODUCTSUBSTITUTELIST, productSubstituteList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductCustomer> getProductCustomerList() {
        return (List<ProductCustomer>) get(PROPERTY_PRODUCTCUSTOMERLIST);
    }

    public void setProductCustomerList(
        List<ProductCustomer> productCustomerList) {
        set(PROPERTY_PRODUCTCUSTOMERLIST, productCustomerList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductOrg> getProductOrgList() {
        return (List<ProductOrg>) get(PROPERTY_PRODUCTORGLIST);
    }

    public void setProductOrgList(List<ProductOrg> productOrgList) {
        set(PROPERTY_PRODUCTORGLIST, productOrgList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductTrl> getProductTrlList() {
        return (List<ProductTrl>) get(PROPERTY_PRODUCTTRLLIST);
    }

    public void setProductTrlList(List<ProductTrl> productTrlList) {
        set(PROPERTY_PRODUCTTRLLIST, productTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<ApprovedVendor> getApprovedVendorList() {
        return (List<ApprovedVendor>) get(PROPERTY_APPROVEDVENDORLIST);
    }

    public void setApprovedVendorList(List<ApprovedVendor> approvedVendorList) {
        set(PROPERTY_APPROVEDVENDORLIST, approvedVendorList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductBOM> getProductBOMList() {
        return (List<ProductBOM>) get(PROPERTY_PRODUCTBOMLIST);
    }

    public void setProductBOMList(List<ProductBOM> productBOMList) {
        set(PROPERTY_PRODUCTBOMLIST, productBOMList);
    }

    @SuppressWarnings("unchecked")
    public List<Replenish> getReplenishList() {
        return (List<Replenish>) get(PROPERTY_REPLENISHLIST);
    }

    public void setReplenishList(List<Replenish> replenishList) {
        set(PROPERTY_REPLENISHLIST, replenishList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.manufacturing.cost.ma_indirect_cost_value_product> getIndirectCostValueProductList() {
        return (List<org.openbravo.model.manufacturing.cost.ma_indirect_cost_value_product>) get(PROPERTY_INDIRECTCOSTVALUEPRODUCTLIST);
    }

    public void setIndirectCostValueProductList(
        List<org.openbravo.model.manufacturing.cost.ma_indirect_cost_value_product> indirectCostValueProductList) {
        set(PROPERTY_INDIRECTCOSTVALUEPRODUCTLIST, indirectCostValueProductList);
    }

    @SuppressWarnings("unchecked")
    public List<org.zsoft.serial.snr_masterdata> getSNRMasterdataList() {
        return (List<org.zsoft.serial.snr_masterdata>) get(PROPERTY_SNRMASTERDATALIST);
    }

    public void setSNRMasterdataList(
        List<org.zsoft.serial.snr_masterdata> sNRMasterdataList) {
        set(PROPERTY_SNRMASTERDATALIST, sNRMasterdataList);
    }

    @SuppressWarnings("unchecked")
    public List<Zse_product_shop> getZseProductShopList() {
        return (List<Zse_product_shop>) get(PROPERTY_ZSEPRODUCTSHOPLIST);
    }

    public void setZseProductShopList(List<Zse_product_shop> zseProductShopList) {
        set(PROPERTY_ZSEPRODUCTSHOPLIST, zseProductShopList);
    }

    @SuppressWarnings("unchecked")
    public List<Costing> getMaterialMgmtCostingList() {
        return (List<Costing>) get(PROPERTY_MATERIALMGMTCOSTINGLIST);
    }

    public void setMaterialMgmtCostingList(
        List<Costing> materialMgmtCostingList) {
        set(PROPERTY_MATERIALMGMTCOSTINGLIST, materialMgmtCostingList);
    }

    @SuppressWarnings("unchecked")
    public List<org.zsoft.serial.snr_currentbom_v> getSnrCurrentbomVList() {
        return (List<org.zsoft.serial.snr_currentbom_v>) get(PROPERTY_SNRCURRENTBOMVLIST);
    }

    public void setSnrCurrentbomVList(
        List<org.zsoft.serial.snr_currentbom_v> snrCurrentbomVList) {
        set(PROPERTY_SNRCURRENTBOMVLIST, snrCurrentbomVList);
    }

    @SuppressWarnings("unchecked")
    public List<Snr_batchmasterdata> getSnrBatchmasterdataList() {
        return (List<Snr_batchmasterdata>) get(PROPERTY_SNRBATCHMASTERDATALIST);
    }

    public void setSnrBatchmasterdataList(
        List<Snr_batchmasterdata> snrBatchmasterdataList) {
        set(PROPERTY_SNRBATCHMASTERDATALIST, snrBatchmasterdataList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductUOM> getProductUOMList() {
        return (List<ProductUOM>) get(PROPERTY_PRODUCTUOMLIST);
    }

    public void setProductUOMList(List<ProductUOM> productUOMList) {
        set(PROPERTY_PRODUCTUOMLIST, productUOMList);
    }

    @SuppressWarnings("unchecked")
    public List<Mrpinoutplanv> getMrpInoutplanVList() {
        return (List<Mrpinoutplanv>) get(PROPERTY_MRPINOUTPLANVLIST);
    }

    public void setMrpInoutplanVList(List<Mrpinoutplanv> mrpInoutplanVList) {
        set(PROPERTY_MRPINOUTPLANVLIST, mrpInoutplanVList);
    }

    @SuppressWarnings("unchecked")
    public List<StorageDetail> getMaterialMgmtStorageDetailList() {
        return (List<StorageDetail>) get(PROPERTY_MATERIALMGMTSTORAGEDETAILLIST);
    }

    public void setMaterialMgmtStorageDetailList(
        List<StorageDetail> materialMgmtStorageDetailList) {
        set(PROPERTY_MATERIALMGMTSTORAGEDETAILLIST,
            materialMgmtStorageDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<Zssi_onhanqty> getZssiOnhanqtyList() {
        return (List<Zssi_onhanqty>) get(PROPERTY_ZSSIONHANQTYLIST);
    }

    public void setZssiOnhanqtyList(List<Zssi_onhanqty> zssiOnhanqtyList) {
        set(PROPERTY_ZSSIONHANQTYLIST, zssiOnhanqtyList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductPrice> getPricingProductPriceList() {
        return (List<ProductPrice>) get(PROPERTY_PRICINGPRODUCTPRICELIST);
    }

    public void setPricingProductPriceList(
        List<ProductPrice> pricingProductPriceList) {
        set(PROPERTY_PRICINGPRODUCTPRICELIST, pricingProductPriceList);
    }
}
