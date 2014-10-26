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
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.ui.Element;
import org.openbravo.model.ad.ui.Process;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ad_column_v (stored in table ad_column_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ad_column_v extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ad_column_v";
    public static final String ENTITY_NAME = "ad_column_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_HELP = "help";
    public static final String PROPERTY_COLUMNNAME = "columnname";
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_REFERENCE = "reference";
    public static final String PROPERTY_REFERENCEVALUE = "referenceValue";
    public static final String PROPERTY_VALRULE = "valRule";
    public static final String PROPERTY_FIELDLENGTH = "fieldlength";
    public static final String PROPERTY_DEFAULTVALUE = "defaultvalue";
    public static final String PROPERTY_ISKEY = "iskey";
    public static final String PROPERTY_ISPARENT = "isparent";
    public static final String PROPERTY_READONLYLOGIC = "readonlylogic";
    public static final String PROPERTY_ISIDENTIFIER = "isidentifier";
    public static final String PROPERTY_ISENCRYPTED = "isencrypted";
    public static final String PROPERTY_ISTRANSLATED = "istranslated";
    public static final String PROPERTY_ELEMENT = "element";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_ISSESSIONATTR = "issessionattr";
    public static final String PROPERTY_CALLOUT = "callout";
    public static final String PROPERTY_DEVELOPMENTSTATUS = "developmentstatus";
    public static final String PROPERTY_MODULE = "module";
    public static final String PROPERTY_SEQNO = "seqno";
    public static final String PROPERTY_LABELLINKDISPATCHERLIST =
        "labellinkdispatcherList";

    public ad_column_v() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISKEY, false);
        setDefaultValue(PROPERTY_ISPARENT, false);
        setDefaultValue(PROPERTY_ISIDENTIFIER, false);
        setDefaultValue(PROPERTY_ISENCRYPTED, false);
        setDefaultValue(PROPERTY_ISTRANSLATED, false);
        setDefaultValue(PROPERTY_ISSESSIONATTR, false);
        setDefaultValue(PROPERTY_DEVELOPMENTSTATUS, "RE");
        setDefaultValue(PROPERTY_LABELLINKDISPATCHERLIST,
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

    public String getColumnname() {
        return (String) get(PROPERTY_COLUMNNAME);
    }

    public void setColumnname(String columnname) {
        set(PROPERTY_COLUMNNAME, columnname);
    }

    public Table getTable() {
        return (Table) get(PROPERTY_TABLE);
    }

    public void setTable(Table table) {
        set(PROPERTY_TABLE, table);
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

    public Long getFieldlength() {
        return (Long) get(PROPERTY_FIELDLENGTH);
    }

    public void setFieldlength(Long fieldlength) {
        set(PROPERTY_FIELDLENGTH, fieldlength);
    }

    public String getDefaultvalue() {
        return (String) get(PROPERTY_DEFAULTVALUE);
    }

    public void setDefaultvalue(String defaultvalue) {
        set(PROPERTY_DEFAULTVALUE, defaultvalue);
    }

    public Boolean isKey() {
        return (Boolean) get(PROPERTY_ISKEY);
    }

    public void setKey(Boolean iskey) {
        set(PROPERTY_ISKEY, iskey);
    }

    public Boolean isParent() {
        return (Boolean) get(PROPERTY_ISPARENT);
    }

    public void setParent(Boolean isparent) {
        set(PROPERTY_ISPARENT, isparent);
    }

    public String getReadonlylogic() {
        return (String) get(PROPERTY_READONLYLOGIC);
    }

    public void setReadonlylogic(String readonlylogic) {
        set(PROPERTY_READONLYLOGIC, readonlylogic);
    }

    public Boolean isIdentifier() {
        return (Boolean) get(PROPERTY_ISIDENTIFIER);
    }

    public void setIdentifier(Boolean isidentifier) {
        set(PROPERTY_ISIDENTIFIER, isidentifier);
    }

    public Boolean isEncrypted() {
        return (Boolean) get(PROPERTY_ISENCRYPTED);
    }

    public void setEncrypted(Boolean isencrypted) {
        set(PROPERTY_ISENCRYPTED, isencrypted);
    }

    public Boolean isTranslated() {
        return (Boolean) get(PROPERTY_ISTRANSLATED);
    }

    public void setTranslated(Boolean istranslated) {
        set(PROPERTY_ISTRANSLATED, istranslated);
    }

    public Element getElement() {
        return (Element) get(PROPERTY_ELEMENT);
    }

    public void setElement(Element element) {
        set(PROPERTY_ELEMENT, element);
    }

    public Process getProcess() {
        return (Process) get(PROPERTY_PROCESS);
    }

    public void setProcess(Process process) {
        set(PROPERTY_PROCESS, process);
    }

    public Boolean isSessionattr() {
        return (Boolean) get(PROPERTY_ISSESSIONATTR);
    }

    public void setSessionattr(Boolean issessionattr) {
        set(PROPERTY_ISSESSIONATTR, issessionattr);
    }

    public Callout getCallout() {
        return (Callout) get(PROPERTY_CALLOUT);
    }

    public void setCallout(Callout callout) {
        set(PROPERTY_CALLOUT, callout);
    }

    public String getDevelopmentstatus() {
        return (String) get(PROPERTY_DEVELOPMENTSTATUS);
    }

    public void setDevelopmentstatus(String developmentstatus) {
        set(PROPERTY_DEVELOPMENTSTATUS, developmentstatus);
    }

    public Module getModule() {
        return (Module) get(PROPERTY_MODULE);
    }

    public void setModule(Module module) {
        set(PROPERTY_MODULE, module);
    }

    public Long getSeqno() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqno(Long seqno) {
        set(PROPERTY_SEQNO, seqno);
    }

    @SuppressWarnings("unchecked")
    public List<Adlabellinkdispatcher> getLabellinkdispatcherList() {
        return (List<Adlabellinkdispatcher>) get(PROPERTY_LABELLINKDISPATCHERLIST);
    }

    public void setLabellinkdispatcherList(
        List<Adlabellinkdispatcher> labellinkdispatcherList) {
        set(PROPERTY_LABELLINKDISPATCHERLIST, labellinkdispatcherList);
    }
}
