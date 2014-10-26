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
package org.openbravo.model.pricing.pricelist;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCategory;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity PricingPriceListSchemeLine (stored in table M_DiscountSchemaLine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class PriceListSchemeLine extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_DiscountSchemaLine";
    public static final String ENTITY_NAME = "PricingPriceListSchemeLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DISCOUNTSCHEMA = "discountSchema";
    public static final String PROPERTY_SEQNO = "seqNo";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_CONVERSIONRATETYPE =
        "conversionRateType";
    public static final String PROPERTY_CONVERSIONDATE = "conversionDate";
    public static final String PROPERTY_LISTBASE = "listBase";
    public static final String PROPERTY_LISTADDAMT = "listAddAmt";
    public static final String PROPERTY_LISTDISCOUNT = "listDiscount";
    public static final String PROPERTY_LISTROUNDING = "listRounding";
    public static final String PROPERTY_LISTMINAMT = "listMinAmt";
    public static final String PROPERTY_LISTMAXAMT = "listMaxAmt";
    public static final String PROPERTY_LISTFIXED = "listFixed";
    public static final String PROPERTY_STDBASE = "stdBase";
    public static final String PROPERTY_STDADDAMT = "stdAddAmt";
    public static final String PROPERTY_STDDISCOUNT = "stdDiscount";
    public static final String PROPERTY_STDROUNDING = "stdRounding";
    public static final String PROPERTY_STDMINAMT = "stdMinAmt";
    public static final String PROPERTY_STDMAXAMT = "stdMaxAmt";
    public static final String PROPERTY_STDFIXED = "stdFixed";
    public static final String PROPERTY_LIMITBASE = "limitBase";
    public static final String PROPERTY_LIMITADDAMT = "limitAddAmt";
    public static final String PROPERTY_LIMITDISCOUNT = "limitDiscount";
    public static final String PROPERTY_LIMITROUNDING = "limitRounding";
    public static final String PROPERTY_LIMITMINAMT = "limitMinAmt";
    public static final String PROPERTY_LIMITMAXAMT = "limitMaxAmt";
    public static final String PROPERTY_LIMITFIXED = "limitFixed";

    public PriceListSchemeLine() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_CONVERSIONRATETYPE, "S");
        setDefaultValue(PROPERTY_LISTBASE, "L");
        setDefaultValue(PROPERTY_LISTROUNDING, "C");
        setDefaultValue(PROPERTY_STDBASE, "S");
        setDefaultValue(PROPERTY_STDROUNDING, "C");
        setDefaultValue(PROPERTY_LIMITBASE, "X");
        setDefaultValue(PROPERTY_LIMITROUNDING, "C");
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

    public PriceListSchema getDiscountSchema() {
        return (PriceListSchema) get(PROPERTY_DISCOUNTSCHEMA);
    }

    public void setDiscountSchema(PriceListSchema discountSchema) {
        set(PROPERTY_DISCOUNTSCHEMA, discountSchema);
    }

    public Long getSeqNo() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqNo(Long seqNo) {
        set(PROPERTY_SEQNO, seqNo);
    }

    public ProductCategory getProductCategory() {
        return (ProductCategory) get(PROPERTY_PRODUCTCATEGORY);
    }

    public void setProductCategory(ProductCategory productCategory) {
        set(PROPERTY_PRODUCTCATEGORY, productCategory);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public String getConversionRateType() {
        return (String) get(PROPERTY_CONVERSIONRATETYPE);
    }

    public void setConversionRateType(String conversionRateType) {
        set(PROPERTY_CONVERSIONRATETYPE, conversionRateType);
    }

    public Date getConversionDate() {
        return (Date) get(PROPERTY_CONVERSIONDATE);
    }

    public void setConversionDate(Date conversionDate) {
        set(PROPERTY_CONVERSIONDATE, conversionDate);
    }

    public String getListBase() {
        return (String) get(PROPERTY_LISTBASE);
    }

    public void setListBase(String listBase) {
        set(PROPERTY_LISTBASE, listBase);
    }

    public BigDecimal getListAddAmt() {
        return (BigDecimal) get(PROPERTY_LISTADDAMT);
    }

    public void setListAddAmt(BigDecimal listAddAmt) {
        set(PROPERTY_LISTADDAMT, listAddAmt);
    }

    public BigDecimal getListDiscount() {
        return (BigDecimal) get(PROPERTY_LISTDISCOUNT);
    }

    public void setListDiscount(BigDecimal listDiscount) {
        set(PROPERTY_LISTDISCOUNT, listDiscount);
    }

    public String getListRounding() {
        return (String) get(PROPERTY_LISTROUNDING);
    }

    public void setListRounding(String listRounding) {
        set(PROPERTY_LISTROUNDING, listRounding);
    }

    public BigDecimal getListMinAmt() {
        return (BigDecimal) get(PROPERTY_LISTMINAMT);
    }

    public void setListMinAmt(BigDecimal listMinAmt) {
        set(PROPERTY_LISTMINAMT, listMinAmt);
    }

    public BigDecimal getListMaxAmt() {
        return (BigDecimal) get(PROPERTY_LISTMAXAMT);
    }

    public void setListMaxAmt(BigDecimal listMaxAmt) {
        set(PROPERTY_LISTMAXAMT, listMaxAmt);
    }

    public BigDecimal getListFixed() {
        return (BigDecimal) get(PROPERTY_LISTFIXED);
    }

    public void setListFixed(BigDecimal listFixed) {
        set(PROPERTY_LISTFIXED, listFixed);
    }

    public String getStdBase() {
        return (String) get(PROPERTY_STDBASE);
    }

    public void setStdBase(String stdBase) {
        set(PROPERTY_STDBASE, stdBase);
    }

    public BigDecimal getStdAddAmt() {
        return (BigDecimal) get(PROPERTY_STDADDAMT);
    }

    public void setStdAddAmt(BigDecimal stdAddAmt) {
        set(PROPERTY_STDADDAMT, stdAddAmt);
    }

    public BigDecimal getStdDiscount() {
        return (BigDecimal) get(PROPERTY_STDDISCOUNT);
    }

    public void setStdDiscount(BigDecimal stdDiscount) {
        set(PROPERTY_STDDISCOUNT, stdDiscount);
    }

    public String getStdRounding() {
        return (String) get(PROPERTY_STDROUNDING);
    }

    public void setStdRounding(String stdRounding) {
        set(PROPERTY_STDROUNDING, stdRounding);
    }

    public BigDecimal getStdMinAmt() {
        return (BigDecimal) get(PROPERTY_STDMINAMT);
    }

    public void setStdMinAmt(BigDecimal stdMinAmt) {
        set(PROPERTY_STDMINAMT, stdMinAmt);
    }

    public BigDecimal getStdMaxAmt() {
        return (BigDecimal) get(PROPERTY_STDMAXAMT);
    }

    public void setStdMaxAmt(BigDecimal stdMaxAmt) {
        set(PROPERTY_STDMAXAMT, stdMaxAmt);
    }

    public BigDecimal getStdFixed() {
        return (BigDecimal) get(PROPERTY_STDFIXED);
    }

    public void setStdFixed(BigDecimal stdFixed) {
        set(PROPERTY_STDFIXED, stdFixed);
    }

    public String getLimitBase() {
        return (String) get(PROPERTY_LIMITBASE);
    }

    public void setLimitBase(String limitBase) {
        set(PROPERTY_LIMITBASE, limitBase);
    }

    public BigDecimal getLimitAddAmt() {
        return (BigDecimal) get(PROPERTY_LIMITADDAMT);
    }

    public void setLimitAddAmt(BigDecimal limitAddAmt) {
        set(PROPERTY_LIMITADDAMT, limitAddAmt);
    }

    public BigDecimal getLimitDiscount() {
        return (BigDecimal) get(PROPERTY_LIMITDISCOUNT);
    }

    public void setLimitDiscount(BigDecimal limitDiscount) {
        set(PROPERTY_LIMITDISCOUNT, limitDiscount);
    }

    public String getLimitRounding() {
        return (String) get(PROPERTY_LIMITROUNDING);
    }

    public void setLimitRounding(String limitRounding) {
        set(PROPERTY_LIMITROUNDING, limitRounding);
    }

    public BigDecimal getLimitMinAmt() {
        return (BigDecimal) get(PROPERTY_LIMITMINAMT);
    }

    public void setLimitMinAmt(BigDecimal limitMinAmt) {
        set(PROPERTY_LIMITMINAMT, limitMinAmt);
    }

    public BigDecimal getLimitMaxAmt() {
        return (BigDecimal) get(PROPERTY_LIMITMAXAMT);
    }

    public void setLimitMaxAmt(BigDecimal limitMaxAmt) {
        set(PROPERTY_LIMITMAXAMT, limitMaxAmt);
    }

    public BigDecimal getLimitFixed() {
        return (BigDecimal) get(PROPERTY_LIMITFIXED);
    }

    public void setLimitFixed(BigDecimal limitFixed) {
        set(PROPERTY_LIMITFIXED, limitFixed);
    }
}
