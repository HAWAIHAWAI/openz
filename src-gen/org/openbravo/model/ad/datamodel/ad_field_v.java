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
package org.openbravo.model.ad.datamodel;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.domain.Callout;
import org.openbravo.model.ad.domain.Reference;
import org.openbravo.model.ad.domain.Validation;
import org.openbravo.model.ad.module.Module;
import org.openbravo.model.ad.system.Ad_fieldinstance;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.ui.FieldGroup;
import org.openbravo.model.ad.ui.FieldTrl;
import org.openbravo.model.ad.ui.Process;
import org.openbravo.model.ad.ui.Tab;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ad_field_v (stored in table ad_field_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ad_field_v extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ad_field_v";
    public static final String ENTITY_NAME = "ad_field_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ISCENTRALLYMAINTAINED =
        "iscentrallymaintained";
    public static final String PROPERTY_TAB = "tab";
    public static final String PROPERTY_COLUMNV = "columnV";
    public static final String PROPERTY_FIELDGROUP = "fieldgroup";
    public static final String PROPERTY_ISDISPLAYED = "isdisplayed";
    public static final String PROPERTY_DISPLAYLOGIC = "displaylogic";
    public static final String PROPERTY_DISPLAYLENGTH = "displaylength";
    public static final String PROPERTY_ISREADONLY = "isreadonly";
    public static final String PROPERTY_SEQNO = "seqno";
    public static final String PROPERTY_ISSAMELINE = "issameline";
    public static final String PROPERTY_ISFIELDONLY = "isfieldonly";
    public static final String PROPERTY_SHOWINRELATION = "showinrelation";
    public static final String PROPERTY_ISFIRSTFOCUSEDFIELD =
        "isfirstfocusedfield";
    public static final String PROPERTY_MODULE = "module";
    public static final String PROPERTY_GRIDSEQNO = "gridseqno";
    public static final String PROPERTY_GRIDLENGTH = "gridlength";
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
    public static final String PROPERTY_FIELDINSTANCELIST = "fieldinstanceList";
    public static final String PROPERTY_ADFIELDTRLLIST = "aDFieldTrlList";
    public static final String PROPERTY_FIELDTRLINSTANCELIST =
        "fieldTrlInstanceList";

    public ad_field_v() {
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
        setDefaultValue(PROPERTY_FIELDINSTANCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADFIELDTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FIELDTRLINSTANCELIST, new ArrayList<Object>());
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

    public Boolean isCentrallymaintained() {
        return (Boolean) get(PROPERTY_ISCENTRALLYMAINTAINED);
    }

    public void setCentrallymaintained(Boolean iscentrallymaintained) {
        set(PROPERTY_ISCENTRALLYMAINTAINED, iscentrallymaintained);
    }

    public Tab getTab() {
        return (Tab) get(PROPERTY_TAB);
    }

    public void setTab(Tab tab) {
        set(PROPERTY_TAB, tab);
    }

    public org.openbravo.model.ad.datamodel.ad_column_v getColumnV() {
        return (org.openbravo.model.ad.datamodel.ad_column_v) get(PROPERTY_COLUMNV);
    }

    public void setColumnV(org.openbravo.model.ad.datamodel.ad_column_v columnV) {
        set(PROPERTY_COLUMNV, columnV);
    }

    public FieldGroup getFieldgroup() {
        return (FieldGroup) get(PROPERTY_FIELDGROUP);
    }

    public void setFieldgroup(FieldGroup fieldgroup) {
        set(PROPERTY_FIELDGROUP, fieldgroup);
    }

    public Boolean isDisplayed() {
        return (Boolean) get(PROPERTY_ISDISPLAYED);
    }

    public void setDisplayed(Boolean isdisplayed) {
        set(PROPERTY_ISDISPLAYED, isdisplayed);
    }

    public String getDisplaylogic() {
        return (String) get(PROPERTY_DISPLAYLOGIC);
    }

    public void setDisplaylogic(String displaylogic) {
        set(PROPERTY_DISPLAYLOGIC, displaylogic);
    }

    public Long getDisplaylength() {
        return (Long) get(PROPERTY_DISPLAYLENGTH);
    }

    public void setDisplaylength(Long displaylength) {
        set(PROPERTY_DISPLAYLENGTH, displaylength);
    }

    public Boolean isReadonly() {
        return (Boolean) get(PROPERTY_ISREADONLY);
    }

    public void setReadonly(Boolean isreadonly) {
        set(PROPERTY_ISREADONLY, isreadonly);
    }

    public Long getSeqno() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqno(Long seqno) {
        set(PROPERTY_SEQNO, seqno);
    }

    public Boolean isSameline() {
        return (Boolean) get(PROPERTY_ISSAMELINE);
    }

    public void setSameline(Boolean issameline) {
        set(PROPERTY_ISSAMELINE, issameline);
    }

    public Boolean isFieldonly() {
        return (Boolean) get(PROPERTY_ISFIELDONLY);
    }

    public void setFieldonly(Boolean isfieldonly) {
        set(PROPERTY_ISFIELDONLY, isfieldonly);
    }

    public Boolean isShowinrelation() {
        return (Boolean) get(PROPERTY_SHOWINRELATION);
    }

    public void setShowinrelation(Boolean showinrelation) {
        set(PROPERTY_SHOWINRELATION, showinrelation);
    }

    public Boolean isFirstfocusedfield() {
        return (Boolean) get(PROPERTY_ISFIRSTFOCUSEDFIELD);
    }

    public void setFirstfocusedfield(Boolean isfirstfocusedfield) {
        set(PROPERTY_ISFIRSTFOCUSEDFIELD, isfirstfocusedfield);
    }

    public Module getModule() {
        return (Module) get(PROPERTY_MODULE);
    }

    public void setModule(Module module) {
        set(PROPERTY_MODULE, module);
    }

    public Long getGridseqno() {
        return (Long) get(PROPERTY_GRIDSEQNO);
    }

    public void setGridseqno(Long gridseqno) {
        set(PROPERTY_GRIDSEQNO, gridseqno);
    }

    public Long getGridlength() {
        return (Long) get(PROPERTY_GRIDLENGTH);
    }

    public void setGridlength(Long gridlength) {
        set(PROPERTY_GRIDLENGTH, gridlength);
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

    @SuppressWarnings("unchecked")
    public List<Ad_fieldinstance> getFieldinstanceList() {
        return (List<Ad_fieldinstance>) get(PROPERTY_FIELDINSTANCELIST);
    }

    public void setFieldinstanceList(List<Ad_fieldinstance> fieldinstanceList) {
        set(PROPERTY_FIELDINSTANCELIST, fieldinstanceList);
    }

    @SuppressWarnings("unchecked")
    public List<FieldTrl> getADFieldTrlList() {
        return (List<FieldTrl>) get(PROPERTY_ADFIELDTRLLIST);
    }

    public void setADFieldTrlList(List<FieldTrl> aDFieldTrlList) {
        set(PROPERTY_ADFIELDTRLLIST, aDFieldTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<Adfieldtrlinstance> getFieldTrlInstanceList() {
        return (List<Adfieldtrlinstance>) get(PROPERTY_FIELDTRLINSTANCELIST);
    }

    public void setFieldTrlInstanceList(
        List<Adfieldtrlinstance> fieldTrlInstanceList) {
        set(PROPERTY_FIELDTRLINSTANCELIST, fieldTrlInstanceList);
    }
}
