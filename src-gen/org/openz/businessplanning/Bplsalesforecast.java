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
package org.openz.businessplanning;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity bpl_salesforecast (stored in table bpl_salesforecast).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Bplsalesforecast extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "bpl_salesforecast";
    public static final String ENTITY_NAME = "bpl_salesforecast";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SALESREP = "salesrep";
    public static final String PROPERTY_ESTPROPABILITY = "estpropability";
    public static final String PROPERTY_STARTDATE = "startdate";
    public static final String PROPERTY_LINENETAMT = "linenetamt";
    public static final String PROPERTY_ADJUSTEDSTARTDATE = "adjustedStartdate";
    public static final String PROPERTY_ADJUSTEDENDDATE = "adjustedEnddate";
    public static final String PROPERTY_ADJUSTEDAMT = "adjustedAmt";
    public static final String PROPERTY_INVOICEDAMTFIRSTQUARTER =
        "invoicedamtfirstquarter";
    public static final String PROPERTY_INVOICEDAMTSECONDQUARTER =
        "invoicedamtsecondquarter";
    public static final String PROPERTY_INVOICEDAMTTHIRDQUARTER =
        "invoicedamtthirdquarter";
    public static final String PROPERTY_INVOICEDAMTFOURTHQUARTER =
        "invoicedamtfourthquarter";
    public static final String PROPERTY_ORDEREDAMTFIRSTQUARTER =
        "orderedamtfirstquarter";
    public static final String PROPERTY_ORDEREDAMTSECONDQUARTER =
        "orderedamtsecondquarter";
    public static final String PROPERTY_ORDEREDAMTTHIRDQUARTER =
        "orderedamtthirdquarter";
    public static final String PROPERTY_ORDEREDAMTFOURTHQUARTER =
        "orderedamtfourthquarter";
    public static final String PROPERTY_OFFEREDAMTFIRSTQUARTER =
        "offeredamtfirstquarter";
    public static final String PROPERTY_OFFEREDAMTSECONDQUARTER =
        "offeredamtsecondquarter";
    public static final String PROPERTY_OFFEREDAMTTHIRDQUARTER =
        "offeredamtthirdquarter";
    public static final String PROPERTY_OFFEREDAMTFOURTHQUARTER =
        "offeredamtfourthquarter";
    public static final String PROPERTY_RATING = "rating";

    public Bplsalesforecast() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
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

    public void setActive(Boolean isactive) {
        set(PROPERTY_ISACTIVE, isactive);
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

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public User getSalesrep() {
        return (User) get(PROPERTY_SALESREP);
    }

    public void setSalesrep(User salesrep) {
        set(PROPERTY_SALESREP, salesrep);
    }

    public String getEstpropability() {
        return (String) get(PROPERTY_ESTPROPABILITY);
    }

    public void setEstpropability(String estpropability) {
        set(PROPERTY_ESTPROPABILITY, estpropability);
    }

    public Date getStartdate() {
        return (Date) get(PROPERTY_STARTDATE);
    }

    public void setStartdate(Date startdate) {
        set(PROPERTY_STARTDATE, startdate);
    }

    public BigDecimal getLinenetamt() {
        return (BigDecimal) get(PROPERTY_LINENETAMT);
    }

    public void setLinenetamt(BigDecimal linenetamt) {
        set(PROPERTY_LINENETAMT, linenetamt);
    }

    public Date getAdjustedStartdate() {
        return (Date) get(PROPERTY_ADJUSTEDSTARTDATE);
    }

    public void setAdjustedStartdate(Date adjustedStartdate) {
        set(PROPERTY_ADJUSTEDSTARTDATE, adjustedStartdate);
    }

    public Date getAdjustedEnddate() {
        return (Date) get(PROPERTY_ADJUSTEDENDDATE);
    }

    public void setAdjustedEnddate(Date adjustedEnddate) {
        set(PROPERTY_ADJUSTEDENDDATE, adjustedEnddate);
    }

    public BigDecimal getAdjustedAmt() {
        return (BigDecimal) get(PROPERTY_ADJUSTEDAMT);
    }

    public void setAdjustedAmt(BigDecimal adjustedAmt) {
        set(PROPERTY_ADJUSTEDAMT, adjustedAmt);
    }

    public BigDecimal getInvoicedamtfirstquarter() {
        return (BigDecimal) get(PROPERTY_INVOICEDAMTFIRSTQUARTER);
    }

    public void setInvoicedamtfirstquarter(BigDecimal invoicedamtfirstquarter) {
        set(PROPERTY_INVOICEDAMTFIRSTQUARTER, invoicedamtfirstquarter);
    }

    public BigDecimal getInvoicedamtsecondquarter() {
        return (BigDecimal) get(PROPERTY_INVOICEDAMTSECONDQUARTER);
    }

    public void setInvoicedamtsecondquarter(BigDecimal invoicedamtsecondquarter) {
        set(PROPERTY_INVOICEDAMTSECONDQUARTER, invoicedamtsecondquarter);
    }

    public BigDecimal getInvoicedamtthirdquarter() {
        return (BigDecimal) get(PROPERTY_INVOICEDAMTTHIRDQUARTER);
    }

    public void setInvoicedamtthirdquarter(BigDecimal invoicedamtthirdquarter) {
        set(PROPERTY_INVOICEDAMTTHIRDQUARTER, invoicedamtthirdquarter);
    }

    public BigDecimal getInvoicedamtfourthquarter() {
        return (BigDecimal) get(PROPERTY_INVOICEDAMTFOURTHQUARTER);
    }

    public void setInvoicedamtfourthquarter(BigDecimal invoicedamtfourthquarter) {
        set(PROPERTY_INVOICEDAMTFOURTHQUARTER, invoicedamtfourthquarter);
    }

    public BigDecimal getOrderedamtfirstquarter() {
        return (BigDecimal) get(PROPERTY_ORDEREDAMTFIRSTQUARTER);
    }

    public void setOrderedamtfirstquarter(BigDecimal orderedamtfirstquarter) {
        set(PROPERTY_ORDEREDAMTFIRSTQUARTER, orderedamtfirstquarter);
    }

    public BigDecimal getOrderedamtsecondquarter() {
        return (BigDecimal) get(PROPERTY_ORDEREDAMTSECONDQUARTER);
    }

    public void setOrderedamtsecondquarter(BigDecimal orderedamtsecondquarter) {
        set(PROPERTY_ORDEREDAMTSECONDQUARTER, orderedamtsecondquarter);
    }

    public BigDecimal getOrderedamtthirdquarter() {
        return (BigDecimal) get(PROPERTY_ORDEREDAMTTHIRDQUARTER);
    }

    public void setOrderedamtthirdquarter(BigDecimal orderedamtthirdquarter) {
        set(PROPERTY_ORDEREDAMTTHIRDQUARTER, orderedamtthirdquarter);
    }

    public BigDecimal getOrderedamtfourthquarter() {
        return (BigDecimal) get(PROPERTY_ORDEREDAMTFOURTHQUARTER);
    }

    public void setOrderedamtfourthquarter(BigDecimal orderedamtfourthquarter) {
        set(PROPERTY_ORDEREDAMTFOURTHQUARTER, orderedamtfourthquarter);
    }

    public BigDecimal getOfferedamtfirstquarter() {
        return (BigDecimal) get(PROPERTY_OFFEREDAMTFIRSTQUARTER);
    }

    public void setOfferedamtfirstquarter(BigDecimal offeredamtfirstquarter) {
        set(PROPERTY_OFFEREDAMTFIRSTQUARTER, offeredamtfirstquarter);
    }

    public BigDecimal getOfferedamtsecondquarter() {
        return (BigDecimal) get(PROPERTY_OFFEREDAMTSECONDQUARTER);
    }

    public void setOfferedamtsecondquarter(BigDecimal offeredamtsecondquarter) {
        set(PROPERTY_OFFEREDAMTSECONDQUARTER, offeredamtsecondquarter);
    }

    public BigDecimal getOfferedamtthirdquarter() {
        return (BigDecimal) get(PROPERTY_OFFEREDAMTTHIRDQUARTER);
    }

    public void setOfferedamtthirdquarter(BigDecimal offeredamtthirdquarter) {
        set(PROPERTY_OFFEREDAMTTHIRDQUARTER, offeredamtthirdquarter);
    }

    public BigDecimal getOfferedamtfourthquarter() {
        return (BigDecimal) get(PROPERTY_OFFEREDAMTFOURTHQUARTER);
    }

    public void setOfferedamtfourthquarter(BigDecimal offeredamtfourthquarter) {
        set(PROPERTY_OFFEREDAMTFOURTHQUARTER, offeredamtfourthquarter);
    }

    public String getRating() {
        return (String) get(PROPERTY_RATING);
    }

    public void setRating(String rating) {
        set(PROPERTY_RATING, rating);
    }
}
