//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ExpenseSheet;

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
  public String sTimeexpenselineId;
  public String cInvoicelineId;
  public String cCampaignId;
  public String cActivityId;
  public String sTimetypeId;
  public String cOrderlineId;
  public String sResourceassignmentId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String sTimeexpenseId;
  public String sTimeexpenseIdr;
  public String line;
  public String isactive;
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
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cProjectphaseId;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
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
    else if (fieldName.equalsIgnoreCase("s_timeexpenseline_id") || fieldName.equals("sTimeexpenselineId"))
      return sTimeexpenselineId;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_id") || fieldName.equals("cInvoicelineId"))
      return cInvoicelineId;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("s_timetype_id") || fieldName.equals("sTimetypeId"))
      return sTimetypeId;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("s_resourceassignment_id") || fieldName.equals("sResourceassignmentId"))
      return sResourceassignmentId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("s_timeexpense_id") || fieldName.equals("sTimeexpenseId"))
      return sTimeexpenseId;
    else if (fieldName.equalsIgnoreCase("s_timeexpense_idr") || fieldName.equals("sTimeexpenseIdr"))
      return sTimeexpenseIdr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
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
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
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
  public static LinesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String sTimeexpenseId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, sTimeexpenseId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static LinesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String sTimeexpenseId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(S_TimeExpenseLine.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = S_TimeExpenseLine.CreatedBy) as CreatedByR, " +
      "        to_char(S_TimeExpenseLine.Updated, ?) as updated, " +
      "        to_char(S_TimeExpenseLine.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        S_TimeExpenseLine.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = S_TimeExpenseLine.UpdatedBy) as UpdatedByR," +
      "        S_TimeExpenseLine.S_TimeExpenseLine_ID, " +
      "S_TimeExpenseLine.C_InvoiceLine_ID, " +
      "S_TimeExpenseLine.C_Campaign_ID, " +
      "S_TimeExpenseLine.C_Activity_ID, " +
      "S_TimeExpenseLine.S_TimeType_ID, " +
      "S_TimeExpenseLine.C_OrderLine_ID, " +
      "S_TimeExpenseLine.S_ResourceAssignment_ID, " +
      "S_TimeExpenseLine.AD_Client_ID, " +
      "(CASE WHEN S_TimeExpenseLine.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "S_TimeExpenseLine.AD_Org_ID, " +
      "(CASE WHEN S_TimeExpenseLine.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "S_TimeExpenseLine.S_TimeExpense_ID, " +
      "(CASE WHEN S_TimeExpenseLine.S_TimeExpense_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.DateReport, 'DD-MM-YYYY')),'') ) END) AS S_TimeExpense_IDR, " +
      "S_TimeExpenseLine.Line, " +
      "COALESCE(S_TimeExpenseLine.IsActive, 'N') AS IsActive, " +
      "COALESCE(S_TimeExpenseLine.IsTimeReport, 'N') AS IsTimeReport, " +
      "COALESCE(S_TimeExpenseLine.IsInvoiced, 'N') AS IsInvoiced, " +
      "S_TimeExpenseLine.M_Product_ID, " +
      "(CASE WHEN S_TimeExpenseLine.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "S_TimeExpenseLine.Qty, " +
      "S_TimeExpenseLine.C_Currency_ID, " +
      "(CASE WHEN S_TimeExpenseLine.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "S_TimeExpenseLine.C_UOM_ID, " +
      "(CASE WHEN S_TimeExpenseLine.C_UOM_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL7.Name IS NULL THEN TO_CHAR(table7.Name) ELSE TO_CHAR(tableTRL7.Name) END)), ''))),'') ) END) AS C_UOM_IDR, " +
      "S_TimeExpenseLine.InvoicePrice, " +
      "S_TimeExpenseLine.DateExpense, " +
      "S_TimeExpenseLine.ExpenseAmt, " +
      "S_TimeExpenseLine.ConvertedAmt, " +
      "S_TimeExpenseLine.Description, " +
      "S_TimeExpenseLine.Note, " +
      "S_TimeExpenseLine.C_Project_ID, " +
      "(CASE WHEN S_TimeExpenseLine.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "S_TimeExpenseLine.C_BPartner_ID, " +
      "(CASE WHEN S_TimeExpenseLine.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "S_TimeExpenseLine.C_ProjectPhase_ID, " +
      "S_TimeExpenseLine.C_ProjectTask_ID, " +
      "(CASE WHEN S_TimeExpenseLine.C_ProjectTask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS C_ProjectTask_IDR, " +
      "        ? AS LANGUAGE " +
      "        FROM S_TimeExpenseLine left join (select AD_Client_ID, Name from AD_Client) table1 on (S_TimeExpenseLine.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (S_TimeExpenseLine.AD_Org_ID = table2.AD_Org_ID) left join (select S_TimeExpense_ID, DocumentNo, C_BPartner_ID, DateReport from S_TimeExpense) table3 on (S_TimeExpenseLine.S_TimeExpense_ID = table3.S_TimeExpense_ID) left join (select C_BPartner_ID, Name from C_BPartner) table4 on (table3.C_BPartner_ID =  table4.C_BPartner_ID) left join (select M_Product_ID, Value, Name from M_Product) table5 on (S_TimeExpenseLine.M_Product_ID = table5.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL5 on (table5.M_Product_ID = tableTRL5.M_Product_ID and tableTRL5.AD_Language = ?)  left join (select C_Currency_ID, ISO_Code from C_Currency) table6 on (S_TimeExpenseLine.C_Currency_ID = table6.C_Currency_ID) left join (select C_UOM_ID, Name from C_UOM) table7 on (S_TimeExpenseLine.C_UOM_ID = table7.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL7 on (table7.C_UOM_ID = tableTRL7.C_UOM_ID and tableTRL7.AD_Language = ?)  left join (select C_Project_ID, Value, Name from C_Project) table8 on (S_TimeExpenseLine.C_Project_ID = table8.C_Project_ID) left join (select C_BPartner_ID, Name from C_BPartner) table9 on (S_TimeExpenseLine.C_BPartner_ID = table9.C_BPartner_ID) left join (select C_ProjectTask_ID, Name, C_Project_ID from C_ProjectTask) table10 on (S_TimeExpenseLine.C_ProjectTask_ID = table10.C_ProjectTask_ID) left join (select C_Project_ID, Value, Name from C_Project) table11 on (table10.C_Project_ID = table11.C_Project_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((sTimeexpenseId==null || sTimeexpenseId.equals(""))?"":"  AND S_TimeExpenseLine.S_TimeExpense_ID = ?  ");
    strSql = strSql + 
      "        AND S_TimeExpenseLine.S_TimeExpenseLine_ID = ? " +
      "        AND S_TimeExpenseLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND S_TimeExpenseLine.AD_Org_ID IN (";
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
      if (sTimeexpenseId != null && !(sTimeexpenseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeexpenseId);
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
        objectLinesData.sTimeexpenselineId = UtilSql.getValue(result, "s_timeexpenseline_id");
        objectLinesData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectLinesData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectLinesData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectLinesData.sTimetypeId = UtilSql.getValue(result, "s_timetype_id");
        objectLinesData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectLinesData.sResourceassignmentId = UtilSql.getValue(result, "s_resourceassignment_id");
        objectLinesData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectLinesData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectLinesData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectLinesData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectLinesData.sTimeexpenseId = UtilSql.getValue(result, "s_timeexpense_id");
        objectLinesData.sTimeexpenseIdr = UtilSql.getValue(result, "s_timeexpense_idr");
        objectLinesData.line = UtilSql.getValue(result, "line");
        objectLinesData.isactive = UtilSql.getValue(result, "isactive");
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
        objectLinesData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectLinesData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectLinesData.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectLinesData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectLinesData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
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
  public static LinesData[] set(String sTimeexpenseId, String cProjectphaseId, String sTimetypeId, String cUomId, String description, String cProjecttaskId, String updatedby, String updatedbyr, String cActivityId, String isactive, String line, String note, String sTimeexpenselineId, String cBpartnerId, String cBpartnerIdr, String cCurrencyId, String convertedamt, String invoiceprice, String dateexpense, String expenseamt, String adOrgId, String cInvoicelineId, String mProductId, String isinvoiced, String createdby, String createdbyr, String cCampaignId, String qty, String istimereport, String adClientId, String cProjectId, String sResourceassignmentId, String cOrderlineId)    throws ServletException {
    LinesData objectLinesData[] = new LinesData[1];
    objectLinesData[0] = new LinesData();
    objectLinesData[0].created = "";
    objectLinesData[0].createdbyr = createdbyr;
    objectLinesData[0].updated = "";
    objectLinesData[0].updatedTimeStamp = "";
    objectLinesData[0].updatedby = updatedby;
    objectLinesData[0].updatedbyr = updatedbyr;
    objectLinesData[0].sTimeexpenselineId = sTimeexpenselineId;
    objectLinesData[0].cInvoicelineId = cInvoicelineId;
    objectLinesData[0].cCampaignId = cCampaignId;
    objectLinesData[0].cActivityId = cActivityId;
    objectLinesData[0].sTimetypeId = sTimetypeId;
    objectLinesData[0].cOrderlineId = cOrderlineId;
    objectLinesData[0].sResourceassignmentId = sResourceassignmentId;
    objectLinesData[0].adClientId = adClientId;
    objectLinesData[0].adClientIdr = "";
    objectLinesData[0].adOrgId = adOrgId;
    objectLinesData[0].adOrgIdr = "";
    objectLinesData[0].sTimeexpenseId = sTimeexpenseId;
    objectLinesData[0].sTimeexpenseIdr = "";
    objectLinesData[0].line = line;
    objectLinesData[0].isactive = isactive;
    objectLinesData[0].istimereport = istimereport;
    objectLinesData[0].isinvoiced = isinvoiced;
    objectLinesData[0].mProductId = mProductId;
    objectLinesData[0].mProductIdr = "";
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
    objectLinesData[0].cBpartnerId = cBpartnerId;
    objectLinesData[0].cBpartnerIdr = cBpartnerIdr;
    objectLinesData[0].cProjectphaseId = cProjectphaseId;
    objectLinesData[0].cProjecttaskId = cProjecttaskId;
    objectLinesData[0].cProjecttaskIdr = "";
    objectLinesData[0].language = "";
    return objectLinesData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef6881_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef6879(ConnectionProvider connectionProvider, String S_TimeExpense_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(Line),0)+10 AS DefaultValue FROM S_TimeExpenseLine WHERE S_TimeExpense_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, S_TimeExpense_ID);

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
  public static String selectDef6867_1(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_BPartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_IDR);

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
Select for auxiliar field
 */
  public static String selectDef6883_2(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
      "        SELECT S_TimeExpenseLine.S_TimeExpense_ID AS NAME" +
      "        FROM S_TimeExpenseLine" +
      "        WHERE S_TimeExpenseLine.S_TimeExpenseLine_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String sTimeexpenseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(table1.DateReport, 'DD-MM-YYYY')) AS NAME FROM S_TimeExpense left join (select S_TimeExpense_ID, DocumentNo, C_BPartner_ID, DateReport from S_TimeExpense) table1 on (S_TimeExpense.S_TimeExpense_ID = table1.S_TimeExpense_ID) left join (select C_BPartner_ID, Name from C_BPartner) table2 on (table1.C_BPartner_ID =  table2.C_BPartner_ID) WHERE S_TimeExpense.S_TimeExpense_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeexpenseId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String sTimeexpenseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(table1.DateReport, 'DD-MM-YYYY')) AS NAME FROM S_TimeExpense left join (select S_TimeExpense_ID, DocumentNo, C_BPartner_ID, DateReport from S_TimeExpense) table1 on (S_TimeExpense.S_TimeExpense_ID = table1.S_TimeExpense_ID) left join (select C_BPartner_ID, Name from C_BPartner) table2 on (table1.C_BPartner_ID =  table2.C_BPartner_ID) WHERE S_TimeExpense.S_TimeExpense_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeexpenseId);

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
      "        UPDATE S_TimeExpenseLine" +
      "        SET S_TimeExpenseLine_ID = (?) , C_InvoiceLine_ID = (?) , C_Campaign_ID = (?) , C_Activity_ID = (?) , S_TimeType_ID = (?) , C_OrderLine_ID = (?) , S_ResourceAssignment_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , S_TimeExpense_ID = (?) , Line = TO_NUMBER(?) , IsActive = (?) , IsTimeReport = (?) , IsInvoiced = (?) , M_Product_ID = (?) , Qty = TO_NUMBER(?) , C_Currency_ID = (?) , C_UOM_ID = (?) , InvoicePrice = TO_NUMBER(?) , DateExpense = TO_DATE(?) , ExpenseAmt = TO_NUMBER(?) , ConvertedAmt = TO_NUMBER(?) , Description = (?) , Note = (?) , C_Project_ID = (?) , C_BPartner_ID = (?) , C_ProjectPhase_ID = (?) , C_ProjectTask_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE S_TimeExpenseLine.S_TimeExpenseLine_ID = ? " +
      "                 AND S_TimeExpenseLine.S_TimeExpense_ID = ? " +
      "        AND S_TimeExpenseLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND S_TimeExpenseLine.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeexpenselineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimetypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceassignmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeexpenseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeexpenselineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeexpenseId);
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
      "        INSERT INTO S_TimeExpenseLine " +
      "        (S_TimeExpenseLine_ID, C_InvoiceLine_ID, C_Campaign_ID, C_Activity_ID, S_TimeType_ID, C_OrderLine_ID, S_ResourceAssignment_ID, AD_Client_ID, AD_Org_ID, S_TimeExpense_ID, Line, IsActive, IsTimeReport, IsInvoiced, M_Product_ID, Qty, C_Currency_ID, C_UOM_ID, InvoicePrice, DateExpense, ExpenseAmt, ConvertedAmt, Description, Note, C_Project_ID, C_BPartner_ID, C_ProjectPhase_ID, C_ProjectTask_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeexpenselineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimetypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceassignmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeexpenseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String sTimeexpenseId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM S_TimeExpenseLine" +
      "        WHERE S_TimeExpenseLine.S_TimeExpenseLine_ID = ? " +
      "                 AND S_TimeExpenseLine.S_TimeExpense_ID = ? " +
      "        AND S_TimeExpenseLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND S_TimeExpenseLine.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeexpenseId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String sTimeexpenseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM S_TimeExpenseLine" +
      "        WHERE S_TimeExpenseLine.S_TimeExpenseLine_ID = ? " +
      "                 AND S_TimeExpenseLine.S_TimeExpense_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeexpenseId);

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
      "          FROM S_TimeExpenseLine" +
      "         WHERE S_TimeExpenseLine.S_TimeExpenseLine_ID = ? ";

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
      "          FROM S_TimeExpenseLine" +
      "         WHERE S_TimeExpenseLine.S_TimeExpenseLine_ID = ? ";

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
