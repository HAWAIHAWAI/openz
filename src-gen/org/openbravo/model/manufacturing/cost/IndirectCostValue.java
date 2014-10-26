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
package org.openbravo.model.manufacturing.cost;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ManufacturingIndirectCostValue (stored in table MA_Indirect_Cost_Value).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class IndirectCostValue extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "MA_Indirect_Cost_Value";
    public static final String ENTITY_NAME = "ManufacturingIndirectCostValue";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_INDIRECTCOST = "indirectCost";
    public static final String PROPERTY_DATEFROM = "dateFrom";
    public static final String PROPERTY_DATETO = "dateTo";
    public static final String PROPERTY_TOTAL = "total";
    public static final String PROPERTY_EMPCOST = "empCost";
    public static final String PROPERTY_COSTUOM = "costUom";
    public static final String PROPERTY_CALCULATED = "calculated";
    public static final String PROPERTY_MACHINECOST = "machinecost";
    public static final String PROPERTY_MATERIALCOST = "materialcost";
    public static final String PROPERTY_VENDORCOST = "vendorcost";
    public static final String PROPERTY_INDIRECTCOSTVALUEPRODUCTLIST =
        "indirectCostValueProductList";

    public IndirectCostValue() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_CALCULATED, false);
        setDefaultValue(PROPERTY_INDIRECTCOSTVALUEPRODUCTLIST,
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

    public IndirectCost getIndirectCost() {
        return (IndirectCost) get(PROPERTY_INDIRECTCOST);
    }

    public void setIndirectCost(IndirectCost indirectCost) {
        set(PROPERTY_INDIRECTCOST, indirectCost);
    }

    public Date getDateFrom() {
        return (Date) get(PROPERTY_DATEFROM);
    }

    public void setDateFrom(Date dateFrom) {
        set(PROPERTY_DATEFROM, dateFrom);
    }

    public Date getDateTo() {
        return (Date) get(PROPERTY_DATETO);
    }

    public void setDateTo(Date dateTo) {
        set(PROPERTY_DATETO, dateTo);
    }

    public BigDecimal getTotal() {
        return (BigDecimal) get(PROPERTY_TOTAL);
    }

    public void setTotal(BigDecimal total) {
        set(PROPERTY_TOTAL, total);
    }

    public BigDecimal getEmpCost() {
        return (BigDecimal) get(PROPERTY_EMPCOST);
    }

    public void setEmpCost(BigDecimal empCost) {
        set(PROPERTY_EMPCOST, empCost);
    }

    public String getCostUom() {
        return (String) get(PROPERTY_COSTUOM);
    }

    public void setCostUom(String costUom) {
        set(PROPERTY_COSTUOM, costUom);
    }

    public Boolean isCalculated() {
        return (Boolean) get(PROPERTY_CALCULATED);
    }

    public void setCalculated(Boolean calculated) {
        set(PROPERTY_CALCULATED, calculated);
    }

    public Long getMachinecost() {
        return (Long) get(PROPERTY_MACHINECOST);
    }

    public void setMachinecost(Long machinecost) {
        set(PROPERTY_MACHINECOST, machinecost);
    }

    public Long getMaterialcost() {
        return (Long) get(PROPERTY_MATERIALCOST);
    }

    public void setMaterialcost(Long materialcost) {
        set(PROPERTY_MATERIALCOST, materialcost);
    }

    public Long getVendorcost() {
        return (Long) get(PROPERTY_VENDORCOST);
    }

    public void setVendorcost(Long vendorcost) {
        set(PROPERTY_VENDORCOST, vendorcost);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.manufacturing.cost.ma_indirect_cost_value_product> getIndirectCostValueProductList() {
        return (List<org.openbravo.model.manufacturing.cost.ma_indirect_cost_value_product>) get(PROPERTY_INDIRECTCOSTVALUEPRODUCTLIST);
    }

    public void setIndirectCostValueProductList(
        List<org.openbravo.model.manufacturing.cost.ma_indirect_cost_value_product> indirectCostValueProductList) {
        set(PROPERTY_INDIRECTCOSTVALUEPRODUCTLIST, indirectCostValueProductList);
    }
}
