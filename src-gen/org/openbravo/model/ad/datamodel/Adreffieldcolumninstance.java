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
import org.openbravo.model.ad.ui.Adreffieldcolumn;
import org.openbravo.model.ad.ui.Element;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity ad_ref_fieldcolumninstance (stored in table ad_ref_fieldcolumninstance).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Adreffieldcolumninstance extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ad_ref_fieldcolumninstance";
    public static final String ENTITY_NAME = "ad_ref_fieldcolumninstance";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_REFFIELDCOLUMN = "refFieldcolumn";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_EDITSETTING = "editsetting";
    public static final String PROPERTY_VISIBLESETTING = "visiblesetting";
    public static final String PROPERTY_READONLYLOGIC = "readonlylogic";
    public static final String PROPERTY_DISPLAYLOGIC = "displaylogic";
    public static final String PROPERTY_MANDANTORYLOGIC = "mandantorylogic";
    public static final String PROPERTY_DEFAULTVALUE = "defaultvalue";
    public static final String PROPERTY_ISDISPLAYED = "isdisplayed";
    public static final String PROPERTY_ISFIRSTFOCUSEDFIELD =
        "isfirstfocusedfield";
    public static final String PROPERTY_TEMPLATE = "template";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_MAXLENGTH = "maxlength";
    public static final String PROPERTY_REFERENCEURL = "referenceurl";
    public static final String PROPERTY_BUTTONCLASS = "buttonclass";
    public static final String PROPERTY_STYLE = "style";
    public static final String PROPERTY_ONCHANGEEVENT = "onchangeevent";
    public static final String PROPERTY_COLSTOTAL = "colstotal";
    public static final String PROPERTY_LEADINGEMPTYCOLS = "leadingemptycols";
    public static final String PROPERTY_ISLINEBREAK = "islinebreak";
    public static final String PROPERTY_FIELDREFERENCE = "fieldreference";
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_VALRULE = "valRule";
    public static final String PROPERTY_ELEMENT = "element";
    public static final String PROPERTY_INCLUDESEMPTYITEM = "includesemptyitem";

    public Adreffieldcolumninstance() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_EDITSETTING, "NON");
        setDefaultValue(PROPERTY_VISIBLESETTING, "NON");
        setDefaultValue(PROPERTY_ISDISPLAYED, true);
        setDefaultValue(PROPERTY_ISFIRSTFOCUSEDFIELD, "NON");
        setDefaultValue(PROPERTY_ISLINEBREAK, "NON");
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

    public Adreffieldcolumn getRefFieldcolumn() {
        return (Adreffieldcolumn) get(PROPERTY_REFFIELDCOLUMN);
    }

    public void setRefFieldcolumn(Adreffieldcolumn refFieldcolumn) {
        set(PROPERTY_REFFIELDCOLUMN, refFieldcolumn);
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

    public Boolean isDisplayed() {
        return (Boolean) get(PROPERTY_ISDISPLAYED);
    }

    public void setDisplayed(Boolean isdisplayed) {
        set(PROPERTY_ISDISPLAYED, isdisplayed);
    }

    public String getIsfirstfocusedfield() {
        return (String) get(PROPERTY_ISFIRSTFOCUSEDFIELD);
    }

    public void setIsfirstfocusedfield(String isfirstfocusedfield) {
        set(PROPERTY_ISFIRSTFOCUSEDFIELD, isfirstfocusedfield);
    }

    public String getTemplate() {
        return (String) get(PROPERTY_TEMPLATE);
    }

    public void setTemplate(String template) {
        set(PROPERTY_TEMPLATE, template);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public Long getMaxlength() {
        return (Long) get(PROPERTY_MAXLENGTH);
    }

    public void setMaxlength(Long maxlength) {
        set(PROPERTY_MAXLENGTH, maxlength);
    }

    public String getReferenceurl() {
        return (String) get(PROPERTY_REFERENCEURL);
    }

    public void setReferenceurl(String referenceurl) {
        set(PROPERTY_REFERENCEURL, referenceurl);
    }

    public String getButtonclass() {
        return (String) get(PROPERTY_BUTTONCLASS);
    }

    public void setButtonclass(String buttonclass) {
        set(PROPERTY_BUTTONCLASS, buttonclass);
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

    public Long getColstotal() {
        return (Long) get(PROPERTY_COLSTOTAL);
    }

    public void setColstotal(Long colstotal) {
        set(PROPERTY_COLSTOTAL, colstotal);
    }

    public Long getLeadingemptycols() {
        return (Long) get(PROPERTY_LEADINGEMPTYCOLS);
    }

    public void setLeadingemptycols(Long leadingemptycols) {
        set(PROPERTY_LEADINGEMPTYCOLS, leadingemptycols);
    }

    public String getIslinebreak() {
        return (String) get(PROPERTY_ISLINEBREAK);
    }

    public void setIslinebreak(String islinebreak) {
        set(PROPERTY_ISLINEBREAK, islinebreak);
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

    public Element getElement() {
        return (Element) get(PROPERTY_ELEMENT);
    }

    public void setElement(Element element) {
        set(PROPERTY_ELEMENT, element);
    }

    public String getIncludesemptyitem() {
        return (String) get(PROPERTY_INCLUDESEMPTYITEM);
    }

    public void setIncludesemptyitem(String includesemptyitem) {
        set(PROPERTY_INCLUDESEMPTYITEM, includesemptyitem);
    }
}
