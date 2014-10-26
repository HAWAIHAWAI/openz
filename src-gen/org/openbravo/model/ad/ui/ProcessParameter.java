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
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.domain.Reference;
import org.openbravo.model.ad.domain.Validation;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ADProcessParameter (stored in table AD_Process_Para).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ProcessParameter extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Process_Para";
    public static final String ENTITY_NAME = "ADProcessParameter";
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
    public static final String PROPERTY_HELP = "help";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_SEQNO = "seqNo";
    public static final String PROPERTY_REFERENCE = "reference";
    public static final String PROPERTY_REFERENCEVALUE = "referenceValue";
    public static final String PROPERTY_VALRULE = "valRule";
    public static final String PROPERTY_COLUMNNAME = "columnName";
    public static final String PROPERTY_ISCENTRALLYMAINTAINED =
        "isCentrallyMaintained";
    public static final String PROPERTY_FIELDLENGTH = "fieldLength";
    public static final String PROPERTY_ISMANDATORY = "isMandatory";
    public static final String PROPERTY_ISRANGE = "isRange";
    public static final String PROPERTY_DEFAULTVALUE = "defaultValue";
    public static final String PROPERTY_DEFAULTVALUE2 = "defaultValue2";
    public static final String PROPERTY_VFORMAT = "vFormat";
    public static final String PROPERTY_VALUEMIN = "valueMin";
    public static final String PROPERTY_VALUEMAX = "valueMax";
    public static final String PROPERTY_ELEMENT = "element";
    public static final String PROPERTY_READONLY = "readonly";
    public static final String PROPERTY_ISDISPLAYED = "isdisplayed";
    public static final String PROPERTY_READONLYLOGIC = "readonlylogic";
    public static final String PROPERTY_DISPLAYLOGIC = "displaylogic";
    public static final String PROPERTY_MANDANTORYLOGIC = "mandantorylogic";
    public static final String PROPERTY_INCLUDESEMPTYITEM = "includesemptyitem";
    public static final String PROPERTY_TEMPLATE = "template";
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_COLSTOTAL = "colstotal";
    public static final String PROPERTY_ISFIRSTFOCUSEDFIELD =
        "isfirstfocusedfield";
    public static final String PROPERTY_PROCESSPARAINSTANCELIST =
        "processParaInstanceList";
    public static final String PROPERTY_ADPROCESSPARAMETERTRLLIST =
        "aDProcessParameterTrlList";

    public ProcessParameter() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISCENTRALLYMAINTAINED, true);
        setDefaultValue(PROPERTY_ISMANDATORY, false);
        setDefaultValue(PROPERTY_ISRANGE, false);
        setDefaultValue(PROPERTY_READONLY, false);
        setDefaultValue(PROPERTY_ISDISPLAYED, true);
        setDefaultValue(PROPERTY_INCLUDESEMPTYITEM, true);
        setDefaultValue(PROPERTY_ISFIRSTFOCUSEDFIELD, false);
        setDefaultValue(PROPERTY_PROCESSPARAINSTANCELIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADPROCESSPARAMETERTRLLIST,
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

    public Process getProcess() {
        return (Process) get(PROPERTY_PROCESS);
    }

    public void setProcess(Process process) {
        set(PROPERTY_PROCESS, process);
    }

    public Long getSeqNo() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqNo(Long seqNo) {
        set(PROPERTY_SEQNO, seqNo);
    }

    public Reference getReference() {
        return (Reference) get(PROPERTY_REFERENCE);
    }

    public void setReference(Reference reference) {
        set(PROPERTY_REFERENCE, reference);
    }

    public Reference getReferenceValue() {
        return (Reference) get(PROPERTY_REFERENCEVALUE);
    }

    public void setReferenceValue(Reference referenceValue) {
        set(PROPERTY_REFERENCEVALUE, referenceValue);
    }

    public Validation getValRule() {
        return (Validation) get(PROPERTY_VALRULE);
    }

    public void setValRule(Validation valRule) {
        set(PROPERTY_VALRULE, valRule);
    }

    public String getColumnName() {
        return (String) get(PROPERTY_COLUMNNAME);
    }

    public void setColumnName(String columnName) {
        set(PROPERTY_COLUMNNAME, columnName);
    }

    public Boolean isCentrallyMaintained() {
        return (Boolean) get(PROPERTY_ISCENTRALLYMAINTAINED);
    }

    public void setCentrallyMaintained(Boolean isCentrallyMaintained) {
        set(PROPERTY_ISCENTRALLYMAINTAINED, isCentrallyMaintained);
    }

    public Long getFieldLength() {
        return (Long) get(PROPERTY_FIELDLENGTH);
    }

    public void setFieldLength(Long fieldLength) {
        set(PROPERTY_FIELDLENGTH, fieldLength);
    }

    public Boolean isMandatory() {
        return (Boolean) get(PROPERTY_ISMANDATORY);
    }

    public void setMandatory(Boolean isMandatory) {
        set(PROPERTY_ISMANDATORY, isMandatory);
    }

    public Boolean isRange() {
        return (Boolean) get(PROPERTY_ISRANGE);
    }

    public void setRange(Boolean isRange) {
        set(PROPERTY_ISRANGE, isRange);
    }

    public String getDefaultValue() {
        return (String) get(PROPERTY_DEFAULTVALUE);
    }

    public void setDefaultValue(String defaultValue) {
        set(PROPERTY_DEFAULTVALUE, defaultValue);
    }

    public String getDefaultValue2() {
        return (String) get(PROPERTY_DEFAULTVALUE2);
    }

    public void setDefaultValue2(String defaultValue2) {
        set(PROPERTY_DEFAULTVALUE2, defaultValue2);
    }

    public String getVFormat() {
        return (String) get(PROPERTY_VFORMAT);
    }

    public void setVFormat(String vFormat) {
        set(PROPERTY_VFORMAT, vFormat);
    }

    public String getValueMin() {
        return (String) get(PROPERTY_VALUEMIN);
    }

    public void setValueMin(String valueMin) {
        set(PROPERTY_VALUEMIN, valueMin);
    }

    public String getValueMax() {
        return (String) get(PROPERTY_VALUEMAX);
    }

    public void setValueMax(String valueMax) {
        set(PROPERTY_VALUEMAX, valueMax);
    }

    public Element getElement() {
        return (Element) get(PROPERTY_ELEMENT);
    }

    public void setElement(Element element) {
        set(PROPERTY_ELEMENT, element);
    }

    public Boolean isReadonly() {
        return (Boolean) get(PROPERTY_READONLY);
    }

    public void setReadonly(Boolean readonly) {
        set(PROPERTY_READONLY, readonly);
    }

    public Boolean isDisplayed() {
        return (Boolean) get(PROPERTY_ISDISPLAYED);
    }

    public void setDisplayed(Boolean isdisplayed) {
        set(PROPERTY_ISDISPLAYED, isdisplayed);
    }

    public String getReadonlylogic() {
        return (String) get(PROPERTY_READONLYLOGIC);
    }

    public void setReadonlylogic(String readonlylogic) {
        set(PROPERTY_READONLYLOGIC, readonlylogic);
    }

    public String getDisplaylogic() {
        return (String) get(PROPERTY_DISPLAYLOGIC);
    }

    public void setDisplaylogic(String displaylogic) {
        set(PROPERTY_DISPLAYLOGIC, displaylogic);
    }

    public String getMandantorylogic() {
        return (String) get(PROPERTY_MANDANTORYLOGIC);
    }

    public void setMandantorylogic(String mandantorylogic) {
        set(PROPERTY_MANDANTORYLOGIC, mandantorylogic);
    }

    public Boolean isIncludesemptyitem() {
        return (Boolean) get(PROPERTY_INCLUDESEMPTYITEM);
    }

    public void setIncludesemptyitem(Boolean includesemptyitem) {
        set(PROPERTY_INCLUDESEMPTYITEM, includesemptyitem);
    }

    public String getTemplate() {
        return (String) get(PROPERTY_TEMPLATE);
    }

    public void setTemplate(String template) {
        set(PROPERTY_TEMPLATE, template);
    }

    public Table getTable() {
        return (Table) get(PROPERTY_TABLE);
    }

    public void setTable(Table table) {
        set(PROPERTY_TABLE, table);
    }

    public String getColstotal() {
        return (String) get(PROPERTY_COLSTOTAL);
    }

    public void setColstotal(String colstotal) {
        set(PROPERTY_COLSTOTAL, colstotal);
    }

    public Boolean isFirstfocusedfield() {
        return (Boolean) get(PROPERTY_ISFIRSTFOCUSEDFIELD);
    }

    public void setFirstfocusedfield(Boolean isfirstfocusedfield) {
        set(PROPERTY_ISFIRSTFOCUSEDFIELD, isfirstfocusedfield);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.ad.system.ad_process_para_instance> getProcessParaInstanceList() {
        return (List<org.openbravo.model.ad.system.ad_process_para_instance>) get(PROPERTY_PROCESSPARAINSTANCELIST);
    }

    public void setProcessParaInstanceList(
        List<org.openbravo.model.ad.system.ad_process_para_instance> processParaInstanceList) {
        set(PROPERTY_PROCESSPARAINSTANCELIST, processParaInstanceList);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessParameterTrl> getADProcessParameterTrlList() {
        return (List<ProcessParameterTrl>) get(PROPERTY_ADPROCESSPARAMETERTRLLIST);
    }

    public void setADProcessParameterTrlList(
        List<ProcessParameterTrl> aDProcessParameterTrlList) {
        set(PROPERTY_ADPROCESSPARAMETERTRLLIST, aDProcessParameterTrlList);
    }
}
