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
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.cashmgmt.CashJournalLine;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.project.Project;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity InvoiceLineCreditcardV (stored in table C_Invoiceline_Creditcard_V).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class InvoicelineCreditcardV extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Invoiceline_Creditcard_V";
    public static final String ENTITY_NAME = "InvoiceLineCreditcardV";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_INVOICELINE = "invoiceline";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_INVOICECREDITCARDV =
        "invoiceCreditcardV";
    public static final String PROPERTY_ORDERLINE = "orderline";
    public static final String PROPERTY_INOUTLINE = "inoutline";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_QTYINVOICED = "qtyInvoiced";
    public static final String PROPERTY_PRICEACTUAL = "priceActual";
    public static final String PROPERTY_LINENETAMT = "lineNetAmt";
    public static final String PROPERTY_UOM = "uom";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_ISGROSSPRICE = "isGrossPrice";
    public static final String PROPERTY_LINEGROSSAMT = "lineGrossAmt";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_HASVOUCHER = "hasVoucher";
    public static final String PROPERTY_VOUCHERDATE = "voucherDate";
    public static final String PROPERTY_CASHLINE = "cashline";
    public static final String PROPERTY_USER = "user";

    public InvoicelineCreditcardV() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_QTYINVOICED, (long) 1);
        setDefaultValue(PROPERTY_ISGROSSPRICE, true);
        setDefaultValue(PROPERTY_HASVOUCHER, false);
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

    public String getInvoiceline() {
        return (String) get(PROPERTY_INVOICELINE);
    }

    public void setInvoiceline(String invoiceline) {
        set(PROPERTY_INVOICELINE, invoiceline);
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

    public org.openbravo.model.common.invoice.invoicecreditcardv getInvoiceCreditcardV() {
        return (org.openbravo.model.common.invoice.invoicecreditcardv) get(PROPERTY_INVOICECREDITCARDV);
    }

    public void setInvoiceCreditcardV(
        org.openbravo.model.common.invoice.invoicecreditcardv invoiceCreditcardV) {
        set(PROPERTY_INVOICECREDITCARDV, invoiceCreditcardV);
    }

    public OrderLine getOrderline() {
        return (OrderLine) get(PROPERTY_ORDERLINE);
    }

    public void setOrderline(OrderLine orderline) {
        set(PROPERTY_ORDERLINE, orderline);
    }

    public ShipmentInOutLine getInoutline() {
        return (ShipmentInOutLine) get(PROPERTY_INOUTLINE);
    }

    public void setInoutline(ShipmentInOutLine inoutline) {
        set(PROPERTY_INOUTLINE, inoutline);
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

    public Long getQtyInvoiced() {
        return (Long) get(PROPERTY_QTYINVOICED);
    }

    public void setQtyInvoiced(Long qtyInvoiced) {
        set(PROPERTY_QTYINVOICED, qtyInvoiced);
    }

    public BigDecimal getPriceActual() {
        return (BigDecimal) get(PROPERTY_PRICEACTUAL);
    }

    public void setPriceActual(BigDecimal priceActual) {
        set(PROPERTY_PRICEACTUAL, priceActual);
    }

    public BigDecimal getLineNetAmt() {
        return (BigDecimal) get(PROPERTY_LINENETAMT);
    }

    public void setLineNetAmt(BigDecimal lineNetAmt) {
        set(PROPERTY_LINENETAMT, lineNetAmt);
    }

    public org.openbravo.model.common.uom.UOM getUom() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUom(org.openbravo.model.common.uom.UOM uom) {
        set(PROPERTY_UOM, uom);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public Boolean isGrossPrice() {
        return (Boolean) get(PROPERTY_ISGROSSPRICE);
    }

    public void setGrossPrice(Boolean isGrossPrice) {
        set(PROPERTY_ISGROSSPRICE, isGrossPrice);
    }

    public BigDecimal getLineGrossAmt() {
        return (BigDecimal) get(PROPERTY_LINEGROSSAMT);
    }

    public void setLineGrossAmt(BigDecimal lineGrossAmt) {
        set(PROPERTY_LINEGROSSAMT, lineGrossAmt);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public Boolean isHasVoucher() {
        return (Boolean) get(PROPERTY_HASVOUCHER);
    }

    public void setHasVoucher(Boolean hasVoucher) {
        set(PROPERTY_HASVOUCHER, hasVoucher);
    }

    public Date getVoucherDate() {
        return (Date) get(PROPERTY_VOUCHERDATE);
    }

    public void setVoucherDate(Date voucherDate) {
        set(PROPERTY_VOUCHERDATE, voucherDate);
    }

    public CashJournalLine getCashline() {
        return (CashJournalLine) get(PROPERTY_CASHLINE);
    }

    public void setCashline(CashJournalLine cashline) {
        set(PROPERTY_CASHLINE, cashline);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }
}
