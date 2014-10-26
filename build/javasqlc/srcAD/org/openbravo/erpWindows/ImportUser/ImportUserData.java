//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ImportUser;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

/**
WAD Generated class
 */
class ImportUserData implements FieldProvider {
static Logger log4j = Logger.getLogger(ImportUserData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String isimported;
  public String iUserId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cBpartnerId;
  public String cGreetingId;
  public String firstname;
  public String lastname;
  public String name;
  public String enumber;
  public String birthday;
  public String title;
  public String email;
  public String phone;
  public String phone2;
  public String fax;
  public String description;
  public String comments;
  public String cBpartnerLocationId;
  public String username;
  public String password;
  public String emailuser;
  public String emailuserpw;
  public String supervisorId;
  public String lastresult;
  public String lastcontact;
  public String isactive;
  public String processing;
  public String adOrgtrxId;
  public String defaultAdRoleId;
  public String defaultAdLanguage;
  public String defaultAdClientId;
  public String defaultAdOrgId;
  public String defaultMWarehouseId;
  public String btnprocess;
  public String branche;
  public String land;
  public String kunde;
  public String klinikkunde;
  public String stippvisitenkunde;
  public String mailingzielgruppe;
  public String geschaeftsfuehrer;
  public String einkauf;
  public String marktforschung;
  public String marketing;
  public String blockbuster;
  public String emarketing;
  public String aussendienst;
  public String klinik;
  public String it;
  public String unternehmenskommunikation;
  public String medicaleducation;
  public String nis;
  public String medwissen;
  public String training;
  public String humanresources;
  public String veranstaltungsmanagement;
  public String geschaeftsentwicklung;
  public String presse;
  public String prominenter;
  public String kol;
  public String kooperation;
  public String schluesselkontakt;
  public String persoenlicherkontakt2008;
  public String persoenlicherkontakt2009;
  public String persoenlicherkontakt2010;
  public String persoenlicherkontakt2011;
  public String hobby;
  public String communityzugehoerigkeit;
  public String planung;
  public String positionfunktion;
  public String abteilungbereich;
  public String sachgebiet;
  public String language;
  public String adUserClient;
  public String adOrgClient;
  public String createdby;
  public String trBgcolor;
  public String totalCount;
  public String dateTimeFormat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdbyr"))
      return createdbyr;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updated_time_stamp") || fieldName.equals("updatedTimeStamp"))
      return updatedTimeStamp;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("updatedbyr"))
      return updatedbyr;
    else if (fieldName.equalsIgnoreCase("isimported"))
      return isimported;
    else if (fieldName.equalsIgnoreCase("i_user_id") || fieldName.equals("iUserId"))
      return iUserId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_greeting_id") || fieldName.equals("cGreetingId"))
      return cGreetingId;
    else if (fieldName.equalsIgnoreCase("firstname"))
      return firstname;
    else if (fieldName.equalsIgnoreCase("lastname"))
      return lastname;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("enumber"))
      return enumber;
    else if (fieldName.equalsIgnoreCase("birthday"))
      return birthday;
    else if (fieldName.equalsIgnoreCase("title"))
      return title;
    else if (fieldName.equalsIgnoreCase("email"))
      return email;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("phone2"))
      return phone2;
    else if (fieldName.equalsIgnoreCase("fax"))
      return fax;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("comments"))
      return comments;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("username"))
      return username;
    else if (fieldName.equalsIgnoreCase("password"))
      return password;
    else if (fieldName.equalsIgnoreCase("emailuser"))
      return emailuser;
    else if (fieldName.equalsIgnoreCase("emailuserpw"))
      return emailuserpw;
    else if (fieldName.equalsIgnoreCase("supervisor_id") || fieldName.equals("supervisorId"))
      return supervisorId;
    else if (fieldName.equalsIgnoreCase("lastresult"))
      return lastresult;
    else if (fieldName.equalsIgnoreCase("lastcontact"))
      return lastcontact;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("default_ad_role_id") || fieldName.equals("defaultAdRoleId"))
      return defaultAdRoleId;
    else if (fieldName.equalsIgnoreCase("default_ad_language") || fieldName.equals("defaultAdLanguage"))
      return defaultAdLanguage;
    else if (fieldName.equalsIgnoreCase("default_ad_client_id") || fieldName.equals("defaultAdClientId"))
      return defaultAdClientId;
    else if (fieldName.equalsIgnoreCase("default_ad_org_id") || fieldName.equals("defaultAdOrgId"))
      return defaultAdOrgId;
    else if (fieldName.equalsIgnoreCase("default_m_warehouse_id") || fieldName.equals("defaultMWarehouseId"))
      return defaultMWarehouseId;
    else if (fieldName.equalsIgnoreCase("btnprocess"))
      return btnprocess;
    else if (fieldName.equalsIgnoreCase("branche"))
      return branche;
    else if (fieldName.equalsIgnoreCase("land"))
      return land;
    else if (fieldName.equalsIgnoreCase("kunde"))
      return kunde;
    else if (fieldName.equalsIgnoreCase("klinikkunde"))
      return klinikkunde;
    else if (fieldName.equalsIgnoreCase("stippvisitenkunde"))
      return stippvisitenkunde;
    else if (fieldName.equalsIgnoreCase("mailingzielgruppe"))
      return mailingzielgruppe;
    else if (fieldName.equalsIgnoreCase("geschaeftsfuehrer"))
      return geschaeftsfuehrer;
    else if (fieldName.equalsIgnoreCase("einkauf"))
      return einkauf;
    else if (fieldName.equalsIgnoreCase("marktforschung"))
      return marktforschung;
    else if (fieldName.equalsIgnoreCase("marketing"))
      return marketing;
    else if (fieldName.equalsIgnoreCase("blockbuster"))
      return blockbuster;
    else if (fieldName.equalsIgnoreCase("emarketing"))
      return emarketing;
    else if (fieldName.equalsIgnoreCase("aussendienst"))
      return aussendienst;
    else if (fieldName.equalsIgnoreCase("klinik"))
      return klinik;
    else if (fieldName.equalsIgnoreCase("it"))
      return it;
    else if (fieldName.equalsIgnoreCase("unternehmenskommunikation"))
      return unternehmenskommunikation;
    else if (fieldName.equalsIgnoreCase("medicaleducation"))
      return medicaleducation;
    else if (fieldName.equalsIgnoreCase("nis"))
      return nis;
    else if (fieldName.equalsIgnoreCase("medwissen"))
      return medwissen;
    else if (fieldName.equalsIgnoreCase("training"))
      return training;
    else if (fieldName.equalsIgnoreCase("humanresources"))
      return humanresources;
    else if (fieldName.equalsIgnoreCase("veranstaltungsmanagement"))
      return veranstaltungsmanagement;
    else if (fieldName.equalsIgnoreCase("geschaeftsentwicklung"))
      return geschaeftsentwicklung;
    else if (fieldName.equalsIgnoreCase("presse"))
      return presse;
    else if (fieldName.equalsIgnoreCase("prominenter"))
      return prominenter;
    else if (fieldName.equalsIgnoreCase("kol"))
      return kol;
    else if (fieldName.equalsIgnoreCase("kooperation"))
      return kooperation;
    else if (fieldName.equalsIgnoreCase("schluesselkontakt"))
      return schluesselkontakt;
    else if (fieldName.equalsIgnoreCase("persoenlicherkontakt2008"))
      return persoenlicherkontakt2008;
    else if (fieldName.equalsIgnoreCase("persoenlicherkontakt2009"))
      return persoenlicherkontakt2009;
    else if (fieldName.equalsIgnoreCase("persoenlicherkontakt2010"))
      return persoenlicherkontakt2010;
    else if (fieldName.equalsIgnoreCase("persoenlicherkontakt2011"))
      return persoenlicherkontakt2011;
    else if (fieldName.equalsIgnoreCase("hobby"))
      return hobby;
    else if (fieldName.equalsIgnoreCase("communityzugehoerigkeit"))
      return communityzugehoerigkeit;
    else if (fieldName.equalsIgnoreCase("planung"))
      return planung;
    else if (fieldName.equalsIgnoreCase("positionfunktion"))
      return positionfunktion;
    else if (fieldName.equalsIgnoreCase("abteilungbereich"))
      return abteilungbereich;
    else if (fieldName.equalsIgnoreCase("sachgebiet"))
      return sachgebiet;
    else if (fieldName.equalsIgnoreCase("language"))
      return language;
    else if (fieldName.equals("adUserClient"))
      return adUserClient;
    else if (fieldName.equals("adOrgClient"))
      return adOrgClient;
    else if (fieldName.equals("createdby"))
      return createdby;
    else if (fieldName.equals("trBgcolor"))
      return trBgcolor;
    else if (fieldName.equals("totalCount"))
      return totalCount;
    else if (fieldName.equals("dateTimeFormat"))
      return dateTimeFormat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for edit
 */
  public static ImportUserData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ImportUserData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(I_User.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = I_User.CreatedBy) as CreatedByR, " +
      "        to_char(I_User.Updated, ?) as updated, " +
      "        to_char(I_User.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        I_User.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = I_User.UpdatedBy) as UpdatedByR," +
      "        COALESCE(I_User.Isimported, 'N') AS Isimported, " +
      "I_User.I_User_ID, " +
      "I_User.AD_Client_ID, " +
      "(CASE WHEN I_User.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "I_User.AD_Org_ID, " +
      "(CASE WHEN I_User.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "I_User.C_Bpartner_ID, " +
      "I_User.C_Greeting_ID, " +
      "I_User.Firstname, " +
      "I_User.Lastname, " +
      "I_User.Name, " +
      "I_User.Enumber, " +
      "I_User.Birthday, " +
      "I_User.Title, " +
      "I_User.Email, " +
      "I_User.Phone, " +
      "I_User.Phone2, " +
      "I_User.Fax, " +
      "I_User.Description, " +
      "I_User.Comments, " +
      "I_User.C_Bpartner_Location_ID, " +
      "I_User.Username, " +
      "I_User.Password, " +
      "I_User.Emailuser, " +
      "I_User.Emailuserpw, " +
      "I_User.Supervisor_ID, " +
      "I_User.Lastresult, " +
      "I_User.Lastcontact, " +
      "COALESCE(I_User.Isactive, 'N') AS Isactive, " +
      "COALESCE(I_User.Processing, 'N') AS Processing, " +
      "I_User.AD_Orgtrx_ID, " +
      "I_User.Default_Ad_Role_ID, " +
      "I_User.Default_Ad_Language, " +
      "I_User.Default_Ad_Client_ID, " +
      "I_User.Default_Ad_Org_ID, " +
      "I_User.Default_M_Warehouse_ID, " +
      "I_User.Btnprocess, " +
      "I_User.Branche, " +
      "I_User.Land, " +
      "I_User.Kunde, " +
      "I_User.Klinikkunde, " +
      "I_User.Stippvisitenkunde, " +
      "I_User.Mailingzielgruppe, " +
      "I_User.Geschaeftsfuehrer, " +
      "I_User.Einkauf, " +
      "I_User.Marktforschung, " +
      "I_User.Marketing, " +
      "I_User.Blockbuster, " +
      "I_User.Emarketing, " +
      "I_User.Aussendienst, " +
      "I_User.Klinik, " +
      "I_User.It, " +
      "I_User.Unternehmenskommunikation, " +
      "I_User.Medicaleducation, " +
      "I_User.Nis, " +
      "I_User.Medwissen, " +
      "I_User.Training, " +
      "I_User.Humanresources, " +
      "I_User.Veranstaltungsmanagement, " +
      "I_User.Geschaeftsentwicklung, " +
      "I_User.Presse, " +
      "I_User.Prominenter, " +
      "I_User.Kol, " +
      "I_User.Kooperation, " +
      "I_User.Schluesselkontakt, " +
      "I_User.Persoenlicherkontakt2008, " +
      "I_User.Persoenlicherkontakt2009, " +
      "I_User.Persoenlicherkontakt2010, " +
      "I_User.Persoenlicherkontakt2011, " +
      "I_User.Hobby, " +
      "I_User.Communityzugehoerigkeit, " +
      "I_User.Planung, " +
      "I_User.Positionfunktion, " +
      "I_User.Abteilungbereich, " +
      "I_User.Sachgebiet, " +
      "        ? AS LANGUAGE " +
      "        FROM I_User left join (select AD_Client_ID, Name from AD_Client) table1 on (I_User.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (I_User.AD_Org_ID = table2.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND I_User.I_User_ID = ? " +
      "        AND I_User.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND I_User.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        ImportUserData objectImportUserData = new ImportUserData();
        objectImportUserData.created = UtilSql.getValue(result, "created");
        objectImportUserData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectImportUserData.updated = UtilSql.getValue(result, "updated");
        objectImportUserData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectImportUserData.updatedby = UtilSql.getValue(result, "updatedby");
        objectImportUserData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectImportUserData.isimported = UtilSql.getValue(result, "isimported");
        objectImportUserData.iUserId = UtilSql.getValue(result, "i_user_id");
        objectImportUserData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectImportUserData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectImportUserData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectImportUserData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectImportUserData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectImportUserData.cGreetingId = UtilSql.getValue(result, "c_greeting_id");
        objectImportUserData.firstname = UtilSql.getValue(result, "firstname");
        objectImportUserData.lastname = UtilSql.getValue(result, "lastname");
        objectImportUserData.name = UtilSql.getValue(result, "name");
        objectImportUserData.enumber = UtilSql.getValue(result, "enumber");
        objectImportUserData.birthday = UtilSql.getDateValue(result, "birthday", "dd-MM-yyyy");
        objectImportUserData.title = UtilSql.getValue(result, "title");
        objectImportUserData.email = UtilSql.getValue(result, "email");
        objectImportUserData.phone = UtilSql.getValue(result, "phone");
        objectImportUserData.phone2 = UtilSql.getValue(result, "phone2");
        objectImportUserData.fax = UtilSql.getValue(result, "fax");
        objectImportUserData.description = UtilSql.getValue(result, "description");
        objectImportUserData.comments = UtilSql.getValue(result, "comments");
        objectImportUserData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectImportUserData.username = UtilSql.getValue(result, "username");
        objectImportUserData.password = UtilSql.getValue(result, "password");
        objectImportUserData.emailuser = UtilSql.getValue(result, "emailuser");
        objectImportUserData.emailuserpw = UtilSql.getValue(result, "emailuserpw");
        objectImportUserData.supervisorId = UtilSql.getValue(result, "supervisor_id");
        objectImportUserData.lastresult = UtilSql.getValue(result, "lastresult");
        objectImportUserData.lastcontact = UtilSql.getDateValue(result, "lastcontact", "dd-MM-yyyy");
        objectImportUserData.isactive = UtilSql.getValue(result, "isactive");
        objectImportUserData.processing = UtilSql.getValue(result, "processing");
        objectImportUserData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectImportUserData.defaultAdRoleId = UtilSql.getValue(result, "default_ad_role_id");
        objectImportUserData.defaultAdLanguage = UtilSql.getValue(result, "default_ad_language");
        objectImportUserData.defaultAdClientId = UtilSql.getValue(result, "default_ad_client_id");
        objectImportUserData.defaultAdOrgId = UtilSql.getValue(result, "default_ad_org_id");
        objectImportUserData.defaultMWarehouseId = UtilSql.getValue(result, "default_m_warehouse_id");
        objectImportUserData.btnprocess = UtilSql.getValue(result, "btnprocess");
        objectImportUserData.branche = UtilSql.getValue(result, "branche");
        objectImportUserData.land = UtilSql.getValue(result, "land");
        objectImportUserData.kunde = UtilSql.getValue(result, "kunde");
        objectImportUserData.klinikkunde = UtilSql.getValue(result, "klinikkunde");
        objectImportUserData.stippvisitenkunde = UtilSql.getValue(result, "stippvisitenkunde");
        objectImportUserData.mailingzielgruppe = UtilSql.getValue(result, "mailingzielgruppe");
        objectImportUserData.geschaeftsfuehrer = UtilSql.getValue(result, "geschaeftsfuehrer");
        objectImportUserData.einkauf = UtilSql.getValue(result, "einkauf");
        objectImportUserData.marktforschung = UtilSql.getValue(result, "marktforschung");
        objectImportUserData.marketing = UtilSql.getValue(result, "marketing");
        objectImportUserData.blockbuster = UtilSql.getValue(result, "blockbuster");
        objectImportUserData.emarketing = UtilSql.getValue(result, "emarketing");
        objectImportUserData.aussendienst = UtilSql.getValue(result, "aussendienst");
        objectImportUserData.klinik = UtilSql.getValue(result, "klinik");
        objectImportUserData.it = UtilSql.getValue(result, "it");
        objectImportUserData.unternehmenskommunikation = UtilSql.getValue(result, "unternehmenskommunikation");
        objectImportUserData.medicaleducation = UtilSql.getValue(result, "medicaleducation");
        objectImportUserData.nis = UtilSql.getValue(result, "nis");
        objectImportUserData.medwissen = UtilSql.getValue(result, "medwissen");
        objectImportUserData.training = UtilSql.getValue(result, "training");
        objectImportUserData.humanresources = UtilSql.getValue(result, "humanresources");
        objectImportUserData.veranstaltungsmanagement = UtilSql.getValue(result, "veranstaltungsmanagement");
        objectImportUserData.geschaeftsentwicklung = UtilSql.getValue(result, "geschaeftsentwicklung");
        objectImportUserData.presse = UtilSql.getValue(result, "presse");
        objectImportUserData.prominenter = UtilSql.getValue(result, "prominenter");
        objectImportUserData.kol = UtilSql.getValue(result, "kol");
        objectImportUserData.kooperation = UtilSql.getValue(result, "kooperation");
        objectImportUserData.schluesselkontakt = UtilSql.getValue(result, "schluesselkontakt");
        objectImportUserData.persoenlicherkontakt2008 = UtilSql.getValue(result, "persoenlicherkontakt2008");
        objectImportUserData.persoenlicherkontakt2009 = UtilSql.getValue(result, "persoenlicherkontakt2009");
        objectImportUserData.persoenlicherkontakt2010 = UtilSql.getValue(result, "persoenlicherkontakt2010");
        objectImportUserData.persoenlicherkontakt2011 = UtilSql.getValue(result, "persoenlicherkontakt2011");
        objectImportUserData.hobby = UtilSql.getValue(result, "hobby");
        objectImportUserData.communityzugehoerigkeit = UtilSql.getValue(result, "communityzugehoerigkeit");
        objectImportUserData.planung = UtilSql.getValue(result, "planung");
        objectImportUserData.positionfunktion = UtilSql.getValue(result, "positionfunktion");
        objectImportUserData.abteilungbereich = UtilSql.getValue(result, "abteilungbereich");
        objectImportUserData.sachgebiet = UtilSql.getValue(result, "sachgebiet");
        objectImportUserData.language = UtilSql.getValue(result, "language");
        objectImportUserData.adUserClient = "";
        objectImportUserData.adOrgClient = "";
        objectImportUserData.createdby = "";
        objectImportUserData.trBgcolor = "";
        objectImportUserData.totalCount = "";
        objectImportUserData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImportUserData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    ImportUserData objectImportUserData[] = new ImportUserData[vector.size()];
    vector.copyInto(objectImportUserData);
    return(objectImportUserData);
  }

/**
Create a registry
 */
  public static ImportUserData[] set(String isactive, String defaultAdOrgId, String klinik, String schluesselkontakt, String klinikkunde, String aussendienst, String abteilungbereich, String iUserId, String mailingzielgruppe, String title, String createdby, String createdbyr, String phone2, String persoenlicherkontakt2009, String stippvisitenkunde, String persoenlicherkontakt2010, String geschaeftsfuehrer, String username, String cBpartnerId, String kol, String processing, String blockbuster, String lastname, String emailuserpw, String persoenlicherkontakt2008, String training, String hobby, String defaultAdLanguage, String branche, String kunde, String prominenter, String name, String geschaeftsentwicklung, String firstname, String positionfunktion, String veranstaltungsmanagement, String presse, String persoenlicherkontakt2011, String password, String marktforschung, String einkauf, String adClientId, String birthday, String cGreetingId, String enumber, String humanresources, String btnprocess, String adOrgId, String fax, String adOrgtrxId, String defaultMWarehouseId, String supervisorId, String marketing, String emarketing, String email, String communityzugehoerigkeit, String phone, String medicaleducation, String nis, String description, String kooperation, String emailuser, String lastcontact, String unternehmenskommunikation, String sachgebiet, String medwissen, String lastresult, String defaultAdRoleId, String comments, String updatedby, String updatedbyr, String land, String cBpartnerLocationId, String planung, String isimported, String defaultAdClientId, String it)    throws ServletException {
    ImportUserData objectImportUserData[] = new ImportUserData[1];
    objectImportUserData[0] = new ImportUserData();
    objectImportUserData[0].created = "";
    objectImportUserData[0].createdbyr = createdbyr;
    objectImportUserData[0].updated = "";
    objectImportUserData[0].updatedTimeStamp = "";
    objectImportUserData[0].updatedby = updatedby;
    objectImportUserData[0].updatedbyr = updatedbyr;
    objectImportUserData[0].isimported = isimported;
    objectImportUserData[0].iUserId = iUserId;
    objectImportUserData[0].adClientId = adClientId;
    objectImportUserData[0].adClientIdr = "";
    objectImportUserData[0].adOrgId = adOrgId;
    objectImportUserData[0].adOrgIdr = "";
    objectImportUserData[0].cBpartnerId = cBpartnerId;
    objectImportUserData[0].cGreetingId = cGreetingId;
    objectImportUserData[0].firstname = firstname;
    objectImportUserData[0].lastname = lastname;
    objectImportUserData[0].name = name;
    objectImportUserData[0].enumber = enumber;
    objectImportUserData[0].birthday = birthday;
    objectImportUserData[0].title = title;
    objectImportUserData[0].email = email;
    objectImportUserData[0].phone = phone;
    objectImportUserData[0].phone2 = phone2;
    objectImportUserData[0].fax = fax;
    objectImportUserData[0].description = description;
    objectImportUserData[0].comments = comments;
    objectImportUserData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectImportUserData[0].username = username;
    objectImportUserData[0].password = password;
    objectImportUserData[0].emailuser = emailuser;
    objectImportUserData[0].emailuserpw = emailuserpw;
    objectImportUserData[0].supervisorId = supervisorId;
    objectImportUserData[0].lastresult = lastresult;
    objectImportUserData[0].lastcontact = lastcontact;
    objectImportUserData[0].isactive = isactive;
    objectImportUserData[0].processing = processing;
    objectImportUserData[0].adOrgtrxId = adOrgtrxId;
    objectImportUserData[0].defaultAdRoleId = defaultAdRoleId;
    objectImportUserData[0].defaultAdLanguage = defaultAdLanguage;
    objectImportUserData[0].defaultAdClientId = defaultAdClientId;
    objectImportUserData[0].defaultAdOrgId = defaultAdOrgId;
    objectImportUserData[0].defaultMWarehouseId = defaultMWarehouseId;
    objectImportUserData[0].btnprocess = btnprocess;
    objectImportUserData[0].branche = branche;
    objectImportUserData[0].land = land;
    objectImportUserData[0].kunde = kunde;
    objectImportUserData[0].klinikkunde = klinikkunde;
    objectImportUserData[0].stippvisitenkunde = stippvisitenkunde;
    objectImportUserData[0].mailingzielgruppe = mailingzielgruppe;
    objectImportUserData[0].geschaeftsfuehrer = geschaeftsfuehrer;
    objectImportUserData[0].einkauf = einkauf;
    objectImportUserData[0].marktforschung = marktforschung;
    objectImportUserData[0].marketing = marketing;
    objectImportUserData[0].blockbuster = blockbuster;
    objectImportUserData[0].emarketing = emarketing;
    objectImportUserData[0].aussendienst = aussendienst;
    objectImportUserData[0].klinik = klinik;
    objectImportUserData[0].it = it;
    objectImportUserData[0].unternehmenskommunikation = unternehmenskommunikation;
    objectImportUserData[0].medicaleducation = medicaleducation;
    objectImportUserData[0].nis = nis;
    objectImportUserData[0].medwissen = medwissen;
    objectImportUserData[0].training = training;
    objectImportUserData[0].humanresources = humanresources;
    objectImportUserData[0].veranstaltungsmanagement = veranstaltungsmanagement;
    objectImportUserData[0].geschaeftsentwicklung = geschaeftsentwicklung;
    objectImportUserData[0].presse = presse;
    objectImportUserData[0].prominenter = prominenter;
    objectImportUserData[0].kol = kol;
    objectImportUserData[0].kooperation = kooperation;
    objectImportUserData[0].schluesselkontakt = schluesselkontakt;
    objectImportUserData[0].persoenlicherkontakt2008 = persoenlicherkontakt2008;
    objectImportUserData[0].persoenlicherkontakt2009 = persoenlicherkontakt2009;
    objectImportUserData[0].persoenlicherkontakt2010 = persoenlicherkontakt2010;
    objectImportUserData[0].persoenlicherkontakt2011 = persoenlicherkontakt2011;
    objectImportUserData[0].hobby = hobby;
    objectImportUserData[0].communityzugehoerigkeit = communityzugehoerigkeit;
    objectImportUserData[0].planung = planung;
    objectImportUserData[0].positionfunktion = positionfunktion;
    objectImportUserData[0].abteilungbereich = abteilungbereich;
    objectImportUserData[0].sachgebiet = sachgebiet;
    objectImportUserData[0].language = "";
    return objectImportUserData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefEC8C46352F0449D8BA15D0B36FBD2FDB_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Createdby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "createdby");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDefDBB027282C944036A33DAD8488B6DD7B_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Updatedby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updatedby");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_User" +
      "        SET Isimported = (?) , I_User_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_Bpartner_ID = (?) , C_Greeting_ID = (?) , Firstname = (?) , Lastname = (?) , Name = (?) , Enumber = (?) , Birthday = TO_DATE(?) , Title = (?) , Email = (?) , Phone = (?) , Phone2 = (?) , Fax = (?) , Description = (?) , Comments = (?) , C_Bpartner_Location_ID = (?) , Username = (?) , Password = (?) , Emailuser = (?) , Emailuserpw = (?) , Supervisor_ID = (?) , Lastresult = (?) , Lastcontact = TO_DATE(?) , Isactive = (?) , Processing = (?) , AD_Orgtrx_ID = (?) , Default_Ad_Role_ID = (?) , Default_Ad_Language = (?) , Default_Ad_Client_ID = (?) , Default_Ad_Org_ID = (?) , Default_M_Warehouse_ID = (?) , Btnprocess = (?) , Branche = (?) , Land = (?) , Kunde = (?) , Klinikkunde = (?) , Stippvisitenkunde = (?) , Mailingzielgruppe = (?) , Geschaeftsfuehrer = (?) , Einkauf = (?) , Marktforschung = (?) , Marketing = (?) , Blockbuster = (?) , Emarketing = (?) , Aussendienst = (?) , Klinik = (?) , It = (?) , Unternehmenskommunikation = (?) , Medicaleducation = (?) , Nis = (?) , Medwissen = (?) , Training = (?) , Humanresources = (?) , Veranstaltungsmanagement = (?) , Geschaeftsentwicklung = (?) , Presse = (?) , Prominenter = (?) , Kol = (?) , Kooperation = (?) , Schluesselkontakt = (?) , Persoenlicherkontakt2008 = (?) , Persoenlicherkontakt2009 = (?) , Persoenlicherkontakt2010 = (?) , Persoenlicherkontakt2011 = (?) , Hobby = (?) , Communityzugehoerigkeit = (?) , Planung = (?) , Positionfunktion = (?) , Abteilungbereich = (?) , Sachgebiet = (?) , updated = now(), updatedby = ? " +
      "        WHERE I_User.I_User_ID = ? " +
      "        AND I_User.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND I_User.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isimported);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGreetingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, birthday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, title);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, comments);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, username);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, password);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emailuser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emailuserpw);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, supervisorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastresult);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastcontact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultMWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, btnprocess);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, branche);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, land);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, kunde);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, klinikkunde);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stippvisitenkunde);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mailingzielgruppe);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, geschaeftsfuehrer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, einkauf);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marktforschung);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marketing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, blockbuster);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emarketing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aussendienst);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, klinik);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, it);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unternehmenskommunikation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, medicaleducation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nis);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, medwissen);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, training);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, humanresources);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, veranstaltungsmanagement);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, geschaeftsentwicklung);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, presse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, prominenter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, kol);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, kooperation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schluesselkontakt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, persoenlicherkontakt2008);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, persoenlicherkontakt2009);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, persoenlicherkontakt2010);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, persoenlicherkontakt2011);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hobby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, communityzugehoerigkeit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planung);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, positionfunktion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, abteilungbereich);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sachgebiet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iUserId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO I_User " +
      "        (Isimported, I_User_ID, AD_Client_ID, AD_Org_ID, C_Bpartner_ID, C_Greeting_ID, Firstname, Lastname, Name, Enumber, Birthday, Title, Email, Phone, Phone2, Fax, Description, Comments, C_Bpartner_Location_ID, Username, Password, Emailuser, Emailuserpw, Supervisor_ID, Lastresult, Lastcontact, Isactive, Processing, AD_Orgtrx_ID, Default_Ad_Role_ID, Default_Ad_Language, Default_Ad_Client_ID, Default_Ad_Org_ID, Default_M_Warehouse_ID, Btnprocess, Branche, Land, Kunde, Klinikkunde, Stippvisitenkunde, Mailingzielgruppe, Geschaeftsfuehrer, Einkauf, Marktforschung, Marketing, Blockbuster, Emarketing, Aussendienst, Klinik, It, Unternehmenskommunikation, Medicaleducation, Nis, Medwissen, Training, Humanresources, Veranstaltungsmanagement, Geschaeftsentwicklung, Presse, Prominenter, Kol, Kooperation, Schluesselkontakt, Persoenlicherkontakt2008, Persoenlicherkontakt2009, Persoenlicherkontakt2010, Persoenlicherkontakt2011, Hobby, Communityzugehoerigkeit, Planung, Positionfunktion, Abteilungbereich, Sachgebiet, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isimported);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGreetingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, birthday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, title);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, comments);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, username);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, password);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emailuser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emailuserpw);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, supervisorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastresult);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastcontact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultMWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, btnprocess);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, branche);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, land);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, kunde);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, klinikkunde);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stippvisitenkunde);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mailingzielgruppe);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, geschaeftsfuehrer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, einkauf);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marktforschung);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marketing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, blockbuster);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emarketing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aussendienst);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, klinik);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, it);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unternehmenskommunikation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, medicaleducation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nis);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, medwissen);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, training);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, humanresources);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, veranstaltungsmanagement);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, geschaeftsentwicklung);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, presse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, prominenter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, kol);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, kooperation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schluesselkontakt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, persoenlicherkontakt2008);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, persoenlicherkontakt2009);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, persoenlicherkontakt2010);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, persoenlicherkontakt2011);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hobby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, communityzugehoerigkeit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planung);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, positionfunktion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, abteilungbereich);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sachgebiet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM I_User" +
      "        WHERE I_User.I_User_ID = ? " +
      "        AND I_User.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND I_User.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM I_User" +
      "        WHERE I_User.I_User_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

/**
Select for relation
 */
  public static String selectOrg(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID" +
      "          FROM I_User" +
      "         WHERE I_User.I_User_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String getCurrentDBTimestamp(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp" +
      "          FROM I_User" +
      "         WHERE I_User.I_User_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updated_time_stamp");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }
}
