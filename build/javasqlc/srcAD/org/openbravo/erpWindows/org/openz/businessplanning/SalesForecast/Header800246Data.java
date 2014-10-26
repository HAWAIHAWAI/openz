//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openz.businessplanning.SalesForecast;

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
class Header800246Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Header800246Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String bplSalesforecastId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String rating;
  public String description;
  public String salesrepId;
  public String salesrepIdr;
  public String estpropability;
  public String estpropabilityr;
  public String startdate;
  public String linenetamt;
  public String adjustedStartdate;
  public String adjustedEnddate;
  public String adjustedAmt;
  public String isactive;
  public String offeredamtfirstquarter;
  public String offeredamtsecondquarter;
  public String orderedamtfirstquarter;
  public String orderedamtsecondquarter;
  public String invoicedamtfirstquarter;
  public String invoicedamtsecondquarter;
  public String offeredamtthirdquarter;
  public String offeredamtfourthquarter;
  public String orderedamtthirdquarter;
  public String orderedamtfourthquarter;
  public String invoicedamtthirdquarter;
  public String invoicedamtfourthquarter;
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
    else if (fieldName.equalsIgnoreCase("bpl_salesforecast_id") || fieldName.equals("bplSalesforecastId"))
      return bplSalesforecastId;
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
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("rating"))
      return rating;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("estpropability"))
      return estpropability;
    else if (fieldName.equalsIgnoreCase("estpropabilityr"))
      return estpropabilityr;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("adjusted_startdate") || fieldName.equals("adjustedStartdate"))
      return adjustedStartdate;
    else if (fieldName.equalsIgnoreCase("adjusted_enddate") || fieldName.equals("adjustedEnddate"))
      return adjustedEnddate;
    else if (fieldName.equalsIgnoreCase("adjusted_amt") || fieldName.equals("adjustedAmt"))
      return adjustedAmt;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("offeredamtfirstquarter"))
      return offeredamtfirstquarter;
    else if (fieldName.equalsIgnoreCase("offeredamtsecondquarter"))
      return offeredamtsecondquarter;
    else if (fieldName.equalsIgnoreCase("orderedamtfirstquarter"))
      return orderedamtfirstquarter;
    else if (fieldName.equalsIgnoreCase("orderedamtsecondquarter"))
      return orderedamtsecondquarter;
    else if (fieldName.equalsIgnoreCase("invoicedamtfirstquarter"))
      return invoicedamtfirstquarter;
    else if (fieldName.equalsIgnoreCase("invoicedamtsecondquarter"))
      return invoicedamtsecondquarter;
    else if (fieldName.equalsIgnoreCase("offeredamtthirdquarter"))
      return offeredamtthirdquarter;
    else if (fieldName.equalsIgnoreCase("offeredamtfourthquarter"))
      return offeredamtfourthquarter;
    else if (fieldName.equalsIgnoreCase("orderedamtthirdquarter"))
      return orderedamtthirdquarter;
    else if (fieldName.equalsIgnoreCase("orderedamtfourthquarter"))
      return orderedamtfourthquarter;
    else if (fieldName.equalsIgnoreCase("invoicedamtthirdquarter"))
      return invoicedamtthirdquarter;
    else if (fieldName.equalsIgnoreCase("invoicedamtfourthquarter"))
      return invoicedamtfourthquarter;
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
  public static Header800246Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Header800246Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(bpl_salesforecast.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = bpl_salesforecast.CreatedBy) as CreatedByR, " +
      "        to_char(bpl_salesforecast.Updated, ?) as updated, " +
      "        to_char(bpl_salesforecast.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        bpl_salesforecast.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = bpl_salesforecast.UpdatedBy) as UpdatedByR," +
      "        bpl_salesforecast.BPL_Salesforecast_ID, " +
      "bpl_salesforecast.AD_Client_ID, " +
      "(CASE WHEN bpl_salesforecast.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "bpl_salesforecast.AD_Org_ID, " +
      "(CASE WHEN bpl_salesforecast.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "bpl_salesforecast.C_Bpartner_ID, " +
      "(CASE WHEN bpl_salesforecast.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "bpl_salesforecast.Rating, " +
      "bpl_salesforecast.Description, " +
      "bpl_salesforecast.Salesrep_ID, " +
      "(CASE WHEN bpl_salesforecast.Salesrep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS Salesrep_IDR, " +
      "bpl_salesforecast.Estpropability, " +
      "(CASE WHEN bpl_salesforecast.Estpropability IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS EstpropabilityR, " +
      "bpl_salesforecast.Startdate, " +
      "bpl_salesforecast.Linenetamt, " +
      "bpl_salesforecast.Adjusted_Startdate, " +
      "bpl_salesforecast.Adjusted_Enddate, " +
      "bpl_salesforecast.Adjusted_Amt, " +
      "COALESCE(bpl_salesforecast.Isactive, 'N') AS Isactive, " +
      "bpl_salesforecast.Offeredamtfirstquarter, " +
      "bpl_salesforecast.Offeredamtsecondquarter, " +
      "bpl_salesforecast.Orderedamtfirstquarter, " +
      "bpl_salesforecast.Orderedamtsecondquarter, " +
      "bpl_salesforecast.Invoicedamtfirstquarter, " +
      "bpl_salesforecast.Invoicedamtsecondquarter, " +
      "bpl_salesforecast.Offeredamtthirdquarter, " +
      "bpl_salesforecast.Offeredamtfourthquarter, " +
      "bpl_salesforecast.Orderedamtthirdquarter, " +
      "bpl_salesforecast.Orderedamtfourthquarter, " +
      "bpl_salesforecast.Invoicedamtthirdquarter, " +
      "bpl_salesforecast.Invoicedamtfourthquarter, " +
      "        ? AS LANGUAGE " +
      "        FROM bpl_salesforecast left join (select AD_Client_ID, Name from AD_Client) table1 on (bpl_salesforecast.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (bpl_salesforecast.AD_Org_ID = table2.AD_Org_ID) left join (select C_BPartner_ID, Name from C_BPartner) table3 on (bpl_salesforecast.C_Bpartner_ID = table3.C_BPartner_ID) left join (select AD_User_ID, Name from AD_User) table4 on (bpl_salesforecast.Salesrep_ID =  table4.AD_User_ID) left join ad_ref_list_v list1 on (bpl_salesforecast.Estpropability = list1.value and list1.ad_reference_id = 'DD6AA16AB1DD4DF5AD11A2665AE665BC' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND bpl_salesforecast.BPL_Salesforecast_ID = ? " +
      "        AND bpl_salesforecast.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND bpl_salesforecast.AD_Org_ID IN (";
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
        Header800246Data objectHeader800246Data = new Header800246Data();
        objectHeader800246Data.created = UtilSql.getValue(result, "created");
        objectHeader800246Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectHeader800246Data.updated = UtilSql.getValue(result, "updated");
        objectHeader800246Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectHeader800246Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectHeader800246Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectHeader800246Data.bplSalesforecastId = UtilSql.getValue(result, "bpl_salesforecast_id");
        objectHeader800246Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectHeader800246Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectHeader800246Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectHeader800246Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectHeader800246Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectHeader800246Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectHeader800246Data.rating = UtilSql.getValue(result, "rating");
        objectHeader800246Data.description = UtilSql.getValue(result, "description");
        objectHeader800246Data.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectHeader800246Data.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectHeader800246Data.estpropability = UtilSql.getValue(result, "estpropability");
        objectHeader800246Data.estpropabilityr = UtilSql.getValue(result, "estpropabilityr");
        objectHeader800246Data.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectHeader800246Data.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectHeader800246Data.adjustedStartdate = UtilSql.getDateValue(result, "adjusted_startdate", "dd-MM-yyyy");
        objectHeader800246Data.adjustedEnddate = UtilSql.getDateValue(result, "adjusted_enddate", "dd-MM-yyyy");
        objectHeader800246Data.adjustedAmt = UtilSql.getValue(result, "adjusted_amt");
        objectHeader800246Data.isactive = UtilSql.getValue(result, "isactive");
        objectHeader800246Data.offeredamtfirstquarter = UtilSql.getValue(result, "offeredamtfirstquarter");
        objectHeader800246Data.offeredamtsecondquarter = UtilSql.getValue(result, "offeredamtsecondquarter");
        objectHeader800246Data.orderedamtfirstquarter = UtilSql.getValue(result, "orderedamtfirstquarter");
        objectHeader800246Data.orderedamtsecondquarter = UtilSql.getValue(result, "orderedamtsecondquarter");
        objectHeader800246Data.invoicedamtfirstquarter = UtilSql.getValue(result, "invoicedamtfirstquarter");
        objectHeader800246Data.invoicedamtsecondquarter = UtilSql.getValue(result, "invoicedamtsecondquarter");
        objectHeader800246Data.offeredamtthirdquarter = UtilSql.getValue(result, "offeredamtthirdquarter");
        objectHeader800246Data.offeredamtfourthquarter = UtilSql.getValue(result, "offeredamtfourthquarter");
        objectHeader800246Data.orderedamtthirdquarter = UtilSql.getValue(result, "orderedamtthirdquarter");
        objectHeader800246Data.orderedamtfourthquarter = UtilSql.getValue(result, "orderedamtfourthquarter");
        objectHeader800246Data.invoicedamtthirdquarter = UtilSql.getValue(result, "invoicedamtthirdquarter");
        objectHeader800246Data.invoicedamtfourthquarter = UtilSql.getValue(result, "invoicedamtfourthquarter");
        objectHeader800246Data.language = UtilSql.getValue(result, "language");
        objectHeader800246Data.adUserClient = "";
        objectHeader800246Data.adOrgClient = "";
        objectHeader800246Data.createdby = "";
        objectHeader800246Data.trBgcolor = "";
        objectHeader800246Data.totalCount = "";
        objectHeader800246Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectHeader800246Data);
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
    Header800246Data objectHeader800246Data[] = new Header800246Data[vector.size()];
    vector.copyInto(objectHeader800246Data);
    return(objectHeader800246Data);
  }

/**
Create a registry
 */
  public static Header800246Data[] set(String orderedamtfirstquarter, String offeredamtfourthquarter, String linenetamt, String adClientId, String invoicedamtsecondquarter, String invoicedamtfourthquarter, String salesrepId, String createdby, String createdbyr, String orderedamtfourthquarter, String bplSalesforecastId, String orderedamtsecondquarter, String description, String offeredamtthirdquarter, String orderedamtthirdquarter, String adjustedAmt, String rating, String startdate, String invoicedamtfirstquarter, String offeredamtsecondquarter, String offeredamtfirstquarter, String adjustedStartdate, String updatedby, String updatedbyr, String isactive, String cBpartnerId, String cBpartnerIdr, String adjustedEnddate, String invoicedamtthirdquarter, String estpropability, String adOrgId)    throws ServletException {
    Header800246Data objectHeader800246Data[] = new Header800246Data[1];
    objectHeader800246Data[0] = new Header800246Data();
    objectHeader800246Data[0].created = "";
    objectHeader800246Data[0].createdbyr = createdbyr;
    objectHeader800246Data[0].updated = "";
    objectHeader800246Data[0].updatedTimeStamp = "";
    objectHeader800246Data[0].updatedby = updatedby;
    objectHeader800246Data[0].updatedbyr = updatedbyr;
    objectHeader800246Data[0].bplSalesforecastId = bplSalesforecastId;
    objectHeader800246Data[0].adClientId = adClientId;
    objectHeader800246Data[0].adClientIdr = "";
    objectHeader800246Data[0].adOrgId = adOrgId;
    objectHeader800246Data[0].adOrgIdr = "";
    objectHeader800246Data[0].cBpartnerId = cBpartnerId;
    objectHeader800246Data[0].cBpartnerIdr = cBpartnerIdr;
    objectHeader800246Data[0].rating = rating;
    objectHeader800246Data[0].description = description;
    objectHeader800246Data[0].salesrepId = salesrepId;
    objectHeader800246Data[0].salesrepIdr = "";
    objectHeader800246Data[0].estpropability = estpropability;
    objectHeader800246Data[0].estpropabilityr = "";
    objectHeader800246Data[0].startdate = startdate;
    objectHeader800246Data[0].linenetamt = linenetamt;
    objectHeader800246Data[0].adjustedStartdate = adjustedStartdate;
    objectHeader800246Data[0].adjustedEnddate = adjustedEnddate;
    objectHeader800246Data[0].adjustedAmt = adjustedAmt;
    objectHeader800246Data[0].isactive = isactive;
    objectHeader800246Data[0].offeredamtfirstquarter = offeredamtfirstquarter;
    objectHeader800246Data[0].offeredamtsecondquarter = offeredamtsecondquarter;
    objectHeader800246Data[0].orderedamtfirstquarter = orderedamtfirstquarter;
    objectHeader800246Data[0].orderedamtsecondquarter = orderedamtsecondquarter;
    objectHeader800246Data[0].invoicedamtfirstquarter = invoicedamtfirstquarter;
    objectHeader800246Data[0].invoicedamtsecondquarter = invoicedamtsecondquarter;
    objectHeader800246Data[0].offeredamtthirdquarter = offeredamtthirdquarter;
    objectHeader800246Data[0].offeredamtfourthquarter = offeredamtfourthquarter;
    objectHeader800246Data[0].orderedamtthirdquarter = orderedamtthirdquarter;
    objectHeader800246Data[0].orderedamtfourthquarter = orderedamtfourthquarter;
    objectHeader800246Data[0].invoicedamtthirdquarter = invoicedamtthirdquarter;
    objectHeader800246Data[0].invoicedamtfourthquarter = invoicedamtfourthquarter;
    objectHeader800246Data[0].language = "";
    return objectHeader800246Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefA76C943E0EC1468D85714CBAF083D9A4_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef6A1CBEA371E949A5BD0E3DC9F0021870_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef387B0D90E72A40D0A9FEA5C2721CD337_2(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_Bpartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Bpartner_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_bpartner_id");
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
      "        UPDATE bpl_salesforecast" +
      "        SET BPL_Salesforecast_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_Bpartner_ID = (?) , Rating = (?) , Description = (?) , Salesrep_ID = (?) , Estpropability = (?) , Startdate = TO_DATE(?) , Linenetamt = TO_NUMBER(?) , Adjusted_Startdate = TO_DATE(?) , Adjusted_Enddate = TO_DATE(?) , Adjusted_Amt = TO_NUMBER(?) , Isactive = (?) , Offeredamtfirstquarter = TO_NUMBER(?) , Offeredamtsecondquarter = TO_NUMBER(?) , Orderedamtfirstquarter = TO_NUMBER(?) , Orderedamtsecondquarter = TO_NUMBER(?) , Invoicedamtfirstquarter = TO_NUMBER(?) , Invoicedamtsecondquarter = TO_NUMBER(?) , Offeredamtthirdquarter = TO_NUMBER(?) , Offeredamtfourthquarter = TO_NUMBER(?) , Orderedamtthirdquarter = TO_NUMBER(?) , Orderedamtfourthquarter = TO_NUMBER(?) , Invoicedamtthirdquarter = TO_NUMBER(?) , Invoicedamtfourthquarter = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE bpl_salesforecast.BPL_Salesforecast_ID = ? " +
      "        AND bpl_salesforecast.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND bpl_salesforecast.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bplSalesforecastId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rating);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estpropability);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adjustedStartdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adjustedEnddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adjustedAmt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, offeredamtfirstquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, offeredamtsecondquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderedamtfirstquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderedamtsecondquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamtfirstquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamtsecondquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, offeredamtthirdquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, offeredamtfourthquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderedamtthirdquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderedamtfourthquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamtthirdquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamtfourthquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bplSalesforecastId);
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
      "        INSERT INTO bpl_salesforecast " +
      "        (BPL_Salesforecast_ID, AD_Client_ID, AD_Org_ID, C_Bpartner_ID, Rating, Description, Salesrep_ID, Estpropability, Startdate, Linenetamt, Adjusted_Startdate, Adjusted_Enddate, Adjusted_Amt, Isactive, Offeredamtfirstquarter, Offeredamtsecondquarter, Orderedamtfirstquarter, Orderedamtsecondquarter, Invoicedamtfirstquarter, Invoicedamtsecondquarter, Offeredamtthirdquarter, Offeredamtfourthquarter, Orderedamtthirdquarter, Orderedamtfourthquarter, Invoicedamtthirdquarter, Invoicedamtfourthquarter, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_NUMBER(?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bplSalesforecastId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rating);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estpropability);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adjustedStartdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adjustedEnddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adjustedAmt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, offeredamtfirstquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, offeredamtsecondquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderedamtfirstquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderedamtsecondquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamtfirstquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamtsecondquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, offeredamtthirdquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, offeredamtfourthquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderedamtthirdquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderedamtfourthquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamtthirdquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamtfourthquarter);
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
      "        DELETE FROM bpl_salesforecast" +
      "        WHERE bpl_salesforecast.BPL_Salesforecast_ID = ? " +
      "        AND bpl_salesforecast.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND bpl_salesforecast.AD_Org_ID IN (";
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
      "        DELETE FROM bpl_salesforecast" +
      "        WHERE bpl_salesforecast.BPL_Salesforecast_ID = ? ";

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
      "          FROM bpl_salesforecast" +
      "         WHERE bpl_salesforecast.BPL_Salesforecast_ID = ? ";

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
      "          FROM bpl_salesforecast" +
      "         WHERE bpl_salesforecast.BPL_Salesforecast_ID = ? ";

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
