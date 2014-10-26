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
package org.openbravo.model.procurement;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductUOM;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.pricing.pricelist.PriceList;
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
 * Entity class for entity ProcurementRequisitionLine (stored in table M_RequisitionLine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class RequisitionLine extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_RequisitionLine";
    public static final String ENTITY_NAME = "ProcurementRequisitionLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_REQUISITION = "requisition";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_QTY = "qty";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_LINENETAMT = "lineNetAmt";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_PRODUCTUOM = "productUom";
    public static final String PROPERTY_QUANTITYORDER = "quantityOrder";
    public static final String PROPERTY_ATTRIBUTESETINSTANCE =
        "attributeSetInstance";
    public static final String PROPERTY_REQSTATUS = "reqstatus";
    public static final String PROPERTY_ORDEREDQTY = "orderedqty";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_CHANGESTATUS = "changestatus";
    public static final String PROPERTY_INTERNALNOTES = "internalnotes";
    public static final String PROPERTY_SUPPLIERNOTES = "suppliernotes";
    public static final String PROPERTY_DATEPLANNED = "dateplanned";
    public static final String PROPERTY_NEEDBYDATE = "needbydate";
    public static final String PROPERTY_PRICEACTUAL = "priceActual";
    public static final String PROPERTY_DISCOUNT = "discount";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_LOCKEDBY = "lockedby";
    public static final String PROPERTY_LOCKQTY = "lockqty";
    public static final String PROPERTY_LOCKPRICE = "lockprice";
    public static final String PROPERTY_PRICELIST32 = "priceList32";
    public static final String PROPERTY_LOCKDATE = "lockdate";
    public static final String PROPERTY_LOCKCAUSE = "lockcause";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_PROJECTPHASE = "projectphase";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_REJECTED = "rejected";
    public static final String PROPERTY_PROCUREMENTREQUISITIONPOMATCHLIST =
        "procurementRequisitionPOMatchList";

    public RequisitionLine() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_QTY, new BigDecimal(1));
        setDefaultValue(PROPERTY_REQSTATUS, "O");
        setDefaultValue(PROPERTY_ORDEREDQTY, new BigDecimal(0));
        setDefaultValue(PROPERTY_CHANGESTATUS, false);
        setDefaultValue(PROPERTY_REJECTED, false);
        setDefaultValue(PROPERTY_PROCUREMENTREQUISITIONPOMATCHLIST,
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

    public Requisition getRequisition() {
        return (Requisition) get(PROPERTY_REQUISITION);
    }

    public void setRequisition(Requisition requisition) {
        set(PROPERTY_REQUISITION, requisition);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getQty() {
        return (BigDecimal) get(PROPERTY_QTY);
    }

    public void setQty(BigDecimal qty) {
        set(PROPERTY_QTY, qty);
    }

    public BigDecimal getPriceList() {
        return (BigDecimal) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(BigDecimal priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public BigDecimal getLineNetAmt() {
        return (BigDecimal) get(PROPERTY_LINENETAMT);
    }

    public void setLineNetAmt(BigDecimal lineNetAmt) {
        set(PROPERTY_LINENETAMT, lineNetAmt);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public org.openbravo.model.common.uom.UOM getUOM() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUOM(org.openbravo.model.common.uom.UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public ProductUOM getProductUom() {
        return (ProductUOM) get(PROPERTY_PRODUCTUOM);
    }

    public void setProductUom(ProductUOM productUom) {
        set(PROPERTY_PRODUCTUOM, productUom);
    }

    public BigDecimal getQuantityOrder() {
        return (BigDecimal) get(PROPERTY_QUANTITYORDER);
    }

    public void setQuantityOrder(BigDecimal quantityOrder) {
        set(PROPERTY_QUANTITYORDER, quantityOrder);
    }

    public AttributeSetInstance getAttributeSetInstance() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETINSTANCE);
    }

    public void setAttributeSetInstance(
        AttributeSetInstance attributeSetInstance) {
        set(PROPERTY_ATTRIBUTESETINSTANCE, attributeSetInstance);
    }

    public String getReqstatus() {
        return (String) get(PROPERTY_REQSTATUS);
    }

    public void setReqstatus(String reqstatus) {
        set(PROPERTY_REQSTATUS, reqstatus);
    }

    public BigDecimal getOrderedqty() {
        return (BigDecimal) get(PROPERTY_ORDEREDQTY);
    }

    public void setOrderedqty(BigDecimal orderedqty) {
        set(PROPERTY_ORDEREDQTY, orderedqty);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isChangestatus() {
        return (Boolean) get(PROPERTY_CHANGESTATUS);
    }

    public void setChangestatus(Boolean changestatus) {
        set(PROPERTY_CHANGESTATUS, changestatus);
    }

    public String getInternalnotes() {
        return (String) get(PROPERTY_INTERNALNOTES);
    }

    public void setInternalnotes(String internalnotes) {
        set(PROPERTY_INTERNALNOTES, internalnotes);
    }

    public String getSuppliernotes() {
        return (String) get(PROPERTY_SUPPLIERNOTES);
    }

    public void setSuppliernotes(String suppliernotes) {
        set(PROPERTY_SUPPLIERNOTES, suppliernotes);
    }

    public Date getDateplanned() {
        return (Date) get(PROPERTY_DATEPLANNED);
    }

    public void setDateplanned(Date dateplanned) {
        set(PROPERTY_DATEPLANNED, dateplanned);
    }

    public Date getNeedbydate() {
        return (Date) get(PROPERTY_NEEDBYDATE);
    }

    public void setNeedbydate(Date needbydate) {
        set(PROPERTY_NEEDBYDATE, needbydate);
    }

    public BigDecimal getPriceActual() {
        return (BigDecimal) get(PROPERTY_PRICEACTUAL);
    }

    public void setPriceActual(BigDecimal priceActual) {
        set(PROPERTY_PRICEACTUAL, priceActual);
    }

    public BigDecimal getDiscount() {
        return (BigDecimal) get(PROPERTY_DISCOUNT);
    }

    public void setDiscount(BigDecimal discount) {
        set(PROPERTY_DISCOUNT, discount);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public User getLockedby() {
        return (User) get(PROPERTY_LOCKEDBY);
    }

    public void setLockedby(User lockedby) {
        set(PROPERTY_LOCKEDBY, lockedby);
    }

    public BigDecimal getLockqty() {
        return (BigDecimal) get(PROPERTY_LOCKQTY);
    }

    public void setLockqty(BigDecimal lockqty) {
        set(PROPERTY_LOCKQTY, lockqty);
    }

    public BigDecimal getLockprice() {
        return (BigDecimal) get(PROPERTY_LOCKPRICE);
    }

    public void setLockprice(BigDecimal lockprice) {
        set(PROPERTY_LOCKPRICE, lockprice);
    }

    public PriceList getPriceList32() {
        return (PriceList) get(PROPERTY_PRICELIST32);
    }

    public void setPriceList32(PriceList priceList32) {
        set(PROPERTY_PRICELIST32, priceList32);
    }

    public Date getLockdate() {
        return (Date) get(PROPERTY_LOCKDATE);
    }

    public void setLockdate(Date lockdate) {
        set(PROPERTY_LOCKDATE, lockdate);
    }

    public String getLockcause() {
        return (String) get(PROPERTY_LOCKCAUSE);
    }

    public void setLockcause(String lockcause) {
        set(PROPERTY_LOCKCAUSE, lockcause);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
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

    public Boolean isRejected() {
        return (Boolean) get(PROPERTY_REJECTED);
    }

    public void setRejected(Boolean rejected) {
        set(PROPERTY_REJECTED, rejected);
    }

    @SuppressWarnings("unchecked")
    public List<RequisitionPOMatch> getProcurementRequisitionPOMatchList() {
        return (List<RequisitionPOMatch>) get(PROPERTY_PROCUREMENTREQUISITIONPOMATCHLIST);
    }

    public void setProcurementRequisitionPOMatchList(
        List<RequisitionPOMatch> procurementRequisitionPOMatchList) {
        set(PROPERTY_PROCUREMENTREQUISITIONPOMATCHLIST,
            procurementRequisitionPOMatchList);
    }
}
