//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.Employee;

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
class PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data implements FieldProvider {
static Logger log4j = Logger.getLogger(PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cBpartnerLocationId;
  public String lastcontact;
  public String emailuserpw;
  public String processing;
  public String emailuser;
  public String lastresult;
  public String adOrgtrxId;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String firstname;
  public String cGreetingId;
  public String cGreetingIdr;
  public String lastname;
  public String title;
  public String username;
  public String name;
  public String defaultAdClientId;
  public String enumber;
  public String defaultAdOrgId;
  public String birthday;
  public String defaultAdLanguage;
  public String email;
  public String defaultAdRoleId;
  public String fax;
  public String defaultMWarehouseId;
  public String phone;
  public String phone2;
  public String description;
  public String comments;
  public String supervisorId;
  public String supervisorIdr;
  public String cColorId;
  public String cColorIdr;
  public String isactive;
  public String mailingzielgruppe;
  public String persoenlicherkontakt2010;
  public String date1;
  public String einkauf;
  public String persoenlicherkontakt2009;
  public String marktforschung;
  public String date4;
  public String communityzugehoerigkeit;
  public String kooperation;
  public String prominenter;
  public String emarketing;
  public String number5;
  public String it;
  public String blockbuster;
  public String unternehmenskommunikation;
  public String number4;
  public String nis;
  public String number3;
  public String number2;
  public String training;
  public String marketing;
  public String aussendienst;
  public String medwissen;
  public String klinikkunde;
  public String kunde;
  public String kol;
  public String persoenlicherkontakt2008;
  public String sachgebiet;
  public String presse;
  public String number1;
  public String stippvisitenkunde;
  public String branche;
  public String persoenlicherkontakt2011;
  public String geschaeftsentwicklung;
  public String hobby;
  public String veranstaltungsmanagement;
  public String schluesselkontakt;
  public String planung;
  public String land;
  public String positionfunktion;
  public String klinik;
  public String abteilungbereich;
  public String geschaeftsfuehrer;
  public String medicaleducation;
  public String humanresources;
  public String auxtext1;
  public String salesrepId;
  public String auxtext2;
  public String cUserPositionId;
  public String auxtext3;
  public String cUserDepartmentId;
  public String date2;
  public String date3;
  public String date5;
  public String adUserId;
  public String adClientId;
  public String password;
  public String adOrgId;
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
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("lastcontact"))
      return lastcontact;
    else if (fieldName.equalsIgnoreCase("emailuserpw"))
      return emailuserpw;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("emailuser"))
      return emailuser;
    else if (fieldName.equalsIgnoreCase("lastresult"))
      return lastresult;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("firstname"))
      return firstname;
    else if (fieldName.equalsIgnoreCase("c_greeting_id") || fieldName.equals("cGreetingId"))
      return cGreetingId;
    else if (fieldName.equalsIgnoreCase("c_greeting_idr") || fieldName.equals("cGreetingIdr"))
      return cGreetingIdr;
    else if (fieldName.equalsIgnoreCase("lastname"))
      return lastname;
    else if (fieldName.equalsIgnoreCase("title"))
      return title;
    else if (fieldName.equalsIgnoreCase("username"))
      return username;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("default_ad_client_id") || fieldName.equals("defaultAdClientId"))
      return defaultAdClientId;
    else if (fieldName.equalsIgnoreCase("enumber"))
      return enumber;
    else if (fieldName.equalsIgnoreCase("default_ad_org_id") || fieldName.equals("defaultAdOrgId"))
      return defaultAdOrgId;
    else if (fieldName.equalsIgnoreCase("birthday"))
      return birthday;
    else if (fieldName.equalsIgnoreCase("default_ad_language") || fieldName.equals("defaultAdLanguage"))
      return defaultAdLanguage;
    else if (fieldName.equalsIgnoreCase("email"))
      return email;
    else if (fieldName.equalsIgnoreCase("default_ad_role_id") || fieldName.equals("defaultAdRoleId"))
      return defaultAdRoleId;
    else if (fieldName.equalsIgnoreCase("fax"))
      return fax;
    else if (fieldName.equalsIgnoreCase("default_m_warehouse_id") || fieldName.equals("defaultMWarehouseId"))
      return defaultMWarehouseId;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("phone2"))
      return phone2;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("comments"))
      return comments;
    else if (fieldName.equalsIgnoreCase("supervisor_id") || fieldName.equals("supervisorId"))
      return supervisorId;
    else if (fieldName.equalsIgnoreCase("supervisor_idr") || fieldName.equals("supervisorIdr"))
      return supervisorIdr;
    else if (fieldName.equalsIgnoreCase("c_color_id") || fieldName.equals("cColorId"))
      return cColorId;
    else if (fieldName.equalsIgnoreCase("c_color_idr") || fieldName.equals("cColorIdr"))
      return cColorIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("mailingzielgruppe"))
      return mailingzielgruppe;
    else if (fieldName.equalsIgnoreCase("persoenlicherkontakt2010"))
      return persoenlicherkontakt2010;
    else if (fieldName.equalsIgnoreCase("date1"))
      return date1;
    else if (fieldName.equalsIgnoreCase("einkauf"))
      return einkauf;
    else if (fieldName.equalsIgnoreCase("persoenlicherkontakt2009"))
      return persoenlicherkontakt2009;
    else if (fieldName.equalsIgnoreCase("marktforschung"))
      return marktforschung;
    else if (fieldName.equalsIgnoreCase("date4"))
      return date4;
    else if (fieldName.equalsIgnoreCase("communityzugehoerigkeit"))
      return communityzugehoerigkeit;
    else if (fieldName.equalsIgnoreCase("kooperation"))
      return kooperation;
    else if (fieldName.equalsIgnoreCase("prominenter"))
      return prominenter;
    else if (fieldName.equalsIgnoreCase("emarketing"))
      return emarketing;
    else if (fieldName.equalsIgnoreCase("number5"))
      return number5;
    else if (fieldName.equalsIgnoreCase("it"))
      return it;
    else if (fieldName.equalsIgnoreCase("blockbuster"))
      return blockbuster;
    else if (fieldName.equalsIgnoreCase("unternehmenskommunikation"))
      return unternehmenskommunikation;
    else if (fieldName.equalsIgnoreCase("number4"))
      return number4;
    else if (fieldName.equalsIgnoreCase("nis"))
      return nis;
    else if (fieldName.equalsIgnoreCase("number3"))
      return number3;
    else if (fieldName.equalsIgnoreCase("number2"))
      return number2;
    else if (fieldName.equalsIgnoreCase("training"))
      return training;
    else if (fieldName.equalsIgnoreCase("marketing"))
      return marketing;
    else if (fieldName.equalsIgnoreCase("aussendienst"))
      return aussendienst;
    else if (fieldName.equalsIgnoreCase("medwissen"))
      return medwissen;
    else if (fieldName.equalsIgnoreCase("klinikkunde"))
      return klinikkunde;
    else if (fieldName.equalsIgnoreCase("kunde"))
      return kunde;
    else if (fieldName.equalsIgnoreCase("kol"))
      return kol;
    else if (fieldName.equalsIgnoreCase("persoenlicherkontakt2008"))
      return persoenlicherkontakt2008;
    else if (fieldName.equalsIgnoreCase("sachgebiet"))
      return sachgebiet;
    else if (fieldName.equalsIgnoreCase("presse"))
      return presse;
    else if (fieldName.equalsIgnoreCase("number1"))
      return number1;
    else if (fieldName.equalsIgnoreCase("stippvisitenkunde"))
      return stippvisitenkunde;
    else if (fieldName.equalsIgnoreCase("branche"))
      return branche;
    else if (fieldName.equalsIgnoreCase("persoenlicherkontakt2011"))
      return persoenlicherkontakt2011;
    else if (fieldName.equalsIgnoreCase("geschaeftsentwicklung"))
      return geschaeftsentwicklung;
    else if (fieldName.equalsIgnoreCase("hobby"))
      return hobby;
    else if (fieldName.equalsIgnoreCase("veranstaltungsmanagement"))
      return veranstaltungsmanagement;
    else if (fieldName.equalsIgnoreCase("schluesselkontakt"))
      return schluesselkontakt;
    else if (fieldName.equalsIgnoreCase("planung"))
      return planung;
    else if (fieldName.equalsIgnoreCase("land"))
      return land;
    else if (fieldName.equalsIgnoreCase("positionfunktion"))
      return positionfunktion;
    else if (fieldName.equalsIgnoreCase("klinik"))
      return klinik;
    else if (fieldName.equalsIgnoreCase("abteilungbereich"))
      return abteilungbereich;
    else if (fieldName.equalsIgnoreCase("geschaeftsfuehrer"))
      return geschaeftsfuehrer;
    else if (fieldName.equalsIgnoreCase("medicaleducation"))
      return medicaleducation;
    else if (fieldName.equalsIgnoreCase("humanresources"))
      return humanresources;
    else if (fieldName.equalsIgnoreCase("auxtext1"))
      return auxtext1;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("auxtext2"))
      return auxtext2;
    else if (fieldName.equalsIgnoreCase("c_user_position_id") || fieldName.equals("cUserPositionId"))
      return cUserPositionId;
    else if (fieldName.equalsIgnoreCase("auxtext3"))
      return auxtext3;
    else if (fieldName.equalsIgnoreCase("c_user_department_id") || fieldName.equals("cUserDepartmentId"))
      return cUserDepartmentId;
    else if (fieldName.equalsIgnoreCase("date2"))
      return date2;
    else if (fieldName.equalsIgnoreCase("date3"))
      return date3;
    else if (fieldName.equalsIgnoreCase("date5"))
      return date5;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("password"))
      return password;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
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
  public static PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cBpartnerId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_User.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_User.CreatedBy) as CreatedByR, " +
      "        to_char(AD_User.Updated, ?) as updated, " +
      "        to_char(AD_User.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_User.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_User.UpdatedBy) as UpdatedByR," +
      "        AD_User.C_BPartner_Location_ID, " +
      "AD_User.LastContact, " +
      "AD_User.EmailUserPW, " +
      "AD_User.Processing, " +
      "AD_User.EmailUser, " +
      "AD_User.LastResult, " +
      "AD_User.AD_OrgTrx_ID, " +
      "AD_User.C_BPartner_ID, " +
      "(CASE WHEN AD_User.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "AD_User.Firstname, " +
      "AD_User.C_Greeting_ID, " +
      "(CASE WHEN AD_User.C_Greeting_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS C_Greeting_IDR, " +
      "AD_User.Lastname, " +
      "AD_User.Title, " +
      "AD_User.UserName, " +
      "AD_User.Name, " +
      "AD_User.Default_Ad_Client_ID, " +
      "AD_User.Enumber, " +
      "AD_User.Default_Ad_Org_ID, " +
      "AD_User.Birthday, " +
      "AD_User.Default_Ad_Language, " +
      "AD_User.Email, " +
      "AD_User.Default_Ad_Role_ID, " +
      "AD_User.Fax, " +
      "AD_User.Default_M_Warehouse_ID, " +
      "AD_User.Phone, " +
      "AD_User.Phone2, " +
      "AD_User.Description, " +
      "AD_User.Comments, " +
      "AD_User.Supervisor_ID, " +
      "(CASE WHEN AD_User.Supervisor_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS Supervisor_IDR, " +
      "AD_User.C_Color_ID, " +
      "(CASE WHEN AD_User.C_Color_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Color_IDR, " +
      "COALESCE(AD_User.IsActive, 'N') AS IsActive, " +
      "AD_User.Mailingzielgruppe, " +
      "AD_User.Persoenlicherkontakt2010, " +
      "AD_User.Date1, " +
      "AD_User.Einkauf, " +
      "AD_User.Persoenlicherkontakt2009, " +
      "AD_User.Marktforschung, " +
      "AD_User.Date4, " +
      "AD_User.Communityzugehoerigkeit, " +
      "AD_User.Kooperation, " +
      "AD_User.Prominenter, " +
      "AD_User.Emarketing, " +
      "AD_User.Number5, " +
      "AD_User.It, " +
      "AD_User.Blockbuster, " +
      "AD_User.Unternehmenskommunikation, " +
      "AD_User.Number4, " +
      "AD_User.Nis, " +
      "AD_User.Number3, " +
      "AD_User.Number2, " +
      "AD_User.Training, " +
      "AD_User.Marketing, " +
      "AD_User.Aussendienst, " +
      "AD_User.Medwissen, " +
      "AD_User.Klinikkunde, " +
      "AD_User.Kunde, " +
      "AD_User.Kol, " +
      "AD_User.Persoenlicherkontakt2008, " +
      "AD_User.Sachgebiet, " +
      "AD_User.Presse, " +
      "AD_User.Number1, " +
      "AD_User.Stippvisitenkunde, " +
      "AD_User.Branche, " +
      "AD_User.Persoenlicherkontakt2011, " +
      "AD_User.Geschaeftsentwicklung, " +
      "AD_User.Hobby, " +
      "AD_User.Veranstaltungsmanagement, " +
      "AD_User.Schluesselkontakt, " +
      "AD_User.Planung, " +
      "AD_User.Land, " +
      "AD_User.Positionfunktion, " +
      "AD_User.Klinik, " +
      "AD_User.Abteilungbereich, " +
      "AD_User.Geschaeftsfuehrer, " +
      "AD_User.Medicaleducation, " +
      "AD_User.Humanresources, " +
      "AD_User.Auxtext1, " +
      "AD_User.Salesrep_ID, " +
      "AD_User.Auxtext2, " +
      "AD_User.C_User_Position_ID, " +
      "AD_User.Auxtext3, " +
      "AD_User.C_User_Department_ID, " +
      "AD_User.Date2, " +
      "AD_User.Date3, " +
      "AD_User.Date5, " +
      "AD_User.AD_User_ID, " +
      "AD_User.AD_Client_ID, " +
      "AD_User.Password, " +
      "AD_User.AD_Org_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_User left join (select C_BPartner_ID, Name from C_BPartner) table1 on (AD_User.C_BPartner_ID = table1.C_BPartner_ID) left join (select C_Greeting_ID, Name from C_Greeting) table2 on (AD_User.C_Greeting_ID = table2.C_Greeting_ID) left join (select C_Greeting_ID,AD_Language, Name from C_Greeting_TRL) tableTRL2 on (table2.C_Greeting_ID = tableTRL2.C_Greeting_ID and tableTRL2.AD_Language = ?)  left join (select AD_User_ID, Name from AD_User) table3 on (AD_User.Supervisor_ID =  table3.AD_User_ID) left join (select C_Color_ID, Name from C_Color) table4 on (AD_User.C_Color_ID = table4.C_Color_ID)" +
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
        PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data = new PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data();
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.created = UtilSql.getValue(result, "created");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.updated = UtilSql.getValue(result, "updated");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.lastcontact = UtilSql.getDateValue(result, "lastcontact", "dd-MM-yyyy");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.emailuserpw = UtilSql.getValue(result, "emailuserpw");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.processing = UtilSql.getValue(result, "processing");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.emailuser = UtilSql.getValue(result, "emailuser");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.lastresult = UtilSql.getValue(result, "lastresult");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.firstname = UtilSql.getValue(result, "firstname");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.cGreetingId = UtilSql.getValue(result, "c_greeting_id");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.cGreetingIdr = UtilSql.getValue(result, "c_greeting_idr");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.lastname = UtilSql.getValue(result, "lastname");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.title = UtilSql.getValue(result, "title");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.username = UtilSql.getValue(result, "username");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.name = UtilSql.getValue(result, "name");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.defaultAdClientId = UtilSql.getValue(result, "default_ad_client_id");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.enumber = UtilSql.getValue(result, "enumber");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.defaultAdOrgId = UtilSql.getValue(result, "default_ad_org_id");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.birthday = UtilSql.getDateValue(result, "birthday", "dd-MM-yyyy");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.defaultAdLanguage = UtilSql.getValue(result, "default_ad_language");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.email = UtilSql.getValue(result, "email");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.defaultAdRoleId = UtilSql.getValue(result, "default_ad_role_id");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.fax = UtilSql.getValue(result, "fax");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.defaultMWarehouseId = UtilSql.getValue(result, "default_m_warehouse_id");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.phone = UtilSql.getValue(result, "phone");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.phone2 = UtilSql.getValue(result, "phone2");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.description = UtilSql.getValue(result, "description");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.comments = UtilSql.getValue(result, "comments");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.supervisorId = UtilSql.getValue(result, "supervisor_id");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.supervisorIdr = UtilSql.getValue(result, "supervisor_idr");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.cColorId = UtilSql.getValue(result, "c_color_id");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.cColorIdr = UtilSql.getValue(result, "c_color_idr");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.isactive = UtilSql.getValue(result, "isactive");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.mailingzielgruppe = UtilSql.getValue(result, "mailingzielgruppe");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.persoenlicherkontakt2010 = UtilSql.getValue(result, "persoenlicherkontakt2010");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.date1 = UtilSql.getDateValue(result, "date1", "dd-MM-yyyy");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.einkauf = UtilSql.getValue(result, "einkauf");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.persoenlicherkontakt2009 = UtilSql.getValue(result, "persoenlicherkontakt2009");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.marktforschung = UtilSql.getValue(result, "marktforschung");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.date4 = UtilSql.getDateValue(result, "date4", "dd-MM-yyyy");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.communityzugehoerigkeit = UtilSql.getValue(result, "communityzugehoerigkeit");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.kooperation = UtilSql.getValue(result, "kooperation");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.prominenter = UtilSql.getValue(result, "prominenter");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.emarketing = UtilSql.getValue(result, "emarketing");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.number5 = UtilSql.getValue(result, "number5");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.it = UtilSql.getValue(result, "it");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.blockbuster = UtilSql.getValue(result, "blockbuster");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.unternehmenskommunikation = UtilSql.getValue(result, "unternehmenskommunikation");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.number4 = UtilSql.getValue(result, "number4");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.nis = UtilSql.getValue(result, "nis");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.number3 = UtilSql.getValue(result, "number3");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.number2 = UtilSql.getValue(result, "number2");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.training = UtilSql.getValue(result, "training");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.marketing = UtilSql.getValue(result, "marketing");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.aussendienst = UtilSql.getValue(result, "aussendienst");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.medwissen = UtilSql.getValue(result, "medwissen");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.klinikkunde = UtilSql.getValue(result, "klinikkunde");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.kunde = UtilSql.getValue(result, "kunde");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.kol = UtilSql.getValue(result, "kol");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.persoenlicherkontakt2008 = UtilSql.getValue(result, "persoenlicherkontakt2008");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.sachgebiet = UtilSql.getValue(result, "sachgebiet");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.presse = UtilSql.getValue(result, "presse");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.number1 = UtilSql.getValue(result, "number1");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.stippvisitenkunde = UtilSql.getValue(result, "stippvisitenkunde");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.branche = UtilSql.getValue(result, "branche");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.persoenlicherkontakt2011 = UtilSql.getValue(result, "persoenlicherkontakt2011");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.geschaeftsentwicklung = UtilSql.getValue(result, "geschaeftsentwicklung");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.hobby = UtilSql.getValue(result, "hobby");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.veranstaltungsmanagement = UtilSql.getValue(result, "veranstaltungsmanagement");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.schluesselkontakt = UtilSql.getValue(result, "schluesselkontakt");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.planung = UtilSql.getValue(result, "planung");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.land = UtilSql.getValue(result, "land");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.positionfunktion = UtilSql.getValue(result, "positionfunktion");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.klinik = UtilSql.getValue(result, "klinik");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.abteilungbereich = UtilSql.getValue(result, "abteilungbereich");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.geschaeftsfuehrer = UtilSql.getValue(result, "geschaeftsfuehrer");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.medicaleducation = UtilSql.getValue(result, "medicaleducation");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.humanresources = UtilSql.getValue(result, "humanresources");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.auxtext1 = UtilSql.getValue(result, "auxtext1");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.auxtext2 = UtilSql.getValue(result, "auxtext2");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.cUserPositionId = UtilSql.getValue(result, "c_user_position_id");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.auxtext3 = UtilSql.getValue(result, "auxtext3");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.cUserDepartmentId = UtilSql.getValue(result, "c_user_department_id");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.date2 = UtilSql.getDateValue(result, "date2", "dd-MM-yyyy");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.date3 = UtilSql.getDateValue(result, "date3", "dd-MM-yyyy");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.date5 = UtilSql.getDateValue(result, "date5", "dd-MM-yyyy");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.password = UtilSql.getValue(result, "password");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.language = UtilSql.getValue(result, "language");
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.adUserClient = "";
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.adOrgClient = "";
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.createdby = "";
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.trBgcolor = "";
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.totalCount = "";
        objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data);
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
    PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[] = new PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[vector.size()];
    vector.copyInto(objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data);
    return(objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data);
  }

/**
Create a registry
 */
  public static PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[] set(String cBpartnerId, String stippvisitenkunde, String kol, String date1, String adOrgtrxId, String number2, String number3, String phone, String emailuser, String emailuserpw, String humanresources, String salesrepId, String emarketing, String lastcontact, String medwissen, String positionfunktion, String klinikkunde, String veranstaltungsmanagement, String schluesselkontakt, String cUserDepartmentId, String fax, String name, String defaultMWarehouseId, String communityzugehoerigkeit, String sachgebiet, String cGreetingId, String persoenlicherkontakt2010, String hobby, String adUserId, String birthday, String number5, String auxtext3, String kunde, String defaultAdClientId, String einkauf, String blockbuster, String geschaeftsentwicklung, String nis, String branche, String auxtext2, String defaultAdOrgId, String description, String supervisorId, String lastresult, String createdby, String createdbyr, String number4, String klinik, String cBpartnerLocationId, String presse, String unternehmenskommunikation, String persoenlicherkontakt2008, String medicaleducation, String date2, String isactive, String phone2, String it, String firstname, String username, String persoenlicherkontakt2009, String aussendienst, String email, String processing, String adOrgId, String date3, String password, String title, String persoenlicherkontakt2011, String mailingzielgruppe, String enumber, String prominenter, String abteilungbereich, String auxtext1, String defaultAdLanguage, String defaultAdRoleId, String cUserPositionId, String training, String geschaeftsfuehrer, String land, String date4, String adClientId, String date5, String comments, String lastname, String marketing, String updatedby, String updatedbyr, String planung, String kooperation, String cColorId, String number1, String marktforschung)    throws ServletException {
    PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[] = new PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[1];
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0] = new PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data();
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].created = "";
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].createdbyr = createdbyr;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].updated = "";
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].updatedTimeStamp = "";
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].updatedby = updatedby;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].updatedbyr = updatedbyr;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].cBpartnerLocationId = cBpartnerLocationId;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].lastcontact = lastcontact;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].emailuserpw = emailuserpw;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].processing = processing;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].emailuser = emailuser;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].lastresult = lastresult;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].adOrgtrxId = adOrgtrxId;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].cBpartnerId = cBpartnerId;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].cBpartnerIdr = "";
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].firstname = firstname;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].cGreetingId = cGreetingId;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].cGreetingIdr = "";
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].lastname = lastname;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].title = title;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].username = username;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].name = name;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].defaultAdClientId = defaultAdClientId;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].enumber = enumber;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].defaultAdOrgId = defaultAdOrgId;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].birthday = birthday;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].defaultAdLanguage = defaultAdLanguage;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].email = email;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].defaultAdRoleId = defaultAdRoleId;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].fax = fax;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].defaultMWarehouseId = defaultMWarehouseId;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].phone = phone;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].phone2 = phone2;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].description = description;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].comments = comments;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].supervisorId = supervisorId;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].supervisorIdr = "";
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].cColorId = cColorId;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].cColorIdr = "";
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].isactive = isactive;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].mailingzielgruppe = mailingzielgruppe;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].persoenlicherkontakt2010 = persoenlicherkontakt2010;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].date1 = date1;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].einkauf = einkauf;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].persoenlicherkontakt2009 = persoenlicherkontakt2009;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].marktforschung = marktforschung;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].date4 = date4;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].communityzugehoerigkeit = communityzugehoerigkeit;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].kooperation = kooperation;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].prominenter = prominenter;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].emarketing = emarketing;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].number5 = number5;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].it = it;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].blockbuster = blockbuster;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].unternehmenskommunikation = unternehmenskommunikation;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].number4 = number4;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].nis = nis;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].number3 = number3;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].number2 = number2;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].training = training;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].marketing = marketing;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].aussendienst = aussendienst;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].medwissen = medwissen;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].klinikkunde = klinikkunde;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].kunde = kunde;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].kol = kol;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].persoenlicherkontakt2008 = persoenlicherkontakt2008;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].sachgebiet = sachgebiet;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].presse = presse;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].number1 = number1;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].stippvisitenkunde = stippvisitenkunde;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].branche = branche;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].persoenlicherkontakt2011 = persoenlicherkontakt2011;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].geschaeftsentwicklung = geschaeftsentwicklung;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].hobby = hobby;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].veranstaltungsmanagement = veranstaltungsmanagement;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].schluesselkontakt = schluesselkontakt;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].planung = planung;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].land = land;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].positionfunktion = positionfunktion;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].klinik = klinik;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].abteilungbereich = abteilungbereich;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].geschaeftsfuehrer = geschaeftsfuehrer;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].medicaleducation = medicaleducation;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].humanresources = humanresources;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].auxtext1 = auxtext1;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].salesrepId = salesrepId;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].auxtext2 = auxtext2;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].cUserPositionId = cUserPositionId;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].auxtext3 = auxtext3;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].cUserDepartmentId = cUserDepartmentId;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].date2 = date2;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].date3 = date3;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].date5 = date5;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].adUserId = adUserId;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].adClientId = adClientId;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].password = password;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].adOrgId = adOrgId;
    objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0].language = "";
    return objectPersonalDataC9B028F8723040C8A2BE9C26E125FA22Data;
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
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM c_bpartneremployee_view left join (select C_BPartner_ID, Name from C_BPartner) table1 on (c_bpartneremployee_view.C_BPartner_ID = table1.C_BPartner_ID) WHERE c_bpartneremployee_view.C_BPartner_ID = ?  ";

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
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM c_bpartneremployee_view left join (select C_BPartner_ID, Name from C_BPartner) table1 on (c_bpartneremployee_view.C_BPartner_ID = table1.C_BPartner_ID) WHERE c_bpartneremployee_view.C_BPartner_ID = ?  ";

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
      "        SET Processing = (?) , LastResult = (?) , AD_OrgTrx_ID = (?) , LastContact = TO_DATE(?) , EmailUser = (?) , C_BPartner_Location_ID = (?) , C_BPartner_ID = (?) , Firstname = (?) , C_Greeting_ID = (?) , Lastname = (?) , Title = (?) , UserName = (?) , Name = (?) , Default_Ad_Client_ID = (?) , Enumber = (?) , Default_Ad_Org_ID = (?) , Birthday = TO_DATE(?) , Default_Ad_Language = (?) , Email = (?) , Default_Ad_Role_ID = (?) , Fax = (?) , Default_M_Warehouse_ID = (?) , Phone = (?) , Phone2 = (?) , Description = (?) , Comments = (?) , Supervisor_ID = (?) , C_Color_ID = (?) , IsActive = (?) , Mailingzielgruppe = (?) , Persoenlicherkontakt2010 = (?) , Date1 = TO_DATE(?) , Einkauf = (?) , Persoenlicherkontakt2009 = (?) , Marktforschung = (?) , Date4 = TO_DATE(?) , Communityzugehoerigkeit = (?) , Kooperation = (?) , Prominenter = (?) , Emarketing = (?) , Number5 = TO_NUMBER(?) , It = (?) , Blockbuster = (?) , Unternehmenskommunikation = (?) , Number4 = TO_NUMBER(?) , Nis = (?) , Number3 = TO_NUMBER(?) , Number2 = TO_NUMBER(?) , Training = (?) , Marketing = (?) , Aussendienst = (?) , Medwissen = (?) , Klinikkunde = (?) , Kunde = (?) , Kol = (?) , Persoenlicherkontakt2008 = (?) , Sachgebiet = (?) , Presse = (?) , Number1 = TO_NUMBER(?) , Stippvisitenkunde = (?) , Branche = (?) , Persoenlicherkontakt2011 = (?) , Geschaeftsentwicklung = (?) , Hobby = (?) , Veranstaltungsmanagement = (?) , Schluesselkontakt = (?) , Planung = (?) , Land = (?) , Positionfunktion = (?) , Klinik = (?) , Abteilungbereich = (?) , Geschaeftsfuehrer = (?) , Medicaleducation = (?) , Humanresources = (?) , Auxtext1 = (?) , Salesrep_ID = (?) , Auxtext2 = (?) , C_User_Position_ID = (?) , Auxtext3 = (?) , C_User_Department_ID = (?) , Date2 = TO_DATE(?) , Date3 = TO_DATE(?) , Date5 = TO_DATE(?) , AD_Client_ID = (?) , AD_User_ID = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastresult);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastcontact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emailuser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGreetingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, title);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, username);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, birthday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultMWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, comments);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, supervisorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cColorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mailingzielgruppe);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, persoenlicherkontakt2010);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, einkauf);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, persoenlicherkontakt2009);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marktforschung);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, communityzugehoerigkeit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, kooperation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, prominenter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emarketing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, number5);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, it);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, blockbuster);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unternehmenskommunikation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, number4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nis);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, number3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, number2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, training);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marketing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aussendienst);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, medwissen);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, klinikkunde);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, kunde);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, kol);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, persoenlicherkontakt2008);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sachgebiet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, presse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, number1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stippvisitenkunde);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, branche);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, persoenlicherkontakt2011);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, geschaeftsentwicklung);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hobby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, veranstaltungsmanagement);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schluesselkontakt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planung);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, land);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, positionfunktion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, klinik);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, abteilungbereich);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, geschaeftsfuehrer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, medicaleducation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, humanresources);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, auxtext1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, auxtext2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, auxtext3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date5);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
      "        (C_BPartner_Location_ID, LastContact, EmailUserPW, Processing, EmailUser, LastResult, AD_OrgTrx_ID, C_BPartner_ID, Firstname, C_Greeting_ID, Lastname, Title, UserName, Name, Default_Ad_Client_ID, Enumber, Default_Ad_Org_ID, Birthday, Default_Ad_Language, Email, Default_Ad_Role_ID, Fax, Default_M_Warehouse_ID, Phone, Phone2, Description, Comments, Supervisor_ID, C_Color_ID, IsActive, Mailingzielgruppe, Persoenlicherkontakt2010, Date1, Einkauf, Persoenlicherkontakt2009, Marktforschung, Date4, Communityzugehoerigkeit, Kooperation, Prominenter, Emarketing, Number5, It, Blockbuster, Unternehmenskommunikation, Number4, Nis, Number3, Number2, Training, Marketing, Aussendienst, Medwissen, Klinikkunde, Kunde, Kol, Persoenlicherkontakt2008, Sachgebiet, Presse, Number1, Stippvisitenkunde, Branche, Persoenlicherkontakt2011, Geschaeftsentwicklung, Hobby, Veranstaltungsmanagement, Schluesselkontakt, Planung, Land, Positionfunktion, Klinik, Abteilungbereich, Geschaeftsfuehrer, Medicaleducation, Humanresources, Auxtext1, Salesrep_ID, Auxtext2, C_User_Position_ID, Auxtext3, C_User_Department_ID, Date2, Date3, Date5, AD_User_ID, AD_Client_ID, Password, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastcontact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emailuserpw);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emailuser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastresult);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGreetingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, title);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, username);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, birthday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultAdRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultMWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, comments);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, supervisorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cColorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mailingzielgruppe);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, persoenlicherkontakt2010);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, einkauf);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, persoenlicherkontakt2009);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marktforschung);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, communityzugehoerigkeit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, kooperation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, prominenter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emarketing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, number5);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, it);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, blockbuster);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unternehmenskommunikation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, number4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nis);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, number3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, number2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, training);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marketing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aussendienst);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, medwissen);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, klinikkunde);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, kunde);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, kol);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, persoenlicherkontakt2008);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sachgebiet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, presse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, number1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stippvisitenkunde);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, branche);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, persoenlicherkontakt2011);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, geschaeftsentwicklung);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hobby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, veranstaltungsmanagement);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schluesselkontakt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planung);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, land);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, positionfunktion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, klinik);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, abteilungbereich);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, geschaeftsfuehrer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, medicaleducation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, humanresources);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, auxtext1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, auxtext2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, auxtext3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date5);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, password);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
