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
package org.openbravo.model.ad.access;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.system.Language;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.CUserDepartment;
import org.openbravo.model.common.businesspartner.CUserPosition;
import org.openbravo.model.common.businesspartner.ContactInterest;
import org.openbravo.model.common.businesspartner.Greeting;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.zsoft.smartui.Notes4customer;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ADUser (stored in table AD_User).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class User extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_User";
    public static final String ENTITY_NAME = "ADUser";
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
    public static final String PROPERTY_PASSWORD = "password";
    public static final String PROPERTY_EMAIL = "email";
    public static final String PROPERTY_SUPERVISOR = "supervisor";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_EMAILUSER = "emailUser";
    public static final String PROPERTY_EMAILUSERPW = "emailUserPW";
    public static final String PROPERTY_BPARTNERLOCATION = "bPartnerLocation";
    public static final String PROPERTY_GREETING = "greeting";
    public static final String PROPERTY_TITLE = "title";
    public static final String PROPERTY_COMMENTS = "comments";
    public static final String PROPERTY_PHONE = "phone";
    public static final String PROPERTY_PHONE2 = "phone2";
    public static final String PROPERTY_FAX = "fax";
    public static final String PROPERTY_LASTCONTACT = "lastContact";
    public static final String PROPERTY_LASTRESULT = "lastResult";
    public static final String PROPERTY_BIRTHDAY = "birthday";
    public static final String PROPERTY_ORGTRX = "orgTrx";
    public static final String PROPERTY_FIRSTNAME = "firstname";
    public static final String PROPERTY_LASTNAME = "lastname";
    public static final String PROPERTY_USERNAME = "userName";
    public static final String PROPERTY_DEFAULTADCLIENT = "defaultAdClient";
    public static final String PROPERTY_DEFAULTADLANGUAGE = "defaultAdLanguage";
    public static final String PROPERTY_DEFAULTADORG = "defaultAdOrg";
    public static final String PROPERTY_DEFAULTADROLE = "defaultAdRole";
    public static final String PROPERTY_DEFAULTMWAREHOUSE = "defaultMWarehouse";
    public static final String PROPERTY_ENUMBER = "enumber";
    public static final String PROPERTY_BRANCHE = "branche";
    public static final String PROPERTY_LAND = "land";
    public static final String PROPERTY_KUNDE = "kunde";
    public static final String PROPERTY_KLINIKKUNDE = "klinikkunde";
    public static final String PROPERTY_STIPPVISITENKUNDE = "stippvisitenkunde";
    public static final String PROPERTY_MAILINGZIELGRUPPE = "mailingzielgruppe";
    public static final String PROPERTY_GESCHAEFTSFUEHRER = "geschaeftsfuehrer";
    public static final String PROPERTY_EINKAUF = "einkauf";
    public static final String PROPERTY_MARKTFORSCHUNG = "marktforschung";
    public static final String PROPERTY_MARKETING = "marketing";
    public static final String PROPERTY_BLOCKBUSTER = "blockbuster";
    public static final String PROPERTY_EMARKETING = "emarketing";
    public static final String PROPERTY_AUSSENDIENST = "aussendienst";
    public static final String PROPERTY_KLINIK = "klinik";
    public static final String PROPERTY_IT = "it";
    public static final String PROPERTY_UNTERNEHMENSKOMMUNIKATION =
        "unternehmenskommunikation";
    public static final String PROPERTY_MEDICALEDUCATION = "medicaleducation";
    public static final String PROPERTY_NIS = "nis";
    public static final String PROPERTY_MEDWISSEN = "medwissen";
    public static final String PROPERTY_TRAINING = "training";
    public static final String PROPERTY_HUMANRESOURCES = "humanresources";
    public static final String PROPERTY_VERANSTALTUNGSMANAGEMENT =
        "veranstaltungsmanagement";
    public static final String PROPERTY_GESCHAEFTSENTWICKLUNG =
        "geschaeftsentwicklung";
    public static final String PROPERTY_PRESSE = "presse";
    public static final String PROPERTY_PROMINENTER = "prominenter";
    public static final String PROPERTY_KOL = "kol";
    public static final String PROPERTY_KOOPERATION = "kooperation";
    public static final String PROPERTY_SCHLUESSELKONTAKT = "schluesselkontakt";
    public static final String PROPERTY_PERSOENLICHERKONTAKT2008 =
        "persoenlicherkontakt2008";
    public static final String PROPERTY_PERSOENLICHERKONTAKT2009 =
        "persoenlicherkontakt2009";
    public static final String PROPERTY_PERSOENLICHERKONTAKT2010 =
        "persoenlicherkontakt2010";
    public static final String PROPERTY_PERSOENLICHERKONTAKT2011 =
        "persoenlicherkontakt2011";
    public static final String PROPERTY_HOBBY = "hobby";
    public static final String PROPERTY_COMMUNITYZUGEHOERIGKEIT =
        "communityzugehoerigkeit";
    public static final String PROPERTY_PLANUNG = "planung";
    public static final String PROPERTY_POSITIONFUNKTION = "positionfunktion";
    public static final String PROPERTY_ABTEILUNGBEREICH = "abteilungbereich";
    public static final String PROPERTY_SACHGEBIET = "sachgebiet";
    public static final String PROPERTY_SALESREP = "salesrep";
    public static final String PROPERTY_USERPOSITION = "userPosition";
    public static final String PROPERTY_USERDEPARTMENT = "userDepartment";
    public static final String PROPERTY_NUMBER1 = "number1";
    public static final String PROPERTY_NUMBER2 = "number2";
    public static final String PROPERTY_NUMBER3 = "number3";
    public static final String PROPERTY_NUMBER4 = "number4";
    public static final String PROPERTY_NUMBER5 = "number5";
    public static final String PROPERTY_DATE1 = "date1";
    public static final String PROPERTY_DATE2 = "date2";
    public static final String PROPERTY_DATE3 = "date3";
    public static final String PROPERTY_DATE4 = "date4";
    public static final String PROPERTY_DATE5 = "date5";
    public static final String PROPERTY_COLOR = "color";
    public static final String PROPERTY_AUXTEXT1 = "auxtext1";
    public static final String PROPERTY_AUXTEXT2 = "auxtext2";
    public static final String PROPERTY_AUXTEXT3 = "auxtext3";
    public static final String PROPERTY_ADUSERROLESLIST = "aDUserRolesList";
    public static final String PROPERTY_ZSSINOTES4CUSTOMERLIST =
        "zssiNotes4customerList";
    public static final String PROPERTY_ZSSINOTES4CUSTOMERADUSERIDNEXTLIST =
        "zssiNotes4customerAdUseridNextList";
    public static final String PROPERTY_CONTACTINTERESTLIST =
        "contactInterestList";

    public User() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_ADUSERROLESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSSINOTES4CUSTOMERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSSINOTES4CUSTOMERADUSERIDNEXTLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_CONTACTINTERESTLIST, new ArrayList<Object>());
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

    public String getPassword() {
        return (String) get(PROPERTY_PASSWORD);
    }

    public void setPassword(String password) {
        set(PROPERTY_PASSWORD, password);
    }

    public String getEmail() {
        return (String) get(PROPERTY_EMAIL);
    }

    public void setEmail(String email) {
        set(PROPERTY_EMAIL, email);
    }

    public User getSupervisor() {
        return (User) get(PROPERTY_SUPERVISOR);
    }

    public void setSupervisor(User supervisor) {
        set(PROPERTY_SUPERVISOR, supervisor);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public String getEmailUser() {
        return (String) get(PROPERTY_EMAILUSER);
    }

    public void setEmailUser(String emailUser) {
        set(PROPERTY_EMAILUSER, emailUser);
    }

    public String getEmailUserPW() {
        return (String) get(PROPERTY_EMAILUSERPW);
    }

    public void setEmailUserPW(String emailUserPW) {
        set(PROPERTY_EMAILUSERPW, emailUserPW);
    }

    public Location getBPartnerLocation() {
        return (Location) get(PROPERTY_BPARTNERLOCATION);
    }

    public void setBPartnerLocation(Location bPartnerLocation) {
        set(PROPERTY_BPARTNERLOCATION, bPartnerLocation);
    }

    public Greeting getGreeting() {
        return (Greeting) get(PROPERTY_GREETING);
    }

    public void setGreeting(Greeting greeting) {
        set(PROPERTY_GREETING, greeting);
    }

    public String getTitle() {
        return (String) get(PROPERTY_TITLE);
    }

    public void setTitle(String title) {
        set(PROPERTY_TITLE, title);
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

    public Date getLastContact() {
        return (Date) get(PROPERTY_LASTCONTACT);
    }

    public void setLastContact(Date lastContact) {
        set(PROPERTY_LASTCONTACT, lastContact);
    }

    public String getLastResult() {
        return (String) get(PROPERTY_LASTRESULT);
    }

    public void setLastResult(String lastResult) {
        set(PROPERTY_LASTRESULT, lastResult);
    }

    public Date getBirthday() {
        return (Date) get(PROPERTY_BIRTHDAY);
    }

    public void setBirthday(Date birthday) {
        set(PROPERTY_BIRTHDAY, birthday);
    }

    public Organization getOrgTrx() {
        return (Organization) get(PROPERTY_ORGTRX);
    }

    public void setOrgTrx(Organization orgTrx) {
        set(PROPERTY_ORGTRX, orgTrx);
    }

    public String getFirstname() {
        return (String) get(PROPERTY_FIRSTNAME);
    }

    public void setFirstname(String firstname) {
        set(PROPERTY_FIRSTNAME, firstname);
    }

    public String getLastname() {
        return (String) get(PROPERTY_LASTNAME);
    }

    public void setLastname(String lastname) {
        set(PROPERTY_LASTNAME, lastname);
    }

    public String getUserName() {
        return (String) get(PROPERTY_USERNAME);
    }

    public void setUserName(String userName) {
        set(PROPERTY_USERNAME, userName);
    }

    public Client getDefaultAdClient() {
        return (Client) get(PROPERTY_DEFAULTADCLIENT);
    }

    public void setDefaultAdClient(Client defaultAdClient) {
        set(PROPERTY_DEFAULTADCLIENT, defaultAdClient);
    }

    public Language getDefaultAdLanguage() {
        return (Language) get(PROPERTY_DEFAULTADLANGUAGE);
    }

    public void setDefaultAdLanguage(Language defaultAdLanguage) {
        set(PROPERTY_DEFAULTADLANGUAGE, defaultAdLanguage);
    }

    public Organization getDefaultAdOrg() {
        return (Organization) get(PROPERTY_DEFAULTADORG);
    }

    public void setDefaultAdOrg(Organization defaultAdOrg) {
        set(PROPERTY_DEFAULTADORG, defaultAdOrg);
    }

    public Role getDefaultAdRole() {
        return (Role) get(PROPERTY_DEFAULTADROLE);
    }

    public void setDefaultAdRole(Role defaultAdRole) {
        set(PROPERTY_DEFAULTADROLE, defaultAdRole);
    }

    public Warehouse getDefaultMWarehouse() {
        return (Warehouse) get(PROPERTY_DEFAULTMWAREHOUSE);
    }

    public void setDefaultMWarehouse(Warehouse defaultMWarehouse) {
        set(PROPERTY_DEFAULTMWAREHOUSE, defaultMWarehouse);
    }

    public String getEnumber() {
        return (String) get(PROPERTY_ENUMBER);
    }

    public void setEnumber(String enumber) {
        set(PROPERTY_ENUMBER, enumber);
    }

    public String getBranche() {
        return (String) get(PROPERTY_BRANCHE);
    }

    public void setBranche(String branche) {
        set(PROPERTY_BRANCHE, branche);
    }

    public String getLand() {
        return (String) get(PROPERTY_LAND);
    }

    public void setLand(String land) {
        set(PROPERTY_LAND, land);
    }

    public String getKunde() {
        return (String) get(PROPERTY_KUNDE);
    }

    public void setKunde(String kunde) {
        set(PROPERTY_KUNDE, kunde);
    }

    public String getKlinikkunde() {
        return (String) get(PROPERTY_KLINIKKUNDE);
    }

    public void setKlinikkunde(String klinikkunde) {
        set(PROPERTY_KLINIKKUNDE, klinikkunde);
    }

    public String getStippvisitenkunde() {
        return (String) get(PROPERTY_STIPPVISITENKUNDE);
    }

    public void setStippvisitenkunde(String stippvisitenkunde) {
        set(PROPERTY_STIPPVISITENKUNDE, stippvisitenkunde);
    }

    public String getMailingzielgruppe() {
        return (String) get(PROPERTY_MAILINGZIELGRUPPE);
    }

    public void setMailingzielgruppe(String mailingzielgruppe) {
        set(PROPERTY_MAILINGZIELGRUPPE, mailingzielgruppe);
    }

    public String getGeschaeftsfuehrer() {
        return (String) get(PROPERTY_GESCHAEFTSFUEHRER);
    }

    public void setGeschaeftsfuehrer(String geschaeftsfuehrer) {
        set(PROPERTY_GESCHAEFTSFUEHRER, geschaeftsfuehrer);
    }

    public String getEinkauf() {
        return (String) get(PROPERTY_EINKAUF);
    }

    public void setEinkauf(String einkauf) {
        set(PROPERTY_EINKAUF, einkauf);
    }

    public String getMarktforschung() {
        return (String) get(PROPERTY_MARKTFORSCHUNG);
    }

    public void setMarktforschung(String marktforschung) {
        set(PROPERTY_MARKTFORSCHUNG, marktforschung);
    }

    public String getMarketing() {
        return (String) get(PROPERTY_MARKETING);
    }

    public void setMarketing(String marketing) {
        set(PROPERTY_MARKETING, marketing);
    }

    public String getBlockbuster() {
        return (String) get(PROPERTY_BLOCKBUSTER);
    }

    public void setBlockbuster(String blockbuster) {
        set(PROPERTY_BLOCKBUSTER, blockbuster);
    }

    public String getEmarketing() {
        return (String) get(PROPERTY_EMARKETING);
    }

    public void setEmarketing(String emarketing) {
        set(PROPERTY_EMARKETING, emarketing);
    }

    public String getAussendienst() {
        return (String) get(PROPERTY_AUSSENDIENST);
    }

    public void setAussendienst(String aussendienst) {
        set(PROPERTY_AUSSENDIENST, aussendienst);
    }

    public String getKlinik() {
        return (String) get(PROPERTY_KLINIK);
    }

    public void setKlinik(String klinik) {
        set(PROPERTY_KLINIK, klinik);
    }

    public String getIt() {
        return (String) get(PROPERTY_IT);
    }

    public void setIt(String it) {
        set(PROPERTY_IT, it);
    }

    public String getUnternehmenskommunikation() {
        return (String) get(PROPERTY_UNTERNEHMENSKOMMUNIKATION);
    }

    public void setUnternehmenskommunikation(String unternehmenskommunikation) {
        set(PROPERTY_UNTERNEHMENSKOMMUNIKATION, unternehmenskommunikation);
    }

    public String getMedicaleducation() {
        return (String) get(PROPERTY_MEDICALEDUCATION);
    }

    public void setMedicaleducation(String medicaleducation) {
        set(PROPERTY_MEDICALEDUCATION, medicaleducation);
    }

    public String getNis() {
        return (String) get(PROPERTY_NIS);
    }

    public void setNis(String nis) {
        set(PROPERTY_NIS, nis);
    }

    public String getMedwissen() {
        return (String) get(PROPERTY_MEDWISSEN);
    }

    public void setMedwissen(String medwissen) {
        set(PROPERTY_MEDWISSEN, medwissen);
    }

    public String getTraining() {
        return (String) get(PROPERTY_TRAINING);
    }

    public void setTraining(String training) {
        set(PROPERTY_TRAINING, training);
    }

    public String getHumanresources() {
        return (String) get(PROPERTY_HUMANRESOURCES);
    }

    public void setHumanresources(String humanresources) {
        set(PROPERTY_HUMANRESOURCES, humanresources);
    }

    public String getVeranstaltungsmanagement() {
        return (String) get(PROPERTY_VERANSTALTUNGSMANAGEMENT);
    }

    public void setVeranstaltungsmanagement(String veranstaltungsmanagement) {
        set(PROPERTY_VERANSTALTUNGSMANAGEMENT, veranstaltungsmanagement);
    }

    public String getGeschaeftsentwicklung() {
        return (String) get(PROPERTY_GESCHAEFTSENTWICKLUNG);
    }

    public void setGeschaeftsentwicklung(String geschaeftsentwicklung) {
        set(PROPERTY_GESCHAEFTSENTWICKLUNG, geschaeftsentwicklung);
    }

    public String getPresse() {
        return (String) get(PROPERTY_PRESSE);
    }

    public void setPresse(String presse) {
        set(PROPERTY_PRESSE, presse);
    }

    public String getProminenter() {
        return (String) get(PROPERTY_PROMINENTER);
    }

    public void setProminenter(String prominenter) {
        set(PROPERTY_PROMINENTER, prominenter);
    }

    public String getKol() {
        return (String) get(PROPERTY_KOL);
    }

    public void setKol(String kol) {
        set(PROPERTY_KOL, kol);
    }

    public String getKooperation() {
        return (String) get(PROPERTY_KOOPERATION);
    }

    public void setKooperation(String kooperation) {
        set(PROPERTY_KOOPERATION, kooperation);
    }

    public String getSchluesselkontakt() {
        return (String) get(PROPERTY_SCHLUESSELKONTAKT);
    }

    public void setSchluesselkontakt(String schluesselkontakt) {
        set(PROPERTY_SCHLUESSELKONTAKT, schluesselkontakt);
    }

    public String getPersoenlicherkontakt2008() {
        return (String) get(PROPERTY_PERSOENLICHERKONTAKT2008);
    }

    public void setPersoenlicherkontakt2008(String persoenlicherkontakt2008) {
        set(PROPERTY_PERSOENLICHERKONTAKT2008, persoenlicherkontakt2008);
    }

    public String getPersoenlicherkontakt2009() {
        return (String) get(PROPERTY_PERSOENLICHERKONTAKT2009);
    }

    public void setPersoenlicherkontakt2009(String persoenlicherkontakt2009) {
        set(PROPERTY_PERSOENLICHERKONTAKT2009, persoenlicherkontakt2009);
    }

    public String getPersoenlicherkontakt2010() {
        return (String) get(PROPERTY_PERSOENLICHERKONTAKT2010);
    }

    public void setPersoenlicherkontakt2010(String persoenlicherkontakt2010) {
        set(PROPERTY_PERSOENLICHERKONTAKT2010, persoenlicherkontakt2010);
    }

    public String getPersoenlicherkontakt2011() {
        return (String) get(PROPERTY_PERSOENLICHERKONTAKT2011);
    }

    public void setPersoenlicherkontakt2011(String persoenlicherkontakt2011) {
        set(PROPERTY_PERSOENLICHERKONTAKT2011, persoenlicherkontakt2011);
    }

    public String getHobby() {
        return (String) get(PROPERTY_HOBBY);
    }

    public void setHobby(String hobby) {
        set(PROPERTY_HOBBY, hobby);
    }

    public String getCommunityzugehoerigkeit() {
        return (String) get(PROPERTY_COMMUNITYZUGEHOERIGKEIT);
    }

    public void setCommunityzugehoerigkeit(String communityzugehoerigkeit) {
        set(PROPERTY_COMMUNITYZUGEHOERIGKEIT, communityzugehoerigkeit);
    }

    public String getPlanung() {
        return (String) get(PROPERTY_PLANUNG);
    }

    public void setPlanung(String planung) {
        set(PROPERTY_PLANUNG, planung);
    }

    public String getPositionfunktion() {
        return (String) get(PROPERTY_POSITIONFUNKTION);
    }

    public void setPositionfunktion(String positionfunktion) {
        set(PROPERTY_POSITIONFUNKTION, positionfunktion);
    }

    public String getAbteilungbereich() {
        return (String) get(PROPERTY_ABTEILUNGBEREICH);
    }

    public void setAbteilungbereich(String abteilungbereich) {
        set(PROPERTY_ABTEILUNGBEREICH, abteilungbereich);
    }

    public String getSachgebiet() {
        return (String) get(PROPERTY_SACHGEBIET);
    }

    public void setSachgebiet(String sachgebiet) {
        set(PROPERTY_SACHGEBIET, sachgebiet);
    }

    public BusinessPartner getSalesrep() {
        return (BusinessPartner) get(PROPERTY_SALESREP);
    }

    public void setSalesrep(BusinessPartner salesrep) {
        set(PROPERTY_SALESREP, salesrep);
    }

    public CUserPosition getUserPosition() {
        return (CUserPosition) get(PROPERTY_USERPOSITION);
    }

    public void setUserPosition(CUserPosition userPosition) {
        set(PROPERTY_USERPOSITION, userPosition);
    }

    public CUserDepartment getUserDepartment() {
        return (CUserDepartment) get(PROPERTY_USERDEPARTMENT);
    }

    public void setUserDepartment(CUserDepartment userDepartment) {
        set(PROPERTY_USERDEPARTMENT, userDepartment);
    }

    public Long getNumber1() {
        return (Long) get(PROPERTY_NUMBER1);
    }

    public void setNumber1(Long number1) {
        set(PROPERTY_NUMBER1, number1);
    }

    public BigDecimal getNumber2() {
        return (BigDecimal) get(PROPERTY_NUMBER2);
    }

    public void setNumber2(BigDecimal number2) {
        set(PROPERTY_NUMBER2, number2);
    }

    public BigDecimal getNumber3() {
        return (BigDecimal) get(PROPERTY_NUMBER3);
    }

    public void setNumber3(BigDecimal number3) {
        set(PROPERTY_NUMBER3, number3);
    }

    public BigDecimal getNumber4() {
        return (BigDecimal) get(PROPERTY_NUMBER4);
    }

    public void setNumber4(BigDecimal number4) {
        set(PROPERTY_NUMBER4, number4);
    }

    public BigDecimal getNumber5() {
        return (BigDecimal) get(PROPERTY_NUMBER5);
    }

    public void setNumber5(BigDecimal number5) {
        set(PROPERTY_NUMBER5, number5);
    }

    public Date getDate1() {
        return (Date) get(PROPERTY_DATE1);
    }

    public void setDate1(Date date1) {
        set(PROPERTY_DATE1, date1);
    }

    public Date getDate2() {
        return (Date) get(PROPERTY_DATE2);
    }

    public void setDate2(Date date2) {
        set(PROPERTY_DATE2, date2);
    }

    public Date getDate3() {
        return (Date) get(PROPERTY_DATE3);
    }

    public void setDate3(Date date3) {
        set(PROPERTY_DATE3, date3);
    }

    public Date getDate4() {
        return (Date) get(PROPERTY_DATE4);
    }

    public void setDate4(Date date4) {
        set(PROPERTY_DATE4, date4);
    }

    public Date getDate5() {
        return (Date) get(PROPERTY_DATE5);
    }

    public void setDate5(Date date5) {
        set(PROPERTY_DATE5, date5);
    }

    public org.openbravo.model.common.enterprise.c_color getColor() {
        return (org.openbravo.model.common.enterprise.c_color) get(PROPERTY_COLOR);
    }

    public void setColor(org.openbravo.model.common.enterprise.c_color color) {
        set(PROPERTY_COLOR, color);
    }

    public String getAuxtext1() {
        return (String) get(PROPERTY_AUXTEXT1);
    }

    public void setAuxtext1(String auxtext1) {
        set(PROPERTY_AUXTEXT1, auxtext1);
    }

    public String getAuxtext2() {
        return (String) get(PROPERTY_AUXTEXT2);
    }

    public void setAuxtext2(String auxtext2) {
        set(PROPERTY_AUXTEXT2, auxtext2);
    }

    public String getAuxtext3() {
        return (String) get(PROPERTY_AUXTEXT3);
    }

    public void setAuxtext3(String auxtext3) {
        set(PROPERTY_AUXTEXT3, auxtext3);
    }

    @SuppressWarnings("unchecked")
    public List<UserRoles> getADUserRolesList() {
        return (List<UserRoles>) get(PROPERTY_ADUSERROLESLIST);
    }

    public void setADUserRolesList(List<UserRoles> aDUserRolesList) {
        set(PROPERTY_ADUSERROLESLIST, aDUserRolesList);
    }

    @SuppressWarnings("unchecked")
    public List<Notes4customer> getZssiNotes4customerList() {
        return (List<Notes4customer>) get(PROPERTY_ZSSINOTES4CUSTOMERLIST);
    }

    public void setZssiNotes4customerList(
        List<Notes4customer> zssiNotes4customerList) {
        set(PROPERTY_ZSSINOTES4CUSTOMERLIST, zssiNotes4customerList);
    }

    @SuppressWarnings("unchecked")
    public List<Notes4customer> getZssiNotes4customerAdUseridNextList() {
        return (List<Notes4customer>) get(PROPERTY_ZSSINOTES4CUSTOMERADUSERIDNEXTLIST);
    }

    public void setZssiNotes4customerAdUseridNextList(
        List<Notes4customer> zssiNotes4customerAdUseridNextList) {
        set(PROPERTY_ZSSINOTES4CUSTOMERADUSERIDNEXTLIST,
            zssiNotes4customerAdUseridNextList);
    }

    @SuppressWarnings("unchecked")
    public List<ContactInterest> getContactInterestList() {
        return (List<ContactInterest>) get(PROPERTY_CONTACTINTERESTLIST);
    }

    public void setContactInterestList(
        List<ContactInterest> contactInterestList) {
        set(PROPERTY_CONTACTINTERESTLIST, contactInterestList);
    }
}
