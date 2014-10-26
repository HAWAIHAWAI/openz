//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.PromissoryNoteFormat;

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
class PromissoryformatData implements FieldProvider {
static Logger log4j = Logger.getLogger(PromissoryformatData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cPromissoryformatId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String name;
  public String description;
  public String cBankaccountId;
  public String cBankaccountIdr;
  public String isactive;
  public String line1left;
  public String line1top;
  public String line2left;
  public String line2top;
  public String line3left;
  public String line3top;
  public String line4left;
  public String line4top;
  public String param11;
  public String param12;
  public String param13;
  public String param31;
  public String param32;
  public String param41;
  public String param42;
  public String param43;
  public String fontdayplanned;
  public String fontmonthplanned;
  public String fontyearplanned;
  public String fontamount;
  public String fontpartnername;
  public String fontamounttext;
  public String fontdaytoday;
  public String fontmonthtoday;
  public String fontyeartoday;
  public String printbankloc;
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
    else if (fieldName.equalsIgnoreCase("c_promissoryformat_id") || fieldName.equals("cPromissoryformatId"))
      return cPromissoryformatId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_bankaccount_id") || fieldName.equals("cBankaccountId"))
      return cBankaccountId;
    else if (fieldName.equalsIgnoreCase("c_bankaccount_idr") || fieldName.equals("cBankaccountIdr"))
      return cBankaccountIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("line1left"))
      return line1left;
    else if (fieldName.equalsIgnoreCase("line1top"))
      return line1top;
    else if (fieldName.equalsIgnoreCase("line2left"))
      return line2left;
    else if (fieldName.equalsIgnoreCase("line2top"))
      return line2top;
    else if (fieldName.equalsIgnoreCase("line3left"))
      return line3left;
    else if (fieldName.equalsIgnoreCase("line3top"))
      return line3top;
    else if (fieldName.equalsIgnoreCase("line4left"))
      return line4left;
    else if (fieldName.equalsIgnoreCase("line4top"))
      return line4top;
    else if (fieldName.equalsIgnoreCase("param11"))
      return param11;
    else if (fieldName.equalsIgnoreCase("param12"))
      return param12;
    else if (fieldName.equalsIgnoreCase("param13"))
      return param13;
    else if (fieldName.equalsIgnoreCase("param31"))
      return param31;
    else if (fieldName.equalsIgnoreCase("param32"))
      return param32;
    else if (fieldName.equalsIgnoreCase("param41"))
      return param41;
    else if (fieldName.equalsIgnoreCase("param42"))
      return param42;
    else if (fieldName.equalsIgnoreCase("param43"))
      return param43;
    else if (fieldName.equalsIgnoreCase("fontdayplanned"))
      return fontdayplanned;
    else if (fieldName.equalsIgnoreCase("fontmonthplanned"))
      return fontmonthplanned;
    else if (fieldName.equalsIgnoreCase("fontyearplanned"))
      return fontyearplanned;
    else if (fieldName.equalsIgnoreCase("fontamount"))
      return fontamount;
    else if (fieldName.equalsIgnoreCase("fontpartnername"))
      return fontpartnername;
    else if (fieldName.equalsIgnoreCase("fontamounttext"))
      return fontamounttext;
    else if (fieldName.equalsIgnoreCase("fontdaytoday"))
      return fontdaytoday;
    else if (fieldName.equalsIgnoreCase("fontmonthtoday"))
      return fontmonthtoday;
    else if (fieldName.equalsIgnoreCase("fontyeartoday"))
      return fontyeartoday;
    else if (fieldName.equalsIgnoreCase("printbankloc"))
      return printbankloc;
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
  public static PromissoryformatData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PromissoryformatData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_PromissoryFormat.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_PromissoryFormat.CreatedBy) as CreatedByR, " +
      "        to_char(C_PromissoryFormat.Updated, ?) as updated, " +
      "        to_char(C_PromissoryFormat.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_PromissoryFormat.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_PromissoryFormat.UpdatedBy) as UpdatedByR," +
      "        C_PromissoryFormat.C_Promissoryformat_ID, " +
      "C_PromissoryFormat.AD_Client_ID, " +
      "(CASE WHEN C_PromissoryFormat.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_PromissoryFormat.AD_Org_ID, " +
      "(CASE WHEN C_PromissoryFormat.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_PromissoryFormat.Name, " +
      "C_PromissoryFormat.Description, " +
      "C_PromissoryFormat.C_BankAccount_ID, " +
      "(CASE WHEN C_PromissoryFormat.C_BankAccount_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DisplayedAccount), ''))),'') ) END) AS C_BankAccount_IDR, " +
      "COALESCE(C_PromissoryFormat.IsActive, 'N') AS IsActive, " +
      "C_PromissoryFormat.Line1left, " +
      "C_PromissoryFormat.Line1top, " +
      "C_PromissoryFormat.Line2left, " +
      "C_PromissoryFormat.Line2top, " +
      "C_PromissoryFormat.Line3left, " +
      "C_PromissoryFormat.Line3top, " +
      "C_PromissoryFormat.Line4left, " +
      "C_PromissoryFormat.Line4top, " +
      "C_PromissoryFormat.Param11, " +
      "C_PromissoryFormat.Param12, " +
      "C_PromissoryFormat.Param13, " +
      "C_PromissoryFormat.Param31, " +
      "C_PromissoryFormat.Param32, " +
      "C_PromissoryFormat.Param41, " +
      "C_PromissoryFormat.Param42, " +
      "C_PromissoryFormat.Param43, " +
      "C_PromissoryFormat.Fontdayplanned, " +
      "C_PromissoryFormat.Fontmonthplanned, " +
      "C_PromissoryFormat.Fontyearplanned, " +
      "C_PromissoryFormat.Fontamount, " +
      "C_PromissoryFormat.Fontpartnername, " +
      "C_PromissoryFormat.Fontamounttext, " +
      "C_PromissoryFormat.Fontdaytoday, " +
      "C_PromissoryFormat.Fontmonthtoday, " +
      "C_PromissoryFormat.Fontyeartoday, " +
      "COALESCE(C_PromissoryFormat.Printbankloc, 'N') AS Printbankloc, " +
      "        ? AS LANGUAGE " +
      "        FROM C_PromissoryFormat left join (select AD_Client_ID, Name from AD_Client) table1 on (C_PromissoryFormat.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_PromissoryFormat.AD_Org_ID = table2.AD_Org_ID) left join (select C_BankAccount_ID, C_Bank_ID, DisplayedAccount from C_BankAccount) table3 on (C_PromissoryFormat.C_BankAccount_ID = table3.C_BankAccount_ID) left join (select C_Bank_ID, Name from C_Bank) table4 on (table3.C_Bank_ID = table4.C_Bank_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_PromissoryFormat.C_Promissoryformat_ID = ? " +
      "        AND C_PromissoryFormat.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_PromissoryFormat.AD_Org_ID IN (";
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
        PromissoryformatData objectPromissoryformatData = new PromissoryformatData();
        objectPromissoryformatData.created = UtilSql.getValue(result, "created");
        objectPromissoryformatData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPromissoryformatData.updated = UtilSql.getValue(result, "updated");
        objectPromissoryformatData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPromissoryformatData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPromissoryformatData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPromissoryformatData.cPromissoryformatId = UtilSql.getValue(result, "c_promissoryformat_id");
        objectPromissoryformatData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPromissoryformatData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectPromissoryformatData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPromissoryformatData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPromissoryformatData.name = UtilSql.getValue(result, "name");
        objectPromissoryformatData.description = UtilSql.getValue(result, "description");
        objectPromissoryformatData.cBankaccountId = UtilSql.getValue(result, "c_bankaccount_id");
        objectPromissoryformatData.cBankaccountIdr = UtilSql.getValue(result, "c_bankaccount_idr");
        objectPromissoryformatData.isactive = UtilSql.getValue(result, "isactive");
        objectPromissoryformatData.line1left = UtilSql.getValue(result, "line1left");
        objectPromissoryformatData.line1top = UtilSql.getValue(result, "line1top");
        objectPromissoryformatData.line2left = UtilSql.getValue(result, "line2left");
        objectPromissoryformatData.line2top = UtilSql.getValue(result, "line2top");
        objectPromissoryformatData.line3left = UtilSql.getValue(result, "line3left");
        objectPromissoryformatData.line3top = UtilSql.getValue(result, "line3top");
        objectPromissoryformatData.line4left = UtilSql.getValue(result, "line4left");
        objectPromissoryformatData.line4top = UtilSql.getValue(result, "line4top");
        objectPromissoryformatData.param11 = UtilSql.getValue(result, "param11");
        objectPromissoryformatData.param12 = UtilSql.getValue(result, "param12");
        objectPromissoryformatData.param13 = UtilSql.getValue(result, "param13");
        objectPromissoryformatData.param31 = UtilSql.getValue(result, "param31");
        objectPromissoryformatData.param32 = UtilSql.getValue(result, "param32");
        objectPromissoryformatData.param41 = UtilSql.getValue(result, "param41");
        objectPromissoryformatData.param42 = UtilSql.getValue(result, "param42");
        objectPromissoryformatData.param43 = UtilSql.getValue(result, "param43");
        objectPromissoryformatData.fontdayplanned = UtilSql.getValue(result, "fontdayplanned");
        objectPromissoryformatData.fontmonthplanned = UtilSql.getValue(result, "fontmonthplanned");
        objectPromissoryformatData.fontyearplanned = UtilSql.getValue(result, "fontyearplanned");
        objectPromissoryformatData.fontamount = UtilSql.getValue(result, "fontamount");
        objectPromissoryformatData.fontpartnername = UtilSql.getValue(result, "fontpartnername");
        objectPromissoryformatData.fontamounttext = UtilSql.getValue(result, "fontamounttext");
        objectPromissoryformatData.fontdaytoday = UtilSql.getValue(result, "fontdaytoday");
        objectPromissoryformatData.fontmonthtoday = UtilSql.getValue(result, "fontmonthtoday");
        objectPromissoryformatData.fontyeartoday = UtilSql.getValue(result, "fontyeartoday");
        objectPromissoryformatData.printbankloc = UtilSql.getValue(result, "printbankloc");
        objectPromissoryformatData.language = UtilSql.getValue(result, "language");
        objectPromissoryformatData.adUserClient = "";
        objectPromissoryformatData.adOrgClient = "";
        objectPromissoryformatData.createdby = "";
        objectPromissoryformatData.trBgcolor = "";
        objectPromissoryformatData.totalCount = "";
        objectPromissoryformatData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPromissoryformatData);
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
    PromissoryformatData objectPromissoryformatData[] = new PromissoryformatData[vector.size()];
    vector.copyInto(objectPromissoryformatData);
    return(objectPromissoryformatData);
  }

/**
Create a registry
 */
  public static PromissoryformatData[] set(String adClientId, String line3top, String updatedby, String updatedbyr, String cPromissoryformatId, String param42, String line4left, String fontamount, String line4top, String param11, String param43, String fontdaytoday, String fontdayplanned, String param12, String param13, String line2left, String printbankloc, String cBankaccountId, String line1top, String name, String fontmonthtoday, String param41, String adOrgId, String fontamounttext, String line2top, String fontmonthplanned, String fontyearplanned, String line1left, String createdby, String createdbyr, String line3left, String isactive, String param32, String description, String fontyeartoday, String param31, String fontpartnername)    throws ServletException {
    PromissoryformatData objectPromissoryformatData[] = new PromissoryformatData[1];
    objectPromissoryformatData[0] = new PromissoryformatData();
    objectPromissoryformatData[0].created = "";
    objectPromissoryformatData[0].createdbyr = createdbyr;
    objectPromissoryformatData[0].updated = "";
    objectPromissoryformatData[0].updatedTimeStamp = "";
    objectPromissoryformatData[0].updatedby = updatedby;
    objectPromissoryformatData[0].updatedbyr = updatedbyr;
    objectPromissoryformatData[0].cPromissoryformatId = cPromissoryformatId;
    objectPromissoryformatData[0].adClientId = adClientId;
    objectPromissoryformatData[0].adClientIdr = "";
    objectPromissoryformatData[0].adOrgId = adOrgId;
    objectPromissoryformatData[0].adOrgIdr = "";
    objectPromissoryformatData[0].name = name;
    objectPromissoryformatData[0].description = description;
    objectPromissoryformatData[0].cBankaccountId = cBankaccountId;
    objectPromissoryformatData[0].cBankaccountIdr = "";
    objectPromissoryformatData[0].isactive = isactive;
    objectPromissoryformatData[0].line1left = line1left;
    objectPromissoryformatData[0].line1top = line1top;
    objectPromissoryformatData[0].line2left = line2left;
    objectPromissoryformatData[0].line2top = line2top;
    objectPromissoryformatData[0].line3left = line3left;
    objectPromissoryformatData[0].line3top = line3top;
    objectPromissoryformatData[0].line4left = line4left;
    objectPromissoryformatData[0].line4top = line4top;
    objectPromissoryformatData[0].param11 = param11;
    objectPromissoryformatData[0].param12 = param12;
    objectPromissoryformatData[0].param13 = param13;
    objectPromissoryformatData[0].param31 = param31;
    objectPromissoryformatData[0].param32 = param32;
    objectPromissoryformatData[0].param41 = param41;
    objectPromissoryformatData[0].param42 = param42;
    objectPromissoryformatData[0].param43 = param43;
    objectPromissoryformatData[0].fontdayplanned = fontdayplanned;
    objectPromissoryformatData[0].fontmonthplanned = fontmonthplanned;
    objectPromissoryformatData[0].fontyearplanned = fontyearplanned;
    objectPromissoryformatData[0].fontamount = fontamount;
    objectPromissoryformatData[0].fontpartnername = fontpartnername;
    objectPromissoryformatData[0].fontamounttext = fontamounttext;
    objectPromissoryformatData[0].fontdaytoday = fontdaytoday;
    objectPromissoryformatData[0].fontmonthtoday = fontmonthtoday;
    objectPromissoryformatData[0].fontyeartoday = fontyeartoday;
    objectPromissoryformatData[0].printbankloc = printbankloc;
    objectPromissoryformatData[0].language = "";
    return objectPromissoryformatData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef802538_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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

/**
Select for auxiliar field
 */
  public static String selectDef802536_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_PromissoryFormat" +
      "        SET C_Promissoryformat_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Name = (?) , Description = (?) , C_BankAccount_ID = (?) , IsActive = (?) , Line1left = TO_NUMBER(?) , Line1top = TO_NUMBER(?) , Line2left = TO_NUMBER(?) , Line2top = TO_NUMBER(?) , Line3left = TO_NUMBER(?) , Line3top = TO_NUMBER(?) , Line4left = TO_NUMBER(?) , Line4top = TO_NUMBER(?) , Param11 = TO_NUMBER(?) , Param12 = TO_NUMBER(?) , Param13 = TO_NUMBER(?) , Param31 = TO_NUMBER(?) , Param32 = TO_NUMBER(?) , Param41 = TO_NUMBER(?) , Param42 = TO_NUMBER(?) , Param43 = TO_NUMBER(?) , Fontdayplanned = TO_NUMBER(?) , Fontmonthplanned = TO_NUMBER(?) , Fontyearplanned = TO_NUMBER(?) , Fontamount = TO_NUMBER(?) , Fontpartnername = TO_NUMBER(?) , Fontamounttext = TO_NUMBER(?) , Fontdaytoday = TO_NUMBER(?) , Fontmonthtoday = TO_NUMBER(?) , Fontyeartoday = TO_NUMBER(?) , Printbankloc = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_PromissoryFormat.C_Promissoryformat_ID = ? " +
      "        AND C_PromissoryFormat.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_PromissoryFormat.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPromissoryformatId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line1left);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line1top);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line2left);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line2top);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line3left);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line3top);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line4left);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line4top);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param11);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param12);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param13);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param31);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param32);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param41);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param42);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param43);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontdayplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontmonthplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontyearplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontpartnername);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontamounttext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontdaytoday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontmonthtoday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontyeartoday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printbankloc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPromissoryformatId);
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
      "        INSERT INTO C_PromissoryFormat " +
      "        (C_Promissoryformat_ID, AD_Client_ID, AD_Org_ID, Name, Description, C_BankAccount_ID, IsActive, Line1left, Line1top, Line2left, Line2top, Line3left, Line3top, Line4left, Line4top, Param11, Param12, Param13, Param31, Param32, Param41, Param42, Param43, Fontdayplanned, Fontmonthplanned, Fontyearplanned, Fontamount, Fontpartnername, Fontamounttext, Fontdaytoday, Fontmonthtoday, Fontyeartoday, Printbankloc, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPromissoryformatId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line1left);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line1top);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line2left);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line2top);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line3left);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line3top);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line4left);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line4top);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param11);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param12);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param13);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param31);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param32);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param41);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param42);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param43);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontdayplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontmonthplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontyearplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontpartnername);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontamounttext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontdaytoday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontmonthtoday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fontyeartoday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printbankloc);
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
      "        DELETE FROM C_PromissoryFormat" +
      "        WHERE C_PromissoryFormat.C_Promissoryformat_ID = ? " +
      "        AND C_PromissoryFormat.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_PromissoryFormat.AD_Org_ID IN (";
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
      "        DELETE FROM C_PromissoryFormat" +
      "        WHERE C_PromissoryFormat.C_Promissoryformat_ID = ? ";

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
      "          FROM C_PromissoryFormat" +
      "         WHERE C_PromissoryFormat.C_Promissoryformat_ID = ? ";

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
      "          FROM C_PromissoryFormat" +
      "         WHERE C_PromissoryFormat.C_Promissoryformat_ID = ? ";

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
