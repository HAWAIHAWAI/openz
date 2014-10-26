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
import org.openbravo.model.ad.datamodel.Adtabinstance;
import org.openbravo.model.ad.datamodel.Adtoolbar;
import org.openbravo.model.ad.datamodel.Column;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.domain.ModelImplementation;
import org.openbravo.model.ad.module.Module;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.utility.Image;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ADTab (stored in table AD_Tab).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Tab extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Tab";
    public static final String ENTITY_NAME = "ADTab";
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
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_WINDOW = "window";
    public static final String PROPERTY_SEQNO = "seqNo";
    public static final String PROPERTY_TABLEVEL = "tabLevel";
    public static final String PROPERTY_ISSINGLEROW = "isSingleRow";
    public static final String PROPERTY_ISINFOTAB = "isInfoTab";
    public static final String PROPERTY_ISTRANSLATIONTAB = "isTranslationTab";
    public static final String PROPERTY_ISREADONLY = "isReadOnly";
    public static final String PROPERTY_COLUMN = "column";
    public static final String PROPERTY_HASTREE = "hasTree";
    public static final String PROPERTY_WHERECLAUSE = "whereClause";
    public static final String PROPERTY_ORDERBYCLAUSE = "orderByClause";
    public static final String PROPERTY_COMMITWARNING = "commitWarning";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_IMAGE = "image";
    public static final String PROPERTY_IMPORTFIELDS = "importFields";
    public static final String PROPERTY_COLUMNSORTORDER = "columnSortOrder";
    public static final String PROPERTY_COLUMNSORTYESNO = "columnSortYesNo";
    public static final String PROPERTY_ISSORTTAB = "isSortTab";
    public static final String PROPERTY_INCLUDEDTAB = "includedTab";
    public static final String PROPERTY_FILTERCLAUSE = "filterClause";
    public static final String PROPERTY_EDITREFERENCE = "editReference";
    public static final String PROPERTY_MODULE = "module";
    public static final String PROPERTY_UIPATTERN = "uIPattern";
    public static final String PROPERTY_EDITIONMANUAL = "editionmanual";
    public static final String PROPERTY_RELATIONMANUAL = "relationmanual";
    public static final String PROPERTY_EDITIONTOOLBAR = "editiontoolbar";
    public static final String PROPERTY_RELATIONTOOLBAR = "relationtoolbar";
    public static final String PROPERTY_LEFTTABSMODE = "lefttabsmode";
    public static final String PROPERTY_MANUALSERVLETCLASS =
        "manualservletclass";
    public static final String PROPERTY_ISSTANDALONE = "isstandalone";
    public static final String PROPERTY_CREATECUSTOM = "createcustom";
    public static final String PROPERTY_DROPCUSTOM = "dropcustom";
    public static final String PROPERTY_ADFIELDLIST = "aDFieldList";
    public static final String PROPERTY_TABTRLINSTANCELIST =
        "tabTrlInstanceList";
    public static final String PROPERTY_ADMODELIMPLEMENTATIONLIST =
        "aDModelImplementationList";
    public static final String PROPERTY_FIELDVLIST = "fieldVList";
    public static final String PROPERTY_ADTABTRLLIST = "aDTabTrlList";
    public static final String PROPERTY_TABINSTANCELIST = "tabInstanceList";

    public Tab() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISSINGLEROW, false);
        setDefaultValue(PROPERTY_ISINFOTAB, false);
        setDefaultValue(PROPERTY_ISTRANSLATIONTAB, false);
        setDefaultValue(PROPERTY_ISREADONLY, false);
        setDefaultValue(PROPERTY_HASTREE, false);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_IMPORTFIELDS, false);
        setDefaultValue(PROPERTY_ISSORTTAB, false);
        setDefaultValue(PROPERTY_UIPATTERN, "STD");
        setDefaultValue(PROPERTY_EDITIONMANUAL, false);
        setDefaultValue(PROPERTY_RELATIONMANUAL, false);
        setDefaultValue(PROPERTY_ISSTANDALONE, false);
        setDefaultValue(PROPERTY_CREATECUSTOM, true);
        setDefaultValue(PROPERTY_DROPCUSTOM, true);
        setDefaultValue(PROPERTY_ADFIELDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TABTRLINSTANCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADMODELIMPLEMENTATIONLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FIELDVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADTABTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TABINSTANCELIST, new ArrayList<Object>());
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

    public Table getTable() {
        return (Table) get(PROPERTY_TABLE);
    }

    public void setTable(Table table) {
        set(PROPERTY_TABLE, table);
    }

    public Window getWindow() {
        return (Window) get(PROPERTY_WINDOW);
    }

    public void setWindow(Window window) {
        set(PROPERTY_WINDOW, window);
    }

    public Long getSeqNo() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqNo(Long seqNo) {
        set(PROPERTY_SEQNO, seqNo);
    }

    public Long getTabLevel() {
        return (Long) get(PROPERTY_TABLEVEL);
    }

    public void setTabLevel(Long tabLevel) {
        set(PROPERTY_TABLEVEL, tabLevel);
    }

    public Boolean isSingleRow() {
        return (Boolean) get(PROPERTY_ISSINGLEROW);
    }

    public void setSingleRow(Boolean isSingleRow) {
        set(PROPERTY_ISSINGLEROW, isSingleRow);
    }

    public Boolean isInfoTab() {
        return (Boolean) get(PROPERTY_ISINFOTAB);
    }

    public void setInfoTab(Boolean isInfoTab) {
        set(PROPERTY_ISINFOTAB, isInfoTab);
    }

    public Boolean isTranslationTab() {
        return (Boolean) get(PROPERTY_ISTRANSLATIONTAB);
    }

    public void setTranslationTab(Boolean isTranslationTab) {
        set(PROPERTY_ISTRANSLATIONTAB, isTranslationTab);
    }

    public Boolean isReadOnly() {
        return (Boolean) get(PROPERTY_ISREADONLY);
    }

    public void setReadOnly(Boolean isReadOnly) {
        set(PROPERTY_ISREADONLY, isReadOnly);
    }

    public Column getColumn() {
        return (Column) get(PROPERTY_COLUMN);
    }

    public void setColumn(Column column) {
        set(PROPERTY_COLUMN, column);
    }

    public Boolean isHasTree() {
        return (Boolean) get(PROPERTY_HASTREE);
    }

    public void setHasTree(Boolean hasTree) {
        set(PROPERTY_HASTREE, hasTree);
    }

    public String getWhereClause() {
        return (String) get(PROPERTY_WHERECLAUSE);
    }

    public void setWhereClause(String whereClause) {
        set(PROPERTY_WHERECLAUSE, whereClause);
    }

    public String getOrderByClause() {
        return (String) get(PROPERTY_ORDERBYCLAUSE);
    }

    public void setOrderByClause(String orderByClause) {
        set(PROPERTY_ORDERBYCLAUSE, orderByClause);
    }

    public String getCommitWarning() {
        return (String) get(PROPERTY_COMMITWARNING);
    }

    public void setCommitWarning(String commitWarning) {
        set(PROPERTY_COMMITWARNING, commitWarning);
    }

    public Process getProcess() {
        return (Process) get(PROPERTY_PROCESS);
    }

    public void setProcess(Process process) {
        set(PROPERTY_PROCESS, process);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Image getImage() {
        return (Image) get(PROPERTY_IMAGE);
    }

    public void setImage(Image image) {
        set(PROPERTY_IMAGE, image);
    }

    public Boolean isImportFields() {
        return (Boolean) get(PROPERTY_IMPORTFIELDS);
    }

    public void setImportFields(Boolean importFields) {
        set(PROPERTY_IMPORTFIELDS, importFields);
    }

    public Column getColumnSortOrder() {
        return (Column) get(PROPERTY_COLUMNSORTORDER);
    }

    public void setColumnSortOrder(Column columnSortOrder) {
        set(PROPERTY_COLUMNSORTORDER, columnSortOrder);
    }

    public Column getColumnSortYesNo() {
        return (Column) get(PROPERTY_COLUMNSORTYESNO);
    }

    public void setColumnSortYesNo(Column columnSortYesNo) {
        set(PROPERTY_COLUMNSORTYESNO, columnSortYesNo);
    }

    public Boolean isSortTab() {
        return (Boolean) get(PROPERTY_ISSORTTAB);
    }

    public void setSortTab(Boolean isSortTab) {
        set(PROPERTY_ISSORTTAB, isSortTab);
    }

    public Tab getIncludedTab() {
        return (Tab) get(PROPERTY_INCLUDEDTAB);
    }

    public void setIncludedTab(Tab includedTab) {
        set(PROPERTY_INCLUDEDTAB, includedTab);
    }

    public String getFilterClause() {
        return (String) get(PROPERTY_FILTERCLAUSE);
    }

    public void setFilterClause(String filterClause) {
        set(PROPERTY_FILTERCLAUSE, filterClause);
    }

    public Form getEditReference() {
        return (Form) get(PROPERTY_EDITREFERENCE);
    }

    public void setEditReference(Form editReference) {
        set(PROPERTY_EDITREFERENCE, editReference);
    }

    public Module getModule() {
        return (Module) get(PROPERTY_MODULE);
    }

    public void setModule(Module module) {
        set(PROPERTY_MODULE, module);
    }

    public String getUIPattern() {
        return (String) get(PROPERTY_UIPATTERN);
    }

    public void setUIPattern(String uIPattern) {
        set(PROPERTY_UIPATTERN, uIPattern);
    }

    public Boolean isEditionmanual() {
        return (Boolean) get(PROPERTY_EDITIONMANUAL);
    }

    public void setEditionmanual(Boolean editionmanual) {
        set(PROPERTY_EDITIONMANUAL, editionmanual);
    }

    public Boolean isRelationmanual() {
        return (Boolean) get(PROPERTY_RELATIONMANUAL);
    }

    public void setRelationmanual(Boolean relationmanual) {
        set(PROPERTY_RELATIONMANUAL, relationmanual);
    }

    public Adtoolbar getEditiontoolbar() {
        return (Adtoolbar) get(PROPERTY_EDITIONTOOLBAR);
    }

    public void setEditiontoolbar(Adtoolbar editiontoolbar) {
        set(PROPERTY_EDITIONTOOLBAR, editiontoolbar);
    }

    public Adtoolbar getRelationtoolbar() {
        return (Adtoolbar) get(PROPERTY_RELATIONTOOLBAR);
    }

    public void setRelationtoolbar(Adtoolbar relationtoolbar) {
        set(PROPERTY_RELATIONTOOLBAR, relationtoolbar);
    }

    public String getLefttabsmode() {
        return (String) get(PROPERTY_LEFTTABSMODE);
    }

    public void setLefttabsmode(String lefttabsmode) {
        set(PROPERTY_LEFTTABSMODE, lefttabsmode);
    }

    public String getManualservletclass() {
        return (String) get(PROPERTY_MANUALSERVLETCLASS);
    }

    public void setManualservletclass(String manualservletclass) {
        set(PROPERTY_MANUALSERVLETCLASS, manualservletclass);
    }

    public Boolean isStandalone() {
        return (Boolean) get(PROPERTY_ISSTANDALONE);
    }

    public void setStandalone(Boolean isstandalone) {
        set(PROPERTY_ISSTANDALONE, isstandalone);
    }

    public Boolean isCreatecustom() {
        return (Boolean) get(PROPERTY_CREATECUSTOM);
    }

    public void setCreatecustom(Boolean createcustom) {
        set(PROPERTY_CREATECUSTOM, createcustom);
    }

    public Boolean isDropcustom() {
        return (Boolean) get(PROPERTY_DROPCUSTOM);
    }

    public void setDropcustom(Boolean dropcustom) {
        set(PROPERTY_DROPCUSTOM, dropcustom);
    }

    @SuppressWarnings("unchecked")
    public List<Field> getADFieldList() {
        return (List<Field>) get(PROPERTY_ADFIELDLIST);
    }

    public void setADFieldList(List<Field> aDFieldList) {
        set(PROPERTY_ADFIELDLIST, aDFieldList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.ad.system.ad_tab_trl_instance> getTabTrlInstanceList() {
        return (List<org.openbravo.model.ad.system.ad_tab_trl_instance>) get(PROPERTY_TABTRLINSTANCELIST);
    }

    public void setTabTrlInstanceList(
        List<org.openbravo.model.ad.system.ad_tab_trl_instance> tabTrlInstanceList) {
        set(PROPERTY_TABTRLINSTANCELIST, tabTrlInstanceList);
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
    public List<org.openbravo.model.ad.datamodel.ad_field_v> getFieldVList() {
        return (List<org.openbravo.model.ad.datamodel.ad_field_v>) get(PROPERTY_FIELDVLIST);
    }

    public void setFieldVList(
        List<org.openbravo.model.ad.datamodel.ad_field_v> fieldVList) {
        set(PROPERTY_FIELDVLIST, fieldVList);
    }

    @SuppressWarnings("unchecked")
    public List<TabTrl> getADTabTrlList() {
        return (List<TabTrl>) get(PROPERTY_ADTABTRLLIST);
    }

    public void setADTabTrlList(List<TabTrl> aDTabTrlList) {
        set(PROPERTY_ADTABTRLLIST, aDTabTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<Adtabinstance> getTabInstanceList() {
        return (List<Adtabinstance>) get(PROPERTY_TABINSTANCELIST);
    }

    public void setTabInstanceList(List<Adtabinstance> tabInstanceList) {
        set(PROPERTY_TABINSTANCELIST, tabInstanceList);
    }
}
