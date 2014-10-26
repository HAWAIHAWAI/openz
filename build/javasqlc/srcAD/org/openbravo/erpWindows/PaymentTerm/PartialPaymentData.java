//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.PaymentTerm;

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
class PartialPaymentData implements FieldProvider {
static Logger log4j = Logger.getLogger(PartialPaymentData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cPaymenttermlineId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cPaymenttermId;
  public String cPaymenttermIdr;
  public String isactive;
  public String line;
  public String percentage;
  public String excludetax;
  public String fixmonthcutoff;
  public String fixmonthoffset;
  public String netdays;
  public String netday;
  public String netdayr;
  public String isnextbusinessday;
  public String paymentrule;
  public String paymentruler;
  public String isduefixed;
  public String fixmonthday;
  public String fixmonthday2;
  public String fixmonthday3;
  public String onremainder;
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
    else if (fieldName.equalsIgnoreCase("c_paymenttermline_id") || fieldName.equals("cPaymenttermlineId"))
      return cPaymenttermlineId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_idr") || fieldName.equals("cPaymenttermIdr"))
      return cPaymenttermIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("percentage"))
      return percentage;
    else if (fieldName.equalsIgnoreCase("excludetax"))
      return excludetax;
    else if (fieldName.equalsIgnoreCase("fixmonthcutoff"))
      return fixmonthcutoff;
    else if (fieldName.equalsIgnoreCase("fixmonthoffset"))
      return fixmonthoffset;
    else if (fieldName.equalsIgnoreCase("netdays"))
      return netdays;
    else if (fieldName.equalsIgnoreCase("netday"))
      return netday;
    else if (fieldName.equalsIgnoreCase("netdayr"))
      return netdayr;
    else if (fieldName.equalsIgnoreCase("isnextbusinessday"))
      return isnextbusinessday;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("paymentruler"))
      return paymentruler;
    else if (fieldName.equalsIgnoreCase("isduefixed"))
      return isduefixed;
    else if (fieldName.equalsIgnoreCase("fixmonthday"))
      return fixmonthday;
    else if (fieldName.equalsIgnoreCase("fixmonthday2"))
      return fixmonthday2;
    else if (fieldName.equalsIgnoreCase("fixmonthday3"))
      return fixmonthday3;
    else if (fieldName.equalsIgnoreCase("onremainder"))
      return onremainder;
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
  public static PartialPaymentData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cPaymenttermId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cPaymenttermId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PartialPaymentData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cPaymenttermId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Paymenttermline.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Paymenttermline.CreatedBy) as CreatedByR, " +
      "        to_char(C_Paymenttermline.Updated, ?) as updated, " +
      "        to_char(C_Paymenttermline.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Paymenttermline.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Paymenttermline.UpdatedBy) as UpdatedByR," +
      "        C_Paymenttermline.C_Paymenttermline_ID, " +
      "C_Paymenttermline.AD_Client_ID, " +
      "(CASE WHEN C_Paymenttermline.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_Paymenttermline.AD_Org_ID, " +
      "(CASE WHEN C_Paymenttermline.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Paymenttermline.C_PaymentTerm_ID, " +
      "(CASE WHEN C_Paymenttermline.C_PaymentTerm_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_PaymentTerm_IDR, " +
      "COALESCE(C_Paymenttermline.IsActive, 'N') AS IsActive, " +
      "C_Paymenttermline.Line, " +
      "C_Paymenttermline.Percentage, " +
      "COALESCE(C_Paymenttermline.Excludetax, 'N') AS Excludetax, " +
      "C_Paymenttermline.FixMonthCutoff, " +
      "C_Paymenttermline.FixMonthOffset, " +
      "C_Paymenttermline.NetDays, " +
      "C_Paymenttermline.NetDay, " +
      "(CASE WHEN C_Paymenttermline.NetDay IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS NetDayR, " +
      "COALESCE(C_Paymenttermline.IsNextBusinessDay, 'N') AS IsNextBusinessDay, " +
      "C_Paymenttermline.PaymentRule, " +
      "(CASE WHEN C_Paymenttermline.PaymentRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS PaymentRuleR, " +
      "COALESCE(C_Paymenttermline.IsDueFixed, 'N') AS IsDueFixed, " +
      "C_Paymenttermline.FixMonthDay, " +
      "C_Paymenttermline.FixMonthDay2, " +
      "C_Paymenttermline.Fixmonthday3, " +
      "COALESCE(C_Paymenttermline.Onremainder, 'N') AS Onremainder, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Paymenttermline left join (select AD_Client_ID, Name from AD_Client) table1 on (C_Paymenttermline.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_Paymenttermline.AD_Org_ID = table2.AD_Org_ID) left join (select C_PaymentTerm_ID, Name from C_PaymentTerm) table3 on (C_Paymenttermline.C_PaymentTerm_ID = table3.C_PaymentTerm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL3 on (table3.C_PaymentTerm_ID = tableTRL3.C_PaymentTerm_ID and tableTRL3.AD_Language = ?)  left join ad_ref_list_v list1 on (C_Paymenttermline.NetDay = list1.value and list1.ad_reference_id = '167' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (C_Paymenttermline.PaymentRule = list2.value and list2.ad_reference_id = '195' and list2.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cPaymenttermId==null || cPaymenttermId.equals(""))?"":"  AND C_Paymenttermline.C_PaymentTerm_ID = ?  ");
    strSql = strSql + 
      "        AND C_Paymenttermline.C_Paymenttermline_ID = ? " +
      "        AND C_Paymenttermline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Paymenttermline.AD_Org_ID IN (";
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
      if (cPaymenttermId != null && !(cPaymenttermId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
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
        PartialPaymentData objectPartialPaymentData = new PartialPaymentData();
        objectPartialPaymentData.created = UtilSql.getValue(result, "created");
        objectPartialPaymentData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPartialPaymentData.updated = UtilSql.getValue(result, "updated");
        objectPartialPaymentData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPartialPaymentData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPartialPaymentData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPartialPaymentData.cPaymenttermlineId = UtilSql.getValue(result, "c_paymenttermline_id");
        objectPartialPaymentData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPartialPaymentData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectPartialPaymentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPartialPaymentData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPartialPaymentData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectPartialPaymentData.cPaymenttermIdr = UtilSql.getValue(result, "c_paymentterm_idr");
        objectPartialPaymentData.isactive = UtilSql.getValue(result, "isactive");
        objectPartialPaymentData.line = UtilSql.getValue(result, "line");
        objectPartialPaymentData.percentage = UtilSql.getValue(result, "percentage");
        objectPartialPaymentData.excludetax = UtilSql.getValue(result, "excludetax");
        objectPartialPaymentData.fixmonthcutoff = UtilSql.getValue(result, "fixmonthcutoff");
        objectPartialPaymentData.fixmonthoffset = UtilSql.getValue(result, "fixmonthoffset");
        objectPartialPaymentData.netdays = UtilSql.getValue(result, "netdays");
        objectPartialPaymentData.netday = UtilSql.getValue(result, "netday");
        objectPartialPaymentData.netdayr = UtilSql.getValue(result, "netdayr");
        objectPartialPaymentData.isnextbusinessday = UtilSql.getValue(result, "isnextbusinessday");
        objectPartialPaymentData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectPartialPaymentData.paymentruler = UtilSql.getValue(result, "paymentruler");
        objectPartialPaymentData.isduefixed = UtilSql.getValue(result, "isduefixed");
        objectPartialPaymentData.fixmonthday = UtilSql.getValue(result, "fixmonthday");
        objectPartialPaymentData.fixmonthday2 = UtilSql.getValue(result, "fixmonthday2");
        objectPartialPaymentData.fixmonthday3 = UtilSql.getValue(result, "fixmonthday3");
        objectPartialPaymentData.onremainder = UtilSql.getValue(result, "onremainder");
        objectPartialPaymentData.language = UtilSql.getValue(result, "language");
        objectPartialPaymentData.adUserClient = "";
        objectPartialPaymentData.adOrgClient = "";
        objectPartialPaymentData.createdby = "";
        objectPartialPaymentData.trBgcolor = "";
        objectPartialPaymentData.totalCount = "";
        objectPartialPaymentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPartialPaymentData);
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
    PartialPaymentData objectPartialPaymentData[] = new PartialPaymentData[vector.size()];
    vector.copyInto(objectPartialPaymentData);
    return(objectPartialPaymentData);
  }

/**
Create a registry
 */
  public static PartialPaymentData[] set(String cPaymenttermId, String cPaymenttermlineId, String isactive, String fixmonthoffset, String paymentrule, String fixmonthcutoff, String fixmonthday3, String netday, String excludetax, String fixmonthday2, String createdby, String createdbyr, String isnextbusinessday, String isduefixed, String line, String onremainder, String netdays, String updatedby, String updatedbyr, String adOrgId, String percentage, String adClientId, String fixmonthday)    throws ServletException {
    PartialPaymentData objectPartialPaymentData[] = new PartialPaymentData[1];
    objectPartialPaymentData[0] = new PartialPaymentData();
    objectPartialPaymentData[0].created = "";
    objectPartialPaymentData[0].createdbyr = createdbyr;
    objectPartialPaymentData[0].updated = "";
    objectPartialPaymentData[0].updatedTimeStamp = "";
    objectPartialPaymentData[0].updatedby = updatedby;
    objectPartialPaymentData[0].updatedbyr = updatedbyr;
    objectPartialPaymentData[0].cPaymenttermlineId = cPaymenttermlineId;
    objectPartialPaymentData[0].adClientId = adClientId;
    objectPartialPaymentData[0].adClientIdr = "";
    objectPartialPaymentData[0].adOrgId = adOrgId;
    objectPartialPaymentData[0].adOrgIdr = "";
    objectPartialPaymentData[0].cPaymenttermId = cPaymenttermId;
    objectPartialPaymentData[0].cPaymenttermIdr = "";
    objectPartialPaymentData[0].isactive = isactive;
    objectPartialPaymentData[0].line = line;
    objectPartialPaymentData[0].percentage = percentage;
    objectPartialPaymentData[0].excludetax = excludetax;
    objectPartialPaymentData[0].fixmonthcutoff = fixmonthcutoff;
    objectPartialPaymentData[0].fixmonthoffset = fixmonthoffset;
    objectPartialPaymentData[0].netdays = netdays;
    objectPartialPaymentData[0].netday = netday;
    objectPartialPaymentData[0].netdayr = "";
    objectPartialPaymentData[0].isnextbusinessday = isnextbusinessday;
    objectPartialPaymentData[0].paymentrule = paymentrule;
    objectPartialPaymentData[0].paymentruler = "";
    objectPartialPaymentData[0].isduefixed = isduefixed;
    objectPartialPaymentData[0].fixmonthday = fixmonthday;
    objectPartialPaymentData[0].fixmonthday2 = fixmonthday2;
    objectPartialPaymentData[0].fixmonthday3 = fixmonthday3;
    objectPartialPaymentData[0].onremainder = onremainder;
    objectPartialPaymentData[0].language = "";
    return objectPartialPaymentData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef801024_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef801028(ConnectionProvider connectionProvider, String C_PAYMENTTERM_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(LINE),0)+10 AS DefaultValue FROM C_PAYMENTTERMLINE WHERE C_PAYMENTTERM_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_PAYMENTTERM_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDef801026_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_Paymenttermline.C_PaymentTerm_ID AS NAME" +
      "        FROM C_Paymenttermline" +
      "        WHERE C_Paymenttermline.C_Paymenttermline_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String cPaymenttermId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_PaymentTerm left join (select C_PaymentTerm_ID, Name from C_PaymentTerm) table1 on (C_PaymentTerm.C_PaymentTerm_ID = table1.C_PaymentTerm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL1 on (table1.C_PaymentTerm_ID = tableTRL1.C_PaymentTerm_ID and tableTRL1.AD_Language = ?)  WHERE C_PaymentTerm.C_PaymentTerm_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String cPaymenttermId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_PaymentTerm left join (select C_PaymentTerm_ID, Name from C_PaymentTerm) table1 on (C_PaymentTerm.C_PaymentTerm_ID = table1.C_PaymentTerm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL1 on (table1.C_PaymentTerm_ID = tableTRL1.C_PaymentTerm_ID and tableTRL1.AD_Language = ?)  WHERE C_PaymentTerm.C_PaymentTerm_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);

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
      "        UPDATE C_Paymenttermline" +
      "        SET C_Paymenttermline_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_PaymentTerm_ID = (?) , IsActive = (?) , Line = TO_NUMBER(?) , Percentage = TO_NUMBER(?) , Excludetax = (?) , FixMonthCutoff = TO_NUMBER(?) , FixMonthOffset = TO_NUMBER(?) , NetDays = TO_NUMBER(?) , NetDay = (?) , IsNextBusinessDay = (?) , PaymentRule = (?) , IsDueFixed = (?) , FixMonthDay = TO_NUMBER(?) , FixMonthDay2 = TO_NUMBER(?) , Fixmonthday3 = TO_NUMBER(?) , Onremainder = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Paymenttermline.C_Paymenttermline_ID = ? " +
      "                 AND C_Paymenttermline.C_PaymentTerm_ID = ? " +
      "        AND C_Paymenttermline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Paymenttermline.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, excludetax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthcutoff);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthoffset);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, netdays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, netday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isnextbusinessday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isduefixed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthday2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthday3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onremainder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
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
      "        INSERT INTO C_Paymenttermline " +
      "        (C_Paymenttermline_ID, AD_Client_ID, AD_Org_ID, C_PaymentTerm_ID, IsActive, Line, Percentage, Excludetax, FixMonthCutoff, FixMonthOffset, NetDays, NetDay, IsNextBusinessDay, PaymentRule, IsDueFixed, FixMonthDay, FixMonthDay2, Fixmonthday3, Onremainder, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, excludetax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthcutoff);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthoffset);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, netdays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, netday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isnextbusinessday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isduefixed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthday2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthday3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onremainder);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cPaymenttermId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Paymenttermline" +
      "        WHERE C_Paymenttermline.C_Paymenttermline_ID = ? " +
      "                 AND C_Paymenttermline.C_PaymentTerm_ID = ? " +
      "        AND C_Paymenttermline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Paymenttermline.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cPaymenttermId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Paymenttermline" +
      "        WHERE C_Paymenttermline.C_Paymenttermline_ID = ? " +
      "                 AND C_Paymenttermline.C_PaymentTerm_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);

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
      "          FROM C_Paymenttermline" +
      "         WHERE C_Paymenttermline.C_Paymenttermline_ID = ? ";

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
      "          FROM C_Paymenttermline" +
      "         WHERE C_Paymenttermline.C_Paymenttermline_ID = ? ";

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
