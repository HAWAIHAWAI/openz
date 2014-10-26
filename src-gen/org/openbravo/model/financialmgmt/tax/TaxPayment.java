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
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.model.financialmgmt.payment.Settlement;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity FinancialMgmtTaxPayment (stored in table C_TaxPayment).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class TaxPayment extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_TaxPayment";
    public static final String ENTITY_NAME = "FinancialMgmtTaxPayment";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_DATEFROM = "datefrom";
    public static final String PROPERTY_DATETO = "dateto";
    public static final String PROPERTY_GENERATEPAYMENT = "generatepayment";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_SETTLEMENT = "settlement";
    public static final String PROPERTY_JOURNAL = "journal";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_CREATEFROM = "createFrom";
    public static final String PROPERTY_ACCTSCHEMA = "acctSchema";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_FINANCIALMGMTTAXREGISTERLIST =
        "financialMgmtTaxRegisterList";

    public TaxPayment() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_GENERATEPAYMENT, false);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_CREATEFROM, false);
        setDefaultValue(PROPERTY_FINANCIALMGMTTAXREGISTERLIST,
            new ArrayList<Object>());
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

    public Date getDatefrom() {
        return (Date) get(PROPERTY_DATEFROM);
    }

    public void setDatefrom(Date datefrom) {
        set(PROPERTY_DATEFROM, datefrom);
    }

    public Date getDateto() {
        return (Date) get(PROPERTY_DATETO);
    }

    public void setDateto(Date dateto) {
        set(PROPERTY_DATETO, dateto);
    }

    public Boolean isGeneratepayment() {
        return (Boolean) get(PROPERTY_GENERATEPAYMENT);
    }

    public void setGeneratepayment(Boolean generatepayment) {
        set(PROPERTY_GENERATEPAYMENT, generatepayment);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Settlement getSettlement() {
        return (Settlement) get(PROPERTY_SETTLEMENT);
    }

    public void setSettlement(Settlement settlement) {
        set(PROPERTY_SETTLEMENT, settlement);
    }

    public GLJournal getJournal() {
        return (GLJournal) get(PROPERTY_JOURNAL);
    }

    public void setJournal(GLJournal journal) {
        set(PROPERTY_JOURNAL, journal);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public Boolean isCreateFrom() {
        return (Boolean) get(PROPERTY_CREATEFROM);
    }

    public void setCreateFrom(Boolean createFrom) {
        set(PROPERTY_CREATEFROM, createFrom);
    }

    public AcctSchema getAcctSchema() {
        return (AcctSchema) get(PROPERTY_ACCTSCHEMA);
    }

    public void setAcctSchema(AcctSchema acctSchema) {
        set(PROPERTY_ACCTSCHEMA, acctSchema);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    @SuppressWarnings("unchecked")
    public List<TaxRegister> getFinancialMgmtTaxRegisterList() {
        return (List<TaxRegister>) get(PROPERTY_FINANCIALMGMTTAXREGISTERLIST);
    }

    public void setFinancialMgmtTaxRegisterList(
        List<TaxRegister> financialMgmtTaxRegisterList) {
        set(PROPERTY_FINANCIALMGMTTAXREGISTERLIST, financialMgmtTaxRegisterList);
    }
}
