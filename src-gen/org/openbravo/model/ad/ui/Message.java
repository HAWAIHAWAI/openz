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
import org.openbravo.model.ad.datamodel.Admessagetrlinstance;
import org.openbravo.model.ad.module.Module;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ADMessage (stored in table AD_Message).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Message extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Message";
    public static final String ENTITY_NAME = "ADMessage";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_MSGTEXT = "msgText";
    public static final String PROPERTY_MSGTIP = "msgTip";
    public static final String PROPERTY_MSGTYPE = "msgType";
    public static final String PROPERTY_MODULE = "module";
    public static final String PROPERTY_MESSAGETRLINSTANCELIST =
        "messageTrlInstanceList";
    public static final String PROPERTY_ADMESSAGETRLLIST = "aDMessageTrlList";

    public Message() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_MSGTYPE, "I");
        setDefaultValue(PROPERTY_MESSAGETRLINSTANCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADMESSAGETRLLIST, new ArrayList<Object>());
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

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
    }

    public String getMsgText() {
        return (String) get(PROPERTY_MSGTEXT);
    }

    public void setMsgText(String msgText) {
        set(PROPERTY_MSGTEXT, msgText);
    }

    public String getMsgTip() {
        return (String) get(PROPERTY_MSGTIP);
    }

    public void setMsgTip(String msgTip) {
        set(PROPERTY_MSGTIP, msgTip);
    }

    public String getMsgType() {
        return (String) get(PROPERTY_MSGTYPE);
    }

    public void setMsgType(String msgType) {
        set(PROPERTY_MSGTYPE, msgType);
    }

    public Module getModule() {
        return (Module) get(PROPERTY_MODULE);
    }

    public void setModule(Module module) {
        set(PROPERTY_MODULE, module);
    }

    @SuppressWarnings("unchecked")
    public List<Admessagetrlinstance> getMessageTrlInstanceList() {
        return (List<Admessagetrlinstance>) get(PROPERTY_MESSAGETRLINSTANCELIST);
    }

    public void setMessageTrlInstanceList(
        List<Admessagetrlinstance> messageTrlInstanceList) {
        set(PROPERTY_MESSAGETRLINSTANCELIST, messageTrlInstanceList);
    }

    @SuppressWarnings("unchecked")
    public List<MessageTrl> getADMessageTrlList() {
        return (List<MessageTrl>) get(PROPERTY_ADMESSAGETRLLIST);
    }

    public void setADMessageTrlList(List<MessageTrl> aDMessageTrlList) {
        set(PROPERTY_ADMESSAGETRLLIST, aDMessageTrlList);
    }
}
