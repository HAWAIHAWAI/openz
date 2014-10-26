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
import org.openbravo.model.ad.access.TableAccess;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.module.DataPackage;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.ui.Window;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ADTable (stored in table AD_Table).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Table extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Table";
    public static final String ENTITY_NAME = "ADTable";
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
    public static final String PROPERTY_TABLENAME = "tableName";
    public static final String PROPERTY_CLASSNAME = "classname";
    public static final String PROPERTY_ISVIEW = "isView";
    public static final String PROPERTY_ACCESSLEVEL = "accessLevel";
    public static final String PROPERTY_WINDOW = "window";
    public static final String PROPERTY_ISSECURITYENABLED = "isSecurityEnabled";
    public static final String PROPERTY_ISDELETEABLE = "isDeleteable";
    public static final String PROPERTY_ISHIGHVOLUME = "isHighVolume";
    public static final String PROPERTY_IMPORTTABLE = "importTable";
    public static final String PROPERTY_ISCHANGELOG = "isChangeLog";
    public static final String PROPERTY_WINDOW21 = "window21";
    public static final String PROPERTY_ISDEFAULTACCT = "isDefaultAcct";
    public static final String PROPERTY_SQLRECORDIDENTIFIER =
        "sQLRecordIdentifier";
    public static final String PROPERTY_DEVELOPMENTSTATUS = "developmentstatus";
    public static final String PROPERTY_PACKAGE = "package";
    public static final String PROPERTY_TREETYPE = "treetype";
    public static final String PROPERTY_ACCTDATECOLUMN = "acctdateColumn";
    public static final String PROPERTY_ACCTCLASSNAME = "acctclassname";
    public static final String PROPERTY_ADCOLUMNLIST = "aDColumnList";
    public static final String PROPERTY_COLUMNVLIST = "columnVList";
    public static final String PROPERTY_ADTABLEACCESSLIST = "aDTableAccessList";

    public Table() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISVIEW, false);
        setDefaultValue(PROPERTY_ACCESSLEVEL, "4");
        setDefaultValue(PROPERTY_ISSECURITYENABLED, false);
        setDefaultValue(PROPERTY_ISDELETEABLE, true);
        setDefaultValue(PROPERTY_ISHIGHVOLUME, false);
        setDefaultValue(PROPERTY_IMPORTTABLE, false);
        setDefaultValue(PROPERTY_ISCHANGELOG, false);
        setDefaultValue(PROPERTY_ISDEFAULTACCT, false);
        setDefaultValue(PROPERTY_DEVELOPMENTSTATUS, "RE");
        setDefaultValue(PROPERTY_ADCOLUMNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_COLUMNVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADTABLEACCESSLIST, new ArrayList<Object>());
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

    public String getTableName() {
        return (String) get(PROPERTY_TABLENAME);
    }

    public void setTableName(String tableName) {
        set(PROPERTY_TABLENAME, tableName);
    }

    public String getClassname() {
        return (String) get(PROPERTY_CLASSNAME);
    }

    public void setClassname(String classname) {
        set(PROPERTY_CLASSNAME, classname);
    }

    public Boolean isView() {
        return (Boolean) get(PROPERTY_ISVIEW);
    }

    public void setView(Boolean isView) {
        set(PROPERTY_ISVIEW, isView);
    }

    public String getAccessLevel() {
        return (String) get(PROPERTY_ACCESSLEVEL);
    }

    public void setAccessLevel(String accessLevel) {
        set(PROPERTY_ACCESSLEVEL, accessLevel);
    }

    public Window getWindow() {
        return (Window) get(PROPERTY_WINDOW);
    }

    public void setWindow(Window window) {
        set(PROPERTY_WINDOW, window);
    }

    public Boolean isSecurityEnabled() {
        return (Boolean) get(PROPERTY_ISSECURITYENABLED);
    }

    public void setSecurityEnabled(Boolean isSecurityEnabled) {
        set(PROPERTY_ISSECURITYENABLED, isSecurityEnabled);
    }

    public Boolean isDeleteable() {
        return (Boolean) get(PROPERTY_ISDELETEABLE);
    }

    public void setDeleteable(Boolean isDeleteable) {
        set(PROPERTY_ISDELETEABLE, isDeleteable);
    }

    public Boolean isHighVolume() {
        return (Boolean) get(PROPERTY_ISHIGHVOLUME);
    }

    public void setHighVolume(Boolean isHighVolume) {
        set(PROPERTY_ISHIGHVOLUME, isHighVolume);
    }

    public Boolean isImportTable() {
        return (Boolean) get(PROPERTY_IMPORTTABLE);
    }

    public void setImportTable(Boolean importTable) {
        set(PROPERTY_IMPORTTABLE, importTable);
    }

    public Boolean isChangeLog() {
        return (Boolean) get(PROPERTY_ISCHANGELOG);
    }

    public void setChangeLog(Boolean isChangeLog) {
        set(PROPERTY_ISCHANGELOG, isChangeLog);
    }

    public Window getWindow21() {
        return (Window) get(PROPERTY_WINDOW21);
    }

    public void setWindow21(Window window21) {
        set(PROPERTY_WINDOW21, window21);
    }

    public Boolean isDefaultAcct() {
        return (Boolean) get(PROPERTY_ISDEFAULTACCT);
    }

    public void setDefaultAcct(Boolean isDefaultAcct) {
        set(PROPERTY_ISDEFAULTACCT, isDefaultAcct);
    }

    public String getSQLRecordIdentifier() {
        return (String) get(PROPERTY_SQLRECORDIDENTIFIER);
    }

    public void setSQLRecordIdentifier(String sQLRecordIdentifier) {
        set(PROPERTY_SQLRECORDIDENTIFIER, sQLRecordIdentifier);
    }

    public String getDevelopmentstatus() {
        return (String) get(PROPERTY_DEVELOPMENTSTATUS);
    }

    public void setDevelopmentstatus(String developmentstatus) {
        set(PROPERTY_DEVELOPMENTSTATUS, developmentstatus);
    }

    public DataPackage getPackage() {
        return (DataPackage) get(PROPERTY_PACKAGE);
    }

    public void setPackage(DataPackage pkg) {
        set(PROPERTY_PACKAGE, pkg);
    }

    public String getTreetype() {
        return (String) get(PROPERTY_TREETYPE);
    }

    public void setTreetype(String treetype) {
        set(PROPERTY_TREETYPE, treetype);
    }

    public Column getAcctdateColumn() {
        return (Column) get(PROPERTY_ACCTDATECOLUMN);
    }

    public void setAcctdateColumn(Column acctdateColumn) {
        set(PROPERTY_ACCTDATECOLUMN, acctdateColumn);
    }

    public String getAcctclassname() {
        return (String) get(PROPERTY_ACCTCLASSNAME);
    }

    public void setAcctclassname(String acctclassname) {
        set(PROPERTY_ACCTCLASSNAME, acctclassname);
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
    public List<TableAccess> getADTableAccessList() {
        return (List<TableAccess>) get(PROPERTY_ADTABLEACCESSLIST);
    }

    public void setADTableAccessList(List<TableAccess> aDTableAccessList) {
        set(PROPERTY_ADTABLEACCESSLIST, aDTableAccessList);
    }
}
