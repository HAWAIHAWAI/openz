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
package org.openbravo.model.common.order;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Location;
import org.openbravo.model.financialmgmt.gl.GLCharge;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.project.Project;
import org.openbravo.model.shipping.ShippingCompany;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity OrderHeaderV (stored in table C_Order_Header_V).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class OrderHeaderV extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Order_Header_V";
    public static final String ENTITY_NAME = "OrderHeaderV";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_LANGUAGE = "language";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ISSOTRX = "isSOTrx";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DOCSTATUS = "docStatus";
    public static final String PROPERTY_DOCTYPE = "docType";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_BPVALUE = "bPValue";
    public static final String PROPERTY_ORGLOCATION = "orgLocation";
    public static final String PROPERTY_TAXID = "taxID";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_DOCUMENTTYPENOTE = "documentTypeNote";
    public static final String PROPERTY_SALESREP = "salesRep";
    public static final String PROPERTY_SALESREPNAME = "salesRepName";
    public static final String PROPERTY_DATEORDERED = "dateOrdered";
    public static final String PROPERTY_DATEPROMISED = "datePromised";
    public static final String PROPERTY_BPGREETING = "bPGreeting";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_NAME2 = "name2";
    public static final String PROPERTY_BPCONTACTGREETING = "bPContactGreeting";
    public static final String PROPERTY_TITLE = "title";
    public static final String PROPERTY_CONTACTNAME = "contactName";
    public static final String PROPERTY_LOCATION = "location";
    public static final String PROPERTY_REFERENCENO = "referenceNo";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_POREFERENCE = "pOReference";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_PAYMENTTERM = "paymentTerm";
    public static final String PROPERTY_PAYMENTTERMNOTE = "paymentTermNote";
    public static final String PROPERTY_CHARGE = "charge";
    public static final String PROPERTY_CHARGEAMT = "chargeAmt";
    public static final String PROPERTY_TOTALLINES = "totalLines";
    public static final String PROPERTY_GRANDTOTAL = "grandTotal";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_ISTAXINCLUDED = "isTaxIncluded";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_SHIPPER = "shipper";
    public static final String PROPERTY_DELIVERYRULE = "deliveryRule";
    public static final String PROPERTY_DELIVERYVIARULE = "deliveryViaRule";
    public static final String PROPERTY_PRIORITYRULE = "priorityRule";
    public static final String PROPERTY_INVOICERULE = "invoiceRule";

    public OrderHeaderV() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISSOTRX, false);
        setDefaultValue(PROPERTY_ISTAXINCLUDED, false);
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

    public String getLanguage() {
        return (String) get(PROPERTY_LANGUAGE);
    }

    public void setLanguage(String language) {
        set(PROPERTY_LANGUAGE, language);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Boolean isSOTrx() {
        return (Boolean) get(PROPERTY_ISSOTRX);
    }

    public void setSOTrx(Boolean isSOTrx) {
        set(PROPERTY_ISSOTRX, isSOTrx);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getDocStatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocStatus(String docStatus) {
        set(PROPERTY_DOCSTATUS, docStatus);
    }

    public String getDocType() {
        return (String) get(PROPERTY_DOCTYPE);
    }

    public void setDocType(String docType) {
        set(PROPERTY_DOCTYPE, docType);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public String getBPValue() {
        return (String) get(PROPERTY_BPVALUE);
    }

    public void setBPValue(String bPValue) {
        set(PROPERTY_BPVALUE, bPValue);
    }

    public Location getOrgLocation() {
        return (Location) get(PROPERTY_ORGLOCATION);
    }

    public void setOrgLocation(Location orgLocation) {
        set(PROPERTY_ORGLOCATION, orgLocation);
    }

    public String getTaxID() {
        return (String) get(PROPERTY_TAXID);
    }

    public void setTaxID(String taxID) {
        set(PROPERTY_TAXID, taxID);
    }

    public String getDocumentType() {
        return (String) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(String documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public String getDocumentTypeNote() {
        return (String) get(PROPERTY_DOCUMENTTYPENOTE);
    }

    public void setDocumentTypeNote(String documentTypeNote) {
        set(PROPERTY_DOCUMENTTYPENOTE, documentTypeNote);
    }

    public User getSalesRep() {
        return (User) get(PROPERTY_SALESREP);
    }

    public void setSalesRep(User salesRep) {
        set(PROPERTY_SALESREP, salesRep);
    }

    public String getSalesRepName() {
        return (String) get(PROPERTY_SALESREPNAME);
    }

    public void setSalesRepName(String salesRepName) {
        set(PROPERTY_SALESREPNAME, salesRepName);
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

    public String getBPGreeting() {
        return (String) get(PROPERTY_BPGREETING);
    }

    public void setBPGreeting(String bPGreeting) {
        set(PROPERTY_BPGREETING, bPGreeting);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getName2() {
        return (String) get(PROPERTY_NAME2);
    }

    public void setName2(String name2) {
        set(PROPERTY_NAME2, name2);
    }

    public String getBPContactGreeting() {
        return (String) get(PROPERTY_BPCONTACTGREETING);
    }

    public void setBPContactGreeting(String bPContactGreeting) {
        set(PROPERTY_BPCONTACTGREETING, bPContactGreeting);
    }

    public String getTitle() {
        return (String) get(PROPERTY_TITLE);
    }

    public void setTitle(String title) {
        set(PROPERTY_TITLE, title);
    }

    public String getContactName() {
        return (String) get(PROPERTY_CONTACTNAME);
    }

    public void setContactName(String contactName) {
        set(PROPERTY_CONTACTNAME, contactName);
    }

    public Location getLocation() {
        return (Location) get(PROPERTY_LOCATION);
    }

    public void setLocation(Location location) {
        set(PROPERTY_LOCATION, location);
    }

    public String getReferenceNo() {
        return (String) get(PROPERTY_REFERENCENO);
    }

    public void setReferenceNo(String referenceNo) {
        set(PROPERTY_REFERENCENO, referenceNo);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getPOReference() {
        return (String) get(PROPERTY_POREFERENCE);
    }

    public void setPOReference(String pOReference) {
        set(PROPERTY_POREFERENCE, pOReference);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public String getPaymentTerm() {
        return (String) get(PROPERTY_PAYMENTTERM);
    }

    public void setPaymentTerm(String paymentTerm) {
        set(PROPERTY_PAYMENTTERM, paymentTerm);
    }

    public String getPaymentTermNote() {
        return (String) get(PROPERTY_PAYMENTTERMNOTE);
    }

    public void setPaymentTermNote(String paymentTermNote) {
        set(PROPERTY_PAYMENTTERMNOTE, paymentTermNote);
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

    public PriceList getPriceList() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(PriceList priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public Boolean isTaxIncluded() {
        return (Boolean) get(PROPERTY_ISTAXINCLUDED);
    }

    public void setTaxIncluded(Boolean isTaxIncluded) {
        set(PROPERTY_ISTAXINCLUDED, isTaxIncluded);
    }

    public Campaign getCampaign() {
        return (Campaign) get(PROPERTY_CAMPAIGN);
    }

    public void setCampaign(Campaign campaign) {
        set(PROPERTY_CAMPAIGN, campaign);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public ABCActivity getActivity() {
        return (ABCActivity) get(PROPERTY_ACTIVITY);
    }

    public void setActivity(ABCActivity activity) {
        set(PROPERTY_ACTIVITY, activity);
    }

    public ShippingCompany getShipper() {
        return (ShippingCompany) get(PROPERTY_SHIPPER);
    }

    public void setShipper(ShippingCompany shipper) {
        set(PROPERTY_SHIPPER, shipper);
    }

    public String getDeliveryRule() {
        return (String) get(PROPERTY_DELIVERYRULE);
    }

    public void setDeliveryRule(String deliveryRule) {
        set(PROPERTY_DELIVERYRULE, deliveryRule);
    }

    public String getDeliveryViaRule() {
        return (String) get(PROPERTY_DELIVERYVIARULE);
    }

    public void setDeliveryViaRule(String deliveryViaRule) {
        set(PROPERTY_DELIVERYVIARULE, deliveryViaRule);
    }

    public String getPriorityRule() {
        return (String) get(PROPERTY_PRIORITYRULE);
    }

    public void setPriorityRule(String priorityRule) {
        set(PROPERTY_PRIORITYRULE, priorityRule);
    }

    public String getInvoiceRule() {
        return (String) get(PROPERTY_INVOICERULE);
    }

    public void setInvoiceRule(String invoiceRule) {
        set(PROPERTY_INVOICERULE, invoiceRule);
    }
}
