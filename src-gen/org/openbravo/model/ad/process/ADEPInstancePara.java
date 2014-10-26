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
package org.openbravo.model.ad.process;

import org.openbravo.base.structure.BaseOBObject;

import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity ADEPInstancePara (stored in table AD_EP_Instance_Para).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ADEPInstancePara extends BaseOBObject {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_EP_Instance_Para";
    public static final String ENTITY_NAME = "ADEPInstancePara";
    public static final String PROPERTY_EPINSTANCE = "epInstance";
    public static final String PROPERTY_EXTENSIONPOINTS = "extensionPoints";
    public static final String PROPERTY_PARAMETERNAME = "parametername";
    public static final String PROPERTY_STRING = "string";
    public static final String PROPERTY_STRINGTO = "stringTo";
    public static final String PROPERTY_NUMBER = "number";
    public static final String PROPERTY_NUMBERTO = "numberTo";
    public static final String PROPERTY_DATE = "date";
    public static final String PROPERTY_DATETO = "dateTo";
    public static final String PROPERTY_TEXT = "text";
    public static final String PROPERTY_ID = "id";

    public ADEPInstancePara() {
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getEpInstance() {
        return (String) get(PROPERTY_EPINSTANCE);
    }

    public void setEpInstance(String epInstance) {
        set(PROPERTY_EPINSTANCE, epInstance);
    }

    public ExtensionPoints getExtensionPoints() {
        return (ExtensionPoints) get(PROPERTY_EXTENSIONPOINTS);
    }

    public void setExtensionPoints(ExtensionPoints extensionPoints) {
        set(PROPERTY_EXTENSIONPOINTS, extensionPoints);
    }

    public String getParametername() {
        return (String) get(PROPERTY_PARAMETERNAME);
    }

    public void setParametername(String parametername) {
        set(PROPERTY_PARAMETERNAME, parametername);
    }

    public String getString() {
        return (String) get(PROPERTY_STRING);
    }

    public void setString(String string) {
        set(PROPERTY_STRING, string);
    }

    public String getStringTo() {
        return (String) get(PROPERTY_STRINGTO);
    }

    public void setStringTo(String stringTo) {
        set(PROPERTY_STRINGTO, stringTo);
    }

    public BigDecimal getNumber() {
        return (BigDecimal) get(PROPERTY_NUMBER);
    }

    public void setNumber(BigDecimal number) {
        set(PROPERTY_NUMBER, number);
    }

    public BigDecimal getNumberTo() {
        return (BigDecimal) get(PROPERTY_NUMBERTO);
    }

    public void setNumberTo(BigDecimal numberTo) {
        set(PROPERTY_NUMBERTO, numberTo);
    }

    public Date getDate() {
        return (Date) get(PROPERTY_DATE);
    }

    public void setDate(Date date) {
        set(PROPERTY_DATE, date);
    }

    public Date getDateTo() {
        return (Date) get(PROPERTY_DATETO);
    }

    public void setDateTo(Date dateTo) {
        set(PROPERTY_DATETO, dateTo);
    }

    public String getText() {
        return (String) get(PROPERTY_TEXT);
    }

    public void setText(String text) {
        set(PROPERTY_TEXT, text);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }
}
