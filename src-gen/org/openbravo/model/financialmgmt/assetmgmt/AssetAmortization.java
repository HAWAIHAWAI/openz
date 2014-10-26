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
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity FinancialMgmtAssetAmortization (stored in table A_Asset_Amortization).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class AssetAmortization extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "A_Asset_Amortization";
    public static final String ENTITY_NAME = "FinancialMgmtAssetAmortization";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_STARTDATE = "startDate";
    public static final String PROPERTY_ENDDATE = "endDate";
    public static final String PROPERTY_AMORTIZATIONPERCENTAGE =
        "amortizationPercentage";
    public static final String PROPERTY_AMORTIZATIONAMT = "amortizationamt";
    public static final String PROPERTY_AMORTIZATION = "amortization";

    public AssetAmortization() {
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
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

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Date getStartDate() {
        return (Date) get(PROPERTY_STARTDATE);
    }

    public void setStartDate(Date startDate) {
        set(PROPERTY_STARTDATE, startDate);
    }

    public Date getEndDate() {
        return (Date) get(PROPERTY_ENDDATE);
    }

    public void setEndDate(Date endDate) {
        set(PROPERTY_ENDDATE, endDate);
    }

    public BigDecimal getAmortizationPercentage() {
        return (BigDecimal) get(PROPERTY_AMORTIZATIONPERCENTAGE);
    }

    public void setAmortizationPercentage(BigDecimal amortizationPercentage) {
        set(PROPERTY_AMORTIZATIONPERCENTAGE, amortizationPercentage);
    }

    public BigDecimal getAmortizationamt() {
        return (BigDecimal) get(PROPERTY_AMORTIZATIONAMT);
    }

    public void setAmortizationamt(BigDecimal amortizationamt) {
        set(PROPERTY_AMORTIZATIONAMT, amortizationamt);
    }

    public Amortization getAmortization() {
        return (Amortization) get(PROPERTY_AMORTIZATION);
    }

    public void setAmortization(Amortization amortization) {
        set(PROPERTY_AMORTIZATION, amortization);
    }
}
