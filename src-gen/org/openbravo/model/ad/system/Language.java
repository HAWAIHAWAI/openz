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
package org.openbravo.model.ad.system;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.alert.AlertRuleTrl;
import org.openbravo.model.ad.datamodel.Adelementtrlinstance;
import org.openbravo.model.ad.datamodel.Adfieldtrlinstance;
import org.openbravo.model.ad.datamodel.Admessagetrlinstance;
import org.openbravo.model.ad.domain.ListTrl;
import org.openbravo.model.ad.domain.ReferenceTrl;
import org.openbravo.model.ad.ui.ElementTrl;
import org.openbravo.model.ad.ui.FieldGroupTrl;
import org.openbravo.model.ad.ui.FieldTrl;
import org.openbravo.model.ad.ui.FormTrl;
import org.openbravo.model.ad.ui.MenuTrl;
import org.openbravo.model.ad.ui.MessageTrl;
import org.openbravo.model.ad.ui.ProcessParameterTrl;
import org.openbravo.model.ad.ui.ProcessTrl;
import org.openbravo.model.ad.ui.TabTrl;
import org.openbravo.model.ad.ui.TaskTrl;
import org.openbravo.model.ad.ui.TextInterfaceTrl;
import org.openbravo.model.ad.ui.WFNodeTrl;
import org.openbravo.model.ad.ui.WindowTrl;
import org.openbravo.model.ad.ui.WorkflowTrl;
import org.openbravo.model.common.businesspartner.CUserDepartmenttrl;
import org.openbravo.model.common.businesspartner.CUserPositiontrl;
import org.openbravo.model.common.businesspartner.GreetingTrl;
import org.openbravo.model.common.currency.CurrencyTrl;
import org.openbravo.model.common.enterprise.ADMonthTrl;
import org.openbravo.model.common.enterprise.DocumentTypeTrl;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.CountryTrl;
import org.openbravo.model.common.plm.ProductTrl;
import org.openbravo.model.common.uom.UOMTrl;
import org.openbravo.model.financialmgmt.accounting.coa.ElementValueTrl;
import org.openbravo.model.financialmgmt.payment.PaymentTermTrl;
import org.openbravo.model.financialmgmt.tax.TaxCategoryTrl;
import org.openbravo.model.financialmgmt.tax.TaxTrl;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ADLanguage (stored in table AD_Language).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Language extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Language";
    public static final String ENTITY_NAME = "ADLanguage";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_LANGUAGE = "language";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_LANGUAGEISO = "languageISO";
    public static final String PROPERTY_COUNTRYCODE = "countryCode";
    public static final String PROPERTY_ISBASELANGUAGE = "isBaseLanguage";
    public static final String PROPERTY_ISSYSTEMLANGUAGE = "isSystemLanguage";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PIXELSIZE = "pixelsize";
    public static final String PROPERTY_TRANSLATEDBY = "translatedby";
    public static final String PROPERTY_ISRTL = "isrtl";
    public static final String PROPERTY_ADWFNODETRLLIST = "aDWFNodeTrlList";
    public static final String PROPERTY_FINANCIALMGMTPAYMENTTERMTRLLIST =
        "financialMgmtPaymentTermTrlList";
    public static final String PROPERTY_COUNTRYTRLLIST = "countryTrlList";
    public static final String PROPERTY_ADTASKTRLLIST = "aDTaskTrlList";
    public static final String PROPERTY_ADFORMTRLLIST = "aDFormTrlList";
    public static final String PROPERTY_REFLISTINSTANCETRLLIST =
        "refListinstanceTrlList";
    public static final String PROPERTY_PRODUCTTRLLIST = "productTrlList";
    public static final String PROPERTY_FINANCIALMGMTELEMENTVALUETRLLIST =
        "financialMgmtElementValueTrlList";
    public static final String PROPERTY_FINANCIALMGMTTAXTRLLIST =
        "financialMgmtTaxTrlList";
    public static final String PROPERTY_ADPROCESSTRLLIST = "aDProcessTrlList";
    public static final String PROPERTY_FINANCIALMGMTTAXCATEGORYTRLLIST =
        "financialMgmtTaxCategoryTrlList";
    public static final String PROPERTY_ADLISTTRLLIST = "aDListTrlList";
    public static final String PROPERTY_ADREFERENCETRLLIST =
        "aDReferenceTrlList";
    public static final String PROPERTY_CURRENCYTRLLIST = "currencyTrlList";
    public static final String PROPERTY_MESSAGETRLINSTANCELIST =
        "messageTrlInstanceList";
    public static final String PROPERTY_ADTABTRLLIST = "aDTabTrlList";
    public static final String PROPERTY_ADMONTHTRLLIST = "aDMonthTrlList";
    public static final String PROPERTY_GREETINGTRLLIST = "greetingTrlList";
    public static final String PROPERTY_DOCUMENTTYPETRLLIST =
        "documentTypeTrlList";
    public static final String PROPERTY_UOMTRLLIST = "uOMTrlList";
    public static final String PROPERTY_ADMESSAGETRLLIST = "aDMessageTrlList";
    public static final String PROPERTY_ADPROCESSPARAMETERTRLLIST =
        "aDProcessParameterTrlList";
    public static final String PROPERTY_ADALERTRULETRLLIST =
        "aDAlertRuleTrlList";
    public static final String PROPERTY_USERPOSITIONTRLLIST =
        "userPositionTrlList";
    public static final String PROPERTY_ADWINDOWTRLLIST = "aDWindowTrlList";
    public static final String PROPERTY_ADWORKFLOWTRLLIST = "aDWorkflowTrlList";
    public static final String PROPERTY_LINEOFBUSINESSTRLLIST =
        "lineofbusinessTrlList";
    public static final String PROPERTY_ADFIELDTRLLIST = "aDFieldTrlList";
    public static final String PROPERTY_ADMENUTRLLIST = "aDMenuTrlList";
    public static final String PROPERTY_ADFIELDGROUPTRLLIST =
        "aDFieldGroupTrlList";
    public static final String PROPERTY_ELEMENTTRLINSTANCELIST =
        "elementTrlInstanceList";
    public static final String PROPERTY_USERDEPARTMENTTRLLIST =
        "userDepartmentTrlList";
    public static final String PROPERTY_ADTEXTINTERFACETRLLIST =
        "aDTextInterfaceTrlList";
    public static final String PROPERTY_ADELEMENTTRLLIST = "aDElementTrlList";
    public static final String PROPERTY_FIELDTRLINSTANCELIST =
        "fieldTrlInstanceList";

    public Language() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISBASELANGUAGE, false);
        setDefaultValue(PROPERTY_ISSYSTEMLANGUAGE, false);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_ISRTL, false);
        setDefaultValue(PROPERTY_ADWFNODETRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTPAYMENTTERMTRLLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_COUNTRYTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADTASKTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADFORMTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_REFLISTINSTANCETRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTELEMENTVALUETRLLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTTAXTRLLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADPROCESSTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTTAXCATEGORYTRLLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADLISTTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADREFERENCETRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CURRENCYTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MESSAGETRLINSTANCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADTABTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADMONTHTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_GREETINGTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPETRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_UOMTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADMESSAGETRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADPROCESSPARAMETERTRLLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADALERTRULETRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_USERPOSITIONTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADWINDOWTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADWORKFLOWTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LINEOFBUSINESSTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADFIELDTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADMENUTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADFIELDGROUPTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ELEMENTTRLINSTANCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_USERDEPARTMENTTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADTEXTINTERFACETRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADELEMENTTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FIELDTRLINSTANCELIST, new ArrayList<Object>());
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

    public String getLanguage() {
        return (String) get(PROPERTY_LANGUAGE);
    }

    public void setLanguage(String language) {
        set(PROPERTY_LANGUAGE, language);
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

    public String getLanguageISO() {
        return (String) get(PROPERTY_LANGUAGEISO);
    }

    public void setLanguageISO(String languageISO) {
        set(PROPERTY_LANGUAGEISO, languageISO);
    }

    public String getCountryCode() {
        return (String) get(PROPERTY_COUNTRYCODE);
    }

    public void setCountryCode(String countryCode) {
        set(PROPERTY_COUNTRYCODE, countryCode);
    }

    public Boolean isBaseLanguage() {
        return (Boolean) get(PROPERTY_ISBASELANGUAGE);
    }

    public void setBaseLanguage(Boolean isBaseLanguage) {
        set(PROPERTY_ISBASELANGUAGE, isBaseLanguage);
    }

    public Boolean isSystemLanguage() {
        return (Boolean) get(PROPERTY_ISSYSTEMLANGUAGE);
    }

    public void setSystemLanguage(Boolean isSystemLanguage) {
        set(PROPERTY_ISSYSTEMLANGUAGE, isSystemLanguage);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Long getPixelsize() {
        return (Long) get(PROPERTY_PIXELSIZE);
    }

    public void setPixelsize(Long pixelsize) {
        set(PROPERTY_PIXELSIZE, pixelsize);
    }

    public String getTranslatedby() {
        return (String) get(PROPERTY_TRANSLATEDBY);
    }

    public void setTranslatedby(String translatedby) {
        set(PROPERTY_TRANSLATEDBY, translatedby);
    }

    public Boolean isRtl() {
        return (Boolean) get(PROPERTY_ISRTL);
    }

    public void setRtl(Boolean isrtl) {
        set(PROPERTY_ISRTL, isrtl);
    }

    @SuppressWarnings("unchecked")
    public List<WFNodeTrl> getADWFNodeTrlList() {
        return (List<WFNodeTrl>) get(PROPERTY_ADWFNODETRLLIST);
    }

    public void setADWFNodeTrlList(List<WFNodeTrl> aDWFNodeTrlList) {
        set(PROPERTY_ADWFNODETRLLIST, aDWFNodeTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<PaymentTermTrl> getFinancialMgmtPaymentTermTrlList() {
        return (List<PaymentTermTrl>) get(PROPERTY_FINANCIALMGMTPAYMENTTERMTRLLIST);
    }

    public void setFinancialMgmtPaymentTermTrlList(
        List<PaymentTermTrl> financialMgmtPaymentTermTrlList) {
        set(PROPERTY_FINANCIALMGMTPAYMENTTERMTRLLIST,
            financialMgmtPaymentTermTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<CountryTrl> getCountryTrlList() {
        return (List<CountryTrl>) get(PROPERTY_COUNTRYTRLLIST);
    }

    public void setCountryTrlList(List<CountryTrl> countryTrlList) {
        set(PROPERTY_COUNTRYTRLLIST, countryTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<TaskTrl> getADTaskTrlList() {
        return (List<TaskTrl>) get(PROPERTY_ADTASKTRLLIST);
    }

    public void setADTaskTrlList(List<TaskTrl> aDTaskTrlList) {
        set(PROPERTY_ADTASKTRLLIST, aDTaskTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<FormTrl> getADFormTrlList() {
        return (List<FormTrl>) get(PROPERTY_ADFORMTRLLIST);
    }

    public void setADFormTrlList(List<FormTrl> aDFormTrlList) {
        set(PROPERTY_ADFORMTRLLIST, aDFormTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<Ad_ref_listinstance_trl> getRefListinstanceTrlList() {
        return (List<Ad_ref_listinstance_trl>) get(PROPERTY_REFLISTINSTANCETRLLIST);
    }

    public void setRefListinstanceTrlList(
        List<Ad_ref_listinstance_trl> refListinstanceTrlList) {
        set(PROPERTY_REFLISTINSTANCETRLLIST, refListinstanceTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductTrl> getProductTrlList() {
        return (List<ProductTrl>) get(PROPERTY_PRODUCTTRLLIST);
    }

    public void setProductTrlList(List<ProductTrl> productTrlList) {
        set(PROPERTY_PRODUCTTRLLIST, productTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<ElementValueTrl> getFinancialMgmtElementValueTrlList() {
        return (List<ElementValueTrl>) get(PROPERTY_FINANCIALMGMTELEMENTVALUETRLLIST);
    }

    public void setFinancialMgmtElementValueTrlList(
        List<ElementValueTrl> financialMgmtElementValueTrlList) {
        set(PROPERTY_FINANCIALMGMTELEMENTVALUETRLLIST,
            financialMgmtElementValueTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<TaxTrl> getFinancialMgmtTaxTrlList() {
        return (List<TaxTrl>) get(PROPERTY_FINANCIALMGMTTAXTRLLIST);
    }

    public void setFinancialMgmtTaxTrlList(List<TaxTrl> financialMgmtTaxTrlList) {
        set(PROPERTY_FINANCIALMGMTTAXTRLLIST, financialMgmtTaxTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessTrl> getADProcessTrlList() {
        return (List<ProcessTrl>) get(PROPERTY_ADPROCESSTRLLIST);
    }

    public void setADProcessTrlList(List<ProcessTrl> aDProcessTrlList) {
        set(PROPERTY_ADPROCESSTRLLIST, aDProcessTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<TaxCategoryTrl> getFinancialMgmtTaxCategoryTrlList() {
        return (List<TaxCategoryTrl>) get(PROPERTY_FINANCIALMGMTTAXCATEGORYTRLLIST);
    }

    public void setFinancialMgmtTaxCategoryTrlList(
        List<TaxCategoryTrl> financialMgmtTaxCategoryTrlList) {
        set(PROPERTY_FINANCIALMGMTTAXCATEGORYTRLLIST,
            financialMgmtTaxCategoryTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<ListTrl> getADListTrlList() {
        return (List<ListTrl>) get(PROPERTY_ADLISTTRLLIST);
    }

    public void setADListTrlList(List<ListTrl> aDListTrlList) {
        set(PROPERTY_ADLISTTRLLIST, aDListTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<ReferenceTrl> getADReferenceTrlList() {
        return (List<ReferenceTrl>) get(PROPERTY_ADREFERENCETRLLIST);
    }

    public void setADReferenceTrlList(List<ReferenceTrl> aDReferenceTrlList) {
        set(PROPERTY_ADREFERENCETRLLIST, aDReferenceTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<CurrencyTrl> getCurrencyTrlList() {
        return (List<CurrencyTrl>) get(PROPERTY_CURRENCYTRLLIST);
    }

    public void setCurrencyTrlList(List<CurrencyTrl> currencyTrlList) {
        set(PROPERTY_CURRENCYTRLLIST, currencyTrlList);
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
    public List<TabTrl> getADTabTrlList() {
        return (List<TabTrl>) get(PROPERTY_ADTABTRLLIST);
    }

    public void setADTabTrlList(List<TabTrl> aDTabTrlList) {
        set(PROPERTY_ADTABTRLLIST, aDTabTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<ADMonthTrl> getADMonthTrlList() {
        return (List<ADMonthTrl>) get(PROPERTY_ADMONTHTRLLIST);
    }

    public void setADMonthTrlList(List<ADMonthTrl> aDMonthTrlList) {
        set(PROPERTY_ADMONTHTRLLIST, aDMonthTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<GreetingTrl> getGreetingTrlList() {
        return (List<GreetingTrl>) get(PROPERTY_GREETINGTRLLIST);
    }

    public void setGreetingTrlList(List<GreetingTrl> greetingTrlList) {
        set(PROPERTY_GREETINGTRLLIST, greetingTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentTypeTrl> getDocumentTypeTrlList() {
        return (List<DocumentTypeTrl>) get(PROPERTY_DOCUMENTTYPETRLLIST);
    }

    public void setDocumentTypeTrlList(
        List<DocumentTypeTrl> documentTypeTrlList) {
        set(PROPERTY_DOCUMENTTYPETRLLIST, documentTypeTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<UOMTrl> getUOMTrlList() {
        return (List<UOMTrl>) get(PROPERTY_UOMTRLLIST);
    }

    public void setUOMTrlList(List<UOMTrl> uOMTrlList) {
        set(PROPERTY_UOMTRLLIST, uOMTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<MessageTrl> getADMessageTrlList() {
        return (List<MessageTrl>) get(PROPERTY_ADMESSAGETRLLIST);
    }

    public void setADMessageTrlList(List<MessageTrl> aDMessageTrlList) {
        set(PROPERTY_ADMESSAGETRLLIST, aDMessageTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessParameterTrl> getADProcessParameterTrlList() {
        return (List<ProcessParameterTrl>) get(PROPERTY_ADPROCESSPARAMETERTRLLIST);
    }

    public void setADProcessParameterTrlList(
        List<ProcessParameterTrl> aDProcessParameterTrlList) {
        set(PROPERTY_ADPROCESSPARAMETERTRLLIST, aDProcessParameterTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<AlertRuleTrl> getADAlertRuleTrlList() {
        return (List<AlertRuleTrl>) get(PROPERTY_ADALERTRULETRLLIST);
    }

    public void setADAlertRuleTrlList(List<AlertRuleTrl> aDAlertRuleTrlList) {
        set(PROPERTY_ADALERTRULETRLLIST, aDAlertRuleTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<CUserPositiontrl> getUserPositionTrlList() {
        return (List<CUserPositiontrl>) get(PROPERTY_USERPOSITIONTRLLIST);
    }

    public void setUserPositionTrlList(
        List<CUserPositiontrl> userPositionTrlList) {
        set(PROPERTY_USERPOSITIONTRLLIST, userPositionTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<WindowTrl> getADWindowTrlList() {
        return (List<WindowTrl>) get(PROPERTY_ADWINDOWTRLLIST);
    }

    public void setADWindowTrlList(List<WindowTrl> aDWindowTrlList) {
        set(PROPERTY_ADWINDOWTRLLIST, aDWindowTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<WorkflowTrl> getADWorkflowTrlList() {
        return (List<WorkflowTrl>) get(PROPERTY_ADWORKFLOWTRLLIST);
    }

    public void setADWorkflowTrlList(List<WorkflowTrl> aDWorkflowTrlList) {
        set(PROPERTY_ADWORKFLOWTRLLIST, aDWorkflowTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.businesspartner.c_lineofbusiness_trl> getLineofbusinessTrlList() {
        return (List<org.openbravo.model.common.businesspartner.c_lineofbusiness_trl>) get(PROPERTY_LINEOFBUSINESSTRLLIST);
    }

    public void setLineofbusinessTrlList(
        List<org.openbravo.model.common.businesspartner.c_lineofbusiness_trl> lineofbusinessTrlList) {
        set(PROPERTY_LINEOFBUSINESSTRLLIST, lineofbusinessTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<FieldTrl> getADFieldTrlList() {
        return (List<FieldTrl>) get(PROPERTY_ADFIELDTRLLIST);
    }

    public void setADFieldTrlList(List<FieldTrl> aDFieldTrlList) {
        set(PROPERTY_ADFIELDTRLLIST, aDFieldTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<MenuTrl> getADMenuTrlList() {
        return (List<MenuTrl>) get(PROPERTY_ADMENUTRLLIST);
    }

    public void setADMenuTrlList(List<MenuTrl> aDMenuTrlList) {
        set(PROPERTY_ADMENUTRLLIST, aDMenuTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<FieldGroupTrl> getADFieldGroupTrlList() {
        return (List<FieldGroupTrl>) get(PROPERTY_ADFIELDGROUPTRLLIST);
    }

    public void setADFieldGroupTrlList(List<FieldGroupTrl> aDFieldGroupTrlList) {
        set(PROPERTY_ADFIELDGROUPTRLLIST, aDFieldGroupTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<Adelementtrlinstance> getElementTrlInstanceList() {
        return (List<Adelementtrlinstance>) get(PROPERTY_ELEMENTTRLINSTANCELIST);
    }

    public void setElementTrlInstanceList(
        List<Adelementtrlinstance> elementTrlInstanceList) {
        set(PROPERTY_ELEMENTTRLINSTANCELIST, elementTrlInstanceList);
    }

    @SuppressWarnings("unchecked")
    public List<CUserDepartmenttrl> getUserDepartmentTrlList() {
        return (List<CUserDepartmenttrl>) get(PROPERTY_USERDEPARTMENTTRLLIST);
    }

    public void setUserDepartmentTrlList(
        List<CUserDepartmenttrl> userDepartmentTrlList) {
        set(PROPERTY_USERDEPARTMENTTRLLIST, userDepartmentTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<TextInterfaceTrl> getADTextInterfaceTrlList() {
        return (List<TextInterfaceTrl>) get(PROPERTY_ADTEXTINTERFACETRLLIST);
    }

    public void setADTextInterfaceTrlList(
        List<TextInterfaceTrl> aDTextInterfaceTrlList) {
        set(PROPERTY_ADTEXTINTERFACETRLLIST, aDTextInterfaceTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<ElementTrl> getADElementTrlList() {
        return (List<ElementTrl>) get(PROPERTY_ADELEMENTTRLLIST);
    }

    public void setADElementTrlList(List<ElementTrl> aDElementTrlList) {
        set(PROPERTY_ADELEMENTTRLLIST, aDElementTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<Adfieldtrlinstance> getFieldTrlInstanceList() {
        return (List<Adfieldtrlinstance>) get(PROPERTY_FIELDTRLINSTANCELIST);
    }

    public void setFieldTrlInstanceList(
        List<Adfieldtrlinstance> fieldTrlInstanceList) {
        set(PROPERTY_FIELDTRLINSTANCELIST, fieldTrlInstanceList);
    }
}
