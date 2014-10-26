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
import org.openbravo.model.ad.domain.Reference;
import org.openbravo.model.ad.domain.Validation;
import org.openbravo.model.ad.ui.ProcessParameter;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity ad_process_para_instance (stored in table ad_process_para_instance).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ad_process_para_instance extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ad_process_para_instance";
    public static final String ENTITY_NAME = "ad_process_para_instance";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_PROCESSPARA = "processPara";
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
    public static final String PROPERTY_INCLUDESEMPTYITEM = "includesemptyitem";
    public static final String PROPERTY_SEQNO = "seqno";
    public static final String PROPERTY_ISFIRSTFOCUSEDFIELD =
        "isfirstfocusedfield";
    public static final String PROPERTY_COLSTOTAL = "colstotal";
    public static final String PROPERTY_FIELDLENGTH = "fieldlength";
    public static final String PROPERTY_TEMPLATE = "template";
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_REFERENCEVALUE = "referenceValue";
    public static final String PROPERTY_VALRULE = "valRule";

    public ad_process_para_instance() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_EDITSETTING, "NON");
        setDefaultValue(PROPERTY_VISIBLESETTING, "NON");
        setDefaultValue(PROPERTY_INCLUDESEMPTYITEM, "NON");
        setDefaultValue(PROPERTY_ISFIRSTFOCUSEDFIELD, "NON");
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

    public ProcessParameter getProcessPara() {
        return (ProcessParameter) get(PROPERTY_PROCESSPARA);
    }

    public void setProcessPara(ProcessParameter processPara) {
        set(PROPERTY_PROCESSPARA, processPara);
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

    public String getIncludesemptyitem() {
        return (String) get(PROPERTY_INCLUDESEMPTYITEM);
    }

    public void setIncludesemptyitem(String includesemptyitem) {
        set(PROPERTY_INCLUDESEMPTYITEM, includesemptyitem);
    }

    public Long getSeqno() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqno(Long seqno) {
        set(PROPERTY_SEQNO, seqno);
    }

    public String getIsfirstfocusedfield() {
        return (String) get(PROPERTY_ISFIRSTFOCUSEDFIELD);
    }

    public void setIsfirstfocusedfield(String isfirstfocusedfield) {
        set(PROPERTY_ISFIRSTFOCUSEDFIELD, isfirstfocusedfield);
    }

    public String getColstotal() {
        return (String) get(PROPERTY_COLSTOTAL);
    }

    public void setColstotal(String colstotal) {
        set(PROPERTY_COLSTOTAL, colstotal);
    }

    public Long getFieldlength() {
        return (Long) get(PROPERTY_FIELDLENGTH);
    }

    public void setFieldlength(Long fieldlength) {
        set(PROPERTY_FIELDLENGTH, fieldlength);
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
}
