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
package org.openbravo.model.common.enterprise;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity C_orgconfiguration (stored in table c_orgconfiguration).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class C_orgconfiguration extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "c_orgconfiguration";
    public static final String ENTITY_NAME = "C_orgconfiguration";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CREATEPROJECTFROMSO =
        "createprojectfromso";
    public static final String PROPERTY_CLOSEPROJECTFROMSO =
        "closeprojectfromso";
    public static final String PROPERTY_POPROJECTWORKFLOW = "poprojectworkflow";
    public static final String PROPERTY_AUTOMATERIAL2PROJECT =
        "automaterial2project";
    public static final String PROPERTY_DEFAULTPOAPPROVALAMT =
        "defaultpoapprovalamt";
    public static final String PROPERTY_DATEVONLYCREDITDEBIT =
        "datevonlycreditdebit";
    public static final String PROPERTY_DATEVEXPORTPROJASSET =
        "datevexportprojasset";
    public static final String PROPERTY_PRAPPROVALWORKFLOW =
        "prapprovalworkflow";
    public static final String PROPERTY_DEFAULTPRAPPROVALAMT =
        "defaultprapprovalamt";
    public static final String PROPERTY_ISSTANDARD = "isstandard";
    public static final String PROPERTY_REINVOICEPROJECTEXPENSES =
        "reinvoiceprojectexpenses";
    public static final String PROPERTY_OFFERPROPABILITYNOTNULL =
        "offerpropabilitynotnull";
    public static final String PROPERTY_ORDERPROJECTNOTNULL =
        "orderprojectnotnull";
    public static final String PROPERTY_DATEPROMISEDNOTNULL =
        "datepromisednotnull";
    public static final String PROPERTY_ACTIVATESHIPMENTAUTOMATICALLY =
        "activateshipmentautomatically";
    public static final String PROPERTY_ACTIVATERECEIPTAUTOMATICALLY =
        "activatereceiptautomatically";
    public static final String PROPERTY_ACTIVATESOINVOICEAUTOMATICALLY =
        "activatesoinvoiceautomatically";
    public static final String PROPERTY_ACTIVATEPOINVOICEAUTOMATICALLY =
        "activatepoinvoiceautomatically";
    public static final String PROPERTY_PROJECTMANGERWORKFLOW =
        "projectmangerworkflow";
    public static final String PROPERTY_AUTOPRODUCTVALUESEQUENCE =
        "autoproductvaluesequence";
    public static final String PROPERTY_AUTOPRODUCTEANSEQUENCE =
        "autoproducteansequence";
    public static final String PROPERTY_AUTOBPARTNERVALUESEQUENCE =
        "autobpartnervaluesequence";
    public static final String PROPERTY_DELIVERYOFSERVICES =
        "deliveryofservices";
    public static final String PROPERTY_PIPURCHASERDISPLAY =
        "pipurchaserdisplay";
    public static final String PROPERTY_ACTIVATEPOBPARTNERPRESELECTION =
        "activatePOBPartnerPreselection";
    public static final String PROPERTY_ORDERREQUISITIONRESTRICTION =
        "orderrequisitionrestriction";
    public static final String PROPERTY_USEPRODUCTVALUE2SCANPRODUCTS =
        "useproductvalue2scanproducts";
    public static final String PROPERTY_BRINGBACKMOREMATERIALTHANRECEIVED =
        "bringbackmorematerialthanreceived";
    public static final String PROPERTY_PROJECTONLYAPPROVEDPRODUCTS =
        "projectonlyapprovedproducts";
    public static final String PROPERTY_PROJECTGETMATONTASKSTART =
        "projectgetmatontaskstart";
    public static final String PROPERTY_ACTIVATEINTERNALCONSUMPTIONAUTO =
        "activateinternalconsumptionauto";
    public static final String PROPERTY_PRODUCTVALUEREADONLY =
        "productvaluereadonly";
    public static final String PROPERTY_BPARTNERVALUEREADONLY =
        "bpartnervaluereadonly";
    public static final String PROPERTY_DOCNOREADONLY = "docnoreadonly";
    public static final String PROPERTY_GENERATESTDTASKFROMSO =
        "generatestdtaskfromso";
    public static final String PROPERTY_AUTOSELECTLOTNUMBER =
        "autoselectlotnumber";
    public static final String PROPERTY_AUTOPROJECTVALUESEQUENCE =
        "autoprojectvaluesequence";
    public static final String PROPERTY_PROJECTVALUEREADONLY =
        "projectvaluereadonly";
    public static final String PROPERTY_REFRESHINTERVALL = "refreshintervall";
    public static final String PROPERTY_SYNCHRONIZEWORKSTEPBOMS =
        "synchronizeworkstepboms";
    public static final String PROPERTY_PROJECTMATPANAUTOWHENGETMAT =
        "projectmatpanautowhengetmat";

    public C_orgconfiguration() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_CREATEPROJECTFROMSO, false);
        setDefaultValue(PROPERTY_CLOSEPROJECTFROMSO, false);
        setDefaultValue(PROPERTY_POPROJECTWORKFLOW, false);
        setDefaultValue(PROPERTY_AUTOMATERIAL2PROJECT, false);
        setDefaultValue(PROPERTY_DEFAULTPOAPPROVALAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_DATEVONLYCREDITDEBIT, false);
        setDefaultValue(PROPERTY_DATEVEXPORTPROJASSET, false);
        setDefaultValue(PROPERTY_PRAPPROVALWORKFLOW, false);
        setDefaultValue(PROPERTY_DEFAULTPRAPPROVALAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISSTANDARD, false);
        setDefaultValue(PROPERTY_REINVOICEPROJECTEXPENSES, false);
        setDefaultValue(PROPERTY_OFFERPROPABILITYNOTNULL, false);
        setDefaultValue(PROPERTY_ORDERPROJECTNOTNULL, false);
        setDefaultValue(PROPERTY_DATEPROMISEDNOTNULL, false);
        setDefaultValue(PROPERTY_ACTIVATESHIPMENTAUTOMATICALLY, true);
        setDefaultValue(PROPERTY_ACTIVATERECEIPTAUTOMATICALLY, true);
        setDefaultValue(PROPERTY_ACTIVATESOINVOICEAUTOMATICALLY, true);
        setDefaultValue(PROPERTY_ACTIVATEPOINVOICEAUTOMATICALLY, true);
        setDefaultValue(PROPERTY_PROJECTMANGERWORKFLOW, false);
        setDefaultValue(PROPERTY_AUTOPRODUCTVALUESEQUENCE, false);
        setDefaultValue(PROPERTY_AUTOPRODUCTEANSEQUENCE, false);
        setDefaultValue(PROPERTY_AUTOBPARTNERVALUESEQUENCE, false);
        setDefaultValue(PROPERTY_DELIVERYOFSERVICES, true);
        setDefaultValue(PROPERTY_PIPURCHASERDISPLAY, false);
        setDefaultValue(PROPERTY_ACTIVATEPOBPARTNERPRESELECTION, true);
        setDefaultValue(PROPERTY_ORDERREQUISITIONRESTRICTION, true);
        setDefaultValue(PROPERTY_USEPRODUCTVALUE2SCANPRODUCTS, false);
        setDefaultValue(PROPERTY_BRINGBACKMOREMATERIALTHANRECEIVED, false);
        setDefaultValue(PROPERTY_PROJECTONLYAPPROVEDPRODUCTS, false);
        setDefaultValue(PROPERTY_PROJECTGETMATONTASKSTART, false);
        setDefaultValue(PROPERTY_ACTIVATEINTERNALCONSUMPTIONAUTO, true);
        setDefaultValue(PROPERTY_PRODUCTVALUEREADONLY, false);
        setDefaultValue(PROPERTY_BPARTNERVALUEREADONLY, false);
        setDefaultValue(PROPERTY_DOCNOREADONLY, false);
        setDefaultValue(PROPERTY_GENERATESTDTASKFROMSO, false);
        setDefaultValue(PROPERTY_AUTOSELECTLOTNUMBER, false);
        setDefaultValue(PROPERTY_AUTOPROJECTVALUESEQUENCE, false);
        setDefaultValue(PROPERTY_PROJECTVALUEREADONLY, false);
        setDefaultValue(PROPERTY_REFRESHINTERVALL, (long) 0);
        setDefaultValue(PROPERTY_SYNCHRONIZEWORKSTEPBOMS, true);
        setDefaultValue(PROPERTY_PROJECTMATPANAUTOWHENGETMAT, false);
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

    public Boolean isCreateprojectfromso() {
        return (Boolean) get(PROPERTY_CREATEPROJECTFROMSO);
    }

    public void setCreateprojectfromso(Boolean createprojectfromso) {
        set(PROPERTY_CREATEPROJECTFROMSO, createprojectfromso);
    }

    public Boolean isCloseprojectfromso() {
        return (Boolean) get(PROPERTY_CLOSEPROJECTFROMSO);
    }

    public void setCloseprojectfromso(Boolean closeprojectfromso) {
        set(PROPERTY_CLOSEPROJECTFROMSO, closeprojectfromso);
    }

    public Boolean isPoprojectworkflow() {
        return (Boolean) get(PROPERTY_POPROJECTWORKFLOW);
    }

    public void setPoprojectworkflow(Boolean poprojectworkflow) {
        set(PROPERTY_POPROJECTWORKFLOW, poprojectworkflow);
    }

    public Boolean isAutomaterial2project() {
        return (Boolean) get(PROPERTY_AUTOMATERIAL2PROJECT);
    }

    public void setAutomaterial2project(Boolean automaterial2project) {
        set(PROPERTY_AUTOMATERIAL2PROJECT, automaterial2project);
    }

    public BigDecimal getDefaultpoapprovalamt() {
        return (BigDecimal) get(PROPERTY_DEFAULTPOAPPROVALAMT);
    }

    public void setDefaultpoapprovalamt(BigDecimal defaultpoapprovalamt) {
        set(PROPERTY_DEFAULTPOAPPROVALAMT, defaultpoapprovalamt);
    }

    public Boolean isDatevonlycreditdebit() {
        return (Boolean) get(PROPERTY_DATEVONLYCREDITDEBIT);
    }

    public void setDatevonlycreditdebit(Boolean datevonlycreditdebit) {
        set(PROPERTY_DATEVONLYCREDITDEBIT, datevonlycreditdebit);
    }

    public Boolean isDatevexportprojasset() {
        return (Boolean) get(PROPERTY_DATEVEXPORTPROJASSET);
    }

    public void setDatevexportprojasset(Boolean datevexportprojasset) {
        set(PROPERTY_DATEVEXPORTPROJASSET, datevexportprojasset);
    }

    public Boolean isPrapprovalworkflow() {
        return (Boolean) get(PROPERTY_PRAPPROVALWORKFLOW);
    }

    public void setPrapprovalworkflow(Boolean prapprovalworkflow) {
        set(PROPERTY_PRAPPROVALWORKFLOW, prapprovalworkflow);
    }

    public BigDecimal getDefaultprapprovalamt() {
        return (BigDecimal) get(PROPERTY_DEFAULTPRAPPROVALAMT);
    }

    public void setDefaultprapprovalamt(BigDecimal defaultprapprovalamt) {
        set(PROPERTY_DEFAULTPRAPPROVALAMT, defaultprapprovalamt);
    }

    public Boolean isStandard() {
        return (Boolean) get(PROPERTY_ISSTANDARD);
    }

    public void setStandard(Boolean isstandard) {
        set(PROPERTY_ISSTANDARD, isstandard);
    }

    public Boolean isReinvoiceprojectexpenses() {
        return (Boolean) get(PROPERTY_REINVOICEPROJECTEXPENSES);
    }

    public void setReinvoiceprojectexpenses(Boolean reinvoiceprojectexpenses) {
        set(PROPERTY_REINVOICEPROJECTEXPENSES, reinvoiceprojectexpenses);
    }

    public Boolean isOfferpropabilitynotnull() {
        return (Boolean) get(PROPERTY_OFFERPROPABILITYNOTNULL);
    }

    public void setOfferpropabilitynotnull(Boolean offerpropabilitynotnull) {
        set(PROPERTY_OFFERPROPABILITYNOTNULL, offerpropabilitynotnull);
    }

    public Boolean isOrderprojectnotnull() {
        return (Boolean) get(PROPERTY_ORDERPROJECTNOTNULL);
    }

    public void setOrderprojectnotnull(Boolean orderprojectnotnull) {
        set(PROPERTY_ORDERPROJECTNOTNULL, orderprojectnotnull);
    }

    public Boolean isDatepromisednotnull() {
        return (Boolean) get(PROPERTY_DATEPROMISEDNOTNULL);
    }

    public void setDatepromisednotnull(Boolean datepromisednotnull) {
        set(PROPERTY_DATEPROMISEDNOTNULL, datepromisednotnull);
    }

    public Boolean isActivateshipmentautomatically() {
        return (Boolean) get(PROPERTY_ACTIVATESHIPMENTAUTOMATICALLY);
    }

    public void setActivateshipmentautomatically(
        Boolean activateshipmentautomatically) {
        set(PROPERTY_ACTIVATESHIPMENTAUTOMATICALLY,
            activateshipmentautomatically);
    }

    public Boolean isActivatereceiptautomatically() {
        return (Boolean) get(PROPERTY_ACTIVATERECEIPTAUTOMATICALLY);
    }

    public void setActivatereceiptautomatically(
        Boolean activatereceiptautomatically) {
        set(PROPERTY_ACTIVATERECEIPTAUTOMATICALLY, activatereceiptautomatically);
    }

    public Boolean isActivatesoinvoiceautomatically() {
        return (Boolean) get(PROPERTY_ACTIVATESOINVOICEAUTOMATICALLY);
    }

    public void setActivatesoinvoiceautomatically(
        Boolean activatesoinvoiceautomatically) {
        set(PROPERTY_ACTIVATESOINVOICEAUTOMATICALLY,
            activatesoinvoiceautomatically);
    }

    public Boolean isActivatepoinvoiceautomatically() {
        return (Boolean) get(PROPERTY_ACTIVATEPOINVOICEAUTOMATICALLY);
    }

    public void setActivatepoinvoiceautomatically(
        Boolean activatepoinvoiceautomatically) {
        set(PROPERTY_ACTIVATEPOINVOICEAUTOMATICALLY,
            activatepoinvoiceautomatically);
    }

    public Boolean isProjectmangerworkflow() {
        return (Boolean) get(PROPERTY_PROJECTMANGERWORKFLOW);
    }

    public void setProjectmangerworkflow(Boolean projectmangerworkflow) {
        set(PROPERTY_PROJECTMANGERWORKFLOW, projectmangerworkflow);
    }

    public Boolean isAutoproductvaluesequence() {
        return (Boolean) get(PROPERTY_AUTOPRODUCTVALUESEQUENCE);
    }

    public void setAutoproductvaluesequence(Boolean autoproductvaluesequence) {
        set(PROPERTY_AUTOPRODUCTVALUESEQUENCE, autoproductvaluesequence);
    }

    public Boolean isAutoproducteansequence() {
        return (Boolean) get(PROPERTY_AUTOPRODUCTEANSEQUENCE);
    }

    public void setAutoproducteansequence(Boolean autoproducteansequence) {
        set(PROPERTY_AUTOPRODUCTEANSEQUENCE, autoproducteansequence);
    }

    public Boolean isAutobpartnervaluesequence() {
        return (Boolean) get(PROPERTY_AUTOBPARTNERVALUESEQUENCE);
    }

    public void setAutobpartnervaluesequence(Boolean autobpartnervaluesequence) {
        set(PROPERTY_AUTOBPARTNERVALUESEQUENCE, autobpartnervaluesequence);
    }

    public Boolean isDeliveryofservices() {
        return (Boolean) get(PROPERTY_DELIVERYOFSERVICES);
    }

    public void setDeliveryofservices(Boolean deliveryofservices) {
        set(PROPERTY_DELIVERYOFSERVICES, deliveryofservices);
    }

    public Boolean isPipurchaserdisplay() {
        return (Boolean) get(PROPERTY_PIPURCHASERDISPLAY);
    }

    public void setPipurchaserdisplay(Boolean pipurchaserdisplay) {
        set(PROPERTY_PIPURCHASERDISPLAY, pipurchaserdisplay);
    }

    public Boolean isActivatePOBPartnerPreselection() {
        return (Boolean) get(PROPERTY_ACTIVATEPOBPARTNERPRESELECTION);
    }

    public void setActivatePOBPartnerPreselection(
        Boolean activatePOBPartnerPreselection) {
        set(PROPERTY_ACTIVATEPOBPARTNERPRESELECTION,
            activatePOBPartnerPreselection);
    }

    public Boolean isOrderrequisitionrestriction() {
        return (Boolean) get(PROPERTY_ORDERREQUISITIONRESTRICTION);
    }

    public void setOrderrequisitionrestriction(
        Boolean orderrequisitionrestriction) {
        set(PROPERTY_ORDERREQUISITIONRESTRICTION, orderrequisitionrestriction);
    }

    public Boolean isUseproductvalue2scanproducts() {
        return (Boolean) get(PROPERTY_USEPRODUCTVALUE2SCANPRODUCTS);
    }

    public void setUseproductvalue2scanproducts(
        Boolean useproductvalue2scanproducts) {
        set(PROPERTY_USEPRODUCTVALUE2SCANPRODUCTS, useproductvalue2scanproducts);
    }

    public Boolean isBringbackmorematerialthanreceived() {
        return (Boolean) get(PROPERTY_BRINGBACKMOREMATERIALTHANRECEIVED);
    }

    public void setBringbackmorematerialthanreceived(
        Boolean bringbackmorematerialthanreceived) {
        set(PROPERTY_BRINGBACKMOREMATERIALTHANRECEIVED,
            bringbackmorematerialthanreceived);
    }

    public Boolean isProjectonlyapprovedproducts() {
        return (Boolean) get(PROPERTY_PROJECTONLYAPPROVEDPRODUCTS);
    }

    public void setProjectonlyapprovedproducts(
        Boolean projectonlyapprovedproducts) {
        set(PROPERTY_PROJECTONLYAPPROVEDPRODUCTS, projectonlyapprovedproducts);
    }

    public Boolean isProjectgetmatontaskstart() {
        return (Boolean) get(PROPERTY_PROJECTGETMATONTASKSTART);
    }

    public void setProjectgetmatontaskstart(Boolean projectgetmatontaskstart) {
        set(PROPERTY_PROJECTGETMATONTASKSTART, projectgetmatontaskstart);
    }

    public Boolean isActivateinternalconsumptionauto() {
        return (Boolean) get(PROPERTY_ACTIVATEINTERNALCONSUMPTIONAUTO);
    }

    public void setActivateinternalconsumptionauto(
        Boolean activateinternalconsumptionauto) {
        set(PROPERTY_ACTIVATEINTERNALCONSUMPTIONAUTO,
            activateinternalconsumptionauto);
    }

    public Boolean isProductvaluereadonly() {
        return (Boolean) get(PROPERTY_PRODUCTVALUEREADONLY);
    }

    public void setProductvaluereadonly(Boolean productvaluereadonly) {
        set(PROPERTY_PRODUCTVALUEREADONLY, productvaluereadonly);
    }

    public Boolean isBpartnervaluereadonly() {
        return (Boolean) get(PROPERTY_BPARTNERVALUEREADONLY);
    }

    public void setBpartnervaluereadonly(Boolean bpartnervaluereadonly) {
        set(PROPERTY_BPARTNERVALUEREADONLY, bpartnervaluereadonly);
    }

    public Boolean isDocnoreadonly() {
        return (Boolean) get(PROPERTY_DOCNOREADONLY);
    }

    public void setDocnoreadonly(Boolean docnoreadonly) {
        set(PROPERTY_DOCNOREADONLY, docnoreadonly);
    }

    public Boolean isGeneratestdtaskfromso() {
        return (Boolean) get(PROPERTY_GENERATESTDTASKFROMSO);
    }

    public void setGeneratestdtaskfromso(Boolean generatestdtaskfromso) {
        set(PROPERTY_GENERATESTDTASKFROMSO, generatestdtaskfromso);
    }

    public Boolean isAutoselectlotnumber() {
        return (Boolean) get(PROPERTY_AUTOSELECTLOTNUMBER);
    }

    public void setAutoselectlotnumber(Boolean autoselectlotnumber) {
        set(PROPERTY_AUTOSELECTLOTNUMBER, autoselectlotnumber);
    }

    public Boolean isAutoprojectvaluesequence() {
        return (Boolean) get(PROPERTY_AUTOPROJECTVALUESEQUENCE);
    }

    public void setAutoprojectvaluesequence(Boolean autoprojectvaluesequence) {
        set(PROPERTY_AUTOPROJECTVALUESEQUENCE, autoprojectvaluesequence);
    }

    public Boolean isProjectvaluereadonly() {
        return (Boolean) get(PROPERTY_PROJECTVALUEREADONLY);
    }

    public void setProjectvaluereadonly(Boolean projectvaluereadonly) {
        set(PROPERTY_PROJECTVALUEREADONLY, projectvaluereadonly);
    }

    public Long getRefreshintervall() {
        return (Long) get(PROPERTY_REFRESHINTERVALL);
    }

    public void setRefreshintervall(Long refreshintervall) {
        set(PROPERTY_REFRESHINTERVALL, refreshintervall);
    }

    public Boolean isSynchronizeworkstepboms() {
        return (Boolean) get(PROPERTY_SYNCHRONIZEWORKSTEPBOMS);
    }

    public void setSynchronizeworkstepboms(Boolean synchronizeworkstepboms) {
        set(PROPERTY_SYNCHRONIZEWORKSTEPBOMS, synchronizeworkstepboms);
    }

    public Boolean isProjectmatpanautowhengetmat() {
        return (Boolean) get(PROPERTY_PROJECTMATPANAUTOWHENGETMAT);
    }

    public void setProjectmatpanautowhengetmat(
        Boolean projectmatpanautowhengetmat) {
        set(PROPERTY_PROJECTMATPANAUTOWHENGETMAT, projectmatpanautowhengetmat);
    }
}
