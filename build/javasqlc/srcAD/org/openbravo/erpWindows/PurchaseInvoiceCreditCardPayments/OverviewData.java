//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.PurchaseInvoiceCreditCardPayments;

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
class OverviewData implements FieldProvider {
static Logger log4j = Logger.getLogger(OverviewData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String invoicedocumentno;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String mPricelistId;
  public String mPricelistIdr;
  public String isgrossinvoice;
  public String isactive;
  public String cInvoiceCreditcardVId;
  public String cInvoiceCreditcardVIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String adUserId;
  public String adUserIdr;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String dateacct;
  public String description;
  public String internalnote;
  public String grandtotal;
  public String docstatus;
  public String docstatusr;
  public String lineisactive;
  public String lineaduser;
  public String lineaduserr;
  public String cInvoicelineCreditcardVId;
  public String cInvoicelineCreditcardVIdr;
  public String line;
  public String hasvoucher;
  public String cInvoiceCreditcardLineVId;
  public String voucherdate;
  public String mProductId;
  public String mProductIdr;
  public String adClientId;
  public String cTaxId;
  public String cTaxIdr;
  public String adOrgId;
  public String linedescription;
  public String priceactual;
  public String aAssetId;
  public String aAssetIdr;
  public String cProjectId;
  public String cProjectIdr;
  public String cOrderlineId;
  public String cOrderlineIdr;
  public String cCashlineId;
  public String cCashlineIdr;
  public String issotrx;
  public String linegrossamt;
  public String docaction;
  public String cBpartnerLocationId;
  public String paymentrule;
  public String cPaymenttermId;
  public String totallines;
  public String linecreated;
  public String linecreatedby;
  public String lineupdated;
  public String lineupdatedby;
  public String qtyinvoiced;
  public String linenetamt;
  public String cUomId;
  public String processed;
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
    else if (fieldName.equalsIgnoreCase("invoicedocumentno"))
      return invoicedocumentno;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_idr") || fieldName.equals("mPricelistIdr"))
      return mPricelistIdr;
    else if (fieldName.equalsIgnoreCase("isgrossinvoice"))
      return isgrossinvoice;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_invoice_creditcard_v_id") || fieldName.equals("cInvoiceCreditcardVId"))
      return cInvoiceCreditcardVId;
    else if (fieldName.equalsIgnoreCase("c_invoice_creditcard_v_idr") || fieldName.equals("cInvoiceCreditcardVIdr"))
      return cInvoiceCreditcardVIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("internalnote"))
      return internalnote;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("lineisactive"))
      return lineisactive;
    else if (fieldName.equalsIgnoreCase("lineaduser"))
      return lineaduser;
    else if (fieldName.equalsIgnoreCase("lineaduserr"))
      return lineaduserr;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_creditcard_v_id") || fieldName.equals("cInvoicelineCreditcardVId"))
      return cInvoicelineCreditcardVId;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_creditcard_v_idr") || fieldName.equals("cInvoicelineCreditcardVIdr"))
      return cInvoicelineCreditcardVIdr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("hasvoucher"))
      return hasvoucher;
    else if (fieldName.equalsIgnoreCase("c_invoice_creditcard_line_v_id") || fieldName.equals("cInvoiceCreditcardLineVId"))
      return cInvoiceCreditcardLineVId;
    else if (fieldName.equalsIgnoreCase("voucherdate"))
      return voucherdate;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("c_tax_idr") || fieldName.equals("cTaxIdr"))
      return cTaxIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("linedescription"))
      return linedescription;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("c_orderline_idr") || fieldName.equals("cOrderlineIdr"))
      return cOrderlineIdr;
    else if (fieldName.equalsIgnoreCase("c_cashline_id") || fieldName.equals("cCashlineId"))
      return cCashlineId;
    else if (fieldName.equalsIgnoreCase("c_cashline_idr") || fieldName.equals("cCashlineIdr"))
      return cCashlineIdr;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("linegrossamt"))
      return linegrossamt;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("totallines"))
      return totallines;
    else if (fieldName.equalsIgnoreCase("linecreated"))
      return linecreated;
    else if (fieldName.equalsIgnoreCase("linecreatedby"))
      return linecreatedby;
    else if (fieldName.equalsIgnoreCase("lineupdated"))
      return lineupdated;
    else if (fieldName.equalsIgnoreCase("lineupdatedby"))
      return lineupdatedby;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
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
  public static OverviewData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static OverviewData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Invoice_Creditcard_Line_V.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Invoice_Creditcard_Line_V.CreatedBy) as CreatedByR, " +
      "        to_char(C_Invoice_Creditcard_Line_V.Updated, ?) as updated, " +
      "        to_char(C_Invoice_Creditcard_Line_V.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Invoice_Creditcard_Line_V.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Invoice_Creditcard_Line_V.UpdatedBy) as UpdatedByR," +
      "        C_Invoice_Creditcard_Line_V.InvoiceDocumentNo, " +
      "C_Invoice_Creditcard_Line_V.C_Doctype_ID, " +
      "(CASE WHEN C_Invoice_Creditcard_Line_V.C_Doctype_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS C_Doctype_IDR, " +
      "C_Invoice_Creditcard_Line_V.M_Pricelist_ID, " +
      "(CASE WHEN C_Invoice_Creditcard_Line_V.M_Pricelist_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS M_Pricelist_IDR, " +
      "COALESCE(C_Invoice_Creditcard_Line_V.IsGrossInvoice, 'N') AS IsGrossInvoice, " +
      "COALESCE(C_Invoice_Creditcard_Line_V.IsActive, 'N') AS IsActive, " +
      "C_Invoice_Creditcard_Line_V.C_Invoice_Creditcard_V_ID, " +
      "(CASE WHEN C_Invoice_Creditcard_Line_V.C_Invoice_Creditcard_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.DateInvoiced, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.GrandTotal), ''))),'') ) END) AS C_Invoice_Creditcard_V_IDR, " +
      "C_Invoice_Creditcard_Line_V.C_BPartner_ID, " +
      "(CASE WHEN C_Invoice_Creditcard_Line_V.C_BPartner_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "C_Invoice_Creditcard_Line_V.AD_User_ID, " +
      "(CASE WHEN C_Invoice_Creditcard_Line_V.AD_User_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "C_Invoice_Creditcard_Line_V.C_Currency_ID, " +
      "(CASE WHEN C_Invoice_Creditcard_Line_V.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "C_Invoice_Creditcard_Line_V.DateAcct, " +
      "C_Invoice_Creditcard_Line_V.Description, " +
      "C_Invoice_Creditcard_Line_V.InternalNote, " +
      "C_Invoice_Creditcard_Line_V.GrandTotal, " +
      "C_Invoice_Creditcard_Line_V.DocStatus, " +
      "(CASE WHEN C_Invoice_Creditcard_Line_V.DocStatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DocStatusR, " +
      "COALESCE(C_Invoice_Creditcard_Line_V.LineIsActive, 'N') AS LineIsActive, " +
      "C_Invoice_Creditcard_Line_V.LineAdUser, " +
      "(CASE WHEN C_Invoice_Creditcard_Line_V.LineAdUser IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS LineAdUserR, " +
      "C_Invoice_Creditcard_Line_V.C_Invoiceline_Creditcard_V_ID, " +
      "(CASE WHEN C_Invoice_Creditcard_Line_V.C_Invoiceline_Creditcard_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table9.DateInvoiced, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.GrandTotal), ''))),'') ) END) AS C_Invoiceline_Creditcard_V_IDR, " +
      "C_Invoice_Creditcard_Line_V.Line, " +
      "COALESCE(C_Invoice_Creditcard_Line_V.HasVoucher, 'N') AS HasVoucher, " +
      "C_Invoice_Creditcard_Line_V.C_Invoice_Creditcard_Line_V_ID, " +
      "C_Invoice_Creditcard_Line_V.VoucherDate, " +
      "C_Invoice_Creditcard_Line_V.M_Product_ID, " +
      "(CASE WHEN C_Invoice_Creditcard_Line_V.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL10.Name IS NULL THEN TO_CHAR(table10.Name) ELSE TO_CHAR(tableTRL10.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "C_Invoice_Creditcard_Line_V.AD_Client_ID, " +
      "C_Invoice_Creditcard_Line_V.C_Tax_ID, " +
      "(CASE WHEN C_Invoice_Creditcard_Line_V.C_Tax_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL11.Name IS NULL THEN TO_CHAR(table11.Name) ELSE TO_CHAR(tableTRL11.Name) END)), ''))),'') ) END) AS C_Tax_IDR, " +
      "C_Invoice_Creditcard_Line_V.AD_Org_ID, " +
      "C_Invoice_Creditcard_Line_V.LineDescription, " +
      "C_Invoice_Creditcard_Line_V.PriceActual, " +
      "C_Invoice_Creditcard_Line_V.A_Asset_ID, " +
      "(CASE WHEN C_Invoice_Creditcard_Line_V.A_Asset_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "C_Invoice_Creditcard_Line_V.C_Project_ID, " +
      "(CASE WHEN C_Invoice_Creditcard_Line_V.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "C_Invoice_Creditcard_Line_V.C_Orderline_ID, " +
      "(CASE WHEN C_Invoice_Creditcard_Line_V.C_Orderline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table15.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.GrandTotal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.LineNetAmt), ''))),'') ) END) AS C_Orderline_IDR, " +
      "C_Invoice_Creditcard_Line_V.C_Cashline_ID, " +
      "(CASE WHEN C_Invoice_Creditcard_Line_V.C_Cashline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Amount), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Description), ''))),'') ) END) AS C_Cashline_IDR, " +
      "COALESCE(C_Invoice_Creditcard_Line_V.IsSOTrx, 'N') AS IsSOTrx, " +
      "C_Invoice_Creditcard_Line_V.LineGrossAmt, " +
      "C_Invoice_Creditcard_Line_V.DocAction, " +
      "C_Invoice_Creditcard_Line_V.C_Bpartner_Location_ID, " +
      "C_Invoice_Creditcard_Line_V.PaymentRule, " +
      "C_Invoice_Creditcard_Line_V.C_PaymentTerm_ID, " +
      "C_Invoice_Creditcard_Line_V.TotalLines, " +
      "C_Invoice_Creditcard_Line_V.LineCreated, " +
      "C_Invoice_Creditcard_Line_V.LineCreatedBy, " +
      "C_Invoice_Creditcard_Line_V.LineUpdated, " +
      "C_Invoice_Creditcard_Line_V.LineUpdatedBy, " +
      "C_Invoice_Creditcard_Line_V.QtyInvoiced, " +
      "C_Invoice_Creditcard_Line_V.LineNetAmt, " +
      "C_Invoice_Creditcard_Line_V.C_Uom_ID, " +
      "COALESCE(C_Invoice_Creditcard_Line_V.Processed, 'N') AS Processed, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Invoice_Creditcard_Line_V left join (select C_Doctype_ID, Name from C_Doctype) table1 on (C_Invoice_Creditcard_Line_V.C_Doctype_ID = table1.C_Doctype_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL1 on (table1.C_DocType_ID = tableTRL1.C_DocType_ID and tableTRL1.AD_Language = ?)  left join (select M_Pricelist_ID, Name from M_Pricelist) table2 on (C_Invoice_Creditcard_Line_V.M_Pricelist_ID = table2.M_Pricelist_ID) left join (select C_Invoice_Creditcard_V_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice_Creditcard_V) table3 on (C_Invoice_Creditcard_Line_V.C_Invoice_Creditcard_V_ID = table3.C_Invoice_Creditcard_V_ID) left join (select C_BPartner_ID, value, Name from C_BPartner) table4 on (C_Invoice_Creditcard_Line_V.C_BPartner_ID =  table4.C_BPartner_ID) left join (select AD_User_ID, Name from AD_User) table5 on (C_Invoice_Creditcard_Line_V.AD_User_ID =  table5.AD_User_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table6 on (C_Invoice_Creditcard_Line_V.C_Currency_ID = table6.C_Currency_ID) left join ad_ref_list_v list1 on (C_Invoice_Creditcard_Line_V.DocStatus = list1.value and list1.ad_reference_id = '131' and list1.ad_language = ?)  left join (select AD_User_ID, Name from AD_User) table7 on (C_Invoice_Creditcard_Line_V.LineAdUser =  table7.AD_User_ID) left join (select C_Invoiceline_Creditcard_V_ID, Line, C_Invoice_Creditcard_V_ID from C_Invoiceline_Creditcard_V) table8 on (C_Invoice_Creditcard_Line_V.C_Invoiceline_Creditcard_V_ID = table8.C_Invoiceline_Creditcard_V_ID) left join (select C_Invoice_Creditcard_V_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice_Creditcard_V) table9 on (table8.C_Invoice_Creditcard_V_ID = table9.C_Invoice_Creditcard_V_ID) left join (select M_Product_ID, Value, Name from M_Product) table10 on (C_Invoice_Creditcard_Line_V.M_Product_ID = table10.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL10 on (table10.M_Product_ID = tableTRL10.M_Product_ID and tableTRL10.AD_Language = ?)  left join (select C_Tax_ID, Name from C_Tax) table11 on (C_Invoice_Creditcard_Line_V.C_Tax_ID = table11.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL11 on (table11.C_Tax_ID = tableTRL11.C_Tax_ID and tableTRL11.AD_Language = ?)  left join (select A_Asset_ID, Name from A_Asset) table12 on (C_Invoice_Creditcard_Line_V.A_Asset_ID = table12.A_Asset_ID) left join (select C_Project_ID, Value, Name from C_Project) table13 on (C_Invoice_Creditcard_Line_V.C_Project_ID = table13.C_Project_ID) left join (select C_Orderline_ID, C_Order_ID, Line, LineNetAmt from C_Orderline) table14 on (C_Invoice_Creditcard_Line_V.C_Orderline_ID = table14.C_Orderline_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table15 on (table14.C_Order_ID = table15.C_Order_ID) left join (select C_Cashline_ID, C_Cash_ID, Line, Amount, Description from C_Cashline) table16 on (C_Invoice_Creditcard_Line_V.C_Cashline_ID = table16.C_Cashline_ID) left join (select C_Cash_ID, Name from C_Cash) table17 on (table16.C_Cash_ID = table17.C_Cash_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_Invoice_Creditcard_Line_V.C_Invoice_Creditcard_Line_V_ID = ? " +
      "        AND C_Invoice_Creditcard_Line_V.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Invoice_Creditcard_Line_V.AD_Org_ID IN (";
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
        OverviewData objectOverviewData = new OverviewData();
        objectOverviewData.created = UtilSql.getValue(result, "created");
        objectOverviewData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectOverviewData.updated = UtilSql.getValue(result, "updated");
        objectOverviewData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectOverviewData.updatedby = UtilSql.getValue(result, "updatedby");
        objectOverviewData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectOverviewData.invoicedocumentno = UtilSql.getValue(result, "invoicedocumentno");
        objectOverviewData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectOverviewData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectOverviewData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectOverviewData.mPricelistIdr = UtilSql.getValue(result, "m_pricelist_idr");
        objectOverviewData.isgrossinvoice = UtilSql.getValue(result, "isgrossinvoice");
        objectOverviewData.isactive = UtilSql.getValue(result, "isactive");
        objectOverviewData.cInvoiceCreditcardVId = UtilSql.getValue(result, "c_invoice_creditcard_v_id");
        objectOverviewData.cInvoiceCreditcardVIdr = UtilSql.getValue(result, "c_invoice_creditcard_v_idr");
        objectOverviewData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectOverviewData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectOverviewData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectOverviewData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectOverviewData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectOverviewData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectOverviewData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectOverviewData.description = UtilSql.getValue(result, "description");
        objectOverviewData.internalnote = UtilSql.getValue(result, "internalnote");
        objectOverviewData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectOverviewData.docstatus = UtilSql.getValue(result, "docstatus");
        objectOverviewData.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectOverviewData.lineisactive = UtilSql.getValue(result, "lineisactive");
        objectOverviewData.lineaduser = UtilSql.getValue(result, "lineaduser");
        objectOverviewData.lineaduserr = UtilSql.getValue(result, "lineaduserr");
        objectOverviewData.cInvoicelineCreditcardVId = UtilSql.getValue(result, "c_invoiceline_creditcard_v_id");
        objectOverviewData.cInvoicelineCreditcardVIdr = UtilSql.getValue(result, "c_invoiceline_creditcard_v_idr");
        objectOverviewData.line = UtilSql.getValue(result, "line");
        objectOverviewData.hasvoucher = UtilSql.getValue(result, "hasvoucher");
        objectOverviewData.cInvoiceCreditcardLineVId = UtilSql.getValue(result, "c_invoice_creditcard_line_v_id");
        objectOverviewData.voucherdate = UtilSql.getDateValue(result, "voucherdate", "dd-MM-yyyy");
        objectOverviewData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectOverviewData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectOverviewData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectOverviewData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectOverviewData.cTaxIdr = UtilSql.getValue(result, "c_tax_idr");
        objectOverviewData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectOverviewData.linedescription = UtilSql.getValue(result, "linedescription");
        objectOverviewData.priceactual = UtilSql.getValue(result, "priceactual");
        objectOverviewData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectOverviewData.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectOverviewData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectOverviewData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectOverviewData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectOverviewData.cOrderlineIdr = UtilSql.getValue(result, "c_orderline_idr");
        objectOverviewData.cCashlineId = UtilSql.getValue(result, "c_cashline_id");
        objectOverviewData.cCashlineIdr = UtilSql.getValue(result, "c_cashline_idr");
        objectOverviewData.issotrx = UtilSql.getValue(result, "issotrx");
        objectOverviewData.linegrossamt = UtilSql.getValue(result, "linegrossamt");
        objectOverviewData.docaction = UtilSql.getValue(result, "docaction");
        objectOverviewData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectOverviewData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectOverviewData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectOverviewData.totallines = UtilSql.getValue(result, "totallines");
        objectOverviewData.linecreated = UtilSql.getDateValue(result, "linecreated", "dd-MM-yyyy");
        objectOverviewData.linecreatedby = UtilSql.getValue(result, "linecreatedby");
        objectOverviewData.lineupdated = UtilSql.getDateValue(result, "lineupdated", "dd-MM-yyyy");
        objectOverviewData.lineupdatedby = UtilSql.getValue(result, "lineupdatedby");
        objectOverviewData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectOverviewData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectOverviewData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectOverviewData.processed = UtilSql.getValue(result, "processed");
        objectOverviewData.language = UtilSql.getValue(result, "language");
        objectOverviewData.adUserClient = "";
        objectOverviewData.adOrgClient = "";
        objectOverviewData.createdby = "";
        objectOverviewData.trBgcolor = "";
        objectOverviewData.totalCount = "";
        objectOverviewData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOverviewData);
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
    OverviewData objectOverviewData[] = new OverviewData[vector.size()];
    vector.copyInto(objectOverviewData);
    return(objectOverviewData);
  }

/**
Create a registry
 */
  public static OverviewData[] set(String cBpartnerId, String totallines, String processed, String docaction, String mProductId, String cUomId, String aAssetId, String internalnote, String mPricelistId, String priceactual, String cOrderlineId, String isactive, String cBpartnerLocationId, String cInvoiceCreditcardLineVId, String hasvoucher, String qtyinvoiced, String cDoctypeId, String lineaduser, String updatedby, String updatedbyr, String cTaxId, String linegrossamt, String lineupdatedby, String adUserId, String adOrgId, String dateacct, String cProjectId, String lineupdated, String linecreated, String description, String linedescription, String isgrossinvoice, String voucherdate, String grandtotal, String docstatus, String lineisactive, String cInvoiceCreditcardVId, String line, String linenetamt, String issotrx, String cInvoicelineCreditcardVId, String cCashlineId, String cPaymenttermId, String createdby, String createdbyr, String adClientId, String paymentrule, String linecreatedby, String invoicedocumentno, String cCurrencyId)    throws ServletException {
    OverviewData objectOverviewData[] = new OverviewData[1];
    objectOverviewData[0] = new OverviewData();
    objectOverviewData[0].created = "";
    objectOverviewData[0].createdbyr = createdbyr;
    objectOverviewData[0].updated = "";
    objectOverviewData[0].updatedTimeStamp = "";
    objectOverviewData[0].updatedby = updatedby;
    objectOverviewData[0].updatedbyr = updatedbyr;
    objectOverviewData[0].invoicedocumentno = invoicedocumentno;
    objectOverviewData[0].cDoctypeId = cDoctypeId;
    objectOverviewData[0].cDoctypeIdr = "";
    objectOverviewData[0].mPricelistId = mPricelistId;
    objectOverviewData[0].mPricelistIdr = "";
    objectOverviewData[0].isgrossinvoice = isgrossinvoice;
    objectOverviewData[0].isactive = isactive;
    objectOverviewData[0].cInvoiceCreditcardVId = cInvoiceCreditcardVId;
    objectOverviewData[0].cInvoiceCreditcardVIdr = "";
    objectOverviewData[0].cBpartnerId = cBpartnerId;
    objectOverviewData[0].cBpartnerIdr = "";
    objectOverviewData[0].adUserId = adUserId;
    objectOverviewData[0].adUserIdr = "";
    objectOverviewData[0].cCurrencyId = cCurrencyId;
    objectOverviewData[0].cCurrencyIdr = "";
    objectOverviewData[0].dateacct = dateacct;
    objectOverviewData[0].description = description;
    objectOverviewData[0].internalnote = internalnote;
    objectOverviewData[0].grandtotal = grandtotal;
    objectOverviewData[0].docstatus = docstatus;
    objectOverviewData[0].docstatusr = "";
    objectOverviewData[0].lineisactive = lineisactive;
    objectOverviewData[0].lineaduser = lineaduser;
    objectOverviewData[0].lineaduserr = "";
    objectOverviewData[0].cInvoicelineCreditcardVId = cInvoicelineCreditcardVId;
    objectOverviewData[0].cInvoicelineCreditcardVIdr = "";
    objectOverviewData[0].line = line;
    objectOverviewData[0].hasvoucher = hasvoucher;
    objectOverviewData[0].cInvoiceCreditcardLineVId = cInvoiceCreditcardLineVId;
    objectOverviewData[0].voucherdate = voucherdate;
    objectOverviewData[0].mProductId = mProductId;
    objectOverviewData[0].mProductIdr = "";
    objectOverviewData[0].adClientId = adClientId;
    objectOverviewData[0].cTaxId = cTaxId;
    objectOverviewData[0].cTaxIdr = "";
    objectOverviewData[0].adOrgId = adOrgId;
    objectOverviewData[0].linedescription = linedescription;
    objectOverviewData[0].priceactual = priceactual;
    objectOverviewData[0].aAssetId = aAssetId;
    objectOverviewData[0].aAssetIdr = "";
    objectOverviewData[0].cProjectId = cProjectId;
    objectOverviewData[0].cProjectIdr = "";
    objectOverviewData[0].cOrderlineId = cOrderlineId;
    objectOverviewData[0].cOrderlineIdr = "";
    objectOverviewData[0].cCashlineId = cCashlineId;
    objectOverviewData[0].cCashlineIdr = "";
    objectOverviewData[0].issotrx = issotrx;
    objectOverviewData[0].linegrossamt = linegrossamt;
    objectOverviewData[0].docaction = docaction;
    objectOverviewData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectOverviewData[0].paymentrule = paymentrule;
    objectOverviewData[0].cPaymenttermId = cPaymenttermId;
    objectOverviewData[0].totallines = totallines;
    objectOverviewData[0].linecreated = linecreated;
    objectOverviewData[0].linecreatedby = linecreatedby;
    objectOverviewData[0].lineupdated = lineupdated;
    objectOverviewData[0].lineupdatedby = lineupdatedby;
    objectOverviewData[0].qtyinvoiced = qtyinvoiced;
    objectOverviewData[0].linenetamt = linenetamt;
    objectOverviewData[0].cUomId = cUomId;
    objectOverviewData[0].processed = processed;
    objectOverviewData[0].language = "";
    return objectOverviewData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef84FF2259D5C64940A764744DB5207547_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef8ED8A2136BDB4786B490496683BA9F4C_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_Invoice_Creditcard_Line_V" +
      "        SET InvoiceDocumentNo = (?) , C_Doctype_ID = (?) , M_Pricelist_ID = (?) , IsGrossInvoice = (?) , IsActive = (?) , C_Invoice_Creditcard_V_ID = (?) , C_BPartner_ID = (?) , AD_User_ID = (?) , C_Currency_ID = (?) , DateAcct = TO_DATE(?) , Description = (?) , InternalNote = (?) , GrandTotal = TO_NUMBER(?) , DocStatus = (?) , LineIsActive = (?) , LineAdUser = (?) , C_Invoiceline_Creditcard_V_ID = (?) , Line = TO_NUMBER(?) , HasVoucher = (?) , C_Invoice_Creditcard_Line_V_ID = (?) , VoucherDate = TO_DATE(?) , M_Product_ID = (?) , AD_Client_ID = (?) , C_Tax_ID = (?) , AD_Org_ID = (?) , LineDescription = (?) , PriceActual = TO_NUMBER(?) , A_Asset_ID = (?) , C_Project_ID = (?) , C_Orderline_ID = (?) , C_Cashline_ID = (?) , IsSOTrx = (?) , LineGrossAmt = TO_NUMBER(?) , DocAction = (?) , C_Bpartner_Location_ID = (?) , PaymentRule = (?) , C_PaymentTerm_ID = (?) , TotalLines = TO_NUMBER(?) , LineCreated = TO_DATE(?) , LineCreatedBy = (?) , LineUpdated = TO_DATE(?) , LineUpdatedBy = (?) , QtyInvoiced = TO_NUMBER(?) , LineNetAmt = TO_NUMBER(?) , C_Uom_ID = (?) , Processed = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Invoice_Creditcard_Line_V.C_Invoice_Creditcard_Line_V_ID = ? " +
      "        AND C_Invoice_Creditcard_Line_V.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Invoice_Creditcard_Line_V.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedocumentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isgrossinvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceCreditcardVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, internalnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lineisactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lineaduser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineCreditcardVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hasvoucher);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceCreditcardLineVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, voucherdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linedescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCashlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linegrossamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linecreated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linecreatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lineupdated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lineupdatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceCreditcardLineVId);
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
      "        INSERT INTO C_Invoice_Creditcard_Line_V " +
      "        (InvoiceDocumentNo, C_Doctype_ID, M_Pricelist_ID, IsGrossInvoice, IsActive, C_Invoice_Creditcard_V_ID, C_BPartner_ID, AD_User_ID, C_Currency_ID, DateAcct, Description, InternalNote, GrandTotal, DocStatus, LineIsActive, LineAdUser, C_Invoiceline_Creditcard_V_ID, Line, HasVoucher, C_Invoice_Creditcard_Line_V_ID, VoucherDate, M_Product_ID, AD_Client_ID, C_Tax_ID, AD_Org_ID, LineDescription, PriceActual, A_Asset_ID, C_Project_ID, C_Orderline_ID, C_Cashline_ID, IsSOTrx, LineGrossAmt, DocAction, C_Bpartner_Location_ID, PaymentRule, C_PaymentTerm_ID, TotalLines, LineCreated, LineCreatedBy, LineUpdated, LineUpdatedBy, QtyInvoiced, LineNetAmt, C_Uom_ID, Processed, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), TO_DATE(?), (?), TO_DATE(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedocumentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isgrossinvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceCreditcardVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, internalnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lineisactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lineaduser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineCreditcardVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hasvoucher);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceCreditcardLineVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, voucherdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linedescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCashlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linegrossamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linecreated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linecreatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lineupdated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lineupdatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
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
      "        DELETE FROM C_Invoice_Creditcard_Line_V" +
      "        WHERE C_Invoice_Creditcard_Line_V.C_Invoice_Creditcard_Line_V_ID = ? " +
      "        AND C_Invoice_Creditcard_Line_V.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Invoice_Creditcard_Line_V.AD_Org_ID IN (";
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
      "        DELETE FROM C_Invoice_Creditcard_Line_V" +
      "        WHERE C_Invoice_Creditcard_Line_V.C_Invoice_Creditcard_Line_V_ID = ? ";

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
      "          FROM C_Invoice_Creditcard_Line_V" +
      "         WHERE C_Invoice_Creditcard_Line_V.C_Invoice_Creditcard_Line_V_ID = ? ";

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
      "          FROM C_Invoice_Creditcard_Line_V" +
      "         WHERE C_Invoice_Creditcard_Line_V.C_Invoice_Creditcard_Line_V_ID = ? ";

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
