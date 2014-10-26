//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.CommissionPayment;

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
class DetailsData implements FieldProvider {
static Logger log4j = Logger.getLogger(DetailsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cCommissiondetailId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cCommissionamtId;
  public String cCommissionamtIdr;
  public String reference;
  public String cOrderlineId;
  public String cOrderlineIdr;
  public String cInvoicelineId;
  public String cInvoicelineIdr;
  public String isactive;
  public String info;
  public String actualamt;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String convertedamt;
  public String actualqty;
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
    else if (fieldName.equalsIgnoreCase("c_commissiondetail_id") || fieldName.equals("cCommissiondetailId"))
      return cCommissiondetailId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_commissionamt_id") || fieldName.equals("cCommissionamtId"))
      return cCommissionamtId;
    else if (fieldName.equalsIgnoreCase("c_commissionamt_idr") || fieldName.equals("cCommissionamtIdr"))
      return cCommissionamtIdr;
    else if (fieldName.equalsIgnoreCase("reference"))
      return reference;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("c_orderline_idr") || fieldName.equals("cOrderlineIdr"))
      return cOrderlineIdr;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_id") || fieldName.equals("cInvoicelineId"))
      return cInvoicelineId;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_idr") || fieldName.equals("cInvoicelineIdr"))
      return cInvoicelineIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("info"))
      return info;
    else if (fieldName.equalsIgnoreCase("actualamt"))
      return actualamt;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("convertedamt"))
      return convertedamt;
    else if (fieldName.equalsIgnoreCase("actualqty"))
      return actualqty;
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
  public static DetailsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cCommissionamtId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cCommissionamtId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static DetailsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cCommissionamtId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_CommissionDetail.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_CommissionDetail.CreatedBy) as CreatedByR, " +
      "        to_char(C_CommissionDetail.Updated, ?) as updated, " +
      "        to_char(C_CommissionDetail.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_CommissionDetail.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_CommissionDetail.UpdatedBy) as UpdatedByR," +
      "        C_CommissionDetail.C_CommissionDetail_ID, " +
      "C_CommissionDetail.AD_Client_ID, " +
      "(CASE WHEN C_CommissionDetail.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_CommissionDetail.AD_Org_ID, " +
      "(CASE WHEN C_CommissionDetail.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_CommissionDetail.C_CommissionAmt_ID, " +
      "(CASE WHEN C_CommissionDetail.C_CommissionAmt_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Line), ''))),'') ) END) AS C_CommissionAmt_IDR, " +
      "C_CommissionDetail.Reference, " +
      "C_CommissionDetail.C_OrderLine_ID, " +
      "(CASE WHEN C_CommissionDetail.C_OrderLine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table8.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.GrandTotal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.LineNetAmt), ''))),'') ) END) AS C_OrderLine_IDR, " +
      "C_CommissionDetail.C_InvoiceLine_ID, " +
      "(CASE WHEN C_CommissionDetail.C_InvoiceLine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table10.DateInvoiced, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.GrandTotal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.LineNetAmt), ''))),'') ) END) AS C_InvoiceLine_IDR, " +
      "COALESCE(C_CommissionDetail.IsActive, 'N') AS IsActive, " +
      "C_CommissionDetail.Info, " +
      "C_CommissionDetail.ActualAmt, " +
      "C_CommissionDetail.C_Currency_ID, " +
      "(CASE WHEN C_CommissionDetail.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "C_CommissionDetail.ConvertedAmt, " +
      "C_CommissionDetail.ActualQty, " +
      "        ? AS LANGUAGE " +
      "        FROM C_CommissionDetail left join (select AD_Client_ID, Name from AD_Client) table1 on (C_CommissionDetail.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_CommissionDetail.AD_Org_ID = table2.AD_Org_ID) left join (select C_CommissionAmt_ID, C_CommissionRun_ID, C_CommissionLine_ID from C_CommissionAmt) table3 on (C_CommissionDetail.C_CommissionAmt_ID = table3.C_CommissionAmt_ID) left join (select C_CommissionRun_ID, DocumentNo from C_CommissionRun) table4 on (table3.C_CommissionRun_ID = table4.C_CommissionRun_ID) left join (select C_CommissionLine_ID, C_Commission_ID, Line from C_CommissionLine) table5 on (table3.C_CommissionLine_ID = table5.C_CommissionLine_ID) left join (select C_Commission_ID, Name from C_Commission) table6 on (table5.C_Commission_ID = table6.C_Commission_ID) left join (select C_OrderLine_ID, C_Order_ID, Line, LineNetAmt from C_OrderLine) table7 on (C_CommissionDetail.C_OrderLine_ID = table7.C_OrderLine_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table8 on (table7.C_Order_ID = table8.C_Order_ID) left join (select C_InvoiceLine_ID, C_Invoice_ID, Line, LineNetAmt from C_InvoiceLine) table9 on (C_CommissionDetail.C_InvoiceLine_ID = table9.C_InvoiceLine_ID) left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table10 on (table9.C_Invoice_ID = table10.C_Invoice_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table11 on (C_CommissionDetail.C_Currency_ID = table11.C_Currency_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cCommissionamtId==null || cCommissionamtId.equals(""))?"":"  AND C_CommissionDetail.C_CommissionAmt_ID = ?  ");
    strSql = strSql + 
      "        AND C_CommissionDetail.C_CommissionDetail_ID = ? " +
      "        AND C_CommissionDetail.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_CommissionDetail.AD_Org_ID IN (";
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
      if (cCommissionamtId != null && !(cCommissionamtId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionamtId);
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
        DetailsData objectDetailsData = new DetailsData();
        objectDetailsData.created = UtilSql.getValue(result, "created");
        objectDetailsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectDetailsData.updated = UtilSql.getValue(result, "updated");
        objectDetailsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectDetailsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDetailsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectDetailsData.cCommissiondetailId = UtilSql.getValue(result, "c_commissiondetail_id");
        objectDetailsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDetailsData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectDetailsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDetailsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectDetailsData.cCommissionamtId = UtilSql.getValue(result, "c_commissionamt_id");
        objectDetailsData.cCommissionamtIdr = UtilSql.getValue(result, "c_commissionamt_idr");
        objectDetailsData.reference = UtilSql.getValue(result, "reference");
        objectDetailsData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectDetailsData.cOrderlineIdr = UtilSql.getValue(result, "c_orderline_idr");
        objectDetailsData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectDetailsData.cInvoicelineIdr = UtilSql.getValue(result, "c_invoiceline_idr");
        objectDetailsData.isactive = UtilSql.getValue(result, "isactive");
        objectDetailsData.info = UtilSql.getValue(result, "info");
        objectDetailsData.actualamt = UtilSql.getValue(result, "actualamt");
        objectDetailsData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDetailsData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectDetailsData.convertedamt = UtilSql.getValue(result, "convertedamt");
        objectDetailsData.actualqty = UtilSql.getValue(result, "actualqty");
        objectDetailsData.language = UtilSql.getValue(result, "language");
        objectDetailsData.adUserClient = "";
        objectDetailsData.adOrgClient = "";
        objectDetailsData.createdby = "";
        objectDetailsData.trBgcolor = "";
        objectDetailsData.totalCount = "";
        objectDetailsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDetailsData);
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
    DetailsData objectDetailsData[] = new DetailsData[vector.size()];
    vector.copyInto(objectDetailsData);
    return(objectDetailsData);
  }

/**
Create a registry
 */
  public static DetailsData[] set(String cCommissionamtId, String reference, String actualqty, String adOrgId, String convertedamt, String cInvoicelineId, String cInvoicelineIdr, String cCurrencyId, String cCommissiondetailId, String info, String actualamt, String cOrderlineId, String cOrderlineIdr, String updatedby, String updatedbyr, String createdby, String createdbyr, String adClientId, String isactive)    throws ServletException {
    DetailsData objectDetailsData[] = new DetailsData[1];
    objectDetailsData[0] = new DetailsData();
    objectDetailsData[0].created = "";
    objectDetailsData[0].createdbyr = createdbyr;
    objectDetailsData[0].updated = "";
    objectDetailsData[0].updatedTimeStamp = "";
    objectDetailsData[0].updatedby = updatedby;
    objectDetailsData[0].updatedbyr = updatedbyr;
    objectDetailsData[0].cCommissiondetailId = cCommissiondetailId;
    objectDetailsData[0].adClientId = adClientId;
    objectDetailsData[0].adClientIdr = "";
    objectDetailsData[0].adOrgId = adOrgId;
    objectDetailsData[0].adOrgIdr = "";
    objectDetailsData[0].cCommissionamtId = cCommissionamtId;
    objectDetailsData[0].cCommissionamtIdr = "";
    objectDetailsData[0].reference = reference;
    objectDetailsData[0].cOrderlineId = cOrderlineId;
    objectDetailsData[0].cOrderlineIdr = cOrderlineIdr;
    objectDetailsData[0].cInvoicelineId = cInvoicelineId;
    objectDetailsData[0].cInvoicelineIdr = cInvoicelineIdr;
    objectDetailsData[0].isactive = isactive;
    objectDetailsData[0].info = info;
    objectDetailsData[0].actualamt = actualamt;
    objectDetailsData[0].cCurrencyId = cCurrencyId;
    objectDetailsData[0].cCurrencyIdr = "";
    objectDetailsData[0].convertedamt = convertedamt;
    objectDetailsData[0].actualqty = actualqty;
    objectDetailsData[0].language = "";
    return objectDetailsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef5838_0(ConnectionProvider connectionProvider, String C_InvoiceLine_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table2.DocumentNo), '')  || ' - ' || COALESCE(TO_CHAR(table2.DateInvoiced), '')  || ' - ' || COALESCE(TO_CHAR(table2.GrandTotal), '')  || ' - ' || COALESCE(TO_CHAR(table1.Line), '')  || ' - ' || COALESCE(TO_CHAR(table1.LineNetAmt), '') ) as C_InvoiceLine_ID FROM C_InvoiceLine table1 left join C_Invoice table2 on (table1.C_Invoice_ID = table2.C_Invoice_ID) WHERE table1.isActive='Y' AND table1.C_InvoiceLine_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_InvoiceLine_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_invoiceline_id");
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
  public static String selectDef5837_1(ConnectionProvider connectionProvider, String C_OrderLine_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table2.DocumentNo), '')  || ' - ' || COALESCE(TO_CHAR(table2.Name), '')  || ' - ' || COALESCE(TO_CHAR(table2.DateOrdered), '')  || ' - ' || COALESCE(TO_CHAR(table2.GrandTotal), '')  || ' - ' || COALESCE(TO_CHAR(table1.Line), '')  || ' - ' || COALESCE(TO_CHAR(table1.LineNetAmt), '') ) as C_OrderLine_ID FROM C_OrderLine table1 left join C_Order table2 on (table1.C_Order_ID = table2.C_Order_ID) WHERE table1.isActive='Y' AND table1.C_OrderLine_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_OrderLine_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_orderline_id");
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
  public static String selectDef5834_2(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDef5832_3(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_CommissionDetail.C_CommissionAmt_ID AS NAME" +
      "        FROM C_CommissionDetail" +
      "        WHERE C_CommissionDetail.C_CommissionDetail_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cCommissionamtId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table4.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.Line), ''))) AS NAME FROM C_CommissionAmt left join (select C_CommissionAmt_ID, C_CommissionRun_ID, C_CommissionLine_ID from C_CommissionAmt) table1 on (C_CommissionAmt.C_CommissionAmt_ID = table1.C_CommissionAmt_ID) left join (select C_CommissionRun_ID, DocumentNo from C_CommissionRun) table2 on (table1.C_CommissionRun_ID = table2.C_CommissionRun_ID) left join (select C_CommissionLine_ID, C_Commission_ID, Line from C_CommissionLine) table3 on (table1.C_CommissionLine_ID = table3.C_CommissionLine_ID) left join (select C_Commission_ID, Name from C_Commission) table4 on (table3.C_Commission_ID = table4.C_Commission_ID) WHERE C_CommissionAmt.C_CommissionAmt_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionamtId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cCommissionamtId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table4.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.Line), ''))) AS NAME FROM C_CommissionAmt left join (select C_CommissionAmt_ID, C_CommissionRun_ID, C_CommissionLine_ID from C_CommissionAmt) table1 on (C_CommissionAmt.C_CommissionAmt_ID = table1.C_CommissionAmt_ID) left join (select C_CommissionRun_ID, DocumentNo from C_CommissionRun) table2 on (table1.C_CommissionRun_ID = table2.C_CommissionRun_ID) left join (select C_CommissionLine_ID, C_Commission_ID, Line from C_CommissionLine) table3 on (table1.C_CommissionLine_ID = table3.C_CommissionLine_ID) left join (select C_Commission_ID, Name from C_Commission) table4 on (table3.C_Commission_ID = table4.C_Commission_ID) WHERE C_CommissionAmt.C_CommissionAmt_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionamtId);

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
      "        UPDATE C_CommissionDetail" +
      "        SET C_CommissionDetail_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_CommissionAmt_ID = (?) , Reference = (?) , C_OrderLine_ID = (?) , C_InvoiceLine_ID = (?) , IsActive = (?) , Info = (?) , ActualAmt = TO_NUMBER(?) , C_Currency_ID = (?) , ConvertedAmt = TO_NUMBER(?) , ActualQty = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE C_CommissionDetail.C_CommissionDetail_ID = ? " +
      "                 AND C_CommissionDetail.C_CommissionAmt_ID = ? " +
      "        AND C_CommissionDetail.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_CommissionDetail.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissiondetailId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionamtId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, info);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, convertedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissiondetailId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionamtId);
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
      "        INSERT INTO C_CommissionDetail " +
      "        (C_CommissionDetail_ID, AD_Client_ID, AD_Org_ID, C_CommissionAmt_ID, Reference, C_OrderLine_ID, C_InvoiceLine_ID, IsActive, Info, ActualAmt, C_Currency_ID, ConvertedAmt, ActualQty, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissiondetailId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionamtId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, info);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, convertedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualqty);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cCommissionamtId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_CommissionDetail" +
      "        WHERE C_CommissionDetail.C_CommissionDetail_ID = ? " +
      "                 AND C_CommissionDetail.C_CommissionAmt_ID = ? " +
      "        AND C_CommissionDetail.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_CommissionDetail.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionamtId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cCommissionamtId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_CommissionDetail" +
      "        WHERE C_CommissionDetail.C_CommissionDetail_ID = ? " +
      "                 AND C_CommissionDetail.C_CommissionAmt_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionamtId);

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
      "          FROM C_CommissionDetail" +
      "         WHERE C_CommissionDetail.C_CommissionDetail_ID = ? ";

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
      "          FROM C_CommissionDetail" +
      "         WHERE C_CommissionDetail.C_CommissionDetail_ID = ? ";

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
