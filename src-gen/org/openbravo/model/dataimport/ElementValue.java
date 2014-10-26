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
import org.openbravo.model.ad.datamodel.Column;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.coa.Element;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity DataImportElementValue (stored in table I_ElementValue).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ElementValue extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "I_ElementValue";
    public static final String ENTITY_NAME = "DataImportElementValue";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ELEMENT = "element";
    public static final String PROPERTY_ELEMENTNAME = "elementName";
    public static final String PROPERTY_ELEMENTVALUE = "elementValue";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ACCOUNTTYPE = "accountType";
    public static final String PROPERTY_ACCOUNTSIGN = "accountSign";
    public static final String PROPERTY_ISDOCCONTROLLED = "isDocControlled";
    public static final String PROPERTY_ISSUMMARY = "isSummary";
    public static final String PROPERTY_PARENTVALUE = "parentValue";
    public static final String PROPERTY_PARENTELEMENTVALUE =
        "parentElementValue";
    public static final String PROPERTY_POSTACTUAL = "postActual";
    public static final String PROPERTY_POSTBUDGET = "postBudget";
    public static final String PROPERTY_POSTSTATISTICAL = "postStatistical";
    public static final String PROPERTY_POSTENCUMBRANCE = "postEncumbrance";
    public static final String PROPERTY_DEFAULTACCOUNT = "defaultAccount";
    public static final String PROPERTY_COLUMN = "column";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_ERRORMSG = "errorMsg";
    public static final String PROPERTY_ISIMPORTED = "isImported";
    public static final String PROPERTY_ELEMENTLEVEL = "elementlevel";
    public static final String PROPERTY_OPERANDS = "operands";
    public static final String PROPERTY_SEQNO = "seqno";

    public ElementValue() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISDOCCONTROLLED, false);
        setDefaultValue(PROPERTY_ISSUMMARY, false);
        setDefaultValue(PROPERTY_POSTACTUAL, false);
        setDefaultValue(PROPERTY_POSTBUDGET, false);
        setDefaultValue(PROPERTY_POSTSTATISTICAL, false);
        setDefaultValue(PROPERTY_POSTENCUMBRANCE, false);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_ISIMPORTED, false);
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

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getCreated() {
        return (Date) get(PROPERTY_CREATED);
    }

    public void setCreated(Date created) {
        set(PROPERTY_CREATED, created);
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

    public Element getElement() {
        return (Element) get(PROPERTY_ELEMENT);
    }

    public void setElement(Element element) {
        set(PROPERTY_ELEMENT, element);
    }

    public String getElementName() {
        return (String) get(PROPERTY_ELEMENTNAME);
    }

    public void setElementName(String elementName) {
        set(PROPERTY_ELEMENTNAME, elementName);
    }

    public org.openbravo.model.financialmgmt.accounting.coa.ElementValue getElementValue() {
        return (org.openbravo.model.financialmgmt.accounting.coa.ElementValue) get(PROPERTY_ELEMENTVALUE);
    }

    public void setElementValue(
        org.openbravo.model.financialmgmt.accounting.coa.ElementValue elementValue) {
        set(PROPERTY_ELEMENTVALUE, elementValue);
    }

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
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

    public String getAccountType() {
        return (String) get(PROPERTY_ACCOUNTTYPE);
    }

    public void setAccountType(String accountType) {
        set(PROPERTY_ACCOUNTTYPE, accountType);
    }

    public String getAccountSign() {
        return (String) get(PROPERTY_ACCOUNTSIGN);
    }

    public void setAccountSign(String accountSign) {
        set(PROPERTY_ACCOUNTSIGN, accountSign);
    }

    public Boolean isDocControlled() {
        return (Boolean) get(PROPERTY_ISDOCCONTROLLED);
    }

    public void setDocControlled(Boolean isDocControlled) {
        set(PROPERTY_ISDOCCONTROLLED, isDocControlled);
    }

    public Boolean isSummary() {
        return (Boolean) get(PROPERTY_ISSUMMARY);
    }

    public void setSummary(Boolean isSummary) {
        set(PROPERTY_ISSUMMARY, isSummary);
    }

    public String getParentValue() {
        return (String) get(PROPERTY_PARENTVALUE);
    }

    public void setParentValue(String parentValue) {
        set(PROPERTY_PARENTVALUE, parentValue);
    }

    public org.openbravo.model.financialmgmt.accounting.coa.ElementValue getParentElementValue() {
        return (org.openbravo.model.financialmgmt.accounting.coa.ElementValue) get(PROPERTY_PARENTELEMENTVALUE);
    }

    public void setParentElementValue(
        org.openbravo.model.financialmgmt.accounting.coa.ElementValue parentElementValue) {
        set(PROPERTY_PARENTELEMENTVALUE, parentElementValue);
    }

    public Boolean isPostActual() {
        return (Boolean) get(PROPERTY_POSTACTUAL);
    }

    public void setPostActual(Boolean postActual) {
        set(PROPERTY_POSTACTUAL, postActual);
    }

    public Boolean isPostBudget() {
        return (Boolean) get(PROPERTY_POSTBUDGET);
    }

    public void setPostBudget(Boolean postBudget) {
        set(PROPERTY_POSTBUDGET, postBudget);
    }

    public Boolean isPostStatistical() {
        return (Boolean) get(PROPERTY_POSTSTATISTICAL);
    }

    public void setPostStatistical(Boolean postStatistical) {
        set(PROPERTY_POSTSTATISTICAL, postStatistical);
    }

    public Boolean isPostEncumbrance() {
        return (Boolean) get(PROPERTY_POSTENCUMBRANCE);
    }

    public void setPostEncumbrance(Boolean postEncumbrance) {
        set(PROPERTY_POSTENCUMBRANCE, postEncumbrance);
    }

    public String getDefaultAccount() {
        return (String) get(PROPERTY_DEFAULTACCOUNT);
    }

    public void setDefaultAccount(String defaultAccount) {
        set(PROPERTY_DEFAULTACCOUNT, defaultAccount);
    }

    public Column getColumn() {
        return (Column) get(PROPERTY_COLUMN);
    }

    public void setColumn(Column column) {
        set(PROPERTY_COLUMN, column);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getErrorMsg() {
        return (String) get(PROPERTY_ERRORMSG);
    }

    public void setErrorMsg(String errorMsg) {
        set(PROPERTY_ERRORMSG, errorMsg);
    }

    public Boolean isImported() {
        return (Boolean) get(PROPERTY_ISIMPORTED);
    }

    public void setImported(Boolean isImported) {
        set(PROPERTY_ISIMPORTED, isImported);
    }

    public String getElementlevel() {
        return (String) get(PROPERTY_ELEMENTLEVEL);
    }

    public void setElementlevel(String elementlevel) {
        set(PROPERTY_ELEMENTLEVEL, elementlevel);
    }

    public String getOperands() {
        return (String) get(PROPERTY_OPERANDS);
    }

    public void setOperands(String operands) {
        set(PROPERTY_OPERANDS, operands);
    }

    public Long getSeqno() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqno(Long seqno) {
        set(PROPERTY_SEQNO, seqno);
    }
}
