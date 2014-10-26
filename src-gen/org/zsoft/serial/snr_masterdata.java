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
package org.zsoft.serial;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.materialmgmt.transaction.InternalConsumptionLine;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;
import org.openbravo.model.materialmgmt.transaction.InventoryCountLine;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.project.ProjectTask;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity SNR_masterdata (stored in table SNR_Masterdata).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class snr_masterdata extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SNR_Masterdata";
    public static final String ENTITY_NAME = "SNR_masterdata";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_SERIALNUMBER = "serialnumber";
    public static final String PROPERTY_FIRSTSEEN = "firstseen";
    public static final String PROPERTY_MOVEMENTDATE = "movementdate";
    public static final String PROPERTY_MOVEMENTTYPE = "movementtype";
    public static final String PROPERTY_LOCATOR = "locator";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_BPARTNERLOCATION = "bpartnerLocation";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_INOUTLINE = "inoutline";
    public static final String PROPERTY_INTERNALCONSUMPTIONLINE =
        "internalConsumptionline";
    public static final String PROPERTY_INVENTORYLINE = "inventoryline";
    public static final String PROPERTY_MOVEMENTLINE = "movementline";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_GUARANTEEDATE = "guaranteedate";
    public static final String PROPERTY_VENDOR = "vendor";
    public static final String PROPERTY_MODEL = "model";
    public static final String PROPERTY_IDENTIFIER2 = "identifier2";
    public static final String PROPERTY_ORDERREFERENCE = "orderreference";
    public static final String PROPERTY_EXTERNALTRACKINGNO =
        "externaltrackingno";
    public static final String PROPERTY_IDENTIFIER3 = "identifier3";
    public static final String PROPERTY_SNRSELFJOIN = "snrselfjoin";
    public static final String PROPERTY_REMARK = "remark";
    public static final String PROPERTY_LOCATION = "location";
    public static final String PROPERTY_ITEMNAME = "itemname";
    public static final String PROPERTY_SENDING = "sending";
    public static final String PROPERTY_SENDMAIL = "sendmail";
    public static final String PROPERTY_SNRSERIALNUMBERTRACKINGLIST =
        "snrSerialnumbertrackingList";
    public static final String PROPERTY_SNRCURRENTBOMVLIST =
        "snrCurrentbomVList";

    public snr_masterdata() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_SENDING, false);
        setDefaultValue(PROPERTY_SENDMAIL, false);
        setDefaultValue(PROPERTY_SNRSERIALNUMBERTRACKINGLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_SNRCURRENTBOMVLIST, new ArrayList<Object>());
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

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public String getSerialnumber() {
        return (String) get(PROPERTY_SERIALNUMBER);
    }

    public void setSerialnumber(String serialnumber) {
        set(PROPERTY_SERIALNUMBER, serialnumber);
    }

    public Date getFirstseen() {
        return (Date) get(PROPERTY_FIRSTSEEN);
    }

    public void setFirstseen(Date firstseen) {
        set(PROPERTY_FIRSTSEEN, firstseen);
    }

    public Date getMovementdate() {
        return (Date) get(PROPERTY_MOVEMENTDATE);
    }

    public void setMovementdate(Date movementdate) {
        set(PROPERTY_MOVEMENTDATE, movementdate);
    }

    public String getMovementtype() {
        return (String) get(PROPERTY_MOVEMENTTYPE);
    }

    public void setMovementtype(String movementtype) {
        set(PROPERTY_MOVEMENTTYPE, movementtype);
    }

    public Locator getLocator() {
        return (Locator) get(PROPERTY_LOCATOR);
    }

    public void setLocator(Locator locator) {
        set(PROPERTY_LOCATOR, locator);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
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

    public ProjectTask getProjecttask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjecttask(ProjectTask projecttask) {
        set(PROPERTY_PROJECTTASK, projecttask);
    }

    public ShipmentInOutLine getInoutline() {
        return (ShipmentInOutLine) get(PROPERTY_INOUTLINE);
    }

    public void setInoutline(ShipmentInOutLine inoutline) {
        set(PROPERTY_INOUTLINE, inoutline);
    }

    public InternalConsumptionLine getInternalConsumptionline() {
        return (InternalConsumptionLine) get(PROPERTY_INTERNALCONSUMPTIONLINE);
    }

    public void setInternalConsumptionline(
        InternalConsumptionLine internalConsumptionline) {
        set(PROPERTY_INTERNALCONSUMPTIONLINE, internalConsumptionline);
    }

    public InventoryCountLine getInventoryline() {
        return (InventoryCountLine) get(PROPERTY_INVENTORYLINE);
    }

    public void setInventoryline(InventoryCountLine inventoryline) {
        set(PROPERTY_INVENTORYLINE, inventoryline);
    }

    public InternalMovementLine getMovementline() {
        return (InternalMovementLine) get(PROPERTY_MOVEMENTLINE);
    }

    public void setMovementline(InternalMovementLine movementline) {
        set(PROPERTY_MOVEMENTLINE, movementline);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Date getGuaranteedate() {
        return (Date) get(PROPERTY_GUARANTEEDATE);
    }

    public void setGuaranteedate(Date guaranteedate) {
        set(PROPERTY_GUARANTEEDATE, guaranteedate);
    }

    public String getVendor() {
        return (String) get(PROPERTY_VENDOR);
    }

    public void setVendor(String vendor) {
        set(PROPERTY_VENDOR, vendor);
    }

    public String getModel() {
        return (String) get(PROPERTY_MODEL);
    }

    public void setModel(String model) {
        set(PROPERTY_MODEL, model);
    }

    public String getIdentifier2() {
        return (String) get(PROPERTY_IDENTIFIER2);
    }

    public void setIdentifier2(String identifier2) {
        set(PROPERTY_IDENTIFIER2, identifier2);
    }

    public String getOrderreference() {
        return (String) get(PROPERTY_ORDERREFERENCE);
    }

    public void setOrderreference(String orderreference) {
        set(PROPERTY_ORDERREFERENCE, orderreference);
    }

    public String getExternaltrackingno() {
        return (String) get(PROPERTY_EXTERNALTRACKINGNO);
    }

    public void setExternaltrackingno(String externaltrackingno) {
        set(PROPERTY_EXTERNALTRACKINGNO, externaltrackingno);
    }

    public String getIdentifier3() {
        return (String) get(PROPERTY_IDENTIFIER3);
    }

    public void setIdentifier3(String identifier3) {
        set(PROPERTY_IDENTIFIER3, identifier3);
    }

    public org.zsoft.serial.snr_masterdata getSnrselfjoin() {
        return (org.zsoft.serial.snr_masterdata) get(PROPERTY_SNRSELFJOIN);
    }

    public void setSnrselfjoin(org.zsoft.serial.snr_masterdata snrselfjoin) {
        set(PROPERTY_SNRSELFJOIN, snrselfjoin);
    }

    public String getRemark() {
        return (String) get(PROPERTY_REMARK);
    }

    public void setRemark(String remark) {
        set(PROPERTY_REMARK, remark);
    }

    public String getLocation() {
        return (String) get(PROPERTY_LOCATION);
    }

    public void setLocation(String location) {
        set(PROPERTY_LOCATION, location);
    }

    public String getItemname() {
        return (String) get(PROPERTY_ITEMNAME);
    }

    public void setItemname(String itemname) {
        set(PROPERTY_ITEMNAME, itemname);
    }

    public Boolean isSending() {
        return (Boolean) get(PROPERTY_SENDING);
    }

    public void setSending(Boolean sending) {
        set(PROPERTY_SENDING, sending);
    }

    public Boolean isSendmail() {
        return (Boolean) get(PROPERTY_SENDMAIL);
    }

    public void setSendmail(Boolean sendmail) {
        set(PROPERTY_SENDMAIL, sendmail);
    }

    @SuppressWarnings("unchecked")
    public List<Snr_serialnumbertracking> getSnrSerialnumbertrackingList() {
        return (List<Snr_serialnumbertracking>) get(PROPERTY_SNRSERIALNUMBERTRACKINGLIST);
    }

    public void setSnrSerialnumbertrackingList(
        List<Snr_serialnumbertracking> snrSerialnumbertrackingList) {
        set(PROPERTY_SNRSERIALNUMBERTRACKINGLIST, snrSerialnumbertrackingList);
    }

    @SuppressWarnings("unchecked")
    public List<org.zsoft.serial.snr_currentbom_v> getSnrCurrentbomVList() {
        return (List<org.zsoft.serial.snr_currentbom_v>) get(PROPERTY_SNRCURRENTBOMVLIST);
    }

    public void setSnrCurrentbomVList(
        List<org.zsoft.serial.snr_currentbom_v> snrCurrentbomVList) {
        set(PROPERTY_SNRCURRENTBOMVLIST, snrCurrentbomVList);
    }
}
