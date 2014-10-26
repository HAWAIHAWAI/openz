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
package org.openz.internallogistic;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectTask;
import org.openbravo.model.shipping.ShippingCompany;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ils_inoutpackage_v (stored in table ils_inoutpackage_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ils_inoutpackage_v extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ils_inoutpackage_v";
    public static final String ENTITY_NAME = "ils_inoutpackage_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_INOUT = "inout";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ISSOTRX = "issotrx";
    public static final String PROPERTY_DIRECTMAIL = "directmail";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DOCACTION = "docAction";
    public static final String PROPERTY_DOCSTATUS = "docstatus";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SHIPMENTCONTENT = "shipmentcontent";
    public static final String PROPERTY_SIGMANO = "sigmano";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PARTNER = "partner";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_MOVEMENTTYPE = "movementtype";
    public static final String PROPERTY_MOVEMENTDATE = "movementdate";
    public static final String PROPERTY_ISLOGISTIC = "islogistic";
    public static final String PROPERTY_SHIPPER = "shipper";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_ORDERLINE = "orderline";
    public static final String PROPERTY_INOUTLINE = "inoutline";
    public static final String PROPERTY_LOCATOR = "locator";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_UOM = "uom";
    public static final String PROPERTY_MOVEMENTQTY = "movementqty";
    public static final String PROPERTY_ISINVOICED = "isinvoiced";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_SERIALNUMBER = "serialnumber";
    public static final String PROPERTY_SNREMPLOYEE = "snremployee";
    public static final String PROPERTY_EMPLOYEE = "employee";
    public static final String PROPERTY_PROCESSBUTTON = "processbutton";
    public static final String PROPERTY_ILSSNRINOUTLINEVLIST =
        "ilsSnrinoutlineVList";

    public ils_inoutpackage_v() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_DIRECTMAIL, false);
        setDefaultValue(PROPERTY_DOCSTATUS, "DR");
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_MOVEMENTTYPE, "V+");
        setDefaultValue(PROPERTY_ISLOGISTIC, true);
        setDefaultValue(PROPERTY_MOVEMENTQTY, new BigDecimal(1));
        setDefaultValue(PROPERTY_ISINVOICED, false);
        setDefaultValue(PROPERTY_PROCESSBUTTON, false);
        setDefaultValue(PROPERTY_ILSSNRINOUTLINEVLIST, new ArrayList<Object>());
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

    public ShipmentInOut getInout() {
        return (ShipmentInOut) get(PROPERTY_INOUT);
    }

    public void setInout(ShipmentInOut inout) {
        set(PROPERTY_INOUT, inout);
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

    public Boolean isSotrx() {
        return (Boolean) get(PROPERTY_ISSOTRX);
    }

    public void setSotrx(Boolean issotrx) {
        set(PROPERTY_ISSOTRX, issotrx);
    }

    public Boolean isDirectmail() {
        return (Boolean) get(PROPERTY_DIRECTMAIL);
    }

    public void setDirectmail(Boolean directmail) {
        set(PROPERTY_DIRECTMAIL, directmail);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getDocAction() {
        return (String) get(PROPERTY_DOCACTION);
    }

    public void setDocAction(String docAction) {
        set(PROPERTY_DOCACTION, docAction);
    }

    public String getDocstatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocstatus(String docstatus) {
        set(PROPERTY_DOCSTATUS, docstatus);
    }

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
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

    public String getShipmentcontent() {
        return (String) get(PROPERTY_SHIPMENTCONTENT);
    }

    public void setShipmentcontent(String shipmentcontent) {
        set(PROPERTY_SHIPMENTCONTENT, shipmentcontent);
    }

    public String getSigmano() {
        return (String) get(PROPERTY_SIGMANO);
    }

    public void setSigmano(String sigmano) {
        set(PROPERTY_SIGMANO, sigmano);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public BusinessPartner getPartner() {
        return (BusinessPartner) get(PROPERTY_PARTNER);
    }

    public void setPartner(BusinessPartner partner) {
        set(PROPERTY_PARTNER, partner);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getMovementtype() {
        return (String) get(PROPERTY_MOVEMENTTYPE);
    }

    public void setMovementtype(String movementtype) {
        set(PROPERTY_MOVEMENTTYPE, movementtype);
    }

    public Date getMovementdate() {
        return (Date) get(PROPERTY_MOVEMENTDATE);
    }

    public void setMovementdate(Date movementdate) {
        set(PROPERTY_MOVEMENTDATE, movementdate);
    }

    public Boolean isLogistic() {
        return (Boolean) get(PROPERTY_ISLOGISTIC);
    }

    public void setLogistic(Boolean islogistic) {
        set(PROPERTY_ISLOGISTIC, islogistic);
    }

    public ShippingCompany getShipper() {
        return (ShippingCompany) get(PROPERTY_SHIPPER);
    }

    public void setShipper(ShippingCompany shipper) {
        set(PROPERTY_SHIPPER, shipper);
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

    public ProjectTask getProjecttask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjecttask(ProjectTask projecttask) {
        set(PROPERTY_PROJECTTASK, projecttask);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public OrderLine getOrderline() {
        return (OrderLine) get(PROPERTY_ORDERLINE);
    }

    public void setOrderline(OrderLine orderline) {
        set(PROPERTY_ORDERLINE, orderline);
    }

    public ShipmentInOutLine getInoutline() {
        return (ShipmentInOutLine) get(PROPERTY_INOUTLINE);
    }

    public void setInoutline(ShipmentInOutLine inoutline) {
        set(PROPERTY_INOUTLINE, inoutline);
    }

    public Locator getLocator() {
        return (Locator) get(PROPERTY_LOCATOR);
    }

    public void setLocator(Locator locator) {
        set(PROPERTY_LOCATOR, locator);
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

    public BigDecimal getMovementqty() {
        return (BigDecimal) get(PROPERTY_MOVEMENTQTY);
    }

    public void setMovementqty(BigDecimal movementqty) {
        set(PROPERTY_MOVEMENTQTY, movementqty);
    }

    public Boolean isInvoiced() {
        return (Boolean) get(PROPERTY_ISINVOICED);
    }

    public void setInvoiced(Boolean isinvoiced) {
        set(PROPERTY_ISINVOICED, isinvoiced);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public String getSerialnumber() {
        return (String) get(PROPERTY_SERIALNUMBER);
    }

    public void setSerialnumber(String serialnumber) {
        set(PROPERTY_SERIALNUMBER, serialnumber);
    }

    public String getSnremployee() {
        return (String) get(PROPERTY_SNREMPLOYEE);
    }

    public void setSnremployee(String snremployee) {
        set(PROPERTY_SNREMPLOYEE, snremployee);
    }

    public String getEmployee() {
        return (String) get(PROPERTY_EMPLOYEE);
    }

    public void setEmployee(String employee) {
        set(PROPERTY_EMPLOYEE, employee);
    }

    public Boolean isProcessbutton() {
        return (Boolean) get(PROPERTY_PROCESSBUTTON);
    }

    public void setProcessbutton(Boolean processbutton) {
        set(PROPERTY_PROCESSBUTTON, processbutton);
    }

    @SuppressWarnings("unchecked")
    public List<org.openz.internallogistic.ils_snrinoutline_v> getIlsSnrinoutlineVList() {
        return (List<org.openz.internallogistic.ils_snrinoutline_v>) get(PROPERTY_ILSSNRINOUTLINEVLIST);
    }

    public void setIlsSnrinoutlineVList(
        List<org.openz.internallogistic.ils_snrinoutline_v> ilsSnrinoutlineVList) {
        set(PROPERTY_ILSSNRINOUTLINEVLIST, ilsSnrinoutlineVList);
    }
}
