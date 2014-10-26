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
package org.openbravo.model.pos;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.shipping.ShippingCompany;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ExternalPOS (stored in table C_ExternalPOS).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ExternalPOS extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_ExternalPOS";
    public static final String ENTITY_NAME = "ExternalPOS";
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
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_DOCTYPE = "docType";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_SALESREP = "salesRep";
    public static final String PROPERTY_SHIPPER = "shipper";
    public static final String PROPERTY_INCLUDEPRODUCT = "includeProduct";
    public static final String PROPERTY_INCLUDEPRODUCTCATEGORY =
        "includeProductCategory";
    public static final String PROPERTY_PERFORMPOST = "performPost";
    public static final String PROPERTY_EXTERNALPOSPRODUCTLIST =
        "externalPOSProductList";
    public static final String PROPERTY_EXTERNALPOSCATEGORYLIST =
        "externalPOSCategoryList";

    public ExternalPOS() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_INCLUDEPRODUCT, "Y");
        setDefaultValue(PROPERTY_INCLUDEPRODUCTCATEGORY, "Y");
        setDefaultValue(PROPERTY_PERFORMPOST, false);
        setDefaultValue(PROPERTY_EXTERNALPOSPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EXTERNALPOSCATEGORYLIST,
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

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public DocumentType getDocType() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDocType(DocumentType docType) {
        set(PROPERTY_DOCTYPE, docType);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public PriceList getPriceList() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(PriceList priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public User getSalesRep() {
        return (User) get(PROPERTY_SALESREP);
    }

    public void setSalesRep(User salesRep) {
        set(PROPERTY_SALESREP, salesRep);
    }

    public ShippingCompany getShipper() {
        return (ShippingCompany) get(PROPERTY_SHIPPER);
    }

    public void setShipper(ShippingCompany shipper) {
        set(PROPERTY_SHIPPER, shipper);
    }

    public String getIncludeProduct() {
        return (String) get(PROPERTY_INCLUDEPRODUCT);
    }

    public void setIncludeProduct(String includeProduct) {
        set(PROPERTY_INCLUDEPRODUCT, includeProduct);
    }

    public String getIncludeProductCategory() {
        return (String) get(PROPERTY_INCLUDEPRODUCTCATEGORY);
    }

    public void setIncludeProductCategory(String includeProductCategory) {
        set(PROPERTY_INCLUDEPRODUCTCATEGORY, includeProductCategory);
    }

    public Boolean isPerformPost() {
        return (Boolean) get(PROPERTY_PERFORMPOST);
    }

    public void setPerformPost(Boolean performPost) {
        set(PROPERTY_PERFORMPOST, performPost);
    }

    @SuppressWarnings("unchecked")
    public List<ExternalPOSProduct> getExternalPOSProductList() {
        return (List<ExternalPOSProduct>) get(PROPERTY_EXTERNALPOSPRODUCTLIST);
    }

    public void setExternalPOSProductList(
        List<ExternalPOSProduct> externalPOSProductList) {
        set(PROPERTY_EXTERNALPOSPRODUCTLIST, externalPOSProductList);
    }

    @SuppressWarnings("unchecked")
    public List<ExternalPOSCategory> getExternalPOSCategoryList() {
        return (List<ExternalPOSCategory>) get(PROPERTY_EXTERNALPOSCATEGORYLIST);
    }

    public void setExternalPOSCategoryList(
        List<ExternalPOSCategory> externalPOSCategoryList) {
        set(PROPERTY_EXTERNALPOSCATEGORYLIST, externalPOSCategoryList);
    }
}
