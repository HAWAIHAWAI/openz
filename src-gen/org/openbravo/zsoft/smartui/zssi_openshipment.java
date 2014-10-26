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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.Product;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity zssi_openshipment (stored in table zssi_openshipment).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class zssi_openshipment extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zssi_openshipment";
    public static final String ENTITY_NAME = "zssi_openshipment";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_DOCUMENTNO = "documentno";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SALESREP = "salesRep";
    public static final String PROPERTY_DATEORDERED = "dateordered";
    public static final String PROPERTY_DATEPROMISED = "datepromised";
    public static final String PROPERTY_SCHEDDELIVERYDATE = "scheddeliverydate";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_UOM = "uom";
    public static final String PROPERTY_QTYORDERED = "qtyordered";
    public static final String PROPERTY_QTYRESERVED = "qtyreserved";
    public static final String PROPERTY_QTYDELIVERED = "qtydelivered";
    public static final String PROPERTY_QTYINVOICED = "qtyinvoiced";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_ORDERLINE = "orderLine";

    public zssi_openshipment() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
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

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public String getDocumentno() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentno(String documentno) {
        set(PROPERTY_DOCUMENTNO, documentno);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public User getSalesRep() {
        return (User) get(PROPERTY_SALESREP);
    }

    public void setSalesRep(User salesRep) {
        set(PROPERTY_SALESREP, salesRep);
    }

    public Date getDateordered() {
        return (Date) get(PROPERTY_DATEORDERED);
    }

    public void setDateordered(Date dateordered) {
        set(PROPERTY_DATEORDERED, dateordered);
    }

    public Date getDatepromised() {
        return (Date) get(PROPERTY_DATEPROMISED);
    }

    public void setDatepromised(Date datepromised) {
        set(PROPERTY_DATEPROMISED, datepromised);
    }

    public Date getScheddeliverydate() {
        return (Date) get(PROPERTY_SCHEDDELIVERYDATE);
    }

    public void setScheddeliverydate(Date scheddeliverydate) {
        set(PROPERTY_SCHEDDELIVERYDATE, scheddeliverydate);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public org.openbravo.model.common.uom.UOM getUom() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUom(org.openbravo.model.common.uom.UOM uom) {
        set(PROPERTY_UOM, uom);
    }

    public Long getQtyordered() {
        return (Long) get(PROPERTY_QTYORDERED);
    }

    public void setQtyordered(Long qtyordered) {
        set(PROPERTY_QTYORDERED, qtyordered);
    }

    public Long getQtyreserved() {
        return (Long) get(PROPERTY_QTYRESERVED);
    }

    public void setQtyreserved(Long qtyreserved) {
        set(PROPERTY_QTYRESERVED, qtyreserved);
    }

    public Long getQtydelivered() {
        return (Long) get(PROPERTY_QTYDELIVERED);
    }

    public void setQtydelivered(Long qtydelivered) {
        set(PROPERTY_QTYDELIVERED, qtydelivered);
    }

    public Long getQtyinvoiced() {
        return (Long) get(PROPERTY_QTYINVOICED);
    }

    public void setQtyinvoiced(Long qtyinvoiced) {
        set(PROPERTY_QTYINVOICED, qtyinvoiced);
    }

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

    public OrderLine getOrderLine() {
        return (OrderLine) get(PROPERTY_ORDERLINE);
    }

    public void setOrderLine(OrderLine orderLine) {
        set(PROPERTY_ORDERLINE, orderLine);
    }
}
