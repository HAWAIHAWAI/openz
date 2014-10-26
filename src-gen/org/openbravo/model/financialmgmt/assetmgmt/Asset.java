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
package org.openbravo.model.financialmgmt.assetmgmt;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.project.Project;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity FinancialMgmtAsset (stored in table A_Asset).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Asset extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "A_Asset";
    public static final String ENTITY_NAME = "FinancialMgmtAsset";
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
    public static final String PROPERTY_HELP = "help";
    public static final String PROPERTY_ASSETGROUP = "assetGroup";
    public static final String PROPERTY_SERNO = "serNo";
    public static final String PROPERTY_LOT = "lot";
    public static final String PROPERTY_VERSIONNO = "versionNo";
    public static final String PROPERTY_GUARANTEEDATE = "guaranteeDate";
    public static final String PROPERTY_ASSETSERVICEDATE = "assetServiceDate";
    public static final String PROPERTY_ISOWNED = "isOwned";
    public static final String PROPERTY_ASSETDEPRECIATIONDATE =
        "assetDepreciationDate";
    public static final String PROPERTY_USELIFEYEARS = "useLifeYears";
    public static final String PROPERTY_USELIFEMONTHS = "useLifeMonths";
    public static final String PROPERTY_LIFEUSEUNITS = "lifeUseUnits";
    public static final String PROPERTY_USEUNITS = "useUnits";
    public static final String PROPERTY_ISDISPOSED = "isDisposed";
    public static final String PROPERTY_ASSETDISPOSALDATE = "assetDisposalDate";
    public static final String PROPERTY_ISINPOSESSION = "isInPosession";
    public static final String PROPERTY_LOCATIONCOMMENT = "locationComment";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_BPARTNERLOCATION = "bPartnerLocation";
    public static final String PROPERTY_LOCATION = "location";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_ISDEPRECIATED = "isDepreciated";
    public static final String PROPERTY_ISFULLYDEPRECIATED =
        "isFullyDepreciated";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_AMORTIZATIONENDDATE =
        "amortizationenddate";
    public static final String PROPERTY_AMORTIZATIONSTARTDATE =
        "amortizationstartdate";
    public static final String PROPERTY_ANNUALAMORTIZATIONPERCENTAGE =
        "annualamortizationpercentage";
    public static final String PROPERTY_ASSETVALUEAMT = "assetValueAmt";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_DATECANCELLED = "datecancelled";
    public static final String PROPERTY_DATEPURCHASED = "datepurchased";
    public static final String PROPERTY_RESIDUALASSETVALUEAMT =
        "residualassetvalueamt";
    public static final String PROPERTY_ACCTVALUEAMT = "acctvalueamt";
    public static final String PROPERTY_AMORTIZATIONTYPE = "amortizationtype";
    public static final String PROPERTY_AMORTIZATIONVALUEAMT =
        "amortizationvalueamt";
    public static final String PROPERTY_ASSETSCHEDULE = "assetschedule";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_PROFIT = "profit";
    public static final String PROPERTY_AMORTIZATIONCALCTYPE =
        "amortizationcalctype";
    public static final String PROPERTY_DEPRECIATEDPLAN = "depreciatedplan";
    public static final String PROPERTY_DEPRECIATEDPREVIOUSAMT =
        "depreciatedpreviousamt";
    public static final String PROPERTY_DEPRECIATEDVALUE = "depreciatedvalue";
    public static final String PROPERTY_ASSETTYPE = "assettype";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ISCOSTCENTER = "iscostcenter";
    public static final String PROPERTY_ISSUMMARY = "issummary";
    public static final String PROPERTY_SNRMASTERDATA = "sNRMasterdata";
    public static final String PROPERTY_FINANCIALMGMTASSETACCOUNTSLIST =
        "financialMgmtAssetAccountsList";
    public static final String PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST =
        "financialMgmtAmortizationLineList";
    public static final String PROPERTY_FINANCIALMGMTASSETAMORTIZATIONLIST =
        "financialMgmtAssetAmortizationList";

    public Asset() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISOWNED, true);
        setDefaultValue(PROPERTY_ISDISPOSED, false);
        setDefaultValue(PROPERTY_ISINPOSESSION, true);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_ISDEPRECIATED, false);
        setDefaultValue(PROPERTY_ISFULLYDEPRECIATED, false);
        setDefaultValue(PROPERTY_AMORTIZATIONTYPE, "LI");
        setDefaultValue(PROPERTY_ASSETSCHEDULE, "YE");
        setDefaultValue(PROPERTY_PROCESSED, "N");
        setDefaultValue(PROPERTY_AMORTIZATIONCALCTYPE, "PE");
        setDefaultValue(PROPERTY_DEPRECIATEDPLAN, new BigDecimal(0));
        setDefaultValue(PROPERTY_DEPRECIATEDPREVIOUSAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_DEPRECIATEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISCOSTCENTER, true);
        setDefaultValue(PROPERTY_ISSUMMARY, false);
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETACCOUNTSLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETAMORTIZATIONLIST,
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

    public String getHelp() {
        return (String) get(PROPERTY_HELP);
    }

    public void setHelp(String help) {
        set(PROPERTY_HELP, help);
    }

    public AssetGroup getAssetGroup() {
        return (AssetGroup) get(PROPERTY_ASSETGROUP);
    }

    public void setAssetGroup(AssetGroup assetGroup) {
        set(PROPERTY_ASSETGROUP, assetGroup);
    }

    public String getSerNo() {
        return (String) get(PROPERTY_SERNO);
    }

    public void setSerNo(String serNo) {
        set(PROPERTY_SERNO, serNo);
    }

    public String getLot() {
        return (String) get(PROPERTY_LOT);
    }

    public void setLot(String lot) {
        set(PROPERTY_LOT, lot);
    }

    public String getVersionNo() {
        return (String) get(PROPERTY_VERSIONNO);
    }

    public void setVersionNo(String versionNo) {
        set(PROPERTY_VERSIONNO, versionNo);
    }

    public Date getGuaranteeDate() {
        return (Date) get(PROPERTY_GUARANTEEDATE);
    }

    public void setGuaranteeDate(Date guaranteeDate) {
        set(PROPERTY_GUARANTEEDATE, guaranteeDate);
    }

    public Date getAssetServiceDate() {
        return (Date) get(PROPERTY_ASSETSERVICEDATE);
    }

    public void setAssetServiceDate(Date assetServiceDate) {
        set(PROPERTY_ASSETSERVICEDATE, assetServiceDate);
    }

    public Boolean isOwned() {
        return (Boolean) get(PROPERTY_ISOWNED);
    }

    public void setOwned(Boolean isOwned) {
        set(PROPERTY_ISOWNED, isOwned);
    }

    public Date getAssetDepreciationDate() {
        return (Date) get(PROPERTY_ASSETDEPRECIATIONDATE);
    }

    public void setAssetDepreciationDate(Date assetDepreciationDate) {
        set(PROPERTY_ASSETDEPRECIATIONDATE, assetDepreciationDate);
    }

    public Long getUseLifeYears() {
        return (Long) get(PROPERTY_USELIFEYEARS);
    }

    public void setUseLifeYears(Long useLifeYears) {
        set(PROPERTY_USELIFEYEARS, useLifeYears);
    }

    public Long getUseLifeMonths() {
        return (Long) get(PROPERTY_USELIFEMONTHS);
    }

    public void setUseLifeMonths(Long useLifeMonths) {
        set(PROPERTY_USELIFEMONTHS, useLifeMonths);
    }

    public Long getLifeUseUnits() {
        return (Long) get(PROPERTY_LIFEUSEUNITS);
    }

    public void setLifeUseUnits(Long lifeUseUnits) {
        set(PROPERTY_LIFEUSEUNITS, lifeUseUnits);
    }

    public Long getUseUnits() {
        return (Long) get(PROPERTY_USEUNITS);
    }

    public void setUseUnits(Long useUnits) {
        set(PROPERTY_USEUNITS, useUnits);
    }

    public Boolean isDisposed() {
        return (Boolean) get(PROPERTY_ISDISPOSED);
    }

    public void setDisposed(Boolean isDisposed) {
        set(PROPERTY_ISDISPOSED, isDisposed);
    }

    public Date getAssetDisposalDate() {
        return (Date) get(PROPERTY_ASSETDISPOSALDATE);
    }

    public void setAssetDisposalDate(Date assetDisposalDate) {
        set(PROPERTY_ASSETDISPOSALDATE, assetDisposalDate);
    }

    public Boolean isInPosession() {
        return (Boolean) get(PROPERTY_ISINPOSESSION);
    }

    public void setInPosession(Boolean isInPosession) {
        set(PROPERTY_ISINPOSESSION, isInPosession);
    }

    public String getLocationComment() {
        return (String) get(PROPERTY_LOCATIONCOMMENT);
    }

    public void setLocationComment(String locationComment) {
        set(PROPERTY_LOCATIONCOMMENT, locationComment);
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

    public org.openbravo.model.common.geography.Location getLocation() {
        return (org.openbravo.model.common.geography.Location) get(PROPERTY_LOCATION);
    }

    public void setLocation(
        org.openbravo.model.common.geography.Location location) {
        set(PROPERTY_LOCATION, location);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Boolean isDepreciated() {
        return (Boolean) get(PROPERTY_ISDEPRECIATED);
    }

    public void setDepreciated(Boolean isDepreciated) {
        set(PROPERTY_ISDEPRECIATED, isDepreciated);
    }

    public Boolean isFullyDepreciated() {
        return (Boolean) get(PROPERTY_ISFULLYDEPRECIATED);
    }

    public void setFullyDepreciated(Boolean isFullyDepreciated) {
        set(PROPERTY_ISFULLYDEPRECIATED, isFullyDepreciated);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public Date getAmortizationenddate() {
        return (Date) get(PROPERTY_AMORTIZATIONENDDATE);
    }

    public void setAmortizationenddate(Date amortizationenddate) {
        set(PROPERTY_AMORTIZATIONENDDATE, amortizationenddate);
    }

    public Date getAmortizationstartdate() {
        return (Date) get(PROPERTY_AMORTIZATIONSTARTDATE);
    }

    public void setAmortizationstartdate(Date amortizationstartdate) {
        set(PROPERTY_AMORTIZATIONSTARTDATE, amortizationstartdate);
    }

    public BigDecimal getAnnualamortizationpercentage() {
        return (BigDecimal) get(PROPERTY_ANNUALAMORTIZATIONPERCENTAGE);
    }

    public void setAnnualamortizationpercentage(
        BigDecimal annualamortizationpercentage) {
        set(PROPERTY_ANNUALAMORTIZATIONPERCENTAGE, annualamortizationpercentage);
    }

    public BigDecimal getAssetValueAmt() {
        return (BigDecimal) get(PROPERTY_ASSETVALUEAMT);
    }

    public void setAssetValueAmt(BigDecimal assetValueAmt) {
        set(PROPERTY_ASSETVALUEAMT, assetValueAmt);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public Date getDatecancelled() {
        return (Date) get(PROPERTY_DATECANCELLED);
    }

    public void setDatecancelled(Date datecancelled) {
        set(PROPERTY_DATECANCELLED, datecancelled);
    }

    public Date getDatepurchased() {
        return (Date) get(PROPERTY_DATEPURCHASED);
    }

    public void setDatepurchased(Date datepurchased) {
        set(PROPERTY_DATEPURCHASED, datepurchased);
    }

    public BigDecimal getResidualassetvalueamt() {
        return (BigDecimal) get(PROPERTY_RESIDUALASSETVALUEAMT);
    }

    public void setResidualassetvalueamt(BigDecimal residualassetvalueamt) {
        set(PROPERTY_RESIDUALASSETVALUEAMT, residualassetvalueamt);
    }

    public BigDecimal getAcctvalueamt() {
        return (BigDecimal) get(PROPERTY_ACCTVALUEAMT);
    }

    public void setAcctvalueamt(BigDecimal acctvalueamt) {
        set(PROPERTY_ACCTVALUEAMT, acctvalueamt);
    }

    public String getAmortizationtype() {
        return (String) get(PROPERTY_AMORTIZATIONTYPE);
    }

    public void setAmortizationtype(String amortizationtype) {
        set(PROPERTY_AMORTIZATIONTYPE, amortizationtype);
    }

    public BigDecimal getAmortizationvalueamt() {
        return (BigDecimal) get(PROPERTY_AMORTIZATIONVALUEAMT);
    }

    public void setAmortizationvalueamt(BigDecimal amortizationvalueamt) {
        set(PROPERTY_AMORTIZATIONVALUEAMT, amortizationvalueamt);
    }

    public String getAssetschedule() {
        return (String) get(PROPERTY_ASSETSCHEDULE);
    }

    public void setAssetschedule(String assetschedule) {
        set(PROPERTY_ASSETSCHEDULE, assetschedule);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public BigDecimal getProfit() {
        return (BigDecimal) get(PROPERTY_PROFIT);
    }

    public void setProfit(BigDecimal profit) {
        set(PROPERTY_PROFIT, profit);
    }

    public String getAmortizationcalctype() {
        return (String) get(PROPERTY_AMORTIZATIONCALCTYPE);
    }

    public void setAmortizationcalctype(String amortizationcalctype) {
        set(PROPERTY_AMORTIZATIONCALCTYPE, amortizationcalctype);
    }

    public BigDecimal getDepreciatedplan() {
        return (BigDecimal) get(PROPERTY_DEPRECIATEDPLAN);
    }

    public void setDepreciatedplan(BigDecimal depreciatedplan) {
        set(PROPERTY_DEPRECIATEDPLAN, depreciatedplan);
    }

    public BigDecimal getDepreciatedpreviousamt() {
        return (BigDecimal) get(PROPERTY_DEPRECIATEDPREVIOUSAMT);
    }

    public void setDepreciatedpreviousamt(BigDecimal depreciatedpreviousamt) {
        set(PROPERTY_DEPRECIATEDPREVIOUSAMT, depreciatedpreviousamt);
    }

    public BigDecimal getDepreciatedvalue() {
        return (BigDecimal) get(PROPERTY_DEPRECIATEDVALUE);
    }

    public void setDepreciatedvalue(BigDecimal depreciatedvalue) {
        set(PROPERTY_DEPRECIATEDVALUE, depreciatedvalue);
    }

    public String getAssettype() {
        return (String) get(PROPERTY_ASSETTYPE);
    }

    public void setAssettype(String assettype) {
        set(PROPERTY_ASSETTYPE, assettype);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Boolean isCostcenter() {
        return (Boolean) get(PROPERTY_ISCOSTCENTER);
    }

    public void setCostcenter(Boolean iscostcenter) {
        set(PROPERTY_ISCOSTCENTER, iscostcenter);
    }

    public Boolean isSummary() {
        return (Boolean) get(PROPERTY_ISSUMMARY);
    }

    public void setSummary(Boolean issummary) {
        set(PROPERTY_ISSUMMARY, issummary);
    }

    public org.zsoft.serial.snr_masterdata getSNRMasterdata() {
        return (org.zsoft.serial.snr_masterdata) get(PROPERTY_SNRMASTERDATA);
    }

    public void setSNRMasterdata(org.zsoft.serial.snr_masterdata sNRMasterdata) {
        set(PROPERTY_SNRMASTERDATA, sNRMasterdata);
    }

    @SuppressWarnings("unchecked")
    public List<AssetAccounts> getFinancialMgmtAssetAccountsList() {
        return (List<AssetAccounts>) get(PROPERTY_FINANCIALMGMTASSETACCOUNTSLIST);
    }

    public void setFinancialMgmtAssetAccountsList(
        List<AssetAccounts> financialMgmtAssetAccountsList) {
        set(PROPERTY_FINANCIALMGMTASSETACCOUNTSLIST,
            financialMgmtAssetAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<AmortizationLine> getFinancialMgmtAmortizationLineList() {
        return (List<AmortizationLine>) get(PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST);
    }

    public void setFinancialMgmtAmortizationLineList(
        List<AmortizationLine> financialMgmtAmortizationLineList) {
        set(PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST,
            financialMgmtAmortizationLineList);
    }

    @SuppressWarnings("unchecked")
    public List<AssetAmortization> getFinancialMgmtAssetAmortizationList() {
        return (List<AssetAmortization>) get(PROPERTY_FINANCIALMGMTASSETAMORTIZATIONLIST);
    }

    public void setFinancialMgmtAssetAmortizationList(
        List<AssetAmortization> financialMgmtAssetAmortizationList) {
        set(PROPERTY_FINANCIALMGMTASSETAMORTIZATIONLIST,
            financialMgmtAssetAmortizationList);
    }
}
