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
import org.openbravo.model.ad.domain.Reference;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ad_ref_group (stored in table ad_ref_group).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ad_ref_group extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ad_ref_group";
    public static final String ENTITY_NAME = "ad_ref_group";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_REFERENCE = "reference";
    public static final String PROPERTY_IDCOLUMN = "idcolumn";
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
    public static final String PROPERTY_REFGROUPINSTANCELIST =
        "refGroupinstanceList";
    public static final String PROPERTY_REFGRIDCOLUMNLIST = "refGridcolumnList";

    public ad_ref_group() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_LEADINGEMPTYCOLS, (long) 0);
        setDefaultValue(PROPERTY_HEADERFORMATBOLD, true);
        setDefaultValue(PROPERTY_COLSVISIBLEONINIT, true);
        setDefaultValue(PROPERTY_HASSELECTALLBELOW, false);
        setDefaultValue(PROPERTY_HASEVENODD, false);
        setDefaultValue(PROPERTY_HASEXPANDER, true);
        setDefaultValue(PROPERTY_HASSELECTLINE, false);
        setDefaultValue(PROPERTY_ISAUTOHEADER, false);
        setDefaultValue(PROPERTY_REFGROUPINSTANCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_REFGRIDCOLUMNLIST, new ArrayList<Object>());
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

    public Reference getReference() {
        return (Reference) get(PROPERTY_REFERENCE);
    }

    public void setReference(Reference reference) {
        set(PROPERTY_REFERENCE, reference);
    }

    public String getIdcolumn() {
        return (String) get(PROPERTY_IDCOLUMN);
    }

    public void setIdcolumn(String idcolumn) {
        set(PROPERTY_IDCOLUMN, idcolumn);
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

    public Boolean isHeaderformatbold() {
        return (Boolean) get(PROPERTY_HEADERFORMATBOLD);
    }

    public void setHeaderformatbold(Boolean headerformatbold) {
        set(PROPERTY_HEADERFORMATBOLD, headerformatbold);
    }

    public Boolean isColsvisibleoninit() {
        return (Boolean) get(PROPERTY_COLSVISIBLEONINIT);
    }

    public void setColsvisibleoninit(Boolean colsvisibleoninit) {
        set(PROPERTY_COLSVISIBLEONINIT, colsvisibleoninit);
    }

    public Boolean isHasselectallbelow() {
        return (Boolean) get(PROPERTY_HASSELECTALLBELOW);
    }

    public void setHasselectallbelow(Boolean hasselectallbelow) {
        set(PROPERTY_HASSELECTALLBELOW, hasselectallbelow);
    }

    public Boolean isHasevenodd() {
        return (Boolean) get(PROPERTY_HASEVENODD);
    }

    public void setHasevenodd(Boolean hasevenodd) {
        set(PROPERTY_HASEVENODD, hasevenodd);
    }

    public Boolean isHasexpander() {
        return (Boolean) get(PROPERTY_HASEXPANDER);
    }

    public void setHasexpander(Boolean hasexpander) {
        set(PROPERTY_HASEXPANDER, hasexpander);
    }

    public Boolean isHasselectline() {
        return (Boolean) get(PROPERTY_HASSELECTLINE);
    }

    public void setHasselectline(Boolean hasselectline) {
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

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.ad.system.ad_ref_groupinstance> getRefGroupinstanceList() {
        return (List<org.openbravo.model.ad.system.ad_ref_groupinstance>) get(PROPERTY_REFGROUPINSTANCELIST);
    }

    public void setRefGroupinstanceList(
        List<org.openbravo.model.ad.system.ad_ref_groupinstance> refGroupinstanceList) {
        set(PROPERTY_REFGROUPINSTANCELIST, refGroupinstanceList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.ad.system.ad_ref_gridcolumn> getRefGridcolumnList() {
        return (List<org.openbravo.model.ad.system.ad_ref_gridcolumn>) get(PROPERTY_REFGRIDCOLUMNLIST);
    }

    public void setRefGridcolumnList(
        List<org.openbravo.model.ad.system.ad_ref_gridcolumn> refGridcolumnList) {
        set(PROPERTY_REFGRIDCOLUMNLIST, refGridcolumnList);
    }
}
