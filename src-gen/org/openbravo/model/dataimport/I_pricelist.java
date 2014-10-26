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
package org.openbravo.model.dataimport;

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
 * Entity class for entity i_pricelist (stored in table I_pricelist).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class I_pricelist extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "I_pricelist";
    public static final String ENTITY_NAME = "i_pricelist";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PLISTNAME = "plistname";
    public static final String PROPERTY_PLISTVERSIONNAME = "plistversionname";
    public static final String PROPERTY_PRODUCTVALUE = "productvalue";
    public static final String PROPERTY_PRICELIST = "pricelist";
    public static final String PROPERTY_PRICESTD = "pricestd";
    public static final String PROPERTY_PRICELIMIT = "pricelimit";
    public static final String PROPERTY_ISIMPORTED = "isimported";
    public static final String PROPERTY_BTNPROCESS = "btnprocess";

    public I_pricelist() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISIMPORTED, false);
        setDefaultValue(PROPERTY_BTNPROCESS, false);
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

    public String getPlistname() {
        return (String) get(PROPERTY_PLISTNAME);
    }

    public void setPlistname(String plistname) {
        set(PROPERTY_PLISTNAME, plistname);
    }

    public String getPlistversionname() {
        return (String) get(PROPERTY_PLISTVERSIONNAME);
    }

    public void setPlistversionname(String plistversionname) {
        set(PROPERTY_PLISTVERSIONNAME, plistversionname);
    }

    public String getProductvalue() {
        return (String) get(PROPERTY_PRODUCTVALUE);
    }

    public void setProductvalue(String productvalue) {
        set(PROPERTY_PRODUCTVALUE, productvalue);
    }

    public Long getPricelist() {
        return (Long) get(PROPERTY_PRICELIST);
    }

    public void setPricelist(Long pricelist) {
        set(PROPERTY_PRICELIST, pricelist);
    }

    public Long getPricestd() {
        return (Long) get(PROPERTY_PRICESTD);
    }

    public void setPricestd(Long pricestd) {
        set(PROPERTY_PRICESTD, pricestd);
    }

    public Long getPricelimit() {
        return (Long) get(PROPERTY_PRICELIMIT);
    }

    public void setPricelimit(Long pricelimit) {
        set(PROPERTY_PRICELIMIT, pricelimit);
    }

    public Boolean isImported() {
        return (Boolean) get(PROPERTY_ISIMPORTED);
    }

    public void setImported(Boolean isimported) {
        set(PROPERTY_ISIMPORTED, isimported);
    }

    public Boolean isBtnprocess() {
        return (Boolean) get(PROPERTY_BTNPROCESS);
    }

    public void setBtnprocess(Boolean btnprocess) {
        set(PROPERTY_BTNPROCESS, btnprocess);
    }
}
