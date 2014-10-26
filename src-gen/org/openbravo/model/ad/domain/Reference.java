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
package org.openbravo.model.ad.domain;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.module.Module;
import org.openbravo.model.ad.system.Ad_ref_listinstance;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.ui.Adreffieldcolumn;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ADReference (stored in table AD_Reference).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Reference extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Reference";
    public static final String ENTITY_NAME = "ADReference";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_HELP = "help";
    public static final String PROPERTY_VALIDATIONTYPE = "validationType";
    public static final String PROPERTY_VFORMAT = "vFormat";
    public static final String PROPERTY_MODULE = "module";
    public static final String PROPERTY_ISUSERDEFINABLELIST =
        "isuserdefinablelist";
    public static final String PROPERTY_POPUPBIGICON = "popupbigicon";
    public static final String PROPERTY_POPUPSMALLICON = "popupsmallicon";
    public static final String PROPERTY_COLUMNS = "columns";
    public static final String PROPERTY_DETAILSIDFIELD = "detailsidfield";
    public static final String PROPERTY_SHOWINFOMENU = "showinfomenu";
    public static final String PROPERTY_REFERENCEINSTANCELIST =
        "referenceinstanceList";
    public static final String PROPERTY_ADREFERENCEDTABLELIST =
        "aDReferencedTableList";
    public static final String PROPERTY_REFLISTINSTANCELIST =
        "refListinstanceList";
    public static final String PROPERTY_ADMODELIMPLEMENTATIONLIST =
        "aDModelImplementationList";
    public static final String PROPERTY_REFFIELDCOLUMNLIST =
        "refFieldcolumnList";
    public static final String PROPERTY_ADLISTLIST = "aDListList";
    public static final String PROPERTY_ADREFERENCETRLLIST =
        "aDReferenceTrlList";
    public static final String PROPERTY_REFGROUPLIST = "refGroupList";
    public static final String PROPERTY_REFGRIDCOLUMNLIST = "refGridcolumnList";
    public static final String PROPERTY_ADSELECTORLIST = "aDSelectorList";

    public Reference() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISUSERDEFINABLELIST, false);
        setDefaultValue(PROPERTY_SHOWINFOMENU, false);
        setDefaultValue(PROPERTY_REFERENCEINSTANCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADREFERENCEDTABLELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_REFLISTINSTANCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADMODELIMPLEMENTATIONLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_REFFIELDCOLUMNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADLISTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADREFERENCETRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_REFGROUPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_REFGRIDCOLUMNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADSELECTORLIST, new ArrayList<Object>());
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
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

    public String getValidationType() {
        return (String) get(PROPERTY_VALIDATIONTYPE);
    }

    public void setValidationType(String validationType) {
        set(PROPERTY_VALIDATIONTYPE, validationType);
    }

    public String getVFormat() {
        return (String) get(PROPERTY_VFORMAT);
    }

    public void setVFormat(String vFormat) {
        set(PROPERTY_VFORMAT, vFormat);
    }

    public Module getModule() {
        return (Module) get(PROPERTY_MODULE);
    }

    public void setModule(Module module) {
        set(PROPERTY_MODULE, module);
    }

    public Boolean isUserdefinablelist() {
        return (Boolean) get(PROPERTY_ISUSERDEFINABLELIST);
    }

    public void setUserdefinablelist(Boolean isuserdefinablelist) {
        set(PROPERTY_ISUSERDEFINABLELIST, isuserdefinablelist);
    }

    public String getPopupbigicon() {
        return (String) get(PROPERTY_POPUPBIGICON);
    }

    public void setPopupbigicon(String popupbigicon) {
        set(PROPERTY_POPUPBIGICON, popupbigicon);
    }

    public String getPopupsmallicon() {
        return (String) get(PROPERTY_POPUPSMALLICON);
    }

    public void setPopupsmallicon(String popupsmallicon) {
        set(PROPERTY_POPUPSMALLICON, popupsmallicon);
    }

    public Long getColumns() {
        return (Long) get(PROPERTY_COLUMNS);
    }

    public void setColumns(Long columns) {
        set(PROPERTY_COLUMNS, columns);
    }

    public String getDetailsidfield() {
        return (String) get(PROPERTY_DETAILSIDFIELD);
    }

    public void setDetailsidfield(String detailsidfield) {
        set(PROPERTY_DETAILSIDFIELD, detailsidfield);
    }

    public Boolean isShowinfomenu() {
        return (Boolean) get(PROPERTY_SHOWINFOMENU);
    }

    public void setShowinfomenu(Boolean showinfomenu) {
        set(PROPERTY_SHOWINFOMENU, showinfomenu);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.ad.system.ad_referenceinstance> getReferenceinstanceList() {
        return (List<org.openbravo.model.ad.system.ad_referenceinstance>) get(PROPERTY_REFERENCEINSTANCELIST);
    }

    public void setReferenceinstanceList(
        List<org.openbravo.model.ad.system.ad_referenceinstance> referenceinstanceList) {
        set(PROPERTY_REFERENCEINSTANCELIST, referenceinstanceList);
    }

    @SuppressWarnings("unchecked")
    public List<ReferencedTable> getADReferencedTableList() {
        return (List<ReferencedTable>) get(PROPERTY_ADREFERENCEDTABLELIST);
    }

    public void setADReferencedTableList(
        List<ReferencedTable> aDReferencedTableList) {
        set(PROPERTY_ADREFERENCEDTABLELIST, aDReferencedTableList);
    }

    @SuppressWarnings("unchecked")
    public List<Ad_ref_listinstance> getRefListinstanceList() {
        return (List<Ad_ref_listinstance>) get(PROPERTY_REFLISTINSTANCELIST);
    }

    public void setRefListinstanceList(
        List<Ad_ref_listinstance> refListinstanceList) {
        set(PROPERTY_REFLISTINSTANCELIST, refListinstanceList);
    }

    @SuppressWarnings("unchecked")
    public List<ModelImplementation> getADModelImplementationList() {
        return (List<ModelImplementation>) get(PROPERTY_ADMODELIMPLEMENTATIONLIST);
    }

    public void setADModelImplementationList(
        List<ModelImplementation> aDModelImplementationList) {
        set(PROPERTY_ADMODELIMPLEMENTATIONLIST, aDModelImplementationList);
    }

    @SuppressWarnings("unchecked")
    public List<Adreffieldcolumn> getRefFieldcolumnList() {
        return (List<Adreffieldcolumn>) get(PROPERTY_REFFIELDCOLUMNLIST);
    }

    public void setRefFieldcolumnList(List<Adreffieldcolumn> refFieldcolumnList) {
        set(PROPERTY_REFFIELDCOLUMNLIST, refFieldcolumnList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.ad.domain.List> getADListList() {
        return (List<org.openbravo.model.ad.domain.List>) get(PROPERTY_ADLISTLIST);
    }

    public void setADListList(
        List<org.openbravo.model.ad.domain.List> aDListList) {
        set(PROPERTY_ADLISTLIST, aDListList);
    }

    @SuppressWarnings("unchecked")
    public List<ReferenceTrl> getADReferenceTrlList() {
        return (List<ReferenceTrl>) get(PROPERTY_ADREFERENCETRLLIST);
    }

    public void setADReferenceTrlList(List<ReferenceTrl> aDReferenceTrlList) {
        set(PROPERTY_ADREFERENCETRLLIST, aDReferenceTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.ad.system.ad_ref_group> getRefGroupList() {
        return (List<org.openbravo.model.ad.system.ad_ref_group>) get(PROPERTY_REFGROUPLIST);
    }

    public void setRefGroupList(
        List<org.openbravo.model.ad.system.ad_ref_group> refGroupList) {
        set(PROPERTY_REFGROUPLIST, refGroupList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.ad.system.ad_ref_gridcolumn> getRefGridcolumnList() {
        return (List<org.openbravo.model.ad.system.ad_ref_gridcolumn>) get(PROPERTY_REFGRIDCOLUMNLIST);
    }

    public void setRefGridcolumnList(
        List<org.openbravo.model.ad.system.ad_ref_gridcolumn> refGridcolumnList) {
        set(PROPERTY_REFGRIDCOLUMNLIST, refGridcolumnList);
    }

    @SuppressWarnings("unchecked")
    public List<Selector> getADSelectorList() {
        return (List<Selector>) get(PROPERTY_ADSELECTORLIST);
    }

    public void setADSelectorList(List<Selector> aDSelectorList) {
        set(PROPERTY_ADSELECTORLIST, aDSelectorList);
    }
}
