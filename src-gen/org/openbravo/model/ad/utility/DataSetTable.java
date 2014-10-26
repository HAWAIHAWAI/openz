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
package org.openbravo.model.ad.utility;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.module.Module;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity DataSetTable (stored in table AD_Dataset_Table).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class DataSetTable extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Dataset_Table";
    public static final String ENTITY_NAME = "DataSetTable";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DATASET = "dataset";
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_INCLUDEALLCOLUMNS = "includeAllColumns";
    public static final String PROPERTY_WHERECLAUSE = "whereClause";
    public static final String PROPERTY_EXCLUDEAUDITINFO = "excludeAuditInfo";
    public static final String PROPERTY_ISBUSINESSOBJECT = "isBusinessObject";
    public static final String PROPERTY_MODULE = "module";
    public static final String PROPERTY_DATASETCOLUMNLIST = "dataSetColumnList";

    public DataSetTable() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_INCLUDEALLCOLUMNS, true);
        setDefaultValue(PROPERTY_EXCLUDEAUDITINFO, false);
        setDefaultValue(PROPERTY_ISBUSINESSOBJECT, false);
        setDefaultValue(PROPERTY_DATASETCOLUMNLIST, new ArrayList<Object>());
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

    public DataSet getDataset() {
        return (DataSet) get(PROPERTY_DATASET);
    }

    public void setDataset(DataSet dataset) {
        set(PROPERTY_DATASET, dataset);
    }

    public Table getTable() {
        return (Table) get(PROPERTY_TABLE);
    }

    public void setTable(Table table) {
        set(PROPERTY_TABLE, table);
    }

    public Boolean isIncludeAllColumns() {
        return (Boolean) get(PROPERTY_INCLUDEALLCOLUMNS);
    }

    public void setIncludeAllColumns(Boolean includeAllColumns) {
        set(PROPERTY_INCLUDEALLCOLUMNS, includeAllColumns);
    }

    public String getWhereClause() {
        return (String) get(PROPERTY_WHERECLAUSE);
    }

    public void setWhereClause(String whereClause) {
        set(PROPERTY_WHERECLAUSE, whereClause);
    }

    public Boolean isExcludeAuditInfo() {
        return (Boolean) get(PROPERTY_EXCLUDEAUDITINFO);
    }

    public void setExcludeAuditInfo(Boolean excludeAuditInfo) {
        set(PROPERTY_EXCLUDEAUDITINFO, excludeAuditInfo);
    }

    public Boolean isBusinessObject() {
        return (Boolean) get(PROPERTY_ISBUSINESSOBJECT);
    }

    public void setBusinessObject(Boolean isBusinessObject) {
        set(PROPERTY_ISBUSINESSOBJECT, isBusinessObject);
    }

    public Module getModule() {
        return (Module) get(PROPERTY_MODULE);
    }

    public void setModule(Module module) {
        set(PROPERTY_MODULE, module);
    }

    @SuppressWarnings("unchecked")
    public List<DataSetColumn> getDataSetColumnList() {
        return (List<DataSetColumn>) get(PROPERTY_DATASETCOLUMNLIST);
    }

    public void setDataSetColumnList(List<DataSetColumn> dataSetColumnList) {
        set(PROPERTY_DATASETCOLUMNLIST, dataSetColumnList);
    }
}
