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
import org.openbravo.model.ad.datamodel.Adelementtrlinstance;
import org.openbravo.model.ad.datamodel.Column;
import org.openbravo.model.ad.module.Module;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ADElement (stored in table AD_Element).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Element extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Element";
    public static final String ENTITY_NAME = "ADElement";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_COLUMNNAME = "columnName";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PRINTNAME = "printName";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_HELP = "help";
    public static final String PROPERTY_NAME13 = "name13";
    public static final String PROPERTY_PRINTNAME14 = "printName14";
    public static final String PROPERTY_DESCRIPTION15 = "description15";
    public static final String PROPERTY_HELP16 = "help16";
    public static final String PROPERTY_MODULE = "module";
    public static final String PROPERTY_DONOTDELETE = "donotdelete";
    public static final String PROPERTY_ADCOLUMNLIST = "aDColumnList";
    public static final String PROPERTY_COLUMNVLIST = "columnVList";
    public static final String PROPERTY_ELEMENTTRLINSTANCELIST =
        "elementTrlInstanceList";
    public static final String PROPERTY_ADELEMENTTRLLIST = "aDElementTrlList";

    public Element() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_DONOTDELETE, true);
        setDefaultValue(PROPERTY_ADCOLUMNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_COLUMNVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ELEMENTTRLINSTANCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADELEMENTTRLLIST, new ArrayList<Object>());
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

    public String getColumnName() {
        return (String) get(PROPERTY_COLUMNNAME);
    }

    public void setColumnName(String columnName) {
        set(PROPERTY_COLUMNNAME, columnName);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getPrintName() {
        return (String) get(PROPERTY_PRINTNAME);
    }

    public void setPrintName(String printName) {
        set(PROPERTY_PRINTNAME, printName);
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

    public String getName13() {
        return (String) get(PROPERTY_NAME13);
    }

    public void setName13(String name13) {
        set(PROPERTY_NAME13, name13);
    }

    public String getPrintName14() {
        return (String) get(PROPERTY_PRINTNAME14);
    }

    public void setPrintName14(String printName14) {
        set(PROPERTY_PRINTNAME14, printName14);
    }

    public String getDescription15() {
        return (String) get(PROPERTY_DESCRIPTION15);
    }

    public void setDescription15(String description15) {
        set(PROPERTY_DESCRIPTION15, description15);
    }

    public String getHelp16() {
        return (String) get(PROPERTY_HELP16);
    }

    public void setHelp16(String help16) {
        set(PROPERTY_HELP16, help16);
    }

    public Module getModule() {
        return (Module) get(PROPERTY_MODULE);
    }

    public void setModule(Module module) {
        set(PROPERTY_MODULE, module);
    }

    public Boolean isDonotdelete() {
        return (Boolean) get(PROPERTY_DONOTDELETE);
    }

    public void setDonotdelete(Boolean donotdelete) {
        set(PROPERTY_DONOTDELETE, donotdelete);
    }

    @SuppressWarnings("unchecked")
    public List<Column> getADColumnList() {
        return (List<Column>) get(PROPERTY_ADCOLUMNLIST);
    }

    public void setADColumnList(List<Column> aDColumnList) {
        set(PROPERTY_ADCOLUMNLIST, aDColumnList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.ad.datamodel.ad_column_v> getColumnVList() {
        return (List<org.openbravo.model.ad.datamodel.ad_column_v>) get(PROPERTY_COLUMNVLIST);
    }

    public void setColumnVList(
        List<org.openbravo.model.ad.datamodel.ad_column_v> columnVList) {
        set(PROPERTY_COLUMNVLIST, columnVList);
    }

    @SuppressWarnings("unchecked")
    public List<Adelementtrlinstance> getElementTrlInstanceList() {
        return (List<Adelementtrlinstance>) get(PROPERTY_ELEMENTTRLINSTANCELIST);
    }

    public void setElementTrlInstanceList(
        List<Adelementtrlinstance> elementTrlInstanceList) {
        set(PROPERTY_ELEMENTTRLINSTANCELIST, elementTrlInstanceList);
    }

    @SuppressWarnings("unchecked")
    public List<ElementTrl> getADElementTrlList() {
        return (List<ElementTrl>) get(PROPERTY_ADELEMENTTRLLIST);
    }

    public void setADElementTrlList(List<ElementTrl> aDElementTrlList) {
        set(PROPERTY_ADELEMENTTRLLIST, aDElementTrlList);
    }
}
