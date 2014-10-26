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
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Location;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.cashmgmt.CashJournalLine;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.project.Project;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity InvoiceCreditcardLineV (stored in table C_Invoice_Creditcard_Line_V).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class cinvoicecreditcardlinev extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Invoice_Creditcard_Line_V";
    public static final String ENTITY_NAME = "InvoiceCreditcardLineV";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_INVOICELINECREDITCARDV =
        "invoicelineCreditcardV";
    public static final String PROPERTY_INVOICECREDITCARDV =
        "invoiceCreditcardV";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ISSOTRX = "isSOTrx";
    public static final String PROPERTY_INVOICEDOCUMENTNO = "invoiceDocumentNo";
    public static final String PROPERTY_DOCSTATUS = "docStatus";
    public static final String PROPERTY_DOCACTION = "docAction";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DATEACCT = "dateAcct";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_BPARTNERLOCATION = "bpartnerLocation";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_PAYMENTRULE = "paymentRule";
    public static final String PROPERTY_PAYMENTTERM = "paymentTerm";
    public static final String PROPERTY_TOTALLINES = "totalLines";
    public static final String PROPERTY_GRANDTOTAL = "grandTotal";
    public static final String PROPERTY_PRICELIST = "pricelist";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_ISGROSSINVOICE = "isGrossInvoice";
    public static final String PROPERTY_INTERNALNOTE = "internalNote";
    public static final String PROPERTY_LINEISACTIVE = "lineIsActive";
    public static final String PROPERTY_LINECREATED = "lineCreated";
    public static final String PROPERTY_LINECREATEDBY = "lineCreatedBy";
    public static final String PROPERTY_LINEUPDATED = "lineUpdated";
    public static final String PROPERTY_LINEUPDATEDBY = "lineUpdatedBy";
    public static final String PROPERTY_ORDERLINE = "orderline";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_LINEDESCRIPTION = "lineDescription";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_QTYINVOICED = "qtyInvoiced";
    public static final String PROPERTY_PRICEACTUAL = "priceActual";
    public static final String PROPERTY_LINENETAMT = "lineNetAmt";
    public static final String PROPERTY_UOM = "uom";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_LINEGROSSAMT = "lineGrossAmt";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_HASVOUCHER = "hasVoucher";
    public static final String PROPERTY_VOUCHERDATE = "voucherDate";
    public static final String PROPERTY_CASHLINE = "cashline";
    public static final String PROPERTY_LINEADUSER = "lineAdUser";

    public cinvoicecreditcardlinev() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISSOTRX, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_ISGROSSINVOICE, false);
        setDefaultValue(PROPERTY_LINEISACTIVE, false);
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

    public InvoicelineCreditcardV getInvoicelineCreditcardV() {
        return (InvoicelineCreditcardV) get(PROPERTY_INVOICELINECREDITCARDV);
    }

    public void setInvoicelineCreditcardV(
        InvoicelineCreditcardV invoicelineCreditcardV) {
        set(PROPERTY_INVOICELINECREDITCARDV, invoicelineCreditcardV);
    }

    public org.openbravo.model.common.invoice.invoicecreditcardv getInvoiceCreditcardV() {
        return (org.openbravo.model.common.invoice.invoicecreditcardv) get(PROPERTY_INVOICECREDITCARDV);
    }

    public void setInvoiceCreditcardV(
        org.openbravo.model.common.invoice.invoicecreditcardv invoiceCreditcardV) {
        set(PROPERTY_INVOICECREDITCARDV, invoiceCreditcardV);
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

    public Boolean isSOTrx() {
        return (Boolean) get(PROPERTY_ISSOTRX);
    }

    public void setSOTrx(Boolean isSOTrx) {
        set(PROPERTY_ISSOTRX, isSOTrx);
    }

    public String getInvoiceDocumentNo() {
        return (String) get(PROPERTY_INVOICEDOCUMENTNO);
    }

    public void setInvoiceDocumentNo(String invoiceDocumentNo) {
        set(PROPERTY_INVOICEDOCUMENTNO, invoiceDocumentNo);
    }

    public String getDocStatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocStatus(String docStatus) {
        set(PROPERTY_DOCSTATUS, docStatus);
    }

    public String getDocAction() {
        return (String) get(PROPERTY_DOCACTION);
    }

    public void setDocAction(String docAction) {
        set(PROPERTY_DOCACTION, docAction);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Date getDateAcct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateAcct(Date dateAcct) {
        set(PROPERTY_DATEACCT, dateAcct);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public Location getBpartnerLocation() {
        return (Location) get(PROPERTY_BPARTNERLOCATION);
    }

    public void setBpartnerLocation(Location bpartnerLocation) {
        set(PROPERTY_BPARTNERLOCATION, bpartnerLocation);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public String getPaymentRule() {
        return (String) get(PROPERTY_PAYMENTRULE);
    }

    public void setPaymentRule(String paymentRule) {
        set(PROPERTY_PAYMENTRULE, paymentRule);
    }

    public PaymentTerm getPaymentTerm() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERM);
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        set(PROPERTY_PAYMENTTERM, paymentTerm);
    }

    public BigDecimal getTotalLines() {
        return (BigDecimal) get(PROPERTY_TOTALLINES);
    }

    public void setTotalLines(BigDecimal totalLines) {
        set(PROPERTY_TOTALLINES, totalLines);
    }

    public BigDecimal getGrandTotal() {
        return (BigDecimal) get(PROPERTY_GRANDTOTAL);
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        set(PROPERTY_GRANDTOTAL, grandTotal);
    }

    public PriceList getPricelist() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPricelist(PriceList pricelist) {
        set(PROPERTY_PRICELIST, pricelist);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public Boolean isGrossInvoice() {
        return (Boolean) get(PROPERTY_ISGROSSINVOICE);
    }

    public void setGrossInvoice(Boolean isGrossInvoice) {
        set(PROPERTY_ISGROSSINVOICE, isGrossInvoice);
    }

    public String getInternalNote() {
        return (String) get(PROPERTY_INTERNALNOTE);
    }

    public void setInternalNote(String internalNote) {
        set(PROPERTY_INTERNALNOTE, internalNote);
    }

    public Boolean isLineIsActive() {
        return (Boolean) get(PROPERTY_LINEISACTIVE);
    }

    public void setLineIsActive(Boolean lineIsActive) {
        set(PROPERTY_LINEISACTIVE, lineIsActive);
    }

    public Date getLineCreated() {
        return (Date) get(PROPERTY_LINECREATED);
    }

    public void setLineCreated(Date lineCreated) {
        set(PROPERTY_LINECREATED, lineCreated);
    }

    public String getLineCreatedBy() {
        return (String) get(PROPERTY_LINECREATEDBY);
    }

    public void setLineCreatedBy(String lineCreatedBy) {
        set(PROPERTY_LINECREATEDBY, lineCreatedBy);
    }

    public Date getLineUpdated() {
        return (Date) get(PROPERTY_LINEUPDATED);
    }

    public void setLineUpdated(Date lineUpdated) {
        set(PROPERTY_LINEUPDATED, lineUpdated);
    }

    public String getLineUpdatedBy() {
        return (String) get(PROPERTY_LINEUPDATEDBY);
    }

    public void setLineUpdatedBy(String lineUpdatedBy) {
        set(PROPERTY_LINEUPDATEDBY, lineUpdatedBy);
    }

    public OrderLine getOrderline() {
        return (OrderLine) get(PROPERTY_ORDERLINE);
    }

    public void setOrderline(OrderLine orderline) {
        set(PROPERTY_ORDERLINE, orderline);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public String getLineDescription() {
        return (String) get(PROPERTY_LINEDESCRIPTION);
    }

    public void setLineDescription(String lineDescription) {
        set(PROPERTY_LINEDESCRIPTION, lineDescription);
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

    public User getLineAdUser() {
        return (User) get(PROPERTY_LINEADUSER);
    }

    public void setLineAdUser(User lineAdUser) {
        set(PROPERTY_LINEADUSER, lineAdUser);
    }
}
