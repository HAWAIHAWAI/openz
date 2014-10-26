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
package org.openbravo.model.ad.ui;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.datamodel.Column;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.domain.Callout;
import org.openbravo.model.ad.domain.Reference;
import org.openbravo.model.ad.domain.Validation;
import org.openbravo.model.ad.module.Module;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity ADField (stored in table AD_Field).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Field extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Field";
    public static final String ENTITY_NAME = "ADField";
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
    public static final String PROPERTY_ISCENTRALLYMAINTAINED =
        "isCentrallyMaintained";
    public static final String PROPERTY_TAB = "tab";
    public static final String PROPERTY_COLUMN = "column";
    public static final String PROPERTY_FIELDGROUP = "fieldGroup";
    public static final String PROPERTY_ISDISPLAYED = "isDisplayed";
    public static final String PROPERTY_DISPLAYLOGIC = "displayLogic";
    public static final String PROPERTY_DISPLAYLENGTH = "displayLength";
    public static final String PROPERTY_ISREADONLY = "isReadOnly";
    public static final String PROPERTY_SEQNO = "seqNo";
    public static final String PROPERTY_ISSAMELINE = "isSameLine";
    public static final String PROPERTY_ISFIELDONLY = "isFieldOnly";
    public static final String PROPERTY_SHOWINRELATION = "showInRelation";
    public static final String PROPERTY_ISFIRSTFOCUSEDFIELD =
        "isFirstFocusedField";
    public static final String PROPERTY_MODULE = "module";
    public static final String PROPERTY_GRIDSEQNO = "gridSeqNo";
    public static final String PROPERTY_GRIDLENGTH = "gridLength";
    public static final String PROPERTY_READONLYLOGIC = "readonlylogic";
    public static final String PROPERTY_MANDANTORYLOGIC = "mandantorylogic";
    public static final String PROPERTY_DEFAULTVALUE = "defaultvalue";
    public static final String PROPERTY_CALLOUT = "callout";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_ISIDENTIFIERCOLUMN =
        "isidentifiercolumn";
    public static final String PROPERTY_ISFILTERCOLUMN = "isfiltercolumn";
    public static final String PROPERTY_FIELDREFERENCE = "fieldreference";
    public static final String PROPERTY_TABLEREFERENCE = "tablereference";
    public static final String PROPERTY_VALIDATIONRULE = "validationrule";
    public static final String PROPERTY_REFERENCEURL = "referenceurl";
    public static final String PROPERTY_TEMPLATE = "template";
    public static final String PROPERTY_MAXLENGTH = "maxlength";
    public static final String PROPERTY_BUTTONCLASS = "buttonclass";
    public static final String PROPERTY_INCLUDESEMPTYITEM = "includesemptyitem";
    public static final String PROPERTY_STYLE = "style";
    public static final String PROPERTY_ONCHANGEEVENT = "onchangeevent";
    public static final String PROPERTY_REQUIRED = "required";
    public static final String PROPERTY_COLSTOTAL = "colstotal";

    public Field() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISCENTRALLYMAINTAINED, false);
        setDefaultValue(PROPERTY_ISDISPLAYED, true);
        setDefaultValue(PROPERTY_DISPLAYLENGTH, (long) 0);
        setDefaultValue(PROPERTY_ISREADONLY, false);
        setDefaultValue(PROPERTY_ISSAMELINE, false);
        setDefaultValue(PROPERTY_ISFIELDONLY, false);
        setDefaultValue(PROPERTY_SHOWINRELATION, false);
        setDefaultValue(PROPERTY_ISFIRSTFOCUSEDFIELD, false);
        setDefaultValue(PROPERTY_ISIDENTIFIERCOLUMN, false);
        setDefaultValue(PROPERTY_ISFILTERCOLUMN, false);
        setDefaultValue(PROPERTY_INCLUDESEMPTYITEM, false);
        setDefaultValue(PROPERTY_REQUIRED, false);
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

    public Boolean isCentrallyMaintained() {
        return (Boolean) get(PROPERTY_ISCENTRALLYMAINTAINED);
    }

    public void setCentrallyMaintained(Boolean isCentrallyMaintained) {
        set(PROPERTY_ISCENTRALLYMAINTAINED, isCentrallyMaintained);
    }

    public Tab getTab() {
        return (Tab) get(PROPERTY_TAB);
    }

    public void setTab(Tab tab) {
        set(PROPERTY_TAB, tab);
    }

    public Column getColumn() {
        return (Column) get(PROPERTY_COLUMN);
    }

    public void setColumn(Column column) {
        set(PROPERTY_COLUMN, column);
    }

    public FieldGroup getFieldGroup() {
        return (FieldGroup) get(PROPERTY_FIELDGROUP);
    }

    public void setFieldGroup(FieldGroup fieldGroup) {
        set(PROPERTY_FIELDGROUP, fieldGroup);
    }

    public Boolean isDisplayed() {
        return (Boolean) get(PROPERTY_ISDISPLAYED);
    }

    public void setDisplayed(Boolean isDisplayed) {
        set(PROPERTY_ISDISPLAYED, isDisplayed);
    }

    public String getDisplayLogic() {
        return (String) get(PROPERTY_DISPLAYLOGIC);
    }

    public void setDisplayLogic(String displayLogic) {
        set(PROPERTY_DISPLAYLOGIC, displayLogic);
    }

    public Long getDisplayLength() {
        return (Long) get(PROPERTY_DISPLAYLENGTH);
    }

    public void setDisplayLength(Long displayLength) {
        set(PROPERTY_DISPLAYLENGTH, displayLength);
    }

    public Boolean isReadOnly() {
        return (Boolean) get(PROPERTY_ISREADONLY);
    }

    public void setReadOnly(Boolean isReadOnly) {
        set(PROPERTY_ISREADONLY, isReadOnly);
    }

    public Long getSeqNo() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqNo(Long seqNo) {
        set(PROPERTY_SEQNO, seqNo);
    }

    public Boolean isSameLine() {
        return (Boolean) get(PROPERTY_ISSAMELINE);
    }

    public void setSameLine(Boolean isSameLine) {
        set(PROPERTY_ISSAMELINE, isSameLine);
    }

    public Boolean isFieldOnly() {
        return (Boolean) get(PROPERTY_ISFIELDONLY);
    }

    public void setFieldOnly(Boolean isFieldOnly) {
        set(PROPERTY_ISFIELDONLY, isFieldOnly);
    }

    public Boolean isShowInRelation() {
        return (Boolean) get(PROPERTY_SHOWINRELATION);
    }

    public void setShowInRelation(Boolean showInRelation) {
        set(PROPERTY_SHOWINRELATION, showInRelation);
    }

    public Boolean isFirstFocusedField() {
        return (Boolean) get(PROPERTY_ISFIRSTFOCUSEDFIELD);
    }

    public void setFirstFocusedField(Boolean isFirstFocusedField) {
        set(PROPERTY_ISFIRSTFOCUSEDFIELD, isFirstFocusedField);
    }

    public Module getModule() {
        return (Module) get(PROPERTY_MODULE);
    }

    public void setModule(Module module) {
        set(PROPERTY_MODULE, module);
    }

    public Long getGridSeqNo() {
        return (Long) get(PROPERTY_GRIDSEQNO);
    }

    public void setGridSeqNo(Long gridSeqNo) {
        set(PROPERTY_GRIDSEQNO, gridSeqNo);
    }

    public Long getGridLength() {
        return (Long) get(PROPERTY_GRIDLENGTH);
    }

    public void setGridLength(Long gridLength) {
        set(PROPERTY_GRIDLENGTH, gridLength);
    }

    public String getReadonlylogic() {
        return (String) get(PROPERTY_READONLYLOGIC);
    }

    public void setReadonlylogic(String readonlylogic) {
        set(PROPERTY_READONLYLOGIC, readonlylogic);
    }

    public String getMandantorylogic() {
        return (String) get(PROPERTY_MANDANTORYLOGIC);
    }

    public void setMandantorylogic(String mandantorylogic) {
        set(PROPERTY_MANDANTORYLOGIC, mandantorylogic);
    }

    public String getDefaultvalue() {
        return (String) get(PROPERTY_DEFAULTVALUE);
    }

    public void setDefaultvalue(String defaultvalue) {
        set(PROPERTY_DEFAULTVALUE, defaultvalue);
    }

    public Callout getCallout() {
        return (Callout) get(PROPERTY_CALLOUT);
    }

    public void setCallout(Callout callout) {
        set(PROPERTY_CALLOUT, callout);
    }

    public Process getProcess() {
        return (Process) get(PROPERTY_PROCESS);
    }

    public void setProcess(Process process) {
        set(PROPERTY_PROCESS, process);
    }

    public Boolean isIdentifiercolumn() {
        return (Boolean) get(PROPERTY_ISIDENTIFIERCOLUMN);
    }

    public void setIdentifiercolumn(Boolean isidentifiercolumn) {
        set(PROPERTY_ISIDENTIFIERCOLUMN, isidentifiercolumn);
    }

    public Boolean isFiltercolumn() {
        return (Boolean) get(PROPERTY_ISFILTERCOLUMN);
    }

    public void setFiltercolumn(Boolean isfiltercolumn) {
        set(PROPERTY_ISFILTERCOLUMN, isfiltercolumn);
    }

    public Reference getFieldreference() {
        return (Reference) get(PROPERTY_FIELDREFERENCE);
    }

    public void setFieldreference(Reference fieldreference) {
        set(PROPERTY_FIELDREFERENCE, fieldreference);
    }

    public Table getTablereference() {
        return (Table) get(PROPERTY_TABLEREFERENCE);
    }

    public void setTablereference(Table tablereference) {
        set(PROPERTY_TABLEREFERENCE, tablereference);
    }

    public Validation getValidationrule() {
        return (Validation) get(PROPERTY_VALIDATIONRULE);
    }

    public void setValidationrule(Validation validationrule) {
        set(PROPERTY_VALIDATIONRULE, validationrule);
    }

    public String getReferenceurl() {
        return (String) get(PROPERTY_REFERENCEURL);
    }

    public void setReferenceurl(String referenceurl) {
        set(PROPERTY_REFERENCEURL, referenceurl);
    }

    public String getTemplate() {
        return (String) get(PROPERTY_TEMPLATE);
    }

    public void setTemplate(String template) {
        set(PROPERTY_TEMPLATE, template);
    }

    public Long getMaxlength() {
        return (Long) get(PROPERTY_MAXLENGTH);
    }

    public void setMaxlength(Long maxlength) {
        set(PROPERTY_MAXLENGTH, maxlength);
    }

    public String getButtonclass() {
        return (String) get(PROPERTY_BUTTONCLASS);
    }

    public void setButtonclass(String buttonclass) {
        set(PROPERTY_BUTTONCLASS, buttonclass);
    }

    public Boolean isIncludesemptyitem() {
        return (Boolean) get(PROPERTY_INCLUDESEMPTYITEM);
    }

    public void setIncludesemptyitem(Boolean includesemptyitem) {
        set(PROPERTY_INCLUDESEMPTYITEM, includesemptyitem);
    }

    public String getStyle() {
        return (String) get(PROPERTY_STYLE);
    }

    public void setStyle(String style) {
        set(PROPERTY_STYLE, style);
    }

    public String getOnchangeevent() {
        return (String) get(PROPERTY_ONCHANGEEVENT);
    }

    public void setOnchangeevent(String onchangeevent) {
        set(PROPERTY_ONCHANGEEVENT, onchangeevent);
    }

    public Boolean isRequired() {
        return (Boolean) get(PROPERTY_REQUIRED);
    }

    public void setRequired(Boolean required) {
        set(PROPERTY_REQUIRED, required);
    }

    public String getColstotal() {
        return (String) get(PROPERTY_COLSTOTAL);
    }

    public void setColstotal(String colstotal) {
        set(PROPERTY_COLSTOTAL, colstotal);
    }
}
