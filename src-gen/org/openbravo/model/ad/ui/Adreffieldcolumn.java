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
import org.openbravo.model.ad.datamodel.Adreffieldcolumninstance;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.domain.Reference;
import org.openbravo.model.ad.domain.Validation;
import org.openbravo.model.ad.system.Adrefradiogroup;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ad_ref_fieldcolumn (stored in table ad_ref_fieldcolumn).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Adreffieldcolumn extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ad_ref_fieldcolumn";
    public static final String ENTITY_NAME = "ad_ref_fieldcolumn";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_REFERENCE = "reference";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_TEMPLATE = "template";
    public static final String PROPERTY_REFERENCEURL = "referenceurl";
    public static final String PROPERTY_FIELDREFERENCE = "fieldreference";
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_LEADINGEMPTYCOLS = "leadingemptycols";
    public static final String PROPERTY_COLSTOTAL = "colstotal";
    public static final String PROPERTY_MAXLENGTH = "maxlength";
    public static final String PROPERTY_REQUIRED = "required";
    public static final String PROPERTY_READONLY = "readonly";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_BUTTONCLASS = "buttonclass";
    public static final String PROPERTY_VALRULE = "valRule";
    public static final String PROPERTY_NAME2 = "name2";
    public static final String PROPERTY_ISLINEBREAK = "islinebreak";
    public static final String PROPERTY_INCLUDESEMPTYITEM = "includesemptyitem";
    public static final String PROPERTY_READONLYLOGIC = "readonlylogic";
    public static final String PROPERTY_DISPLAYLOGIC = "displaylogic";
    public static final String PROPERTY_MANDANTORYLOGIC = "mandantorylogic";
    public static final String PROPERTY_DEFAULTVALUE = "defaultvalue";
    public static final String PROPERTY_ISDISPLAYED = "isdisplayed";
    public static final String PROPERTY_STYLE = "style";
    public static final String PROPERTY_ISSESSIONATTR = "issessionattr";
    public static final String PROPERTY_ONCHANGEEVENT = "onchangeevent";
    public static final String PROPERTY_ELEMENT = "element";
    public static final String PROPERTY_ISFIRSTFOCUSEDFIELD =
        "isfirstfocusedfield";
    public static final String PROPERTY_REFRADIOGROUPLIST = "refRadiogroupList";
    public static final String PROPERTY_REFFIELDCOLUMNINSTANCELIST =
        "refFieldcolumninstanceList";

    public Adreffieldcolumn() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_LEADINGEMPTYCOLS, (long) 0);
        setDefaultValue(PROPERTY_REQUIRED, false);
        setDefaultValue(PROPERTY_READONLY, false);
        setDefaultValue(PROPERTY_ISLINEBREAK, false);
        setDefaultValue(PROPERTY_INCLUDESEMPTYITEM, false);
        setDefaultValue(PROPERTY_ISDISPLAYED, true);
        setDefaultValue(PROPERTY_ISSESSIONATTR, true);
        setDefaultValue(PROPERTY_ISFIRSTFOCUSEDFIELD, false);
        setDefaultValue(PROPERTY_REFRADIOGROUPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_REFFIELDCOLUMNINSTANCELIST,
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

    public Long getLeadingemptycols() {
        return (Long) get(PROPERTY_LEADINGEMPTYCOLS);
    }

    public void setLeadingemptycols(Long leadingemptycols) {
        set(PROPERTY_LEADINGEMPTYCOLS, leadingemptycols);
    }

    public Long getColstotal() {
        return (Long) get(PROPERTY_COLSTOTAL);
    }

    public void setColstotal(Long colstotal) {
        set(PROPERTY_COLSTOTAL, colstotal);
    }

    public Long getMaxlength() {
        return (Long) get(PROPERTY_MAXLENGTH);
    }

    public void setMaxlength(Long maxlength) {
        set(PROPERTY_MAXLENGTH, maxlength);
    }

    public Boolean isRequired() {
        return (Boolean) get(PROPERTY_REQUIRED);
    }

    public void setRequired(Boolean required) {
        set(PROPERTY_REQUIRED, required);
    }

    public Boolean isReadonly() {
        return (Boolean) get(PROPERTY_READONLY);
    }

    public void setReadonly(Boolean readonly) {
        set(PROPERTY_READONLY, readonly);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public String getButtonclass() {
        return (String) get(PROPERTY_BUTTONCLASS);
    }

    public void setButtonclass(String buttonclass) {
        set(PROPERTY_BUTTONCLASS, buttonclass);
    }

    public Validation getValRule() {
        return (Validation) get(PROPERTY_VALRULE);
    }

    public void setValRule(Validation valRule) {
        set(PROPERTY_VALRULE, valRule);
    }

    public String getName2() {
        return (String) get(PROPERTY_NAME2);
    }

    public void setName2(String name2) {
        set(PROPERTY_NAME2, name2);
    }

    public Boolean isLinebreak() {
        return (Boolean) get(PROPERTY_ISLINEBREAK);
    }

    public void setLinebreak(Boolean islinebreak) {
        set(PROPERTY_ISLINEBREAK, islinebreak);
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

    public Boolean isDisplayed() {
        return (Boolean) get(PROPERTY_ISDISPLAYED);
    }

    public void setDisplayed(Boolean isdisplayed) {
        set(PROPERTY_ISDISPLAYED, isdisplayed);
    }

    public String getStyle() {
        return (String) get(PROPERTY_STYLE);
    }

    public void setStyle(String style) {
        set(PROPERTY_STYLE, style);
    }

    public Boolean isSessionattr() {
        return (Boolean) get(PROPERTY_ISSESSIONATTR);
    }

    public void setSessionattr(Boolean issessionattr) {
        set(PROPERTY_ISSESSIONATTR, issessionattr);
    }

    public String getOnchangeevent() {
        return (String) get(PROPERTY_ONCHANGEEVENT);
    }

    public void setOnchangeevent(String onchangeevent) {
        set(PROPERTY_ONCHANGEEVENT, onchangeevent);
    }

    public Element getElement() {
        return (Element) get(PROPERTY_ELEMENT);
    }

    public void setElement(Element element) {
        set(PROPERTY_ELEMENT, element);
    }

    public Boolean isFirstfocusedfield() {
        return (Boolean) get(PROPERTY_ISFIRSTFOCUSEDFIELD);
    }

    public void setFirstfocusedfield(Boolean isfirstfocusedfield) {
        set(PROPERTY_ISFIRSTFOCUSEDFIELD, isfirstfocusedfield);
    }

    @SuppressWarnings("unchecked")
    public List<Adrefradiogroup> getRefRadiogroupList() {
        return (List<Adrefradiogroup>) get(PROPERTY_REFRADIOGROUPLIST);
    }

    public void setRefRadiogroupList(List<Adrefradiogroup> refRadiogroupList) {
        set(PROPERTY_REFRADIOGROUPLIST, refRadiogroupList);
    }

    @SuppressWarnings("unchecked")
    public List<Adreffieldcolumninstance> getRefFieldcolumninstanceList() {
        return (List<Adreffieldcolumninstance>) get(PROPERTY_REFFIELDCOLUMNINSTANCELIST);
    }

    public void setRefFieldcolumninstanceList(
        List<Adreffieldcolumninstance> refFieldcolumninstanceList) {
        set(PROPERTY_REFFIELDCOLUMNINSTANCELIST, refFieldcolumninstanceList);
    }
}
