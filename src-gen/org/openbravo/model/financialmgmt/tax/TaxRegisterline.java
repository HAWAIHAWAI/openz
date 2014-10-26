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
package org.openbravo.model.financialmgmt.tax;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.InvoiceTax;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity FinancialMgmtTaxRegisterline (stored in table C_TaxRegisterline).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class TaxRegisterline extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_TaxRegisterline";
    public static final String ENTITY_NAME = "FinancialMgmtTaxRegisterline";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_TAXREGISTER = "taxregister";
    public static final String PROPERTY_INVOICETAX = "invoicetax";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_TAXBASEAMT = "taxbaseamt";
    public static final String PROPERTY_TAXAMT = "taxamt";
    public static final String PROPERTY_TOTALAMT = "totalAmt";
    public static final String PROPERTY_TAXUNDAMT = "taxUndAmt";
    public static final String PROPERTY_INVOICEDATE = "invoiceDate";
    public static final String PROPERTY_EXEMPTAMT = "exemptAmt";
    public static final String PROPERTY_NOVATAMT = "novatamt";
    public static final String PROPERTY_NAME = "name";

    public TaxRegisterline() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
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

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public TaxRegister getTaxregister() {
        return (TaxRegister) get(PROPERTY_TAXREGISTER);
    }

    public void setTaxregister(TaxRegister taxregister) {
        set(PROPERTY_TAXREGISTER, taxregister);
    }

    public InvoiceTax getInvoicetax() {
        return (InvoiceTax) get(PROPERTY_INVOICETAX);
    }

    public void setInvoicetax(InvoiceTax invoicetax) {
        set(PROPERTY_INVOICETAX, invoicetax);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public BigDecimal getTaxbaseamt() {
        return (BigDecimal) get(PROPERTY_TAXBASEAMT);
    }

    public void setTaxbaseamt(BigDecimal taxbaseamt) {
        set(PROPERTY_TAXBASEAMT, taxbaseamt);
    }

    public BigDecimal getTaxamt() {
        return (BigDecimal) get(PROPERTY_TAXAMT);
    }

    public void setTaxamt(BigDecimal taxamt) {
        set(PROPERTY_TAXAMT, taxamt);
    }

    public BigDecimal getTotalAmt() {
        return (BigDecimal) get(PROPERTY_TOTALAMT);
    }

    public void setTotalAmt(BigDecimal totalAmt) {
        set(PROPERTY_TOTALAMT, totalAmt);
    }

    public BigDecimal getTaxUndAmt() {
        return (BigDecimal) get(PROPERTY_TAXUNDAMT);
    }

    public void setTaxUndAmt(BigDecimal taxUndAmt) {
        set(PROPERTY_TAXUNDAMT, taxUndAmt);
    }

    public Date getInvoiceDate() {
        return (Date) get(PROPERTY_INVOICEDATE);
    }

    public void setInvoiceDate(Date invoiceDate) {
        set(PROPERTY_INVOICEDATE, invoiceDate);
    }

    public BigDecimal getExemptAmt() {
        return (BigDecimal) get(PROPERTY_EXEMPTAMT);
    }

    public void setExemptAmt(BigDecimal exemptAmt) {
        set(PROPERTY_EXEMPTAMT, exemptAmt);
    }

    public BigDecimal getNovatamt() {
        return (BigDecimal) get(PROPERTY_NOVATAMT);
    }

    public void setNovatamt(BigDecimal novatamt) {
        set(PROPERTY_NOVATAMT, novatamt);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }
}
