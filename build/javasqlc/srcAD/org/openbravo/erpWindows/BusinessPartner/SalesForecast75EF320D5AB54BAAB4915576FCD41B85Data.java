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
class SalesForecast75EF320D5AB54BAAB4915576FCD41B85Data implements FieldProvider {
static Logger log4j = Logger.getLogger(SalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.class);
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
  public String orderedamtfirstquarter;
  public String invoicedamtfirstquarter;
  public String offeredamtsecondquarter;
  public String orderedamtsecondquarter;
  public String invoicedamtsecondquarter;
  public String offeredamtthirdquarter;
  public String orderedamtthirdquarter;
  public String invoicedamtthirdquarter;
  public String offeredamtfourthquarter;
  public String orderedamtfourthquarter;
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
    else if (fieldName.equalsIgnoreCase("orderedamtfirstquarter"))
      return orderedamtfirstquarter;
    else if (fieldName.equalsIgnoreCase("invoicedamtfirstquarter"))
      return invoicedamtfirstquarter;
    else if (fieldName.equalsIgnoreCase("offeredamtsecondquarter"))
      return offeredamtsecondquarter;
    else if (fieldName.equalsIgnoreCase("orderedamtsecondquarter"))
      return orderedamtsecondquarter;
    else if (fieldName.equalsIgnoreCase("invoicedamtsecondquarter"))
      return invoicedamtsecondquarter;
    else if (fieldName.equalsIgnoreCase("offeredamtthirdquarter"))
      return offeredamtthirdquarter;
    else if (fieldName.equalsIgnoreCase("orderedamtthirdquarter"))
      return orderedamtthirdquarter;
    else if (fieldName.equalsIgnoreCase("invoicedamtthirdquarter"))
      return invoicedamtthirdquarter;
    else if (fieldName.equalsIgnoreCase("offeredamtfourthquarter"))
      return offeredamtfourthquarter;
    else if (fieldName.equalsIgnoreCase("orderedamtfourthquarter"))
      return orderedamtfourthquarter;
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
  public static SalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cBpartnerId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static SalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
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
      "bpl_salesforecast.Orderedamtfirstquarter, " +
      "bpl_salesforecast.Invoicedamtfirstquarter, " +
      "bpl_salesforecast.Offeredamtsecondquarter, " +
      "bpl_salesforecast.Orderedamtsecondquarter, " +
      "bpl_salesforecast.Invoicedamtsecondquarter, " +
      "bpl_salesforecast.Offeredamtthirdquarter, " +
      "bpl_salesforecast.Orderedamtthirdquarter, " +
      "bpl_salesforecast.Invoicedamtthirdquarter, " +
      "bpl_salesforecast.Offeredamtfourthquarter, " +
      "bpl_salesforecast.Orderedamtfourthquarter, " +
      "bpl_salesforecast.Invoicedamtfourthquarter, " +
      "        ? AS LANGUAGE " +
      "        FROM bpl_salesforecast left join (select AD_Client_ID, Name from AD_Client) table1 on (bpl_salesforecast.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (bpl_salesforecast.AD_Org_ID = table2.AD_Org_ID) left join (select C_BPartner_ID, Name from C_BPartner) table3 on (bpl_salesforecast.C_Bpartner_ID = table3.C_BPartner_ID) left join (select AD_User_ID, Name from AD_User) table4 on (bpl_salesforecast.Salesrep_ID =  table4.AD_User_ID) left join ad_ref_list_v list1 on (bpl_salesforecast.Estpropability = list1.value and list1.ad_reference_id = 'DD6AA16AB1DD4DF5AD11A2665AE665BC' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND bpl_salesforecast.C_Bpartner_ID = ?  ");
    strSql = strSql + 
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
        SalesForecast75EF320D5AB54BAAB4915576FCD41B85Data objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data = new SalesForecast75EF320D5AB54BAAB4915576FCD41B85Data();
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.created = UtilSql.getValue(result, "created");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.updated = UtilSql.getValue(result, "updated");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.bplSalesforecastId = UtilSql.getValue(result, "bpl_salesforecast_id");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.description = UtilSql.getValue(result, "description");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.estpropability = UtilSql.getValue(result, "estpropability");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.estpropabilityr = UtilSql.getValue(result, "estpropabilityr");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.adjustedStartdate = UtilSql.getDateValue(result, "adjusted_startdate", "dd-MM-yyyy");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.adjustedEnddate = UtilSql.getDateValue(result, "adjusted_enddate", "dd-MM-yyyy");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.adjustedAmt = UtilSql.getValue(result, "adjusted_amt");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.isactive = UtilSql.getValue(result, "isactive");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.offeredamtfirstquarter = UtilSql.getValue(result, "offeredamtfirstquarter");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.orderedamtfirstquarter = UtilSql.getValue(result, "orderedamtfirstquarter");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.invoicedamtfirstquarter = UtilSql.getValue(result, "invoicedamtfirstquarter");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.offeredamtsecondquarter = UtilSql.getValue(result, "offeredamtsecondquarter");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.orderedamtsecondquarter = UtilSql.getValue(result, "orderedamtsecondquarter");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.invoicedamtsecondquarter = UtilSql.getValue(result, "invoicedamtsecondquarter");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.offeredamtthirdquarter = UtilSql.getValue(result, "offeredamtthirdquarter");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.orderedamtthirdquarter = UtilSql.getValue(result, "orderedamtthirdquarter");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.invoicedamtthirdquarter = UtilSql.getValue(result, "invoicedamtthirdquarter");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.offeredamtfourthquarter = UtilSql.getValue(result, "offeredamtfourthquarter");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.orderedamtfourthquarter = UtilSql.getValue(result, "orderedamtfourthquarter");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.invoicedamtfourthquarter = UtilSql.getValue(result, "invoicedamtfourthquarter");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.language = UtilSql.getValue(result, "language");
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.adUserClient = "";
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.adOrgClient = "";
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.createdby = "";
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.trBgcolor = "";
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.totalCount = "";
        objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data);
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
    SalesForecast75EF320D5AB54BAAB4915576FCD41B85Data objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[] = new SalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[vector.size()];
    vector.copyInto(objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data);
    return(objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data);
  }

/**
Create a registry
 */
  public static SalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[] set(String cBpartnerId, String orderedamtfirstquarter, String offeredamtfourthquarter, String linenetamt, String adClientId, String invoicedamtsecondquarter, String salesrepId, String invoicedamtfourthquarter, String createdby, String createdbyr, String orderedamtfourthquarter, String bplSalesforecastId, String orderedamtsecondquarter, String offeredamtthirdquarter, String orderedamtthirdquarter, String invoicedamtfirstquarter, String startdate, String description, String adjustedAmt, String offeredamtsecondquarter, String offeredamtfirstquarter, String adjustedStartdate, String updatedby, String updatedbyr, String isactive, String cBpartnerIdr, String adjustedEnddate, String invoicedamtthirdquarter, String estpropability, String adOrgId)    throws ServletException {
    SalesForecast75EF320D5AB54BAAB4915576FCD41B85Data objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[] = new SalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[1];
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0] = new SalesForecast75EF320D5AB54BAAB4915576FCD41B85Data();
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].created = "";
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].createdbyr = createdbyr;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].updated = "";
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].updatedTimeStamp = "";
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].updatedby = updatedby;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].updatedbyr = updatedbyr;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].bplSalesforecastId = bplSalesforecastId;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].adClientId = adClientId;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].adClientIdr = "";
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].adOrgId = adOrgId;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].adOrgIdr = "";
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].cBpartnerId = cBpartnerId;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].cBpartnerIdr = cBpartnerIdr;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].description = description;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].salesrepId = salesrepId;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].salesrepIdr = "";
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].estpropability = estpropability;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].estpropabilityr = "";
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].startdate = startdate;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].linenetamt = linenetamt;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].adjustedStartdate = adjustedStartdate;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].adjustedEnddate = adjustedEnddate;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].adjustedAmt = adjustedAmt;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].isactive = isactive;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].offeredamtfirstquarter = offeredamtfirstquarter;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].orderedamtfirstquarter = orderedamtfirstquarter;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].invoicedamtfirstquarter = invoicedamtfirstquarter;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].offeredamtsecondquarter = offeredamtsecondquarter;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].orderedamtsecondquarter = orderedamtsecondquarter;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].invoicedamtsecondquarter = invoicedamtsecondquarter;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].offeredamtthirdquarter = offeredamtthirdquarter;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].orderedamtthirdquarter = orderedamtthirdquarter;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].invoicedamtthirdquarter = invoicedamtthirdquarter;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].offeredamtfourthquarter = offeredamtfourthquarter;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].orderedamtfourthquarter = orderedamtfourthquarter;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].invoicedamtfourthquarter = invoicedamtfourthquarter;
    objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data[0].language = "";
    return objectSalesForecast75EF320D5AB54BAAB4915576FCD41B85Data;
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

/**
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT bpl_salesforecast.C_Bpartner_ID AS NAME" +
      "        FROM bpl_salesforecast" +
      "        WHERE bpl_salesforecast.BPL_Salesforecast_ID = ?";

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
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BPartner left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BPartner.C_Bpartner_ID = table1.C_BPartner_ID) WHERE C_BPartner.C_Bpartner_ID = ?  ";

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
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BPartner left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BPartner.C_Bpartner_ID = table1.C_BPartner_ID) WHERE C_BPartner.C_Bpartner_ID = ?  ";

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
      "        UPDATE bpl_salesforecast" +
      "        SET BPL_Salesforecast_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_Bpartner_ID = (?) , Description = (?) , Salesrep_ID = (?) , Estpropability = (?) , Startdate = TO_DATE(?) , Linenetamt = TO_NUMBER(?) , Adjusted_Startdate = TO_DATE(?) , Adjusted_Enddate = TO_DATE(?) , Adjusted_Amt = TO_NUMBER(?) , Isactive = (?) , Offeredamtfirstquarter = TO_NUMBER(?) , Orderedamtfirstquarter = TO_NUMBER(?) , Invoicedamtfirstquarter = TO_NUMBER(?) , Offeredamtsecondquarter = TO_NUMBER(?) , Orderedamtsecondquarter = TO_NUMBER(?) , Invoicedamtsecondquarter = TO_NUMBER(?) , Offeredamtthirdquarter = TO_NUMBER(?) , Orderedamtthirdquarter = TO_NUMBER(?) , Invoicedamtthirdquarter = TO_NUMBER(?) , Offeredamtfourthquarter = TO_NUMBER(?) , Orderedamtfourthquarter = TO_NUMBER(?) , Invoicedamtfourthquarter = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE bpl_salesforecast.BPL_Salesforecast_ID = ? " +
      "                 AND bpl_salesforecast.C_Bpartner_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderedamtfirstquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamtfirstquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, offeredamtsecondquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderedamtsecondquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamtsecondquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, offeredamtthirdquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderedamtthirdquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamtthirdquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, offeredamtfourthquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderedamtfourthquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamtfourthquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bplSalesforecastId);
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
      "        INSERT INTO bpl_salesforecast " +
      "        (BPL_Salesforecast_ID, AD_Client_ID, AD_Org_ID, C_Bpartner_ID, Description, Salesrep_ID, Estpropability, Startdate, Linenetamt, Adjusted_Startdate, Adjusted_Enddate, Adjusted_Amt, Isactive, Offeredamtfirstquarter, Orderedamtfirstquarter, Invoicedamtfirstquarter, Offeredamtsecondquarter, Orderedamtsecondquarter, Invoicedamtsecondquarter, Offeredamtthirdquarter, Orderedamtthirdquarter, Invoicedamtthirdquarter, Offeredamtfourthquarter, Orderedamtfourthquarter, Invoicedamtfourthquarter, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_NUMBER(?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bplSalesforecastId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderedamtfirstquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamtfirstquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, offeredamtsecondquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderedamtsecondquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamtsecondquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, offeredamtthirdquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderedamtthirdquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamtthirdquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, offeredamtfourthquarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderedamtfourthquarter);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cBpartnerId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM bpl_salesforecast" +
      "        WHERE bpl_salesforecast.BPL_Salesforecast_ID = ? " +
      "                 AND bpl_salesforecast.C_Bpartner_ID = ? " +
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
      "        DELETE FROM bpl_salesforecast" +
      "        WHERE bpl_salesforecast.BPL_Salesforecast_ID = ? " +
      "                 AND bpl_salesforecast.C_Bpartner_ID = ? ";

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
