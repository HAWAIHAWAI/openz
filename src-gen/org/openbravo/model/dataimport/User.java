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
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity DataImportUser (stored in table I_User).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class User extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "I_User";
    public static final String ENTITY_NAME = "DataImportUser";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PASSWORD = "password";
    public static final String PROPERTY_EMAIL = "email";
    public static final String PROPERTY_SUPERVISOR = "supervisor";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_EMAILUSER = "emailuser";
    public static final String PROPERTY_EMAILUSERPW = "emailuserpw";
    public static final String PROPERTY_BPARTNERLOCATION = "bpartnerLocation";
    public static final String PROPERTY_GREETING = "greeting";
    public static final String PROPERTY_TITLE = "title";
    public static final String PROPERTY_COMMENTS = "comments";
    public static final String PROPERTY_PHONE = "phone";
    public static final String PROPERTY_PHONE2 = "phone2";
    public static final String PROPERTY_FAX = "fax";
    public static final String PROPERTY_LASTCONTACT = "lastcontact";
    public static final String PROPERTY_LASTRESULT = "lastresult";
    public static final String PROPERTY_BIRTHDAY = "birthday";
    public static final String PROPERTY_ORGTRX = "orgtrx";
    public static final String PROPERTY_FIRSTNAME = "firstname";
    public static final String PROPERTY_LASTNAME = "lastname";
    public static final String PROPERTY_USERNAME = "username";
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
    public static final String PROPERTY_ISIMPORTED = "isimported";
    public static final String PROPERTY_BTNPROCESS = "btnprocess";

    public User() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_ISIMPORTED, false);
        setDefaultValue(PROPERTY_BTNPROCESS, false);
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

    public org.openbravo.model.ad.access.User getCreatedBy() {
        return (org.openbravo.model.ad.access.User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(org.openbravo.model.ad.access.User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public org.openbravo.model.ad.access.User getUpdatedBy() {
        return (org.openbravo.model.ad.access.User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(org.openbravo.model.ad.access.User updatedBy) {
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

    public String getSupervisor() {
        return (String) get(PROPERTY_SUPERVISOR);
    }

    public void setSupervisor(String supervisor) {
        set(PROPERTY_SUPERVISOR, supervisor);
    }

    public String getBpartner() {
        return (String) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(String bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public String getEmailuser() {
        return (String) get(PROPERTY_EMAILUSER);
    }

    public void setEmailuser(String emailuser) {
        set(PROPERTY_EMAILUSER, emailuser);
    }

    public String getEmailuserpw() {
        return (String) get(PROPERTY_EMAILUSERPW);
    }

    public void setEmailuserpw(String emailuserpw) {
        set(PROPERTY_EMAILUSERPW, emailuserpw);
    }

    public String getBpartnerLocation() {
        return (String) get(PROPERTY_BPARTNERLOCATION);
    }

    public void setBpartnerLocation(String bpartnerLocation) {
        set(PROPERTY_BPARTNERLOCATION, bpartnerLocation);
    }

    public String getGreeting() {
        return (String) get(PROPERTY_GREETING);
    }

    public void setGreeting(String greeting) {
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

    public Date getLastcontact() {
        return (Date) get(PROPERTY_LASTCONTACT);
    }

    public void setLastcontact(Date lastcontact) {
        set(PROPERTY_LASTCONTACT, lastcontact);
    }

    public String getLastresult() {
        return (String) get(PROPERTY_LASTRESULT);
    }

    public void setLastresult(String lastresult) {
        set(PROPERTY_LASTRESULT, lastresult);
    }

    public Date getBirthday() {
        return (Date) get(PROPERTY_BIRTHDAY);
    }

    public void setBirthday(Date birthday) {
        set(PROPERTY_BIRTHDAY, birthday);
    }

    public String getOrgtrx() {
        return (String) get(PROPERTY_ORGTRX);
    }

    public void setOrgtrx(String orgtrx) {
        set(PROPERTY_ORGTRX, orgtrx);
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

    public String getUsername() {
        return (String) get(PROPERTY_USERNAME);
    }

    public void setUsername(String username) {
        set(PROPERTY_USERNAME, username);
    }

    public String getDefaultAdClient() {
        return (String) get(PROPERTY_DEFAULTADCLIENT);
    }

    public void setDefaultAdClient(String defaultAdClient) {
        set(PROPERTY_DEFAULTADCLIENT, defaultAdClient);
    }

    public String getDefaultAdLanguage() {
        return (String) get(PROPERTY_DEFAULTADLANGUAGE);
    }

    public void setDefaultAdLanguage(String defaultAdLanguage) {
        set(PROPERTY_DEFAULTADLANGUAGE, defaultAdLanguage);
    }

    public String getDefaultAdOrg() {
        return (String) get(PROPERTY_DEFAULTADORG);
    }

    public void setDefaultAdOrg(String defaultAdOrg) {
        set(PROPERTY_DEFAULTADORG, defaultAdOrg);
    }

    public String getDefaultAdRole() {
        return (String) get(PROPERTY_DEFAULTADROLE);
    }

    public void setDefaultAdRole(String defaultAdRole) {
        set(PROPERTY_DEFAULTADROLE, defaultAdRole);
    }

    public String getDefaultMWarehouse() {
        return (String) get(PROPERTY_DEFAULTMWAREHOUSE);
    }

    public void setDefaultMWarehouse(String defaultMWarehouse) {
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

    public Boolean isImported() {
        return (Boolean) get(PROPERTY_ISIMPORTED);
    }

    public void setImported(Boolean isimported) {
        set(PROPERTY_ISIMPORTED, isimported);
    }

    public Boolean isBtnprocess() {
        return (Boolean) get(PROPERTY_BTNPROCESS);
    }

    public void setBtnprocess(Boolean btnprocess) {
        set(PROPERTY_BTNPROCESS, btnprocess);
    }
}
