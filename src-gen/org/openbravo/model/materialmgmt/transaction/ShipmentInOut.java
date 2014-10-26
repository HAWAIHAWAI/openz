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
package org.openbravo.model.materialmgmt.transaction;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.gl.GLCharge;
import org.openbravo.model.financialmgmt.payment.Incoterms;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectTask;
import org.openbravo.model.shipping.ShippingCompany;
import org.openbravo.zsoft.smartui.Zssi_minout_textmodule;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity MaterialMgmtShipmentInOut (stored in table M_InOut).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ShipmentInOut extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_InOut";
    public static final String ENTITY_NAME = "MaterialMgmtShipmentInOut";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ISSOTRX = "isSOTrx";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DOCACTION = "docAction";
    public static final String PROPERTY_DOCSTATUS = "docStatus";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_DOCTYPE = "docType";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_DATEORDERED = "dateOrdered";
    public static final String PROPERTY_ISPRINTED = "isPrinted";
    public static final String PROPERTY_MOVEMENTTYPE = "movementType";
    public static final String PROPERTY_MOVEMENTDATE = "movementDate";
    public static final String PROPERTY_DATEACCT = "dateAcct";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_BPARTNERLOCATION = "bPartnerLocation";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_POREFERENCE = "pOReference";
    public static final String PROPERTY_DELIVERYRULE = "deliveryRule";
    public static final String PROPERTY_FREIGHTCOSTRULE = "freightCostRule";
    public static final String PROPERTY_FREIGHTAMT = "freightAmt";
    public static final String PROPERTY_DELIVERYVIARULE = "deliveryViaRule";
    public static final String PROPERTY_SHIPPER = "shipper";
    public static final String PROPERTY_CHARGE = "charge";
    public static final String PROPERTY_CHARGEAMT = "chargeAmt";
    public static final String PROPERTY_PRIORITYRULE = "priorityRule";
    public static final String PROPERTY_DATEPRINTED = "datePrinted";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_CREATEFROM = "createFrom";
    public static final String PROPERTY_GENERATETO = "generateTo";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_SALESREP = "salesRep";
    public static final String PROPERTY_PICKDATE = "pickDate";
    public static final String PROPERTY_SHIPDATE = "shipDate";
    public static final String PROPERTY_TRACKINGNO = "trackingNo";
    public static final String PROPERTY_ORGTRX = "orgTrx";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_USER1 = "user1";
    public static final String PROPERTY_USER2 = "user2";
    public static final String PROPERTY_UPDATELINES = "updateLines";
    public static final String PROPERTY_ISLOGISTIC = "islogistic";
    public static final String PROPERTY_GENERATELINES = "generateLines";
    public static final String PROPERTY_DELIVERYLOCATION = "deliveryLocation";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_WEIGHT = "weight";
    public static final String PROPERTY_QTY = "qty";
    public static final String PROPERTY_WEIGHTUOM = "weightUom";
    public static final String PROPERTY_INCOTERMS = "incoterms";
    public static final String PROPERTY_SHIPPINGTO = "shippingto";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_DIRECTMAIL = "directmail";
    public static final String PROPERTY_INTERNALNOTE = "internalnote";
    public static final String PROPERTY_QTYOFPALLETS = "qtyofpallets";
    public static final String PROPERTY_ZSSIMINOUTTEXTMODULELIST =
        "zssiMinoutTextmoduleList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEVLIST =
        "materialMgmtShipmentInOutLineVList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST =
        "materialMgmtShipmentInOutLineList";

    public ShipmentInOut() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_DOCACTION, "CO");
        setDefaultValue(PROPERTY_DOCSTATUS, "DR");
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_ISPRINTED, false);
        setDefaultValue(PROPERTY_DELIVERYRULE, "A");
        setDefaultValue(PROPERTY_FREIGHTCOSTRULE, "I");
        setDefaultValue(PROPERTY_FREIGHTAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_CHARGEAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_PRIORITYRULE, "5");
        setDefaultValue(PROPERTY_CREATEFROM, false);
        setDefaultValue(PROPERTY_GENERATETO, false);
        setDefaultValue(PROPERTY_UPDATELINES, false);
        setDefaultValue(PROPERTY_GENERATELINES, false);
        setDefaultValue(PROPERTY_DIRECTMAIL, false);
        setDefaultValue(PROPERTY_ZSSIMINOUTTEXTMODULELIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEVLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST,
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

    public String getDocAction() {
        return (String) get(PROPERTY_DOCACTION);
    }

    public void setDocAction(String docAction) {
        set(PROPERTY_DOCACTION, docAction);
    }

    public String getDocStatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocStatus(String docStatus) {
        set(PROPERTY_DOCSTATUS, docStatus);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public DocumentType getDocType() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDocType(DocumentType docType) {
        set(PROPERTY_DOCTYPE, docType);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

    public Date getDateOrdered() {
        return (Date) get(PROPERTY_DATEORDERED);
    }

    public void setDateOrdered(Date dateOrdered) {
        set(PROPERTY_DATEORDERED, dateOrdered);
    }

    public Boolean isPrinted() {
        return (Boolean) get(PROPERTY_ISPRINTED);
    }

    public void setPrinted(Boolean isPrinted) {
        set(PROPERTY_ISPRINTED, isPrinted);
    }

    public String getMovementType() {
        return (String) get(PROPERTY_MOVEMENTTYPE);
    }

    public void setMovementType(String movementType) {
        set(PROPERTY_MOVEMENTTYPE, movementType);
    }

    public Date getMovementDate() {
        return (Date) get(PROPERTY_MOVEMENTDATE);
    }

    public void setMovementDate(Date movementDate) {
        set(PROPERTY_MOVEMENTDATE, movementDate);
    }

    public Date getDateAcct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateAcct(Date dateAcct) {
        set(PROPERTY_DATEACCT, dateAcct);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public Location getBPartnerLocation() {
        return (Location) get(PROPERTY_BPARTNERLOCATION);
    }

    public void setBPartnerLocation(Location bPartnerLocation) {
        set(PROPERTY_BPARTNERLOCATION, bPartnerLocation);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public String getPOReference() {
        return (String) get(PROPERTY_POREFERENCE);
    }

    public void setPOReference(String pOReference) {
        set(PROPERTY_POREFERENCE, pOReference);
    }

    public String getDeliveryRule() {
        return (String) get(PROPERTY_DELIVERYRULE);
    }

    public void setDeliveryRule(String deliveryRule) {
        set(PROPERTY_DELIVERYRULE, deliveryRule);
    }

    public String getFreightCostRule() {
        return (String) get(PROPERTY_FREIGHTCOSTRULE);
    }

    public void setFreightCostRule(String freightCostRule) {
        set(PROPERTY_FREIGHTCOSTRULE, freightCostRule);
    }

    public BigDecimal getFreightAmt() {
        return (BigDecimal) get(PROPERTY_FREIGHTAMT);
    }

    public void setFreightAmt(BigDecimal freightAmt) {
        set(PROPERTY_FREIGHTAMT, freightAmt);
    }

    public String getDeliveryViaRule() {
        return (String) get(PROPERTY_DELIVERYVIARULE);
    }

    public void setDeliveryViaRule(String deliveryViaRule) {
        set(PROPERTY_DELIVERYVIARULE, deliveryViaRule);
    }

    public ShippingCompany getShipper() {
        return (ShippingCompany) get(PROPERTY_SHIPPER);
    }

    public void setShipper(ShippingCompany shipper) {
        set(PROPERTY_SHIPPER, shipper);
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

    public String getPriorityRule() {
        return (String) get(PROPERTY_PRIORITYRULE);
    }

    public void setPriorityRule(String priorityRule) {
        set(PROPERTY_PRIORITYRULE, priorityRule);
    }

    public Date getDatePrinted() {
        return (Date) get(PROPERTY_DATEPRINTED);
    }

    public void setDatePrinted(Date datePrinted) {
        set(PROPERTY_DATEPRINTED, datePrinted);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public Boolean isCreateFrom() {
        return (Boolean) get(PROPERTY_CREATEFROM);
    }

    public void setCreateFrom(Boolean createFrom) {
        set(PROPERTY_CREATEFROM, createFrom);
    }

    public Boolean isGenerateTo() {
        return (Boolean) get(PROPERTY_GENERATETO);
    }

    public void setGenerateTo(Boolean generateTo) {
        set(PROPERTY_GENERATETO, generateTo);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public User getSalesRep() {
        return (User) get(PROPERTY_SALESREP);
    }

    public void setSalesRep(User salesRep) {
        set(PROPERTY_SALESREP, salesRep);
    }

    public Date getPickDate() {
        return (Date) get(PROPERTY_PICKDATE);
    }

    public void setPickDate(Date pickDate) {
        set(PROPERTY_PICKDATE, pickDate);
    }

    public Date getShipDate() {
        return (Date) get(PROPERTY_SHIPDATE);
    }

    public void setShipDate(Date shipDate) {
        set(PROPERTY_SHIPDATE, shipDate);
    }

    public String getTrackingNo() {
        return (String) get(PROPERTY_TRACKINGNO);
    }

    public void setTrackingNo(String trackingNo) {
        set(PROPERTY_TRACKINGNO, trackingNo);
    }

    public Organization getOrgTrx() {
        return (Organization) get(PROPERTY_ORGTRX);
    }

    public void setOrgTrx(Organization orgTrx) {
        set(PROPERTY_ORGTRX, orgTrx);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Campaign getCampaign() {
        return (Campaign) get(PROPERTY_CAMPAIGN);
    }

    public void setCampaign(Campaign campaign) {
        set(PROPERTY_CAMPAIGN, campaign);
    }

    public ABCActivity getActivity() {
        return (ABCActivity) get(PROPERTY_ACTIVITY);
    }

    public void setActivity(ABCActivity activity) {
        set(PROPERTY_ACTIVITY, activity);
    }

    public String getUser1() {
        return (String) get(PROPERTY_USER1);
    }

    public void setUser1(String user1) {
        set(PROPERTY_USER1, user1);
    }

    public String getUser2() {
        return (String) get(PROPERTY_USER2);
    }

    public void setUser2(String user2) {
        set(PROPERTY_USER2, user2);
    }

    public Boolean isUpdateLines() {
        return (Boolean) get(PROPERTY_UPDATELINES);
    }

    public void setUpdateLines(Boolean updateLines) {
        set(PROPERTY_UPDATELINES, updateLines);
    }

    public Boolean isLogistic() {
        return (Boolean) get(PROPERTY_ISLOGISTIC);
    }

    public void setLogistic(Boolean islogistic) {
        set(PROPERTY_ISLOGISTIC, islogistic);
    }

    public Boolean isGenerateLines() {
        return (Boolean) get(PROPERTY_GENERATELINES);
    }

    public void setGenerateLines(Boolean generateLines) {
        set(PROPERTY_GENERATELINES, generateLines);
    }

    public Location getDeliveryLocation() {
        return (Location) get(PROPERTY_DELIVERYLOCATION);
    }

    public void setDeliveryLocation(Location deliveryLocation) {
        set(PROPERTY_DELIVERYLOCATION, deliveryLocation);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getWeight() {
        return (BigDecimal) get(PROPERTY_WEIGHT);
    }

    public void setWeight(BigDecimal weight) {
        set(PROPERTY_WEIGHT, weight);
    }

    public Long getQty() {
        return (Long) get(PROPERTY_QTY);
    }

    public void setQty(Long qty) {
        set(PROPERTY_QTY, qty);
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

    public String getShippingto() {
        return (String) get(PROPERTY_SHIPPINGTO);
    }

    public void setShippingto(String shippingto) {
        set(PROPERTY_SHIPPINGTO, shippingto);
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

    public Boolean isDirectmail() {
        return (Boolean) get(PROPERTY_DIRECTMAIL);
    }

    public void setDirectmail(Boolean directmail) {
        set(PROPERTY_DIRECTMAIL, directmail);
    }

    public String getInternalnote() {
        return (String) get(PROPERTY_INTERNALNOTE);
    }

    public void setInternalnote(String internalnote) {
        set(PROPERTY_INTERNALNOTE, internalnote);
    }

    public Long getQtyofpallets() {
        return (Long) get(PROPERTY_QTYOFPALLETS);
    }

    public void setQtyofpallets(Long qtyofpallets) {
        set(PROPERTY_QTYOFPALLETS, qtyofpallets);
    }

    @SuppressWarnings("unchecked")
    public List<Zssi_minout_textmodule> getZssiMinoutTextmoduleList() {
        return (List<Zssi_minout_textmodule>) get(PROPERTY_ZSSIMINOUTTEXTMODULELIST);
    }

    public void setZssiMinoutTextmoduleList(
        List<Zssi_minout_textmodule> zssiMinoutTextmoduleList) {
        set(PROPERTY_ZSSIMINOUTTEXTMODULELIST, zssiMinoutTextmoduleList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOutLineV> getMaterialMgmtShipmentInOutLineVList() {
        return (List<ShipmentInOutLineV>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEVLIST);
    }

    public void setMaterialMgmtShipmentInOutLineVList(
        List<ShipmentInOutLineV> materialMgmtShipmentInOutLineVList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEVLIST,
            materialMgmtShipmentInOutLineVList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOutLine> getMaterialMgmtShipmentInOutLineList() {
        return (List<ShipmentInOutLine>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST);
    }

    public void setMaterialMgmtShipmentInOutLineList(
        List<ShipmentInOutLine> materialMgmtShipmentInOutLineList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST,
            materialMgmtShipmentInOutLineList);
    }
}
