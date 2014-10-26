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
package org.openbravo.model.common.invoice;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductUOM;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.gl.GLCharge;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.pricing.priceadjustment.PriceAdjustment;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.project.ProjectTask;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity InvoiceLine (stored in table C_InvoiceLine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class InvoiceLine extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_InvoiceLine";
    public static final String ENTITY_NAME = "InvoiceLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_ORDERLINE = "orderLine";
    public static final String PROPERTY_INOUTLINE = "inOutLine";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_QTYINVOICED = "qtyInvoiced";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_PRICEACTUAL = "priceActual";
    public static final String PROPERTY_PRICELIMIT = "priceLimit";
    public static final String PROPERTY_LINENETAMT = "lineNetAmt";
    public static final String PROPERTY_CHARGE = "charge";
    public static final String PROPERTY_CHARGEAMT = "chargeAmt";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_RESOURCEASSIGNMENT =
        "resourceAssignment";
    public static final String PROPERTY_TAXAMT = "taxAmt";
    public static final String PROPERTY_ATTRIBUTESETINSTANCE =
        "attributeSetInstance";
    public static final String PROPERTY_ISDESCRIPTION = "isDescription";
    public static final String PROPERTY_QUANTITYORDER = "quantityOrder";
    public static final String PROPERTY_PRODUCTUOM = "productUom";
    public static final String PROPERTY_OFFER = "offer";
    public static final String PROPERTY_PRICESTD = "priceStd";
    public static final String PROPERTY_EXCLUDEFORWITHHOLDING =
        "excludeforwithholding";
    public static final String PROPERTY_ISGROSSPRICE = "isgrossprice";
    public static final String PROPERTY_LINEGROSSAMT = "linegrossamt";
    public static final String PROPERTY_LINETAXAMT = "linetaxamt";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_PROJECTPHASE = "projectphase";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_REINVOICEDBY = "reinvoicedby";
    public static final String PROPERTY_NORECHARGE = "norecharge";
    public static final String PROPERTY_NORECHARGECOMMENT = "norechargecomment";
    public static final String PROPERTY_HASVOUCHER = "hasvoucher";
    public static final String PROPERTY_VOUCHERDATE = "voucherdate";
    public static final String PROPERTY_INVOICELINEOFFERLIST =
        "invoiceLineOfferList";
    public static final String PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST =
        "invoiceLineAccountingDimensionList";
    public static final String PROPERTY_ZSPMRECHARGEVIEWLIST =
        "zspmRechargeViewList";

    public InvoiceLine() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_QTYINVOICED, new BigDecimal(1));
        setDefaultValue(PROPERTY_ISDESCRIPTION, false);
        setDefaultValue(PROPERTY_PRICESTD, new BigDecimal(0));
        setDefaultValue(PROPERTY_EXCLUDEFORWITHHOLDING, false);
        setDefaultValue(PROPERTY_LINEGROSSAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_LINETAXAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_NORECHARGE, "N");
        setDefaultValue(PROPERTY_HASVOUCHER, false);
        setDefaultValue(PROPERTY_INVOICELINEOFFERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSPMRECHARGEVIEWLIST, new ArrayList<Object>());
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

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public OrderLine getOrderLine() {
        return (OrderLine) get(PROPERTY_ORDERLINE);
    }

    public void setOrderLine(OrderLine orderLine) {
        set(PROPERTY_ORDERLINE, orderLine);
    }

    public ShipmentInOutLine getInOutLine() {
        return (ShipmentInOutLine) get(PROPERTY_INOUTLINE);
    }

    public void setInOutLine(ShipmentInOutLine inOutLine) {
        set(PROPERTY_INOUTLINE, inOutLine);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getQtyInvoiced() {
        return (BigDecimal) get(PROPERTY_QTYINVOICED);
    }

    public void setQtyInvoiced(BigDecimal qtyInvoiced) {
        set(PROPERTY_QTYINVOICED, qtyInvoiced);
    }

    public BigDecimal getPriceList() {
        return (BigDecimal) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(BigDecimal priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public BigDecimal getPriceActual() {
        return (BigDecimal) get(PROPERTY_PRICEACTUAL);
    }

    public void setPriceActual(BigDecimal priceActual) {
        set(PROPERTY_PRICEACTUAL, priceActual);
    }

    public BigDecimal getPriceLimit() {
        return (BigDecimal) get(PROPERTY_PRICELIMIT);
    }

    public void setPriceLimit(BigDecimal priceLimit) {
        set(PROPERTY_PRICELIMIT, priceLimit);
    }

    public BigDecimal getLineNetAmt() {
        return (BigDecimal) get(PROPERTY_LINENETAMT);
    }

    public void setLineNetAmt(BigDecimal lineNetAmt) {
        set(PROPERTY_LINENETAMT, lineNetAmt);
    }

    public GLCharge getCharge() {
        return (GLCharge) get(PROPERTY_CHARGE);
    }

    public void setCharge(GLCharge charge) {
        set(PROPERTY_CHARGE, charge);
    }

    public BigDecimal getChargeAmt() {
        return (BigDecimal) get(PROPERTY_CHARGEAMT);
    }

    public void setChargeAmt(BigDecimal chargeAmt) {
        set(PROPERTY_CHARGEAMT, chargeAmt);
    }

    public org.openbravo.model.common.uom.UOM getUOM() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUOM(org.openbravo.model.common.uom.UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public String getResourceAssignment() {
        return (String) get(PROPERTY_RESOURCEASSIGNMENT);
    }

    public void setResourceAssignment(String resourceAssignment) {
        set(PROPERTY_RESOURCEASSIGNMENT, resourceAssignment);
    }

    public BigDecimal getTaxAmt() {
        return (BigDecimal) get(PROPERTY_TAXAMT);
    }

    public void setTaxAmt(BigDecimal taxAmt) {
        set(PROPERTY_TAXAMT, taxAmt);
    }

    public AttributeSetInstance getAttributeSetInstance() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETINSTANCE);
    }

    public void setAttributeSetInstance(
        AttributeSetInstance attributeSetInstance) {
        set(PROPERTY_ATTRIBUTESETINSTANCE, attributeSetInstance);
    }

    public Boolean isDescription() {
        return (Boolean) get(PROPERTY_ISDESCRIPTION);
    }

    public void setDescription(Boolean isDescription) {
        set(PROPERTY_ISDESCRIPTION, isDescription);
    }

    public BigDecimal getQuantityOrder() {
        return (BigDecimal) get(PROPERTY_QUANTITYORDER);
    }

    public void setQuantityOrder(BigDecimal quantityOrder) {
        set(PROPERTY_QUANTITYORDER, quantityOrder);
    }

    public ProductUOM getProductUom() {
        return (ProductUOM) get(PROPERTY_PRODUCTUOM);
    }

    public void setProductUom(ProductUOM productUom) {
        set(PROPERTY_PRODUCTUOM, productUom);
    }

    public PriceAdjustment getOffer() {
        return (PriceAdjustment) get(PROPERTY_OFFER);
    }

    public void setOffer(PriceAdjustment offer) {
        set(PROPERTY_OFFER, offer);
    }

    public BigDecimal getPriceStd() {
        return (BigDecimal) get(PROPERTY_PRICESTD);
    }

    public void setPriceStd(BigDecimal priceStd) {
        set(PROPERTY_PRICESTD, priceStd);
    }

    public Boolean isExcludeforwithholding() {
        return (Boolean) get(PROPERTY_EXCLUDEFORWITHHOLDING);
    }

    public void setExcludeforwithholding(Boolean excludeforwithholding) {
        set(PROPERTY_EXCLUDEFORWITHHOLDING, excludeforwithholding);
    }

    public Boolean isGrossprice() {
        return (Boolean) get(PROPERTY_ISGROSSPRICE);
    }

    public void setGrossprice(Boolean isgrossprice) {
        set(PROPERTY_ISGROSSPRICE, isgrossprice);
    }

    public BigDecimal getLinegrossamt() {
        return (BigDecimal) get(PROPERTY_LINEGROSSAMT);
    }

    public void setLinegrossamt(BigDecimal linegrossamt) {
        set(PROPERTY_LINEGROSSAMT, linegrossamt);
    }

    public BigDecimal getLinetaxamt() {
        return (BigDecimal) get(PROPERTY_LINETAXAMT);
    }

    public void setLinetaxamt(BigDecimal linetaxamt) {
        set(PROPERTY_LINETAXAMT, linetaxamt);
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

    public InvoiceLine getReinvoicedby() {
        return (InvoiceLine) get(PROPERTY_REINVOICEDBY);
    }

    public void setReinvoicedby(InvoiceLine reinvoicedby) {
        set(PROPERTY_REINVOICEDBY, reinvoicedby);
    }

    public String getNorecharge() {
        return (String) get(PROPERTY_NORECHARGE);
    }

    public void setNorecharge(String norecharge) {
        set(PROPERTY_NORECHARGE, norecharge);
    }

    public String getNorechargecomment() {
        return (String) get(PROPERTY_NORECHARGECOMMENT);
    }

    public void setNorechargecomment(String norechargecomment) {
        set(PROPERTY_NORECHARGECOMMENT, norechargecomment);
    }

    public Boolean isHasvoucher() {
        return (Boolean) get(PROPERTY_HASVOUCHER);
    }

    public void setHasvoucher(Boolean hasvoucher) {
        set(PROPERTY_HASVOUCHER, hasvoucher);
    }

    public Date getVoucherdate() {
        return (Date) get(PROPERTY_VOUCHERDATE);
    }

    public void setVoucherdate(Date voucherdate) {
        set(PROPERTY_VOUCHERDATE, voucherdate);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLineOffer> getInvoiceLineOfferList() {
        return (List<InvoiceLineOffer>) get(PROPERTY_INVOICELINEOFFERLIST);
    }

    public void setInvoiceLineOfferList(
        List<InvoiceLineOffer> invoiceLineOfferList) {
        set(PROPERTY_INVOICELINEOFFERLIST, invoiceLineOfferList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLineAccountingDimension> getInvoiceLineAccountingDimensionList() {
        return (List<InvoiceLineAccountingDimension>) get(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST);
    }

    public void setInvoiceLineAccountingDimensionList(
        List<InvoiceLineAccountingDimension> invoiceLineAccountingDimensionList) {
        set(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST,
            invoiceLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.zsoft.projects.zspm_recharge_view> getZspmRechargeViewList() {
        return (List<org.openbravo.zsoft.projects.zspm_recharge_view>) get(PROPERTY_ZSPMRECHARGEVIEWLIST);
    }

    public void setZspmRechargeViewList(
        List<org.openbravo.zsoft.projects.zspm_recharge_view> zspmRechargeViewList) {
        set(PROPERTY_ZSPMRECHARGEVIEWLIST, zspmRechargeViewList);
    }
}
