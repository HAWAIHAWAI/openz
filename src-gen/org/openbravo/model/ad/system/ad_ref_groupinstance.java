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
package org.openbravo.model.ad.system;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity ad_ref_groupinstance (stored in table ad_ref_groupinstance).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ad_ref_groupinstance extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ad_ref_groupinstance";
    public static final String ENTITY_NAME = "ad_ref_groupinstance";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_REFGROUP = "refGroup";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_LEVEL = "level";
    public static final String PROPERTY_LEADINGEMPTYCOLS = "leadingemptycols";
    public static final String PROPERTY_HEADERFORMATBOLD = "headerformatbold";
    public static final String PROPERTY_COLSVISIBLEONINIT = "colsvisibleoninit";
    public static final String PROPERTY_HASSELECTALLBELOW = "hasselectallbelow";
    public static final String PROPERTY_HASEVENODD = "hasevenodd";
    public static final String PROPERTY_HASEXPANDER = "hasexpander";
    public static final String PROPERTY_HASSELECTLINE = "hasselectline";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_ISAUTOHEADER = "isautoheader";

    public ad_ref_groupinstance() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_HEADERFORMATBOLD, "NON");
        setDefaultValue(PROPERTY_COLSVISIBLEONINIT, "NON");
        setDefaultValue(PROPERTY_HASSELECTALLBELOW, "NON");
        setDefaultValue(PROPERTY_HASEVENODD, "NON");
        setDefaultValue(PROPERTY_HASEXPANDER, "NON");
        setDefaultValue(PROPERTY_HASSELECTLINE, "NON");
        setDefaultValue(PROPERTY_ISAUTOHEADER, false);
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

    public org.openbravo.model.ad.system.ad_ref_group getRefGroup() {
        return (org.openbravo.model.ad.system.ad_ref_group) get(PROPERTY_REFGROUP);
    }

    public void setRefGroup(org.openbravo.model.ad.system.ad_ref_group refGroup) {
        set(PROPERTY_REFGROUP, refGroup);
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

    public Long getLevel() {
        return (Long) get(PROPERTY_LEVEL);
    }

    public void setLevel(Long level) {
        set(PROPERTY_LEVEL, level);
    }

    public Long getLeadingemptycols() {
        return (Long) get(PROPERTY_LEADINGEMPTYCOLS);
    }

    public void setLeadingemptycols(Long leadingemptycols) {
        set(PROPERTY_LEADINGEMPTYCOLS, leadingemptycols);
    }

    public String getHeaderformatbold() {
        return (String) get(PROPERTY_HEADERFORMATBOLD);
    }

    public void setHeaderformatbold(String headerformatbold) {
        set(PROPERTY_HEADERFORMATBOLD, headerformatbold);
    }

    public String getColsvisibleoninit() {
        return (String) get(PROPERTY_COLSVISIBLEONINIT);
    }

    public void setColsvisibleoninit(String colsvisibleoninit) {
        set(PROPERTY_COLSVISIBLEONINIT, colsvisibleoninit);
    }

    public String getHasselectallbelow() {
        return (String) get(PROPERTY_HASSELECTALLBELOW);
    }

    public void setHasselectallbelow(String hasselectallbelow) {
        set(PROPERTY_HASSELECTALLBELOW, hasselectallbelow);
    }

    public String getHasevenodd() {
        return (String) get(PROPERTY_HASEVENODD);
    }

    public void setHasevenodd(String hasevenodd) {
        set(PROPERTY_HASEVENODD, hasevenodd);
    }

    public String getHasexpander() {
        return (String) get(PROPERTY_HASEXPANDER);
    }

    public void setHasexpander(String hasexpander) {
        set(PROPERTY_HASEXPANDER, hasexpander);
    }

    public String getHasselectline() {
        return (String) get(PROPERTY_HASSELECTLINE);
    }

    public void setHasselectline(String hasselectline) {
        set(PROPERTY_HASSELECTLINE, hasselectline);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public Boolean isAutoheader() {
        return (Boolean) get(PROPERTY_ISAUTOHEADER);
    }

    public void setAutoheader(Boolean isautoheader) {
        set(PROPERTY_ISAUTOHEADER, isautoheader);
    }
}
