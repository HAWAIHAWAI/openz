//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.SalesInvoice;

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
class PriceAdjustmentsData implements FieldProvider {
static Logger log4j = Logger.getLogger(PriceAdjustmentsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cInvoicelineId;
  public String adClientId;
  public String adClientIdr;
  public String cInvoicelineOfferId;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String mOfferId;
  public String mOfferIdr;
  public String line;
  public String amtoffer;
  public String priceoffer;
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
    else if (fieldName.equalsIgnoreCase("c_invoiceline_id") || fieldName.equals("cInvoicelineId"))
      return cInvoicelineId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_offer_id") || fieldName.equals("cInvoicelineOfferId"))
      return cInvoicelineOfferId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("m_offer_id") || fieldName.equals("mOfferId"))
      return mOfferId;
    else if (fieldName.equalsIgnoreCase("m_offer_idr") || fieldName.equals("mOfferIdr"))
      return mOfferIdr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("amtoffer"))
      return amtoffer;
    else if (fieldName.equalsIgnoreCase("priceoffer"))
      return priceoffer;
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
  public static PriceAdjustmentsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cInvoicelineId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cInvoicelineId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PriceAdjustmentsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cInvoicelineId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_InvoiceLine_Offer.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_InvoiceLine_Offer.CreatedBy) as CreatedByR, " +
      "        to_char(C_InvoiceLine_Offer.Updated, ?) as updated, " +
      "        to_char(C_InvoiceLine_Offer.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_InvoiceLine_Offer.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_InvoiceLine_Offer.UpdatedBy) as UpdatedByR," +
      "        C_InvoiceLine_Offer.C_InvoiceLine_ID, " +
      "C_InvoiceLine_Offer.AD_Client_ID, " +
      "(CASE WHEN C_InvoiceLine_Offer.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_InvoiceLine_Offer.C_Invoiceline_Offer_ID, " +
      "C_InvoiceLine_Offer.AD_Org_ID, " +
      "(CASE WHEN C_InvoiceLine_Offer.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(C_InvoiceLine_Offer.IsActive, 'N') AS IsActive, " +
      "C_InvoiceLine_Offer.M_Offer_ID, " +
      "(CASE WHEN C_InvoiceLine_Offer.M_Offer_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS M_Offer_IDR, " +
      "C_InvoiceLine_Offer.Line, " +
      "C_InvoiceLine_Offer.Amtoffer, " +
      "C_InvoiceLine_Offer.Priceoffer, " +
      "        ? AS LANGUAGE " +
      "        FROM C_InvoiceLine_Offer left join (select AD_Client_ID, Name from AD_Client) table1 on (C_InvoiceLine_Offer.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_InvoiceLine_Offer.AD_Org_ID = table2.AD_Org_ID) left join (select M_Offer_ID, Name from M_Offer) table3 on (C_InvoiceLine_Offer.M_Offer_ID = table3.M_Offer_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cInvoicelineId==null || cInvoicelineId.equals(""))?"":"  AND C_InvoiceLine_Offer.C_InvoiceLine_ID = ?  ");
    strSql = strSql + 
      "        AND C_InvoiceLine_Offer.C_Invoiceline_Offer_ID = ? " +
      "        AND C_InvoiceLine_Offer.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_InvoiceLine_Offer.AD_Org_ID IN (";
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
      if (cInvoicelineId != null && !(cInvoicelineId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
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
        PriceAdjustmentsData objectPriceAdjustmentsData = new PriceAdjustmentsData();
        objectPriceAdjustmentsData.created = UtilSql.getValue(result, "created");
        objectPriceAdjustmentsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPriceAdjustmentsData.updated = UtilSql.getValue(result, "updated");
        objectPriceAdjustmentsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPriceAdjustmentsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPriceAdjustmentsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPriceAdjustmentsData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectPriceAdjustmentsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPriceAdjustmentsData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectPriceAdjustmentsData.cInvoicelineOfferId = UtilSql.getValue(result, "c_invoiceline_offer_id");
        objectPriceAdjustmentsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPriceAdjustmentsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPriceAdjustmentsData.isactive = UtilSql.getValue(result, "isactive");
        objectPriceAdjustmentsData.mOfferId = UtilSql.getValue(result, "m_offer_id");
        objectPriceAdjustmentsData.mOfferIdr = UtilSql.getValue(result, "m_offer_idr");
        objectPriceAdjustmentsData.line = UtilSql.getValue(result, "line");
        objectPriceAdjustmentsData.amtoffer = UtilSql.getValue(result, "amtoffer");
        objectPriceAdjustmentsData.priceoffer = UtilSql.getValue(result, "priceoffer");
        objectPriceAdjustmentsData.language = UtilSql.getValue(result, "language");
        objectPriceAdjustmentsData.adUserClient = "";
        objectPriceAdjustmentsData.adOrgClient = "";
        objectPriceAdjustmentsData.createdby = "";
        objectPriceAdjustmentsData.trBgcolor = "";
        objectPriceAdjustmentsData.totalCount = "";
        objectPriceAdjustmentsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPriceAdjustmentsData);
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
    PriceAdjustmentsData objectPriceAdjustmentsData[] = new PriceAdjustmentsData[vector.size()];
    vector.copyInto(objectPriceAdjustmentsData);
    return(objectPriceAdjustmentsData);
  }

/**
Create a registry
 */
  public static PriceAdjustmentsData[] set(String cInvoicelineId, String priceoffer, String createdby, String createdbyr, String isactive, String updatedby, String updatedbyr, String line, String cInvoicelineOfferId, String adOrgId, String amtoffer, String adClientId, String mOfferId)    throws ServletException {
    PriceAdjustmentsData objectPriceAdjustmentsData[] = new PriceAdjustmentsData[1];
    objectPriceAdjustmentsData[0] = new PriceAdjustmentsData();
    objectPriceAdjustmentsData[0].created = "";
    objectPriceAdjustmentsData[0].createdbyr = createdbyr;
    objectPriceAdjustmentsData[0].updated = "";
    objectPriceAdjustmentsData[0].updatedTimeStamp = "";
    objectPriceAdjustmentsData[0].updatedby = updatedby;
    objectPriceAdjustmentsData[0].updatedbyr = updatedbyr;
    objectPriceAdjustmentsData[0].cInvoicelineId = cInvoicelineId;
    objectPriceAdjustmentsData[0].adClientId = adClientId;
    objectPriceAdjustmentsData[0].adClientIdr = "";
    objectPriceAdjustmentsData[0].cInvoicelineOfferId = cInvoicelineOfferId;
    objectPriceAdjustmentsData[0].adOrgId = adOrgId;
    objectPriceAdjustmentsData[0].adOrgIdr = "";
    objectPriceAdjustmentsData[0].isactive = isactive;
    objectPriceAdjustmentsData[0].mOfferId = mOfferId;
    objectPriceAdjustmentsData[0].mOfferIdr = "";
    objectPriceAdjustmentsData[0].line = line;
    objectPriceAdjustmentsData[0].amtoffer = amtoffer;
    objectPriceAdjustmentsData[0].priceoffer = priceoffer;
    objectPriceAdjustmentsData[0].language = "";
    return objectPriceAdjustmentsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef803126_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef803128_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef803130(ConnectionProvider connectionProvider, String C_INVOICELINE_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(LINE),0)+10 AS DefaultValue FROM C_INVOICELINE_OFFER WHERE C_INVOICELINE_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_INVOICELINE_ID);

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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_InvoiceLine_Offer.C_InvoiceLine_ID AS NAME" +
      "        FROM C_InvoiceLine_Offer" +
      "        WHERE C_InvoiceLine_Offer.C_Invoiceline_Offer_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cInvoicelineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.DocumentNo), '')) || ' - ' || TO_CHAR(table2.DateInvoiced, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.GrandTotal), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Line), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.LineNetAmt), ''))) AS NAME FROM C_InvoiceLine left join (select C_InvoiceLine_ID, C_Invoice_ID, Line, LineNetAmt from C_InvoiceLine) table1 on (C_InvoiceLine.C_InvoiceLine_ID = table1.C_InvoiceLine_ID) left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table2 on (table1.C_Invoice_ID = table2.C_Invoice_ID) WHERE C_InvoiceLine.C_InvoiceLine_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cInvoicelineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.DocumentNo), '')) || ' - ' || TO_CHAR(table2.DateInvoiced, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.GrandTotal), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Line), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.LineNetAmt), ''))) AS NAME FROM C_InvoiceLine left join (select C_InvoiceLine_ID, C_Invoice_ID, Line, LineNetAmt from C_InvoiceLine) table1 on (C_InvoiceLine.C_InvoiceLine_ID = table1.C_InvoiceLine_ID) left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table2 on (table1.C_Invoice_ID = table2.C_Invoice_ID) WHERE C_InvoiceLine.C_InvoiceLine_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);

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
      "        UPDATE C_InvoiceLine_Offer" +
      "        SET C_InvoiceLine_ID = (?) , AD_Client_ID = (?) , C_Invoiceline_Offer_ID = (?) , AD_Org_ID = (?) , IsActive = (?) , M_Offer_ID = (?) , Line = TO_NUMBER(?) , Amtoffer = TO_NUMBER(?) , Priceoffer = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE C_InvoiceLine_Offer.C_Invoiceline_Offer_ID = ? " +
      "                 AND C_InvoiceLine_Offer.C_InvoiceLine_ID = ? " +
      "        AND C_InvoiceLine_Offer.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_InvoiceLine_Offer.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineOfferId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mOfferId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtoffer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceoffer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineOfferId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
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
      "        INSERT INTO C_InvoiceLine_Offer " +
      "        (C_InvoiceLine_ID, AD_Client_ID, C_Invoiceline_Offer_ID, AD_Org_ID, IsActive, M_Offer_ID, Line, Amtoffer, Priceoffer, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineOfferId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mOfferId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtoffer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceoffer);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cInvoicelineId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_InvoiceLine_Offer" +
      "        WHERE C_InvoiceLine_Offer.C_Invoiceline_Offer_ID = ? " +
      "                 AND C_InvoiceLine_Offer.C_InvoiceLine_ID = ? " +
      "        AND C_InvoiceLine_Offer.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_InvoiceLine_Offer.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cInvoicelineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_InvoiceLine_Offer" +
      "        WHERE C_InvoiceLine_Offer.C_Invoiceline_Offer_ID = ? " +
      "                 AND C_InvoiceLine_Offer.C_InvoiceLine_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);

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
      "          FROM C_InvoiceLine_Offer" +
      "         WHERE C_InvoiceLine_Offer.C_Invoiceline_Offer_ID = ? ";

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
      "          FROM C_InvoiceLine_Offer" +
      "         WHERE C_InvoiceLine_Offer.C_Invoiceline_Offer_ID = ? ";

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
