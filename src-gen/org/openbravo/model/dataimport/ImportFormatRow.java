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
package org.openbravo.model.dataimport;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.datamodel.Column;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity DataImportFormatRow (stored in table AD_ImpFormat_Row).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ImportFormatRow extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_ImpFormat_Row";
    public static final String ENTITY_NAME = "DataImportFormatRow";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_IMPFORMAT = "impFormat";
    public static final String PROPERTY_SEQNO = "seqNo";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_COLUMN = "column";
    public static final String PROPERTY_STARTNO = "startNo";
    public static final String PROPERTY_ENDNO = "endNo";
    public static final String PROPERTY_DATATYPE = "dataType";
    public static final String PROPERTY_DATAFORMAT = "dataFormat";
    public static final String PROPERTY_DECIMALPOINT = "decimalPoint";
    public static final String PROPERTY_DIVIDEBY100 = "divideBy100";
    public static final String PROPERTY_CONSTANTVALUE = "constantValue";
    public static final String PROPERTY_CALLOUT = "callout";
    public static final String PROPERTY_SCRIPT = "script";

    public ImportFormatRow() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_DECIMALPOINT, ".");
        setDefaultValue(PROPERTY_DIVIDEBY100, false);
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

    public ImportFormat getImpFormat() {
        return (ImportFormat) get(PROPERTY_IMPFORMAT);
    }

    public void setImpFormat(ImportFormat impFormat) {
        set(PROPERTY_IMPFORMAT, impFormat);
    }

    public Long getSeqNo() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqNo(Long seqNo) {
        set(PROPERTY_SEQNO, seqNo);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public Column getColumn() {
        return (Column) get(PROPERTY_COLUMN);
    }

    public void setColumn(Column column) {
        set(PROPERTY_COLUMN, column);
    }

    public Long getStartNo() {
        return (Long) get(PROPERTY_STARTNO);
    }

    public void setStartNo(Long startNo) {
        set(PROPERTY_STARTNO, startNo);
    }

    public Long getEndNo() {
        return (Long) get(PROPERTY_ENDNO);
    }

    public void setEndNo(Long endNo) {
        set(PROPERTY_ENDNO, endNo);
    }

    public String getDataType() {
        return (String) get(PROPERTY_DATATYPE);
    }

    public void setDataType(String dataType) {
        set(PROPERTY_DATATYPE, dataType);
    }

    public String getDataFormat() {
        return (String) get(PROPERTY_DATAFORMAT);
    }

    public void setDataFormat(String dataFormat) {
        set(PROPERTY_DATAFORMAT, dataFormat);
    }

    public String getDecimalPoint() {
        return (String) get(PROPERTY_DECIMALPOINT);
    }

    public void setDecimalPoint(String decimalPoint) {
        set(PROPERTY_DECIMALPOINT, decimalPoint);
    }

    public Boolean isDivideBy100() {
        return (Boolean) get(PROPERTY_DIVIDEBY100);
    }

    public void setDivideBy100(Boolean divideBy100) {
        set(PROPERTY_DIVIDEBY100, divideBy100);
    }

    public String getConstantValue() {
        return (String) get(PROPERTY_CONSTANTVALUE);
    }

    public void setConstantValue(String constantValue) {
        set(PROPERTY_CONSTANTVALUE, constantValue);
    }

    public String getCallout() {
        return (String) get(PROPERTY_CALLOUT);
    }

    public void setCallout(String callout) {
        set(PROPERTY_CALLOUT, callout);
    }

    public String getScript() {
        return (String) get(PROPERTY_SCRIPT);
    }

    public void setScript(String script) {
        set(PROPERTY_SCRIPT, script);
    }
}
