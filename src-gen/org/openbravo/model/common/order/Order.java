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
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.gl.GLCharge;
import org.openbravo.model.financialmgmt.payment.DebtPayment;
import org.openbravo.model.financialmgmt.payment.Incoterms;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.project.ProjectTask;
import org.openbravo.model.shipping.ShippingCompany;
import org.openbravo.zsoft.smartui.Zssi_order_textmodule;

import org.zsoft.juwimm.Juwimmorderstatuscontrollingv;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity Order (stored in table C_Order).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Order extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Order";
    public static final String ENTITY_NAME = "Order";
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
    public static final String PROPERTY_DOCSTATUS = "docStatus";
    public static final String PROPERTY_DOCACTION = "docAction";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_DOCTYPE = "docType";
    public static final String PROPERTY_DOCTYPETARGET = "docTypeTarget";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ISDELIVERED = "isDelivered";
    public static final String PROPERTY_ISINVOICED = "isInvoiced";
    public static final String PROPERTY_ISPRINTED = "isPrinted";
    public static final String PROPERTY_ISSELECTED = "isSelected";
    public static final String PROPERTY_SALESREP = "salesRep";
    public static final String PROPERTY_DATEORDERED = "dateOrdered";
    public static final String PROPERTY_DATEPROMISED = "datePromised";
    public static final String PROPERTY_DATEPRINTED = "datePrinted";
    public static final String PROPERTY_DATEACCT = "dateAcct";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_BILLTO = "billTo";
    public static final String PROPERTY_BPARTNERLOCATION = "bPartnerLocation";
    public static final String PROPERTY_POREFERENCE = "pOReference";
    public static final String PROPERTY_ISDISCOUNTPRINTED = "isDiscountPrinted";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_PAYMENTRULE = "paymentRule";
    public static final String PROPERTY_PAYMENTTERM = "paymentTerm";
    public static final String PROPERTY_INVOICERULE = "invoiceRule";
    public static final String PROPERTY_DELIVERYRULE = "deliveryRule";
    public static final String PROPERTY_FREIGHTCOSTRULE = "freightCostRule";
    public static final String PROPERTY_FREIGHTAMT = "freightAmt";
    public static final String PROPERTY_DELIVERYVIARULE = "deliveryViaRule";
    public static final String PROPERTY_SHIPPER = "shipper";
    public static final String PROPERTY_CHARGE = "charge";
    public static final String PROPERTY_CHARGEAMT = "chargeAmt";
    public static final String PROPERTY_PRIORITYRULE = "priorityRule";
    public static final String PROPERTY_TOTALLINES = "totalLines";
    public static final String PROPERTY_GRANDTOTAL = "grandTotal";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_ISTAXINCLUDED = "isTaxIncluded";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_COPYFROM = "copyFrom";
    public static final String PROPERTY_DROPSHIPBPARTNER = "dropShipBPartner";
    public static final String PROPERTY_DROPSHIPLOCATION = "dropShipLocation";
    public static final String PROPERTY_DROPSHIPUSER = "dropShipUser";
    public static final String PROPERTY_ISSELFSERVICE = "isSelfService";
    public static final String PROPERTY_ORGTRX = "orgTrx";
    public static final String PROPERTY_USER1 = "user1";
    public static final String PROPERTY_USER2 = "user2";
    public static final String PROPERTY_DELIVERYNOTES = "deliverynotes";
    public static final String PROPERTY_INCOTERMS = "incoterms";
    public static final String PROPERTY_INCOTERMSDESCRIPTION =
        "incotermsdescription";
    public static final String PROPERTY_GENERATETEMPLATE = "generatetemplate";
    public static final String PROPERTY_DELIVERYLOCATION = "deliveryLocation";
    public static final String PROPERTY_COPYFROMPO = "copyFromPO";
    public static final String PROPERTY_BIDPROJECT = "bidproject";
    public static final String PROPERTY_PROJECTPHASE = "projectphase";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_WEIGHT = "weight";
    public static final String PROPERTY_QTY = "qty";
    public static final String PROPERTY_WEIGHTUOM = "weightUom";
    public static final String PROPERTY_BPZIPCODE = "bpzipcode";
    public static final String PROPERTY_GENERATEPROJECT = "generateproject";
    public static final String PROPERTY_CLOSEPROJECT = "closeproject";
    public static final String PROPERTY_ESTPROPABILITY = "estpropability";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PROPOSALSTATUS = "proposalstatus";
    public static final String PROPERTY_ORDERSELFJOIN = "orderselfjoin";
    public static final String PROPERTY_LOSTPROPOSALREASON =
        "lostproposalreason";
    public static final String PROPERTY_LOSTPROPOSALFIXEDREASON =
        "lostproposalfixedreason";
    public static final String PROPERTY_INVOICEFREQUENCE = "invoicefrequence";
    public static final String PROPERTY_CONTRACTDATE = "contractdate";
    public static final String PROPERTY_ENDDATE = "enddate";
    public static final String PROPERTY_TOTALLINESONETIME = "totallinesonetime";
    public static final String PROPERTY_GRANDTOTALONETIME = "grandtotalonetime";
    public static final String PROPERTY_YEARLYMONTH = "yearlyMonth";
    public static final String PROPERTY_WEEKLYDAY = "weeklyDay";
    public static final String PROPERTY_MONTHLYDAY = "monthlyDay";
    public static final String PROPERTY_QUARTERLYMONTH = "quarterlyMonth";
    public static final String PROPERTY_INVOICEDAMT = "invoicedamt";
    public static final String PROPERTY_COMPLETEORDERVALUE =
        "completeordervalue";
    public static final String PROPERTY_ISINVOICEAFTERFIRSTCYCLE =
        "isinvoiceafterfirstcycle";
    public static final String PROPERTY_SCHEDDELIVERYDATE = "scheddeliverydate";
    public static final String PROPERTY_FIRSTSCHEDINVOICEDATE =
        "firstschedinvoicedate";
    public static final String PROPERTY_SCHEDTRANSACTIONDATE =
        "schedtransactiondate";
    public static final String PROPERTY_TRANSACTIONDATE = "transactiondate";
    public static final String PROPERTY_ISCOMPLETELYINVOICED =
        "iscompletelyinvoiced";
    public static final String PROPERTY_TOTALPAID = "totalpaid";
    public static final String PROPERTY_ISPAID = "ispaid";
    public static final String PROPERTY_ISRECHARGE = "isrecharge";
    public static final String PROPERTY_INTERNALNOTE = "internalnote";
    public static final String PROPERTY_BTNCOPYTEMPLATE = "btnCopyTemplate";
    public static final String PROPERTY_SUBSCRIPTIONCHANGEDATE =
        "subscriptionchangedate";
    public static final String PROPERTY_TRANSACTIONREFERENCE =
        "transactionreference";
    public static final String PROPERTY_DELIVERYCOMPLETE = "deliverycomplete";
    public static final String PROPERTY_DELIVER2PROJECTADRESS =
        "deliver2projectadress";
    public static final String PROPERTY_ORDERPAYMENTSCHEDULELIST =
        "orderPaymentscheduleList";
    public static final String PROPERTY_ORDERLINELIST = "orderLineList";
    public static final String PROPERTY_JUWIMMORDERSTATUSLIST =
        "juwimmOrderstatusList";
    public static final String PROPERTY_ILSINOUTVLIST = "ilsInoutVList";
    public static final String PROPERTY_ORDERTAXLIST = "orderTaxList";
    public static final String PROPERTY_SUBSCRIPTIONINTERVALLINESVIEWCSUBSCRIPTIONINTERVALVIEWIDLIST =
        "subscriptionintervallinesViewCSubscriptionintervalViewIDList";
    public static final String PROPERTY_ZSSIQTYOVERVIEWLIST =
        "zssiQtyoverviewList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST =
        "materialMgmtShipmentInOutList";
    public static final String PROPERTY_ZSSIORDERTEXTMODULELIST =
        "zssiOrderTextmoduleList";
    public static final String PROPERTY_JUWIMMORDERSTATUSCONTROLLINGVLIST =
        "juwimmOrderstatusControllingVList";
    public static final String PROPERTY_FRAMECONTRACTOVERVIEWLIST =
        "framecontractoverviewList";
    public static final String PROPERTY_ILSINOUTPACKAGEVLIST =
        "ilsInoutpackageVList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST =
        "financialMgmtDebtPaymentList";

    public Order() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_DOCSTATUS, "DR");
        setDefaultValue(PROPERTY_DOCACTION, "CO");
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_ISDELIVERED, false);
        setDefaultValue(PROPERTY_ISINVOICED, false);
        setDefaultValue(PROPERTY_ISPRINTED, false);
        setDefaultValue(PROPERTY_ISSELECTED, false);
        setDefaultValue(PROPERTY_ISDISCOUNTPRINTED, false);
        setDefaultValue(PROPERTY_PAYMENTRULE, "B");
        setDefaultValue(PROPERTY_INVOICERULE, "D");
        setDefaultValue(PROPERTY_DELIVERYRULE, "A");
        setDefaultValue(PROPERTY_FREIGHTCOSTRULE, "I");
        setDefaultValue(PROPERTY_DELIVERYVIARULE, "P");
        setDefaultValue(PROPERTY_CHARGEAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_PRIORITYRULE, "5");
        setDefaultValue(PROPERTY_ISTAXINCLUDED, false);
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_COPYFROM, false);
        setDefaultValue(PROPERTY_ISSELFSERVICE, false);
        setDefaultValue(PROPERTY_GENERATETEMPLATE, false);
        setDefaultValue(PROPERTY_COPYFROMPO, false);
        setDefaultValue(PROPERTY_GENERATEPROJECT, false);
        setDefaultValue(PROPERTY_CLOSEPROJECT, false);
        setDefaultValue(PROPERTY_PROPOSALSTATUS, "OP");
        setDefaultValue(PROPERTY_TOTALLINESONETIME, new BigDecimal(0));
        setDefaultValue(PROPERTY_GRANDTOTALONETIME, new BigDecimal(0));
        setDefaultValue(PROPERTY_INVOICEDAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_COMPLETEORDERVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISINVOICEAFTERFIRSTCYCLE, true);
        setDefaultValue(PROPERTY_ISCOMPLETELYINVOICED, false);
        setDefaultValue(PROPERTY_TOTALPAID, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISPAID, false);
        setDefaultValue(PROPERTY_ISRECHARGE, true);
        setDefaultValue(PROPERTY_BTNCOPYTEMPLATE, false);
        setDefaultValue(PROPERTY_DELIVERYCOMPLETE, false);
        setDefaultValue(PROPERTY_DELIVER2PROJECTADRESS, false);
        setDefaultValue(PROPERTY_ORDERPAYMENTSCHEDULELIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_JUWIMMORDERSTATUSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ILSINOUTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERTAXLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SUBSCRIPTIONINTERVALLINESVIEWCSUBSCRIPTIONINTERVALVIEWIDLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSSIQTYOVERVIEWLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSSIORDERTEXTMODULELIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_JUWIMMORDERSTATUSCONTROLLINGVLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FRAMECONTRACTOVERVIEWLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ILSINOUTPACKAGEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST,
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

    public String getDocStatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocStatus(String docStatus) {
        set(PROPERTY_DOCSTATUS, docStatus);
    }

    public String getDocAction() {
        return (String) get(PROPERTY_DOCACTION);
    }

    public void setDocAction(String docAction) {
        set(PROPERTY_DOCACTION, docAction);
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

    public DocumentType getDocTypeTarget() {
        return (DocumentType) get(PROPERTY_DOCTYPETARGET);
    }

    public void setDocTypeTarget(DocumentType docTypeTarget) {
        set(PROPERTY_DOCTYPETARGET, docTypeTarget);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isDelivered() {
        return (Boolean) get(PROPERTY_ISDELIVERED);
    }

    public void setDelivered(Boolean isDelivered) {
        set(PROPERTY_ISDELIVERED, isDelivered);
    }

    public Boolean isInvoiced() {
        return (Boolean) get(PROPERTY_ISINVOICED);
    }

    public void setInvoiced(Boolean isInvoiced) {
        set(PROPERTY_ISINVOICED, isInvoiced);
    }

    public Boolean isPrinted() {
        return (Boolean) get(PROPERTY_ISPRINTED);
    }

    public void setPrinted(Boolean isPrinted) {
        set(PROPERTY_ISPRINTED, isPrinted);
    }

    public Boolean isSelected() {
        return (Boolean) get(PROPERTY_ISSELECTED);
    }

    public void setSelected(Boolean isSelected) {
        set(PROPERTY_ISSELECTED, isSelected);
    }

    public User getSalesRep() {
        return (User) get(PROPERTY_SALESREP);
    }

    public void setSalesRep(User salesRep) {
        set(PROPERTY_SALESREP, salesRep);
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

    public Date getDatePrinted() {
        return (Date) get(PROPERTY_DATEPRINTED);
    }

    public void setDatePrinted(Date datePrinted) {
        set(PROPERTY_DATEPRINTED, datePrinted);
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

    public Location getBillTo() {
        return (Location) get(PROPERTY_BILLTO);
    }

    public void setBillTo(Location billTo) {
        set(PROPERTY_BILLTO, billTo);
    }

    public Location getBPartnerLocation() {
        return (Location) get(PROPERTY_BPARTNERLOCATION);
    }

    public void setBPartnerLocation(Location bPartnerLocation) {
        set(PROPERTY_BPARTNERLOCATION, bPartnerLocation);
    }

    public String getPOReference() {
        return (String) get(PROPERTY_POREFERENCE);
    }

    public void setPOReference(String pOReference) {
        set(PROPERTY_POREFERENCE, pOReference);
    }

    public Boolean isDiscountPrinted() {
        return (Boolean) get(PROPERTY_ISDISCOUNTPRINTED);
    }

    public void setDiscountPrinted(Boolean isDiscountPrinted) {
        set(PROPERTY_ISDISCOUNTPRINTED, isDiscountPrinted);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public String getPaymentRule() {
        return (String) get(PROPERTY_PAYMENTRULE);
    }

    public void setPaymentRule(String paymentRule) {
        set(PROPERTY_PAYMENTRULE, paymentRule);
    }

    public PaymentTerm getPaymentTerm() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERM);
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        set(PROPERTY_PAYMENTTERM, paymentTerm);
    }

    public String getInvoiceRule() {
        return (String) get(PROPERTY_INVOICERULE);
    }

    public void setInvoiceRule(String invoiceRule) {
        set(PROPERTY_INVOICERULE, invoiceRule);
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

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
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

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public Boolean isCopyFrom() {
        return (Boolean) get(PROPERTY_COPYFROM);
    }

    public void setCopyFrom(Boolean copyFrom) {
        set(PROPERTY_COPYFROM, copyFrom);
    }

    public BusinessPartner getDropShipBPartner() {
        return (BusinessPartner) get(PROPERTY_DROPSHIPBPARTNER);
    }

    public void setDropShipBPartner(BusinessPartner dropShipBPartner) {
        set(PROPERTY_DROPSHIPBPARTNER, dropShipBPartner);
    }

    public Location getDropShipLocation() {
        return (Location) get(PROPERTY_DROPSHIPLOCATION);
    }

    public void setDropShipLocation(Location dropShipLocation) {
        set(PROPERTY_DROPSHIPLOCATION, dropShipLocation);
    }

    public User getDropShipUser() {
        return (User) get(PROPERTY_DROPSHIPUSER);
    }

    public void setDropShipUser(User dropShipUser) {
        set(PROPERTY_DROPSHIPUSER, dropShipUser);
    }

    public Boolean isSelfService() {
        return (Boolean) get(PROPERTY_ISSELFSERVICE);
    }

    public void setSelfService(Boolean isSelfService) {
        set(PROPERTY_ISSELFSERVICE, isSelfService);
    }

    public Organization getOrgTrx() {
        return (Organization) get(PROPERTY_ORGTRX);
    }

    public void setOrgTrx(Organization orgTrx) {
        set(PROPERTY_ORGTRX, orgTrx);
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

    public String getDeliverynotes() {
        return (String) get(PROPERTY_DELIVERYNOTES);
    }

    public void setDeliverynotes(String deliverynotes) {
        set(PROPERTY_DELIVERYNOTES, deliverynotes);
    }

    public Incoterms getIncoterms() {
        return (Incoterms) get(PROPERTY_INCOTERMS);
    }

    public void setIncoterms(Incoterms incoterms) {
        set(PROPERTY_INCOTERMS, incoterms);
    }

    public String getIncotermsdescription() {
        return (String) get(PROPERTY_INCOTERMSDESCRIPTION);
    }

    public void setIncotermsdescription(String incotermsdescription) {
        set(PROPERTY_INCOTERMSDESCRIPTION, incotermsdescription);
    }

    public Boolean isGeneratetemplate() {
        return (Boolean) get(PROPERTY_GENERATETEMPLATE);
    }

    public void setGeneratetemplate(Boolean generatetemplate) {
        set(PROPERTY_GENERATETEMPLATE, generatetemplate);
    }

    public Location getDeliveryLocation() {
        return (Location) get(PROPERTY_DELIVERYLOCATION);
    }

    public void setDeliveryLocation(Location deliveryLocation) {
        set(PROPERTY_DELIVERYLOCATION, deliveryLocation);
    }

    public Boolean isCopyFromPO() {
        return (Boolean) get(PROPERTY_COPYFROMPO);
    }

    public void setCopyFromPO(Boolean copyFromPO) {
        set(PROPERTY_COPYFROMPO, copyFromPO);
    }

    public Project getBidproject() {
        return (Project) get(PROPERTY_BIDPROJECT);
    }

    public void setBidproject(Project bidproject) {
        set(PROPERTY_BIDPROJECT, bidproject);
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

    public String getBpzipcode() {
        return (String) get(PROPERTY_BPZIPCODE);
    }

    public void setBpzipcode(String bpzipcode) {
        set(PROPERTY_BPZIPCODE, bpzipcode);
    }

    public Boolean isGenerateproject() {
        return (Boolean) get(PROPERTY_GENERATEPROJECT);
    }

    public void setGenerateproject(Boolean generateproject) {
        set(PROPERTY_GENERATEPROJECT, generateproject);
    }

    public Boolean isCloseproject() {
        return (Boolean) get(PROPERTY_CLOSEPROJECT);
    }

    public void setCloseproject(Boolean closeproject) {
        set(PROPERTY_CLOSEPROJECT, closeproject);
    }

    public String getEstpropability() {
        return (String) get(PROPERTY_ESTPROPABILITY);
    }

    public void setEstpropability(String estpropability) {
        set(PROPERTY_ESTPROPABILITY, estpropability);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getProposalstatus() {
        return (String) get(PROPERTY_PROPOSALSTATUS);
    }

    public void setProposalstatus(String proposalstatus) {
        set(PROPERTY_PROPOSALSTATUS, proposalstatus);
    }

    public Order getOrderselfjoin() {
        return (Order) get(PROPERTY_ORDERSELFJOIN);
    }

    public void setOrderselfjoin(Order orderselfjoin) {
        set(PROPERTY_ORDERSELFJOIN, orderselfjoin);
    }

    public String getLostproposalreason() {
        return (String) get(PROPERTY_LOSTPROPOSALREASON);
    }

    public void setLostproposalreason(String lostproposalreason) {
        set(PROPERTY_LOSTPROPOSALREASON, lostproposalreason);
    }

    public String getLostproposalfixedreason() {
        return (String) get(PROPERTY_LOSTPROPOSALFIXEDREASON);
    }

    public void setLostproposalfixedreason(String lostproposalfixedreason) {
        set(PROPERTY_LOSTPROPOSALFIXEDREASON, lostproposalfixedreason);
    }

    public String getInvoicefrequence() {
        return (String) get(PROPERTY_INVOICEFREQUENCE);
    }

    public void setInvoicefrequence(String invoicefrequence) {
        set(PROPERTY_INVOICEFREQUENCE, invoicefrequence);
    }

    public Date getContractdate() {
        return (Date) get(PROPERTY_CONTRACTDATE);
    }

    public void setContractdate(Date contractdate) {
        set(PROPERTY_CONTRACTDATE, contractdate);
    }

    public Date getEnddate() {
        return (Date) get(PROPERTY_ENDDATE);
    }

    public void setEnddate(Date enddate) {
        set(PROPERTY_ENDDATE, enddate);
    }

    public BigDecimal getTotallinesonetime() {
        return (BigDecimal) get(PROPERTY_TOTALLINESONETIME);
    }

    public void setTotallinesonetime(BigDecimal totallinesonetime) {
        set(PROPERTY_TOTALLINESONETIME, totallinesonetime);
    }

    public BigDecimal getGrandtotalonetime() {
        return (BigDecimal) get(PROPERTY_GRANDTOTALONETIME);
    }

    public void setGrandtotalonetime(BigDecimal grandtotalonetime) {
        set(PROPERTY_GRANDTOTALONETIME, grandtotalonetime);
    }

    public String getYearlyMonth() {
        return (String) get(PROPERTY_YEARLYMONTH);
    }

    public void setYearlyMonth(String yearlyMonth) {
        set(PROPERTY_YEARLYMONTH, yearlyMonth);
    }

    public String getWeeklyDay() {
        return (String) get(PROPERTY_WEEKLYDAY);
    }

    public void setWeeklyDay(String weeklyDay) {
        set(PROPERTY_WEEKLYDAY, weeklyDay);
    }

    public Long getMonthlyDay() {
        return (Long) get(PROPERTY_MONTHLYDAY);
    }

    public void setMonthlyDay(Long monthlyDay) {
        set(PROPERTY_MONTHLYDAY, monthlyDay);
    }

    public String getQuarterlyMonth() {
        return (String) get(PROPERTY_QUARTERLYMONTH);
    }

    public void setQuarterlyMonth(String quarterlyMonth) {
        set(PROPERTY_QUARTERLYMONTH, quarterlyMonth);
    }

    public BigDecimal getInvoicedamt() {
        return (BigDecimal) get(PROPERTY_INVOICEDAMT);
    }

    public void setInvoicedamt(BigDecimal invoicedamt) {
        set(PROPERTY_INVOICEDAMT, invoicedamt);
    }

    public BigDecimal getCompleteordervalue() {
        return (BigDecimal) get(PROPERTY_COMPLETEORDERVALUE);
    }

    public void setCompleteordervalue(BigDecimal completeordervalue) {
        set(PROPERTY_COMPLETEORDERVALUE, completeordervalue);
    }

    public Boolean isInvoiceafterfirstcycle() {
        return (Boolean) get(PROPERTY_ISINVOICEAFTERFIRSTCYCLE);
    }

    public void setInvoiceafterfirstcycle(Boolean isinvoiceafterfirstcycle) {
        set(PROPERTY_ISINVOICEAFTERFIRSTCYCLE, isinvoiceafterfirstcycle);
    }

    public Date getScheddeliverydate() {
        return (Date) get(PROPERTY_SCHEDDELIVERYDATE);
    }

    public void setScheddeliverydate(Date scheddeliverydate) {
        set(PROPERTY_SCHEDDELIVERYDATE, scheddeliverydate);
    }

    public Date getFirstschedinvoicedate() {
        return (Date) get(PROPERTY_FIRSTSCHEDINVOICEDATE);
    }

    public void setFirstschedinvoicedate(Date firstschedinvoicedate) {
        set(PROPERTY_FIRSTSCHEDINVOICEDATE, firstschedinvoicedate);
    }

    public Date getSchedtransactiondate() {
        return (Date) get(PROPERTY_SCHEDTRANSACTIONDATE);
    }

    public void setSchedtransactiondate(Date schedtransactiondate) {
        set(PROPERTY_SCHEDTRANSACTIONDATE, schedtransactiondate);
    }

    public Date getTransactiondate() {
        return (Date) get(PROPERTY_TRANSACTIONDATE);
    }

    public void setTransactiondate(Date transactiondate) {
        set(PROPERTY_TRANSACTIONDATE, transactiondate);
    }

    public Boolean isCompletelyinvoiced() {
        return (Boolean) get(PROPERTY_ISCOMPLETELYINVOICED);
    }

    public void setCompletelyinvoiced(Boolean iscompletelyinvoiced) {
        set(PROPERTY_ISCOMPLETELYINVOICED, iscompletelyinvoiced);
    }

    public BigDecimal getTotalpaid() {
        return (BigDecimal) get(PROPERTY_TOTALPAID);
    }

    public void setTotalpaid(BigDecimal totalpaid) {
        set(PROPERTY_TOTALPAID, totalpaid);
    }

    public Boolean isPaid() {
        return (Boolean) get(PROPERTY_ISPAID);
    }

    public void setPaid(Boolean ispaid) {
        set(PROPERTY_ISPAID, ispaid);
    }

    public Boolean isRecharge() {
        return (Boolean) get(PROPERTY_ISRECHARGE);
    }

    public void setRecharge(Boolean isrecharge) {
        set(PROPERTY_ISRECHARGE, isrecharge);
    }

    public String getInternalnote() {
        return (String) get(PROPERTY_INTERNALNOTE);
    }

    public void setInternalnote(String internalnote) {
        set(PROPERTY_INTERNALNOTE, internalnote);
    }

    public Boolean isBtnCopyTemplate() {
        return (Boolean) get(PROPERTY_BTNCOPYTEMPLATE);
    }

    public void setBtnCopyTemplate(Boolean btnCopyTemplate) {
        set(PROPERTY_BTNCOPYTEMPLATE, btnCopyTemplate);
    }

    public Date getSubscriptionchangedate() {
        return (Date) get(PROPERTY_SUBSCRIPTIONCHANGEDATE);
    }

    public void setSubscriptionchangedate(Date subscriptionchangedate) {
        set(PROPERTY_SUBSCRIPTIONCHANGEDATE, subscriptionchangedate);
    }

    public String getTransactionreference() {
        return (String) get(PROPERTY_TRANSACTIONREFERENCE);
    }

    public void setTransactionreference(String transactionreference) {
        set(PROPERTY_TRANSACTIONREFERENCE, transactionreference);
    }

    public Boolean isDeliverycomplete() {
        return (Boolean) get(PROPERTY_DELIVERYCOMPLETE);
    }

    public void setDeliverycomplete(Boolean deliverycomplete) {
        set(PROPERTY_DELIVERYCOMPLETE, deliverycomplete);
    }

    public Boolean isDeliver2projectadress() {
        return (Boolean) get(PROPERTY_DELIVER2PROJECTADRESS);
    }

    public void setDeliver2projectadress(Boolean deliver2projectadress) {
        set(PROPERTY_DELIVER2PROJECTADRESS, deliver2projectadress);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.order.C_order_paymentschedule> getOrderPaymentscheduleList() {
        return (List<org.openbravo.model.common.order.C_order_paymentschedule>) get(PROPERTY_ORDERPAYMENTSCHEDULELIST);
    }

    public void setOrderPaymentscheduleList(
        List<org.openbravo.model.common.order.C_order_paymentschedule> orderPaymentscheduleList) {
        set(PROPERTY_ORDERPAYMENTSCHEDULELIST, orderPaymentscheduleList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLine> getOrderLineList() {
        return (List<OrderLine>) get(PROPERTY_ORDERLINELIST);
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        set(PROPERTY_ORDERLINELIST, orderLineList);
    }

    @SuppressWarnings("unchecked")
    public List<org.zsoft.juwimm.juwimm_orderstatus> getJuwimmOrderstatusList() {
        return (List<org.zsoft.juwimm.juwimm_orderstatus>) get(PROPERTY_JUWIMMORDERSTATUSLIST);
    }

    public void setJuwimmOrderstatusList(
        List<org.zsoft.juwimm.juwimm_orderstatus> juwimmOrderstatusList) {
        set(PROPERTY_JUWIMMORDERSTATUSLIST, juwimmOrderstatusList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openz.internallogistic.ils_inout_v> getIlsInoutVList() {
        return (List<org.openz.internallogistic.ils_inout_v>) get(PROPERTY_ILSINOUTVLIST);
    }

    public void setIlsInoutVList(
        List<org.openz.internallogistic.ils_inout_v> ilsInoutVList) {
        set(PROPERTY_ILSINOUTVLIST, ilsInoutVList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderTax> getOrderTaxList() {
        return (List<OrderTax>) get(PROPERTY_ORDERTAXLIST);
    }

    public void setOrderTaxList(List<OrderTax> orderTaxList) {
        set(PROPERTY_ORDERTAXLIST, orderTaxList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.sales.c_subscriptionintervallines_view> getSubscriptionintervallinesViewCSubscriptionintervalViewIDList() {
        return (List<org.openbravo.model.sales.c_subscriptionintervallines_view>) get(PROPERTY_SUBSCRIPTIONINTERVALLINESVIEWCSUBSCRIPTIONINTERVALVIEWIDLIST);
    }

    public void setSubscriptionintervallinesViewCSubscriptionintervalViewIDList(
        List<org.openbravo.model.sales.c_subscriptionintervallines_view> subscriptionintervallinesViewCSubscriptionintervalViewIDList) {
        set(PROPERTY_SUBSCRIPTIONINTERVALLINESVIEWCSUBSCRIPTIONINTERVALVIEWIDLIST,
            subscriptionintervallinesViewCSubscriptionintervalViewIDList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.zsoft.smartui.zssi_qtyoverview> getZssiQtyoverviewList() {
        return (List<org.openbravo.zsoft.smartui.zssi_qtyoverview>) get(PROPERTY_ZSSIQTYOVERVIEWLIST);
    }

    public void setZssiQtyoverviewList(
        List<org.openbravo.zsoft.smartui.zssi_qtyoverview> zssiQtyoverviewList) {
        set(PROPERTY_ZSSIQTYOVERVIEWLIST, zssiQtyoverviewList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOut> getMaterialMgmtShipmentInOutList() {
        return (List<ShipmentInOut>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST);
    }

    public void setMaterialMgmtShipmentInOutList(
        List<ShipmentInOut> materialMgmtShipmentInOutList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST,
            materialMgmtShipmentInOutList);
    }

    @SuppressWarnings("unchecked")
    public List<Zssi_order_textmodule> getZssiOrderTextmoduleList() {
        return (List<Zssi_order_textmodule>) get(PROPERTY_ZSSIORDERTEXTMODULELIST);
    }

    public void setZssiOrderTextmoduleList(
        List<Zssi_order_textmodule> zssiOrderTextmoduleList) {
        set(PROPERTY_ZSSIORDERTEXTMODULELIST, zssiOrderTextmoduleList);
    }

    @SuppressWarnings("unchecked")
    public List<Juwimmorderstatuscontrollingv> getJuwimmOrderstatusControllingVList() {
        return (List<Juwimmorderstatuscontrollingv>) get(PROPERTY_JUWIMMORDERSTATUSCONTROLLINGVLIST);
    }

    public void setJuwimmOrderstatusControllingVList(
        List<Juwimmorderstatuscontrollingv> juwimmOrderstatusControllingVList) {
        set(PROPERTY_JUWIMMORDERSTATUSCONTROLLINGVLIST,
            juwimmOrderstatusControllingVList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.order.c_framecontractoverview> getFramecontractoverviewList() {
        return (List<org.openbravo.model.common.order.c_framecontractoverview>) get(PROPERTY_FRAMECONTRACTOVERVIEWLIST);
    }

    public void setFramecontractoverviewList(
        List<org.openbravo.model.common.order.c_framecontractoverview> framecontractoverviewList) {
        set(PROPERTY_FRAMECONTRACTOVERVIEWLIST, framecontractoverviewList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openz.internallogistic.ils_inoutpackage_v> getIlsInoutpackageVList() {
        return (List<org.openz.internallogistic.ils_inoutpackage_v>) get(PROPERTY_ILSINOUTPACKAGEVLIST);
    }

    public void setIlsInoutpackageVList(
        List<org.openz.internallogistic.ils_inoutpackage_v> ilsInoutpackageVList) {
        set(PROPERTY_ILSINOUTPACKAGEVLIST, ilsInoutpackageVList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPayment> getFinancialMgmtDebtPaymentList() {
        return (List<DebtPayment>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST);
    }

    public void setFinancialMgmtDebtPaymentList(
        List<DebtPayment> financialMgmtDebtPaymentList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST, financialMgmtDebtPaymentList);
    }
}
