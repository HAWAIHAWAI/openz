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
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.system.Language;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity ADElementTrl (stored in table AD_Element_Trl).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ElementTrl extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Element_Trl";
    public static final String ENTITY_NAME = "ADElementTrl";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ELEMENT = "element";
    public static final String PROPERTY_LANGUAGE = "language";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PRINTNAME = "printName";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_HELP = "help";
    public static final String PROPERTY_NAME14 = "name14";
    public static final String PROPERTY_PRINTNAME15 = "printName15";
    public static final String PROPERTY_DESCRIPTION16 = "description16";
    public static final String PROPERTY_HELP17 = "help17";
    public static final String PROPERTY_ISTRANSLATED = "isTranslated";

    public ElementTrl() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISTRANSLATED, false);
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

    public Element getElement() {
        return (Element) get(PROPERTY_ELEMENT);
    }

    public void setElement(Element element) {
        set(PROPERTY_ELEMENT, element);
    }

    public Language getLanguage() {
        return (Language) get(PROPERTY_LANGUAGE);
    }

    public void setLanguage(Language language) {
        set(PROPERTY_LANGUAGE, language);
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

    public String getName14() {
        return (String) get(PROPERTY_NAME14);
    }

    public void setName14(String name14) {
        set(PROPERTY_NAME14, name14);
    }

    public String getPrintName15() {
        return (String) get(PROPERTY_PRINTNAME15);
    }

    public void setPrintName15(String printName15) {
        set(PROPERTY_PRINTNAME15, printName15);
    }

    public String getDescription16() {
        return (String) get(PROPERTY_DESCRIPTION16);
    }

    public void setDescription16(String description16) {
        set(PROPERTY_DESCRIPTION16, description16);
    }

    public String getHelp17() {
        return (String) get(PROPERTY_HELP17);
    }

    public void setHelp17(String help17) {
        set(PROPERTY_HELP17, help17);
    }

    public Boolean isTranslated() {
        return (Boolean) get(PROPERTY_ISTRANSLATED);
    }

    public void setTranslated(Boolean isTranslated) {
        set(PROPERTY_ISTRANSLATED, isTranslated);
    }
}
