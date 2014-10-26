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
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.Category;
import org.openbravo.model.common.businesspartner.Greeting;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Country;
import org.openbravo.model.common.geography.Region;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity DataImportBusinessPartner (stored in table I_BPartner).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class BusinessPartner extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "I_BPartner";
    public static final String ENTITY_NAME = "DataImportBusinessPartner";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_NAME2 = "name2";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DUNS = "dUNS";
    public static final String PROPERTY_TAXID = "taxID";
    public static final String PROPERTY_NAICS = "nAICS";
    public static final String PROPERTY_GROUPVALUE = "groupValue";
    public static final String PROPERTY_BPGROUP = "bPGroup";
    public static final String PROPERTY_BPARTNERLOCATION = "bPartnerLocation";
    public static final String PROPERTY_ADDRESS1 = "address1";
    public static final String PROPERTY_ADDRESS2 = "address2";
    public static final String PROPERTY_POSTAL = "postal";
    public static final String PROPERTY_POSTALADD = "postalAdd";
    public static final String PROPERTY_CITY = "city";
    public static final String PROPERTY_REGION = "region";
    public static final String PROPERTY_REGIONNAME = "regionName";
    public static final String PROPERTY_COUNTRY = "country";
    public static final String PROPERTY_COUNTRYCODE = "countryCode";
    public static final String PROPERTY_TITLE = "title";
    public static final String PROPERTY_CONTACTNAME = "contactName";
    public static final String PROPERTY_CONTACTDESCRIPTION =
        "contactDescription";
    public static final String PROPERTY_COMMENTS = "comments";
    public static final String PROPERTY_PHONE = "phone";
    public static final String PROPERTY_PHONE2 = "phone2";
    public static final String PROPERTY_FAX = "fax";
    public static final String PROPERTY_EMAIL = "email";
    public static final String PROPERTY_PASSWORD = "password";
    public static final String PROPERTY_BIRTHDAY = "birthday";
    public static final String PROPERTY_GREETING = "greeting";
    public static final String PROPERTY_BPCONTACTGREETING = "bPContactGreeting";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_ERRORMSG = "errorMsg";
    public static final String PROPERTY_ISIMPORTED = "isImported";
    public static final String PROPERTY_ISVENDOR = "isvendor";
    public static final String PROPERTY_ISCUSTOMER = "iscustomer";
    public static final String PROPERTY_ISSALESLEAD = "issaleslead";
    public static final String PROPERTY_EXTERNALSYNCCODE = "externalsynccode";
    public static final String PROPERTY_CUSTOMERPAYMENTTERMS =
        "customerpaymentterms";
    public static final String PROPERTY_TAXATADDRESS = "taxataddress";
    public static final String PROPERTY_ISHEADQUARTER = "isheadquarter";

    public BusinessPartner() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_ISIMPORTED, false);
        setDefaultValue(PROPERTY_ISVENDOR, false);
        setDefaultValue(PROPERTY_ISCUSTOMER, false);
        setDefaultValue(PROPERTY_ISSALESLEAD, false);
        setDefaultValue(PROPERTY_ISHEADQUARTER, false);
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

    public org.openbravo.model.common.businesspartner.BusinessPartner getBPartner() {
        return (org.openbravo.model.common.businesspartner.BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(
        org.openbravo.model.common.businesspartner.BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
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

    public String getName2() {
        return (String) get(PROPERTY_NAME2);
    }

    public void setName2(String name2) {
        set(PROPERTY_NAME2, name2);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getDUNS() {
        return (String) get(PROPERTY_DUNS);
    }

    public void setDUNS(String dUNS) {
        set(PROPERTY_DUNS, dUNS);
    }

    public String getTaxID() {
        return (String) get(PROPERTY_TAXID);
    }

    public void setTaxID(String taxID) {
        set(PROPERTY_TAXID, taxID);
    }

    public String getNAICS() {
        return (String) get(PROPERTY_NAICS);
    }

    public void setNAICS(String nAICS) {
        set(PROPERTY_NAICS, nAICS);
    }

    public String getGroupValue() {
        return (String) get(PROPERTY_GROUPVALUE);
    }

    public void setGroupValue(String groupValue) {
        set(PROPERTY_GROUPVALUE, groupValue);
    }

    public Category getBPGroup() {
        return (Category) get(PROPERTY_BPGROUP);
    }

    public void setBPGroup(Category bPGroup) {
        set(PROPERTY_BPGROUP, bPGroup);
    }

    public Location getBPartnerLocation() {
        return (Location) get(PROPERTY_BPARTNERLOCATION);
    }

    public void setBPartnerLocation(Location bPartnerLocation) {
        set(PROPERTY_BPARTNERLOCATION, bPartnerLocation);
    }

    public String getAddress1() {
        return (String) get(PROPERTY_ADDRESS1);
    }

    public void setAddress1(String address1) {
        set(PROPERTY_ADDRESS1, address1);
    }

    public String getAddress2() {
        return (String) get(PROPERTY_ADDRESS2);
    }

    public void setAddress2(String address2) {
        set(PROPERTY_ADDRESS2, address2);
    }

    public String getPostal() {
        return (String) get(PROPERTY_POSTAL);
    }

    public void setPostal(String postal) {
        set(PROPERTY_POSTAL, postal);
    }

    public String getPostalAdd() {
        return (String) get(PROPERTY_POSTALADD);
    }

    public void setPostalAdd(String postalAdd) {
        set(PROPERTY_POSTALADD, postalAdd);
    }

    public String getCity() {
        return (String) get(PROPERTY_CITY);
    }

    public void setCity(String city) {
        set(PROPERTY_CITY, city);
    }

    public Region getRegion() {
        return (Region) get(PROPERTY_REGION);
    }

    public void setRegion(Region region) {
        set(PROPERTY_REGION, region);
    }

    public String getRegionName() {
        return (String) get(PROPERTY_REGIONNAME);
    }

    public void setRegionName(String regionName) {
        set(PROPERTY_REGIONNAME, regionName);
    }

    public Country getCountry() {
        return (Country) get(PROPERTY_COUNTRY);
    }

    public void setCountry(Country country) {
        set(PROPERTY_COUNTRY, country);
    }

    public String getCountryCode() {
        return (String) get(PROPERTY_COUNTRYCODE);
    }

    public void setCountryCode(String countryCode) {
        set(PROPERTY_COUNTRYCODE, countryCode);
    }

    public String getTitle() {
        return (String) get(PROPERTY_TITLE);
    }

    public void setTitle(String title) {
        set(PROPERTY_TITLE, title);
    }

    public String getContactName() {
        return (String) get(PROPERTY_CONTACTNAME);
    }

    public void setContactName(String contactName) {
        set(PROPERTY_CONTACTNAME, contactName);
    }

    public String getContactDescription() {
        return (String) get(PROPERTY_CONTACTDESCRIPTION);
    }

    public void setContactDescription(String contactDescription) {
        set(PROPERTY_CONTACTDESCRIPTION, contactDescription);
    }

    public String getComments() {
        return (String) get(PROPERTY_COMMENTS);
    }

    public void setComments(String comments) {
        set(PROPERTY_COMMENTS, comments);
    }

    public String getPhone() {
        return (String) get(PROPERTY_PHONE);
    }

    public void setPhone(String phone) {
        set(PROPERTY_PHONE, phone);
    }

    public String getPhone2() {
        return (String) get(PROPERTY_PHONE2);
    }

    public void setPhone2(String phone2) {
        set(PROPERTY_PHONE2, phone2);
    }

    public String getFax() {
        return (String) get(PROPERTY_FAX);
    }

    public void setFax(String fax) {
        set(PROPERTY_FAX, fax);
    }

    public String getEmail() {
        return (String) get(PROPERTY_EMAIL);
    }

    public void setEmail(String email) {
        set(PROPERTY_EMAIL, email);
    }

    public String getPassword() {
        return (String) get(PROPERTY_PASSWORD);
    }

    public void setPassword(String password) {
        set(PROPERTY_PASSWORD, password);
    }

    public Date getBirthday() {
        return (Date) get(PROPERTY_BIRTHDAY);
    }

    public void setBirthday(Date birthday) {
        set(PROPERTY_BIRTHDAY, birthday);
    }

    public Greeting getGreeting() {
        return (Greeting) get(PROPERTY_GREETING);
    }

    public void setGreeting(Greeting greeting) {
        set(PROPERTY_GREETING, greeting);
    }

    public String getBPContactGreeting() {
        return (String) get(PROPERTY_BPCONTACTGREETING);
    }

    public void setBPContactGreeting(String bPContactGreeting) {
        set(PROPERTY_BPCONTACTGREETING, bPContactGreeting);
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

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
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

    public Boolean isVendor() {
        return (Boolean) get(PROPERTY_ISVENDOR);
    }

    public void setVendor(Boolean isvendor) {
        set(PROPERTY_ISVENDOR, isvendor);
    }

    public Boolean isCustomer() {
        return (Boolean) get(PROPERTY_ISCUSTOMER);
    }

    public void setCustomer(Boolean iscustomer) {
        set(PROPERTY_ISCUSTOMER, iscustomer);
    }

    public Boolean isSaleslead() {
        return (Boolean) get(PROPERTY_ISSALESLEAD);
    }

    public void setSaleslead(Boolean issaleslead) {
        set(PROPERTY_ISSALESLEAD, issaleslead);
    }

    public String getExternalsynccode() {
        return (String) get(PROPERTY_EXTERNALSYNCCODE);
    }

    public void setExternalsynccode(String externalsynccode) {
        set(PROPERTY_EXTERNALSYNCCODE, externalsynccode);
    }

    public String getCustomerpaymentterms() {
        return (String) get(PROPERTY_CUSTOMERPAYMENTTERMS);
    }

    public void setCustomerpaymentterms(String customerpaymentterms) {
        set(PROPERTY_CUSTOMERPAYMENTTERMS, customerpaymentterms);
    }

    public String getTaxataddress() {
        return (String) get(PROPERTY_TAXATADDRESS);
    }

    public void setTaxataddress(String taxataddress) {
        set(PROPERTY_TAXATADDRESS, taxataddress);
    }

    public Boolean isHeadquarter() {
        return (Boolean) get(PROPERTY_ISHEADQUARTER);
    }

    public void setHeadquarter(Boolean isheadquarter) {
        set(PROPERTY_ISHEADQUARTER, isheadquarter);
    }
}
