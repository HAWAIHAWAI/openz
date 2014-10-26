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
package org.openbravo.zsoft.smartui;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.financialmgmt.payment.Incoterms;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.shipping.ShippingCompany;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity zssi_smartinvoiceprefs (stored in table zssi_smartinvoiceprefs).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Smartinvoiceprefs extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zssi_smartinvoiceprefs";
    public static final String ENTITY_NAME = "zssi_smartinvoiceprefs";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PAYMENTRULE = "paymentrule";
    public static final String PROPERTY_INVOICETYPE = "invoicetype";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_BPARTNERLOCATION = "bpartnerLocation";
    public static final String PROPERTY_PAYMENTTERM = "paymentterm";
    public static final String PROPERTY_PRICELIST = "pricelist";
    public static final String PROPERTY_ISDEFAULT = "isdefault";
    public static final String PROPERTY_INVOICERULE = "invoicerule";
    public static final String PROPERTY_DELIVERYRULE = "deliveryrule";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_DELIVERYVIARULE = "deliveryViaRule";
    public static final String PROPERTY_FREIGHTCOSTRULE = "freightcostrule";
    public static final String PROPERTY_SHIPPER = "shipper";
    public static final String PROPERTY_WEIGHTUOM = "weightUom";
    public static final String PROPERTY_INCOTERMS = "incoterms";
    public static final String PROPERTY_ISAUTOCLOSING = "isautoclosing";
    public static final String PROPERTY_USECUSTOMERSDEFAULTS =
        "usecustomersdefaults";

    public Smartinvoiceprefs() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISDEFAULT, true);
        setDefaultValue(PROPERTY_ISAUTOCLOSING, false);
        setDefaultValue(PROPERTY_USECUSTOMERSDEFAULTS, false);
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

    public void setActive(Boolean isactive) {
        set(PROPERTY_ISACTIVE, isactive);
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

    public String getPaymentrule() {
        return (String) get(PROPERTY_PAYMENTRULE);
    }

    public void setPaymentrule(String paymentrule) {
        set(PROPERTY_PAYMENTRULE, paymentrule);
    }

    public String getInvoicetype() {
        return (String) get(PROPERTY_INVOICETYPE);
    }

    public void setInvoicetype(String invoicetype) {
        set(PROPERTY_INVOICETYPE, invoicetype);
    }

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public Location getBpartnerLocation() {
        return (Location) get(PROPERTY_BPARTNERLOCATION);
    }

    public void setBpartnerLocation(Location bpartnerLocation) {
        set(PROPERTY_BPARTNERLOCATION, bpartnerLocation);
    }

    public PaymentTerm getPaymentterm() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERM);
    }

    public void setPaymentterm(PaymentTerm paymentterm) {
        set(PROPERTY_PAYMENTTERM, paymentterm);
    }

    public PriceList getPricelist() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPricelist(PriceList pricelist) {
        set(PROPERTY_PRICELIST, pricelist);
    }

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_ISDEFAULT);
    }

    public void setDefault(Boolean isdefault) {
        set(PROPERTY_ISDEFAULT, isdefault);
    }

    public String getInvoicerule() {
        return (String) get(PROPERTY_INVOICERULE);
    }

    public void setInvoicerule(String invoicerule) {
        set(PROPERTY_INVOICERULE, invoicerule);
    }

    public String getDeliveryrule() {
        return (String) get(PROPERTY_DELIVERYRULE);
    }

    public void setDeliveryrule(String deliveryrule) {
        set(PROPERTY_DELIVERYRULE, deliveryrule);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public String getDeliveryViaRule() {
        return (String) get(PROPERTY_DELIVERYVIARULE);
    }

    public void setDeliveryViaRule(String deliveryViaRule) {
        set(PROPERTY_DELIVERYVIARULE, deliveryViaRule);
    }

    public String getFreightcostrule() {
        return (String) get(PROPERTY_FREIGHTCOSTRULE);
    }

    public void setFreightcostrule(String freightcostrule) {
        set(PROPERTY_FREIGHTCOSTRULE, freightcostrule);
    }

    public ShippingCompany getShipper() {
        return (ShippingCompany) get(PROPERTY_SHIPPER);
    }

    public void setShipper(ShippingCompany shipper) {
        set(PROPERTY_SHIPPER, shipper);
    }

    public org.openbravo.model.common.uom.UOM getWeightUom() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_WEIGHTUOM);
    }

    public void setWeightUom(org.openbravo.model.common.uom.UOM weightUom) {
        set(PROPERTY_WEIGHTUOM, weightUom);
    }

    public Incoterms getIncoterms() {
        return (Incoterms) get(PROPERTY_INCOTERMS);
    }

    public void setIncoterms(Incoterms incoterms) {
        set(PROPERTY_INCOTERMS, incoterms);
    }

    public Boolean isAutoclosing() {
        return (Boolean) get(PROPERTY_ISAUTOCLOSING);
    }

    public void setAutoclosing(Boolean isautoclosing) {
        set(PROPERTY_ISAUTOCLOSING, isautoclosing);
    }

    public Boolean isUsecustomersdefaults() {
        return (Boolean) get(PROPERTY_USECUSTOMERSDEFAULTS);
    }

    public void setUsecustomersdefaults(Boolean usecustomersdefaults) {
        set(PROPERTY_USECUSTOMERSDEFAULTS, usecustomersdefaults);
    }
}
