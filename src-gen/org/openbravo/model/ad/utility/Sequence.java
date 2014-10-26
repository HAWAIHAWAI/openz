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
package org.openbravo.model.ad.utility;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.AdSequenceOrg;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ADSequence (stored in table AD_Sequence).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Sequence extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Sequence";
    public static final String ENTITY_NAME = "ADSequence";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_VFORMAT = "vFormat";
    public static final String PROPERTY_ISAUTOSEQUENCE = "isAutoSequence";
    public static final String PROPERTY_INCREMENTNO = "incrementNo";
    public static final String PROPERTY_STARTNO = "startNo";
    public static final String PROPERTY_CURRENTNEXT = "currentNext";
    public static final String PROPERTY_CURRENTNEXTSYS = "currentNextSys";
    public static final String PROPERTY_ISTABLEID = "isTableID";
    public static final String PROPERTY_PREFIX = "prefix";
    public static final String PROPERTY_SUFFIX = "suffix";
    public static final String PROPERTY_STARTNEWYEAR = "startNewYear";
    public static final String PROPERTY_SEQUENCEORGLIST = "sequenceOrgList";

    public Sequence() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISAUTOSEQUENCE, false);
        setDefaultValue(PROPERTY_INCREMENTNO, (long) 1);
        setDefaultValue(PROPERTY_STARTNO, (long) 1000000);
        setDefaultValue(PROPERTY_CURRENTNEXT, (long) 1000000);
        setDefaultValue(PROPERTY_CURRENTNEXTSYS, (long) 100);
        setDefaultValue(PROPERTY_ISTABLEID, false);
        setDefaultValue(PROPERTY_STARTNEWYEAR, false);
        setDefaultValue(PROPERTY_SEQUENCEORGLIST, new ArrayList<Object>());
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

    public String getVFormat() {
        return (String) get(PROPERTY_VFORMAT);
    }

    public void setVFormat(String vFormat) {
        set(PROPERTY_VFORMAT, vFormat);
    }

    public Boolean isAutoSequence() {
        return (Boolean) get(PROPERTY_ISAUTOSEQUENCE);
    }

    public void setAutoSequence(Boolean isAutoSequence) {
        set(PROPERTY_ISAUTOSEQUENCE, isAutoSequence);
    }

    public Long getIncrementNo() {
        return (Long) get(PROPERTY_INCREMENTNO);
    }

    public void setIncrementNo(Long incrementNo) {
        set(PROPERTY_INCREMENTNO, incrementNo);
    }

    public Long getStartNo() {
        return (Long) get(PROPERTY_STARTNO);
    }

    public void setStartNo(Long startNo) {
        set(PROPERTY_STARTNO, startNo);
    }

    public Long getCurrentNext() {
        return (Long) get(PROPERTY_CURRENTNEXT);
    }

    public void setCurrentNext(Long currentNext) {
        set(PROPERTY_CURRENTNEXT, currentNext);
    }

    public Long getCurrentNextSys() {
        return (Long) get(PROPERTY_CURRENTNEXTSYS);
    }

    public void setCurrentNextSys(Long currentNextSys) {
        set(PROPERTY_CURRENTNEXTSYS, currentNextSys);
    }

    public Boolean isTableID() {
        return (Boolean) get(PROPERTY_ISTABLEID);
    }

    public void setTableID(Boolean isTableID) {
        set(PROPERTY_ISTABLEID, isTableID);
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

    public Boolean isStartNewYear() {
        return (Boolean) get(PROPERTY_STARTNEWYEAR);
    }

    public void setStartNewYear(Boolean startNewYear) {
        set(PROPERTY_STARTNEWYEAR, startNewYear);
    }

    @SuppressWarnings("unchecked")
    public List<AdSequenceOrg> getSequenceOrgList() {
        return (List<AdSequenceOrg>) get(PROPERTY_SEQUENCEORGLIST);
    }

    public void setSequenceOrgList(List<AdSequenceOrg> sequenceOrgList) {
        set(PROPERTY_SEQUENCEORGLIST, sequenceOrgList);
    }
}
