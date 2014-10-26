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
package org.openbravo.model.financialmgmt.payment;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.bank.BankAccount;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity FinancialMgmtPromissoryFormat (stored in table C_PromissoryFormat).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class PromissoryFormat extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_PromissoryFormat";
    public static final String ENTITY_NAME = "FinancialMgmtPromissoryFormat";
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
    public static final String PROPERTY_BANKACCOUNT = "bankAccount";
    public static final String PROPERTY_LINE1TOP = "line1top";
    public static final String PROPERTY_LINE1LEFT = "line1left";
    public static final String PROPERTY_LINE2TOP = "line2top";
    public static final String PROPERTY_LINE2LEFT = "line2left";
    public static final String PROPERTY_LINE3TOP = "line3top";
    public static final String PROPERTY_LINE3LEFT = "line3left";
    public static final String PROPERTY_LINE4TOP = "line4top";
    public static final String PROPERTY_LINE4LEFT = "line4left";
    public static final String PROPERTY_PARAM11 = "param11";
    public static final String PROPERTY_PARAM12 = "param12";
    public static final String PROPERTY_PARAM13 = "param13";
    public static final String PROPERTY_PARAM31 = "param31";
    public static final String PROPERTY_PARAM32 = "param32";
    public static final String PROPERTY_PARAM41 = "param41";
    public static final String PROPERTY_PARAM42 = "param42";
    public static final String PROPERTY_PARAM43 = "param43";
    public static final String PROPERTY_PRINTBANKLOC = "printbankloc";
    public static final String PROPERTY_FONTDAYPLANNED = "fontdayplanned";
    public static final String PROPERTY_FONTMONTHPLANNED = "fontmonthplanned";
    public static final String PROPERTY_FONTYEARPLANNED = "fontyearplanned";
    public static final String PROPERTY_FONTAMOUNT = "fontamount";
    public static final String PROPERTY_FONTPARTNERNAME = "fontpartnername";
    public static final String PROPERTY_FONTAMOUNTTEXT = "fontamounttext";
    public static final String PROPERTY_FONTDAYTODAY = "fontdaytoday";
    public static final String PROPERTY_FONTMONTHTODAY = "fontmonthtoday";
    public static final String PROPERTY_FONTYEARTODAY = "fontyeartoday";
    public static final String PROPERTY_FONTBANKLOCATION = "fontBankLocation";

    public PromissoryFormat() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_LINE1TOP, new BigDecimal(1));
        setDefaultValue(PROPERTY_LINE1LEFT, new BigDecimal(1));
        setDefaultValue(PROPERTY_LINE2TOP, new BigDecimal(1));
        setDefaultValue(PROPERTY_LINE2LEFT, new BigDecimal(1));
        setDefaultValue(PROPERTY_LINE3TOP, new BigDecimal(1));
        setDefaultValue(PROPERTY_LINE3LEFT, new BigDecimal(1));
        setDefaultValue(PROPERTY_LINE4TOP, new BigDecimal(1));
        setDefaultValue(PROPERTY_LINE4LEFT, new BigDecimal(1));
        setDefaultValue(PROPERTY_PARAM11, new BigDecimal(0));
        setDefaultValue(PROPERTY_PARAM12, new BigDecimal(0));
        setDefaultValue(PROPERTY_PARAM13, new BigDecimal(0));
        setDefaultValue(PROPERTY_PARAM31, new BigDecimal(0));
        setDefaultValue(PROPERTY_PARAM32, new BigDecimal(0));
        setDefaultValue(PROPERTY_PARAM41, new BigDecimal(0));
        setDefaultValue(PROPERTY_PARAM42, new BigDecimal(0));
        setDefaultValue(PROPERTY_PARAM43, new BigDecimal(0));
        setDefaultValue(PROPERTY_PRINTBANKLOC, true);
        setDefaultValue(PROPERTY_FONTDAYPLANNED, new BigDecimal(8));
        setDefaultValue(PROPERTY_FONTMONTHPLANNED, new BigDecimal(8));
        setDefaultValue(PROPERTY_FONTYEARPLANNED, new BigDecimal(8));
        setDefaultValue(PROPERTY_FONTAMOUNT, new BigDecimal(8));
        setDefaultValue(PROPERTY_FONTPARTNERNAME, new BigDecimal(8));
        setDefaultValue(PROPERTY_FONTAMOUNTTEXT, new BigDecimal(8));
        setDefaultValue(PROPERTY_FONTDAYTODAY, new BigDecimal(8));
        setDefaultValue(PROPERTY_FONTMONTHTODAY, new BigDecimal(8));
        setDefaultValue(PROPERTY_FONTYEARTODAY, new BigDecimal(8));
        setDefaultValue(PROPERTY_FONTBANKLOCATION, new BigDecimal(8));
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

    public BankAccount getBankAccount() {
        return (BankAccount) get(PROPERTY_BANKACCOUNT);
    }

    public void setBankAccount(BankAccount bankAccount) {
        set(PROPERTY_BANKACCOUNT, bankAccount);
    }

    public BigDecimal getLine1top() {
        return (BigDecimal) get(PROPERTY_LINE1TOP);
    }

    public void setLine1top(BigDecimal line1top) {
        set(PROPERTY_LINE1TOP, line1top);
    }

    public BigDecimal getLine1left() {
        return (BigDecimal) get(PROPERTY_LINE1LEFT);
    }

    public void setLine1left(BigDecimal line1left) {
        set(PROPERTY_LINE1LEFT, line1left);
    }

    public BigDecimal getLine2top() {
        return (BigDecimal) get(PROPERTY_LINE2TOP);
    }

    public void setLine2top(BigDecimal line2top) {
        set(PROPERTY_LINE2TOP, line2top);
    }

    public BigDecimal getLine2left() {
        return (BigDecimal) get(PROPERTY_LINE2LEFT);
    }

    public void setLine2left(BigDecimal line2left) {
        set(PROPERTY_LINE2LEFT, line2left);
    }

    public BigDecimal getLine3top() {
        return (BigDecimal) get(PROPERTY_LINE3TOP);
    }

    public void setLine3top(BigDecimal line3top) {
        set(PROPERTY_LINE3TOP, line3top);
    }

    public BigDecimal getLine3left() {
        return (BigDecimal) get(PROPERTY_LINE3LEFT);
    }

    public void setLine3left(BigDecimal line3left) {
        set(PROPERTY_LINE3LEFT, line3left);
    }

    public BigDecimal getLine4top() {
        return (BigDecimal) get(PROPERTY_LINE4TOP);
    }

    public void setLine4top(BigDecimal line4top) {
        set(PROPERTY_LINE4TOP, line4top);
    }

    public BigDecimal getLine4left() {
        return (BigDecimal) get(PROPERTY_LINE4LEFT);
    }

    public void setLine4left(BigDecimal line4left) {
        set(PROPERTY_LINE4LEFT, line4left);
    }

    public BigDecimal getParam11() {
        return (BigDecimal) get(PROPERTY_PARAM11);
    }

    public void setParam11(BigDecimal param11) {
        set(PROPERTY_PARAM11, param11);
    }

    public BigDecimal getParam12() {
        return (BigDecimal) get(PROPERTY_PARAM12);
    }

    public void setParam12(BigDecimal param12) {
        set(PROPERTY_PARAM12, param12);
    }

    public BigDecimal getParam13() {
        return (BigDecimal) get(PROPERTY_PARAM13);
    }

    public void setParam13(BigDecimal param13) {
        set(PROPERTY_PARAM13, param13);
    }

    public BigDecimal getParam31() {
        return (BigDecimal) get(PROPERTY_PARAM31);
    }

    public void setParam31(BigDecimal param31) {
        set(PROPERTY_PARAM31, param31);
    }

    public BigDecimal getParam32() {
        return (BigDecimal) get(PROPERTY_PARAM32);
    }

    public void setParam32(BigDecimal param32) {
        set(PROPERTY_PARAM32, param32);
    }

    public BigDecimal getParam41() {
        return (BigDecimal) get(PROPERTY_PARAM41);
    }

    public void setParam41(BigDecimal param41) {
        set(PROPERTY_PARAM41, param41);
    }

    public BigDecimal getParam42() {
        return (BigDecimal) get(PROPERTY_PARAM42);
    }

    public void setParam42(BigDecimal param42) {
        set(PROPERTY_PARAM42, param42);
    }

    public BigDecimal getParam43() {
        return (BigDecimal) get(PROPERTY_PARAM43);
    }

    public void setParam43(BigDecimal param43) {
        set(PROPERTY_PARAM43, param43);
    }

    public Boolean isPrintbankloc() {
        return (Boolean) get(PROPERTY_PRINTBANKLOC);
    }

    public void setPrintbankloc(Boolean printbankloc) {
        set(PROPERTY_PRINTBANKLOC, printbankloc);
    }

    public BigDecimal getFontdayplanned() {
        return (BigDecimal) get(PROPERTY_FONTDAYPLANNED);
    }

    public void setFontdayplanned(BigDecimal fontdayplanned) {
        set(PROPERTY_FONTDAYPLANNED, fontdayplanned);
    }

    public BigDecimal getFontmonthplanned() {
        return (BigDecimal) get(PROPERTY_FONTMONTHPLANNED);
    }

    public void setFontmonthplanned(BigDecimal fontmonthplanned) {
        set(PROPERTY_FONTMONTHPLANNED, fontmonthplanned);
    }

    public BigDecimal getFontyearplanned() {
        return (BigDecimal) get(PROPERTY_FONTYEARPLANNED);
    }

    public void setFontyearplanned(BigDecimal fontyearplanned) {
        set(PROPERTY_FONTYEARPLANNED, fontyearplanned);
    }

    public BigDecimal getFontamount() {
        return (BigDecimal) get(PROPERTY_FONTAMOUNT);
    }

    public void setFontamount(BigDecimal fontamount) {
        set(PROPERTY_FONTAMOUNT, fontamount);
    }

    public BigDecimal getFontpartnername() {
        return (BigDecimal) get(PROPERTY_FONTPARTNERNAME);
    }

    public void setFontpartnername(BigDecimal fontpartnername) {
        set(PROPERTY_FONTPARTNERNAME, fontpartnername);
    }

    public BigDecimal getFontamounttext() {
        return (BigDecimal) get(PROPERTY_FONTAMOUNTTEXT);
    }

    public void setFontamounttext(BigDecimal fontamounttext) {
        set(PROPERTY_FONTAMOUNTTEXT, fontamounttext);
    }

    public BigDecimal getFontdaytoday() {
        return (BigDecimal) get(PROPERTY_FONTDAYTODAY);
    }

    public void setFontdaytoday(BigDecimal fontdaytoday) {
        set(PROPERTY_FONTDAYTODAY, fontdaytoday);
    }

    public BigDecimal getFontmonthtoday() {
        return (BigDecimal) get(PROPERTY_FONTMONTHTODAY);
    }

    public void setFontmonthtoday(BigDecimal fontmonthtoday) {
        set(PROPERTY_FONTMONTHTODAY, fontmonthtoday);
    }

    public BigDecimal getFontyeartoday() {
        return (BigDecimal) get(PROPERTY_FONTYEARTODAY);
    }

    public void setFontyeartoday(BigDecimal fontyeartoday) {
        set(PROPERTY_FONTYEARTODAY, fontyeartoday);
    }

    public BigDecimal getFontBankLocation() {
        return (BigDecimal) get(PROPERTY_FONTBANKLOCATION);
    }

    public void setFontBankLocation(BigDecimal fontBankLocation) {
        set(PROPERTY_FONTBANKLOCATION, fontBankLocation);
    }
}
