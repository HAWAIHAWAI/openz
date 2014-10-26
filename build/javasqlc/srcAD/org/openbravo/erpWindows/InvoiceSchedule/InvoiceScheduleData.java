//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.InvoiceSchedule;

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
class InvoiceScheduleData implements FieldProvider {
static Logger log4j = Logger.getLogger(InvoiceScheduleData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String name;
  public String description;
  public String isactive;
  public String isdefault;
  public String invoicefrequency;
  public String invoicefrequencyr;
  public String invoiceday;
  public String cInvoicescheduleId;
  public String invoiceweekday;
  public String amt;
  public String eveninvoiceweek;
  public String invoicedaycutoff;
  public String invoiceweekdaycutoff;
  public String isamount;
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
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("invoicefrequency"))
      return invoicefrequency;
    else if (fieldName.equalsIgnoreCase("invoicefrequencyr"))
      return invoicefrequencyr;
    else if (fieldName.equalsIgnoreCase("invoiceday"))
      return invoiceday;
    else if (fieldName.equalsIgnoreCase("c_invoiceschedule_id") || fieldName.equals("cInvoicescheduleId"))
      return cInvoicescheduleId;
    else if (fieldName.equalsIgnoreCase("invoiceweekday"))
      return invoiceweekday;
    else if (fieldName.equalsIgnoreCase("amt"))
      return amt;
    else if (fieldName.equalsIgnoreCase("eveninvoiceweek"))
      return eveninvoiceweek;
    else if (fieldName.equalsIgnoreCase("invoicedaycutoff"))
      return invoicedaycutoff;
    else if (fieldName.equalsIgnoreCase("invoiceweekdaycutoff"))
      return invoiceweekdaycutoff;
    else if (fieldName.equalsIgnoreCase("isamount"))
      return isamount;
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
  public static InvoiceScheduleData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static InvoiceScheduleData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_InvoiceSchedule.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_InvoiceSchedule.CreatedBy) as CreatedByR, " +
      "        to_char(C_InvoiceSchedule.Updated, ?) as updated, " +
      "        to_char(C_InvoiceSchedule.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_InvoiceSchedule.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_InvoiceSchedule.UpdatedBy) as UpdatedByR," +
      "        C_InvoiceSchedule.AD_Client_ID, " +
      "(CASE WHEN C_InvoiceSchedule.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_InvoiceSchedule.AD_Org_ID, " +
      "(CASE WHEN C_InvoiceSchedule.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_InvoiceSchedule.Name, " +
      "C_InvoiceSchedule.Description, " +
      "COALESCE(C_InvoiceSchedule.IsActive, 'N') AS IsActive, " +
      "COALESCE(C_InvoiceSchedule.IsDefault, 'N') AS IsDefault, " +
      "C_InvoiceSchedule.InvoiceFrequency, " +
      "(CASE WHEN C_InvoiceSchedule.InvoiceFrequency IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS InvoiceFrequencyR, " +
      "C_InvoiceSchedule.InvoiceDay, " +
      "C_InvoiceSchedule.C_InvoiceSchedule_ID, " +
      "C_InvoiceSchedule.InvoiceWeekDay, " +
      "C_InvoiceSchedule.Amt, " +
      "COALESCE(C_InvoiceSchedule.EvenInvoiceWeek, 'N') AS EvenInvoiceWeek, " +
      "C_InvoiceSchedule.InvoiceDayCutoff, " +
      "C_InvoiceSchedule.InvoiceWeekDayCutoff, " +
      "COALESCE(C_InvoiceSchedule.IsAmount, 'N') AS IsAmount, " +
      "        ? AS LANGUAGE " +
      "        FROM C_InvoiceSchedule left join (select AD_Client_ID, Name from AD_Client) table1 on (C_InvoiceSchedule.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_InvoiceSchedule.AD_Org_ID = table2.AD_Org_ID) left join ad_ref_list_v list1 on (C_InvoiceSchedule.InvoiceFrequency = list1.value and list1.ad_reference_id = '168' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_InvoiceSchedule.C_InvoiceSchedule_ID = ? " +
      "        AND C_InvoiceSchedule.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_InvoiceSchedule.AD_Org_ID IN (";
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
        InvoiceScheduleData objectInvoiceScheduleData = new InvoiceScheduleData();
        objectInvoiceScheduleData.created = UtilSql.getValue(result, "created");
        objectInvoiceScheduleData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectInvoiceScheduleData.updated = UtilSql.getValue(result, "updated");
        objectInvoiceScheduleData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectInvoiceScheduleData.updatedby = UtilSql.getValue(result, "updatedby");
        objectInvoiceScheduleData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectInvoiceScheduleData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectInvoiceScheduleData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectInvoiceScheduleData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectInvoiceScheduleData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectInvoiceScheduleData.name = UtilSql.getValue(result, "name");
        objectInvoiceScheduleData.description = UtilSql.getValue(result, "description");
        objectInvoiceScheduleData.isactive = UtilSql.getValue(result, "isactive");
        objectInvoiceScheduleData.isdefault = UtilSql.getValue(result, "isdefault");
        objectInvoiceScheduleData.invoicefrequency = UtilSql.getValue(result, "invoicefrequency");
        objectInvoiceScheduleData.invoicefrequencyr = UtilSql.getValue(result, "invoicefrequencyr");
        objectInvoiceScheduleData.invoiceday = UtilSql.getValue(result, "invoiceday");
        objectInvoiceScheduleData.cInvoicescheduleId = UtilSql.getValue(result, "c_invoiceschedule_id");
        objectInvoiceScheduleData.invoiceweekday = UtilSql.getValue(result, "invoiceweekday");
        objectInvoiceScheduleData.amt = UtilSql.getValue(result, "amt");
        objectInvoiceScheduleData.eveninvoiceweek = UtilSql.getValue(result, "eveninvoiceweek");
        objectInvoiceScheduleData.invoicedaycutoff = UtilSql.getValue(result, "invoicedaycutoff");
        objectInvoiceScheduleData.invoiceweekdaycutoff = UtilSql.getValue(result, "invoiceweekdaycutoff");
        objectInvoiceScheduleData.isamount = UtilSql.getValue(result, "isamount");
        objectInvoiceScheduleData.language = UtilSql.getValue(result, "language");
        objectInvoiceScheduleData.adUserClient = "";
        objectInvoiceScheduleData.adOrgClient = "";
        objectInvoiceScheduleData.createdby = "";
        objectInvoiceScheduleData.trBgcolor = "";
        objectInvoiceScheduleData.totalCount = "";
        objectInvoiceScheduleData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInvoiceScheduleData);
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
    InvoiceScheduleData objectInvoiceScheduleData[] = new InvoiceScheduleData[vector.size()];
    vector.copyInto(objectInvoiceScheduleData);
    return(objectInvoiceScheduleData);
  }

/**
Create a registry
 */
  public static InvoiceScheduleData[] set(String invoiceweekday, String invoiceday, String name, String invoicedaycutoff, String isactive, String createdby, String createdbyr, String description, String invoicefrequency, String invoiceweekdaycutoff, String eveninvoiceweek, String cInvoicescheduleId, String isamount, String updatedby, String updatedbyr, String amt, String adClientId, String adOrgId, String isdefault)    throws ServletException {
    InvoiceScheduleData objectInvoiceScheduleData[] = new InvoiceScheduleData[1];
    objectInvoiceScheduleData[0] = new InvoiceScheduleData();
    objectInvoiceScheduleData[0].created = "";
    objectInvoiceScheduleData[0].createdbyr = createdbyr;
    objectInvoiceScheduleData[0].updated = "";
    objectInvoiceScheduleData[0].updatedTimeStamp = "";
    objectInvoiceScheduleData[0].updatedby = updatedby;
    objectInvoiceScheduleData[0].updatedbyr = updatedbyr;
    objectInvoiceScheduleData[0].adClientId = adClientId;
    objectInvoiceScheduleData[0].adClientIdr = "";
    objectInvoiceScheduleData[0].adOrgId = adOrgId;
    objectInvoiceScheduleData[0].adOrgIdr = "";
    objectInvoiceScheduleData[0].name = name;
    objectInvoiceScheduleData[0].description = description;
    objectInvoiceScheduleData[0].isactive = isactive;
    objectInvoiceScheduleData[0].isdefault = isdefault;
    objectInvoiceScheduleData[0].invoicefrequency = invoicefrequency;
    objectInvoiceScheduleData[0].invoicefrequencyr = "";
    objectInvoiceScheduleData[0].invoiceday = invoiceday;
    objectInvoiceScheduleData[0].cInvoicescheduleId = cInvoicescheduleId;
    objectInvoiceScheduleData[0].invoiceweekday = invoiceweekday;
    objectInvoiceScheduleData[0].amt = amt;
    objectInvoiceScheduleData[0].eveninvoiceweek = eveninvoiceweek;
    objectInvoiceScheduleData[0].invoicedaycutoff = invoicedaycutoff;
    objectInvoiceScheduleData[0].invoiceweekdaycutoff = invoiceweekdaycutoff;
    objectInvoiceScheduleData[0].isamount = isamount;
    objectInvoiceScheduleData[0].language = "";
    return objectInvoiceScheduleData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2141_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef2143_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_InvoiceSchedule" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , Name = (?) , Description = (?) , IsActive = (?) , IsDefault = (?) , InvoiceFrequency = (?) , InvoiceDay = TO_NUMBER(?) , C_InvoiceSchedule_ID = (?) , InvoiceWeekDay = (?) , Amt = TO_NUMBER(?) , EvenInvoiceWeek = (?) , InvoiceDayCutoff = TO_NUMBER(?) , InvoiceWeekDayCutoff = (?) , IsAmount = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_InvoiceSchedule.C_InvoiceSchedule_ID = ? " +
      "        AND C_InvoiceSchedule.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_InvoiceSchedule.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicefrequency);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicescheduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceweekday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, eveninvoiceweek);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedaycutoff);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceweekdaycutoff);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicescheduleId);
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
      "        INSERT INTO C_InvoiceSchedule " +
      "        (AD_Client_ID, AD_Org_ID, Name, Description, IsActive, IsDefault, InvoiceFrequency, InvoiceDay, C_InvoiceSchedule_ID, InvoiceWeekDay, Amt, EvenInvoiceWeek, InvoiceDayCutoff, InvoiceWeekDayCutoff, IsAmount, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicefrequency);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicescheduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceweekday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, eveninvoiceweek);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedaycutoff);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceweekdaycutoff);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isamount);
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
      "        DELETE FROM C_InvoiceSchedule" +
      "        WHERE C_InvoiceSchedule.C_InvoiceSchedule_ID = ? " +
      "        AND C_InvoiceSchedule.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_InvoiceSchedule.AD_Org_ID IN (";
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
      "        DELETE FROM C_InvoiceSchedule" +
      "        WHERE C_InvoiceSchedule.C_InvoiceSchedule_ID = ? ";

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
      "          FROM C_InvoiceSchedule" +
      "         WHERE C_InvoiceSchedule.C_InvoiceSchedule_ID = ? ";

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
      "          FROM C_InvoiceSchedule" +
      "         WHERE C_InvoiceSchedule.C_InvoiceSchedule_ID = ? ";

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
