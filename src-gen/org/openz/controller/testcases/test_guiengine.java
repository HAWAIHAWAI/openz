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
package org.openz.controller.testcases;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity Test_Guiengine (stored in table test_guiengine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class test_guiengine extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "test_guiengine";
    public static final String ENTITY_NAME = "Test_Guiengine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_TEXTBOX = "textbox";
    public static final String PROPERTY_DATEBOX = "datebox";
    public static final String PROPERTY_CHECKBOX = "checkbox";
    public static final String PROPERTY_DECBOX = "decbox";
    public static final String PROPERTY_EURO = "euro";
    public static final String PROPERTY_INTBOX = "intbox";
    public static final String PROPERTY_LISTSORTER = "listsorter";
    public static final String PROPERTY_MULTISELECTOR = "multiselector";
    public static final String PROPERTY_POPUPSEARCH = "popupsearch";
    public static final String PROPERTY_PRICE = "price";
    public static final String PROPERTY_REFCOMBO = "refcombo";
    public static final String PROPERTY_NOEDITTEXTBOX = "noedittextbox";
    public static final String PROPERTY_IMAGE = "image";
    public static final String PROPERTY_URL = "url";
    public static final String PROPERTY_TEXTAREASIMPLE = "textareasimple";
    public static final String PROPERTY_TEXTAREAADV = "textareaadv";
    public static final String PROPERTY_LISTSORTERSIM = "listsortersim";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CREATEDBY = "createdBy";

    public test_guiengine() {
        setDefaultValue(PROPERTY_CHECKBOX, false);
        setDefaultValue(PROPERTY_ISACTIVE, true);
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

    public String getTextbox() {
        return (String) get(PROPERTY_TEXTBOX);
    }

    public void setTextbox(String textbox) {
        set(PROPERTY_TEXTBOX, textbox);
    }

    public Date getDatebox() {
        return (Date) get(PROPERTY_DATEBOX);
    }

    public void setDatebox(Date datebox) {
        set(PROPERTY_DATEBOX, datebox);
    }

    public Boolean isCheckbox() {
        return (Boolean) get(PROPERTY_CHECKBOX);
    }

    public void setCheckbox(Boolean checkbox) {
        set(PROPERTY_CHECKBOX, checkbox);
    }

    public Long getDecbox() {
        return (Long) get(PROPERTY_DECBOX);
    }

    public void setDecbox(Long decbox) {
        set(PROPERTY_DECBOX, decbox);
    }

    public Long getEuro() {
        return (Long) get(PROPERTY_EURO);
    }

    public void setEuro(Long euro) {
        set(PROPERTY_EURO, euro);
    }

    public Long getIntbox() {
        return (Long) get(PROPERTY_INTBOX);
    }

    public void setIntbox(Long intbox) {
        set(PROPERTY_INTBOX, intbox);
    }

    public String getListsorter() {
        return (String) get(PROPERTY_LISTSORTER);
    }

    public void setListsorter(String listsorter) {
        set(PROPERTY_LISTSORTER, listsorter);
    }

    public String getMultiselector() {
        return (String) get(PROPERTY_MULTISELECTOR);
    }

    public void setMultiselector(String multiselector) {
        set(PROPERTY_MULTISELECTOR, multiselector);
    }

    public String getPopupsearch() {
        return (String) get(PROPERTY_POPUPSEARCH);
    }

    public void setPopupsearch(String popupsearch) {
        set(PROPERTY_POPUPSEARCH, popupsearch);
    }

    public Long getPrice() {
        return (Long) get(PROPERTY_PRICE);
    }

    public void setPrice(Long price) {
        set(PROPERTY_PRICE, price);
    }

    public String getRefcombo() {
        return (String) get(PROPERTY_REFCOMBO);
    }

    public void setRefcombo(String refcombo) {
        set(PROPERTY_REFCOMBO, refcombo);
    }

    public String getNoedittextbox() {
        return (String) get(PROPERTY_NOEDITTEXTBOX);
    }

    public void setNoedittextbox(String noedittextbox) {
        set(PROPERTY_NOEDITTEXTBOX, noedittextbox);
    }

    public String getImage() {
        return (String) get(PROPERTY_IMAGE);
    }

    public void setImage(String image) {
        set(PROPERTY_IMAGE, image);
    }

    public String getUrl() {
        return (String) get(PROPERTY_URL);
    }

    public void setUrl(String url) {
        set(PROPERTY_URL, url);
    }

    public String getTextareasimple() {
        return (String) get(PROPERTY_TEXTAREASIMPLE);
    }

    public void setTextareasimple(String textareasimple) {
        set(PROPERTY_TEXTAREASIMPLE, textareasimple);
    }

    public String getTextareaadv() {
        return (String) get(PROPERTY_TEXTAREAADV);
    }

    public void setTextareaadv(String textareaadv) {
        set(PROPERTY_TEXTAREAADV, textareaadv);
    }

    public String getListsortersim() {
        return (String) get(PROPERTY_LISTSORTERSIM);
    }

    public void setListsortersim(String listsortersim) {
        set(PROPERTY_LISTSORTERSIM, listsortersim);
    }

    public Organization getOrg() {
        return (Organization) get(PROPERTY_ORG);
    }

    public void setOrg(Organization org) {
        set(PROPERTY_ORG, org);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ISACTIVE);
    }

    public void setActive(Boolean isactive) {
        set(PROPERTY_ISACTIVE, isactive);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public Date getCreated() {
        return (Date) get(PROPERTY_CREATED);
    }

    public void setCreated(Date created) {
        set(PROPERTY_CREATED, created);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }
}
