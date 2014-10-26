//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.project.Projects;

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
class InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data implements FieldProvider {
static Logger log4j = Logger.getLogger(InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjectInvoiceOverviewId;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String issotrx;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String salestotallines;
  public String purchasetotallines;
  public String ispaid;
  public String salestotalpaid;
  public String purchasetotalpaid;
  public String salesoutstandingamt;
  public String purchaseoutstandingamt;
  public String linenetamt;
  public String linegrossamt;
  public String mProductId;
  public String mProductIdr;
  public String qtyinvoiced;
  public String description;
  public String cInvoiceId;
  public String cInvoiceIdr;
  public String mPricelistId;
  public String mPricelistIdr;
  public String adClientId;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
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
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_project_invoice_overview_id") || fieldName.equals("cProjectInvoiceOverviewId"))
      return cProjectInvoiceOverviewId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("salestotallines"))
      return salestotallines;
    else if (fieldName.equalsIgnoreCase("purchasetotallines"))
      return purchasetotallines;
    else if (fieldName.equalsIgnoreCase("ispaid"))
      return ispaid;
    else if (fieldName.equalsIgnoreCase("salestotalpaid"))
      return salestotalpaid;
    else if (fieldName.equalsIgnoreCase("purchasetotalpaid"))
      return purchasetotalpaid;
    else if (fieldName.equalsIgnoreCase("salesoutstandingamt"))
      return salesoutstandingamt;
    else if (fieldName.equalsIgnoreCase("purchaseoutstandingamt"))
      return purchaseoutstandingamt;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("linegrossamt"))
      return linegrossamt;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("c_invoice_idr") || fieldName.equals("cInvoiceIdr"))
      return cInvoiceIdr;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_idr") || fieldName.equals("mPricelistIdr"))
      return mPricelistIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
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
  public static InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjectId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cProjectId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjectId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_project_invoice_overview.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_project_invoice_overview.CreatedBy) as CreatedByR, " +
      "        to_char(c_project_invoice_overview.Updated, ?) as updated, " +
      "        to_char(c_project_invoice_overview.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_project_invoice_overview.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_project_invoice_overview.UpdatedBy) as UpdatedByR," +
      "        c_project_invoice_overview.C_Project_ID, " +
      "(CASE WHEN c_project_invoice_overview.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "c_project_invoice_overview.C_Project_Invoice_Overview_ID, " +
      "c_project_invoice_overview.C_Projecttask_ID, " +
      "(CASE WHEN c_project_invoice_overview.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "c_project_invoice_overview.C_Doctype_ID, " +
      "(CASE WHEN c_project_invoice_overview.C_Doctype_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_Doctype_IDR, " +
      "COALESCE(c_project_invoice_overview.Issotrx, 'N') AS Issotrx, " +
      "c_project_invoice_overview.C_Bpartner_ID, " +
      "(CASE WHEN c_project_invoice_overview.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "c_project_invoice_overview.C_Bpartner_Location_ID, " +
      "(CASE WHEN c_project_invoice_overview.C_Bpartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_Bpartner_Location_IDR, " +
      "c_project_invoice_overview.Salestotallines, " +
      "c_project_invoice_overview.Purchasetotallines, " +
      "COALESCE(c_project_invoice_overview.Ispaid, 'N') AS Ispaid, " +
      "c_project_invoice_overview.Salestotalpaid, " +
      "c_project_invoice_overview.Purchasetotalpaid, " +
      "c_project_invoice_overview.Salesoutstandingamt, " +
      "c_project_invoice_overview.Purchaseoutstandingamt, " +
      "c_project_invoice_overview.Linenetamt, " +
      "c_project_invoice_overview.Linegrossamt, " +
      "c_project_invoice_overview.M_Product_ID, " +
      "(CASE WHEN c_project_invoice_overview.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL7.Name IS NULL THEN TO_CHAR(table7.Name) ELSE TO_CHAR(tableTRL7.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "c_project_invoice_overview.Qtyinvoiced, " +
      "c_project_invoice_overview.Description, " +
      "c_project_invoice_overview.C_Invoice_ID, " +
      "(CASE WHEN c_project_invoice_overview.C_Invoice_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table8.DateInvoiced, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.GrandTotal), ''))),'') ) END) AS C_Invoice_IDR, " +
      "c_project_invoice_overview.M_Pricelist_ID, " +
      "(CASE WHEN c_project_invoice_overview.M_Pricelist_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS M_Pricelist_IDR, " +
      "c_project_invoice_overview.AD_Client_ID, " +
      "c_project_invoice_overview.AD_Org_ID, " +
      "(CASE WHEN c_project_invoice_overview.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(c_project_invoice_overview.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM c_project_invoice_overview left join (select C_Project_ID, Value, Name from C_Project) table1 on (c_project_invoice_overview.C_Project_ID = table1.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table2 on (c_project_invoice_overview.C_Projecttask_ID = table2.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table3 on (table2.C_Project_ID = table3.C_Project_ID) left join (select C_Doctype_ID, Name from C_Doctype) table4 on (c_project_invoice_overview.C_Doctype_ID = table4.C_Doctype_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL4 on (table4.C_DocType_ID = tableTRL4.C_DocType_ID and tableTRL4.AD_Language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table5 on (c_project_invoice_overview.C_Bpartner_ID = table5.C_BPartner_ID) left join (select C_Bpartner_Location_ID, Name from C_Bpartner_Location) table6 on (c_project_invoice_overview.C_Bpartner_Location_ID = table6.C_Bpartner_Location_ID) left join (select M_Product_ID, Value, Name from M_Product) table7 on (c_project_invoice_overview.M_Product_ID = table7.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL7 on (table7.M_Product_ID = tableTRL7.M_Product_ID and tableTRL7.AD_Language = ?)  left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table8 on (c_project_invoice_overview.C_Invoice_ID = table8.C_Invoice_ID) left join (select M_Pricelist_ID, Name from M_Pricelist) table9 on (c_project_invoice_overview.M_Pricelist_ID = table9.M_Pricelist_ID) left join (select AD_Org_ID, Name from AD_Org) table10 on (c_project_invoice_overview.AD_Org_ID = table10.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND c_project_invoice_overview.C_Project_ID = ?  ");
    strSql = strSql + 
      "        AND c_project_invoice_overview.C_Project_Invoice_Overview_ID = ? " +
      "        AND c_project_invoice_overview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_project_invoice_overview.AD_Org_ID IN (";
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
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
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
        InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data = new InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data();
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.created = UtilSql.getValue(result, "created");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.updated = UtilSql.getValue(result, "updated");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.cProjectInvoiceOverviewId = UtilSql.getValue(result, "c_project_invoice_overview_id");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.issotrx = UtilSql.getValue(result, "issotrx");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.salestotallines = UtilSql.getValue(result, "salestotallines");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.purchasetotallines = UtilSql.getValue(result, "purchasetotallines");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.ispaid = UtilSql.getValue(result, "ispaid");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.salestotalpaid = UtilSql.getValue(result, "salestotalpaid");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.purchasetotalpaid = UtilSql.getValue(result, "purchasetotalpaid");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.salesoutstandingamt = UtilSql.getValue(result, "salesoutstandingamt");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.purchaseoutstandingamt = UtilSql.getValue(result, "purchaseoutstandingamt");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.linegrossamt = UtilSql.getValue(result, "linegrossamt");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.description = UtilSql.getValue(result, "description");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.cInvoiceIdr = UtilSql.getValue(result, "c_invoice_idr");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.mPricelistIdr = UtilSql.getValue(result, "m_pricelist_idr");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.isactive = UtilSql.getValue(result, "isactive");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.language = UtilSql.getValue(result, "language");
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.adUserClient = "";
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.adOrgClient = "";
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.createdby = "";
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.trBgcolor = "";
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.totalCount = "";
        objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data);
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
    InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[] = new InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[vector.size()];
    vector.copyInto(objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data);
    return(objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data);
  }

/**
Create a registry
 */
  public static InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[] set(String cProjectId, String purchaseoutstandingamt, String cProjectInvoiceOverviewId, String cBpartnerId, String cBpartnerIdr, String adOrgId, String salestotallines, String ispaid, String purchasetotallines, String cProjecttaskId, String mPricelistId, String linegrossamt, String cInvoiceId, String purchasetotalpaid, String updatedby, String updatedbyr, String adClientId, String qtyinvoiced, String mProductId, String mProductIdr, String salesoutstandingamt, String isactive, String linenetamt, String description, String salestotalpaid, String issotrx, String cBpartnerLocationId, String cDoctypeId, String createdby, String createdbyr)    throws ServletException {
    InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[] = new InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[1];
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0] = new InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data();
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].created = "";
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].createdbyr = createdbyr;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].updated = "";
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].updatedTimeStamp = "";
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].updatedby = updatedby;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].updatedbyr = updatedbyr;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].cProjectId = cProjectId;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].cProjectIdr = "";
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].cProjectInvoiceOverviewId = cProjectInvoiceOverviewId;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].cProjecttaskId = cProjecttaskId;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].cProjecttaskIdr = "";
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].cDoctypeId = cDoctypeId;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].cDoctypeIdr = "";
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].issotrx = issotrx;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].cBpartnerId = cBpartnerId;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].cBpartnerIdr = cBpartnerIdr;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].cBpartnerLocationId = cBpartnerLocationId;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].cBpartnerLocationIdr = "";
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].salestotallines = salestotallines;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].purchasetotallines = purchasetotallines;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].ispaid = ispaid;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].salestotalpaid = salestotalpaid;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].purchasetotalpaid = purchasetotalpaid;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].salesoutstandingamt = salesoutstandingamt;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].purchaseoutstandingamt = purchaseoutstandingamt;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].linenetamt = linenetamt;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].linegrossamt = linegrossamt;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].mProductId = mProductId;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].mProductIdr = mProductIdr;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].qtyinvoiced = qtyinvoiced;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].description = description;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].cInvoiceId = cInvoiceId;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].cInvoiceIdr = "";
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].mPricelistId = mPricelistId;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].mPricelistIdr = "";
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].adClientId = adClientId;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].adOrgId = adOrgId;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].adOrgIdr = "";
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].isactive = isactive;
    objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0].language = "";
    return objectInvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef4B6F17A5FB3949F7A37E60CFD4686908_0(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDef3C8E791A01734B7488F1CBD3435E1CED_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef52DF8262DD11461AA80A8AEA3B504B63_2(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDef12BEF6D30CED485AB3FDAB1068B705F4_3(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_project_invoice_overview.C_Project_ID AS NAME" +
      "        FROM c_project_invoice_overview" +
      "        WHERE c_project_invoice_overview.C_Project_Invoice_Overview_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_Project left join (select C_Project_ID, Value, Name from C_Project) table1 on (C_Project.C_Project_ID = table1.C_Project_ID) WHERE C_Project.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_Project left join (select C_Project_ID, Value, Name from C_Project) table1 on (C_Project.C_Project_ID = table1.C_Project_ID) WHERE C_Project.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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
      "        UPDATE c_project_invoice_overview" +
      "        SET C_Project_ID = (?) , C_Project_Invoice_Overview_ID = (?) , C_Projecttask_ID = (?) , C_Doctype_ID = (?) , Issotrx = (?) , C_Bpartner_ID = (?) , C_Bpartner_Location_ID = (?) , Salestotallines = TO_NUMBER(?) , Purchasetotallines = TO_NUMBER(?) , Ispaid = (?) , Salestotalpaid = TO_NUMBER(?) , Purchasetotalpaid = TO_NUMBER(?) , Salesoutstandingamt = TO_NUMBER(?) , Purchaseoutstandingamt = TO_NUMBER(?) , Linenetamt = TO_NUMBER(?) , Linegrossamt = TO_NUMBER(?) , M_Product_ID = (?) , Qtyinvoiced = TO_NUMBER(?) , Description = (?) , C_Invoice_ID = (?) , M_Pricelist_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE c_project_invoice_overview.C_Project_Invoice_Overview_ID = ? " +
      "                 AND c_project_invoice_overview.C_Project_ID = ? " +
      "        AND c_project_invoice_overview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_project_invoice_overview.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectInvoiceOverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salestotallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, purchasetotallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salestotalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, purchasetotalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesoutstandingamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, purchaseoutstandingamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linegrossamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectInvoiceOverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
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
      "        INSERT INTO c_project_invoice_overview " +
      "        (C_Project_ID, C_Project_Invoice_Overview_ID, C_Projecttask_ID, C_Doctype_ID, Issotrx, C_Bpartner_ID, C_Bpartner_Location_ID, Salestotallines, Purchasetotallines, Ispaid, Salestotalpaid, Purchasetotalpaid, Salesoutstandingamt, Purchaseoutstandingamt, Linenetamt, Linegrossamt, M_Product_ID, Qtyinvoiced, Description, C_Invoice_ID, M_Pricelist_ID, AD_Client_ID, AD_Org_ID, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectInvoiceOverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salestotallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, purchasetotallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salestotalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, purchasetotalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesoutstandingamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, purchaseoutstandingamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linegrossamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cProjectId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_project_invoice_overview" +
      "        WHERE c_project_invoice_overview.C_Project_Invoice_Overview_ID = ? " +
      "                 AND c_project_invoice_overview.C_Project_ID = ? " +
      "        AND c_project_invoice_overview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_project_invoice_overview.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_project_invoice_overview" +
      "        WHERE c_project_invoice_overview.C_Project_Invoice_Overview_ID = ? " +
      "                 AND c_project_invoice_overview.C_Project_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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
      "          FROM c_project_invoice_overview" +
      "         WHERE c_project_invoice_overview.C_Project_Invoice_Overview_ID = ? ";

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
      "          FROM c_project_invoice_overview" +
      "         WHERE c_project_invoice_overview.C_Project_Invoice_Overview_ID = ? ";

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
