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
package org.openbravo.model.sales;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductUOM;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.gl.GLCharge;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.pricing.priceadjustment.PriceAdjustment;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.project.ProjectTask;
import org.openbravo.model.shipping.ShippingCompany;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity c_subscriptionintervallines_view (stored in table c_subscriptionintervallines_view).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class c_subscriptionintervallines_view extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "c_subscriptionintervallines_view";
    public static final String ENTITY_NAME = "c_subscriptionintervallines_view";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ORDERLINE = "orderLine";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SUBSCRIPTIONINTERVALVIEW =
        "subscriptionintervalView";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_BPARTNERLOCATION = "bPartnerLocation";
    public static final String PROPERTY_DATEORDERED = "dateOrdered";
    public static final String PROPERTY_DATEPROMISED = "datePromised";
    public static final String PROPERTY_DATEDELIVERED = "dateDelivered";
    public static final String PROPERTY_DATEINVOICED = "dateInvoiced";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_DIRECTSHIP = "directShip";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_QTYORDERED = "qtyOrdered";
    public static final String PROPERTY_QTYRESERVED = "qtyReserved";
    public static final String PROPERTY_QTYDELIVERED = "qtyDelivered";
    public static final String PROPERTY_QTYINVOICED = "qtyInvoiced";
    public static final String PROPERTY_SHIPPER = "shipper";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_PRICEACTUAL = "priceActual";
    public static final String PROPERTY_PRICELIMIT = "priceLimit";
    public static final String PROPERTY_LINENETAMT = "lineNetAmt";
    public static final String PROPERTY_DISCOUNT = "discount";
    public static final String PROPERTY_FREIGHTAMT = "freightAmt";
    public static final String PROPERTY_CHARGE = "charge";
    public static final String PROPERTY_CHARGEAMT = "chargeAmt";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_RESOURCEASSIGNMENT =
        "resourceAssignment";
    public static final String PROPERTY_REFORDERLINE = "refOrderLine";
    public static final String PROPERTY_ATTRIBUTESETINSTANCE =
        "attributeSetInstance";
    public static final String PROPERTY_ISDESCRIPTION = "isDescription";
    public static final String PROPERTY_QUANTITYORDER = "quantityOrder";
    public static final String PROPERTY_PRODUCTUOM = "productUom";
    public static final String PROPERTY_OFFER = "offer";
    public static final String PROPERTY_PRICESTD = "priceStd";
    public static final String PROPERTY_CANCELPRICEAD = "cANCELPRICEAD";
    public static final String PROPERTY_LINEGROSSAMT = "linegrossamt";
    public static final String PROPERTY_LINETAXAMT = "linetaxamt";
    public static final String PROPERTY_ISGROSSPRICE = "isgrossprice";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_PROJECTPHASE = "projectphase";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_ISSUMMARYITEM = "issummaryitem";
    public static final String PROPERTY_ISONETIMEPOSITION = "isonetimeposition";
    public static final String PROPERTY_INVOICEDAMT = "invoicedamt";
    public static final String PROPERTY_IGNORERESIDUE = "ignoreresidue";
    public static final String PROPERTY_SCHEDDELIVERYDATE = "scheddeliverydate";

    public c_subscriptionintervallines_view() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_DIRECTSHIP, false);
        setDefaultValue(PROPERTY_QTYORDERED, new BigDecimal(1));
        setDefaultValue(PROPERTY_DISCOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_CHARGEAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISDESCRIPTION, false);
        setDefaultValue(PROPERTY_PRICESTD, new BigDecimal(0));
        setDefaultValue(PROPERTY_CANCELPRICEAD, false);
        setDefaultValue(PROPERTY_ISGROSSPRICE, false);
        setDefaultValue(PROPERTY_ISSUMMARYITEM, false);
        setDefaultValue(PROPERTY_ISONETIMEPOSITION, false);
        setDefaultValue(PROPERTY_INVOICEDAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_IGNORERESIDUE, false);
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

    public String getOrderLine() {
        return (String) get(PROPERTY_ORDERLINE);
    }

    public void setOrderLine(String orderLine) {
        set(PROPERTY_ORDERLINE, orderLine);
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

    public Order getSubscriptionintervalView() {
        return (Order) get(PROPERTY_SUBSCRIPTIONINTERVALVIEW);
    }

    public void setSubscriptionintervalView(Order subscriptionintervalView) {
        set(PROPERTY_SUBSCRIPTIONINTERVALVIEW, subscriptionintervalView);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public Location getBPartnerLocation() {
        return (Location) get(PROPERTY_BPARTNERLOCATION);
    }

    public void setBPartnerLocation(Location bPartnerLocation) {
        set(PROPERTY_BPARTNERLOCATION, bPartnerLocation);
    }

    public Date getDateOrdered() {
        return (Date) get(PROPERTY_DATEORDERED);
    }

    public void setDateOrdered(Date dateOrdered) {
        set(PROPERTY_DATEORDERED, dateOrdered);
    }

    public Date getDatePromised() {
        return (Date) get(PROPERTY_DATEPROMISED);
    }

    public void setDatePromised(Date datePromised) {
        set(PROPERTY_DATEPROMISED, datePromised);
    }

    public Date getDateDelivered() {
        return (Date) get(PROPERTY_DATEDELIVERED);
    }

    public void setDateDelivered(Date dateDelivered) {
        set(PROPERTY_DATEDELIVERED, dateDelivered);
    }

    public Date getDateInvoiced() {
        return (Date) get(PROPERTY_DATEINVOICED);
    }

    public void setDateInvoiced(Date dateInvoiced) {
        set(PROPERTY_DATEINVOICED, dateInvoiced);
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

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public Boolean isDirectShip() {
        return (Boolean) get(PROPERTY_DIRECTSHIP);
    }

    public void setDirectShip(Boolean directShip) {
        set(PROPERTY_DIRECTSHIP, directShip);
    }

    public org.openbravo.model.common.uom.UOM getUOM() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUOM(org.openbravo.model.common.uom.UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public BigDecimal getQtyOrdered() {
        return (BigDecimal) get(PROPERTY_QTYORDERED);
    }

    public void setQtyOrdered(BigDecimal qtyOrdered) {
        set(PROPERTY_QTYORDERED, qtyOrdered);
    }

    public BigDecimal getQtyReserved() {
        return (BigDecimal) get(PROPERTY_QTYRESERVED);
    }

    public void setQtyReserved(BigDecimal qtyReserved) {
        set(PROPERTY_QTYRESERVED, qtyReserved);
    }

    public BigDecimal getQtyDelivered() {
        return (BigDecimal) get(PROPERTY_QTYDELIVERED);
    }

    public void setQtyDelivered(BigDecimal qtyDelivered) {
        set(PROPERTY_QTYDELIVERED, qtyDelivered);
    }

    public BigDecimal getQtyInvoiced() {
        return (BigDecimal) get(PROPERTY_QTYINVOICED);
    }

    public void setQtyInvoiced(BigDecimal qtyInvoiced) {
        set(PROPERTY_QTYINVOICED, qtyInvoiced);
    }

    public ShippingCompany getShipper() {
        return (ShippingCompany) get(PROPERTY_SHIPPER);
    }

    public void setShipper(ShippingCompany shipper) {
        set(PROPERTY_SHIPPER, shipper);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
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

    public BigDecimal getDiscount() {
        return (BigDecimal) get(PROPERTY_DISCOUNT);
    }

    public void setDiscount(BigDecimal discount) {
        set(PROPERTY_DISCOUNT, discount);
    }

    public BigDecimal getFreightAmt() {
        return (BigDecimal) get(PROPERTY_FREIGHTAMT);
    }

    public void setFreightAmt(BigDecimal freightAmt) {
        set(PROPERTY_FREIGHTAMT, freightAmt);
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

    public OrderLine getRefOrderLine() {
        return (OrderLine) get(PROPERTY_REFORDERLINE);
    }

    public void setRefOrderLine(OrderLine refOrderLine) {
        set(PROPERTY_REFORDERLINE, refOrderLine);
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

    public Boolean isCANCELPRICEAD() {
        return (Boolean) get(PROPERTY_CANCELPRICEAD);
    }

    public void setCANCELPRICEAD(Boolean cANCELPRICEAD) {
        set(PROPERTY_CANCELPRICEAD, cANCELPRICEAD);
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

    public Boolean isGrossprice() {
        return (Boolean) get(PROPERTY_ISGROSSPRICE);
    }

    public void setGrossprice(Boolean isgrossprice) {
        set(PROPERTY_ISGROSSPRICE, isgrossprice);
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

    public Boolean isSummaryitem() {
        return (Boolean) get(PROPERTY_ISSUMMARYITEM);
    }

    public void setSummaryitem(Boolean issummaryitem) {
        set(PROPERTY_ISSUMMARYITEM, issummaryitem);
    }

    public Boolean isOnetimeposition() {
        return (Boolean) get(PROPERTY_ISONETIMEPOSITION);
    }

    public void setOnetimeposition(Boolean isonetimeposition) {
        set(PROPERTY_ISONETIMEPOSITION, isonetimeposition);
    }

    public BigDecimal getInvoicedamt() {
        return (BigDecimal) get(PROPERTY_INVOICEDAMT);
    }

    public void setInvoicedamt(BigDecimal invoicedamt) {
        set(PROPERTY_INVOICEDAMT, invoicedamt);
    }

    public Boolean isIgnoreresidue() {
        return (Boolean) get(PROPERTY_IGNORERESIDUE);
    }

    public void setIgnoreresidue(Boolean ignoreresidue) {
        set(PROPERTY_IGNORERESIDUE, ignoreresidue);
    }

    public Date getScheddeliverydate() {
        return (Date) get(PROPERTY_SCHEDDELIVERYDATE);
    }

    public void setScheddeliverydate(Date scheddeliverydate) {
        set(PROPERTY_SCHEDDELIVERYDATE, scheddeliverydate);
    }
}
