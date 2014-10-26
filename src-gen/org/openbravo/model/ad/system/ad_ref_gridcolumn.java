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
import org.openbravo.model.ad.datamodel.Adrefgridcolumninstance;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.domain.Reference;
import org.openbravo.model.ad.domain.Validation;
import org.openbravo.model.ad.ui.Element;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ad_ref_gridcolumn (stored in table ad_ref_gridcolumn).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ad_ref_gridcolumn extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ad_ref_gridcolumn";
    public static final String ENTITY_NAME = "ad_ref_gridcolumn";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_REFGROUP = "refGroup";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_REFERENCE = "reference";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_HEADERTEXT = "headertext";
    public static final String PROPERTY_TEMPLATE = "template";
    public static final String PROPERTY_REFERENCEURL = "referenceurl";
    public static final String PROPERTY_COLREFERENCE = "colreference";
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_COLSPAN = "colspan";
    public static final String PROPERTY_MAXLENGTH = "maxLength";
    public static final String PROPERTY_REQUIRED = "required";
    public static final String PROPERTY_READONLY = "readOnly";
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
    public static final String PROPERTY_ELEMENT = "element";
    public static final String PROPERTY_REFGRIDCOLUMNINSTANCELIST =
        "refGridcolumninstanceList";

    public ad_ref_gridcolumn() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_COLSPAN, (long) 0);
        setDefaultValue(PROPERTY_MAXLENGTH, (long) 0);
        setDefaultValue(PROPERTY_REQUIRED, false);
        setDefaultValue(PROPERTY_READONLY, false);
        setDefaultValue(PROPERTY_ISINHEADER, false);
        setDefaultValue(PROPERTY_ISSPLITGROUP, false);
        setDefaultValue(PROPERTY_INCLUDESEMPTYITEM, false);
        setDefaultValue(PROPERTY_ISDISPLAYED, true);
        setDefaultValue(PROPERTY_ISSECONDHEADER, false);
        setDefaultValue(PROPERTY_ISROWKEY, false);
        setDefaultValue(PROPERTY_ISSORTABLE, true);
        setDefaultValue(PROPERTY_REFGRIDCOLUMNINSTANCELIST,
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

    public Reference getReference() {
        return (Reference) get(PROPERTY_REFERENCE);
    }

    public void setReference(Reference reference) {
        set(PROPERTY_REFERENCE, reference);
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

    public Long getMaxLength() {
        return (Long) get(PROPERTY_MAXLENGTH);
    }

    public void setMaxLength(Long maxLength) {
        set(PROPERTY_MAXLENGTH, maxLength);
    }

    public Boolean isRequired() {
        return (Boolean) get(PROPERTY_REQUIRED);
    }

    public void setRequired(Boolean required) {
        set(PROPERTY_REQUIRED, required);
    }

    public Boolean isReadOnly() {
        return (Boolean) get(PROPERTY_READONLY);
    }

    public void setReadOnly(Boolean readOnly) {
        set(PROPERTY_READONLY, readOnly);
    }

    public Boolean isInheader() {
        return (Boolean) get(PROPERTY_ISINHEADER);
    }

    public void setInheader(Boolean isinheader) {
        set(PROPERTY_ISINHEADER, isinheader);
    }

    public Boolean isSplitgroup() {
        return (Boolean) get(PROPERTY_ISSPLITGROUP);
    }

    public void setSplitgroup(Boolean issplitgroup) {
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

    public Boolean isIncludesemptyitem() {
        return (Boolean) get(PROPERTY_INCLUDESEMPTYITEM);
    }

    public void setIncludesemptyitem(Boolean includesemptyitem) {
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

    public Boolean isSecondheader() {
        return (Boolean) get(PROPERTY_ISSECONDHEADER);
    }

    public void setSecondheader(Boolean issecondheader) {
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

    public Boolean isSortable() {
        return (Boolean) get(PROPERTY_ISSORTABLE);
    }

    public void setSortable(Boolean issortable) {
        set(PROPERTY_ISSORTABLE, issortable);
    }

    public Element getElement() {
        return (Element) get(PROPERTY_ELEMENT);
    }

    public void setElement(Element element) {
        set(PROPERTY_ELEMENT, element);
    }

    @SuppressWarnings("unchecked")
    public List<Adrefgridcolumninstance> getRefGridcolumninstanceList() {
        return (List<Adrefgridcolumninstance>) get(PROPERTY_REFGRIDCOLUMNINSTANCELIST);
    }

    public void setRefGridcolumninstanceList(
        List<Adrefgridcolumninstance> refGridcolumninstanceList) {
        set(PROPERTY_REFGRIDCOLUMNINSTANCELIST, refGridcolumninstanceList);
    }
}
