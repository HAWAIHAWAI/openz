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
package org.openbravo.model.materialmgmt.cost;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity MaterialMgmtCosting (stored in table M_Costing).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Costing extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Costing";
    public static final String ENTITY_NAME = "MaterialMgmtCosting";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_DATEFROM = "dateFrom";
    public static final String PROPERTY_DATETO = "dateTo";
    public static final String PROPERTY_ISMANUAL = "isManual";
    public static final String PROPERTY_INOUTLINE = "inOutLine";
    public static final String PROPERTY_INVOICELINE = "invoiceLine";
    public static final String PROPERTY_QTY = "qty";
    public static final String PROPERTY_PRICE = "price";
    public static final String PROPERTY_CUMQTY = "cumqty";
    public static final String PROPERTY_COSTTYPE = "costtype";
    public static final String PROPERTY_ISPERMANENT = "ispermanent";
    public static final String PROPERTY_COST = "cost";
    public static final String PROPERTY_PRODUCTIONLINE = "productionLine";
    public static final String PROPERTY_ISPRODUCTION = "isproduction";

    public Costing() {
        setDefaultValue(PROPERTY_ISMANUAL, false);
        setDefaultValue(PROPERTY_COSTTYPE, "ST");
        setDefaultValue(PROPERTY_ISPERMANENT, false);
        setDefaultValue(PROPERTY_ISPRODUCTION, false);
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

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Date getDateFrom() {
        return (Date) get(PROPERTY_DATEFROM);
    }

    public void setDateFrom(Date dateFrom) {
        set(PROPERTY_DATEFROM, dateFrom);
    }

    public Date getDateTo() {
        return (Date) get(PROPERTY_DATETO);
    }

    public void setDateTo(Date dateTo) {
        set(PROPERTY_DATETO, dateTo);
    }

    public Boolean isManual() {
        return (Boolean) get(PROPERTY_ISMANUAL);
    }

    public void setManual(Boolean isManual) {
        set(PROPERTY_ISMANUAL, isManual);
    }

    public ShipmentInOutLine getInOutLine() {
        return (ShipmentInOutLine) get(PROPERTY_INOUTLINE);
    }

    public void setInOutLine(ShipmentInOutLine inOutLine) {
        set(PROPERTY_INOUTLINE, inOutLine);
    }

    public InvoiceLine getInvoiceLine() {
        return (InvoiceLine) get(PROPERTY_INVOICELINE);
    }

    public void setInvoiceLine(InvoiceLine invoiceLine) {
        set(PROPERTY_INVOICELINE, invoiceLine);
    }

    public BigDecimal getQty() {
        return (BigDecimal) get(PROPERTY_QTY);
    }

    public void setQty(BigDecimal qty) {
        set(PROPERTY_QTY, qty);
    }

    public BigDecimal getPrice() {
        return (BigDecimal) get(PROPERTY_PRICE);
    }

    public void setPrice(BigDecimal price) {
        set(PROPERTY_PRICE, price);
    }

    public BigDecimal getCumqty() {
        return (BigDecimal) get(PROPERTY_CUMQTY);
    }

    public void setCumqty(BigDecimal cumqty) {
        set(PROPERTY_CUMQTY, cumqty);
    }

    public String getCosttype() {
        return (String) get(PROPERTY_COSTTYPE);
    }

    public void setCosttype(String costtype) {
        set(PROPERTY_COSTTYPE, costtype);
    }

    public Boolean isPermanent() {
        return (Boolean) get(PROPERTY_ISPERMANENT);
    }

    public void setPermanent(Boolean ispermanent) {
        set(PROPERTY_ISPERMANENT, ispermanent);
    }

    public BigDecimal getCost() {
        return (BigDecimal) get(PROPERTY_COST);
    }

    public void setCost(BigDecimal cost) {
        set(PROPERTY_COST, cost);
    }

    public String getProductionLine() {
        return (String) get(PROPERTY_PRODUCTIONLINE);
    }

    public void setProductionLine(String productionLine) {
        set(PROPERTY_PRODUCTIONLINE, productionLine);
    }

    public Boolean isProduction() {
        return (Boolean) get(PROPERTY_ISPRODUCTION);
    }

    public void setProduction(Boolean isproduction) {
        set(PROPERTY_ISPRODUCTION, isproduction);
    }
}
