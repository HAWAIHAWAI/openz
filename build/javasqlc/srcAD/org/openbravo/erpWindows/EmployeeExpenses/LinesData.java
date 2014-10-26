//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.EmployeeExpenses;

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
class LinesData implements FieldProvider {
static Logger log4j = Logger.getLogger(LinesData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String sTimeexpenselineId;
  public String adOrgId;
  public String adOrgIdr;
  public String sTimeexpenseId;
  public String sTimeexpenseIdr;
  public String isactive;
  public String line;
  public String istimereport;
  public String isinvoiced;
  public String mProductId;
  public String mProductIdr;
  public String qty;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String cUomId;
  public String cUomIdr;
  public String invoiceprice;
  public String dateexpense;
  public String expenseamt;
  public String convertedamt;
  public String description;
  public String note;
  public String cProjectId;
  public String cProjectIdr;
  public String sResourceassignmentId;
  public String telCBpartnerId;
  public String telCBpartnerIdr;
  public String cProjectphaseId;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String cActivityId;
  public String cCampaignId;
  public String cInvoicelineId;
  public String cOrderlineId;
  public String sTimetypeId;
  public String cBpartnerId;
  public String datereport;
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
    else if (fieldName.equalsIgnoreCase("s_timeexpenseline_id") || fieldName.equals("sTimeexpenselineId"))
      return sTimeexpenselineId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("s_timeexpense_id") || fieldName.equals("sTimeexpenseId"))
      return sTimeexpenseId;
    else if (fieldName.equalsIgnoreCase("s_timeexpense_idr") || fieldName.equals("sTimeexpenseIdr"))
      return sTimeexpenseIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("istimereport"))
      return istimereport;
    else if (fieldName.equalsIgnoreCase("isinvoiced"))
      return isinvoiced;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("invoiceprice"))
      return invoiceprice;
    else if (fieldName.equalsIgnoreCase("dateexpense"))
      return dateexpense;
    else if (fieldName.equalsIgnoreCase("expenseamt"))
      return expenseamt;
    else if (fieldName.equalsIgnoreCase("convertedamt"))
      return convertedamt;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("note"))
      return note;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("s_resourceassignment_id") || fieldName.equals("sResourceassignmentId"))
      return sResourceassignmentId;
    else if (fieldName.equalsIgnoreCase("tel_c_bpartner_id") || fieldName.equals("telCBpartnerId"))
      return telCBpartnerId;
    else if (fieldName.equalsIgnoreCase("tel_c_bpartner_idr") || fieldName.equals("telCBpartnerIdr"))
      return telCBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_id") || fieldName.equals("cInvoicelineId"))
      return cInvoicelineId;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("s_timetype_id") || fieldName.equals("sTimetypeId"))
      return sTimetypeId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("datereport"))
      return datereport;
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
  public static LinesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cBpartnerId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static LinesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(S_TimeExpenseLine_V.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = S_TimeExpenseLine_V.CreatedBy) as CreatedByR, " +
      "        to_char(S_TimeExpenseLine_V.Updated, ?) as updated, " +
      "        to_char(S_TimeExpenseLine_V.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        S_TimeExpenseLine_V.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = S_TimeExpenseLine_V.UpdatedBy) as UpdatedByR," +
      "        S_TimeExpenseLine_V.AD_Client_ID, " +
      "(CASE WHEN S_TimeExpenseLine_V.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "S_TimeExpenseLine_V.S_TimeExpenseLine_ID, " +
      "S_TimeExpenseLine_V.AD_Org_ID, " +
      "(CASE WHEN S_TimeExpenseLine_V.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "S_TimeExpenseLine_V.S_TimeExpense_ID, " +
      "(CASE WHEN S_TimeExpenseLine_V.S_TimeExpense_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.DateReport, 'DD-MM-YYYY')),'') ) END) AS S_TimeExpense_IDR, " +
      "COALESCE(S_TimeExpenseLine_V.IsActive, 'N') AS IsActive, " +
      "S_TimeExpenseLine_V.Line, " +
      "COALESCE(S_TimeExpenseLine_V.IsTimeReport, 'N') AS IsTimeReport, " +
      "COALESCE(S_TimeExpenseLine_V.IsInvoiced, 'N') AS IsInvoiced, " +
      "S_TimeExpenseLine_V.M_Product_ID, " +
      "(CASE WHEN S_TimeExpenseLine_V.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "S_TimeExpenseLine_V.Qty, " +
      "S_TimeExpenseLine_V.C_Currency_ID, " +
      "(CASE WHEN S_TimeExpenseLine_V.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "S_TimeExpenseLine_V.C_UOM_ID, " +
      "(CASE WHEN S_TimeExpenseLine_V.C_UOM_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL7.Name IS NULL THEN TO_CHAR(table7.Name) ELSE TO_CHAR(tableTRL7.Name) END)), ''))),'') ) END) AS C_UOM_IDR, " +
      "S_TimeExpenseLine_V.InvoicePrice, " +
      "S_TimeExpenseLine_V.Dateexpense, " +
      "S_TimeExpenseLine_V.Expenseamt, " +
      "S_TimeExpenseLine_V.ConvertedAmt, " +
      "S_TimeExpenseLine_V.Description, " +
      "S_TimeExpenseLine_V.Note, " +
      "S_TimeExpenseLine_V.C_Project_ID, " +
      "(CASE WHEN S_TimeExpenseLine_V.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "S_TimeExpenseLine_V.S_ResourceAssignment_ID, " +
      "S_TimeExpenseLine_V.TEL_C_Bpartner_ID, " +
      "(CASE WHEN S_TimeExpenseLine_V.TEL_C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS TEL_C_Bpartner_IDR, " +
      "S_TimeExpenseLine_V.C_ProjectPhase_ID, " +
      "S_TimeExpenseLine_V.C_ProjectTask_ID, " +
      "(CASE WHEN S_TimeExpenseLine_V.C_ProjectTask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS C_ProjectTask_IDR, " +
      "S_TimeExpenseLine_V.C_Activity_ID, " +
      "S_TimeExpenseLine_V.C_Campaign_ID, " +
      "S_TimeExpenseLine_V.C_InvoiceLine_ID, " +
      "S_TimeExpenseLine_V.C_OrderLine_ID, " +
      "S_TimeExpenseLine_V.S_Timetype_ID, " +
      "S_TimeExpenseLine_V.C_BPartner_ID, " +
      "S_TimeExpenseLine_V.Datereport, " +
      "        ? AS LANGUAGE " +
      "        FROM S_TimeExpenseLine_V left join (select AD_Client_ID, Name from AD_Client) table1 on (S_TimeExpenseLine_V.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (S_TimeExpenseLine_V.AD_Org_ID = table2.AD_Org_ID) left join (select S_TimeExpense_ID, DocumentNo, C_BPartner_ID, DateReport from S_TimeExpense) table3 on (S_TimeExpenseLine_V.S_TimeExpense_ID = table3.S_TimeExpense_ID) left join (select C_BPartner_ID, Name from C_BPartner) table4 on (table3.C_BPartner_ID =  table4.C_BPartner_ID) left join (select M_Product_ID, Value, Name from M_Product) table5 on (S_TimeExpenseLine_V.M_Product_ID = table5.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL5 on (table5.M_Product_ID = tableTRL5.M_Product_ID and tableTRL5.AD_Language = ?)  left join (select C_Currency_ID, ISO_Code from C_Currency) table6 on (S_TimeExpenseLine_V.C_Currency_ID = table6.C_Currency_ID) left join (select C_UOM_ID, Name from C_UOM) table7 on (S_TimeExpenseLine_V.C_UOM_ID = table7.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL7 on (table7.C_UOM_ID = tableTRL7.C_UOM_ID and tableTRL7.AD_Language = ?)  left join (select C_Project_ID, Value, Name from C_Project) table8 on (S_TimeExpenseLine_V.C_Project_ID = table8.C_Project_ID) left join (select C_BPartner_ID, Name from C_BPartner) table9 on (S_TimeExpenseLine_V.TEL_C_Bpartner_ID = table9.C_BPartner_ID) left join (select C_ProjectTask_ID, Name, C_Project_ID from C_ProjectTask) table10 on (S_TimeExpenseLine_V.C_ProjectTask_ID = table10.C_ProjectTask_ID) left join (select C_Project_ID, Value, Name from C_Project) table11 on (table10.C_Project_ID = table11.C_Project_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND S_TimeExpenseLine_V.C_BPartner_ID = ?  ");
    strSql = strSql + 
      "        AND S_TimeExpenseLine_V.S_TimeExpenseLine_ID = ? " +
      "        AND S_TimeExpenseLine_V.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND S_TimeExpenseLine_V.AD_Org_ID IN (";
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
        LinesData objectLinesData = new LinesData();
        objectLinesData.created = UtilSql.getValue(result, "created");
        objectLinesData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectLinesData.updated = UtilSql.getValue(result, "updated");
        objectLinesData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectLinesData.updatedby = UtilSql.getValue(result, "updatedby");
        objectLinesData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectLinesData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectLinesData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectLinesData.sTimeexpenselineId = UtilSql.getValue(result, "s_timeexpenseline_id");
        objectLinesData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectLinesData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectLinesData.sTimeexpenseId = UtilSql.getValue(result, "s_timeexpense_id");
        objectLinesData.sTimeexpenseIdr = UtilSql.getValue(result, "s_timeexpense_idr");
        objectLinesData.isactive = UtilSql.getValue(result, "isactive");
        objectLinesData.line = UtilSql.getValue(result, "line");
        objectLinesData.istimereport = UtilSql.getValue(result, "istimereport");
        objectLinesData.isinvoiced = UtilSql.getValue(result, "isinvoiced");
        objectLinesData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectLinesData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectLinesData.qty = UtilSql.getValue(result, "qty");
        objectLinesData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectLinesData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectLinesData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectLinesData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectLinesData.invoiceprice = UtilSql.getValue(result, "invoiceprice");
        objectLinesData.dateexpense = UtilSql.getDateValue(result, "dateexpense", "dd-MM-yyyy");
        objectLinesData.expenseamt = UtilSql.getValue(result, "expenseamt");
        objectLinesData.convertedamt = UtilSql.getValue(result, "convertedamt");
        objectLinesData.description = UtilSql.getValue(result, "description");
        objectLinesData.note = UtilSql.getValue(result, "note");
        objectLinesData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectLinesData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectLinesData.sResourceassignmentId = UtilSql.getValue(result, "s_resourceassignment_id");
        objectLinesData.telCBpartnerId = UtilSql.getValue(result, "tel_c_bpartner_id");
        objectLinesData.telCBpartnerIdr = UtilSql.getValue(result, "tel_c_bpartner_idr");
        objectLinesData.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectLinesData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectLinesData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectLinesData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectLinesData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectLinesData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectLinesData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectLinesData.sTimetypeId = UtilSql.getValue(result, "s_timetype_id");
        objectLinesData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectLinesData.datereport = UtilSql.getDateValue(result, "datereport", "dd-MM-yyyy");
        objectLinesData.language = UtilSql.getValue(result, "language");
        objectLinesData.adUserClient = "";
        objectLinesData.adOrgClient = "";
        objectLinesData.createdby = "";
        objectLinesData.trBgcolor = "";
        objectLinesData.totalCount = "";
        objectLinesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLinesData);
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
    LinesData objectLinesData[] = new LinesData[vector.size()];
    vector.copyInto(objectLinesData);
    return(objectLinesData);
  }

/**
Create a registry
 */
  public static LinesData[] set(String cBpartnerId, String invoiceprice, String cProjectphaseId, String dateexpense, String cCurrencyId, String cInvoicelineId, String telCBpartnerId, String telCBpartnerIdr, String cActivityId, String updatedby, String updatedbyr, String note, String adOrgId, String adClientId, String cProjecttaskId, String cCampaignId, String isinvoiced, String qty, String convertedamt, String sTimeexpenseId, String createdby, String createdbyr, String line, String mProductId, String mProductIdr, String datereport, String expenseamt, String description, String sTimeexpenselineId, String cUomId, String cOrderlineId, String istimereport, String isactive, String sTimetypeId, String sResourceassignmentId, String cProjectId)    throws ServletException {
    LinesData objectLinesData[] = new LinesData[1];
    objectLinesData[0] = new LinesData();
    objectLinesData[0].created = "";
    objectLinesData[0].createdbyr = createdbyr;
    objectLinesData[0].updated = "";
    objectLinesData[0].updatedTimeStamp = "";
    objectLinesData[0].updatedby = updatedby;
    objectLinesData[0].updatedbyr = updatedbyr;
    objectLinesData[0].adClientId = adClientId;
    objectLinesData[0].adClientIdr = "";
    objectLinesData[0].sTimeexpenselineId = sTimeexpenselineId;
    objectLinesData[0].adOrgId = adOrgId;
    objectLinesData[0].adOrgIdr = "";
    objectLinesData[0].sTimeexpenseId = sTimeexpenseId;
    objectLinesData[0].sTimeexpenseIdr = "";
    objectLinesData[0].isactive = isactive;
    objectLinesData[0].line = line;
    objectLinesData[0].istimereport = istimereport;
    objectLinesData[0].isinvoiced = isinvoiced;
    objectLinesData[0].mProductId = mProductId;
    objectLinesData[0].mProductIdr = mProductIdr;
    objectLinesData[0].qty = qty;
    objectLinesData[0].cCurrencyId = cCurrencyId;
    objectLinesData[0].cCurrencyIdr = "";
    objectLinesData[0].cUomId = cUomId;
    objectLinesData[0].cUomIdr = "";
    objectLinesData[0].invoiceprice = invoiceprice;
    objectLinesData[0].dateexpense = dateexpense;
    objectLinesData[0].expenseamt = expenseamt;
    objectLinesData[0].convertedamt = convertedamt;
    objectLinesData[0].description = description;
    objectLinesData[0].note = note;
    objectLinesData[0].cProjectId = cProjectId;
    objectLinesData[0].cProjectIdr = "";
    objectLinesData[0].sResourceassignmentId = sResourceassignmentId;
    objectLinesData[0].telCBpartnerId = telCBpartnerId;
    objectLinesData[0].telCBpartnerIdr = telCBpartnerIdr;
    objectLinesData[0].cProjectphaseId = cProjectphaseId;
    objectLinesData[0].cProjecttaskId = cProjecttaskId;
    objectLinesData[0].cProjecttaskIdr = "";
    objectLinesData[0].cActivityId = cActivityId;
    objectLinesData[0].cCampaignId = cCampaignId;
    objectLinesData[0].cInvoicelineId = cInvoicelineId;
    objectLinesData[0].cOrderlineId = cOrderlineId;
    objectLinesData[0].sTimetypeId = sTimetypeId;
    objectLinesData[0].cBpartnerId = cBpartnerId;
    objectLinesData[0].datereport = datereport;
    objectLinesData[0].language = "";
    return objectLinesData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefD463F52ACB6611DD87FACF0742499ECD_0(ConnectionProvider connectionProvider, String TEL_C_Bpartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as TEL_C_Bpartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, TEL_C_Bpartner_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "tel_c_bpartner_id");
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
  public static String selectDef803424_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef803422_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef803426(ConnectionProvider connectionProvider, String c_bpartner_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(LINE),0)+10 AS DefaultValue FROM S_TIMEEXPENSELINE_V WHERE c_bpartner_id=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_bpartner_id);

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
  public static String selectDef803429_3(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as M_Product_ID FROM M_Product table1 WHERE table1.isActive='Y' AND table1.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_id");
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
      "        SELECT S_TimeExpenseLine_V.C_BPartner_ID AS NAME" +
      "        FROM S_TimeExpenseLine_V" +
      "        WHERE S_TimeExpenseLine_V.S_TimeExpenseLine_ID = ?";

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
      "        UPDATE S_TimeExpenseLine_V" +
      "        SET AD_Client_ID = (?) , S_TimeExpenseLine_ID = (?) , AD_Org_ID = (?) , S_TimeExpense_ID = (?) , IsActive = (?) , Line = TO_NUMBER(?) , IsTimeReport = (?) , IsInvoiced = (?) , M_Product_ID = (?) , Qty = TO_NUMBER(?) , C_Currency_ID = (?) , C_UOM_ID = (?) , InvoicePrice = TO_NUMBER(?) , Dateexpense = TO_DATE(?) , Expenseamt = TO_NUMBER(?) , ConvertedAmt = TO_NUMBER(?) , Description = (?) , Note = (?) , C_Project_ID = (?) , S_ResourceAssignment_ID = (?) , TEL_C_Bpartner_ID = (?) , C_ProjectPhase_ID = (?) , C_ProjectTask_ID = (?) , C_Activity_ID = (?) , C_Campaign_ID = (?) , C_InvoiceLine_ID = (?) , C_OrderLine_ID = (?) , S_Timetype_ID = (?) , C_BPartner_ID = (?) , Datereport = TO_DATE(?) , updated = now(), updatedby = ? " +
      "        WHERE S_TimeExpenseLine_V.S_TimeExpenseLine_ID = ? " +
      "                 AND S_TimeExpenseLine_V.C_BPartner_ID = ? " +
      "        AND S_TimeExpenseLine_V.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND S_TimeExpenseLine_V.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeexpenselineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeexpenseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istimereport);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceprice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateexpense);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenseamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, convertedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceassignmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, telCBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimetypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datereport);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeexpenselineId);
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
      "        INSERT INTO S_TimeExpenseLine_V " +
      "        (AD_Client_ID, S_TimeExpenseLine_ID, AD_Org_ID, S_TimeExpense_ID, IsActive, Line, IsTimeReport, IsInvoiced, M_Product_ID, Qty, C_Currency_ID, C_UOM_ID, InvoicePrice, Dateexpense, Expenseamt, ConvertedAmt, Description, Note, C_Project_ID, S_ResourceAssignment_ID, TEL_C_Bpartner_ID, C_ProjectPhase_ID, C_ProjectTask_ID, C_Activity_ID, C_Campaign_ID, C_InvoiceLine_ID, C_OrderLine_ID, S_Timetype_ID, C_BPartner_ID, Datereport, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeexpenselineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeexpenseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istimereport);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceprice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateexpense);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenseamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, convertedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceassignmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, telCBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimetypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datereport);
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
      "        DELETE FROM S_TimeExpenseLine_V" +
      "        WHERE S_TimeExpenseLine_V.S_TimeExpenseLine_ID = ? " +
      "                 AND S_TimeExpenseLine_V.C_BPartner_ID = ? " +
      "        AND S_TimeExpenseLine_V.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND S_TimeExpenseLine_V.AD_Org_ID IN (";
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
      "        DELETE FROM S_TimeExpenseLine_V" +
      "        WHERE S_TimeExpenseLine_V.S_TimeExpenseLine_ID = ? " +
      "                 AND S_TimeExpenseLine_V.C_BPartner_ID = ? ";

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
      "          FROM S_TimeExpenseLine_V" +
      "         WHERE S_TimeExpenseLine_V.S_TimeExpenseLine_ID = ? ";

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
      "          FROM S_TimeExpenseLine_V" +
      "         WHERE S_TimeExpenseLine_V.S_TimeExpenseLine_ID = ? ";

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
