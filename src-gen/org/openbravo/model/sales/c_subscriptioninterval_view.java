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
package org.openbravo.model.sales;

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
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.gl.GLCharge;
import org.openbravo.model.financialmgmt.payment.Incoterms;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.project.ProjectTask;
import org.openbravo.model.shipping.ShippingCompany;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity c_subscriptioninterval_view (stored in table c_subscriptioninterval_view).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class c_subscriptioninterval_view extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "c_subscriptioninterval_view";
    public static final String ENTITY_NAME = "c_subscriptioninterval_view";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ISSOTRX = "issotrx";
    public static final String PROPERTY_DOCUMENTNO = "documentno";
    public static final String PROPERTY_DOCSTATUS = "docstatus";
    public static final String PROPERTY_DOCACTION = "docAction";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_DOCTYPETARGET = "doctypetarget";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ISDELIVERED = "isdelivered";
    public static final String PROPERTY_ISINVOICED = "isinvoiced";
    public static final String PROPERTY_ISPRINTED = "isprinted";
    public static final String PROPERTY_SALESREP = "salesrep";
    public static final String PROPERTY_ISSELECTED = "isselected";
    public static final String PROPERTY_DATEORDERED = "dateordered";
    public static final String PROPERTY_DATEPROMISED = "datepromised";
    public static final String PROPERTY_DATEPRINTED = "dateprinted";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_DATEACCT = "dateacct";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_BILLTO = "billto";
    public static final String PROPERTY_BPARTNERLOCATION = "bpartnerLocation";
    public static final String PROPERTY_POREFERENCE = "poreference";
    public static final String PROPERTY_ISDISCOUNTPRINTED = "isdiscountprinted";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_PAYMENTRULE = "paymentrule";
    public static final String PROPERTY_PAYMENTTERM = "paymentterm";
    public static final String PROPERTY_INVOICERULE = "invoicerule";
    public static final String PROPERTY_DELIVERYRULE = "deliveryrule";
    public static final String PROPERTY_FREIGHTCOSTRULE = "freightcostrule";
    public static final String PROPERTY_FREIGHTAMT = "freightamt";
    public static final String PROPERTY_DELIVERYVIARULE = "deliveryviarule";
    public static final String PROPERTY_SHIPPER = "shipper";
    public static final String PROPERTY_CHARGE = "charge";
    public static final String PROPERTY_CHARGEAMT = "chargeamt";
    public static final String PROPERTY_PRIORITYRULE = "priorityrule";
    public static final String PROPERTY_TOTALLINES = "totallines";
    public static final String PROPERTY_GRANDTOTAL = "grandtotal";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_PRICELIST = "pricelist";
    public static final String PROPERTY_ISTAXINCLUDED = "istaxincluded";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_COPYFROM = "copyfrom";
    public static final String PROPERTY_DROPSHIPBPARTNER = "dropshipBpartner";
    public static final String PROPERTY_DROPSHIPLOCATION = "dropshipLocation";
    public static final String PROPERTY_DROPSHIPUSER = "dropshipUser";
    public static final String PROPERTY_ISSELFSERVICE = "isselfservice";
    public static final String PROPERTY_ORGTRX = "orgtrx";
    public static final String PROPERTY_USER1 = "user1";
    public static final String PROPERTY_USER2 = "user2";
    public static final String PROPERTY_DELIVERYNOTES = "deliverynotes";
    public static final String PROPERTY_INCOTERMS = "incoterms";
    public static final String PROPERTY_INCOTERMSDESCRIPTION =
        "incotermsdescription";
    public static final String PROPERTY_GENERATETEMPLATE = "generatetemplate";
    public static final String PROPERTY_DELIVERYLOCATION = "deliveryLocation";
    public static final String PROPERTY_COPYFROMPO = "copyfrompo";
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
    public static final String PROPERTY_BTNCOPYTEMPLATE = "btncopytemplate";

    public c_subscriptioninterval_view() {
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
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getOrder() {
        return (String) get(PROPERTY_ORDER);
    }

    public void setOrder(String order) {
        set(PROPERTY_ORDER, order);
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

    public String getDocumentno() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentno(String documentno) {
        set(PROPERTY_DOCUMENTNO, documentno);
    }

    public String getDocstatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocstatus(String docstatus) {
        set(PROPERTY_DOCSTATUS, docstatus);
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

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public DocumentType getDoctypetarget() {
        return (DocumentType) get(PROPERTY_DOCTYPETARGET);
    }

    public void setDoctypetarget(DocumentType doctypetarget) {
        set(PROPERTY_DOCTYPETARGET, doctypetarget);
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

    public void setDelivered(Boolean isdelivered) {
        set(PROPERTY_ISDELIVERED, isdelivered);
    }

    public Boolean isInvoiced() {
        return (Boolean) get(PROPERTY_ISINVOICED);
    }

    public void setInvoiced(Boolean isinvoiced) {
        set(PROPERTY_ISINVOICED, isinvoiced);
    }

    public Boolean isPrinted() {
        return (Boolean) get(PROPERTY_ISPRINTED);
    }

    public void setPrinted(Boolean isprinted) {
        set(PROPERTY_ISPRINTED, isprinted);
    }

    public User getSalesrep() {
        return (User) get(PROPERTY_SALESREP);
    }

    public void setSalesrep(User salesrep) {
        set(PROPERTY_SALESREP, salesrep);
    }

    public Boolean isSelected() {
        return (Boolean) get(PROPERTY_ISSELECTED);
    }

    public void setSelected(Boolean isselected) {
        set(PROPERTY_ISSELECTED, isselected);
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

    public Date getDateprinted() {
        return (Date) get(PROPERTY_DATEPRINTED);
    }

    public void setDateprinted(Date dateprinted) {
        set(PROPERTY_DATEPRINTED, dateprinted);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Date getDateacct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateacct(Date dateacct) {
        set(PROPERTY_DATEACCT, dateacct);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public Location getBillto() {
        return (Location) get(PROPERTY_BILLTO);
    }

    public void setBillto(Location billto) {
        set(PROPERTY_BILLTO, billto);
    }

    public Location getBpartnerLocation() {
        return (Location) get(PROPERTY_BPARTNERLOCATION);
    }

    public void setBpartnerLocation(Location bpartnerLocation) {
        set(PROPERTY_BPARTNERLOCATION, bpartnerLocation);
    }

    public String getPoreference() {
        return (String) get(PROPERTY_POREFERENCE);
    }

    public void setPoreference(String poreference) {
        set(PROPERTY_POREFERENCE, poreference);
    }

    public Boolean isDiscountprinted() {
        return (Boolean) get(PROPERTY_ISDISCOUNTPRINTED);
    }

    public void setDiscountprinted(Boolean isdiscountprinted) {
        set(PROPERTY_ISDISCOUNTPRINTED, isdiscountprinted);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public String getPaymentrule() {
        return (String) get(PROPERTY_PAYMENTRULE);
    }

    public void setPaymentrule(String paymentrule) {
        set(PROPERTY_PAYMENTRULE, paymentrule);
    }

    public PaymentTerm getPaymentterm() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERM);
    }

    public void setPaymentterm(PaymentTerm paymentterm) {
        set(PROPERTY_PAYMENTTERM, paymentterm);
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

    public String getFreightcostrule() {
        return (String) get(PROPERTY_FREIGHTCOSTRULE);
    }

    public void setFreightcostrule(String freightcostrule) {
        set(PROPERTY_FREIGHTCOSTRULE, freightcostrule);
    }

    public BigDecimal getFreightamt() {
        return (BigDecimal) get(PROPERTY_FREIGHTAMT);
    }

    public void setFreightamt(BigDecimal freightamt) {
        set(PROPERTY_FREIGHTAMT, freightamt);
    }

    public String getDeliveryviarule() {
        return (String) get(PROPERTY_DELIVERYVIARULE);
    }

    public void setDeliveryviarule(String deliveryviarule) {
        set(PROPERTY_DELIVERYVIARULE, deliveryviarule);
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

    public BigDecimal getChargeamt() {
        return (BigDecimal) get(PROPERTY_CHARGEAMT);
    }

    public void setChargeamt(BigDecimal chargeamt) {
        set(PROPERTY_CHARGEAMT, chargeamt);
    }

    public String getPriorityrule() {
        return (String) get(PROPERTY_PRIORITYRULE);
    }

    public void setPriorityrule(String priorityrule) {
        set(PROPERTY_PRIORITYRULE, priorityrule);
    }

    public BigDecimal getTotallines() {
        return (BigDecimal) get(PROPERTY_TOTALLINES);
    }

    public void setTotallines(BigDecimal totallines) {
        set(PROPERTY_TOTALLINES, totallines);
    }

    public BigDecimal getGrandtotal() {
        return (BigDecimal) get(PROPERTY_GRANDTOTAL);
    }

    public void setGrandtotal(BigDecimal grandtotal) {
        set(PROPERTY_GRANDTOTAL, grandtotal);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public PriceList getPricelist() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPricelist(PriceList pricelist) {
        set(PROPERTY_PRICELIST, pricelist);
    }

    public Boolean isTaxincluded() {
        return (Boolean) get(PROPERTY_ISTAXINCLUDED);
    }

    public void setTaxincluded(Boolean istaxincluded) {
        set(PROPERTY_ISTAXINCLUDED, istaxincluded);
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

    public Boolean isCopyfrom() {
        return (Boolean) get(PROPERTY_COPYFROM);
    }

    public void setCopyfrom(Boolean copyfrom) {
        set(PROPERTY_COPYFROM, copyfrom);
    }

    public BusinessPartner getDropshipBpartner() {
        return (BusinessPartner) get(PROPERTY_DROPSHIPBPARTNER);
    }

    public void setDropshipBpartner(BusinessPartner dropshipBpartner) {
        set(PROPERTY_DROPSHIPBPARTNER, dropshipBpartner);
    }

    public Location getDropshipLocation() {
        return (Location) get(PROPERTY_DROPSHIPLOCATION);
    }

    public void setDropshipLocation(Location dropshipLocation) {
        set(PROPERTY_DROPSHIPLOCATION, dropshipLocation);
    }

    public User getDropshipUser() {
        return (User) get(PROPERTY_DROPSHIPUSER);
    }

    public void setDropshipUser(User dropshipUser) {
        set(PROPERTY_DROPSHIPUSER, dropshipUser);
    }

    public Boolean isSelfservice() {
        return (Boolean) get(PROPERTY_ISSELFSERVICE);
    }

    public void setSelfservice(Boolean isselfservice) {
        set(PROPERTY_ISSELFSERVICE, isselfservice);
    }

    public Organization getOrgtrx() {
        return (Organization) get(PROPERTY_ORGTRX);
    }

    public void setOrgtrx(Organization orgtrx) {
        set(PROPERTY_ORGTRX, orgtrx);
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

    public Boolean isCopyfrompo() {
        return (Boolean) get(PROPERTY_COPYFROMPO);
    }

    public void setCopyfrompo(Boolean copyfrompo) {
        set(PROPERTY_COPYFROMPO, copyfrompo);
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

    public Boolean isBtncopytemplate() {
        return (Boolean) get(PROPERTY_BTNCOPYTEMPLATE);
    }

    public void setBtncopytemplate(Boolean btncopytemplate) {
        set(PROPERTY_BTNCOPYTEMPLATE, btncopytemplate);
    }
}
