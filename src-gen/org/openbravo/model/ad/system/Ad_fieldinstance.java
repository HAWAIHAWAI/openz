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
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.domain.Callout;
import org.openbravo.model.ad.domain.Reference;
import org.openbravo.model.ad.domain.Validation;
import org.openbravo.model.ad.ui.FieldGroup;
import org.openbravo.model.ad.ui.Process;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity ad_fieldinstance (stored in table ad_fieldinstance).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Ad_fieldinstance extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ad_fieldinstance";
    public static final String ENTITY_NAME = "ad_fieldinstance";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_FIELDV = "fieldV";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_GRIDSEQNO = "gridseqno";
    public static final String PROPERTY_GRIDLENGTH = "gridlength";
    public static final String PROPERTY_SHOWINRELATION = "showinrelation";
    public static final String PROPERTY_EDITSETTING = "editsetting";
    public static final String PROPERTY_VISIBLESETTING = "visiblesetting";
    public static final String PROPERTY_READONLYLOGIC = "readonlylogic";
    public static final String PROPERTY_DISPLAYLOGIC = "displaylogic";
    public static final String PROPERTY_MANDANTORYLOGIC = "mandantorylogic";
    public static final String PROPERTY_DEFAULTVALUE = "defaultvalue";
    public static final String PROPERTY_ISFIRSTFOCUSEDFIELD =
        "isfirstfocusedfield";
    public static final String PROPERTY_SEQNO = "seqno";
    public static final String PROPERTY_ISSAMELINE = "issameline";
    public static final String PROPERTY_CALLOUT = "callout";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_ISIDENTIFIERCOLUMN =
        "isidentifiercolumn";
    public static final String PROPERTY_ISFILTERCOLUMN = "isfiltercolumn";
    public static final String PROPERTY_FIELDREFERENCE = "fieldreference";
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_VALRULE = "valRule";
    public static final String PROPERTY_REFERENCEURL = "referenceurl";
    public static final String PROPERTY_TEMPLATE = "template";
    public static final String PROPERTY_MAXLENGTH = "maxlength";
    public static final String PROPERTY_BUTTONCLASS = "buttonclass";
    public static final String PROPERTY_INCLUDESEMPTYITEM = "includesemptyitem";
    public static final String PROPERTY_STYLE = "style";
    public static final String PROPERTY_ONCHANGEEVENT = "onchangeevent";
    public static final String PROPERTY_COLSTOTAL = "colstotal";
    public static final String PROPERTY_FIELDGROUP = "fieldgroup";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_IDENTSEQUENCE = "identsequence";

    public Ad_fieldinstance() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_SHOWINRELATION, "NON");
        setDefaultValue(PROPERTY_EDITSETTING, "NON");
        setDefaultValue(PROPERTY_VISIBLESETTING, "NON");
        setDefaultValue(PROPERTY_ISFIRSTFOCUSEDFIELD, "NON");
        setDefaultValue(PROPERTY_ISSAMELINE, "NON");
        setDefaultValue(PROPERTY_ISIDENTIFIERCOLUMN, "NON");
        setDefaultValue(PROPERTY_ISFILTERCOLUMN, "NON");
        setDefaultValue(PROPERTY_INCLUDESEMPTYITEM, "NON");
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

    public org.openbravo.model.ad.datamodel.ad_field_v getFieldV() {
        return (org.openbravo.model.ad.datamodel.ad_field_v) get(PROPERTY_FIELDV);
    }

    public void setFieldV(org.openbravo.model.ad.datamodel.ad_field_v fieldV) {
        set(PROPERTY_FIELDV, fieldV);
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

    public String getShowinrelation() {
        return (String) get(PROPERTY_SHOWINRELATION);
    }

    public void setShowinrelation(String showinrelation) {
        set(PROPERTY_SHOWINRELATION, showinrelation);
    }

    public String getEditsetting() {
        return (String) get(PROPERTY_EDITSETTING);
    }

    public void setEditsetting(String editsetting) {
        set(PROPERTY_EDITSETTING, editsetting);
    }

    public String getVisiblesetting() {
        return (String) get(PROPERTY_VISIBLESETTING);
    }

    public void setVisiblesetting(String visiblesetting) {
        set(PROPERTY_VISIBLESETTING, visiblesetting);
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

    public String getDefaultvalue() {
        return (String) get(PROPERTY_DEFAULTVALUE);
    }

    public void setDefaultvalue(String defaultvalue) {
        set(PROPERTY_DEFAULTVALUE, defaultvalue);
    }

    public String getIsfirstfocusedfield() {
        return (String) get(PROPERTY_ISFIRSTFOCUSEDFIELD);
    }

    public void setIsfirstfocusedfield(String isfirstfocusedfield) {
        set(PROPERTY_ISFIRSTFOCUSEDFIELD, isfirstfocusedfield);
    }

    public Long getSeqno() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqno(Long seqno) {
        set(PROPERTY_SEQNO, seqno);
    }

    public String getIssameline() {
        return (String) get(PROPERTY_ISSAMELINE);
    }

    public void setIssameline(String issameline) {
        set(PROPERTY_ISSAMELINE, issameline);
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

    public String getIsidentifiercolumn() {
        return (String) get(PROPERTY_ISIDENTIFIERCOLUMN);
    }

    public void setIsidentifiercolumn(String isidentifiercolumn) {
        set(PROPERTY_ISIDENTIFIERCOLUMN, isidentifiercolumn);
    }

    public String getIsfiltercolumn() {
        return (String) get(PROPERTY_ISFILTERCOLUMN);
    }

    public void setIsfiltercolumn(String isfiltercolumn) {
        set(PROPERTY_ISFILTERCOLUMN, isfiltercolumn);
    }

    public Reference getFieldreference() {
        return (Reference) get(PROPERTY_FIELDREFERENCE);
    }

    public void setFieldreference(Reference fieldreference) {
        set(PROPERTY_FIELDREFERENCE, fieldreference);
    }

    public Table getTable() {
        return (Table) get(PROPERTY_TABLE);
    }

    public void setTable(Table table) {
        set(PROPERTY_TABLE, table);
    }

    public Validation getValRule() {
        return (Validation) get(PROPERTY_VALRULE);
    }

    public void setValRule(Validation valRule) {
        set(PROPERTY_VALRULE, valRule);
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

    public String getIncludesemptyitem() {
        return (String) get(PROPERTY_INCLUDESEMPTYITEM);
    }

    public void setIncludesemptyitem(String includesemptyitem) {
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

    public String getColstotal() {
        return (String) get(PROPERTY_COLSTOTAL);
    }

    public void setColstotal(String colstotal) {
        set(PROPERTY_COLSTOTAL, colstotal);
    }

    public FieldGroup getFieldgroup() {
        return (FieldGroup) get(PROPERTY_FIELDGROUP);
    }

    public void setFieldgroup(FieldGroup fieldgroup) {
        set(PROPERTY_FIELDGROUP, fieldgroup);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public Long getIdentsequence() {
        return (Long) get(PROPERTY_IDENTSEQUENCE);
    }

    public void setIdentsequence(Long identsequence) {
        set(PROPERTY_IDENTSEQUENCE, identsequence);
    }
}
