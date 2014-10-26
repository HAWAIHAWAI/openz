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
import org.openbravo.model.ad.utility.Sequence;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity ad_sequence_org (stored in table ad_sequence_org).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class AdSequenceOrg extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ad_sequence_org";
    public static final String ENTITY_NAME = "ad_sequence_org";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_SEQUENCE = "sequence";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_VFORMAT = "vformat";
    public static final String PROPERTY_ISAUTOSEQUENCE = "isautosequence";
    public static final String PROPERTY_INCREMENTNO = "incrementno";
    public static final String PROPERTY_STARTNO = "startno";
    public static final String PROPERTY_CURRENTNEXT = "currentnext";
    public static final String PROPERTY_CURRENTNEXTSYS = "currentnextsys";
    public static final String PROPERTY_ISTABLEID = "istableid";
    public static final String PROPERTY_PREFIX = "prefix";
    public static final String PROPERTY_SUFFIX = "suffix";
    public static final String PROPERTY_STARTNEWYEAR = "startnewyear";

    public AdSequenceOrg() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISAUTOSEQUENCE, false);
        setDefaultValue(PROPERTY_STARTNO, (long) 1000000);
        setDefaultValue(PROPERTY_CURRENTNEXT, (long) 1000000);
        setDefaultValue(PROPERTY_CURRENTNEXTSYS, (long) 100);
        setDefaultValue(PROPERTY_ISTABLEID, false);
        setDefaultValue(PROPERTY_STARTNEWYEAR, false);
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

    public Sequence getSequence() {
        return (Sequence) get(PROPERTY_SEQUENCE);
    }

    public void setSequence(Sequence sequence) {
        set(PROPERTY_SEQUENCE, sequence);
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getVformat() {
        return (String) get(PROPERTY_VFORMAT);
    }

    public void setVformat(String vformat) {
        set(PROPERTY_VFORMAT, vformat);
    }

    public Boolean isAutosequence() {
        return (Boolean) get(PROPERTY_ISAUTOSEQUENCE);
    }

    public void setAutosequence(Boolean isautosequence) {
        set(PROPERTY_ISAUTOSEQUENCE, isautosequence);
    }

    public Long getIncrementno() {
        return (Long) get(PROPERTY_INCREMENTNO);
    }

    public void setIncrementno(Long incrementno) {
        set(PROPERTY_INCREMENTNO, incrementno);
    }

    public Long getStartno() {
        return (Long) get(PROPERTY_STARTNO);
    }

    public void setStartno(Long startno) {
        set(PROPERTY_STARTNO, startno);
    }

    public Long getCurrentnext() {
        return (Long) get(PROPERTY_CURRENTNEXT);
    }

    public void setCurrentnext(Long currentnext) {
        set(PROPERTY_CURRENTNEXT, currentnext);
    }

    public Long getCurrentnextsys() {
        return (Long) get(PROPERTY_CURRENTNEXTSYS);
    }

    public void setCurrentnextsys(Long currentnextsys) {
        set(PROPERTY_CURRENTNEXTSYS, currentnextsys);
    }

    public Boolean isTableid() {
        return (Boolean) get(PROPERTY_ISTABLEID);
    }

    public void setTableid(Boolean istableid) {
        set(PROPERTY_ISTABLEID, istableid);
    }

    public String getPrefix() {
        return (String) get(PROPERTY_PREFIX);
    }

    public void setPrefix(String prefix) {
        set(PROPERTY_PREFIX, prefix);
    }

    public String getSuffix() {
        return (String) get(PROPERTY_SUFFIX);
    }

    public void setSuffix(String suffix) {
        set(PROPERTY_SUFFIX, suffix);
    }

    public Boolean isStartnewyear() {
        return (Boolean) get(PROPERTY_STARTNEWYEAR);
    }

    public void setStartnewyear(Boolean startnewyear) {
        set(PROPERTY_STARTNEWYEAR, startnewyear);
    }
}
