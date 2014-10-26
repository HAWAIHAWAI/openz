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
import org.openbravo.model.financialmgmt.tax.TaxRate;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity InvoiceLineTaxV (stored in table C_Invoice_LineTax_V).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class InvoiceLineTaxV extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Invoice_LineTax_V";
    public static final String ENTITY_NAME = "InvoiceLineTaxV";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_LANGUAGE = "language";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_QTYINVOICED = "qtyInvoiced";
    public static final String PROPERTY_UOMSYMBOL = "uOMSymbol";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DOCUMENTNOTE = "documentNote";
    public static final String PROPERTY_UPC = "uPC";
    public static final String PROPERTY_SKU = "sKU";
    public static final String PROPERTY_PRODUCTVALUE = "productValue";
    public static final String PROPERTY_RESOURCEDESCRIPTION =
        "resourceDescription";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_DISCOUNT = "discount";
    public static final String PROPERTY_PRICEACTUAL = "priceActual";
    public static final String PROPERTY_LINENETAMT = "lineNetAmt";

    public InvoiceLineTaxV() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_LANGUAGE, false);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
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

    public Boolean isLanguage() {
        return (Boolean) get(PROPERTY_LANGUAGE);
    }

    public void setLanguage(Boolean language) {
        set(PROPERTY_LANGUAGE, language);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public BigDecimal getQtyInvoiced() {
        return (BigDecimal) get(PROPERTY_QTYINVOICED);
    }

    public void setQtyInvoiced(BigDecimal qtyInvoiced) {
        set(PROPERTY_QTYINVOICED, qtyInvoiced);
    }

    public String getUOMSymbol() {
        return (String) get(PROPERTY_UOMSYMBOL);
    }

    public void setUOMSymbol(String uOMSymbol) {
        set(PROPERTY_UOMSYMBOL, uOMSymbol);
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

    public String getProductValue() {
        return (String) get(PROPERTY_PRODUCTVALUE);
    }

    public void setProductValue(String productValue) {
        set(PROPERTY_PRODUCTVALUE, productValue);
    }

    public String getResourceDescription() {
        return (String) get(PROPERTY_RESOURCEDESCRIPTION);
    }

    public void setResourceDescription(String resourceDescription) {
        set(PROPERTY_RESOURCEDESCRIPTION, resourceDescription);
    }

    public BigDecimal getPriceList() {
        return (BigDecimal) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(BigDecimal priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public BigDecimal getDiscount() {
        return (BigDecimal) get(PROPERTY_DISCOUNT);
    }

    public void setDiscount(BigDecimal discount) {
        set(PROPERTY_DISCOUNT, discount);
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
}
