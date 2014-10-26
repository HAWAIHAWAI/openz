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
package org.openbravo.zsoft.finance;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ZSPR_Bwaprefs (stored in table zspr_bwaprefs).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class bwaprefs extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zspr_bwaprefs";
    public static final String ENTITY_NAME = "ZSPR_Bwaprefs";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ZSPRBWAHEADER = "zsprBwaheader";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PARENTPREF = "parentpref";
    public static final String PROPERTY_ORDERNO = "orderno";
    public static final String PROPERTY_ISPARENT = "isparent";
    public static final String PROPERTY_ISASSET = "isasset";
    public static final String PROPERTY_ALLWOWONLYNEGATIVE =
        "allwowonlynegative";
    public static final String PROPERTY_ALLWOWONLYPOSITIVE =
        "allwowonlypositive";
    public static final String PROPERTY_DONTPRINTDETAILS = "dontprintdetails";
    public static final String PROPERTY_SUMFROMBEGINNING = "sumfrombeginning";
    public static final String PROPERTY_ISSUMINFOOTER = "issuminfooter";
    public static final String PROPERTY_ZSPRBWAPREFACCTLIST =
        "zsprBwaprefacctList";

    public bwaprefs() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ORDERNO, (long) 0);
        setDefaultValue(PROPERTY_ISPARENT, true);
        setDefaultValue(PROPERTY_ISASSET, false);
        setDefaultValue(PROPERTY_ALLWOWONLYNEGATIVE, false);
        setDefaultValue(PROPERTY_ALLWOWONLYPOSITIVE, false);
        setDefaultValue(PROPERTY_DONTPRINTDETAILS, false);
        setDefaultValue(PROPERTY_SUMFROMBEGINNING, true);
        setDefaultValue(PROPERTY_ISSUMINFOOTER, true);
        setDefaultValue(PROPERTY_ZSPRBWAPREFACCTLIST, new ArrayList<Object>());
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

    public org.openbravo.zsoft.finance.bwaheader getZsprBwaheader() {
        return (org.openbravo.zsoft.finance.bwaheader) get(PROPERTY_ZSPRBWAHEADER);
    }

    public void setZsprBwaheader(
        org.openbravo.zsoft.finance.bwaheader zsprBwaheader) {
        set(PROPERTY_ZSPRBWAHEADER, zsprBwaheader);
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public org.openbravo.zsoft.finance.bwaprefs getParentpref() {
        return (org.openbravo.zsoft.finance.bwaprefs) get(PROPERTY_PARENTPREF);
    }

    public void setParentpref(org.openbravo.zsoft.finance.bwaprefs parentpref) {
        set(PROPERTY_PARENTPREF, parentpref);
    }

    public Long getOrderno() {
        return (Long) get(PROPERTY_ORDERNO);
    }

    public void setOrderno(Long orderno) {
        set(PROPERTY_ORDERNO, orderno);
    }

    public Boolean isParent() {
        return (Boolean) get(PROPERTY_ISPARENT);
    }

    public void setParent(Boolean isparent) {
        set(PROPERTY_ISPARENT, isparent);
    }

    public Boolean isAsset() {
        return (Boolean) get(PROPERTY_ISASSET);
    }

    public void setAsset(Boolean isasset) {
        set(PROPERTY_ISASSET, isasset);
    }

    public Boolean isAllwowonlynegative() {
        return (Boolean) get(PROPERTY_ALLWOWONLYNEGATIVE);
    }

    public void setAllwowonlynegative(Boolean allwowonlynegative) {
        set(PROPERTY_ALLWOWONLYNEGATIVE, allwowonlynegative);
    }

    public Boolean isAllwowonlypositive() {
        return (Boolean) get(PROPERTY_ALLWOWONLYPOSITIVE);
    }

    public void setAllwowonlypositive(Boolean allwowonlypositive) {
        set(PROPERTY_ALLWOWONLYPOSITIVE, allwowonlypositive);
    }

    public Boolean isDontprintdetails() {
        return (Boolean) get(PROPERTY_DONTPRINTDETAILS);
    }

    public void setDontprintdetails(Boolean dontprintdetails) {
        set(PROPERTY_DONTPRINTDETAILS, dontprintdetails);
    }

    public Boolean isSumfrombeginning() {
        return (Boolean) get(PROPERTY_SUMFROMBEGINNING);
    }

    public void setSumfrombeginning(Boolean sumfrombeginning) {
        set(PROPERTY_SUMFROMBEGINNING, sumfrombeginning);
    }

    public Boolean isSuminfooter() {
        return (Boolean) get(PROPERTY_ISSUMINFOOTER);
    }

    public void setSuminfooter(Boolean issuminfooter) {
        set(PROPERTY_ISSUMINFOOTER, issuminfooter);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.zsoft.finance.bwaprefacct> getZsprBwaprefacctList() {
        return (List<org.openbravo.zsoft.finance.bwaprefacct>) get(PROPERTY_ZSPRBWAPREFACCTLIST);
    }

    public void setZsprBwaprefacctList(
        List<org.openbravo.zsoft.finance.bwaprefacct> zsprBwaprefacctList) {
        set(PROPERTY_ZSPRBWAPREFACCTLIST, zsprBwaprefacctList);
    }
}
