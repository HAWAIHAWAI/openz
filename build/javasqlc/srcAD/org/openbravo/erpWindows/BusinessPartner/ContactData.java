//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.BusinessPartner;

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
class ContactData implements FieldProvider {
static Logger log4j = Logger.getLogger(ContactData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cGreetingId;
  public String cGreetingIdr;
  public String firstname;
  public String lastname;
  public String name;
  public String birthday;
  public String title;
  public String email;
  public String phone;
  public String phone2;
  public String fax;
  public String cUserPositionId;
  public String cUserPositionIdr;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String cUserDepartmentId;
  public String cUserDepartmentIdr;
  public String salesrepId;
  public String salesrepIdr;
  public String isactive;
  public String description;
  public String comments;
  public String lastcontact;
  public String lastresult;
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
  public String supervisorId;
  public String adOrgtrxId;
  public String adClientId;
  public String password;
  public String username;
  public String enumber;
  public String defaultAdClientId;
  public String defaultAdLanguage;
  public String defaultAdRoleId;
  public String defaultAdOrgId;
  public String defaultMWarehouseId;
  public String emailuser;
  public String emailuserpw;
  public String adOrgId;
  public String adUserId;
  public String processing;
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
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_greeting_id") || fieldName.equals("cGreetingId"))
      return cGreetingId;
    else if (fieldName.equalsIgnoreCase("c_greeting_idr") || fieldName.equals("cGreetingIdr"))
      return cGreetingIdr;
    else if (fieldName.equalsIgnoreCase("firstname"))
      return firstname;
    else if (fieldName.equalsIgnoreCase("lastname"))
      return lastname;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
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
    else if (fieldName.equalsIgnoreCase("c_user_position_id") || fieldName.equals("cUserPositionId"))
      return cUserPositionId;
    else if (fieldName.equalsIgnoreCase("c_user_position_idr") || fieldName.equals("cUserPositionIdr"))
      return cUserPositionIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("c_user_department_id") || fieldName.equals("cUserDepartmentId"))
      return cUserDepartmentId;
    else if (fieldName.equalsIgnoreCase("c_user_department_idr") || fieldName.equals("cUserDepartmentIdr"))
      return cUserDepartmentIdr;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("comments"))
      return comments;
    else if (fieldName.equalsIgnoreCase("lastcontact"))
      return lastcontact;
    else if (fieldName.equalsIgnoreCase("lastresult"))
      return lastresult;
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
    else if (fieldName.equalsIgnoreCase("supervisor_id") || fieldName.equals("supervisorId"))
      return supervisorId;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("password"))
      return password;
    else if (fieldName.equalsIgnoreCase("username"))
      return username;
    else if (fieldName.equalsIgnoreCase("enumber"))
      return enumber;
    else if (fieldName.equalsIgnoreCase("default_ad_client_id") || fieldName.equals("defaultAdClientId"))
      return defaultAdClientId;
    else if (fieldName.equalsIgnoreCase("default_ad_language") || fieldName.equals("defaultAdLanguage"))
      return defaultAdLanguage;
    else if (fieldName.equalsIgnoreCase("default_ad_role_id") || fieldName.equals("defaultAdRoleId"))
      return defaultAdRoleId;
    else if (fieldName.equalsIgnoreCase("default_ad_org_id") || fieldName.equals("defaultAdOrgId"))
      return defaultAdOrgId;
    else if (fieldName.equalsIgnoreCase("default_m_warehouse_id") || fieldName.equals("defaultMWarehouseId"))
      return defaultMWarehouseId;
    else if (fieldName.equalsIgnoreCase("emailuser"))
      return emailuser;
    else if (fieldName.equalsIgnoreCase("emailuserpw"))
      return emailuserpw;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
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
  public static ContactData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cBpartnerId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ContactData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_User.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_User.CreatedBy) as CreatedByR, " +
      "        to_char(AD_User.Updated, ?) as updated, " +
      "        to_char(AD_User.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_User.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_User.UpdatedBy) as UpdatedByR," +
      "        AD_User.C_BPartner_ID, " +
      "(CASE WHEN AD_User.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "AD_User.C_Greeting_ID, " +
      "(CASE WHEN AD_User.C_Greeting_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS C_Greeting_IDR, " +
      "AD_User.Firstname, " +
      "AD_User.Lastname, " +
      "AD_User.Name, " +
      "AD_User.Birthday, " +
      "AD_User.Title, " +
      "AD_User.Email, " +
      "AD_User.Phone, " +
      "AD_User.Phone2, " +
      "AD_User.Fax, " +
      "AD_User.C_User_Position_ID, " +
      "(CASE WHEN AD_User.C_User_Position_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_User_Position_IDR, " +
      "AD_User.C_BPartner_Location_ID, " +
      "(CASE WHEN AD_User.C_BPartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_BPartner_Location_IDR, " +
      "AD_User.C_User_Department_ID, " +
      "(CASE WHEN AD_User.C_User_Department_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS C_User_Department_IDR, " +
      "AD_User.Salesrep_ID, " +
      "(CASE WHEN AD_User.Salesrep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS Salesrep_IDR, " +
      "COALESCE(AD_User.IsActive, 'N') AS IsActive, " +
      "AD_User.Description, " +
      "AD_User.Comments, " +
      "AD_User.LastContact, " +
      "AD_User.LastResult, " +
      "AD_User.Branche, " +
      "AD_User.Land, " +
      "AD_User.Kunde, " +
      "AD_User.Klinikkunde, " +
      "AD_User.Stippvisitenkunde, " +
      "AD_User.Mailingzielgruppe, " +
      "AD_User.Geschaeftsfuehrer, " +
      "AD_User.Einkauf, " +
      "AD_User.Marktforschung, " +
      "AD_User.Marketing, " +
      "AD_User.Blockbuster, " +
      "AD_User.Emarketing, " +
      "AD_User.Aussendienst, " +
      "AD_User.Klinik, " +
      "AD_User.It, " +
      "AD_User.Unternehmenskommunikation, " +
      "AD_User.Medicaleducation, " +
      "AD_User.Nis, " +
      "AD_User.Medwissen, " +
      "AD_User.Training, " +
      "AD_User.Humanresources, " +
      "AD_User.Veranstaltungsmanagement, " +
      "AD_User.Geschaeftsentwicklung, " +
      "AD_User.Presse, " +
      "AD_User.Prominenter, " +
      "AD_User.Kol, " +
      "AD_User.Kooperation, " +
      "AD_User.Schluesselkontakt, " +
      "AD_User.Persoenlicherkontakt2008, " +
      "AD_User.Persoenlicherkontakt2009, " +
      "AD_User.Persoenlicherkontakt2010, " +
      "AD_User.Persoenlicherkontakt2011, " +
      "AD_User.Hobby, " +
      "AD_User.Communityzugehoerigkeit, " +
      "AD_User.Planung, " +
      "AD_User.Positionfunktion, " +
      "AD_User.Abteilungbereich, " +
      "AD_User.Sachgebiet, " +
      "AD_User.Supervisor_ID, " +
      "AD_User.AD_OrgTrx_ID, " +
      "AD_User.AD_Client_ID, " +
      "AD_User.Password, " +
      "AD_User.UserName, " +
      "AD_User.Enumber, " +
      "AD_User.Default_Ad_Client_ID, " +
      "AD_User.Default_Ad_Language, " +
      "AD_User.Default_Ad_Role_ID, " +
      "AD_User.Default_Ad_Org_ID, " +
      "AD_User.Default_M_Warehouse_ID, " +
      "AD_User.EmailUser, " +
      "AD_User.EmailUserPW, " +
      "AD_User.AD_Org_ID, " +
      "AD_User.AD_User_ID, " +
      "AD_User.Processing, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_User left join (select C_BPartner_ID, Name from C_BPartner) table1 on (AD_User.C_BPartner_ID = table1.C_BPartner_ID) left join (select C_Greeting_ID, Name from C_Greeting) table2 on (AD_User.C_Greeting_ID = table2.C_Greeting_ID) left join (select C_Greeting_ID,AD_Language, Name from C_Greeting_TRL) tableTRL2 on (table2.C_Greeting_ID = tableTRL2.C_Greeting_ID and tableTRL2.AD_Language = ?)  left join (select C_User_Position_ID, Name from C_User_Position) table3 on (AD_User.C_User_Position_ID = table3.C_User_Position_ID) left join (select C_User_Position_ID,AD_Language, Name from c_user_position_TRL) tableTRL3 on (table3.C_User_Position_ID = tableTRL3.C_User_Position_ID and tableTRL3.AD_Language = ?)  left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table4 on (AD_User.C_BPartner_Location_ID = table4.C_BPartner_Location_ID) left join (select C_User_Department_ID, Name from C_User_Department) table5 on (AD_User.C_User_Department_ID = table5.C_User_Department_ID) left join (select C_User_Department_ID,AD_Language, Name from C_User_Department_TRL) tableTRL5 on (table5.C_User_Department_ID = tableTRL5.C_User_Department_ID and tableTRL5.AD_Language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table6 on (AD_User.Salesrep_ID =  table6.C_BPartner_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND AD_User.C_BPartner_ID = ?  ");
    strSql = strSql + 
      "        AND AD_User.AD_User_ID = ? " +
      "        AND AD_User.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_User.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      }
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
        ContactData objectContactData = new ContactData();
        objectContactData.created = UtilSql.getValue(result, "created");
        objectContactData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectContactData.updated = UtilSql.getValue(result, "updated");
        objectContactData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectContactData.updatedby = UtilSql.getValue(result, "updatedby");
        objectContactData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectContactData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectContactData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectContactData.cGreetingId = UtilSql.getValue(result, "c_greeting_id");
        objectContactData.cGreetingIdr = UtilSql.getValue(result, "c_greeting_idr");
        objectContactData.firstname = UtilSql.getValue(result, "firstname");
        objectContactData.lastname = UtilSql.getValue(result, "lastname");
        objectContactData.name = UtilSql.getValue(result, "name");
        objectContactData.birthday = UtilSql.getDateValue(result, "birthday", "dd-MM-yyyy");
        objectContactData.title = UtilSql.getValue(result, "title");
        objectContactData.email = UtilSql.getValue(result, "email");
        objectContactData.phone = UtilSql.getValue(result, "phone");
        objectContactData.phone2 = UtilSql.getValue(result, "phone2");
        objectContactData.fax = UtilSql.getValue(result, "fax");
        objectContactData.cUserPositionId = UtilSql.getValue(result, "c_user_position_id");
        objectContactData.cUserPositionIdr = UtilSql.getValue(result, "c_user_position_idr");
        objectContactData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectContactData.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectContactData.cUserDepartmentId = UtilSql.getValue(result, "c_user_department_id");
        objectContactData.cUserDepartmentIdr = UtilSql.getValue(result, "c_user_department_idr");
        objectContactData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectContactData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectContactData.isactive = UtilSql.getValue(result, "isactive");
        objectContactData.description = UtilSql.getValue(result, "description");
        objectContactData.comments = UtilSql.getValue(result, "comments");
        objectContactData.lastcontact = UtilSql.getDateValue(result, "lastcontact", "dd-MM-yyyy");
        objectContactData.lastresult = UtilSql.getValue(result, "lastresult");
        objectContactData.branche = UtilSql.getValue(result, "branche");
        objectContactData.land = UtilSql.getValue(result, "land");
        objectContactData.kunde = UtilSql.getValue(result, "kunde");
        objectContactData.klinikkunde = UtilSql.getValue(result, "klinikkunde");
        objectContactData.stippvisitenkunde = UtilSql.getValue(result, "stippvisitenkunde");
        objectContactData.mailingzielgruppe = UtilSql.getValue(result, "mailingzielgruppe");
        objectContactData.geschaeftsfuehrer = UtilSql.getValue(result, "geschaeftsfuehrer");
        objectContactData.einkauf = UtilSql.getValue(result, "einkauf");
        objectContactData.marktforschung = UtilSql.getValue(result, "marktforschung");
        objectContactData.marketing = UtilSql.getValue(result, "marketing");
        objectContactData.blockbuster = UtilSql.getValue(result, "blockbuster");
        objectContactData.emarketing = UtilSql.getValue(result, "emarketing");
        objectContactData.aussendienst = UtilSql.getValue(result, "aussendienst");
        objectContactData.klinik = UtilSql.getValue(result, "klinik");
        objectContactData.it = UtilSql.getValue(result, "it");
        objectContactData.unternehmenskommunikation = UtilSql.getValue(result, "unternehmenskommunikation");
        objectContactData.medicaleducation = UtilSql.getValue(result, "medicaleducation");
        objectContactData.nis = UtilSql.getValue(result, "nis");
        objectContactData.medwissen = UtilSql.getValue(result, "medwissen");
        objectContactData.training = UtilSql.getValue(result, "training");
        objectContactData.humanresources = UtilSql.getValue(result, "humanresources");
        objectContactData.veranstaltungsmanagement = UtilSql.getValue(result, "veranstaltungsmanagement");
        objectContactData.geschaeftsentwicklung = UtilSql.getValue(result, "geschaeftsentwicklung");
        objectContactData.presse = UtilSql.getValue(result, "presse");
        objectContactData.prominenter = UtilSql.getValue(result, "prominenter");
        objectContactData.kol = UtilSql.getValue(result, "kol");
        objectContactData.kooperation = UtilSql.getValue(result, "kooperation");
        objectContactData.schluesselkontakt = UtilSql.getValue(result, "schluesselkontakt");
        objectContactData.persoenlicherkontakt2008 = UtilSql.getValue(result, "persoenlicherkontakt2008");
        objectContactData.persoenlicherkontakt2009 = UtilSql.getValue(result, "persoenlicherkontakt2009");
        objectContactData.persoenlicherkontakt2010 = UtilSql.getValue(result, "persoenlicherkontakt2010");
        objectContactData.persoenlicherkontakt2011 = UtilSql.getValue(result, "persoenlicherkontakt2011");
        objectContactData.hobby = UtilSql.getValue(result, "hobby");
        objectContactData.communityzugehoerigkeit = UtilSql.getValue(result, "communityzugehoerigkeit");
        objectContactData.planung = UtilSql.getValue(result, "planung");
        objectContactData.positionfunktion = UtilSql.getValue(result, "positionfunktion");
        objectContactData.abteilungbereich = UtilSql.getValue(result, "abteilungbereich");
        objectContactData.sachgebiet = UtilSql.getValue(result, "sachgebiet");
        objectContactData.supervisorId = UtilSql.getValue(result, "supervisor_id");
        objectContactData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectContactData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectContactData.password = UtilSql.getValue(result, "password");
        objectContactData.username = UtilSql.getValue(result, "username");
        objectContactData.enumber = UtilSql.getValue(result, "enumber");
        objectContactData.defaultAdClientId = UtilSql.getValue(result, "default_ad_client_id");
        objectContactData.defaultAdLanguage = UtilSql.getValue(result, "default_ad_language");
        objectContactData.defaultAdRoleId = UtilSql.getValue(result, "default_ad_role_id");
        objectContactData.defaultAdOrgId = UtilSql.getValue(result, "default_ad_org_id");
        objectContactData.defaultMWarehouseId = UtilSql.getValue(result, "default_m_warehouse_id");
        objectContactData.emailuser = UtilSql.getValue(result, "emailuser");
        objectContactData.emailuserpw = UtilSql.getValue(result, "emailuserpw");
        objectContactData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectContactData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectContactData.processing = UtilSql.getValue(result, "processing");
        objectContactData.language = UtilSql.getValue(result, "language");
        objectContactData.adUserClient = "";
        objectContactData.adOrgClient = "";
        objectContactData.createdby = "";
        objectContactData.trBgcolor = "";
        objectContactData.totalCount = "";
        objectContactData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectContactData);
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
    ContactData objectContactData[] = new ContactData[vector.size()];
    vector.copyInto(objectContactData);
    return(objectContactData);
  }

/**
Create a registry
 */
  public static ContactData[] set(String cBpartnerId, String stippvisitenkunde, String adOrgtrxId, String planung, String phone, String lastname, String emailuserpw, String emailuser, String emarketing, String marktforschung, String abteilungbereich, String medwissen, String klinikkunde, String cUserPositionId, String veranstaltungsmanagement, String schluesselkontakt, String enumber, String name, String fax, String defaultMWarehouseId, String communityzugehoerigkeit, String cGreetingId, String sachgebiet, String training, String persoenlicherkontakt2010, String adUserId, String birthday, String kunde, String persoenlicherkontakt2011, String defaultAdClientId, String mailingzielgruppe, String blockbuster, String geschaeftsentwicklung, String branche, String cBpartnerLocationId, String defaultAdOrgId, String description, String it, String createdby, String createdbyr, String firstname, String klinik, String presse, String unternehmenskommunikation, String persoenlicherkontakt2008, String medicaleducation, String isactive, String phone2, String supervisorId, String lastresult, String username, String aussendienst, String persoenlicherkontakt2009, String email, String processing, String adOrgId, String password, String title, String nis, String einkauf, String cUserDepartmentId, String prominenter, String lastcontact, String positionfunktion, String defaultAdRoleId, String defaultAdLanguage, String hobby, String geschaeftsfuehrer, String land, String adClientId, String comments, String marketing, String updatedby, String updatedbyr, String kol, String kooperation, String salesrepId, String humanresources)    throws ServletException {
    ContactData objectContactData[] = new ContactData[1];
    objectContactData[0] = new ContactData();
    objectContactData[0].created = "";
    objectContactData[0].createdbyr = createdbyr;
    objectContactData[0].updated = "";
    objectContactData[0].updatedTimeStamp = "";
    objectContactData[0].updatedby = updatedby;
    objectContactData[0].updatedbyr = updatedbyr;
    objectContactData[0].cBpartnerId = cBpartnerId;
    objectContactData[0].cBpartnerIdr = "";
    objectContactData[0].cGreetingId = cGreetingId;
    objectContactData[0].cGreetingIdr = "";
    objectContactData[0].firstname = firstname;
    objectContactData[0].lastname = lastname;
    objectContactData[0].name = name;
    objectContactData[0].birthday = birthday;
    objectContactData[0].title = title;
    objectContactData[0].email = email;
    objectContactData[0].phone = phone;
    objectContactData[0].phone2 = phone2;
    objectContactData[0].fax = fax;
    objectContactData[0].cUserPositionId = cUserPositionId;
    objectContactData[0].cUserPositionIdr = "";
    objectContactData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectContactData[0].cBpartnerLocationIdr = "";
    objectContactData[0].cUserDepartmentId = cUserDepartmentId;
    objectContactData[0].cUserDepartmentIdr = "";
    objectContactData[0].salesrepId = salesrepId;
    objectContactData[0].salesrepIdr = "";
    objectContactData[0].isactive = isactive;
    objectContactData[0].description = description;
    objectContactData[0].comments = comments;
    objectContactData[0].lastcontact = lastcontact;
    objectContactData[0].lastresult = lastresult;
    objectContactData[0].branche = branche;
    objectContactData[0].land = land;
    objectContactData[0].kunde = kunde;
    objectContactData[0].klinikkunde = klinikkunde;
    objectContactData[0].stippvisitenkunde = stippvisitenkunde;
    objectContactData[0].mailingzielgruppe = mailingzielgruppe;
    objectContactData[0].geschaeftsfuehrer = geschaeftsfuehrer;
    objectContactData[0].einkauf = einkauf;
    objectContactData[0].marktforschung = marktforschung;
    objectContactData[0].marketing = marketing;
    objectContactData[0].blockbuster = blockbuster;
    objectContactData[0].emarketing = emarketing;
    objectContactData[0].aussendienst = aussendienst;
    objectContactData[0].klinik = klinik;
    objectContactData[0].it = it;
    objectContactData[0].unternehmenskommunikation = unternehmenskommunikation;
    objectContactData[0].medicaleducation = medicaleducation;
    objectContactData[0].nis = nis;
    objectContactData[0].medwissen = medwissen;
    objectContactData[0].training = training;
    objectContactData[0].humanresources = humanresources;
    objectContactData[0].veranstaltungsmanagement = veranstaltungsmanagement;
    objectContactData[0].geschaeftsentwicklung = geschaeftsentwicklung;
    objectContactData[0].presse = presse;
    objectContactData[0].prominenter = prominenter;
    objectContactData[0].kol = kol;
    objectContactData[0].kooperation = kooperation;
    objectContactData[0].schluesselkontakt = schluesselkontakt;
    objectContactData[0].persoenlicherkontakt2008 = persoenlicherkontakt2008;
    objectContactData[0].persoenlicherkontakt2009 = persoenlicherkontakt2009;
    objectContactData[0].persoenlicherkontakt2010 = persoenlicherkontakt2010;
    objectContactData[0].persoenlicherkontakt2011 = persoenlicherkontakt2011;
    objectContactData[0].hobby = hobby;
    objectContactData[0].communityzugehoerigkeit = communityzugehoerigkeit;
    objectContactData[0].planung = planung;
    objectContactData[0].positionfunktion = positionfunktion;
    objectContactData[0].abteilungbereich = abteilungbereich;
    objectContactData[0].sachgebiet = sachgebiet;
    objectContactData[0].supervisorId = supervisorId;
    objectContactData[0].adOrgtrxId = adOrgtrxId;
    objectContactData[0].adClientId = adClientId;
    objectContactData[0].password = password;
    objectContactData[0].username = username;
    objectContactData[0].enumber = enumber;
    objectContactData[0].defaultAdClientId = defaultAdClientId;
    objectContactData[0].defaultAdLanguage = defaultAdLanguage;
    objectContactData[0].defaultAdRoleId = defaultAdRoleId;
    objectContactData[0].defaultAdOrgId = defaultAdOrgId;
    objectContactData[0].defaultMWarehouseId = defaultMWarehouseId;
    objectContactData[0].emailuser = emailuser;
    objectContactData[0].emailuserpw = emailuserpw;
    objectContactData[0].adOrgId = adOrgId;
    objectContactData[0].adUserId = adUserId;
    objectContactData[0].processing = processing;
    objectContactData[0].language = "";
    return objectContactData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef624_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as CreatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

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
  public static String selectDef626_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as UpdatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

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

/**
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_User.C_BPartner_ID AS NAME" +
      "        FROM AD_User" +
      "        WHERE AD_User.AD_User_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
Select for parent field
 */
  public static String selectParent(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BPartner left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BPartner.C_BPartner_ID = table1.C_BPartner_ID) WHERE C_BPartner.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
Select for parent field
 */
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BPartner left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BPartner.C_BPartner_ID = table1.C_BPartner_ID) WHERE C_BPartner.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
      "        UPDATE AD_User" +
      "        SET C_BPartner_ID = (?) , C_Greeting_ID = (?) , Firstname = (?) , Lastname = (?) , Name = (?) , Birthday = TO_DATE(?) , Title = (?) , Email = (?) , Phone = (?) , Phone2 = (?) , Fax = (?) , C_User_Position_ID = (?) , C_BPartner_Location_ID = (?) , C_User_Department_ID = (?) , Salesrep_ID = (?) , IsActive = (?) , Description = (?) , Comments = (?) , LastContact = TO_DATE(?) , LastResult = (?) , Branche = (?) , Land = (?) , Kunde = (?) , Klinikkunde = (?) , Stippvisitenkunde = (?) , Mailingzielgruppe = (?) , Geschaeftsfuehrer = (?) , Einkauf = (?) , Marktforschung = (?) , Marketing = (?) , Blockbuster = (?) , Emarketing = (?) , Aussendienst = (?) , Klinik = (?) , It = (?) , Unternehmenskommunikation = (?) , Medicaleducation = (?) , Nis = (?) , Medwissen = (?) , Training = (?) , Humanresources = (?) , Veranstaltungsmanagement = (?) , Geschaeftsentwicklung = (?) , Presse = (?) , Prominenter = (?) , Kol = (?) , Kooperation = (?) , Schluesselkontakt = (?) , Persoenlicherkontakt2008 = (?) , Persoenlicherkontakt2009 = (?) , Persoenlicherkontakt2010 = (?) , Persoenlicherkontakt2011 = (?) , Hobby = (?) , Communityzugehoerigkeit = (?) , Planung = (?) , Positionfunktion = (?) , Abteilungbereich = (?) , Sachgebiet = (?) , Supervisor_ID = (?) , AD_OrgTrx_ID = (?) , AD_Client_ID = (?) , UserName = (?) , Processing = (?) , Enumber = (?) , Default_Ad_Client_ID = (?) , Default_Ad_Language = (?) , Default_Ad_Role_ID = (?) , AD_User_ID = (?) , AD_Org_ID = (?) , EmailUser = (?) , Default_Ad_Org_ID = (?) , Default_M_Warehouse_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_User.AD_User_ID = ? " +
      "                 AND AD_User.C_BPartner_ID = ? " +
      "        AND AD_User.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_User.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGreetingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, birthday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, title);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, comments);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastcontact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastresult);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, supervisorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, username);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emailuser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultMWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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
      "        INSERT INTO AD_User " +
      "        (C_BPartner_ID, C_Greeting_ID, Firstname, Lastname, Name, Birthday, Title, Email, Phone, Phone2, Fax, C_User_Position_ID, C_BPartner_Location_ID, C_User_Department_ID, Salesrep_ID, IsActive, Description, Comments, LastContact, LastResult, Branche, Land, Kunde, Klinikkunde, Stippvisitenkunde, Mailingzielgruppe, Geschaeftsfuehrer, Einkauf, Marktforschung, Marketing, Blockbuster, Emarketing, Aussendienst, Klinik, It, Unternehmenskommunikation, Medicaleducation, Nis, Medwissen, Training, Humanresources, Veranstaltungsmanagement, Geschaeftsentwicklung, Presse, Prominenter, Kol, Kooperation, Schluesselkontakt, Persoenlicherkontakt2008, Persoenlicherkontakt2009, Persoenlicherkontakt2010, Persoenlicherkontakt2011, Hobby, Communityzugehoerigkeit, Planung, Positionfunktion, Abteilungbereich, Sachgebiet, Supervisor_ID, AD_OrgTrx_ID, AD_Client_ID, Password, UserName, Enumber, Default_Ad_Client_ID, Default_Ad_Language, Default_Ad_Role_ID, Default_Ad_Org_ID, Default_M_Warehouse_ID, EmailUser, EmailUserPW, AD_Org_ID, AD_User_ID, Processing, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGreetingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, birthday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, title);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, comments);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastcontact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastresult);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, supervisorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, password);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, username);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultMWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emailuser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emailuserpw);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cBpartnerId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_User" +
      "        WHERE AD_User.AD_User_ID = ? " +
      "                 AND AD_User.C_BPartner_ID = ? " +
      "        AND AD_User.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_User.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_User" +
      "        WHERE AD_User.AD_User_ID = ? " +
      "                 AND AD_User.C_BPartner_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
      "          FROM AD_User" +
      "         WHERE AD_User.AD_User_ID = ? ";

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
      "          FROM AD_User" +
      "         WHERE AD_User.AD_User_ID = ? ";

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
