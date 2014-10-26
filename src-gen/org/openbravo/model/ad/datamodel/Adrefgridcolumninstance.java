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
import org.openbravo.model.ad.domain.Reference;
import org.openbravo.model.ad.domain.Validation;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.ui.Element;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity ad_ref_gridcolumninstance (stored in table ad_ref_gridcolumninstance).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Adrefgridcolumninstance extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ad_ref_gridcolumninstance";
    public static final String ENTITY_NAME = "ad_ref_gridcolumninstance";
    public static final String PROPERTY_REFGRIDCOLUMN = "refGridcolumn";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_HEADERTEXT = "headertext";
    public static final String PROPERTY_TEMPLATE = "template";
    public static final String PROPERTY_REFERENCEURL = "referenceurl";
    public static final String PROPERTY_COLREFERENCE = "colreference";
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_COLSPAN = "colspan";
    public static final String PROPERTY_MAXLENGTH = "maxlength";
    public static final String PROPERTY_REQUIRED = "required";
    public static final String PROPERTY_READONLY = "readonly";
    public static final String PROPERTY_ISINHEADER = "isinheader";
    public static final String PROPERTY_ISSPLITGROUP = "issplitgroup";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_VALRULE = "valRule";
    public static final String PROPERTY_INCLUDESEMPTYITEM = "includesemptyitem";
    public static final String PROPERTY_READONLYLOGIC = "readonlylogic";
    public static final String PROPERTY_MANDANTORYLOGIC = "mandantorylogic";
    public static final String PROPERTY_ISDISPLAYED = "isdisplayed";
    public static final String PROPERTY_DEFAULTVALUE = "defaultvalue";
    public static final String PROPERTY_ISSECONDHEADER = "issecondheader";
    public static final String PROPERTY_ONCHANGEEVENT = "onchangeevent";
    public static final String PROPERTY_ROWKEYSUFFIX = "rowkeysuffix";
    public static final String PROPERTY_ISROWKEY = "isrowkey";
    public static final String PROPERTY_ISSORTABLE = "issortable";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_EDITSETTING = "editsetting";
    public static final String PROPERTY_VISIBLESETTING = "visiblesetting";
    public static final String PROPERTY_ELEMENT = "element";

    public Adrefgridcolumninstance() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_REQUIRED, "NON");
        setDefaultValue(PROPERTY_READONLY, false);
        setDefaultValue(PROPERTY_ISINHEADER, "NON");
        setDefaultValue(PROPERTY_ISSPLITGROUP, "NON");
        setDefaultValue(PROPERTY_INCLUDESEMPTYITEM, "NON");
        setDefaultValue(PROPERTY_ISDISPLAYED, false);
        setDefaultValue(PROPERTY_ISSECONDHEADER, "NON");
        setDefaultValue(PROPERTY_ISROWKEY, false);
        setDefaultValue(PROPERTY_EDITSETTING, "NON");
        setDefaultValue(PROPERTY_VISIBLESETTING, "NON");
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public org.openbravo.model.ad.system.ad_ref_gridcolumn getRefGridcolumn() {
        return (org.openbravo.model.ad.system.ad_ref_gridcolumn) get(PROPERTY_REFGRIDCOLUMN);
    }

    public void setRefGridcolumn(
        org.openbravo.model.ad.system.ad_ref_gridcolumn refGridcolumn) {
        set(PROPERTY_REFGRIDCOLUMN, refGridcolumn);
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

    public String getHeadertext() {
        return (String) get(PROPERTY_HEADERTEXT);
    }

    public void setHeadertext(String headertext) {
        set(PROPERTY_HEADERTEXT, headertext);
    }

    public String getTemplate() {
        return (String) get(PROPERTY_TEMPLATE);
    }

    public void setTemplate(String template) {
        set(PROPERTY_TEMPLATE, template);
    }

    public String getReferenceurl() {
        return (String) get(PROPERTY_REFERENCEURL);
    }

    public void setReferenceurl(String referenceurl) {
        set(PROPERTY_REFERENCEURL, referenceurl);
    }

    public Reference getColreference() {
        return (Reference) get(PROPERTY_COLREFERENCE);
    }

    public void setColreference(Reference colreference) {
        set(PROPERTY_COLREFERENCE, colreference);
    }

    public Table getTable() {
        return (Table) get(PROPERTY_TABLE);
    }

    public void setTable(Table table) {
        set(PROPERTY_TABLE, table);
    }

    public Long getColspan() {
        return (Long) get(PROPERTY_COLSPAN);
    }

    public void setColspan(Long colspan) {
        set(PROPERTY_COLSPAN, colspan);
    }

    public Long getMaxlength() {
        return (Long) get(PROPERTY_MAXLENGTH);
    }

    public void setMaxlength(Long maxlength) {
        set(PROPERTY_MAXLENGTH, maxlength);
    }

    public String getRequired() {
        return (String) get(PROPERTY_REQUIRED);
    }

    public void setRequired(String required) {
        set(PROPERTY_REQUIRED, required);
    }

    public Boolean isReadonly() {
        return (Boolean) get(PROPERTY_READONLY);
    }

    public void setReadonly(Boolean readonly) {
        set(PROPERTY_READONLY, readonly);
    }

    public String getIsinheader() {
        return (String) get(PROPERTY_ISINHEADER);
    }

    public void setIsinheader(String isinheader) {
        set(PROPERTY_ISINHEADER, isinheader);
    }

    public String getIssplitgroup() {
        return (String) get(PROPERTY_ISSPLITGROUP);
    }

    public void setIssplitgroup(String issplitgroup) {
        set(PROPERTY_ISSPLITGROUP, issplitgroup);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public Validation getValRule() {
        return (Validation) get(PROPERTY_VALRULE);
    }

    public void setValRule(Validation valRule) {
        set(PROPERTY_VALRULE, valRule);
    }

    public String getIncludesemptyitem() {
        return (String) get(PROPERTY_INCLUDESEMPTYITEM);
    }

    public void setIncludesemptyitem(String includesemptyitem) {
        set(PROPERTY_INCLUDESEMPTYITEM, includesemptyitem);
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

    public Boolean isDisplayed() {
        return (Boolean) get(PROPERTY_ISDISPLAYED);
    }

    public void setDisplayed(Boolean isdisplayed) {
        set(PROPERTY_ISDISPLAYED, isdisplayed);
    }

    public String getDefaultvalue() {
        return (String) get(PROPERTY_DEFAULTVALUE);
    }

    public void setDefaultvalue(String defaultvalue) {
        set(PROPERTY_DEFAULTVALUE, defaultvalue);
    }

    public String getIssecondheader() {
        return (String) get(PROPERTY_ISSECONDHEADER);
    }

    public void setIssecondheader(String issecondheader) {
        set(PROPERTY_ISSECONDHEADER, issecondheader);
    }

    public String getOnchangeevent() {
        return (String) get(PROPERTY_ONCHANGEEVENT);
    }

    public void setOnchangeevent(String onchangeevent) {
        set(PROPERTY_ONCHANGEEVENT, onchangeevent);
    }

    public String getRowkeysuffix() {
        return (String) get(PROPERTY_ROWKEYSUFFIX);
    }

    public void setRowkeysuffix(String rowkeysuffix) {
        set(PROPERTY_ROWKEYSUFFIX, rowkeysuffix);
    }

    public Boolean isRowkey() {
        return (Boolean) get(PROPERTY_ISROWKEY);
    }

    public void setRowkey(Boolean isrowkey) {
        set(PROPERTY_ISROWKEY, isrowkey);
    }

    public String getIssortable() {
        return (String) get(PROPERTY_ISSORTABLE);
    }

    public void setIssortable(String issortable) {
        set(PROPERTY_ISSORTABLE, issortable);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
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

    public Element getElement() {
        return (Element) get(PROPERTY_ELEMENT);
    }

    public void setElement(Element element) {
        set(PROPERTY_ELEMENT, element);
    }
}
